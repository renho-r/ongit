package com.renho.internet.webservice.cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.6.10
 * 2015-11-24T15:41:29.456+08:00
 * Generated source version: 2.6.10
 * 
 */
@WebService(targetNamespace = "Yangzhili", name = "TrainServiceHttpGet")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TrainServiceHttpGet {

    /**
     * <h3>站到站查询</h3>输入参数:发车站和目的站，依据输入的站名返回实体集。TrainNumber：车次，Traintype：类型，FirstStation：始发站，TerminalStation：终点站，StartStation：出发站，StartTime：发车时间，ArriveStation：目的站，ArriveTime：到达目的站的时间，UseTime：用时，Mileage：出发站到达目的站的里程，查询过程失败或异常TrainNumber为False。
     */
    @WebResult(name = "ArrayOfTrainInfo", targetNamespace = "Yangzhili", partName = "Body")
    @WebMethod(operationName = "GetTrainStationToStation")
    public ArrayOfTrainInfo getTrainStationToStation(
        @WebParam(partName = "startStation", name = "startStation", targetNamespace = "Yangzhili")
        java.lang.String startStation,
        @WebParam(partName = "arriveStation", name = "arriveStation", targetNamespace = "Yangzhili")
        java.lang.String arriveStation,
        @WebParam(partName = "UserId", name = "UserId", targetNamespace = "Yangzhili")
        java.lang.String userId
    );

    /**
     * <h3>站到站查询（JSON）</h3>输入参数:发车站和目的站，依据输入的站名返回JSON数据。TrainNumber：车次，Traintype：类型，FirstStation：始发站，TerminalStation：终点站，StartStation：出发站，StartTime：发车时间，ArriveStation：目的站，ArriveTime：到达目的站的时间，UseTime：用时，Mileage：出发站到达目的站的里程，查询过程失败或异常TrainNumber为False。
     */
    @WebResult(name = "string", targetNamespace = "Yangzhili", partName = "Body")
    @WebMethod(operationName = "GetJsonTrainStationToStation")
    public java.lang.String getJsonTrainStationToStation(
        @WebParam(partName = "startStation", name = "startStation", targetNamespace = "Yangzhili")
        java.lang.String startStation,
        @WebParam(partName = "arriveStation", name = "arriveStation", targetNamespace = "Yangzhili")
        java.lang.String arriveStation,
        @WebParam(partName = "UserId", name = "UserId", targetNamespace = "Yangzhili")
        java.lang.String userId
    );

    /**
     * <h3>车次详情查询</h3>输入参数:车次，依据该车次代码返回实体集。trainNumber：车次，Traintype：类型，StationNo：站次，Station：站名，Day：日期，ArriveTime：到达时间，DepartureTime：开车时间，Mileage：里程，查询过程失败或异常TrainNumber为False。
     */
    @WebResult(name = "ArrayOfTrainDetailInfo", targetNamespace = "Yangzhili", partName = "Body")
    @WebMethod(operationName = "GetTrainDetailInfoByTrainNumber")
    public ArrayOfTrainDetailInfo getTrainDetailInfoByTrainNumber(
        @WebParam(partName = "trainNumber", name = "trainNumber", targetNamespace = "Yangzhili")
        java.lang.String trainNumber,
        @WebParam(partName = "UserId", name = "UserId", targetNamespace = "Yangzhili")
        java.lang.String userId
    );

    /**
     * <h3>车次详情查询（JSON）</h3>输入参数:车次，依据该车次代码返回JSON数据。trainNumber：车次，Traintype：类型，StationNo：站次，Station：站名，Day：日期，ArriveTime：到达时间，DepartureTime：开车时间，Mileage：里程，查询过程失败或异常TrainNumber为False。
     */
    @WebResult(name = "string", targetNamespace = "Yangzhili", partName = "Body")
    @WebMethod(operationName = "GetJsonDetailInfoByTrainNumber")
    public java.lang.String getJsonDetailInfoByTrainNumber(
        @WebParam(partName = "trainNumber", name = "trainNumber", targetNamespace = "Yangzhili")
        java.lang.String trainNumber,
        @WebParam(partName = "UserId", name = "UserId", targetNamespace = "Yangzhili")
        java.lang.String userId
    );
}
