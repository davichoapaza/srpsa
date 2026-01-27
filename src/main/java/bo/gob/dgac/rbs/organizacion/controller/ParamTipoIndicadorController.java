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

import bo.gob.dgac.rbs.organizacion.modelo.ParamTipoIndicador;
import bo.gob.dgac.rbs.organizacion.service.ParamTipoIndicadorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("param-tipo-indicador")
@RequiredArgsConstructor
public class ParamTipoIndicadorController {

    private final ParamTipoIndicadorService service;

    @PostMapping
    public ResponseEntity<ParamTipoIndicador> crear(
            @RequestBody ParamTipoIndicador param) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.guardar(param));
    }

    @GetMapping
    public ResponseEntity<List<ParamTipoIndicador>> listar() {
        return ResponseEntity.ok(service.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParamTipoIndicador> obtenerPorId(
            @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParamTipoIndicador> actualizar(
            @PathVariable Long id,
            @RequestBody ParamTipoIndicador param) {
        return ResponseEntity.ok(service.actualizar(id, param));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
