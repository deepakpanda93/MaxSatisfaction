package com.satisfaction.vo;

import java.io.Serializable;

/**
 * This will hold the list of all entities of the
 * Food and Satisfaction. Also it would hold value of the maximum given time to be
 * used in the restaurant.
 *
 */
public class FileData implements Serializable {

	private static final long serialVersionUID = -4323392940602781269L;

	private int[] timeForDishArr;
	private int[] satisfactionArr;
	private int totalMenuItems = 0;
	private int totalGivenTime = 0;

	public int[] gettimeForDishArr() {
		return timeForDishArr;
	}

	public void settimeForDishArr(int[] timeForDishArr) {
		this.timeForDishArr = timeForDishArr;
	}

	public int[] getsatisfactionArr() {
		return satisfactionArr;
	}

	public void setsatisfactionArr(int[] satisfactionArr) {
		this.satisfactionArr = satisfactionArr;
	}

	public int gettotalMenuItems() {
		return totalMenuItems;
	}

	public void settotalMenuItems(int totalMenuItems) {
		this.totalMenuItems = totalMenuItems;
	}

	public int gettotalGivenTime() {
		return totalGivenTime;
	}

	public void settotalGivenTime(int totalGivenTime) {
		this.totalGivenTime = totalGivenTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

