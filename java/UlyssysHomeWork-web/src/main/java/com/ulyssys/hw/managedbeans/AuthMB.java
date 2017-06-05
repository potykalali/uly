package com.ulyssys.hw.managedbeans;

import java.io.Serializable;
import java.security.Principal;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import com.ulyssys.hw.facades.interfaces.UserFacade;
import com.ulyssys.hw.jpa.entity.User;

@SessionScoped
@ManagedBean
public class AuthMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	
	@EJB
	private UserFacade userFacade;

	public AuthMB() {
	}
	
	public User getUser() {
        if (user == null) {
            Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
            if (principal != null) {
                user = userFacade.findByLogin(principal.getName()); // Find User by j_username.
            }
        }
        return user;
    }	
	
}
