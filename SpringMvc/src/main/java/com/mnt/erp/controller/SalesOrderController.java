/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.bean.CustomerInvoiceLine;
import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.DeliveryNoteLine;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.OrderType;
import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.bean.SalesGroup;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.SalesOrderLineBean;
import com.mnt.erp.bean.SalesOrderSchLineBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.WorkFlowList;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CustomerInvoiceService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.DeliveryNoteService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.SalesOrderService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 20-11-2013
 */
@Controller
public class SalesOrderController {
	private static Logger log = Logger.getLogger(SalesOrderController.class);
	@Autowired
	SalesOrderService salesOrderService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	DeliveryNoteService deliveryNoteService;
	@Autowired
	CustomerInvoiceService ciservice;
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
	Object obj = null;
	HttpSession session = null;
	String message = "";

	@RequestMapping(value = "/salesOrderHome", method = RequestMethod.GET)
	public ModelAndView salesOrderHome(
			@ModelAttribute("salesOrderCmd") SalesOrderBean salesOrderBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("salesOrderHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		response.setCharacterEncoding("UTF-8");
		return new ModelAndView("salesOrderHome", "salesOrderCmd",
				salesOrderBean);

	}

	@ModelAttribute("custSelect")
	public Map<Integer, String> custSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesOrderService.selectCustomerIds();
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

	@ModelAttribute("salesGroupSelect")
	public Map<Integer, String> salesGroupSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesOrderService.selectSalesGroupIds();
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

	@ModelAttribute("orderTypeSelect")
	public Map<Integer, String> orderTypeSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesOrderService.selectOrderTypeIds();
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

	@ModelAttribute("paymentTermsSelect")
	public Map<Integer, String> paymentTermsSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesOrderService.selectPaymentTermIds();
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

	@ModelAttribute("SelectCurrency")
	public Map<Integer, String> currencySelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesOrderService.populateCurrencyIds();
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

	@ModelAttribute("materialSelect")
	public Map<Integer, String> materialSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesOrderService.populateMaterialIds();
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

	@ModelAttribute("SelectUom")
	public Map<Integer, String> uomSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesOrderService.populateUOMIds();
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

	@RequestMapping(value = "/checkSOAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkSOAddDuplicate(
			@RequestParam(value = "salesOrderNo", required = true) String salesNo,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long checkCustName = salesOrderService.checkSalesOrder(salesNo);
		if (checkCustName != 0) {
			message = "Warning ! Sales Order No is Already exists. Please try some other name";
		} else {
			message = "";
		}
		return message;
	}

	@RequestMapping(value = "/salesOrderAdd", method = RequestMethod.POST)
	public String saveSalesOrder(
			@ModelAttribute("salesOrderCmd") SalesOrderBean saveSalesBean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status) {
		session = request.getSession(false);
		response.setCharacterEncoding("UTF-8");
		String salesOrderSave = null;

		List<SalesOrderLineBean> salesOrderLine = new ArrayList<SalesOrderLineBean>();
		Set<SalesOrderSchLineBean> salesSearch = new HashSet<SalesOrderSchLineBean>();
		String materialId[] = saveSalesBean.getMaterialId();
		String qty[] = saveSalesBean.getQuantity();
		String uomId[] = saveSalesBean.getUomId();
		String custMatNo[] = saveSalesBean.getCustMaterailNo();
		String curId[] = saveSalesBean.getCurrencyId();
		String uPrice[] = saveSalesBean.getuPrice();
		String netPrice[] = saveSalesBean.getNetPrice();
		String tax[] = saveSalesBean.getTax();
		String disc[] = saveSalesBean.getDiscount();
		String totAmt[] = saveSalesBean.getTotalAmt();
		String uId[] = saveSalesBean.getSosUomId();
		String cQty[] = saveSalesBean.getSosQuantity();
		String cdelDate[] = saveSalesBean.getSosDelDate();
		float amt = 0.0f;
		SalesOrderBean soBean = (SalesOrderBean) saveSalesBean;
		try {

			soBean.setCustPODate(dateService.dateFormat(
					dateService.dateParse(soBean.getCustPODate(), "au"), "au"));
			soBean.setReqDeliveryDate(dateService.dateFormat(
					dateService.dateParse(soBean.getReqDeliveryDate(), "au"),
					"au"));
			soBean.setSalesOrderDate(dateService.dateFormat(
					dateService.dateParse(soBean.getSalesOrderDate(), "au"),
					"au"));

			if (materialId != null) {
				SalesOrderLineBean sLine = new SalesOrderLineBean();
				if (uId != null) {
					for (int m = 0; m < uId.length; m++) {
						SalesOrderSchLineBean ss = new SalesOrderSchLineBean();
						ss.setSosUomId(uId[m]);
						ss.setSosQuantity(cQty[m]);
						ss.setSosDelDate(cdelDate[m]);
						salesSearch.add(ss);
						sLine.setSalesSearchLine(salesSearch);
					}

				}
				for (int n = 0; n < materialId.length; n++) {
					SalesOrderLineBean soLine = new SalesOrderLineBean();
					soLine.setMaterialId(materialId[n]);
					soLine.setQuantity(qty[n]);
					soLine.setUomId(uomId[n]);
					soLine.setCurrencyId(curId[n]);
					soLine.setCustMaterailNo(custMatNo[n]);
					soLine.setuPrice(uPrice[n]);
					soLine.setNetPrice(netPrice[n]);
					soLine.setTax(tax[n]);
					soLine.setDiscount(disc[n]);
					soLine.setTotalAmt(totAmt[n]);
					salesOrderLine.add(soLine);
					amt = +Float.parseFloat(totAmt[n]);
				}

				soBean.setSalesOrderLineBean(salesOrderLine);
			}
			int odrId = Integer.parseInt(soBean.getOrderTypeId());

			
			
			
			
			if (2 == odrId) {
				
				String msg = salesOrderService.saveSalesOrder(soBean);
				log.info("savedetails=="+msg);
				

				// Delivery Note Add
				int sid = soBean.getSalesOrderId();
				DeliveryNote dn = new DeliveryNote();
				Set<DeliveryNoteLine> dLine = new HashSet<DeliveryNoteLine>();
				dn.setSalesOrderId(Integer.toString(sid));
				Date date = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				dn.setActualGI(df.format(date));
				dn.setPlannedGI(df.format(date));
				dn.setDeliveryNoteDate(df.format(date));
				dn.setTotalWeight(totAmt[0]);
				dn.setUomId(uomId[0]);
				dn.setNoofPacks("0");
				dn.setStatusId("100");

				for (int n = 0; n < materialId.length; n++) {
					DeliveryNoteLine dnl = new DeliveryNoteLine();
					dnl.setMaterialId(Integer.parseInt(materialId[n]));
					dnl.setQuantity(Integer.parseInt(qty[n]));
					dnl.setUomId(Integer.parseInt(uomId[n]));
					dnl.setStorageLoacationId(1);
					dLine.add(dnl);
				}
				dn.setDeliveryNotes(dLine);
				deliveryNoteService.saveDeliveryNote(dn);

				// Customer Invoice Add
				int delId = dn.getDeliveryNoteId();
				CustomerInvoice ci = new CustomerInvoice();
				List<CustomerInvoiceLine> custInvoice = new ArrayList<CustomerInvoiceLine>();
				ci.setCustomerinvoiceno("cash sale");
				ci.setDeliverynoteid(Integer.toString(delId));
				ci.setCustomerinvoicedate(df.format(date));
				ci.setPostingdate(df.format(date));
				ci.setAmount(Float.valueOf(amt));
				ci.setCurrencyid(curId[0]);
				ci.setReference("mnt");
				ci.setDescription("cash sale");
				// Get Organization Id
				String orgId = salesOrderService.getOrganizationId(session
						.getAttribute("userId").toString());
				ci.setOrgid(orgId);
				ci.setFy(String.valueOf(cal.get(Calendar.YEAR)));
				for (int n = 0; n < materialId.length; n++) {
					CustomerInvoiceLine cil = new CustomerInvoiceLine();
					cil.setMaterialid(materialId[n]);
					cil.setQty(Integer.parseInt(qty[n]));
					cil.setUomid(uomId[n]);
					cil.setPrice(netPrice[n]);
					cil.setTax(tax[n]);
					custInvoice.add(cil);
				}
				ci.setCustomerinvoicelinebean(custInvoice);
				ciservice.saveCustomerInvoiceservice(ci);
				ci.setCustomerinvoiceno(String.valueOf(ci
						.getCustomerinvoiceid()));
				ciservice.updateCustomerInvoiceservice(ci);

				if (msg.equals("S")) {
					String ms=saveWorkFlowDetails(saveSalesBean);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(new Date());
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Sales Order", "ROW", String.valueOf(soBean
									.getSalesOrderId()), "1", modifiedDate,
							session.getAttribute("userName").toString());
					salesOrderSave = "Sales Order Data Saved Successfully";
				} else {
					salesOrderSave = "Sales Order Data Insertion Failures";
					return "redirect:salesOrderHome.mnt?addSOFail="
							+ salesOrderSave + "";
				}
			} else {
				String msg = salesOrderService.saveSalesOrder(soBean);
				if (msg.equals("S")) {
					String ms=saveWorkFlowDetails(saveSalesBean);
					session = request.getSession(false);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(new Date());
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Sales Order", "ROW", String.valueOf(soBean
									.getSalesOrderId()), "1", modifiedDate,
							session.getAttribute("userName").toString());
					salesOrderSave = "Sales Order Data Saved Successfully";
				} else {

					salesOrderSave = "Sales Order Data Insertion Failures";
					return "redirect:salesOrderHome.mnt?addSOFail="
							+ salesOrderSave + "";
				}
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:salesOrderHome.mnt?addSOFail=" + salesOrderSave
					+ "";

		}
		return "redirect:salesOrderHome.mnt?addSOSus=" + salesOrderSave + "";

	}

	@RequestMapping(value = "/checkSOUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkSOUpdateDuplicate(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "esalesOrderNo", required = true) String salesNo,
			@RequestParam(value = "soId", required = true) int soId) {
		response.setCharacterEncoding("UTF-8");
		String message = null;
		int checkCustName = salesOrderService.updateCheckSalesOrder(salesNo,
				soId);

		if (checkCustName != 0) {
			message = "Warning ! Sales Order No is Already exists. Please try some other name";
		} else {
			message = null;
		}

		return message;
	}

	@RequestMapping(value = "/salesOrderSearch", method = RequestMethod.GET)
	public String searchSalesOrder(
			@ModelAttribute("salesOrderCmd") SalesOrderBean SalesOrderBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<SalesOrderBean> SOList = new ArrayList<SalesOrderBean>();
		try {
			String dbField = SalesOrderBeanSearch.getXmlLabel();
			String operation = SalesOrderBeanSearch.getOperations();
			String basicSearchId = SalesOrderBeanSearch.getBasicSearchId();

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
				list = salesOrderService.searchSalesOrder();

			} else {

				list = salesOrderService.basicSearchSalesOrder(dbField,
						operation, basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				SalesOrderBean sob = new SalesOrderBean();
				sob.setSalesOrderId((Integer) objects[0]);
				sob.setCustPONumber((String) objects[1]);

				sob.setCustPODate(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));
				sob.setReqDeliveryDate(dateService.dateFormat(
						dateService.dateParse((String) objects[3], "se"), "se"));
				sob.setSalesOrderDate(dateService.dateFormat(
						dateService.dateParse((String) objects[4], "se"), "se"));
				sob.setNetWeight((String) objects[5]);
				sob.setTotalWeight((String) objects[6]);
				sob.setTotalVolume((String) objects[7]);
				sob.setOrderReason((String) objects[8]);
				sob.setPriority((String) objects[9]);
				sob.setUnloadingPoint((String) objects[10]);
				sob.setRoute((String) objects[11]);
				sob.setReceivingPoint((String) objects[12]);

				CustomerBean cBean = ((CustomerBean) objects[13]);
				sob.setCustomerId(cBean.getCustomerName());
				SalesGroup sGroup = ((SalesGroup) objects[14]);
				sob.setSalesGroupId(sGroup.getSalesGroup());
				OrderType oType = ((OrderType) objects[15]);
				sob.setOrderTypeId(oType.getOrderType());
				PaymentTerms pt = ((PaymentTerms) objects[16]);
				sob.setPaymentTermId(pt.getPaymentTermName());
				sob.setSalesOrderNo((String) objects[17]);
				Uom u = ((Uom) objects[18]);
				sob.setUom(u.getUom());
				Status st = ((Status) objects[19]);
				sob.setStatusId(st.getStatus());
				SOList.add(sob);
			}
			request.setAttribute("SOList", SOList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salesOrderHome";

	}

	@RequestMapping(value = "/salesOrderDelete", method = RequestMethod.GET)
	public String salesOrderDelete(
			@ModelAttribute("salesOrderCmd") SalesOrderBean SalesOrderBeanDelete,
			@RequestParam(value = "salesOrderId", required = true) int salesId,
			HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		String SODelete = null;
		try {
			String msg = salesOrderService.deleteSalesOrder(salesId);

			if (msg.equals("Deleted")) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Sales Order", "ROW", String
						.valueOf(salesId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				SODelete = "Sales Order Deleted Successfully";

			} else {
				SODelete = "Sales Order Deletion Failed due to Conatraint Violation";
				return "redirect:salesOrderHome.mnt?DeleteSOFail=" + SODelete
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:salesOrderHome.mnt?DeleteSOFail=" + SODelete + "";
		}
		return "redirect:salesOrderHome.mnt?DeleteSOsus=" + SODelete + "";

	}

	@RequestMapping(value = "/SalesOrderEdit", method = RequestMethod.GET)
	public String salesInquiryEdit(
			@RequestParam(value = "salesOrderId", required = true) int salesId,
			@ModelAttribute("salesOrderCmd") SalesOrderBean salesOrderBeanEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<SalesOrderBean> salesEditList = new ArrayList<SalesOrderBean>();
		List<SalesOrderLineBean> salesLineEditList = new ArrayList<SalesOrderLineBean>();
		List<SalesOrderSchLineBean> salesSchEditList = new ArrayList<SalesOrderSchLineBean>();
		try {

			List<Object> l = salesOrderService.searchSalesOrderWithId(salesId);

			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				SalesOrderBean sob = (SalesOrderBean) oo;
				salesOrderBeanEdit.setEsalesOrderId(sob.getSalesOrderId());
				salesOrderBeanEdit.setEsalesOrderNo(sob.getSalesOrderNo());
				salesOrderBeanEdit.setEsalesGroupId(sob.getSalesGroupId());
				salesOrderBeanEdit.setEcustomerId(sob.getCustomerId());
				salesOrderBeanEdit.setEorderTypeId(sob.getOrderTypeId());
				salesOrderBeanEdit.setEpaymentTermId(sob.getPaymentTermId());
				salesOrderBeanEdit.setEuom(sob.getUom());
				salesOrderBeanEdit.setEcustPONumber(sob.getCustPONumber());

				salesOrderBeanEdit
						.setEcustPODate(dateService.dateFormat(dateService
								.dateParse(sob.getCustPODate(), "se"), "se"));
				salesOrderBeanEdit.setEsalesOrderDate(dateService.dateFormat(
						dateService.dateParse(sob.getReqDeliveryDate(), "se"),
						"se"));
				salesOrderBeanEdit.setEreqDeliveryDate(dateService.dateFormat(
						dateService.dateParse(sob.getSalesOrderDate(), "se"),
						"se"));
				salesOrderBeanEdit.setEnetWeight(sob.getNetWeight());
				salesOrderBeanEdit.setEtotalWeight(sob.getTotalWeight());
				salesOrderBeanEdit.setEtotalVolume(sob.getTotalVolume());
				salesOrderBeanEdit.setEorderReason(sob.getOrderReason());
				salesOrderBeanEdit.setEunloadingPoint(sob.getUnloadingPoint());
				salesOrderBeanEdit.setEpriority(sob.getPriority());
				salesOrderBeanEdit.setEroute(sob.getRoute());
				salesOrderBeanEdit.setEreceivingPoint(sob.getReceivingPoint());
				salesOrderBeanEdit.setEstatusId(sob.getStatusId());

				List<SalesOrderLineBean> listEdit = sob.getSalesOrderLineBean();
				Iterator<SalesOrderLineBean> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					SalesOrderLineBean so = (SalesOrderLineBean) o;
					SalesOrderLineBean soMultiple = new SalesOrderLineBean();
					soMultiple.setEsalesOrderLineId(so.getSalesOrderLineId());
					soMultiple.setEmaterialId(so.getMaterialId());
					soMultiple.setEuomId(so.getUomId());
					soMultiple.setEcurrencyId(so.getCurrencyId());
					soMultiple.setEquantity(so.getQuantity());
					soMultiple.setEcustMaterailNo(so.getCustMaterailNo());
					soMultiple.setEuPrice(so.getuPrice());
					soMultiple.setEnetPrice(so.getNetPrice());
					soMultiple.setEtax(so.getTax());
					soMultiple.setEdiscount(so.getDiscount());
					soMultiple.setEtotalAmt(so.getTotalAmt());
					Material mt = so.getMaterial();
					soMultiple.setEmaterialName(mt.getMaterialName());
					Uom uom = so.getUom();
					soMultiple.setEuomName(uom.getUom());
					Currency cc = so.getCurrency();
					soMultiple.setEcurrencyName(cc.getCurrency());

					salesLineEditList.add(soMultiple);

				}
				salesOrderBeanEdit.setSalesOrderLineBean(listEdit);
				salesEditList.add(salesOrderBeanEdit);
			}

			request.setAttribute("salesOdrEditList", salesEditList);
			request.setAttribute("salesOdrLineEditList", salesLineEditList);
			// request.setAttribute("salesSchEditList", salesSchEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salesOrderHome";
	}

	@RequestMapping(value = "/salesOrderUpdate", method = RequestMethod.POST)
	public String salesOrderUpdate(
			@ModelAttribute("salesOrderCmd") SalesOrderBean SalesOrderBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setCharacterEncoding("UTF-8");
		List<SalesOrderLineBean> SOLineUpList = new ArrayList<SalesOrderLineBean>();
		Set<SalesOrderSchLineBean> SOSLineUpList = new HashSet<SalesOrderSchLineBean>();
		String msg = null;
		String salesUpdate = null;

		SalesOrderBeanUpdate.setSalesOrderId(SalesOrderBeanUpdate
				.getEsalesOrderId());
		SalesOrderBeanUpdate.setSalesOrderNo(SalesOrderBeanUpdate
				.getEsalesOrderNo());
		SalesOrderBeanUpdate.setCustomerId(SalesOrderBeanUpdate
				.getEcustomerId());
		SalesOrderBeanUpdate.setSalesGroupId(SalesOrderBeanUpdate
				.getEsalesGroupId());
		SalesOrderBeanUpdate.setOrderTypeId(SalesOrderBeanUpdate
				.getEorderTypeId());
		SalesOrderBeanUpdate.setPaymentTermId(SalesOrderBeanUpdate
				.getEpaymentTermId());

		SalesOrderBeanUpdate
				.setSalesOrderDate(dateService.dateFormat(dateService
						.dateParse(SalesOrderBeanUpdate.getEsalesOrderDate(),
								"au"), "au"));
		SalesOrderBeanUpdate.setCustPONumber(SalesOrderBeanUpdate
				.getEcustPONumber());
		SalesOrderBeanUpdate.setCustPODate(dateService.dateFormat(dateService
				.dateParse(SalesOrderBeanUpdate.getEcustPODate(), "au"), "au"));
		SalesOrderBeanUpdate.setUom(SalesOrderBeanUpdate.getEuom());
		SalesOrderBeanUpdate
				.setReqDeliveryDate(dateService.dateFormat(dateService
						.dateParse(SalesOrderBeanUpdate.getEreqDeliveryDate(),
								"au"), "au"));
		SalesOrderBeanUpdate.setNetWeight(SalesOrderBeanUpdate.getEnetWeight());
		SalesOrderBeanUpdate.setTotalWeight(SalesOrderBeanUpdate
				.getEtotalWeight());
		SalesOrderBeanUpdate.setTotalVolume(SalesOrderBeanUpdate
				.getEtotalVolume());
		SalesOrderBeanUpdate.setOrderReason(SalesOrderBeanUpdate
				.getEorderReason());
		SalesOrderBeanUpdate.setRoute(SalesOrderBeanUpdate.getEroute());
		SalesOrderBeanUpdate.setUnloadingPoint(SalesOrderBeanUpdate
				.getEunloadingPoint());
		SalesOrderBeanUpdate.setReceivingPoint(SalesOrderBeanUpdate
				.getEreceivingPoint());
		SalesOrderBeanUpdate.setPriority(SalesOrderBeanUpdate.getEpriority());
		SalesOrderBeanUpdate.setStatusId(SalesOrderBeanUpdate.getEstatusId());

		int sLineId[] = SalesOrderBeanUpdate.getEsalesOrderLineId();
		String matid[] = SalesOrderBeanUpdate.getEmaterialId();
		String qty[] = SalesOrderBeanUpdate.getEquantity();
		String uomId[] = SalesOrderBeanUpdate.getEuomId();
		String curid[] = SalesOrderBeanUpdate.getEcurrencyId();
		String custMtdNo[] = SalesOrderBeanUpdate.getEcustMaterailNo();
		String nPrice[] = SalesOrderBeanUpdate.getEnetPrice();
		String uPrice[] = SalesOrderBeanUpdate.getEuPrice();
		String tax[] = SalesOrderBeanUpdate.getEtax();
		String disc[] = SalesOrderBeanUpdate.getEdiscount();
		String totAmt[] = SalesOrderBeanUpdate.getEtotalAmt();

		int sosId[] = SalesOrderBeanUpdate.getEsalesOrderSchLineId();
		String cQty[] = SalesOrderBeanUpdate.getEsosQuantity();
		String cuId[] = SalesOrderBeanUpdate.getEsosUomId();
		String cDelDate[] = SalesOrderBeanUpdate.getEsosDelDate();
		String childDelete = "", childSch = "", str = "1";
		int id = 0, schId = 0;

		if (matid != null) {

			/*
			 * if (cuId != null) { SalesOrderLineBean sib = new
			 * SalesOrderLineBean(); for (int m = 0; m < cuId.length; m++) {
			 * SalesOrderSchLineBean ss = new SalesOrderSchLineBean();
			 * ss.setSosUomId(cuId[m]); ss.setSosQuantity(cQty[m]);
			 * ss.setSosDelDate(cDelDate[m]); schId = sosId[m]; childSch =
			 * request.getParameter("checkSch" + schId); if
			 * (str.equals(childSch)) { msg =
			 * salesOrderService.deleteSalesOrderSch(schId);
			 * 
			 * } else { SOSLineUpList.add(ss);
			 * 
			 * }
			 * 
			 * } sib.setSalesSearchLine(SOSLineUpList);
			 * 
			 * }
			 */

			for (int n = 0; n < matid.length; n++) {
				int cbId = sLineId[n];
				if (cbId == 0) {
					SalesOrderLineBean sib = new SalesOrderLineBean();
					sib.setMaterialId(matid[n]);
					sib.setQuantity(qty[n]);
					sib.setUomId(uomId[n]);
					sib.setCurrencyId(curid[n]);
					sib.setNetPrice(nPrice[n]);
					sib.setuPrice(uPrice[n]);
					sib.setCustMaterailNo(custMtdNo[n]);
					sib.setTax(tax[n]);
					sib.setDiscount(disc[n]);
					sib.setTotalAmt(totAmt[n]);
					SOLineUpList.add(sib);
					sib.setSalesSearchLine(SOSLineUpList);
				} else {
					SalesOrderLineBean sib = new SalesOrderLineBean();
					sib.setMaterialId(matid[n]);
					sib.setQuantity(qty[n]);
					sib.setUomId(uomId[n]);
					sib.setCurrencyId(curid[n]);
					sib.setNetPrice(nPrice[n]);
					sib.setuPrice(uPrice[n]);
					sib.setCustMaterailNo(custMtdNo[n]);
					sib.setTax(tax[n]);
					sib.setDiscount(disc[n]);
					sib.setTotalAmt(totAmt[n]);
					id = sLineId[n];
					childDelete = request.getParameter("Check" + id);

					if (str.equals(childDelete)) {
						msg = salesOrderService.deleteSalesOrderLine(id);

					} else {
						SOLineUpList.add(sib);
						sib.setSalesSearchLine(SOSLineUpList);
					}
				}

			}

		}

		try {

			SalesOrderBeanUpdate.setSalesOrderLineBean(SOLineUpList);
			msg = salesOrderService.updateSalesOrder(SalesOrderBeanUpdate);

			if (msg == "success") {
				salesUpdate = "Sales Order Data Updated Successfully";

			} else {
				salesUpdate = "Sales Order Data Updation Failed";
				return "redirect:salesOrderHome.mnt?UpdateSOFail="
						+ salesUpdate + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:salesOrderHome.mnt?UpdateSOFail=" + salesUpdate
					+ "";
		}

		return "redirect:salesOrderHome.mnt?UpdateSOsus=" + salesUpdate + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "salesOrderId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/SOAdvanceSearch", method = RequestMethod.GET)
	public String soAdvanceSearch(
			@ModelAttribute("salesOrderCmd") SalesOrderBean st,
			HttpServletRequest request, HttpServletResponse response) {
		List<Object[]> objArray = null;
		List<SalesOrderBean> stList = new ArrayList<SalesOrderBean>();
		List<SalesOrderBean> refList = new ArrayList<SalesOrderBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("salesOrderId");

			for (Object[] object : objArray) {
				SalesOrderBean s = new SalesOrderBean();
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
		return "salesOrderHome";
	}

	@RequestMapping(value = "/SOAdvanceSearchOperations", method = RequestMethod.GET)
	public String soAdvanceSearchOperations(
			@ModelAttribute("salesOrderCmd") SalesOrderBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<SalesOrderBean> SOList = new ArrayList<SalesOrderBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = salesOrderService.advSearchSalesOrder(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = salesOrderService.searchSalesOrder();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			SalesOrderBean sob = new SalesOrderBean();
			sob.setSalesOrderId((Integer) objects[0]);
			sob.setCustPONumber((String) objects[1]);

			sob.setCustPODate(dateService.dateFormat(
					dateService.dateParse((String) objects[2], "se"), "se"));
			sob.setReqDeliveryDate(dateService.dateFormat(
					dateService.dateParse((String) objects[3], "se"), "se"));
			sob.setSalesOrderDate(dateService.dateFormat(
					dateService.dateParse((String) objects[4], "se"), "se"));
			sob.setNetWeight((String) objects[5]);
			sob.setTotalWeight((String) objects[6]);
			sob.setTotalVolume((String) objects[7]);
			sob.setOrderReason((String) objects[8]);
			sob.setPriority((String) objects[9]);
			sob.setUnloadingPoint((String) objects[10]);
			sob.setRoute((String) objects[11]);
			sob.setReceivingPoint((String) objects[12]);

			CustomerBean cBean = ((CustomerBean) objects[13]);
			sob.setCustomerId(cBean.getCustomerName());
			SalesGroup sGroup = ((SalesGroup) objects[14]);
			sob.setSalesGroupId(sGroup.getSalesGroup());
			OrderType oType = ((OrderType) objects[15]);
			sob.setOrderTypeId(oType.getOrderType());
			PaymentTerms pt = ((PaymentTerms) objects[16]);
			sob.setPaymentTermId(pt.getPaymentTermName());
			sob.setSalesOrderNo((String) objects[17]);
			Uom u = ((Uom) objects[18]);
			sob.setUom(u.getUom());
			Status st = ((Status) objects[19]);
			sob.setStatusId(st.getStatus());
			SOList.add(sob);
		}
		request.setAttribute("SOList", SOList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("salesOrderCmd", new SalesOrderBean());
		return "salesOrderHome";
	}
	
	public String saveWorkFlowDetails(SalesOrderBean saveSalesBean)
	{
		String wmsg=null;
		try
		{
		Date date = new Date();
		List<Object[]> list2 = null;
		String id = (String) session.getAttribute("userId"), stepid = null, userid = null;
		WorkFlowList wflist = new WorkFlowList();
		wflist.setReceivedFrom(id);
		wflist.setWorkListId(saveSalesBean.getSalesOrderNo());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(Calendar.getInstance().getTime());
		wflist.setReceivedDTTM(dateFormat.format(date));
		wflist.setWorkListContext("SO");
		wflist.setWorkListStatus("Queued");
		list2 = salesOrderService.getStepUsers();
		log.info("list sixze is=="+list2.size());
		Iterator<Object[]> iterator = list2.iterator();
		while (iterator.hasNext()) {
			
			Object[] objects = (Object[]) iterator.next();
			stepid = (String) objects[0];
			userid = (String) objects[1];
			log.info("sales step savee=="+stepid);
		}
		wflist.setUserId(userid);
		wflist.setStep(stepid);
	 wmsg = salesOrderService.saveWorkFlowListDaoDetails(wflist);	
		}
catch(Exception e)
{
	log.error(e.getMessage());
}
	
		return wmsg;
	}
	
}
