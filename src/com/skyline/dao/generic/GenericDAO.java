package com.skyline.dao.generic;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T extends Serializable> {
	
	public void setEntity(Class<T> entityToSet);

	public List<T> getAll();
	
	public void save(T entity);
	
	public T findOne(int id);
	
}
