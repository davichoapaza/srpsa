package bo.gob.dgac.rbs.organizacion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.modelo.ParamCargo;
import bo.gob.dgac.rbs.organizacion.service.ParamCargoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("param-cargos")
@RequiredArgsConstructor
public class ParamCargoController {

    private final ParamCargoService service;

    @PostMapping
    public ResponseEntity<ParamCargo> crear(
            @RequestBody ParamCargo cargo) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.guardar(cargo));
    }
    @GetMapping
    public ResponseEntity<List<ParamCargo>> listar() {
        return ResponseEntity.ok(service.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ParamCargo> obtenerPorId(
            @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<ParamCargo> obtenerPorCodigo(
            @PathVariable String codigo) {
        return service.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<ParamCargo> actualizar(
            @PathVariable Long id,
            @RequestBody ParamCargo cargo) {
        return ResponseEntity.ok(service.actualizar(id, cargo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
