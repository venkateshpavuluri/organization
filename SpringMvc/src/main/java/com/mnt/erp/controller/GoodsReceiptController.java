/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.controller;

import java.io.PrintWriter;
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
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.GoodsReceipt;
import com.mnt.erp.bean.GoodsReceiptLine;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.GoodsReceiptService;
import com.mnt.erp.service.GoodsReceiptTypeService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PurchaseOrderService;
import com.mnt.erp.service.StatusService;
import com.mnt.erp.service.StorageLocationService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.VendorService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

@Controller
@Scope("request")
public class GoodsReceiptController {

	@Autowired
	GoodsReceiptService grService;

	@Autowired
	VendorService categoryService;

	@Autowired
	MaterialService materialService;

	@Autowired
	UomService uomService;

	@Autowired
	StatusService statusService;

	@Autowired
	GoodsReceiptTypeService grtservice;

	@Autowired
	PurchaseOrderService poservice;

	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	StorageLocationService storageLocationService;

	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;

	@Autowired
	DateConversionService dateService;
	
	List<GoodsReceipt> goods1 = null;
	String name = null;
	GoodsReceipt gr = null;
	Object objects2 = null;

	List<Object[]> objectsArray = null;
	int id = 0;
	Iterator<Object[]> iterator = null;
	List<GoodsReceipt> goodsList = null;

	/* To get Vendor Id Values */

	@ModelAttribute("vendor")
	public Map<Integer, String> vendorIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {

			listvalues = categoryService.vendorIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				map.put((Integer) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	/* Method Ended */

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
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* Method Ended */
	/* To Get Storage Location Id Values */
	@ModelAttribute("storageId")
	public Map<Integer, String> storageLocIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = storageLocationService.getStorageIds();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	/* To Get GoodsReceiptType Id Values */
	@ModelAttribute("goodsReceiptType")
	public Map<Integer, String> GoodsReceiptType() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = grtservice.goodsReceiptIdsGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* Method Ended */

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
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* Method Ended */

	/* To Get Status Id Values */
	@ModelAttribute("status")
	public Map<Integer, String> statusIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = statusService.searchStatus();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	/* Method Ended */

	@RequestMapping(value = "/GoodsReceiptHome", method = RequestMethod.GET)
	public ModelAndView getGoodsReceipt(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("GoodsReceiptHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("GoodsReceiptHome", "GoodsReceiptCommand",
				new GoodsReceipt());
	}

	@RequestMapping(value = "/GoodsReceiptAdd", method = RequestMethod.POST)
	public String saveGoodsReceipt(
			@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goodsReceipt,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		
		List<GoodsReceiptLine> goodsReceiptLines = null;
		String msg = null;
		HttpSession session = null;
		String res = null;
		try {
			goodsReceipt.setReceivingDate(dateService.dateFormat(dateService.dateParse(goodsReceipt.getReceivingDate(),"au"),"au"));
			goodsReceipt.setdCDate(dateService.dateFormat(dateService.dateParse(goodsReceipt.getdCDate(),"au"),"au"));
			goodsReceipt.setDocketDate(dateService.dateFormat(dateService.dateParse(goodsReceipt.getDocketDate(),"au"),"au"));
			if (goodsReceipt.getWeight().equals("")) {
				goodsReceipt.setWeight("0");

			}
			if (goodsReceipt.getFreightCharges().equals("")) {
				goodsReceipt.setFreightCharges("0");
			}
			if (goodsReceipt.getTotalValue().equals("")) {
				goodsReceipt.setTotalValue("0");
			}

			goodsReceiptLines = new ArrayList<GoodsReceiptLine>();

			String materialedit = goodsReceipt.getMaterialids();

			List<String> meditlist = Arrays.asList(materialedit.split(","));
			Object[] materialiids = meditlist.toArray();

			String uomedit = goodsReceipt.getQtyuoms();
			List<String> uomlist = Arrays.asList(uomedit.split(","));
			Object[] uomids = uomlist.toArray();

			String luomedit = goodsReceipt.getQlUom();
			List<String> luomlist = Arrays.asList(luomedit.split(","));
			Object[] luomids = luomlist.toArray();

			String wuomedit = goodsReceipt.getQwUom();
			List<String> wuomlist = Arrays.asList(wuomedit.split(","));
			Object[] wuomids = wuomlist.toArray();

			String sledit = goodsReceipt.getStoragelocs();
			List<String> sllist = Arrays.asList(sledit.split(","));
			Object[] slids = sllist.toArray();

			String[] batchno = goodsReceipt.getBatchNo();
			float[] receivedQty = goodsReceipt.getReceivedQty();
			String[] veondorMaterialNbr = goodsReceipt.getVendorMaterialNbr();
			String[] materialSpecs = goodsReceipt.getMaterialSpecs();
			float[] qtyLength = goodsReceipt.getQtyLength();
			float[] qtyWeight = goodsReceipt.getQtyWeight();

			for (int i = 0; i < receivedQty.length; i++) {
				GoodsReceiptLine goodsreceiptline = new GoodsReceiptLine();

				goodsreceiptline.setBatchNo(batchno[i]);
				goodsreceiptline.setMaterial_Id(materialiids[i].toString());
				goodsreceiptline.setReceivedQty(receivedQty[i]);
				goodsreceiptline.setQuantityUOM(uomids[i].toString());
				goodsreceiptline.setqAStatus("1");
				goodsreceiptline.setVendorMaterialNbr(veondorMaterialNbr[i]);
				goodsreceiptline.setMaterialSpecs(materialSpecs[i]);
				goodsreceiptline.setStorageLocationId(slids[i].toString());
				goodsreceiptline.setQtyLength(qtyLength[i]);
				goodsreceiptline.setQtyLengthUOM(luomids[i].toString());
				goodsreceiptline.setQtyWeight(qtyWeight[i]);
				goodsreceiptline.setQtyWeightUOM(wuomids[i].toString());
				goodsReceiptLines.add(goodsreceiptline);
			}
			goodsReceipt.setGoodsReceiptLine(goodsReceiptLines);
			session = request.getSession(false);
			msg = grService.saveGoodsReceipt(goodsReceipt, session
					.getAttribute("userId").toString(),
					session.getAttribute("userName").toString());
			if (msg.equals("S")) {
				res = "redirect:GoodsReceiptHome.mnt?list=" + "success" + "";
			}

			else {
				res = "redirect:GoodsReceiptHome.mnt?listwar=" + "fail" + "";
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	@RequestMapping(value = "/GoodsReceiptAddCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkname(HttpServletRequest request, HttpServletResponse response,
			GoodsReceipt goodsReceiptcheck) {
		String msg = null;
		int pname = 0;

		try {

			String before = request.getParameter("receivingIDcheck");
			pname = grService.goodsReceiptDuplicate(before);
			if (pname != 0) {
				goodsReceiptcheck.setAid(2);

				request.setAttribute("addpurchaseReqDuplicate",
						"Receiving ID Already Exists Please try some other Id");

				goodsReceiptcheck.setReceivingID("");

				msg = "Receiving ID Already Exists Please try some other Id";

			}
			if (pname == 0) {
				goodsReceiptcheck.setAid(2);
				request.setAttribute("addGoodsReceiptDuplicate",
						"Receiving ID Already Exists Choose Another One");
				goodsReceiptcheck.setReceivingID("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/GoodsReceiptSearch", method = RequestMethod.GET)
	public ModelAndView searchGoodsReceipt(
			@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goodsReceipt,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {

		List<GoodsReceipt> list4 = null;
		List<GoodsReceipt> list5 = null;
		GoodsReceipt gr = null;

		String dbField = goodsReceipt.getXmlLabel();
		String operation = goodsReceipt.getOperations();
		String basicSearchId = goodsReceipt.getBasicSearchId();

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

		try {
			list5 = new ArrayList<GoodsReceipt>();
			if (basicSearchId.length() == 0) {
				list4 = grService.searchGoodsReceipt();
			} else {
				list4 = grService.basicSearchGoodsReceipt(dbField, operation,
						basicSearchId);
			}

			Iterator<GoodsReceipt> iterator = list4.iterator();
			while (iterator.hasNext()) {
				GoodsReceipt objects = (GoodsReceipt) iterator.next();
				gr = new GoodsReceipt();

				gr.setGoodsReceipt_Id(objects.getGoodsReceipt_Id());
				gr.setGoodsReceiptType_Id(objects.getGoodsReceiptType_Id());
				gr.setGoodsReceiptTypeNum(objects.getGoodsReceiptTypeNum());
				gr.setReceivingID(objects.getReceivingID());
				gr.setReceivingDate(dateService.dateFormat(dateService.dateParse(objects.getReceivingDate(),"se"),"se"));
				gr.setStatusId(objects.getStatusId());
				gr.setdCNumber(objects.getdCNumber());
				gr.setDocketNum(objects.getDocketNum());
				gr.setMemo(objects.getMemo());
				list5.add(gr);

			}

			request.setAttribute("goodsReceipt", list5);

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GoodsReceiptHome");
		modelAndView.addObject("GoodsReceip", list5);
		return modelAndView;
	}

	@RequestMapping(value = "/purchasedetails", method = RequestMethod.GET)
	public @ResponseBody
	Map<Integer, String> getPurchaseDetails(
			@RequestParam(value = "goodsReceipt", required = true) String goodsReceiptType,
			HttpServletRequest req, HttpServletResponse response)
			throws Exception {

		String str = StringUtils.deleteWhitespace(goodsReceiptType);

		List<Object[]> list = null;
		StringBuffer stringBuffer = new StringBuffer();
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();

		{
			list = poservice.purchaseOrderNumGet(str);
			iterator = list.iterator();
			stringBuffer.append("<option value=''>" + "....Select...."
					+ "</option>");
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);

				stringBuffer.append("<option value='" + (String) objects[1]
						+ "'>");
				stringBuffer.append((String) objects[1] + "</option>");
			}

		}
		response.setContentType("text/html"); // this is imp.
		PrintWriter out;
		out = response.getWriter();
		out.println(stringBuffer.toString());
		out.flush();
		return null;
	}

	@RequestMapping(value = "/poMaterialsDetails", method = RequestMethod.POST)
	public @ResponseBody
	float getPurchaseOrderMaterials(HttpServletRequest req,
			HttpServletResponse response) throws Exception {

		String gr = req.getParameter("goodsReceipt");
		int mat = Integer.parseInt(req.getParameter("materials"));

		float s = 0.0f,result=0.0f;
		double b=0.00d;
		List<Object> list = null;
		List<Object> list2 = null;

		Iterator<Object> iterator = null;
		Iterator<Object> iterator1 = null;
		list = grService.purchaseOrderMaterialGet(gr, mat);
		
		list2=grService.goodsReceiptLineMaterialQtyGet(gr, mat);
		
		
		iterator = list.iterator();

		while (iterator.hasNext()) {
			Object objects = (Object) iterator.next();
			s = (Float) objects;
			
		}
		if(list2.get(0)!=null){
		
			iterator1=list2.iterator();
			while (iterator1.hasNext()) {
				Object objects1 = (Object) iterator1.next();
				b = (Double) objects1;
				
			}
			 result=s-(float)b;
		}
		else{
			result=s;
		}
     
		return result;
	}

	@RequestMapping(value = "/goodsReceiptEditHome", method = RequestMethod.GET)
	public String goodsReceiptEdit(
			@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goodsReceiptEdit,
			BindingResult result, HttpServletRequest request, Model model) {

		List<Object> list = null;
		List<GoodsReceipt> goodsReceiptEditList = new ArrayList<GoodsReceipt>();
		List<GoodsReceiptLine> goodsReceiptLineEditList = new ArrayList<GoodsReceiptLine>();
		int prid = Integer.parseInt(request.getParameter("goodsReceiptId"));

		try {

			list = grService.editGoodsReceipWithId(prid);
			Iterator<Object> iterator = list.iterator();
			if (iterator.hasNext()) {
				Object quotObj = iterator.next();
				GoodsReceipt goodsr = (GoodsReceipt) quotObj;
				goodsReceiptEdit.setGoodsReceipt_IdEdit(prid);
				goodsReceiptEdit.setGoodsReceiptType_IdEdit(goodsr
						.getGoodsReceiptType_Id());
				goodsReceiptEdit.setGoodsReceiptTypeNumEdit(goodsr
						.getGoodsReceiptTypeNum());

				goodsReceiptEdit.setReceivingIDEdit(goodsr.getReceivingID());
				goodsReceiptEdit
						.setReceivingDateEdit(dateService.dateFormat(dateService.dateParse(goodsr.getReceivingDate(),"se"),"se"));
             
				goodsReceiptEdit.setStatusIdEdit(goodsr.getStatusId());
			
				goodsReceiptEdit.setMemoEdit(goodsr.getMemo());
				goodsReceiptEdit.setVendor_IdEdit(goodsr.getVendor_Id());
				goodsReceiptEdit.setShippingAddressEdit(goodsr
						.getShippingAddress());
				goodsReceiptEdit.setdCNumberEdit(goodsr.getdCNumber());
				goodsReceiptEdit.setdCDateEdit(dateService.dateFormat(dateService.dateParse(goodsr.getdCDate(),"se"),"se"));
				goodsReceiptEdit.setTransportAgencyEdit(goodsr
						.getTransportAgency());
				goodsReceiptEdit.setDocketNumEdit(goodsr.getDocketNum());
				goodsReceiptEdit.setDocketDateEdit(dateService.dateFormat(dateService.dateParse(goodsr.getDocketDate(),"se"),"se"));
				goodsReceiptEdit
						.setTotalPackagesEdit(goodsr.getTotalPackages());
				goodsReceiptEdit.setWeightEdit(goodsr.getWeight());

				goodsReceiptEdit.setUom_IdEdit(goodsr.getUom_Id());
				goodsReceiptEdit.setReceivingAddressEdit(goodsr
						.getReceivingAddress());
				goodsReceiptEdit.setFreightChargesEdit(goodsr
						.getFreightCharges());
				goodsReceiptEdit.setTotalValueEdit(goodsr.getTotalValue());
				goodsReceiptEdit.setProdOrder_IdEdit(goodsr.getProdOrder_Id());
				goodsReceiptEdit.setBatch_IdEdit(goodsr.getBatch_Id());
				goodsReceiptEdit.setRouteCard_IdEdit(goodsr.getRouteCard_Id());

				List<GoodsReceiptLine> listEdit = goodsr.getGoodsReceiptLine();

				Iterator<GoodsReceiptLine> iterator1 = listEdit.iterator();
				while (iterator1.hasNext()) {
					Object grLineObj = iterator1.next();
					GoodsReceiptLine goodsRLine = (GoodsReceiptLine) grLineObj;
					GoodsReceiptLine grMultiple = new GoodsReceiptLine();

					grMultiple.setGoodsReceiptLine_Id(goodsRLine
							.getGoodsReceiptLine_Id());

					Material material = goodsRLine.getMaterialDetails();
					grMultiple.setMaterialName(material.getMaterialName());

					grMultiple.setBatchNoEdit(goodsRLine.getBatchNo());

					Uom uom = goodsRLine.getUomDetails();
					grMultiple.setQtyUomName(uom.getUom());
					Uom qluom = goodsRLine.getQtylUomDetails();
					grMultiple.setQtylname(uom.getUom());
					Uom qwuom = goodsRLine.getQtywUomDetails();
					grMultiple.setQtywname(uom.getUom());

					grMultiple.setMaterial_IdEdit(Integer.toString(material
							.getMaterial_Id()));
					grMultiple.setReceivedQtyEdit(goodsRLine.getReceivedQty());
					/*
					 * int materialId =
					 * Integer.parseInt(goodsRLine.getMaterial_Id()); int stock;
					 * stock = materialService.materialStockGet(materialId);
					 * 
					 * int
					 * beforeStockEdit=(int)(grMultiple.getReceivedQtyEdit());
					 * 
					 * 
					 * int remainingStock=stock-beforeStockEdit;
					 * 
					 * if(remainingStock<0){ remainingStock=-remainingStock; }
					 * grMultiple.setStockEdit(remainingStock);
					 */

					grMultiple.setQuantityUOMEdit(Integer.toString(uom
							.getUom_Id()));
					grMultiple.setQtyLengthUOMEdit(qluom.getUom());
					grMultiple.setVendorMaterialNbrEdit(goodsRLine
							.getVendorMaterialNbr());
					grMultiple.setMaterialSpecsEdit(goodsRLine
							.getMaterialSpecs());
					StorageLocation storagelocate = goodsRLine
							.getStoragelocDetails();
					grMultiple.setStoragelocName(storagelocate
							.getStorageLocation());
					grMultiple.setQtyLengthEdit(goodsRLine.getQtyLength());
					grMultiple.setQtyLengthUOMEdit(Integer.toString(qluom
							.getUom_Id()));
					grMultiple.setQtyWeightEdit(goodsRLine.getQtyWeight());
					grMultiple.setQtyWeightUOMEdit(Integer.toString(qwuom
							.getUom_Id()));
					grMultiple.setStorageLocationIdEdit(Integer
							.toString(storagelocate.getStorageLocationId()));
					goodsReceiptLineEditList.add(grMultiple);

				}

				goodsReceiptEditList.add(goodsReceiptEdit);

			}

			model.addAttribute("GoodsReceiptCommand", goodsReceiptEdit);

			request.setAttribute("goodsReceiptEditList", goodsReceiptEditList);
			request.setAttribute("goodsReceiptLineEditList",
					goodsReceiptLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "GoodsReceiptHome";

	}

	@RequestMapping(value = "/GoodsReceiptEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checknameEdit(HttpServletRequest request,
			HttpServletResponse response, GoodsReceipt goodsReceiptcheck) {
		String msg = null;
		int pname = 0;

		try {

			String before = request.getParameter("receivingIDEdit");
			int iid = Integer.parseInt(request
					.getParameter("goodsReceipt_IdEdit"));
			pname = grService.goodsReceiptEditDuplicate(before, iid);
			if (pname != 0) {
				goodsReceiptcheck.setGoodsReceipt_Id(1);

				request.setAttribute("addpurchaseReqEditDuplicate",
						"Receiving ID Already Exists Choose Another One");

				goodsReceiptcheck.setReceivingIDEdit("");

				msg = "Receiving ID Already Exists Choose Another One";

			}
			if (pname == 0) {
				goodsReceiptcheck.setGoodsReceipt_Id(1);

				request.setAttribute("addpurchaseReqEditDuplicate",
						"Receiving ID Already Exists Choose Another One");

				goodsReceiptcheck.setReceivingIDEdit("");

				msg = "";

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/GoodsReceiptedit", method = RequestMethod.POST)
	public String updateGoodsReceipt(
			@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goodsRecupdate,
			HttpServletRequest request, Model model) {

		List<GoodsReceiptLine> goodsReceiptLineLineEditList = new ArrayList<GoodsReceiptLine>();

		String msg = null;
try{
		// float stockEdit=goodsRecupdate.getStockEdit();
		goodsRecupdate.setGoodsReceipt_Id(goodsRecupdate
				.getGoodsReceipt_IdEdit());
		goodsRecupdate.setGoodsReceiptType_Id(goodsRecupdate
				.getGoodsReceiptType_IdEdit());
		goodsRecupdate.setGoodsReceiptTypeNum(goodsRecupdate
				.getGoodsReceiptTypeNumEdit());
		goodsRecupdate.setReceivingID(goodsRecupdate.getReceivingIDEdit());
		
		goodsRecupdate.setStatusId(goodsRecupdate.getStatusIdEdit());
	
		goodsRecupdate.setReceivingDate(dateService.dateFormat(dateService.dateParse(goodsRecupdate.getReceivingDateEdit(),"au"),"au"));
		goodsRecupdate.setReceivingStatus(goodsRecupdate
				.getReceivingStatusEdit());
		goodsRecupdate.setMemo(goodsRecupdate.getMemoEdit());
		goodsRecupdate.setVendor_Id(goodsRecupdate.getVendor_IdEdit());
		goodsRecupdate.setShippingAddress(goodsRecupdate
				.getShippingAddressEdit());
		goodsRecupdate.setdCNumber(goodsRecupdate.getdCNumberEdit());
		goodsRecupdate.setdCDate(dateService.dateFormat(dateService.dateParse(goodsRecupdate.getdCDateEdit(),"au"),"au"));
		goodsRecupdate.setTransportAgency(goodsRecupdate
				.getTransportAgencyEdit());
		goodsRecupdate.setDocketNum(goodsRecupdate.getDocketNumEdit());
		goodsRecupdate.setDocketDate(dateService.dateFormat(dateService.dateParse(goodsRecupdate.getDocketDateEdit(),"au"),"au"));
		goodsRecupdate.setTotalPackages(goodsRecupdate.getTotalPackagesEdit());
		goodsRecupdate.setWeight(goodsRecupdate.getWeightEdit());
		goodsRecupdate.setUom_Id(goodsRecupdate.getUom_IdEdit());
		goodsRecupdate.setReceivingAddress(goodsRecupdate
				.getReceivingAddressEdit());
		goodsRecupdate
				.setFreightCharges(goodsRecupdate.getFreightChargesEdit());
		goodsRecupdate.setTotalValue(goodsRecupdate.getTotalValueEdit());
		goodsRecupdate.setProdOrder_Id(goodsRecupdate.getProdOrder_IdEdit());
		goodsRecupdate.setBatch_Id(goodsRecupdate.getBatch_IdEdit());
		goodsRecupdate.setRouteCard_Id(goodsRecupdate.getRouteCard_IdEdit());
		int[] goodsIdUpdate = goodsRecupdate.getGoodsReceiptLine_IdEdit();
		String materialedit = goodsRecupdate.getMaterialidsEdit();
		List<String> meditlist = Arrays.asList(materialedit.split(","));
		Object[] materialiidedit = meditlist.toArray();
		String[] batchno = goodsRecupdate.getBatchNoEdit();
		float[] receivedQty = goodsRecupdate.getReceivedQtyEdit();
		String uomedit = goodsRecupdate.getQtyuomsEdit();
		List<String> uomlist = Arrays.asList(uomedit.split(","));
		Object[] uomeditid = uomlist.toArray();

		String stedit = goodsRecupdate.getStoragelocsEdit();

		List<String> stlist = Arrays.asList(stedit.split(","));
		Object[] stledit = stlist.toArray();

		String[] veondorMaterialNbr = goodsRecupdate.getVendorMaterialNbrEdit();
		String[] materialSpecs = goodsRecupdate.getMaterialSpecsEdit();
		float[] qtyLength = goodsRecupdate.getQtyLengthEdit();

		String qtylentthuom = goodsRecupdate.getQlUomEdit();
		List<String> qtylengthlist = Arrays.asList(qtylentthuom.split(","));
		Object[] qluom = qtylengthlist.toArray();
		float[] qtyWeight = goodsRecupdate.getQtyWeightEdit();

		String qtyWeightUOMedit = goodsRecupdate.getQlUomEdit();
		List<String> qwlist = Arrays.asList(qtyWeightUOMedit.split(","));
		Object[] qtyWeightUOM = qwlist.toArray();

		for (int i = 0; i < receivedQty.length; i++) {

			GoodsReceiptLine goodsreceiptline = new GoodsReceiptLine();

			goodsreceiptline.setMaterial_Id(materialiidedit[i].toString());
			goodsreceiptline.setBatchNo(batchno[i].toString());
			goodsreceiptline.setReceivedQty(receivedQty[i]);
			goodsreceiptline.setQuantityUOM(uomeditid[i].toString());

			/*
			 * float recivedQty = goodsreceiptline.getReceivedQty();
			 * 
			 * int materialId =
			 * Integer.parseInt(goodsreceiptline.getMaterial_Id());
			 * 
			 * 
			 * float totalStock = 0; totalStock = recivedQty + stockEdit;
			 * 
			 * String a = materialService.materialStockUpdate(materialId,
			 * totalStock);
			 */

			goodsreceiptline.setVendorMaterialNbr(veondorMaterialNbr[i]);
			goodsreceiptline.setMaterialSpecs(materialSpecs[i]);
			goodsreceiptline.setStorageLocationId(stledit[i].toString());
			goodsreceiptline.setQtyLength(qtyLength[i]);
			goodsreceiptline.setQtyLengthUOM(qluom[i].toString());
			goodsreceiptline.setQtyWeight(qtyWeight[i]);
			goodsreceiptline.setQtyWeightUOM(qtyWeightUOM[i].toString());

			int kk = goodsIdUpdate[i];

			String ch = "1", ch1 = "0";
			String idQL = request.getParameter(kk + "Check");

			if (ch.equals(idQL)) {
				grService.deleteGoodsReceiptLine(kk);

			}

			if (ch1.equals(idQL) || idQL == null) {
				goodsReceiptLineLineEditList.add(goodsreceiptline);
				goodsRecupdate
						.setGoodsReceiptLine(goodsReceiptLineLineEditList);

			}

		}

		msg = grService.updateGoodsReceipt(goodsRecupdate);
	

		if (msg.equals("S")) {
		
			request.setAttribute("goodsReceiptUpdate",
					"Goods Receipt has been updated");
		} else {
			
			request.setAttribute("goodsReceiptUpdateError",
					"Goods Receipt has not been updated");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
		return "GoodsReceiptHome";
	}

	@RequestMapping(value = "/goodsReceiptDelete", method = RequestMethod.GET)
	public ModelAndView goodsReceiptDelete(
			@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goodsReceiptDelet,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("goodsReceiptId"));
		HttpSession session = null;

		try {
			String msg = grService.deleteGoodsReceipt(id);

			if (msg.equals("S")) {

				request.setAttribute("goodsReceiptDelete",
						"Goods Receipt has been deleted Successfully");

				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Goods Receipt", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());

			} else {

				request.setAttribute("goodsReceiptDeleteError",
						"Goods Receipt has not been deleted");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("GoodsReceiptHome", "GoodsReceiptCommand",
				new GoodsReceipt());

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "goodsreceiptId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/goodsAdvanceSearch", method = RequestMethod.GET)
	public ModelAndView goodsAdvanceSearch(
			@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goods,
			HttpServletRequest request, HttpServletResponse response) {

		String name1 = "goods", s1 = null, s2 = null;

		List<Object[]> returnString = null;

		goodsList = new ArrayList<GoodsReceipt>();
		goods.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);

			for (Object[] object : returnString) {
				GoodsReceipt g = new GoodsReceipt();

				s1 = (String) object[0];
				s2 = (String) object[1];
				g.setFirstLabel(s1);

				g.setSecondLabel(s2);
				goodsList.add(g);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GoodsReceiptHome");
		request.setAttribute("goodsSearchAdvance", goodsList);
		return modelAndView;
	}

	@RequestMapping(value = "/goodsAdvanceSearchOperations", method = RequestMethod.POST)
	public ModelAndView goodsAdvanceSearchOperations(
			@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goods,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		List<Object> list = null;
		goods1 = new ArrayList<GoodsReceipt>();
		String columns = goods.getFirstLabel();
		String operations = goods.getOperations1();
		String advanceSearchText = goods.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {

			list = grService.getGoodsAdvance(columns, operations,
					advanceSearchText);

		} else {
			list = grService.getGoods("ALL");
		}

		Iterator<Object> iterator = list.iterator();
		while (iterator.hasNext()) {

			gr = new com.mnt.erp.bean.GoodsReceipt();

			objects2 = (Object) iterator.next();
			GoodsReceipt goodsReceipt = (GoodsReceipt) objects2;
			gr.setGoodsReceipt_Id(((GoodsReceipt) objects2)
					.getGoodsReceipt_Id());

			gr.setGoodsReceiptType_Id(((GoodsReceipt) objects2)
					.getGoodsReceiptType_Id());
			gr.setGoodsReceiptTypeNum(((GoodsReceipt) objects2)
					.getGoodsReceiptTypeNum());
			gr.setReceivingID(((GoodsReceipt) objects2).getReceivingID());
			gr.setReceivingDate(((GoodsReceipt) objects2).getReceivingDate());
			gr.setStatusId(((GoodsReceipt) objects2).getStatusId());
			gr.setdCNumber(((GoodsReceipt) objects2).getdCNumber());
			gr.setDocketNum(((GoodsReceipt) objects2).getDocketNum());
			gr.setMemo(((GoodsReceipt) objects2).getMemo());

			goods1.add(gr);

		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GoodsReceiptHome");
		request.setAttribute("GoodsReceip", goods1);
		model.addAttribute("goods", new GoodsReceipt());
		goods.setAdvanceSearchHidden(0);
		return modelAndView;
	}

}
