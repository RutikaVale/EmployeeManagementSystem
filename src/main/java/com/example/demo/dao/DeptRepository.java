package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Dept;
@Repository
public interface DeptRepository extends JpaRepository<Dept, Integer> {

}
