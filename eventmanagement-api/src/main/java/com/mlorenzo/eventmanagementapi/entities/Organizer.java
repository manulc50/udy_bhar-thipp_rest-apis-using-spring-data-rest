package com.mlorenzo.eventmanagementapi.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "organizers")
public class Organizer extends AbstractEntity {

	private String name;
	
	@OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Event> events;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
}
