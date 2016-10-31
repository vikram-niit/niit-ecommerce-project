package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer Id;
	private String name;
	private String password;
	private String role;
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", password=" + password + ", role=" + role + "]";
	}
	
	
}