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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.GoodsReceiptLine;
import com.mnt.erp.bean.InspLotEqpBean;
import com.mnt.erp.bean.InspectionLotBean;
import com.mnt.erp.bean.InspectionType;
import com.mnt.erp.bean.InsplotOrigin;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.InspectionLotService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 07-01-2014
 */

@Controller
public class InspectionLotController {
	private static final Logger log = Logger
			.getLogger(InspectionLotController.class);
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	InspectionLotService inspLotService;
	@Autowired
	PopulateService populateService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	List<Object[]> list = null;
	Iterator<Object[]> itr = null;
	Object[] objects = null;
	List<Object> obj = null;
	String message = null;
	HttpSession session = null;
	boolean flag = true;

	@RequestMapping(value = "/inspLotHome", method = RequestMethod.GET)
	public ModelAndView inspLotHome(
			@ModelAttribute("inspLotCmd") InspectionLotBean inspLotBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("inspLotHome.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("inspLotHome", "inspLotCmd", inspLotBean);
	}

	@RequestMapping(value = "/getMaterialIds", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> populatMaterialIds(@RequestParam("refNo") String refNo) {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.material_Id,m.materialName from GoodsReceiptLine grl,Material m where grl.goodsReceipt_Id='"
							+ refNo + "' and m.material_Id=grl.material_Id");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("materialSelect")
	public Map<Integer, String> populatMatIds() {
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

	@ModelAttribute("PlantSelect")
	public Map<Integer, String> populatPlantIds() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.plantId,p.plantName from Plant p");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("inspTypeSelect")
	public Map<Integer, String> populatinspTypeIds() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.inspectionTypeId,p.inspectionType from InspectionType p");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("InsplotOriginSelect")
	public Map<Integer, String> populatInsplotOriginIds() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.insplotoriginId,p.insplotorigin from InsplotOrigin p");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("statusSelect")
	public Map<Integer, String> populatStatusIds() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.statusId,s.status from Status s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("equipmentSelect")
	public Map<Integer, String> populatEquipment() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select e.equipmentId,e.equipmentName from EquipmentBean e");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/getRefNos", method = RequestMethod.POST)
	public @ResponseBody
	Map<Integer, String> populateRefNo(
			@RequestParam("lotOriginId") String lotOriginId) {
		String origin = null;
		if (lotOriginId.equals("1")) {
			origin = "Purchase Order";
		} else if (lotOriginId.equals("2")) {
			origin = "Goods Receipt";

		} else if (lotOriginId.equals("3")) {
			origin = "GRWOPO";
		} else if (lotOriginId.equals("4")) {
			origin = "PRD";
		} else {
			origin = "ST";
		}
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select distinct gr.goodsReceipt_Id,gr.goodsReceiptTypeNum from GoodsReceipt gr,GoodsReceiptType grt where grt.goodsReceiptTypeId=gr.goodsReceiptType_Id and grt.goodsReceiptType='"
							+ origin + "'");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("refNos")
	public Map<Integer, String> populateRefNos() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select distinct gr.goodsReceipt_Id,gr.goodsReceiptTypeNum from GoodsReceipt gr  ");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/getBatchNo", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> populatBatchNos(@RequestParam("materialId") String matId) {
		Map<String, String> map = null;
		try {
			map = populateService
					.populatePopUp("select distinct grl.batchNo,grl.batchNo from GoodsReceiptLine grl where grl.material_Id='"
							+ matId + "'");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("selectBatchNos")
	public Map<String, String> populatBNos() {
		Map<String, String> map = null;
		try {
			map = populateService
					.populatePopUp("select distinct grl.batchNo,grl.batchNo from GoodsReceiptLine grl");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/getGRLQty", method = RequestMethod.POST)
	public @ResponseBody
	float forAvalQty(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("batchNo") String bId) {
		response.setCharacterEncoding("UTF-8");
		int matId = 0;
		if (!request.getParameter("materialId").equals("")) {
			matId = Integer.parseInt(request.getParameter("materialId"));
		}
		float avalQty = 0;
		List<GoodsReceiptLine> grlBean = null;
		try {
			grlBean = inspLotService.getAvlQty(matId, bId);
			if (grlBean != null) {
				for (GoodsReceiptLine ms : grlBean) {
					avalQty = ms.getQtyAccepted();
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		return avalQty;

	}

	@RequestMapping(value = "/checkLotAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkLotAddDuplicate(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("inspLotNo") String inspNo) {
		response.setCharacterEncoding("UTF-8");
		Long checkCustName = inspLotService.checkInspectionLotCout(inspNo);
		if (checkCustName != 0) {
			message = "Warning ! Inspection Lot No is Already exists. Please try some other name";
		} else {
			message = "";
		}
		return message;
	}

	@RequestMapping(value = "/checkLotUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkLotUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("inspLotNo") String inspNo,
			@RequestParam("inspLotNoId") int inspId) {
		response.setCharacterEncoding("UTF-8");
		String message = null;
		long checkCustName = inspLotService.updateCheckInspectionLot(inspNo,
				inspId);
		if (checkCustName != 0) {
			message = "Warning ! Inspection Lot No is Already exists. Please try some other name";
		} else {
			message = "";
		}
		return message;
	}

	@RequestMapping(value = "/inspLotAdd", method = RequestMethod.POST)
	public String saveInspLot(
			@ModelAttribute("inspLotCmd") InspectionLotBean inspBean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<InspLotEqpBean> eqpList = new ArrayList<InspLotEqpBean>();
		String inspSave = null;
		try {
			InspectionLotBean addBean = (InspectionLotBean) inspBean;
			String[] eqpId = addBean.getEquipmentId();
			if (eqpId != null) {
				for (int a = 0; a < eqpId.length; a++) {
					InspLotEqpBean lotEqp = new InspLotEqpBean();
					lotEqp.setEquipmentId(eqpId[a]);
					eqpList.add(lotEqp);
				}
				addBean.setInspLotEqpList(eqpList);
			}

			flag = inspLotService.saveInspectionLotDetails(addBean);

			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Inspection Lot", "ROW", String
						.valueOf(addBean.getInspLotNoId()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				inspSave = "Inspection Lot Data Saved Successfully";

			} else {
				inspSave = "Inspection Lot Data Insertion Failures";
				return "redirect:inspLotHome.mnt?addLotFail=" + inspSave + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:inspLotHome.mnt?addLotFail=" + inspSave + "";
		}

		return "redirect:inspLotHome.mnt?addLotsus=" + inspSave + "";

	}

	@RequestMapping(value = "/inspLotSearch", method = RequestMethod.GET)
	public String searchInspLot(
			@ModelAttribute("inspLotCmd") InspectionLotBean inspLotBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<InspectionLotBean> LOTList = new ArrayList<InspectionLotBean>();
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
				list = inspLotService.searchInspectionLot();

			} else {

				list = inspLotService.basicSearchInspectionLot(dbField,
						operation, basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				InspectionLotBean dnb = new InspectionLotBean();
				dnb.setInspLotNoId((Integer) objects[0]);
				dnb.setInspLotNo((String) objects[1]);
				dnb.setRefNo((String) objects[2]);
				dnb.setQuantity((String) objects[3]);
				dnb.setDesc((String) objects[4]);
				Plant p = ((Plant) objects[5]);
				dnb.setPlantId(p.getPlantName());
				Material m = ((Material) objects[6]);
				dnb.setMaterialId(m.getMaterialName());
				Uom u = ((Uom) objects[7]);
				dnb.setUomId(u.getUom());
				InspectionType insp = ((InspectionType) objects[8]);
				dnb.setInspTypeId(insp.getInspectionType());
				InsplotOrigin inlot = ((InsplotOrigin) objects[9]);
				dnb.setInspLotOriginId(inlot.getInsplotorigin());
				Status st = ((Status) objects[10]);
				dnb.setStatusId(st.getStatus());
				dnb.setBatchNo((String) objects[11]);

				LOTList.add(dnb);
			}
			request.setAttribute("LOTList", LOTList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "inspLotHome";

	}

	@RequestMapping(value = "/inspLotDelete", method = RequestMethod.GET)
	public String inspLotDelete(
			@ModelAttribute("inspLotCmd") InspectionLotBean inspLotBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String inspLotDelete = null;
		int inspId = Integer.parseInt(request.getParameter("inspLotNoId"));
		try {
			flag = inspLotService.deleteInspectionLot(inspId);
			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Inspection Lot", "ROW", String
						.valueOf(inspId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				inspLotDelete = "Inspection Lot Deleted Successfully";

			} else {
				inspLotDelete = "Inspection Lot Deletion Failed due to Conatraint Violation";
				return "redirect:inspLotHome.mnt?DeleteLotFail="
						+ inspLotDelete + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:inspLotHome.mnt?DeleteLotFail=" + inspLotDelete
					+ "";
		}
		return "redirect:inspLotHome.mnt?DeleteLotsus=" + inspLotDelete + "";

	}

	@RequestMapping(value = "/inspLotEdit", method = RequestMethod.GET)
	public String inspLotEdit(
			@ModelAttribute("inspLotCmd") InspectionLotBean salesEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("inspLotNoId"));
		List<InspectionLotBean> inspLotBean = new ArrayList<InspectionLotBean>();
		List<InspLotEqpBean> inspLotEqp = new ArrayList<InspLotEqpBean>();
		InspectionLotBean isp = null;
		try {
			obj = inspLotService.searchInspectionLotWithId(id);
			Iterator<Object> iterator = obj.iterator();
			while (iterator.hasNext()) {
				Object obj = iterator.next();
				isp = (InspectionLotBean) obj;
				inspLotBean.add(isp);
				for (InspLotEqpBean eqp : isp.getInspLotEqpList()) {
					InspLotEqpBean loteqp = new InspLotEqpBean();
					loteqp.setInspLotEqpId(eqp.getInspLotEqpId());
					loteqp.setEquipmentId(eqp.getEquipmentId());
					EquipmentBean eb = (EquipmentBean) eqp.getEqpBean();
					loteqp.setEqpName(eb.getEquipmentName());
					inspLotEqp.add(loteqp);
				}
			}
			model.addAttribute("inspLotCmd", isp);
			request.setAttribute("inspLotEdit", inspLotBean);
			request.setAttribute("inspLotEqpEdit", inspLotEqp);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			obj = null;
		}
		return "inspLotHome";

	}

	@RequestMapping(value = "/inspLotUpdate", method = RequestMethod.POST)
	public String inspLotUpdate(
			@ModelAttribute("inspLotCmd") InspectionLotBean inspUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String inspUpadted = null;
		List<InspLotEqpBean> eqpList = new ArrayList<InspLotEqpBean>();
		try {
			InspectionLotBean upBean = (InspectionLotBean) inspUpdate;
			String[] eqpId = upBean.getEquipmentId();
			int[] lotEqpId = upBean.getInspLotEqpId();
			String childEqp = "", no = "1";
			int ed = 0;
			if (eqpId != null) {
				for (int a = 0; a < eqpId.length; a++) {
					int qId = lotEqpId[a];
					if (qId == 0) {
						InspLotEqpBean lotEqp = new InspLotEqpBean();
						lotEqp.setEquipmentId(eqpId[a]);
						eqpList.add(lotEqp);
					} else {
						InspLotEqpBean lotEqp = new InspLotEqpBean();
						lotEqp.setEquipmentId(eqpId[a]);
						ed = lotEqpId[a];
						childEqp = request.getParameter(ed + "Check");
						if (no.equals(childEqp)) {
							flag = inspLotService.deleteInspectionLotEqp(ed);
						} else {
							eqpList.add(lotEqp);
						}
					}

				}
				upBean.setInspLotEqpList(eqpList);
			}
			flag = inspLotService.updateInspectionLot(upBean);

			if (flag == true) {
				inspUpadted = "Inspection Lot Data Updated Successfully";

			} else {
				inspUpadted = "Inspection Lot Data Updation Failed";
				return "redirect:inspLotHome.mnt?updateLotFail=" + inspUpadted
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:inspLotHome.mnt?updateLotFail=" + inspUpadted + "";
		}

		return "redirect:inspLotHome.mnt?updateLotssus=" + inspUpadted + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "inspLotId";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/inspAdvanceSearch", method = RequestMethod.GET)
	public String inspAdvanceSearch(
			@ModelAttribute("inspLotCmd") InspectionLotBean st,
			HttpServletRequest request, HttpServletResponse response) {
		List<Object[]> objArray = null;
		List<InspectionLotBean> stList = new ArrayList<InspectionLotBean>();
		List<InspectionLotBean> refList = new ArrayList<InspectionLotBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("inspLotId");

			for (Object[] object : objArray) {
				InspectionLotBean s = new InspectionLotBean();
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
		request.setAttribute("stAdv", stList);
		request.setAttribute("refList", refList);
		return "inspLotHome";
	}

	@RequestMapping(value = "/inspAdvanceSearchOperations", method = RequestMethod.GET)
	public String inspAdvanceSearchOperations(
			@ModelAttribute("inspLotCmd") InspectionLotBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model, ModelMap map) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<InspectionLotBean> LOTList = new ArrayList<InspectionLotBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = inspLotService.advSearchInspectionLot(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = inspLotService.searchInspectionLot();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			InspectionLotBean dnb = new InspectionLotBean();
			dnb.setInspLotNoId((Integer) objects[0]);
			dnb.setInspLotNo((String) objects[1]);
			dnb.setRefNo((String) objects[2]);
			dnb.setQuantity((String) objects[3]);
			dnb.setDesc((String) objects[4]);
			Plant p = ((Plant) objects[5]);
			dnb.setPlantId(p.getPlantName());
			Material m = ((Material) objects[6]);
			dnb.setMaterialId(m.getMaterialName());
			Uom u = ((Uom) objects[7]);
			dnb.setUomId(u.getUom());
			InspectionType insp = ((InspectionType) objects[8]);
			dnb.setInspTypeId(insp.getInspectionType());
			InsplotOrigin inlot = ((InsplotOrigin) objects[9]);
			dnb.setInspLotOriginId(inlot.getInsplotorigin());
			Status st = ((Status) objects[10]);
			dnb.setStatusId(st.getStatus());
			dnb.setBatchNo((String) objects[11]);

			LOTList.add(dnb);
		}
		request.setAttribute("LOTList", LOTList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("inspLotCmd", new InspectionLotBean());
		return "inspLotHome";
	}

}
