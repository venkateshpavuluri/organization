/**
 *@Copyright MNTSOFT 
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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.CustomerAccount;
import com.mnt.erp.bean.CustomerBankDept;
import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.CustomerGroup;
import com.mnt.erp.bean.PaymentMethod;
import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.bean.SalesAreaBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CountryService;
import com.mnt.erp.service.CustomerService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 23-09-2013
 */

@Controller
public class CustomerController {

	public static final Logger log = Logger.getLogger(CustomerController.class);

	@Autowired
	CustomerService custService;
	@Autowired
	CountryService countryService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	PopulateService populateService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	List<Object[]> list = null;
	Iterator<Object[]> itr = null;
	Object[] objects = null;
	Object obj = null;
	String message = "";

	@RequestMapping(value = "/customerHome", method = RequestMethod.GET)
	public ModelAndView customerHome(
			@ModelAttribute("customerCmd") CustomerBean customerBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("customerHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("customerHome", "customerCmd", customerBean);
	}

	@ModelAttribute("custGroupSelect")
	public Map<Integer, String> custGroupSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = custService.selectCustomerGroup();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("salesAreaSelect")
	public Map<Integer, String> salesAreaSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = custService.selectSalesArea();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;

	}

	@ModelAttribute("countrys")
	public Map<Integer, String> populateCountry() {

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = countryService.getCountryIds();
			itr = list.iterator();
			while (itr.hasNext()) {
				Object[] objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("statusSelect")
	public Map<Integer, String> populatStatusIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.statusId,s.status from Status s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/checkAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkAddDuplicate(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("customerName") String custName) {
		response.setCharacterEncoding("UTF-8");
		Long checkCustName = custService.checkCustomer(custName);
		if (checkCustName != 0) {
			message = "Warning ! Customer Name is Already exists. Please try some other name";
		} else {
			message = "";
		}

		return message;
	}

	@RequestMapping(value = "/customerAdd", method = RequestMethod.POST)
	public String saveCustomer(
			@ModelAttribute("customerCmd") CustomerBean saveCustBean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		List<CustomerBankDept> custBankList = new ArrayList<CustomerBankDept>();
		Set<CustomerAccount> custAccount = new HashSet<CustomerAccount>();

		String bankName[] = saveCustBean.getBankName();
		String bankAddress[] = saveCustBean.getBankAddress();
		String accType[] = saveCustBean.getAccountType();
		String accNo[] = saveCustBean.getAccountNumber();
		String micrCode[] = saveCustBean.getMICRCode();
		String ifscCode[] = saveCustBean.getIFSCCode();

		String[] acGroup = saveCustBean.getAcGroupId();
		String[] recnd = saveCustBean.getReCondId();
		String[] payTerm = saveCustBean.getPaymentTermId();
		String[] payMtd = saveCustBean.getPaymentMethodId();
		CustomerBean cuBean = (CustomerBean) saveCustBean;

		if (bankName != null) {
			for (int n = 0; n < bankName.length; n++) {
				CustomerBankDept cbDept = new CustomerBankDept();
				cbDept.setBankName(bankName[n]);
				cbDept.setBankAddress(bankAddress[n]);
				cbDept.setAccountType(accType[n]);
				cbDept.setAccountNumber(accNo[n]);
				cbDept.setMICRCode(micrCode[n]);
				cbDept.setIFSCCode(ifscCode[n]);
				custBankList.add(cbDept);
			}

			cuBean.setCustBank(custBankList);

		}
		if (acGroup != null) {
			for (int m = 0; m < acGroup.length; m++) {
				CustomerAccount ca = new CustomerAccount();
				ca.setAcGroupId(acGroup[m]);
				ca.setReCondId(recnd[m]);
				ca.setPaymentMethodId(payMtd[m]);
				ca.setPaymentTermId(payTerm[m]);
				custAccount.add(ca);
			}
			cuBean.setCustAccount(custAccount);

		}
		// Long checkCustomer = custService.checkCustomer(cuName);
		try {
			message = custService.saveCustomerDetails(cuBean);
			if (message.equals("success")) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Customer ", "ROW", String
						.valueOf(cuBean.getCustomerId()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				return "redirect:customerHome.mnt?list=" + "success" + "";
			} else {
				return "redirect:customerHome.mnt?addFail=" + "fail" + "";

			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:customerHome.mnt?addFail=" + "fail" + "";

		}

	}

	@RequestMapping(value = "/checkUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("customerName") String custName,
			@RequestParam("cuId") int cuId) {
		response.setCharacterEncoding("UTF-8");
		int checkCustName = custService.updateCheckCustomer(custName, cuId);
		if (checkCustName != 0) {
			message = "Warning ! Customer Name is Already exists. Please try some other name";
		} else {
			message = "";
		}

		return message;
	}

	@ModelAttribute("customerSelect")
	public Map<Integer, String> selectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		String active = "Y";
		try {
			list = custService.selectCustomer(active);
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("AccGroupSelect")
	public Map<Integer, String> selectAccountGroupBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = custService.selectAccountGroupIds();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("PaymentTermSelect")
	public Map<Integer, String> selectPTBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = custService.selectPaymentTermIds();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("PaymentMethodSelect")
	public Map<Integer, String> selectPMBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = custService.selectPaymentMethodIds();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/customerSearch", method = RequestMethod.GET)
	public String searchCustomer(
			@ModelAttribute("customerCmd") CustomerBean customerBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<CustomerBean> customerList = new ArrayList<CustomerBean>();
		try {
			String active = "Y";
			String dbField = customerBeanSearch.getXmlLabel();
			String operation = customerBeanSearch.getOperations();
			String basicSearchId = customerBeanSearch.getBasicSearchId();

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
				list = custService.searchCustomer(active);

			} else {

				list = custService.basicSearchCustomer(dbField, operation,
						basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				CustomerBean cb = new CustomerBean();
				cb.setCustomerId((Integer) objects[0]);
				cb.setCustomerName((String) objects[1]);
				CustomerGroup cuGroup = ((CustomerGroup) objects[2]);
				cb.setCustomerGroupId(cuGroup.getCustGroup());
				SalesAreaBean sab = ((SalesAreaBean) objects[3]);
				cb.setSalesAreaId(sab.getSalesArea());
				cb.setCompanyName((String) objects[4]);
				cb.setAddress((String) objects[5]);
				cb.setCity((String) objects[6]);
				cb.setState((String) objects[7]);
				CountrysList cList = ((CountrysList) objects[8]);
				cb.setCountryName(cList.getCountryName());
				cb.setZip((String) objects[9]);
				cb.setEmail((String) objects[10]);
				cb.setPhone((String) objects[11]);
				cb.setMobile((String) objects[12]);
				cb.setFax((String) objects[13]);
				cb.setContactPerson((String) objects[14]);
				cb.setContactPersonPhone((String) objects[15]);
				customerList.add(cb);
			}

			request.setAttribute("customerList", customerList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customerHome";

	}

	@RequestMapping(value = "/customerDelete", method = RequestMethod.GET)
	public String customerDelete(
			@ModelAttribute("customerCmd") CustomerBean customerBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		int cId = Integer.parseInt(request.getParameter("customerId"));

		try {
			String msg = custService.deleteCustomer(cId);
			if (msg.equals("Deleted")) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Customer", "ROW", String
						.valueOf(cId), "1", modifiedDate,
						session.getAttribute("userName").toString());
				request.setAttribute("custDel",
						"Customer data deleted successfully");

			} else {
				request.setAttribute("custDelErr",
						"Customer data deleted successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("custDelErr",
					"Customer data deleted successfully");
		}
		model.addAttribute("customerCmd", new CustomerBean());
		return "customerHome";

	}

	@RequestMapping(value = "/customerEdit", method = RequestMethod.GET)
	public String customerEdit(
			@ModelAttribute("customerCmd") CustomerBean customerBeanEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<CustomerBean> customerEditList = new ArrayList<CustomerBean>();
		List<CustomerBankDept> customerBankEditList = new ArrayList<CustomerBankDept>();
		Set<CustomerAccount> custAcEdit = new HashSet<CustomerAccount>();
		int custId = customerBeanEdit.getCustomerId();
		String active = "Y";
		try {

			List<Object> l = custService.editCustomerWithId(custId, active);
			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				CustomerBean ccb = (CustomerBean) oo;
				customerBeanEdit.setEcustomerId(ccb.getCustomerId());
				customerBeanEdit.setEcustomerName(ccb.getCustomerName());
				customerBeanEdit.setEcustomerGroupId(ccb.getCustomerGroupId());
				customerBeanEdit.setEsalesAreaId(ccb.getSalesAreaId());
				customerBeanEdit.setEcompanyName(ccb.getCompanyName());
				customerBeanEdit.setEaddress(ccb.getAddress());
				customerBeanEdit.setEcity(ccb.getCity());
				customerBeanEdit.setEstate(ccb.getState());
				customerBeanEdit.setEcountryId(ccb.getCountryId());
				customerBeanEdit.setEzip(ccb.getZip());
				customerBeanEdit.setEemail(ccb.getEmail());
				customerBeanEdit.setEphone(ccb.getPhone());
				customerBeanEdit.setEmobile(ccb.getMobile());
				customerBeanEdit.setEfax(ccb.getFax());
				customerBeanEdit.setEcontactPerson(ccb.getContactPerson());
				customerBeanEdit.setEcontactPersonPhone(ccb
						.getContactPersonPhone());
				customerBeanEdit.setEstatusId(ccb.getStatusId());
				customerBeanEdit.setEactive(ccb.getActive());

				List<CustomerBankDept> listEdit = ccb.getCustBank();
				Set<CustomerAccount> acEdit = ccb.getCustAccount();
				Iterator<CustomerAccount> iterr = acEdit.iterator();
				Iterator<CustomerBankDept> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					CustomerBankDept cc = (CustomerBankDept) o;
					CustomerBankDept cMultiple = new CustomerBankDept();
					cMultiple.setEbcustomerId(cc.getCustomerId());
					cMultiple.setEcustomerBankDetId(cc.getCustomerBankDetId());
					cMultiple.setEbankName(cc.getBankName());
					cMultiple.setEbankAddress(cc.getBankAddress());
					cMultiple.setEaccountType(cc.getAccountType());
					cMultiple.setEaccountNumber(cc.getAccountNumber());
					cMultiple.setEmicrCode(cc.getMICRCode());
					cMultiple.setEifscCode(cc.getIFSCCode());

					customerBankEditList.add(cMultiple);
				}
				while (iterr.hasNext()) {
					Object obj = iterr.next();
					CustomerAccount ca = (CustomerAccount) obj;
					CustomerAccount cca = new CustomerAccount();
					AccountGroupBean ag = ca.getAcGroup();
					AccountGroupBean ar = ca.getRecnd();
					cca.setEacGroupName(ag.getAccountgroup());
					PaymentTerms pt = ca.getPaymentTerm();
					cca.setEpaymentTermName(pt.getPaymentTermName());
					PaymentMethod pm = ca.getPaymentMethod();
					cca.setEpaymentMethodName(pm.getPaymentMethodName());
					cca.setEreCondName(ar.getAccountgroup());
					cca.setEcustAccountId(ca.getCustAccountId());
					cca.setEacGroupId(ca.getAcGroupId());
					cca.setEreCondId(ca.getReCondId());
					cca.setEpaymentTermId(ca.getPaymentTermId());
					cca.setEpaymentMethodId(ca.getPaymentMethodId());
					custAcEdit.add(cca);
				}

				customerBeanEdit.setCustomerBankEditList(customerBankEditList);
				customerBeanEdit.setCustAccount(custAcEdit);
				customerEditList.add(customerBeanEdit);
			}

			request.setAttribute("customerEditList", customerEditList);
			request.setAttribute("customerBankEditList", customerBankEditList);
			request.setAttribute("custAccountEditList", custAcEdit);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customerHome";
	}

	@RequestMapping(value = "/customerUpdate", method = RequestMethod.POST)
	public String customerUpdate(
			@ModelAttribute("customerCmd") CustomerBean customerBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<CustomerBankDept> customerBankUpList = new ArrayList<CustomerBankDept>();
		Set<CustomerAccount> custAcUp = new HashSet<CustomerAccount>();

		String msg = null;
		String custName = customerBeanUpdate.getEcustomerName();
		int custId = customerBeanUpdate.getEcustomerId();
		customerBeanUpdate.setCustomerId(custId);
		customerBeanUpdate.setCustomerName(custName);
		customerBeanUpdate.setCompanyName(customerBeanUpdate.getEcompanyName());
		customerBeanUpdate.setCustomerGroupId(customerBeanUpdate
				.getEcustomerGroupId());
		customerBeanUpdate.setSalesAreaId(customerBeanUpdate.getEsalesAreaId());
		customerBeanUpdate.setAddress(customerBeanUpdate.getEaddress());
		customerBeanUpdate.setContactPerson(customerBeanUpdate
				.getEcontactPerson());
		customerBeanUpdate.setContactPersonPhone(customerBeanUpdate
				.getEcontactPersonPhone());
		customerBeanUpdate.setCity(customerBeanUpdate.getEcity());
		customerBeanUpdate.setState(customerBeanUpdate.getEstate());
		customerBeanUpdate.setCountryId(customerBeanUpdate.getEcountryId());
		customerBeanUpdate.setZip(customerBeanUpdate.getEzip());
		customerBeanUpdate.setEmail(customerBeanUpdate.getEemail());
		customerBeanUpdate.setPhone(customerBeanUpdate.getEphone());
		customerBeanUpdate.setMobile(customerBeanUpdate.getEmobile());
		customerBeanUpdate.setFax(customerBeanUpdate.getEfax());
		customerBeanUpdate.setStatusId(customerBeanUpdate.getEstatusId());
		customerBeanUpdate.setActive(customerBeanUpdate.getEactive());

		int cBankid[] = customerBeanUpdate.getEcustomerBankDetId();
		String bName[] = customerBeanUpdate.getEbankName();
		String bAddress[] = customerBeanUpdate.getEbankAddress();
		String accNumber[] = customerBeanUpdate.getEaccountNumber();
		String accType[] = customerBeanUpdate.getEaccountType();
		String mCode[] = customerBeanUpdate.getEmicrCode();
		String iCode[] = customerBeanUpdate.getEifscCode();

		int cAcId[] = customerBeanUpdate.getEcustAccountId();
		String[] acGp = customerBeanUpdate.getEacGroupId();
		String[] rec = customerBeanUpdate.getEreCondId();
		String[] payTr = customerBeanUpdate.getEpaymentTermId();
		String[] patMt = customerBeanUpdate.getEpaymentMethodId();
		String childDelete = "", childAccount = "", ss = "1";
		int id = 0;
		int accId = 0;
		if (bName != null) {
			for (int n = 0; n < bName.length; n++) {
				int cbId = cBankid[n];
				if (cbId == 0) {
					CustomerBankDept cbd = new CustomerBankDept();
					cbd.setBankName(bName[n]);
					cbd.setBankAddress(bAddress[n]);
					cbd.setAccountType(accType[n]);
					cbd.setAccountNumber(accNumber[n]);
					cbd.setMICRCode(mCode[n]);
					cbd.setIFSCCode(iCode[n]);
					customerBankUpList.add(cbd);

				} else {

					CustomerBankDept cbd = new CustomerBankDept();
					cbd.setBankName(bName[n]);
					cbd.setBankAddress(bAddress[n]);
					cbd.setAccountType(accType[n]);
					cbd.setAccountNumber(accNumber[n]);
					cbd.setMICRCode(mCode[n]);
					cbd.setIFSCCode(iCode[n]);
					id = cBankid[n];
					childDelete = request.getParameter("checkDelete" + id);

					if (ss.equals(childDelete)) {

						msg = custService.deleteCustomerBankDet(id);

					} else {
						customerBankUpList.add(cbd);
					}

				}

			}
		}
		if (acGp != null) {

			for (int n = 0; n < acGp.length; n++) {
				int cbId = cAcId[n];
				if (cbId == 0) {
					CustomerAccount ca = new CustomerAccount();
					ca.setAcGroupId(acGp[n]);
					ca.setReCondId(rec[n]);
					ca.setPaymentTermId(payTr[n]);
					ca.setPaymentMethodId(patMt[n]);
					custAcUp.add(ca);

				} else {
					CustomerAccount ca = new CustomerAccount();
					ca.setAcGroupId(acGp[n]);
					ca.setReCondId(rec[n]);
					ca.setPaymentTermId(payTr[n]);
					ca.setPaymentMethodId(patMt[n]);
					accId = cAcId[n];
					childAccount = request.getParameter("checkAccount" + accId);

					if (ss.equals(childAccount)) {

						msg = custService.deleteCustomerAccount(accId);

					} else {

						custAcUp.add(ca);
					}
				}

			}
		}

		try {
			customerBeanUpdate.setCustAccount(custAcUp);
			customerBeanUpdate.setCustBank(customerBankUpList);
			msg = custService.updateCustomer(customerBeanUpdate);
			if (msg.equals("Updated")) {
				request.setAttribute("custUpdate",
						"Customer Data Updated Successfully");

			} else {
				request.setAttribute("custUpdateErr",
						"Customer Data doesn't updated properly");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("custUpdateErr",
					"Customer Data doesn't updated properly");
		}

		model.addAttribute("customerCmd", new CustomerBean());
		return "customerHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "customerId";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/CustomerAdvanceSearch", method = RequestMethod.GET)
	public String rfqAdvanceSearch(
			@ModelAttribute("customerCmd") CustomerBean cusbean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<CustomerBean> custlist = null;

		String names = "customerId", s1 = null, s2 = null;
		List<Object[]> returnString = null;
		custlist = new ArrayList<CustomerBean>();
		cusbean.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(names);
			// Iterator<Object[]> it = returnString.iterator();
			for (Object[] object : returnString) {
				CustomerBean v = new CustomerBean();
				s1 = (String) object[0];
				s2 = (String) object[1];
				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				custlist.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("CustomerSearchAdvance", custlist);

		return "customerHome";
	}

	@RequestMapping(value = "/CustomerAdvanceSearchOperations", method = RequestMethod.POST)
	public String rfqAdvanceSearchOperations(
			@ModelAttribute CustomerBean cubean, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		List<CustomerBean> customerList = null;
		List<Object[]> objectsArray = null;

		response.setCharacterEncoding("UTF-8");
		customerList = new ArrayList<CustomerBean>();
		String columns = cubean.getFirstLabel();
		String operations = cubean.getOperations1();
		String advanceSearchText = cubean.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {
			objectsArray = custService.Customeradvance(columns, operations,
					advanceSearchText);
		} else {
			objectsArray = custService.getcustomer("ALL");
		}
		Iterator<Object[]> iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			objects = (Object[]) iterator.next();
			CustomerBean cb = new CustomerBean();
			cb.setCustomerId((Integer) objects[0]);
			cb.setCustomerName((String) objects[1]);
			CustomerGroup cuGroup = (CustomerGroup) objects[2];
			cb.setCustomerGroupId(cuGroup.getCustGroup());
			SalesAreaBean sab = ((SalesAreaBean) objects[3]);
			cb.setSalesAreaId(sab.getSalesArea());
			cb.setCompanyName((String) objects[4]);
			cb.setAddress((String) objects[5]);
			cb.setCity((String) objects[6]);
			cb.setState((String) objects[7]);
			CountrysList cList = ((CountrysList) objects[8]);
			cb.setCountryName(cList.getCountryName());
			cb.setZip((String) objects[9]);
			cb.setEmail((String) objects[10]);
			cb.setPhone((String) objects[11]);
			cb.setMobile((String) objects[12]);
			cb.setFax((String) objects[13]);
			cb.setContactPerson((String) objects[14]);
			cb.setContactPersonPhone((String) objects[15]);
			customerList.add(cb);
		}

		request.setAttribute("customerList", customerList);
		model.addAttribute("customerCmd", new CustomerBean());

		return "customerHome";
	}
}
