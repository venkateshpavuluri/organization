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

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Function;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.FunctionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author anikesh
 * 
 */
@Controller
public class FunctionController {
	@Autowired
	FunctionService functionService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session;

	@RequestMapping(value = "/functionHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView functionType(
			@ModelAttribute("functionAdd") Function function,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("functionHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("functionHome", "functionAdd", new Function());
	}

	@RequestMapping(value = "/functionAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveFunctionDetails(
			@ModelAttribute("functionAdd") @Valid Function functionAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<String> list = new ArrayList<String>();
		String msa = null;
		Long duplicateId = 0l;
		String functiionSave=null;
		String res=null;

		try {
			
			// this method is used to check the Duplicates
			duplicateId = functionService.duplicateFunctionCheck(functionAdd
					.getFunctionName());
			if (duplicateId == 0) {
				// here there are no duplicates
				// saveFunctionDetails this method is used to save Function
				// Details
				session = request.getSession(false);
				msa = functionService.saveFunctionDetails(functionAdd, session
						.getAttribute("userId").toString(), session
						.getAttribute("userName").toString());
				model.addAttribute("functionAdd", new Function());
				if (msa.equals("S")) {
					functiionSave = "Function has been saved successfully";
					list.add("2");
					res = "redirect:functionHome.mnt?success="
							+ functiionSave + "&list=" + list + "";
				} else  {

					functiionSave = "Function has not been saved";
					list.add("2");
					res = "redirect:functionHome.mnt?warning="
							+ functiionSave + "&listwar=" + list + "";
				}
			} else {

				request.setAttribute("FunctionDuplicate",
						"Function Name  Already exist");
				functionAdd.setAid(1);
				return "functionHome";
			}

		
		} catch (Exception e) {
			functiionSave = "Function has not been saved";
			list.add("2");
			res = "redirect:functionHome.mnt?warning="
					+ functiionSave + "&listwar=" + list + "";
			e.printStackTrace();
			
		}
      return res;
	}

	@RequestMapping(value = "/functionSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchFunction(@ModelAttribute Function functionSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<Function> functionBean = new ArrayList<Function>();

		try {
			String dbField = functionSearch.getXmlLabel();
			String operation = functionSearch.getOperations();
			String basicSearchId = functionSearch.getBasicSearchId();

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
				list = functionService.searchFunction();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Function vt = new Function();
					Object[] obj = (Object[]) iterator.next();
					vt.setFunctionId((Integer) obj[0]);
					vt.setFunctionName((String) obj[1]);
					functionBean.add(vt);

				}
			} else {
				list = functionService.basicSearchFunction(dbField, operation,
						basicSearchId);
				// list = assertService.searchAssertTypeWithId(id);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Function vt = new Function();
					Object[] obj = (Object[]) iterator.next();
					vt.setFunctionId((Integer) obj[0]);
					vt.setFunctionName((String) obj[1]);
					functionBean.add(vt);
				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("functionSearch", functionBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("functionAdd", functionSearch);

		return "functionHome";
	}

	@ModelAttribute("FunctionSearchNames")
	public Map<String, String> populatefunctionSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = functionService.selectFunctionNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				// list.add((String)objects[1]);

				String desigId = Integer.toString((Integer) objects[0]);
				map.put(desigId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "functionId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/functionEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String functionEdit(@ModelAttribute Function functionDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String functionname = request.getParameter("functionDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<Function> functionsList = new ArrayList<Function>();

		try {

			list = functionService.searchFunctionWithId(functionname);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				functionDisplay.setFunctionIdEdit((Integer) object[0]);
				functionDisplay.setFunctionNameEdit((String) object[1]);

				/* functionDisplay.setStatusEdit((String) object[2]); */

				functionsList.add(functionDisplay);

			}
			request.setAttribute("functionValues", functionsList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("functionAdd", functionDisplay);
		return "functionHome";

	}

	@RequestMapping(value = "/functionUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateFunction(
			@ModelAttribute("functionAdd") Function function,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = functionService.updateDuplicateCheck(
					function.getFunctionNameEdit(),
					function.getFunctionIdEdit());

			if (duplicateId == 0) {
				function.setFunctionId(function.getFunctionIdEdit());
				function.setFunctionName(function.getFunctionNameEdit());

				String msg = functionService.updateFunction(function);

				if (msg.equals("S")) {
					request.setAttribute("functionUpadteSuccess",
							"Function has been updated successfully");
				} else {
					

					request.setAttribute("functionUpadteFail","Function has not been updated");

				}
			} else {
				request.setAttribute("functionEditDuplicate","Function Name Already exist");
				request.setAttribute("functionValues", "functionValues");

				return "functionHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "functionHome";

	}

	@RequestMapping(value = "/functionDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView functionDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int functionId = 0;

		try {
			functionId = Integer.parseInt(request
					.getParameter("functionIdDelete"));
			String msg = functionService.functionDelete(functionId);

			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Function", "ROW", String
						.valueOf(functionId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				request.setAttribute("functionDeleteSuccess",
						"Function has been deleted successfully");
			} else {
				request.setAttribute("functionDeleteError",
						"Function has not been deleted");
			}
		} catch (Exception e) {
			request.setAttribute("functionDeleteError",
					"Function has not been deleted");
			e.printStackTrace();

		}
		return new ModelAndView("functionHome", "functionAdd", new Function());
	}
}
