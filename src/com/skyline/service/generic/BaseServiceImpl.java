package com.skyline.service.generic;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.generic.BaseDAO;

@Service
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class BaseServiceImpl<T extends Serializable> implements BaseService<T> {

	
	private BaseDAO<T> baseDao; 
	
	
	
	//@SuppressWarnings("unchecked")
	public BaseServiceImpl(BaseDAO<T> dao) {
			this.baseDao = dao;
		//	dao.setEntity(property);
	}
	
	
	
	@Override
	@Transactional
	public List<T> getAll() {
		 return (List<T>) baseDao.getAll();
	}
	
				
	
	
}

	

