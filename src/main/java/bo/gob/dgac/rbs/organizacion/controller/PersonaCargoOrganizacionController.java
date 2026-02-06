package bo.gob.dgac.rbs.organizacion.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bo.gob.dgac.rbs.organizacion.dto.PersonaCargoResponseDTO;
import bo.gob.dgac.rbs.organizacion.dto.PersonalCargoRequestDto;
import bo.gob.dgac.rbs.organizacion.modelo.Persona;
import bo.gob.dgac.rbs.organizacion.service.OrganizacionCargoPersonaService;
import bo.gob.dgac.rbs.organizacion.service.PersonasCargoService;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("organizacion-cargo-persona")
@RequiredArgsConstructor
public class PersonaCargoOrganizacionController {

	   private final PersonasCargoService service;
	   private final OrganizacionCargoPersonaService organizacionService;
	   
	   @PostMapping
	   public ResponseEntity<?> crear(@RequestBody PersonalCargoRequestDto dto ){
		     Persona  creado =  service.guardarOrganizacionCargoPersona(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
        		"id", creado.getId(), "mesaje","La persona fue creado"));
        		
	   }
	   
	   /*@GetMapping("/persona-cargo/{orgId}")
	   public ResponseEntity<List<PersonaCargoDto>> listarPersonaCargo(@PathVariable Long orgId){
		   List<PersonaCargoDto> lista = service.listarPersonaYCargo(orgId);
		   return ResponseEntity.ok(lista);
		   
	   }*/
	   
	    @GetMapping("/{orgId}")
	   public ResponseEntity<List<PersonaCargoResponseDTO>> listarPersonaCargo(@PathVariable Long orgId){
		   return ResponseEntity.ok(organizacionService.listarPersonasOrganizacion(orgId));
		   
	   }
	   
	    
	   
	   
	   
}
