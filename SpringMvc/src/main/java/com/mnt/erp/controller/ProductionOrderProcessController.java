/** 
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.controller;

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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.ProcessDetailBean;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.ProductionOrderProcess;
import com.mnt.erp.bean.WorkCenter;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ProductionOrderProcessService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author sailajach
 * @version 1.0 05-02-2014
 * @build 0.0
 * 
 */

@Controller
public class ProductionOrderProcessController {

	private Logger logger = Logger
			.getLogger(ProductionOrderProcessController.class);

	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	ProductionOrderProcessService productionOrderProcessService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;
	@Autowired
	DateConversionService dateService;

	Object[] objects = null;
	String msg = null;

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "productionOrderProcess";
		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return map;
	}

	/* ================ To Get Production Order Values========= */
	@ModelAttribute("productionOrder")
	public Map<Integer, String> plantIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = productionOrderProcessService.getProductionOrderNo();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return map;
	}

	/* ================ To Get Process Detail Values========= */
	@ModelAttribute("processDetail")
	public Map<Integer, String> getProcessDetail() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = productionOrderProcessService.getProcessDetail();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return map;
	}

	/* ================ To Get Work Center Values========= */
	@ModelAttribute("workCenter")
	public Map<Integer, String> getWorkCenter() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = productionOrderProcessService.getWorkCenterName();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return map;
	}

	@RequestMapping(value = "/productionOrderProcess", method = RequestMethod.GET)
	public ModelAndView getProductionOrderProcess(HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige(
				"productionOrderProcess.mnt", session.getAttribute("userId")
						.toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("productionOrderProcessHome",
				"productionOrderProcessCommand", new ProductionOrderProcess());

	}

	/*
	 * ===========================Duplicate checking for
	 * add========================
	 */
	@RequestMapping(value = "/popDuplicateAddCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkProductionOrderNo(HttpServletRequest request,
			HttpServletResponse response, ProductionOrderProcess pop) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;

		try {

			String before = request.getParameter("productionOrder");
			pname = productionOrderProcessService.checkDuplicate(before);
			if (pname != 0) {
				pop.setAid(2);

				request.setAttribute("addPOPDuplicate",
						"Production Order Number is Already Exists Please try some other number");

				pop.setProductionOrder("");

				msg = "Production Order Number is Already Exists Please try some other number";

			}
			if (pname == 0) {
				pop.setAid(2);
				request.setAttribute("addPOPDuplicate",
						"Production Order Number is Already Exists Please try some other number");
				pop.setProductionOrder("");

				msg = "";

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}

	/* ================================Add Method========================== */
	@RequestMapping(value = "/productionOrderProcessAdd", method = RequestMethod.GET)
	public String addPOP(
			@ModelAttribute("productionOrderProcessCommand") ProductionOrderProcess popAdd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		ProductionOrderProcess pop = null;
		String msg = null;
		String res = null;
		HttpSession session = null;
		int id = popAdd.getProductionOrderProcessId();
		String checkProductionOrderNo = popAdd.getProductionOrder();
		int list1 = productionOrderProcessService
				.checkDuplicate(checkProductionOrderNo);
		if (list1 == 0) {
			try {
				String processDetails = popAdd.getProcessdetailid();

				List<String> pdlist = Arrays.asList(processDetails.split(","));
				Object[] pdid = pdlist.toArray();

				String wCenter = popAdd.getWorkCenter_Id();
				List<String> wclist = Arrays.asList(wCenter.split(","));
				Object[] wcid = wclist.toArray();

				String startDate11 = popAdd.getStartDate();
				String[] startDate = startDate11.split(",");
				String endDate1 = popAdd.getFinishDate();
				String[] endDate = endDate1.split(",");

				for (int i = 0; i < wcid.length; i++) {

					pop = new ProductionOrderProcess();
					pop.setProductionOrder(popAdd.getProductionOrder());
					pop.setProcessdetailid(pdid[i].toString());
					pop.setWorkCenter_Id(wcid[i].toString());
					pop.setStartDate(dateService.dateFormat(
							dateService.dateParse(startDate[i], "au"), "au"));
					pop.setFinishDate(dateService.dateFormat(
							dateService.dateParse(endDate[i], "au"), "au"));

					msg = productionOrderProcessService
							.addProductionOrderProcess(pop);
					if (msg.equals("S")) {
						session = request.getSession(false);
						Date date = new Date();
						String modifiedDate = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(date);
						auditLogService.setAuditLogSave(
								session.getAttribute("userId").toString(), "A",
								"Production Order Process", "ROW", String
										.valueOf(id), "1", modifiedDate,
								session.getAttribute("userName").toString());

						res = "redirect:productionOrderProcess.mnt?list="
								+ "success" + "";
					} else {
						res = "redirect:productionOrderProcess.mnt?listwar="
								+ "fail" + "";
					}

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			popAdd.setAid(1);
			request.setAttribute("addPOPDuplicate",
					"Production Order No is Already Exists Please try some other number");
			return "productionOrderProcessHome";
		}
		return res;
	}

	/*
	 * =============================Search
	 * Method======================================
	 */
	@RequestMapping(value = "/popsSearch", method = RequestMethod.GET)
	@Scope("request")
	public ModelAndView searchProductionOdrProcess(
			@ModelAttribute("productionOrderProcessCommand") ProductionOrderProcess popSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		List<ProductionOrderProcess> pop = null;
		List<Object[]> list = null;
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

				list = productionOrderProcessService
						.searchProductionOrderProcess();
			}

			else {
				list = productionOrderProcessService
						.basicSearchProductionOrderProcess(dbField, operation,
								basicSearchId);
			}

			pop = new ArrayList<ProductionOrderProcess>();
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				ProductionOrderProcess popList = new ProductionOrderProcess();
				popList.setProductionOrderProcessId((Integer) objects[0]);

				ProductionOrderBean pobean = ((ProductionOrderBean) objects[1]);
				popList.setProductionOrder(pobean.getProdOrderNo());

				ProcessDetailBean pdbean = ((ProcessDetailBean) objects[2]);
				popList.setProcessdetailid(pdbean.getProcessdescription());

				WorkCenter wcbean = ((WorkCenter) objects[3]);
				popList.setWorkCenter_Id(wcbean.getWorkCenterName());

				popList.setStartDate(dateService.dateFormat(
						dateService.dateParse((String) objects[4], "se"), "se"));
				popList.setFinishDate(dateService.dateFormat(
						dateService.dateParse((String) objects[5], "se"), "se"));

				pop.add(popList);
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("productionOrderProcessHome");
		modelAndView.addObject("productionOrderProcessCommand");
		request.setAttribute("popSearch", pop);
		return modelAndView;
	}

	/*
	 * =======================Duplicate Checking for
	 * Edit=========================
	 */
	@RequestMapping(value = "/popDuplicateEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkProductionOrderEdit(HttpServletRequest request,
			HttpServletResponse response, ProductionOrderProcess pop) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		int pname = 0;

		try {

			String beforeedit = request.getParameter("productionOrder");
			String iid = (request.getParameter("popId"));
			pname = productionOrderProcessService.checkEditDuplicate(
					beforeedit, iid);
			if (pname != 0) {
				pop.setProductionOrderProcessIdEditt("1");
				request.setAttribute("updatePOPDuplicate",
						"Production Order Number is Already Exists Please try some other number");
				pop.setProductionOrderEditt("");

				msg = "Production Order Number is Already Exists Please try some other number";

			}
			if (pname == 0) {
				pop.setProductionOrderProcessIdEditt("1");
				request.setAttribute("updatePOPDuplicate",
						"Production Order Number is Already Exists Please try some other number");
				pop.setProductionOrderEditt("");

				msg = "";

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return msg;
	}

	/*
	 * =====================================Edit
	 * Method==============================
	 */
	@RequestMapping(value = "/productionOrderProcessIdEdit", method = RequestMethod.GET)
	@Scope("request")
	public String popEdit(
			@ModelAttribute("productionOrderProcessCommand") ProductionOrderProcess popIdEdit,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object> list = null;
		List<ProductionOrderProcess> popEditList = new ArrayList<ProductionOrderProcess>();
		List<ProductionOrderProcess> popLineEditList = new ArrayList<ProductionOrderProcess>();
		int pid = Integer.parseInt(request.getParameter("productionOrder"));

		try {

			list = productionOrderProcessService
					.editProductionOrderProcessWithId(pid);

			Iterator<Object> iterator = list.iterator();
			popIdEdit.setProductionOrderProcessIdEditt(String.valueOf(pid));

			while (iterator.hasNext()) {
				Object popObj = iterator.next();
				ProductionOrderProcess pop = (ProductionOrderProcess) popObj;
				popIdEdit.setProductionOrderEditt(pop.getProductionOrder());
				ProductionOrderProcess popMultiple = new ProductionOrderProcess();
				ProcessDetailBean process = pop.getProcessDetailBean();
				popMultiple.setProcessdetailidEditt(pop.getProcessdetailid());
				popMultiple.setProcessdescription(process
						.getProcessdescription());
				WorkCenter work = pop.getWorkCenterBean();
				popMultiple.setWorkCenter_IdEditt(pop.getWorkCenter_Id());
				popMultiple.setWorkCenterName(work.getWorkCenterName());
				popMultiple.setProductionOrderProcessIdEditt(String.valueOf(pop
						.getProductionOrderProcessId()));
				popMultiple.setStartDateEditt(dateService.dateFormat(
						dateService.dateParse(pop.getStartDate(), "se"), "se"));
				popMultiple
						.setFinishDateEditt(dateService.dateFormat(dateService
								.dateParse(pop.getFinishDate(), "se"), "se"));

				popLineEditList.add(popMultiple);

			}
			popEditList.add(popIdEdit);
			model.addAttribute("productionOrderProcessCommand", popIdEdit);
			request.setAttribute("popEditList", popEditList);
			request.setAttribute("popLineEditList", popLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "productionOrderProcessHome";

	}

	/* ===================================Update Method======================== */
	@RequestMapping(value = "/popEdit", method = RequestMethod.GET)
	public String updateQuotation(
			@ModelAttribute("productionOrderProcessCommand") ProductionOrderProcess prodOrderProcessEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		ProductionOrderProcess popLine = null;
		List<ProductionOrderProcess> popLines = null;
		String msg = null;
		String checkProductionOrderNo = prodOrderProcessEdit
				.getProductionOrderEditt();
		String id1 = prodOrderProcessEdit.getProductionOrderProcessIdEditt();
		String[] id = id1.split(",");

		int list1 = productionOrderProcessService.checkEditDuplicate(
				checkProductionOrderNo, id1);

		if (list1 == 0) {

			try {

				popLines = new ArrayList<ProductionOrderProcess>();

				String processEdit = prodOrderProcessEdit
						.getProcessdetailidEditt();

				List<String> processEditlist = Arrays.asList(processEdit
						.split(","));
				Object[] processIdEdit = processEditlist.toArray();

				String workEdit = prodOrderProcessEdit.getWorkCenter_IdEditt();

				List<String> workEditList = Arrays.asList(workEdit.split(","));
				Object[] workIdEdit = workEditList.toArray();

				String start1 = prodOrderProcessEdit.getStartDateEditt();
				String finish1 = prodOrderProcessEdit.getFinishDateEditt();
				String[] start = start1.split(",");
				String[] finish = finish1.split(",");

				for (int i = 0; i < workIdEdit.length; i++) {

					if (id[i].equals("0")) {
						System.out.println("in if");
						ProductionOrderProcess popLineObj = new ProductionOrderProcess();
						popLineObj.setProductionOrder(prodOrderProcessEdit
								.getProductionOrderEditt());
						popLineObj.setProcessdetailid(processIdEdit[i]
								.toString());
						popLineObj.setWorkCenter_Id(workIdEdit[i].toString());
						popLineObj.setStartDate(dateService.dateFormat(
								dateService.dateParse(start[i], "au"), "au"));
						popLineObj.setFinishDate(dateService.dateFormat(
								dateService.dateParse(finish[i], "au"), "au"));
						popLineObj.setProductionOrderProcessId(Integer
								.parseInt(id[i]));

						popLines.add(popLineObj);
						prodOrderProcessEdit.setPopChild(popLines);
						productionOrderProcessService
								.addProductionOrderProcess(popLineObj);
					} else {
						popLine = new ProductionOrderProcess();
						popLine.setProductionOrder(prodOrderProcessEdit
								.getProductionOrderEditt());
						popLine.setProcessdetailid(processIdEdit[i].toString());
						popLine.setWorkCenter_Id(workIdEdit[i].toString());
						popLine.setStartDate(dateService.dateFormat(
								dateService.dateParse(start[i], "au"), "au"));
						popLine.setFinishDate(dateService.dateFormat(
								dateService.dateParse(finish[i], "au"), "au"));
						popLine.setProductionOrderProcessId(Integer
								.parseInt(id[i]));

						int pLineId = Integer.parseInt(id[i]);
						String ch = "1", ch1 = "0";
						String idQL = request.getParameter(pLineId + "Check");

						if (ch.equals(idQL)) {
							productionOrderProcessService
									.deleteProductionOrderProcessChild(pLineId);
						}

						if (ch1.equals(idQL) || idQL == null) {
							popLines.add(popLine);
							prodOrderProcessEdit.setPopChild(popLines);
						}
					}

				}
				msg = productionOrderProcessService
						.updateProductionOrderProcess(prodOrderProcessEdit);
				if (msg.equals("S")) {
					request.setAttribute("popUpdate",
							"Production Process has been updated");
				} else {
					request.setAttribute("popUpdateError",
							"Production Process has not been updated");
				}

			} catch (Exception e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}

		}

		else {

			request.setAttribute("popEditList", "popEditList");
			request.setAttribute("updatePOPDuplicate",
					"Production Order Number is Already Exists Please try some other number");
			return "productionOrderProcessHome";
		}

		return "productionOrderProcessHome";
	}

	/*
	 * =================================Delete
	 * Method=======================================
	 */
	@RequestMapping(value = "/productionOrderProcessIdDelete", method = RequestMethod.GET)
	public ModelAndView quotationDelete(
			@ModelAttribute("productionOrderProcessCommand") ProductionOrderProcess popDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("productionOrder"));
		HttpSession session = null;
		try {
			String msg = productionOrderProcessService
					.deleteProductionOrderProcess(id);
			if (msg.equals("S")) {

				request.setAttribute("popDelete",
						"Production Order Process has been deleted");
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Production Order Process", "ROW",
						String.valueOf(id), "1", modifiedDate, session
								.getAttribute("userName").toString());
			} else {
				request.setAttribute("popDeleteError",
						"Production Order Process has not been deleted");
			}

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ModelAndView("productionOrderProcessHome",
				"productionOrderProcessCommand", new ProductionOrderProcess());
	}

}
