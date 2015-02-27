package com.renho.servlet;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

public class TransformationClass {

	public <T extends SupperPojo> T transformation(ResultSet rs, Class<T> c) {
		T o = null;
		try {
			if(rs.next()) {
				o = c.newInstance();
				Map<String, String> map = o.getMapping();
				Set<String> set = map.keySet();
				for(String member:set) {
					String sqlKey = map.get(member);
					String setKeyName = getSetKeyName(member);
					Class<?> typeClass = getTypeClass(c, member);
					String getSqlName = getSqlName(typeClass.getSimpleName());
					Method rsMethod = rs.getClass().getMethod(getSqlName, String.class);
					rsMethod.setAccessible(true);
					Object objectTemp = rsMethod.invoke(rs, sqlKey);
					Method setMethod = o.getClass().getMethod(setKeyName, typeClass);
					setMethod.invoke(o, objectTemp);
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return o;
	}
	
	private Class<?> getTypeClass(Class<?> c, String fieldName) {
		Class<?> back = null;
		Field field = null;
		try {
			field = c.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			try {
				field = c.getSuperclass().getDeclaredField(fieldName);
			} catch (NoSuchFieldException e1) {
				e1.printStackTrace();
			} catch (SecurityException e1) {
				e1.printStackTrace();
			}
		}
		back = field.getType();
		return back;
	}
	
	private String getSetKeyName(String member) {
		String setKeyName = "set" + member.substring(0, 1).toUpperCase() + member.substring(1);
		return setKeyName;
	}
	
	private String getSqlName(String fieldName) {
		String getSqlName = "get";
		if("Integer".equals(fieldName)) {
			getSqlName += "Int";
		}else {
			getSqlName += fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);;
		}
		return getSqlName;
	}
	
	public static void main(String[] args) {
		Connection conn = DBUtils.getConnection();
		ResultSet rs;
		PreparedStatement ps;
		try {
			ps = conn
					.prepareStatement("select * from TRA_SHCEDULE");
			rs = ps.executeQuery();
			TransformationClass tc = new TransformationClass();
			ps = conn
					.prepareStatement("select * from scott.emp  ORDER BY empno DESC");
			rs = ps.executeQuery();
			Emp s = tc.transformation(rs, Emp.class);
			System.out.println(s.getEname());
			DBUtils.close(conn, ps, rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
