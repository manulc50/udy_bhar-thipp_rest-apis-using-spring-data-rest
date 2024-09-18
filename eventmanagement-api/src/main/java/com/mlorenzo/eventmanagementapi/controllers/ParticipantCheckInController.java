package com.mlorenzo.eventmanagementapi.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mlorenzo.eventmanagementapi.entities.Participant;
import com.mlorenzo.eventmanagementapi.exceptions.AlreadyCheckedInException;
import com.mlorenzo.eventmanagementapi.exceptions.NotCheckInException;
import com.mlorenzo.eventmanagementapi.repositories.ParticipantRepository;

// Controlador personalizado para Spring Data REST

/* Para aprovechar la configuración de Spring Data REST, los convertidores de mensajes, el manejo de excepciones y más,
   use la anotación @RepositoryRestController en lugar de las anotaciones @Controller o @RestController de Spring MVC estándar
*/

@RepositoryRestController // A diferencia de la anotación @RestController, esta anotación no incluye la anotación @ResponseBody
@RequestMapping("/participants")
public class ParticipantCheckInController {
	
	@Autowired
	private ParticipantRepository repository;
	
	// Nota: El argumento de entrada "assembler" de tipo "PersistentEntityResourceAssembler" nos permite convertir un objeto entidad en un recurso HAL(HATEOAS)
	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {
		Participant p = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Participant with id %d not found", id)));
		
		if(p.getCheckedIn())
			throw new AlreadyCheckedInException(String.format("Participant with id %d is already checked in", id));
		
		p.setCheckedIn(true);
		repository.save(p);
		
		return ResponseEntity.ok(assembler.toFullResource(p));
	}
	
	// Nota: El argumento de entrada "assembler" de tipo "PersistentEntityResourceAssembler" nos permite convertir un objeto entidad en un recurso HAL(HATEOAS)
	@PostMapping("/checkout/{id}")
	public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable Long id, PersistentEntityResourceAssembler assembler) {
		Participant p = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(String.format("Participant with id %d not found", id)));
	
		if(!p.getCheckedIn())
			throw new NotCheckInException(String.format("Participant with id %d is not checked in", id));
		
		p.setCheckedIn(false);
		repository.save(p);
		
		return ResponseEntity.ok(assembler.toFullResource(p));
	}

}
