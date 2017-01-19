package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.domain.Employee;
import com.websystique.springmvc.interfaces.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@RequestMapping("/listAllEmployees")
	public List<Employee> listAll() {
		List<Employee> list = service.listAll();
		return list;
	}

	@RequestMapping("/findEmployee/{id}")
	public ResponseEntity<Employee> find(@PathVariable String id) {
		Integer intId = null;
		try {
			intId = Integer.valueOf(id);
			Employee employee = service.findById(intId);
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (NumberFormatException e) {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
	}
	@RequestMapping(value="/saveEmployee/", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> save(@RequestBody Employee employee) {
		try {
			Integer id = service.save(employee);
			return new ResponseEntity<Integer>(id, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}