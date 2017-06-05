package com.ulyssys.hw.managedbeans;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ulyssys.hw.facades.interfaces.ApplicationFacade;
import com.ulyssys.hw.facades.interfaces.UserFacade;
import com.ulyssys.hw.jpa.entity.Application;

@ViewScoped
@ManagedBean
public class ApprovalMB {

	@EJB
	private ApplicationFacade applicationFacade;
	
	@EJB
	private UserFacade userFacade;

	private int applicationId;
	private int userId ;
	private String name;
	private Double amount;
	private Timestamp approved;

	public ApprovalMB() {
	}
	
	public List<Application> getModifiableApplications() {
		return applicationFacade.findAllModifiable();
	}
	
	public void approve(int applicationId) {
		applicationFacade.approve(applicationId);
	}

	public void approveAll() {
		applicationFacade.approve(applicationId);
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Timestamp getApproved() {
		return approved;
	}

	public void setApproved(Timestamp approved) {
		this.approved = approved;
	}

}
