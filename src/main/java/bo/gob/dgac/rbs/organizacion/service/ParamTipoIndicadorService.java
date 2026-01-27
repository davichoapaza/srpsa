package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamTipoIndicador;
import bo.gob.dgac.rbs.organizacion.repository.ParamTipoIndicadorRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamTipoIndicadorService {

    private final ParamTipoIndicadorRepository repository;

    public ParamTipoIndicador guardar(ParamTipoIndicador param) {
        return repository.save(param);
    }

    public List<ParamTipoIndicador> listar() {
        return repository.findAll();
    }

    public Optional<ParamTipoIndicador> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ParamTipoIndicador actualizar(Long id, ParamTipoIndicador param) {
        return repository.findById(id)
                .map(existente -> {
                    existente.setNombreIndicador(param.getNombreIndicador());
                    existente.setDescripcion(param.getDescripcion());
                    return repository.save(existente);
                })
                .orElseThrow(() ->
                        new RuntimeException(
                                "Tipo de indicador no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
