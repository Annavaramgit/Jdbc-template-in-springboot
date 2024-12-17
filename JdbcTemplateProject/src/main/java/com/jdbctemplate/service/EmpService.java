package com.jdbctemplate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdbctemplate.model.Emp;
import com.jdbctemplate.repo.EmpRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmpService {

	@Autowired
	private EmpRepo empRepo;

	// save emp
	public String saveEmp(Emp emp) {
		log.info("service entered with emp :{}", emp);
		int i = empRepo.saveEmp(emp);
		if (i > 0) {
			return "saved";
		} else {
			return "not saved";
		}

	}

	public Emp getEmpById(int id) {
		
		log.info("getEmpById method in service :{}", id);
		Emp emp = empRepo.findEmpById(id);
		return emp;

	}
	
	public List<Emp> findAllEmployees(){
		log.info("service is entered for findallemployees");
		List<Emp> employees = empRepo.findAll();
		return employees;
	}

}
