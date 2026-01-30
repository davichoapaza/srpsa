package bo.gob.dgac.rbs.organizacion.modelo;

import java.util.List;

import bo.gob.dgac.rbs.organizacion.dto.IndicadorDto;
import bo.gob.dgac.rbs.organizacion.dto.MetaDto;
import bo.gob.dgac.rbs.organizacion.dto.ObjetivosDto;
import bo.gob.dgac.rbs.organizacion.dto.ObjetivosRequestDto;
import bo.gob.dgac.rbs.organizacion.repository.IndicadorRepository;
import bo.gob.dgac.rbs.organizacion.repository.MetasRepository;
import bo.gob.dgac.rbs.organizacion.repository.ObjetivosRepository;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="metas", schema="organizacion")
@AllArgsConstructor
@NoArgsConstructor
public class Metas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "objetivo_id")
	private Objetivos objetivos;
	@Column(name = "nombre")
	private String nombre;
	private String descripcion;

    @OneToMany(mappedBy ="metas", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Indicador> indicador;
    
    
    
	
    

	
	
	
	
	
	

}
