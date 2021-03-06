package com.satisfaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.satisfaction.service.FindMaxSatisfaction;
import com.satisfaction.service.DataFileReader;
import com.satisfaction.vo.FileData;

@SpringBootApplication
public class MaximumSatisfactionFinderAppApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(MaximumSatisfactionFinderAppApplication.class, args);
		DataFileReader  reader = ctx.getBean(DataFileReader .class);
		FindMaxSatisfaction  fms = ctx.getBean(FindMaxSatisfaction .class);
		FileData fdata = reader.ReadDataFile("timeAndsatisfactionFile.txt");
		int maxSatisfaction = fms.findMaxSatisfaction(fdata.gettotalGivenTime(), fdata.gettimeForDishArr(), fdata.getsatisfactionArr(), fdata.gettotalMenuItems());
		System.out.println("Maximum Satisfaction is : " + maxSatisfaction);
	}
}
