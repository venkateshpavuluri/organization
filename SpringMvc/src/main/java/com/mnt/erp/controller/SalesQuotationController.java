/**
 *@Copyright MNTSOFT 
 */
package com.mnt.erp.controller;

import java.io.IOException;
import java.text.ParseException;
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
import com.mnt.erp.bean.SalesInquiryBean;
import com.mnt.erp.bean.SalesInquiryLineBean;
import com.mnt.erp.bean.SalesQuotationBean;
import com.mnt.erp.bean.SalesQuotationLineBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.SalesQuotationService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 15-11-2013
 */
@Controller
public class SalesQuotationController {
	private static final Logger log = Logger
			.getLogger(SalesQuotationController.class);

	@Autowired
	SalesQuotationService salesQuotationService;
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

	@RequestMapping(value = "/salesQuotationHome", method = RequestMethod.GET)
	public ModelAndView salesQuotationHome(
			@ModelAttribute("salesQuotationCmd") SalesQuotationBean salesQuotationBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("salesQuotationHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("salesQuotationHome", "salesQuotationCmd",
				salesQuotationBean);

	}

	@ModelAttribute("custSelect")
	public Map<Integer, String> custSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesQuotationService.selectCustomerIds();
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

	@ModelAttribute("salesInquirySelect")
	public Map<Integer, String> salesInquirySelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesQuotationService.selectSalesInquiryIds();
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
			list = salesQuotationService.populateCurrencyIds();
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
			list = salesQuotationService.populateMaterialIds();
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
			list = salesQuotationService.populateUOMIds();
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

	@RequestMapping(value = "/salesInquiryDetails", method = RequestMethod.POST)
	public @ResponseBody
	String getsalesInquiryDetails(
			@RequestParam(value = "salesInquiryId", required = true) int salesInquiryId,
			HttpServletResponse response, HttpServletRequest request) {
		List<Object> list = null;
		String jsondataChild = "";
		int count = 1;
		try {
			list = salesQuotationService.editSalesInquiryWithId(salesInquiryId);
			Iterator<Object> iterator = list.iterator();
			if (iterator.hasNext()) {
				Object salesObj = iterator.next();
				SalesInquiryBean sales = (SalesInquiryBean) salesObj;
				List<SalesInquiryLineBean> listEdit = sales
						.getSalesEnquiryLine();
				List<SalesInquiryLineBean> listJson = new ArrayList<SalesInquiryLineBean>();
				Iterator<SalesInquiryLineBean> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object siLineObj = iter.next();
					SalesInquiryLineBean SILine = (SalesInquiryLineBean) siLineObj;
					Material material = (Material) SILine.getMaterial();
					Uom uom = (Uom) SILine.getUom();
					SalesInquiryLineBean sl = new SalesInquiryLineBean();
					sl.setSalesInquiryLineId(SILine.getSalesInquiryLineId());
					sl.setMaterialId(SILine.getMaterialId());
					sl.setEmaterialName(material.getMaterialName());
					sl.setUmId(SILine.getUOMId());
					sl.setUomName(uom.getUom());
					sl.setQuantity(SILine.getQuantity());
					sl.setRequiredDate(dateService.dateFormat(dateService
							.dateParse(SILine.getRequiredDate(), "se"), "se"));
					sl.setCount(count);
					listJson.add(sl);
					count++;
				}
				ObjectMapper mapper = new ObjectMapper();
				jsondataChild = mapper.writeValueAsString(listJson);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return jsondataChild;
	}

	@RequestMapping(value = "/checkSQAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkSQAddDuplicate(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "salesQuotationNo", required = true) String salesNo) {
		response.setCharacterEncoding("UTF-8");
		Long checkCustName = salesQuotationService.checkSalesQuotation(salesNo);
		if (checkCustName != 0) {
			message = "Warning ! Sales Quotation No is Already exists. Please try some other name";
		} else {
			message = null;
		}
		return message;
	}

	@RequestMapping(value = "/salesQuotationAdd", method = RequestMethod.POST)
	public String saveSalesInquiry(
			@ModelAttribute("salesQuotationCmd") SalesQuotationBean saveSalesBean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status) {
		response.setCharacterEncoding("UTF-8");
		String salesQuotationSave = null;
		Set<SalesQuotationLineBean> salesQuotationLine = new HashSet<SalesQuotationLineBean>();
		String materialId[] = saveSalesBean.getMaterialId();
		String qty[] = saveSalesBean.getQuantity();
		String uomId[] = saveSalesBean.getUOMId();
		String reqDate[] = saveSalesBean.getRequiredDate();
		String delDate[] = saveSalesBean.getDeliveryDate();
		String curId[] = saveSalesBean.getCurrencyId();
		int perUnit[] = saveSalesBean.getPerUnit();
		float netPrice[] = saveSalesBean.getNetPrice();
		float lineAmt[] = saveSalesBean.getLineAmount();
		try {
			SalesQuotationBean sqBean = (SalesQuotationBean) saveSalesBean;
			if ("0".equals(sqBean.getSalesInquiryId())) {
				sqBean.setSalesInquiryId(null);

			}
			sqBean.setSalesQuotationDate(dateService.dateFormat(
					dateService.dateParse(sqBean.getSalesQuotationDate(), "au"),
					"au"));
			if (delDate != null && curId != null && perUnit != null
					&& netPrice != null) {

				for (int n = 0; n < materialId.length; n++) {
					SalesQuotationLineBean siLine = new SalesQuotationLineBean();
					siLine.setMaterialId(materialId[n]);
					siLine.setQuantity(qty[n]);
					siLine.setUOMId(uomId[n]);
					siLine.setRequiredDate(dateService.dateFormat(
							dateService.dateParse(reqDate[n], "au"), "au"));
					siLine.setDeliveryDate(dateService.dateFormat(
							dateService.dateParse(delDate[n], "au"), "au"));
					siLine.setCurrencyId(curId[n]);
					siLine.setPerUnit(perUnit[n]);
					siLine.setNetPrice(netPrice[n]);
					siLine.setLineAmount(lineAmt[n]);
					salesQuotationLine.add(siLine);
				}

				sqBean.setSalesQuotationLineBean(salesQuotationLine);
			}

			String msg = salesQuotationService.saveSalesQuotation(sqBean);
			if (msg.equals("success")) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Sales Quotation", "ROW", String
						.valueOf(sqBean.getSalesQuotationId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				salesQuotationSave = "Sales Quotation Data Saved Successfully";
			} else {
				return "redirect:salesQuotationHome.mnt?addSQFail="
						+ salesQuotationSave + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:salesQuotationHome.mnt?addSQFail="
					+ salesQuotationSave + "";

		}
		return "redirect:salesQuotationHome.mnt?addSQSus=" + salesQuotationSave
				+ "";

	}

	@RequestMapping(value = "/checkSQUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkSQUpdateDuplicate(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "sqId", required = true) int sqId,
			@RequestParam(value = "esalesQuotationNo", required = true) String salesNo) {
		response.setCharacterEncoding("UTF-8");
		int checkCustName = salesQuotationService.updateCheckSalesQuotation(
				salesNo, sqId);

		if (checkCustName != 0) {
			message = "Warning ! Sales Quotation No is Already exists. Please try some other name";
		} else {
			message = null;
		}

		return message;
	}

	@RequestMapping(value = "/salesQuotationSearch", method = RequestMethod.GET)
	public String searchSalesQuotation(
			@ModelAttribute("salesQuotationCmd") SalesQuotationBean SalesQuotationBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<SalesQuotationBean> SQList = new ArrayList<SalesQuotationBean>();
		try {

			String dbField = SalesQuotationBeanSearch.getXmlLabel();
			String operation = SalesQuotationBeanSearch.getOperations();
			String basicSearchId = SalesQuotationBeanSearch.getBasicSearchId();

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
				list = salesQuotationService.searchSalesQuotation();

			} else {

				list = salesQuotationService.basicSearchSalesQuotation(dbField,
						operation, basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				SalesQuotationBean sib = new SalesQuotationBean();
				sib.setSalesQuotationId((Integer) objects[0]);
				sib.setSalesQuotationNo((String) objects[1]);
				sib.setSalesInquiryId((String) objects[3]);
				sib.setSalesQuotationDate(dateService.dateFormat(
						dateService.dateParse((String) objects[4], "se"), "se"));
				sib.setDescription((String) objects[5]);
				sib.setStatusId((Integer) objects[6]);
				CustomerBean cBean = ((CustomerBean) objects[7]);
				sib.setCustomerId(cBean.getCustomerName());
				/*
				 * SalesInquiryBean siBean = ((SalesInquiryBean) objects[8]);
				 * sib.setSalesInquiryId(siBean.getSalesInquiryNo());
				 */
				SQList.add(sib);
			}
			request.setAttribute("SQList", SQList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salesQuotationHome";

	}

	@RequestMapping(value = "/salesQuotationDelete", method = RequestMethod.GET)
	public String salesQuotationDelete(
			@ModelAttribute("salesQuotationCmd") SalesQuotationBean SalesQuotationBeanDelete,
			@RequestParam(value = "salesQuotationId") int cId,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String sQDelete = null;
		try {
			String msg = salesQuotationService.deleteSalesQuotation(cId);

			if (msg.equals("Deleted")) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Sales Quotation", "ROW", String
						.valueOf(cId), "1", modifiedDate,
						session.getAttribute("userName").toString());
				sQDelete = "Sales Quotation Deleted Successfully";

			} else {
				sQDelete = "Sales Quotation Deletion Failed due to Conatraint Violation";
				return "redirect:salesQuotationHome.mnt?DeleteSQFail="
						+ sQDelete + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:salesQuotationHome.mnt?DeleteSQFail=" + sQDelete
					+ "";
		}
		return "redirect:salesQuotationHome.mnt?DeleteSQsus=" + sQDelete + "";

	}

	@RequestMapping(value = "/SalesQuotationEdit", method = RequestMethod.GET)
	public String salesQuotationEdit(
			@ModelAttribute("salesQuotationCmd") SalesQuotationBean salesQuotationBeanEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<SalesQuotationBean> salesEditList = new ArrayList<SalesQuotationBean>();
		List<SalesQuotationLineBean> salesLineEditList = new ArrayList<SalesQuotationLineBean>();
		List<Integer> mlist = new ArrayList<Integer>();
		int salesId = salesQuotationBeanEdit.getSalesQuotationId();
		try {

			List<Object> l = salesQuotationService
					.searchSalesQuotationWithId(salesId);

			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				SalesQuotationBean ccb = (SalesQuotationBean) oo;
				salesQuotationBeanEdit.setEsalesQuotationId(ccb
						.getSalesQuotationId());
				salesQuotationBeanEdit.setEsalesQuotationNo(ccb
						.getSalesQuotationNo());
				salesQuotationBeanEdit.setEcustomerId(ccb.getCustomerId());
				salesQuotationBeanEdit.setEsalesQuotationDate(dateService
						.dateFormat(
								dateService.dateParse(
										ccb.getSalesQuotationDate(), "se"),
								"se"));
				salesQuotationBeanEdit.setEdescription(ccb.getDescription());
				salesQuotationBeanEdit.setEstatusId(ccb.getStatusId());
				salesQuotationBeanEdit.setEsalesInquiryId(ccb
						.getSalesInquiryId());

				Set<SalesQuotationLineBean> listEdit = ccb
						.getSalesQuotationLineBean();

				Iterator<SalesQuotationLineBean> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					SalesQuotationLineBean sq = (SalesQuotationLineBean) o;
					SalesQuotationLineBean sqMultiple = new SalesQuotationLineBean();
					sqMultiple.setEsalesQuotationLineId(sq
							.getSalesQuotationLineId());
					sqMultiple.setEmaterialId(sq.getMaterialId());
					Material mt = sq.getMaterial();
					sqMultiple.setEmaterialName(mt.getMaterialName());
					mlist.add(mt.getMaterial_Id());
					sqMultiple.seteUOMId(sq.getUOMId());
					Uom uom = sq.getUom();
					sqMultiple.setEuomName(uom.getUom());
					sqMultiple.setEcurrencyId(sq.getCurrencyId());
					Currency cr = sq.getCurrency();
					sqMultiple.setEcurrencyName(cr.getCurrency());
					sqMultiple.setEquantity(sq.getQuantity());
					sqMultiple.setErequiredDate(dateService.dateFormat(
							dateService.dateParse(sq.getRequiredDate(), "se"),
							"se"));
					sqMultiple.setEdeliveryDate(dateService.dateFormat(
							dateService.dateParse(sq.getDeliveryDate(), "se"),
							"se"));
					sqMultiple.setEperUnit(sq.getPerUnit());
					sqMultiple.setEnetPrice(sq.getNetPrice());
					sqMultiple.setElineAmount(sq.getLineAmount());
					salesLineEditList.add(sqMultiple);

				}
				salesQuotationBeanEdit.setSalesQuotationLineBean(listEdit);
				salesEditList.add(salesQuotationBeanEdit);
			}
			request.setAttribute("mList", mlist);
			request.setAttribute("salesQuotEditList", salesEditList);
			request.setAttribute("salesQuotLineEditList", salesLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salesQuotationHome";
	}

	@RequestMapping(value = "/salesQuotationUpdate", method = RequestMethod.POST)
	public String salesQuotationUpdate(
			@ModelAttribute("salesQuotationCmd") SalesQuotationBean SalesQuotationBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		Set<SalesQuotationLineBean> SQLineUpList = new HashSet<SalesQuotationLineBean>();
		String msg = null;
		String salesUpdate = null;
		try {
			SalesQuotationBeanUpdate
					.setSalesQuotationId(SalesQuotationBeanUpdate
							.getEsalesQuotationId());
			SalesQuotationBeanUpdate.setCustomerId(SalesQuotationBeanUpdate
					.getEcustomerId());
			SalesQuotationBeanUpdate.setSalesQuotationDate(dateService
					.dateFormat(dateService.dateParse(
							SalesQuotationBeanUpdate.getEsalesQuotationDate(),
							"au"), "au"));

			SalesQuotationBeanUpdate.setDescription(SalesQuotationBeanUpdate
					.getEdescription());
			SalesQuotationBeanUpdate.setStatusId(SalesQuotationBeanUpdate
					.getEstatusId());
			SalesQuotationBeanUpdate
					.setSalesQuotationNo(SalesQuotationBeanUpdate
							.getEsalesQuotationNo());

			if ("0".equals(SalesQuotationBeanUpdate.getEsalesInquiryId())) {
				SalesQuotationBeanUpdate.setSalesInquiryId(null);

			} else {
				SalesQuotationBeanUpdate
						.setSalesInquiryId(SalesQuotationBeanUpdate
								.getEsalesInquiryId());
			}

			int sLineId[] = SalesQuotationBeanUpdate.getEsalesQuotationLineId();
			String matid[] = SalesQuotationBeanUpdate.getEmaterialId();
			String qty[] = SalesQuotationBeanUpdate.getEquantity();
			String uomId[] = SalesQuotationBeanUpdate.geteUOMId();
			String reqDate[] = SalesQuotationBeanUpdate.getErequiredDate();
			String delDate[] = SalesQuotationBeanUpdate.getEdeliveryDate();
			String curid[] = SalesQuotationBeanUpdate.getEcurrencyId();
			float nPrice[] = SalesQuotationBeanUpdate.getEnetPrice();
			int pUnit[] = SalesQuotationBeanUpdate.getEperUnit();
			float lineAmt[] = SalesQuotationBeanUpdate.getElineAmount();
			String childDelete = "", ss = "1";
			int id = 0;

			if (matid != null) {

				for (int n = 0; n < matid.length; n++) {
					int cbId = sLineId[n];
					if (cbId == 0 && curid.length != 0) {

						SalesQuotationLineBean sib = new SalesQuotationLineBean();
						sib.setMaterialId(matid[n]);
						sib.setQuantity(qty[n]);
						sib.setUOMId(uomId[n]);
						sib.setRequiredDate(dateService.dateFormat(
								dateService.dateParse(reqDate[n], "au"), "au"));
						sib.setDeliveryDate(dateService.dateFormat(
								dateService.dateParse(delDate[n], "au"), "au"));
						sib.setCurrencyId(curid[n]);
						sib.setNetPrice(nPrice[n]);
						sib.setPerUnit(pUnit[n]);
						sib.setLineAmount(lineAmt[n]);
						SQLineUpList.add(sib);

					} else {

						SalesQuotationLineBean sib = new SalesQuotationLineBean();
						sib.setMaterialId(matid[n]);
						sib.setQuantity(qty[n]);
						sib.setUOMId(uomId[n]);
						sib.setRequiredDate(dateService.dateFormat(
								dateService.dateParse(reqDate[n], "au"), "au"));
						sib.setDeliveryDate(dateService.dateFormat(
								dateService.dateParse(delDate[n], "au"), "au"));
						sib.setCurrencyId(curid[n]);
						sib.setNetPrice(nPrice[n]);
						sib.setPerUnit(pUnit[n]);
						sib.setLineAmount(lineAmt[n]);

						id = sLineId[n];
						childDelete = request.getParameter("Check" + id);

						if (ss.equals(childDelete)) {

							msg = salesQuotationService.deleteSalesQuotLine(id);
						} else {
							SQLineUpList.add(sib);
						}
					}

				}
			}

			SalesQuotationBeanUpdate.setSalesQuotationLineBean(SQLineUpList);
			msg = salesQuotationService
					.updateSalesQuotation(SalesQuotationBeanUpdate);

			if (msg == "Updated") {
				salesUpdate = "Sales Quotation Data Updated Successfully";

			} else {
				salesUpdate = "Sales Quotation Data Updation Failed";
				return "redirect:salesQuotationHome.mnt?UpdateSQFail="
						+ salesUpdate + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:salesQuotationHome.mnt?UpdateSQFail="
					+ salesUpdate + "";
		}

		return "redirect:salesQuotationHome.mnt?UpdateSQsus=" + salesUpdate
				+ "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "salesQuotationId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/SQAdvanceSearch", method = RequestMethod.GET)
	public String sqAdvanceSearch(
			@ModelAttribute("salesQuotationCmd") SalesQuotationBean st,
			HttpServletRequest request, HttpServletResponse response) {
		List<Object[]> objArray = null;
		List<SalesQuotationBean> stList = new ArrayList<SalesQuotationBean>();
		List<SalesQuotationBean> refList = new ArrayList<SalesQuotationBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("salesQuotationId");

			for (Object[] object : objArray) {
				SalesQuotationBean s = new SalesQuotationBean();
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
		return "salesQuotationHome";
	}

	@RequestMapping(value = "/SQAdvanceSearchOperations", method = RequestMethod.GET)
	public String sqAdvanceSearchOperations(
			@ModelAttribute("salesQuotationCmd") SalesQuotationBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<SalesQuotationBean> SQList = new ArrayList<SalesQuotationBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = salesQuotationService.advSearchSalesQuotation(
					columns, operations, advanceSearchText);
		} else {
			objectsArray = salesQuotationService.searchSalesQuotation();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			SalesQuotationBean sib = new SalesQuotationBean();
			sib.setSalesQuotationId((Integer) objects[0]);
			sib.setSalesQuotationNo((String) objects[1]);
			sib.setSalesInquiryId((String) objects[3]);
			sib.setSalesQuotationDate(dateService.dateFormat(
					dateService.dateParse((String) objects[4], "se"), "se"));
			sib.setDescription((String) objects[5]);
			sib.setStatusId((Integer) objects[6]);
			CustomerBean cBean = ((CustomerBean) objects[7]);
			sib.setCustomerId(cBean.getCustomerName());
			/*
			 * SalesInquiryBean siBean = ((SalesInquiryBean) objects[8]);
			 * sib.setSalesInquiryId(siBean.getSalesInquiryNo());
			 */
			SQList.add(sib);
		}
		request.setAttribute("SQList", SQList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("salesQuotationCmd", new SalesQuotationBean());
		return "salesQuotationHome";
	}
}