package bo.gob.dgac.rbs.organizacion.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.dto.AeronavesRequestDto;
import bo.gob.dgac.rbs.organizacion.service.AeronavesService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("aeronaves")
@RequiredArgsConstructor
public class AeronavesController {
	
	private final AeronavesService service;
	
	@PostMapping
	public ResponseEntity<?>  guardar(@RequestBody AeronavesRequestDto dto){
		service.guardarAeronaves(dto);
		return ResponseEntity.ok("Se Guardo Correctamente");
		
	}
	

}
