/*
 * @author Srinivas

 */
package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;

import com.mnt.erp.bean.ItemCategory;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.PurchaseGroup;
import com.mnt.erp.bean.RFQLineBean;
import com.mnt.erp.bean.RFQType;
import com.mnt.erp.bean.RfqBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.RfqService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class RFQController {
	private static Logger logger = Logger.getLogger(RFQController.class);
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	String msg = null;
	String msgedit = null;
	@Autowired
	RfqService rfqservice;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	PopulateService populateService;
	@Autowired
	DateConversionService dateService;

	HttpSession session;

	@RequestMapping(value = "/rfqHome", method = RequestMethod.GET)
	public String getRfq(@ModelAttribute RfqBean rfqbean, SessionStatus status,
			Model model, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("rfqHome.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("RFQ", new RfqBean());

		return "rfqHome";
	}

	@RequestMapping(value = "/RFQDuplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkrfqname(HttpServletRequest request,
			HttpServletResponse response, RfqBean rfqbean) {

		Long pname = null;

		try {

			String before = request.getParameter("rfqno");

			pname = rfqservice.getRfqCount(before);
			if (pname != 0) {
				rfqbean.setRfqNo("");
				msg = "Warning ! RFQ No is already exists. Please try some other name";
			}
			if (pname == 0) {
				rfqbean.setRfqNo("");
				msg = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/getStorLocIds", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> getStorLocIds(HttpServletRequest request,
			HttpServletResponse response, RfqBean rfqBean) {
		response.setCharacterEncoding("UTF-8");
		int plantId = 0;
		if (request.getParameter("plantId")!= "") {
			plantId = Integer.parseInt(request.getParameter("plantId"));
		}
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.storageLocationId,s.storageLocation from StorageLocation s where s.plantId="
							+ plantId);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;

	}

	@RequestMapping(value = "/saverfq", method = RequestMethod.POST)
	public String saveRfq(@ModelAttribute("RFQ") RfqBean rfqbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<RFQLineBean> rfqbeanlist = new ArrayList<RFQLineBean>();

		try {
			rfqbean.setRfqDate(dateService.dateFormat(dateService.dateParse(rfqbean.getRfqDate(), "au"), "au"));
			rfqbean.setQuotationdeadline(dateService.dateFormat(
					dateService.dateParse(rfqbean.getQuotationdeadline(), "au"),
					"au"));
			rfqbean.setDeliveryDate(dateService.dateFormat(
					dateService.dateParse(rfqbean.getDeliveryDate(), "au"),
					"au"));
			rfqbean.setValidFrom(dateService.dateFormat(
					dateService.dateParse(rfqbean.getValidFrom(), "au"), "au"));
			rfqbean.setValidTo(dateService.dateFormat(
					dateService.dateParse(rfqbean.getValidTo(), "au"), "au"));
			String material = rfqbean.getMaterialid();
			int qtty[] = rfqbean.getQty();
			if (qtty != null) {
				List<String> mlist = Arrays.asList(material.split(","));
				Object[] materials = mlist.toArray();

				String uomid = rfqbean.getUomid();
				List<String> ulist = Arrays.asList(uomid.split(","));
				Object[] uomids = ulist.toArray();
				String deliveryd[] = rfqbean.getDeliverydate();

				for (int r = 0; r < qtty.length; r++) {

					RFQLineBean rfqlinebean = new RFQLineBean();
					rfqlinebean.setMaterialid(materials[r].toString());
					rfqlinebean.setQty(qtty[r]);
					rfqlinebean.setUomid(uomids[r].toString());
					rfqlinebean.setDeliverydate(dateService.dateFormat(
							dateService.dateParse(deliveryd[r], "au"), "au"));
					rfqbeanlist.add(rfqlinebean);

				}
				rfqbean.setRfqlinebean(rfqbeanlist);
			}

			String msg = rfqservice.saverfqservice(rfqbean);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "RFQ", "ROW", String.valueOf(rfqbean
						.getRfqid()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				return "redirect:rfqHome.mnt?list=" + "success" + "";
			} else {
				return "redirect:rfqHome.mnt?listwar=" + "fail" + "";
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			return "redirect:rfqHome.mnt?listwar=" + "fail" + "";
		}

	}

	@ModelAttribute("rfqType")
	public Map<Integer, String> populateRfqType() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = rfqservice.selectrfqTypeservice();
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

	@ModelAttribute("Itemcategory")
	public Map<Integer, String> populateItemCategoryids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = rfqservice.selectItemCategoryservice();
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

	@ModelAttribute("status")
	public Map<Integer, String> populatestatus() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = rfqservice.selectStatus();
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

	@ModelAttribute("storageLocation")
	public Map<Integer, String> populateStorageLocationids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = rfqservice.selectstorageLocationservice();
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

	@ModelAttribute("plantrfq")
	public Map<Integer, String> populatePlantids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = rfqservice.selectplantservice();
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

	@ModelAttribute("materialid")
	public Map<Integer, String> populatMaterialids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = rfqservice.selectMaterialservice();
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

	@ModelAttribute("uom")
	public Map<Integer, String> populatUomids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = rfqservice.selectUOMservice();
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

	@RequestMapping(value = "/searchrfq", method = RequestMethod.GET)
	public String searchRFQIds(@ModelAttribute("RFQ") RfqBean rfqBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<RfqBean> rfqbeans = new ArrayList<RfqBean>();
			String dbField = rfqBean.getXmlLabel();
			String operation = rfqBean.getOperations();
			String basicSearchId = rfqBean.getBasicSearchId();

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
				list = rfqservice.searchRfqservice();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					RfqBean rfqbean2 = new RfqBean();
					rfqbean2.setRfqid((Integer) obj[0]);
					RFQType rfqtb = (RFQType) obj[1];
					rfqbean2.setRfqType(rfqtb.getRfqType());
					rfqbean2.setRfqNo((String) obj[2]);
					rfqbean2.setRfqDate(dateService.dateFormat(
							dateService.dateParse((String) obj[3], "se"), "se"));
					rfqbean2.setQuotationdeadline(dateService.dateFormat(
							dateService.dateParse((String) obj[4], "se"), "se"));
					ItemCategory itemcb = (ItemCategory) obj[5];
					rfqbean2.setItemCategory(itemcb.getItemCategory());
					rfqbean2.setDeliveryDate(dateService.dateFormat(
							dateService.dateParse((String) obj[6], "se"), "se"));
					rfqbean2.setValidFrom(dateService.dateFormat(
							dateService.dateParse((String) obj[7], "se"), "se"));
					rfqbean2.setValidTo(dateService.dateFormat(
							dateService.dateParse((String) obj[8], "se"), "se"));
					StorageLocation stlcb = (StorageLocation) obj[9];
					rfqbean2.setStorageLocation(stlcb.getStorageLocation());
					Plant plb = (Plant) obj[10];
					rfqbean2.setPalntRfq(plb.getPlantName());
					rfqbean2.setRefNumber((String) obj[11]);
					PurchaseGroup pgb = (PurchaseGroup) obj[12];
					rfqbean2.setPurchaseGrouprfq(pgb.getPurchaseGroup());
					Status st = (Status) obj[13];
					rfqbean2.setStatusid(st.getStatus());
					rfqbeans.add(rfqbean2);

				}

			} else {

				list = rfqservice.basicSearchRfqservice(dbField, operation,
						basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					RfqBean rfqbean2 = new RfqBean();
					rfqbean2.setRfqid((Integer) obj[0]);
					RFQType rfqtb = (RFQType) obj[1];
					rfqbean2.setRfqType(rfqtb.getRfqType());
					rfqbean2.setRfqNo((String) obj[2]);
					rfqbean2.setRfqDate(dateService.dateFormat(
							dateService.dateParse((String) obj[3], "se"), "se"));
					rfqbean2.setQuotationdeadline(dateService.dateFormat(
							dateService.dateParse((String) obj[4], "se"), "se"));
					ItemCategory itemcb = (ItemCategory) obj[5];
					rfqbean2.setItemCategory(itemcb.getItemCategory());
					rfqbean2.setDeliveryDate(dateService.dateFormat(
							dateService.dateParse((String) obj[6], "se"), "se"));
					rfqbean2.setValidFrom(dateService.dateFormat(
							dateService.dateParse((String) obj[7], "se"), "se"));
					rfqbean2.setValidTo(dateService.dateFormat(
							dateService.dateParse((String) obj[8], "se"), "se"));
					StorageLocation stlcb = (StorageLocation) obj[9];
					rfqbean2.setStorageLocation(stlcb.getStorageLocation());
					Plant plb = (Plant) obj[10];
					rfqbean2.setPalntRfq(plb.getPlantName());
					rfqbean2.setRefNumber((String) obj[11]);
					PurchaseGroup pgb = (PurchaseGroup) obj[12];
					rfqbean2.setPurchaseGrouprfq(pgb.getPurchaseGroup());
					Status st = (Status) obj[13];
					rfqbean2.setStatusid(st.getStatus());
					rfqbeans.add(rfqbean2);
				}
			}
			request.setAttribute("rfqbeans", rfqbeans);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "rfqHome";
	}

	@RequestMapping(value = "/rfqEdit", method = RequestMethod.GET)
	public String editRfq(@ModelAttribute("RFQ") RfqBean rfqbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<RfqBean> rfqedit = new ArrayList<RfqBean>();
		List<RFQLineBean> rfqlinelist = new ArrayList<RFQLineBean>();
		// int processId = processBean.getProcessid();
		int rfqId = Integer.parseInt(request.getParameter("rfqedit"));
		try {
			List<RfqBean> list = rfqservice.EditRfqservice(rfqId);
			Iterator<RfqBean> iter = list.iterator();
			if (iter.hasNext()) {
				Object object = iter.next();
				RfqBean rfqb = (RfqBean) object;

				rfqbean.setRfqidedit(rfqb.getRfqid());
				rfqbean.setRfqTypeedit(rfqb.getRfqType());
				rfqbean.setRfqNoedit(rfqb.getRfqNo());
				rfqbean.setRfqDateedit(dateService.dateFormat(
						dateService.dateParse(rfqb.getRfqDate(), "se"), "se"));
				rfqbean.setQuotationdeadlineedit(dateService.dateFormat(
						dateService
								.dateParse(rfqb.getQuotationdeadline(), "se"),
						"se"));
				rfqbean.setItemCategoryedit(rfqb.getItemCategory());

				rfqbean.setDeliveryDateedit(dateService.dateFormat(
						dateService.dateParse(rfqb.getDeliveryDate(), "se"),
						"se"));
				rfqbean.setValidFromedit(dateService.dateFormat(
						dateService.dateParse(rfqb.getValidFrom(), "se"), "se"));

				rfqbean.setValidToedit(dateService.dateFormat(
						dateService.dateParse(rfqb.getValidTo(), "se"), "se"));
				rfqbean.setStorageLocationedit(rfqb.getStorageLocation());
				rfqbean.setPalntRfqedit(rfqb.getPalntRfq());
				rfqbean.setStatusidedit(rfqb.getStatusid());
				rfqbean.setRefNumberedit(rfqb.getRefNumber());

				rfqbean.setPurchaseGrouprfqeit(rfqb.getPurchaseGrouprfq());

				List<RFQLineBean> listEdit = rfqb.getRfqlinebean();
				Iterator<RFQLineBean> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					RFQLineBean rfedit = (RFQLineBean) object2;

					RFQLineBean rfqlineedit = new RFQLineBean();
					rfqlineedit.setRfqlineidedit(rfedit.getRfqlineid());
					Material matrfq = rfedit.getMaterialdetail();
					rfqlineedit.setMaterialidName(matrfq.getMaterialName());
					rfqlineedit.setMaterialidedit(rfedit.getMaterialid());
					rfqlineedit.setQtyedit(rfedit.getQty());
					Uom uomrfq = rfedit.getUomdetail();
					rfqlineedit.setUomidName(uomrfq.getUom());
					rfqlineedit.setUomidedit(rfedit.getUomid());
					rfqlineedit.setDeliverydateedit(dateService.dateFormat(
							dateService.dateParse(rfedit.getDeliverydate(),
									"se"), "se"));
					rfqlinelist.add(rfqlineedit);

				}
				rfqbean.setRfqlineeditlist(rfqlinelist);
				rfqedit.add(rfqbean);

			}
			request.setAttribute("editvalues", rfqedit);
			request.setAttribute("rfqlindetails", rfqlinelist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "rfqHome";

	}

	@RequestMapping(value = "/RFQDuplicateEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkrfqnameEdit(HttpServletRequest request,
			HttpServletResponse response, Model model, RfqBean rfqbean) {

		Long pname = null;

		try {

			String beforeedit = request.getParameter("rfqnameedit");
			int id = Integer.parseInt(request.getParameter("rfqeditid"));

			pname = rfqservice.getRfqCountedit(beforeedit, id);
			if (pname != 0) {

				rfqbean.setRfqNoedit("");

				msgedit = "Warning ! RFQ No is already exists. Please try some other name";

			}
			if (pname == 0) {

				rfqbean.setRfqNoedit("");

				msgedit = null;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msgedit;
	}

	@RequestMapping(value = "/rfqUpdate", method = RequestMethod.POST)
	public String rfqUpdate(@ModelAttribute("RFQ") RfqBean rfqUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<RFQLineBean> rfqlinelist = new ArrayList<RFQLineBean>();
		String msg = null;
		String rfqdUpdate = null;
		String checked = "", s1 = "0", s2 = "1";
		int ss = 0;
		try {
			rfqUpdate.setRfqid(rfqUpdate.getRfqidedit());
			rfqUpdate.setRfqType(rfqUpdate.getRfqTypeedit());
			rfqUpdate.setRfqNo(rfqUpdate.getRfqNoedit());
			rfqUpdate.setRfqDate(dateService.dateFormat(
					dateService.dateParse(rfqUpdate.getRfqDateedit(), "au"),
					"au"));
			rfqUpdate.setQuotationdeadline(dateService.dateFormat(dateService
					.dateParse(rfqUpdate.getQuotationdeadlineedit(), "au"),
					"au"));
			rfqUpdate.setItemCategory(rfqUpdate.getItemCategoryedit());
			rfqUpdate.setDeliveryDate(dateService.dateFormat(dateService
					.dateParse(rfqUpdate.getDeliveryDateedit(), "au"), "au"));
			rfqUpdate.setValidFrom(dateService.dateFormat(
					dateService.dateParse(rfqUpdate.getValidFromedit(), "au"),
					"au"));
			rfqUpdate.setValidTo(dateService.dateFormat(
					dateService.dateParse(rfqUpdate.getValidToedit(), "au"),
					"au"));
			rfqUpdate.setStorageLocation(rfqUpdate.getStorageLocationedit());
			rfqUpdate.setPalntRfq(rfqUpdate.getPalntRfqedit());
			rfqUpdate.setRefNumber(rfqUpdate.getRefNumberedit());
			rfqUpdate.setPurchaseGrouprfq(rfqUpdate.getPurchaseGrouprfqeit());
			rfqUpdate.setStatusid(rfqUpdate.getStatusidedit());

			int rfqlineid[] = rfqUpdate.getRfqlineidedit();
			String ddate[] = rfqUpdate.getDeliverydateedit();
			if (ddate != null) {
				String rfqmaterialid = rfqUpdate.getMaterialidedit();

				List<String> rfqmateriallist = Arrays.asList(rfqmaterialid
						.split(","));
				Object[] materialarray = rfqmateriallist.toArray();
				int rfqqty[] = rfqUpdate.getQtyedit();
				String uomid = rfqUpdate.getUomidedit();
				List<String> rfquomlist = Arrays.asList(uomid.split(","));
				Object[] uomrfq = rfquomlist.toArray();

				if (rfqmaterialid != null) {

					for (int r = 0; r < ddate.length; r++) {
						int rfqId = rfqlineid[r];

						if (rfqId == 0) {
							System.out.println("this is if block");
							RFQLineBean rfqlinebean = new RFQLineBean();
							rfqlinebean.setRfqlineid(rfqlineid[r]);
							rfqlinebean.setMaterialid(materialarray[r]
									.toString());

							rfqlinebean.setQty(rfqqty[r]);
							rfqlinebean.setUomid(uomrfq[r].toString());
							rfqlinebean
									.setDeliverydate(dateService.dateFormat(
											dateService.dateParse(ddate[r],
													"au"), "au"));
							rfqlinelist.add(rfqlinebean);

						} else {

							RFQLineBean rfqlinebean = new RFQLineBean();
							rfqlinebean.setRfqlineid(rfqlineid[r]);
							rfqlinebean.setMaterialid(materialarray[r]
									.toString());

							rfqlinebean.setQty(rfqqty[r]);
							rfqlinebean.setUomid(uomrfq[r].toString());
							rfqlinebean
									.setDeliverydate(dateService.dateFormat(
											dateService.dateParse(ddate[r],
													"au"), "au"));
							rfqlinelist.add(rfqlinebean);
							ss = rfqlineid[r];

							checked = request.getParameter("Checkdelete" + ss);

							if (s2.equals(checked)) {

								rfqservice.deleteChildDetailsService(ss);

							}
							if (s1.equals(checked) || checked == null) {
								rfqlinelist.add(rfqlinebean);

							}

						}

					}
				}

			}

			rfqUpdate.setRfqlinebean(rfqlinelist);
			msg = rfqservice.updateRfqservice(rfqUpdate);

			if (msg.equals("S")) {
				request.setAttribute("RfqUpdateSuccess",
						"RFQ Data Updated Successfully");
				model.addAttribute("RFQ", new RfqBean());
			} else {
				request.setAttribute("RfqUpdateFail",
						"RFQ Data Updated Successfully");
				model.addAttribute("RFQ", new RfqBean());
			}

		} catch (Exception e) {
			request.setAttribute("RfqUpdateFail",
					"RFQ Data Updated Successfully");
			model.addAttribute("RFQ", new RfqBean());
			e.printStackTrace();
		}

		return "rfqHome";
	}

	@RequestMapping(value = "/rfqDelete", method = RequestMethod.GET)
	public String rfqDelete(@ModelAttribute("RFQ") RfqBean rfqBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String rfqDelete = null;
		response.setCharacterEncoding("UTF-8");

		int rId = Integer.parseInt(request.getParameter("rfqdelid"));
		logger.info(" rfq id iss==" + rId);

		try {
			String msg = rfqservice.deleteRfqservice(rId);
			logger.info("success msg idsss==s==" + rId);
			if (msg.equals("S")) {

				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "RFQ", "ROW", String.valueOf(rId),
						"1", modifiedDate, session.getAttribute("userName")
								.toString());
				rfqDelete = "RFQ Details Deleted Successfully";
				request.setAttribute("RfqDeleteSuccess",
						"RFQ Data Deleted Successfully");
				model.addAttribute("RFQ", new RfqBean());
			} else {
				rfqDelete = "RFQ Details Deletion Failed";
				request.setAttribute("RfqDeleteFail",
						"RFQ Data Deleted Successfully");
				model.addAttribute("RFQ", new RfqBean());
			}

		} catch (Exception e) {
			rfqDelete = "RFQ Details Deletion Failed";
			request.setAttribute("RfqDeleteFail",
					"RFQ Data Deleted Successfully");
			e.printStackTrace();
		}
		return "rfqHome";

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "rfqid";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/rfqAdvanceSearch", method = RequestMethod.GET)
	public String rfqAdvanceSearch(@ModelAttribute("RFQ") RfqBean rfqbean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		List<RfqBean> rfqlist = null;

		String name1 = "rfqid", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		// Vendor v=null;
		rfqlist = new ArrayList<RfqBean>();
		rfqbean.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			Iterator<Object[]> ist = returnString.iterator();
			for (Object[] object : returnString) {
				RfqBean v = new RfqBean();

				s1 = (String) object[0];
				s2 = (String) object[1];
				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				rfqlist.add(v);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("rfqSearchAdvance", rfqlist);

		return "rfqHome";
	}

	@RequestMapping(value = "/rfqAdvanceSearchOperations", method = RequestMethod.POST)
	public String rfqAdvanceSearchOperations(@ModelAttribute("RFQ") RfqBean rfqbean,
			HttpServletRequest request, HttpServletResponse response) {
		List<RfqBean> rfqbeans = null;
		List<Object[]> objectsArray = null;

		response.setCharacterEncoding("UTF-8");
		rfqbeans = new ArrayList<RfqBean>();
		String columns = rfqbean.getFirstLabel();
		String operations = rfqbean.getOperations1();
		String advanceSearchText = rfqbean.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {

			objectsArray = rfqservice.Rfqadvance(columns, operations,
					advanceSearchText);
		} else {
			objectsArray = rfqservice.getrfq("ALL");
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			Object[] obj = (Object[]) iterator.next();
			RfqBean rfqbean2 = new RfqBean();
			rfqbean2.setRfqid((Integer) obj[0]);
			RFQType rfqtb = (RFQType) obj[1];
			rfqbean2.setRfqType(rfqtb.getRfqType());
			rfqbean2.setRfqNo((String) obj[2]);
			rfqbean2.setRfqDate((String) obj[3]);
			rfqbean2.setQuotationdeadline((String) obj[4]);
			ItemCategory itemcb = (ItemCategory) obj[5];
			rfqbean2.setItemCategory(itemcb.getItemCategory());
			rfqbean2.setDeliveryDate((String) obj[6]);
			rfqbean2.setValidFrom((String) obj[7]);
			rfqbean2.setValidTo((String) obj[8]);
			StorageLocation stlcb = (StorageLocation) obj[9];
			rfqbean2.setStorageLocation(stlcb.getStorageLocation());
			Plant plb = (Plant) obj[10];
			rfqbean2.setPalntRfq(plb.getPlantName());
			rfqbean2.setRefNumber((String) obj[11]);
			PurchaseGroup pgb = (PurchaseGroup) obj[12];
			rfqbean2.setPurchaseGrouprfq(pgb.getPurchaseGroup());

			rfqbeans.add(rfqbean2);
		}

		request.setAttribute("rfqbeans", rfqbeans);
		//model.addAttribute("RFQ", new RfqBean());

		return "rfqHome";
	}

}
