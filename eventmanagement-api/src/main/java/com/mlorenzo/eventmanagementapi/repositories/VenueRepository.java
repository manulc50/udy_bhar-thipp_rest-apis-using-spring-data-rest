package com.mlorenzo.eventmanagementapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mlorenzo.eventmanagementapi.entities.Venue;

public interface VenueRepository extends CrudRepository<Venue, Long> {
	
	List<Venue> findByPostalCode(@Param(value = "postalCode") String pc);

}
