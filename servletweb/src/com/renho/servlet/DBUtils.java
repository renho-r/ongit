package com.renho.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	private static DBUtils d = new DBUtils();
	private static Properties p = new Properties();
	
	static {
		
		try {
			p.load(d.getClass().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�����ļ�����ʧ��!"+e.getMessage());
		}
	}
	
	public static Connection getConnection() {
		
		String dbname = p.getProperty("dbname").trim();
		String ip = p.getProperty("ip").trim();
		String port = p.getProperty("port").trim();
		String username = p.getProperty("username").trim();
		String password = p.getProperty("password").trim();
		Connection con = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("������δ�ҵ�" + e1.getMessage());
		}
		
		StringBuffer url = new StringBuffer("jdbc:oracle:thin:@");
		url.append(ip);
		url.append(":");
		url.append(port);
		url.append(":");
		url.append(dbname);
		
		try {
			con = DriverManager.getConnection(url.toString(), username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����ʧ��!" + e.getMessage());
		}
		
		return con;
		
	} 
	
	public static void close(Connection con, PreparedStatement pstam, ResultSet rs) {
		
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("con�ر�ʧ��!" + e.getMessage());
			}
		}
		
		if(pstam != null) {
			
			try {
				pstam.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("pstam�ر�ʧ��!" + e.getMessage());
			}
		}
		
		if(rs != null) {
			
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("rs�ر�ʧ��!" + e.getMessage());
			}
		}
		
	}
}
