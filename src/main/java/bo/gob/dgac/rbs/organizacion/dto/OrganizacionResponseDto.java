package bo.gob.dgac.rbs.organizacion.dto;

import java.util.ArrayList;
import java.util.List;

public class OrganizacionResponseDto {
	    public Long id;
	    public String nombreOrganizacion;
	    public List<ObjetivosDto> objetivos = new ArrayList<>();
}
