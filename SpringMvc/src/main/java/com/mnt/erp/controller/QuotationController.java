/**
@copyright MNTSOFT
 * 
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.Quotation;
import com.mnt.erp.bean.QuotationLine;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StockTransferBean;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.Vendor;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CurrencyService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PlantService;
import com.mnt.erp.service.QuotationService;
import com.mnt.erp.service.StatusService;
import com.mnt.erp.service.StockTransferService;
//import com.mnt.erp.service.StockTransferService;
import com.mnt.erp.service.StorageLocationService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.VendorService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */
@Controller
@Scope("request")
public class QuotationController {
	private Logger logger = Logger.getLogger(QuotationController.class);
	@Autowired
	QuotationService qt_service;
	@Autowired
	CurrencyService currencyService;
	@Autowired
	VendorService categoryService;
	@Autowired
	MaterialService materialService;
	@Autowired
	UomService uomService;
	@Autowired
	StatusService statusService;
	@Autowired
	StorageLocationService storageLocationService;
	@Autowired
	PlantService plantService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	DateConversionService dateService;

	@Autowired
	StockTransferService stockTransService;

	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;

	HttpSession session;

	Object[] objects = null;
	List<Quotation> quotation1 = null;
	String name = null;
	Quotation ql = null;
	Object[] objects2 = null;

	List<Object[]> objectsArray = null;
	int id = 0;
	Iterator<Object[]> iterator = null;
	List<Quotation> quotationList = null;

	/* ================ To Get Plant Id Values========= */
	@ModelAttribute("plant")
	public Map<Integer, String> plantIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = plantService.getPlantIds();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* ========= To Get Storage Location Id Values================ */
	@ModelAttribute("storageId")
	public Map<Integer, String> storageLocIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = storageLocationService.getStorageIds();
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

	/* ===================== To Get Status Id Values =============== */
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

	/* ==================== To get Vendor Id Values ==================== */
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

	/* ==================== To get RFQ No Values ==================== */
	@ModelAttribute("rfqno")
	public Map<Integer, String> RfqIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {

			listvalues = qt_service.rfqIdGet();
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

	/* ==================== To Get Material Id Values================= */
	@ModelAttribute("material")
	public Map<Integer, String> materialIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = materialService.materialIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* ======================= To Get UOM Id Values================= */
	@ModelAttribute("uom")
	public Map<Integer, String> UomIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = uomService.uomIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* ====================== To Get Currency Id Values ================ */
	@ModelAttribute("currency")
	public Map<Integer, String> currencyIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = currencyService.currencyIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;

	}

	@RequestMapping(value = "/Quotation", method = RequestMethod.GET)
	public ModelAndView getQuotation(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("Quotation.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("quotationHome", "quotationCommand",
				new Quotation());

	}

	@RequestMapping(value = "/forStorLocIdsQuotation", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> storLocIds(HttpServletRequest request,
			HttpServletResponse response, StockTransferBean stBean) {
		response.setCharacterEncoding("UTF-8");

		int plantId = Integer.parseInt(request.getParameter("plantId"));
		Map<Integer, String> map = null;
		List<Object[]> list = null;
		Iterator<Object[]> itr = null;
		Object[] objects = null;
		try {
			list = stockTransService.populateStorLocIds(plantId);
			if (list.size() != 0) {
				map = new HashMap<Integer, String>();
			}
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

	/*
	 * ===========================Duplicate checking for
	 * add========================
	 */
	@RequestMapping(value = "/quotationDuplicateAddCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkquotNo(HttpServletRequest request,
			HttpServletResponse response, Quotation quot) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;
		try {
			String before = request.getParameter("quotationno");
			pname = qt_service.checkDuplicate(before);
			if (pname != 0) {
				quot.setAid(2);
				request.setAttribute("addQuotDuplicate",
						"Quotation Number is Already Exists Please try some other number");

				quot.setQuotationNo("");
				msg = "Quotation Number is Already Exists Please try some other number";

			}
			if (pname == 0) {
				quot.setAid(2);
				request.setAttribute("addQuotDuplicate",
						"Quotation Number is Already Exists Please try some other number");
				quot.setQuotationNo("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/* ================================Add Method========================== */
	@RequestMapping(value = "/quotation", method = RequestMethod.GET)
	public String addQuotation(
			@ModelAttribute("quotationCommand") Quotation quotationAdd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		QuotationLine quotationLine = null;
		List<QuotationLine> quotationLines = null;
		String quotationUpdate = null;
		String msg = null;
		String rfqNo = quotationAdd.getRfqid();

		if (rfqNo.equals("0")) {
			quotationAdd.setRfqid(null);
		}
		String checkQuotNo = quotationAdd.getQuotationNo();
		int list1 = qt_service.checkDuplicate(checkQuotNo);
		if (list1 == 0) {

			try {
				quotationAdd.setQuotationDate(dateService.dateFormat(
						dateService.dateParse(quotationAdd.getQuotationDate(),
								"au"), "au"));
				quotationLines = new ArrayList<QuotationLine>();

				String material = quotationAdd.getmId();
				List<String> mlist = Arrays.asList(material.split(","));
				Object[] materialiid = mlist.toArray();

				Integer[] quantity = quotationAdd.getQuantity();

				String unit = quotationAdd.getUomm();
				List<String> uomlist = Arrays.asList(unit.split(","));
				Object[] uomid = uomlist.toArray();

				Float[] netPrice = quotationAdd.getNetPrice();
				Integer[] perUnit = quotationAdd.getPerUnit();
				Float[] lineAmount = quotationAdd.getLineAmount();

				String currencyid = quotationAdd.getcId();
				List<String> currencylist = Arrays
						.asList(currencyid.split(","));
				Object[] currencyy = currencylist.toArray();

				String[] deliveryDate = quotationAdd.getDeliveryDate();

				String status = quotationAdd.getStId();

				List<String> statuslist = Arrays.asList(status.split(","));
				Object[] statuss = statuslist.toArray();

				String plant = quotationAdd.getpId();

				List<String> plantlist = Arrays.asList(plant.split(","));
				Object[] plantt = plantlist.toArray();

				String storage = quotationAdd.getStLId();
				List<String> storagelist = Arrays.asList(storage.split(","));
				Object[] storagee = storagelist.toArray();

				for (int i = 0; i < quantity.length; i++) {
					quotationLine = new QuotationLine();
					quotationLine.setMaterial_Id(materialiid[i].toString());
					quotationLine.setQuantity(quantity[i]);

					quotationLine.setUom(uomid[i].toString());
					quotationLine.setNetPrice(netPrice[i]);
					quotationLine.setPerUnit(perUnit[i]);
					quotationLine.setLineAmount(lineAmount[i]);

					quotationLine.setCurrencyId(currencyy[i].toString());
					quotationLine
							.setDeliveryDate(dateService.dateFormat(dateService
									.dateParse(deliveryDate[i], "au"), "au"));

					quotationLine.setStatusId(statuss[i].toString());

					quotationLine.setPlantId(plantt[i].toString());

					quotationLine.setStorageLocId(storagee[i].toString());

					quotationLines.add(quotationLine);

				}
				quotationAdd.setQuotationLine(quotationLines);
				msg = qt_service.addQuotation(quotationAdd);

			} catch (Exception e) {

				e.printStackTrace();
				return "redirect:Quotation.mnt?listwar=" + "fail" + "";
			}
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date1 = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date1);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Quotation", "ROW", String
						.valueOf(quotationAdd.getQuotationId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				return "redirect:Quotation.mnt?list=" + "success" + "";
			}

			else {

				return "redirect:Quotation.mnt?listwar=" + "fail" + "";
			}

		} else {
			quotationAdd.setAid(1);
			request.setAttribute("addQuotDuplicate",
					"Quotation Number is Already Exists Please try some other number");
			return "quotationHome";
		}
	}

	/*
	 * =============================Search
	 * Method======================================
	 */
	@RequestMapping(value = "/quotationSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchQuotation(
			@ModelAttribute("quotationCommand") Quotation quotationSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		List<Quotation> quot = null;
		List<Object[]> list = null;
		try {

			String dbField = quotationSearch.getXmlLabel();
			String operation = quotationSearch.getOperations();
			String basicSearchId = quotationSearch.getBasicSearchId();

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

				list = qt_service.searchQuotation();
				quot = new ArrayList<Quotation>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					Quotation qList = new Quotation();
					qList.setQuotationId((Integer) objects[0]);
					qList.setQuotationNo((String) objects[1]);

					Vendor vendorBean = ((Vendor) objects[2]);
					qList.setVendorId(vendorBean.getVendorName());
					qList.setQuotationDate(dateService.dateFormat(
							dateService.dateParse((String) objects[3], "se"),
							"se"));
					/*
					 * String tDate = ((String) objects[3]);
					 * 
					 * String quotDate = tDate.substring(0,10);
					 * qList.setQuotationDate(quotDate);
					 */
					qList.setDescription((String) objects[4]);

					Status statusBean = ((Status) objects[5]);
					qList.setStatus(statusBean.getStatus());

					quot.add(qList);

				}

			} else {

				list = qt_service.basicSearchQuotation(dbField, operation,
						basicSearchId);
				quot = new ArrayList<Quotation>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					Quotation qList = new Quotation();
					qList.setQuotationId((Integer) objects[0]);
					qList.setQuotationNo((String) objects[1]);

					Vendor vendorBean = ((Vendor) objects[2]);
					qList.setVendorId(vendorBean.getVendorName());
					qList.setQuotationDate(dateService.dateFormat(
							dateService.dateParse((String) objects[3], "se"),
							"se"));
					// qList.setQuotationDate((String) objects[3]);
					qList.setDescription((String) objects[4]);

					Status statusBean = ((Status) objects[5]);
					qList.setStatus(statusBean.getStatus());

					quot.add(qList);

				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("quotationHome");
		modelAndView.addObject("quotationCommand");
		request.setAttribute("quotationSearch", quot);
		return modelAndView;
	}

	/*
	 * =====================================Edit
	 * Method==============================
	 */
	@RequestMapping(value = "/quotationIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String quotationEdit(
			@ModelAttribute("quotationCommand") Quotation quotationIdEdit,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object> list = null;
		List<Quotation> quotationEditList = new ArrayList<Quotation>();
		List<QuotationLine> quotationLineEditList = new ArrayList<QuotationLine>();
		int quotid = quotationIdEdit.getQuotationId();

		try {

			list = qt_service.editQuotationWithId(quotid);

			Iterator<Object> iterator = list.iterator();

			if (iterator.hasNext()) {
				Object quotObj = iterator.next();
				Quotation quot = (Quotation) quotObj;

				quotationIdEdit.setQuotationIdEditt(quot.getQuotationId());
				quotationIdEdit.setQuotationNoEditt(quot.getQuotationNo());
				quotationIdEdit.setVendorIdEditt(quot.getVendorId());
				quotationIdEdit.setRfqidEditt(quot.getRfqid());
				/*
				 * String quotDate = quot.getQuotationDate().substring(0, 10);
				 * quotationIdEdit.setQuotationDateEditt(quotDate);
				 */
				quotationIdEdit.setQuotationDateEditt(dateService.dateFormat(
						dateService.dateParse(quot.getQuotationDate(), "se"),
						"se"));
				quotationIdEdit.setDescriptionEditt(quot.getDescription());
				quotationIdEdit.setQuotStatusIdEditt(quot.getQuotStatusId());

				List<QuotationLine> listEdit = quot.getQuotationLine();

				Iterator<QuotationLine> iterator1 = listEdit.iterator();
				while (iterator1.hasNext()) {
					Object quotLineObj = iterator1.next();
					QuotationLine quotLine = (QuotationLine) quotLineObj;
					QuotationLine quotMultiple = new QuotationLine();
					quotMultiple.setQuotationLineId(quotLine
							.getQuotationLineId());

					quotMultiple
							.setMaterial_IdEditt((quotLine.getMaterial_Id()));

					Material material = quotLine.getMaterialDetails();
					quotMultiple.setMaterialName(material.getMaterialName());

					Uom uom = quotLine.getUomDetails();
					quotMultiple.setUomName(uom.getUom());

					Plant plant = quotLine.getPlantDetails();
					quotMultiple.setPlantName(plant.getPlantName());

					Status status = quotLine.getStatusDetails();
					quotMultiple.setStatusName(status.getStatus());

					Currency currency = quotLine.getCurrencyDetails();
					quotMultiple.setCurrencyName(currency.getCurrency());

					StorageLocation stLocation = quotLine.getStLocDetails();
					quotMultiple.setStlocName(stLocation.getStorageLocation());

					quotMultiple.setQuantityEditt((quotLine.getQuantity()));
					quotMultiple.setUomEditt((quotLine.getUom()));
					quotMultiple.setNetPriceEditt((quotLine.getNetPrice()));
					quotMultiple.setPerUnitEditt((quotLine.getPerUnit()));
					quotMultiple.setLineAmountEditt((quotLine.getLineAmount()));
					quotMultiple.setCurrencyIdEditt((quotLine.getCurrencyId()));
					quotMultiple.setDeliveryDateEditt((quotLine
							.getDeliveryDate()));
					quotMultiple.setDeliveryDateEditt(dateService.dateFormat(
							dateService.dateParse(quotLine.getDeliveryDate(),
									"se"), "se"));
					quotMultiple.setStatusIdEditt((quotLine.getStatusId()));
					quotMultiple.setPlantIdEditt((quotLine.getPlantId()));
					quotMultiple.setStorageLocIdEditt((quotLine
							.getStorageLocId()));

					quotationLineEditList.add(quotMultiple);

				}
				quotationEditList.add(quotationIdEdit);

			}

			model.addAttribute("quotationCommand", quotationIdEdit);
			request.setAttribute("quotationEditList", quotationEditList);
			request.setAttribute("quotationLineEditList", quotationLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "quotationHome";

	}

	/**
	 * ========================================Duplicate Checking for
	 * edit===========================
	 */
	@RequestMapping(value = "/quotationDuplicateEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checknameEdit(HttpServletRequest request,
			HttpServletResponse response, Quotation quotation) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;

		try {

			String beforeedit = request.getParameter("quotationId");
			int iid = Integer.parseInt(request.getParameter("qid"));
			pname = qt_service.checkEditDuplicate(beforeedit, iid);
			if (pname != 0) {
				quotation.setQuotationIdEditt(1);
				request.setAttribute("updateQuotDuplicate",
						"Quotation Number is Already Exists Please try some other number");
				quotation.setQuotationNoEditt("");

				msg = "Quotation Number is Already Exists Please try some other number";

			}
			if (pname == 0) {
				quotation.setQuotationIdEditt(1);
				request.setAttribute("updateQuotDuplicate",
						"Quotation Number is Already Exists Please try some other number");
				quotation.setQuotationNoEditt("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/* ===================================Update Method======================== */
	@RequestMapping(value = "/quotationEdit", method = RequestMethod.GET)
	public String updateQuotation(
			@ModelAttribute("quotationCommand") Quotation quotationEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		QuotationLine quotationLine = null;
		List<QuotationLine> quotationLines = null;
		String quotationUpdate = null;

		List<String> list = new ArrayList<String>();
		String msg = null;

		String checkQuotNo = quotationEdit.getQuotationNoEditt();
		int id = quotationEdit.getQuotationIdEditt();
		int list1 = qt_service.checkEditDuplicate(checkQuotNo, id);

		if (list1 == 0) {

			try {
				quotationEdit.setQuotationId(id);
				quotationEdit.setQuotationNo(quotationEdit
						.getQuotationNoEditt());
				quotationEdit.setVendorId(quotationEdit.getVendorIdEditt());
				String rfqNoEdit = quotationEdit.getRfqidEditt();
				quotationEdit.setRfqid(quotationEdit.getRfqidEditt());

				if (rfqNoEdit.equals("0")) {
					quotationEdit.setRfqid(null);
				}

				quotationEdit.setQuotationDate(dateService.dateFormat(
						dateService.dateParse(
								quotationEdit.getQuotationDateEditt(), "au"),
						"au"));
				/*
				 * quotationEdit.setQuotationDate(quotationEdit
				 * .getQuotationDateEditt());
				 */
				quotationEdit.setDescription(quotationEdit
						.getDescriptionEditt());
				quotationEdit.setQuotStatusId(quotationEdit
						.getQuotStatusIdEditt());

				quotationLines = new ArrayList<QuotationLine>();
				int[] quotationIdUpdate = quotationEdit
						.getQuotationLineIdEditt();

				String materialedit = quotationEdit.getmIdEditt();
				List<String> meditlist = Arrays.asList(materialedit.split(","));
				Object[] materialiidedit = meditlist.toArray();

				Integer[] quantity = quotationEdit.getQuantityEditt();
				String unitedit = quotationEdit.getUommEditt();
				List<String> uomeditlist = Arrays.asList(unitedit.split(","));
				Object[] uomidedit = uomeditlist.toArray();

				Float[] netPrice = quotationEdit.getNetPriceEditt();
				Integer[] perUnit = quotationEdit.getPerUnitEditt();
				Float[] lineAmount = quotationEdit.getLineAmountEditt();
				String cidedit = quotationEdit.getcIdEditt();
				List<String> currencyeditlist = Arrays.asList(cidedit
						.split(","));
				Object[] cIdedit = currencyeditlist.toArray();

				String[] deliveryDate = quotationEdit.getDeliveryDateEditt();
				String statusidedit = quotationEdit.getStIdEditt();
				List<String> statuseditlist = Arrays.asList(statusidedit
						.split(","));
				Object[] statusIdedit = statuseditlist.toArray();
				String plantidedit = quotationEdit.getpIdEditt();
				List<String> planteditlist = Arrays.asList(plantidedit
						.split(","));
				Object[] plantIdedit = planteditlist.toArray();
				String storageidedit = quotationEdit.getStLIdEditt();
				List<String> storageeditlist = Arrays.asList(storageidedit
						.split(","));
				Object[] storageIdedit = storageeditlist.toArray();
				String idQL = null;

				for (int i = 0; i < quantity.length; i++) {
					quotationLine = new QuotationLine();

					quotationLine.setMaterial_Id(materialiidedit[i].toString());
					quotationLine.setQuantity(quantity[i]);
					quotationLine.setUom(uomidedit[i].toString());
					quotationLine.setNetPrice(netPrice[i]);
					quotationLine.setPerUnit(perUnit[i]);
					quotationLine.setLineAmount(lineAmount[i]);
					quotationLine.setCurrencyId(cIdedit[i].toString());
					quotationLine
							.setDeliveryDate(dateService.dateFormat(dateService
									.dateParse(deliveryDate[i], "au"), "au"));
					quotationLine.setStatusId(statusIdedit[i].toString());
					quotationLine.setPlantId(plantIdedit[i].toString());
					quotationLine.setStorageLocId(storageIdedit[i].toString());

					int qLineId = quotationIdUpdate[i];

					String ch = "1", ch1 = "0";
					idQL = request.getParameter(qLineId + "Check");

					if (ch.equals(idQL)) {
						qt_service.deleteQuotationLine(qLineId);

					}

					if (ch1.equals(idQL) || idQL == null) {
						quotationLines.add(quotationLine);
						quotationEdit.setQuotationLine(quotationLines);
					}

				}
				msg = qt_service.updateQuotation(quotationEdit);
				request.setAttribute("updateQuotation",
						"Quotation  Details Updated Successfully");
			} catch (Exception e) {
				request.setAttribute("quotationUpadateFail",
						"Quotation  Details Updated Successfully");
				e.printStackTrace();
			}
			if (msg.equals("S")) {
				request.setAttribute("quotationUpadateSuccess",
						"Quotation  Details Updated Successfully");
			} else {
				request.setAttribute("quotationUpadateFail",
						"Quotation  Details Updated Successfully");
			}

			model.addAttribute("quotationCommand", new Quotation());

		} else {

			request.setAttribute("quotationEditList", "quotationEditList");
			request.setAttribute("updateQuotDuplicate",
					"Quotation Number is Already Exists Please try some other number");
			return "quotationHome";
		}
		return "quotationHome";

	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/quotationIdDelete", method = RequestMethod.GET)
	public String quotationDelete(
			@ModelAttribute("quotationCommand") Quotation quotation,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		String quotationUpdate = null;
		int id = Integer.parseInt(request.getParameter("quotationId"));

		try {
			String msg = qt_service.deleteQuotation(id);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date1 = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date1);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Quotation", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				quotationUpdate = "Quotation Data Deleted Successfully";
				request.setAttribute("quotationDeleteSuccess", quotationUpdate);
			} else {

				request.setAttribute("quotationDeleteFail",
						"Quotation Data Deletion Failed Due to Constraint Violation");
				return "quotationHome";
			}

			model.addAttribute("quotationCommand", new Quotation());

		} catch (Exception e) {
			request.setAttribute("quotationDeleteFail",
					"Quotation Data Deletion Failed Due to Constraint Violation");
			e.printStackTrace();
		}
		return "quotationHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "quotationId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/quotationAdvanceSearch", method = RequestMethod.GET)
	public ModelAndView quotationAdvanceSearch(
			@ModelAttribute("quotationCommand") Quotation quotation,
			HttpServletRequest request, HttpServletResponse response) {

		String name1 = "quotation", s1 = null, s2 = null;

		List<Object[]> returnString = null;

		quotationList = new ArrayList<Quotation>();
		quotation.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);

			for (Object[] object : returnString) {
				Quotation q = new Quotation();

				s1 = (String) object[0];
				s2 = (String) object[1];
				q.setFirstLabel(s1);

				q.setSecondLabel(s2);
				quotationList.add(q);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("quotationHome");
		request.setAttribute("quotationSearchAdvance", quotationList);
		return modelAndView;
	}

	@RequestMapping(value = "/quotationAdvanceSearchOperations", method = RequestMethod.POST)
	public ModelAndView quotationAdvanceSearchOperations(
			@ModelAttribute("quotationCommand") Quotation quotation,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		quotation1 = new ArrayList<Quotation>();
		String columns = quotation.getFirstLabel();
		String operations = quotation.getOperations1();
		String advanceSearchText = quotation.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {

			objectsArray = qt_service.getQuotationAdvance(columns, operations,
					advanceSearchText);
		} else {
			objectsArray = qt_service.getQuotation("ALL");

		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			ql = new com.mnt.erp.bean.Quotation();
			objects2 = (Object[]) iterator.next();

			ql.setQuotationId((Integer) objects2[0]);
			ql.setQuotationNo((String) objects2[1]);

			Vendor vendorBean = ((Vendor) objects2[2]);
			ql.setVendorId(vendorBean.getVendorName());

			String tDate = ((String) objects2[3]);
			String quotDate = tDate.substring(0, 10);
			ql.setQuotationDate(quotDate);

			ql.setDescription((String) objects2[4]);
			Status statusBean = ((Status) objects2[5]);
			ql.setStatus(statusBean.getStatus());
			quotation1.add(ql);

		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("quotationHome");
		request.setAttribute("quotationSearch", quotation1);
		model.addAttribute("quotation", new Quotation());
		quotation.setAdvanceSearchHidden(0);
		return modelAndView;
	}

}
