package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {

	public void saveProduct(Product p);
	public Product getProductById(int id);
	public void updateProduct(Product p);
	public void deleteProduct(Product p);
	public List<Product> getProducts();
	public Product getProductByName(String name);
}
