package bo.gob.dgac.rbs;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import bo.gob.dgac.rbs.organizacion.dto.PersonaCargoResponseDTO;
import bo.gob.dgac.rbs.organizacion.modelo.OrganizacionCargoPersona;
import bo.gob.dgac.rbs.organizacion.repository.OrganizacionCargoPersonaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // Si usas una DB real de pruebas
class OrganizacionCargoPersonaRepositoryTest {

    @Autowired
    private OrganizacionCargoPersonaRepository repository;
    @Test
    void debeListarPersonasYCargosPorOrganizacion() {
        List<OrganizacionCargoPersona> resultado = repository.listarPersonaYCargo(29L);
        for (OrganizacionCargoPersona p: resultado) {
        	System.out.println(p.getPersonas().getNombres());
        }
    }
    
   @Test
    void listarPersonas() {
    	
    	List<PersonaCargoResponseDTO> res = repository.listarPersonasOrganizacion(29L);
    	
    	
       for(PersonaCargoResponseDTO pc:res) {
    	   
    	   System.out.println("cargo ID"+pc.cargoId);
    	   System.out.println("DDDDDDDDDD:"+pc.nombres);
       }	
    }
}

 

