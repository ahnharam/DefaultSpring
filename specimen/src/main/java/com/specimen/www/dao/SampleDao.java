package com.specimen.www.dao;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Repository
public class SampleDao {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleDao.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void home(Locale locale, Model model) {
		
	}
	
}
