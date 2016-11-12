/*package com.niit.shoppingcart.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.Employee;
import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.EmployeeDAO;
import com.niit.shoppingcart.dao.EmployeeDao3;



public class EmployeeTestCase {

	@Autowired
	EmployeeDao3 dao;
	
	@Autowired
	EmployeeDAO dao;
	
	@Autowired 
	AnnotationConfigApplicationContext context;

	@Autowired
	Employee e;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		//context.refresh();		
		//context.scan("com.niit.shoppingcart");
		dao = (EmployeeDAO) context.getBean("EmployeeDAO");		
		e = (Employee) context.getBean("employee");		
	}
	
	@Test
	public void getEmployee() {
		int id = 1;
		
		
		Employee emp = dao.getById(id);
		
		// creates a new employee if it does not exist
		if(emp == null){
			e.setEid(id);
			dao.saveEmployee(e);
			
			emp = dao.getById(id);			
		}
		
		Assert.assertNotNull("Get employee", emp);
	}
	
	@Test
	public void createEmployee(){
		
		int id = 1002;
		
		e.setEid(id);
		e.setName("name 20");
		e.setSalary(60000);
		
		Employee emp = dao.getById(id);
		
		// checks whether employee with the specified id does not exist already
		// if it exists increment the id
		while(emp != null)
		{
			id+=1;
			e.setEid(id);
			emp = dao.getById(id);
		}
				
		dao.saveEmployee(e);
		
		Assert.assertNotNull("Get employee", dao.getById(id));	
	}
	
	@Test
	public void deleteEmployee(){
		
		int id=2000;
		
		
		Employee emp = dao.getById(id);
		//Assert.assertNotNull("check employee exists", emp);
		
		if(emp != null){
			dao.deleteEmployee(emp);	
			Assert.assertNull("delete employee", dao.getById(id));
		}
		else
		{
			// creates a record with the id and then delete
			e.setEid(id);
			dao.saveEmployee(e);
			emp = dao.getById(id);
			
			//checks whether record is created before deleting
			Assert.assertNotNull(dao.getById(id));
			// deletes the record
			dao.deleteEmployee(emp);
			//checks whether record is deleted 
			Assert.assertNull(dao.getById(id));
			
		}
	}
	
	@Test
	public void updateEmployee(){
		int id=3000;
		
		// update the employee
		Employee emp = dao.getById(id);
		//Assert.assertNotNull("check employee exists", emp);
		if(emp != null){
			emp.setName("updated name "+id);
			dao.updateEmployee(emp);
			
			Assert.assertEquals(emp, dao.getById(id));
		}
		else
		{
			// creates a record with the id and then update
			e.setEid(id);
			dao.saveEmployee(e);
			emp = dao.getById(id);
			
			//checks whether record is created before deleting
			Assert.assertNotNull(dao.getById(id));
			// updates the record
			emp.setName("updated name "+id);
			dao.updateEmployee(emp);
			//checks whether record is updated
			Assert.assertEquals(emp, dao.getById(id));
		}
	}

	@Test
	public void getEmployeeList() {
		List<Employee> list = dao.getEmployees();
		System.out.println(list+" list-size="+list.size());
		
		
		Assert.assertNotNull("Get employee", list);
		
		//Assert.assertEquals(10, dao.getEmployees().size());
	}
}
*/