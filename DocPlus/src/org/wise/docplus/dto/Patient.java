package org.wise.docplus.dto;

import java.util.Date;

public class Patient {
	private int id;
	private String fullName;
	private Date dob;
	private String gender;
	private String email;
	private String userName;
	private String  password;
	private String houseNumber;
	private String street;
	private String city;
	private String state;
	private String country;
	private String contact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date date) {
		this.dob = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	 @Override
	    public String toString() {
	    	return "Patient [id=" + id + ", full_name=" + fullName + ", dob=" + dob + ", gender=" + gender + ", email=" + email + ", userName=" + userName + ", password=" + password + ", house_number=" + houseNumber +", street=" +street +",city=" + city + ", country=" + country + ", contact=" + contact +"]";
	    	
	   }
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
