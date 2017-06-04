package com.ulyssys.hw.facades.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.ulyssys.hw.jpa.entity.User;

@Local
public interface UserFacade {
	
	public User create(User user);
	public User update(User user);
	public void remove(int id);
	public User findUserById(int id);
	public List<User> findAll();
	
	

}
