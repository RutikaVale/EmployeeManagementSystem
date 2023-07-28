package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="emp")
public class Employee 
{
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Employee name can not be empty")
	@Size(max = 20,message = "Employee name can't be more than 20 characters")
	@Size(min=2, message="Employee name must be more than 5 characters")
	@Column(name="ename")
	private String ename;
	@NotBlank(message = "job name can not be empty")
	@Size(max = 20,message = "job name can't be more than 20 characters")
	@Size(min=2, message="job name must be more than 5 characters")
	@Column(name="job")
	private String job;
	@NotNull(message = "mgr can not be null")
	@Column(name="mgr")
	private Integer mgr;
	@Column(name="hiredate")
	private Date hiredate;
	@NotNull(message = "Salary can not be null")
	@Max(value=100000, message ="Salary should not be greater than 10000" )
	@Min(value=1000, message="Salary must be greater than 1000")
	@Column(name="sal")
	private Double sal;
	@Column(name="comm")
	private Double comm;
	@NotNull(message = "dept_id can not be null")
	@Column(name="dept_id")
	private Integer dept_id;
	@Column(name="image_path")
	private String image_path;
	@ManyToOne(targetEntity=Dept.class,fetch=FetchType.EAGER)
	@JoinColumn(name="dept_id",insertable = false,updatable = false)
	private Dept dept;
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Employee()
	{
		
	}
	public Employee(int id, String ename, String job, Integer mgr, Date hiredate, Double sal, Double comm,
			Integer dept_id, String image_path) {
		super();
		this.id = id;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.dept_id = dept_id;
		this.image_path = image_path;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Integer getMgr() {
		return mgr;
	}
	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Double getSal() {
		return sal;
	}
	public void setSal(Double sal) {
		this.sal = sal;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Integer getDept_id() {
		return dept_id;
	}
	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}
	public String getImage_path() {
		return image_path;
	}
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}
	
}
