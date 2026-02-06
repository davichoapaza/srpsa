package bo.gob.dgac.rbs.organizacion.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.rbs.organizacion.modelo.TipoOperacion;
@Repository
public interface TipoOperacionRepository extends JpaRepository<TipoOperacion, Long> {

    List<TipoOperacion> findByOrganizacionId(Long organizacionId);

    void deleteByOrganizacionId(Long organizacionId);
}
