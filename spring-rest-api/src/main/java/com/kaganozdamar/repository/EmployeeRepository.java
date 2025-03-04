package com.kaganozdamar.repository;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kaganozdamar.model.Employee;

@Repository
public class EmployeeRepository {

	@Autowired
	private List<Employee> employeeList;

	public List<Employee> getAllEmployees() {

		return employeeList;
	}

	public Employee getEmployeeById(String id) {
		Employee foundEmployee = null;
		for (Employee employee : employeeList) {
			if (id.equals(employee.getId())) {
				foundEmployee = employee;
				break;
			}
		}
		return foundEmployee;
	}
	
	public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
		return employeeList.stream()
	            .filter(employee -> 
	                (firstName == null || firstName.equals(employee.getFirstName())) &&
	                (lastName == null || lastName.equals(employee.getLastName()))
	            )
	            .collect(Collectors.toList());
	}
	
	public Employee addEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
		
		return newEmployee;
	}
	
	public boolean deleteEmployee(String id) {
		if(id != null) {
			for (Iterator<Employee> iterator = employeeList.iterator(); iterator.hasNext();) {
				Employee employee = iterator.next();
				if(id.equals(employee.getId())) {
					iterator.remove();
					return true;
				}
			}
		}
		return false;
	}
	public boolean updateEmployee(String id, Employee updatedEmployee) {
		boolean isUpdated = employeeList.stream()
			.filter(employee -> employee.getId().equals(id))
			.findFirst()
			.map(employee -> {
				if(updatedEmployee.getFirstName() != null) {
					employee.setFirstName(updatedEmployee.getFirstName());
				}
				if(updatedEmployee.getLastName() != null) {
					employee.setLastName(updatedEmployee.getLastName());
				}
				return true;
			})
			.orElse(false);
		return isUpdated;
	}
}