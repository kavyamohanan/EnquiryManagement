package com.enquiry.pro.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
public class Photo {
	@Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
    
    @Column(name = "registration_id")
    private Integer registrationId;
    

    @Lob
    @Column(name = "pic")
    private byte[] pic;

    //Custom Construtor
    public Photo(String name, String type, byte[] pic) {
        this.name = name;
        this.type = type;
        this.pic = pic;
    }
   
	
	//constructor
	public Photo(String name, String type, byte[] pic,Integer registrationId) {
		
		this.name = name;
		this.type = type;
		this.registrationId = registrationId;
		this.pic = pic;
	}


	public Integer getRegistrationId() {
		return registrationId;
	}


	public void setRegistrationId(Integer registrationId) {
		this.registrationId = registrationId;
	}


}
