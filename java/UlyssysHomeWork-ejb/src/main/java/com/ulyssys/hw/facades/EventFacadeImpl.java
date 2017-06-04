package com.ulyssys.hw.facades;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.dto.EventDTO;
import com.ulyssys.hw.ejb.beans.interfaces.EventDAO;
import com.ulyssys.hw.facades.interfaces.EventFacade;
import com.ulyssys.hw.jpa.entity.Event;

@Stateless
public class EventFacadeImpl implements EventFacade {

	@EJB
	private EventDAO eventDAO;
	
	@Override
	public List<Event> findAll() {
		return eventDAO.findAll();
	}

	public List<EventDTO> findAllForView() {
		return eventDAO.findAllForView();
	}
}
