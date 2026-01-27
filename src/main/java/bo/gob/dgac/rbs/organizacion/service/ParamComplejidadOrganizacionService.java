package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamComplejidadOrganizacion;
import bo.gob.dgac.rbs.organizacion.repository.ParamComplejidadOrganizacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamComplejidadOrganizacionService {

	 private final ParamComplejidadOrganizacionRepository service;
	 
	 public ParamComplejidadOrganizacion guardar(ParamComplejidadOrganizacion param) {
       return service.save(param); 		 
		 
	 }
	 
	 public List<ParamComplejidadOrganizacion> listarTodos(){
		 return service.findAll();
		 
	 }
	 public Optional<ParamComplejidadOrganizacion> obtenerPorId(Long id){
		 return service.findById(id);
		 
	 }
	 
	 public void eliminar(Long id) {
		 
		 service.deleteById(id);
	 }

	 public ParamComplejidadOrganizacion actualizar(Long id, ParamComplejidadOrganizacion param) {
 		 
        ParamComplejidadOrganizacion paramComplejidadOrganizacion = service.findById(id)
        		.orElseThrow(() -> new RuntimeException ("No se encontro el id :"+id));
        paramComplejidadOrganizacion.setNombre(param.getNombre());
        paramComplejidadOrganizacion.setDescripcion(param.getDescripcion());
        return service.save(paramComplejidadOrganizacion);
	 } 
	
}
