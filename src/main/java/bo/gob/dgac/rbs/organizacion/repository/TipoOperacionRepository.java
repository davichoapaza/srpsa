package bo.gob.dgac.rbs.organizacion.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import bo.gob.dgac.rbs.organizacion.modelo.TipoOperacion;

public interface TipoOperacionRepository extends JpaRepository<TipoOperacion, Long> {

    List<TipoOperacion> findByOrganizacionId(Long organizacionId);

    void deleteByOrganizacionId(Long organizacionId);
}
