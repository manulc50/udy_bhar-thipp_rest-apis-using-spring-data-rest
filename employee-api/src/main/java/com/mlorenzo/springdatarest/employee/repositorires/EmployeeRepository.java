package com.mlorenzo.springdatarest.employee.repositorires;

import org.springframework.data.repository.CrudRepository;

import com.mlorenzo.springdatarest.employee.entities.Employee;


public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
