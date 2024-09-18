package com.mlorenzo.eventmanagementapi.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

// Con esta anotación, podemos cambiar el orden de las propiedades de los recursos de esta clase en las respuestas de las peticiones http
// Por defecto, el orden que se usa se corresponde con el orden en que se declaran las propiedades en la clase
@JsonPropertyOrder("resourceId") // En este caso en concreto, "resourceId" se mostrará en primer lugar y después de mostrarán las siguientes propiedades en función del orden de su declaración dentro de la clase
@Entity
@Table(name = "participants")
public class Participant extends AbstractEntity {

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String email;
	
	private Boolean checkedIn;
	
	@ManyToOne
	@JoinColumn(nullable = false, updatable = false)
	private Event event;
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		
		if(!(obj instanceof Participant))
			return false;
		
		return Objects.equals(((Participant)obj).getId(), id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
