package com.nitrocabs.cabs.booking.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.nitrocabs.cabs.booking.model.BookingInfo;
import com.nitrocabs.cabs.booking.model.OrderInfo;
import com.nitrocabs.cabs.model.CabInfo;
import com.nitrocabs.constants.Constants;

public class BookingRequestService {
	
	private final Calendar cal = Calendar.getInstance();

	public void processBookingRequests(List<BookingInfo> incomingRequests) {
		
				

		if (null != incomingRequests && !incomingRequests.isEmpty()) {
						
			List<Future<OrderInfo>> processedOrders = new ArrayList<Future<OrderInfo>>();
			
			ExecutorService threadProcesser = Executors
					.newFixedThreadPool(Constants.Orders.ORDER_PROCESS_CAPACITY);
			try{
				Collections.unmodifiableList(processedOrders);				
			
			for (BookingInfo bookingInfo : incomingRequests) {
				CabLocatorService locator = new CabLocatorService();
				locator.setCabStore();
				if (validRequest(bookingInfo)) {
					CabInfo assignedCab = locator.findCabForBookingRequest(bookingInfo);					
					if(assignedCab != null){					
					OrderService orderToProcess = new OrderService(bookingInfo);
					processedOrders.add(threadProcesser.submit(orderToProcess));
					}else{
						System.out.println( " No Cab Could be Allocated to The Request..");
					}
					
				} else {
					rejectRequest(bookingInfo);
				}							
			}
			
			if(null != processedOrders && !processedOrders.isEmpty()){
				for (Future<OrderInfo> processedOrder : processedOrders) {
					processedOrder.get().toString();
				}
			}
			
			}catch(InterruptedException e){
				e.printStackTrace();
			} catch (ExecutionException e) {				
				e.printStackTrace();
			}finally{
				threadProcesser.shutdown();
			}
			
		}else{
			System.out.println( " No Order to Process .. " );
		}
	}

	private boolean validRequest(BookingInfo bookingInfo) {	
		int toady = cal.get(Calendar.DATE);				
		return bookingInfo.getPickUpTime().get(Calendar.DATE) == toady;				
	}

	private void rejectRequest(BookingInfo bookingInfo) {
		
		System.out.println(" Cannot Process -->> " + bookingInfo.toString());
		
	}
	
	
	
}
