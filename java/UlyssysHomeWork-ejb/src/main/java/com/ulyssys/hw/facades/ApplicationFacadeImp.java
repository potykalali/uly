package com.ulyssys.hw.facades;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.ApplicationDAO;
import com.ulyssys.hw.facades.interfaces.ApplicationFacade;
import com.ulyssys.hw.jpa.entity.Application;

@Stateless
public class ApplicationFacadeImp implements ApplicationFacade {

	@EJB
	private ApplicationDAO applicationDAO;
	
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
	public Application findApplicationById(int id) {
		return applicationDAO.getById(id);
	}

	@Override
	public List<Application> findAll() {
		return applicationDAO.findAll();
	}

}
