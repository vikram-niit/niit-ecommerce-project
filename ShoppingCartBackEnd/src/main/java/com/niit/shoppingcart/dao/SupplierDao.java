package com.niit.shoppingcart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate4.HibernateTemplate;
import com.niit.shoppingcart.model.Supplier;

@Transactional
public class SupplierDao {

	public SupplierDao(HibernateTemplate template) {
		super();
		this.template = template;
	}
	HibernateTemplate template;  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	//method to save Supplier  
	public void saveSupplier(Supplier e){  
	    template.save(e);  
	}  
	//method to update Supplier  
	public void updateSupplier(Supplier e){  
	    template.update(e);  
	}  
	//method to delete Supplier  
	public void deleteSupplier(Supplier e){  
	    template.delete(e);  
	}  
	//method to return one Supplier of given id  
	public Supplier getById(int id){  
	    Supplier e=(Supplier)template.get(Supplier.class,id);  
	    return e;  
	}  
	//method to return all Suppliers  
	public List<Supplier> getSuppliers(){  
	    List<Supplier> list=new ArrayList<Supplier>();  
	    list=template.loadAll(Supplier.class);  
	    return list;  
	}  
}
