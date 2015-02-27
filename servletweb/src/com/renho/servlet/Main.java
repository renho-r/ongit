package com.renho.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		Connection conn = DBUtils.getConnection();
		ResultSet rs;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from scott.emp  ORDER BY empno DESC");
			rs = ps.executeQuery();
			TransformationClass tc = new TransformationClass();
			Emp s = tc.transformation(rs, Emp.class);
			System.out.println(s.getEname());
			DBUtils.close(conn, null, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
