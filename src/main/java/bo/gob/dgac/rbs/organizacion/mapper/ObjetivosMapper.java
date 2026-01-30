package bo.gob.dgac.rbs.organizacion.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import bo.gob.dgac.rbs.organizacion.dto.ObjetivosDto;
import bo.gob.dgac.rbs.organizacion.modelo.Metas;
import bo.gob.dgac.rbs.organizacion.modelo.Objetivos;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;

@Mapper(componentModel = "spring")
public interface ObjetivosMapper {
	
	// @Mapping(source = "organizacion.id", target = "organizacionId")
	ObjetivosDto toDto(Objetivos entity);
	
	
	
//	@Mapping(target = "organizacion", source = "organizacionId", qualifiedByName = "mapOrganizacion")
	Objetivos toEntity(ObjetivosDto dto);
	
	
	@AfterMapping
	default void metas(@MappingTarget Objetivos obj) {
		if(obj.getMetas()!=null) {
			for(Metas m: obj.getMetas()) {
			    m.setObjetivos(obj);
			}
		}
			
		
	}
    
	
	
	 @Named("mapOrganizacion")
	    default Organizacion mapOrganizacion(Long id) {
	        if (id == null) return null;
	        Organizacion o = new Organizacion();
	        o.setId(id);
	        return o;
	 }
}
