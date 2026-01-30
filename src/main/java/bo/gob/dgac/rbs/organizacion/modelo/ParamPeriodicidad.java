package bo.gob.dgac.rbs.organizacion.modelo;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "param_periodicidad", schema = "organizacion")
@Getter @Setter
public class ParamPeriodicidad {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String periodo;
    private String descripcion;
    private LocalDateTime fechaRegistro;
    
        
    @OneToOne(mappedBy = "periodicidad", cascade = CascadeType.ALL, orphanRemoval= true)
    private Indicador indicador;
    
}
