package com.example.crud.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.model.Employee;
import com.example.crud.repository.EmployeeRepository;
import com.example.crud.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if (employee.isPresent()) {
//			return employee.get();
//		} else {
//			throw new ResourceNotFoundException("Employee", "Id",id);
//		}
		return employeeRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Employee", "Id", id));
	}
	
	//update employee
	@Override
	public Employee updateEmployee(Employee employee, long id) {
		//we need to check i the employee with the given id exists in the Database or not.
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Employee", "Id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		//save existing employee to database
		employeeRepository.save(existingEmployee);
		
		return existingEmployee;
	}
	
	@Override
	public void deleteEmployee(long id) {
		//check whether a employee exist in a Database
		employeeRepository.findById(id).orElseThrow(() -> 
				new ResourceNotFoundException("Employee", "Id", id));
		employeeRepository.deleteById(id);
	}
	
	
	
	
	
}
