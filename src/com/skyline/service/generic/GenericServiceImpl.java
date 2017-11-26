package com.skyline.service.generic;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.daoInterface.GenericDao;
import com.skyline.service.serviceInterface.GenericService;

@Service
public abstract class GenericServiceImpl<E>
		implements GenericService<E> {

	private GenericDao<E> genericDao;
	 
    public GenericServiceImpl(GenericDao<E> genericDao) {
        this.genericDao=genericDao;
    }
 
    public GenericServiceImpl() {
    }
    
    // methods
    
    @Override
    @Transactional
    public List<E> getAll() {
        return genericDao.getAll();
    }
    
    @Override
    @Transactional
    public E find(int id) {
        return genericDao.find(id);
    }
    
    @Override
    @Transactional
    public void saveOrUpdate(E entity){
    	genericDao.saveOrUpdate(entity);
    }
	
    @Override
    @Transactional
	public void remove(int id){
    	genericDao.remove(id);
    }
    
    
    
}





