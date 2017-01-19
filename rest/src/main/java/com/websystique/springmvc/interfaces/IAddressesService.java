package com.websystique.springmvc.interfaces;

import java.util.List;

import com.websystique.springmvc.domain.Addresses;

public interface IAddressesService {
	List<Addresses> listAll();
	Addresses findById(Integer id);
}
