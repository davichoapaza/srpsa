package bo.gob.dgac.rbs.organizacion.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import bo.gob.dgac.rbs.organizacion.dto.TipoOperacionItemDto;
import bo.gob.dgac.rbs.organizacion.modelo.TipoOperacion;


@Mapper(componentModel = "spring")
public interface TipoOperacionMapper {

	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "organizacion", ignore = true) // se setea en @AfterMapping
	@Mapping(target = "tipoOperacionId", source = "tipoOperacionId")
	@Mapping(target = "descripcion", source = "descripcion")
      TipoOperacion toEntity(TipoOperacionItemDto dto);
    
	TipoOperacionItemDto toDto(TipoOperacion entity);
	
	


	

	
}


