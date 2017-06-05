package com.ulyssys.hw.ejb.beans;

import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.EventDAO;
import com.ulyssys.hw.jpa.entity.Event;

@Stateless
public class EventDAOImpl extends GenericDAOImp<Event> implements EventDAO {

	public EventDAOImpl() {
		super(Event.class);
	}

}
