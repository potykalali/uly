package com.ulyssys.hw.ejb.beans.interfaces;

import java.util.List;

import com.ulyssys.hw.jpa.entity.VAppUser;

public interface VAppUserDAO extends GenericDAO<VAppUser> {

	public List<VAppUser> findApplicationByUser(int userId);
	public List<VAppUser> findAllModifiable();
	
}
