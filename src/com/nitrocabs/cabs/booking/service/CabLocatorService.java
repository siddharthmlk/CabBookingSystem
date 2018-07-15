package com.nitrocabs.cabs.booking.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;

import com.nitrocabs.cabs.booking.model.BookingInfo;
import com.nitrocabs.cabs.model.CabInfo;
import com.nitrocabs.constants.Constants;
import com.nitrocabs.cost.model.CostInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class CabLocatorService {

	ArrayList<CabInfo> cabstore = new ArrayList<CabInfo>();				
	

	CabInfo findCabForBookingRequest(BookingInfo bookingRequest) {
		
		CabInfo requestedCab = new CabInfo();
		requestedCab.setCabLocation(bookingRequest.getPickUpSector());			
		
		int cabInfo = Collections.binarySearch(cabstore, requestedCab);
		
		if (cabInfo >= 0) {
			CabInfo foundCab = cabstore.get(cabInfo);

			if (checkTravelTimeAndProfit(foundCab.getCabLocation(),
					bookingRequest)) {
				return foundCab;
			} else {

				return null;
			}
		}else{
			return null;
		}
	}

	private boolean checkTravelTimeAndProfit(int cabLocation,
			BookingInfo bookingRequest) {
		boolean validated = true;
		
		int travelTime = Math.abs(bookingRequest.getPickUpSector()
				- cabLocation)
				* Constants.Location.PER_KM_TIME_IN_MINUTE;
		
		if(travelTime > 15){
			validated = false;
		}
		
		CostInfo costInfo = new CostInfo(
				bookingRequest.getPickUpSector(),
				bookingRequest.getDropSector());
		
		double totalExpectedCharge = costInfo.calculateCabCharge();
		
		double totalOperatingCost = costInfo.calculateCompanyCost() + Math.abs(bookingRequest.getPickUpSector()
				- cabLocation)
				* Constants.Cost.PER_KM_COMAPNY_OPERATING_COST;
		
		if((totalExpectedCharge-totalOperatingCost)/totalOperatingCost < 20 ){
			validated = false;
		}
		
		return validated;
	}
		
	
	public void setCabStore(){
		CabInfo info = new CabInfo();
		info.setCabLocation(100020);
		info.setCabNo("DL01HB001");
		cabstore.add(info);
		
		CabInfo info1 = new CabInfo();
		info1.setCabLocation(100040);
		info1.setCabNo("DL01HB002");
		cabstore.add(info1);
		
		CabInfo info2 = new CabInfo();
		info2.setCabLocation(100060);
		info2.setCabNo("DL01HB003");
		cabstore.add(info2);
		
		CabInfo info3 = new CabInfo();
		info3.setCabLocation(100080);
		info3.setCabNo("DL01HB004");
		cabstore.add(info3);				
		
		Collections.sort(cabstore, new Comparator<CabInfo>() {

			@Override
			public int compare(CabInfo o1, CabInfo o2) { 
				return Integer.valueOf(o1.getCabLocation()).compareTo(Integer.valueOf(o2.getCabLocation()));
			}
		});		
	}

}
