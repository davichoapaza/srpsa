package bo.gob.dgac.rbs.organizacion.modelo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "tipo_operacion", schema = "organizacion")
public class TipoOperacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizacion_id")
    private Organizacion organizacion;

    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_operacion_id")*/
    @Column(name = "tipo_operacion_id")
    private ParamTipoOperacion tipoOperacionId;

    @Column(name = "descripcion")
    private String descripcion;
}
