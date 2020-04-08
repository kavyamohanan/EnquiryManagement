package com.enquiry.pro.model;


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
	private Qualification qualificationId;
	
	@ManyToOne
	@JoinColumn(name="registrationId")
	private Registration registrationId;*/
	private Integer qualificationId;
	private Integer  registrationId; 
	
	private String institution;
	private Integer mark;
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
		return qualificationId;
	}

	public void setQualification(Qualification qualificationId) {
		this.qualificationId = qualificationId;
	}

	public Registration getRegistration() {
		return registrationId;
	}

	public void setRegistration(Registration registrationId) {
		this.registrationId = registrationId;
	}*/

	public Integer getMark() {
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

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getYearOfPass() {
		return yearOfPass;
	}

	public void setYearOfPass(Integer yearOfPass) {
		this.yearOfPass = yearOfPass;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
		
}
