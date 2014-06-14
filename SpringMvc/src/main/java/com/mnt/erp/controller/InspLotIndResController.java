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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Code;
import com.mnt.erp.bean.CodeGroup;
import com.mnt.erp.bean.DefectClassBean;
import com.mnt.erp.bean.DefectTypeBean;
import com.mnt.erp.bean.InspCharacteristic;
import com.mnt.erp.bean.InspLotIndResBean;
import com.mnt.erp.bean.InspLotIndResLine;
import com.mnt.erp.bean.InspLotResultBean;
import com.mnt.erp.bean.InspectionDecision;
import com.mnt.erp.bean.InspectionLotBean;
import com.mnt.erp.bean.ProcessDetailBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.InspLotIndResService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 17-05-2014
 */
@Controller
public class InspLotIndResController {
	private static final Logger log = Logger
			.getLogger(InspLotIndResController.class);

	@Autowired
	InspLotIndResService inspLotIndResService;
	@Autowired
	XmlLabelsService xmlService;
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

	@RequestMapping(value = "/inspLotIndResHome", method = RequestMethod.GET)
	public ModelAndView inspLotIndResHome(
			@ModelAttribute("inspLotIndResCmd") InspLotIndResBean inspLotIndResBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("inspLotIndResHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("inspLotIndResHome", "inspLotIndResCmd",
				inspLotIndResBean);
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

	@ModelAttribute("ProcessDetail")
	public Map<Integer, String> populatProcDetail() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select pd.processdetailid,pd.processdescription from ProcessDetailBean pd");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("InspChar")
	public Map<Integer, String> populatInspChar() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select c.inspCharacteristicId,c.inspCharacteristic from InspCharacteristic c");

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

	@ModelAttribute("DefectSelect")
	public Map<Integer, String> populatDefectCls() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.defectClassId,m.defectClass from DefectClassBean m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("DefectType")
	public Map<Integer, String> populatDefectType() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select d.defecttypeid,d.defecttype from DefectTypeBean d");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("CodeGrp")
	public Map<Integer, String> populatCodeGrp() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select d.codeGroup_Id,d.codeGroup from CodeGroup d");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("CodeSelect")
	public Map<Integer, String> populatCode() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select c.codeId,c.code from Code c");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/inspLotIndResAdd", method = RequestMethod.POST)
	public String saveInspLotIndRes(
			@ModelAttribute("inspLotIndResCmd") InspLotIndResBean inspBean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<InspLotIndResLine> resLineList = new ArrayList<InspLotIndResLine>();
		String inspSave = null;
		try {
			InspLotIndResBean addBean = (InspLotIndResBean) inspBean;
			String[] codeGrpId = addBean.getCodeGrpId();
			String[] code = addBean.getCodeId();
			String[] defect = addBean.getDefectClsId();
			String[] defType = addBean.getDefectTypeId();
			String[] defLoc = addBean.getDefectLoc();
			String[] inspChar = addBean.getInspCharId();
			String[] inDec = addBean.getInspDecisionId();
			String[] lLimit = addBean.getLowerLimit();
			String[] uLimit = addBean.getUpperLimit();
			String[] maxTol = addBean.getMaxTolerance();
			String[] minTol = addBean.getMinTolerance();
			String[] sNo = addBean.getSampleNo();
			String[] uomId = addBean.getUomId();
			String[] val = addBean.getValuation();
			Double[] mVal = addBean.getMeasuredVal();
			if (inspChar != null) {
				for (int a = 0; a < inspChar.length; a++) {
					InspLotIndResLine lotRes = new InspLotIndResLine();
					lotRes.setInspCharId(inspChar[a]);
					lotRes.setDefectClsId(defect[a]);
					lotRes.setCodeGrpId(codeGrpId[a]);
					lotRes.setCodeId(code[a]);
					lotRes.setDefectLoc(defLoc[a]);
					lotRes.setDefectTypeId(defType[a]);
					lotRes.setInspDecisionId(inDec[a]);
					lotRes.setLowerLimit(lLimit[a]);
					lotRes.setUpperLimit(uLimit[a]);
					lotRes.setMaxTolerance(maxTol[a]);
					lotRes.setMinTolerance(minTol[a]);
					lotRes.setMeasuredVal(mVal[a]);
					lotRes.setValuation(val[a]);
					lotRes.setUomId(uomId[a]);
					lotRes.setSampleNo(sNo[a]);
					resLineList.add(lotRes);
				}
				addBean.setInspLotIndResList(resLineList);
			}

			flag = inspLotIndResService.saveInspLotIndRes(addBean);

			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Inspection Lot Ind Result", "ROW",
						String.valueOf(addBean.getInspLotIndResId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				inspSave = "Inspection Lot Individual Result Data Saved Successfully";

			} else {
				inspSave = "Inspection Lot Individual Result Data Insertion Failures";
				return "redirect:inspLotIndResHome.mnt?addLotFail=" + inspSave
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:inspLotIndResHome.mnt?addLotFail=" + inspSave + "";
		}

		return "redirect:inspLotIndResHome.mnt?addLotsus=" + inspSave + "";

	}

	@RequestMapping(value = "/inspLotIndResSearch", method = RequestMethod.GET)
	public String searchInspLotIndRes(
			@ModelAttribute("inspLotIndResCmd") InspLotIndResBean inspLotBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<InspLotIndResBean> LOTList = new ArrayList<InspLotIndResBean>();
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
				list = inspLotIndResService.searchInspLotIndRes();

			} else {

				list = inspLotIndResService.basicSearchInspLotIndRes(dbField,
						operation, Double.parseDouble(basicSearchId));
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				InspLotIndResBean insp = new InspLotIndResBean();
				insp.setInspLotIndResId((Integer) objects[0]);
				insp.setInspect((Double) objects[1]);
				insp.setInspected((Double) objects[2]);
				InspectionLotBean lot = (InspectionLotBean) objects[3];
				insp.setInspLotId(lot.getInspLotNo());
				ProcessDetailBean pd = (ProcessDetailBean) objects[4];
				insp.setProcessDetailId(pd.getProcessdescription());

				LOTList.add(insp);
			}
			request.setAttribute("LOTList", LOTList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "inspLotIndResHome";

	}

	@RequestMapping(value = "/inspLotIndResDelete", method = RequestMethod.GET)
	public String inspLotIndResDelete(
			@ModelAttribute("inspLotIndResCmd") InspLotIndResBean inspLotBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String inspLotDelete = null;
		int inspId = Integer.parseInt(request.getParameter("inspLotIndResId"));
		try {
			flag = inspLotIndResService.deleteInspLotIndRes(inspId);
			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Inspection Lot Individual Result",
						"ROW", String.valueOf(inspId), "1", modifiedDate,
						session.getAttribute("userName").toString());
				inspLotDelete = "Inspection Lot Individual Result Deleted Successfully";

			} else {
				inspLotDelete = "Inspection Lot Individual Result Deletion Failed due to Conatraint Violation";
				return "redirect:inspLotIndResHome.mnt?DeleteLotFail="
						+ inspLotDelete + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:inspLotIndResHome.mnt?DeleteLotFail="
					+ inspLotDelete + "";
		}
		return "redirect:inspLotIndResHome.mnt?DeleteLotsus=" + inspLotDelete
				+ "";

	}

	@RequestMapping(value = "/inspLotIndResEdit", method = RequestMethod.GET)
	public String inspLotIndResEdit(
			@ModelAttribute("inspLotIndResCmd") InspLotIndResBean inspEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("inspLotIndResId"));
		List<InspLotIndResBean> inspLotBean = new ArrayList<InspLotIndResBean>();
		List<InspLotIndResLine> inspLotLine = new ArrayList<InspLotIndResLine>();
		InspLotIndResBean insp = null;
		try {
			obj = inspLotIndResService.searchInspLotIndResWithId(id);
			Iterator<Object> iterator = obj.iterator();
			while (iterator.hasNext()) {
				Object obj = iterator.next();
				insp = (InspLotIndResBean) obj;
				inspLotBean.add(insp);
				for (InspLotIndResLine eqp : insp.getInspLotIndResList()) {
					InspLotIndResLine lotLine = new InspLotIndResLine();
					lotLine.setInspLotIndResLineId(eqp.getInspLotIndResLineId());
					lotLine.setCodeGrpId(eqp.getCodeGrpId());
					lotLine.setCodeId(eqp.getCodeId());
					lotLine.setDefectClsId(eqp.getDefectClsId());
					lotLine.setDefectLoc(eqp.getDefectLoc());
					lotLine.setDefectTypeId(eqp.getDefectTypeId());
					lotLine.setMaxTolerance(eqp.getMaxTolerance());
					lotLine.setMinTolerance(eqp.getMinTolerance());
					lotLine.setMeasuredVal(eqp.getMeasuredVal());
					lotLine.setInspCharId(eqp.getInspCharId());
					lotLine.setInspDecisionId(eqp.getInspDecisionId());
					lotLine.setLowerLimit(eqp.getLowerLimit());
					lotLine.setUpperLimit(eqp.getUpperLimit());
					lotLine.setUomId(eqp.getUomId());
					lotLine.setSampleNo(eqp.getSampleNo());
					lotLine.setValuation(eqp.getValuation());
					InspCharacteristic ic = (InspCharacteristic) eqp
							.getInspCharBean();
					lotLine.setInspCharName(ic.getInspCharacteristic());
					Uom u = (Uom) eqp.getUomBean();
					lotLine.setUomName(u.getUom());
					DefectClassBean dc = (DefectClassBean) eqp.getDefClsBean();
					lotLine.setDefClsName(dc.getDefectClass());
					DefectTypeBean dt = (DefectTypeBean) eqp.getDefTypeBean();
					lotLine.setDefTypeName(dt.getDefecttype());
					CodeGroup cg = (CodeGroup) eqp.getCodeGrpBean();
					lotLine.setCodeGrpName(cg.getCodeGroup());
					Code c = (Code) eqp.getCodeBean();
					lotLine.setCodeName(c.getCode());
					inspLotLine.add(lotLine);
				}
			}
			model.addAttribute("inspLotIndResCmd", insp);
			request.setAttribute("inspLotEdit", inspLotBean);
			request.setAttribute("inspLotLineEdit", inspLotLine);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			obj = null;
		}
		return "inspLotIndResHome";

	}

	@RequestMapping(value = "/inspLotIndResUpdate", method = RequestMethod.POST)
	public String inspLotIndResUpdate(
			@ModelAttribute("inspLotIndResCmd") InspLotIndResBean inspUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String inspUpadted = null;
		List<InspLotIndResLine> lineList = new ArrayList<InspLotIndResLine>();
		try {
			InspLotIndResBean upBean = (InspLotIndResBean) inspUpdate;
			String childEqp = "", no = "1";
			int ed = 0;
			int[] resLineId = upBean.getInspLotIndResLineId();
			String[] codeGrpId = upBean.getCodeGrpId();
			String[] code = upBean.getCodeId();
			String[] defect = upBean.getDefectClsId();
			String[] defType = upBean.getDefectTypeId();
			String[] defLoc = upBean.getDefectLoc();
			String[] inspChar = upBean.getInspCharId();
			String[] inDec = upBean.getInspDecisionId();
			String[] lLimit = upBean.getLowerLimit();
			String[] uLimit = upBean.getUpperLimit();
			String[] maxTol = upBean.getMaxTolerance();
			String[] minTol = upBean.getMinTolerance();
			String[] sNo = upBean.getSampleNo();
			String[] uomId = upBean.getUomId();
			String[] val = upBean.getValuation();
			Double[] mVal = upBean.getMeasuredVal();
			if (inspChar != null) {
				for (int a = 0; a < inspChar.length; a++) {

					int qId = resLineId[a];
					if (qId == 0) {
						InspLotIndResLine lotRes = new InspLotIndResLine();
						lotRes.setInspCharId(inspChar[a]);
						lotRes.setDefectClsId(defect[a]);
						lotRes.setCodeGrpId(codeGrpId[a]);
						lotRes.setCodeId(code[a]);
						lotRes.setDefectLoc(defLoc[a]);
						lotRes.setDefectTypeId(defType[a]);
						lotRes.setInspDecisionId(inDec[a]);
						lotRes.setLowerLimit(lLimit[a]);
						lotRes.setUpperLimit(uLimit[a]);
						lotRes.setMaxTolerance(maxTol[a]);
						lotRes.setMinTolerance(minTol[a]);
						lotRes.setMeasuredVal(mVal[a]);
						lotRes.setValuation(val[a]);
						lotRes.setUomId(uomId[a]);
						lotRes.setSampleNo(sNo[a]);
						lineList.add(lotRes);
					} else {
						InspLotIndResLine lotRes = new InspLotIndResLine();
						lotRes.setInspCharId(inspChar[a]);
						lotRes.setDefectClsId(defect[a]);
						lotRes.setCodeGrpId(codeGrpId[a]);
						lotRes.setCodeId(code[a]);
						lotRes.setDefectLoc(defLoc[a]);
						lotRes.setDefectTypeId(defType[a]);
						lotRes.setInspDecisionId(inDec[a]);
						lotRes.setLowerLimit(lLimit[a]);
						lotRes.setUpperLimit(uLimit[a]);
						lotRes.setMaxTolerance(maxTol[a]);
						lotRes.setMinTolerance(minTol[a]);
						lotRes.setMeasuredVal(mVal[a]);
						lotRes.setValuation(val[a]);
						lotRes.setUomId(uomId[a]);
						lotRes.setSampleNo(sNo[a]);
						ed = resLineId[a];
						childEqp = request.getParameter(ed + "Check");
						if (no.equals(childEqp)) {
							flag = inspLotIndResService
									.deleteInspLotIndResLine(ed);
						} else {
							lineList.add(lotRes);
						}
					}
				}
				upBean.setInspLotIndResList(lineList);
			}
			flag = inspLotIndResService.updateInspLotIndRes(upBean);

			if (flag == true) {
				inspUpadted = "Inspection Lot Individual Result Data Updated Successfully";

			} else {
				inspUpadted = "Inspection Lot Individual Result Data Updation Failed";
				return "redirect:inspLotIndResHome.mnt?updateLotFail="
						+ inspUpadted + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:inspLotIndResHome.mnt?updateLotFail="
					+ inspUpadted + "";
		}

		return "redirect:inspLotIndResHome.mnt?updateLotssus=" + inspUpadted
				+ "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "inspLotIndRes";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/inspIndAdvanceSearch", method = RequestMethod.GET)
	public String inspAdvanceSearch(
			@ModelAttribute("inspLotIndResCmd") InspLotIndResBean st,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		List<Object[]> objArray = null;
		List<InspLotIndResBean> stList = new ArrayList<InspLotIndResBean>();
		List<InspLotIndResBean> refList = new ArrayList<InspLotIndResBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("inspLotIndRes");

			for (Object[] object : objArray) {
				InspLotIndResBean s = new InspLotIndResBean();
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
		return "inspLotIndResHome";
	}

	@RequestMapping(value = "/inspIndAdvanceSearchOperations", method = RequestMethod.GET)
	public String inspAdvanceSearchOperations(
			@ModelAttribute("inspLotIndResCmd") InspLotIndResBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model, ModelMap map) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<InspLotIndResBean> LOTList = new ArrayList<InspLotIndResBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = inspLotIndResService.advSearchInspLotIndRes(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = inspLotIndResService.searchInspLotIndRes();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			InspLotIndResBean insp = new InspLotIndResBean();
			insp.setInspLotIndResId((Integer) objects[0]);
			insp.setInspect((Double) objects[1]);
			insp.setInspected((Double) objects[2]);
			InspectionLotBean lot = (InspectionLotBean) objects[3];
			insp.setInspLotId(lot.getInspLotNo());
			ProcessDetailBean pd = (ProcessDetailBean) objects[4];
			insp.setProcessDetailId(pd.getProcessdescription());

			LOTList.add(insp);
		}
		request.setAttribute("LOTList", LOTList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("inspLotIndResCmd", new InspLotIndResBean());
		return "inspLotIndResHome";
	}

}
