package com.ulyssys.hw.facades;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.VEventUserDAO;
import com.ulyssys.hw.facades.interfaces.EventFacade;
import com.ulyssys.hw.jpa.entity.VEventUser;

@Stateless
public class EventFacadeImpl implements EventFacade {

	@EJB
	private VEventUserDAO eventUserDAO;
	
	public List<VEventUser> findAllForView() {
		return eventUserDAO.findAllForView();
	}
}
