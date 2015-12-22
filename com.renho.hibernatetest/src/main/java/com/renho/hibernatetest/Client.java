package com.renho.hibernatetest;

import java.sql.Timestamp;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Client {

	public static void main(String[] args) {

		Action action = new Action();
		action.setServerID(100L);
		action.setAction(100);
		action.setChange_time(new Timestamp(System.currentTimeMillis()));
		action.setFlag(1);
		action.setReturn_flag(1);
		action.setSend_flag(1);
		action.setUname("renho");
		action.setZonename("zoneName");
		Transaction tx = null;
		try {
			Configuration cfg = new Configuration();
			SessionFactory sf = cfg.configure().buildSessionFactory();// 默认读取的是sre下面的hibernate.cfg.xml
			Session session = sf.openSession();
			tx = session.beginTransaction();
			// tx.commit();
			session.save(action);
			tx.commit();
			session.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			try {
				tx.rollback();
			} catch (HibernateException e1) {
				e1.printStackTrace();
			}
		} finally {

		}
	}

}
