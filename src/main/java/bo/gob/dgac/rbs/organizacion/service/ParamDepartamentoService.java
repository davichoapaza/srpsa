package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamDepartamento;
import bo.gob.dgac.rbs.organizacion.repository.ParamDepartamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamDepartamentoService {
	
	private  final ParamDepartamentoRepository service;
	
	public ParamDepartamento guardar(ParamDepartamento param) {
		return service.save(param);
	}
	public List<ParamDepartamento> listarTodos(){
		return service.findAll();
	}
	public Optional<ParamDepartamento> obtenerPorId(Long id){
		return service.findById(id);
	}
	
	public void eliminar (Long id) {
		service.deleteById(id);
	}
	
	public ParamDepartamento actualizar(Long id, ParamDepartamento param) {
		ParamDepartamento paramDepartamento = service.findById(id)
				.orElseThrow(()-> new RuntimeException("No se puede econtrar el id"));
        paramDepartamento.setNombre(param.getNombre());
        paramDepartamento.setDescripcion(param.getDescripcion());
        return service.save(paramDepartamento);
		
	}
	

}
