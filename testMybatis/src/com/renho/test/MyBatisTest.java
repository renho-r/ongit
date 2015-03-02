package com.renho.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.renho.dao.CityMapper;
import com.renho.pojo.City;

/**
 * myBatis���ݿ����Ӳ���
 *
 */
public class MyBatisTest {
	/**
	 * ���MyBatis SqlSessionFactory
	 * SqlSessionFactory���𴴽�SqlSession��һ�������ɹ����Ϳ�����SqlSessionʵ����ִ��ӳ�����
	 * ��commit��rollback��close�ȷ�����
	 * 
	 * @return
	 */
	private static SqlSessionFactory getSessionFactory() {
		SqlSessionFactory sessionFactory = null;
		String resource = "configuration.xml";
		try {
			sessionFactory = new SqlSessionFactoryBuilder().build(Resources
					.getResourceAsReader(resource));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sessionFactory;
	}

	public static void main(String[] args) {
		SqlSession sqlSession = getSessionFactory().openSession();
		CityMapper cityMapper = sqlSession.getMapper(CityMapper.class);
		City city = cityMapper.findById(new Integer(1));
		System.out.println(city.getName());

		System.out.println("----------------------select-----------------------");
		List<City> list = cityMapper.findAll();
		for (City c : list) {
			System.out.println(c.getId() + "      " + c.getName() + "      "
					+ c.getCountryCode() + "      " + c.getDistrict()
					+ "      " + c.getPopulation());
		}
		System.out.println("----------------------insert-----------------------");
		City city0 = new City();
		city0.setName("renho");
		city0.setCountryCode("998");
		city0.setDistrict("district");
		city0.setPopulation(9999);
		int flag = cityMapper.addCity(city0);
		System.out.println(flag);
		System.out.println("id=" + city0.getId());
		System.out.println("----------------------delete-----------------------");
		flag = cityMapper.deleteByName("renho");
		System.out.println(flag);
		System.out.println("----------------------update-----------------------");
		city0.setId(4094);
		city0.setName("renho1");
		flag = cityMapper.updateCity(city0);
		System.out.println(flag);
 	}

}