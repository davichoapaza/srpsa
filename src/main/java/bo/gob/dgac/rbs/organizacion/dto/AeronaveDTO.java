package bo.gob.dgac.rbs.organizacion.dto;

import java.time.LocalDate;


import lombok.Data;

@Data
public class AeronaveDTO {
 private String matricula;
 private String marca;
 private String modelo;
 private String serie;
 private LocalDate fechaExpiracion;	
}
