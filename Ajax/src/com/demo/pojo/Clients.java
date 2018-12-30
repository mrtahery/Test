package com.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="CLIENTS")
public class Clients {

	@NotBlank(message="Username can not be blank")
	@Column(name="username")
	@Id 
	private String username;
	@Size(min=6 , max = 10 , message="Password must be between 6 and 10")
	private String password;
	private String gender;
	private String vehicle;
	private String country;
	private String image;
	public Clients() {
		
	}
	
	public Clients(String username, String password, String gender, String vehicle, String country, String image) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.vehicle = vehicle;
		this.country = country;
		this.image = image;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getVehicle() {
		return vehicle;
	}
	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}
