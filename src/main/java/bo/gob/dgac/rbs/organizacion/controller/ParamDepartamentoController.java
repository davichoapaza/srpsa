package bo.gob.dgac.rbs.organizacion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.modelo.ParamDepartamento;
import bo.gob.dgac.rbs.organizacion.service.ParamDepartamentoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("param-departamentos")
@RequiredArgsConstructor
public class ParamDepartamentoController {
	
	private final ParamDepartamentoService service;

	 @PostMapping
	 public ResponseEntity<ParamDepartamento> crear(
			 @RequestBody ParamDepartamento param){
		 return ResponseEntity.status(HttpStatus.CREATED)
				 .body(service.guardar(param));
	 }
	 
	 @GetMapping
	 public ResponseEntity<List<ParamDepartamento>> listar(){
		 return ResponseEntity.ok(service.listarTodos());	 
		 
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<ParamDepartamento> obtenerPorId(
			 @PathVariable Long id){
		 return service.obtenerPorId(id).
				 map(ResponseEntity::ok)
				 .orElse(ResponseEntity.notFound().build());
	 }
	 
	 
	 
	 
	 
	 
	 
			 
	 
	
		 
	 
	 
	 
			 
}
