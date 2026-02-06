package bo.gob.dgac.rbs.organizacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import bo.gob.dgac.rbs.organizacion.dto.PersonaCargoResponseDTO;
import bo.gob.dgac.rbs.organizacion.modelo.OrganizacionCargoPersona;




@Repository
public interface OrganizacionCargoPersonaRepository extends JpaRepository<OrganizacionCargoPersona, Long> {
	

@Query("""
    select ocp
    from OrganizacionCargoPersona ocp
    join fetch ocp.personas p
    join fetch ocp.paramCargo pc
    where ocp.organizacion.id = :orgId
""")
List<OrganizacionCargoPersona> listarPersonaYCargo(@Param("orgId") Long orgId);

 @Query("""
		   select new bo.gob.dgac.rbs.organizacion.dto.PersonaCargoResponseDTO(
		       pc.id,
		       pc.descripcion,
		       p.nombres,
		       p.primerApellido,
		       p.segundoApellido,
		       p.cedulaIdentidad,
		       p.telefono,
		       p.correo,
		       p.numeroLicencia
		   )
		   from OrganizacionCargoPersona ocp
		   join ocp.personas p
		   join ocp.paramCargo pc
		   where ocp.organizacion.id = :org
		""")
    List<PersonaCargoResponseDTO> listarPersonasOrganizacion(@Param("org") Long org);






}
