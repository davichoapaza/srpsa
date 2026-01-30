package bo.gob.dgac.rbs.organizacion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import bo.gob.dgac.rbs.organizacion.dto.MetasDTO;
import bo.gob.dgac.rbs.organizacion.modelo.Metas;

@Mapper(componentModel = "spring")
public interface MetasMapper {

	MetasDTO toDto(Metas entity);
	
	Metas toEntity(MetasDTO dto);
	
	
	
	
	
}
