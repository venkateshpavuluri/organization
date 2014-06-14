package com.mnt.erp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.EmpPerformance;
import com.mnt.erp.bean.EmpPerformanceKPI;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.KPIBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.EmpPerformanceService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class EmpPerformanceController {

	@Autowired
	EmpPerformanceService empPerformanceService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	DateConversionService dateService;

	@RequestMapping(value = "/EmpPerformance", method = RequestMethod.GET)
	public ModelAndView getEmpPerformance(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("EmpPerformanceHome", "EmpPerformance",
				new EmpPerformance());
	}

	/* To Get Employee Id Values */
	@ModelAttribute("employee")
	public Map<Integer, String> equipmentIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = empPerformanceService.selectEmployee();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* To Get Status Id Values */
	@ModelAttribute("status")
	public Map<Integer, String> maintenanceCategoryIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = empPerformanceService.selectStatus();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* To Get Kpi Id Values */
	@ModelAttribute("kpi")
	public Map<Integer, String> maintenanceTypeIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = empPerformanceService.selectKpi();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	@RequestMapping(value = "/empPerformanceAdd", method = RequestMethod.POST)
	public String saveEmpPerformanceAdd(
			@ModelAttribute("EmpPerformance") EmpPerformance empPerformanceAdd,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res = null;
		List<EmpPerformanceKPI> empPerformanceKPI = null;
		EmpPerformanceKPI empPerformanceSchCa = null;

		try {
			empPerformanceAdd.setPeriodFrom(dateService.dateFormat(dateService
					.dateParse(empPerformanceAdd.getPeriodFrom(), "au"), "au"));
			empPerformanceAdd.setPeriodTo(dateService.dateFormat(dateService
					.dateParse(empPerformanceAdd.getPeriodTo(), "au"), "au"));
			String rating = empPerformanceAdd.getRating();
			if (rating != null) {

				List<String> ratinglist = Arrays.asList(rating.split(","));
				Object[] ratings = ratinglist.toArray();

				String kpi = empPerformanceAdd.getkPIId();
				List<String> kpiList = Arrays.asList(kpi.split(","));
				Object[] kpiListids = kpiList.toArray();
				String comments = empPerformanceAdd.getComment();
				List<String> commentslist = Arrays.asList(comments.split(","));
				Object[] commet = commentslist.toArray();
				String eval = empPerformanceAdd.getEvaluationBy();
				List<String> evalList = Arrays.asList(eval.split(","));
				Object[] evalListids = evalList.toArray();

				empPerformanceKPI = new ArrayList<EmpPerformanceKPI>();
				for (int i = 0; i < ratings.length; i++) {

					empPerformanceSchCa = new EmpPerformanceKPI();
					empPerformanceSchCa.setkPIId(kpiListids[i].toString());
					empPerformanceSchCa.setRating(ratings[i].toString());
					empPerformanceSchCa.setComment(commet[i].toString());
					empPerformanceSchCa.setEvaluationBy(evalListids[i]
							.toString());
					empPerformanceKPI.add(empPerformanceSchCa);

				}
				empPerformanceAdd.setEmpPerformanceKPI(empPerformanceKPI);

			}

			msg = empPerformanceService
					.saveEmpPerformanceDetails(empPerformanceAdd);

			if (msg == "S") {
				res = "redirect:EmpPerformance.mnt?list=" + "success" + "";
			} else {
				res = "redirect:EmpPerformance.mnt?listwar=" + "fail" + "";
			}

		}

		catch (Exception e) {

			e.printStackTrace();

		}
		return res;

	}

	@RequestMapping(value = "/EmpPerformanceSearch", method = RequestMethod.GET)
	public ModelAndView EmpPerformanceSearch(
			@ModelAttribute("EmpPerformance") EmpPerformance empPerformanceSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<EmpPerformance> empPerSearch = null;

		try {

			String dbField = empPerformanceSearch.getXmlLabel();
			String operation = empPerformanceSearch.getOperations();
			String basicSearchId = empPerformanceSearch.getBasicSearchId();

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
				list = empPerformanceService.searchEmpPerformance();

			} else {
				list = empPerformanceService.basicSearchEmpPerformance(dbField,
						operation, basicSearchId);

			}

			Iterator<Object[]> iterator = list.iterator();
			empPerSearch = new ArrayList<EmpPerformance>();
			while (iterator.hasNext()) {
				EmpPerformance empPer = new EmpPerformance();
				Object[] obj = (Object[]) iterator.next();
				empPer.setPerformanceReviewId((Integer) obj[0]);
				Employee emp = (Employee) obj[1];
				empPer.setEmpName(emp.getfName());
				empPer.setPeriodFrom(dateService.dateFormat(
						dateService.dateParse((String) obj[2], "se"), "se"));
				empPer.setPeriodTo(dateService.dateFormat(
						dateService.dateParse((String) obj[3], "se"), "se"));
				Status status = (Status) obj[4];
				empPer.setStatusName(status.getStatus());
				empPerSearch.add(empPer);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("empPerValues", "empPerValues");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("EmpPerformanceHome");
		modelAndView.addObject("EmpPerf", empPerSearch);
		return modelAndView;

	}

	@RequestMapping(value = "/EmpPerformanceEdit", method = RequestMethod.GET)
	public String editPrevMain(
			@ModelAttribute("EmpPerformance") EmpPerformance empPerformanceEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<EmpPerformance> empPerEdit = new ArrayList<EmpPerformance>();

		List<EmpPerformanceKPI> empPerformanceKPIList = new ArrayList<EmpPerformanceKPI>();
		int id = Integer.parseInt(request.getParameter("EmpPerformanceId"));

		try {
			List<EmpPerformance> list = empPerformanceService
					.searchEmpPerformanceWithId(id);
			Iterator<EmpPerformance> iter = list.iterator();
			while (iter.hasNext()) {
				Object pobject = iter.next();
				EmpPerformance resReq = (EmpPerformance) pobject;

				empPerformanceEdit.setPerformanceReviewIdEdit(resReq
						.getPerformanceReviewId());
				empPerformanceEdit.setEmployeeId(resReq.getEmployeeId());
				empPerformanceEdit.setPeriodFrom(dateService.dateFormat(
						dateService.dateParse(resReq.getPeriodFrom(), "se"),
						"se"));
				empPerformanceEdit
						.setPeriodTo(dateService.dateFormat(dateService
								.dateParse(resReq.getPeriodTo(), "se"), "se"));
				empPerformanceEdit.setStatusId(resReq.getStatusId());

				List<EmpPerformanceKPI> listEdit = resReq
						.getEmpPerformanceKPI();
				Iterator<EmpPerformanceKPI> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					EmpPerformanceKPI resRdit = (EmpPerformanceKPI) object2;
					EmpPerformanceKPI resReEdit = new EmpPerformanceKPI();
					resReEdit.setPerformanceReviewKPIIdEdit(resRdit
							.getPerformanceReviewKPIId());
					resReEdit.setkPIIdEdit(resRdit.getkPIId());
					KPIBean kpibean = resRdit.getKpibean();
					resReEdit.setKpiName(kpibean.getKPI());
					resReEdit.setRatingEdit(resRdit.getRating());
					resReEdit.setCommentEdit(resRdit.getComment());
					resReEdit.setEvaluationByEdit(resRdit.getEvaluationBy());
					Employee emp = resRdit.getEmployee();
					resReEdit.setEmpName(emp.getfName());

					empPerformanceKPIList.add(resReEdit);
				}
				empPerformanceEdit.setEmpPerformanceKPI(empPerformanceKPIList);
				empPerEdit.add(empPerformanceEdit);

			}

			request.setAttribute("empPerEdit", empPerEdit);

			request.setAttribute("empPerformanceKPIList", empPerformanceKPIList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "EmpPerformanceHome";

	}

	@RequestMapping(value = "/EmpPerformanceUpdate", method = RequestMethod.POST)
	public String EmpPerformanceUpdate(
			@ModelAttribute("EmpPerformance") EmpPerformance empPerformanceUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<EmpPerformanceKPI> empPerformanceKPI = null;
		EmpPerformanceKPI empPerKPI = null;
		String msg = null;

		empPerformanceUpdate.setPerformanceReviewId(empPerformanceUpdate
				.getPerformanceReviewIdEdit());
		try {
			empPerformanceUpdate.setPeriodFrom(dateService.dateFormat(
					dateService.dateParse(empPerformanceUpdate.getPeriodFrom(),
							"au"), "au"));
			empPerformanceUpdate
					.setPeriodTo(dateService.dateFormat(
							dateService.dateParse(
									empPerformanceUpdate.getPeriodTo(), "au"),
							"au"));
			String rating = empPerformanceUpdate.getRatingEdit();

			if (rating != null) {

				List<String> ratinglist = Arrays.asList(rating.split(","));
				Object[] ratings = ratinglist.toArray();

				String comment = empPerformanceUpdate.getCommentEdit();

				List<String> commentlist = Arrays.asList(comment.split(","));
				Object[] comments = commentlist.toArray();
				String kpis = empPerformanceUpdate.getkPIIdEdit();

				List<String> kpiList = Arrays.asList(kpis.split(","));
				Object[] kpiIds = kpiList.toArray();

				String evalBys = empPerformanceUpdate.getEvaluationByEdit();

				List<String> evalBysList = Arrays.asList(evalBys.split(","));
				Object[] evalBysListIds = evalBysList.toArray();
				int[] empPerUpdate = empPerformanceUpdate.getEmpPerEditt();

				empPerformanceKPI = new ArrayList<EmpPerformanceKPI>();
				for (int i = 0; i < empPerUpdate.length; i++) {

					empPerKPI = new EmpPerformanceKPI();
					System.out.println("the kpi id is:"+empPerUpdate[i]);
					empPerKPI.setPerformanceReviewKPIId(empPerUpdate[i]);

					empPerKPI.setRating(ratings[i].toString());

					empPerKPI.setkPIId(kpiIds[i].toString());

					empPerKPI.setComment(comments[i].toString());

					empPerKPI.setEvaluationBy(evalBysListIds[i].toString());
					int resDelId = empPerUpdate[i];

					String check = "1", check1 = "0";
					String egCheck = request.getParameter(resDelId + "Check");

					if (check.equals(egCheck)) {

						empPerformanceService
								.deleteEmpPerformanceDetail(resDelId);

					}

					if (check1.equals(egCheck) || egCheck == null) {

						empPerformanceKPI.add(empPerKPI);

					}

				}

				empPerformanceUpdate.setEmpPerformanceKPI(empPerformanceKPI);

				msg = empPerformanceService
						.updateEmpPerformance(empPerformanceUpdate);

				if (msg == "S") {
					request.setAttribute("empPerformanceUpdate",
							"EmpPerformance has been updated");
				} else {
					request.setAttribute("empPerformanceUpdateError",
							"EmpPerformance has not been updated");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "EmpPerformanceHome";
	}

	@RequestMapping(value = "/EmpPerformanceDelete", method = RequestMethod.GET)
	public ModelAndView EmpPerformanceDelete(
			@ModelAttribute("EmpPerformance") EmpPerformance empPerformanceDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("EmpPerformanceId"));
		try {

			String msg = empPerformanceService.deleteEmpPerformance(id);
			if (msg == "S") {

				request.setAttribute("empPerformanceDelete",
						"EmpPerformance has been deleted");

			} else {

				request.setAttribute("empPerformanceError",
						"EmpPerformance has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("EmpPerformanceHome", "EmpPerformance",
				new EmpPerformance());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "EmpPerformanceId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
