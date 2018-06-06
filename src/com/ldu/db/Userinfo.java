package com.ldu.db;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ldu.getsession.HibernateSessionFactory;
import com.ldu.model.User;

public class Userinfo {
	//private static SessionFactory factory = new Configuration().configure().buildSessionFactory();
	//factory.getSession();
	Session session = HibernateSessionFactory.getSession();
	Transaction tx = null;
	
	public List login(User user){
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("username",user.getUsername()));
		List list=cr.list();
		return list;
	}
	public void register(User user) {
		try {
			
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		} finally {
			session.close();
		}
		
	}
	
}
