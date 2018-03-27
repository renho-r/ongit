package com.renho.system.db.commons.dao;

import org.hibernate.SessionFactory;

public interface CommonHibernateDao {

    void setSessionFactory(SessionFactory sessionFactory);

    <T> void save(T po);
}
