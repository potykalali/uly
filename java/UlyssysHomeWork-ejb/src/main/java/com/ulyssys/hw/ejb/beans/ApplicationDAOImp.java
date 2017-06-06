package com.ulyssys.hw.ejb.beans;


import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.ApplicationDAO;
import com.ulyssys.hw.ejb.beans.interfaces.EventDAO;
import com.ulyssys.hw.ejb.enums.ApplicationStatus;
import com.ulyssys.hw.ejb.enums.EventType;
import com.ulyssys.hw.ejb.enums.OperationStatus;
import com.ulyssys.hw.jpa.entity.Application;
import com.ulyssys.hw.jpa.entity.Event;

@Stateless
public class ApplicationDAOImp extends GenericDAOImp<Application> implements ApplicationDAO {
	
	@EJB
	private EventDAO eventDAO;
	
	public ApplicationDAOImp() {
		super(Application.class);
	}

	@Override
	public Application create(Application application) {
		try {
			super.create(application);
			logEvent(application, EventType.CREATE, OperationStatus.SUCCESFULL);
			
		} catch (Exception e) {
			logEvent(application, EventType.CREATE, OperationStatus.FAILED);
		}
		
		return application;
		
	}

	public Application update(Application application){
		try {
			super.update(application);
			logEvent(application, EventType.UPDATE, OperationStatus.SUCCESFULL);
		} catch (Exception e) {
			logEvent(application, EventType.UPDATE, OperationStatus.FAILED);
		}
		return application;
	}
	
	public void remove(int id){
		Application application = (Application) super.getById(id);
		try {
			super.remove(id);
			logEvent(application, EventType.DELETE, OperationStatus.SUCCESFULL);
		} catch (Exception e) {
			logEvent(application, EventType.DELETE, OperationStatus.FAILED);
		}
	}
	
	@Override
	public void approve(int id) {
		changeStatus(id, ApplicationStatus.APPROVED, EventType.APPROVE);
	}

	@Override
	public void approveAll() {
		List<Application> appList = super.findAll();
		for (Application oneApp : appList) {
			this.approve(oneApp.getApplicationId());
		} 
	}

	@Override
	public void reject(int id) {
		changeStatus(id, ApplicationStatus.REJECTED, EventType.REJECT);
	}

	private void changeStatus(int id, ApplicationStatus status, EventType evenType) {
		Application application = super.getById(id);
		try {
			application.setApproved(status.toString());
			super.update(application);
			logEvent(application, evenType, OperationStatus.SUCCESFULL);
		} catch (Exception e) {
			logEvent(application, evenType, OperationStatus.FAILED);
		}
	}

	private void logEvent(Application application, EventType eventType, OperationStatus status) {
		Event event = new Event();
		event.setTstamp(new Timestamp(System.currentTimeMillis()));
		event.setUserId(application.getUserId());
		event.setDescription(eventType.toString());
		event.setSuccessful(status.toString());
		eventDAO.create(event);
	}
}
