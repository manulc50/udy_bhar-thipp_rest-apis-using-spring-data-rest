package com.mlorenzo.eventmanagementapi.entities.projections;

import org.springframework.data.rest.core.config.Projection;

import com.mlorenzo.eventmanagementapi.entities.Participant;

/*
 Nota:
 For projection interfaces to be auto-discovered they need to be placed inside the very same or a sub-package of the package of the domain type they're bound to.
 If you can't put the type into that location, you can manually register a projection definition on RepositoryRestConfiguration by calling ….projectionConfiguration().addProjection(…)
*/

// En este caso, esta proyección se aplica a objetos de la clase entidad "Participant"
// En este caso, esta proyección se aplica añadiendo a la uri el parámetro "projection" con el valor "participantPartial"(...?projection=participantPartial)


@Projection(name = "participantPartial", types = {Participant.class})
public interface PartialParticipantProjection {
	
	// Indicamos los métodos getter de las propiedades que queremos mostrar en las respuestas de las peticione http asociadas a esta proyección
	// Si alguna de estas propiedades está anotada con @JsonIgnore, también se mostrará en las respuestas de las peticione http correspondientes a esta proyección
	String getName();
	Boolean getCheckedIn();

}
