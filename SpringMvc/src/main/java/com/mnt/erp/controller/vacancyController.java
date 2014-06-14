/**
 * 
 */
package com.mnt.erp.controller;

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
import com.mnt.erp.bean.Department;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.RFQLineBean;
import com.mnt.erp.bean.RfqBean;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.Skill;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.Vacancy;
import com.mnt.erp.bean.VacancyDetailLine;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.vacancyService;

/**
 * @author devi
 * 
 */
@Controller
public class vacancyController {
	@Autowired
	PopulateService populateService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	vacancyService vacancyService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@Autowired
	DateConversionService dateService;
	String msg;
	List<Object[]> list;
	static Logger logger = Logger.getLogger(vacancyController.class);

	@RequestMapping(value = "/vacancyHome", method = RequestMethod.GET)
	public String vacancyHome(@ModelAttribute("VacancyForm") Vacancy vacancy,
			HttpServletResponse response, Model model,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("vacancyHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		response.setCharacterEncoding("UTF-8");
		return "vacancyHome";
	}

	@ModelAttribute("departmentDetails")
	public Map<Integer, String> populatDepartmentids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select d.departmentId,d.department from Department d");
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

	@ModelAttribute("skillDetails")
	public Map<Integer, String> populatSkillids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select s.skillId,s.skill from Skill s");
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

	@ModelAttribute("statusDetails")
	public Map<Integer, String> populatStatusids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select s.statusId,s.status from Status s");
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

	@RequestMapping(value = "/saveVacancy", method = RequestMethod.POST)
	public String SaveVacancy(@ModelAttribute("VacancyForm") Vacancy vacancy,
			HttpServletResponse response, Model model,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		String[] departmentIds = null;
		String[] skillIds = null;
		String[] noofpositions = null;
		String[] vDetailNo=null;
		String[] statusIds = null;
		VacancyDetailLine vacancyLine = null;
		Set<VacancyDetailLine> vacancyLinesofSet = null;
		List<String> list = null;
		String result ,res= null;
		HttpSession session=null;
		try {
			vacancy.setPostedDate(dateService.dateFormat(dateService.dateParse(vacancy.getPostedDate(),"au"),"au"));
			list = new ArrayList<String>();
			list.add("1dww");

			departmentIds = vacancy.getDepartmentId().split(",");
			noofpositions = vacancy.getNoOfPositions().split(",");
			vDetailNo= vacancy.getVacancyDetailNo().split(",");
			skillIds = vacancy.getSkillId().split(",");
			statusIds = vacancy.getStatusId().split(",");

			vacancyLinesofSet = new HashSet<VacancyDetailLine>();
			for (int i = 0; i < departmentIds.length; i++) {
				vacancyLine = new VacancyDetailLine();
				vacancyLine
						.setDepartmentId((Integer.parseInt(departmentIds[i])));
				vacancyLine.setNoOfPositions((Integer
						.parseInt(noofpositions[i])));
				vacancyLine.setVacancyDetailNo((vDetailNo[i]));
				System.out.println("the vacancy no:"+vacancyLine.getVacancyDetailNo());
				vacancyLine.setSkillId((Integer.parseInt(skillIds[i])));
				vacancyLine.setStatusId((Integer.parseInt(statusIds[i])));
				vacancyLinesofSet.add(vacancyLine);

			}

			vacancy.setVacancyDetails(vacancyLinesofSet);
			session=request.getSession(false);
			msg = vacancyService.saveVacancy(vacancy,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
		

			if (msg.equals("S")) {
				result = "redirect:vacancyHome.mnt?list=" + "success" + "";
				
			} else {
				result = "redirect:vacancyHome.mnt?listwar=" + "fail" + "";
			}

		} catch (Exception e) {
			result = "redirect:vacancyHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "/searchVacancy", method = RequestMethod.GET)
	public String searchVacancy(
			@ModelAttribute("VacancyForm") Vacancy vacancy,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		Iterator<Object[]> iterator = null;
		Vacancy vacancySearchDetails = null;
		List<Vacancy> listofVacancies = null;
		try {
			int iid = vacancy.getVacancyId();

			String dbField = vacancy.getXmlLabel();
			String operation = vacancy.getOperations();
			String basicSearchId = vacancy.getBasicSearchId();
			listofVacancies = new ArrayList<Vacancy>();

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
				list = vacancyService.searchVacancy();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					vacancySearchDetails = new Vacancy();

					vacancySearchDetails.setVacancyId((Integer) obj[0]);
					vacancySearchDetails.setPostedDate(dateService.dateFormat(dateService.dateParse((String) obj[1],"se"),"se"));
					vacancySearchDetails.setVacancyNo((String) obj[2]);

					listofVacancies.add(vacancySearchDetails);

				}

			} else {

				list = vacancyService.basicSearchVacancy(dbField, operation,
						basicSearchId);

				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					vacancySearchDetails = new Vacancy();
					vacancySearchDetails.setVacancyId((Integer) obj[0]);
					vacancySearchDetails.setPostedDate(dateService.dateFormat(dateService.dateParse((String) obj[1],"se"),"se"));
					vacancySearchDetails.setVacancyNo((String) obj[2]);
					listofVacancies.add(vacancySearchDetails);

				}
			}
			request.setAttribute("listofDNotes", listofVacancies);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "vacancyHome";
	}

	/* ===================Edit Delivery Note Details=================== */
	@RequestMapping(value = "/vacancyEdit", method = RequestMethod.GET)
	public String editVacancy(
			@ModelAttribute("VacancyForm") Vacancy vacancy,
			BindingResult result, HttpServletRequest request, Model model,
			HttpServletResponse response) {

		int vacancyId = 0;
		response.setCharacterEncoding("UTF-8");
		Iterator<Vacancy> iterator = null;
		Set<VacancyDetailLine> listOfVacancyLines = null;
		Iterator<VacancyDetailLine> vacancyLineIterator = null;
		Vacancy vacancyForChildEdit = null;
		List<Vacancy> vacancylforchildEdit = null;
		List<Vacancy> vacancyDetails = null;
		List<String> listofstrings = null;
		try {
			vacancyId = Integer.parseInt(request.getParameter("vEdit"));

			vacancyDetails = vacancyService.editVacancyDetails(vacancyId);

			vacancylforchildEdit = new ArrayList<Vacancy>();
			iterator = vacancyDetails.iterator();

			while (iterator.hasNext()) {
				Vacancy obj = (Vacancy) iterator.next();

				vacancy.setVacancyIdEdit(obj.getVacancyId());
				vacancy.setPostedDateEdit(dateService.dateFormat(dateService.dateParse(obj.getPostedDate(),"se"),"se"));
                vacancy.setVacancyNoEdit(obj.getVacancyNo());
                listOfVacancyLines = obj.getVacancyDetails();

			}
			vacancyLineIterator = listOfVacancyLines.iterator();
			while (vacancyLineIterator.hasNext()) {
				vacancyForChildEdit = new Vacancy();
				VacancyDetailLine vacancyDetailLine = (VacancyDetailLine) vacancyLineIterator
						.next();
				vacancyForChildEdit.setVacancyLineidedit(String
						.valueOf(vacancyDetailLine.getVacancyDetailLineId()));

				Department department = (Department) vacancyDetailLine
						.getDeptDetails();

				vacancyForChildEdit.setDepartmentIdEdit(String
						.valueOf(vacancyDetailLine.getDepartmentId()));
				vacancyForChildEdit.setDepartmentEdit(department.getDepartment());

				Skill skill = (Skill) vacancyDetailLine.getSkillDetails();
				vacancyForChildEdit.setSkillIdEdit(String.valueOf(vacancyDetailLine
						.getSkillId()));
				vacancyForChildEdit.setSkillEdit(skill.getSkill());

				vacancyForChildEdit.setNoOfPositionsEdit(String
						.valueOf(vacancyDetailLine.getNoOfPositions()));
				
				
				vacancyForChildEdit.setVacancyDetailNoEdit(String.valueOf(vacancyDetailLine.getVacancyDetailNo()));

				Status status = (Status) vacancyDetailLine.getStatusDetails();
				vacancyForChildEdit.setStatusIdEdit(String.valueOf(vacancyDetailLine
						.getStatusId()));
				vacancyForChildEdit.setStatusEdit(status.getStatus());

				
				vacancylforchildEdit.add(vacancyForChildEdit);
			}

			listofstrings = new ArrayList<String>();
			listofstrings.add("1");
			request.setAttribute("editvalues", listofstrings);
			request.setAttribute("vacancylindetails", vacancylforchildEdit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "vacancyHome";

	}

	@RequestMapping(value = "/vacancyUpdate", method = RequestMethod.POST)
	public String vacancyUpdate(
			@ModelAttribute("VacancyForm") Vacancy vacancy, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;
		
		String checked = "", s2 = "1";
		int ss = 0;
		VacancyDetailLine vacancyDetailLine = null;
		Set<VacancyDetailLine> vacancyDetailLines = null;
		List<VacancyDetailLine> childDelete = null;

		try {
			model.addAttribute("VacancyForm", new Vacancy());
			vacancyDetailLines = new HashSet<VacancyDetailLine>();

			vacancy.setVacancyId(vacancy.getVacancyIdEdit());
			vacancy.setPostedDate(dateService.dateFormat(dateService.dateParse(vacancy.getPostedDateEdit(),"au"),"au"));
            vacancy.setVacancyNo(vacancy.getVacancyNoEdit());
			childDelete = new ArrayList<VacancyDetailLine>();

			String vacancylineid = vacancy.getVacancyLineidedit();

			String[] vlineIdArray = vacancylineid.split(",");

			String[] departmentIdEdit = vacancy.getDepartmentIdEdit()
					.split(",");
			String[] skillEdit = vacancy.getSkillIdEdit().split(",");
			String[] statusEdit = vacancy.getStatusIdEdit().split(",");
			String[] noofpos = vacancy.getNoOfPositionsEdit().split(",");
			String[] vDetailNo = vacancy.getVacancyDetailNoEdit().split(",");
			if (departmentIdEdit != null) {
				for (int i = 0; i < departmentIdEdit.length; i++) {
					int vllineId = Integer.parseInt(departmentIdEdit[i]);
					if (vllineId == 0) {
						vacancyDetailLine = new VacancyDetailLine();
						vacancyDetailLine.setVacancyDetailLineId(Integer
								.parseInt(vlineIdArray[i]));

						vacancyDetailLine.setDepartmentId(Integer
								.parseInt(departmentIdEdit[i]));
						vacancyDetailLine.setSkillId(Integer
								.parseInt(skillEdit[i]));
						vacancyDetailLine.setStatusId(Integer
								.parseInt(statusEdit[i]));
						vacancyDetailLine.setNoOfPositions(Integer
								.parseInt(noofpos[i]));
						vacancyDetailLine.setVacancyDetailNo((vDetailNo[i]));

						vacancyDetailLine.setDeptDetails(new Department());
						vacancyDetailLine.setSkillDetails(new Skill());
						vacancyDetailLine.setStatusDetails(new Status());

						vacancyDetailLines.add(vacancyDetailLine);
					} else {
						vacancyDetailLine = new VacancyDetailLine();
						vacancyDetailLine.setVacancyDetailLineId(Integer
								.parseInt(vlineIdArray[i]));

						vacancyDetailLine.setDepartmentId(Integer
								.parseInt(departmentIdEdit[i]));
						vacancyDetailLine.setSkillId(Integer
								.parseInt(skillEdit[i]));
						vacancyDetailLine.setStatusId(Integer
								.parseInt(statusEdit[i]));
						vacancyDetailLine.setNoOfPositions(Integer
								.parseInt(noofpos[i]));
						vacancyDetailLine.setVacancyDetailNo(vDetailNo[i]);

						vacancyDetailLine.setDeptDetails(new Department());
						vacancyDetailLine.setSkillDetails(new Skill());
						vacancyDetailLine.setStatusDetails(new Status());

						vacancyDetailLines.add(vacancyDetailLine);

						ss = Integer.parseInt(vlineIdArray[i]);
						checked = request.getParameter("Checkdelete" + ss);
					
						if (s2.equals(checked)) {
							VacancyDetailLine vline = new VacancyDetailLine();
							vline.setVacancyDetailLineId(ss);

							childDelete.add(vacancyDetailLine);

						}

					}

				}
				vacancy.setVacancyDetails(vacancyDetailLines);
				vacancyService.deleteChildRecords(childDelete);
				msg = vacancyService.updateVacancyDetails(vacancy);

				if (msg.equals("S")) {
					request.setAttribute("vacancyUpdate",
							"Vacancy Details Updated Successfully");
				} else {
					request.setAttribute("vacancyUpdateErr",
							"Vacancy Data is not updated properly");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
      model.addAttribute("VacancyForm", new Vacancy());
		return "vacancyHome";
	}

	@RequestMapping(value = "/vacancyDelete", method = RequestMethod.GET)
	public String deleteVacancy(
			@ModelAttribute("VacancyForm") Vacancy vacancy,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int deleId = Integer.parseInt(request.getParameter("vdelId"));
			HttpSession session=null;
			msg = vacancyService.deleteVacancy(deleId);

			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","vacancy","ROW" ,String.valueOf(deleId),"1",modifiedDate,session.getAttribute("userName").toString());
			
				request.setAttribute("vacancyDel",
						"Vacancy Details Deleted Successfully");
			} else {
				request.setAttribute("vacancyDelErr",
						"Vacancy Data is not deleted properly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "vacancyHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "Posteddate";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
