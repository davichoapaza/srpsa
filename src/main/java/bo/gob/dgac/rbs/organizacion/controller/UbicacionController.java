package bo.gob.dgac.rbs.organizacion.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.dto.UbicacionDTO;
import bo.gob.dgac.rbs.organizacion.service.UbicacionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("ubicaciones")
@RequiredArgsConstructor
public class UbicacionController {

    private final UbicacionService service;

    @GetMapping
    public List<UbicacionDTO> listar() {
        return service.listarTodos();
    }
    @GetMapping("/{id}")
    public UbicacionDTO obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    @PostMapping
    public UbicacionDTO crear(@RequestBody UbicacionDTO dto) {
        return service.guardar(dto);
    }
    @PutMapping("/{id}")
    public UbicacionDTO actualizar(@PathVariable Long id,
                                   @RequestBody UbicacionDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
