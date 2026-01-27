package bo.gob.dgac.rbs.organizacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import bo.gob.dgac.rbs.organizacion.modelo.ParamTamanoOrganizacion;
import bo.gob.dgac.rbs.organizacion.repository.ParamTamanoOrganizacionRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParamTamanoOrganizacionService {

    private final ParamTamanoOrganizacionRepository repository;

    public ParamTamanoOrganizacion guardar(ParamTamanoOrganizacion param) {
        return repository.save(param);
    }

    public List<ParamTamanoOrganizacion> listar() {
        return repository.findAll();
    }

    public Optional<ParamTamanoOrganizacion> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ParamTamanoOrganizacion actualizar(
            Long id,
            ParamTamanoOrganizacion param) {

        return repository.findById(id)
                .map(existente -> {
                    existente.setTamano(param.getTamano());
                    existente.setDescripcion(param.getDescripcion());
                    return repository.save(existente);
                })
                .orElseThrow(() ->
                        new RuntimeException(
                                "Tamaño de organización no encontrado con id: " + id));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
