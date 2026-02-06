package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.dto.UbicacionDTO;
import bo.gob.dgac.rbs.organizacion.dto.UbicacionRequestDto;
import bo.gob.dgac.rbs.organizacion.mapper.UbicacionMapper;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.modelo.Ubicacion;
import bo.gob.dgac.rbs.organizacion.repository.UbicacionRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UbicacionService {

    private final UbicacionRepository repository;
    private final UbicacionMapper mapper;
    
    public List<UbicacionDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    
    public UbicacionDTO obtenerPorId(Long id) {
        Ubicacion u = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ubicación no encontrada"));
        return mapper.toDto(u);
    }

    public UbicacionDTO guardar(UbicacionDTO dto) {
        return mapper.toDto(
                repository.save(mapper.toEntity(dto))
        );
    }
    
    public UbicacionRequestDto guardar(UbicacionRequestDto dto) {
    	Organizacion org=new Organizacion();
    	org.setId(dto.organizacionId);
    	for(UbicacionDTO ubic:dto.ubicacion) {
    		Ubicacion entity= mapper.toEntity(ubic);
    		entity.setOrganizacion(org);
    		repository.save(entity);
    	}
    	return null;
    	
    	
    }

    
    public UbicacionDTO actualizar(Long id, UbicacionDTO dto) {
        Ubicacion entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
