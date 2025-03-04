package com.kaganozdamar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaganozdamar.model.Employee;
import com.kaganozdamar.services.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path = "/list")
	public List<Employee> getAllEmployeeList() {

		return employeeService.getAllEmployeeList();
	}

	@GetMapping(path = "/list/{id}")
	public Employee getEmployeeById(@PathVariable(required = true) String id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping(path = "/with-params")
	public List<Employee> getEmployeeWithParam(@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName) {
		return employeeService.getEmployeeWithParams(firstName, lastName);
	}
	
	@PostMapping("/add-employee")
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		return employeeService.addEmployee(newEmployee);
	}
	
	@DeleteMapping("/delete-employee/{id}")
	public boolean deleteEmployee(@PathVariable String id) {
		return employeeService.deleteEmployee(id);
	}
	
	@PutMapping("/update-employee/{id}")
	public boolean updateEmployee(@PathVariable String id, @RequestBody Employee updatedEmployee) {
		return employeeService.updateEmployee(id, updatedEmployee);
	}
	
	
}
