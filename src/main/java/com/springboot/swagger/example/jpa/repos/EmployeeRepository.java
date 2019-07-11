package com.springboot.swagger.example.jpa.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.swagger.example.jpa.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
