package com.enquiry.pro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MultipleQualification {

	//instance variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mQualId;
	
	/*@ManyToOne
	@JoinColumn(name="qualificationId")
	private Qualification qualification;
	
	@ManyToOne
	@JoinColumn(name="registrationId")
	private Registration registration;*/
	private Integer qualificationId;
	private Integer  registrationId;
	
	private Double mark;
	private Integer yearOfPass;
	
	//default constructor
	public MultipleQualification() {
	
	}

	//getters and setters
	public Integer getmQualId() {
		return mQualId;
	}

	public void setmQualId(Integer mQualId) {
		this.mQualId = mQualId;
	}

	/*public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}*/

	public Double getMark() {
		return mark;
	}

	public Integer getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Integer qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Integer getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
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
		
}
