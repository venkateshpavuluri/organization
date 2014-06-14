/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.controller;

import java.io.IOException;
import java.text.ParseException;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.GLJournalBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.ReasonForRejection;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.VendorReturn;
import com.mnt.erp.bean.VendorReturnLine;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.PurchaseOrderService;
import com.mnt.erp.service.ReasonForRejectionService;
import com.mnt.erp.service.StorageLocationService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.VendorReturnService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Sailaja
 * @version 1.0 20-11-2013
 * @build 0.0
 */
@Controller
@Scope("request")
public class VendorReturnController {

	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	StorageLocationService storageLocationService;
	@Autowired
	VendorReturnService vrService;
	@Autowired
	MaterialService materialService;
	@Autowired
	ReasonForRejectionService rfrService;
	@Autowired
	PurchaseOrderService poService;
	@Autowired
	UomService uomService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	PopulateService populateService;
	@Autowired
	DateConversionService dateService;

	HttpSession session = null;
	Object[] objects = null;

	List<VendorReturn> vr1 = null;
	String name = null;
	VendorReturn vr = null;
	Object objects2 = null;

	List<Object> objectsArray = null;
	int id = 0;
	Iterator<Object> iterator = null;
	List<VendorReturn> vrList = null;

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "vendorReturnId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/* To Get Material Id Values */
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

	@ModelAttribute("goodsReceipt")
	public Map<Integer, String> goodsReceiptGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();

		try {

			map = populateService
					.populateSelectBox("select gr.goodsReceipt_Id,gr.goodsReceiptTypeNum from GoodsReceipt gr");

			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	@ModelAttribute("batchNos")
	public Map<String, String> batchNos() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = new HashMap<String, String>();
		try {
			map = populateService
					.populatePopUp("select gr.batchNo,gr.batchNo from GoodsReceiptLine gr");

			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((String) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	@RequestMapping(value = "/getMatIds", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> populatMaterialIds(HttpServletRequest request) {
		int poId = 0;
		if (!"".equals(request.getParameter("purOrderId"))) {
			poId = Integer.parseInt(request.getParameter("purOrderId"));
		}
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.material_Id,m.materialName from GoodsReceiptLine grl,Material m,GoodsReceipt gr,PurchaseOrder pur where gr.goodsReceiptTypeNum=pur.purchaseOrderNo and gr.goodsReceipt_Id=grl.goodsReceipt_Id and pur.purchaseOrderId='"
							+ poId + "' and m.material_Id=grl.material_Id");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/getGoodsIds", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> populatGRIds(HttpServletRequest request) {
		int poId = 0;
		if (!"".equals(request.getParameter("purOrderId"))) {
			poId = Integer.parseInt(request.getParameter("purOrderId"));
		}
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select gr.goodsReceipt_Id,gr.goodsReceiptTypeNum from GoodsReceipt gr,PurchaseOrder pur,GoodsReceiptType grt where grt.goodsReceiptTypeId=gr.goodsReceiptType_Id and gr.goodsReceiptTypeNum=pur.purchaseOrderNo and pur.purchaseOrderId='"
							+ poId
							+ "' and grt.goodsReceiptType='Purchase Order'");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/getBatchNos", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> populateBatchNos(HttpServletRequest request) {
		int grId = 0;
		if (!"".equals(request.getParameter("grId"))) {
			grId = Integer.parseInt(request.getParameter("grId"));
		}
		Map<String, String> map = null;
		try {
			map = populateService
					.populatePopUp("select grl.batchNo,grl.batchNo from GoodsReceipt gr,GoodsReceiptLine grl where gr.goodsReceipt_Id=grl.goodsReceipt_Id and gr.goodsReceipt_Id='"
							+ grId + "'");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/* To Get UOM Id Values */
	@ModelAttribute("uom")
	public Map<Integer, String> UomIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = uomService.selectUomDetails();
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

	/* ========= To Get RFR Id Values================ */
	@ModelAttribute("reasonforrejection")
	public Map<Integer, String> RFRIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = rfrService.searchReasonForRejection();
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

	/* ========= To Get RFR Id Values================ */
	@ModelAttribute("purchaseorder")
	public Map<Integer, String> purchaseOrderIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = vrService.getPurchaseOrderIds();

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

	@RequestMapping(value = "/VendorReturn", method = RequestMethod.GET)
	public ModelAndView getVendorReturn(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("VendorReturn.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("vendorReturnHome", "vendorReturnCommand",
				new VendorReturn());

	}

	/*
	 * ===========================Duplicate checking for
	 * add========================
	 */
	@RequestMapping(value = "/vendorReturnDuplicateAddCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkVrNo(HttpServletRequest request, HttpServletResponse response,
			VendorReturn vend) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;

		try {

			String before = request.getParameter("vendorReturnNo");
			pname = vrService.checkDuplicate(before);
			if (pname != 0) {
				vend.setAid(2);

				request.setAttribute("addVendorReturnDuplicate",
						"Vendor Return No Already Exists Choose Another One");

				vend.setVendorReturnNo("");

				msg = "Vendor Return No Already Exists Choose Another One";

			}
			if (pname == 0) {
				vend.setAid(2);
				request.setAttribute("addVendorReturnDuplicate",
						"Vendor Return No Already Exists Choose Another One");
				vend.setVendorReturnNo("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/getRejQty", method = RequestMethod.POST)
	public @ResponseBody
	float getRejQty(HttpServletRequest request, HttpServletResponse response,
			VendorReturn vend) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> ob = null;
		float rejQty = 0.0f, returnQty = 0.0f, qty = 0.0f;
		int poId = 0, grId = 0;
		String mtId = null, bNo = null;
		try {
			if (!"".equals(request.getParameter("bNo"))) {
				poId = Integer.parseInt(request.getParameter("purOrderId"));
				grId = Integer.parseInt(request.getParameter("grId"));
				mtId = request.getParameter("mtId");
				bNo = request.getParameter("bNo");
				ob = vrService.getRejQty(poId, grId, mtId, bNo);
				if (ob != null) {
					Iterator<Object[]> itr = ob.iterator();
					while (itr.hasNext()) {
						Object[] obj = (Object[]) itr.next();
						if (obj[0] != null && obj[1] != null) {
							rejQty = (Float) obj[0];
							returnQty = (Float) obj[1];
							qty = (rejQty > returnQty) ? rejQty - returnQty
									: returnQty - rejQty;
						} else if (obj[0] != null) {
							rejQty = (Float) obj[0];
							qty = rejQty;

						}

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return qty;
	}

	/* ================================Add Method========================== */
	@RequestMapping(value = "/vendorReturn", method = RequestMethod.GET)
	public String addVendorReturn(
			@ModelAttribute("vendorReturnCommand") VendorReturn vendorReturnAdd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		VendorReturnLine vrLine = null;
		List<VendorReturnLine> vrLines = null;
		String vrAddSus = null;
		String msg = null;

		String checkVrNo = vendorReturnAdd.getVendorReturnNo();
		int list1 = vrService.checkDuplicate(checkVrNo);
		if (list1 == 0) {

			try {

				vrLines = new ArrayList<VendorReturnLine>();

				String material = vendorReturnAdd.getmId();
				String[] bNo = vendorReturnAdd.getBatchNo();
				List<String> mlist = Arrays.asList(material.split(","));
				Object[] materialiid = mlist.toArray();

				Integer[] quantity = vendorReturnAdd.getQuantity();
				String unit = vendorReturnAdd.getUomm();
				List<String> uomlist = Arrays.asList(unit.split(","));
				Object[] uomid = uomlist.toArray();

				float[] price = vendorReturnAdd.getPrice();

				String rfr = vendorReturnAdd.getRfrId();
				List<String> rfrlist = Arrays.asList(rfr.split(","));
				Object[] rfrid = rfrlist.toArray();

				String storage = vendorReturnAdd.getStLId();
				List<String> storagelist = Arrays.asList(storage.split(","));
				Object[] storageid = storagelist.toArray();

				for (int i = 0; i < quantity.length; i++) {
					vrLine = new VendorReturnLine();
					vrLine.setMaterial_Id(materialiid[i].toString());
					vrLine.setQuantity(quantity[i]);
					vrLine.setUom_Id(uomid[i].toString());
					vrLine.setPrice(price[i]);
					vrLine.setReasonForRejectionId(rfrid[i].toString());
					vrLine.setStorageLocationId(storageid[i].toString());
					vrLine.setBatchNo(bNo[i]);
					vrLines.add(vrLine);

					float enteredQty = vrLine.getQuantity();
					int materialid = Integer.parseInt(vrLine.getMaterial_Id());
					float materialStock;
					materialStock = materialService
							.materialStockGet(materialid);
					float updatedStock = 0;
					updatedStock = materialStock - enteredQty;
					// msg =
					// materialService.materialStockUpdate(materialid,updatedStock);
					// Update Goods Receipt Line Returns Qty
					vrService.updateGRLQtyReturns(Integer
							.parseInt(vendorReturnAdd.getGoodsReceiptId()),
							materialiid[i].toString(), String.valueOf(bNo[i]),
							quantity[i].floatValue());

				}
				vendorReturnAdd.setVendorReturnDate(dateService.dateFormat(
						dateService.dateParse(
								vendorReturnAdd.getVendorReturnDate(), "au"),
						"au"));
				vendorReturnAdd.setVendorReturnLine(vrLines);
				msg = vrService.addVendorReturn(vendorReturnAdd);
				request.setAttribute("addVendorReturn",
						"Vendor Return Details Successfully Saved");
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (msg.equals("S")) {
				session = request.getSession(false);
				Date dates = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(dates);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Vendor Returns", "ROW", String
						.valueOf(vendorReturnAdd.getVendorReturnId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				vrAddSus = "Vendor Return Details Successfully Saved";
				list.add("2");

			}
			model.addAttribute("vendorReturnCommand", new VendorReturn());

			return "redirect:VendorReturn.mnt?Addsuccess=" + vrAddSus + "";

		} else {
			vendorReturnAdd.setAid(1);

			request.setAttribute("addVendorReturnDuplicate",
					"Vendor Return No Already Exists Choose Another One");
			return "redirect:VendorReturn.mnt?AddFail=" + vrAddSus + "";
		}

	}

	/*
	 * =============================Search
	 * Method======================================
	 */

	@RequestMapping(value = "/vendorReturnSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchVendorReturn(
			@ModelAttribute("vendorReturnCommand") VendorReturn vendorReturnSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<VendorReturn> vrlist = new ArrayList<VendorReturn>();
		List<Object> list = null;
		List<Object> lob = null;
		try {

			String dbField = vendorReturnSearch.getXmlLabel();
			String operation = vendorReturnSearch.getOperations();
			String basicSearchId = vendorReturnSearch.getBasicSearchId();

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

				lob = vrService.searchVendorReturn();

				Iterator<Object> iterator = lob.iterator();

				while (iterator.hasNext()) {
					VendorReturn vr = (VendorReturn) iterator.next();
					vr.setVendorReturnId(vr.getVendorReturnId());
					vr.setVendorReturnNo(vr.getVendorReturnNo());
					vr.setVendorReturnDate(dateService.dateFormat(dateService
							.dateParse(vr.getVendorReturnDate(), "se"), "se"));
					vr.setReference(vr.getReference());
					vr.setDescription(vr.getDescription());
					vr.setBatchNo(vr.getBatchNo());

					vrlist.add(vr);

				}

			} else {

				list = vrService.basicSearchVendorReturn(dbField, operation,
						basicSearchId);
				Iterator<Object> iter = list.iterator();

				while (iter.hasNext()) {
					VendorReturn vr = (VendorReturn) iter.next();
					vr.setVendorReturnId(vr.getVendorReturnId());
					vr.setVendorReturnNo(vr.getVendorReturnNo());
					vr.setVendorReturnDate(dateService.dateFormat(dateService
							.dateParse(vr.getVendorReturnDate(), "se"), "se"));
					vr.setReference(vr.getReference());
					vr.setDescription(vr.getDescription());
					vr.setBatchNo(vr.getBatchNo());
					vrlist.add(vr);

				}

			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("vendorReturnSearch", vrlist);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("vendorReturnHome");
		modelAndView.addObject("vendorReturnCommand");

		return modelAndView;
	}

	@RequestMapping(value = "/vendorReturnAdvanceSearch", method = RequestMethod.GET)
	public String vendorReturnAdvanceSearch(
			@ModelAttribute("vendorReturnCommand") VendorReturn vendorReturn,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		List<Object[]> objArray = null;
		vrList = new ArrayList<VendorReturn>();
		List<VendorReturn> refList = new ArrayList<VendorReturn>();
		vendorReturn.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("vendorReturnId");

			for (Object[] object : objArray) {
				VendorReturn s = new VendorReturn();
				if ((boolean) object[2].equals("false")) {
					s.setDbField((String) object[0]);
					s.setLabels((String) object[1]);
					vrList.add(s);
				} else {
					s.setDbField((String) object[0]);
					s.setLabels((String) object[1]);
					refList.add(s);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("vendorReturnSearchAdvance", vrList);
		model.addAttribute("refList", refList);

		return "vendorReturnHome";
	}

	@RequestMapping(value = "/vendorReturnAdvanceSearchOperations", method = RequestMethod.POST)
	public String vendorReturnAdvanceSearchOperations(
			@ModelAttribute("vendorReturnCommand") VendorReturn vendorReturn,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {

		vr1 = new ArrayList<VendorReturn>();
		String columns = vendorReturn.getDbField();
		String operations = vendorReturn.getAsOpts();
		String advanceSearchText = vendorReturn.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {
			objectsArray = vrService.getVendorReturnAdvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = vrService.getVendorReturn("ALL");
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {

			VendorReturn vr = (VendorReturn) iterator.next();
			vr.setVendorReturnId(vr.getVendorReturnId());
			vr.setVendorReturnNo(vr.getVendorReturnNo());
			vr.setVendorReturnDate(dateService.dateFormat(dateService
					.dateParse(vr.getVendorReturnDate(), "se"), "se"));
			vr.setReference(vr.getReference());
			vr.setDescription(vr.getDescription());
			vr.setBatchNo(vr.getBatchNo());
			vr1.add(vr);

		}

		request.setAttribute("vendorReturnSearch", vr1);
		model.addAttribute("vendorReturn", new VendorReturn());
		request.setAttribute("Adv", "Adv");
		vendorReturn.setAdvanceSearchHidden(0);
		return "vendorReturnHome";
	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/vendorReturnIdDelete", method = RequestMethod.GET)
	public String vendorReturnDelete(
			@ModelAttribute("vendorReturnCommand") VendorReturn vendorReturnDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();

		String vendorReturnUpdate = null;
		int id = Integer.parseInt(request.getParameter("vendorReturnId"));

		try {
			String msg = vrService.deleteVendorReturn(id);
			if (msg.equals("Deleted")) {
				session = request.getSession(false);
				Date dates = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(dates);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Vendor Returns", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				vendorReturnUpdate = "Vendor Return Details Deleted Successfully";
				list.add("2");
			} else {
				vendorReturnUpdate = "Deletion Failed Due to Constraint Violation";
				return "redirect:VendorReturn.mnt?deleteFail="
						+ vendorReturnUpdate + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:VendorReturn.mnt?deleteSuccess=" + vendorReturnUpdate
				+ "";
	}

	/*
	 * =====================================Edit
	 * Method==============================
	 */
	@RequestMapping(value = "/vendorReturnIdEdit1", method = RequestMethod.GET)
	@Scope("request")
	public String vendorReturnEdit(
			@ModelAttribute VendorReturn vendorReturnIdEdit1,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<Float> qtyList = new ArrayList<Float>();
		List<Object> list = null;
		List<VendorReturn> vrEditList = new ArrayList<VendorReturn>();
		List<VendorReturnLine> vrLineEditList = new ArrayList<VendorReturnLine>();
		int vrid = vendorReturnIdEdit1.getVendorReturnId();

		try {

			list = vrService.editVendorReturnWithId(vrid);

			Iterator<Object> iterator = list.iterator();

			if (iterator.hasNext()) {
				Object vrObj = iterator.next();
				VendorReturn vr = (VendorReturn) vrObj;

				vendorReturnIdEdit1.setVendorReturnIdEditt(vr
						.getVendorReturnId());
				vendorReturnIdEdit1.setVendorReturnNoEditt(vr
						.getVendorReturnNo());
				vendorReturnIdEdit1.setVendorReturnDateEditt(dateService
						.dateFormat(dateService.dateParse(
								vr.getVendorReturnDate(), "se"), "se"));
				vendorReturnIdEdit1.setReferenceEditt(vr.getReference());
				vendorReturnIdEdit1.setDescriptionEditt(vr.getDescription());
				vendorReturnIdEdit1.setPurchaseOrderIdEditt(vr
						.getPurchaseOrderId());
				vendorReturnIdEdit1.setGoodsReceiptIdEdit(vr
						.getGoodsReceiptId());

				List<VendorReturnLine> listEdit = vr.getVendorReturnLine();

				Iterator<VendorReturnLine> iterator1 = listEdit.iterator();
				while (iterator1.hasNext()) {
					Object vrLineObj = iterator1.next();
					VendorReturnLine vrLine = (VendorReturnLine) vrLineObj;
					VendorReturnLine vrMultiple = new VendorReturnLine();
					vrMultiple.setVendorReturnLineId(vrLine
							.getVendorReturnLineId());

					int materialId = Integer.parseInt(vrLine.getMaterial_Id());

					int previousUpdatedStock;
					previousUpdatedStock = materialService
							.materialStockGet(materialId);

					int materialQtyInEditField = (int) (vrLine.getQuantity());
					int stockEdit = previousUpdatedStock
							+ materialQtyInEditField;

					vrMultiple.setStockEdit(stockEdit);

					Material material = vrLine.getMaterialDetails();
					Uom uom = vrLine.getUomDetails();
					ReasonForRejection rfr = vrLine.getRfrDetails();
					StorageLocation storage = vrLine.getStorageDetails();

					vrMultiple.setMaterial_IdEditt((vrLine.getMaterial_Id()));
					vrMultiple.setMaterialName(material.getMaterialName());
					vrMultiple.setQuantityEditt((vrLine.getQuantity()));

					vrMultiple.setBatchNoEdit(vrLine.getBatchNo());
					vrMultiple.setUom_IdEditt(vrLine.getUom_Id());
					vrMultiple.setUomName(uom.getUom());
					vrMultiple.setPriceEditt(vrLine.getPrice());
					vrMultiple.setReasonForRejectionIdEditt(vrLine
							.getReasonForRejectionId());
					vrMultiple.setRfrName(rfr.getReasonForRejection());
					vrMultiple.setStorageLocationIdEditt(vrLine
							.getStorageLocationId());
					vrMultiple.setStorageName(storage.getStorageLocation());
					vrLineEditList.add(vrMultiple);
					qtyList.add((float) vrLine.getQuantity());
				}
				vrEditList.add(vendorReturnIdEdit1);

			}

			model.addAttribute("vendorReturnCommand", vendorReturnIdEdit1);
			session = request.getSession(false);
			session.setAttribute("qtyList", qtyList);
			request.setAttribute("vrEditList", vrEditList);
			request.setAttribute("vrLineEditList", vrLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "vendorReturnHome";

	}

	/**
	 * ========================================Duplicate Checking for
	 * edit===========================
	 */
	@RequestMapping(value = "/vendorReturnDuplicateEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checknameEdit(HttpServletRequest request,
			HttpServletResponse response, VendorReturn vend) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;

		try {

			String beforeedit = request.getParameter("vendorReturnNo");
			int iid = Integer.parseInt(request.getParameter("vid"));
			pname = vrService.checkEditDuplicate(beforeedit, iid);

			if (pname != 0) {
				vend.setVendorReturnIdEditt(1);
				request.setAttribute("updateVendorReturnDuplicate",
						"Vendor Return No Already Exists Choose Another One");
				vend.setVendorReturnNoEditt("");

				msg = "Vendor Return No Already Exists Choose Another One";

			}
			if (pname == 0) {
				vend.setVendorReturnIdEditt(1);
				request.setAttribute("updateQuotDuplicate",
						"Vendor Return No Already Exists Choose Another One");
				vend.setVendorReturnNoEditt("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	/* ===================================Update Method======================== */
	@RequestMapping(value = "/vendorReturnEdit", method = RequestMethod.GET)
	public String updateVendorReturn(
			@ModelAttribute("vendorReturnCommand") VendorReturn vrEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		VendorReturnLine vrLine = null;
		List<VendorReturnLine> vrLines = null;
		String vendorReturnUpdate = null;
		List<Object[]> ob = null;
		float rejQty = 0.0f, returnQty = 0.0f, qty = 0.0f, diffQty = 0.0f;
		List<String> list = new ArrayList<String>();
		String msg = null;

		String checkVrNo = vrEdit.getVendorReturnNoEditt();

		int id = vrEdit.getVendorReturnIdEditt();

		int list1 = vrService.checkEditDuplicate(checkVrNo, id);

		if (list1 == 0) {

			try {
				float stockEdit = vrEdit.getStockEdit();
				vrEdit.setVendorReturnId(id);
				vrEdit.setVendorReturnNo(vrEdit.getVendorReturnNoEditt());
				vrEdit.setVendorReturnDate(dateService.dateFormat(dateService
						.dateParse(vrEdit.getVendorReturnDateEditt(), "au"),
						"au"));
				vrEdit.setReference(vrEdit.getReferenceEditt());
				vrEdit.setDescription(vrEdit.getDescriptionEditt());
				vrEdit.setPurchaseOrderId(vrEdit.getPurchaseOrderIdEditt());
				vrEdit.setGoodsReceiptId(vrEdit.getGoodsReceiptIdEdit());
				vrLines = new ArrayList<VendorReturnLine>();
				List<Float> newQty = new ArrayList<Float>();

				int[] vrIdUpdate = vrEdit.getVendorReturnLineIdEditt();
				String[] bno = vrEdit.getBatchNoEdit();
				String materialedit = vrEdit.getmIdEditt();
				List<String> meditlist = Arrays.asList(materialedit.split(","));
				Object[] materialiidedit = meditlist.toArray();

				Integer[] quantity = vrEdit.getQuantityEditt();

				String unitedit = vrEdit.getUommEditt();
				List<String> uomeditlist = Arrays.asList(unitedit.split(","));
				Object[] uomidedit = uomeditlist.toArray();

				float[] price = vrEdit.getPriceEditt();

				String rfredit = vrEdit.getRfrIdEditt();
				List<String> rfreditlist = Arrays.asList(rfredit.split(","));
				Object[] rfridedit = rfreditlist.toArray();

				String storageedit = vrEdit.getUommEditt();
				List<String> storageeditlist = Arrays.asList(storageedit
						.split(","));
				Object[] storageidedit = storageeditlist.toArray();

				String idQL = null;

				if (quantity != null) {
					session = request.getSession(false);
					@SuppressWarnings("unchecked")
					List<Float> oldQty = (List<Float>) session
							.getAttribute("qtyList");
					for (int i = 0; i < quantity.length; i++) {
						int kk = vrIdUpdate[i];
						// get the Qtys
						ob = vrService.getRejQty(
								Integer.parseInt(vrEdit.getPurchaseOrderId()),
								Integer.parseInt(vrEdit.getGoodsReceiptId()),
								materialiidedit[i].toString(), bno[i]);

						if (kk == 0) {
							vrLine = new VendorReturnLine();
							vrLine.setBatchNo(bno[i]);
							vrLine.setMaterial_Id(materialiidedit[i].toString());
							vrLine.setQuantity(quantity[i]);

							/*
							 * float afterEdit = vrLine.getQuantity(); int
							 * materialId = Integer.parseInt(vrLine
							 * .getMaterial_Id()); float finalStock = 0;
							 * finalStock = stockEdit - afterEdit;
							 * 
							 * materialService.materialStockUpdate(materialId,
							 * finalStock);
							 */
							vrLine.setUom_Id(uomidedit[i].toString());
							vrLine.setPrice(price[i]);
							vrLine.setReasonForRejectionId(rfridedit[i]
									.toString());
							vrLine.setStorageLocationId(storageidedit[i]
									.toString());
							vrLines.add(vrLine);
							// update qty returns in GRL
							if (ob != null) {
								Iterator<Object[]> itr = ob.iterator();
								while (itr.hasNext()) {
									Object[] obj = (Object[]) itr.next();
									if (obj[0] != null && obj[1] != null) {
										rejQty = (Float) obj[0];
										returnQty = (Float) obj[1];
									} else if (obj[0] != null) {
										rejQty = (Float) obj[0];

									}

								}
								diffQty = returnQty + quantity[i].floatValue();
								// update qty returns in GRL
								vrService.updateGRLQtyReturns(Integer
										.parseInt(vrEdit
												.getGoodsReceiptIdEdit()),
										materialiidedit[i].toString(), String
												.valueOf(bno[i]), diffQty);

							}

						} else {

							vrLine = new VendorReturnLine();
							vrLine.setBatchNo(bno[i]);
							vrLine.setMaterial_Id(materialiidedit[i].toString());
							vrLine.setQuantity(quantity[i]);
							vrLine.setUom_Id(uomidedit[i].toString());
							vrLine.setPrice(price[i]);
							vrLine.setReasonForRejectionId(rfridedit[i]
									.toString());
							vrLine.setStorageLocationId(storageidedit[i]
									.toString());

							newQty.add((float) (quantity[i]));
							String ch = "1", ch1 = "0";
							idQL = request.getParameter(kk + "Check");
							if (ch.equals(idQL)) {
								vrService.deleteVendorReturnLine(kk);
							}
							if (ch1.equals(idQL) || idQL == null) {
								vrLines.add(vrLine);
							}

							if (oldQty.get(i) > (newQty.get(i))) {
								qty = oldQty.get(i) - newQty.get(i);
								if (ob != null) {
									Iterator<Object[]> itr = ob.iterator();
									while (itr.hasNext()) {
										Object[] obj = (Object[]) itr.next();
										if (obj[0] != null && obj[1] != null) {
											rejQty = (Float) obj[0];
											returnQty = (Float) obj[1];
										} else if (obj[0] != null) {
											rejQty = (Float) obj[0];

										}

									}
									diffQty = returnQty - qty;
									// update qty returns in GRL
									vrService.updateGRLQtyReturns(Integer
											.parseInt(vrEdit
													.getGoodsReceiptIdEdit()),
											materialiidedit[i].toString(),
											String.valueOf(bno[i]), diffQty);

								}
							} else if (oldQty.get(i) < (newQty.get(i))) {
								qty = newQty.get(i) - oldQty.get(i);
								if (ob != null) {
									Iterator<Object[]> itr = ob.iterator();
									while (itr.hasNext()) {
										Object[] obj = (Object[]) itr.next();
										if (obj[0] != null && obj[1] != null) {
											rejQty = (Float) obj[0];
											returnQty = (Float) obj[1];
										} else if (obj[0] != null) {
											rejQty = (Float) obj[0];

										}

									}

									diffQty = returnQty + qty;
									// update qty returns in GRL
									vrService.updateGRLQtyReturns(Integer
											.parseInt(vrEdit
													.getGoodsReceiptIdEdit()),
											materialiidedit[i].toString(),
											String.valueOf(bno[i]), diffQty);
								}

							}

							else { // Two Quantitys are Equal No update... }

							}
						}
					}
				}
				vrEdit.setVendorReturnLine(vrLines);
				msg = vrService.updateVendorReturn(vrEdit);

				request.setAttribute("updateVendorReturn",
						"Vendor Return Details Updated Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (msg.equals("Vendor Return Details Updated Successfully")) {
				vendorReturnUpdate = "Vendor Return Details Updated Successfully";
				list.add("2");
			} else {
				return "redirect:VendorReturn.mnt?updateFail="
						+ vendorReturnUpdate + "";
			}

			model.addAttribute("vendorReturnCommand", new VendorReturn());

			return "redirect:VendorReturn.mnt?updateSuccess="
					+ vendorReturnUpdate + "";
		} else {

			request.setAttribute("vrEditList", "vrEditList");
			return "redirect:VendorReturn.mnt?updateFail=" + vendorReturnUpdate
					+ "";

		}

	}
}
