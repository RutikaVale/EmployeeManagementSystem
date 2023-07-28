package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;

public interface UserService 
{
	public ResponseEntity<?> saveUser(@RequestBody User user) ;
	public List<User>findALL();
	public User findUserById(int id);
	public User updateUser(User e) throws ResourceNotFoundException;
	public void deleteCustomer(int customerId);
	public User loginUser(User u);
} 
