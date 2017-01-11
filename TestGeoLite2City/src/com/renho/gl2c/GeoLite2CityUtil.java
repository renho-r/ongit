package com.renho.gl2c;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;
import com.maxmind.geoip2.record.Subdivision;

public class GeoLite2CityUtil {

	private static final String FILE_PATH = "E://GeoLite2/GeoLite2-City.mmdb";
	private static final String REMOVE_STR = "省|市";
	
	private GeoLite2CityUtil() throws Exception {
		throw new Exception("GeoLite2CityUtil不可实例化");
	}
	
	public static String getSubdivision(String ip) throws IOException, GeoIp2Exception {
		File database = new File(FILE_PATH);
		DatabaseReader reader = new DatabaseReader.Builder(database).build();
		InetAddress ipAddress = InetAddress.getByName(ip);
		CityResponse response = reader.city(ipAddress);
		List<Subdivision> list = response.getSubdivisions();
		String provinceName = "未知省份";
		if(null != list && list.size() > 0 && null != list.get(0).getNames() && null != list.get(0).getNames().get("zh-CN")) {
			provinceName = list.get(0).getNames().get("zh-CN").replaceAll(REMOVE_STR, "");
		}
		return provinceName;
	}
	
	public static IpLocation getLocation(String ip) throws IOException, GeoIp2Exception {
		File database = new File(FILE_PATH);
		DatabaseReader reader = new DatabaseReader.Builder(database).build();
		InetAddress ipAddress = InetAddress.getByName(ip);
		CityResponse response = reader.city(ipAddress);
		
		Country country = response.getCountry();
		String countryName = country.getNames().get("zh-CN");
		List<Subdivision> list = response.getSubdivisions();
		String provinceName = "未知省份";
		if(null != list && list.size() > 0 && null != list.get(0).getNames() && null != list.get(0).getNames().get("zh-CN")) {
			provinceName = list.get(0).getNames().get("zh-CN").replaceAll(REMOVE_STR, "");
		}
		City city = response.getCity();
		String cityName = "未知地市";
		if(null != city && null != city.getNames() && null != city.getNames().get("zh-CN")) {
			cityName = city.getNames().get("zh-CN").replaceAll(REMOVE_STR, "");
		}
		IpLocation ipLocation = new IpLocation(ip, countryName, provinceName, cityName);
		return ipLocation;
	}
}


