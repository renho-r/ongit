package com.renho.spring.renho.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renho.spring.renho.pojo.Renho;
import com.renho.spring.renho.service.RenhoService;

@Controller
public class SpringMVCRenhoController {

	@Resource(name="renhoService")
	private RenhoService renhoService;
	
	@RequestMapping("renho/findRenho.do")
	public String testRenho0(@RequestParam(value = "method") String method,
			HttpServletRequest request) {
		// @RequestParam��ָ����url��ַӳ���б��뺬�еĲ���(��������required=false)
		// @RequestParam�ɼ�дΪ��@RequestParam("username")
		System.out.println(method);
		List<Renho> list = renhoService.find();
		if(list.isEmpty()) {
			return "index";			
		}else {
			request.setAttribute("renho", list);
			return "showCountry";
		}
	}

	@RequestMapping("renho/addRenho.do")
	public String addRenho(){
		Renho renho = renhoService.add();
		return "showCountry";
	}

	public RenhoService getRenhoService() {
		return renhoService;
	}

	public void setRenhoService(RenhoService renhoService) {
		this.renhoService = renhoService;
	}
	
	
}
