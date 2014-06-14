/**
 * 
 */
package com.mnt.erp.controller;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.GoodsIssue;
import com.mnt.erp.bean.GoodsIssueLine;
import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.ReasonForMovement;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.GoodsIssueService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.physicalVerificationService;

/**
 * @author kirangangone
 * 
 */
@Controller
public class GoodsIssueController {

	@Autowired
	physicalVerificationService pVService;

	@Autowired
	GoodsIssueService goodsIssueService;

	@Autowired
	PopulateService populateService;

	@Autowired
	AuditLogService auditLogService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	DateConversionService dateService;

	Object[] objects = null;
	List<Object[]> list = null;
	HttpSession session = null;
	Iterator<Object[]> iterator = null;
	boolean flag = true;

	@RequestMapping(value = "/goodsIssueAdvanceSearch", method = RequestMethod.GET)
	public String vendorAdvanceSearch(
			@ModelAttribute("goodsIssueCommand") GoodsIssue goodsIssue,
			HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		String name1 = "goodsIssue", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		List<GoodsIssue> goodsIssueList = null;
		goodsIssueList = new ArrayList();
		goodsIssue.setAdvanceSearchHidden(1);
		goodsIssue.setAdvanceBasicSearchHidden(2);
		try {
			returnString = xmlService.populateXml(name1);
			Iterator it = returnString.iterator();
			for (Object[] object : returnString) {
				GoodsIssue goodsIssueObject = new GoodsIssue();

				s1 = (String) object[0];
				s2 = (String) object[1];
				goodsIssueObject.setFirstLabel(s1);
				goodsIssueObject.setSecondLabel(s2);
				goodsIssueList.add(goodsIssueObject);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("goodsIssueSearchAdvance", goodsIssueList);

		return "goodsIssueHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "goodsIssue";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
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

	@ModelAttribute("deliveryNote")
	public Map<Integer, Integer> populateUomDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, Integer> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, Integer>();

			listvalues = populateService
					.poPulate("select m.deliveryNoteId,m.deliveryNoteId from DeliveryNote m");

			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (Integer) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("reasonForMovement")
	public Map<Integer, String> populateReasonForMovementDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, String>();

			listvalues = populateService
					.poPulate("select m.reasonForMovementId,m.reasonForMovement from ReasonForMovement m");

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

	@ModelAttribute("producionOrderId")
	public Map<Integer, Integer> populateproducionOrderIdDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, Integer> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<Integer, Integer>();

			listvalues = populateService
					.poPulate("select m.prodOrderId,m.prodOrderId from ProductionOrderBean m");

			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);
				map.put((Integer) objects[0], (Integer) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("batchNo")
	public Map<String, String> populateBatchNo() {
		List<Object[]> listvalues = null;
		Map<String, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			map = new HashMap<String, String>();
			listvalues = populateService
					.poPulate("select m.batchNo,m.batchNo from GoodsReceiptLine m");
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((String) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/duplicateGoodsIssueNoCheck", method = RequestMethod.POST)
	public @ResponseBody
	String duplicateGoodsIssueNoCheck(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforeCreditNoteNoValue = 0;
		try {

			String beforeCreditNoteNo = request.getParameter("goodsIssueNo");
			String id = request.getParameter("goodsIssueId");
			if (id.equalsIgnoreCase("0")) {
				beforeCreditNoteNoValue = goodsIssueService.checkGoodsIssue(
						beforeCreditNoteNo, "");
			} else {
				beforeCreditNoteNoValue = goodsIssueService.checkGoodsIssue(
						beforeCreditNoteNo, id);
			}
			GoodsIssue goodsIssue = new GoodsIssue();
			if (beforeCreditNoteNoValue != 0) {
				goodsIssue.setGoodsIssueNoDuplicate("1");
				goodsIssue.setGoodsIssueNo("");
				msa = "Warning ! Goods Issue aleardy exists. Please try some other no";
				return msa;
			}
			if (beforeCreditNoteNoValue == 0) {
				goodsIssue.setGoodsIssueNoDuplicate("1");
				msa = "";
				return msa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msa;
	}

	@RequestMapping(value = "/forAvailability", method = RequestMethod.POST)
	public @ResponseBody
	double forAvailability(HttpServletRequest request,
			HttpServletResponse response) {

		int matId = Integer.parseInt(request.getParameter("materialId"));
		String bId = request.getParameter("batchNo");
		int slId = Integer.parseInt(request.getParameter("storageLocationId"));

		float avalQty = 0;
		List<MatStockBean> mBean = null;
		try {
			mBean = goodsIssueService.getAvlQty(matId, slId, bId);

			if (mBean != null) {
				for (MatStockBean ms : mBean) {
					avalQty = ms.getQtyAval();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return avalQty;

	}

	@RequestMapping(value = "/GoodsIssue", method = RequestMethod.GET)
	public ModelAndView getGoodsIssue(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("GoodsIssue.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("goodsIssueHome", "goodsIssueCommand",
				new GoodsIssue());

	}

	@RequestMapping(value = "/GoodsIssueAdd", method = RequestMethod.POST)
	public String addGoodsIssue(
			@ModelAttribute("goodsIssueCommand") GoodsIssue goodsIssue,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String inspSave = null;
		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(date);
		List<GoodsIssueLine> goodsIssueMethod = new ArrayList<GoodsIssueLine>();
		String[] materialId = goodsIssue.getMaterialId();
		String[] qty = goodsIssue.getQty();
		String[] uOMId = goodsIssue.getuOMId();
		String[] batchNo = goodsIssue.getBatchNo();
		String[] plantId = goodsIssue.getPlantId();
		String[] storageLocationId = goodsIssue.getStorageLocationId();
		GoodsIssue goodsIssueDetails = (GoodsIssue) goodsIssue;
		MatStockBean mBean = new MatStockBean();
		int mStockId = 0;
		float matQty = 0, totQty = 0;
		if (materialId != null) {
			for (int n = 0; n < materialId.length; n++) {
				GoodsIssueLine goodsLineDetails = new GoodsIssueLine();
				goodsLineDetails.setMaterialId(materialId[n]);
				goodsLineDetails.setQty(qty[n]);
				goodsLineDetails.setuOMId(uOMId[n]);
				goodsLineDetails.setBatchNo(batchNo[n]);
				goodsLineDetails.setPlantId(plantId[n]);
				goodsLineDetails.setStorageLocationId(storageLocationId[n]);
				goodsLineDetails.setQtyAcc("0");
				goodsIssueMethod.add(goodsLineDetails);

				// get mat Stock
				List<MatStockBean> ob = goodsIssueService.getMatStock(
						Integer.parseInt(materialId[n]),
						Integer.parseInt(storageLocationId[n]), batchNo[n]);
				if (ob != null) {
					for (MatStockBean mst : ob) {
						mStockId = mst.getMatStockId();
						matQty = mst.getQtyAval();
					}
					totQty = matQty + Float.parseFloat(qty[n]);
					mBean.setMatStockId(mStockId);
					mBean.setMaterialId(Integer.parseInt(materialId[n]));
					mBean.setBatchNo(batchNo[n]);
					mBean.setStorLocId(Integer.parseInt(storageLocationId[n]));
					mBean.setQtyAval(totQty);
					flag = goodsIssueService.saveOrUpdateMatStock(mBean);

				} else {
					// Save Or Update Quantity From MatStock
					mBean.setMaterialId(Integer.parseInt(materialId[n]));
					mBean.setBatchNo(batchNo[n]);
					mBean.setStorLocId(Integer.parseInt(storageLocationId[n]));
					mBean.setQtyAval(Float.parseFloat(qty[n]));
					flag = goodsIssueService.saveOrUpdateMatStock(mBean);
				}

			}
		}
		goodsIssueDetails.setGoodsIssueLineDetails(goodsIssueMethod);
		if (goodsIssueDetails.getProducionOrderId().equals("0")) {
			goodsIssueDetails.setProducionOrderId(null);
		} else {
			goodsIssueDetails.setDeliveryNoteId(null);
		}

		int checkInsp = goodsIssueService.checkGoodsIssue(
				goodsIssue.getGoodsIssueNo(), "");

		try {

			goodsIssueDetails
					.setGoodsIssueDate(dateService.dateFormat(dateService
							.dateParse(goodsIssueDetails.getGoodsIssueDate(),
									"au"), "au"));
			goodsIssueDetails
					.setPostingDate(dateService.dateFormat(
							dateService.dateParse(
									goodsIssueDetails.getPostingDate(), "au"),
							"au"));
			String msg = goodsIssueService.saveGoodsIssue(goodsIssueDetails);

			if (msg.equals("S")) {
				session = request.getSession(false);

				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Goods Issue", "ROW", String
						.valueOf(goodsIssueDetails.getGoodsIssueId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());

				inspSave = "$uccess : GoodsIssue Data is saved successfully";
				return "redirect:GoodsIssue.mnt?addPursu=" + inspSave + "";
			} else {
				String fail = "Error ! : GoodsIssue Data is not saved properly";
				request.setAttribute("fail", fail);
				return "goodsIssueHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			String fail = "Error ! : GoodsIssue data is not saved properly";
			request.setAttribute("fail", fail);
			return "goodsIssueHome";
		}

	}

	@RequestMapping(value = "/goodsIssueSearch", method = RequestMethod.GET)
	public String searchScheduling(
			@ModelAttribute("goodsIssueCommand") GoodsIssue goodsIssueSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<GoodsIssue> goodsIssueList = new ArrayList<GoodsIssue>();
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		int advanceBasicSearchHidden = 0;
		try {
			// int poid = purchaseOrderSearch.getPurchaseOrderId();
			advanceBasicSearchHidden = goodsIssueSearch
					.getAdvanceBasicSearchHidden();
			if (advanceBasicSearchHidden == 2) {
				String columns = goodsIssueSearch.getFirstLabel();
				String operations = goodsIssueSearch.getOperations1();
				String advanceSearchText = goodsIssueSearch
						.getAdvanceSearchText();
				if (advanceSearchText.length() != 0
						&& advanceSearchText != null) {

					list = goodsIssueService.basicSearchGoodsIssue(columns,
							operations, advanceSearchText, "A");
				} else {
					list = goodsIssueService.basicSearchGoodsIssue("", "", "",
							"");
				}
				goodsIssueSearch.setAdvanceBasicSearchHidden(2);
			} else {
				String dbField = goodsIssueSearch.getXmlLabelBasic();
				String operation = goodsIssueSearch.getOperations();
				String basicSearchId = goodsIssueSearch.getBasicSearchId();

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
					list = goodsIssueService.basicSearchGoodsIssue("", "", "",
							"");

				} else if (basicSearchId != "") {
					list = goodsIssueService.basicSearchGoodsIssue(dbField,
							operation, basicSearchId, "B");
				}
			}

			if (list != null) {
				iterator = list.iterator();
				while (iterator.hasNext()) {
					objects = (Object[]) iterator.next();
					GoodsIssue cb = new GoodsIssue();

					cb.setGoodsIssueId((Integer) objects[0]);
					cb.setGoodsIssueNo((String) objects[1]);
					cb.setGoodsIssueDate(dateService.dateFormat(
							dateService.dateParse((String) objects[2], "se"),
							"se"));
					cb.setDeliveryNoteId((String) objects[3]);
					cb.setProducionOrderId((String) objects[4]);
					cb.setPostingDate(dateService.dateFormat(
							dateService.dateParse((String) objects[5], "se"),
							"se"));
					// cb.setReasonForMovementId((String) objects[6]);
					cb.setReference((String) objects[7]);

					ReasonForMovement re = (ReasonForMovement) objects[8];
					cb.setReasonForMovementId(re.getReasonForMovement());

					goodsIssueList.add(cb);

				}
			}

			request.setAttribute("goodsIssueList", goodsIssueList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "goodsIssueHome";

	}

	@RequestMapping(value = "/goodsIssueEdit", method = RequestMethod.GET)
	public String goodsIssueCommandEdit(
			@ModelAttribute("goodsIssueCommand") GoodsIssue goodsIssue,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<GoodsIssue> goodsIssueEditList = new ArrayList<GoodsIssue>();
		List<GoodsIssueLine> goodsIssueMethodEditList = new ArrayList<GoodsIssueLine>();
		List<Float> qtyList = new ArrayList<Float>();
		int purcId = Integer.parseInt(request.getParameter("goodsIssueId"));

		try {

			List<Object> l = goodsIssueService.editGoodsIssueWithId(purcId);
			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				GoodsIssue ccb = (GoodsIssue) oo;
				goodsIssue.setGoodsIssueId(ccb.getGoodsIssueId());
				goodsIssue.setGoodsIssueNo(ccb.getGoodsIssueNo());
				goodsIssue.setGoodsIssueDate(dateService.dateFormat(
						dateService.dateParse(ccb.getGoodsIssueDate(), "se"),
						"se"));
				goodsIssue.setDeliveryNoteId(ccb.getDeliveryNoteId());
				goodsIssue.setProducionOrderId(ccb.getProducionOrderId());
				goodsIssue
						.setPostingDate(dateService.dateFormat(dateService
								.dateParse(ccb.getPostingDate(), "se"), "se"));
				goodsIssue.setReasonForMovementId(ccb.getReasonForMovementId());
				goodsIssue.setReference(ccb.getReference());

				List<GoodsIssueLine> listEdit = ccb.getGoodsIssueLineDetails();
				Iterator<GoodsIssueLine> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					GoodsIssueLine cc = (GoodsIssueLine) o;
					GoodsIssueLine cMultiple = new GoodsIssueLine();

					cMultiple.setGoodsIssueLineId(cc.getGoodsIssueLineId());
					cMultiple.setGoodsIssueId(cc.getGoodsIssueId());
					cMultiple.setMaterialId(cc.getMaterialId());
					cMultiple.setQty(cc.getQty());
					cMultiple.setQtyAcc(cc.getQty());
					cMultiple.setuOMId(cc.getuOMId());
					cMultiple.setBatchNo(cc.getBatchNo());
					cMultiple.setPlantId(cc.getPlantId());
					cMultiple.setStorageLocationId(cc.getStorageLocationId());

					Material material = (Material) cc.getMaterialDetails();
					cMultiple.setMaterialName(material.getMaterialName());
					Uom uom = (Uom) cc.getUomDetails();
					cMultiple.setuOMName(uom.getUom());
					Plant plant = (Plant) cc.getPlantDetails();
					cMultiple.setPlantName(plant.getPlantName());
					StorageLocation strLo = (StorageLocation) cc
							.getStorageLocDetails();
					cMultiple
							.setStorageLocationName(strLo.getStorageLocation());

					goodsIssueMethodEditList.add(cMultiple);
					qtyList.add(Float.parseFloat(cc.getQty()));

				}
				goodsIssue.setGoodsIssueLineDetails(goodsIssueMethodEditList);
				goodsIssueEditList.add(goodsIssue);
			}
			session = request.getSession(false);
			session.setAttribute("qtyList", qtyList);
			request.setAttribute("goodsIssueEditList", goodsIssueEditList);
			request.setAttribute("goodsIssueLineEditList",
					goodsIssueMethodEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "goodsIssueHome";
	}

	@RequestMapping(value = "/goodsIssueUpdate", method = RequestMethod.POST)
	public String goodsIssueCommandUpdate(
			@ModelAttribute("goodsIssueCommand") GoodsIssue goodsIssueUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<GoodsIssueLine> goodsIssueUpList = new ArrayList<GoodsIssueLine>();
		HttpSession session = request.getSession();
		Date date = new Date();
		String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(date);
		String purcUpdate = null;
		try {
			if (goodsIssueUpdate.getProducionOrderId().equals("0")) {
				goodsIssueUpdate.setProducionOrderId(null);
			} else {
				goodsIssueUpdate.setDeliveryNoteId(null);
			}
			
			goodsIssueUpdate.setGoodsIssueDate(dateService.dateFormat(dateService.dateParse(goodsIssueUpdate.getGoodsIssueDate(),"au"),"au"));
			goodsIssueUpdate.setPostingDate(dateService.dateFormat(dateService.dateParse(goodsIssueUpdate.getPostingDate(),"au"),"au"));
			int[] goodsIssueLineId = goodsIssueUpdate.getGoodsIssueLineId();
			String[] materialId = goodsIssueUpdate.getMaterialId();
			String[] qty = goodsIssueUpdate.getQty();
			String[] uOMId = goodsIssueUpdate.getuOMId();
			String[] batchNo = goodsIssueUpdate.getBatchNo();
			String[] plantId = goodsIssueUpdate.getPlantId();
			String[] storageLocationId = goodsIssueUpdate
					.getStorageLocationId();
			String[] qtyAcc = goodsIssueUpdate.getQtyAcc();
			MatStockBean mBean = new MatStockBean();
			int mStockId = 0;
			float matQty = 0, diffQty = 0, totQty = 0;
			List<Float> newQty = new ArrayList<Float>();
			if (materialId != null && qty != null) {
				session = request.getSession(false);
				@SuppressWarnings("unchecked")
				List<Float> oldQty = (List<Float>) session
						.getAttribute("qtyList");

				for (int n = 0; n < materialId.length; n++) {

					// Get mat Stock
					List<MatStockBean> ob = goodsIssueService.getMatStock(
							Integer.parseInt(materialId[n]),
							Integer.parseInt(storageLocationId[n]), batchNo[n]);

					int puId = goodsIssueLineId[n];

					if (puId == 0) {
						GoodsIssueLine goodsLineDetails = new GoodsIssueLine();
						goodsLineDetails.setGoodsIssueId(Integer
								.toString(goodsIssueUpdate.getGoodsIssueId()));
						goodsLineDetails.setMaterialId(materialId[n]);
						goodsLineDetails.setQty(qty[n]);
						goodsLineDetails.setuOMId(uOMId[n]);
						goodsLineDetails.setBatchNo(batchNo[n]);
						goodsLineDetails.setPlantId(plantId[n]);
						goodsLineDetails
								.setStorageLocationId(storageLocationId[n]);
						goodsLineDetails.setQtyAcc(qtyAcc[n]);
						goodsIssueUpList.add(goodsLineDetails);
						// Mat Stock for new row
						if (ob != null) {
							for (MatStockBean mst : ob) {
								mStockId = mst.getMatStockId();
								matQty = mst.getQtyAval();
							}
							totQty = matQty + Float.parseFloat(qty[n]);
							mBean.setMatStockId(mStockId);
							mBean.setMaterialId(Integer.parseInt(materialId[n]));
							mBean.setBatchNo(batchNo[n]);
							mBean.setStorLocId(Integer
									.parseInt(storageLocationId[n]));
							mBean.setQtyAval(totQty);
							flag = goodsIssueService
									.saveOrUpdateMatStock(mBean);

						} else {
							// Save Or Update Quantity From MatStock
							mBean.setMaterialId(Integer.parseInt(materialId[n]));
							mBean.setBatchNo(batchNo[n]);
							mBean.setStorLocId(Integer
									.parseInt(storageLocationId[n]));
							mBean.setQtyAval(Float.parseFloat(qty[n]));
							flag = goodsIssueService
									.saveOrUpdateMatStock(mBean);
						}

					} else {
						int CheckInsp = Integer.parseInt(request
								.getParameter("CheckGoodsIssue"
										+ goodsIssueLineId[n]));
						newQty.add(Float.parseFloat(qty[n]));
						GoodsIssueLine goodsLineDetails = new GoodsIssueLine();
						goodsLineDetails
								.setGoodsIssueLineId(goodsIssueLineId[n]);
						goodsLineDetails.setGoodsIssueId(Integer
								.toString(goodsIssueUpdate.getGoodsIssueId()));
						goodsLineDetails.setMaterialId(materialId[n]);
						goodsLineDetails.setQty(qty[n]);
						goodsLineDetails.setuOMId(uOMId[n]);
						goodsLineDetails.setBatchNo(batchNo[n]);
						goodsLineDetails.setPlantId(plantId[n]);
						goodsLineDetails.setQtyAcc(qtyAcc[n]);
						goodsLineDetails
								.setStorageLocationId(storageLocationId[n]);
						// goodsIssueUpList.add(goodsLineDetails);
						if (CheckInsp == 0) {
							goodsIssueUpList.add(goodsLineDetails);

						} else {

							goodsIssueService.deleteGoodsIssue(
									goodsIssueLineId[n], "Sub");

						}

						// Check OldQty And NewQty for Matstock Update
						if (oldQty.get(n) > (newQty.get(n))) {
							if (ob != null) {
								for (MatStockBean mst : ob) {
									mStockId = mst.getMatStockId();
									matQty = mst.getQtyAval();
								}
								diffQty = oldQty.get(n) - newQty.get(n);
								totQty = matQty - diffQty;
								mBean.setMatStockId(mStockId);
								mBean.setMaterialId(Integer
										.parseInt(materialId[n]));
								mBean.setBatchNo(batchNo[n]);
								mBean.setStorLocId(Integer
										.parseInt(storageLocationId[n]));
								mBean.setQtyAval(totQty);
								flag = goodsIssueService
										.saveOrUpdateMatStock(mBean);

							} else {
								// Save Or Update Quantity From MatStock
								mBean.setMaterialId(Integer
										.parseInt(materialId[n]));
								mBean.setBatchNo(batchNo[n]);
								mBean.setStorLocId(Integer
										.parseInt(storageLocationId[n]));
								mBean.setQtyAval(Float.parseFloat(qty[n]));
								flag = goodsIssueService
										.saveOrUpdateMatStock(mBean);
							}

						} else if (oldQty.get(n) < (newQty.get(n))) {
							if (ob != null) {
								for (MatStockBean mst : ob) {
									mStockId = mst.getMatStockId();
									matQty = mst.getQtyAval();
								}
								diffQty = newQty.get(n) - oldQty.get(n);
								totQty = matQty + diffQty;
								mBean.setMatStockId(mStockId);
								mBean.setMaterialId(Integer
										.parseInt(materialId[n]));
								mBean.setBatchNo(batchNo[n]);
								mBean.setStorLocId(Integer
										.parseInt(storageLocationId[n]));
								mBean.setQtyAval(totQty);
								flag = goodsIssueService
										.saveOrUpdateMatStock(mBean);

							} else {
								// Save Or Update Quantity From MatStock
								mBean.setMaterialId(Integer
										.parseInt(materialId[n]));
								mBean.setBatchNo(batchNo[n]);
								mBean.setStorLocId(Integer
										.parseInt(storageLocationId[n]));
								mBean.setQtyAval(Float.parseFloat(qty[n]));
								flag = goodsIssueService
										.saveOrUpdateMatStock(mBean);
							}

						} else {
							// Two Quantitys are Equal No update...
						}

					}
				}
				goodsIssueUpdate.setGoodsIssueLineDetails(goodsIssueUpList);

			}
			AuditLog auditLogI = new AuditLog();
			auditLogI.setUserId(session.getAttribute("userId").toString());
			auditLogI.setOperation("M");
			auditLogI.setObjectChanged("GoodsIssue");
			auditLogI.setObjectType("ROW");
			auditLogI.setObjectId(Integer.toString(goodsIssueUpdate
					.getGoodsIssueId()));
			auditLogI.setStatus("1");
			auditLogI.setTimeStamp(modifiedDate);
			auditLogI.setUserName(session.getAttribute("userName").toString());

			boolean flag = goodsIssueService.updateGoodsIssue(goodsIssueUpdate,
					auditLogI, materialId.length);

			if (flag == true) {

				purcUpdate = "$uccess : Goods Issue Data is updated successfully";

			} else {
				String fail = "Error ! :Goods Issue data is not updated properly";
				request.setAttribute("updatefail", fail);
				model.addAttribute("goodsIssueCommand", new GoodsIssue());
				return "goodsIssueHome";
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return "redirect:GoodsIssue.mnt?purcUpdate=" + purcUpdate + "";
	}

	@RequestMapping(value = "/goodsIssueDelete", method = RequestMethod.GET)
	public ModelAndView BomDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		try {

			int id = Integer.parseInt(request.getParameter("goodsIssueId"));
			boolean flag = goodsIssueService.deleteGoodsIssue(id, "main");
			if (flag == true) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Goods Issue", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				request.setAttribute("deleteSus",
						"$uccess : Goods Issue Data is deleted successfully");
			} else {
				String fail = "Error ! :Goods Issue data is not deleted properly";
				request.setAttribute("deletefail", fail);
				return new ModelAndView("goodsIssueHome", "goodsIssueCommand",
						new GoodsIssue());
			}

		} catch (Exception e) {
			// auditLogService.setAuditLogSave(userId,"D","ROW","BomCategory"
			// ,Integer.toString(id) , "0",modifiedDate);
			String fail = "Error ! : Goods Issue data is not deleted properly";
			request.setAttribute("deletefail", fail);
			return new ModelAndView("goodsIssueHome", "goodsIssueCommand",
					new GoodsIssue());
			// e.printStackTrace();
		}
		return new ModelAndView("goodsIssueHome", "goodsIssueCommand",
				new GoodsIssue());
	}

}
