package com.jobfinder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "companies")
public class Company{

	private int id;
	private String name;
	private int taxNumber;
	private String telephone;
	private String email;
	private String country;
	private String city;
	private String address;
	private int userId;
	
	private List<Job> jobs;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "tax_number")
	public int getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(int taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "user_id")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	@OneToMany(fetch=FetchType.EAGER,mappedBy="company", cascade = CascadeType.ALL)
	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public String toString(){
		String result = "";
		result +="id: "+id
				+" name: "+name
				+" tax number: "+taxNumber
				+" email: "+email
				+" address: "+address;
		return result;
	}
}
