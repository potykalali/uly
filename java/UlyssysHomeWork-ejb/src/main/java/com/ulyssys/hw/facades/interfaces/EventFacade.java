package com.ulyssys.hw.facades.interfaces;

import java.util.List;

import javax.ejb.Local;

import com.ulyssys.hw.jpa.entity.VEventUser;

@Local
public interface EventFacade {

	public List<VEventUser> findAllForView();

}
