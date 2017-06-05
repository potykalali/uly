package com.ulyssys.hw.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.ulyssys.hw.facades.interfaces.UserFacade;
import com.ulyssys.hw.jpa.entity.User;

@SessionScoped
@ManagedBean
public class LoginMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private UserFacade userFacade;

	private int userId;
	private String login;
	private String password;
	private String type;

	public LoginMB() {
	}
	
	public void getUserById(int userId) {
		User user = userFacade.findUserById(userId); 
		this.userId = user.getUserId();
		this.login = user.getLogin();
		this.type = user.getType();
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
