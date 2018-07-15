package com.nitrocabs.locations.model;

import com.nitrocabs.constants.Constants;

public class LocationInfo {

	private int sectorID;
	

	public int getSectorID() {
		return sectorID;
	}

	public void setSectorID(int sectorID) {
		this.sectorID = sectorID;
	}

	public int calculateDistanceFromOrigin() {
		return (sectorID - Constants.Location.CAB_ORIGIN_SECTOR_ID)
				* Constants.Location.PER_SECTOR_DISTANCE;
	}	

}
