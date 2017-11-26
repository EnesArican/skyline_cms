package com.skyline.dao.daoInterface;

import java.util.List;

public interface GenericDao<E> {

	public List<E> getAll();
	
	public E find(int id);
	
	
	public void saveOrUpdate(E entity);
	
	public void remove(int id);
	
	
	
}
