package bo.gob.dgac.rbs.organizacion.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import bo.gob.dgac.rbs.organizacion.dto.UbicacionDTO;
import bo.gob.dgac.rbs.organizacion.service.UbicacionService;

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
