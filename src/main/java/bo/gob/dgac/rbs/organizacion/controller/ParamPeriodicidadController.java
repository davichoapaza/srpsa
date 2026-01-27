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

import bo.gob.dgac.rbs.organizacion.modelo.ParamPeriodicidad;
import bo.gob.dgac.rbs.organizacion.service.ParamPeriodicidadService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("param-periodicidad")
@RequiredArgsConstructor
public class ParamPeriodicidadController {

    private final ParamPeriodicidadService service;

    @PostMapping
    public ResponseEntity<ParamPeriodicidad> crear(
            @RequestBody ParamPeriodicidad param) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.guardar(param));
    }

    @GetMapping
    public ResponseEntity<List<ParamPeriodicidad>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParamPeriodicidad> obtenerPorId(
            @PathVariable Long id) {

        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParamPeriodicidad> actualizar(
            @PathVariable Long id,
            @RequestBody ParamPeriodicidad param) {

        return ResponseEntity.ok(service.actualizar(id, param));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
