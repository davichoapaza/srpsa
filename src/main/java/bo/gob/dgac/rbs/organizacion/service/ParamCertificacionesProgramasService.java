package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamCertificacionesProgramas;
import bo.gob.dgac.rbs.organizacion.repository.ParamCertificacionesProgramasRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamCertificacionesProgramasService {

    private final ParamCertificacionesProgramasRepository repository;

    public ParamCertificacionesProgramas guardar(ParamCertificacionesProgramas param) {
        return repository.save(param);
    }

    public List<ParamCertificacionesProgramas> listar() {
        return repository.findAll();
    }

    public Optional<ParamCertificacionesProgramas> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ParamCertificacionesProgramas actualizar(
            Long id,
            ParamCertificacionesProgramas param) {

        return repository.findById(id)
                .map(existente -> {
                    existente.setNombre(param.getNombre());
                    existente.setDescripcion(param.getDescripcion());
                    return repository.save(existente);
                })
                .orElseThrow(() ->
                        new RuntimeException(
                                "Certificación/Programa no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
