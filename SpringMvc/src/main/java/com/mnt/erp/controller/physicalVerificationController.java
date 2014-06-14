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

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.AuditLogDetail;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.VerificationtypeBean;
import com.mnt.erp.bean.physicalVerification;
import com.mnt.erp.bean.physicalVerificationLine;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.physicalVerificationService;

/**
 * @author kirangangone
 * 
 */
@Controller
public class physicalVerificationController {

	@Autowired
	physicalVerificationService pVService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;
	@Autowired
	DateConversionService dateService;

	Object[] objects = null;
	Object[] objects1 = null;
	String msg = null;
	Map<Integer, String> map = null;
	List<Object[]> list = null;
	List<Object[]> listTotal = null;
	Iterator<Object[]> iterator = null;
	Iterator<Object[]> iteratorTotal = null;
	List<Object> addPhy = null;
	HttpSession session = null;
	Date date = new Date();
	String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
			.format(date);

	@RequestMapping(value = "/physicalVerification", method = RequestMethod.GET)
	public ModelAndView getPhysicalVerification(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige(
				"physicalVerification.mnt", session.getAttribute("userId")
						.toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("physicalVerificationHome",
				"physicalVerificationCommand", new physicalVerification());

	}

	@ModelAttribute("materialSelect")
	public Map<Integer, String> materialSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = pVService.materialIdGet();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
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
			list = pVService.uomIdGet();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("Selectverification")
	public Map<Integer, String> verificationSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = pVService.verificationTypeIdSelect();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("SelectOrg")
	public Map<Integer, String> orgSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = pVService.orgIdSelect();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("SelectPlant")
	public Map<Integer, String> PlantSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = pVService.plantIdSelect();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("SelectStorageLocation")
	public Map<Integer, String> storageLocationSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = pVService.storageLocationIdSelect();
			iterator = list.iterator();

			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "physicalId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/orgOnChange", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> getOrganisationDetails(HttpServletResponse response,
			HttpServletRequest request) {

		String orgId = request.getParameter("orgId");

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {

			list = pVService.getplantIdForOrg(orgId);

			iterator = list.iterator();
			// map.put(0,"-SELECT-");
			while (iterator.hasNext()) {

				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return map;
	}

	@RequestMapping(value = "/plantOnChange", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> getPlantDetails(HttpServletResponse response,
			HttpServletRequest request) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		String plantId = request.getParameter("plantId");
		try {

			list = pVService.getLocationIdForOrg(plantId);

			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}
		} catch (Exception e) {

			e.printStackTrace();

		}
		return map;
	}

	@RequestMapping(value = "/storageLocationOnChange", method = RequestMethod.POST)
	public @ResponseBody
	String getGoodDetails(HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		String jsondataChild = "";
		String storageId = request.getParameter("storageId");
		int count = 1;
		List<physicalVerificationLine> listJson = new ArrayList<physicalVerificationLine>();
		try {

			list = pVService.getGoodsIdForOrg(storageId);

			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				int materialId = (Integer) objects[0];
				String batchNo = (String) objects[1];
				Material mName = (Material) objects[2];
				float qty = (Float) objects[3];
				Uom uom = (Uom) objects[4];
				String uomId = (String) objects[5];
				String UomName = uom.getUom();
				String materialName = mName.getMaterialName();

				physicalVerificationLine qLine = new physicalVerificationLine();
				qLine.setMaterialId(String.valueOf(materialId));
				qLine.setMaterialName(materialName);
				qLine.setBatchNo(batchNo);
				qLine.setUomId(uomId);
				qLine.setUomName(UomName);
				qLine.setBookQty(String.valueOf(qty));
				qLine.setCount(count);
				listJson.add(qLine);
				count++;
			}
			ObjectMapper mapper = new ObjectMapper();
			jsondataChild = mapper.writeValueAsString(listJson);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return jsondataChild;

	}

	@RequestMapping(value = "/PhysicalNoCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkPhysicalDuplicateAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		Long beforephysicalVerificationValue = null;
		try {

			String beforeverificationNo = request
					.getParameter("verificationNo");
			beforephysicalVerificationValue = pVService
					.checkPhysicalVerification(beforeverificationNo);
			physicalVerification p = new physicalVerification();
			if (beforephysicalVerificationValue != 0) {
				p.setPhysicalVerificationAddDuplicate(1);
				/*
				 * request.setAttribute("purchaseDuplicateAdd",
				 * "Warning ! @Physical Verification@ Duplicate values are not allowed"
				 * );
				 */
				p.setVerificationNo("");
				msa = "Warning ! Physical Verication no aleardy exists. Please try some other no";
			}
			if (beforephysicalVerificationValue == 0) {
				p.setPhysicalVerificationAddDuplicate(0);
				msa = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			physicalVerification purchaseOrder = null;
		}
		return msa;
	}

	@RequestMapping(value = "/verificationNoEditCheckEdit", method = RequestMethod.POST)
	public @ResponseBody
	String checkPurchaseDuplicateEdit(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforephyVerifyNoValue = 0;
		response.setCharacterEncoding("UTF-8");
		try {

			String verificationNoEdit = request
					.getParameter("verificationNoEdit");
			int verificationIdEdit = Integer.parseInt(request
					.getParameter("verificationIdEdit"));
			beforephyVerifyNoValue = pVService.updateCheckPhysicalVerification(
					verificationNoEdit, verificationIdEdit);
			physicalVerification p = new physicalVerification();
			if (beforephyVerifyNoValue != 0) {
				p.setPhysicalVerificationEditDuplicate(1);
				request.setAttribute("purchaseDuplicateAddEdit",
						"Warning ! Physical Verication no aleardy exists. Please try some other no");
				p.setVerificationNo("");
				msa = "Warning ! Physical Verication no aleardy exists. Please try some other no";
			}
			if (beforephyVerifyNoValue == 0) {
				p.setPhysicalVerificationEditDuplicate(1);
				msa = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			physicalVerification physicalVerification = null;
		}
		return msa;
	}

	@RequestMapping(value = "/physicalVerificationAdvanceSearch", method = RequestMethod.GET)
	public String physicalVerificationAdvanceSearch(
			@ModelAttribute("physicalVerificationCommand") physicalVerification physicalVeri,
			HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");

		String name1 = "physicalId", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		// Vendor v=null;
		List<physicalVerification> physicalVerificationList = null;
		physicalVerificationList = new ArrayList();
		physicalVeri.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			Iterator it = returnString.iterator();
			for (Object[] object : returnString) {
				physicalVerification p = new physicalVerification();

				s1 = (String) object[0];
				s2 = (String) object[1];
				p.setFirstLabel(s1);
				p.setSecondLabel(s2);
				physicalVerificationList.add(p);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("physicalVerificationAdvance",
				physicalVerificationList);

		return "physicalVerificationHome";
	}

	@RequestMapping(value = "/PhysicalAdvanceSearchOperations", method = RequestMethod.GET)
	public String purchaseAdvanceSearchOperations(
			@ModelAttribute("physicalVerificationCommand") physicalVerification physicalVer,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String columns = physicalVer.getFirstLabel();
		String operations = physicalVer.getOperations1();
		String advanceSearchText = physicalVer.getAdvanceSearchText();
		List<physicalVerification> physicalVerList = new ArrayList<physicalVerification>();
		if (advanceSearchText.length() != 0 && advanceSearchText != null) {
			list = pVService.getPhysicalVerificationAdvance(columns,
					operations, advanceSearchText);
		} else {
			list = pVService.basicSearchPV();
		}
		try {
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				physicalVerification pv = new physicalVerification();
				pv.setVerificationId(((Integer) objects[0]));
				pv.setVerificationNo((String) objects[1]);
				Organization o = (Organization) objects[2];
				pv.setOrgId(o.getOrgName());
				Plant plant = (Plant) objects[3];
				pv.setPlantId(plant.getPlantName());
				StorageLocation s = (StorageLocation) objects[4];
				pv.setStorageLocaionId(s.getStorageLocation());
				pv.setVerificationDate((String) objects[5]);
				VerificationtypeBean vv = (VerificationtypeBean) objects[7];
				pv.setVerificationTypeId(vv.getVerificationtype());
				physicalVerList.add(pv);

			}
			physicalVer.setAdvanceSearchHidden(0);
			request.setAttribute("physicalVerificationListAdvanced",
					physicalVerList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "physicalVerificationHome";

	}

	@RequestMapping(value = "/physicalVerificationAdd", method = RequestMethod.POST)
	public String addPhysicalVerificationOrder(
			@ModelAttribute("physicalVerificationCommand") physicalVerification physicalVerificationobj,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {
		response.setCharacterEncoding("UTF-8");
		String physicalSave = null;
		List<AuditLog> auditLogList = new ArrayList<AuditLog>();
		java.util.Set<physicalVerificationLine> physicalVerificationLine = new HashSet<physicalVerificationLine>();
		String[] materialId = physicalVerificationobj.getMaterialIdChild();
		String[] batchNo = physicalVerificationobj.getBatchNoChild();
		String[] bookQty = physicalVerificationobj.getBookQtyChild();
		String[] physicalQty = physicalVerificationobj.getPhysicalQtyChild();
		String[] uomId = physicalVerificationobj.getUomIdChild();
		HttpSession session = request.getSession();
		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(date);

		physicalVerification physicalVerificationDetails = (physicalVerification) physicalVerificationobj;
		physicalVerificationDetails
				.setVerificationDate(dateService.dateFormat(dateService
						.dateParse(physicalVerificationDetails
								.getVerificationDate(), "au"), "au"));
		if (materialId != null) {

			for (int n = 0; n < materialId.length; n++) {
				physicalVerificationLine pVLineDetails = new physicalVerificationLine();
				pVLineDetails.setMaterialId(materialId[n]);
				pVLineDetails.setBatchNo(batchNo[n]);
				pVLineDetails.setBookQty(bookQty[n]);
				pVLineDetails.setPhysicalQty(physicalQty[n]);
				pVLineDetails.setUomId(uomId[n]);

				physicalVerificationLine.add(pVLineDetails);
			}

			physicalVerificationDetails
					.setPhysicalVerificationFk(physicalVerificationLine);
		}

		Long checkPhysical = pVService
				.checkPhysicalVerification(physicalVerificationobj
						.getVerificationNo());
		if (checkPhysical == 0) {
			try {
				List<Object> msg = pVService
						.addPhysicalVerification(physicalVerificationDetails);
				if (msg == addPhy) {
					String fail = "Error ! : Physical Verification data is not saved properly";
					request.setAttribute("Addfail", fail);
					return "physicalVerificationHome";
				} else {
					Iterator<Object> itrr = msg.iterator();
					int count = 0;
					if (itrr.hasNext()) {
						Object oo = itrr.next();
						physicalVerification ccb = (physicalVerification) oo;
						AuditLog audit = new AuditLog();
						audit.setUserId(session.getAttribute("userId")
								.toString());
						audit.setOperation("A");
						audit.setObjectChanged("ROW");
						audit.setObjectType("PhysicalVerification");
						audit.setStatus("1");
						audit.setTimeStamp(modifiedDate);
						audit.setObjectId(Integer.toString(ccb
								.getVerificationId()));
						auditLogList.add(audit);
						Set<physicalVerificationLine> pp = null;
						pp = (Set<com.mnt.erp.bean.physicalVerificationLine>) ccb
								.getPhysicalVerificationFk();
						Iterator<physicalVerificationLine> itrrr = pp
								.iterator();
						while (itrrr.hasNext()) {
							Object obj = itrrr.next();
							physicalVerificationLine ca = (physicalVerificationLine) obj;

							AuditLog audit1 = new AuditLog();
							audit1.setUserId(session.getAttribute("userId")
									.toString());
							audit1.setOperation("A");
							audit1.setObjectChanged("PhysicalVerificationLine");
							audit1.setObjectType("ROW");
							audit1.setStatus("1");
							audit1.setTimeStamp(modifiedDate);
							audit1.setUserName(session.getAttribute("userName")
									.toString());
							audit1.setObjectId(Integer.toString(ca
									.getVerificationLineId()));
							auditLogList.add(audit1);
						}

					}

					String resultofauditadd = auditLogService
							.saveAuditLogForAdd(auditLogList);
					if (resultofauditadd.equalsIgnoreCase("success")) {
						physicalSave = "$uccess : Physical Verification Data is saved successfully";

						return "redirect:physicalVerification.mnt?addPV="
								+ physicalSave + "";
					} else {
						String fail = "Error ! : Audit Log data is not saved properly";
						request.setAttribute("fail", fail);
						return "physicalVerificationHome";
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				String fail = "Error ! : Physical Verification data is not saved properly";
				request.setAttribute("Addfail", fail);
				return "physicalVerificationHome";
			}
		} else {
			physicalVerificationobj.setPvId(1);
			request.setAttribute("physicalSave",
					"Warning ! Physical Verication no aleardy exists. Please try some other name");
			request.setAttribute("physicalVerificationLine",
					physicalVerificationLine);

			return "physicalVerificationHome";

		}
	}

	@RequestMapping(value = "/physicalVerificationSearch", method = RequestMethod.GET)
	public String searchScheduling(
			@ModelAttribute("physicalVerificationCommand") physicalVerification physicalVerificationSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(date);
		List<physicalVerification> physicalVerif = new ArrayList<physicalVerification>();
		try {
			// String pvid = physicalVerificationSearch.getVerificationNo();
			/* String status = "Y"; */
			String dbField = physicalVerificationSearch.getXmlLabel();
			String operation = physicalVerificationSearch.getOperations();
			String basicSearchId = physicalVerificationSearch
					.getBasicSearchId();

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
				list = pVService.basicSearchPV();

			} else {

				// list = custService.searchCustomerWithId(cid, status);
				list = pVService.basicSearchPhysicalVerification(dbField,
						operation, basicSearchId);
			}
			iterator = list.iterator();

			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				physicalVerification pv = new physicalVerification();
				pv.setVerificationId(((Integer) objects[0]));
				pv.setVerificationNo((String) objects[1]);
				Organization o = (Organization) objects[2];
				pv.setOrgId(o.getOrgName());
				Plant plant = (Plant) objects[3];
				pv.setPlantId(plant.getPlantName());
				StorageLocation s = (StorageLocation) objects[4];
				pv.setStorageLocaionId(s.getStorageLocation());
				pv.setVerificationDate(dateService.dateFormat(
						dateService.dateParse((String) objects[5], "se"), "se"));
				VerificationtypeBean vv = (VerificationtypeBean) objects[7];
				pv.setVerificationTypeId(vv.getVerificationtype());
				physicalVerif.add(pv);

			}
			// purchaseOrderSearch.setPuEditId(0);

			request.setAttribute("physicalVerificationList", physicalVerif);
			auditLogService.setAuditLogSave(session.getAttribute("userId")
					.toString(), "S", "PhysicalVerification", "TABLE", "0",
					"1", modifiedDate, session.getAttribute("userName")
							.toString());
		} catch (Exception e) {
			auditLogService.setAuditLogSave(session.getAttribute("userId")
					.toString(), "S", "PhysicalVerification", "TABLE", "0",
					"0", modifiedDate, session.getAttribute("userName")
							.toString());
			e.printStackTrace();
		}
		return "physicalVerificationHome";

	}

	@RequestMapping(value = "/PhysicalVerificationEdit", method = RequestMethod.GET)
	public String physicalVerificationEdit(
			@ModelAttribute("physicalVerificationCommand") physicalVerification physicalVerificationEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(date);
		List<physicalVerification> physicalVerificationEditList = new ArrayList<physicalVerification>();
		java.util.Set<physicalVerificationLine> physicalVerificationLineEditList = new HashSet<physicalVerificationLine>();

		int purcId = Integer.parseInt(request.getParameter("verificationId"));

		// String status = "Y";
		try {

			List<Object> l = pVService.editPVWithId(purcId);
			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				physicalVerification ccb = (physicalVerification) oo;
				physicalVerificationEdit.setVerificationIdEdit(ccb
						.getVerificationId());
				physicalVerificationEdit.setVerificationNoEdit(ccb
						.getVerificationNo());
				physicalVerificationEdit.setVerificationTypeIdEdit(ccb
						.getVerificationTypeId());
				physicalVerificationEdit.setOrgIdEdit(ccb.getOrgId());
				physicalVerificationEdit.setPlantIdEdit(ccb.getPlantId());
				physicalVerificationEdit.setStorageLocaionIdEdit(ccb
						.getStorageLocaionId());
				physicalVerificationEdit.setVerificationDateEdit(dateService
						.dateFormat(dateService.dateParse(
								ccb.getVerificationDate(), "se"), "se"));

				physicalVerificationEdit.setPvEditId(1);
				// physicalVerificationEdit.setPhysicalVerificationListType(physicalVerificationEditList);

				java.util.Set<physicalVerificationLine> listEdit = ccb
						.getPhysicalVerificationFk();
				Iterator<physicalVerificationLine> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					physicalVerificationLine cc = (physicalVerificationLine) o;
					physicalVerificationLine cMultiple = new physicalVerificationLine();
					cMultiple.setVerificationLineId(cc.getVerificationLineId());
					cMultiple.setVerificationId(cc.getVerificationId());
					cMultiple.setMaterialId(cc.getMaterialId());
					cMultiple.setBatchNo(cc.getBatchNo());
					cMultiple.setBookQty(cc.getBookQty());
					cMultiple.setPhysicalQty(cc.getPhysicalQty());
					cMultiple.setUomId(cc.getUomId());

					Material material = (Material) cc.getMaterialDetails();
					cMultiple.setMaterialName(material.getMaterialName());
					Uom uom = (Uom) cc.getUomDetails();
					cMultiple.setUomName(uom.getUom());

					physicalVerificationLineEditList.add(cMultiple);

				}
				physicalVerificationEdit
						.setPhysicalVerificationFk(physicalVerificationLineEditList);

				// setPurchaseOrderLine(physicalVerificationLineEditList);
				physicalVerificationEditList.add(physicalVerificationEdit);
			}

			// physicalVerificationEdit.setPhysicalVerificationListType(physicalVerificationEditList);
			auditLogService.setAuditLogSave(session.getAttribute("userId")
					.toString(), "E", "PhysicalVerification", "ROW", request
					.getParameter("verificationId"), "1", modifiedDate, session
					.getAttribute("userName").toString());
			request.setAttribute("physicalVerificationEditList",
					physicalVerificationEditList);
			session.setAttribute("physicalVerificationEditListSess",
					physicalVerificationEditList);
			session.setAttribute("physicalVerificationLineEditListSess",
					physicalVerificationLineEditList);
			request.setAttribute("physicalVerificationLineEditList",
					physicalVerificationLineEditList);

		} catch (Exception e) {
			auditLogService.setAuditLogSave(session.getAttribute("userId")
					.toString(), "E", "PhysicalVerification", "ROW", request
					.getParameter("verificationId"), "0", modifiedDate, session
					.getAttribute("userName").toString());
			e.printStackTrace();
		}
		return "physicalVerificationHome";
	}

	@RequestMapping(value = "/physicalVerificationUpdate", method = RequestMethod.POST)
	public String physicalVerificationUpdate(
			@ModelAttribute("physicalVerificationCommand") physicalVerification physicalVerificationUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession sess = request.getSession();
		List<AuditLog> auditLog = new ArrayList<AuditLog>();
		java.util.Set<AuditLogDetail> auditLogDetailLine = new HashSet<AuditLogDetail>();
		// List<physicalVerification> physicalVerificationEditList = new
		// ArrayList<physicalVerification>();
		java.util.Set<physicalVerificationLine> physicalVerificationUpList = new HashSet<physicalVerificationLine>();
		physicalVerificationUpdate.setVerificationId(physicalVerificationUpdate
				.getVerificationIdEdit());
		physicalVerificationUpdate.setVerificationNo(physicalVerificationUpdate
				.getVerificationNoEdit());
		physicalVerificationUpdate
				.setVerificationTypeId(physicalVerificationUpdate
						.getVerificationTypeIdEdit());
		physicalVerificationUpdate.setOrgId(physicalVerificationUpdate
				.getOrgIdEdit());
		physicalVerificationUpdate.setPlantId(physicalVerificationUpdate
				.getPlantIdEdit());
		physicalVerificationUpdate
				.setStorageLocaionId(physicalVerificationUpdate
						.getStorageLocaionIdEdit());
		physicalVerificationUpdate
				.setVerificationDate(physicalVerificationUpdate
						.getVerificationDateEdit());

		List<physicalVerification> obj = (List<physicalVerification>) sess
				.getAttribute("physicalVerificationEditListSess");
		int auditChanged = 0;

		Set<physicalVerificationLine> objLine = (Set<physicalVerificationLine>) sess
				.getAttribute("physicalVerificationLineEditListSess");
		// Iterator<physicalVerificationLine> ii=objLine.iterator();
		String materialIdSess = "";
		String batchNoSess = "";
		String bookQtySess = "";
		String physicalQtySess = "";
		String uomIdSess = "";
		for (physicalVerificationLine physicalVerificationLine : objLine) {
			materialIdSess = materialIdSess
					+ physicalVerificationLine.getMaterialId() + ",";
			batchNoSess = batchNoSess + physicalVerificationLine.getBatchNo()
					+ ",";
			bookQtySess = bookQtySess + physicalVerificationLine.getBookQty()
					+ ",";
			physicalQtySess = physicalQtySess
					+ physicalVerificationLine.getPhysicalQty() + ",";
			uomIdSess = uomIdSess + physicalVerificationLine.getUomId() + ",";
		}
		String[] materialIdSessCompare = materialIdSess.split(",");
		String[] batchNoSessCompare = batchNoSess.split(",");
		String[] bookQtySessCompare = bookQtySess.split(",");
		String[] physicalQtySessCompare = physicalQtySess.split(",");
		String[] uomIdSessCompare = uomIdSess.split(",");

		int compareValue = materialIdSessCompare.length, comp = 0, compCheck = 0;
		AuditLog auditLogI = new AuditLog();
		auditLogI.setUserId(sess.getAttribute("userId").toString());
		auditLogI.setOperation("M");
		auditLogI.setObjectChanged("Physical Verfication");
		auditLogI.setObjectType("ROW");
		auditLogI.setObjectId(Integer.toString(physicalVerificationUpdate
				.getVerificationIdEdit()));
		auditLogI.setStatus("1");
		auditLogI.setTimeStamp(modifiedDate);
		auditLogI.setUserName(sess.getAttribute("userName").toString());

		if (!physicalVerificationUpdate.getVerificationNoEdit()
				.equalsIgnoreCase(obj.get(0).getVerificationNoEdit())) {

			AuditLogDetail auditLogDetails = new AuditLogDetail();
			auditLogDetails.setOldValue(obj.get(0).getVerificationNoEdit());
			auditLogDetails.setNewValue(physicalVerificationUpdate
					.getVerificationNoEdit());
			auditLogDetailLine.add(auditLogDetails);
			auditChanged = auditChanged + 1;

		}
		if (!physicalVerificationUpdate.getVerificationTypeIdEdit()
				.equalsIgnoreCase(obj.get(0).getVerificationTypeIdEdit())) {
			AuditLogDetail auditLogDetails = new AuditLogDetail();
			auditLogDetails.setOldValue(obj.get(0).getVerificationNoEdit());
			auditLogDetails.setNewValue(physicalVerificationUpdate
					.getVerificationNoEdit());
			auditLogDetailLine.add(auditLogDetails);
			auditChanged = auditChanged + 1;
		}
		if (!physicalVerificationUpdate.getOrgIdEdit().equalsIgnoreCase(
				obj.get(0).getOrgIdEdit())) {
			AuditLogDetail auditLogDetails = new AuditLogDetail();
			auditLogDetails.setOldValue(obj.get(0).getOrgIdEdit());
			auditLogDetails.setNewValue(physicalVerificationUpdate
					.getOrgIdEdit());
			auditLogDetailLine.add(auditLogDetails);
			auditChanged = auditChanged + 1;
		}
		if (!physicalVerificationUpdate.getPlantIdEdit().equalsIgnoreCase(
				obj.get(0).getPlantIdEdit())) {
			AuditLogDetail auditLogDetails = new AuditLogDetail();
			auditLogDetails.setOldValue(obj.get(0).getPlantIdEdit());
			auditLogDetails.setNewValue(physicalVerificationUpdate
					.getPlantIdEdit());
			auditLogDetailLine.add(auditLogDetails);
			auditChanged = auditChanged + 1;
		}
		if (!physicalVerificationUpdate.getStorageLocaionIdEdit()
				.equalsIgnoreCase(obj.get(0).getStorageLocaionIdEdit())) {
			AuditLogDetail auditLogDetails = new AuditLogDetail();
			auditLogDetails.setOldValue(obj.get(0).getStorageLocaionIdEdit());
			auditLogDetails.setNewValue(physicalVerificationUpdate
					.getStorageLocaionIdEdit());
			auditLogDetailLine.add(auditLogDetails);
			auditChanged = auditChanged + 1;
		}

		if (!physicalVerificationUpdate.getVerificationDateEdit()
				.equalsIgnoreCase(obj.get(0).getVerificationDateEdit())) {
			AuditLogDetail auditLogDetails = new AuditLogDetail();
			auditLogDetails.setOldValue(obj.get(0).getVerificationDateEdit());
			auditLogDetails.setNewValue(physicalVerificationUpdate
					.getVerificationDateEdit());
			auditLogDetailLine.add(auditLogDetails);
			auditChanged = auditChanged + 1;
		}
		if (auditChanged > 0) {
			auditLogI.setAuditLogDetails(auditLogDetailLine);
			auditLogService.addAuditLog(auditLogI);
		}

		int[] verificationLineIdChildEdit = physicalVerificationUpdate
				.getVerificationLineIdChildEdit();
		String[] materialId = physicalVerificationUpdate
				.getMaterialIdChildEdit();
		String[] batchNo = physicalVerificationUpdate.getBatchNoChildEdit();
		String[] bookQty = physicalVerificationUpdate.getBookQtyChildEdit();
		String[] physicalQty = physicalVerificationUpdate
				.getPhysicalQtyChildEdit();
		String[] uomId = physicalVerificationUpdate.getUomIdChildEdit();
		String purcUpdate = null;

		try {

			if (materialId != null) {

				for (int n = 0; n < materialId.length; n++) {
					int puId = verificationLineIdChildEdit[n];

					if (puId == 0) {
						physicalVerificationLine cbd = new physicalVerificationLine();

						cbd.setMaterialId(materialId[n]);
						cbd.setBatchNo(batchNo[n]);
						cbd.setBookQty(bookQty[n]);
						cbd.setPhysicalQty(physicalQty[n]);
						cbd.setUomId(uomId[n]);
						physicalVerificationUpList.add(cbd);

						AuditLog auditLogILine = new AuditLog();
						auditLogILine.setUserId(sess.getAttribute("userId")
								.toString());
						auditLogILine.setOperation("A");
						auditLogILine
								.setObjectChanged("Physical Verfication Line");
						auditLogILine.setObjectType("ROW");
						auditLogILine.setObjectId(Integer
								.toString(physicalVerificationUpdate
										.getVerificationIdEdit()));
						auditLogILine.setStatus("1");
						auditLogILine.setTimeStamp(modifiedDate);
						auditLogILine.setUserName(sess.getAttribute("userName")
								.toString());
						auditLogService.addAuditLog(auditLogILine);

					} else {

						int CheckPhysical = Integer.parseInt(request
								.getParameter("CheckPhysical"
										+ verificationLineIdChildEdit[n]));
						physicalVerificationLine cbd = new physicalVerificationLine();
						cbd.setVerificationLineId(verificationLineIdChildEdit[n]);
						cbd.setVerificationId(physicalVerificationUpdate
								.getVerificationIdEdit());

						cbd.setMaterialId(materialId[n]);
						cbd.setBatchNo(batchNo[n]);
						cbd.setBookQty(bookQty[n]);
						cbd.setPhysicalQty(physicalQty[n]);
						cbd.setUomId(uomId[n]);
						if (comp < compareValue) {

							if (!materialIdSessCompare[comp]
									.equalsIgnoreCase(materialId[n])) {

								AuditLogDetail auditLogDetails = new AuditLogDetail();
								auditLogDetails
										.setOldValue(materialIdSessCompare[comp]);
								auditLogDetails.setNewValue(materialId[n]);
								auditLogDetailLine.add(auditLogDetails);
								compCheck++;
							}
							if (!batchNoSessCompare[comp]
									.equalsIgnoreCase(batchNo[n])) {

								AuditLogDetail auditLogDetails = new AuditLogDetail();
								auditLogDetails
										.setOldValue(batchNoSessCompare[comp]);
								auditLogDetails.setNewValue(batchNo[n]);
								auditLogDetailLine.add(auditLogDetails);
								compCheck++;
							}
							if (!bookQtySessCompare[comp]
									.equalsIgnoreCase(bookQty[n])) {

								AuditLogDetail auditLogDetails = new AuditLogDetail();
								auditLogDetails
										.setOldValue(bookQtySessCompare[comp]);
								auditLogDetails.setNewValue(bookQty[n]);
								auditLogDetailLine.add(auditLogDetails);
								compCheck++;
							}
							if (!physicalQtySessCompare[comp]
									.equalsIgnoreCase(physicalQty[n])) {

								AuditLogDetail auditLogDetails = new AuditLogDetail();
								auditLogDetails
										.setOldValue(physicalQtySessCompare[comp]);
								auditLogDetails.setNewValue(physicalQty[n]);
								auditLogDetailLine.add(auditLogDetails);
								compCheck++;

							}
							if (!uomIdSessCompare[comp]
									.equalsIgnoreCase(uomId[n])) {

								AuditLogDetail auditLogDetails = new AuditLogDetail();
								auditLogDetails
										.setOldValue(uomIdSessCompare[comp]);
								auditLogDetails.setNewValue(uomId[n]);
								auditLogDetailLine.add(auditLogDetails);
								compCheck++;
							}
							if (comp == compareValue - 1 && compCheck > 0) {
								AuditLog auditLogILine = new AuditLog();
								auditLogILine.setUserId(sess.getAttribute(
										"userId").toString());
								auditLogILine.setOperation("M");
								auditLogILine
										.setObjectChanged("Physical Verfication Line");
								auditLogILine.setObjectType("ROW");
								auditLogILine
										.setObjectId(Integer
												.toString(verificationLineIdChildEdit[n]));
								auditLogILine.setStatus("1");
								auditLogILine.setTimeStamp(modifiedDate);
								auditLogILine.setUserName(sess.getAttribute(
										"userName").toString());
								auditLogILine
										.setAuditLogDetails(auditLogDetailLine);
								auditLogService.addAuditLog(auditLogILine);
							}
						}
						if (CheckPhysical == 0) {
							physicalVerificationUpList.add(cbd);
						} else {

							pVService
									.deletePhysicalVerificationLine(verificationLineIdChildEdit[n]);

							auditLogService
									.setAuditLogSave(
											sess.getAttribute("userId")
													.toString(),
											"D",
											"Physical Verfication Line",
											"ROW",
											Integer.toString(verificationLineIdChildEdit[n]),
											"1", modifiedDate, sess
													.getAttribute("userName")
													.toString());

						}
						comp++;

					}
				}
				physicalVerificationUpdate
						.setPhysicalVerificationFk(physicalVerificationUpList);

			}

			physicalVerificationUpdate.setVerificationDate(dateService
					.dateFormat(dateService.dateParse(
							physicalVerificationUpdate
									.getVerificationDateEdit(), "au"), "au"));
			msg = pVService
					.updatePhysicalVerification(physicalVerificationUpdate);

			if (msg == "Updated") {
				purcUpdate = "$uccess : Physical verification Data is updated successfully";

			} else {
				String fail = "Error ! : Physical Verification data is not updated properly";
				request.setAttribute("updatefail", fail);
				model.addAttribute("physicalVerificationCommand",
						new physicalVerification());
				return "physicalVerificationHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
			String fail = "Error ! : Physical Verification data is not updated properly";
			request.setAttribute("updatefail", fail);
			model.addAttribute("physicalVerificationCommand",
					new physicalVerification());
			return "physicalVerificationHome";
		}
		return "redirect:physicalVerification.mnt?pVUpdate=" + purcUpdate + "";
	}

}
