package com.skyline.dao.daoInterface;

import com.skyline.entity.property.Property;

public interface PropertyDao extends GenericDao <Property> {
	
	public Integer getNewSkyCode();
	
}
