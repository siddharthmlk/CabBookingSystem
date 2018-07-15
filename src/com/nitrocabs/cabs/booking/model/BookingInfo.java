package com.nitrocabs.cabs.booking.model;

import java.util.Calendar;

public class BookingInfo {

	private String bookingId;
	private int pickUpSector;
	private int dropSector;	
	private Calendar pickUpTime;
	
	
	public BookingInfo(String bookingId, int pickUpSector, int dropSector, Calendar pickUpTime){
		this.bookingId = bookingId;
		this.pickUpSector =pickUpSector;
		this.dropSector = dropSector;
		this.pickUpTime = pickUpTime;
	}
	
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	public int getPickUpSector() {
		return pickUpSector;
	}
	public void setPickUpSector(int pickUpSector) {
		this.pickUpSector = pickUpSector;
	}
	public int getDropSector() {
		return dropSector;
	}
	public void setDropSector(int dropSector) {
		this.dropSector = dropSector;
	}
	public Calendar getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(Calendar pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	
	@Override
	public String toString() {
		return "BookingInfo [bookingId=" + bookingId + ", pickUpSector="
				+ pickUpSector + ", dropSector=" + dropSector + ", pickUpTime="
				+ pickUpTime + "]";
	}
	
	
	
}
