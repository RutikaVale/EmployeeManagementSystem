package com.example.demo;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.entity.Employee;

@SpringBootTest
class EmployeeManagementSystemApplicationTests {

	@Autowired
	private EmployeeRepository dao;
	@Test
	void contextLoads() {
	}
	@Test
	public void testCreate() throws ParseException
	{
		Scanner sc=new Scanner(System.in);
	
	Employee p=new Employee();
	System.out.println("enter the date");
	 String hiredate = sc.next();
     //Converting String to Date
     Date date = FormattingDate.StringToDate(hiredate);
     System.out.println(date);
		p.setId(3253245);
		p.setEname("prathemesh");
		p.setDept_id(10);
		p.setJob("IT");
		p.setHiredate(date);
		p.setComm(3.4);
		p.setImage_path("xyz");
		p.setMgr(345);
		p.setSal(100000.0);
		dao.save(p);

}
}
