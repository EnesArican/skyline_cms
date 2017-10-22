package com.skyline.service.generic;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends Serializable> {

	public List<T> getAll();
}
