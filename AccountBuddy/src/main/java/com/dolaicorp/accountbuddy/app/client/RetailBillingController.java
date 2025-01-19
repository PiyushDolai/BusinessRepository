package com.dolaicorp.accountbuddy.app.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class RetailBillingController {

	@GetMapping("/billing")
	public String showBillingPage() {
		return "client/billingPage";
	}
	
}
