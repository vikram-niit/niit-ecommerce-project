package com.niit.shoppingcart.model;

import java.io.Serializable;

public class ShippingAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String addressline1;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	@Override
	public String toString() {
		return "ShippingAddress [addressline1=" + addressline1 + ", street=" + street + ", city=" + city + ", state="
				+ state + ", country=" + country + ", zipcode=" + zipcode + "]";
	}
	
	
	
}
