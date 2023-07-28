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

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.UserService;
@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	UserService service;
	@Autowired

	UserRepository dao;
	@PostMapping("/saveuser")
	public ResponseEntity<?> saveUser(@RequestBody User user) {
		User u=dao.findByUsername(user.getUsername());
		if(u!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		else {
			dao.save(user);
			return ResponseEntity.ok(user);
		}
	}
	
	@GetMapping("/view")
	public List<User>findAll()
	{
		return service.findALL();
	}
	@GetMapping("customer/{id}")
	public ResponseEntity<User> getCustomerById(@PathVariable("id") int customerId) {
		return new ResponseEntity<User>(service.findUserById(customerId), HttpStatus.OK);
	}
	@PutMapping("/updatecustomer")
	public ResponseEntity<User> updateemp(@Valid @RequestBody User user) throws ResourceNotFoundException
	{
		
		return new ResponseEntity<User>(service.updateUser(user), HttpStatus.CREATED);
	}
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<Boolean> deleteuser(@Valid @PathVariable int id) throws ResourceNotFoundException
	{
		service.deleteCustomer(id);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	@PostMapping("/login")
	public ResponseEntity<User> login(@Valid @RequestBody User e) throws ResourceNotFoundException
	{
		return new ResponseEntity<User>(service.loginUser(e), HttpStatus.CREATED);
	}
}
