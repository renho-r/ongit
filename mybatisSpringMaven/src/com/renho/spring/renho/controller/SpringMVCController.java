package com.renho.spring.renho.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renho.spring.renho.pojo.Country;
import com.renho.spring.renho.service.CountryService;

@Controller
public class SpringMVCController {

	@Resource(name="countryService")
	private CountryService countryService;
	
	@RequestMapping("renho/find.do")
	public String testRenho0(@RequestParam(value = "method") String method,
			HttpServletRequest request) {
		// @RequestParam是指请求url地址映射中必须含有的参数(除非属性required=false)
		// @RequestParam可简写为：@RequestParam("username")
		System.out.println(method);
		List<Country> list = countryService.find();
		if(list.isEmpty()) {
			return "index";			
		}else {
			request.setAttribute("renho", list);
			return "showCountry";
		}
	}

	@RequestMapping("renho/add.do")
	public int addCountry(Country country) {
		return 1;
	}
	
	@RequestMapping("renho/backNull.do")
	public String backNull(Country country) {
		return null;
	}
	@RequestMapping("renho/backJson.do")
	@ResponseBody
	public String backJson(Country country) {
		return "{\"key-renho\": \"value-renho\"}";
	}
	
	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}
	
}
