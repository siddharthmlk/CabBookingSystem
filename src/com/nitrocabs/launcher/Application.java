package com.nitrocabs.launcher;

import java.util.ArrayList;
import java.util.Calendar;

import com.nitrocabs.cabs.booking.model.BookingInfo;
import com.nitrocabs.cabs.booking.service.BookingRequestService;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {				
							
				
		new BookingRequestService().processBookingRequests(new Application().getBookingRequests());
		
	}
	
	ArrayList<BookingInfo> getBookingRequests(){
		ArrayList<BookingInfo> requests = new ArrayList<BookingInfo>();				
		
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 07, 25, 10, 00);			
		BookingInfo request1 = new BookingInfo("BR001" ,
				100025, 1000036, cal);
		requests.add(request1);
		
		cal.add(Calendar.HOUR, 1);
		cal.getTime();			
		BookingInfo request2 = new BookingInfo("BR002" ,
				100056, 1000042, cal);
		requests.add(request2);
		
		cal.add(Calendar.HOUR, 1);
		cal.getTime();
		BookingInfo request3 = new BookingInfo("BR003" ,
				100044, 1000056, cal);
		requests.add(request3);
		
		
		cal.add(Calendar.HOUR, 3);
		cal.getTime();
		BookingInfo request4 = new BookingInfo("BR004" ,
				100028, 1000036, cal);			
		requests.add(request4);
		
		return requests;
	}

}
