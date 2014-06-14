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

import com.mnt.erp.bean.CreditNote;
import com.mnt.erp.bean.CreditNoteDetail;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CreditNoteService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Kiran
 * @version 1.0 02-01-2014
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class CreditNoteController {

	@Autowired
	CreditNoteService creditNoteService;
	@Autowired
	MaterialService materialService;
	@Autowired
	UomService uomService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;

	@Autowired
	DateConversionService dateService;

	HttpSession session;

	Object[] objects = null;
	String msg = null;
	Map<Integer, String> map = null;
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	/* =================To Get Quotation Id Values============================= */

	@RequestMapping(value = "/CreditNote", method = RequestMethod.GET)
	public ModelAndView getPurchaseOrder(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("CreditNote.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("creditNoteHome", "creditNoteCommand",
				new CreditNote());

	}

	@ModelAttribute("customerInvoiceId")
	public Map<Integer, String> getCustomerInvoiceId() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = creditNoteService.getCustomerInvoiceId();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	@ModelAttribute("vendorInvoiceId")
	public Map<Integer, String> getVendorInvoiceId() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = creditNoteService.getVendorInvoiceId();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	@ModelAttribute("materialSelect")
	public Map<Integer, String> materialSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = materialService.materialIdGet();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("SelectUom")
	public Map<Integer, String> uomSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = uomService.uomIdGet();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/creditNoteNoCheck", method = RequestMethod.POST)
	public @ResponseBody
	String creditNoteNoDuplicateAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		Long beforeCreditNoteNoValue = null;
		try {

			String beforeCreditNoteNo = request.getParameter("creditNoteNo");
			beforeCreditNoteNoValue = creditNoteService
					.checkCreditNote(beforeCreditNoteNo);
			CreditNote creditNote = new CreditNote();
			if (beforeCreditNoteNoValue != 0) {
				// System.out.println("check Dup");
				creditNote.setCreditNoteDuplicate(1);
				// request.setAttribute("purchaseDuplicateAdd","Warning ! Purchase order no aleardy exists. Please try some other no");
				creditNote.setCreditNoteNo("");
				msa = "Warning ! Credit Note no aleardy exists. Please try some other no";
				return msa;
			}
			if (beforeCreditNoteNoValue == 0) {
				creditNote.setCreditNoteDuplicate(1);
				msa = "";
				return msa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msa;
	}

	@RequestMapping(value = "/creditNoteAdvanceSearch", method = RequestMethod.GET)
	public String vendorAdvanceSearch(
			@ModelAttribute("creditNoteCommand") CreditNote creditNote,
			HttpServletRequest request, HttpServletResponse response) {

		// String
		// advanceSearchHidden=request.getParameter("advanceSearchHidden");
		response.setCharacterEncoding("UTF-8");
		String name1 = "creditNote", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		// Vendor v=null;
		List<CreditNote> creditList = null;
		creditList = new ArrayList();
		creditNote.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			Iterator it = returnString.iterator();
			for (Object[] object : returnString) {
				CreditNote p = new CreditNote();

				s1 = (String) object[0];
				s2 = (String) object[1];
				p.setFirstLabel(s1);
				p.setSecondLabel(s2);
				creditList.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("creditSearchAdvance", creditList);

		return "creditNoteHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "creditNote";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/creditNoteAdvanceSearchOperations", method = RequestMethod.GET)
	public String purchaseAdvanceSearchOperations(
			@ModelAttribute("creditNoteCommand") CreditNote creditNote,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<CreditNote> vendor1 = new ArrayList<CreditNote>();
		String columns = creditNote.getFirstLabel();
		String operations = creditNote.getOperations1();
		String advanceSearchText = creditNote.getAdvanceSearchText();
		List<CreditNote> creditNoteList = new ArrayList<CreditNote>();

		if (advanceSearchText.length() != 0 && advanceSearchText != null) {

			list = creditNoteService.getCreditNoteAdvance(columns, operations,
					advanceSearchText);
		} else {
			list = creditNoteService.basicSearchCreditNote();
		}
		try {
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				CreditNote cb = new CreditNote();
				cb.setCreditNoteNo(((String) objects[0]));
				cb.setCreditNoteDT((String) objects[1]);
				cb.setCustomerInvoiceId((String) objects[2]);
				cb.setVendorInvoiceId((String) objects[3]);
				cb.setCreditNoteId((Integer) objects[4]);
				creditNoteList.add(cb);

			}
			creditNote.setAdvanceSearchHidden(0);
			request.setAttribute("creditNoteListAdvancedValues", creditNoteList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "creditNoteHome";

	}

	@RequestMapping(value = "/creditNoteNoCheckEdit", method = RequestMethod.POST)
	public @ResponseBody
	String checkPurchaseDuplicateEdit(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforepurchaseOrderNoValue = 0;
		response.setCharacterEncoding("UTF-8");
		try {

			String beforecreditNoteNoEdit = request
					.getParameter("creditNoteNoEdit");
			int creditNoteIdEdit = Integer.parseInt(request
					.getParameter("creditNoteIdEdit"));
			beforepurchaseOrderNoValue = creditNoteService.updateCheckCredit(
					beforecreditNoteNoEdit, creditNoteIdEdit);
			CreditNote p = new CreditNote();
			if (beforepurchaseOrderNoValue != 0) {
				p.setCreditNoteDuplicate(2);
				p.setCreditNoteNo("");
				msa = "Warning ! Credit Note no aleardy exists. Please try some other no";
			}
			if (beforepurchaseOrderNoValue == 0) {
				p.setCreditNoteDuplicate(2);
				msa = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			CreditNote creditNote = null;
		}
		return msa;
	}

	@RequestMapping(value = "/creditNoteAdd", method = RequestMethod.POST)
	public String addCreditNote(
			@ModelAttribute("creditNoteCommand") CreditNote creditNoteAdd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String creditSave = null;
		List<CreditNoteDetail> creditNoteDetailList = new ArrayList<CreditNoteDetail>();

		String materialId[] = creditNoteAdd.getMaterialId();
		String[] qty = creditNoteAdd.getQty();
		String uomId[] = creditNoteAdd.getUomId();
		String[] perUnit = creditNoteAdd.getPerUnit();
		String[] netPrice = creditNoteAdd.getNetPrice();
		String[] demitAmont = creditNoteAdd.getDemitAmont();
		CreditNote creditNote = (CreditNote) creditNoteAdd;
		if (materialId != null) {
			for (int n = 0; n < materialId.length; n++) {

				CreditNoteDetail cnDetails = new CreditNoteDetail();
				cnDetails.setMaterialId(materialId[n]);
				cnDetails.setPerUnit(perUnit[n]);
				cnDetails.setQty(qty[n]);
				cnDetails.setNetPrice(netPrice[n]);
				cnDetails.setUomId(uomId[n]);
				cnDetails.setDemitAmont(demitAmont[n]);
				creditNoteDetailList.add(cnDetails);
			}
		}
		creditNote.setCreditNoteDetail(creditNoteDetailList);

		Long checkCreditNote = creditNoteService.checkCreditNote(creditNoteAdd
				.getCreditNoteNo());
		if (checkCreditNote == 0) {
			try {
				creditNoteAdd.setCreditNoteDT(dateService.dateFormat(
						dateService.dateParse(creditNoteAdd.getCreditNoteDT(),
								"au"), "au"));
				msg = creditNoteService.addCreditNote(creditNote);

				if (msg.equalsIgnoreCase("S")) {
					session = request.getSession(false);
					Date date1 = new Date();
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date1);
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Credit Note", "ROW", String.valueOf(creditNote
									.getCreditNoteId()), "1", modifiedDate,
							session.getAttribute("userName").toString());
					creditSave = "$uccess : Credit Note  Data is saved successfully";
					return "redirect:CreditNote.mnt?list=" + creditSave + "";
				} else {
					creditSave = "$uccess : Credit Note  Data is not saved ";
					return "redirect:CreditNote.mnt?listwar=" + creditSave;
				}

			} catch (Exception e) {
				creditSave = "$uccess : Credit Note  Data is not saved ";
				return "redirect:CreditNote.mnt?listwar=" + creditSave;
			}
		} else {
			creditNoteAdd.setCnId(1);
			request.setAttribute("fail",
					"Warning ! Credit Note no aleardy exists. Please try some other No");
			request.setAttribute("creditNoteDetailList", creditNoteDetailList);

			return "creditNoteHome";

		}
	}

	@RequestMapping(value = "/creditNoteSearch", method = RequestMethod.GET)
	public String searchScheduling(
			@ModelAttribute("creditNoteCommand") CreditNote creditNote,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<CreditNote> creditNoteList = new ArrayList<CreditNote>();
		try {

			String dbField = creditNote.getXmlLabelBasic();
			String operation = creditNote.getOperations();
			String basicSearchId = creditNote.getBasicSearchId();

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
				list = creditNoteService.basicSearchCreditNote();

			} else {

				// list = custService.searchCustomerWithId(cid, status);
				list = creditNoteService.basicSearchCredit(dbField, operation,
						basicSearchId);
			}
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				CreditNote cb = new CreditNote();
				cb.setCreditNoteNo(((String) objects[0]));
				cb.setCreditNoteDT(dateService.dateFormat(
						dateService.dateParse((String) objects[1], "se"), "se"));
				cb.setCustomerInvoiceId((String) objects[2]);
				cb.setVendorInvoiceId((String) objects[3]);
				cb.setCreditNoteId((Integer) objects[4]);
				creditNoteList.add(cb);

			}

			request.setAttribute("creditNoteList", creditNoteList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "creditNoteHome";

	}

	@RequestMapping(value = "/creditNoteEdit", method = RequestMethod.GET)
	public String creditNoteEdit(
			@ModelAttribute("creditNoteCommand") CreditNote creditNote,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<CreditNote> creditNoteEditList = new ArrayList<CreditNote>();
		List<CreditNoteDetail> creditNoteDetailEditList = new ArrayList<CreditNoteDetail>();

		int purcId = Integer.parseInt(request.getParameter("creditNoteId"));

		try {

			List<Object> l = creditNoteService.editCreditNoteWithId(purcId);
			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				CreditNote ccb = (CreditNote) oo;
				creditNote.setCreditNoteId(ccb.getCreditNoteId());
				creditNote.setCreditNoteNo(ccb.getCreditNoteNo());
				creditNote.setCreditNoteDT(dateService.dateFormat(
						dateService.dateParse(ccb.getCreditNoteDT(), "se"),
						"se"));
				creditNote.setCustomerInvoiceId(ccb.getCustomerInvoiceId());
				creditNote.setVendorInvoiceId(ccb.getVendorInvoiceId());

				creditNote.setCnId(2);

				List<CreditNoteDetail> listEdit = ccb.getCreditNoteDetail();

				Iterator<CreditNoteDetail> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					CreditNoteDetail cc = (CreditNoteDetail) o;
					CreditNoteDetail cMultiple = new CreditNoteDetail();

					cMultiple.setCreditNoteDetailId(cc.getCreditNoteDetailId());
					cMultiple.setCreditNoteId(cc.getCreditNoteId());
					cMultiple.setMaterialId(cc.getMaterialId());
					cMultiple.setQty(cc.getQty());
					cMultiple.setUomId(cc.getUomId());
					cMultiple.setPerUnit(cc.getPerUnit());
					cMultiple.setNetPrice(cc.getNetPrice());
					cMultiple.setDemitAmont(cc.getDemitAmont());
					Material material = (Material) cc.getMaterialDetails();
					cMultiple.setMaterialName(material.getMaterialName());
					Uom uom = (Uom) cc.getUomDetails();
					cMultiple.setUomName(uom.getUom());

					creditNoteDetailEditList.add(cMultiple);

				}
				creditNote.setCreditNoteDetail(creditNoteDetailEditList);
				creditNoteEditList.add(creditNote);
			}

			request.setAttribute("creditNoteEditList", creditNoteEditList);
			request.setAttribute("creditNoteDetailEditList",
					creditNoteDetailEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "creditNoteHome";
	}

	@RequestMapping(value = "/creditNoteUpdate", method = RequestMethod.POST)
	public String customerUpdate(
			@ModelAttribute("creditNoteCommand") CreditNote creditNoteUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<CreditNoteDetail> creditNoteUpList = new ArrayList<CreditNoteDetail>();
			creditNoteUpdate
					.setCreditNoteId(creditNoteUpdate.getCreditNoteId());
			creditNoteUpdate
					.setCreditNoteNo(creditNoteUpdate.getCreditNoteNo());
			creditNoteUpdate
					.setCreditNoteDT(dateService.dateFormat(
							dateService.dateParse(
									creditNoteUpdate.getCreditNoteDT(), "au"),
							"au"));
			creditNoteUpdate.setCustomerInvoiceId(creditNoteUpdate
					.getCustomerInvoiceId());
			creditNoteUpdate.setVendorInvoiceId(creditNoteUpdate
					.getVendorInvoiceId());

			int[] creditDetailsId = creditNoteUpdate.getCreditNoteDetailId();
			String materialId[] = creditNoteUpdate.getMaterialId();
			String[] qty = creditNoteUpdate.getQty();
			String uomId[] = creditNoteUpdate.getUomId();
			String[] perUnit = creditNoteUpdate.getPerUnit();
			String[] netPrice = creditNoteUpdate.getNetPrice();
			String[] demitAmont = creditNoteUpdate.getDemitAmont();

			if (materialId != null) {

				for (int n = 0; n < materialId.length; n++) {

					int puId = creditDetailsId[n];

					if (puId == 0) {
						CreditNoteDetail cnDetails = new CreditNoteDetail();
						cnDetails.setCreditNoteId(creditNoteUpdate
								.getCreditNoteId());
						cnDetails.setMaterialId(materialId[n]);
						cnDetails.setPerUnit(perUnit[n]);
						cnDetails.setQty(qty[n]);
						cnDetails.setNetPrice(netPrice[n]);
						cnDetails.setUomId(uomId[n]);
						cnDetails.setDemitAmont(demitAmont[n]);
						creditNoteUpList.add(cnDetails);

					} else {
						int CheckCredit = Integer.parseInt(request
								.getParameter("CheckCredit"
										+ creditDetailsId[n]));
						CreditNoteDetail cnDetails = new CreditNoteDetail();
						cnDetails.setCreditNoteDetailId(creditDetailsId[n]);
						cnDetails.setCreditNoteId(creditNoteUpdate
								.getCreditNoteId());
						cnDetails.setMaterialId(materialId[n]);
						cnDetails.setPerUnit(perUnit[n]);
						cnDetails.setQty(qty[n]);
						cnDetails.setNetPrice(netPrice[n]);
						cnDetails.setUomId(uomId[n]);
						cnDetails.setDemitAmont(demitAmont[n]);
						// creditNoteUpList.add(cnDetails);
						if (CheckCredit == 0) {
							creditNoteUpList.add(cnDetails);
						} else {

							creditNoteService
									.deleteCreditNoteDetailList(creditDetailsId[n]);

						}

					}
				}
				creditNoteUpdate.setCreditNoteDetail(creditNoteUpList);

			}
			msg = creditNoteService.updateCreditNote(creditNoteUpdate);

			if (msg == "S") {
				request.setAttribute("creditNoteUpdate", "Success");
				session = request.getSession(false);
				Date date1 = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date1);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "U", "Credit Note", "ROW", String
						.valueOf(creditNoteUpdate.getCreditNoteId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
			} else {

				request.setAttribute("creditNoteUpdateFail",
						"Error ! : Credit Note data is not updated properly");
				model.addAttribute("creditNoteCommand", new CreditNote());
				return "creditNoteHome";
				// purcUpdate = "Purchase Order Details  Updation Failed!";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return "redirect:customerHome.mnt?UpdateCustsus=" + custUpdate + "";
		return "creditNoteHome";
	}

	@RequestMapping(value = "/creditNoteDelete", method = RequestMethod.GET)
	public String crediteNoteDelete(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		// HttpSession session = request.getSession();
		// String userId=session.getAttribute("userId").toString();

		try {

			int id = Integer.parseInt(request.getParameter("creditNoteId"));
			msg = creditNoteService.deleteCreditNote(id);
			if (msg.equalsIgnoreCase("S")) {
				session = request.getSession(false);
				Date date1 = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date1);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Credit Note", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				model.addAttribute("creditNoteCommand", new CreditNote());
				request.setAttribute("creditNoteDelete",
						"$uccess : Credit Note Data is deleted successfully");
				return "creditNoteHome";

			} else {
				model.addAttribute("creditNoteCommand", new CreditNote());
				String fail = "Error ! : Credit Note data is not deleted properly";
				request.setAttribute("creditNoteDeleteFail", fail);
				return "creditNoteHome";
			}

		} catch (Exception e) {
			model.addAttribute("creditNoteCommand", new CreditNote());
			// auditLogService.setAuditLogSave(userId,"D","ROW","BomCategory"
			// ,Integer.toString(id) , "0",modifiedDate);
			e.printStackTrace();
			String fail = "Error ! : Credit Note data is not deleted properly";
			request.setAttribute("creditNoteDeleteFail", fail);
			return "creditNoteHome";
			// e.printStackTrace();
		}

	}

}