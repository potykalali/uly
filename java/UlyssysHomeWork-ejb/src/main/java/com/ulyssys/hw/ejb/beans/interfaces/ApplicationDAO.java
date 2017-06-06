package com.ulyssys.hw.ejb.beans.interfaces;

import com.ulyssys.hw.jpa.entity.Application;

public interface ApplicationDAO extends GenericDAO<Application> {

	public void approve(int applicationId);
	public void approveAll();
	public void reject(int applicationId);

}

