package bo.gob.dgac.rbs.organizacion.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "param_tipo_organizacion", schema = "organizacion")
@Getter
@Setter
public class ParamTipoOrganizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "descripcion")
    private String descripcion;
}
