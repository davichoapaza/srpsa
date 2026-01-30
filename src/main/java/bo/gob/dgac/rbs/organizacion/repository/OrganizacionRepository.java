package bo.gob.dgac.rbs.organizacion.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;

@Repository
public interface OrganizacionRepository extends JpaRepository<Organizacion, Long> {
	
	
	 @Query("""
			  select distinct o
			    from Organizacion o
			    left join fetch o.objetivos obj
			    left join fetch obj.metas m
			    left join fetch m.indicador i
			    where o.id = :id
			    """)
	Optional<Organizacion> findArbolById(@Param("id") Long id);
	
	
	 /*@Query("""
    select i
    from Indicador i
    join fetch i.meta m
    left join fetch i.tipoIndicador
    where m.id in :metaIds
    """)
    List<Indicador> findByMetaIdsWithTipo(@Param("metaIds") List<Long> metaIds);
}*/
	 
	@Query("""
		    SELECT o FROM Organizacion o
		    LEFT JOIN FETCH o.ubicaciones u
		    WHERE o.id = :id
 """)
	Optional<Organizacion> findByIdConUbicaciones(Long id);

	
	
	
	
}
