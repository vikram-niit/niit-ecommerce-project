package com.niit.shoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Supplier")
@Component
public class Supplier {

	@Id
	private Integer id;
	private String supplierName;
	
	
	/*@ManyToMany(mappedBy="suppliers", fetch=FetchType.EAGER)
	private Set<Product> products;*/

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
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", supplierName=" + supplierName + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Supplier s = (Supplier)obj;
		
		if(this.getId().equals(s.getId()))
			return true;
		return false;		
	}

	/*public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}*/

		
	
}
