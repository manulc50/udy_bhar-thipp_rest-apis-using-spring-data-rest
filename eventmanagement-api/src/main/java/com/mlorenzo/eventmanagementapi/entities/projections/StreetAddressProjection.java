package com.mlorenzo.eventmanagementapi.entities.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.mlorenzo.eventmanagementapi.entities.Venue;

// Virtual Projection

/*
 Nota:
 For projection interfaces to be auto-discovered they need to be placed inside the very same or a sub-package of the package of the domain type they're bound to.
 If you can't put the type into that location, you can manually register a projection definition on RepositoryRestConfiguration by calling ….projectionConfiguration().addProjection(…)
*/

// Proyección para unir las propiedades "streetAddress" y "streetAddress2" en una única propiedad en las respuestas de las peticiones http asociadas a esta proyección

@Projection(name="virtual", types = {Venue.class})
public interface StreetAddressProjection {

	// Usamos la notación @Value junto con Spring Expression Language para indicar que las propiedades "streetAddress" y "streetAddress2" se unirán en la propiedad "completeStreetAddress" en las respuestas de las peticiones http asociadas a esta proyección
	// En este caso, "target" hace referencia a la clase entidad "Venue"
	@Value("#{target.streetAddress} #{target.streetAddress2}")
	String getCompleteStreetAddress();
}
