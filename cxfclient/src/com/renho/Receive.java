package com.renho;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.7
 * 2013-10-24T04:47:28.921Z
 * Generated source version: 2.7.7
 * 
 */
@WebService(targetNamespace = "http://renho.com/", name = "Receive")
@XmlSeeAlso({ObjectFactory.class})
public interface Receive {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "sendXML", targetNamespace = "http://renho.com/", className = "com.renho.SendXML")
    @WebMethod
    @ResponseWrapper(localName = "sendXMLResponse", targetNamespace = "http://renho.com/", className = "com.renho.SendXMLResponse")
    public java.lang.String sendXML(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
