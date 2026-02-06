package bo.gob.dgac.rbs.organizacion.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "organizaciones", schema = "organizacion")
public class Organizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_organizacion", nullable = false)
    private String nombreOrganizacion;

    @ManyToOne
    @JoinColumn(name = "param_tipo_organizacion_id", nullable = false)
    private ParamTipoOrganizacion tipoOrganizacion;

    @ManyToOne
    @JoinColumn(name = "param_clase_certificacion_id")
    private ParamClaseCertificacion claseCertificacion;

    @ManyToOne
    @JoinColumn(name = "param_nacionalidad_id")
    private ParamNacionalidad nacionalidad;

    @ManyToOne
    @JoinColumn(name = "param_tamano_organizacion_id")
    private ParamTamanoOrganizacion tamanoOrganizacion;

    @ManyToOne
    @JoinColumn(name = "param_complejidad_organizacion_id")
    private ParamComplejidadOrganizacion complejidadOrganizacion;

    
    @Column(name = "fecha_certificacion_inicial")
    private LocalDate fechaCertificacionInicial;

    @Column(name = "fecha_certificacion_expiracion")
    private LocalDate fechaCertificacionExpiracion;

    @Column(name = "numero_certificado_dgac")
    private String numeroCertificadoDgac;

    @Column(name = "numero_resolucion_administrativa_dgac")
    private String numeroResolucionAdministrativaDgac;

    @Column(name = "otra_resolucion_clase_certificacion")
    private String otraResolucionClaseCertificacion;

    @Column(name = "tiene_sms")
    private Boolean tieneSms;

    @Column(name = "fecha_aceptacion_inicial_sms")
    private LocalDate fechaAceptacionInicialSms;

    @Column(name = "estado_registro", length = 2)
    private String estadoRegistro;

    @Column(name = "usuario_creado", length = 100)
    private String usuarioCreado;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @Column(name = "ruta_file", length = 255)
    private String rutaFile;
    
    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }

    /*
     
    @OneToMany(mappedBy = "organizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ubicacion> ubicaciones;

    */
     
    @OneToMany(mappedBy="organizacion", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Ubicacion> ubicaciones;
    
    public void addUbicacion(Ubicacion u) {
    	  ubicaciones.add(u);
    	  u.setOrganizacion(this);
    }
    public void removeUbicacion(Ubicacion u) {
    	ubicaciones.remove(u);
    	u.setOrganizacion(null);
    }
    
    @OneToMany(mappedBy="organizacion", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Aeronaves> aeronaves;
    
    
    @OneToMany(mappedBy="organizacion", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<Objetivos> objetivos;
    
    
//    @OneToMany(mappedBy="organizacion", cascade = CascadeType.ALL, orphanRemoval = true)
 //   private List<TipoOperacion> tipoOperacion;
    
    @OneToMany(mappedBy="organizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TipoOperacion> tipoOperacion = new ArrayList<>();
// Con esto, aunque no llegue nada, getTipoOperacion() devuelve lista vacía y no revienta.
    
    
    @OneToMany(mappedBy="organizacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CertificacionesProgramas> certificacionesProgramas = new ArrayList<>();
     // con esto hacemos que si el objeto certifcacionesProgramas este e
    // en valor nulo no pueda producir ningun error
    
    
}
