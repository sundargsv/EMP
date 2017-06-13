package com.sundar.dao.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sundar.dao.EmployeeDao;
import com.sundar.model.Employee;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {
/*	= new Configuration().configure().buildSessionFactory();
 * = sessionFactory.openSession();*/
	
	@Autowired
	private SessionFactory sessionFactory ;    
	//try setter and getter
	/*public EmployeeDaoImpl(SessionFactory sessionFactory) {
	super();
	this.sessionFactory = sessionFactory;
}*/

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional    
	public long add(Employee e) {
		Employee savedObject = null;
		System.out.println("EmployeeDaoImpl.add");
		Long id = null;
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			id =  (Long) session.save(e);
			tx.commit();
			
		}catch(HibernateException e1){
			if (tx!=null){ 
				tx.rollback();
			}
	         e1.printStackTrace(); 
		}finally {
	         session.close(); 
	      }
 		
		
		return id.longValue();
	}
	
	@Transactional
	public List<Employee> list(){
		List<Employee> employeeList = null;
		System.out.println("EmployeeDaoImpl.list");
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			employeeList = (List<Employee>) session.createCriteria(Employee.class).list();
			
			tx.commit();
/*			(List<Products>)session.createSQLQuery("SELECT * FROM Products").addEntity(Products.class).list();
*/		}catch(HibernateException e){
			if(tx != null){
				tx.rollback();
			}
			e.printStackTrace(); 
		}finally {
			session.close();
		}
		
		return employeeList;
		
	}

	@Transactional
	public Employee getById(long id) {
		Employee employee = null;
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		try{
			employee = (Employee) session.get(Employee.class, id);
			
		}catch(HibernateException e){
			e.printStackTrace(); 
		}finally {
			session.close();
		}
		
		return employee;
	}



}
