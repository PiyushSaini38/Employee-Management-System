package com.employee.DAO;

import java.util.List;

import com.employee.entities.Employee;

public interface EmpDAO {

	List<Employee> getEmployees();

	Employee findById(int id);

	void save(Employee employee);

	void delete(int id);

}