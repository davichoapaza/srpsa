package bo.gob.dgac.rbs.organizacion.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
   
@Entity
@Data
@Table(name="objetivos", schema="organizacion")
public class Objetivos {
	     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "organizacion_id")
	private Organizacion organizacion;
	
	private String nombre;
	
	private String descripcion;
	
	@OneToMany(mappedBy="objetivos", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Metas> metas;

			
}
