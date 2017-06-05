package com.ulyssys.hw.ejb.beans;

import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.UserDAO;
import com.ulyssys.hw.jpa.entity.User;

@Stateless
public class UserDAOImp extends GenericDAOImp<User> implements UserDAO {

    public UserDAOImp() {
    	super(User.class);
    }

	@Override
	public User findByLogin(String login) {
		  Map<String, Object> parameters = new HashMap<String, Object>();
		  parameters.put("login", login); 
		 
		  return super.findOneResult(User.FIND_BY_LOGIN, parameters);
	}

}
