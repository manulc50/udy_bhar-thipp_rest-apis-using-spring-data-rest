package com.mlorenzo.eventmanagementapi.repositories;

import java.time.ZoneId;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.mlorenzo.eventmanagementapi.entities.Event;
import com.mlorenzo.eventmanagementapi.entities.projections.PartialEventProjection;

// Anotación requerida si vamos a usar Excerpts(proyecciones que se aplican a colecciones de recursos)
// Ahora, se aplicara automáticamente la proyección de la clase "PartialEventProjection" a los endpoints expuestos por Spring Data REST para este repositorio que devuelven colecciones de eventos
@RepositoryRestResource(excerptProjection = PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	
	//List<Event> findByName(String name);
	
	// Para añadir paginación a la consulta
	Page<Event> findByName(String name, Pageable pageable);
	
	Page<Event> findByNameAndZoneId(@Param(value = "name") String nombre, @Param(value = "zoneId") ZoneId zona, Pageable pageable);

	// Method Level Security
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	void deleteById(Long id);

	// Method Level Security
	// POST, PUT, PATCH
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	<S extends Event> S save(S entity);
	
	
	
	

}
