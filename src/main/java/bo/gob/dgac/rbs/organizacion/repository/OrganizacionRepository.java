package bo.gob.dgac.rbs.organizacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
	
	@Query("""
		    SELECT o FROM Organizacion o
		    LEFT JOIN FETCH o.ubicaciones u
		    WHERE o.id = :id
 """)
	Optional<Organizacion> findByIdConUbicaciones(Long id);

}
