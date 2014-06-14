package com.mnt.erp.controller;

/*
 @author Srinivas
 @version 1.0   
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.bean.ChartofAccount;
import com.mnt.erp.service.AccountGroupService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class AccountGroupController {

	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	@Autowired
	AccountGroupService accountgroupservice;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/accountGroup", method = RequestMethod.GET)
	public String getAccountGroup(
			@ModelAttribute AccountGroupBean accountgroupbean,
			SessionStatus status, Model model,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
       
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("accountGroup.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		
		model.addAttribute("accountGroup", new AccountGroupBean());

		return "accountGroup";
	}

	
	@ModelAttribute("coa")
	public Map<Integer, String> populateRfqType() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = accountgroupservice.selectcoa();
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
	
	@RequestMapping(value = "/accountGroup", method = RequestMethod.POST)
	@RequestScoped
	public String saveAccountGroups(
			
			@ModelAttribute("accountGroup") AccountGroupBean accountGroupBean,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request,HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		String mess = null;
		String AGSuccessdup = null;
		String res=null;
		String name = accountGroupBean.getAccountgroup();
		Long id = 0L;
		try {
			id = accountgroupservice.getAccountgroupCount(name);
			if (id == 0) {
				session=request.getSession(false);
				mess = accountgroupservice.saveAccountGroupservice(accountGroupBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (mess.equals("S")) {
					
					res = "redirect:accountGroup.mnt?list=" + "success" + "";
				}
				else{
					
					res = "redirect:accountGroup.mnt?listwar=" + "fail" + "";
				}
			} else {
				AGSuccessdup = "Warning ! Account Group is already exists. Please try some other name";
				accountGroupBean.setAccountgrouphide(1);
				request.setAttribute("AGSuccessdup", AGSuccessdup);
				return "accountGroup";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	@RequestMapping(value = "/searchGroups", method = RequestMethod.GET)
	public String searchAccountGroups(
			@ModelAttribute("accountGroup") AccountGroupBean accountGroupBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<AccountGroupBean> accountGroupBeans = new ArrayList<AccountGroupBean>();
			String dbField = accountGroupBean.getXmlLabel();
			String operation = accountGroupBean.getOperations();
			String basicSearchId = accountGroupBean.getBasicSearchId();

			if (operation.equals("_%")) {
				operation = " like ";
				basicSearchId = basicSearchId + "%";

			} else if (operation.equals("%_")) {
				operation = " like ";
				basicSearchId = "%" + basicSearchId;

			} else if (operation.equals("%_%")) {
				operation = " like ";
				basicSearchId = "%" + basicSearchId + "%";

			}

			if (basicSearchId == "") {

				list = accountgroupservice.searchAccountGroups();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					AccountGroupBean accountGroupBean2 = new AccountGroupBean();
					accountGroupBean2.setAccountgroupid((Integer) obj[0]);
					accountGroupBean2.setAccountgroup((String) obj[1]);
					ChartofAccount ca=(ChartofAccount)obj[2];
					accountGroupBean2.setCoaid(ca.getCoa());
					accountGroupBeans.add(accountGroupBean2);
				}

			} else {

				// list = accountgroupservice.searchAccountGroupsWithId(iid);
				list = accountgroupservice.basicSearchAccoutGroup(dbField,
						operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					AccountGroupBean accountGroupBean2 = new AccountGroupBean();
					accountGroupBean2.setAccountgroupid((Integer) obj[0]);
					accountGroupBean2.setAccountgroup((String) obj[1]);
					ChartofAccount ca=(ChartofAccount)obj[2];
					accountGroupBean2.setCoaid(ca.getCoa());
					accountGroupBeans.add(accountGroupBean2);
				}

			}
			request.setAttribute("accountGroupBeans", accountGroupBeans);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "accountGroup";
	}

	@ModelAttribute("accountsearch")
	public Map<Integer, String> populateAccountGroupids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = accountgroupservice.selectAccountGroupids();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				map.put((Integer) obj[0], ((String) obj[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/accountGroupsedit", method = RequestMethod.GET)
	public String editAccountGroup(
			@ModelAttribute("accountGroup") AccountGroupBean accountGroupBean,
			HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("accountgroupedit"));

		try {
			List<AccountGroupBean> accountGroupBeans = new ArrayList<AccountGroupBean>();
			list = accountgroupservice.searchAccountGroupsWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				accountGroupBean.setAccountgroupidedit((Integer) obj[0]);
				accountGroupBean.setAccountgroupedit((String) obj[1]);
				accountGroupBean.setCoaidedit((String) obj[2]);
				accountGroupBeans.add(accountGroupBean);
			}
			request.setAttribute("editvalues", accountGroupBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "accountGroup";

	}

	@RequestMapping(value = "/accountGroupUpdate", method = RequestMethod.POST)
	public String updateaccountGroups(
			@ModelAttribute("accountGroup") AccountGroupBean accountGroupBean,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = accountGroupBean.getAccountgroupedit();
		int accountgroupid = accountGroupBean.getAccountgroupidedit();
		String AGSuccessdupedit = null;

		Long id = 0L;
		try {

			id = accountgroupservice.getAccountgroupCountedit(name,
					accountgroupid);

			if (id == 0) {
				accountGroupBean.setAccountgroupid(accountGroupBean
						.getAccountgroupidedit());

				accountGroupBean.setAccountgroup(accountGroupBean.getAccountgroupedit());
				accountGroupBean.setCoaid(accountGroupBean.getCoaidedit());
				String message = accountgroupservice
						.updateAccountGroups(accountGroupBean);

				if (message.equals("S")) {
					
					request.setAttribute("accountGroupUpdate","Account Groups has been updated");
					
				}
				else{
					
					request.setAttribute("accountGroupUpdateError","Account Groups has not been updated");
					
				}
			} else {
				AGSuccessdupedit = "Warning ! Account Group is already exists. Please try some other name";
				accountGroupBean.setAccountgrouphideedit(1);
				request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "accountGroup";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "accountGroup";
	}

	@RequestMapping(value = "/accountGroupDelete", method = RequestMethod.GET)
	public ModelAndView accountGroupDelete(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session=null;
		try {
			id = Integer.parseInt(request.getParameter("accountGroupDelete"));

			String msg = accountgroupservice.deleteAccountGroups(id);
			if (msg.equals("S")){
				request.setAttribute("accountGroupDelete","Account Group has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Account Group","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else{
				request.setAttribute("accountGroupDeleteError","Account Group has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("accountGroup", "accountGroup",
				new AccountGroupBean());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "accountGroupId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
