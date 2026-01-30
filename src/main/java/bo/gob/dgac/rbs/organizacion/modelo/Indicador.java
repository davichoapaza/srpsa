package bo.gob.dgac.rbs.organizacion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="indicadores", schema="organizacion")
@Data
public class Indicador {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "meta_id")
	private Metas metas; 
	
	private String nombre;
	private String descripcion;
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name= "tipo_indicador_id") 
    private ParamTipoIndicador tipoIndicador;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "periodicidad_id")
    private ParamPeriodicidad periodicidad;
    
    private String formulaIndicador;
    private String nivelAlertaUno;
    private String nivelAlertaDos;
    private String nivelAlertaTres;
    private String valorObjetivo;
    private String valorActual;
	
	
	
	
	
}
