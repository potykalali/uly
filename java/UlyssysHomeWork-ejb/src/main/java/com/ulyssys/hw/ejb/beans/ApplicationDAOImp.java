package com.ulyssys.hw.ejb.beans;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.ApplicationDAO;
import com.ulyssys.hw.jpa.entity.Application;

@Stateless
public class ApplicationDAOImp extends GenericDAOImp<Application> implements ApplicationDAO {
	
	public ApplicationDAOImp() {
		super(Application.class);
	}

	public Application findApplicationByUser(String userId){
		  Map<String, Object> parameters = new HashMap<String, Object>();
		  parameters.put("id", userId); 
		 
		  return super.findOneResult(Application.FIND_BY_USER, parameters);
		 }

	@Override
	public List<Application> findAllModifiable() {
		return super.findAllByParameter(Application.FIND_MODIFIABLE, null);
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
