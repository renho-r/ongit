package com.renho.servlet;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Emp implements SupperPojo{

	private String ename;
	private Long deptno;
	private float sal;
	private Timestamp hiredate;
	
	public Timestamp getHiredate() {
		return hiredate;
	}
	public void setHiredate(Timestamp hiredate) {
		this.hiredate = hiredate;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	
	@Override
	public String toString() {
		return "ename:" + ename + "-deptno:" + deptno + "-sal:" + sal + "-hiredate:" + hiredate;
	}
	@Override
	public Map<String, String> getMapping() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("ename", "ename");
		map.put("deptno", "deptno");
		map.put("sal", "sal");
		map.put("hiredate", "hiredate");
		return map;
	}
}
