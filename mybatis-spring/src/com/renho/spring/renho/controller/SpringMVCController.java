package com.renho.spring.renho.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renho.spring.renho.pojo.Country;
import com.renho.spring.renho.service.CountryService;

@Controller
public class SpringMVCController {

	@Resource(name="countryService")
	private CountryService countryService;
	
	@RequestMapping("renho/find.do")
	public String testRenho0(@RequestParam(value = "method") String method,
			HttpServletRequest request) {
		// @RequestParam��ָ����url��ַӳ���б��뺬�еĲ���(��������required=false)
		// @RequestParam�ɼ�дΪ��@RequestParam("username")
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
	
	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}
	
}
