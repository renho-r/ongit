package com.renho.influxdbtest;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class InfluxDBDemo {

    public static void insert(int num){

        InfluxDB db = InfluxDBFactory.connect("http://myserver:8086", "oe", "oe");
        db.setDatabase("oe");  // 设置数据库
        Point.Builder builder = Point.measurement("test_measurement");  // 创建Builder，设置表名
        builder.addField("count",num);  // 添加Field
        builder.tag("TAG_CODE","TAG_VALUE_" + num);    // 添加Tag
        Point point = builder.build();
        db.write(point);
    }
}