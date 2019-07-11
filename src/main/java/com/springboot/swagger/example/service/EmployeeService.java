package com.springboot.swagger.example.service;

import java.util.List;

import com.springboot.swagger.example.exception.ResourceNotFoundException;
import com.springboot.swagger.example.exception.SystemException;
import com.springboot.swagger.example.jpa.entities.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee getEmployeeById(Integer employeeId) throws ResourceNotFoundException;
	public Employee createEmployee(Employee employee) throws SystemException;
	public Employee updateEmployee(Integer empid,Employee emp) throws ResourceNotFoundException,SystemException;
	public Employee deleteEmployee(Integer empid) throws ResourceNotFoundException,SystemException;
}
