package com.satisfaction;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.satisfaction.service.FindMaxSatisfaction;
import com.satisfaction.service.MyFileReader;
import com.satisfaction.vo.FileData;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MaximumSatisfactionFinderAppApplicationTests {

	private int arrayTimeTaken[];
	private int arraySatisfaction[];
	private int totalItems;
			
	@Before
	public void init(){
		arrayTimeTaken = new int[]{20, 30, 22, 15};
		arraySatisfaction = new int[]{100, 60, 200, 105};
		totalItems = 4;
	}

	
	@Test
	public final void testParseRestaurantFile() throws Exception{
		MyFileReader reader = new MyFileReader();
		FileData fileData = reader.parseRestaurantFile("timeAndsatisfactionFile.txt");
		Assert.assertEquals(16808, fileData.getsatisfactionArr()[0]);
		Assert.assertEquals(250, fileData.gettimeForDishArr()[0]);
	}

	@Test
	public final void testFindMaxSatisfaction(){

		int maxGivenTime = 42;
		FindMaxSatisfaction fms = new FindMaxSatisfaction();

		int maxSatisfaction = fms.findMaxSatisfaction(maxGivenTime, arrayTimeTaken, arraySatisfaction, totalItems);
		Assert.assertEquals(305, maxSatisfaction);
	}

	@Test
	public final void testFindMaxSatisfaction2(){

		int maxGivenTime = 40;

		FindMaxSatisfaction fms = new FindMaxSatisfaction();

		int maxSatisfaction = fms.findMaxSatisfaction(maxGivenTime, arrayTimeTaken, arraySatisfaction, totalItems);
		Assert.assertEquals(305, maxSatisfaction);
	}
	
	@Test(expected = FileNotFoundException.class)
    public final void whenFileNameIsPassedEmpty() throws Exception {
        new MyFileReader().parseRestaurantFile("");
    }

	@Test
    public final void NoExceptionWhenFileExist() throws Exception {
        new MyFileReader().parseRestaurantFile("timeAndsatisfactionFile.txt");
        Assert.assertTrue(true);
    }


}
