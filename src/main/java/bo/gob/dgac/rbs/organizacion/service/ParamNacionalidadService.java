package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamNacionalidad;
import bo.gob.dgac.rbs.organizacion.repository.ParamNacionalidadRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamNacionalidadService {

    private final ParamNacionalidadRepository paramNacionalidadRepository;

    public ParamNacionalidad guardar(ParamNacionalidad param) {
        return paramNacionalidadRepository.save(param);
    }

    public List<ParamNacionalidad> listar() {
        return paramNacionalidadRepository.findAll();
    }

    public Optional<ParamNacionalidad> buscarPorId(Long id) {
        return paramNacionalidadRepository.findById(id);
    }

    public ParamNacionalidad actualizar(Long id, ParamNacionalidad param) {
        return paramNacionalidadRepository.findById(id)
                .map(existente -> {
                    existente.setNombre(param.getNombre());
                    existente.setDescripcion(param.getDescripcion());
                    return paramNacionalidadRepository.save(existente);
                })
                .orElseThrow(() ->
                        new RuntimeException("Nacionalidad no encontrada con id: " + id));
    }

    public void eliminar(Long id) {
        paramNacionalidadRepository.deleteById(id);
    }
}
