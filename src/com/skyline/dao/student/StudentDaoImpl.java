package com.skyline.dao.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.StudentDao;
import com.skyline.dao.generic.GenericDaoImpl;
import com.skyline.entity.student.Student;
import com.skyline.entity.student.StudentAccomodation;
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
		
		for(StudentAccomodation sa: student.getStudentAccomodations()){
			sa.setStudent(student);
		}
		
		// used to remove unnecesary data
		// can improve
		StudentFlight studentF = student.getStudentFlight().get(0);
		if(studentF.getPickupAirport() == null && studentF.getDropoffAirport() == null){
			student.getStudentFlight().remove(0);
		}
		
		
		for(StudentFlight sf: student.getStudentFlight()){
			
			System.out.println(sf.toString());
			sf.setStudent(student);
		}
		
		System.out.println("near the end of method");
		currentSession().saveOrUpdate(student);;
	}
}







