package com.websystique.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.websystique.springmvc.domain.Addresses;
import com.websystique.springmvc.interfaces.IAddressesService;

@RestController
public class AddressesController {

	@Autowired
	private IAddressesService service;

	@RequestMapping("/listAllAddresses")
	public List<Addresses> listAll() {
		List<Addresses> list = service.listAll();
		return list;
	}

	@RequestMapping("/findAddress/{id}")
	public ResponseEntity<Addresses> find(@PathVariable String id) {
		Integer intId = null;
		try {
			intId = Integer.valueOf(id);
			Addresses address = service.findById(intId);
			return new ResponseEntity<Addresses>(address, HttpStatus.OK);
		} catch (NumberFormatException e) {
			return new ResponseEntity<Addresses>(HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Addresses>(HttpStatus.NOT_FOUND);
		}
	}
}
