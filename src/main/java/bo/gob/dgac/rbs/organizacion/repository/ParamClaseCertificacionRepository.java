package bo.gob.dgac.rbs.organizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.rbs.organizacion.modelo.ParamClaseCertificacion;

@Repository
public interface ParamClaseCertificacionRepository extends JpaRepository<ParamClaseCertificacion, Long> {

}
