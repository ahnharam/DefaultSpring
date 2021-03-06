package com.specimen.www.service;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Service
public class SampleService {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleService.class);

	public String home(Locale locale, Model model) {
		
		return "home";
	}
	
}
