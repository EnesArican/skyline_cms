package com.skyline.service.serviceInterface;

import java.util.List;

public interface GenericService<E> {
	
	public List<E> getAll();
	
	public E find(int id);
	
	public void saveOrUpdate(E entity);
	
	public void remove(int id);
	

}
