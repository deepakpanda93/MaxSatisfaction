package com.satisfaction;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.satisfaction.service.FindMaxSatisfaction;
import com.satisfaction.service.DataFileReader;
import com.satisfaction.vo.FileData;

//import junit.framework.Assert;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaximumSatisfactionFinderAppApplicationTests {

	private int timeArrayForDish[];
	private int satisfactionArr[];
	private int totalItems;
	
	@Autowired
	private DataFileReader filereader;
	@Autowired
	private FindMaxSatisfaction max;
			
	@Before
	public void init(){
		timeArrayForDish = new int[]{12, 35, 40, 42,45};
		satisfactionArr = new int[]{50, 100, 110, 80,60};
		totalItems = 5;
	}

	
	@Test
	public final void testDataFile() throws Exception{
		FileData fileData = filereader.ReadDataFile("timeAndsatisfactionFile.txt");
		Assert.assertEquals(16808, fileData.getsatisfactionArr()[0]);
		Assert.assertEquals(250, fileData.gettimeForDishArr()[0]);
	}

	@Test
	public final void testFindMaxSatisfaction(){
		int totalGivenTime = 55;
		int maxSatisfaction = max.findMaxSatisfaction(totalGivenTime, timeArrayForDish, satisfactionArr, totalItems);
		Assert.assertEquals(160, maxSatisfaction);
	}

	@Test
	public final void testFindMaxSatisfaction2(){
		int totalGivenTime = 60;
		int maxSatisfaction = max.findMaxSatisfaction(totalGivenTime, timeArrayForDish, satisfactionArr, totalItems);
		Assert.assertEquals(160, maxSatisfaction);
	}
	
	
	@Test(expected = RuntimeException.class)
    public final void emptyFileName() throws Exception {
         filereader.ReadDataFile("");
    }

	@Test
    public final void NoExceptionWhenFileExist() throws Exception {
        filereader.ReadDataFile("timeAndsatisfactionFile.txt");
        Assert.assertTrue(true);
    }


}
