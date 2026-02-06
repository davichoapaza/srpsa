package bo.gob.dgac.rbs.organizacion.dto;

import java.util.List;

import lombok.Data;

@Data
public class UbicacionRequestDto {
	public Long organizacionId;
	public List<UbicacionDTO> ubicacion;

}
