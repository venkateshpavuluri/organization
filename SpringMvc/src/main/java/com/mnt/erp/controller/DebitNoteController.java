/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.controller;

import java.io.IOException;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.bean.DebitNoteBean;
import com.mnt.erp.bean.DebitNoteDetail;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.VendorInvoice;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.DebitNoteService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 02-01-2014
 */
@Controller
public class DebitNoteController {
	private static final Logger log = Logger
			.getLogger(DebitNoteController.class);
	@Autowired
	DebitNoteService debitNoteService;

	@Autowired
	XmlLabelsService xmlService;

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
	String message = null;
	boolean flag = true;

	@RequestMapping(value = "/debitNoteHome", method = RequestMethod.GET)
	public ModelAndView debitNoteHome(
			@ModelAttribute("debitNoteCmd") DebitNoteBean debitNoteBean,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("debitNoteHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("debitNoteHome", "debitNoteCmd", debitNoteBean);

	}

	@ModelAttribute("materialSelect")
	public Map<Integer, String> populatMaterialIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.material_Id,m.materialName from Material m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("uomSelect")
	public Map<Integer, String> populatUomIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.uom_Id,m.uom from Uom m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("custInvoiceSelect")
	public Map<Integer, String> populatCustInvoiceIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.customerinvoiceid,m.customerinvoiceno from CustomerInvoice m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("vendorInvoiceSelect")
	public Map<Integer, String> populatVendorInvoiceIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.vendorinvoiceid,m.vendorinvoiceno from VendorInvoice m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/checkDNAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkDNAddDuplicate(HttpServletRequest request,
			HttpServletResponse response, DebitNoteBean sqdupBean) {
		response.setCharacterEncoding("UTF-8");
		String debNo = request.getParameter("debitNoteNo");
		Long checkCustName = debitNoteService.checkDebitNote(debNo);
		if (checkCustName != 0) {

			message = "Warning ! Debit Note No is Already exists. Please try some other name";
		} else {
			message = "";
		}
		return message;
	}

	@RequestMapping(value = "/checkDNUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkDNUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response, DebitNoteBean dupBean) {
		response.setCharacterEncoding("UTF-8");
		String message = null;
		String debNo = request.getParameter("edebitNoteNo");
		int dnId = Integer.parseInt(request.getParameter("dnId"));
		int checkCustName = debitNoteService.updateCheckDebitNote(debNo, dnId);

		if (checkCustName != 0) {

			message = "Warning ! Debit Note No is Already exists. Please try some other name";
		} else {
			message = "";
		}

		return message;
	}

	@RequestMapping(value = "/debitNoteAdd", method = RequestMethod.POST)
	public String saveDebitNote(
			@ModelAttribute("debitNoteCmd") DebitNoteBean debitNoteBean,
			HttpServletRequest request, HttpServletResponse response) {
		String debitNoteSave = null;
		response.setCharacterEncoding("UTF-8");
		List<DebitNoteDetail> debitNoteDetail = new ArrayList<DebitNoteDetail>();

		String materialId[] = debitNoteBean.getMaterialId();
		String qty[] = debitNoteBean.getQuantity();
		String uomId[] = debitNoteBean.getUomId();
		String perUnit[] = debitNoteBean.getPerUnit();
		String netPrice[] = debitNoteBean.getNetPrice();
		String debitAmt[] = debitNoteBean.getDebitAmount();
		DebitNoteBean debitBean = (DebitNoteBean) debitNoteBean;

		if (materialId != null) {
			for (int m = 0; m < materialId.length; m++) {
				DebitNoteDetail dnd = new DebitNoteDetail();
				dnd.setMaterialId(materialId[m]);
				dnd.setQuantity(qty[m]);
				dnd.setUomId(uomId[m]);
				dnd.setPerUnit(perUnit[m]);
				dnd.setNetPrice(netPrice[m]);
				dnd.setDebitAmount(debitAmt[m]);
				debitNoteDetail.add(dnd);
			}
		}
		try {
			debitNoteBean
					.setDebitNoteDT(dateService.dateFormat(
							dateService.dateParse(
									debitNoteBean.getDebitNoteDT(), "au"), "au"));
			debitBean.setDebitNoteDetail(debitNoteDetail);
			flag = debitNoteService.saveDebitNote(debitBean);

			if (flag == true) {
				debitNoteSave = "Debit Note Data Saved Successfully";
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Debit Note", "ROW", String
						.valueOf(debitBean.getDebitNoteId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());

			} else {
				debitNoteSave = "Debit Note Data Insertion Failures";
				return "redirect:debitNoteHome.mnt?addDNFail=" + debitNoteSave
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:debitNoteHome.mnt?addDNsus=" + debitNoteSave + "";

	}

	@RequestMapping(value = "/debitNoteSearch", method = RequestMethod.GET)
	public String searchDebitNote(
			@ModelAttribute("debitNoteCmd") DebitNoteBean debitNoteBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<DebitNoteBean> DNList = new ArrayList<DebitNoteBean>();
		try {

			String dbField = debitNoteBeanSearch.getXmlLabel();
			String operation = debitNoteBeanSearch.getOperations();
			String basicSearchId = debitNoteBeanSearch.getBasicSearchId();

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
				list = debitNoteService.searchDebitNote();

			} else {

				list = debitNoteService.basicSearchDebitNote(dbField,
						operation, basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				DebitNoteBean dnb = new DebitNoteBean();
				dnb.setDebitNoteId((Integer) objects[0]);
				dnb.setDebitNoteNo((String) objects[1]);
				dnb.setDebitNoteDT(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));
				CustomerInvoice ci = ((CustomerInvoice) objects[5]);
				dnb.setCustInvoiceId(ci.getCustomerinvoiceno());
				VendorInvoice vi = ((VendorInvoice) objects[6]);
				dnb.setVendorInvoiceId(vi.getVendorinvoiceno());

				DNList.add(dnb);
			}
			request.setAttribute("DNList", DNList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "debitNoteHome";

	}

	@RequestMapping(value = "/debitNoteDelete", method = RequestMethod.GET)
	public String debitNoteDelete(
			@ModelAttribute("debitNoteCmd") DebitNoteBean debitNoteBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		String DNDelete = null;
		int dId = Integer.parseInt(request.getParameter("debitNoteId"));

		try {
			flag = debitNoteService.deleteDebitNote(dId);

			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Debit Note", "ROW", String
						.valueOf(dId), "1", modifiedDate,
						session.getAttribute("userName").toString());
				DNDelete = "Debit Note Deleted Successfully";

			} else {
				DNDelete = "Debit Note Deletion Failed due to Conatraint Violation";
				return "redirect:debitNoteHome.mnt?DeleteDNFail=" + DNDelete
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:debitNoteHome.mnt?DeleteDNsus=" + DNDelete + "";

	}

	@RequestMapping(value = "/debitNoteEdit", method = RequestMethod.GET)
	public String debitNoteEdit(
			@ModelAttribute("debitNoteCmd") DebitNoteBean debitNoteBeanEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<DebitNoteBean> dnEditList = new ArrayList<DebitNoteBean>();
		List<DebitNoteDetail> dnLineEditList = new ArrayList<DebitNoteDetail>();
		int dnId = debitNoteBeanEdit.getDebitNoteId();
		try {

			List<Object> l = debitNoteService.searchDebitNoteWithId(dnId);

			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				DebitNoteBean sob = (DebitNoteBean) oo;
				debitNoteBeanEdit.setEdebitNoteId(sob.getDebitNoteId());
				debitNoteBeanEdit.setEdebitNoteId(sob.getDebitNoteId());
				debitNoteBeanEdit.setEdebitNoteNo(sob.getDebitNoteNo());
				debitNoteBeanEdit
						.setEdebitNoteDT(dateService.dateFormat(dateService
								.dateParse(sob.getDebitNoteDT(), "se"), "se"));
				debitNoteBeanEdit.setEcustInvoiceId(sob.getCustInvoiceId());
				debitNoteBeanEdit.setEvendorInvoiceId(sob.getVendorInvoiceId());

				List<DebitNoteDetail> listEdit = sob.getDebitNoteDetail();
				Iterator<DebitNoteDetail> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					DebitNoteDetail so = (DebitNoteDetail) o;
					DebitNoteDetail soMultiple = new DebitNoteDetail();
					soMultiple.setEdebitNoteDetailId(so.getDebitNoteDetailId());
					soMultiple.setEmaterialId(so.getMaterialId());
					Material mt = so.getMaterial();
					soMultiple.setMaterialName(mt.getMaterialName());
					Uom uom = so.getUom();
					soMultiple.setUomName(uom.getUom());
					soMultiple.setEuomId(so.getUomId());
					soMultiple.setEperUnit(so.getPerUnit());
					soMultiple.setEquantity(so.getQuantity());
					soMultiple.setEnetPrice(so.getNetPrice());
					soMultiple.setEdebitAmount(so.getDebitAmount());
					dnLineEditList.add(soMultiple);

				}
				debitNoteBeanEdit.setDebitNoteDetail(dnLineEditList);
				dnEditList.add(debitNoteBeanEdit);
			}

			request.setAttribute("dNoteEditList", dnEditList);
			request.setAttribute("dNoteLineEditList", dnLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "debitNoteHome";
	}

	@RequestMapping(value = "/debitNoteUpdate", method = RequestMethod.POST)
	public String debitNoteUpdate(
			@ModelAttribute("debitNoteCmd") DebitNoteBean debitNoteBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<DebitNoteDetail> DNDUpList = new ArrayList<DebitNoteDetail>();
		String debitUpdate = null;

		debitNoteBeanUpdate.setDebitNoteId(debitNoteBeanUpdate
				.getEdebitNoteId());
		debitNoteBeanUpdate.setDebitNoteNo(debitNoteBeanUpdate
				.getEdebitNoteNo());

		debitNoteBeanUpdate.setCustInvoiceId(debitNoteBeanUpdate
				.getEcustInvoiceId());
		debitNoteBeanUpdate.setVendorInvoiceId(debitNoteBeanUpdate
				.getEvendorInvoiceId());

		int noteId[] = debitNoteBeanUpdate.getEdebitNoteDetailId();
		String matid[] = debitNoteBeanUpdate.getEmaterialId();
		String qty[] = debitNoteBeanUpdate.getEquantity();
		String uomId[] = debitNoteBeanUpdate.getEuomId();
		String perUnit[] = debitNoteBeanUpdate.getEperUnit();
		String netPrice[] = debitNoteBeanUpdate.getEnetPrice();
		String debitAmt[] = debitNoteBeanUpdate.getEdebitAmount();

		String childDelete = "", ss = "1";
		int id = 0;

		if (matid != null) {

			for (int n = 0; n < matid.length; n++) {
				int cbId = noteId[n];
				if (cbId == 0) {

					DebitNoteDetail sib = new DebitNoteDetail();
					sib.setMaterialId(matid[n]);
					sib.setQuantity(qty[n]);
					sib.setUomId(uomId[n]);
					sib.setPerUnit(perUnit[n]);
					sib.setNetPrice(netPrice[n]);
					sib.setDebitAmount(debitAmt[n]);
					DNDUpList.add(sib);

				} else {

					DebitNoteDetail sib = new DebitNoteDetail();
					sib.setMaterialId(matid[n]);
					sib.setQuantity(qty[n]);
					sib.setUomId(uomId[n]);
					sib.setPerUnit(perUnit[n]);
					sib.setNetPrice(netPrice[n]);
					sib.setDebitAmount(debitAmt[n]);
					id = noteId[n];
					childDelete = request.getParameter("Check" + id);
					if (ss.equals(childDelete)) {

						flag = debitNoteService.deleteDebitNoteLine(id);
					} else {
						DNDUpList.add(sib);
					}
				}

			}
		}

		try {
			debitNoteBeanUpdate
					.setDebitNoteDT(dateService.dateFormat(dateService
							.dateParse(debitNoteBeanUpdate.getEdebitNoteDT(),
									"au"), "au"));
			debitNoteBeanUpdate.setDebitNoteDetail(DNDUpList);
			flag = debitNoteService.updateDebitNote(debitNoteBeanUpdate);

			if (flag == true) {
				debitUpdate = "Debit Note Data Updated Successfully";

			}

			else {
				debitUpdate = "Debit Note Data Updation Failed";
				return "redirect:debitNoteHome.mnt?UpdateDNFail=" + debitUpdate
						+ "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:debitNoteHome.mnt?UpdateDNsus=" + debitUpdate + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "debitNoteId";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/debitNoteAdvanceSearch", method = RequestMethod.GET)
	public String debitNoteAdvanceSearch(
			@ModelAttribute("debitNoteCmd") DebitNoteBean st,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		List<Object[]> objArray = null;
		List<DebitNoteBean> stList = new ArrayList<DebitNoteBean>();
		List<DebitNoteBean> refList = new ArrayList<DebitNoteBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("debitNoteId");

			for (Object[] object : objArray) {
				DebitNoteBean s = new DebitNoteBean();
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
		model.addAttribute("stAdv", stList);
		model.addAttribute("refList", refList);
		return "debitNoteHome";
	}

	@RequestMapping(value = "/debitNoteAdvanceSearchOperations", method = RequestMethod.GET)
	public String debitNoteAdvanceSearchOperations(
			@ModelAttribute("debitNoteCmd") DebitNoteBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model, ModelMap map) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<DebitNoteBean> DNList = new ArrayList<DebitNoteBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = debitNoteService.advSearchDebitNote(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = debitNoteService.searchDebitNote();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			DebitNoteBean dnb = new DebitNoteBean();
			dnb.setDebitNoteId((Integer) objects[0]);
			dnb.setDebitNoteNo((String) objects[1]);
			dnb.setDebitNoteDT(dateService.dateFormat(
					dateService.dateParse((String) objects[2], "se"), "se"));
			CustomerInvoice ci = ((CustomerInvoice) objects[5]);
			dnb.setCustInvoiceId(ci.getCustomerinvoiceno());
			VendorInvoice vi = ((VendorInvoice) objects[6]);
			dnb.setVendorInvoiceId(vi.getVendorinvoiceno());

			DNList.add(dnb);
		}
		request.setAttribute("DNList", DNList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("debitNoteCmd", new DebitNoteBean());
		return "debitNoteHome";
	}

}
