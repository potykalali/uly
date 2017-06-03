package com.ulyssys.hw.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
public class User implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="user_id")
	private int userId;
	
	@NotNull
	@Length(max=200)
	private String name;
	
	@NotNull
	@Length(max=45)
	private String login;
	
	@NotNull
	@Length(max=45)
	private String password;
	
	@NotNull
	@Length(max=20)
	private String type;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	}   
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getLogin() {
		return this.login;
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
