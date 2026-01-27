package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamAprobacionesEspecificas;
import bo.gob.dgac.rbs.organizacion.repository.ParamAprobacionesEspecificasRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ParamAprobacionesEspecificasService {

    private final ParamAprobacionesEspecificasRepository paramAprobacionesEspecificasRepository;

    public ParamAprobacionesEspecificas guardar(ParamAprobacionesEspecificas param) {
        return paramAprobacionesEspecificasRepository.save(param);
    }

    public List<ParamAprobacionesEspecificas> listarTodos() {
        return paramAprobacionesEspecificasRepository.findAll();
    }

    public Optional<ParamAprobacionesEspecificas> obtenerPorId(Long id) {
        return paramAprobacionesEspecificasRepository.findById(id);
    }

    public ParamAprobacionesEspecificas actualizar(Long id, ParamAprobacionesEspecificas param) {
        return paramAprobacionesEspecificasRepository.findById(id)
                .map(existente -> {
                    existente.setNombre(param.getNombre());
                    existente.setDescripcion(param.getDescripcion());
                    return paramAprobacionesEspecificasRepository.save(existente);
                })
                .orElseThrow(() -> new RuntimeException(
                        "ParamAprobacionesEspecificas no encontrado con id: " + id
                ));
    }

    public void eliminar(Long id) {
        paramAprobacionesEspecificasRepository.deleteById(id);
    }
}
  
	
