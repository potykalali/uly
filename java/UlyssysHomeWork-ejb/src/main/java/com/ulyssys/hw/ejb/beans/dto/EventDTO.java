package com.ulyssys.hw.ejb.beans.dto;

import com.ulyssys.hw.jpa.entity.Event;

public class EventDTO extends Event {
	
	private static final long serialVersionUID = 1L;
	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
