package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Supplier;

public interface SupplierDAO {

	public void saveSupplier(Supplier s);
	public Supplier getSupplierById(int id);
	public void updateSupplier(Supplier s);
	public void deleteSupplier(Supplier s);
	public List<Supplier> getSuppliers();
	public Supplier getSupplierByName(String name);
}
