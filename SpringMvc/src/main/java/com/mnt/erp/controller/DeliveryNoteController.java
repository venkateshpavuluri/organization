/**
 * 
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.DeliveryNoteLine;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.DeliveryNoteService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author venkateshp
 * 
 */
@Controller
public class DeliveryNoteController {

	@Autowired
	PopulateService populateService;

	@Autowired
	DeliveryNoteService deliveryNoteService;

	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;

	@Autowired
	DateConversionService dateService;
	HttpSession session = null;

	String msg;
	List<Object[]> list;
	static Logger logger = Logger.getLogger(DeliveryNoteController.class);

	@RequestMapping(value = "/deliveryNoteHome", method = RequestMethod.GET)
	public String customerHome(
			@ModelAttribute("DeliveryNoteForm") DeliveryNote deliveryNote,
			HttpServletResponse response, Model model,
			HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("deliveryNoteHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		response.setCharacterEncoding("UTF-8");
		return "deliveryNote";
	}

	@ModelAttribute("materialDetails")
	public Map<Integer, String> populatMaterialids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select m.material_Id,m.materialName from Material m");
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

	@ModelAttribute("uomDetails")
	public Map<Integer, String> populateUomDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, String>();
			listvalues = populateService
					.poPulate("select m.uom_Id,m.uom from Uom m");

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

	@ModelAttribute("statusDetails")
	public Map<Integer, String> populateStatusDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, String>();
			listvalues = populateService
					.poPulate("select s.statusId,s.status from Status s");

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

	@ModelAttribute("storageLocDetails")
	public Map<Integer, String> populateStorageLocDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, String>();
			listvalues = populateService
					.poPulate("select s.storageLocationId,s.storageLocation from com.mnt.erp.bean.StorageLocation s");
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

	@ModelAttribute("salesOrderDetails")
	public Map<Integer, String> populatesalesOrderDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, String>();
			listvalues = populateService
					.poPulate("select s.salesOrderId,s.salesOrderNo from com.mnt.erp.bean.SalesOrderBean s");

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

	@RequestMapping(value = "/saveDeliveryNote", method = RequestMethod.POST)
	public String SaveDelivery(
			@ModelAttribute("DeliveryNoteForm") DeliveryNote deliveryNote,
			HttpServletResponse response, Model model,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		String[] materialIds = null;
		String[] uomIds = null;
		String[] quantity = null;
		String[] storageLocation = null;
		DeliveryNoteLine deliveryNoteLine = null;
		Set<DeliveryNoteLine> deliveryNoteLinesofSet = null;

		String result = null;
		try {
			deliveryNote.setActualGI(dateService.dateFormat(
					dateService.dateParse(deliveryNote.getActualGI(), "au"),
					"au"));
			deliveryNote
					.setDeliveryNoteDate(dateService.dateFormat(
							dateService.dateParse(
									deliveryNote.getDeliveryNoteDate(), "au"),
							"au"));
			deliveryNote.setPlannedGI(dateService.dateFormat(
					dateService.dateParse(deliveryNote.getPlannedGI(), "au"),
					"au"));
			// It is used for to print the success msg in jsp
			// here we split the storageliocation details
			storageLocation = deliveryNote.getStorageLocation().split(",");
			materialIds = deliveryNote.getMaterialId().split(",");
			uomIds = deliveryNote.getDnluomid().split(",");
			quantity = deliveryNote.getQuantity().split(",");
			String batchNo[] = deliveryNote.getBatchNo().split(",");
			deliveryNoteLinesofSet = new HashSet<DeliveryNoteLine>();
			for (int i = 0; i < storageLocation.length; i++) {
				deliveryNoteLine = new DeliveryNoteLine();
				deliveryNoteLine.setMaterialId((Integer
						.parseInt(materialIds[i])));
				deliveryNoteLine.setQuantity(Float.parseFloat(quantity[i]));
				deliveryNoteLine.setStorageLoacationId((Integer
						.parseInt(storageLocation[i])));
				deliveryNoteLine.setUomId((Integer.parseInt(uomIds[i])));
				deliveryNoteLine.setBatchNo(batchNo[i]);
				deliveryNoteLinesofSet.add(deliveryNoteLine);

			}
			// here we set all the child values to paresn
			deliveryNote.setDeliveryNotes(deliveryNoteLinesofSet);
			// it is used to save the DeliveryNote Details
			msg = deliveryNoteService.saveDeliveryNote(deliveryNote);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date1 = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date1);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Delivery Note", "ROW", String
						.valueOf(deliveryNote.getDeliveryNoteId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				result = "redirect:deliveryNoteHome.mnt?list=" + "success" + "";
			} else {
				result = "redirect:deliveryNoteHome.mnt?listwar=" + "fail" + "";
			}

		} catch (Exception e) {
			msg = "Delivery Note Data is not saved properly";
			result = "redirect:deliveryNoteHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
		}

		return result;
	}

	/*
	 * ===============================================Search Delivey Note
	 * Details==========================
	 */
	@RequestMapping(value = "/searchDelivery", method = RequestMethod.GET)
	public String searchDeliveryNote(
			@ModelAttribute("DeliveryNoteForm") DeliveryNote deliveryNote,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		Iterator<Object[]> iterator = null;
		DeliveryNote dnSearchDetails = null;
		List<DeliveryNote> listofDNotes = null;
		try {
			int iid = deliveryNote.getDeliveryNoteId();
			String dbField = deliveryNote.getXmlLabel();
			String operation = deliveryNote.getOperations();
			String basicSearchId = deliveryNote.getBasicSearchId();
			listofDNotes = new ArrayList<DeliveryNote>();

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
				list = deliveryNoteService.searchDeliveryNote();

			} else {

				list = deliveryNoteService.basicSearchDeliveryservice(dbField,
						operation, dateService.dateFormat(
								dateService.dateParse(basicSearchId, "au"),
								"au"));
			}

			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				dnSearchDetails = new DeliveryNote();
				dnSearchDetails.setActualGI(dateService.dateFormat(
						dateService.dateParse((String) obj[5], "se"), "se"));
				dnSearchDetails.setDeliveryNoteId((Integer) obj[0]);
				dnSearchDetails.setDeliveryNoteDate(dateService.dateFormat(
						dateService.dateParse((String) obj[1], "se"), "se"));

				dnSearchDetails.setTotalWeight((String) obj[2]);
				Uom uom = (Uom) obj[3];
				dnSearchDetails.setUomId(String.valueOf(uom.getUom_Id()));
				dnSearchDetails.setUomName(uom.getUom());
				Status status = (Status) obj[7];
				dnSearchDetails
						.setStatusId(String.valueOf(status.getStatusId()));
				dnSearchDetails.setStatusName(status.getStatus());
				dnSearchDetails.setPlannedGI(dateService.dateFormat(
						dateService.dateParse((String) obj[4], "se"), "se"));
				dnSearchDetails.setNoofPacks((String) obj[6]);
				SalesOrderBean salesOrderBean = (SalesOrderBean) obj[8];
				dnSearchDetails.setSalesOrderId(String.valueOf(salesOrderBean
						.getSalesOrderId()));
				dnSearchDetails.setSalesOrderName(salesOrderBean
						.getSalesOrderNo());
				listofDNotes.add(dnSearchDetails);
			}
			request.setAttribute("listofDNotes", listofDNotes);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "deliveryNote";
	}

	/* ===================Edit Delivery Note Details=================== */
	@RequestMapping(value = "/deliveryNoteEdit", method = RequestMethod.GET)
	public String editDeliveryNote(
			@ModelAttribute("DeliveryNoteForm") DeliveryNote deliveryNote,
			BindingResult result, HttpServletRequest request, Model model,
			HttpServletResponse response) {

		int deliveryNoteId = 0;
		response.setCharacterEncoding("UTF-8");
		Iterator<DeliveryNote> iterator = null;
		Set<DeliveryNoteLine> listOfDnLines = null;
		Iterator<DeliveryNoteLine> dnlIterator = null;
		DeliveryNote dnForChildEdit = null;
		List<DeliveryNote> dnlforchildEdit = null;
		List<DeliveryNote> deliveryNotes = null;
		List<String> listofstrings = null;
		try {
			deliveryNoteId = Integer.parseInt(request.getParameter("dnEdit"));
			deliveryNotes = deliveryNoteService
					.editDeliveryNoteDetails(deliveryNoteId);
			dnlforchildEdit = new ArrayList<DeliveryNote>();
			iterator = deliveryNotes.iterator();
			while (iterator.hasNext()) {
				DeliveryNote obj = (DeliveryNote) iterator.next();

				deliveryNote.setActualGIEdit(dateService.dateFormat(
						dateService.dateParse(obj.getActualGI(), "se"), "se"));
				deliveryNote.setDeliveryNoteIdEdit(obj.getDeliveryNoteId());
				deliveryNote.setDeliveryNoteDateEdit(dateService.dateFormat(
						dateService.dateParse(obj.getDeliveryNoteDate(), "se"),
						"se"));
				deliveryNote.setTotalWeightEdit(obj.getTotalWeight());
				Uom uom = obj.getUomDetails();
				deliveryNote.setUomIdEdit(String.valueOf(uom.getUom_Id()));
				deliveryNote.setUomName(uom.getUom());
				Status status = obj.getStatusDetails();
				deliveryNote.setStatusIdEdit(String.valueOf(status
						.getStatusId()));
				// deliveryNote.setStatusName (status.getStatus());
				deliveryNote.setPlannedGIEdit(dateService.dateFormat(
						dateService.dateParse(obj.getPlannedGI(), "se"), "se"));
				deliveryNote.setNoofPacksEdit(obj.getNoofPacks());
				SalesOrderBean salesOrderBean = obj.getSalesOrderDetails();
				deliveryNote.setSalesOrderIdEdit(String.valueOf(salesOrderBean
						.getSalesOrderId()));

				listOfDnLines = obj.getDeliveryNotes();
			}
			dnlIterator = listOfDnLines.iterator();
			while (dnlIterator.hasNext()) {
				dnForChildEdit = new DeliveryNote();
				DeliveryNoteLine deliveryNoteLine = (DeliveryNoteLine) dnlIterator
						.next();
				dnForChildEdit.setDeliveryNoteLineidedit(String
						.valueOf(deliveryNoteLine.getDeliveryNoteLineId()));
				Material material = (Material) deliveryNoteLine
						.getMaterialDetails();
				dnForChildEdit.setMaterialIdEdit(String.valueOf(material
						.getMaterial_Id()));
				dnForChildEdit.setMaterialNameEdit(material.getMaterialName());
				dnForChildEdit.setQuantityEdit(String.valueOf(deliveryNoteLine
						.getQuantity()));
				Uom uom = (Uom) deliveryNoteLine.getUomDetails();
				dnForChildEdit.setDnluomIdEdit(String.valueOf(uom.getUom_Id()));
				dnForChildEdit.setDnluomNameEdit(uom.getUom());
				StorageLocation location = (StorageLocation) deliveryNoteLine
						.getStorageLocDetails();
				dnForChildEdit.setStorageLocationEdit(String.valueOf(location
						.getStorageLocationId()));
				dnForChildEdit.setStorageLocNameEdit(location
						.getStorageLocation());
				dnForChildEdit.setBatchNoEdit(deliveryNoteLine.getBatchNo());
				dnlforchildEdit.add(dnForChildEdit);
			}

			listofstrings = new ArrayList<String>();
			listofstrings.add("1");
			request.setAttribute("editvalues", listofstrings);
			request.setAttribute("deliverylindetails", dnlforchildEdit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deliveryNote";

	}

	@RequestMapping(value = "/deliveryUpdate", method = RequestMethod.POST)
	public String deliveryNoteUpdate(
			@ModelAttribute("DeliveryNoteForm") DeliveryNote deliveryNoteo,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String checked = "", s1 = "0", s2 = "1";
		int ss = 0;
		DeliveryNoteLine deliveryNoteLine = null;
		Set<DeliveryNoteLine> deliveryNoteLines = null;
		List<DeliveryNoteLine> childDelete = null;

		try {
			DeliveryNote deliveryNote = new DeliveryNote();

			model.addAttribute("DeliveryNoteForm", new DeliveryNote());
			deliveryNoteLines = new HashSet<DeliveryNoteLine>();
			deliveryNote.setDeliveryNoteId(deliveryNoteo
					.getDeliveryNoteIdEdit());
			deliveryNote.setActualGI(dateService.dateFormat(dateService
					.dateParse(deliveryNoteo.getActualGIEdit(), "au"), "au"));
			deliveryNote.setPlannedGI(dateService.dateFormat(dateService
					.dateParse(deliveryNoteo.getPlannedGIEdit(), "au"), "au"));
			deliveryNote.setDeliveryNoteDate(dateService.dateFormat(
					dateService.dateParse(
							deliveryNoteo.getDeliveryNoteDateEdit(), "au"),
					"au"));
			deliveryNote.setUomId(deliveryNoteo.getUomIdEdit());
			deliveryNote.setSalesOrderId(deliveryNoteo.getSalesOrderIdEdit());
			deliveryNote.setNoofPacks(deliveryNoteo.getNoofPacksEdit());
			deliveryNote.setStatusId(deliveryNoteo.getStatusIdEdit());
			deliveryNote.setTotalWeight(deliveryNoteo.getTotalWeightEdit());
			childDelete = new ArrayList<DeliveryNoteLine>();

			String deliverylineid = deliveryNoteo.getDeliveryNoteLineidedit();

			String[] dlineIdArray = deliverylineid.split(",");

			String[] materialIdEdit = deliveryNoteo.getMaterialIdEdit().split(
					",");
			String[] dnluomEdit = deliveryNoteo.getDnluomIdEdit().split(",");
			String[] stLocEdit = deliveryNoteo.getStorageLocationEdit().split(
					",");
			String[] quantity = deliveryNoteo.getQuantityEdit().split(",");
			String[] bNo = deliveryNoteo.getBatchNoEdit().split(",");
			if (materialIdEdit != null) {
				for (int i = 0; i < materialIdEdit.length; i++) {
					int dllineId = Integer.parseInt(dlineIdArray[i]);
					if (dllineId == 0) {
						deliveryNoteLine = new DeliveryNoteLine();
						deliveryNoteLine.setDeliveryNoteLineId(Integer
								.parseInt(dlineIdArray[i]));
						deliveryNoteLine.setMaterialId(Integer
								.parseInt(materialIdEdit[i]));
						deliveryNoteLine.setUomId(Integer
								.parseInt(dnluomEdit[i]));
						deliveryNoteLine.setStorageLoacationId(Integer
								.parseInt(stLocEdit[i]));
						deliveryNoteLine.setQuantity(Float
								.parseFloat(quantity[i]));
						deliveryNoteLine.setBatchNo(bNo[i]);
						deliveryNoteLine.setMaterialDetails(new Material());
						deliveryNoteLine.setUomDetails(new Uom());
						deliveryNoteLine
								.setStorageLocDetails(new StorageLocation());
						deliveryNoteLines.add(deliveryNoteLine);
					} else {
						deliveryNoteLine = new DeliveryNoteLine();
						deliveryNoteLine.setDeliveryNoteLineId(Integer
								.parseInt(dlineIdArray[i]));
						deliveryNoteLine.setMaterialId(Integer
								.parseInt(materialIdEdit[i]));
						deliveryNoteLine.setUomId(Integer
								.parseInt(dnluomEdit[i]));
						deliveryNoteLine.setStorageLoacationId(Integer
								.parseInt(stLocEdit[i]));
						deliveryNoteLine.setQuantity(Float
								.parseFloat(quantity[i]));
						deliveryNoteLine.setBatchNo(bNo[i]);
						deliveryNoteLine.setMaterialDetails(new Material());
						deliveryNoteLine.setUomDetails(new Uom());
						deliveryNoteLine
								.setStorageLocDetails(new StorageLocation());

						ss = Integer.parseInt(dlineIdArray[i]);

						checked = request.getParameter("Checkdelete" + ss);

						if (checked.equals("0")) {
							deliveryNoteLines.add(deliveryNoteLine);
						}

						/*
						 * if (s2.equals(checked)){ DeliveryNoteLine noteLine =
						 * new DeliveryNoteLine();
						 * noteLine.setDeliveryNoteLineId(ss);
						 * 
						 * // deliveryNote.setDeliveryNotes(deliveryNoteLines);
						 * childDelete.add(deliveryNoteLine); //
						 * rfqservice.deleteChildDetailsService(ss); }
						 */
						else {
							DeliveryNoteLine noteLine = new DeliveryNoteLine();
							noteLine.setDeliveryNoteLineId(ss);
							childDelete.add(deliveryNoteLine);
						}

					}

				}
				deliveryNote.setDeliveryNotes(deliveryNoteLines);
				deliveryNote.setSalesOrderDetails(new SalesOrderBean());
				deliveryNote.setUomDetails(new Uom());
				deliveryNoteService.deleteChildRecords(childDelete);
				msg = deliveryNoteService.updateDeliveryDetails(deliveryNote);

				if (msg.equals("S")) {
					request.setAttribute("dlNoteUpdateSuccess",
							"Delivery Note Data is updated successfully");
				} else {
					request.setAttribute("dlNoteUpdateFail",
							"Delivery Note Data is not updated properly");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("dlNoteUpdateFail",
					"Delivery Note Data is not updated properly");
		}

		return "deliveryNote";
	}

	@RequestMapping(value = "/deliveryNoteDelete", method = RequestMethod.GET)
	public String deleteDeliveryNote(
			@ModelAttribute("DeliveryNoteForm") DeliveryNote deliveryNote,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int deleId = Integer.parseInt(request.getParameter("dndelId"));
			msg = deliveryNoteService.deleteDeliveryNote(deleId);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date1 = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date1);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Delivery Note", "ROW", String
						.valueOf(deleId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				request.setAttribute("dlNoteDeleteSuccess",
						"Delivery Note Data is deleted successfully");
			} else {
				request.setAttribute("dlNoteDeleteFail",
						"Delivery Note Data is not deleted properly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "deliveryNote";
	}
	
	
	@RequestMapping(value = "/deliveryAdvanceSearch", method = RequestMethod.GET)
	public String deliveryAdvanceSearch(
			@ModelAttribute("DeliveryNoteForm") DeliveryNote deliveryNote,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<DeliveryNote> stList = new ArrayList<DeliveryNote>();
		List<DeliveryNote> refList = new ArrayList<DeliveryNote>();
		List<Object[]> objArray = null;
		try {
			deliveryNote.setAdvanceSearchHidden(1);
			objArray = xmlService.populateXml("deliveryNoteId");
			for (Object[] object : objArray) {
				DeliveryNote s = new DeliveryNote();
				if ((boolean) object[2].equals("false")) {
					if((boolean) object[3].equals("false")){
						s.setDbField((String) object[0]);
						s.setLabels((String) object[1]);
						stList.add(s);
					}else{
						s.setDbField((String) object[0]);
						s.setLabels((String) object[1]);
						stList.add(s);
					}
					
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

		return "deliveryNote";
	}

	@RequestMapping(value = "/deliveryAdvanceSearchOperations", method = RequestMethod.GET)
	public String deliveryAdvanceSearchOperations(
			@ModelAttribute("DeliveryNoteForm") DeliveryNote deliveryNote,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {
		List<DeliveryNote> listofDNotes = null;
		List<Object[]> objectsArray = null;
		Iterator<Object[]> iterator = null;
		response.setCharacterEncoding("UTF-8");
		listofDNotes = new ArrayList<DeliveryNote>();
		String columns = deliveryNote.getDbField();
		String operations = deliveryNote.getAsOpts();
		String advanceSearchText = deliveryNote.getAdvanceSearchText();
		if (advanceSearchText != null) {
			if (advanceSearchText.length() != 0) {
				objectsArray = deliveryNoteService.deliveryadvance(columns,
						operations, advanceSearchText);
			} else {
				objectsArray = deliveryNoteService.getDelivery("ALL");
			}
		}
		if (objectsArray != null) {
			iterator = objectsArray.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				DeliveryNote dnSearchDetails = new DeliveryNote();
				dnSearchDetails.setActualGI(dateService.dateFormat(
						dateService.dateParse((String) obj[5], "se"), "se"));
				dnSearchDetails.setDeliveryNoteId((Integer) obj[0]);
				dnSearchDetails.setDeliveryNoteDate(dateService.dateFormat(
						dateService.dateParse((String) obj[1], "se"), "se"));
				dnSearchDetails.setTotalWeight((String) obj[2]);
				Uom uom = (Uom) obj[3];
				dnSearchDetails.setUomId(String.valueOf(uom.getUom_Id()));
				dnSearchDetails.setUomName(uom.getUom());
				Status status = (Status) obj[7];
				dnSearchDetails
						.setStatusId(String.valueOf(status.getStatusId()));
				dnSearchDetails.setStatusName(status.getStatus());
				dnSearchDetails.setPlannedGI(dateService.dateFormat(
						dateService.dateParse((String) obj[4], "se"), "se"));
				dnSearchDetails.setNoofPacks((String) obj[6]);
				SalesOrderBean salesOrderBean = (SalesOrderBean) obj[8];
				dnSearchDetails.setSalesOrderId(String.valueOf(salesOrderBean
						.getSalesOrderId()));
				dnSearchDetails.setSalesOrderName(salesOrderBean
						.getSalesOrderNo());
				listofDNotes.add(dnSearchDetails);

			}
		}
		request.setAttribute("listofDNotes", listofDNotes);
		request.setAttribute("Adv", "Adv");
		deliveryNote.setAdvanceSearchHidden(0);
		return "deliveryNote";
	}

	

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "deliveryNoteId";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
