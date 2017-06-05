package com.ulyssys.hw.ejb.beans.interfaces;

import java.util.List;

import com.ulyssys.hw.jpa.entity.VEventUser;

public interface VEventUserDAO extends GenericDAO<VEventUser> {
	
	public List<VEventUser> findAllForView();

}
