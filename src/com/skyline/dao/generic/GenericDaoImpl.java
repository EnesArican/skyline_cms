package com.skyline.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.GenericDao;

@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<E> 
		implements GenericDao<E> {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Class<? extends E> daoType;
	
	
	public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class<? extends E>) pt.getActualTypeArguments()[0];
    }

	protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
	
	
	// Generic Methods
	
	@Override
	public List<E> getAll(){
		return (List<E>) currentSession().
				createQuery("from " + daoType.getName(), daoType).getResultList();
	}

	@Override
	public void saveOrUpdate(E entity){
		currentSession().saveOrUpdate(entity);
	}
	
	@Override
	public void remove(int id){
		// delete object with primary key
		Query<?> theQuery = currentSession().createQuery(
				"delete from " + daoType.getName() +" where id=:theId");
		 				
		theQuery.setParameter("theId", id);
		 				
		theQuery.executeUpdate();
	}
	
	@Override
	public E find(int id){
		return (E) currentSession().find(daoType, id);
	}
	
}













