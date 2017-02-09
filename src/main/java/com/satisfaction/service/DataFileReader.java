package com.satisfaction.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.satisfaction.vo.FileData;


/**
 * This class is reading the data from the file. This class is used to generate
 * the FileData object after taking data from the file.
 */
@Component
public class DataFileReader {
	
	/**
	 * This method reads the data from the file. Each line in the file is the
	 * combination of amount of satisfaction and total time taken for each
	 * dish.
	 * 
	 * @param fileName
	 * @return FileData
	 */
	public FileData ReadDataFile(String fileName) throws Exception {

		if (StringUtils.isEmpty(fileName)) {
			throw new RuntimeException("File Name can't be blank");
		}

		FileData fileData = new FileData();

		BufferedReader br = null;
				
		try{
			br = new BufferedReader(new FileReader(new File(fileName)));
	
			String val = "";
			String[] str;

			String timeAndMenuItems = br.readLine();
			str = timeAndMenuItems.split("\\s+");
	
			/*
			 * First line of the file is used as the input for the maximum given
			 * time and total number of items.
			 */
			fileData.settotalGivenTime(Integer.parseInt(str[0]));
			fileData.settotalMenuItems(Integer.parseInt(str[1]));
	
			int[] timeForDishArr = new int[fileData.gettotalMenuItems()];
			int[] satisfactionArr = new int[fileData.gettotalMenuItems()];
			
			for (int i=0;i<= fileData.gettotalMenuItems();i++) {
				val = br.readLine();
				if (val == null)
					break;
	
				if (val.trim().isEmpty())
					continue;
				str = val.split("\\s+");
	
				Integer satisfaction = Integer.valueOf(str[0]);
				Integer timeForDish = Integer.valueOf(str[1]);
	
				timeForDishArr[i] = timeForDish;
				satisfactionArr[i] = satisfaction;
	
			}
	
			fileData.setsatisfactionArr(satisfactionArr);
			fileData.settimeForDishArr(timeForDishArr);
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			br.close();
		}

		return fileData;
	}
}
