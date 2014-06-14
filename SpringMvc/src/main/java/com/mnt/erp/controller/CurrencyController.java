/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.AuditLogDetail;
import com.mnt.erp.bean.Currency;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CurrencyService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Gkiran
 * @version 1.0v
 * @Date -09-2013
 */

@Controller
public class CurrencyController {

	@Autowired
	CurrencyService categoryService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	String msa = null;
	Currency bom2 = null;
	String currencyUpadte = null;
	List<String> list = null;
	List<Currency> currency1 = null;
	String name = null;
	List<Object[]> objects = null;
	Iterator<Object[]> iterator = null;
	List<Object[]> listObject = null;
	Object[] objectsArray = null;
	List<Currency> bomsList = null;
	int id = 0;
	String msg = null;
	Long count = null;

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/currency", method = RequestMethod.GET)
	public ModelAndView getCurrency(HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession(false);
	List<String> list=menuService.getPrivilige("currency.mnt", session.getAttribute("userId").toString());
			session.setAttribute("privilegeList",list);
		return new ModelAndView("currency", "currencyForm", new Currency());
	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/currencyAdd", method = RequestMethod.POST)
	public String saveCurrency(
			@ModelAttribute("currencyForm") Currency currency,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request,HttpServletResponse response, SessionStatus status, ModelMap model) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession  session=request.getSession();
		try {
			count = categoryService.checkDuplicateCurrency(currency
					.getCurrency());
			System.out.println("duplicate check="+count);
			if (count == 0) {
				msa =categoryService.setCurrencySave(currency,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				
				bom2 = new Currency();
				model.addAttribute("currencyForm", bom2);
				if (msa.equals("S")) {
					list = new ArrayList<String>();
					list.add("2");
					currencyUpadte = "Success ! @Currency@ Added successfully";
				}
				else
				{
					list = new ArrayList<String>();
					list.add("2");
					currencyUpadte = "Success ! @Currency@  Not Added";
					return "redirect:currency.mnt?success=" + currencyUpadte + "&listwar="
					+ list + "";
				}

			} else {
				currency.setCurrencyAddDuplicate(1);
				request.setAttribute("currencyDuplicateAdd",
						"Warning ! @Bom Category@ Duplicate values are not allowed");
				return "currency";
				
			}

		} catch (Exception e) {
		e.printStackTrace();
		}

		return "redirect:currency.mnt?success=" + currencyUpadte + "&list="
				+ list + "";

	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/currencySearch", method = RequestMethod.GET)
	public String searchMaterial(@ModelAttribute Currency currency,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		currency1 = new ArrayList<Currency>();
		name = currency.getCurrency();
		String dbField = currency.getXmlLabel();
		String operation = currency.getOperations();
		String basicSearchId = currency.getBasicSearchId();

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
		if (basicSearchId.length() != 0) {
			// objects= categoryService.getCurrency(currency.getCurrency());
			objects = categoryService.basicSearchCurrency(dbField, operation,
					basicSearchId);
		} else {
			objects = categoryService.getCurrency("ALL");
		}
		iterator = objects.iterator();
		while (iterator.hasNext()) {
			Currency mm = new com.mnt.erp.bean.Currency();
			Object[] objects2 = (Object[]) iterator.next();
			mm.setCurrencyId((Integer) objects2[0]);
			mm.setCurrency((String) objects2[1]);
			mm.setIsoCode((String) objects2[2]);
			mm.setSymbol((String) objects2[3]);
			currency1.add(mm);

		}

		request.setAttribute("currencySearch", currency1);
		model.addAttribute("currencyForm", new Currency());

		return "currency";

	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/currencyEdit", method = RequestMethod.GET)
	public String currencyEdit(@ModelAttribute Currency currencyDisplay,
			HttpServletRequest request,HttpServletResponse response, Model model)

	{
		HttpSession session=request.getSession(false);
		
		response.setCharacterEncoding("UTF-8");
		id = Integer.parseInt(request.getParameter("currencyEdit"));

		bomsList = new ArrayList<Currency>();
		try {

			listObject = categoryService.getCurrencyId(id);

			Iterator<Object[]> iterator = listObject.iterator();
			// request.setAttribute("tabactive", "3");
			while (iterator.hasNext()) {
				objectsArray = (Object[]) iterator.next();

				currencyDisplay.setCurrencyIdEdit((Integer) objectsArray[0]);
				currencyDisplay.setCurrencyEdit((String) objectsArray[1]);
				currencyDisplay.setIsoCodeEdit((String) objectsArray[2]);
				currencyDisplay.setSymbolEdit((String) objectsArray[3]);
				currencyDisplay.setCurrencyEditUpdate((String) objectsArray[1]);
				currencyDisplay.setIsoCodeEditUpdate((String) objectsArray[2]);
				currencyDisplay.setSymbolEditUpdate((String) objectsArray[3]);

				bomsList.add(currencyDisplay);
			
			}

			request.setAttribute("currencyValues", bomsList);
			session.setAttribute("currencyDetails",bomsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}
		model.addAttribute("currencyForm", currencyDisplay);
		return "currency";
	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/currencyUpdate", method = RequestMethod.POST)
	public String updateCurrency(@ModelAttribute Currency currency,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		
		HttpSession session=request.getSession(false);
		try {
			
			response.setCharacterEncoding("UTF-8");
			// currency.setBomCategory(bomCategory.getBomCategoryEdit());
			count = categoryService.checkDuplicateCurrencyUpdate(
					currency.getCurrencyEdit(), currency.getCurrencyIdEdit());
			if (count == 0) {
				currency.setCurrencyId(currency.getCurrencyIdEdit());
				currency.setCurrency(currency.getCurrencyEdit());
				currency.setIsoCode(currency.getIsoCodeEdit());
				currency.setSymbol(currency.getSymbolEdit());

				msg = categoryService.updateCurrency(currency);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				AuditLog auditLogI=new AuditLog();
		    	auditLogI.setUserId(session.getAttribute("userId").toString());
		    	auditLogI.setOperation("M");
		    	auditLogI.setObjectChanged("Currency"); 
		    	auditLogI.setObjectType("ROW");
		    	auditLogI.setObjectId(String.valueOf(currency.getCurrencyIdEdit()));
		    	auditLogI.setStatus("1");
		    	auditLogI.setTimeStamp(modifiedDate);
		    	auditLogI.setUserName(session.getAttribute("userName").toString());
				List<Currency> currencies=(List<Currency>)session.getAttribute("currencyDetails");
				if(currencies!=null && currencies.size()!=0)
				{
					int auditChanged=0;
					Set<AuditLogDetail> auditLogDetailList=new HashSet<AuditLogDetail>();
					 
					if(!currency.getCurrencyEdit().equalsIgnoreCase(currencies.get(0).getCurrencyEdit()))
					{
						AuditLogDetail auditLogDetails=new AuditLogDetail();
				    	auditLogDetails.setOldValue(currencies.get(0).getCurrencyEdit());
				    	auditLogDetails.setNewValue(currency.getCurrencyEdit());
				    	auditLogDetailList.add(auditLogDetails);
				    	auditChanged=auditChanged+1;
					}
					
					if(!currency.getIsoCodeEdit().equalsIgnoreCase(currencies.get(0).getIsoCodeEdit()))
					{
						AuditLogDetail auditLogDetails=new AuditLogDetail();
				    	auditLogDetails.setOldValue(currencies.get(0).getIsoCodeEdit());
				    	auditLogDetails.setNewValue(currency.getIsoCodeEdit());
				    	auditLogDetailList.add(auditLogDetails);
				    	auditChanged=auditChanged+1;
					}
					
					if(!currency.getSymbolEdit().equalsIgnoreCase(currencies.get(0).getSymbolEdit()))
					{
						AuditLogDetail auditLogDetails=new AuditLogDetail();
				    	auditLogDetails.setOldValue(currencies.get(0).getSymbolEdit());
				    	auditLogDetails.setNewValue(currency.getSymbolEdit());
				    	auditLogDetailList.add(auditLogDetails);
				    	auditChanged=auditChanged+1;
					}
					
					if(auditChanged>0)
					{
					    auditLogI.setAuditLogDetails(auditLogDetailList);
					    auditLogService.addAuditLog(auditLogI);
					}
				}
				

				if (msg.equals("S")) {
					request.setAttribute("currencyUpadte",
							"Success ! @Currency@ Updated successfully");
				}
				else
				{
					request.setAttribute("currencyUpadteError",
							"Curency not updated");
				}
			} else {

				// bomCategory.setBomCategoryEdit(bomCategory.getBomCategoryEditUpdate());

				currency.setCurrencyEdit(currency.getCurrencyEditUpdate());
				currency.setIsoCodeEdit(currency.getIsoCodeEditUpdate());
				currency.setSymbolEdit(currency.getSymbolEditUpdate());
				model.addAttribute("currencyForm", currency);
				request.setAttribute("currencyValues", bomsList);
				// request.setAttribute("bomCategoryValues",request.getParameter("bomCategoryValuesForword"));
				currency.setCurrencyAddDuplicateUpdate(1);
				request.setAttribute("currencyDuplicateUpdate",
						"Warning ! @Currency@ Duplicate values are not allowed");
				return "currency";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("currencyForm", new Currency());

		return "currency";

	}

	/*
	 * **********************************************************************************************************************************
	 */
	@RequestMapping(value = "/currencyDelete", method = RequestMethod.GET)
	public ModelAndView CurrencyDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
HttpSession session=request.getSession(false);
		try {
			id = Integer.parseInt(request.getParameter("currencyDelete"));
			msg = categoryService.currencyDelete(id);
			
			if (msg.equals("S"))
			{
				
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Currency","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("currencyDelete",
						"Currency Deleted Successfully");
			}
			else
			{
				request.setAttribute("currencyDeleteError",
						"Currency Not Deleted");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("currency", "currencyForm", new Currency());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "currencyId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
