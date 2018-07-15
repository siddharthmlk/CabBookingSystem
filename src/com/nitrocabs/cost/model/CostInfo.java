package com.nitrocabs.cost.model;

import com.nitrocabs.constants.Constants;

public class CostInfo {

	private int pickUpLocation;
	private int dropLocation;
	
	public CostInfo(int pickUpLocation, int dropLocation) {
		this.pickUpLocation = pickUpLocation;
		this.dropLocation = dropLocation;
	}
	
	
	public double calculateCompanyCost(){
		return Constants.Cost.PER_KM_COMAPNY_OPERATING_COST * Math.abs(dropLocation-pickUpLocation);
	}
	
	public double calculateCabCharge(){
		return Constants.Cost.PER_KM_COMPANY_CHARGES * Math.abs(dropLocation-pickUpLocation);
	}
	
}
