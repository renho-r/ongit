
package com.renho;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.renho package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendXMLResponse_QNAME = new QName("http://renho.com/", "sendXMLResponse");
    private final static QName _SendXML_QNAME = new QName("http://renho.com/", "sendXML");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.renho
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendXML }
     * 
     */
    public SendXML createSendXML() {
        return new SendXML();
    }

    /**
     * Create an instance of {@link SendXMLResponse }
     * 
     */
    public SendXMLResponse createSendXMLResponse() {
        return new SendXMLResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendXMLResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://renho.com/", name = "sendXMLResponse")
    public JAXBElement<SendXMLResponse> createSendXMLResponse(SendXMLResponse value) {
        return new JAXBElement<SendXMLResponse>(_SendXMLResponse_QNAME, SendXMLResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendXML }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://renho.com/", name = "sendXML")
    public JAXBElement<SendXML> createSendXML(SendXML value) {
        return new JAXBElement<SendXML>(_SendXML_QNAME, SendXML.class, null, value);
    }

}
