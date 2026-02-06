package bo.gob.dgac.rbs.organizacion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.dto.ObjetivosRequestDto;
import bo.gob.dgac.rbs.organizacion.service.ObjetivosService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("objetivos")
@RequiredArgsConstructor
public class ObjetivoController {

    private final ObjetivosService service;

    @PostMapping()
    public ResponseEntity<?> guardar(@RequestBody ObjetivosRequestDto dto) {
        service.guardar(dto);
        return ResponseEntity.ok("Guardado correctamente");
    }
    
    
}
