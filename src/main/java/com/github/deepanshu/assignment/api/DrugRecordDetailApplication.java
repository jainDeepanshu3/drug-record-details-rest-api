package com.github.deepanshu.assignment.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.github.deepanshu.assignment.*"})
public class DrugRecordDetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrugRecordDetailApplication.class, args);
	}	
}
