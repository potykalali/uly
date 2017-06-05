package com.ulyssys.hw.facades.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.ulyssys.hw.jpa.entity.Application;
import com.ulyssys.hw.jpa.entity.VAppUser;

@Local
public interface ApplicationFacade {
	
	public Application create(Application application);
	public Application update(Application application);
	public void remove(int id);
	public VAppUser findApplicationById(int id);
	public List<VAppUser> findAll();
	
	public List<VAppUser> findAllModifiable();
	public void approve(int id);
	public void approveAll();
	
	public List<VAppUser> findAllByUserId(int userId);

}
