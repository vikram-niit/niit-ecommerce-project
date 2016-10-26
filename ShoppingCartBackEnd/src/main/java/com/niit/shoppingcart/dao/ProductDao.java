package com.niit.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import com.niit.shoppingcart.model.Product;


public class ProductDao {

	public ProductDao(HibernateTemplate template) {
		super();
		this.template = template;
	}
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	//method to save Product  
	public void saveProduct(Product e){  
	    template.save(e);  
	}  
	//method to update Product  
	public void updateProduct(Product e){  
	    template.update(e);  
	}  
	//method to delete Product  
	public void deleteProduct(Product e){  
	    template.delete(e);  
	}  
	//method to return one Product of given id  
	public Product getById(int id){  
	    Product e=(Product)template.get(Product.class,id);  
	    return e;  
	}  
	//method to return all Products  
	public List<Product> getProducts(){  
	    List<Product> list=new ArrayList<Product>();  
	    list=template.loadAll(Product.class);  
	    return list;  
	}  
}