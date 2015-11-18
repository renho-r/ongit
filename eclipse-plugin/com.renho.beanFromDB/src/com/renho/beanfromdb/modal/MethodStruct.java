package com.renho.beanfromdb.modal;

public class MethodStruct {

	public static final String NULL = null;
	public static final int GETTER = 0;
	public static final int SETTER = 1;
	
	private int methodType;
	private String backType;
	private String methodName;
	private String paramType;
	private String paramName;
	
	public MethodStruct(int methodType) {
		this.methodType = methodType;
	}

	public int getMethodType() {
		return methodType;
	}

	public void setMethodType(int methodType) {
		this.methodType = methodType;
	}

	public String getBackType() {
		return backType;
	}

	public void setBackType(String backType) {
		this.backType = backType;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	
	
}
