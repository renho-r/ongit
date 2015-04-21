package com.renho.controller.servlet;

import java.sql.Timestamp;

import org.apache.commons.beanutils.converters.DateTimeConverter;

public class TimestampConverter extends DateTimeConverter {

	@Override
	protected Class<?> getDefaultType() {
		return Timestamp.class;
	}

	@Override
	protected <T> T convertToType(Class<T> targetType, Object value)
			throws Exception {
		if (value == null) {
			return null;
		}
		String backValue = value.toString().trim();
		if (backValue.length() == 0) {
			return null;
		}
		return super.convertToType(targetType, backValue);
	}
}