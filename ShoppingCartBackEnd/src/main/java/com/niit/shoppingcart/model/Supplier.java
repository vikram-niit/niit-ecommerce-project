package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Supplier")
public class Supplier {

	@Id
	private Integer id;
	private String supplierName;
	
	
	@ManyToMany(mappedBy="suppliers", fetch=FetchType.EAGER)
	private Set<Product> products;

	public Supplier() {
		// TODO Auto-generated constructor stub
	}
	public Supplier(int i, String string) {
		this.id = i;
		this.supplierName = string;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", supplierName=" + supplierName + ", products=" + products + "]";
	}	
	
}