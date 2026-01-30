package bo.gob.dgac.rbs.organizacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.rbs.organizacion.modelo.Indicador;

@Repository
public interface IndicadorRepository extends JpaRepository<Indicador, Long> {
	
	

}
