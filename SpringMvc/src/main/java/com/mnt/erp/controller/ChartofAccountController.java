/**
 * 
 */
package com.mnt.erp.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.ChartofAccount;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.ChartofAccountService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;



/**
 * @author kirangangone
 * @version 1.0 04-01-2014
 * @build 0.0
 * 
 */

@Controller
@Scope("request")
public class ChartofAccountController {
	@Autowired
	ChartofAccountService chartofAccountService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@RequestMapping(value = "/ChartofAccount.mnt", method = RequestMethod.GET)
	public ModelAndView getPurchaseOrder(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("ChartofAccount.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

				return new ModelAndView("chartofAccountHome","chartofAccountCommand",new ChartofAccount());

	}
	
	
	@ModelAttribute("orgId")
	public Map<Integer, String> getChartofAccountGroupId() {
		List<Object[]> chartofAccountListvalues = null;
		Iterator<Object[]> chartofAccountIterator = null;
		Object[] chartofAccountObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			chartofAccountListvalues = chartofAccountService.getChartofAccountOrgId();
			chartofAccountIterator = chartofAccountListvalues.iterator();
			while (chartofAccountIterator.hasNext()) {
				chartofAccountObjects = (Object[]) chartofAccountIterator.next();
				map.put((Integer) chartofAccountObjects[0], (String) chartofAccountObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "chartofAccount";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	@RequestMapping(value = "/chartofAccountCheck", method = RequestMethod.POST)
	public @ResponseBody
	String creditNoteNoDuplicateAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforeCreditNoteNoValue = 0;
		try {

			String beforeCreditNoteNo = request.getParameter("chartofAccount");
			String id=request.getParameter("chartofAccountId");
			if(id.equalsIgnoreCase("0"))
			{
			beforeCreditNoteNoValue = chartofAccountService.duplicateCheckChartofAccount(beforeCreditNoteNo,"");
			}
			else
			{
				beforeCreditNoteNoValue = chartofAccountService.duplicateCheckChartofAccount(beforeCreditNoteNo,id);
				//System.out.println("in id "+id);
			}
			//System.out.println("beforeCreditNoteNoValue  final  "+beforeCreditNoteNoValue);
			ChartofAccount creditNote = new ChartofAccount();
			if (beforeCreditNoteNoValue != 0) {
				//System.out.println("check Dup");
				creditNote.setCoaDuplicate(1);
				//request.setAttribute("purchaseDuplicateAdd","Warning ! Purchase order no aleardy exists. Please try some other no");
				creditNote.setCoa("");
				msa = "Warning ! Chart of Account aleardy exists.";
				return msa;
			}
			if (beforeCreditNoteNoValue == 0) {
				creditNote.setCoaDuplicate(1);
				msa = "";
				return msa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msa;
	}
	
	
	@RequestMapping(value = "/chartofAccountAdd", method = RequestMethod.POST)
	public String addChartOfAcc(@ModelAttribute("chartofAccountCommand") ChartofAccount chartofAccountAdd,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		boolean flag = false;
			String res=null;	
        HttpSession session=null;
		int checkCreditNote = chartofAccountService.duplicateCheckChartofAccount(chartofAccountAdd.getCoa(),"");
		if (checkCreditNote == 0) {
			try {
				session=request.getSession(false);
				flag = chartofAccountService.saveChartofAccount(chartofAccountAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
			
				if(flag==true)
				{
				
				res = "redirect:ChartofAccount.mnt?list=" + "success" + "";
				}
				else
				{
					res = "redirect:ChartofAccount.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:ChartofAccount.mnt?listwar=" + "fail" + "";
				
			}
		} 
		return "redirect:ChartofAccount.mnt?list=" + "success" + "";
	}
	
	
	
	
	@RequestMapping(value = "/chartofAccountSearch", method = RequestMethod.GET)
	public String searchScheduling(
			@ModelAttribute("chartofAccountCommand") ChartofAccount chartofAccount,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ChartofAccount> chartofAccountList = new ArrayList<ChartofAccount>();
		List<Object[]> chartofAccountObjecList = null;
		Iterator<Object[]> chartofAccountIterator = null;
		Object[] chartofAccountObjects = null;
		try {
			
			String dbField = chartofAccount.getXmlLabelBasic();
			String operation = chartofAccount.getOperations();
			String basicSearchId = chartofAccount.getBasicSearchId();

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
				chartofAccountObjecList = chartofAccountService.basicSearchChartofAccount("","","");

			} else {

				// list = custService.searchCustomerWithId(cid, status);
				chartofAccountObjecList = chartofAccountService.basicSearchChartofAccount(dbField, operation,
						basicSearchId);
			}
			chartofAccountIterator = chartofAccountObjecList.iterator();
			while (chartofAccountIterator.hasNext()) {
				chartofAccountObjects = (Object[]) chartofAccountIterator.next();
				ChartofAccount cb = new ChartofAccount();
				cb.setCoa(((String) chartofAccountObjects[0]));
				cb.setCoaId((Integer)chartofAccountObjects[1]);
				Organization chartofAccountGroup=(Organization)chartofAccountObjects[2];
			    cb.setOrgId(chartofAccountGroup.getOrgName());
				chartofAccountList.add(cb);

			}
			// purchaseOrderSearch.setPuEditId(0);
			request.setAttribute("chartofAccountList", chartofAccountList);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "chartofAccountHome";

	}
	
	
	
	@RequestMapping(value = "/chartofAccountEdit", method = RequestMethod.GET)
	public String creditNoteEdit(
			@ModelAttribute("chartofAccountCommand") ChartofAccount chartofAccount,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ChartofAccount> chartofAccountEditList = new ArrayList<ChartofAccount>();
	//	List<CreditNoteDetail> creditNoteDetailEditList = new ArrayList<CreditNoteDetail>();

		int purcId = Integer.parseInt(request.getParameter("coaId"));

		// String status = "Y";
		try {

			List<Object> chartofAccountList = chartofAccountService.editChartofAccount(purcId);
			Iterator<Object> chartofAccountIterator = chartofAccountList.iterator();
			if (chartofAccountIterator.hasNext()) {
				Object oo = chartofAccountIterator.next();
				ChartofAccount ccb = (ChartofAccount)oo;
				chartofAccount.setCoaId(ccb.getCoaId());
				chartofAccount.setCoa(ccb.getCoa());
				chartofAccount.setOrgId(ccb.getOrgId());
				chartofAccount.setCnId(2);

				

				}
				
			chartofAccountEditList.add(chartofAccount);
		

			request.setAttribute("chartofAccountEditList", chartofAccountEditList);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "chartofAccountHome";
	}
	
	
	
	
	@RequestMapping(value = "/chartofAccountUpdate", method = RequestMethod.POST)
	public String customerUpdate(
			@ModelAttribute("chartofAccountCommand") ChartofAccount chartofAccountUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		boolean flag=false;
		chartofAccountUpdate.setCoa(chartofAccountUpdate.getCoa());
		chartofAccountUpdate.setCoaId(chartofAccountUpdate.getCoaId());
		chartofAccountUpdate.setOrgId(chartofAccountUpdate.getOrgId());
		flag = chartofAccountService.updateChartofAccount(chartofAccountUpdate);
		
		if (flag==true) {
			
           request.setAttribute("ChartOfAccUpdate", "ChartofAccount Data is updated successfully");
		} else {
			 request.setAttribute("ChartOfAccUpdateErr", "ChartofAccount Data is doesn't updated");
			
	
		}
		model.addAttribute("chartofAccountCommand", new ChartofAccount());
		return "chartofAccountHome";
	}
	
	
	
	
	@RequestMapping(value = "/chartofAccountDelete", method = RequestMethod.GET)
	public String BomDelete(HttpServletRequest request,
			HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			
			int id = Integer.parseInt(request.getParameter("coaId"));
			HttpSession session=null;
		 boolean msg = chartofAccountService.deleteChartofAccount(id);
			if (msg==true)
			{
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Chart","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("ChartDel","ChartofAccount Data is deleted successfully");
								
							}
			else
			{
				request.setAttribute("ChartDeleteErr","ChartofAccount Data is Doesn't deleted properly");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		model.addAttribute("chartofAccountCommand", new ChartofAccount());
		return "chartofAccountHome";
	}
}

