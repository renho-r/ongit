package com.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-10-24T04:49:37.406Z
 * Generated source version: 2.7.7
 * 
 */
@WebService(targetNamespace = "http://demo.com/", name = "HelloWord")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWord {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sayHi", targetNamespace = "http://demo.com/", className = "com.demo.SayHi")
    @WebMethod
    @ResponseWrapper(localName = "sayHiResponse", targetNamespace = "http://demo.com/", className = "com.demo.SayHiResponse")
    public java.lang.String sayHi(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}