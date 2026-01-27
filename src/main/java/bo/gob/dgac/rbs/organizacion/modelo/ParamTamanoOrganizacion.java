package bo.gob.dgac.rbs.organizacion.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "param_tamano_organizacion", schema = "organizacion")
@Getter @Setter
public class ParamTamanoOrganizacion {

	private String tamano;
    private String descripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
}
