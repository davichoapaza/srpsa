package bo.gob.dgac.rbs.organizacion.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import bo.gob.dgac.rbs.organizacion.dto.UbicacionDTO;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.modelo.ParamDepartamento;
import bo.gob.dgac.rbs.organizacion.modelo.Ubicacion;

@Mapper(componentModel = "spring")
public interface UbicacionMapper {

    
    @Mapping(source = "organizacion.id", target = "organizacionId")
    @Mapping(source = "departamento.id", target = "departamentoId")
    UbicacionDTO toDto(Ubicacion entity);

    @Mapping(target = "organizacion", source = "organizacionId", qualifiedByName = "mapOrganizacion")
    @Mapping(target = "departamento", source = "departamentoId", qualifiedByName = "mapDepartamento")
    Ubicacion toEntity(UbicacionDTO dto);

    
    @Named("mapOrganizacion")
    default Organizacion mapOrganizacion(Long id) {
        if (id == null) return null;
        Organizacion o = new Organizacion();
        o.setId(id);
        return o;
    }

    @Named("mapDepartamento")
    default ParamDepartamento mapDepartamento(Long id) {
        if (id == null) return null;
        ParamDepartamento d = new ParamDepartamento();
        d.setId(id);
        return d;
    }
    
    
    
}
