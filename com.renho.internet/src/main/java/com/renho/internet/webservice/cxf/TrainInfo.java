
package com.renho.internet.webservice.cxf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>TrainInfo complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
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
     * 获取trainNumber属性的值。
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
     * 设置trainNumber属性的值。
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
     * 获取traintype属性的值。
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
     * 设置traintype属性的值。
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
     * 获取firstStation属性的值。
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
     * 设置firstStation属性的值。
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
     * 获取terminalStation属性的值。
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
     * 设置terminalStation属性的值。
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
     * 获取startStation属性的值。
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
     * 设置startStation属性的值。
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
     * 获取startTime属性的值。
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
     * 设置startTime属性的值。
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
     * 获取arriveStation属性的值。
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
     * 设置arriveStation属性的值。
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
     * 获取arriveTime属性的值。
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
     * 设置arriveTime属性的值。
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
     * 获取useTime属性的值。
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
     * 设置useTime属性的值。
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
     * 获取mileage属性的值。
     * 
     */
    public int getMileage() {
        return mileage;
    }

    /**
     * 设置mileage属性的值。
     * 
     */
    public void setMileage(int value) {
        this.mileage = value;
    }

}
