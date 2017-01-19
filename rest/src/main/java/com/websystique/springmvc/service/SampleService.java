package com.websystique.springmvc.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websystique.springmvc.domain.Employee;

@Service
public class SampleService {

	@Autowired
	private DataSource dataSource;

	public List<Employee> findAll() {
		String sql = "SELECT * FROM APP.EMPLOYEE ";
		Connection conn = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			conn = dataSource.getConnection();
			Statement ps = conn.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			while (rs.next()) {
				list.add(new Employee(rs.getInt("ID"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
						rs.getString("EMAIL")));
			}
			rs.close();
			ps.close();
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
