/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.bean.HouseBankBean;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.PaymentMethod;
import com.mnt.erp.bean.PaymentType;
import com.mnt.erp.bean.ReceiptBean;
import com.mnt.erp.bean.ReceiptWithHold;
import com.mnt.erp.bean.Status;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.ReceiptService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 22-01-2014
 */

@Controller
public class ReceiptController {

	private static final Logger log = Logger.getLogger(ReceiptController.class);
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	ReceiptService receiptService;
	@Autowired
	PopulateService populateService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	DateConversionService dateService;
	List<Object[]> list = null;
	Iterator<Object[]> itr = null;
	Object[] objects = null;
	List<Object> obj = null;
	String message = null;
	HttpSession session = null;
	boolean flag = true;

	@RequestMapping(value = "/receiptHome", method = RequestMethod.GET)
	public ModelAndView receiptHome(
			@ModelAttribute("receiptCmd") ReceiptBean receiptBean,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige(
				"receiptHome.mnt", session.getAttribute("userId")
						.toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("receiptHome", "receiptCmd", receiptBean);
	}

	@ModelAttribute("orgSelect")
	public Map<Integer, String> populateOrgIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.orgId,m.orgName from Organization m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("paymentTypeSelect")
	public Map<Integer, String> populatePTIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.paymentTypeId,m.paymentType from PaymentType m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("paymentMethodSelect")
	public Map<Integer, String> populatePMIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.paymentMethodId,p.paymentMethodName from PaymentMethod p");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("custSelect")
	public Map<Integer, String> populateCustIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.customerId,p.customerName from CustomerBean p");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("custInvoiceSelect")
	public Map<Integer, String> populateCustInvoiceIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.customerinvoiceid,p.customerinvoiceno from CustomerInvoice p");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("currencySelect")
	public Map<Integer, String> populatCurrencyIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.currencyId,p.currency from Currency p");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("bankSelect")
	public Map<Integer, String> populatBankIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.bankid,p.bankname from HouseBankBean p");

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

	@RequestMapping(value = "/checkReceiptAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkRecAddDuplicate(HttpServletRequest request,
			HttpServletResponse response, ReceiptBean sqdupBean) {
		response.setCharacterEncoding("UTF-8");
		String recNo = request.getParameter("receiptNo");
		Long checkCustName = receiptService.checkReceiptCout(recNo);
		if (checkCustName != 0) {

			message = "Warning ! Receipt No is Already exists. Please try some other name";
		} else {
			message = "";
		}
		return message;
	}

	@RequestMapping(value = "/checkReceiptUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkRecUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response, ReceiptBean dupBean) {
		response.setCharacterEncoding("UTF-8");
		String message = null;
		String recNo = request.getParameter("receiptNo");
		int recId = Integer.parseInt(request.getParameter("receiptId"));
		long checkCustName = receiptService.updateCheckReceipt(recNo, recId);

		if (checkCustName != 0) {

			message = "Warning ! Receipt No is Already exists. Please try some other name";
		} else {
			message = "";
		}

		return message;
	}

	@RequestMapping(value = "/receiptAdd", method = RequestMethod.POST)
	public String saveReceipt(
			@ModelAttribute("receiptCmd") ReceiptBean recBean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ReceiptWithHold> rwhList = new ArrayList<ReceiptWithHold>();
		String recSave = null;
		try {
			recBean.setChequeDate(dateService.dateFormat(dateService.dateParse(recBean.getChequeDate(),"au"),"au"));
			recBean.setChequeClearanceDate(dateService.dateFormat(dateService.dateParse(recBean.getChequeClearanceDate(),"au"),"au"));
			recBean.setPostingDate(dateService.dateFormat(dateService.dateParse(recBean.getPostingDate(),"au"),"au"));
			ReceiptBean addBean = (ReceiptBean) recBean;
			HttpSession session = request.getSession();
			String userId = (String) session.getAttribute("userId");
			addBean.setChequeIssuedBy(userId);
			Date date = new Date();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			addBean.setChequeIssuedDate(df.format(date));
			String whReason[] = addBean.getWithHoldReason();
			String whAmt[] = addBean.getWithHoldAmount();
			if (whReason != null) {
				for (int r = 0; r < whReason.length; r++) {
					ReceiptWithHold rwh = new ReceiptWithHold();
					rwh.setWithHoldReason(whReason[r]);
					rwh.setWithHoldAmount(whAmt[r]);
					rwhList.add(rwh);
				}
				addBean.setRecWithHold(rwhList);
			}

			flag = receiptService.saveReceiptDetails(addBean);

			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(),"A","Receipt","ROW" ,String.valueOf(addBean.getReceiptId()),"1",modifiedDate,session.getAttribute("userName").toString());
				recSave = "Receipt Data Saved Successfully";

			} else {
				recSave = "Receipt Data Insertion Failures";
				return "redirect:receiptHome.mnt?addRecFail=" + recSave + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:receiptHome.mnt?addRecsus=" + recSave + "";

	}

	@RequestMapping(value = "/receiptSearch", method = RequestMethod.GET)
	public String searchReceipt(
			@ModelAttribute("receiptCmd") ReceiptBean receiptBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<ReceiptBean> receiptList = new ArrayList<ReceiptBean>();
		try {

			String dbField = receiptBeanSearch.getXmlLabel();
			String operation = receiptBeanSearch.getOperations();
			String basicSearchId = receiptBeanSearch.getBasicSearchId();

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
				list = receiptService.searchReceipt();

			} else {

				list = receiptService.basicSearchReceipt(dbField, operation,
						basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				ReceiptBean rb = new ReceiptBean();
				rb.setReceiptId((Integer) objects[0]);
				rb.setAccNo((String) objects[1]);
				rb.setPostingDate(dateService.dateFormat(dateService.dateParse((String) objects[2],"se"),"se"));
				rb.setReceiptNo((String) objects[3]);
				rb.setAmount((String) objects[4]);
				rb.setChequeNo((String) objects[5]);
				rb.setChequeDate(dateService.dateFormat(dateService.dateParse((String) objects[6],"se"),"se"));
				rb.setDesc((String) objects[7]);

				Status st = ((Status) objects[8]);
				rb.setReceiptStatus(st.getStatus());
				Currency cur = ((Currency) objects[9]);
				rb.setCurrencyId(cur.getCurrency());
				PaymentType pt = ((PaymentType) objects[10]);
				rb.setPaymentTypeId(pt.getPaymentType());
				PaymentMethod pm = ((PaymentMethod) objects[11]);
				rb.setPaymentMethodId(pm.getPaymentMethodName());
				Organization org = ((Organization) objects[12]);
				rb.setOrgId(org.getOrgName());
				CustomerBean cust = ((CustomerBean) objects[13]);
				rb.setCustId(cust.getCustomerName());
				CustomerInvoice custInv = ((CustomerInvoice) objects[14]);
				rb.setCustInvoiceId(custInv.getCustomerinvoiceno());
				HouseBankBean hb = ((HouseBankBean) objects[15]);
				rb.setBankId(hb.getBankname());
				rb.setChequeIssuedDate((String) objects[16]);
				rb.setChequeClearanceDate(dateService.dateFormat(dateService.dateParse((String) objects[17],"se"),"se"));
				receiptList.add(rb);
			}
			request.setAttribute("receiptList", receiptList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "receiptHome";

	}

	@RequestMapping(value = "/receiptDelete", method = RequestMethod.GET)
	public String receiptDelete(
			@ModelAttribute("receiptCmd") ReceiptBean receiptBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String receiptDelete = null;
		int recId = Integer.parseInt(request.getParameter("receiptId"));
		try {
			flag = receiptService.deleteReceipt(recId);
			if (flag == true) {
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(),"D","Receipt","ROW" ,String.valueOf(recId),"1",modifiedDate,session.getAttribute("userName").toString());
				receiptDelete = "Receipt Deleted Successfully";

			} else {
				receiptDelete = "Receipt Deletion Failed due to Conatraint Violation";
				return "redirect:receiptHome.mnt?DeleteRecFail="
						+ receiptDelete + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:receiptHome.mnt?DeleteRecsus=" + receiptDelete + "";

	}

	@RequestMapping(value = "/receiptEdit", method = RequestMethod.GET)
	public String receiptEdit(
			@ModelAttribute("receiptCmd") ReceiptBean recEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("receiptId"));
		List<ReceiptBean> receiptBean = new ArrayList<ReceiptBean>();
		List<ReceiptWithHold> recHold = new ArrayList<ReceiptWithHold>();
		ReceiptBean isp = null;
		try {
			obj = receiptService.searchReceiptWithId(id);
			Iterator<Object> iterator = obj.iterator();
			if (iterator.hasNext()) {
				Object obj = iterator.next();
				isp = (ReceiptBean) obj;
				isp.setChequeDate(dateService.dateFormat(dateService.dateParse(isp.getChequeDate(),"se"),"se"));
				isp.setPostingDate(dateService.dateFormat(dateService.dateParse(isp.getPostingDate(),"se"),"se"));
				isp.setChequeClearanceDate(dateService.dateFormat(dateService.dateParse(isp.getChequeClearanceDate(),"se"),"se"));
				List<ReceiptWithHold> holdList = isp.getRecWithHold();
				Iterator<ReceiptWithHold> iter = holdList.iterator();
				while (iter.hasNext()) {
					Object ob = iter.next();
					ReceiptWithHold rwh = (ReceiptWithHold) ob;
					ReceiptWithHold rw = new ReceiptWithHold();
					rw.setRecWithHoldId(rwh.getRecWithHoldId());
					rw.setWithHoldReason(rwh.getWithHoldReason());
					rw.setWithHoldAmount(rwh.getWithHoldAmount());
					recHold.add(rw);

				}
				receiptBean.add(isp);
				isp.setRecWithHold(recHold);
			}
			model.addAttribute("receiptCmd", isp);
			request.setAttribute("receiptEdit", receiptBean);
			request.setAttribute("recHold", recHold);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			obj = null;
		}
		return "receiptHome";

	}

	@RequestMapping(value = "/receiptUpdate", method = RequestMethod.POST)
	public String receiptUpdate(
			@ModelAttribute("receiptCmd") ReceiptBean recUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String recUpadted = null;
		List<ReceiptWithHold> rwhList = new ArrayList<ReceiptWithHold>();
		try {
			recUpdate.setPostingDate(dateService.dateFormat(dateService.dateParse(recUpdate.getPostingDate(),"au"),"au"));
			recUpdate.setChequeDate(dateService.dateFormat(dateService.dateParse(recUpdate.getChequeDate(),"au"),"au"));
			recUpdate.setChequeClearanceDate(dateService.dateFormat(dateService.dateParse(recUpdate.getChequeClearanceDate(),"au"),"au"));
			ReceiptBean upBean = (ReceiptBean) recUpdate;
			String whReason[] = upBean.getWithHoldReason();
			String whAmt[] = upBean.getWithHoldAmount();
			if (whReason != null) {
				for (int r = 0; r < whReason.length; r++) {
					ReceiptWithHold rwh = new ReceiptWithHold();
					rwh.setWithHoldReason(whReason[r]);
					rwh.setWithHoldAmount(whAmt[r]);
					rwhList.add(rwh);
				}
				upBean.setRecWithHold(rwhList);
			}
			flag = receiptService.updateReceipt(upBean);

			if (flag == true) {
				recUpadted = "Receipt Data Updated Successfully";

			} else {
				recUpadted = "Receipt Data Updation Failed";
				return "redirect:receiptHome.mnt?updateRecFail=" + recUpadted
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:receiptHome.mnt?updateRecssus=" + recUpadted + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "Receipt";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@RequestMapping(value = "/receiptAdvanceSearch", method = RequestMethod.GET)
	public String receiptAdvanceSearch(
			@ModelAttribute("receiptCmd") ReceiptBean st,
			HttpServletRequest request, HttpServletResponse response) {
		List<Object[]> objArray = null;
		List<ReceiptBean> stList = new ArrayList<ReceiptBean>();
		List<ReceiptBean> refList = new ArrayList<ReceiptBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("Receipt");

			for (Object[] object : objArray) {
				ReceiptBean s = new ReceiptBean();
				if ((boolean) object[2].equals("false")) {
					s.setDbField((String) object[0]);
					s.setLabels((String) object[1]);
					stList.add(s);
				} else {
					s.setDbField((String) object[0]);
					s.setLabels((String) object[1]);
					refList.add(s);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("stAdv", stList);
		request.setAttribute("refList", refList);
		return "receiptHome";
	}

	@RequestMapping(value = "/receiptAdvanceSearchOperations", method = RequestMethod.GET)
	public String receiptAdvanceSearchOperations(
			@ModelAttribute("receiptCmd") ReceiptBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<ReceiptBean> receiptList = new ArrayList<ReceiptBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = receiptService.advSearchReceipt(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = receiptService.searchReceipt();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			ReceiptBean rb = new ReceiptBean();
			rb.setReceiptId((Integer) objects[0]);
			rb.setAccNo((String) objects[1]);
			rb.setPostingDate(dateService.dateFormat(dateService.dateParse((String) objects[2],"se"),"se"));
			rb.setReceiptNo((String) objects[3]);
			rb.setAmount((String) objects[4]);
			rb.setChequeNo((String) objects[5]);
			rb.setChequeDate(dateService.dateFormat(dateService.dateParse((String) objects[6],"se"),"se"));
			rb.setDesc((String) objects[7]);

			Status st = ((Status) objects[8]);
			rb.setReceiptStatus(st.getStatus());
			Currency cur = ((Currency) objects[9]);
			rb.setCurrencyId(cur.getCurrency());
			PaymentType pt = ((PaymentType) objects[10]);
			rb.setPaymentTypeId(pt.getPaymentType());
			PaymentMethod pm = ((PaymentMethod) objects[11]);
			rb.setPaymentMethodId(pm.getPaymentMethodName());
			Organization org = ((Organization) objects[12]);
			rb.setOrgId(org.getOrgName());
			CustomerBean cust = ((CustomerBean) objects[13]);
			rb.setCustId(cust.getCustomerName());
			CustomerInvoice custInv = ((CustomerInvoice) objects[14]);
			rb.setCustInvoiceId(custInv.getCustomerinvoiceno());
			HouseBankBean hb = ((HouseBankBean) objects[15]);
			rb.setBankId(hb.getBankname());
			rb.setChequeIssuedDate((String) objects[16]);
			rb.setChequeClearanceDate(dateService.dateFormat(dateService.dateParse((String) objects[17],"se"),"se"));
			receiptList.add(rb);
		}
		request.setAttribute("receiptList", receiptList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("receiptCmd", new ReceiptBean());
		return "receiptHome";
	}
}
