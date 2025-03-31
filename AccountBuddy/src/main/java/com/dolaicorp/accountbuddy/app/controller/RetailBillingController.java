package com.dolaicorp.accountbuddy.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dolaicorp.accountbuddy.app.service.CommonService;

@Controller()
public class RetailBillingController {
	
	@Autowired
	private CommonService commonService;
	
	
	@GetMapping("/billing")
	public String showBillingPage() {
		return "client/billingPage";	
	}
	
}
