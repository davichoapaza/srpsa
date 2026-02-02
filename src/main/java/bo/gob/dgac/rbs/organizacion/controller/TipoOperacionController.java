package bo.gob.dgac.rbs.organizacion.controller;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.dto.TipoOperacionGuardarDto;
import bo.gob.dgac.rbs.organizacion.service.TipoOperacionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("tipo-operacion")
@RequiredArgsConstructor
public class TipoOperacionController {

    private final TipoOperacionService service;


  
    @PostMapping
    public ResponseEntity<?> guardar(@RequestBody TipoOperacionGuardarDto dto) {
        service.guardarTipos(dto);
        return ResponseEntity.ok("Tipos de operación guardados");
    }

/*
    @GetMapping("/organizacion/{organizacionId}")
    public ResponseEntity<List<TipoOperacionDto>> listar(@PathVariable Long organizacionId) {
        return ResponseEntity.ok(service.listarPorOrganizacion(organizacionId));
    }*/
}
