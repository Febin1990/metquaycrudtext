package com.task.metquay.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.task.metquay.model.Employee;

@Service
public interface EmployeeService {

	void save(Employee employee);

	List<Employee> listallEmployee();

	Employee getedit(Long id);

	void deleteEmployeeById(Long id);

	void updateUserbyId(@Valid Employee employee);

}
