package com.renho.springbootvue.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
@RestController
@RequestMapping("")
public class AuthController {

    @RequestMapping("/auth/oauth/token")
    public Map token() {
        Map map = new HashMap();
        map.put("access_token", "access_token-renho");
        map.put("refresh_token", "refresh_token-renho");
        return map;
    }

    @RequestMapping("/sys/token/info/access_token-renho")
    public Map info() throws IOException {
        String json = "{\"name\":\"renho\",\"menus\":[{\"name\":\"系统首页\",\"icon\":\"el-icon-lx-home\",\"orderNum\":0,\"perms\":\"sys:dashboard:info\",\"id\":\"1\",\"type\":1,\"parentId\":\"0\",\"url\":\"dashboard\"},{\"name\":\"用户管理\",\"icon\":\"el-icon-lx-home\",\"orderNum\":1,\"perms\":\"sys:dashboard:info\",\"id\":\"100\",\"type\":1,\"parentId\":\"0\",\"url\":\"user\"},{\"name\":\"角色管理\",\"icon\":\"el-icon-lx-home\",\"orderNum\":2,\"perms\":\"sys:dashboard:info\",\"id\":\"100\",\"type\":1,\"parentId\":\"0\",\"url\":\"sysrole\"},{\"name\":\"规则管理\",\"icon\":\"el-icon-lx-home\",\"orderNum\":3,\"perms\":\"sys:dashboard:info\",\"id\":\"100\",\"type\":1,\"parentId\":\"0\",\"url\":\"rule\"}]}";
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(json, Map.class);
        System.out.println(map);
        return map;
    }
}
