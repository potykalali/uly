package com.ulyssys.hw.ejb.beans;

import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.ApplicationDAO;
import com.ulyssys.hw.jpa.entity.Application;

@Stateless
public class ApplicationDAOImp extends GenericDAOImp<Application> implements ApplicationDAO {
	
	public ApplicationDAOImp() {
		super(Application.class);
	}

}
