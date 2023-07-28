package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class UserServiceImplementation implements UserService
{
@Autowired
UserRepository dao;
	@Override
	public ResponseEntity<?> saveUser(User user) {
		User u=dao.findByUsername(user.getUsername());
		if(u!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		else {
			dao.save(user);
			return ResponseEntity.ok(user);
	}
	}
	@Override
	public List<User> findALL() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer id not available"));
	}
	@Override
	public User updateUser(User e) throws ResourceNotFoundException {
		
		
			User existingUser=dao.findById(e.getEluser_id()).orElseThrow(()->new ResourceNotFoundException("id doesnot exist"));
					
			
		existingUser.setFirst_name(e.getFirst_name());
		existingUser.setLast_name(e.getLast_name());
		existingUser.setUser_address1(e.getUser_address1());
		existingUser.setUser_address1(e.getUser_address2());
		existingUser.setUsername(e.getUsername());
		existingUser.setUserpassword(e.getUserpassword());
		existingUser.setEluser_id(e.getEluser_id());
	
				return dao.save(e);
			}
	@Override
	public void deleteCustomer(int customerId) {
		dao.findById(customerId).orElseThrow(()->new ResourceNotFoundException("Customer id not available"));
		dao.deleteById(customerId);
		
	}
	@Override
	
	public User loginUser(User u) {
		User user = dao.findByUsername(u.getUsername());

		if (user.getUserpassword().equals(u.getUserpassword())) {
			User senduser=new User();
			senduser.setEluser_id(user.getEluser_id());
			senduser.setFirst_name(user.getFirst_name());
			senduser.setLast_name(user.getLast_name());
			senduser.setUser_address1(user.getUser_address1());
			senduser.setUser_address2(user.getUser_address2());
			senduser.setUsername(user.getUsername());
			return user;
		} else {
         throw new ResourceNotFoundException("not existing user");
	}
	}
}

