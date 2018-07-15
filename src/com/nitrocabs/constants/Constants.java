package com.nitrocabs.constants;

public interface Constants {
			
	public interface Location{
		int CAB_ORIGIN_SECTOR_ID = 10000;
		int PER_SECTOR_DISTANCE = 2; 	
		int PER_KM_TIME_IN_MINUTE = 2;
	}

	public interface Cost{
		int PER_KM_COMPANY_CHARGES = 10;
		int PER_KM_COMAPNY_OPERATING_COST = 5;
	}
	
	public interface Orders{
		int ORDER_PROCESS_CAPACITY = 3;		 		
	}
}
