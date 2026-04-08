package com.ibm.demo.jdbc.dao;

import com.ibm.demo.jdbc.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Create table
	public void createTable() {
		jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS employee (" + "id INT PRIMARY KEY, " + "name VARCHAR(50), "
				+ "salary DOUBLE)");
	}

	// Insert
	public void insert(Employee emp) {
		String sql = "INSERT INTO EMPLOYEE VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, emp.getId(), emp.getName(), emp.getSalary());
	}

	// Fetch all
	public List<Employee> getAll() {
		String sql = "SELECT * FROM EMPLOYEE";

		RowMapper<Employee> mapper = (rs, rowNum) -> new Employee(rs.getInt("id"), rs.getString("name"),
				rs.getDouble("salary"));

		return jdbcTemplate.query(sql, mapper);
	}
}