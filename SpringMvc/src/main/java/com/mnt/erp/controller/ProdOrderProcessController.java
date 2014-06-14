/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.ProcessDetailBean;
import com.mnt.erp.bean.ProdOrderProcessBean;
import com.mnt.erp.bean.ProdOrderProcessEqp;
import com.mnt.erp.bean.ProdProcessEmpBean;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.WorkCenter;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.ProdOrderProcessService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 14-05-2014
 */
@Controller
public class ProdOrderProcessController {
	public static final Logger log = Logger
			.getLogger(ProdOrderProcessController.class);

	@Autowired
	ProdOrderProcessService popService;
	@Autowired
	XmlLabelsService xmlService;
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
	String message = null;
	boolean flag = true;

	@RequestMapping(value = "/popHome", method = RequestMethod.GET)
	public ModelAndView popHome(
			@ModelAttribute("popCmd") ProdOrderProcessBean prodOdrProcessBean,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("popHome.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("popHome", "popCmd", prodOdrProcessBean);

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

	@ModelAttribute("productionOrder")
	public Map<Integer, String> populatProdOdrs() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select po.prodOrderId,po.prodOrderNo from ProductionOrderBean po");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("processDetail")
	public Map<Integer, String> populatProcessDetail() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select pd.processdetailid,pd.processdescription from ProcessDetailBean pd");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("workCenter")
	public Map<Integer, String> populatWorkCenter() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select wc.workCenter_Id,wc.workCenterName from WorkCenter wc");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("employeeSelect")
	public Map<Integer, String> populatEmployee() {
		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select e.employee_Id,e.employeeNo from Employee e");

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

	@RequestMapping(value = "/popAdd", method = RequestMethod.POST)
	public String saveProdOdrProcess(
			@ModelAttribute("popCmd") ProdOrderProcessBean savePopBean,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ParseException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		List<ProdProcessEmpBean> popEmpList = new ArrayList<ProdProcessEmpBean>();
		Set<ProdOrderProcessEqp> popEqpList = new HashSet<ProdOrderProcessEqp>();

		String empId[] = savePopBean.getEmpId();
		String[] eqpId = savePopBean.getEquipmentId();
		String[] uomId = savePopBean.getUomId();
		Double[] eCost = savePopBean.getEstimatedCost();
		ProdOrderProcessBean popBean = (ProdOrderProcessBean) savePopBean;
		popBean.setStartDate(dateService.dateFormat(
				dateService.dateParse(popBean.getStartDate(), "au"), "au"));
		popBean.setEndDate(dateService.dateFormat(
				dateService.dateParse(popBean.getEndDate(), "au"), "au"));

		if (empId != null) {
			for (int n = 0; n < empId.length; n++) {
				ProdProcessEmpBean emp = new ProdProcessEmpBean();
				emp.setEmpId(empId[n]);
				popEmpList.add(emp);
			}
			popBean.setPopEmp(popEmpList);
		}
		if (eqpId != null) {
			for (int m = 0; m < eqpId.length; m++) {
				ProdOrderProcessEqp eqp = new ProdOrderProcessEqp();
				eqp.setEquipmentId(eqpId[m]);
				eqp.setUomId(uomId[m]);
				eqp.setEstimatedCost(eCost[m]);
				popEqpList.add(eqp);
			}
			popBean.setPopEqp(popEqpList);
		}
		try {
			flag = popService.saveProdOdrProcess(popBean);
			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Customer ", "ROW", String
						.valueOf(popBean.getPopId()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				return "redirect:popHome.mnt?addSus=" + "success" + "";
			} else {
				return "redirect:popHome.mnt?addFail=" + "fail" + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:popHome.mnt?addFail=" + "fail" + "";
		}

	}

	@RequestMapping(value = "/popSearch", method = RequestMethod.GET)
	public String searchPops(
			@ModelAttribute("popCmd") ProdOrderProcessBean popSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ProdOrderProcessBean> popList = new ArrayList<ProdOrderProcessBean>();
		try {

			String dbField = popSearch.getXmlLabel();
			String operation = popSearch.getOperations();
			String basicSearchId = popSearch.getBasicSearchId();

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
				list = popService.searchProdOdrProcess();

			} else {

				list = popService.basicSearchProdOdrProcess(dbField, operation,
						basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				ProdOrderProcessBean dnb = new ProdOrderProcessBean();
				dnb.setPopId((Integer) objects[0]);
				dnb.setStartDate(dateService.dateFormat(
						dateService.dateParse((String) objects[1], "se"), "se"));
				dnb.setEndDate(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));
				ProductionOrderBean pobean = ((ProductionOrderBean) objects[4]);
				dnb.setProdOrderId(pobean.getProdOrderNo());
				ProcessDetailBean pdbean = ((ProcessDetailBean) objects[3]);
				dnb.setProcessDetailId(pdbean.getProcessdescription());
				WorkCenter wcbean = ((WorkCenter) objects[5]);
				dnb.setWorkCenterId(wcbean.getWorkCenterName());
				dnb.setInspPoint((((String) objects[6]).equals("1") ? "True"
						: "False"));

				popList.add(dnb);
			}
			request.setAttribute("popSearch", popList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "popHome";

	}

	@RequestMapping(value = "/popDelete", method = RequestMethod.GET)
	public String popDelete(
			@ModelAttribute("popCmd") ProdOrderProcessBean popDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("popId"));
		HttpSession session = null;
		try {
			flag = popService.deleteProdOdrProcess(id);
			if (flag == true) {
				request.setAttribute("popDelete",
						"Production Order Process has been deleted");
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Production Order Process", "ROW",
						String.valueOf(id), "1", modifiedDate, session
								.getAttribute("userName").toString());
			} else {
				return "redirect:popHome.mnt?deleteFail=" + "fail" + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:popHome.mnt?deleteFail=" + "fail" + "";
		}
		return "redirect:popHome.mnt?deleteSus=" + "success" + "";
	}

	@RequestMapping(value = "/popsEdit", method = RequestMethod.GET)
	public String popEdit(
			@ModelAttribute("popCmd") ProdOrderProcessBean popEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("popId"));
		List<ProdOrderProcessBean> popBean = new ArrayList<ProdOrderProcessBean>();
		Set<ProdProcessEmpBean> empEdit = new HashSet<ProdProcessEmpBean>();
		Set<ProdOrderProcessEqp> eqpEdit = new HashSet<ProdOrderProcessEqp>();
		ProdOrderProcessBean pb = null;
		try {
			obj = popService.searchProdOdrProcessWithId(id);
			Iterator<Object> iterator = obj.iterator();
			if (iterator.hasNext()) {
				Object obj = iterator.next();
				pb = (ProdOrderProcessBean) obj;
				pb.setStartDate(dateService.dateFormat(
						dateService.dateParse(pb.getStartDate(), "se"), "se"));
				pb.setEndDate(dateService.dateFormat(
						dateService.dateParse(pb.getEndDate(), "se"), "se"));
				Set<ProdOrderProcessEqp> popEqp = pb.getPopEqp();
				Iterator<ProdOrderProcessEqp> iterat = popEqp.iterator();
				List<ProdProcessEmpBean> popEmp = pb.getPopEmp();
				Iterator<ProdProcessEmpBean> iter = popEmp.iterator();
				while (iter.hasNext()) {
					ProdProcessEmpBean o = iter.next();
					ProdProcessEmpBean emp = new ProdProcessEmpBean();
					emp.setPopEmpId(o.getPopEmpId());
					emp.setEmpId(o.getEmpId());
					Employee ee = (Employee) o.getEmployee();
					emp.setEmpNo(ee.getEmployeeNo());
					empEdit.add(emp);
				}
				while (iterat.hasNext()) {
					ProdOrderProcessEqp e = iterat.next();
					ProdOrderProcessEqp eqp = new ProdOrderProcessEqp();
					eqp.setPopEqpId(e.getPopEqpId());
					eqp.setEquipmentId(e.getEquipmentId());
					eqp.setUomId(e.getUomId());
					eqp.setEstimatedCost(e.getEstimatedCost());
					Uom u = (Uom) e.getUom();
					eqp.setUomName(u.getUom());
					EquipmentBean q = (EquipmentBean) e.getEquipment();
					eqp.setEqpName(q.getEquipmentName());
					eqpEdit.add(eqp);
				}
				popBean.add(pb);
			}
			model.addAttribute("popCmd", pb);
			request.setAttribute("popEditList", popBean);
			request.setAttribute("empEdit", empEdit);
			request.setAttribute("eqpEdit", eqpEdit);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			obj = null;
		}
		return "popHome";

	}

	@RequestMapping(value = "/popsUpdate", method = RequestMethod.POST)
	public String updatePop(
			@ModelAttribute("popCmd") ProdOrderProcessBean savePopBean,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ParseException {
		response.setCharacterEncoding("UTF-8");
		List<ProdProcessEmpBean> popEmpList = new ArrayList<ProdProcessEmpBean>();
		Set<ProdOrderProcessEqp> popEqpList = new HashSet<ProdOrderProcessEqp>();

		String empId[] = savePopBean.getEmpId();

		String[] eqpId = savePopBean.getEquipmentId();
		String[] uomId = savePopBean.getUomId();
		Double[] eCost = savePopBean.getEstimatedCost();
		int[] popEmpId = savePopBean.getPopEmpId();
		int[] popEqpId = savePopBean.getPopEqpId();
		ProdOrderProcessBean popBean = (ProdOrderProcessBean) savePopBean;
		popBean.setStartDate(dateService.dateFormat(
				dateService.dateParse(popBean.getStartDate(), "au"), "au"));
		popBean.setEndDate(dateService.dateFormat(
				dateService.dateParse(popBean.getEndDate(), "au"), "au"));
		String childDelete = "", childEqp = "", ss = "1";
		int id = 0;
		int ed = 0;

		if (empId != null) {
			for (int n = 0; n < empId.length; n++) {
				int eId = popEmpId[n];
				if (eId == 0) {
					ProdProcessEmpBean emp = new ProdProcessEmpBean();
					emp.setEmpId(empId[n]);
					popEmpList.add(emp);
				} else {
					ProdProcessEmpBean emp = new ProdProcessEmpBean();
					emp.setEmpId(empId[n]);
					id = popEmpId[n];
					childDelete = request.getParameter("checkEmp" + id);
					if (ss.equals(childDelete)) {
						flag = popService.deleteProdOdrProcessEmp(id);
					} else {
						popEmpList.add(emp);
					}
				}

			}
			popBean.setPopEmp(popEmpList);
		}
		if (eqpId != null) {
			for (int m = 0; m < eqpId.length; m++) {
				int qId = popEqpId[m];
				if (qId == 0) {
					ProdOrderProcessEqp eqp = new ProdOrderProcessEqp();
					eqp.setEquipmentId(eqpId[m]);
					eqp.setUomId(uomId[m]);
					eqp.setEstimatedCost(eCost[m]);
					popEqpList.add(eqp);
				} else {
					ProdOrderProcessEqp eqp = new ProdOrderProcessEqp();
					eqp.setEquipmentId(eqpId[m]);
					eqp.setUomId(uomId[m]);
					eqp.setEstimatedCost(eCost[m]);
					ed = popEqpId[m];
					childEqp = request.getParameter(ed + "Check");
					if (ss.equals(childEqp)) {
						flag = popService.deleteProdOdrProcessEqp(ed);
					} else {
						popEqpList.add(eqp);
					}

				}

			}
			popBean.setPopEqp(popEqpList);
		}
		try {
			flag = popService.updateProdOdrProcess(popBean);
			if (flag == true) {
				return "redirect:popHome.mnt?updateSus=" + "success" + "";
			} else {
				return "redirect:popHome.mnt?updateFail=" + "fail" + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:popHome.mnt?updateFail=" + "fail" + "";
		}

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "productionOdrProcess";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
