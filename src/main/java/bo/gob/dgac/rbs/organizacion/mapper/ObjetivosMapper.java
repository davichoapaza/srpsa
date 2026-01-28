package bo.gob.dgac.rbs.organizacion.mapper;

import org.mapstruct.Mapper;

import bo.gob.dgac.rbs.organizacion.dto.ObjetivosDto;
import bo.gob.dgac.rbs.organizacion.modelo.Objetivos;






@Mapper(componentModel = "spring")
public interface ObjetivosMapper {
	/*@Mapping(source = "organizacion.id", target = "organizacionId")
    @Mapping(source = "departamento.id", target = "departamentoId")*/
    ObjetivosDto toDto(Objetivos entity);

}
