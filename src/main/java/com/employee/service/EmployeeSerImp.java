package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.DAO.EmpDAO;
import com.employee.entities.Employee;

@Service
@Transactional
public class EmployeeSerImp implements EmployeeService {

	@Autowired
	private EmpDAO employeeDao;

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);
	}

}
