package bo.gob.dgac.rbs.organizacion.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "param_clase_certificacion", schema = "organizacion")
@Getter
@Setter
public class ParamClaseCertificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_certificacion")
    private String nombreCertificacion;

    @Column(name = "descripcion")
    private String descripcion;
}
