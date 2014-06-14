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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.GLFiscalYear;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.GLFiscalYearService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class GLFiscalYearController {

	@Autowired
	GLFiscalYearService gLFiscalYearservice;

	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	DateConversionService dateService;


	@RequestMapping(value = "/GLFiscalYearHome", method = RequestMethod.GET)
	public ModelAndView assetHome(
			@ModelAttribute("gLFiscalYearCommand") GLFiscalYear gLFiscalYear,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("GLFiscalYearHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("GLFiscalYearHome", "gLFiscalYearCommand",
				gLFiscalYear);
	}

	@RequestMapping(value = "/fiscalYearCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkGl(HttpServletRequest request, HttpServletResponse response,
			GLFiscalYear gLFiscalYearcheck) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		Long fyear = null;

		try {

			String fiscalYear = request.getParameter("fiscalYearcheck");

			fyear = gLFiscalYearservice.checkGLFiscalYear(fiscalYear);

			if (fyear != 0) {
				gLFiscalYearcheck.setAid(2);
				request.setAttribute("addGLFiscalYearDuplicate",
						"Warning ! Fiscal Year already exists!");
				gLFiscalYearcheck.setFiscalYearEdit("");
				msg = "Warning ! Fiscal Year already exists!";

			}
			if (fyear == 0) {
				gLFiscalYearcheck.setAid(2);
				request.setAttribute("addGLFiscalYearDuplicate",
						"Warning ! Fiscal Year already exists!");
				gLFiscalYearcheck.setFiscalYearEdit("");
				msg = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/gLFiscalYearAdd", method = RequestMethod.POST)
	public String saveAssetType(
			@ModelAttribute("gLFiscalYearCommand") GLFiscalYear gLFiscalYearAdd,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String gLFiscalYearSave, res = null;
		HttpSession session = null;
		String msg = null;

		try {

			String calenderYear = gLFiscalYearAdd.getCalendarYear();
			String fiscalYearClosed = gLFiscalYearAdd.getFiscalYearClosed();
			if (calenderYear.equals("1")) {
				gLFiscalYearAdd.setCalendarYear("True");
			} else {
				gLFiscalYearAdd.setCalendarYear("False");
			}
			if (fiscalYearClosed.equals("1")) {
				gLFiscalYearAdd.setFiscalYearClosed("True");

			} else {
				gLFiscalYearAdd.setFiscalYearClosed("False");

			}
			session = request.getSession(false);
			gLFiscalYearAdd.setStartDate(dateService.dateFormat(dateService.dateParse(gLFiscalYearAdd.getStartDate(),"au"),"au"));
			gLFiscalYearAdd.setEndDate(dateService.dateFormat(dateService.dateParse(gLFiscalYearAdd.getEndDate(),"au"),"au"));
			msg = gLFiscalYearservice.saveGLFiscalYearDetails(gLFiscalYearAdd,
					session.getAttribute("userId").toString(), session
							.getAttribute("userName").toString());

			if (msg.equals("S"))
				res = "redirect:GLFiscalYearHome.mnt?list=" + "success" + "";
			else
				res = "redirect:GLFiscalYearHome.mnt?listwar=" + "fail" + "";
		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:GLFiscalYearHome.mnt?listwar=" + "fail" + "";

		}

		return "redirect:GLFiscalYearHome.mnt?list=" + "success" + "";

	}

	@RequestMapping(value = "/GLFiscalYearSearch", method = RequestMethod.GET)
	public ModelAndView searchGLFiscalYear(
			@ModelAttribute("gLFiscalYearCommand") GLFiscalYear gLFiscalYearSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<GLFiscalYear> gLFiscalYearBean = new ArrayList<GLFiscalYear>();

		try {

			int id = gLFiscalYearSearch.getgLFiscalYear_Id();
			String dbField = gLFiscalYearSearch.getXmlLabel();
			String operation = gLFiscalYearSearch.getOperations();
			String basicSearchId = gLFiscalYearSearch.getBasicSearchId();

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
				list = gLFiscalYearservice.searchGLFiscalYear();

			} else {
				list = gLFiscalYearservice.basicSearchGLFiscalYear(dbField,
						operation, basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				GLFiscalYear glFiscalYearSearch = new GLFiscalYear();
				Object[] obj = (Object[]) iterator.next();
				glFiscalYearSearch.setgLFiscalYear_Id((Integer) obj[0]);
				glFiscalYearSearch.setFiscalYear((String) obj[1]);
				int calenderYear = Integer.parseInt((String) obj[2]);

				if (calenderYear == 1) {
					glFiscalYearSearch.setCalendarYear("Yes");
				} else {
					glFiscalYearSearch.setCalendarYear("No");
				}
				glFiscalYearSearch.setStartDate(dateService.dateFormat(dateService.dateParse((String) obj[3], "se"), "se"));
				glFiscalYearSearch.setStartDate(dateService.dateFormat(dateService.dateParse((String) obj[4], "se"), "se"));
				
				int fiscalYearClosed = Integer.parseInt((String) obj[5]);
				if (fiscalYearClosed == 1)
					glFiscalYearSearch.setFiscalYearClosed("Yes");
				else
					glFiscalYearSearch.setFiscalYearClosed("No");
				gLFiscalYearBean.add(glFiscalYearSearch);
			}

			request.setAttribute("gLFiscalYearSearchBean", gLFiscalYearBean);
			request.setAttribute("glSearchvalues", "glSearchvalues");

		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("GLFiscalYearHome");
		modelAndView.addObject("GLFiscalYear", gLFiscalYearBean);
		return modelAndView;

	}

	@RequestMapping(value = "/GLFiscalYearEdit", method = RequestMethod.GET)
	public String assetTypeEdit(
			@ModelAttribute("gLFiscalYearCommand") GLFiscalYear gLFiscalYearEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("GLFiscalYearId"));

		List<Object[]> list = null;
		List<GLFiscalYear> gLFiscalYearEditBean = new ArrayList<GLFiscalYear>();
		try {
			list = gLFiscalYearservice.searchGLFiscalYearWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				gLFiscalYearEdit.setgLFiscalYear_IdEdit((Integer) obj[0]);
				gLFiscalYearEdit.setFiscalYearEdit((String) obj[1]);
				gLFiscalYearEdit.setCalendarYearEdit((String) obj[2]);
				gLFiscalYearEdit.setStartDateEdit(dateService.dateFormat(dateService.dateParse((String) obj[3], "se"), "se"));
				gLFiscalYearEdit.setEndDateEdit(dateService.dateFormat(dateService.dateParse((String) obj[4], "se"), "se"));
				gLFiscalYearEdit.setFiscalYearClosedEdit((String) obj[5]);
				gLFiscalYearEditBean.add(gLFiscalYearEdit);
			}
			request.setAttribute("gLFiscalYearEdit", gLFiscalYearEditBean);
			request.setAttribute("glvalues", "glvalues");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "GLFiscalYearHome";

	}

	@RequestMapping(value = "/fiscalYearEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checknameEdit(HttpServletRequest request,
			HttpServletResponse response, GLFiscalYear gLFiscalYearcheck) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		Long fiscalEdit = null;

		try {

			String fiscalYearEdit = request.getParameter("fiscalYearEdit");
			int gLFiscalYearIdEdit = Integer.parseInt(request
					.getParameter("gLFiscalYear_IdEdit"));
			fiscalEdit = gLFiscalYearservice.updateCheckGLFiscalYear(
					fiscalYearEdit, gLFiscalYearIdEdit);

			if (fiscalEdit != 0) {
				gLFiscalYearcheck.setgLFiscalYear_IdEdit(1);
				request.setAttribute("addGLFiscalYearEditDuplicate",
						"Warning ! Fiscal Year already exists!");
				gLFiscalYearcheck.setFiscalYearEdit("");
				msg = "Warning ! Fiscal Year already exists!";
			}

			if (fiscalEdit == 0) {
				gLFiscalYearcheck.setgLFiscalYear_IdEdit(1);
				request.setAttribute("addGLFiscalYearEditDuplicate",
						"Warning ! Fiscal Year already exists!");
				gLFiscalYearcheck.setFiscalYearEdit("");
				msg = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@RequestMapping(value = "/GLFiscalYearUpdate", method = RequestMethod.POST)
	public String assetTypeUpdate(
			@ModelAttribute("gLFiscalYearCommand") GLFiscalYear gLFiscalYearUpdate,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		try{
		String gLFiscalYearUpadted = null;

		gLFiscalYearUpdate.setgLFiscalYear_Id(gLFiscalYearUpdate
				.getgLFiscalYear_IdEdit());
		gLFiscalYearUpdate
				.setFiscalYear(gLFiscalYearUpdate.getFiscalYearEdit());
		gLFiscalYearUpdate.setCalendarYear(gLFiscalYearUpdate
				.getCalendarYearEdit());
		gLFiscalYearUpdate.setStartDate((dateService.dateFormat(dateService.dateParse(gLFiscalYearUpdate.getStartDateEdit(),"au"),"au")));
		gLFiscalYearUpdate.setEndDate((dateService.dateFormat(dateService.dateParse(gLFiscalYearUpdate.getEndDateEdit(),"au"),"au")));
		gLFiscalYearUpdate.setFiscalYearClosed(gLFiscalYearUpdate
				.getFiscalYearClosedEdit());

	

			String msg = gLFiscalYearservice
					.updateGLFiscalYear(gLFiscalYearUpdate);

			if (msg.equals("S")) {
				request.setAttribute("YearUpdate",
						"GLFiscalYear has been updated successfully");

			} else {
				request.setAttribute("YearUpdateErr",
						"GLFiscalYear doesn't updated properly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("gLFiscalYearCommand", new GLFiscalYear());
		return "GLFiscalYearHome";

	}

	@RequestMapping(value = "/GLFiscalYearDelete", method = RequestMethod.GET)
	public String assetTypeDelete(
			@ModelAttribute("gLFiscalYearCommand") GLFiscalYear gLFiscalYearDelete,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String gLFiscalYearDeleted = null;
		HttpSession session = null;
		int id = Integer.parseInt(request.getParameter("GLFiscalYearId"));
		try {

			String msg = gLFiscalYearservice.deleteGLFiscalYear(id);
			if (msg == "S") {

				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "assertType", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				request.setAttribute("YearDelete",
						"GLFiscalYear has been deleted successfully");

			} else {

				request.setAttribute("YearDeleteErr",
						"GLFiscalYear Doesn't deleted properly");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("gLFiscalYearCommand", new GLFiscalYear());
		return "GLFiscalYearHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "gLFiscalYearId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
