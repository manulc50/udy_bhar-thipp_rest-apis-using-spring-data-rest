package com.mlorenzo.eventmanagementapi.entities;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


// Con esta anotación, podemos cambiar el orden de las propiedades de los recursos de esta clase en las respuestas de las peticiones http
// Por defecto, el orden que se usa se corresponde con el orden en que se declaran las propiedades en la clase
@JsonPropertyOrder({"started", "resourceId"}) // En este caso en concreto, "started" y "resourceId" se mostrarán en primer lugar y después de mostrarán las siguientes propiedades en función del orden de su declaración dentro de la clase
@Entity
@Table(name = "events")
public class Event extends AbstractEntity {

	private String name;
	
	@JsonProperty("desc") // Anotación para modificar el nombre de una propiedad a la hora de serializar a un Json o deserializar a un objeto de esta clase entidad. Esta anotación hace que la propiedad sea la última en aparecer en las respuestas de las peticiones http
	private String description;
	
	private ZonedDateTime startTime;
	private ZonedDateTime endTime;
	private ZoneId zoneId;
	private Boolean started;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Organizer organizer;
	
	@OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Participant> participants;
	
	@ManyToOne
	private Venue venue;
	
	// Para mostrar los ids de los recursos en las respuestas de las peticiones http
	public Long getResourceId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ZonedDateTime getStartTime() {
		return startTime;
	}
	
	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}
	
	public ZonedDateTime getEndTime() {
		return endTime;
	}
	
	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}
	
	public ZoneId getZoneId() {
		return zoneId;
	}
	
	public void setZoneId(ZoneId zoneId) {
		this.zoneId = zoneId;
	}
	
	public Boolean getStarted() {
		return started;
	}
	
	public void setStarted(Boolean started) {
		this.started = started;
	}

	public Organizer getOrganizer() {
		return organizer;
	}

	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}

	public Set<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<Participant> participants) {
		this.participants = participants;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(!(obj instanceof Event))
			return false;
		
		return Objects.equals(((Event)obj).getId(), id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
	
}
