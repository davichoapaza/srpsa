package bo.gob.dgac.rbs.organizacion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="organizacion_cargo_persona", schema ="organizacion")
public class OrganizacionCargoPersona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name = "organizacion_id")
	 private Organizacion organizacion;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "param_cargo_id")
	 private ParamCargo paramCargo;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "personas_id" )
	 private Persona personas;

}








