package com.ulyssys.hw.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ulyssys.hw.ejb.beans.interfaces.UserDAOLocal;
import com.ulyssys.hw.jpa.entity.User;

@ViewScoped
@ManagedBean
public class UserMB {

	@EJB
	private UserDAOLocal userDAOLocal;

	private int userId;
	private String name;
	private String login;
	private String password;
	private String type;

	public UserMB() {
	}
	
	public void createUser() {
		User user = new User();
		//user.setUserId();
		user.setLogin(login);
		user.setName(name);
		user.setPassword(login);
		user.setType(type);
		userDAOLocal.create(user);
	}
	
	public void updateUser() {
		User user = new User();
		user.setUserId(this.userId);
		user.setName(name);
		user.setLogin(login);
		user.setPassword(password);
		user.setType(type);
		System.out.println(type);

		userDAOLocal.update(user);
	}

	public void getUserById(int userId) {
		User user = userDAOLocal.getUserById(userId); 
		this.userId = user.getUserId();
		this.name = user.getName();
		this.login = user.getLogin();
		this.type = user.getType();
	}
	
	public void deleteUser(int userId) {
		userDAOLocal.remove(userId);
	}
	
	public List<User> getAllUsers() {
		return userDAOLocal.getAllUsers();
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
