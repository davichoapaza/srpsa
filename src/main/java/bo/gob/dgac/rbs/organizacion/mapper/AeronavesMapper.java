package bo.gob.dgac.rbs.organizacion.mapper;

import org.mapstruct.Mapper;
import bo.gob.dgac.rbs.organizacion.dto.AeronaveDTO;
import bo.gob.dgac.rbs.organizacion.modelo.Aeronaves;
@Mapper(componentModel = "spring")
public interface AeronavesMapper {
	
	Aeronaves toEntity(AeronaveDTO dto);
	
	AeronaveDTO toDto(Aeronaves entity);
	
	

}
