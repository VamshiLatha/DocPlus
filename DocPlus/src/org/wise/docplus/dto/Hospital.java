package org.wise.docplus.dto;

import java.util.Date;

public class Hospital {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public String getSurveyNumber() {
		return surveyNumber;
	}
	public void setSurveyNumber(String surveyNumber) {
		this.surveyNumber = surveyNumber;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public double getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}
	private int id;
	private Doctor doctor;
	private String name;
	private int contact;
	private String surveyNumber;
	private String street;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private Date startDate;
	private Date endDate;
	private double consultationFee;

//
//	
//	public int getHospitalId() {
//		return id;
//	}
//	public void setHospitalId(int id) {
//		this.id = id;
//	}
//	
//	public String getHospitalName() {
//		return name;
//	}
//	public void setHospitalName(String name) {
//		this.name = name;
//	}
//	public String getSurveyNumber() {
//		return surveyNumber;
//	}
//	public void setSurveyNumber(String surveyNumber) {
//		this.surveyNumber = surveyNumber;
//	}
//	public String getStreet() {
//		return street;
//	}
//	public void setStreet(String street) {
//		this.street = street;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getCountry() {
//		return country;
//	}
//	public void setCountry(String country) {
//		this.country = country;
//	}
//	public String getPincode() {
//		return pincode;
//	}
//	public void setPincode(String pincode) {
//		this.pincode = pincode;
//	}
//	public Date getStartDate() {
//		return startDate;
//	}
//	public void setStartDate(Date startDate) {
//		this.startDate = startDate;
//	}
//	public Date getEndDate() {
//		return endDate;
//	}
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
//	public double getConsultationFee() {
//		return consultationFee;
//	}
//	public void setConsultationFee(double consultationFee) {
//		this.consultationFee = consultationFee;
//	}
//	
//	@Override
//    public String toString() {
//    	return "Hospital [id = "+id+", Doctor_id =" + doctor.getId() + ", Hospital_name =" + name + ", contact =" + contact + ", Survey_number=" + surveyNumber + ", Street =" + street + ", city =" + city + ",Pincode =" + pincode +", State =" + state +",Country =" + country + ", Start_date =" + startDate +", End_date =" + endDate +",Consultation_fee =" + consultationFee +"]";
//    	
//   }
//	public int getDoctorId() {
//		return doctor.getId();
//	}
//	public void setDoctorId(int doctorId) {
//		this.doctor.setId(doctorId);
//
//	}
//	public int getContact() {
//		return contact;
//	}
//	public void setContact(int contact) {
//		this.contact = contact;
//	}
//	public String getState() {
//		return state;
//	}
//	public void setState(String state) {
//		this.state = state;
//	}

	
}
