package com.renho.spring.renho.dao;

import java.util.List;

import com.renho.spring.renho.pojo.Country;

public interface CountryMapper {
	public List<Country> findAll();
	public int addCountry(Country country);
}
