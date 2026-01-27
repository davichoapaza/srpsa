package bo.gob.dgac.rbs.organizacion.modelo;

import java.time.LocalDate;
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
@Table(name = "aeronaves", schema="organizacion")
public class Aeronaves {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "organizacion_id")
	private Organizacion organizacion;
	@Column(name="matricula")
	private String matricula;
	@Column(name = "marca")
	private String marca;
	@Column(name = "modelo")
	private String modelo;
	@Column(name = "serie")
	private String serie;
	@Column(name ="fecha_expiracion")
	private LocalDate fechaExpiracion;
					     
}
