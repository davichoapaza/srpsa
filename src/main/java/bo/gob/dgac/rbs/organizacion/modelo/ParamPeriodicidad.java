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
@Table(name = "param_periodicidad", schema = "organizacion")
@Getter @Setter
public class ParamPeriodicidad {
	private String periodo;
    private String descripcion;
    private LocalDateTime fechaRegistro;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
}
