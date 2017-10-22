package com.skyline.dao.generic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

import org.springframework.beans.factory.config.*;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class BaseDAOImpl<T extends Serializable> 
extends BaseDAOAbstract<T> implements BaseDAO<T> {
	
				
}
