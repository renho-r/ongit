package com.renho.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/AdminAddServlet")
public class AdminAddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Connection conn = DBUtils.getConnection();
		ResultSet rs;
		System.out.println("--------------------------------------------");
		try {
			PreparedStatement ps = conn.prepareStatement("select * from emp where deptno=?");
			ps.setInt(1, 30);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("ename"));
			}
//			TransformationClass tc = new TransformationClass();
//			tc.transformation(rs, Emp.class);
			DBUtils.close(conn, null, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
