package bo.gob.dgac.rbs.organizacion.service;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.dto.AeronaveDTO;
import bo.gob.dgac.rbs.organizacion.dto.AeronavesRequestDto;
import bo.gob.dgac.rbs.organizacion.mapper.AeronaveMapper;
import bo.gob.dgac.rbs.organizacion.modelo.Aeronaves;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.repository.AeronavesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AeronavesService {
	
	private final AeronavesRepository repository;
	private final AeronaveMapper mapper;
	
	public void guardarAeronaves(AeronavesRequestDto request) {

	    Organizacion org = new Organizacion();
	    org.setId(request.organizacionId);

	    for (AeronaveDTO dto : request.aeronaves) {
	        Aeronaves entity = mapper.toEntity(dto);
	        entity.setOrganizacion(org);

	        repository.save(entity);
	    }
	}

 
  
  
  

}
