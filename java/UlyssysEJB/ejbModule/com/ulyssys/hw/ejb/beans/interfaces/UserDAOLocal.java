package com.ulyssys.hw.ejb.beans.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.ulyssys.hw.jpa.entity.User;

@Local
public interface UserDAOLocal {

	public User create(User user);
	public User update(User user);
	public void remove(int userId);
	public User getUserById(int userId);
	public List<User> getAllUsers();
	
}
