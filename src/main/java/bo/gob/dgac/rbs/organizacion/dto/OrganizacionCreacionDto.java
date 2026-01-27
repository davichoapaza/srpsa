package bo.gob.dgac.rbs.organizacion.dto;

import java.time.LocalDate;
import java.util.List;

public class OrganizacionCreacionDto {

    public String nombreOrganizacion;
    public Integer paramTipoOrganizacionId;

    public LocalDate fechaCertificacionInicial;
    public LocalDate fechaCertificacionExpiracion;

    public String numeroCertificadoDgac;
    public String numeroResolucionAdministrativaDgac;
 
    public Integer paramClaseCertificacionId;
    public String otraResolucionClaseCertificacion;
 
    public Boolean tieneSms;
    public LocalDate fechaAceptacionInicialSms;

    public Integer paramNacionalidadId;
    public Integer paramTamanoOrganizacionId;
    public Integer paramComplejidadOrganizacionId;
    
    
    public String estadoRegistro;
    public String usuarioCreado;
    public String rutaFile;

    public List<UbicacionCreacionDto> ubicaciones;

    public List<AeronaveDTO> aeronaves;
    
    
    
}
