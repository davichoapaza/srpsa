package bo.gob.dgac.rbs.organizacion.dto;

import java.util.List;

import lombok.Data;

@Data
public class ObjetivosRequestDto {

	public Long organizacionId;
	public List<ObjetivosDto> objetivos;
	
}
