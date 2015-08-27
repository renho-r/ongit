package com.renho.spring.renho.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataTablesController {

	@RequestMapping("renho/queryAllAsArray.do")
	@ResponseBody
	public String queryAllAsArray(HttpServletRequest request) {
		Logger logger = Logger.getLogger(this.getClass());
		logger.info(request.getParameter("draw"));
		return "{\"key-renho\": \"value-renho\"}";
	}
	
}
