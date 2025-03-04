package com.kaganozdamar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaganozdamar.model.Employee;
import com.kaganozdamar.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployeeList() {
		return employeeRepository.getAllEmployees();
	}

	public Employee getEmployeeById(String id) {
		return employeeRepository.getEmployeeById(id);
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		return employeeRepository.getEmployeeWithParams(firstName, lastName);
	}
	
	public Employee addEmployee(Employee newEmployee) {
		return employeeRepository.addEmployee(newEmployee);
	}
	
	public boolean deleteEmployee(String id) {
		return employeeRepository.deleteEmployee(id);
	}
	
	public boolean updateEmployee(String id, Employee updatedEmployee) {
		return employeeRepository.updateEmployee(id, updatedEmployee);
	}
}
