package com.renho.servlet;

import java.util.HashMap;
import java.util.Map;
public class Schcedule implements SupperPojo {
	
	private Integer startJuncId;
	private String flightId;
	private String date;
	private String endJuncId;
	private String time;
	private String estArrivingTime;
	private String scheduleClass;
	private String available;
	private Float price;
	private Integer type;
	
	@Override
	public Map<String, String> getMapping() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("startJuncId","start_junc_id");
		map.put("flightId","flight_id");
		map.put("date","date");
		map.put("endJuncId","end_junc_id");
		map.put("time","time");
		map.put("estArrivingTime","est_arriving_time");
		map.put("scheduleClass","schedule_class");
		map.put("available","available");
		map.put("price","price");
		map.put("type","type");
		return map;
	}

	public Integer getStartJuncId() {
		return startJuncId;
	}

	public void setStartJuncId(Integer startJuncId) {
		this.startJuncId = startJuncId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEndJuncId() {
		return endJuncId;
	}

	public void setEndJuncId(String endJuncId) {
		this.endJuncId = endJuncId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEstArrivingTime() {
		return estArrivingTime;
	}

	public void setEstArrivingTime(String estArrivingTime) {
		this.estArrivingTime = estArrivingTime;
	}

	public String getScheduleClass() {
		return scheduleClass;
	}

	public void setScheduleClass(String scheduleClass) {
		this.scheduleClass = scheduleClass;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
