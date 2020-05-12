package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmpController {

	// Dependency of Service Interface
	@Autowired
	private EmployeeService employeeService;

//	List of all Employees
	@GetMapping("/list")
	public List<Employee> listEmployees() {
		return employeeService.getEmployees();
	}

//	Find Employee by id
	@GetMapping("/list/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee not found");
		}
		return employee;
	}

	// Saving Employee
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}

	// Update Employee
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}

//	Delete Employee by id
	@DeleteMapping("/delete/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = employeeService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee not found");
		}
		employeeService.delete(employeeId);
		return " Deleted Employee id : " + employeeId;
	}

}
