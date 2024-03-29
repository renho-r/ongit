package com.renho.controller.servlet;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

/**
 * 好像只能转换Date类型?
 * 是
 * @author song
 *
 */

public class DateJsonValueProcessor implements JsonValueProcessor {
	
	public static final	String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss"; 
	private DateFormat dateFormat; 
	public DateJsonValueProcessor() { 
		this(DEFAULT_DATE_PATTERN); 
	} 
	public DateJsonValueProcessor(String datePattern) { 
		try {
			dateFormat = new SimpleDateFormat(datePattern);
			System.out.println("OK");
		} catch (Exception ex) {
			dateFormat = new SimpleDateFormat(DEFAULT_DATE_PATTERN);
		}
	}
	@Override
	public Object processArrayValue(Object value, JsonConfig jsonConfig) {
		return process(value);
	}
	@Override
	public Object processObjectValue(String key, Object value,JsonConfig jsonConfig) { 
		return process(value);
	}
	
	private Object process(Object value) {
		if(value instanceof Timestamp)
			return dateFormat.format((Timestamp) value);
		else if(value instanceof Date)
			return dateFormat.format((Date) value);
		else if(value==null)
			return "";
		else
			return value.toString();
	}
} 
