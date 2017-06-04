package com.ulyssys.hw.ejb.beans;

import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.UserDAO;
import com.ulyssys.hw.jpa.entity.User;

@Stateless
public class UserDAOImp extends GenericDAOImp<User> implements UserDAO {

    public UserDAOImp() {
    	super(User.class);
    }

}
