package com.jm.scbooking.controller.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	@RequestMapping("/booking")
	public String booking() {
		logger.info("/main/booking called.......");
		return "/main/booking";
	}
}
