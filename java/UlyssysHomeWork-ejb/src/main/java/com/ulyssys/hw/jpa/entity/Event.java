package com.ulyssys.hw.jpa.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@NamedQueries({
	  @NamedQuery(name = "Event.findAll",
			  	  query = "SELECT e FROM Event e")
	})
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="event_id")
	private int eventId;

	private String description;

	private String successful;

	private Timestamp tstamp;

	@Column(name="user_id")
	private int userId;

	public Event() {
	}

	public int getEventId() {
		return this.eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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