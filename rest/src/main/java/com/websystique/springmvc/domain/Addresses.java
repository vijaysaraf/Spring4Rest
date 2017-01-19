package com.websystique.springmvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "ADDRESS", schema = "APP")
public class Addresses {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer id;
	@Column(name = "FIRST_LINE")
	private String firstLine;
	@Column(name = "SECOND_LINE")
	private String secondLine;
	@Column(name = "STATE")
	private String state;
	@Column(name = "CITY")
	private String city;
	@Column(name = "PIN_CODE")
	private String pinCode;
	@Column(name = "COUNTRY")
	private String country;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMPLOYEE_ID", nullable = false)
	@JsonIgnore
	private Employee employee;

	public Addresses() {
		super();
	}

	public Addresses(Integer id, String firstLine, String secondLine, String state, String city, String pinCode,
			String country) {
		super();
		this.id = id;
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.state = state;
		this.city = city;
		this.pinCode = pinCode;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Addresses [id=" + id + ", firstLine=" + firstLine + ", secondLine=" + secondLine + ", state=" + state
				+ ", city=" + city + ", pinCode=" + pinCode + ", country=" + country + ", [employee=" + employee + "]]";
	}

}
