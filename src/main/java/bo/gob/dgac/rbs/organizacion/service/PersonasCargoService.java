package bo.gob.dgac.rbs.organizacion.service;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.dto.PersonaCargoDto;
import bo.gob.dgac.rbs.organizacion.dto.PersonalCargoRequestDto;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.modelo.OrganizacionCargoPersona;
import bo.gob.dgac.rbs.organizacion.modelo.ParamCargo;
import bo.gob.dgac.rbs.organizacion.modelo.Persona;
import bo.gob.dgac.rbs.organizacion.repository.OrganizacionCargoPersonaRepository;
import bo.gob.dgac.rbs.organizacion.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonasCargoService {
	
    private final PersonaRepository personaService;
     private final OrganizacionCargoPersonaRepository ocpService;
//    @Transactional
    public Persona guardarOrganizacionCargoPersona(PersonalCargoRequestDto pcrd) {
        Organizacion org= new Organizacion();
        org.setId(pcrd.organizacionId);
        Persona personaGuardada=null;
        for(PersonaCargoDto persona: pcrd.personaCargo) {
          Persona p = new  Persona();
          p.setNombres(persona.getNombres());
          p.setPrimerApellido(persona.getPrimerApellido());
          p.setSegundoApellido(persona.getSegundoApellido());
          p.setCedulaIdentidad(persona.getCedulaIdentidad());
          p.setTelefono(persona.getTelefono());
          p.setCorreo(persona.getCorreo());
          p.setNumeroLicencia(persona.numeroLicencia);
          personaGuardada= personaService.save(p);
        
          OrganizacionCargoPersona ocp= new OrganizacionCargoPersona();
          ocp.setOrganizacion(org);
          ParamCargo cargo= new ParamCargo();
          cargo.setId(persona.cargoId);
          ocp.setParamCargo(cargo);
          ocp.setPersonas(personaGuardada);
          ocpService.save(ocp);
        }
        return personaGuardada;
    }
    
}








