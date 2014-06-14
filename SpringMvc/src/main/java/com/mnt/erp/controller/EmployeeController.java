/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.EmployeeManager;
import com.mnt.erp.bean.EmployeeProject;
import com.mnt.erp.bean.Project;
import com.mnt.erp.service.AssertTypeService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CountryService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.EmployeeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.OrganizationService;
import com.mnt.erp.service.StatusService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

@Controller
public class EmployeeController {
	@Autowired
	AssertTypeService assertService;

	@Autowired
	EmployeeService eservice;

	@Autowired
	CountryService countryService;

	@Autowired
	DateConversionService dateService;

	@Autowired
	StatusService statusService;

	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	OrganizationService organizationService;

	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/Employee", method = RequestMethod.GET)
	public ModelAndView employeeHome(
			@ModelAttribute("EmployeeCommand") Employee employee,
			SessionStatus status, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("Employee.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("EmployeeHome", "EmployeeCommand", employee);
	}

	@ModelAttribute("countrys")
	public Map<Integer, String> populateCountry() {

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> list = countryService.getCountryIds();
			Iterator<Object[]> itr = list.iterator();
			while (itr.hasNext()) {
				Object[] objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("Employees")
	public Map<Integer, String> employeesGet() {

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> list = eservice.selectEmployees();
			Iterator<Object[]> itr = list.iterator();
			while (itr.hasNext()) {
				Object[] objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("designations")
	public Map<Integer, String> designationGet() {

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> list = eservice.selecDesignations();
			Iterator<Object[]> itr = list.iterator();
			while (itr.hasNext()) {
				Object[] objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("employeeGroup")
	public Map<Integer, String> employeeGroupGet() {

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> list = eservice.selectEmployeeGroupDetails();
			Iterator<Object[]> itr = list.iterator();
			while (itr.hasNext()) {
				Object[] objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/* To Get Org Id Values */
	@ModelAttribute("organization")
	public Map<Integer, String> PurOrgCompany() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = organizationService.selectOrganizationDetails();
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

	/* To Get department Id Values */
	@ModelAttribute("department")
	public Map<Integer, String> department() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = eservice.selectDepartmentDetails();
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

	@ModelAttribute("projects")
	public Map<Integer, String> employeeIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = eservice.selectProjects();
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

	@ModelAttribute("status")
	public Map<Integer, String> statusIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = statusService.searchStatus();
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

	@RequestMapping(value = "/employeeAdd", method = RequestMethod.POST)
	public String saveEmployee(
			@ModelAttribute("EmployeeCommand") Employee employeeadd,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res = null;
		Set<EmployeeManager> employeeLine = null;
		EmployeeManager empmanager = null;
		HttpSession session = null;

		try {
			String s = employeeadd.getGender();
			employeeadd.setdOB(dateService.dateFormat(
					dateService.dateParse(employeeadd.getdOB(), "au"), "au"));
			employeeadd.setdOJ(dateService.dateFormat(
					dateService.dateParse(employeeadd.getdOJ(), "au"), "au"));
			if (s.equals("Male")) {
				employeeadd.setGender("1");
			} else {
				employeeadd.setGender("2");
			}
			session = request.getSession(false);
			String sdatesEdit = employeeadd.getStartDate();
			if (sdatesEdit != null) {
				List<String> sdateslist = Arrays.asList(sdatesEdit.split(","));
				Object[] sdates = sdateslist.toArray();
				String managersedit = employeeadd.getManagers();
				List<String> managerslist = Arrays.asList(managersedit
						.split(","));
				Object[] managersids = managerslist.toArray();
				String edatesEdit = employeeadd.getEndDate();
				List<String> edateslist = Arrays.asList(edatesEdit.split(","));
				Object[] edates = edateslist.toArray();

				employeeLine = new HashSet<EmployeeManager>();
				for (int i = 0; i < sdates.length; i++) {

					empmanager = new EmployeeManager();
					empmanager.setManager_Id(managersids[i].toString());
					empmanager.setStartDate(dateService.dateFormat(
							dateService.dateParse(sdates[i].toString(), "au"),
							"au"));
					empmanager.setEndDate(dateService.dateFormat(
							dateService.dateParse(edates[i].toString(), "au"),
							"au"));
					employeeLine.add(empmanager);

				}
				String[] stdtpro = employeeadd.getStartDatepro();
				String[] etdtpro = employeeadd.getEndDatepro();
				String projectsedit = employeeadd.getProjects();
				List<String> projectsList = Arrays.asList(projectsedit
						.split(","));
				Object[] projectsids = projectsList.toArray();
				Set<EmployeeProject> empproject = new HashSet<EmployeeProject>();
				for (int j = 0; j < stdtpro.length; j++) {
					EmployeeProject emppro = new EmployeeProject();
					emppro.setProject_Id(projectsids[j].toString());
					emppro.setStartDatepro(dateService.dateFormat(
							dateService.dateParse(stdtpro[j].toString(), "au"),
							"au"));
					emppro.setEndDatepro(dateService.dateFormat(
							dateService.dateParse(etdtpro[j].toString(), "au"),
							"au"));
					empproject.add(emppro);

				}
				employeeadd.setEmployeeManager(employeeLine);
				employeeadd.setEmployeeProject(empproject);
			}
			msg = eservice.saveEmployeeDetails(employeeadd, session
					.getAttribute("userId").toString(),
					session.getAttribute("userName").toString());
			if (msg == "S") {
				res = "redirect:Employee.mnt?list=" + "success" + "";
			} else {
				res = "redirect:Employee.mnt?listwar=" + "fail" + "";
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return res;

	}

	@RequestMapping(value = "/employeeSearch", method = RequestMethod.GET)
	public ModelAndView searchEmployee(
			@ModelAttribute("EmployeeCommand") Employee employeeSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object[]> list = null;
		List<Employee> employeeBean = new ArrayList<Employee>();
		try {

			String dbField = employeeSearch.getXmlLabel();
			String operation = employeeSearch.getOperations();
			String basicSearchId = employeeSearch.getBasicSearchId();

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
				list = eservice.selectEmployee();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Employee ab = new Employee();
					Object[] obj = (Object[]) iterator.next();
					ab.setEmployee_Id((Integer) obj[0]);
					ab.setEmployeeNo((String) obj[1]);
					ab.setfName((String) obj[2]);
					ab.setlName((String) obj[3]);
					ab.setdOB((String) obj[4]);
					ab.setdOJ((String) obj[5]);
					ab.seteMail((String) obj[6]);
					ab.setMobile((String) obj[7]);

					employeeBean.add(ab);
				}

			} else {
				list = eservice.basicSearchEmployee(dbField, operation,
						basicSearchId);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Employee ab = new Employee();
					Object[] obj = (Object[]) iterator.next();
					ab.setEmployee_Id((Integer) obj[0]);
					ab.setEmployeeNo((String) obj[1]);
					ab.setfName((String) obj[2]);
					ab.setlName((String) obj[3]);
					ab.setdOB((String) obj[4]);
					ab.setdOJ((String) obj[5]);
					ab.seteMail((String) obj[6]);
					ab.setMobile((String) obj[7]);
					employeeBean.add(ab);

				}

				request.setAttribute("employeeBean", employeeBean);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("employees", "employees");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("EmployeeHome");
		modelAndView.addObject("employeeBean", employeeBean);
		return modelAndView;
	}

	@RequestMapping(value = "/employeeEdit", method = RequestMethod.GET)
	public String employeeEdit(
			@ModelAttribute("EmployeeCommand") Employee employeeEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Employee> empedit = new ArrayList<Employee>();

		Set<EmployeeManager> emplinelist = new HashSet<EmployeeManager>();
		Set<EmployeeProject> empprojectlist = new HashSet<EmployeeProject>();
		int id = Integer.parseInt(request.getParameter("employeeId"));

		try {
			List<Employee> list = eservice.searchEmployeeWithId(id);

			Iterator<Employee> iter = list.iterator();
			while (iter.hasNext()) {
				Employee object = (Employee) iter.next();

				Employee empl = (Employee) object;
				employeeEdit.setEmployee_IdEdit(empl.getEmployee_Id());
				employeeEdit.setEmployeeNoEdit(empl.getEmployeeNo());
				employeeEdit.setfNameEdit(empl.getfName());
				employeeEdit.setlNameEdit(empl.getlName());
				employeeEdit.setmNameEdit(empl.getmName());

				String s = empl.getGender();

				if (s.equals("1")) {
					employeeEdit.setGenderEdit("Male");
				} else {
					employeeEdit.setGenderEdit("Female");
				}

				employeeEdit.setdOBEdit(dateService.dateFormat(
						dateService.dateParse(empl.getdOB(), "se"), "se"));
				employeeEdit.setdOJEdit(dateService.dateFormat(
						dateService.dateParse(empl.getdOJ(), "se"), "se"));
				employeeEdit.setpAddEdit(empl.getpAdd());
				employeeEdit.setpCityEdit(empl.getpCity());
				employeeEdit.setpStateEdit(empl.getpState());
				employeeEdit.setpCountryEdit(empl.getpCountry());
				employeeEdit.settAddEdit(empl.gettAdd());
				employeeEdit.settCityEdit(empl.gettCity());
				employeeEdit.settStateEdit(empl.gettState());
				employeeEdit.settCountryEdit(empl.gettCountry());
				employeeEdit.seteMailEdit(empl.geteMail());
				employeeEdit.setPhoneEdit(empl.getPhone());
				employeeEdit.setMobileEdit(empl.getMobile());
				employeeEdit.setStatusEdit(empl.getStatus());
				employeeEdit.setCeMailEdit(empl.getCeMail());
				employeeEdit.setOrg_IdEdit(empl.getOrg_Id());
				employeeEdit.setDepartment_IdEdit(empl.getDepartment_Id());
				employeeEdit.setDesignationIdEdit(empl.getDesignationId());
				employeeEdit
						.setEmployeeGroup_IdEdit(empl.getEmployeeGroup_Id());

				Set<EmployeeManager> listEdit = empl.getEmployeeManager();
				Iterator<EmployeeManager> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					EmployeeManager rfedit = (EmployeeManager) object2;

					EmployeeManager rfqlineedit = new EmployeeManager();

					rfqlineedit.setEmployeeManager_IdEdit(rfedit
							.getEmployeeManager_Id());
					rfqlineedit.setManager_IdEdit((rfedit.getManager_Id()));
					Employee emanager = rfedit.getManagerDetails();
					rfqlineedit.setManagerName(emanager.getfName());
					rfqlineedit.setStartDateEdit(dateService.dateFormat(
							dateService.dateParse(rfedit.getStartDate(), "se"),
							"se"));
					rfqlineedit.setEndDateEdit(dateService.dateFormat(
							dateService.dateParse(rfedit.getEndDate(), "se"),
							"se"));
					emplinelist.add(rfqlineedit);

				}
				Set<EmployeeProject> listEditproject = empl
						.getEmployeeProject();
				Iterator<EmployeeProject> iterateproject = listEditproject
						.iterator();
				while (iterateproject.hasNext()) {
					Object object2 = iterateproject.next();
					EmployeeProject p = (EmployeeProject) object2;

					EmployeeProject empprojectedit = new EmployeeProject();

					empprojectedit.setEmployeeProject_IdEdit(p
							.getEmployeeProject_Id());
					Project eproject = p.getProjectbean();
					empprojectedit.setProjectName(eproject.getProjectName());
					empprojectedit.setProject_IdEdit(p.getProject_Id());
					empprojectedit.setStartDateproEdit(dateService.dateFormat(
							dateService.dateParse(p.getStartDatepro(), "se"),
							"se"));
					empprojectedit.setEndDateproEdit(dateService.dateFormat(
							dateService.dateParse(p.getEndDatepro(), "se"),
							"se"));
					empprojectlist.add(empprojectedit);
				}
				// employeeEdit.setEmployeeManager(emplinelist);
				empedit.add(employeeEdit);
			}
			request.setAttribute("empedit", empedit);
			request.setAttribute("emplinelist", emplinelist);
			request.setAttribute("empprojectlist", empprojectlist);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "EmployeeHome";

	}

	@RequestMapping(value = "/employeeUpdate", method = RequestMethod.POST)
	public String employeeUpdate(
			@ModelAttribute("EmployeeCommand") Employee employeeUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Set<EmployeeManager> employeeLine = null;
		EmployeeManager empmanager = null;
		EmployeeProject emppro = null;
		try {
			employeeUpdate.setEmployee_Id(employeeUpdate.getEmployee_IdEdit());
			employeeUpdate.setEmployeeNo(employeeUpdate.getEmployeeNoEdit());
			employeeUpdate.setfName(employeeUpdate.getfNameEdit());
			employeeUpdate.setlName(employeeUpdate.getlNameEdit());
			employeeUpdate.setmName(employeeUpdate.getmNameEdit());

			String s = employeeUpdate.getGenderEdit();

			if (s.equals("Male")) {
				employeeUpdate.setGender("1");
			} else {
				employeeUpdate.setGender("2");
			}

			employeeUpdate.setdOB(dateService.dateFormat(
					dateService.dateParse(employeeUpdate.getdOBEdit(), "au"),
					"au"));
			employeeUpdate.setdOJ(dateService.dateFormat(
					dateService.dateParse(employeeUpdate.getdOJEdit(), "au"),
					"au"));
			employeeUpdate.setpAdd(employeeUpdate.getpAddEdit());
			employeeUpdate.setpCity(employeeUpdate.getpCityEdit());
			employeeUpdate.setpState(employeeUpdate.getpStateEdit());
			employeeUpdate.setpCountry(employeeUpdate.getpCountryEdit());
			employeeUpdate.settAdd(employeeUpdate.gettAddEdit());
			employeeUpdate.settCity(employeeUpdate.gettCityEdit());
			employeeUpdate.settState(employeeUpdate.gettStateEdit());
			employeeUpdate.settCountry(employeeUpdate.gettCountryEdit());
			employeeUpdate.seteMail(employeeUpdate.geteMailEdit());
			employeeUpdate.setPhone(employeeUpdate.getPhoneEdit());
			employeeUpdate.setMobile(employeeUpdate.getMobileEdit());
			employeeUpdate.setStatus(employeeUpdate.getStatusEdit());
			employeeUpdate.setOrg_Id(employeeUpdate.getOrg_IdEdit());
			employeeUpdate.setCeMail(employeeUpdate.getCeMailEdit());
			employeeUpdate.setDepartment_Id(employeeUpdate
					.getDepartment_IdEdit());
			employeeUpdate.setEmployeeGroup_Id(employeeUpdate
					.getEmployeeGroup_IdEdit());
			employeeUpdate.setDesignationId(employeeUpdate
					.getDesignationIdEdit());
			int[] empIdUpdate = employeeUpdate.getEmployeeManager_IdEditt();

			String sdatesEdit = employeeUpdate.getStartDateEdit();
			List<String> sdateslist = Arrays.asList(sdatesEdit.split(","));
			Object[] sdates = sdateslist.toArray();

			String edatesEdit = employeeUpdate.getEndDateEdit();
			List<String> edateslist = Arrays.asList(edatesEdit.split(","));
			Object[] edates = edateslist.toArray();

			String managersedit = employeeUpdate.getManageresEdit();
			List<String> managerslist = Arrays.asList(managersedit.split(","));
			Object[] managersids = managerslist.toArray();

			employeeLine = new HashSet<EmployeeManager>();
			for (int i = 0; i < sdates.length; i++) {

				empmanager = new EmployeeManager();
				empmanager.setEmployeeManager_Id(empIdUpdate[i]);
				empmanager.setManager_Id(managersids[i].toString());
				empmanager
						.setStartDate(dateService.dateFormat(dateService
								.dateParse(sdates[i].toString(), "au"), "au"));
				empmanager
						.setEndDate(dateService.dateFormat(dateService
								.dateParse(edates[i].toString(), "au"), "au"));
				int egLineId = empIdUpdate[i];
				String check = "1", check1 = "0";
				String egCheck = request.getParameter(egLineId + "Check");

				if (check.equals(egCheck)) {

					eservice.deleteEmployeeManager(egLineId);

				}

				if (check1.equals(egCheck) || egCheck == null) {

					employeeLine.add(empmanager);

				}

				employeeLine.add(empmanager);

			}
			String projectsedit = employeeUpdate.getProjectsEdit();
			List<String> projectsList = Arrays.asList(projectsedit.split(","));
			Object[] projectsids = projectsList.toArray();
			int[] proid = employeeUpdate.getEmployeeProject_IdEdit();
			String[] stdate = employeeUpdate.getStartDateproEdit();
			String[] etdate = employeeUpdate.getEndDateproEdit();
			Set<EmployeeProject> empproject = new HashSet<EmployeeProject>();
			for (int j = 0; j < stdate.length; j++) {

				emppro = new EmployeeProject();
				emppro.setEmployeeProject_Id(proid[j]);
				emppro.setProject_Id(projectsids[j].toString());
				emppro.setStartDatepro(dateService.dateFormat(
						dateService.dateParse(stdate[j].toString(), "au"), "au"));
				emppro.setEndDatepro(dateService.dateFormat(
						dateService.dateParse(etdate[j].toString(), "au"), "au"));
				int epId = proid[j];
				String check = "1", check1 = "0";
				String egpCheck = request.getParameter(epId + "Checkp");

				if (check.equals(egpCheck)) {

					eservice.deleteEmployeeProject(epId);

				}

				if (check1.equals(egpCheck) || egpCheck == null) {

					empproject.add(emppro);

				}

				empproject.add(emppro);

			}
			employeeUpdate.setEmployeeManager(employeeLine);
			employeeUpdate.setEmployeeProject(empproject);
			String msg = eservice.updateEmployee(employeeUpdate);

			if (msg.equals("S")) {
				request.setAttribute("employeeUpdate",
						"Employee has been updated");

			} else {
				request.setAttribute("employeeUpdateError",
						"Employee has not been updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "EmployeeHome";
	}

	@RequestMapping(value = "/employeeDelete", method = RequestMethod.GET)
	public ModelAndView employeeDelete(
			@ModelAttribute("EmployeeCommand") Employee employeeDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		int id = Integer.parseInt(request.getParameter("employeeId"));
		try {

			String msg = eservice.deleteEmployee(id);
			if (msg == "S") {

				request.setAttribute("employeeDelete",
						"Employee has been deleted");

				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Code Employee", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
			} else {

				request.setAttribute("employeeDeleteError",
						"Employee has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("EmployeeHome", "EmployeeCommand",
				new Employee());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "employee_Id";
		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
