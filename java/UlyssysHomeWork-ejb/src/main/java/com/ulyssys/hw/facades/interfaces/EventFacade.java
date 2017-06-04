package com.ulyssys.hw.facades.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.ulyssys.hw.ejb.beans.dto.EventDTO;
import com.ulyssys.hw.jpa.entity.Event;

@Local
public interface EventFacade {

	public List<Event> findAll();
	public List<EventDTO> findAllForView();

}
