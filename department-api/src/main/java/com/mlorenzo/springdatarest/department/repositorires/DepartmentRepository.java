package com.mlorenzo.springdatarest.department.repositorires;

import org.springframework.data.repository.CrudRepository;

import com.mlorenzo.springdatarest.department.entities.Department;


public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
