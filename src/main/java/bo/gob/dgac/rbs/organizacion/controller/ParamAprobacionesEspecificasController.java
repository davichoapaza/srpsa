package bo.gob.dgac.rbs.organizacion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.modelo.ParamAprobacionesEspecificas;
import bo.gob.dgac.rbs.organizacion.service.ParamAprobacionesEspecificasService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("param-aprobaciones-especificas")
@RequiredArgsConstructor
public class ParamAprobacionesEspecificasController {

    private final ParamAprobacionesEspecificasService service;

    @GetMapping
    public ResponseEntity<List<ParamAprobacionesEspecificas>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ParamAprobacionesEspecificas>> obtenerPorId(
            @PathVariable Long id) {
		return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ParamAprobacionesEspecificas> crear(
            @RequestBody ParamAprobacionesEspecificas aprobacion) {
        return new ResponseEntity<>(
                service.guardar(aprobacion),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParamAprobacionesEspecificas> actualizar(
            @PathVariable Long id,
            @RequestBody ParamAprobacionesEspecificas aprobacion) {
        return ResponseEntity.ok(service.actualizar(id, aprobacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
