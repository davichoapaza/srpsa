package bo.gob.dgac.rbs.organizacion.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrganizacionDTO {

    private Long id;
    private String nombreOrganizacion;
    private Long tipoOrganizacionId;
    private Long claseCertificacionId;
    private Long nacionalidadId;
    private Long tamanoOrganizacionId;
    private Long complejidadOrganizacionId;

    private LocalDate fechaCertificacionInicial;
    private LocalDate fechaCertificacionExpiracion;
    private String numeroCertificadoDgac;
    private String numeroResolucionAdministrativaDgac;
    private String otraResolucionClaseCertificacion;

    private Boolean tieneSms;
    private LocalDate fechaAceptacionInicialSms;

    private String estadoRegistro;
    private String usuarioCreado;
    private LocalDateTime fechaRegistro;
    private String rutaFile;
}
