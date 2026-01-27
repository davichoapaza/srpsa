package bo.gob.dgac.rbs.organizacion.controller;

import java.util.List;
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
import bo.gob.dgac.rbs.organizacion.modelo.ParamClaseCertificacion;
import bo.gob.dgac.rbs.organizacion.service.ParamClaseCertificacionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("param-clase-certificacion")
@RequiredArgsConstructor
public class ParamClaseCertificacionController {
	private final ParamClaseCertificacionService service;
	
	@PostMapping
	public ResponseEntity<ParamClaseCertificacion> crear(
			@RequestBody ParamClaseCertificacion param){
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(service.guardar(param));
	
	}
	
	@GetMapping()
	public ResponseEntity<List<ParamClaseCertificacion>> listar(){
		return ResponseEntity.ok(service.listarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ParamClaseCertificacion> obtenerPorId(@PathVariable Long id){
		return service.obtenerPorId(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id){
		service.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ParamClaseCertificacion> actualizar(
			@PathVariable Long id,
			@RequestBody ParamClaseCertificacion param){
		return ResponseEntity.ok(service.actualizar(id, param));
	}
	
	

}
