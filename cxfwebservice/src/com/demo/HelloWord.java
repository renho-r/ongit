package com.demo;

import javax.jws.WebParam;
import javax.jws.WebService;

/** */
/**
 * service interface
 * 
 * @author
 * 
 */
@WebService
public interface HelloWord {
	String sayHi(String text);//∫√”√
//	String sayHi(@WebParam (name="text" ) String text);
//	String sayHi(@WebParam(name="text",targetNamespace = "http://demo.com/",mode = WebParam.Mode.IN) String text);
}
