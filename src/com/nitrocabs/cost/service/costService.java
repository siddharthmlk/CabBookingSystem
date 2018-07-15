package com.nitrocabs.cost.service;

import com.nitrocabs.cost.model.CostInfo;

public class costService {

	public void generateInvoice(CostInfo costInfo){
		generateCustomerInvoice(costInfo);
		generateCompanyInvoice(costInfo);
	}

	private void generateCompanyInvoice(CostInfo costInfo) {
		System.out.println(" Total Company invoice " + costInfo.calculateCabCharge());
		
	}

	private void generateCustomerInvoice(CostInfo costInfo) {
		System.out.println(" Total Company Invoice" + costInfo.calculateCabCharge());
		
	}
	
}
