package com.renho.system.db.commons.dao.impl;

import com.renho.system.db.commons.dao.CommonHibernateDao;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

public class CommonHibernateDaoImpl extends HibernateDaoSupport implements CommonHibernateDao {

    public <T> void save(T po) {
        this.getHibernateTemplate().save(po);
    }
}
