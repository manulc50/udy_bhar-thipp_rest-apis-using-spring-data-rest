package com.mlorenzo.eventmanagementapi.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;


@MappedSuperclass
public class AbstractEntity {

	@Id
	@Column(nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@JsonIgnore // Para ignorar una propiedad en el momento de la serialización/deserialización
	@CreationTimestamp // Anotación que crea un timestamps con la fecha y hora actual antes de persistir un objeto entidad en la base de datos
	@Column(updatable = false)
	protected Instant created;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getCreated() {
		return created;
	}
	
	public void setCreated(Instant created) {
		this.created = created;
	}
	
}
