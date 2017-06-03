package com.ulyssys.hw.ejb.beans;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ulyssys.hw.ejb.beans.interfaces.UserDAOLocal;
import com.ulyssys.hw.ejb.beans.interfaces.UserDAORemote;
import com.ulyssys.hw.jpa.entity.User;

@Stateless
public class UserDAO implements UserDAORemote, UserDAOLocal {

	@PersistenceContext
	private EntityManager em;
	
    public UserDAO() {
    }

	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		em.merge(user);
		return user;
	}

	@Override
	public void remove(int userId) {
		em.remove(this.getUserById(userId));
	}

	@Override
	public User getUserById(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	public List<User> getAllUsers() {
		return em.createNamedQuery("User.getAll", User.class).getResultList();
	}

}
