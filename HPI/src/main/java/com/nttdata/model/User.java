package com.nttdata.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usres")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private long id;
	private String password;

	private String fullName;
	private String email;
	private String phone;
	private Date dob;
	private String maritalstatus;
	private String gender;
	private String address;

	private boolean enabled = true;

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", fullName=" + fullName + ", email=" + email + ", phone="
				+ phone + ", dob=" + dob + ", maritalstatus=" + maritalstatus + ", gender=" + gender + ", address="
				+ address + ", enabled=" + enabled + ", userRoles=" + userRoles + "]";
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	private Set<UserRole> userRoles = new HashSet<>();

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public User() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMaritalstatus() {
		return maritalstatus;
	}

	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

//	public User(long id, String password, String fullName, String email, String phone, boolean enabled) {
//		super();
//		this.id = id;
//		this.password = password;
//		this.fullName = fullName;
//		this.email = email;
//		this.phone = phone;
//		this.enabled = enabled;
//	}

	public User(long id, String password, String fullName, String email, String phone, Date dob, String maritalstatus,
			String gender, String address, boolean enabled, Set<UserRole> userRoles) {
		super();
		this.id = id;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
		this.dob = dob;
		this.maritalstatus = maritalstatus;
		this.gender = gender;
		this.address = address;
		this.enabled = enabled;
		this.userRoles = userRoles;
	}

}
