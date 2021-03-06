package com.skyline.dao.student;

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
	
	@Override
	public void saveOrUpdate(Student student){		
		
		// used to remove unnecesary data
		// can improve
		StudentFlight studentF = student.getStudentFlight().get(0);
		if(studentF.getPickupAirport() == null && studentF.getDropoffAirport() == null){
			student.getStudentFlight().remove(0);
		}
		
		for(StudentFlight sf: student.getStudentFlight()){
			sf.setStudent(student);
		}
		
		currentSession().saveOrUpdate(student);;
	}
}







