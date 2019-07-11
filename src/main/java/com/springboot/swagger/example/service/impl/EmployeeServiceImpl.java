package com.springboot.swagger.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.swagger.example.dao.EmployeeDao;
import com.springboot.swagger.example.exception.ResourceNotFoundException;
import com.springboot.swagger.example.exception.SystemException;
import com.springboot.swagger.example.jpa.entities.Employee;
import com.springboot.swagger.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) throws ResourceNotFoundException {
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public Employee createEmployee(Employee employee) throws SystemException {
		return employeeDao.createEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Integer empid,Employee emp) throws ResourceNotFoundException,SystemException {
		return employeeDao.updateEmployee(empid,emp);
	}

	@Override
	public Employee deleteEmployee(Integer empid) throws ResourceNotFoundException,SystemException {
		return employeeDao.deleteEmployee(empid);
	}

}
