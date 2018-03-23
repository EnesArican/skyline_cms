package com.skyline.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.skyline.dao.daoInterface.GenericDao;
import com.skyline.dao.daoInterface.StudentAccomodationDao;
import com.skyline.entity.student.StudentAccomodation;
import com.skyline.service.generic.GenericServiceImpl;
import com.skyline.service.serviceInterface.StudentAccomodationService;

@Service
public class StudentAccomodationServiceImpl extends GenericServiceImpl<StudentAccomodation>
		implements StudentAccomodationService {

	private StudentAccomodationDao studentAccomodationDAO;
	
	public StudentAccomodationServiceImpl(){}
	
	@Autowired
	public StudentAccomodationServiceImpl(
			@Qualifier("studentAccomodationDaoImpl") GenericDao<StudentAccomodation> genericDao){
		super(genericDao);
		this.studentAccomodationDAO = (StudentAccomodationDao) genericDao;
	}
}
