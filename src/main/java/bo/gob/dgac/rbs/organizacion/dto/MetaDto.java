package bo.gob.dgac.rbs.organizacion.dto;

import java.util.List;

import lombok.Data;

@Data
public class MetaDto {
  public String nombre;
  public String descripcion;
  public List<IndicadorDto> indicadores;
	
	
}
