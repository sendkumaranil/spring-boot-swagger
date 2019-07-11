package com.springboot.swagger.example.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.swagger.example.exception.ResourceNotFoundException;
import com.springboot.swagger.example.exception.SystemException;
import com.springboot.swagger.example.jpa.entities.Employee;
import com.springboot.swagger.example.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1")
@Api(value="Employee Management System")
public class EmployeeResource {

	@Autowired
	EmployeeService employeeService;
	
	@ApiOperation(value="View List of All Employees", response=List.class)
	@ApiResponses(value= {
				@ApiResponse(code=200,message="Successfully retrieved List"),
				@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			    @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			    @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
			}
			)
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employeeService.getAllEmployees();
	}
	
	@ApiOperation(value="View Specific Employee By Id", response=Employee.class)
	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@ApiParam(value = "Employee id from which employee object will retrieve", required = true) @PathVariable("empid") Integer empid) throws ResourceNotFoundException{
		Employee emp=employeeService.getEmployeeById(empid);
		
		return ResponseEntity.ok().body(emp);
	}
	
	@ApiOperation(value="Add a New Employee")
	@PostMapping("/employees")
	public Employee createEmployee(@ApiParam(value="Employee will be add to database", required=true) @Valid @RequestBody Employee employee) throws SystemException {
		
		return employeeService.createEmployee(employee);
	}
	
	@ApiOperation(value="Update Employee By EmpId", response=Employee.class)
	@PutMapping("/employees/{empid}")
	public Employee updateEmployee(@ApiParam(value="Update by this Employee ID",required=true) @PathVariable("empid") Integer empid,
			@ApiParam(value="Update this Employee",required=true) @Valid @RequestBody Employee emp) throws ResourceNotFoundException, SystemException {
		
		return employeeService.updateEmployee(empid, emp);
	}
	
	@ApiOperation(value="Delete Employee by EmpId",response=Employee.class)
	@DeleteMapping("/employees/{empid}")
	public Employee deleteEmployee(@ApiParam(value="Delete Employee by EmpId", required=true) @PathVariable("empid") Integer empid) throws ResourceNotFoundException, SystemException {
		return employeeService.deleteEmployee(empid);
	}
}
