package bo.gob.dgac.rbs.organizacion.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import bo.gob.dgac.rbs.organizacion.dto.AeronaveDTO;
import bo.gob.dgac.rbs.organizacion.dto.OrganizacionCreacionDto;
import bo.gob.dgac.rbs.organizacion.dto.OrganizacionDTO;
import bo.gob.dgac.rbs.organizacion.dto.OrganizacionDetalleDTO;
import bo.gob.dgac.rbs.organizacion.dto.UbicacionCreacionDto;
import bo.gob.dgac.rbs.organizacion.modelo.Aeronaves;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.modelo.ParamClaseCertificacion;
import bo.gob.dgac.rbs.organizacion.modelo.ParamComplejidadOrganizacion;
import bo.gob.dgac.rbs.organizacion.modelo.ParamDepartamento;
import bo.gob.dgac.rbs.organizacion.modelo.ParamNacionalidad;
import bo.gob.dgac.rbs.organizacion.modelo.ParamTamanoOrganizacion;
import bo.gob.dgac.rbs.organizacion.modelo.ParamTipoOrganizacion;
import bo.gob.dgac.rbs.organizacion.modelo.Ubicacion;

@Mapper(componentModel = "spring")
public interface OrganizacionMapper {

    @Mapping(source = "tipoOrganizacion.id", target = "tipoOrganizacionId")
    @Mapping(source = "claseCertificacion.id", target = "claseCertificacionId")
    @Mapping(source = "nacionalidad.id", target = "nacionalidadId")
    @Mapping(source = "tamanoOrganizacion.id", target = "tamanoOrganizacionId")
    @Mapping(source = "complejidadOrganizacion.id", target = "complejidadOrganizacionId")
    OrganizacionDTO toDto(Organizacion entity);
    
    @Mapping(target = "tipoOrganizacion", source = "tipoOrganizacionId", qualifiedByName = "mapTipo")
    @Mapping(target = "claseCertificacion", source = "claseCertificacionId", qualifiedByName = "mapClase")
    @Mapping(target = "nacionalidad", source = "nacionalidadId", qualifiedByName = "mapNacionalidad")
    @Mapping(target = "tamanoOrganizacion", source = "tamanoOrganizacionId", qualifiedByName = "mapTamano")
    @Mapping(target = "complejidadOrganizacion", source = "complejidadOrganizacionId", qualifiedByName = "mapComplejidad")
    Organizacion toEntity(OrganizacionDTO dto);

    
    @Mapping(source = "tipoOrganizacion.id", target = "tipoOrganizacionId")
    @Mapping(source = "claseCertificacion.id", target = "claseCertificacionId")
    @Mapping(source = "nacionalidad.id", target = "nacionalidadId")
    @Mapping(source = "tamanoOrganizacion.id", target = "tamanoOrganizacionId")
    @Mapping(source = "complejidadOrganizacion.id", target = "complejidadOrganizacionId")
    @Mapping(source = "ubicaciones", target = "ubicaciones")
    OrganizacionDetalleDTO toDetalleDto(Organizacion entity);

    
    
    
    
    
   /* de ides  a entidades  */

    @Named("mapTipo")
    default ParamTipoOrganizacion mapTipo(Long id) {
        if (id == null) return null;
        ParamTipoOrganizacion obj = new ParamTipoOrganizacion();
        obj.setId(id);
        return obj;
    }

    @Named("mapClase")
    default ParamClaseCertificacion mapClase(Long id) {
        if (id == null) return null;
        ParamClaseCertificacion obj = new ParamClaseCertificacion();
        obj.setId(id);
        return obj;
    }

    @Named("mapNacionalidad")
    default ParamNacionalidad mapNacionalidad(Long id) {
        if (id == null) return null;
        ParamNacionalidad obj = new ParamNacionalidad();
        obj.setId(id);
        return obj;
    }

    @Named("mapTamano")
    default ParamTamanoOrganizacion mapTamano(Long id) {
        if (id == null) return null;
        ParamTamanoOrganizacion obj = new ParamTamanoOrganizacion();
        obj.setId(id);
        return obj;
    }

    @Named("mapComplejidad")
    default ParamComplejidadOrganizacion mapComplejidad(Long id) {
        if (id == null) return null;
        ParamComplejidadOrganizacion obj = new ParamComplejidadOrganizacion();
        obj.setId(id);
        return obj;
    }
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true) 
    @Mapping(target = "tipoOrganizacion", source = "paramTipoOrganizacionId", qualifiedByName = "mapTipoOrg")
    @Mapping(target = "claseCertificacion", source = "paramClaseCertificacionId", qualifiedByName = "mapClase")
    @Mapping(target = "nacionalidad", source = "paramNacionalidadId", qualifiedByName = "mapNacionalidad")
    @Mapping(target = "tamanoOrganizacion", source = "paramTamanoOrganizacionId", qualifiedByName = "mapTamano")
    @Mapping(target = "complejidadOrganizacion", source = "paramComplejidadOrganizacionId", qualifiedByName = "mapComplejidad")
    Organizacion toEntity(OrganizacionCreacionDto dto);

    //   el eixto de una persona tener la liberdad de hacer sin consultar 
    /*@Mapping(target = "id", ignore = true)
    @Mapping(target = "organizacion", ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true) 
    Ubicacion toEntity(UbicacionCreacionDto dto);*/
    
    
    Aeronaves toEntity(AeronaveDTO dto);
    
    AeronaveDTO toDto(Aeronaves entity);
    
    @AfterMapping
    default void linkUbicaciones(@MappingTarget Organizacion org) {
        if (org.getUbicaciones() != null) {
            for (Ubicacion u : org.getUbicaciones()) {
                u.setOrganizacion(org);
            }
        }
    }
    
    @AfterMapping
    default void linkAeronaves(@MappingTarget Organizacion org) {
      if(org.getAeronaves()!=null) {
    	  for(Aeronaves a:org.getAeronaves()) {
    		 a.setOrganizacion(org);  
    	  }
      } 	
    }
    
    
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizacion", ignore = true)
    @Mapping(target = "fechaRegistro", ignore = true)
    @Mapping(target = "departamento", source = "departamentoId", qualifiedByName = "mapDepartamento")
    Ubicacion toEntity(UbicacionCreacionDto dto);
    
    @Named("mapDepartamento")
    default ParamDepartamento toDepartamento(Long id) {
        if (id == null) return null;
        ParamDepartamento d = new ParamDepartamento();
        d.setId(id); 
        return d;
    }
    
    @Named("mapTipoOrg")
    default ParamTipoOrganizacion toTipoOrg(Long id) {
        if (id == null) return null;
        ParamTipoOrganizacion x = new ParamTipoOrganizacion();
        x.setId(id); 
        return x;
    }

    
    
}
