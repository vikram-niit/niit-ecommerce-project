package com.niit.shoppingcart.dao;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.Employee;  

@Transactional
@Repository("EmployeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO{  
	
	@Autowired 
	SessionFactory sessionFactory;
	
	@Autowired
	HibernateTemplate template;
	
	public EmployeeDAOImpl() {
		
	}
	
	public EmployeeDAOImpl(HibernateTemplate template) {
		super();
		this.template = template;
	}
	
  
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	//method to save employee
	public void saveEmployee(Employee e){  
		try {
			template.save(e);
		} catch (HibernateException e2) {
			System.out.println(e2);
		}
	      
	}  
	//method to update employee  
	public void updateEmployee(Employee e){  
		try {
			template.update(e);
			sessionFactory.getCurrentSession().update(e);
		} catch (HibernateException e2) {
			System.out.println(e2);
		}	    
	}  
	//method to delete employee  
	public void deleteEmployee(Employee e){  
		try {
			 template.delete(e);
		} catch (HibernateException e2) {
			System.out.println(e2);
		}
	     
	}  
	//method to return one employee of given id  
	public Employee getById(int id){
		Employee e = null;
		try {
			e=(Employee)template.get(Employee.class,id);  
		    
		} catch (HibernateException e1) {
			System.out.println(e1);
		}
		
		return e;  
	    
	}  
	//method to return all employees  
	public List<Employee> getEmployees(){  
		
		List<Employee> list = null;
		
		try {
			list=new ArrayList<Employee>();  
		    list=template.loadAll(Employee.class);  
		     
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return list; 
	    
	}  
}  