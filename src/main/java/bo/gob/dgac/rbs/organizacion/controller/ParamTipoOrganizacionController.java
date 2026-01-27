package bo.gob.dgac.rbs.organizacion.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.modelo.ParamTipoOrganizacion;
import bo.gob.dgac.rbs.organizacion.service.ParamTipoOrganizacionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("param-tipo-organizacion")
@RequiredArgsConstructor
public class ParamTipoOrganizacionController {
	
	private final ParamTipoOrganizacionService service;
	
	@GetMapping
	public ResponseEntity<List<ParamTipoOrganizacion>> listar(){
		return ResponseEntity.ok(service.ListarTodos());
	}
	@GetMapping("/{id}")
	public ResponseEntity<ParamTipoOrganizacion> obtenerPorId(
			@PathVariable  Long id){
		return service.obtenerPorId(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
		
	}
	
	
	

}
