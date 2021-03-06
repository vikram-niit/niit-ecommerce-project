package com.niit.shoppingcart.dao;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.niit.shoppingcart.Employee;  

@Transactional
public class EmployeeDao3 {  
	
	@Autowired
	private HibernateTemplate template;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public EmployeeDao3(HibernateTemplate template) {
		super();
		this.template = template;
		this.sessionFactory = sessionFactory;
	}
	
	//method to save employee
		public void saveEmployee(Employee e){  
		    template.save(e);  
		}  
		//method to update employee  
		public void updateEmployee(Employee e){  
		   template.update(e);
		//	sessionFactory.getCurrentSession().update(e);
		}  
		//method to delete employee  
		public void deleteEmployee(Employee e){  
		    template.delete(e);  
		}  
		//method to return one employee of given id  
		public Employee getById(int id){  
		    Employee e=(Employee)template.get(Employee.class,id);  
		    return e;  
		}  
		//method to return all employees  
		public List<Employee> getEmployees(){  
		    List<Employee> list=new ArrayList<Employee>();  
		    list=template.loadAll(Employee.class);  
		    return list;  
		}  
}  