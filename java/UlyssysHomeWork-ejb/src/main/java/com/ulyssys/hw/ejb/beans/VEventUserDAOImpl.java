package com.ulyssys.hw.ejb.beans;

import java.util.List;

import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.VEventUserDAO;
import com.ulyssys.hw.jpa.entity.VEventUser;

@Stateless
public class VEventUserDAOImpl extends GenericDAOImp<VEventUser> implements VEventUserDAO {

	public VEventUserDAOImpl() {
		super(VEventUser.class);
	}

	@Override
	public List<VEventUser> findAllForView() {
		return super.findAll();
	}

}
