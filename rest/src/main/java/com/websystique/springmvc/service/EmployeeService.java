package com.websystique.springmvc.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.domain.Employee;
import com.websystique.springmvc.interfaces.IEmployeeService;

@Repository
@Transactional
public class EmployeeService implements IEmployeeService {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> listAll() {
		return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
	}
	public Employee findById(Integer id){
		return (Employee)sessionFactory.getCurrentSession().get(Employee.class,id);
	}
	public Integer save(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return 1;
	}
	
}
