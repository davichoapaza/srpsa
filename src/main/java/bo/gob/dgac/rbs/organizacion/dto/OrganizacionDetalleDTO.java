package bo.gob.dgac.rbs.organizacion.dto;

import java.util.List;

import lombok.Data;

@Data
public class OrganizacionDetalleDTO {

    private Long id;
    private String nombreOrganizacion;

    private Long tipoOrganizacionId;
    private Long claseCertificacionId;
    private Long nacionalidadId;
    private Long tamanoOrganizacionId;
    private Long complejidadOrganizacionId;

    private List<UbicacionDTO> ubicaciones;
}
