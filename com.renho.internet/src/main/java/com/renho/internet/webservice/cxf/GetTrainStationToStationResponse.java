
package com.renho.internet.webservice.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetTrainStationToStationResult" type="{Yangzhili}ArrayOfTrainInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getTrainStationToStationResult"
})
@XmlRootElement(name = "GetTrainStationToStationResponse")
public class GetTrainStationToStationResponse {

    @XmlElement(name = "GetTrainStationToStationResult")
    protected ArrayOfTrainInfo getTrainStationToStationResult;

    /**
     * 获取getTrainStationToStationResult属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTrainInfo }
     *     
     */
    public ArrayOfTrainInfo getGetTrainStationToStationResult() {
        return getTrainStationToStationResult;
    }

    /**
     * 设置getTrainStationToStationResult属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTrainInfo }
     *     
     */
    public void setGetTrainStationToStationResult(ArrayOfTrainInfo value) {
        this.getTrainStationToStationResult = value;
    }

}
