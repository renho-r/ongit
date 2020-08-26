package com.renho.influxdbtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

@SpringBootApplication
@EnableScheduling
public class InfluxdbTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfluxdbTestApplication.class, args);
	}

	@Scheduled(fixedRate = 1000)
	public void doInsert(){
		Random random = new Random();
		InfluxDBDemo.insert(random.nextInt(1000));
	}
}
