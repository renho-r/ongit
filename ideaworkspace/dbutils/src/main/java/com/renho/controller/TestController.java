package com.renho.controller;

import com.renho.domain.po.TbUserPo;
import com.renho.system.db.commons.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/db/test")
public class TestController {

    @RequestMapping("/query/{id}")
    @ResponseBody
    public TbUserPo query(@PathVariable String id) {

        TbUserPo user = DBUtils.getFirst("SELECT * FROM TB_USER WHERE ID = ? ", TbUserPo.class, id);

        return user;
    }


}
