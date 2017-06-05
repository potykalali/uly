package com.ulyssys.hw.ejb.beans.interfaces;

import com.ulyssys.hw.jpa.entity.User;

public interface UserDAO extends GenericDAO<User> {
	
	public User findByLogin(String login);

}
