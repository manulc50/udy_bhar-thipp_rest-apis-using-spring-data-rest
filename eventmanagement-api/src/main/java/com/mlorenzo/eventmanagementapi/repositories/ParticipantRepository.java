package com.mlorenzo.eventmanagementapi.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.mlorenzo.eventmanagementapi.entities.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {
	
	Participant findByEmail(String email);

}
