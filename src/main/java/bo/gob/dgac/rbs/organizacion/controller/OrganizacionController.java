package bo.gob.dgac.rbs.organizacion.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.dto.OrganizacionCreacionDto;
import bo.gob.dgac.rbs.organizacion.dto.OrganizacionDTO;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.service.OrganizacionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("organizaciones")
@RequiredArgsConstructor
public class OrganizacionController {

    private final ParamComplejidadOrganizacionController paramComplejidadOrganizacionController;

    private final OrganizacionService service;

    /*OrganizacionController(ParamComplejidadOrganizacionController paramComplejidadOrganizacionController) {
        this.paramComplejidadOrganizacionController = paramComplejidadOrganizacionController;
    }*/

    @GetMapping
    public List<OrganizacionDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public OrganizacionDTO obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    
    @PostMapping
    public ResponseEntity<?>  crear(@RequestBody OrganizacionCreacionDto dto) {
    	Organizacion creado=service.crear(dto);
    	return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
    			"id",creado.getId(),
    			"mensaje","La organizacion fue creada correctament"));
    }
    /*
    @GetMapping("/objetivos/{id}")
    public ResponseEntity<OrganizacionResponseDto> obtenerObjetivos(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerArbol(id));
    }
    */
    /*@PostMapping
    public ResponseEntity<?> crear(@RequestBody OrganizacionCreacionDto dto) {
        Organizacion creada = service.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
            "id", creada.getId(),
            "mensaje", "Organización creada "
        ));
    }*/
    
    
    
    /*@PostMapping
    public OrganizacionDTO crear(@RequestBody OrganizacionDTO dto) {
        return service.guardar(dto);
    }*/

    
    /*
    @GetMapping("/detalle/{id}")
    public OrganizacionDetalleDTO obtenerDetalle(@PathVariable Long id) {
        return service.obtenerConUbicaciones(id);
    }
   */
    
    @PutMapping("/{id}")
    public OrganizacionDTO actualizar(@PathVariable Long id,
                                      @RequestBody OrganizacionDTO dto) {
        return service.actualizar(id, dto);
    }
}



/*
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bo.gob.dgac.rbs.organizacion.modelo.Organizacion;
import bo.gob.dgac.rbs.organizacion.service.OrganizacionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("organizaciones")
@RequiredArgsConstructor
public class OrganizacionController {

    private final OrganizacionService service;

    @GetMapping
    public ResponseEntity<List<Organizacion>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Organizacion> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<Organizacion> crear(@RequestBody Organizacion organizacion) {
        return new ResponseEntity<>(service.guardar(organizacion), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Organizacion> actualizar(
            @PathVariable Long id,
            @RequestBody Organizacion organizacion) {

        return ResponseEntity.ok(service.actualizar(id, organizacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
*/