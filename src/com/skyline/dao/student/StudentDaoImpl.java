package com.skyline.dao.student;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.StudentDao;
import com.skyline.dao.generic.GenericDaoImpl;
import com.skyline.entity.student.Student;
import com.skyline.entity.student.StudentFlight;;


@Repository
public class StudentDaoImpl extends GenericDaoImpl<Student> 
						implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected final Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	

	public static List safe( List other ) {
	    return other == null ? Collections.EMPTY_LIST : other;
	}
	
	@Override
	public void saveOrUpdate(Student student){		
		for(Object sf:safe(student.getStudentFlights())){
			student.addFlight((StudentFlight)sf);
		}
					
		currentSession().saveOrUpdate(student);
	}
}







