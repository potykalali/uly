package com.ulyssys.hw.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="v_event_user")
@NamedQuery(name="VEventUser.findAll", query="SELECT v FROM VEventUser v ORDER BY v.eventId DESC")
public class VEventUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FIND_ALL = "VEventUser.findAll";

	private String description;

	@Id
	@Column(name="event_id")
	private int eventId;

	private String login;

	private String name;

	private String successful;

	private Timestamp tstamp;

	@Column(name="user_id")
	private int userId;

	public VEventUser() {
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuccessful() {
		return this.successful;
	}

	public void setSuccessful(String successful) {
		this.successful = successful;
	}

	public Timestamp getTstamp() {
		return this.tstamp;
	}

	public void setTstamp(Timestamp tstamp) {
		this.tstamp = tstamp;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}