package com.niit.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.exception.spi.TemplatedViolatedConstraintNameExtracter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Category;

@Transactional
@Repository("CategoryDAO")
public class CategoryDAOImpl implements CategoryDAO{

	@Autowired
	private HibernateTemplate template;

	public void saveCategory(Category c) {
		try {
			template.save(c);	
		} catch (HibernateException e) {
			System.out.println(e);
		}			
	}

	public Category getCategoryById(int id) {
		Category c = null;
		try {
			c = template.get(Category.class, id);		
			
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return c;		
	}

	public void updateCategory(Category c) {
		
		try {
			template.update(c);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		
	}

	public void deleteCategory(Category c) {
		try {
			template.delete(c);
		} catch (HibernateException ex) {
			System.out.println(ex);
		}		
	}

	public List<Category> getCategories() {
		
		List<Category> list = null;
		try {
			list = template.loadAll(Category.class);
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return list;
	}

	public Category getCategoryByName(String name) {
		
		String query = "from Category where name=?";
		Object[] queryParams = {name};System.out.println("Category list="+template.find(query, queryParams));
		Category c = (Category) template.find(query, queryParams).get(0);
		
		return c;		
	}
}
