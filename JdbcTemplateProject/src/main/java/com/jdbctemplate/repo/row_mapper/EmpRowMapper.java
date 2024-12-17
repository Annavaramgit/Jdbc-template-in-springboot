package com.jdbctemplate.repo.row_mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbctemplate.model.Emp;

//rowmapper is used to convert each row into object
//if we want to get emp as object then we need to use this
public class EmpRowMapper implements RowMapper<Emp> {

	@Override
	public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
		Emp emp = new Emp();
		emp.setId(rs.getInt(1));
		emp.setName(rs.getString(2));
		return emp;
	}

}
