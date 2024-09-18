package com.mlorenzo.springdatarest.department;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.mlorenzo.springdatarest.department.entities.Department;


// Clase de configuración de Spring Data REST para exponer los ids de los objetos entidad "Department" en las respuestas de las peticiones http cuando éstos se serialicen a objetos Json

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Department.class);
	}
	
}
