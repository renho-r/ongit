
package com.renho.internet.webservice.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.renho.internet.webservice.cxf package. 
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

    private final static QName _ArrayOfTrainDetailInfo_QNAME = new QName("Yangzhili", "ArrayOfTrainDetailInfo");
    private final static QName _String_QNAME = new QName("Yangzhili", "string");
    private final static QName _ArrayOfTrainInfo_QNAME = new QName("Yangzhili", "ArrayOfTrainInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.renho.internet.webservice.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTrainStationToStationResponse }
     * 
     */
    public GetTrainStationToStationResponse createGetTrainStationToStationResponse() {
        return new GetTrainStationToStationResponse();
    }

    /**
     * Create an instance of {@link ArrayOfTrainInfo }
     * 
     */
    public ArrayOfTrainInfo createArrayOfTrainInfo() {
        return new ArrayOfTrainInfo();
    }

    /**
     * Create an instance of {@link GetTrainDetailInfoByTrainNumberResponse }
     * 
     */
    public GetTrainDetailInfoByTrainNumberResponse createGetTrainDetailInfoByTrainNumberResponse() {
        return new GetTrainDetailInfoByTrainNumberResponse();
    }

    /**
     * Create an instance of {@link ArrayOfTrainDetailInfo }
     * 
     */
    public ArrayOfTrainDetailInfo createArrayOfTrainDetailInfo() {
        return new ArrayOfTrainDetailInfo();
    }

    /**
     * Create an instance of {@link GetJsonDetailInfoByTrainNumberResponse }
     * 
     */
    public GetJsonDetailInfoByTrainNumberResponse createGetJsonDetailInfoByTrainNumberResponse() {
        return new GetJsonDetailInfoByTrainNumberResponse();
    }

    /**
     * Create an instance of {@link GetTrainStationToStation }
     * 
     */
    public GetTrainStationToStation createGetTrainStationToStation() {
        return new GetTrainStationToStation();
    }

    /**
     * Create an instance of {@link GetJsonTrainStationToStation }
     * 
     */
    public GetJsonTrainStationToStation createGetJsonTrainStationToStation() {
        return new GetJsonTrainStationToStation();
    }

    /**
     * Create an instance of {@link GetTrainDetailInfoByTrainNumber }
     * 
     */
    public GetTrainDetailInfoByTrainNumber createGetTrainDetailInfoByTrainNumber() {
        return new GetTrainDetailInfoByTrainNumber();
    }

    /**
     * Create an instance of {@link GetJsonTrainStationToStationResponse }
     * 
     */
    public GetJsonTrainStationToStationResponse createGetJsonTrainStationToStationResponse() {
        return new GetJsonTrainStationToStationResponse();
    }

    /**
     * Create an instance of {@link GetJsonDetailInfoByTrainNumber }
     * 
     */
    public GetJsonDetailInfoByTrainNumber createGetJsonDetailInfoByTrainNumber() {
        return new GetJsonDetailInfoByTrainNumber();
    }

    /**
     * Create an instance of {@link TrainDetailInfo }
     * 
     */
    public TrainDetailInfo createTrainDetailInfo() {
        return new TrainDetailInfo();
    }

    /**
     * Create an instance of {@link TrainInfo }
     * 
     */
    public TrainInfo createTrainInfo() {
        return new TrainInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTrainDetailInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "Yangzhili", name = "ArrayOfTrainDetailInfo")
    public JAXBElement<ArrayOfTrainDetailInfo> createArrayOfTrainDetailInfo(ArrayOfTrainDetailInfo value) {
        return new JAXBElement<ArrayOfTrainDetailInfo>(_ArrayOfTrainDetailInfo_QNAME, ArrayOfTrainDetailInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "Yangzhili", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfTrainInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "Yangzhili", name = "ArrayOfTrainInfo")
    public JAXBElement<ArrayOfTrainInfo> createArrayOfTrainInfo(ArrayOfTrainInfo value) {
        return new JAXBElement<ArrayOfTrainInfo>(_ArrayOfTrainInfo_QNAME, ArrayOfTrainInfo.class, null, value);
    }

}
