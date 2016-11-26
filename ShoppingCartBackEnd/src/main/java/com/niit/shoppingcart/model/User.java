package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="user")
@Component
public class User {

	@javax.persistence.Id
	//@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer Id;
	private String username;
	private String email;
	
	private String password;
	private Integer mobile;
	private String address;	
	private Boolean enabled;
//	private String role;
	
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
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
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getMobile() {
		return mobile;
	}
	public void setMobile(Integer mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	@Override
	public String toString() {
		return "User [Id=" + Id + ", username=" + username + ", email=" + email + ", password=" + password + ", mobile="
				+ mobile + ", address=" + address + "]";
	}
	@Override
	public boolean equals(Object obj) {

		User user = (User) obj;
		
		if(this.getId().equals(user.getId()))
			return true;
		return false;
			
	}
	
}
