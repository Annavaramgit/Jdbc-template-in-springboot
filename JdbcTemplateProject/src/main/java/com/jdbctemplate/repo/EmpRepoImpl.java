package com.jdbctemplate.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbctemplate.model.Emp;
import com.jdbctemplate.repo.row_mapper.EmpRowMapper;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EmpRepoImpl implements EmpRepo {

	@Autowired
	private JdbcTemplate template;
	//rowmapper (it is for convert each row into object)
	EmpRowMapper row = new EmpRowMapper();

	//queries
	private static final String INSERT_EMPLOYEE = "INSERT INTO EMPSATYA(ID,NAME) VALUES(?,?)";
	private final static String GET_EMP_NAME_BY_ID = "SELECT * FROM EMPSATYA WHERE ID=?";
	private final static String GET_ALL_EMP = "SELECT * FROM EMPSATYA";

	@Override
	public int saveEmp(Emp emp) {
		log.info("repo entered in save method  with emp : {}", emp);
		try {
			log.info("try block:  {}", emp);
			return template.update(INSERT_EMPLOYEE, emp.getId(), emp.getName());

		} catch (Exception e) {
			System.out.println("error is : " + e.getMessage().toString());
		}
		return 0;

	}

	@Override
	public Emp findEmpById(int id) {

		

		log.info("getEmpById method : {}", id);

		try {
			log.info("getEmpById method try : {}", id);
			Emp queryForObject = template.queryForObject(GET_EMP_NAME_BY_ID, row, id);
			log.info("getEmpById method try for name: {}", queryForObject.getName());
			if (queryForObject != null) {
				return queryForObject;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("error is " + e.getMessage().toString());
		}
		return null;

	}

	@Override
	public List<Emp> findAll() {
		List<Emp> employees = template.query(GET_ALL_EMP, row);
		return employees;
	}

}
