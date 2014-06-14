
package com.mnt.erp.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import com.mnt.erp.bean.Vacancy;
import com.mnt.erp.bean.VacancyVendor;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.vacancyService;
import com.mnt.mail.MailService;

/**
 * @author tparvathi
 *
 */
@Controller
public class VacancyMailController {
	
	@Autowired
	public org.springframework.mail.javamail.JavaMailSenderImpl mailSender;
	
	@Autowired
    public MailService	userRegistrationService;

	@Autowired
	vacancyService vService;
	@Autowired
	PopulateService populateService;
	@RequestMapping(value = "/vacancyMailHome", method = RequestMethod.GET)
	public String getShortList(
			@ModelAttribute Vacancy vacancy,
			SessionStatus status, Model model,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
       
		model.addAttribute("vacancyMail", new Vacancy());

		return "vacancyMailHome";
	}
	@ModelAttribute("vacancyMailIds")
	public Map<Integer, String> populatDepartmentids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select v.vacancyId,v.vacancyNo from Vacancy v");
					
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	@ModelAttribute("vendorIds")
	public Map<Integer, String> populatVendorIds() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select v.vendorId,v.vendorName from Vendor v");
					
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@RequestMapping(value = "/vendorDetails", method = RequestMethod.GET)
	public @ResponseBody
	Map<Integer, String> getPurchaseDetails(
			//@RequestParam(value = "vendor", required = true) String vendor,
			HttpServletRequest req, HttpServletResponse response)
			throws Exception {

String vendor=req.getParameter("vendor");


		List<Object[]> list = null;
		StringBuffer stringBuffer = new StringBuffer();
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();

		{
			list = populateService.poPulate("select v.vendorId,v.email from Vendor v where v.vendorId="+vendor+"");
			iterator = list.iterator();
			stringBuffer.append("<option value=''>"+"....Select...."+"</option>");
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
				
				stringBuffer.append("<option value='"
						+ (String) objects[1] + "'>");
				stringBuffer.append((String) objects[1] + "</option>");
			}

		}
		response.setContentType("text/html"); // this is imp.
		PrintWriter out;
		out = response.getWriter();
		out.println(stringBuffer.toString());
		out.flush();
		return null;
	}
	
	
	@RequestMapping(value = "/sendVacancyMail", method = RequestMethod.POST)
	public String sendVacancyMail(
			@ModelAttribute("vacancyMail") Vacancy getVacancy,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String s=getVacancy.getEmployee();
	
	        VacancyVendor vv=null;
	        String[] vecancyIds=getVacancy.getVendorId().split(",");
	        
			for (int i = 0; i < vecancyIds.length; i++) {
				vv=new VacancyVendor();
				vv.setVendorId(vecancyIds[i].toString());
				 vv.setVacancyId(getVacancy.getVacancyId());
			        vService.saveVacancyVendor(vv);
			}
			if(s.equals("Yes")){
		List<Object[]> list=vService.getEmployeeMailIds();

		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
			Object[] objects=(Object[])iterator.next();
			 mailSender.setHost("smtp.gmail.com");
			 mailSender.setPort(587);
			 mailSender.setUsername("thotaparvathidevi@gmail.com");
			 mailSender.setPassword("kruparani");
			// SimpleMailMessage[] mailMessageArray = new SimpleMailMessage[1];
			 SimpleMailMessage message = new SimpleMailMessage();
	           
	            message.setFrom("thotaparvathidevi@gmail.com");
	            message.setTo("durgasridevi.salugu@mntsoft.co.in");
	            message.setSubject("With CC");
	            message.setCc((String)objects[0]);
	            message.setText("Mail Sent from @parvathi@gmail.com");
	            mailSender.send(message);
	        
		}
			
	     //send mails to vendors
		String emailCCList =getVacancy.getVendorEmail();
		 String[] splitedEmail = emailCCList.split(",");
		 mailSender.setHost("smtp.gmail.com");
		 mailSender.setPort(587);
		 mailSender.setUsername("thotaparvathidevi@gmail.com");
		 mailSender.setPassword("kruparani");
		 
		 Set<String> set=new HashSet<String>();
			for (String string : splitedEmail) {
			set.add(string);
			
			userRegistrationService.setUserEmailIds(set);
 		    userRegistrationService.uponSuccessfulRegistration(splitedEmail);
			}
		
	request.setAttribute("vacancyMail", "Vacancy mail has been sent");
	}
		return "vacancyMailHome";
	}
}

