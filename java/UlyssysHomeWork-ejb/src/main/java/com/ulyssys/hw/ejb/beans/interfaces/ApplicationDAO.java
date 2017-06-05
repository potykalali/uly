package com.ulyssys.hw.ejb.beans.interfaces;

import java.util.List;

import com.ulyssys.hw.jpa.entity.Application;

public interface ApplicationDAO extends GenericDAO<Application> {

	public Application findApplicationByUser(String userId);
	public List<Application> findAllModifiable();
	public void approve(int applicationId);
	public void approveAll();
	
}
