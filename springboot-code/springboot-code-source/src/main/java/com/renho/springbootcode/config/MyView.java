package com.renho.springbootcode.config;

import com.alibaba.fastjson.JSON;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Map;

/**
 * @author renho
 * @date 2020/11/27
 */
public class MyView implements View {
    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setHeader("content-type", "application/json;charset=UTF-8");
        OutputStream out = response.getOutputStream();
        out.write(JSON.toJSONString(model).getBytes());
        out.flush();
    }
}
