package com.websystique.springmvc.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springmvc.domain.Addresses;
import com.websystique.springmvc.interfaces.IAddressesService;

@Repository
@Transactional
public class AddressesService implements IAddressesService {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Addresses> listAll() {
		return sessionFactory.getCurrentSession().createCriteria(Addresses.class).list();
	}

	public Addresses findById(Integer id) {
		// TODO Auto-generated method stub
		return (Addresses) sessionFactory.getCurrentSession().get(Addresses.class, id);
	}

}
