package com.renho.spring.renho.dao;

import java.util.List;

import com.renho.spring.renho.pojo.Renho;

public interface RenhoMapper {
	public List<Renho> findAll();
	public int addRenho(Renho renho);
}
