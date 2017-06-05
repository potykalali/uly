package com.ulyssys.hw.ejb.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import com.ulyssys.hw.ejb.beans.interfaces.VAppUserDAO;
import com.ulyssys.hw.jpa.entity.VAppUser;

@Stateless
public class VAppUserDAOImp extends GenericDAOImp<VAppUser> implements VAppUserDAO {
	
	public VAppUserDAOImp() {
		super(VAppUser.class);
	}

	public VAppUser findApplicationByUser(String userId){
		  Map<String, Object> parameters = new HashMap<String, Object>();
		  parameters.put("id", userId); 
		 
		  return super.findOneResult(VAppUser.FIND_BY_USER, parameters);
	 }

	@Override
	public List<VAppUser> findAllModifiable() {
		return super.findAllByParameter(VAppUser.FIND_MODIFIABLE, null);
	}


}
