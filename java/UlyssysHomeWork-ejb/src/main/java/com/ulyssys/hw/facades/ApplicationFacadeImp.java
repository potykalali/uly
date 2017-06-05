package com.ulyssys.hw.facades;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.ApplicationDAO;
import com.ulyssys.hw.ejb.beans.interfaces.VAppUserDAO;
import com.ulyssys.hw.facades.interfaces.ApplicationFacade;
import com.ulyssys.hw.jpa.entity.Application;
import com.ulyssys.hw.jpa.entity.VAppUser;

@Stateless
public class ApplicationFacadeImp implements ApplicationFacade {

	@EJB
	private ApplicationDAO applicationDAO;
	
	@EJB
	private VAppUserDAO appUserDAO;

	@Override
	public Application create(Application application) {
		return applicationDAO.create(application);
	}

	@Override
	public Application update(Application application) {
		return applicationDAO.update(application);
	}

	@Override
	public void remove(int id) {
		applicationDAO.remove(id);
	}

	@Override
	public VAppUser findApplicationById(int id) {
		return appUserDAO.getById(id);
	}

	@Override
	public List<VAppUser> findAll() {
		return appUserDAO.findAll();
	}

	@Override
	public List<VAppUser> findAllModifiable() {
		return appUserDAO.findAllModifiable();
	}

	@Override
	public void approve(int id) {
		applicationDAO.approve(id);
		
	}

	@Override
	public void approveAll() {
		applicationDAO.approveAll();
	}

	@Override
	public List<VAppUser> findAllByUserId(int userId) {
		return appUserDAO.findApplicationByUser(userId);
	}

}
