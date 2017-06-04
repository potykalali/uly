package com.ulyssys.hw.ejb.beans.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface GenericDAO<T> {

	public T create(T obj);
	public T update(T obj);
	public void remove(int id);
	public T getById(int id);
	public List<T> findAll();
	public List<T> findAllByParameter(String namedQuery, Map<String, Object> parameters);
	
}
