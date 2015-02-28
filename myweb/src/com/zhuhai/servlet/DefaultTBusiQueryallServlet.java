package com.zhuhai.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class TicketBusiQueryallServlet
 */

public class DefaultTBusiQueryallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefaultTBusiQueryallServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String startPlace = (String) session.getAttribute("start");
//		session.setAttribute("start", "");
//		session.setAttribute("end", "");
		String endPlace = (String) session.getAttribute("end");
		System.out.println("default-start:" + startPlace);
		System.out.println("default-end:" + endPlace);
		if(null != startPlace && !"".equals(startPlace) && null != endPlace && !"".equals(endPlace)) {
			String regex = "Öéº£+";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher1 = pattern.matcher(startPlace);
			Matcher matcher2 = pattern.matcher(endPlace);
			if(matcher1.find() || matcher2.find()) {
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
			}
		}
		System.out.println("doPost");
	}

}
