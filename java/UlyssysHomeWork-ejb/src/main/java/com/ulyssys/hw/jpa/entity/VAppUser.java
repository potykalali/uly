package com.ulyssys.hw.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="v_app_user")
@NamedQueries({
	@NamedQuery(name="VAppUser.findAll", query="SELECT v FROM VAppUser v ORDER BY v.applicationId DESC"),
	@NamedQuery(name="VAppUser.findByUser", query="SELECT v FROM VAppUser v WHERE v.userId = :id"),
	@NamedQuery(name="VAppUser.findModifiable", query="SELECT v FROM VAppUser v WHERE v.approved IS NULL ORDER BY v.applicationId DESC")
})
public class VAppUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "VAppUser.findAll";
	public static final String FIND_BY_USER = "VAppUser.findByUser"; 
	public static final String FIND_MODIFIABLE = "VAppUser.findModifiable"; 

	private double amount;

	@Id
	@Column(name="application_id")
	private int applicationId;

	private String approved;

	private String login;

	private String name;

	@Column(name="user_id")
	private int userId;

	public VAppUser() {
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public String getApproved() {
		return this.approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}