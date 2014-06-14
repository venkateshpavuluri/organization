/**
 * 
 */
package com.mnt.erp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.bean.PurchaseOrder;
import com.mnt.erp.bean.PurchaseOrderLine;
import com.mnt.erp.bean.Quotation;
import com.mnt.erp.bean.QuotationLine;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.WorkFlowList;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CurrencyService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PaymentTermService;
import com.mnt.erp.service.PurchaseOrderService;
import com.mnt.erp.service.QuotationService;
import com.mnt.erp.service.RfqService;
import com.mnt.erp.service.StatusService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.VendorService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Kiran
 * @version 1.0 16-10-2013
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class PurchaseOrderController {
	@Autowired
	ServletContext servletContext;
	@Autowired
	PurchaseOrderService poService;
	@Autowired
	QuotationService qtService;
	@Autowired
	PaymentTermService paymentTermService;
	@Autowired
	StatusService statusService;
	@Autowired
	VendorService categoryService;
	@Autowired
	CurrencyService currencyService;
	@Autowired
	QuotationService qt_service;
	@Autowired
	MaterialService materialService;
	@Autowired
	UomService uomService;
	@Autowired
	RfqService rfqservice;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;
	@Autowired
	DateConversionService dateService;
	HttpSession session;

	Object[] objects = null;
	String msg = null;
	Map<Integer, String> map = null;
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	/* =================To Get Quotation Id Values============================= */

	@ModelAttribute("quotation")
	public Map<Integer, String> quotationIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = qtService.quotationIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return map;
	}

	/* To Get Purchase Group Values */

	@ModelAttribute("purchaseGroup")
	public Map<Integer, String> populatPurchasegroupids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = rfqservice.selectpurchaseGroupservice();
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

	/* End Of Purchase Group Values */

	/* =================To Get Payment Term Values============================= */

	@ModelAttribute("paymentTerm")
	public Map<Integer, String> getPaymentTerm() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = paymentTermService.searchPaymentTerms();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/*
	 * ===============================To Get Status Id
	 * Values=============================
	 */

	@ModelAttribute("status")
	public Map<Integer, String> statusIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = statusService.searchStatus();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	/*
	 * ===============================To Get Vendor
	 * Values=============================
	 */

	@ModelAttribute("vendor")
	public Map<Integer, String> vendorIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = categoryService.vendorIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();

				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	/*
	 * ===============================To Get Currency Code
	 * Values=============================
	 */

	@ModelAttribute("ccode")
	public Map<Integer, String> getCurrencyCode() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = currencyService.getCurrencyCode();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@ModelAttribute("SelectCurrency")
	public Map<Integer, String> currencySelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = currencyService.currencyIdGet();
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

	@ModelAttribute("materialId")
	public Map<Integer, String> populateMaterialName() {
		map = new HashMap<Integer, String>();
		try {
			list = materialService.getMaterialName();
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

	@RequestMapping(value = "/purchaseOrderNoCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkPurchaseDuplicateAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		Long beforepurchaseOrderNoValue = null;
		try {

			String beforepurchaseOrderNo = request
					.getParameter("purchaseOrderNo");
			beforepurchaseOrderNoValue = poService
					.checkPurchase(beforepurchaseOrderNo);
			PurchaseOrder p = new PurchaseOrder();
			if (beforepurchaseOrderNoValue != 0) {
				p.setPurchaseAddDuplicate(1);
				request.setAttribute("purchaseDuplicateAdd",
						"Warning ! Purchase order no aleardy exists. Please try some other no");
				p.setPurchaseOrderNo("");
				msa = "Warning ! Purchase order no aleardy exists. Please try some other no";
				return msa;
			}
			if (beforepurchaseOrderNoValue == 0) {
				p.setPurchaseAddDuplicate(1);
				msa = "";
				return msa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msa;
	}

	@RequestMapping(value = "/purchaseOrderNoCheckEdit", method = RequestMethod.POST)
	public @ResponseBody
	String checkPurchaseDuplicateEdit(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforepurchaseOrderNoValue = 0;
		response.setCharacterEncoding("UTF-8");
		try {

			String beforepurchaseOrderNo = request
					.getParameter("purchaseOrderNoEdit");
			int purchaseOrderIdEdit = Integer.parseInt(request
					.getParameter("purchaseOrderIdEdit"));
			beforepurchaseOrderNoValue = poService.updateCheckPurchase(
					beforepurchaseOrderNo, purchaseOrderIdEdit);
			PurchaseOrder p = new PurchaseOrder();
			if (beforepurchaseOrderNoValue != 0) {
				p.setPurchaseAddDuplicateEdit(1);
				request.setAttribute("purchaseDuplicateAddEdit",
						"Warning ! Purchase order no aleardy exists. Please try some other no");
				p.setPurchaseOrderNo("");
				msa = "Warning ! Purchase order no aleardy exists. Please try some other no";
			}
			if (beforepurchaseOrderNoValue == 0) {
				p.setPurchaseAddDuplicateEdit(1);
				msa = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			PurchaseOrder purchaseOrder = null;
		}
		return msa;
	}

	@RequestMapping(value = "/PurchaseOrder", method = RequestMethod.GET)
	public ModelAndView getPurchaseOrder(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("PurchaseOrder.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("purchaseOrderHome", "purchaseOrderCommand",
				new PurchaseOrder());

	}

	@RequestMapping(value = "/PurchaseOrderAdd", method = RequestMethod.POST)
	public String addPurchaseOrder(
			@ModelAttribute("purchaseOrderCommand") PurchaseOrder purchaseAdd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		String url = null;
		response.setCharacterEncoding("UTF-8");
		Date date = new Date();
		try {
			HttpSession session = request.getSession();
			purchaseAdd
					.setPurchaseOrderDate(dateService.dateFormat(
							dateService.dateParse(
									purchaseAdd.getPurchaseOrderDate(), "au"),
							"au"));
			purchaseAdd
					.setDueDate(dateService.dateFormat(dateService.dateParse(
							purchaseAdd.getDueDate(), "au"), "au"));
			purchaseAdd.setCreatedBy(session.getAttribute("userId").toString());
			purchaseAdd.setCreatedDateTime(new SimpleDateFormat("yyyy-MM-dd")
					.format(date));
			List<PurchaseOrderLine> purchaseOrderLine = new ArrayList<PurchaseOrderLine>();
			String[] materialId = null;
			materialId = purchaseAdd.getMaterialIdChild();
			float[] unitPrice = purchaseAdd.getUnitPriceChild();
			String[] cCurrencyCode = purchaseAdd.getCurrencyCodeChild();
			float[] quantity = purchaseAdd.getQuantityChild();
			String[] uom = purchaseAdd.getUomChild();
			float[] lineAmt = purchaseAdd.getLineAmtChild();

			String[] cDueDate = purchaseAdd.getDueDateChild();

			PurchaseOrder purchaseOrderDetails = (PurchaseOrder) purchaseAdd;
			if ("".equals(purchaseOrderDetails.getQuotationId())) {
				purchaseOrderDetails.setQuotationId(null);
			}
			if ("".equals(purchaseOrderDetails.getVendorId())) {
				purchaseOrderDetails.setVendorId(null);
			}
			if ("".equals(purchaseOrderDetails.getPurchaseOrderValue())) {
				purchaseOrderDetails.setPurchaseOrderValue("0");
			}

			if (materialId != null) {
				for (int n = 0; n < materialId.length; n++) {

					PurchaseOrderLine poLineDetails = new PurchaseOrderLine();
					poLineDetails.setMaterialId(materialId[n]);
					poLineDetails.setUnitPrice(unitPrice[n]);
					poLineDetails.setCurrencyCode(cCurrencyCode[n]);
					poLineDetails.setQuantity(quantity[n]);
					poLineDetails.setUom(uom[n]);
					poLineDetails.setLineAmt(lineAmt[n]);
					if (cDueDate[n] != null && cDueDate[n] != "") {
						poLineDetails
								.setDueDate(dateService.dateFormat(dateService
										.dateParse(cDueDate[n], "au"), "au"));
					} else {
						poLineDetails.setDueDate(dateService.dateFormat(
								new Date(), "au"));
					}
					purchaseOrderLine.add(poLineDetails);
				}
			}
			purchaseOrderDetails.setPoLine(purchaseOrderLine);

			Long checkPurchase = poService.checkPurchase(purchaseAdd
					.getPurchaseOrderNo());
			if (checkPurchase == 0) {

				msg = poService.addPurchaseOrder(purchaseOrderDetails);
				if (msg.equals("S")) {
					Date date1 = new Date();
					session = request.getSession(false);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date1);
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Purchase Order", "ROW", String
									.valueOf(purchaseOrderDetails
											.getPurchaseOrderId()), "1",
							modifiedDate, session.getAttribute("userName")
									.toString());
					url = "redirect:PurchaseOrder.mnt?list=" + "sucess" + "";
				} else {
					url = "redirect:PurchaseOrder.mnt?listwar=" + "fail" + "";
				}
				List<Object[]> list2 = null;
				String id = (String) session.getAttribute("userId"), stepid = null, userid = null;
				WorkFlowList wflist = new WorkFlowList();
				wflist.setReceivedFrom(id);
				wflist.setWorkListId(purchaseAdd.getPurchaseOrderNo());
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
						.format(Calendar.getInstance().getTime());
				wflist.setReceivedDTTM(dateFormat.format(date));
				wflist.setWorkListContext("PO");
				wflist.setWorkListStatus("Queued");
				list2 = poService.getStepUser();
				Iterator<Object[]> iterator = list2.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					stepid = (String) objects[0];
					userid = (String) objects[1];

				}
				wflist.setUserId(userid);
				wflist.setStep(stepid);
				String wmsg = poService.saveWorkFlowListDaoDetails(wflist);
			} else {
				purchaseAdd.setPuId(1);
				request.setAttribute("fail",
						"Warning ! Purchase order no aleardy exists. Please try some other name");
				request.setAttribute("purchaseOrderLine", purchaseOrderLine);

				return "purchaseOrderHome";

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:PurchaseOrder.mnt?listwar=" + "fail" + "";
		}
		return url;
	}

	@RequestMapping(value = "/purchaseOrderSearch", method = RequestMethod.GET)
	public String searchScheduling(
			@ModelAttribute("purchaseOrderCommand") PurchaseOrder purchaseOrderSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();
		try {
			String dbField = purchaseOrderSearch.getXmlLabelBasic();
			String operation = purchaseOrderSearch.getOperations();
			String basicSearchId = purchaseOrderSearch.getBasicSearchId();

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
				list = poService.basicSearchPO();

			} else {
				list = poService.basicSearchPurchase(dbField, operation,
						basicSearchId);
			}
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				PurchaseOrder cb = new PurchaseOrder();
				cb.setPurchaseOrderId(((Integer) objects[0]));
				cb.setPurchaseOrderNo((String) objects[1]);
				cb.setPurchaseOrderDate(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));
				cb.setPurchaseOrderValue((String) objects[3]);
				Status status = ((Status) objects[4]);
				cb.setPurchaseOrderStatus(status.getStatus());
				cb.setDescription((String) objects[5]);
				PaymentTerms paymentTerms = (PaymentTerms) objects[6];
				cb.setPaymentTerms(paymentTerms.getPaymentTermName());
				cb.setMemo((String) objects[7]);
				cb.setDueDate(dateService.dateFormat(
						dateService.dateParse((String) objects[8], "se"), "se"));
				purchaseOrderList.add(cb);
			}
			request.setAttribute("purchaseOrderList", purchaseOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseOrderHome";

	}

	@RequestMapping(value = "/purchaseOrderEdit", method = RequestMethod.GET)
	public String PurchaseOrderEdit(
			@ModelAttribute("purchaseOrderCommand") PurchaseOrder purchaseOrderEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<PurchaseOrder> purchaseOrderEditList = new ArrayList<PurchaseOrder>();
		List<PurchaseOrderLine> purchaseOrderLineEditList = new ArrayList<PurchaseOrderLine>();

		int purcId = Integer.parseInt(request.getParameter("purchaseOrderId"));

		try {

			List<Object> l = poService.editPOWithId(purcId);
			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				PurchaseOrder ccb = (PurchaseOrder) oo;
				purchaseOrderEdit.setPurchaseGroupIdEdit(ccb
						.getPurchaseGroupId());
				purchaseOrderEdit.setPurchaseOrderIdEdit(ccb
						.getPurchaseOrderId());
				purchaseOrderEdit.setPurchaseOrderNoEdit(ccb
						.getPurchaseOrderNo());
				purchaseOrderEdit
						.setPurchaseOrderDateEdit(dateService.dateFormat(
								dateService.dateParse(
										ccb.getPurchaseOrderDate(), "se"), "se"));
				purchaseOrderEdit.setPurchaseOrderValueEdit(ccb
						.getPurchaseOrderValue());
				purchaseOrderEdit.setPurchaseOrderStatusEdit(ccb
						.getPurchaseOrderStatus());
				purchaseOrderEdit.setDescriptionEdit(ccb.getDescription());

				purchaseOrderEdit.setVendorIdEdit(ccb.getVendorId());
				purchaseOrderEdit.setQuotationIdEdit(ccb.getQuotationId());
				purchaseOrderEdit.setPaymentTermsEdit(ccb.getPaymentTerms());
				purchaseOrderEdit.setMemoEdit(ccb.getMemo());
				purchaseOrderEdit.setCurrencyCodeEdit(ccb.getCurrencyCode());
				purchaseOrderEdit.setSalesTaxAmtEdit(ccb.getSalesTaxAmt());
				purchaseOrderEdit.setVatAmtEdit(ccb.getVatAmt());
				purchaseOrderEdit.setExciseAmtEdit(ccb.getExciseAmt());
				purchaseOrderEdit
						.setFrieghtChargesEdit(ccb.getFrieghtCharges());
				purchaseOrderEdit.setPnFChargesEdit(ccb.getPnFCharges());
				purchaseOrderEdit.setDueDateEdit(dateService.dateFormat(
						dateService.dateParse(ccb.getDueDate(), "se"), "se"));
				purchaseOrderEdit.setCreatedBy(ccb.getCreatedBy());
				purchaseOrderEdit.setCreatedDateTime(ccb.getCreatedDateTime());

				purchaseOrderEdit.setPuEditId(1);

				List<PurchaseOrderLine> listEdit = ccb.getPoLine();

				Iterator<PurchaseOrderLine> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					PurchaseOrderLine cc = (PurchaseOrderLine) o;
					PurchaseOrderLine cMultiple = new PurchaseOrderLine();
					cMultiple.setPurchaseOrderLineId(cc
							.getPurchaseOrderLineId());
					cMultiple.setPurchaseOrderId(cc.getPurchaseOrderId());
					cMultiple.setMaterialId(cc.getMaterialId());

					Material material = (Material) cc.getMaterialDetails();
					cMultiple.setMaterialName(material.getMaterialName());
					Uom uom = (Uom) cc.getUomDetails();
					cMultiple.setUomName(uom.getUom());
					Currency currency = (Currency) cc.getCurrencyDetails();
					cMultiple.setCurrencyName(currency.getCurrency());
					cMultiple.setUnitPrice(cc.getUnitPrice());
					cMultiple.setCurrencyCode(cc.getCurrencyCode());
					cMultiple.setQuantity(cc.getQuantity());
					cMultiple.setUom(cc.getUom());
					cMultiple.setLineAmt(cc.getLineAmt());
					cMultiple
							.setDueDate(dateService.dateFormat(dateService
									.dateParse(cc.getDueDate(), "se"), "se"));

					purchaseOrderLineEditList.add(cMultiple);

				}
				purchaseOrderEdit
						.setPurchaseOrderLine(purchaseOrderLineEditList);
				purchaseOrderEditList.add(purchaseOrderEdit);
			}

			request.setAttribute("purchaseOrderEditList", purchaseOrderEditList);
			request.setAttribute("purchaseOrderLineEditList",
					purchaseOrderLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseOrderHome";
	}

	@RequestMapping(value = "/purchaseOrderDetailsJson", method = RequestMethod.POST)
	public @ResponseBody
	String getPurchaseOrderDetails(
			@RequestParam(value = "quotationId", required = true) int quotationId,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		List<Object> list = null;
		String jsondataChild = "";
		int count = 1;
		float total = 0;
		List<QuotationLine> listJson = new ArrayList<QuotationLine>();

		try {

			list = qt_service.editQuotationWithId(quotationId);
			Iterator<Object> iterator = list.iterator();
			if (iterator.hasNext()) {
				Object quotObj = iterator.next();
				Quotation quot = (Quotation) quotObj;
				List<QuotationLine> listEdit = quot.getQuotationLine();
				Iterator<QuotationLine> iterator1 = listEdit.iterator();
				while (iterator1.hasNext()) {
					Object quotLineObj = iterator1.next();
					QuotationLine quotLine = (QuotationLine) quotLineObj;
					Material material = (Material) quotLine
							.getMaterialDetails();
					Uom uom = (Uom) quotLine.getUomDetails();
					Currency currency = (Currency) quotLine
							.getCurrencyDetails();
					total = total
							+ Float.parseFloat(Integer.toString(quotLine
									.getQuantity()))
							* Float.parseFloat(Integer.toString(quotLine
									.getPerUnit()));
					float totalEdit = Float.parseFloat(Integer
							.toString(quotLine.getQuantity()))
							* Float.parseFloat(Integer.toString(quotLine
									.getPerUnit()));
					QuotationLine qLine = new QuotationLine();
					qLine.setVendorIdForJson(Integer.parseInt(quot
							.getVendorId()));
					qLine.setMaterial_Id(quotLine.getMaterial_Id());
					qLine.setMaterialName(material.getMaterialName());
					qLine.setQuantity(quotLine.getQuantity());
					qLine.setPerUnit(quotLine.getPerUnit());
					qLine.setLineAmount(quotLine.getLineAmount());
					qLine.setUom(quotLine.getUom());
					qLine.setUomName(uom.getUom());
					qLine.setCurrencyId(quotLine.getCurrencyId());
					qLine.setCurrencyName(currency.getCurrency());
					qLine.setCount(count);
					qLine.setTotal(total);
					qLine.setTotalEdit(totalEdit);
					listJson.add(qLine);
					count++;

				}

			}
			ObjectMapper mapper = new ObjectMapper();
			jsondataChild = mapper.writeValueAsString(listJson);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return jsondataChild;

	}

	@RequestMapping(value = "/purchaseAdvanceSearch", method = RequestMethod.GET)
	public String pOAdvanceSearch(
			@ModelAttribute("purchaseOrderCommand") PurchaseOrder purchaseOrder,
			HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		String name1 = "purchaseOrder", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		List<PurchaseOrder> purchaseList = null;
		purchaseList = new ArrayList();
		purchaseOrder.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			Iterator it = returnString.iterator();
			for (Object[] object : returnString) {
				PurchaseOrder p = new PurchaseOrder();

				s1 = (String) object[0];
				s2 = (String) object[1];
				p.setFirstLabel(s1);
				p.setSecondLabel(s2);
				purchaseList.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("purchaseSearchAdvance", purchaseList);

		return "purchaseOrderHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "purchaseOrder";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/purchaseAdvanceSearchOperations", method = RequestMethod.GET)
	public String purchaseAdvanceSearchOperations(
			@ModelAttribute("purchaseOrderCommand") PurchaseOrder purchaseOrder,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		List<PurchaseOrder> vendor1 = new ArrayList<PurchaseOrder>();
		String columns = purchaseOrder.getFirstLabel();
		String operations = purchaseOrder.getOperations1();
		String advanceSearchText = purchaseOrder.getAdvanceSearchText();
		List<PurchaseOrder> purchaseOrderList = new ArrayList<PurchaseOrder>();

		if (advanceSearchText.length() != 0 && advanceSearchText != null) {

			list = poService.getPurchaseAdvance(columns, operations,
					advanceSearchText);
		} else {
			list = poService.basicSearchPO();
		}
		try {
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				PurchaseOrder cb = new PurchaseOrder();
				cb.setPurchaseOrderId(((Integer) objects[0]));
				cb.setPurchaseOrderNo((String) objects[1]);
				Status status = ((Status) objects[4]);
				PaymentTerms paymentTerms = (PaymentTerms) objects[6];
				cb.setPurchaseOrderDate((String) objects[2]);
				cb.setPurchaseOrderValue((String) objects[3]);
				cb.setPurchaseOrderStatus(status.getStatus());
				cb.setDescription((String) objects[5]);
				cb.setPaymentTerms(paymentTerms.getPaymentTermName());
				cb.setMemo((String) objects[7]);
				cb.setDueDate((String) objects[8]);
				purchaseOrderList.add(cb);

			}
			purchaseOrder.setAdvanceSearchHidden(0);
			request.setAttribute("purchaseOrderListAdvancedValues",
					purchaseOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "purchaseOrderHome";

	}

	@RequestMapping(value = "/PurchaseOrderUpdate", method = RequestMethod.POST)
	public String pOUpdate(
			@ModelAttribute("purchaseOrderCommand") PurchaseOrder purchaseOrderUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<PurchaseOrderLine> purchaseOrderUpList = new ArrayList<PurchaseOrderLine>();
			purchaseOrderUpdate.setPurchaseGroupId(purchaseOrderUpdate
					.getPurchaseGroupIdEdit());
			purchaseOrderUpdate.setPurchaseOrderId(purchaseOrderUpdate
					.getPurchaseOrderIdEdit());
			purchaseOrderUpdate.setPurchaseOrderNo(purchaseOrderUpdate
					.getPurchaseOrderNoEdit());
			purchaseOrderUpdate.setPurchaseOrderDate(dateService.dateFormat(
					dateService.dateParse(
							purchaseOrderUpdate.getPurchaseOrderDateEdit(),
							"au"), "au"));
			if ("".equals(purchaseOrderUpdate.getPurchaseOrderValueEdit())) {
				purchaseOrderUpdate.setPurchaseOrderValue("0");
			} else {
				purchaseOrderUpdate.setPurchaseOrderValue(purchaseOrderUpdate
						.getPurchaseOrderValueEdit());
			}
			purchaseOrderUpdate.setPurchaseOrderStatus(purchaseOrderUpdate
					.getPurchaseOrderStatusEdit());
			purchaseOrderUpdate.setDescription(purchaseOrderUpdate
					.getDescriptionEdit());
			purchaseOrderUpdate.setMemo(purchaseOrderUpdate.getMemoEdit());

			purchaseOrderUpdate.setPaymentTerms(purchaseOrderUpdate
					.getPaymentTermsEdit());
			if ("".equals(purchaseOrderUpdate.getVendorIdEdit())) {
				purchaseOrderUpdate.setVendorId(null);
			} else {
				purchaseOrderUpdate.setVendorId(purchaseOrderUpdate
						.getVendorIdEdit());
			}
			if ("".equals(purchaseOrderUpdate.getQuotationIdEdit())) {
				purchaseOrderUpdate.setQuotationId(null);
			} else {
				purchaseOrderUpdate.setQuotationId(purchaseOrderUpdate
						.getQuotationIdEdit());
			}

			purchaseOrderUpdate.setCurrencyCode(purchaseOrderUpdate
					.getCurrencyCodeEdit());
			purchaseOrderUpdate.setDueDate(dateService.dateFormat(dateService
					.dateParse(purchaseOrderUpdate.getDueDateEdit(), "au"),
					"au"));
			purchaseOrderUpdate.setSalesTaxAmt(purchaseOrderUpdate
					.getSalesTaxAmtEdit());
			purchaseOrderUpdate.setVatAmt(purchaseOrderUpdate.getVatAmtEdit());
			purchaseOrderUpdate.setExciseAmt(purchaseOrderUpdate
					.getExciseAmtEdit());
			purchaseOrderUpdate.setFrieghtCharges(purchaseOrderUpdate
					.getFrieghtChargesEdit());
			purchaseOrderUpdate.setPnFCharges(purchaseOrderUpdate
					.getPnFChargesEdit());
			purchaseOrderUpdate
					.setCreatedBy(purchaseOrderUpdate.getCreatedBy());
			purchaseOrderUpdate.setCreatedDateTime(purchaseOrderUpdate
					.getCreatedDateTime());
			HttpSession session = request.getSession();
			Date date = new Date();
			purchaseOrderUpdate.setModifiedBy(session.getAttribute("userId")
					.toString());
			purchaseOrderUpdate.setModifiedDateTime(new SimpleDateFormat(
					"yyyy-MM-dd").format(date));
			int[] purchaseOrderLineId = purchaseOrderUpdate
					.getPurchaseOrderLineIdChild();
			String[] materialIdChildEdit = purchaseOrderUpdate
					.getMaterialIdChildEdit();
			float[] unitPriceChildEdit = purchaseOrderUpdate
					.getUnitPriceChildEdit();
			String[] currencyCodeChildEdit = purchaseOrderUpdate
					.getCurrencyCodeChildEdit();
			float[] quantityChildEdit = purchaseOrderUpdate
					.getQuantityChildEdit();
			String[] uomChildEdit = purchaseOrderUpdate.getUomChildEdit();
			float[] lineAmtChildEdit = purchaseOrderUpdate
					.getLineAmtChildEdit();
			String[] dueDateChildEdit = purchaseOrderUpdate
					.getDueDateChildEdit();

			if (materialIdChildEdit != null) {

				for (int n = 0; n < materialIdChildEdit.length; n++) {

					int puId = purchaseOrderLineId[n];

					if (puId == 0) {
						PurchaseOrderLine cbd = new PurchaseOrderLine();
						cbd.setMaterialId(materialIdChildEdit[n]);
						cbd.setUnitPrice(unitPriceChildEdit[n]);
						cbd.setUom(uomChildEdit[n]);
						cbd.setCurrencyCode(currencyCodeChildEdit[n]);
						cbd.setQuantity(quantityChildEdit[n]);
						cbd.setLineAmt(lineAmtChildEdit[n]);
						cbd.setDueDate(dateService.dateFormat(dateService
								.dateParse(dueDateChildEdit[n], "au"), "au"));
						purchaseOrderUpList.add(cbd);

					} else {
						int CheckPurchase = Integer.parseInt(request
								.getParameter("CheckPurchase"
										+ purchaseOrderLineId[n]));

						PurchaseOrderLine cbd = new PurchaseOrderLine();
						cbd.setPurchaseOrderLineId(purchaseOrderLineId[n]);
						cbd.setMaterialId(materialIdChildEdit[n]);
						cbd.setUnitPrice(unitPriceChildEdit[n]);
						cbd.setCurrencyCode(currencyCodeChildEdit[n]);
						cbd.setQuantity(quantityChildEdit[n]);
						cbd.setLineAmt(lineAmtChildEdit[n]);
						cbd.setDueDate(dateService.dateFormat(dateService
								.dateParse(dueDateChildEdit[n], "au"), "au"));
						cbd.setUom(uomChildEdit[n]);
						if (CheckPurchase == 0) {
							purchaseOrderUpList.add(cbd);
						} else {
							poService
									.deletePurchaseOrderLine(purchaseOrderLineId[n]);
						}

					}
				}
				purchaseOrderUpdate.setPoLine(purchaseOrderUpList);
			}

			msg = poService.updatePurchaseOrder(purchaseOrderUpdate);
			String purcUpdate = null;
			if (msg.equals("Updated")) {
				purcUpdate = "$uccess : Purchase order Data is updated successfully";
				request.setAttribute("purchaseOrderUpdate", purcUpdate);

			} else {
				String fail = "Error ! : Purchase order data is not updated properly";
				request.setAttribute("purchaseOrderUpdateError", fail);
				model.addAttribute("purchaseOrderCommand", new PurchaseOrder());
				return "purchaseOrderHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
			String fail = "Error ! : Purchase order data is not updated properly";
			request.setAttribute("purchaseOrderUpdateError", fail);
			model.addAttribute("purchaseOrderCommand", new PurchaseOrder());
			return "purchaseOrderHome";

		}

		return "purchaseOrderHome";
	}

	@RequestMapping(value = "/purchaseOrderDelete", method = RequestMethod.GET)
	public String pODelete(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String userId = session.getAttribute("userId").toString();

		try {

			int id = Integer.parseInt(request.getParameter("purchaseOrderId"));
			msg = poService.deletePurchaseOrder(id);
			if (msg.equals("S")) {
				model.addAttribute("purchaseOrderCommand", new PurchaseOrder());
				Date date1 = new Date();
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date1);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Purchase Order", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				String purcUpdate = "$uccess : Purchase Order  Data is deleted successfully";
				request.setAttribute("poDelete", purcUpdate);
				return "purchaseOrderHome";
			} else {
				model.addAttribute("purchaseOrderCommand", new PurchaseOrder());
				String fail = "Error ! : Purchase order data is not deleted properly";
				request.setAttribute("poDeleteError", fail);
				return "purchaseOrderHome";
			}

		} catch (Exception e) {
			String fail = "Error ! : Purchase order data is not deleted properly";
			request.setAttribute("poDeleteError", fail);
			model.addAttribute("purchaseOrderCommand", new PurchaseOrder());
			return "purchaseOrderHome";
		}

	}

}