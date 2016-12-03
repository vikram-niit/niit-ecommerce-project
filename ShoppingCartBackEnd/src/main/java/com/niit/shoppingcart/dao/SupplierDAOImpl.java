package com.niit.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Supplier;

@Transactional
@Repository("SupplierDAO")
public class SupplierDAOImpl implements SupplierDAO{

	@Autowired
	private HibernateTemplate template;

	public void saveSupplier(Supplier c) {
		try {
			template.save(c);	
		} catch (HibernateException e) {
			System.out.println(e);
		}			
	}

	public Supplier getSupplierById(int id) {
		Supplier c = null;
		try {
			c = template.get(Supplier.class, id);		
			
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return c;		
	}

	public void updateSupplier(Supplier c) {
		
		try {
			template.update(c);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		
	}

	public void deleteSupplier(Supplier c) {
		try {
			template.delete(c);
		} catch (HibernateException ex) {
			System.out.println(ex);
		}		
	}

	public List<Supplier> getSuppliers() {
		
		List<Supplier> list = null;
		try {
			list = template.loadAll(Supplier.class);
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return list;
	}

	public Supplier getSupplierByName(String name) {

		String query = "from Supplier where supplierName=?";
		Object[] queryParams = {name};
		Supplier supplier = (Supplier) template.find(query, queryParams).get(0);
		
		return supplier;		
	}

}
