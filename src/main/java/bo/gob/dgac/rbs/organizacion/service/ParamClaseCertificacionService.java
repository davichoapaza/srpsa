package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import bo.gob.dgac.rbs.organizacion.modelo.ParamClaseCertificacion;
import bo.gob.dgac.rbs.organizacion.repository.ParamClaseCertificacionRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ParamClaseCertificacionService {
 private final ParamClaseCertificacionRepository service;
	
 public ParamClaseCertificacion guardar(ParamClaseCertificacion param) {
	 return service.save(param);
 } 
 
 public List<ParamClaseCertificacion> listarTodos(){
	 return service.findAll();
 }
 
 public Optional<ParamClaseCertificacion> obtenerPorId(Long id){
	 return service.findById(id);
	 
 }
 public void eliminar(Long id) {
	 service.deleteById(id);;
 }

 public ParamClaseCertificacion actualizar(Long id, ParamClaseCertificacion param) {
   ParamClaseCertificacion paramClaseCertificacion= service.findById(id)
		   .orElseThrow(() -> new RuntimeException ("No se encontro el id :"+id));
	  paramClaseCertificacion.setNombreCertificacion(param.getNombreCertificacion());        
      paramClaseCertificacion.setDescripcion(param.getDescripcion());
     return service.save(paramClaseCertificacion);
 }

  
}
