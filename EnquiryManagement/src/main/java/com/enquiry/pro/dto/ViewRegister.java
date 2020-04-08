package com.enquiry.pro.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.enquiry.pro.model.Course;

public class ViewRegister {
	
	//instance variables
	private Integer registrationId;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registrationDate;

	private String name;
	private String address;
	private String district;
	private String state;
	private Integer pincode;
	private String nationality;
	private String phone;
	private String gender;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dob;

	//@Column(unique = true)
	private String email;

	//@ManyToOne
	//@JoinColumn(name = "course_id")
	private Course courseId;
		
	//@Lob
	private byte[] photo;
	private String status;
	private Integer mQualId;
	private Integer qualificationId;
	private Double mark;
	private Integer yearOfPass;
	private Integer paymentId;	
	private String modeOfPayment;
	private String transactionId;
	public Integer getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Course getCourseId() {
		return courseId;
	}
	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getmQualId() {
		return mQualId;
	}
	public void setmQualId(Integer mQualId) {
		this.mQualId = mQualId;
	}
	public Integer getQualificationId() {
		return qualificationId;
	}
	public void setQualificationId(Integer qualificationId) {
		this.qualificationId = qualificationId;
	}
	public Double getMark() {
		return mark;
	}
	public void setMark(Double mark) {
		this.mark = mark;
	}
	public Integer getYearOfPass() {
		return yearOfPass;
	}
	public void setYearOfPass(Integer yearOfPass) {
		this.yearOfPass = yearOfPass;
	}
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getModeOfPayment() {
		return modeOfPayment;
	}
	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	
	

}
