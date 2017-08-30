package com.renho.service.impl;

import com.renho.po.StudentVo;
import com.renho.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService {

//    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void saveStudent(StudentVo s) {
        hibernateTemplate.save(s);
//        jdbcTemplate.update("INSERT INTO T_STUDENT(ID, NAME) VALUES(1, 'RENHOJDBC')");
    }

    public void queryStudent(StudentVo s) {
        hibernateTemplate.save(s);
//        jdbcTemplate.update("INSERT INTO T_STUDENT(ID, NAME) VALUES(1, 'RENHOJDBC')");
    }

}
