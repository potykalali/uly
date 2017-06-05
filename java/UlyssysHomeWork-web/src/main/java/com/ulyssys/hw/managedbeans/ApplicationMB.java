package com.ulyssys.hw.managedbeans;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ulyssys.hw.facades.interfaces.ApplicationFacade;
import com.ulyssys.hw.jpa.entity.Application;
import com.ulyssys.hw.jpa.entity.VAppUser;

@ViewScoped
@ManagedBean
public class ApplicationMB {

	@EJB
	private ApplicationFacade applicationFacade;
	
	private int applicationId;
	private int userId ;
	private String name;
	private Double amount;
	private Timestamp approved;

	public ApplicationMB() {
	}
	
	public void createApplication() {
		Application application = new Application();
		//application.setApplicationId();
		application.setAmount(amount);
		application.setApproved(null);
		application.setUserId(userId);
		applicationFacade.create(application);
	}
	
	public void updateApplication() {
		Application application = new Application();
		application.setApplicationId(this.applicationId);
		application.setAmount(amount);
		application.setApproved(null);
		application.setUserId(userId);
		applicationFacade.update(application);
	}

	public void getApplicationById(int applicationId) {
		VAppUser appUser = applicationFacade.findApplicationById(applicationId);
		this.applicationId = appUser.getApplicationId();
		this.userId = appUser.getUserId();
		this.name = appUser.getName();  
		this.amount = appUser.getAmount();
		this.approved = appUser.getApproved();
	}
	
	public void deleteApplication(int applicationId) {
		applicationFacade.remove(applicationId);
	}
	
	public List<VAppUser> getAllApplications() {
		return applicationFacade.findAll();
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
