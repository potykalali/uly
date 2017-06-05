package com.ulyssys.hw.jpa.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
	  @NamedQuery(name = "Application.getAll",
			  	  query = "SELECT a FROM Application a")
	})
public class Application implements Serializable {

	public static final String GET_ALL = "Application.getAll"; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="application_id")
	private int applicationId;
	
	@NotNull
	@Column(name="user_id")
	private int userId;

	@NotNull
	private Double amount;
	
	private Timestamp approved;
	
	private static final long serialVersionUID = 1L;

	public Application() {
		super();
	}   
	public int getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}   
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}   
	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}   
	public Timestamp getApproved() {
		return this.approved;
	}

	public void setApproved(Timestamp approved) {
		this.approved = approved;
	}
   
}
