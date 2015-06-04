package com.renho.dao;

import java.util.List;

import com.renho.pojo.City;

public interface CityMapper {

	public City findById(Integer id);
	public List<City> findAll();
	public int addCity(City city);
	public int deleteByName(String name);
	public int updateCity(City city);
}
