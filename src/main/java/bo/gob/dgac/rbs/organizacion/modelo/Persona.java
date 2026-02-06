package bo.gob.dgac.rbs.organizacion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "personas", schema= "organizacion")
public class Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
	 private String nombres;
	 private String primerApellido;
	 private String segundoApellido;
	 private String cedulaIdentidad;
	 private String telefono;
	 private String correo;
	 private String numeroLicencia;
	
}


