
package com.renho.internet.webservice.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GetTrainDetailInfoByTrainNumberResult" type="{Yangzhili}ArrayOfTrainDetailInfo" minOccurs="0"/>
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
    "getTrainDetailInfoByTrainNumberResult"
})
@XmlRootElement(name = "GetTrainDetailInfoByTrainNumberResponse")
public class GetTrainDetailInfoByTrainNumberResponse {

    @XmlElement(name = "GetTrainDetailInfoByTrainNumberResult")
    protected ArrayOfTrainDetailInfo getTrainDetailInfoByTrainNumberResult;

    /**
     * ��ȡgetTrainDetailInfoByTrainNumberResult���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfTrainDetailInfo }
     *     
     */
    public ArrayOfTrainDetailInfo getGetTrainDetailInfoByTrainNumberResult() {
        return getTrainDetailInfoByTrainNumberResult;
    }

    /**
     * ����getTrainDetailInfoByTrainNumberResult���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfTrainDetailInfo }
     *     
     */
    public void setGetTrainDetailInfoByTrainNumberResult(ArrayOfTrainDetailInfo value) {
        this.getTrainDetailInfoByTrainNumberResult = value;
    }

}
