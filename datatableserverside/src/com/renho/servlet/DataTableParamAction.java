package com.renho.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.renho.servlet.datatableparam.DataTableParam;

import net.sf.json.JSONObject;


@WebServlet("/datatable")
public class DataTableParamAction extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String jsonStr = request.getParameter("jsonStr");
		JSONObject json = JSONObject.fromObject(jsonStr);
		DataTableParam dataTableParam = DataTableParamUtil.fromJson(json);
		List columnsList = dataTableParam.getColumns();
		System.out.println(columnsList.toString());
		System.out.println(dataTableParam.getStart());
		System.out.println(dataTableParam.get("renho"));
	}

}
