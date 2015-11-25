<?xml version="1.0" encoding="utf-8"?>
<wsdl:definitions xmlns:s="http://www.w3.org/2001/XMLSchema" xmlns:soap12="http://schemas.xmlsoap.org/wsdl/soap12/" xmlns:http="http://schemas.xmlsoap.org/wsdl/http/" xmlns:mime="http://schemas.xmlsoap.org/wsdl/mime/" xmlns:tns="Yangzhili" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:tm="http://microsoft.com/wsdl/mime/textMatching/" xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/" targetNamespace="Yangzhili" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">
  <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">高效/快捷/实时,为您打造全方位云数据服务。  电话：029-68859950  了解更多访问:&lt;a href='http://www.36wu.com' target='_blank'&gt;http://www.36wu.com&lt;/a&gt;</wsdl:documentation>
  <wsdl:types>
    <s:schema elementFormDefault="qualified" targetNamespace="Yangzhili">
      <s:element name="GetTrainDetailInfoByTrainNumber">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="trainNumber" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="UserId" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTrainDetailInfoByTrainNumberResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetTrainDetailInfoByTrainNumberResult" type="tns:ArrayOfTrainDetailInfo" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfTrainDetailInfo">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="TrainDetailInfo" nillable="true" type="tns:TrainDetailInfo" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="TrainDetailInfo">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="TrainNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Traintype" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="StationNo" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Station" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Day" type="s:int" />
          <s:element minOccurs="0" maxOccurs="1" name="ArriveTime" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="DepartureTime" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Mileage" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetJsonDetailInfoByTrainNumber">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="trainNumber" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="UserId" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetJsonDetailInfoByTrainNumberResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetJsonDetailInfoByTrainNumberResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTrainStationToStation">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="startStation" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="arriveStation" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="UserId" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetTrainStationToStationResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetTrainStationToStationResult" type="tns:ArrayOfTrainInfo" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:complexType name="ArrayOfTrainInfo">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="unbounded" name="TrainInfo" nillable="true" type="tns:TrainInfo" />
        </s:sequence>
      </s:complexType>
      <s:complexType name="TrainInfo">
        <s:sequence>
          <s:element minOccurs="0" maxOccurs="1" name="TrainNumber" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="Traintype" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="FirstStation" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="TerminalStation" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="StartStation" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="StartTime" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ArriveStation" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="ArriveTime" type="s:string" />
          <s:element minOccurs="0" maxOccurs="1" name="UseTime" type="s:string" />
          <s:element minOccurs="1" maxOccurs="1" name="Mileage" type="s:int" />
        </s:sequence>
      </s:complexType>
      <s:element name="GetJsonTrainStationToStation">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="startStation" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="arriveStation" type="s:string" />
            <s:element minOccurs="0" maxOccurs="1" name="UserId" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="GetJsonTrainStationToStationResponse">
        <s:complexType>
          <s:sequence>
            <s:element minOccurs="0" maxOccurs="1" name="GetJsonTrainStationToStationResult" type="s:string" />
          </s:sequence>
        </s:complexType>
      </s:element>
      <s:element name="ArrayOfTrainDetailInfo" nillable="true" type="tns:ArrayOfTrainDetailInfo" />
      <s:element name="string" nillable="true" type="s:string" />
      <s:element name="ArrayOfTrainInfo" nillable="true" type="tns:ArrayOfTrainInfo" />
    </s:schema>
  </wsdl:types>
  <wsdl:message name="GetTrainDetailInfoByTrainNumberSoapIn">
    <wsdl:part name="parameters" element="tns:GetTrainDetailInfoByTrainNumber" />
  </wsdl:message>
  <wsdl:message name="GetTrainDetailInfoByTrainNumberSoapOut">
    <wsdl:part name="parameters" element="tns:GetTrainDetailInfoByTrainNumberResponse" />
  </wsdl:message>
  <wsdl:message name="GetJsonDetailInfoByTrainNumberSoapIn">
    <wsdl:part name="parameters" element="tns:GetJsonDetailInfoByTrainNumber" />
  </wsdl:message>
  <wsdl:message name="GetJsonDetailInfoByTrainNumberSoapOut">
    <wsdl:part name="parameters" element="tns:GetJsonDetailInfoByTrainNumberResponse" />
  </wsdl:message>
  <wsdl:message name="GetTrainStationToStationSoapIn">
    <wsdl:part name="parameters" element="tns:GetTrainStationToStation" />
  </wsdl:message>
  <wsdl:message name="GetTrainStationToStationSoapOut">
    <wsdl:part name="parameters" element="tns:GetTrainStationToStationResponse" />
  </wsdl:message>
  <wsdl:message name="GetJsonTrainStationToStationSoapIn">
    <wsdl:part name="parameters" element="tns:GetJsonTrainStationToStation" />
  </wsdl:message>
  <wsdl:message name="GetJsonTrainStationToStationSoapOut">
    <wsdl:part name="parameters" element="tns:GetJsonTrainStationToStationResponse" />
  </wsdl:message>
  <wsdl:message name="GetTrainDetailInfoByTrainNumberHttpGetIn">
    <wsdl:part name="trainNumber" type="s:string" />
    <wsdl:part name="UserId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTrainDetailInfoByTrainNumberHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfTrainDetailInfo" />
  </wsdl:message>
  <wsdl:message name="GetJsonDetailInfoByTrainNumberHttpGetIn">
    <wsdl:part name="trainNumber" type="s:string" />
    <wsdl:part name="UserId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetJsonDetailInfoByTrainNumberHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetTrainStationToStationHttpGetIn">
    <wsdl:part name="startStation" type="s:string" />
    <wsdl:part name="arriveStation" type="s:string" />
    <wsdl:part name="UserId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTrainStationToStationHttpGetOut">
    <wsdl:part name="Body" element="tns:ArrayOfTrainInfo" />
  </wsdl:message>
  <wsdl:message name="GetJsonTrainStationToStationHttpGetIn">
    <wsdl:part name="startStation" type="s:string" />
    <wsdl:part name="arriveStation" type="s:string" />
    <wsdl:part name="UserId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetJsonTrainStationToStationHttpGetOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetTrainDetailInfoByTrainNumberHttpPostIn">
    <wsdl:part name="trainNumber" type="s:string" />
    <wsdl:part name="UserId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTrainDetailInfoByTrainNumberHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfTrainDetailInfo" />
  </wsdl:message>
  <wsdl:message name="GetJsonDetailInfoByTrainNumberHttpPostIn">
    <wsdl:part name="trainNumber" type="s:string" />
    <wsdl:part name="UserId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetJsonDetailInfoByTrainNumberHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:message name="GetTrainStationToStationHttpPostIn">
    <wsdl:part name="startStation" type="s:string" />
    <wsdl:part name="arriveStation" type="s:string" />
    <wsdl:part name="UserId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetTrainStationToStationHttpPostOut">
    <wsdl:part name="Body" element="tns:ArrayOfTrainInfo" />
  </wsdl:message>
  <wsdl:message name="GetJsonTrainStationToStationHttpPostIn">
    <wsdl:part name="startStation" type="s:string" />
    <wsdl:part name="arriveStation" type="s:string" />
    <wsdl:part name="UserId" type="s:string" />
  </wsdl:message>
  <wsdl:message name="GetJsonTrainStationToStationHttpPostOut">
    <wsdl:part name="Body" element="tns:string" />
  </wsdl:message>
  <wsdl:portType name="TrainServiceSoap">
    <wsdl:operation name="GetTrainDetailInfoByTrainNumber">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;车次详情查询&lt;/h3&gt;输入参数:车次，依据该车次代码返回实体集。trainNumber：车次，Traintype：类型，StationNo：站次，Station：站名，Day：日期，ArriveTime：到达时间，DepartureTime：开车时间，Mileage：里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetTrainDetailInfoByTrainNumberSoapIn" />
      <wsdl:output message="tns:GetTrainDetailInfoByTrainNumberSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJsonDetailInfoByTrainNumber">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;车次详情查询（JSON）&lt;/h3&gt;输入参数:车次，依据该车次代码返回JSON数据。trainNumber：车次，Traintype：类型，StationNo：站次，Station：站名，Day：日期，ArriveTime：到达时间，DepartureTime：开车时间，Mileage：里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetJsonDetailInfoByTrainNumberSoapIn" />
      <wsdl:output message="tns:GetJsonDetailInfoByTrainNumberSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTrainStationToStation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;站到站查询&lt;/h3&gt;输入参数:发车站和目的站，依据输入的站名返回实体集。TrainNumber：车次，Traintype：类型，FirstStation：始发站，TerminalStation：终点站，StartStation：出发站，StartTime：发车时间，ArriveStation：目的站，ArriveTime：到达目的站的时间，UseTime：用时，Mileage：出发站到达目的站的里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetTrainStationToStationSoapIn" />
      <wsdl:output message="tns:GetTrainStationToStationSoapOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJsonTrainStationToStation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;站到站查询（JSON）&lt;/h3&gt;输入参数:发车站和目的站，依据输入的站名返回JSON数据。TrainNumber：车次，Traintype：类型，FirstStation：始发站，TerminalStation：终点站，StartStation：出发站，StartTime：发车时间，ArriveStation：目的站，ArriveTime：到达目的站的时间，UseTime：用时，Mileage：出发站到达目的站的里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetJsonTrainStationToStationSoapIn" />
      <wsdl:output message="tns:GetJsonTrainStationToStationSoapOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="TrainServiceHttpGet">
    <wsdl:operation name="GetTrainDetailInfoByTrainNumber">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;车次详情查询&lt;/h3&gt;输入参数:车次，依据该车次代码返回实体集。trainNumber：车次，Traintype：类型，StationNo：站次，Station：站名，Day：日期，ArriveTime：到达时间，DepartureTime：开车时间，Mileage：里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetTrainDetailInfoByTrainNumberHttpGetIn" />
      <wsdl:output message="tns:GetTrainDetailInfoByTrainNumberHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJsonDetailInfoByTrainNumber">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;车次详情查询（JSON）&lt;/h3&gt;输入参数:车次，依据该车次代码返回JSON数据。trainNumber：车次，Traintype：类型，StationNo：站次，Station：站名，Day：日期，ArriveTime：到达时间，DepartureTime：开车时间，Mileage：里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetJsonDetailInfoByTrainNumberHttpGetIn" />
      <wsdl:output message="tns:GetJsonDetailInfoByTrainNumberHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTrainStationToStation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;站到站查询&lt;/h3&gt;输入参数:发车站和目的站，依据输入的站名返回实体集。TrainNumber：车次，Traintype：类型，FirstStation：始发站，TerminalStation：终点站，StartStation：出发站，StartTime：发车时间，ArriveStation：目的站，ArriveTime：到达目的站的时间，UseTime：用时，Mileage：出发站到达目的站的里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetTrainStationToStationHttpGetIn" />
      <wsdl:output message="tns:GetTrainStationToStationHttpGetOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJsonTrainStationToStation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;站到站查询（JSON）&lt;/h3&gt;输入参数:发车站和目的站，依据输入的站名返回JSON数据。TrainNumber：车次，Traintype：类型，FirstStation：始发站，TerminalStation：终点站，StartStation：出发站，StartTime：发车时间，ArriveStation：目的站，ArriveTime：到达目的站的时间，UseTime：用时，Mileage：出发站到达目的站的里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetJsonTrainStationToStationHttpGetIn" />
      <wsdl:output message="tns:GetJsonTrainStationToStationHttpGetOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:portType name="TrainServiceHttpPost">
    <wsdl:operation name="GetTrainDetailInfoByTrainNumber">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;车次详情查询&lt;/h3&gt;输入参数:车次，依据该车次代码返回实体集。trainNumber：车次，Traintype：类型，StationNo：站次，Station：站名，Day：日期，ArriveTime：到达时间，DepartureTime：开车时间，Mileage：里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetTrainDetailInfoByTrainNumberHttpPostIn" />
      <wsdl:output message="tns:GetTrainDetailInfoByTrainNumberHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJsonDetailInfoByTrainNumber">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;车次详情查询（JSON）&lt;/h3&gt;输入参数:车次，依据该车次代码返回JSON数据。trainNumber：车次，Traintype：类型，StationNo：站次，Station：站名，Day：日期，ArriveTime：到达时间，DepartureTime：开车时间，Mileage：里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetJsonDetailInfoByTrainNumberHttpPostIn" />
      <wsdl:output message="tns:GetJsonDetailInfoByTrainNumberHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetTrainStationToStation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;站到站查询&lt;/h3&gt;输入参数:发车站和目的站，依据输入的站名返回实体集。TrainNumber：车次，Traintype：类型，FirstStation：始发站，TerminalStation：终点站，StartStation：出发站，StartTime：发车时间，ArriveStation：目的站，ArriveTime：到达目的站的时间，UseTime：用时，Mileage：出发站到达目的站的里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetTrainStationToStationHttpPostIn" />
      <wsdl:output message="tns:GetTrainStationToStationHttpPostOut" />
    </wsdl:operation>
    <wsdl:operation name="GetJsonTrainStationToStation">
      <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">&lt;h3&gt;站到站查询（JSON）&lt;/h3&gt;输入参数:发车站和目的站，依据输入的站名返回JSON数据。TrainNumber：车次，Traintype：类型，FirstStation：始发站，TerminalStation：终点站，StartStation：出发站，StartTime：发车时间，ArriveStation：目的站，ArriveTime：到达目的站的时间，UseTime：用时，Mileage：出发站到达目的站的里程，查询过程失败或异常TrainNumber为False。</wsdl:documentation>
      <wsdl:input message="tns:GetJsonTrainStationToStationHttpPostIn" />
      <wsdl:output message="tns:GetJsonTrainStationToStationHttpPostOut" />
    </wsdl:operation>
  </wsdl:portType>
  <wsdl:binding name="TrainServiceSoap" type="tns:TrainServiceSoap">
    <soap:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetTrainDetailInfoByTrainNumber">
      <soap:operation soapAction="Yangzhili/GetTrainDetailInfoByTrainNumber" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJsonDetailInfoByTrainNumber">
      <soap:operation soapAction="Yangzhili/GetJsonDetailInfoByTrainNumber" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTrainStationToStation">
      <soap:operation soapAction="Yangzhili/GetTrainStationToStation" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJsonTrainStationToStation">
      <soap:operation soapAction="Yangzhili/GetJsonTrainStationToStation" style="document" />
      <wsdl:input>
        <soap:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="TrainServiceSoap12" type="tns:TrainServiceSoap">
    <soap12:binding transport="http://schemas.xmlsoap.org/soap/http" />
    <wsdl:operation name="GetTrainDetailInfoByTrainNumber">
      <soap12:operation soapAction="Yangzhili/GetTrainDetailInfoByTrainNumber" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJsonDetailInfoByTrainNumber">
      <soap12:operation soapAction="Yangzhili/GetJsonDetailInfoByTrainNumber" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTrainStationToStation">
      <soap12:operation soapAction="Yangzhili/GetTrainStationToStation" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJsonTrainStationToStation">
      <soap12:operation soapAction="Yangzhili/GetJsonTrainStationToStation" style="document" />
      <wsdl:input>
        <soap12:body use="literal" />
      </wsdl:input>
      <wsdl:output>
        <soap12:body use="literal" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="TrainServiceHttpGet" type="tns:TrainServiceHttpGet">
    <http:binding verb="GET" />
    <wsdl:operation name="GetTrainDetailInfoByTrainNumber">
      <http:operation location="/GetTrainDetailInfoByTrainNumber" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJsonDetailInfoByTrainNumber">
      <http:operation location="/GetJsonDetailInfoByTrainNumber" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTrainStationToStation">
      <http:operation location="/GetTrainStationToStation" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJsonTrainStationToStation">
      <http:operation location="/GetJsonTrainStationToStation" />
      <wsdl:input>
        <http:urlEncoded />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:binding name="TrainServiceHttpPost" type="tns:TrainServiceHttpPost">
    <http:binding verb="POST" />
    <wsdl:operation name="GetTrainDetailInfoByTrainNumber">
      <http:operation location="/GetTrainDetailInfoByTrainNumber" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJsonDetailInfoByTrainNumber">
      <http:operation location="/GetJsonDetailInfoByTrainNumber" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetTrainStationToStation">
      <http:operation location="/GetTrainStationToStation" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
    <wsdl:operation name="GetJsonTrainStationToStation">
      <http:operation location="/GetJsonTrainStationToStation" />
      <wsdl:input>
        <mime:content type="application/x-www-form-urlencoded" />
      </wsdl:input>
      <wsdl:output>
        <mime:mimeXml part="Body" />
      </wsdl:output>
    </wsdl:operation>
  </wsdl:binding>
  <wsdl:service name="TrainService">
    <wsdl:documentation xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/">高效/快捷/实时,为您打造全方位云数据服务。  电话：029-68859950  了解更多访问:&lt;a href='http://www.36wu.com' target='_blank'&gt;http://www.36wu.com&lt;/a&gt;</wsdl:documentation>
    <wsdl:port name="TrainServiceSoap" binding="tns:TrainServiceSoap">
      <soap:address location="http://webservice.36wu.com/TrainService.asmx" />
    </wsdl:port>
    <wsdl:port name="TrainServiceSoap12" binding="tns:TrainServiceSoap12">
      <soap12:address location="http://webservice.36wu.com/TrainService.asmx" />
    </wsdl:port>
    <wsdl:port name="TrainServiceHttpGet" binding="tns:TrainServiceHttpGet">
      <http:address location="http://webservice.36wu.com/TrainService.asmx" />
    </wsdl:port>
    <wsdl:port name="TrainServiceHttpPost" binding="tns:TrainServiceHttpPost">
      <http:address location="http://webservice.36wu.com/TrainService.asmx" />
    </wsdl:port>
  </wsdl:service>
</wsdl:definitions>