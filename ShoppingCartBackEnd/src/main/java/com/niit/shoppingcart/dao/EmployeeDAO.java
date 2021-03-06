package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.niit.shoppingcart.Employee;


public interface EmployeeDAO {

	    //method to save employee
		public void saveEmployee(Employee e);
	
		//method to update employee  
		public void updateEmployee(Employee e);
		
		//method to delete employee  
		public void deleteEmployee(Employee e);
		
		//method to return one employee of given id  
		public Employee getById(int id);
		
		//method to return all employees  
		public List<Employee> getEmployees();
}
