package com.mlorenzo.springdatarest.department.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// Nota: Por defecto, Sprig Data REST no expone los ids de los recursos directamente


@Entity
@Table(name = "departments")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // El tipo de estrategia por defecto es AUTO
	private Long id;
	
	private String name;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
