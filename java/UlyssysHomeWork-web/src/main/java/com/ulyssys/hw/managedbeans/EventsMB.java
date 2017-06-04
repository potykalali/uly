package com.ulyssys.hw.managedbeans;

import java.sql.Timestamp;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.ulyssys.hw.ejb.beans.dto.EventDTO;
import com.ulyssys.hw.facades.interfaces.EventFacade;
import com.ulyssys.hw.facades.interfaces.UserFacade;
import com.ulyssys.hw.jpa.entity.Event;

@ViewScoped
@ManagedBean
public class EventsMB {

	@EJB
	private EventFacade eventFacade;
	
	@EJB
	private UserFacade userFacade;

	private int eventId;
	private String description;
	private String successful;
	private Timestamp tstamp;
	private int userId;
	private String login;
	
	public EventsMB(){
	}
	
	public List<EventDTO> getAllEvents() {
		return eventFacade.findAllForView();
	}
	
	public List<Event> getAllEventsDraft() {
		return eventFacade.findAll();
	}
	
	public String getLogin(int userId) {
		try {
			return userFacade.findUserById(userId).getLogin();
		} catch (Exception e) {
			return "[" + String.valueOf(userId) + "]";
		}
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSuccessful() {
		return successful;
	}

	public void setSuccessful(String successful) {
		this.successful = successful;
	}

	public Timestamp getTstamp() {
		return tstamp;
	}

	public void setTstamp(Timestamp tstamp) {
		this.tstamp = tstamp;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
