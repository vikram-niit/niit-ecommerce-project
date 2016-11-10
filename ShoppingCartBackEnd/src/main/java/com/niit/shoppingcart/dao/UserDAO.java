package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.User;

public interface UserDAO {

	public void saveUser(User user);
	public User getUserById(int id);
	public void updateUser(User user);
	public void deleteUser(User user);
	public List<User> getUsers();
}
