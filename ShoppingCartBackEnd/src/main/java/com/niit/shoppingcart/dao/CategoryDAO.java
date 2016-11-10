package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Category;

public interface CategoryDAO {
		
	public void saveCategory(Category c);
	public Category getCategoryById(int id);
	public void updateCategory(Category c);
	public void deleteCategory(Category c);
	public List<Category> getCategories();
}

