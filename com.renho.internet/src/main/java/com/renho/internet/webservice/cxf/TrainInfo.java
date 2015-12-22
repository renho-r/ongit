
package com.renho.internet.webservice.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TrainInfo complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
 * 
 * <pre>
 * &lt;complexType name="TrainInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TrainNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Traintype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FirstStation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TerminalStation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartStation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="StartTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArriveStation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ArriveTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UseTime" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Mileage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TrainInfo", propOrder = {
    "trainNumber",
    "traintype",
    "firstStation",
    "terminalStation",
    "startStation",
    "startTime",
    "arriveStation",
    "arriveTime",
    "useTime",
    "mileage"
})
public class TrainInfo {

    @XmlElement(name = "TrainNumber")
    protected String trainNumber;
    @XmlElement(name = "Traintype")
    protected String traintype;
    @XmlElement(name = "FirstStation")
    protected String firstStation;
    @XmlElement(name = "TerminalStation")
    protected String terminalStation;
    @XmlElement(name = "StartStation")
    protected String startStation;
    @XmlElement(name = "StartTime")
    protected String startTime;
    @XmlElement(name = "ArriveStation")
    protected String arriveStation;
    @XmlElement(name = "ArriveTime")
    protected String arriveTime;
    @XmlElement(name = "UseTime")
    protected String useTime;
    @XmlElement(name = "Mileage")
    protected int mileage;

    /**
     * ��ȡtrainNumber���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrainNumber() {
        return trainNumber;
    }

    /**
     * ����trainNumber���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrainNumber(String value) {
        this.trainNumber = value;
    }

    /**
     * ��ȡtraintype���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTraintype() {
        return traintype;
    }

    /**
     * ����traintype���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTraintype(String value) {
        this.traintype = value;
    }

    /**
     * ��ȡfirstStation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirstStation() {
        return firstStation;
    }

    /**
     * ����firstStation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirstStation(String value) {
        this.firstStation = value;
    }

    /**
     * ��ȡterminalStation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalStation() {
        return terminalStation;
    }

    /**
     * ����terminalStation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalStation(String value) {
        this.terminalStation = value;
    }

    /**
     * ��ȡstartStation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartStation() {
        return startStation;
    }

    /**
     * ����startStation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartStation(String value) {
        this.startStation = value;
    }

    /**
     * ��ȡstartTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * ����startTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartTime(String value) {
        this.startTime = value;
    }

    /**
     * ��ȡarriveStation���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArriveStation() {
        return arriveStation;
    }

    /**
     * ����arriveStation���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArriveStation(String value) {
        this.arriveStation = value;
    }

    /**
     * ��ȡarriveTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArriveTime() {
        return arriveTime;
    }

    /**
     * ����arriveTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArriveTime(String value) {
        this.arriveTime = value;
    }

    /**
     * ��ȡuseTime���Ե�ֵ��
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUseTime() {
        return useTime;
    }

    /**
     * ����useTime���Ե�ֵ��
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUseTime(String value) {
        this.useTime = value;
    }

    /**
     * ��ȡmileage���Ե�ֵ��
     * 
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * ����mileage���Ե�ֵ��
     * 
     */
    public void setMileage(int value) {
        this.mileage = value;
    }

}
