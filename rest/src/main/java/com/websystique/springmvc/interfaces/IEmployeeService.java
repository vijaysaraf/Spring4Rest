package com.websystique.springmvc.interfaces;

import java.util.List;

import com.websystique.springmvc.domain.Employee;

public interface IEmployeeService {

	List<Employee> listAll();
	Employee findById(Integer id);
	Integer save(Employee employee);

}