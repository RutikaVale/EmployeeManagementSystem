package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class EmployeeServiceImpl implements EmployeeService
{
@Autowired
EmployeeRepository dao;
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Employee addEmployee(Employee e) throws ResourceNotFoundException
	{
		Employee existingemp=dao.findById(e.getId()).orElse(null);
		if(existingemp==null)
		{
			e.setEname(e.getEname());
			e.setJob(e.getJob());
			e.setMgr(e.getMgr());
			e.setHiredate(e.getHiredate());
			e.setSal(e.getSal());
			e.setComm(e.getComm());
			e.setDept_id(e.getDept_id());
			e.setImage_path(e.getImage_path());
			return dao.save(e);
		}
		else
		{
			throw new ResourceNotFoundException("employee data already exist");
		}

	}
	@Override
	public Employee findEmployee(int id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		return this.dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
	}
	@Override
	public Employee updateEmployee(Employee e) throws ResourceNotFoundException {
		Employee existingemp=dao.findById(e.getId()).orElseThrow(()->new ResourceNotFoundException("id doesnot exist"));
				
		
		existingemp.setEname(e.getEname());
		existingemp.setJob(e.getJob());
		existingemp.setMgr(e.getMgr());
		existingemp.setHiredate(e.getHiredate());
		existingemp.setSal(e.getSal());
		existingemp.setComm(e.getComm());
		existingemp.setDept_id(e.getDept_id());
		existingemp.setImage_path(e.getImage_path());
			return dao.save(e);
		}
	@Override
	public String deleteById(int id) {
		Employee exixtingid=dao.findById(id).orElseThrow(null);
		if(exixtingid!=null)
		{
			 dao.delete(exixtingid);
			 return "Delete success"+exixtingid;
		}
		else
		{
			throw new ResourceNotFoundException("delete id doesnot exists");
		}
		
	}
	@Override
	public List<Employee> getEmployeeByName(String ename) {
	
		return this.dao.findByEnameIgnoreCase(ename);
	}

	}


