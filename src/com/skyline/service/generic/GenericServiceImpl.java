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
    
    
}
