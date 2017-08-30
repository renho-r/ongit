package com.renho.controller;

import com.renho.po.StudentVo;
import com.renho.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/renho")
public class RenhoController {

    @Autowired
    private HibernateTemplate hibernateTemplate;

//    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IStudentService studentService;

    @RequestMapping(value = "/hibernate/query", method = RequestMethod.GET)
    @ResponseBody
    public StudentVo query(HttpServletRequest request) {
        StudentVo s = new StudentVo();
        s.setName("renho001");
        hibernateTemplate.save(s);
        return null;
    }

    @RequestMapping(value = "/hibernate/save", method = RequestMethod.GET)
    @ResponseBody
    public StudentVo save(HttpServletRequest request) {
        StudentVo s = new StudentVo();
        s.setName("renho002");
        studentService.saveStudent(s);
        return null;
    }

    @RequestMapping(value = "/jdbc/query", method = RequestMethod.GET)
    @ResponseBody
    public StudentVo jdbcQuery(HttpServletRequest request) {
        StudentVo s = new StudentVo();
        s.setName("renho001");
        jdbcTemplate.update("INSERT INTO T_STUDENT(ID, NAME) VALUES(1, 'RENHOJDBC')");
        return null;
    }

    @RequestMapping(value = "/jdbc/save", method = RequestMethod.GET)
    @ResponseBody
    public StudentVo jdbcSave(HttpServletRequest request) {
        StudentVo s = new StudentVo();
        s.setName("renho002");
//        studentService.saveStudent(s);
        studentService.queryStudent(s);
        return null;
    }

}
