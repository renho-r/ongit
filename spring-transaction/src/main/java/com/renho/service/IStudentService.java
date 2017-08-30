package com.renho.service;

import com.renho.po.StudentVo;

public interface IStudentService {

    void saveStudent(StudentVo s);

    void queryStudent(StudentVo s);

}
