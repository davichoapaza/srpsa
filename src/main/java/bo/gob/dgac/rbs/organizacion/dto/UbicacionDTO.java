package bo.gob.dgac.rbs.organizacion.dto;

import lombok.Data;

@Data
public class UbicacionDTO {

    private Long id;
    private Long organizacionId;
    private Long departamentoId;
    private String direccion;
    private String telefono;
    private String correo;

}
