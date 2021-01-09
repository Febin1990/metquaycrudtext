package com.task.metquay.services.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.task.metquay.model.Employee;
import com.task.metquay.repository.EmployeeRepository;
import com.task.metquay.services.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);		
	}

	@Override
	public List<Employee> listallEmployee() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee getedit(Long id) {	
		return employeeRepository.findById(id).get();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public void updateUserbyId(@Valid Employee employee) {
		employeeRepository.save(employee);
	}
	
	

}
