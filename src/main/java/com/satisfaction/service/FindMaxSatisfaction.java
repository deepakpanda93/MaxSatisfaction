package com.satisfaction.service;

/**
 * 
 * This is containing the logic to find the maximum satisfaction value from a
 * given list.
 *
 */
public class FindMaxSatisfaction {


	/**
	 *
	 * This code is based on knapSack algorithm dynamic programming.
	 *
	 * @param maxGivenTime: The maximum Given time that should be taken to have dishes
	 * @param timeTaken: The array which contains the time taken for each dish
	 * @param satisfaction: The array which contains the amount of satisfaction
	 * @param noOfItems: total no of dishes
	 */
	private int knapSackAlgorithm(int maxGivenTime, int timeTaken[], int satisfaction[], int noOfItems) {
        int [][]arrSatisfactionAndTime = new int[noOfItems+1][maxGivenTime+1];

        for (int i = 0; i <= noOfItems; i++) {
            for (int t = 0; t <= maxGivenTime; t++) {
                if (i==0 || t==0)
                    arrSatisfactionAndTime[i][t] = 0;
                else if (timeTaken[i-1] <= t){
                    arrSatisfactionAndTime[i][t] = findMaxValue(satisfaction[i-1] + arrSatisfactionAndTime[i-1][t-timeTaken[i-1]],  arrSatisfactionAndTime[i-1][t]);
                }
                else{
                    arrSatisfactionAndTime[i][t] = arrSatisfactionAndTime[i-1][t];
                }
            }
        }
 
        return arrSatisfactionAndTime[noOfItems][maxGivenTime];
    }

	
	public int findMaxSatisfaction(int maxGivenTime, int timeTaken[], int satisfaction[], int noOfItems) {
		return knapSackAlgorithm(maxGivenTime, timeTaken, satisfaction, noOfItems);
	}
	
	private int findMaxValue(int a, int b) {
		return a > b ? a : b;
	}

}

