package com.ulyssys.hw.managedbeans;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ulyssys.hw.facades.interfaces.ApplicationFacade;
import com.ulyssys.hw.facades.interfaces.UserFacade;
import com.ulyssys.hw.jpa.entity.Application;
import com.ulyssys.hw.jpa.entity.User;

@ViewScoped
@ManagedBean
public class ApplicationMB {

	@EJB
	private ApplicationFacade applicationFacade;
	
	@EJB
	private UserFacade userFacade;

	private int applicationId;
	private int userId ;
	private String login;
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
		Application application = applicationFacade.findApplicationById(applicationId);
		User user = userFacade.findUserById(application.getUserId());
		this.applicationId = application.getApplicationId();
		this.userId = application.getUserId();
		this.login = user.getLogin();  
		this.amount = application.getAmount();
		this.approved = application.getApproved();
	}
	
	public void deleteApplication(int applicationId) {
		applicationFacade.remove(applicationId);
	}
	
	public List<Application> getAllApplications() {
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
