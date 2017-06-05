package com.ulyssys.hw.facades.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.ulyssys.hw.jpa.entity.Application;

@Local
public interface ApplicationFacade {
	
	public Application create(Application application);
	public Application update(Application application);
	public void remove(int id);
	public Application findApplicationById(int id);
	public List<Application> findAll();
	
	public List<Application> findAllModifiable();
	public void approve(int id);
	public void approveAll();
	

}
