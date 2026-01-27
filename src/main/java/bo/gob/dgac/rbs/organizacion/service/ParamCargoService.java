package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamCargo;
import bo.gob.dgac.rbs.organizacion.repository.ParamCargoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamCargoService {

    private final ParamCargoRepository paramCargoRepository;

    public ParamCargo guardar(ParamCargo cargo) {
        paramCargoRepository.findByCodigo(cargo.getCodigo())
                .ifPresent(c -> {
                    throw new RuntimeException(
                            "Ya existe un cargo con el código: " + cargo.getCodigo());
                });

        return paramCargoRepository.save(cargo);
    }

    public List<ParamCargo> listar() {
        return paramCargoRepository.findAll();
    }

    public Optional<ParamCargo> buscarPorId(Long id) {
        return paramCargoRepository.findById(id);
    }

    public Optional<ParamCargo> buscarPorCodigo(String codigo) {
        return paramCargoRepository.findByCodigo(codigo);
    }

    public ParamCargo actualizar(Long id, ParamCargo cargo) {
        return paramCargoRepository.findById(id)
                .map(existente -> {
                    if (!existente.getCodigo().equals(cargo.getCodigo())) {
                        paramCargoRepository.findByCodigo(cargo.getCodigo())
                                .ifPresent(c -> {
                                    throw new RuntimeException(
                                            "El código ya está en uso: " + cargo.getCodigo());
                                });
                    }
                    existente.setCodigo(cargo.getCodigo());
                    existente.setDescripcion(cargo.getDescripcion());

                    return paramCargoRepository.save(existente);
                })
                .orElseThrow(() ->
                        new RuntimeException("Cargo no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        paramCargoRepository.deleteById(id);
    }
}
