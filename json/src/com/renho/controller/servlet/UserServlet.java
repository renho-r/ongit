package com.renho.controller.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import com.renho.model.pojo.impl.User;

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if("object".equals(method)) {
			doObject(request, response);
		}else if("list".equals(method)){
			try {
				doList(request, response);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}else if("map".equals(method)) {
			doMap(request, response);
		}else if("get".equals(method)) {
			doNewGet(request, response);
		}
	}

	private void doNewGet(HttpServletRequest request,
			HttpServletResponse response) {
		User user = new User();
		user.setUserId(100);
		user.setUserName("getUserName");
		user.setTime(new Timestamp((new Date()).getTime()));
		
		JsonConfig cfg = new JsonConfig();
		cfg.registerJsonValueProcessor(java.util.Date.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		cfg.registerJsonValueProcessor(java.sql.Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd"));
		JSONObject jsonObject = JSONObject.fromObject(user, cfg);
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(jsonObject);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void doMap(HttpServletRequest request, HttpServletResponse response) {
		
	}


	private void doList(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		Map map = request.getParameterMap();
		String jsonStr = request.getParameter("json");
		JSONObject json = JSONObject.fromObject(jsonStr);
		JSONArray arrayList = (JSONArray) json.get("list");
		Iterator<JSONObject> it = arrayList.iterator();
		List<User> userList = new ArrayList<User>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		while(it.hasNext()) {
			JSONObject j = it.next();
			User user = new User();
			user.setUserId(j.getInt("userId"));
			user.setUserName(j.getString("userName"));
			if(!StringUtils.isBlank(j.getString("time"))) {
				user.setTime(new Timestamp(sdf.parse(j.getString("time")).getTime()));				
			}
			userList.add(user);
		}
		for(User u:userList) {
			u.show();
		}
		System.out.println(json);
	}


	private void doObject(HttpServletRequest request,
			HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		
		User user = new User(Integer.valueOf(userId), userName);
		user.show();
		
		user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			user.show();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}		
	}
	
}
