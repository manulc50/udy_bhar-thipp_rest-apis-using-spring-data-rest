package com.mlorenzo.eventmanagementapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mlorenzo.eventmanagementapi.entities.Event;
import com.mlorenzo.eventmanagementapi.repositories.EventRepository;

// Controlador personalizado para Spring Data REST

/* Para aprovechar la configuración de Spring Data REST, los convertidores de mensajes, el manejo de excepciones y más,
   use la anotación @RepositoryRestController en lugar de las anotaciones @Controller o @RestController de Spring MVC estándar
 */

@RepositoryRestController // A diferencia de la anotación @RestController, esta anotación no incluye la anotación @ResponseBody
@ResponseBody
@RequestMapping("events")
public class EventKickOffController {
	
	@Autowired
	private EventRepository repository;
	
	@PostMapping("start/{id}")
	public String start(@PathVariable(name = "id") Long eventId) {
		Event event = repository.findById(eventId).orElseThrow(() -> new ResourceNotFoundException(String.format("Event with id %d not found", eventId)));
		event.setStarted(true);
		repository.save(event);
		return String.format("%s has started", event.getName());
	}

}
