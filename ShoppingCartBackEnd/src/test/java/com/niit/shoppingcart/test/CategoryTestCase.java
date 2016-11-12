/*package com.niit.shoppingcart.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.config.AppConfig;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;



public class CategoryTestCase {

	@Autowired
	CategoryDAO categoryDao;
	
	@Autowired
	Category c;
	
	@Autowired
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init(){
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		context.refresh();
		context.scan("com.niit.shoppingcart");
		
		categoryDao = (CategoryDAO) context.getBean("CategoryDAO");
		c = (Category)context.getBean(Category.class);
		
				
	}
	
	@Test
	public void getCategory(){
		int id = 111;
		Category temp = categoryDao.getCategoryById(id);
		
		if(temp==null){
			temp = new Category();
			temp.setId(id);
			temp.setName("Category1");
			
			categoryDao.saveCategory(temp);
		}
		
		Assert.assertNotNull("Get Category id", categoryDao.getCategoryById(id));
		
		
	}
	
	@Test
	public void createCategory(){
		
		int id = 1001;
		Category temp = categoryDao.getCategoryById(id);
		
		while(temp!=null)
		{			
			id+=1;
			temp = categoryDao.getCategoryById(id);
			System.out.println(id);
			System.out.println("temp="+temp);
		}
		
		c.setId(id);
		
		categoryDao.saveCategory(c);
		
		Assert.assertNotNull("Create Category", categoryDao.getCategoryById(id));
	}
	
	@Test
	public void deleteCategory(){
		
		int id=2000;
		
		Category temp = categoryDao.getCategoryById(id);
		
		if(temp != null){
			categoryDao.deleteCategory(temp);	
			Assert.assertNull("delete Category", categoryDao.getCategoryById(id));
		}
		else
		{
			// creates a record with the id and then delete
			c.setId(id);
			
			categoryDao.saveCategory(c);
			temp = categoryDao.getCategoryById(id);
			
			//checks whether record is created before deleting
			Assert.assertNotNull(categoryDao.getCategoryById(id));
			// deletes the record
			categoryDao.deleteCategory(temp);
			//checks whether record is deleted 
			Assert.assertNull(categoryDao.getCategoryById(id));
			
		}
	}
	
	@Test
	public void updateCategory(){
		int id=3000;
		
		// update the Category
		Category temp = categoryDao.getCategoryById(id);
		//Assert.assertNotNull("check Category exists", temp);
		if(temp != null){
			temp.setName("updated name "+id);
			categoryDao.updateCategory(temp);
			
			Assert.assertEquals(temp, categoryDao.getCategoryById(id));
		}
		else
		{
			// creates a record with the id and then update
			c.setId(id);
			
			categoryDao.saveCategory(c);
			temp = categoryDao.getCategoryById(id);
			
			//checks whether record is created before deleting
			Assert.assertNotNull(categoryDao.getCategoryById(id));
			// updates the record
			temp.setName("updated name "+id);
			categoryDao.updateCategory(temp);
			//checks whether record is updated
			Assert.assertEquals(temp, categoryDao.getCategoryById(id));
		}
	}

	@Test
	public void getCategoryList() {
		List<Category> list = categoryDao.getCategories();
		System.out.println(list+" list-size="+list.size());
		
		
		Assert.assertNotNull("Get Category", list);
		
		//Assert.assertEquals(10, categoryDao.getCategorys().size());
	}

}
*/