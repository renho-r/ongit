package com.renho.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.renho.dao.OnlyVarcharMapper;
import com.renho.pojo.OnlyVarchar;

public class OnlyVarcharTest {

	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory = null;
		String resource = "configuration.xml";
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		try {
			long start = System.currentTimeMillis();
			SqlSession sqlSession = getSessionFactory().openSession();
			OnlyVarcharMapper onlyVarcharMapper = sqlSession.getMapper(OnlyVarcharMapper.class);
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\renho\\Desktop\\ip_as_cc\\ip_as_cc.txt"));
			List<OnlyVarchar> list = new ArrayList<>();
			String line = null;
			OnlyVarchar ov = null;
			int i = 1;
			while(null != (line=br.readLine())) {
				line = new String(line.getBytes(), "UTF-8");
				ov = new OnlyVarchar();
				ov.setDes(line);
				list.add(ov);
//				onlyVarcharMapper.add(ov);
				if(0 == i%10000) {
					System.out.println(i);
					onlyVarcharMapper.addList(list);
					list.clear();
				}
				i++;
			}
			br.close();
			onlyVarcharMapper.addList(list);
			sqlSession.commit();
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
