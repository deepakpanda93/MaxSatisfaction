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
	 * @param maxGivenTime: The maximum Givem time that should be taken to have dishes
	 * @param timeTaken: The array which contains the time taken for each dish
	 * @param satisfaction: The array which contains the amount of satisfaction
	 * @param noOfItems: total no of dishes
	 * @return
	 */
	private int knapSackAlgorithm(int maxGivenTime, int timeTaken[], int satisfaction[], int noOfItems) {
        int [][]arrSatisfactionAndTime = new int[noOfItems+1][maxGivenTime+1];

        for (int index = 0; index <= noOfItems; index++) {
            for (int capacity = 0; capacity <= maxGivenTime; capacity++) {
                if (index==0 || capacity==0)
                    arrSatisfactionAndTime[index][capacity] = 0;
                else if (timeTaken[index-1] <= capacity){
                    arrSatisfactionAndTime[index][capacity] = findMaxValue(satisfaction[index-1] + arrSatisfactionAndTime[index-1][capacity-timeTaken[index-1]],  arrSatisfactionAndTime[index-1][capacity]);
                }
                else{
                    arrSatisfactionAndTime[index][capacity] = arrSatisfactionAndTime[index-1][capacity];
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

