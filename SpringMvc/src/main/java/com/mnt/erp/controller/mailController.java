package com.mnt.erp.controller;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


import antlr.collections.List;

import com.mnt.erp.bean.mailBean;
import com.mnt.mail.MailService;
@Controller
public class mailController {
	@Autowired
	public JavaMailSenderImpl javamail;
	@Autowired
    public MailService	userRegistrationService;
	
	@RequestMapping(value = "/mailList", method = RequestMethod.GET)
	public ModelAndView getMailHome(
			@ModelAttribute("Mail") mailBean  mbean, SessionStatus status,
			HttpServletResponse response, Model model) {
		System.out.println("Mailing.................");
		/*HashSet<String> s=new HashSet<String>();
		s*/
		
		return new ModelAndView("MailHome", "Mail", mbean);
	}
	
	@RequestMapping(value = "/saveMail", method = RequestMethod.GET)
	public String getMailHome2(
			@ModelAttribute("Mail") mailBean  mbean, SessionStatus status,
			HttpServletResponse response, Model model){
				
				 	String[] to=mbean.getTo();
				 	System.out.println(""+to);
				 	Set<String> set=new HashSet<String>();
				 			for (String string : to) {
								set.add(string);
							} 					 				 	
				 			//MailService.setUserEmailIds(set);
				//userRegistrationService.uponSuccessfulRegistration("");
			
						return "MailHome";
	}
}
