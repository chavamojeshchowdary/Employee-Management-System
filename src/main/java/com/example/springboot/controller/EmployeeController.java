package com.example.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Employee;
import com.example.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	
	//build create employee rest API
	//@RequestBody to convert JSON to java object
	//Using response entity because we can add  HTTp status,Body and header etc..in order to create complete entity 
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
		
	}
	
	
	//build GET employees rest API 
	@GetMapping
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	//Build get employee by id REST API
	//http://localhost:8080/api/employees/1
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(name="id") long employeeId) {
		
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
	}
	
	//Build Update Rest API by id
	//http://localhost:8080/api/employees/1
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee,@PathVariable("id") long id){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
	}
	
	//Build Delete By Id Employee API
	@DeleteMapping("{id}")
	public ResponseEntity<Employee> deleteEmployeeById(@PathVariable("id")long id){
		return new ResponseEntity<Employee>(employeeService.deleteEmployeeById(id),HttpStatus.OK);
	}
	
	
}
