package com.renho.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.renho.dao.CityMapper;
import com.renho.pojo.City;

public class CityService {

	private SqlSessionFactory sessionFactory;
	
	public void find() {
		
		SqlSession sqlSession = sessionFactory.openSession();
		CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
		City city = cityMapper.findById(new Integer(1));
		System.out.println(city.getName());

		System.out.println("----------------------select start-----------------------");
		List<City> list = cityMapper.findAll();
		for (City c : list) {
			System.out.println(c.getId() + "      " + c.getName() + "      "
					+ c.getCountryCode() + "      " + c.getDistrict()
					+ "      " + c.getPopulation());
		}
		System.out.println("----------------------select end-----------------------");
	}
	
	public int addCity() {
		System.out.println("----------------------insert start-----------------------");
		SqlSession sqlSession = sessionFactory.openSession();
		CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
		City city0 = new City();
		city0.setName("renho");
		city0.setCountryCode("998");
		city0.setDistrict("district");
		city0.setPopulation(9999);
		int flag = cityMapper.addCity(city0);
		System.out.println(flag);
		System.out.println("id=" + city0.getId());
		System.out.println("----------------------insert end-----------------------");
		return flag;
	}
	
	public int deleteByName(String name) {
		System.out.println("----------------------delete start-----------------------");
		SqlSession sqlSession = sessionFactory.openSession();
		CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
		int flag = cityMapper.deleteByName("renho");
		System.out.println(flag);
		System.out.println("----------------------delete end-----------------------");
		return flag;
	}
	public int updateCity() {
		System.out.println("----------------------update start-----------------------");
		SqlSession sqlSession = sessionFactory.openSession();
		CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
		City city0 = new City();
		
		city0.setCountryCode("998");
		city0.setDistrict("district");
		city0.setPopulation(9999);
		city0.setId(4102);
		city0.setName("renho1");
		
		int flag = cityMapper.updateCity(city0);
		System.out.println(flag);
		System.out.println("----------------------update end-----------------------");
		return flag;
	}

	public SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
