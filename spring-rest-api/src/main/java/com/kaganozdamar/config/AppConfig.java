package com.kaganozdamar.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kaganozdamar.model.Employee;

@Configuration
public class AppConfig {
	@Bean
	public List<Employee> employeeList(){
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("1","John","Doe"));
		employeeList.add(new Employee("2","Jane","Doe"));
		employeeList.add(new Employee("3","Jack","Doe"));
		employeeList.add(new Employee("4","Johnny","Doe"));
		
		return employeeList;
	}
}
