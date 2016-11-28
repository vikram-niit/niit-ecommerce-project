package com.niit.shoppingcart.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="Product")
@Component
public class Product {

	@Id	
	private Integer id;	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="categoryId", referencedColumnName="id", nullable=false)
	private Category category;
	
	private String price;
	
	private String brand;
	
	private String description;
	
	@Transient
	private MultipartFile image;
	
	/*@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name="product_supplier", joinColumns={@JoinColumn(referencedColumnName="id")}
			, inverseJoinColumns={@JoinColumn(referencedColumnName="id")})
	private Set<Supplier> suppliers;*/
	
	

	@ManyToOne
	@JoinColumn(name="supplierId", referencedColumnName="id", nullable=false)
	private Supplier supplier;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	
	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	/*public Set<Supplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(Set<Supplier> suppliers) {
		this.suppliers = suppliers;
	}*/
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + ", brand="
				+ brand + ", description=" + description + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		
		Product p = (Product)obj;
		if(this.getId().equals(p.getId()))
			return true;
		else 
			return false;
		
	}
}
