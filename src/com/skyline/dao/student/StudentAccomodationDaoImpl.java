package com.skyline.dao.student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skyline.dao.daoInterface.StudentAccomodationDao;
import com.skyline.dao.generic.GenericDaoImpl;
import com.skyline.entity.student.StudentAccomodation;


@Repository
public class StudentAccomodationDaoImpl extends GenericDaoImpl<StudentAccomodation> 
implements StudentAccomodationDao {

@Autowired
private SessionFactory sessionFactory;

protected final Session getSession(){
return sessionFactory.getCurrentSession();
}

}
