package com.ulyssys.hw.ejb.beans.interfaces;

import java.util.List;

import com.ulyssys.hw.ejb.beans.dto.EventDTO;
import com.ulyssys.hw.jpa.entity.Event;

public interface EventDAO extends GenericDAO<Event> {
	
	public List<EventDTO> findAllForView();

}
