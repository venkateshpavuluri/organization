/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.PurchaseReq;
import com.mnt.erp.bean.PurchaseReqLine;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StockTransferBean;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.WorkFlowList;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.OrganizationService;
import com.mnt.erp.service.PlantService;
import com.mnt.erp.service.PurchaseRequisitionService;
import com.mnt.erp.service.StatusService;
import com.mnt.erp.service.StockTransferService;
import com.mnt.erp.service.StorageLocationService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.WorkFlowListService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @Author parvathi
 * @Version 1.1
 * @Batch 0.0
 */

@Controller
public class PurchaseReqController {
	public interface purhas{
		public interface purchase{
			
		}
	}
	
	@Autowired
	PlantService pservice;

	@Autowired
	UomService uomService;

	@Autowired
	StorageLocationService storageLocationService;

	@Autowired
	StatusService statusService;

	@Autowired
	OrganizationService organizationService;

	@Autowired
	MaterialService materialService;

	@Autowired
	PurchaseRequisitionService purchaseRequisitionService;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	WorkFlowListService workFlowListService;

	@Autowired
	StockTransferService stockTransService;
	@Autowired
	DateConversionService dateService;

	@RequestMapping(value = "/PurchaseReq", method = RequestMethod.GET)
	public ModelAndView getPurchaseReq(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		return new ModelAndView("PurchaseReqHome",
				"PurchaseRequisitionCommand", new PurchaseReq());
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
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* To Get Org Id Values */
	@ModelAttribute("organization")
	public Map<Integer, String> PurOrgCompany() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = organizationService.selectOrganizationDetails();
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

	/* To Get plant Id Values */
	@ModelAttribute("plant")
	public Map<Integer, String> purOrgPlant() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {

			listvalues = pservice.selectPlantDetails();
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

	@RequestMapping(value = "/PurchaseRequisition", method = RequestMethod.GET)
	public String savePurchaseReq(
			@ModelAttribute("PurchaseRequisitionCommand") PurchaseReq purchaseReq,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		List<String> purchaseReqAddlist = new ArrayList<String>();

		List<Object[]> workflowlist = null;
		List<PurchaseReqLine> purchaseReqLines = null;
		String PurchaseReqmsg = null;
		String msg = null;
		PurchaseReqLine purchaseReqLine;
		String purReqNo = purchaseReq.getPurchaseReqNo();
		int purReqDuplicate = 0;

		purReqDuplicate = purchaseRequisitionService
				.purchaseRequisitionDuplicate(purReqNo);
		if (purReqDuplicate == 0) {
			try {

				purchaseReqLines = new ArrayList<PurchaseReqLine>();
				HttpSession session = request.getSession();
				String id = (String) session.getAttribute("userId");
				purchaseReq.setRequestedBy(id);

				String materialedit = purchaseReq.getMaterialids();
				purchaseReq
						.setRequestedDate(dateService.dateFormat(
								dateService.dateParse(
										purchaseReq.getRequestedDate(), "au"),
								"au"));
				purchaseReq.setReqDate(dateService.dateFormat(
						dateService.dateParse(purchaseReq.getReqDate(), "au"),
						"au"));

				if (materialedit != null) {
					List<String> meditlist = Arrays.asList(materialedit
							.split(","));
					Object[] materialiids = meditlist.toArray();

					Integer[] quantity = purchaseReq.getQuantity();

					String uomEdit = purchaseReq.getUoms();
					List<String> uomlist = Arrays.asList(uomEdit.split(","));
					Object[] uomids = uomlist.toArray();
					
				
					String s = purchaseReq.getRedates();
					System.out.println("the dates:"+purchaseReq.getRedates());
					List<String> rdateslist = Arrays.asList(s.split(","));
					Object[] rdates = rdateslist.toArray();
					

					String statusEdit = purchaseReq.getStatusids();
					List<String> statuslist = Arrays.asList(statusEdit
							.split(","));
					Object[] statusids = statuslist.toArray();

					String plantEdit = purchaseReq.getPlants();
					List<String> plantlist = Arrays
							.asList(plantEdit.split(","));
					Object[] plantids = plantlist.toArray();

					String storageLocEdit = purchaseReq.getStoragelocs();
					List<String> storageLoclist = Arrays.asList(storageLocEdit
							.split(","));
					Object[] storageLocids = storageLoclist.toArray();
					System.out.println("the quantity length:"+quantity.length);

					for (int i = 0; i < quantity.length; i++) {
						purchaseReqLine = new PurchaseReqLine();

						purchaseReqLine.setMaterial_Id(materialiids[i]
								.toString());
						purchaseReqLine.setQty(quantity[i].toString());
						purchaseReqLine.setUom(uomids[i].toString());
						
						purchaseReqLine.setRequiredDate(dateService.dateFormat(
								dateService.dateParse(rdates[i].toString(), "au"),
								"au"));
						purchaseReqLine.setStatus_Id(statusids[i].toString());
						purchaseReqLine.setPlant_Id(plantids[i].toString());
						purchaseReqLine.setStorageLoc_Id(storageLocids[i]
								.toString());
						purchaseReqLines.add(purchaseReqLine);
					}
				}
				purchaseReq.setPurchaseReqLine(purchaseReqLines);

				/* Add of workflowlist */
				WorkFlowList wflist = new WorkFlowList();
				wflist.setReceivedFrom(id);
				wflist.setWorkListId(purchaseReq.getPurchaseReqNo());

				/* convert date format */
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date date = new Date();
				String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(Calendar.getInstance().getTime());

				String dathu = dateFormat.format(date);

				wflist.setReceivedDTTM(timeStamp.toString());
				wflist.setWorkListContext("PR");
				wflist.setWorkListStatus("Queued");
				wflist.setMessage("message");
				wflist.setActionType("action");
				workflowlist = purchaseRequisitionService.getStepUser();

				Iterator<Object[]> iterator = workflowlist.iterator();
				while (iterator.hasNext()) {

					Object[] objects = (Object[]) iterator.next();
					wflist.setUserId((String) objects[1]);
					wflist.setStep((String) objects[0]);

				}

				msg = purchaseRequisitionService
						.savePurchaseRequisitionDetails(purchaseReq);
				workFlowListService.saveWorkFlowListDaoDetails(wflist);
				request.setAttribute("purchaseReqLines",
						"Purchase Requisition Data Saved Successfully");
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (msg.equals("Purchase Requisition Details Saved Successfully")) {
				PurchaseReqmsg = "Purchase Requisition Data Saved Successfully";
				purchaseReqAddlist.add("2");
			}

			model.addAttribute("PurchaseRequisitionCommand", new PurchaseReq());
			return "redirect:PurchaseReq.mnt?success=" + PurchaseReqmsg
					+ "&list=" + purchaseReqAddlist + "";
		}

		else {
			purchaseReq.setAid(1);
			request.setAttribute("addpurchaseReqDuplicate",
					"Purchase Requisition Already Exists Choose Another One");
			return "PurchaseReqHome";
		}

	}

	@RequestMapping(value = "/purchaseReqNoCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkname(HttpServletRequest request, HttpServletResponse response,
			PurchaseReq purchaseReqcheck) throws Exception {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int purchaseReqNo = 0;

		try {
			String purchaseReqNocheck = request
					.getParameter("purchaseReqNocheck");
			purchaseReqNo = purchaseRequisitionService
					.purchaseRequisitionDuplicate(purchaseReqNocheck);
			if (purchaseReqNo != 0) {
				purchaseReqcheck.setAid(2);
				request.setAttribute("addpurchaseReqDuplicate",
						"Purchase Requisition Already Exists Choose Another One");
				purchaseReqcheck.setPurchaseReqNoEdit("");
				msg = "Purchase Requisition Already Exists Choose Another One";

			}
			if (purchaseReqNo == 0) {
				purchaseReqcheck.setAid(2);
				request.setAttribute("addpurchaseReqDuplicate",
						"Purchase Requisition Already Exists Choose Another One");
				purchaseReqcheck.setPurchaseReqNoEdit("");
				msg = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/forStorLocIdsPR", method = RequestMethod.POST)
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

	@RequestMapping(value = "/PurchaseRequisitionSearch", method = RequestMethod.GET)
	public ModelAndView searchPurchaseRequistion(
			@ModelAttribute("PurchaseRequisitionCommand") PurchaseReq purchaseReq,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> purchaseReqBasicSearch = null;
		List<PurchaseReq> purchaseReqBasicSearchlist = null;
		try {
			String dbField = purchaseReq.getXmlLabel();
			String operation = purchaseReq.getOperations();
			String basicSearchId = purchaseReq.getBasicSearchId();

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
				purchaseReqBasicSearch = purchaseRequisitionService
						.searchPurchaseReq();

			} else {
				purchaseReqBasicSearch = purchaseRequisitionService
						.basicSearchPurchaseReq(dbField, operation,
								basicSearchId);

			}
			purchaseReqBasicSearchlist = new ArrayList<PurchaseReq>();
			Iterator<Object[]> iterator = purchaseReqBasicSearch.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				PurchaseReq purchaseReqList = new PurchaseReq();
				purchaseReqList.setPurchaseReq_Id((Integer) objects[0]);
				purchaseReqList.setPurchaseReqNo((String) objects[1]);
				purchaseReqList
						.setRequestedDate(dateService.dateFormat(dateService
								.dateParse((String) objects[2], "se"), "se"));
				purchaseReqList
						.setReqDate(dateService.dateFormat(dateService
								.dateParse((String) objects[3], "se"), "se"));
				purchaseReqList.setOrgname((String) objects[4]);
				purchaseReqList.setRefNo((String) objects[5]);
				purchaseReqList.setStatus((String) objects[6]);
				purchaseReqList.setDescription((String) objects[7]);
				purchaseReqBasicSearchlist.add(purchaseReqList);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("prvalues", "prvalues");
		request.setAttribute("PurchaseReq1", purchaseReqBasicSearchlist);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PurchaseReqHome");
		modelAndView.addObject("purchaseRequi", purchaseReqBasicSearchlist);
		return modelAndView;
	}

	@RequestMapping(value = "/purchaseReqEditHome", method = RequestMethod.GET)
	public String purchaseReqEdit(
			@ModelAttribute("PurchaseRequisitionCommand") PurchaseReq purchaseReqedit,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object> purchaseReqList = null;
		List<PurchaseReq> purchaseReqEditList = new ArrayList<PurchaseReq>();
		List<PurchaseReqLine> purchaseReqLineEditList = new ArrayList<PurchaseReqLine>();
		int purchaseReqid = Integer.parseInt(request
				.getParameter("purchaseReqId"));
		List<Integer> mlist=new ArrayList<Integer>();

		try {

			purchaseReqList = purchaseRequisitionService
					.editPurchaseReqWithId(purchaseReqid);
			Iterator<Object> iterator = purchaseReqList.iterator();
			if (iterator.hasNext()) {
				Object quotObj = iterator.next();
				PurchaseReq purReq = (PurchaseReq) quotObj;
				purchaseReqedit.setPurchaseReq_IdEdit(purchaseReqid);
				purchaseReqedit.setPurchaseReqNoEdit(purReq.getPurchaseReqNo());
				purchaseReqedit.setRequestedDateEdit(dateService.dateFormat(
						dateService.dateParse(purReq.getRequestedDate(), "se"),
						"se"));
				purchaseReqedit
						.setRequiredDateEdit(dateService.dateFormat(dateService
								.dateParse(purReq.getReqDate(), "se"), "se"));

				purchaseReqedit.setOrg_IdEdit(purReq.getOrg_Id());
				purchaseReqedit.setDescriptionEdit(purReq.getDescription());
				purchaseReqedit.setRefNoEdit(purReq.getRefNo());
				purchaseReqedit.setStatus_idEdit(purReq.getStatus_id());
				purchaseReqedit.setRequestedByEdit(purReq.getRequestedBy());
				List<PurchaseReqLine> listEdit = purReq.getPurchaseReqLine();

				Iterator<PurchaseReqLine> iterator1 = listEdit.iterator();
				while (iterator1.hasNext()) {
					Object quotLineObj = iterator1.next();
					PurchaseReqLine purReqLine = (PurchaseReqLine) quotLineObj;
					PurchaseReqLine purReqMultiple = new PurchaseReqLine();
					purReqMultiple.setPurchaseReqLine_Id(purReqLine
							.getPurchaseReqLine_Id());
					Material material = purReqLine.getMaterial();
					mlist.add(material.getMaterial_Id());
					purReqMultiple.setMateriaName(material.getMaterialName());
					Uom uom = purReqLine.getUomDetails();
					purReqMultiple.setUomname(uom.getUom());
					Plant plant = purReqLine.getPlantDetails();
					purReqMultiple.setPlantname(plant.getPlantName());
					Status status = purReqLine.getStatusDetails();
					purReqMultiple.setStatuName(status.getStatus());
					StorageLocation storageloc = purReqLine
							.getStorageLocationDetails();
					purReqMultiple.setStorageLoName(storageloc
							.getStorageLocation());
					purReqMultiple.setQtyEdit(purReqLine.getQty());
					purReqMultiple.setMaterial_IdEdit(Integer.toString(material
							.getMaterial_Id()));
					purReqMultiple
							.setUomEdit(Integer.toString(uom.getUom_Id()));
					purReqMultiple.setRequiredDateEdit(dateService.dateFormat(
							dateService.dateParse(purReqLine.getRequiredDate(),
									"se"), "se"));
					purReqMultiple.setStatus_IdEdit(Integer.toString(status
							.getStatusId()));
					purReqMultiple.setPlant_IdEdit(Integer.toString(plant
							.getPlantId()));
					purReqMultiple.setStoregeLoc_IdEdit(Integer
							.toString(storageloc.getStorageLocationId()));
					purchaseReqLineEditList.add(purReqMultiple);

				}

				purchaseReqEditList.add(purchaseReqedit);

			}
		
			model.addAttribute("PurchaseRequisitionCommand", purchaseReqedit);
			request.setAttribute("mList", mlist);
			request.setAttribute("purchaseReqEditList", purchaseReqEditList);
			request.setAttribute("purchaseReqLineEditList",
					purchaseReqLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "PurchaseReqHome";

	}

	@RequestMapping(value = "/purchaseReqNoEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checknameEdit(HttpServletRequest request,
			HttpServletResponse response, PurchaseReq purchaseReqcheck) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int prNoEdit = 0;

		try {

			String purchaseReqNoEdit = request
					.getParameter("purchaseReqNoEdit");
			int purchaseReqIdEdit = Integer.parseInt(request
					.getParameter("purchaseReqIdEdit"));
			prNoEdit = purchaseRequisitionService
					.purchaseRquisitionEditDuplicate(purchaseReqNoEdit,
							purchaseReqIdEdit);

			if (prNoEdit != 0) {
				purchaseReqcheck.setPurchaseReq_IdEdit(1);
				request.setAttribute("addpurchaseReqEditDuplicate",
						"Purchase Requisition Already Exists Choose Another One");
				purchaseReqcheck.setPurchaseReqNoEdit("");
				msg = "Purchase Requisition Already Exists Choose Another One";
			}

			if (prNoEdit == 0) {
				purchaseReqcheck.setPurchaseReq_IdEdit(1);
				request.setAttribute("addpurchaseReqEditDuplicate",
						"Purchase Requisition Already Exists Choose Another One");
				purchaseReqcheck.setPurchaseReqNoEdit("");
				msg = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/PurchaseRequisitionedit", method = RequestMethod.GET)
	public String updatePurchaseRequisition(
			@ModelAttribute("PurchaseRequisitionCommand") PurchaseReq purchaseReq,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		response.setCharacterEncoding("UTF-8");
		PurchaseReqLine purchaseReqLine = null;
		List<PurchaseReqLine> PurchaseReqLineupdate = null;

		String purReqNo = purchaseReq.getPurchaseReqNoEdit();
		int purchaseReqIdEdit = purchaseReq.getPurchaseReq_IdEdit();
		int purchaseReqEditDupCheck = 0;

		String msg = null;
		purchaseReqEditDupCheck = purchaseRequisitionService
				.purchaseRquisitionEditDuplicate(purReqNo, purchaseReqIdEdit);

		if (purchaseReqEditDupCheck == 0) {

			try {

				purchaseReq.setPurchaseReq_Id(purchaseReq
						.getPurchaseReq_IdEdit());
				purchaseReq
						.setPurchaseReqNo(purchaseReq.getPurchaseReqNoEdit());
				purchaseReq
						.setRequestedDate(dateService.dateFormat(dateService
								.dateParse(purchaseReq.getRequestedDateEdit(),
										"au"), "au"));
				purchaseReq.setReqDate(dateService.dateFormat(dateService
						.dateParse(purchaseReq.getRequiredDateEdit(), "au"),
						"au"));
				purchaseReq.setOrg_Id(purchaseReq.getOrg_IdEdit());
				purchaseReq.setDescription(purchaseReq.getDescriptionEdit());
				purchaseReq.setRefNo(purchaseReq.getRefNoEdit());
				purchaseReq.setRequestedBy(purchaseReq.getRequestedByEdit());
				purchaseReq.setStatus_id(purchaseReq.getStatus_idEdit());

				int[] purchaseIdUpdate = purchaseReq
						.getPurchaseReqLineIdEditt();

				PurchaseReqLineupdate = new ArrayList<PurchaseReqLine>();
				String materialedit = purchaseReq.getMaterialidsEdit();
				List<String> meditlist = Arrays.asList(materialedit.split(","));
				Object[] materialiidedit = meditlist.toArray();
				Integer[] quantity = purchaseReq.getQuantityEdit();
				String uomedit = purchaseReq.getUomsEdit();
				List<String> uomlist = Arrays.asList(uomedit.split(","));
				Object[] uomIdlist = uomlist.toArray();

				String requiredDate = purchaseReq.getRedatesEdit();

				List<String> rdatelist = Arrays.asList(requiredDate.split(","));
				Object[] requireddate = rdatelist.toArray();
				String statusId = purchaseReq.getStatusidsEdit();
				List<String> statuslist = Arrays.asList(statusId.split(","));
				Object[] status = statuslist.toArray();
				String plantsid = purchaseReq.getPlantsEdit();
				List<String> plantslist = Arrays.asList(plantsid.split(","));
				Object[] plants = plantslist.toArray();
				String storageLocId = purchaseReq.getStoragelocsEdit();
				List<String> storageloclist = Arrays.asList(storageLocId
						.split(","));
				Object[] storageloc = storageloclist.toArray();

				String prLineCheck = null;

				for (int i = 0; i < quantity.length; i++) {
					purchaseReqLine = new PurchaseReqLine();
					purchaseReqLine.setPurchaseReqLine_Id(purchaseIdUpdate[i]);
					purchaseReqLine.setMaterial_Id(materialiidedit[i]
							.toString());
					purchaseReqLine.setQty(quantity[i].toString());
					purchaseReqLine.setUom(uomIdlist[i].toString());
					purchaseReqLine.setRequiredDate(dateService.dateFormat(
							dateService.dateParse(requireddate[i].toString(),
									"au"), "au"));
					purchaseReqLine.setStatus_Id(status[i].toString());
					purchaseReqLine.setPlant_Id(plants[i].toString());
					purchaseReqLine.setStorageLoc_Id(storageloc[i].toString());
					int prLineId = purchaseIdUpdate[i];
					String check = "1", check1 = "0";
					prLineCheck = request.getParameter(prLineId + "Check");

					if (check.equals(prLineCheck)) {

						purchaseRequisitionService
								.deletePuchseRequisitionLine(prLineId);

					}

					if (check1.equals(prLineCheck) || prLineCheck == null) {

						PurchaseReqLineupdate.add(purchaseReqLine);

					}

				}
				purchaseReq.setPurchaseReqLine(PurchaseReqLineupdate);

				msg = purchaseRequisitionService
						.updatePurchaseRequisition(purchaseReq);

				if (msg.equals("Purchase Requition  Details Updated Successfully")) {

					request.setAttribute("purchaseReqUpdate",
							"Purchase Requition  Data Updated Successfully");

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			purchaseReq.setPurchaseReq_IdEdit(1);
			request.setAttribute("addpurchaseReqEditDuplicate",
					"Purchase Requisition Already Exists Choose Another One");
			request.setAttribute("purchaseReqEditList", "purchaseReqEditList");
			return "PurchaseReqHome";
		}
		return "PurchaseReqHome";

	}

	@RequestMapping(value = "/purchaseReqDelete", method = RequestMethod.GET)
	public String purchaseReqDelete(
			@ModelAttribute("PurchaseRequisitionCommand") PurchaseReq purchaseReq,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		int purchaseReqId = Integer.parseInt(request
				.getParameter("purchaseReqId"));

		try {
			String msg = purchaseRequisitionService
					.deletePurchaseRequisition(purchaseReqId);

			if (msg.equals("Deleted")) {
				request.setAttribute("purchaseReqDelete",
						"Purchase Requisition Data Deleted Successfully");

			} else {

				request.setAttribute("purchaseReqDeleteError",
						"Purchase Requisition Data Deletion Failed!");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "PurchaseReqHome";

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "purchaseReqId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/purchaseRequisitionAdvanceSearch", method = RequestMethod.GET)
	public String purchaseRequisitionAdvanceSearch(
			@ModelAttribute("PurchaseRequisitionCommand") PurchaseReq purchaseReqAdavance,
			HttpServletRequest request, HttpServletResponse response) {
		String name1 = "purchase", string1 = null, string2 = null;
		List<Object[]> returnString = null;
		List<PurchaseReq> purchaseReqList = null;
		purchaseReqList = new ArrayList<PurchaseReq>();
		purchaseReqAdavance.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			for (Object[] object : returnString) {
				PurchaseReq purReq = new PurchaseReq();

				string1 = (String) object[0];
				string2 = (String) object[1];
				purReq.setFirstLabel(string1);

				purReq.setSecondLabel(string2);

				purchaseReqList.add(purReq);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("purchaseRequisitionSearchAdvance",
				purchaseReqList);

		return "PurchaseReqHome";

	}

	@RequestMapping(value = "/purchaseRequisitionAdvanceSearchOperations", method = RequestMethod.POST)
	public ModelAndView purchaseRequisitionAdvanceSearchOperations(
			@ModelAttribute PurchaseReq purchaseReqOpearations,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		List<PurchaseReq> purchaseReqList = null;
		purchaseReqList = new ArrayList<PurchaseReq>();
		String columns = purchaseReqOpearations.getFirstLabel();
		String operations = purchaseReqOpearations.getOperations1();
		String advanceSearchText = purchaseReqOpearations
				.getAdvanceSearchText();
		List<Object[]> objectsArray = null;
		if (advanceSearchText.length() != 0) {
			objectsArray = purchaseRequisitionService
					.getPurchaseRequisitionAdvance(columns, operations,
							advanceSearchText);

		} else {
			objectsArray = purchaseRequisitionService.searchPurchaseReq();
		}
		Iterator<Object[]> iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			PurchaseReq prList = new com.mnt.erp.bean.PurchaseReq();
			Object[] probjects = (Object[]) iterator.next();
			prList.setPurchaseReq_Id((Integer) probjects[0]);

			prList.setPurchaseReqNo((String) probjects[1]);
			String actualReqDate = (String) probjects[2];
			String modifiedReqDate = actualReqDate.substring(0, 10);
			prList.setRequestedDate(modifiedReqDate);
			String actualRequiredDate = (String) probjects[3];
			String modifiedRequiredDate = actualRequiredDate.substring(0, 10);
			prList.setReqDate(modifiedRequiredDate);
			prList.setOrgname((String) probjects[4]);
			prList.setRefNo((String) probjects[5]);
			prList.setStatus((String) probjects[6]);
			prList.setDescription((String) probjects[7]);

			purchaseReqList.add(prList);

		}
		request.setAttribute("prvalues", "prvalues");
		request.setAttribute("purchaseRequi", purchaseReqList);
		model.addAttribute("PurchaseRequisitionCommand", new PurchaseReq());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("PurchaseReqHome");
		modelAndView.addObject("purchaseRequi", purchaseReqList);
		return modelAndView;

	}

}
