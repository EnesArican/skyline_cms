package com.skyline.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.skyline.dao.daoInterface.GenericDao;
import com.skyline.dao.daoInterface.StudentDao;
import com.skyline.entity.student.Student;
import com.skyline.service.generic.GenericServiceImpl;
import com.skyline.service.serviceInterface.StudentService;

@Service
public class StudentServiceImpl extends GenericServiceImpl<Student>
		implements StudentService{

	
	private StudentDao studentDAO;
	
	public StudentServiceImpl(){}
	
	@Autowired
	public StudentServiceImpl(
			@Qualifier("studentDaoImpl") GenericDao<Student> genericDao){
		super(genericDao);
		this.studentDAO = (StudentDao) genericDao;
	}
	
}
