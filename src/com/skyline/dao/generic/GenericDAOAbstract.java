package com.skyline.dao.generic;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDAOAbstract<T extends Serializable>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Class<T> entity;
	
	// getters and setters
	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public void setEntity(Class<T> entityToSet){
		this.entity = entityToSet;
	}
	
	public Class<T> getEntity() {
		return entity;
	}


	// methods
	public List<T> getAll(){
		  return getSession().
				  createQuery("from " + entity.getName(), entity).getResultList();
	}
	
	public void save(T entity){
		getSession().saveOrUpdate(entity);
	}
	
	public T findOne( int id ){
	      return getSession().find( entity, id );
	 }
	

	
}
