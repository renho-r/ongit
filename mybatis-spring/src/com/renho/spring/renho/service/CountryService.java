package com.renho.spring.renho.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.renho.spring.renho.dao.CountryMapper;
import com.renho.spring.renho.pojo.Country;

@Service("countryService")
public class CountryService {

	private SqlSessionFactory sessionFactory;
	
	public CountryService() {
		System.out.println("init CountryService");
	}
	
	public List<Country> find() {
		SqlSession sqlSession = sessionFactory.openSession();
		CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);
		List<Country> list = countryMapper.findAll();
		for(Country c:list) {
			System.out.println(c.getCode() + "         " + c.getName());
		}
		return list;
	}

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@Resource(name="sqlSessionFactory")
	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		System.out.println("setSessionFactory");
		this.sessionFactory = sessionFactory;
	}
	
}
