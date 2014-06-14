/**
 * @Copyright MNTSOFT
 *//*
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.GoodsReceiptLine;
import com.mnt.erp.bean.InspLotResultBean;
import com.mnt.erp.bean.InspectionDecision;
import com.mnt.erp.bean.InspectionLotBean;
import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.InspLotResultService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

*//**
 * @author Naresh
 * @version 1.0 10-01-2014
 *//*
@Controller
public class InspLotResultController {
	private static final Logger log = Logger
			.getLogger(InspLotResultController.class);
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	InspLotResultService inspLotResService;
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
	List<Object> obj = null;
	HttpSession session = null;
	boolean flag = true;
	String msg = null;

	@RequestMapping(value = "/inspLotResHome", method = RequestMethod.GET)
	public ModelAndView inspLotResHome(
			@ModelAttribute("inspLotResCmd") InspLotResultBean inspLotResBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("inspLotResHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("inspLotResHome", "inspLotResCmd",
				inspLotResBean);
	}

	@ModelAttribute("inspLotSelect")
	public Map<Integer, String> populatInspLotIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.inspLotNoId,s.inspLotNo from InspectionLotBean s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("InspDecision")
	public Map<Integer, String> populateInspDecision() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select pd.inspDecision_Id,pd.decision from InspectionDecision pd");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/getLotQty", method = RequestMethod.POST)
	public @ResponseBody
	String getQuantity(HttpServletRequest request,
			HttpServletResponse response, InspLotResultBean sqdupBean) {
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("inspId");
		String insp = request.getParameter("inspected");
		if (id.equals("") || insp.equals("")) {

		} else {
			int inspId = Integer.parseInt(id);
			float inspected = Float.parseFloat(insp);
			flag = inspLotResService.getLotQty(inspId, inspected);
		}
		if (flag == true) {
			msg = "";

		} else {
			msg = "Warning ! Inspected Must be Equal to Inspection Lot Quantity";
		}
		return msg;

	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/inspLotResAdd", method = RequestMethod.POST)
	public String saveInspLot(
			@ModelAttribute("inspLotResCmd") InspLotResultBean inspBean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String inspSave = null;
		int mId = 0, slId = 0, mStockId = 0;
		String batchNo = "0";
		float qty = 0, matQty = 0, totStock = 0, qtyAcp = 0, qtyInsp = 0, qtyRej = 0, totQtyAcp = 0, totQtyInsp = 0, totQtyRej = 0;
		try {
			InspLotResultBean addBean = (InspLotResultBean) inspBean;
			MatStockBean mBean = new MatStockBean();
			boolean skip = addBean.isSkip();
			if (skip == true || addBean.getAccepted().equals("")
					|| addBean.getInspected().equals("")
					|| addBean.getNonConf().equals("")) {

				InspLotResultBean lrBean = new InspLotResultBean();
				lrBean.setInspDecisionId(addBean.getInspDecisionId());
				lrBean.setQualityScore(addBean.getQualityScore());
				String inspId = addBean.getInspLotNoId();
				lrBean.setInspLotNoId(inspId);
				lrBean.setStartDate(dateService.dateFormat(
						dateService.dateParse(addBean.getStartDate(), "au"),
						"au"));
				lrBean.setEndDate(dateService.dateFormat(
						dateService.dateParse(addBean.getEndDate(), "au"), "au"));
				lrBean.setMean(addBean.getMean());
				lrBean.setStdValue(addBean.getStdValue());
				lrBean.setAccepted("0");
				lrBean.setInspected("0");
				lrBean.setNonConf("0");
				lrBean.setSkip(skip);
				int insId = Integer.parseInt(inspId);
				//Insp Decision is equal to Rejected can't update MatStock
				if(!"1".equals(addBean.getInspDecisionId())){
				// Get Material_Id,Quantity,Batch_No From Inspection Lot
				obj = inspLotResService.getMaterialId(insId);
				Iterator<Object> iterator = obj.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					InspectionLotBean isp = (InspectionLotBean) obj;
					mId = Integer.parseInt(isp.getMaterialId());
					qty = Float.parseFloat(isp.getQuantity());
					batchNo = isp.getBatchNo();

				}
				// Get Stock From Material
				float stock = inspLotResService.getStock(mId);
				totStock = stock + qty;
				// Update Stock From Material
				flag = inspLotResService.updateMaterial(totStock, mId);
				// Get GoodsReceiptLine Quantity
				List<Object> obje = inspLotResService.getGoodsQty(mId, batchNo);
				Iterator<Object> iterat = obje.iterator();
				while (iterat.hasNext()) {
					Object objec = iterat.next();
					GoodsReceiptLine grl = (GoodsReceiptLine) objec;
					qtyAcp = grl.getQtyAccepted();
					qtyInsp = grl.getQtyInspected();
					qtyRej = grl.getQtyRejected();
					slId = Integer.parseInt(grl.getStorageLocationId());
				}
				totQtyAcp = qtyAcp + qty;
				totQtyInsp = qtyInsp + qty;
				totQtyRej = qtyRej;
				// Update Quantity From GoodsReceiptLine
				flag = inspLotResService.updateGoodsReceiptLine(totQtyInsp,
						totQtyAcp, totQtyRej, mId, batchNo);
				// get mat Stock
				List<MatStockBean> ob = inspLotResService.getMatStock(mId,
						slId, batchNo);
				if (ob != null) {

					for (MatStockBean mst : ob) {
						mStockId = mst.getMatStockId();
						matQty = mst.getQtyAval();
					}

					mBean.setMatStockId(mStockId);
					mBean.setMaterialId(mId);
					mBean.setBatchNo(batchNo);
					mBean.setStorLocId(slId);
					mBean.setQtyAval(qty);
					flag = inspLotResService.saveOrUpdateMatStock(mBean);

				} else {
					// Save Or Update Quantity From MatStock
					mBean.setMaterialId(mId);
					mBean.setBatchNo(batchNo);
					mBean.setStorLocId(slId);
					mBean.setQtyAval(qty);
					flag = inspLotResService.saveOrUpdateMatStock(mBean);
				}
				}
				// Save Inspection Lot Result
				flag = inspLotResService.saveInspLotResultDetails(lrBean);
			
			}

			else {
				InspLotResultBean lrBean = new InspLotResultBean();
				String inspId = addBean.getInspLotNoId();
				addBean.setStartDate(dateService.dateFormat(
						dateService.dateParse(addBean.getStartDate(), "au"),
						"au"));
				addBean.setEndDate(dateService.dateFormat(
						dateService.dateParse(addBean.getStartDate(), "au"),
						"au"));
				lrBean.setInspDecisionId(addBean.getInspDecisionId());
				lrBean.setQualityScore(addBean.getQualityScore());
				lrBean.setInspLotNoId(inspId);
				
				float inspected = Float.parseFloat(addBean.getInspected());
				float accepted = Float.parseFloat(addBean.getAccepted());
				float nonConf = Float.parseFloat(addBean.getNonConf());
				int insId = Integer.parseInt(inspId);
				if(!"1".equals(addBean.getInspDecisionId())){
				obj = inspLotResService.getMaterialId(insId);
				Iterator<Object> iterator = obj.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					InspectionLotBean isp = (InspectionLotBean) obj;
					mId = Integer.parseInt(isp.getMaterialId());
					qty = Float.parseFloat(isp.getQuantity());
					batchNo = isp.getBatchNo();
				}
				float stock = inspLotResService.getStock(mId);
				totStock = stock + inspected;
				flag = inspLotResService.updateMaterial(totStock, mId);
				List<Object> obje = inspLotResService.getGoodsQty(mId, batchNo);
				Iterator<Object> iterat = obje.iterator();
				while (iterat.hasNext()) {
					Object objec = iterat.next();
					GoodsReceiptLine grl = (GoodsReceiptLine) objec;
					qtyAcp = grl.getQtyAccepted();
					qtyInsp = grl.getQtyInspected();
					qtyRej = grl.getQtyRejected();
					slId = Integer.parseInt(grl.getStorageLocationId());
				}
				totQtyAcp = qtyAcp + accepted;
				totQtyInsp = qtyInsp + inspected;
				totQtyRej = qtyRej + nonConf;
				flag = inspLotResService.updateGoodsReceiptLine(totQtyInsp,
						totQtyAcp, totQtyRej, mId, batchNo);
				// Get Mat Stock
				List<MatStockBean> ob = inspLotResService.getMatStock(mId,
						slId, batchNo);

				if (ob != null) {
					for (MatStockBean mst : ob) {
						mStockId = mst.getMatStockId();
						matQty = mst.getQtyAval();
					}

					mBean.setMatStockId(mStockId);
					mBean.setMaterialId(mId);
					mBean.setBatchNo(batchNo);
					mBean.setStorLocId(slId);
					mBean.setQtyAval(accepted);
					flag = inspLotResService.saveOrUpdateMatStock(mBean);

				} else {
					// Save Or Update Quantity From MatStock
					mBean.setMaterialId(mId);
					mBean.setBatchNo(batchNo);
					mBean.setStorLocId(slId);
					mBean.setQtyAval(accepted);
					flag = inspLotResService.saveOrUpdateMatStock(mBean);
				}
				}

				flag = inspLotResService.saveInspLotResultDetails(addBean);
			}
			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Inspection Lot Result", "ROW",
						String.valueOf(addBean.getInspLotResultId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				inspSave = "Inspection Lot Result Data Saved Successfully";

			} else {
				inspSave = "Inspection Lot Result Data Insertion Failures";
				return "redirect:inspLotResHome.mnt?addLotFail=" + inspSave
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:inspLotResHome.mnt?addLotFail=" + inspSave + "";
		}

		return "redirect:inspLotResHome.mnt?addLotsus=" + inspSave + "";

	}

	@RequestMapping(value = "/inspLotResSearch", method = RequestMethod.GET)
	public String searchInspLot(
			@ModelAttribute("inspLotResCmd") InspLotResultBean inspLotBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<InspLotResultBean> LOTList = new ArrayList<InspLotResultBean>();
		try {

			String dbField = inspLotBeanSearch.getXmlLabel();
			String operation = inspLotBeanSearch.getOperations();
			String basicSearchId = inspLotBeanSearch.getBasicSearchId();

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
				list = inspLotResService.searchInspLotResult();

			} else {

				list = inspLotResService.basicSearchInspLotResult(dbField,
						operation, dateService.dateFormat(
								dateService.dateParse(basicSearchId, "au"),
								"au"));
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				InspLotResultBean dnb = new InspLotResultBean();
				dnb.setInspLotResultId((Integer) objects[0]);
				InspectionLotBean insp = ((InspectionLotBean) objects[10]);
				dnb.setInspLotNoId(insp.getInspLotNo());
				dnb.setStartDate(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));
				dnb.setEndDate(dateService.dateFormat(
						dateService.dateParse((String) objects[3], "se"), "se"));
				dnb.setInspected((String) objects[4]);
				dnb.setAccepted((String) objects[5]);
				dnb.setNonConf((String) objects[6]);
				dnb.setMean((String) objects[7]);
				dnb.setStdValue((String) objects[8]);
				dnb.setSkip((Boolean) objects[9]);
				InspectionDecision pd = (InspectionDecision) objects[11];
				dnb.setInspDecisionId(pd.getDecision());
				LOTList.add(dnb);
			}
			request.setAttribute("LOTList", LOTList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "inspLotResHome";

	}

	@RequestMapping(value = "/inspLotResDelete", method = RequestMethod.GET)
	public String inspLotDelete(
			@ModelAttribute("inspLotResCmd") InspLotResultBean inspLotBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String inspLotDelete = null;
		int inspId = Integer.parseInt(request.getParameter("inspLotResNoId"));
		try {
			flag = inspLotResService.deleteInspLotResult(inspId);
			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "InspLot Result", "ROW", String
						.valueOf(inspId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				inspLotDelete = "Inspection Lot Result Deleted Successfully";

			} else {
				inspLotDelete = "Inspection Lot Result Deletion Failed due to Conatraint Violation";
				return "redirect:inspLotResHome.mnt?DeleteLotFail="
						+ inspLotDelete + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:inspLotResHome.mnt?DeleteLotFail=" + inspLotDelete
					+ "";
		}
		return "redirect:inspLotResHome.mnt?DeleteLotsus=" + inspLotDelete + "";

	}

	@RequestMapping(value = "/inspLotResEdit", method = RequestMethod.GET)
	public String inspLotEdit(
			@ModelAttribute("inspLotResCmd") InspLotResultBean salesEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("inspLotResNoId"));
		List<InspLotResultBean> inspLotBean = new ArrayList<InspLotResultBean>();
		InspLotResultBean isp = null;
		try {
			obj = inspLotResService.searchInspLotResultWithId(id);
			Iterator<Object> iterator = obj.iterator();
			while (iterator.hasNext()) {
				Object obj = iterator.next();
				isp = (InspLotResultBean) obj;
				isp.setAcpInEdit(Float.parseFloat(isp.getAccepted()));
				isp.setInspInEdit(Float.parseFloat(isp.getInspected()));
				isp.setNonCnfInEdit(Float.parseFloat(isp.getNonConf()));
				isp.setStartDate(dateService.dateFormat(
						dateService.dateParse(isp.getStartDate(), "se"), "se"));
				isp.setEndDate(dateService.dateFormat(
						dateService.dateParse(isp.getEndDate(), "se"), "se"));
				inspLotBean.add(isp);
			}
			model.addAttribute("inspLotResCmd", isp);
			request.setAttribute("inspLotEdit", inspLotBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			obj = null;
		}
		return "inspLotResHome";

	}

	@RequestMapping(value = "/inspLotResUpdate", method = RequestMethod.POST)
	public String inspLotUpdate(
			@ModelAttribute("inspLotResCmd") InspLotResultBean inspUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String inspUpadted = null;
		int mId = 0, slId = 0, mStockId = 0;
		String batchNo = "0";
		float qty = 0, diffQty = 0, matQty = 0, totStock = 0, qtyAcp = 0, qtyInsp = 0, qtyRej = 0, totQtyAcp = 0, totQtyInsp = 0, totQtyRej = 0;
		try {
			InspLotResultBean upBean = (InspLotResultBean) inspUpdate;
			MatStockBean mBean = new MatStockBean();
			boolean skip = upBean.isSkip();
			if (skip == true || upBean.getAccepted().equals("0")
					|| upBean.getAccepted().equals("")
					|| upBean.getInspected().equals("0")
					|| upBean.getInspected().equals("")) {
				InspLotResultBean lrBean = new InspLotResultBean();
				lrBean.setInspDecisionId(upBean.getInspDecisionId());
				lrBean.setQualityScore(upBean.getQualityScore());
				int resId = upBean.getInspLotResultId();
				String inspId = upBean.getInspLotNoId();
				lrBean.setInspLotResultId(resId);
				lrBean.setInspLotNoId(inspId);
				lrBean.setStartDate(dateService.dateFormat(
						dateService.dateParse(upBean.getStartDate(), "au"),
						"au"));
				lrBean.setEndDate(dateService.dateFormat(
						dateService.dateParse(upBean.getEndDate(), "au"), "au"));
				lrBean.setMean(upBean.getMean());
				lrBean.setStdValue(upBean.getStdValue());
				lrBean.setAccepted("0");
				lrBean.setInspected("0");
				lrBean.setNonConf("0");
				lrBean.setSkip(skip);
				int insId = Integer.parseInt(inspId);
				if(!"1".equals(upBean.getInspDecisionId())){
				obj = inspLotResService.getMaterialId(insId);
				Iterator<Object> iterator = obj.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					InspectionLotBean isp = (InspectionLotBean) obj;
					mId = Integer.parseInt(isp.getMaterialId());
					qty = Float.parseFloat(isp.getQuantity());
					batchNo = isp.getBatchNo();
				}
				float stock = inspLotResService.getStock(mId);
				totStock = stock + qty;
				flag = inspLotResService.updateMaterial(totStock, mId);
				List<Object> obje = inspLotResService.getGoodsQty(mId, batchNo);
				Iterator<Object> iterat = obje.iterator();
				while (iterat.hasNext()) {
					Object objec = iterat.next();
					GoodsReceiptLine grl = (GoodsReceiptLine) objec;
					qtyAcp = grl.getQtyAccepted();
					qtyInsp = grl.getQtyInspected();
					qtyRej = grl.getQtyRejected();
					slId = Integer.parseInt(grl.getStorageLocationId());
				}
				totQtyAcp = qtyAcp + qty;
				totQtyInsp = qtyInsp + qty;
				totQtyRej = qtyRej;
				// Update Quantity From GoodsReceiptLine
				flag = inspLotResService.updateGoodsReceiptLine(totQtyInsp,
						totQtyAcp, totQtyRej, mId, batchNo);

				// Get Mat Stock
				List<MatStockBean> ob = inspLotResService.getMatStock(mId,
						slId, batchNo);

				if (ob != null) {
					for (MatStockBean mst : ob) {
						mStockId = mst.getMatStockId();
						matQty = mst.getQtyAval();
					}
					mBean.setMatStockId(mStockId);
					mBean.setMaterialId(mId);
					mBean.setBatchNo(batchNo);
					mBean.setStorLocId(slId);
					mBean.setQtyAval(qty);
					flag = inspLotResService.saveOrUpdateMatStock(mBean);

				} else {
					// Save Or Update Quantity From MatStock
					mBean.setMaterialId(mId);
					mBean.setBatchNo(batchNo);
					mBean.setStorLocId(slId);
					mBean.setQtyAval(qty);
					flag = inspLotResService.saveOrUpdateMatStock(mBean);
				}
				}

				flag = inspLotResService.updateInspLotResult(lrBean);
			} else {

				float totAcp = 0, totInsp = 0, totNonCnf = 0;
				InspLotResultBean lrBean = new InspLotResultBean();
				lrBean.setInspDecisionId(upBean.getInspDecisionId());
				lrBean.setQualityScore(upBean.getQualityScore());
				String inspId = upBean.getInspLotNoId();
				lrBean.setInspLotNoId(inspId);
				upBean.setStartDate(dateService.dateFormat(
						dateService.dateParse(upBean.getStartDate(), "au"),
						"au"));
				upBean.setEndDate(dateService.dateFormat(
						dateService.dateParse(upBean.getEndDate(), "au"),
						"au"));
				float inspInEdit = upBean.getInspInEdit();
				float acpInEdit = upBean.getAcpInEdit();
				float nonCnfInEdit = upBean.getNonCnfInEdit();
				float inspected = Float.parseFloat(upBean.getInspected());
				float accepted = Float.parseFloat(upBean.getAccepted());
				float nonConf = Float.parseFloat(upBean.getNonConf());
				if (acpInEdit < accepted && nonCnfInEdit > nonConf) {
					totAcp = accepted - acpInEdit;
					totNonCnf = nonConf - nonCnfInEdit;

				} else if (acpInEdit > accepted && nonCnfInEdit < nonConf) {
					totAcp = accepted - acpInEdit;
					totNonCnf = nonConf - nonCnfInEdit;
				} else {
					totAcp = 0;
					totNonCnf = 0;
				}
				if (inspInEdit < inspected || inspInEdit > inspected) {

					totInsp = inspInEdit - inspected;
				} else {
					totInsp = 0;
				}

				int insId = Integer.parseInt(inspId);
				if(!"1".equals(upBean.getInspDecisionId())){
				obj = inspLotResService.getMaterialId(insId);
				Iterator<Object> iterator = obj.iterator();
				while (iterator.hasNext()) {
					Object obj = iterator.next();
					InspectionLotBean isp = (InspectionLotBean) obj;
					mId = Integer.parseInt(isp.getMaterialId());
					batchNo = isp.getBatchNo();
				}
				float stock = inspLotResService.getStock(mId);
				totStock = stock + totAcp;
				// log.info("total stock" + totStock);
				flag = inspLotResService.updateMaterial(totStock, mId);

				List<Object> obje = inspLotResService.getGoodsQty(mId, batchNo);
				Iterator<Object> iterat = obje.iterator();
				while (iterat.hasNext()) {
					Object objec = iterat.next();
					GoodsReceiptLine grl = (GoodsReceiptLine) objec;
					qtyAcp = grl.getQtyAccepted();
					qtyInsp = grl.getQtyInspected();
					qtyRej = grl.getQtyRejected();
					slId = Integer.parseInt(grl.getStorageLocationId());
				}
				totQtyAcp = qtyAcp + totAcp;
				totQtyInsp = qtyInsp + totInsp;
				totQtyRej = qtyRej + totNonCnf;

				flag = inspLotResService.updateGoodsReceiptLine(totQtyInsp,
						totQtyAcp, totQtyRej, mId, batchNo);
				// Get Mat Stock
				List<MatStockBean> ob = inspLotResService.getMatStock(mId,
						slId, batchNo);

				if (ob != null) {
					for (MatStockBean mst : ob) {
						mStockId = mst.getMatStockId();
						matQty = mst.getQtyAval();
					}
					float matQtyAcp = matQty + totAcp;
					mBean.setMatStockId(mStockId);
					mBean.setMaterialId(mId);
					mBean.setBatchNo(batchNo);
					mBean.setStorLocId(slId);
					mBean.setQtyAval(matQtyAcp);
					flag = inspLotResService.saveOrUpdateMatStock(mBean);

				} else {
					// Save Or Update Quantity From MatStock
					mBean.setMaterialId(mId);
					mBean.setBatchNo(batchNo);
					mBean.setStorLocId(slId);
					mBean.setQtyAval(qty);
					flag = inspLotResService.saveOrUpdateMatStock(mBean);
				}
				}
				flag = inspLotResService.updateInspLotResult(upBean);
			}
			if (flag == true) {
				inspUpadted = "Inspection Lot Result Data Updated Successfully";

			} else {
				inspUpadted = "Inspection Lot Result Data Updation Failed";
				return "redirect:inspLotResHome.mnt?updateLotFail="
						+ inspUpadted + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:inspLotResHome.mnt?updateLotFail=" + inspUpadted
					+ "";
		}

		return "redirect:inspLotResHome.mnt?updateLotsus=" + inspUpadted + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "InspLotResult";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/inspResAdvanceSearch", method = RequestMethod.GET)
	public String inspAdvanceSearch(
			@ModelAttribute("inspLotResCmd") InspLotResultBean st,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		List<Object[]> objArray = null;
		List<InspLotResultBean> stList = new ArrayList<InspLotResultBean>();
		List<InspLotResultBean> refList = new ArrayList<InspLotResultBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("InspLotResult");

			for (Object[] object : objArray) {
				InspLotResultBean s = new InspLotResultBean();
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
		return "inspLotResHome";
	}

	@RequestMapping(value = "/inspResAdvanceSearchOperations", method = RequestMethod.GET)
	public String inspAdvanceSearchOperations(
			@ModelAttribute("inspLotResCmd") InspLotResultBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model, ModelMap map) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<InspLotResultBean> LOTList = new ArrayList<InspLotResultBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = inspLotResService.advSearchInspLotResult(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = inspLotResService.searchInspLotResult();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			InspLotResultBean dnb = new InspLotResultBean();
			dnb.setInspLotResultId((Integer) objects[0]);
			InspectionLotBean insp = ((InspectionLotBean) objects[10]);
			dnb.setInspLotNoId(insp.getInspLotNo());
			dnb.setStartDate(dateService.dateFormat(
					dateService.dateParse((String) objects[2], "se"), "se"));
			dnb.setEndDate(dateService.dateFormat(
					dateService.dateParse((String) objects[3], "se"), "se"));
			dnb.setInspected((String) objects[4]);
			dnb.setAccepted((String) objects[5]);
			dnb.setNonConf((String) objects[6]);
			dnb.setMean((String) objects[7]);
			dnb.setStdValue((String) objects[8]);
			dnb.setSkip((Boolean) objects[9]);
			InspectionDecision pd = (InspectionDecision) objects[11];
			dnb.setInspDecisionId(pd.getDecision());
			LOTList.add(dnb);
		}
		request.setAttribute("LOTList", LOTList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("inspLotResCmd", new InspLotResultBean());
		return "inspLotResHome";
	}

}
*/