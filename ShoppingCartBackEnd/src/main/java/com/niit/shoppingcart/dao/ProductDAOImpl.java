package com.niit.shoppingcart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.Product;

@Transactional
@Repository("ProductDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private HibernateTemplate template;

	public ProductDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/*public ProductDAOImpl(HibernateTemplate template){
		super();
		this.template = template;
	}
	
	
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
*/
	public void saveProduct(Product p) {
		try {
			template.save(p);	
		} catch (HibernateException e) {
			System.out.println(e);
		}			
	}

	public Product getProductById(int id) {
		Product p = null;
		try {
			p = template.get(Product.class, id);		
			
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return p;		
	}
	
	
	public void updateProduct(Product p) {
		
		try {
			template.update(p);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		
	}

	public void deleteProduct(Product p) {
		try {
			template.delete(p);
		} catch (HibernateException ex) {
			System.out.println(ex);
		}		
	}

	public List<Product> getProducts() {
		
		List<Product> list = null;
		try {
			list = template.loadAll(Product.class);
		} catch (HibernateException ex) {
			System.out.println(ex);
		}
		
		return list;
	}

	public Product getProductByName(String name) {

		String query = "from Product where name="+name;
		Product p = (Product) template.find(query);
		
		return p;
	}
}
