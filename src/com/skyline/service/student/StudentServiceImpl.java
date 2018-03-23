package com.skyline.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skyline.dao.daoInterface.GenericDao;
import com.skyline.dao.daoInterface.StudentDao;
import com.skyline.entity.student.Student;
import com.skyline.entity.student.StudentAccomodation;
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
	
	@Override
	@Transactional
	public void saveOrUpdate(Student student){	
		
		for(int i = student.getStudentAccomodations().size()-1; i >= 0 ; i--){
			StudentAccomodation sa = student.getStudentAccomodations().get(i);
		
			System.out.println(sa.toString());
			if(sa.getId() == -1){
				System.out.println("found an id that is -1");
				student.getStudentAccomodations().remove(sa);
		}else{
			sa.setStudent(student);
		}
		studentDAO.saveOrUpdate(student);
	}
	}
}
