package com.example.crud.service;

import java.util.List;
import com.example.crud.model.Employee;

public interface EmployeeService {
	//for POST method
	Employee saveEmployee(Employee employee);
	//for GET method
	List<Employee> getAllEmployees();
	//for GET BY ID method
	Employee getEmployeeById(long id);
	//for UPDATE method
	Employee updateEmployee(Employee employee, long id);
	//for DELETE method
	void deleteEmployee(long id);
}
