package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.dto.PersonaCargoResponseDTO;
import bo.gob.dgac.rbs.organizacion.repository.OrganizacionCargoPersonaRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class OrganizacionCargoPersonaService {

	 private final OrganizacionCargoPersonaRepository service;
	 
	 public List<PersonaCargoResponseDTO> listarPersonasOrganizacion(Long org){
		 return service.listarPersonasOrganizacion(org);
	 }
	      
	 
	 
	 
}
