package bo.gob.dgac.rbs.organizacion.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import bo.gob.dgac.rbs.organizacion.dto.TipoOperacionItemDto;
import bo.gob.dgac.rbs.organizacion.modelo.TipoOperacion;






@Mapper(componentModel = "spring")
public interface TipoOperacionMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "organizacion", ignore = true)
   // @Mapping(target = "tipoOperacion", source = "tipoOperacionId", qualifiedByName = "mapTipoOperacion")
    //@Mapping(target = "descripcion", source = "descripcion")
    TipoOperacion toEntity(TipoOperacionItemDto dto);

    @Mapping(target = "tipoOperacionId", source = "tipoOperacion.id")
    TipoOperacionItemDto toDto(TipoOperacion entity);

  /*  @AfterMapping
    default void validate(@MappingTarget TipoOperacion entity, TipoOperacionItemDto dto) {
        System.out.println(" AFTER MAPPING EJECUTADO");

        if (dto != null && dto.getTipoOperacionId() != null && entity.getTipoOperacion() == null) {
            throw new IllegalStateException(
                "No se pudo mapear tipoOperacionId=" + dto.getTipoOperacionId()
            );
        }
    }*/

    /*@Named("mapTipoOperacion")
    default ParamTipoOperacion mapTipoOperacion(Long id) {
        System.out.println("MAP TIPO OPERACION: " + id);
        if (id == null) return null;
        ParamTipoOperacion obj = new ParamTipoOperacion();
        obj.setId(id);
        return obj;
    }
    */
}

