package com.ulyssys.hw.facades;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.UserDAO;
import com.ulyssys.hw.facades.interfaces.UserFacade;
import com.ulyssys.hw.jpa.entity.User;

@Stateless
public class UserFacadeImp implements UserFacade {

	@EJB
	private UserDAO userDAO;
	
	@Override
	public User create(User user) {
		return userDAO.create(user);
	}

	@Override
	public User update(User user) {
		return userDAO.update(user);
	}

	@Override
	public void remove(int id) {
		userDAO.remove(id);
	}

	@Override
	public User findUserById(int id) {
		return userDAO.getById(id);
	}

	@Override
	public List<User> findAll() {
		return userDAO.findAll();
	}

	public User findByLogin(String login) {
		return userDAO.findByLogin(login);
		
	}
}
