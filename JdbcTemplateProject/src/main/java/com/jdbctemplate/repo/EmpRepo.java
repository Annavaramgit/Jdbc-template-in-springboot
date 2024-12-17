package com.jdbctemplate.repo;

import java.util.List;

import com.jdbctemplate.model.Emp;

public interface EmpRepo {
	
	public int saveEmp(Emp emp);
	public Emp findEmpById(int id);
	public List<Emp> findAll();
	

}
