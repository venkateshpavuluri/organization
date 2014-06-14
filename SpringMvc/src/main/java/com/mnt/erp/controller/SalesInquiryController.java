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

import com.mnt.erp.bean.CustomerBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.SalesGroup;
import com.mnt.erp.bean.SalesInquiryBean;
import com.mnt.erp.bean.SalesInquiryLineBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.SalesInquiryService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 08-11-2013
 */
@Controller
public class SalesInquiryController {
	private static final Logger logger = Logger
			.getLogger(SalesInquiryController.class);
	@Autowired
	SalesInquiryService salesInquiryService;
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
	String message = "";

	@RequestMapping(value = "/salesInquiryHome", method = RequestMethod.GET)
	public ModelAndView salesInquiryHome(
			@ModelAttribute("salesInquiryCmd") SalesInquiryBean salesInquiryBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		// logger.info("In SalesInquiry");
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("salesInquiryHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("salesInquiryHome", "salesInquiryCmd",
				salesInquiryBean);

	}

	@ModelAttribute("custSelect")
	public Map<Integer, String> custSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = salesInquiryService.selectCustomerIds();
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
			list = salesInquiryService.selectSalesGroupIds();
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
			list = salesInquiryService.populateUOMIds();
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
			list = salesInquiryService.populateMaterialIds();
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

	@RequestMapping(value = "/checkSalesAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkSalesAddDuplicate(HttpServletRequest request,
			HttpServletResponse response, SalesInquiryBean dupBean) {
		response.setCharacterEncoding("UTF-8");
		String salesNo = request.getParameter("salesInquiryNo");
		Long checkCustName = salesInquiryService.checkSalesInquiry(salesNo);
		if (checkCustName != 0) {
			dupBean.setSiId(1);
			message = "Warning ! Sales Inquiry No is Already exists. Please try some other name";
		} else {
			message = "";
		}

		return message;
	}

	@RequestMapping(value = "/salesInquiryAdd", method = RequestMethod.POST)
	public String saveSalesInquiry(
			@ModelAttribute("salesInquiryCmd") SalesInquiryBean saveSalesBean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status) {
		response.setCharacterEncoding("UTF-8");
		String salesInquirySave = null;
		List<SalesInquiryLineBean> salesInquiryLine = new ArrayList<SalesInquiryLineBean>();

		String materialId[] = saveSalesBean.getMaterialId();
		String qty[] = saveSalesBean.getQuantity();
		String uomId[] = saveSalesBean.getUOMId();
		String reqDate[] = saveSalesBean.getRequiredDate();
		SalesInquiryBean siBean = (SalesInquiryBean) saveSalesBean;
		try {
			if (materialId != null) {

				for (int n = 0; n < materialId.length; n++) {
					SalesInquiryLineBean siLine = new SalesInquiryLineBean();
					siLine.setMaterialId(materialId[n]);
					siLine.setQuantity(qty[n]);
					siLine.setUOMId(uomId[n]);
					siLine.setRequiredDate(dateService.dateFormat(
							dateService.dateParse(reqDate[n], "au"), "au"));
					salesInquiryLine.add(siLine);
				}

				siBean.setSalesEnquiryLine(salesInquiryLine);

			}

			siBean.setRequestedDate(dateService.dateFormat(
					dateService.dateParse(siBean.getRequestedDate(), "au"),
					"au"));
			siBean.setRequiredDeliveryDate(dateService.dateFormat(dateService
					.dateParse(siBean.getRequiredDeliveryDate(), "au"), "au"));
			siBean.setValidFrom(dateService.dateFormat(
					dateService.dateParse(siBean.getValidFrom(), "au"), "au"));
			siBean.setValidTo(dateService.dateFormat(
					dateService.dateParse(siBean.getValidTo(), "au"), "au"));

			String msg = salesInquiryService.saveSalesInquiry(siBean);
			if (msg == "S") {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Sales Inquiry", "ROW", String
						.valueOf(siBean.getSalesInquiryId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				salesInquirySave = "Sales Inquiry Data Saved Successfully";
			} else {
				return "redirect:salesInquiryHome.mnt?addSEFail="
						+ salesInquirySave + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			salesInquirySave = "Sales Inquiry Data Insertion Failures";
			return "redirect:salesInquiryHome.mnt?addSEFail="
					+ salesInquirySave + "";

		}
		return "redirect:salesInquiryHome.mnt?addSESus=" + salesInquirySave
				+ "";
	}

	@RequestMapping(value = "/checkSalesUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkSalesUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response, SalesInquiryBean dupBean) {
		response.setCharacterEncoding("UTF-8");
		String salesNo = request.getParameter("esalesInquiryNo");
		int siId = Integer.parseInt(request.getParameter("siId"));
		int checkCustName = salesInquiryService.updateCheckSalesInquiry(
				salesNo, siId);
		if (checkCustName != 0) {
			dupBean.setEditsiId(1);
			message = "Warning ! Sales Inquiry No is Already exists. Please try some other name";
		} else {
			message = null;
		}

		return message;
	}

	@RequestMapping(value = "/salesInquirySearch", method = RequestMethod.GET)
	public String searchSalesInquiry(
			@ModelAttribute("salesInquiryCmd") SalesInquiryBean SalesInquiryBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<SalesInquiryBean> SEList = new ArrayList<SalesInquiryBean>();
		try {

			String dbField = SalesInquiryBeanSearch.getXmlLabel();
			String operation = SalesInquiryBeanSearch.getOperations();
			String basicSearchId = SalesInquiryBeanSearch.getBasicSearchId();

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
				list = salesInquiryService.searchSalesInquiry();

			} else {

				list = salesInquiryService.basicSearchSalesInquiry(dbField,
						operation, basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				SalesInquiryBean sib = new SalesInquiryBean();
				sib.setSalesInquiryId((Integer) objects[0]);
				sib.setSalesInquiryNo((String) objects[1]);
				sib.setRequestedDate(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));
				sib.setValidFrom(dateService.dateFormat(
						dateService.dateParse((String) objects[3], "se"), "se"));
				sib.setValidTo(dateService.dateFormat(
						dateService.dateParse((String) objects[4], "se"), "se"));
				sib.setRequiredDeliveryDate(dateService.dateFormat(
						dateService.dateParse((String) objects[5], "se"), "se"));
				sib.setDescription((String) objects[6]);
				sib.setStatusId((String) objects[7]);
				CustomerBean cBean = ((CustomerBean) objects[8]);
				sib.setCustomerId(cBean.getCustomerName());

				SalesGroup sGroup = ((SalesGroup) objects[9]);
				sib.setSalesGroupId(sGroup.getSalesGroup());
				SEList.add(sib);
			}
			request.setAttribute("SEList", SEList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salesInquiryHome";

	}

	@RequestMapping(value = "/salesInquiryDelete", method = RequestMethod.GET)
	public String salesInquiryDelete(
			@ModelAttribute("salesInquiryCmd") SalesInquiryBean SalesInquiryBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		String siDelete = null;
		int cId = Integer.parseInt(request.getParameter("salesInquiryId"));

		try {
			String msg = salesInquiryService.deleteSalesInquiry(cId);

			if (msg.equals("Deleted")) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Sales Inquiry", "ROW", String
						.valueOf(cId), "1", modifiedDate,
						session.getAttribute("userName").toString());
				siDelete = "Sales Inquiry Data Deleted Successfully";

			} else {
				siDelete = "Sales Inquiry Deletion Failed due to Conatraint Violation";
				return "redirect:salesInquiryHome.mnt?DeleteSEFail=" + siDelete
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:salesInquiryHome.mnt?DeleteSEsus=" + siDelete + "";

	}

	@RequestMapping(value = "/SalesInquiryEdit", method = RequestMethod.GET)
	public String salesInquiryEdit(
			@ModelAttribute("salesInquiryCmd") SalesInquiryBean salesInquiryBeanEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<SalesInquiryBean> salesEditList = new ArrayList<SalesInquiryBean>();
		List<SalesInquiryLineBean> salesLineEditList = new ArrayList<SalesInquiryLineBean>();
		List<Integer> mlist = new ArrayList<Integer>();
		int salesId = salesInquiryBeanEdit.getSalesInquiryId();
		try {

			List<Object> l = salesInquiryService
					.searchSalesInquiryWithId(salesId);
			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				SalesInquiryBean ccb = (SalesInquiryBean) oo;
				salesInquiryBeanEdit
						.setEsalesInquiryId(ccb.getSalesInquiryId());
				salesInquiryBeanEdit
						.setEsalesInquiryNo(ccb.getSalesInquiryNo());
				salesInquiryBeanEdit.setEcustomerId(ccb.getCustomerId());
				salesInquiryBeanEdit.setErequestedDate(dateService.dateFormat(
						dateService.dateParse(ccb.getRequestedDate(), "se"),
						"se"));
				salesInquiryBeanEdit.setErequiredDeliveryDate(dateService
						.dateFormat(
								dateService.dateParse(
										ccb.getRequiredDeliveryDate(), "se"),
								"se"));
				salesInquiryBeanEdit.setEvalidFrom(dateService.dateFormat(
						dateService.dateParse(ccb.getValidFrom(), "se"), "se"));
				salesInquiryBeanEdit.setEvalidTo(dateService.dateFormat(
						dateService.dateParse(ccb.getValidTo(), "se"), "se"));
				salesInquiryBeanEdit.setEsalesGroupId(ccb.getSalesGroupId());
				salesInquiryBeanEdit.setEdescription(ccb.getDescription());
				salesInquiryBeanEdit.setEstatusId(ccb.getStatusId());
				List<SalesInquiryLineBean> listEdit = ccb.getSalesEnquiryLine();

				Iterator<SalesInquiryLineBean> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					SalesInquiryLineBean cc = (SalesInquiryLineBean) o;
					SalesInquiryLineBean sMultiple = new SalesInquiryLineBean();
					sMultiple
							.setEsalesInquiryLineId(cc.getSalesInquiryLineId());
					sMultiple.setEsalesInquiryId(cc.getSalesInquiryId());
					Material mt = cc.getMaterial();
					mlist.add(mt.getMaterial_Id());
					sMultiple.setEmaterialName(mt.getMaterialName());
					sMultiple.setEmaterialId(cc.getMaterialId());
					sMultiple.setEquantity(cc.getQuantity());
					sMultiple.setErequiredDate(dateService.dateFormat(
							dateService.dateParse(cc.getRequiredDate(), "se"),
							"se"));
					Uom uom = cc.getUom();
					sMultiple.seteUomName(uom.getUom());
					sMultiple.seteUOMId(cc.getUOMId());
					salesLineEditList.add(sMultiple);

				}

				salesInquiryBeanEdit.setSalesEnquiryLine(salesLineEditList);
				salesEditList.add(salesInquiryBeanEdit);
			}
			request.setAttribute("mList", mlist);
			request.setAttribute("salesEditList", salesEditList);
			request.setAttribute("salesLineEditList", salesLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "salesInquiryHome";
	}

	@RequestMapping(value = "/salesInquiryUpdate", method = RequestMethod.POST)
	public String salesInquiryUpdate(
			@ModelAttribute("salesInquiryCmd") SalesInquiryBean SalesInquiryBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<SalesInquiryLineBean> SELineUpList = new ArrayList<SalesInquiryLineBean>();
		String msg = null;
		String salesUpdate = null;
		try {
			SalesInquiryBeanUpdate.setSalesInquiryId(SalesInquiryBeanUpdate
					.getEsalesInquiryId());
			SalesInquiryBeanUpdate.setSalesInquiryNo(SalesInquiryBeanUpdate
					.getEsalesInquiryNo());
			SalesInquiryBeanUpdate.setCustomerId(SalesInquiryBeanUpdate
					.getEcustomerId());
			SalesInquiryBeanUpdate.setSalesGroupId(SalesInquiryBeanUpdate
					.getEsalesGroupId());
			SalesInquiryBeanUpdate.setDescription(SalesInquiryBeanUpdate
					.getEdescription());
			SalesInquiryBeanUpdate
					.setValidFrom(dateService.dateFormat(dateService.dateParse(
							SalesInquiryBeanUpdate.getEvalidFrom(), "au"), "au"));
			SalesInquiryBeanUpdate.setValidTo(dateService.dateFormat(
					dateService.dateParse(SalesInquiryBeanUpdate.getEvalidTo(),
							"au"), "au"));
			SalesInquiryBeanUpdate.setRequestedDate(dateService.dateFormat(
					dateService.dateParse(
							SalesInquiryBeanUpdate.getErequestedDate(), "au"),
					"au"));

			SalesInquiryBeanUpdate.setRequiredDeliveryDate(dateService
					.dateFormat(dateService.dateParse(
							SalesInquiryBeanUpdate.getErequiredDeliveryDate(),
							"au"), "au"));
			SalesInquiryBeanUpdate.setStatusId(SalesInquiryBeanUpdate
					.getEstatusId());

			int sLineId[] = SalesInquiryBeanUpdate.getEsalesInquiryLineId();
			String matid[] = SalesInquiryBeanUpdate.getEmaterialId();
			String qty[] = SalesInquiryBeanUpdate.getEquantity();
			String uomId[] = SalesInquiryBeanUpdate.geteUOMId();
			String reqDate[] = SalesInquiryBeanUpdate.getErequiredDate();
			String childDelete = "", ss = "1";
			int id = 0;

			if (matid != null) {

				for (int n = 0; n < matid.length; n++) {
					int cbId = sLineId[n];
					if (cbId == 0) {

						SalesInquiryLineBean sib = new SalesInquiryLineBean();
						sib.setMaterialId(matid[n]);
						sib.setQuantity(qty[n]);
						sib.setUOMId(uomId[n]);
						sib.setRequiredDate(dateService.dateFormat(
								dateService.dateParse(reqDate[n], "au"), "au"));
						SELineUpList.add(sib);

					} else {

						SalesInquiryLineBean sib = new SalesInquiryLineBean();
						sib.setMaterialId(matid[n]);
						sib.setQuantity(qty[n]);
						sib.setUOMId(uomId[n]);
						sib.setRequiredDate(dateService.dateFormat(
								dateService.dateParse(reqDate[n], "au"), "au"));
						id = sLineId[n];
						childDelete = request.getParameter("Check" + id);
						if (ss.equals(childDelete)) {

							msg = salesInquiryService.deleteSalesLine(id);

						} else {
							SELineUpList.add(sib);
						}
					}

				}
			}

			SalesInquiryBeanUpdate.setSalesEnquiryLine(SELineUpList);
			msg = salesInquiryService
					.updateSalesInquiry(SalesInquiryBeanUpdate);

			if (msg == "Updated") {
				salesUpdate = "Sales Inquiry Data Updated Successfully";

			}

			else {
				salesUpdate = "Sales Inquiry Data Updation Failed";
				return "redirect:salesInquiryHome.mnt?UpdateSEFail="
						+ salesUpdate + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:salesInquiryHome.mnt?UpdateSEsus=" + salesUpdate + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "salesInquiryId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/SIAdvanceSearch", method = RequestMethod.GET)
	public String siAdvanceSearch(
			@ModelAttribute("salesInquiryCmd") SalesInquiryBean st,
			HttpServletRequest request, HttpServletResponse response) {
		List<Object[]> objArray = null;
		List<SalesInquiryBean> stList = new ArrayList<SalesInquiryBean>();
		List<SalesInquiryBean> refList = new ArrayList<SalesInquiryBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("salesInquiryId");

			for (Object[] object : objArray) {
				SalesInquiryBean s = new SalesInquiryBean();
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
		return "salesInquiryHome";
	}

	@RequestMapping(value = "/SIAdvanceSearchOperations", method = RequestMethod.GET)
	public String seAdvanceSearchOperations(
			@ModelAttribute("salesInquiryCmd") SalesInquiryBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<SalesInquiryBean> SEList = new ArrayList<SalesInquiryBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = salesInquiryService.advSearchSalesInquiry(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = salesInquiryService.searchSalesInquiry();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			SalesInquiryBean sib = new SalesInquiryBean();
			sib.setSalesInquiryId((Integer) objects[0]);
			sib.setSalesInquiryNo((String) objects[1]);
			sib.setRequestedDate(dateService.dateFormat(
					dateService.dateParse((String) objects[2], "se"), "se"));
			sib.setValidFrom(dateService.dateFormat(
					dateService.dateParse((String) objects[3], "se"), "se"));
			sib.setValidTo(dateService.dateFormat(
					dateService.dateParse((String) objects[4], "se"), "se"));
			sib.setRequiredDeliveryDate(dateService.dateFormat(
					dateService.dateParse((String) objects[5], "se"), "se"));
			sib.setDescription((String) objects[6]);
			sib.setStatusId((String) objects[7]);
			CustomerBean cBean = ((CustomerBean) objects[8]);
			sib.setCustomerId(cBean.getCustomerName());

			SalesGroup sGroup = ((SalesGroup) objects[9]);
			sib.setSalesGroupId(sGroup.getSalesGroup());
			SEList.add(sib);
		}
		request.setAttribute("SEList", SEList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("salesInquiryCmd", new SalesInquiryBean());
		return "salesInquiryHome";
	}
}
