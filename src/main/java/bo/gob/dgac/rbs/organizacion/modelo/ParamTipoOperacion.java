package bo.gob.dgac.rbs.organizacion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "param_tipo_operacion", schema = "organizacion")
@Data
public class ParamTipoOperacion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String nombre;
    private String decripcion;
	
    /*@OneToOne(mappedBy = "tipoOperacion")
     private TipoOperacion tipoOperacion;*/
    
}

