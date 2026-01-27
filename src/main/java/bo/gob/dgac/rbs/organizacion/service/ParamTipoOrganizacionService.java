package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamTipoOrganizacion;
import bo.gob.dgac.rbs.organizacion.repository.ParamTipoOrganizacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamTipoOrganizacionService {
	
	private final ParamTipoOrganizacionRepository service;
	
    public ParamTipoOrganizacion guardar(ParamTipoOrganizacion param) {
	return service.save(param);
    	}
    public List<ParamTipoOrganizacion> ListarTodos(){
    	return service.findAll();
    }
    public Optional<ParamTipoOrganizacion> obtenerPorId(Long id){
    	return service.findById(id);
    }
    public void eliminar(Long id) {
    	service.deleteById(id);
    }
    public ParamTipoOrganizacion actualizar(Long id, ParamTipoOrganizacion param) {
       	
    	ParamTipoOrganizacion paramTipoOrganizacion= service.findById(id)
    			.orElseThrow(()->new RuntimeException("No se encontro el id buscado:"+id));
              paramTipoOrganizacion.setTipo(param.getTipo());
              paramTipoOrganizacion.setDescripcion(param.getDescripcion());
              return service.save(paramTipoOrganizacion);    
    }
    
    
}
