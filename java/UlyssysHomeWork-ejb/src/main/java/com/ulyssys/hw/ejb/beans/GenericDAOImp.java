package com.ulyssys.hw.ejb.beans;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import com.ulyssys.hw.ejb.beans.interfaces.GenericDAO;

@Stateless
public abstract class GenericDAOImp<T> implements GenericDAO<T> {

	@PersistenceContext()
	private EntityManager em;
	 
	private Class<T> entityClass;
	 
	public GenericDAOImp(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public T create(T obj) {
		em.persist(obj);
		return obj;
	}

	@Override
	public T update(T obj) {
		em.merge(obj);
		return obj;
	}

	@Override
	public void remove(int id) {
		em.remove(this.getById(id));
	}

	@Override
	public T getById(int id) {
		return em.find(entityClass, id);
	}

	// Using the unchecked because JPA does not have a
	// em.getCriteriaBuilder().createQuery()<T> method
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findAll() {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return em.createQuery(cq).getResultList();
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<T> findAllByParameter(String namedQuery, Map<String, Object> parameters) {
		List<T> result = null;
		
		try {
			Query query = em.createNamedQuery(namedQuery);
			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}

			result = (List<T>) query.getResultList();

		} catch (Exception e) {
			 System.out.println("Error while running query: " + e.getMessage());
			 e.printStackTrace();
		 }
		return result;
	}
	
	// Using the unchecked because JPA does not have a
	// ery.getSingleResult()<T> method
	@SuppressWarnings("unchecked")
	protected T findOneResult(String namedQuery, Map<String, Object> parameters) {
		T result = null;
		 
		try {
			Query query = em.createNamedQuery(namedQuery);
	
			// Method that will populate parameters if they are passed not null and empty
			if (parameters != null && !parameters.isEmpty()) {
				populateQueryParameters(query, parameters);
			}
			result = (T) query.getSingleResult();
		 } catch (Exception e) {
			 System.out.println("Error while running query: " + e.getMessage());
			 e.printStackTrace();
		 }
		 return result;
	 }
	
	 private void populateQueryParameters(Query query, Map<String, Object> parameters) {
		 for (Entry<String, Object> entry : parameters.entrySet()) {
			 query.setParameter(entry.getKey(), entry.getValue());
		 }
	 }

}
