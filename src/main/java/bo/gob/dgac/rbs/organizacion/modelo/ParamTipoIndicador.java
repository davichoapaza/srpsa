package bo.gob.dgac.rbs.organizacion.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "param_tipo_indicador", schema = "organizacion")
@Getter @Setter
public class ParamTipoIndicador {

	private String nombreIndicador;
    private String descripcion;
    private LocalDateTime fechaRegistro;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
}
