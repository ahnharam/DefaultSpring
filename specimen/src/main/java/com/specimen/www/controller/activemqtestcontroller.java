package com.specimen.www.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.specimen.www.activemq.webmmsDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class activemqtestcontroller {
	
	private static final Logger logger = LoggerFactory.getLogger(activemqtestcontroller.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	webmmsDAO webmmsDAO;
	
	@RequestMapping(value = "/activemq", method = RequestMethod.GET)
	public void home(HttpServletRequest request, HttpServletResponse response) {
		try {
			webmmsDAO.updateOIMachineState(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
