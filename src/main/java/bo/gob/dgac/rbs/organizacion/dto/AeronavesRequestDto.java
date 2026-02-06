package bo.gob.dgac.rbs.organizacion.dto;

import java.util.List;

import lombok.Data;

@Data
public class AeronavesRequestDto {
  public Long organizacionId;
  public List<AeronaveDTO> aeronaves;
	
}
