package bo.gob.dgac.rbs.organizacion.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaCargoResponseDTO {
	
	public  Long cargoId;
	public String nombreCargo;
	public String nombres;
	public String primerApellido;
	public String segundoApellido;
	public String cedulaIdentidad;
	public String telefono;
	public String correo;
	public String numeroLicencia;

}
