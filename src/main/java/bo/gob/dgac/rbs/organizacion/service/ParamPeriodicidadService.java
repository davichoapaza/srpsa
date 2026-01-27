package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamPeriodicidad;
import bo.gob.dgac.rbs.organizacion.repository.ParamPeriodicidadRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamPeriodicidadService {

    private final ParamPeriodicidadRepository repository;

    public ParamPeriodicidad guardar(ParamPeriodicidad param) {
        return repository.save(param);
    }

    public List<ParamPeriodicidad> listar() {
        return repository.findAll();
    }

    public Optional<ParamPeriodicidad> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ParamPeriodicidad actualizar(Long id, ParamPeriodicidad param) {

        return repository.findById(id)
                .map(existente -> {
                    existente.setPeriodo(param.getPeriodo());
                    existente.setDescripcion(param.getDescripcion());
                    return repository.save(existente);
                })
                .orElseThrow(() ->
                        new RuntimeException(
                                "Periodicidad no encontrada con id: " + id));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
