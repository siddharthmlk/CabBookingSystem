package com.nitrocabs.cabs.model;

import java.util.Comparator;

public class CabInfo implements Comparable<CabInfo> {

	private String cabNo;
	private int cabLocation;
	

	public String getCabNo() {
		return cabNo;
	}

	public void setCabNo(String cabNo) {
		this.cabNo = cabNo;
	}

	public int getCabLocation() {
		return cabLocation;
	}

	public void setCabLocation(int cabLocation) {
		this.cabLocation = cabLocation;
	}
	
	@Override
	public int compareTo(CabInfo o2) { 
		return Integer.valueOf(o2.getCabLocation()).compareTo(Integer.valueOf(this.getCabLocation()));
	}
		
}
