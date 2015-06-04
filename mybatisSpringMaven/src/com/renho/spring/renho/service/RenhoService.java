package com.renho.spring.renho.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.renho.spring.renho.dao.RenhoMapper;
import com.renho.spring.renho.pojo.Renho;

@Service("renhoService")
public class RenhoService {

	private SqlSessionFactory sessionFactory;
	
	public RenhoService() {
		System.out.println("init RenhoService");
	}
	
	public List<Renho> find() {
		SqlSession sqlSession = sessionFactory.openSession();
		RenhoMapper renhoMapper = sqlSession.getMapper(RenhoMapper.class);
		List<Renho> list = renhoMapper.findAll();
		for(Renho r:list) {
			System.out.println(r.getId() + "         " + r.getName());
		}
		return list;
	}
	
	public Renho add(){
		SqlSession sqlSession = sessionFactory.openSession();
		
		RenhoMapper renhoMapper = sqlSession.getMapper(RenhoMapper.class);
		Renho renho = new Renho();
		renho.setName("renho");
		renhoMapper.addRenho(renho);
		
		//≤‚ ‘ªÿÕÀ
		String s = null;
		s.equals("renho");
		
		return renho;
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
