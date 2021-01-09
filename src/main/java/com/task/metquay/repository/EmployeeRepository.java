package com.task.metquay.repository;

import org.springframework.data.repository.CrudRepository;

import com.task.metquay.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
