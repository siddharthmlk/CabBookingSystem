package com.nitrocabs.cabs.booking.model;

import com.nitrocabs.cabs.model.CabInfo;
import com.nitrocabs.cost.model.CostInfo;

public class OrderInfo {
	
	public BookingInfo bookingdetails;
	public CostInfo costInfo;
	public CabInfo cabInfo;
	
	public CabInfo getCabInfo() {
		return cabInfo;
	}
	public void setCabInfo(CabInfo cabInfo) {
		this.cabInfo = cabInfo;
	}
	public BookingInfo getBookingdetails() {
		return bookingdetails;
	}
	public void setBookingdetails(BookingInfo bookingdetails) {
		this.bookingdetails = bookingdetails;
	}
	public CostInfo getCostInfo() {
		return costInfo;
	}
	public void setCostInfo(CostInfo costInfo) {
		this.costInfo = costInfo;
	} 
	
	
	
}
