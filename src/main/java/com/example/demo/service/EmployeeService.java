package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;

public interface EmployeeService 
{
	public List<Employee>findAll();
	public Employee addEmployee(Employee e) throws ResourceNotFoundException;
    public Employee findEmployee(int id) throws ResourceNotFoundException;
	public Employee updateEmployee(Employee e) throws ResourceNotFoundException;
	public String deleteById(int id);
	public List<Employee> getEmployeeByName(String ename);

}
