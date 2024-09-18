package com.mlorenzo.springdatarest.employee.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Nota: Por defecto, Sprig Data REST no expone los ids de los recursos directamente
//       Si queremos exponerlos en las respuestas de las peticiones http, una opción es implementar un nuevo método get que devuelva el id(En este caso, "getResourceId")


@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // El tipo de estrategia por defecto es AUTO
	private Long id;
	
	private String firstName;
	private String lastName;
	
	// Método get alternativo para exponer los ids en las respuestas de las peticiones http
	// Esto es debido a que por defecto Spring Data REST ignora el método get asociado a la propiedad anotada con @Id("getId"), a la hora de serializar los objetos Entidad a objetos Json, para no exponer los ids directamente
	public Long getResourceId() {
		return id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
