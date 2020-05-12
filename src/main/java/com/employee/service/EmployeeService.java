package com.employee.service;

import java.util.List;

import com.employee.entities.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();

	Employee findById(int id);

	void save(Employee employee);

	void delete(int id);

}
