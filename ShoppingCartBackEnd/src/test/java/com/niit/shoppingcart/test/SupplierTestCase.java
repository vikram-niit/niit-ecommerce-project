package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

public class SupplierTestCase {

	@Autowired
	SupplierDAO supplierDao;
	
	@Autowired
	Supplier s;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		/*context.refresh();
		context.scan("com.niit.shoppingcart");*/
		
		supplierDao = (SupplierDAO) context.getBean("SupplierDAO");
		s = (Supplier)context.getBean(Supplier.class);
		
				
	}
	
	@Test
	public void getSupplier(){
		int id = 111;
		Supplier temp = supplierDao.getSupplierById(id);
		
		if(temp==null){
			temp = new Supplier();
			temp.setId(id);
			temp.setSupplierName("Supplier Name");			
			supplierDao.saveSupplier(temp);
		}
		
		Assert.assertNotNull("Get Supplier id", supplierDao.getSupplierById(id));
		
		
	}
	
	@Test
	public void createSupplier(){
		
		int id = 1001;
		Supplier temp = supplierDao.getSupplierById(id);
		
		while(temp!=null)
		{			
			id+=1;
			temp = supplierDao.getSupplierById(id);
			System.out.println(id);
			System.out.println("temp="+temp);
		}
		
		s.setId(id);
		
		supplierDao.saveSupplier(s);
		
		Assert.assertNotNull("Create Supplier", supplierDao.getSupplierById(id));
	}
	
	@Test
	public void deleteSupplier(){
		
		int id=2000;
		
		Supplier temp = supplierDao.getSupplierById(id);
		
		if(temp != null){
			supplierDao.deleteSupplier(temp);	
			Assert.assertNull("delete Supplier", supplierDao.getSupplierById(id));
		}
		else
		{
			// creates a record with the id and then delete
			s.setId(id);
			
			supplierDao.saveSupplier(s);
			temp = supplierDao.getSupplierById(id);
			
			//checks whether record is created before deleting
			Assert.assertNotNull(supplierDao.getSupplierById(id));
			// deletes the record
			supplierDao.deleteSupplier(temp);
			//checks whether record is deleted 
			Assert.assertNull(supplierDao.getSupplierById(id));
			
		}
	}
	
	
	@Test
	public void updateSupplier(){
		int id=3000;
		
		// update the Supplier
		Supplier temp = supplierDao.getSupplierById(id);
		//Assert.assertNotNull("check Supplier exists", temp);
		if(temp != null){
			temp.setSupplierName("updated name "+id);
			supplierDao.updateSupplier(temp);
			
			Assert.assertEquals(temp, supplierDao.getSupplierById(id));
		}
		else
		{
			// creates a record with the id and then update
			s.setId(id);
			
			supplierDao.saveSupplier(s);
			temp = supplierDao.getSupplierById(id);
			
			//checks whether record is created before deleting
			Assert.assertNotNull(supplierDao.getSupplierById(id));
			// updates the record
			temp.setSupplierName("updated name "+id);
			supplierDao.updateSupplier(temp);
			//checks whether record is updated
			Assert.assertEquals(temp, supplierDao.getSupplierById(id));
		}
	}

	@Test
	public void getSupplierList() {
		List<Supplier> list = supplierDao.getCategories();
		System.out.println(list+" list-size="+list.size());
		
		
		Assert.assertNotNull("Get Supplier", list);
		
		//Assert.assertEquals(10, SupplierDao.getSuppliers().size());
	}

}
