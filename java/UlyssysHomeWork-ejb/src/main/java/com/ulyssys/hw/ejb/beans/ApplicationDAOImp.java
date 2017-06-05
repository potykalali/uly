package com.ulyssys.hw.ejb.beans;

import java.sql.Timestamp;

import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.ApplicationDAO;
import com.ulyssys.hw.jpa.entity.Application;

@Stateless
public class ApplicationDAOImp extends GenericDAOImp<Application> implements ApplicationDAO {
	
	public ApplicationDAOImp() {
		super(Application.class);
	}

	@Override
	public void approve(int id) {
		Application application = super.getById(id);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		application.setApproved(timestamp);
		super.update(application);
	}

	@Override
	public void approveAll() {
		// TODO Auto-generated method stub
		
	}
	
}
