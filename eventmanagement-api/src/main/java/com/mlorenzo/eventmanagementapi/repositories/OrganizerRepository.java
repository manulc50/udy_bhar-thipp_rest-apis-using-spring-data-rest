package com.mlorenzo.eventmanagementapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mlorenzo.eventmanagementapi.entities.Organizer;

public interface OrganizerRepository extends CrudRepository<Organizer, Long> {

}
