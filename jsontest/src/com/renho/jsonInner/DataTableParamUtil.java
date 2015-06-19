package com.renho.jsonInner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.renho.jsonInner.pojo.DataTableParam;
import com.renho.jsonInner.pojo.DataTableParam.Columns;
import com.renho.jsonInner.pojo.DataTableParam.Order;
import com.renho.jsonInner.pojo.DataTableParam.Search;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class DataTableParamUtil {
	
	private static JsonConfig cfg = new JsonConfig();
	
	private DataTableParamUtil() throws Exception {
		throw new Exception("DataTableParamUtil不能初始化!");
	}
	
	public static DataTableParam fromJson(String dataTableParamJsonStr) {
		JSONObject dataTableParamJson = JSONObject.fromObject(dataTableParamJsonStr);
		return fromJson(dataTableParamJson);
	}
	
	public static DataTableParam fromJson(JSONObject dataTableParamJson) {
		cfg.setNewBeanInstanceStrategy(new MyNewBeanInstanceStrategy());

		DataTableParam dataTableParam = new DataTableParam();
		dataTableParam.setParamJson(dataTableParamJson);
		setList("columns", dataTableParamJson, dataTableParam, Columns.class);
		setList("order", dataTableParamJson, dataTableParam, Order.class);
		setObject("search", dataTableParamJson, dataTableParam, Search.class);
		setBasic("draw", dataTableParamJson, dataTableParam, Integer.class);
		setBasic("start", dataTableParamJson, dataTableParam, Integer.class);
		setBasic("length", dataTableParamJson, dataTableParam, Integer.class);
		
		return dataTableParam;
	}
	@SuppressWarnings("unchecked")
	private static <T> void setObject(String key, JSONObject json, DataTableParam dtp, Class<T> clazz) {
		JSONObject jsonObject = (JSONObject) json.get(key);
		T t = (T) JSONObject.toBean(jsonObject, getT(dtp, clazz), cfg);
		setInDataTableParam(key, dtp, t, clazz);
	}
	
	@SuppressWarnings("unchecked")
	private static <T> void setBasic(String key, JSONObject json, DataTableParam dtp, Class<T> clazz) {
		T t = (T) json.get(key);
		setInDataTableParam(key, dtp, t, clazz);
	}
	
	@SuppressWarnings("unchecked")
	private static <T> void setList(String key, JSONObject json, DataTableParam dtp, Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		JSONArray jsonArray = (JSONArray) json.get(key);
		if(null != jsonArray) {
			Iterator<JSONObject> it = jsonArray.iterator();
			while (it.hasNext()) {
				JSONObject temp = it.next();
				T tTemp = (T) JSONObject.toBean(temp, getT(dtp, clazz), cfg);
				list.add(tTemp);
			}			
		}
		setInDataTableParam(key, dtp, list, List.class);
	}

	@SuppressWarnings("unchecked")
	private static <T> T getT(DataTableParam dtp, Class<T> clazz) {
		Constructor<?>[] constructors = clazz.getConstructors();
		T t = null;
		try {
			t = (T) constructors[0].newInstance(dtp);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	private static String getMethodName(String key) {
		return "set" + key.substring(0, 1).toUpperCase() + key.substring(1);
	}
	
	private static <T> void setInDataTableParam(String key, DataTableParam dtp, T t, Class<T> clazz) {
		try {
			String methodName = getMethodName(key);
			Method method = DataTableParam.class.getDeclaredMethod(methodName, clazz);
			method.invoke(dtp, t);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
