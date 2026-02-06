package bo.gob.dgac.rbs.organizacion.modelo;

import jakarta.persistence.Column;
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
@Table(name = "certificaciones_programas", schema="organizacion")
public class CertificacionesProgramas {
 
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   
	   @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "organizacion_id")
	   private Organizacion organizacion;
	   
	   @ManyToOne(fetch = FetchType.LAZY)
	   @JoinColumn(name = "certificaciones_programas_id")
	   private ParamCertificacionesProgramas certificacionesProgramas;
	 
	   @Column(name= "descripcion")
	   private String descripcion;
	   
	   
	   
	
	
	
}
