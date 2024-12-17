package com.jdbctemplate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbctemplate.model.Emp;
import com.jdbctemplate.service.EmpService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmpController {

	@Autowired
	private EmpService empService;

	@PostMapping("/save-emp")
	public ResponseEntity<String> saveEmp(@RequestBody Emp emp) {
		log.info("controller entered for save with emp: {}", emp);

		String saveEmp = empService.saveEmp(emp);
		return new ResponseEntity<String>(saveEmp, HttpStatus.CREATED);
	}

	//find employee by id
	@GetMapping("/get-emp-by-id/{id}")
	public ResponseEntity<Emp> getEmpById(@PathVariable("id") int id) {

		log.info("controller entered for get-emp-by-id with emp: {}", id);
		Emp emp = empService.getEmpById(id);

		if (emp != null) {
			return new ResponseEntity<Emp>(emp, HttpStatus.OK);
		}

		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}
	
	//find all employees
	@GetMapping("/allEmployees")
	public ResponseEntity<List<Emp>> findAllEmployees(){
		log.info("controller is entered for findallemployees");
		
		return new ResponseEntity<List<Emp>>(empService.findAllEmployees(), HttpStatus.OK);
		
	}

}
