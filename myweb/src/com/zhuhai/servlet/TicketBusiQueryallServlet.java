package com.zhuhai.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class TicketBusiQueryallServlet
 */
public class TicketBusiQueryallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TicketBusiQueryallServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String startPlace = request.getParameter("startplace");
		String endplace = request.getParameter("endplace");
		String stt = request.getParameter("stt");
		String tte = request.getParameter("tte");
		String ets = request.getParameter("ets");
		String time = request.getParameter("time");
		System.out.println("TicketBusiQueryallServlet-start:" + startPlace);
		System.out.println("TicketBusiQueryallServlet-end:" + endplace);
		String path = this.getServletContext().getRealPath("/");
		File file = new File(path + "../build/classes/com/zhuhai/servlet/json.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = "";
		String all = "";
		while(((str=br.readLine())!=null)) {
			all += str;
		}
		br.close();
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(all);
		PrintWriter out = response.getWriter();
		out.print(jsonObject);
		out.flush();
		out.close();
		System.out.println("doPost");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy");
	}
}
