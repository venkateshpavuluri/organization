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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
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
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.bean.SalesPOLineBean;
import com.mnt.erp.bean.SalesPurchaseOrderBean;
import com.mnt.erp.bean.SalesQuotationBean;
import com.mnt.erp.bean.SalesQuotationLineBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.SalesPOService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 04-12-2013
 */

@Controller
public class SalesPOController {

	private static final Logger log = Logger.getLogger(SalesPOController.class);
	@Autowired
	SalesPOService salesPOService;
	@Autowired
	XmlLabelsService xmlService;
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
	String message;

	@RequestMapping(value = "/salesPOHome", method = RequestMethod.GET)
	public ModelAndView salesPOHome(
			@ModelAttribute("salesPOCmd") SalesPurchaseOrderBean salesPOBean,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("salesPOHome.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("salesPOHome", "salesPOCmd", salesPOBean);

	}

	@ModelAttribute("custSelect")
	public Map<Integer, String> custSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesPOService.selectCustomerIds();
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
			list = salesPOService.populateCurrencyIds();
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
			list = salesPOService.populateMaterialIds();
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
			list = salesPOService.populateUOMIds();
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

	@ModelAttribute("salesQuotSelect")
	public Map<Integer, String> salesInquirySelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesPOService.selectSalesQuotationIds();
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

	@ModelAttribute("paymentTermSelect")
	public Map<Integer, String> paymentTermSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesPOService.selectPaymentTermIds();
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
	public Map<Integer, String> statusSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesPOService.selectStatusIds();
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

	@RequestMapping(value = "/salesQuotDetails", method = RequestMethod.POST)
	@ResponseBody
	String getSalesQuotDetails(
			@RequestParam(value = "salesQuotId", required = true) int salesQuotId,
			HttpServletResponse response, HttpServletRequest request) {
		List<Object> list = null;
		String jsonDataChild = "";
		int count = 1;
		try {
			list = salesPOService.editSalesQuotationWithId(salesQuotId);
			Iterator<Object> iterator = list.iterator();
			if (iterator.hasNext()) {
				Object salesObj = iterator.next();
				SalesQuotationBean sales = (SalesQuotationBean) salesObj;
				Set<SalesQuotationLineBean> listEdit = sales
						.getSalesQuotationLineBean();
				List<SalesQuotationLineBean> listJson = new ArrayList<SalesQuotationLineBean>();
				Iterator<SalesQuotationLineBean> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object siLineObj = iter.next();
					SalesQuotationLineBean SILine = (SalesQuotationLineBean) siLineObj;
					Material material = (Material) SILine.getMaterial();
					Uom uom = (Uom) SILine.getUom();
					Currency cur = (Currency) SILine.getCurrency();
					SalesQuotationLineBean sq = new SalesQuotationLineBean();
					sq.setMaterialId(SILine.getMaterialId());
					sq.setEmaterialName(material.getMaterialName());
					sq.setQuantity(SILine.getQuantity());
					sq.setUmId(SILine.getUOMId());
					sq.setEuomName(uom.getUom());
					sq.setCurrencyId(SILine.getCurrencyId());
					sq.setEcurrencyName(cur.getCurrency());
					sq.setPerUnit(SILine.getPerUnit());
					sq.setLineAmount(SILine.getLineAmount());
					sq.setCount(count);
					listJson.add(sq);
					count++;
				}
				ObjectMapper mapper = new ObjectMapper();
				jsonDataChild = mapper.writeValueAsString(listJson);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonDataChild;
	}

	@RequestMapping(value = "/checkSPOAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkSPOAddDuplicate(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "salesPONo", required = true) String salesNo) {
		response.setCharacterEncoding("UTF-8");
		Long checkCustName = salesPOService.checkSalesPO(salesNo);
		if (checkCustName != 0) {
			message = "Warning ! Sales Purchase Order No is Already exists. Please try some other name";
		} else {
			message = null;
		}

		return message;
	}

	@RequestMapping(value = "/salesPOAdd", method = RequestMethod.POST)
	public String saveSalesPO(
			@ModelAttribute("salesPOCmd") SalesPurchaseOrderBean saveSalesBean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status) {
		response.setCharacterEncoding("UTF-8");
		String salesPOSave = null;
		List<SalesPOLineBean> salesPOLine = new ArrayList<SalesPOLineBean>();
		String materialId[] = saveSalesBean.getMaterialId();
		String qty[] = saveSalesBean.getQuantity();
		String uomId[] = saveSalesBean.getUOMId();
		String curId[] = saveSalesBean.getCurId();
		String unitPrice[] = saveSalesBean.getUnitPrice();
		String lineAmt[] = saveSalesBean.getLineAmount();
		String duedate[] = saveSalesBean.getDueDateChild();

		session = request.getSession(false);
		saveSalesBean.setCreatedBy((String) session.getAttribute("userId"));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		saveSalesBean.setCreatedDTTM(df.format(new Date()));
		SalesPurchaseOrderBean spoBean = (SalesPurchaseOrderBean) saveSalesBean;
		if (spoBean.getSalesQuotationId().equals("0")) {
			spoBean.setSalesQuotationId(null);
		}
		try {
			spoBean.setSalesPODate(dateService.dateFormat(
					dateService.dateParse(spoBean.getSalesPODate(), "au"), "au"));
			spoBean.setDueDate(dateService.dateFormat(
					dateService.dateParse(spoBean.getDueDate(), "au"), "au"));
			if (materialId.length != 0 && curId.length != 0) {

				for (int n = 0; n < materialId.length; n++) {
					SalesPOLineBean siLine = new SalesPOLineBean();
					siLine.setMaterialId(materialId[n]);
					siLine.setQuantity(qty[n]);
					siLine.setUOMId(uomId[n]);
					siLine.setCurId(curId[n]);
					siLine.setUnitPrice(unitPrice[n]);
					siLine.setLineAmount(lineAmt[n]);
					if (duedate.length > 0) {
						siLine.setDueDateChild(dateService.dateFormat(
								dateService.dateParse(duedate[n], "au"), "au"));
					} else {
						siLine.setDueDateChild(dateService.dateFormat(
								new Date(), "au"));
					}
					salesPOLine.add(siLine);
				}
				spoBean.setSalesPOLine(salesPOLine);
			}
			String msg = salesPOService.saveSalesPO(spoBean);
			if (msg.equals("success")) {
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Sales PO", "ROW", String
						.valueOf(spoBean.getSalesPOId()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				salesPOSave = "Sales Purchase Order Data is saved Successfully";
			} else {
				return "redirect:salesPOHome.mnt?addSPOFail=" + salesPOSave
						+ "";

			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:salesPOHome.mnt?addSPOFail=" + salesPOSave + "";
		}
		return "redirect:salesPOHome.mnt?addSPOSus=" + salesPOSave + "";
	}

	@RequestMapping(value = "/checkSPOUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkSPOUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "salesPONo", required = true) String salesNo,
			@RequestParam(value = "spoId", required = true) int sqId) {
		response.setCharacterEncoding("UTF-8");
		int checkCustName = salesPOService.updateCheckSalesPO(salesNo, sqId);
		if (checkCustName != 0) {
			message = "Warning ! Sales Purchase Order No is Already exists. Please try some other name";
		} else {
			message = null;
		}
		return message;
	}

	@RequestMapping(value = "/salesPOSearch", method = RequestMethod.GET)
	public String searchSalesPO(
			@ModelAttribute("salesPOCmd") SalesPurchaseOrderBean salesPOBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<SalesPurchaseOrderBean> SPOList = new ArrayList<SalesPurchaseOrderBean>();
		try {
			String dbField = salesPOBeanSearch.getXmlLabel();
			String operation = salesPOBeanSearch.getOperations();
			String basicSearchId = salesPOBeanSearch.getBasicSearchId();

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
				list = salesPOService.searchSalesPO();

			} else {

				list = salesPOService.basicSearchSalesPO(dbField, operation,
						basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				SalesPurchaseOrderBean spob = new SalesPurchaseOrderBean();
				spob.setSalesPOId((Integer) objects[0]);
				spob.setSalesPONbr((String) objects[1]);
				spob.setSalesPOValue((String) objects[2]);
				spob.setSalesPODate(dateService.dateFormat(
						dateService.dateParse((String) objects[3], "se"), "se"));
				spob.setDescription((String) objects[4]);
				spob.setMemo((String) objects[5]);
				spob.setSalesTaxAmount((String) objects[6]);
				spob.setVATAmount((String) objects[7]);
				spob.setExiciseAmount((String) objects[8]);
				spob.setFrieghtCharges((String) objects[9]);
				spob.setPnFCharges((String) objects[10]);
				spob.setDueDate(dateService.dateFormat(
						dateService.dateParse((String) objects[11], "se"), "se"));
				CustomerBean cBean = ((CustomerBean) objects[14]);
				spob.setCustomerId(cBean.getCustomerName());
				PaymentTerms pt = ((PaymentTerms) objects[15]);
				spob.setPaymentTermId(pt.getPaymentTermName());
				Status st = ((Status) objects[16]);
				spob.setStatusId(st.getStatus());
				Currency cr = ((Currency) objects[17]);
				spob.setCurrencyId(cr.getCurrency());

				SPOList.add(spob);
			}
			request.setAttribute("SPOList", SPOList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salesPOHome";

	}

	@RequestMapping(value = "/salesPODelete", method = RequestMethod.GET)
	public String salesPODelete(
			@ModelAttribute("salesPOCmd") SalesPurchaseOrderBean SalesPOBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String sQDelete = null;
		int cId = Integer.parseInt(request.getParameter("salesPOId"));

		try {
			String msg = salesPOService.deleteSalesPO(cId);

			if (msg.equals("Deleted")) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Sales PO", "ROW", String
						.valueOf(cId), "1", modifiedDate,
						session.getAttribute("userName").toString());
				sQDelete = "Sales Purchase Order Deleted Successfully";

			} else {
				sQDelete = "Sales Purchase Order Deletion Failed due to Conatraint Violation";
				return "redirect:salesPOHome.mnt?DeleteSPOFail=" + sQDelete
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:salesPOHome.mnt?DeleteSPOFail=" + sQDelete + "";
		}
		return "redirect:salesPOHome.mnt?DeleteSPOsus=" + sQDelete + "";

	}

	@RequestMapping(value = "/SalesPOEdit", method = RequestMethod.GET)
	public String salesPOEdit(
			@ModelAttribute("salesPOCmd") SalesPurchaseOrderBean salesPOBeanEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<SalesPurchaseOrderBean> salesEditList = new ArrayList<SalesPurchaseOrderBean>();
		List<SalesPOLineBean> salesLineEditList = new ArrayList<SalesPOLineBean>();
		int salesId = salesPOBeanEdit.getSalesPOId();
		try {

			List<Object> l = salesPOService.searchSalesPOWithId(salesId);
			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				SalesPurchaseOrderBean spob = (SalesPurchaseOrderBean) oo;
				salesPOBeanEdit.setEsalesPOId(spob.getSalesPOId());
				salesPOBeanEdit.setEsalesPONbr(spob.getSalesPONbr());
				salesPOBeanEdit.setEsalesPODate(dateService.dateFormat(
						dateService.dateParse(spob.getSalesPODate(), "se"),
						"se"));
				salesPOBeanEdit.setEsalesPOValue(spob.getSalesPOValue());
				salesPOBeanEdit.setEdescription(spob.getDescription());
				salesPOBeanEdit
						.setEsalesQuotationId(spob.getSalesQuotationId());
				salesPOBeanEdit.setEcustomerId(spob.getCustomerId());
				salesPOBeanEdit.setEcurrencyId(spob.getCurrencyId());
				salesPOBeanEdit.setEstatusId(spob.getStatusId());
				salesPOBeanEdit.setEpaymentTermId(spob.getPaymentTermId());
				salesPOBeanEdit.setEmemo(spob.getMemo());
				salesPOBeanEdit.setEdueDate(dateService.dateFormat(
						dateService.dateParse(spob.getDueDate(), "se"), "se"));
				salesPOBeanEdit.setEexiciseAmount(spob.getExiciseAmount());
				salesPOBeanEdit.setEfrieghtCharges(spob.getFrieghtCharges());
				salesPOBeanEdit.setePnFCharges(spob.getPnFCharges());
				salesPOBeanEdit.seteVATAmount(spob.getVATAmount());
				salesPOBeanEdit.setEsalesTaxAmount(spob.getSalesTaxAmount());
				salesPOBeanEdit.setEcreatedBy(spob.getCreatedBy());
				salesPOBeanEdit.setEcreatedDTTM(spob.getCreatedDTTM());

				List<SalesPOLineBean> listEdit = spob.getSalesPOLine();

				Iterator<SalesPOLineBean> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					SalesPOLineBean spol = (SalesPOLineBean) o;
					SalesPOLineBean spoMultiple = new SalesPOLineBean();
					spoMultiple.setEsalesPOLineId(spol.getSalesPOLineId());
					spoMultiple.setEmaterialId(spol.getMaterialId());
					spoMultiple.seteUOMId(spol.getUOMId());
					spoMultiple.setEcurId(spol.getCurId());
					spoMultiple.setEquantity(spol.getQuantity());
					spoMultiple
							.setEdueDateChild(dateService.dateFormat(
									dateService.dateParse(
											spol.getDueDateChild(), "se"), "se"));
					spoMultiple.setEunitPrice(spol.getUnitPrice());
					spoMultiple.setElineAmount(spol.getLineAmount());

					Material mt = spol.getMaterial();
					spoMultiple.setEmaterialName(mt.getMaterialName());
					Uom uom = spol.getUom();
					spoMultiple.setEuomName(uom.getUom());
					Currency cr = spol.getCurrency();
					spoMultiple.setEcurrencyName(cr.getCurrency());
					salesLineEditList.add(spoMultiple);

				}
				salesPOBeanEdit.setSalesPOLine(salesLineEditList);
				salesEditList.add(salesPOBeanEdit);
			}

			request.setAttribute("salesPOEditList", salesEditList);
			request.setAttribute("salesPOLineEditList", salesLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salesPOHome";
	}

	@RequestMapping(value = "/salesPOUpdate", method = RequestMethod.POST)
	public String salesPOUpdate(
			@ModelAttribute("salesPOCmd") SalesPurchaseOrderBean SalesPOBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<SalesPOLineBean> SPOLineUpList = new ArrayList<SalesPOLineBean>();
		String msg = null;
		String salesUpdate = null;
		try {
			SalesPOBeanUpdate.setSalesPOId(SalesPOBeanUpdate.getEsalesPOId());
			SalesPOBeanUpdate.setSalesPONbr(SalesPOBeanUpdate.getEsalesPONbr());
			SalesPOBeanUpdate
					.setSalesPODate(dateService.dateFormat(
							dateService.dateParse(
									SalesPOBeanUpdate.getEsalesPODate(), "au"),
							"au"));
			SalesPOBeanUpdate.setSalesPOValue(SalesPOBeanUpdate
					.getEsalesPOValue());
			SalesPOBeanUpdate.setDescription(SalesPOBeanUpdate
					.getEdescription());
			SalesPOBeanUpdate.setMemo(SalesPOBeanUpdate.getEmemo());
			SalesPOBeanUpdate.setCustomerId(SalesPOBeanUpdate.getEcustomerId());
			SalesPOBeanUpdate.setCurrencyId(SalesPOBeanUpdate.getEcurrencyId());
			SalesPOBeanUpdate.setPaymentTermId(SalesPOBeanUpdate
					.getEpaymentTermId());
			SalesPOBeanUpdate.setStatusId(SalesPOBeanUpdate.getEstatusId());
			SalesPOBeanUpdate.setDueDate(dateService.dateFormat(dateService
					.dateParse(SalesPOBeanUpdate.getEdueDate(), "au"), "au"));
			SalesPOBeanUpdate.setFrieghtCharges(SalesPOBeanUpdate
					.getEfrieghtCharges());
			SalesPOBeanUpdate.setExiciseAmount(SalesPOBeanUpdate
					.getEexiciseAmount());
			SalesPOBeanUpdate.setPnFCharges(SalesPOBeanUpdate.getePnFCharges());
			SalesPOBeanUpdate.setSalesTaxAmount(SalesPOBeanUpdate
					.getEsalesTaxAmount());
			SalesPOBeanUpdate.setVATAmount(SalesPOBeanUpdate.geteVATAmount());
			SalesPOBeanUpdate.setCreatedBy(SalesPOBeanUpdate.getEcreatedBy());
			SalesPOBeanUpdate.setCreatedDTTM(SalesPOBeanUpdate
					.getEcreatedDTTM());
			session = request.getSession(false);
			SalesPOBeanUpdate.setModifiedBy((String) session
					.getAttribute("userId"));
			SalesPOBeanUpdate.setModifiedDTTM(new Date());
			if (SalesPOBeanUpdate.getEsalesQuotationId().equals("0")) {
				SalesPOBeanUpdate.setSalesQuotationId(null);
			} else {
				SalesPOBeanUpdate.setSalesQuotationId(SalesPOBeanUpdate
						.getEsalesQuotationId());
			}

			int sLineId[] = SalesPOBeanUpdate.getEsalesPOLineId();
			String matid[] = SalesPOBeanUpdate.getEmaterialId();
			String qty[] = SalesPOBeanUpdate.getEquantity();
			String uomId[] = SalesPOBeanUpdate.geteUOMId();
			String curid[] = SalesPOBeanUpdate.getEcurId();
			String unitPrice[] = SalesPOBeanUpdate.getEunitPrice();
			String lineAmt[] = SalesPOBeanUpdate.getElineAmount();
			String dueDate[] = SalesPOBeanUpdate.getEdueDateChild();
			String childDelete = "", ss = "1";
			int id = 0;
			if (matid != null) {
				for (int n = 0; n < matid.length; n++) {
					int cbId = sLineId[n];
					if (cbId == 0 && curid.length != 0) {
						SalesPOLineBean sib = new SalesPOLineBean();
						sib.setMaterialId(matid[n]);
						sib.setQuantity(qty[n]);
						sib.setUOMId(uomId[n]);
						sib.setCurId(curid[n]);
						sib.setUnitPrice(unitPrice[n]);
						sib.setLineAmount(lineAmt[n]);
						if (dueDate != null) {
							sib.setDueDateChild(dateService.dateFormat(
									dateService.dateParse(dueDate[n], "au"),
									"au"));
						} else {
							sib.setDueDateChild(dateService.dateFormat(
									new Date(), "au"));
						}

						SPOLineUpList.add(sib);

					} else {
						SalesPOLineBean sib = new SalesPOLineBean();
						sib.setMaterialId(matid[n]);
						sib.setQuantity(qty[n]);
						sib.setUOMId(uomId[n]);
						sib.setCurId(curid[n]);
						sib.setUnitPrice(unitPrice[n]);
						sib.setLineAmount(lineAmt[n]);
						sib.setDueDateChild(dateService.dateFormat(
								dateService.dateParse(dueDate[n], "au"), "au"));
						id = sLineId[n];
						childDelete = request.getParameter("Check" + id);

						if (ss.equals(childDelete)) {

							msg = salesPOService.deleteSalesPOLine(id);

						} else {
							SPOLineUpList.add(sib);
						}
					}

				}
			}

			SalesPOBeanUpdate.setSalesPOLine(SPOLineUpList);
			msg = salesPOService.updateSalesPO(SalesPOBeanUpdate);
			if (msg == "Updated") {
				salesUpdate = "Sales Purchase Order Data Updated Successfully";

			} else {
				salesUpdate = "Sales Purchase Order Data Updation Failed";
				return "redirect:salesPOHome.mnt?UpdateSPOFail=" + salesUpdate
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:salesPOHome.mnt?UpdateSPOFail=" + salesUpdate + "";
		}

		return "redirect:salesPOHome.mnt?UpdateSPOsus=" + salesUpdate + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "salesPOId";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/SPOAdvanceSearch", method = RequestMethod.GET)
	public String spoAdvanceSearch(
			@ModelAttribute("salesPOCmd") SalesPurchaseOrderBean st,
			HttpServletRequest request, HttpServletResponse response) {
		List<Object[]> objArray = null;
		List<SalesPurchaseOrderBean> stList = new ArrayList<SalesPurchaseOrderBean>();
		List<SalesPurchaseOrderBean> refList = new ArrayList<SalesPurchaseOrderBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("salesPOId");

			for (Object[] object : objArray) {
				SalesPurchaseOrderBean s = new SalesPurchaseOrderBean();
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
		return "salesPOHome";
	}

	@RequestMapping(value = "/SPOAdvanceSearchOperations", method = RequestMethod.GET)
	public String spoAdvanceSearchOperations(
			@ModelAttribute("salesPOCmd") SalesPurchaseOrderBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<SalesPurchaseOrderBean> SPOList = new ArrayList<SalesPurchaseOrderBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = salesPOService.advSearchSalesPO(columns, operations,
					advanceSearchText);
		} else {
			objectsArray = salesPOService.searchSalesPO();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			SalesPurchaseOrderBean spob = new SalesPurchaseOrderBean();
			spob.setSalesPOId((Integer) objects[0]);
			spob.setSalesPONbr((String) objects[1]);
			spob.setSalesPOValue((String) objects[2]);
			spob.setSalesPODate(dateService.dateFormat(
					dateService.dateParse((String) objects[3], "se"), "se"));
			spob.setDescription((String) objects[4]);
			spob.setMemo((String) objects[5]);
			spob.setSalesTaxAmount((String) objects[6]);
			spob.setVATAmount((String) objects[7]);
			spob.setExiciseAmount((String) objects[8]);
			spob.setFrieghtCharges((String) objects[9]);
			spob.setPnFCharges((String) objects[10]);
			spob.setDueDate(dateService.dateFormat(
					dateService.dateParse((String) objects[11], "se"), "se"));
			CustomerBean cBean = ((CustomerBean) objects[14]);
			spob.setCustomerId(cBean.getCustomerName());
			PaymentTerms pt = ((PaymentTerms) objects[15]);
			spob.setPaymentTermId(pt.getPaymentTermName());
			Status st = ((Status) objects[16]);
			spob.setStatusId(st.getStatus());
			Currency cr = ((Currency) objects[17]);
			spob.setCurrencyId(cr.getCurrency());

			SPOList.add(spob);
		}
		request.setAttribute("SPOList", SPOList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("salesPOCmd", new SalesPurchaseOrderBean());
		return "salesPOHome";
	}
}
