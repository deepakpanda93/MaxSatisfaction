package com.satisfaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.satisfaction.service.FindMaxSatisfaction;
import com.satisfaction.service.MyFileReader;
import com.satisfaction.vo.FileData;

@SpringBootApplication
public class MaximumSatisfactionFinderAppApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MaximumSatisfactionFinderAppApplication.class, args);
		FindMaxSatisfaction fms = new  FindMaxSatisfaction();
		MyFileReader reader = new MyFileReader();
		FileData fdata = reader.ReadDataFile("timeAndsatisfactionFile.txt");
		int maxSatisfaction = fms.findMaxSatisfaction(fdata.gettotalGivenTime(), fdata.gettimeForDishArr(), fdata.getsatisfactionArr(), fdata.gettotalMenuItems());
		System.out.println("Maximum Satisfaction is : " + maxSatisfaction);
	}
}
