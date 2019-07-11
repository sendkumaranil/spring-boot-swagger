package com.springboot.swagger.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springboot.swagger.example.dao.EmployeeDao;
import com.springboot.swagger.example.exception.ResourceNotFoundException;
import com.springboot.swagger.example.exception.SystemException;
import com.springboot.swagger.example.jpa.entities.Employee;
import com.springboot.swagger.example.jpa.repos.EmployeeRepository;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) throws ResourceNotFoundException {
		return employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee Not found for this Id:"+employeeId));
	}

	@Override
	public Employee createEmployee(Employee employee) throws SystemException{
		Employee emp=null;
		try {
			emp=employeeRepository.save(employee);
		}catch(Exception exp) {
			throw new SystemException(exp.getMessage());
		}
		return emp;
	}

	@Override
	public Employee updateEmployee(Integer empid,Employee emp) throws ResourceNotFoundException,SystemException {
		Employee employee=employeeRepository.findById(empid).orElseThrow(() -> new ResourceNotFoundException("Employee Not found for this Id:"+empid));
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setEmail(emp.getEmail());
		try{
			return employeeRepository.save(employee);
		}catch(Exception ex) {
			throw new SystemException(ex.getMessage());
		}
	}

	@Override
	public Employee deleteEmployee(Integer empid) throws ResourceNotFoundException,SystemException {
		Employee employee=employeeRepository.findById(empid).orElseThrow(() -> new ResourceNotFoundException("Employee Not found for this Id:"+empid));
		try {
			employeeRepository.delete(employee);
		}catch(Exception exp) {
			throw new SystemException(exp.getMessage());
		}
		
		return employee;
	}

}
