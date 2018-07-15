package com.nitrocabs.cabs.booking.service;

import java.util.concurrent.Callable;

import com.nitrocabs.cabs.booking.model.BookingInfo;
import com.nitrocabs.cabs.booking.model.OrderInfo;
import com.nitrocabs.cost.model.CostInfo;

public class OrderService implements Callable<OrderInfo>{
	
	BookingInfo bookingRequest;
	
	public OrderService(BookingInfo bookingRequest){
		this.bookingRequest = bookingRequest;
	}

	@Override
	public OrderInfo call() throws Exception {		
		OrderInfo order = new OrderInfo();
		order.setBookingdetails(bookingRequest);
		order.setCostInfo(new CostInfo(bookingRequest.getPickUpSector(), bookingRequest.getDropSector()));					
		return order;
	}

}
