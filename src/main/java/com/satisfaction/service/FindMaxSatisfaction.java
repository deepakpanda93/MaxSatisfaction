package com.satisfaction.service;

import org.springframework.stereotype.Component;

/**
 * 
 * This is containing the logic to find the maximum satisfactionArr value from a
 * given list.
 *
 */
@Component
public class FindMaxSatisfaction {


	/**
	 *
	 * This code is based on knapSack algorithm dynamic programming.
	 *
	 * @param totalGivenTime: The maximum Given time that should be taken to have dishes
	 * @param timeArrayForDish: The array which contains the time taken for each dish
	 * @param satisfactionArr: The array which contains the amount of satisfactionArr
	 * @param noOfItems: total no of dishes
	 */
	private int knapSackAlgorithm(int totalGivenTime, int timeArrayForDish[], int satisfactionArr[], int noOfItems) {
        int [][]arrsatisfactionArrAndTime = new int[noOfItems+1][totalGivenTime+1];

        for (int i = 0; i <= noOfItems; i++) {
            for (int t = 0; t <= totalGivenTime; t++) {
                if (i==0 || t==0)
                    arrsatisfactionArrAndTime[i][t] = 0;
                else if (timeArrayForDish[i-1] <= t){
                    arrsatisfactionArrAndTime[i][t] = findMaxValue(satisfactionArr[i-1] + arrsatisfactionArrAndTime[i-1][t-timeArrayForDish[i-1]],  arrsatisfactionArrAndTime[i-1][t]);
                }
                else{
                    arrsatisfactionArrAndTime[i][t] = arrsatisfactionArrAndTime[i-1][t];
                }
            }
        }
 
        return arrsatisfactionArrAndTime[noOfItems][totalGivenTime];
    }

	
	public int findMaxSatisfaction(int totalGivenTime, int timeArrayForDish[], int satisfactionArr[], int noOfItems) {
		return knapSackAlgorithm(totalGivenTime, timeArrayForDish, satisfactionArr, noOfItems);
	}
	
	private int findMaxValue(int a, int b) {
		return a > b ? a : b;
	}

}

