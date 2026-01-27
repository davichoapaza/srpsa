package bo.gob.dgac.rbs.organizacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.rbs.organizacion.modelo.ParamCargo;

@Repository
public interface ParamCargoRepository
        extends JpaRepository<ParamCargo, Long> {

    Optional<ParamCargo> findByCodigo(String codigo);
}
