package bo.gob.dgac.rbs.organizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.rbs.organizacion.modelo.ParamTipoOperacion;

@Repository
public interface ParamTipoOperacionRepository
        extends JpaRepository<ParamTipoOperacion, Long> {
}
