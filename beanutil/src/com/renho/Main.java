package com.renho;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import com.renho.pojo.User;

public class Main {

	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("id", "0001");
//		map.put("name", "renho");
//		map.put("age", 50);
//		map.put("fAge", 50.0f);
//		map.put("date", new Date());
////		map.put("renho", "renho");
//		User user = new User();
//		BeanUtils.populate(user, map);
//		System.out.println(user);
//		Set<Map.Entry<String, Object>> set = map.entrySet();
//		Iterator<Map.Entry<String, Object>> it = set.iterator();
//		while(it.hasNext()) {
//			Map.Entry<String, Object> object = it.next();
//			System.out.println(object + ":" + object.getKey() + ":" + object.getValue());
//		}
//		System.out.println(StringUtils.isEmpty("renho"));
//		System.out.println(StringUtils.difference("renho", "renho001renho0"));
//		
//		abstract class Renho {
//			abstract String showName(String name);
//		}
//		Renho renho = new Renho() {
//			
//			@Override
//			String showName(String name) {
//				return name;
//			}
//		};
//		System.out.println(renho.showName("renho0"));
		
//		List<String> list = new ArrayList<String>();
//		test(list);
//		System.out.println(list);
//		try {
//			throw new Exception();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("renho");
	}

	public static void test(List<String> list) {
		list.add("renho");
	}
	
}
