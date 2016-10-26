package com.niit.shoppingcart;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App4 
{
	
	private static Configuration cfg;
	private static Employee emp;
    public static void main( String[] args )
    {
    	cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        
        // Create new employee object
        Employee emp = new Employee();
        emp.setEid(11);
        emp.setName("cccc");
        emp.setSalary(50000);
        
        
       // addEmployee();
        emp = getEmployee(11);
        System.out.println(emp);
        
        listEmployees();
        
       // deleteEmployee(1);
        //updateEmployee(1);
        
        listEmployees();
    }
    
    private static void updateEmployee(int empid) {
    	SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        
        
        Transaction t = session.beginTransaction();
        emp = (Employee) session.get(Employee.class, empid);
        emp.setName("newName");
        session.update(emp);
        
       
        t.commit();
        session.close();

		
	}

	private static void deleteEmployee(int eid) {
    	 SessionFactory factory = cfg.buildSessionFactory();
         Session session = factory.openSession();
         
         
         
         Transaction t = session.beginTransaction();
        emp = (Employee) session.get(Employee.class, eid);
        session.delete(emp);
         
        
         t.commit();
         session.close();

		
	}

	private static void addEmployee() {
    	 SessionFactory factory = cfg.buildSessionFactory();
         Session session = factory.openSession();
         
         // Create new employee object
         Employee emp = new Employee();
         emp.setEid(11);
         emp.setName("cccc");
         emp.setSalary(50000);
         
         Transaction t = session.beginTransaction();
         session.persist(emp);
         
        
         t.commit();
         session.close();

		
	}

	private static Employee getEmployee(int i) {
    	SessionFactory factory = cfg.buildSessionFactory();
    	Session session = factory.openSession();
    	
    	Transaction tx = session.beginTransaction();
    	Employee emp = (Employee)session.get(Employee.class, i);
    	
    	tx.commit();
    	session.close();    	
    	
        return emp;
		
	}

	public static void listEmployees(){
    	 SessionFactory factory = cfg.buildSessionFactory();
         Session session = factory.openSession();
         
         Transaction t = session.beginTransaction();
         
    	List employees = session.createQuery("FROM Employee").list(); 
        for (Iterator iterator = 
                          employees.iterator(); iterator.hasNext();){
           Employee employee = (Employee) iterator.next(); 
           System.out.println(employee);
           System.out.print("Eid: " + employee.getEid()); 
           System.out.print("  Name: " + employee.getName()); 
           System.out.println("  Salary: " + employee.getSalary()); 
        }
       
        
           
        t.commit();
        session.close();
    }
}
