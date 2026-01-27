package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamTipoOperacion;
import bo.gob.dgac.rbs.organizacion.repository.ParamTipoOperacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamTipoOperacionService {

    private final ParamTipoOperacionRepository repository;

    public ParamTipoOperacion guardar(ParamTipoOperacion param) {
        return repository.save(param);
    }

    public List<ParamTipoOperacion> listar() {
        return repository.findAll();
    }

    public Optional<ParamTipoOperacion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ParamTipoOperacion actualizar(Long id, ParamTipoOperacion param) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNombre(param.getNombre());
                    existente.setDecripcion(param.getDecripcion());
                    return repository.save(existente);
                })
                .orElseThrow(() ->
                        new RuntimeException(
                                "Tipo de operación no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
