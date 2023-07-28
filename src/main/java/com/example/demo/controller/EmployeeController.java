package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.EmployeeService;
@RestController
@RequestMapping("/emp")
public class EmployeeController
{
	@Autowired
	EmployeeService service;
	@GetMapping("/list")
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}
	@PostMapping("/addemp")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee e) throws ResourceNotFoundException
	{
		return new ResponseEntity<Employee>(service.addEmployee(e), HttpStatus.CREATED);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployee(@Valid @PathVariable int id) throws ResourceNotFoundException
	{
		return new ResponseEntity<Employee>(service.findEmployee(id), HttpStatus.CREATED);
	}
	@PutMapping("/updateemp/{id}")
	public ResponseEntity<Employee> updateemp(@Valid @RequestBody Employee e) throws ResourceNotFoundException
	{
		return new ResponseEntity<Employee>(service.updateEmployee(e), HttpStatus.CREATED);
	}
	@DeleteMapping("/deleteemp/{id}")
	public ResponseEntity<Boolean> deleteemp(@Valid @PathVariable int id) throws ResourceNotFoundException
	{
		service.deleteById(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	@GetMapping("/search/{ename}")
	public List<Employee> getEmployeeByEname(String ename)
	{
		//postTitle=postTitle.toLowerCase();
		return service.getEmployeeByName(ename);
	}
}
