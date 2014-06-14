/**
 * @Copyright MNTSOFT

 * 
 */

package com.mnt.erp.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mnt.erp.bean.ThemeBean;
import com.mnt.erp.service.LoginServiceImpl;
import com.mnt.erp.service.PurchaseRequisitionService;

/**
 * @author pvenkateswarlu
 * @version 1.0 15-09-2013
 */
@Controller
public class HomeController {
	@Autowired
	LoginServiceImpl loginServiceImpl;
	@Autowired
	PurchaseRequisitionService prservice;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String addstudent() {
		return "login";
		// return new ModelAndView("login", "command", new Login());
	}

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String getLogin(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String view = null;
		String dbUsername = null;
		String dbpassword = null;
		String dbUserId = null;
		try {

			String userName = request.getParameter("userName"); /*
																 * login.getUserName
																 * ();
																 */
			String password = request.getParameter("password"); /*
																 * login.getPassword
																 * ();
																 */

			List<Object[]> list = loginServiceImpl.getCredentials(userName,password);
			ThemeBean themeBean=null;
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				dbUsername = (String) objects[1];
				dbpassword = (String) objects[2];
				dbUserId = (String) objects[0];
				 themeBean=(ThemeBean)objects[3];
				

			}

			if (userName.equals(dbUsername) & password.equals(dbpassword)) {

				//view = "Dashboard.mnt";//
				view = "redirect:Dashboard.mnt";
				// view="loginHome";
				session.setAttribute("userId", dbUserId);
				session.setAttribute("role", dbUsername);
				session.setAttribute("userName", userName);
				session.setAttribute("theme","css/"+themeBean.getTheme()+".css");
				/*
				 * purchaseReqs=prservice.getPurchaseReqDetails();
				 * request.setAttribute("purchaseRequisition",purchaseReqs);
				 */

			} else {

				view = "login";
				request.setAttribute("invalid", "Invalid UserName Password");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return view;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("role");
		}

		/*
		 * response.setHeader("Expires", "Tue, 03 Jul 2001 06:00:00 GMT");
		 * response.setHeader("Last-Modified", new Date().toString());
		 * response.setHeader("Cache-Control",
		 * "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0"
		 * ); response.setHeader("Pragma", "no-cache");
		 */
		session.invalidate();
		return "redirect:login.mnt";
		// return new ModelAndView("login","command",new Login());
	}
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String forgotPassword(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
	//String view=null;
		String dbUsername = null;
		String dbpassword = null;
		String dbUserId = null;
		String dbmailId=null;
		try {
			String userName = request.getParameter("userNamefp");
			String mailid = request.getParameter("mailId"); 
																		// * login.getPassword
																// * ();
																 

			List<Object[]> list = loginServiceImpl.getDetails(userName);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				dbUsername = (String) objects[1];
				dbpassword = (String) objects[2];
				dbUserId = (String) objects[0];
			//	dbmailId=(String) objects[3];
			}

			if (userName.equals(dbUsername)/* & mailid.equals(dbmailId)*/) {

				//ForgotPasswordMail fpm=new ForgotPasswordMail();
				//fpm.forgotpassMail(userName,dbpassword);
				
				request.setAttribute("valid", "Password has been sent to your mail");
				
			//	 purchaseReqs=prservice.getPurchaseReqDetails();
			//  request.setAttribute("purchaseRequisition",purchaseReqs);
				 

			} else {

				//view = "login";
				request.setAttribute("invalid", "Invalid UserName or Mail Id");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		
		
		return "login";
	}

}
