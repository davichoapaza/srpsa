package bo.gob.dgac.rbs.organizacion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "param_certificaciones_programas", schema = "organizacion")
@Getter @Setter
public class ParamCertificacionesProgramas {

	private String nombre;
    private String descripcion;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
}
