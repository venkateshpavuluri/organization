package com.mnt.erp.controller;

/*
 @author Srinivas
 @version 1.0 27Sep2013
 */
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.DefectTypeBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DefectTypeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class DefectTypeController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	DefectTypeService defecttypeservice;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	XmlLabelsService xmlService;

	@RequestMapping(value = "/defectTypeHome", method = RequestMethod.GET)
	public String getInspectionMethod(@ModelAttribute DefectTypeBean dtbean,
			SessionStatus status, Model model,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("defectTypeHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("DefectType", new DefectTypeBean());

		return "defectTypeHome";
	}

	@RequestMapping(value = "/saveDefectType", method = RequestMethod.POST)
	public String saveDefectType(
			@ModelAttribute("DefectType") @Valid DefectTypeBean dtbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		DefectTypeBean dtbean2 = null;
		String dtsuccessdup = null;
		List<String> list = new ArrayList<String>();
		String name = dtbean.getDefecttype();
		Long id = 0L;
		HttpSession session=null;
		
		String res=null;
		try {
			id = defecttypeservice.getDefectTypeCount(name);
			if (id == 0) {
				session=request.getSession(false);
				msg = defecttypeservice.saveDefectTypeService(dtbean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				dtbean2 = new DefectTypeBean();

				map.addAttribute("DefectType", dtbean2);
				if (msg.equals("S")) {
		
					res = "redirect:defectTypeHome.mnt?list=" + "success" + "";
					
				}
				else{
				
					res = "redirect:defectTypeHome.mnt?listwar=" + "fail" + "";
				}
			}

			else {
				dtsuccessdup = "Defect Type already Exists please Enter Other ";
				dtbean.setDthide(1);
				request.setAttribute("dtsuccessdup", dtsuccessdup);
				return "defectTypeHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	@ModelAttribute("DefecttypeSearch")
	public Map<Integer, String> populateDefectTypeids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = defecttypeservice.selectDefectTypeService();
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

	@RequestMapping(value = "/searchDefectType", method = RequestMethod.GET)
	public String searchDefectTypeIds(
			@ModelAttribute("DefectType") DefectTypeBean dtbean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {

			List<DefectTypeBean> dtbeans = new ArrayList<DefectTypeBean>();
			String dbField = dtbean.getXmlLabel();
			String operation = dtbean.getOperations();
			String basicSearchId = dtbean.getBasicSearchId();

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
				list = defecttypeservice.searchDefectTypeService();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					DefectTypeBean dtbean2 = new DefectTypeBean();
					dtbean2.setDefecttypeid((Integer) obj[0]);
					dtbean2.setDefecttype((String) obj[1]);
					dtbeans.add(dtbean2);

				}

			} else {

				
				list = defecttypeservice.basicSearchDefectType(dbField,
						operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();

					DefectTypeBean dtbean2 = new DefectTypeBean();
					dtbean2.setDefecttypeid((Integer) obj[0]);
					dtbean2.setDefecttype((String) obj[1]);
					dtbeans.add(dtbean2);
				}
			}
			request.setAttribute("dtbeans", dtbeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "defectTypeHome";
	}

	@RequestMapping(value = "/defectEdit", method = RequestMethod.GET)
	public String editDefectType(
			@ModelAttribute("DefectType") DefectTypeBean dtbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("defectedit"));

		try {
			List<DefectTypeBean> dtbeans = new ArrayList<DefectTypeBean>();
			list = defecttypeservice.searchDefectTypeServiceWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				dtbean.setEdefecttypeid((Integer) obj[0]);
				dtbean.setEdefecttype((String) obj[1]);
				dtbeans.add(dtbean);
			}
			request.setAttribute("editvalues", dtbeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "defectTypeHome";

	}

	@RequestMapping(value = "/defectTypeUpdate", method = RequestMethod.POST)
	public String updateDefectType(
			@ModelAttribute("DefectType") DefectTypeBean dtbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = dtbean.getEdefecttype();
		int imid = dtbean.getEdefecttypeid();
		Long iid = 0l;
		
		try {
			iid = defecttypeservice.getDefectTypeCountedit(name, imid);
			if (iid == 0) {
				dtbean.setDefecttypeid(dtbean.getEdefecttypeid());
				dtbean.setDefecttype(dtbean.getEdefecttype());

				String message = defecttypeservice.updateDefectTypeService(dtbean);
				if (message.equals("S")) {
					request.setAttribute("defectTypeUpdate","Defect Type has been updated successfully");
				}
				else{
					request.setAttribute("defectTypeUpdateError","Defect Type has not been updated successfully");
				}
			} else {
				
				dtbean.setEdthide(1);
				request.setAttribute("dtsuccessdupedit", "Defect type already exists");
				request.setAttribute("editvalues", "editvalues");
				return "defectTypeHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("DefectType", new DefectTypeBean());
		return "defectTypeHome";
	}

	@RequestMapping(value = "/defectDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView DefectTypeDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("defectdelete"));
			String msg = defecttypeservice.deleteDefectTypeService(id);
			if (msg.equals("S")){
				request.setAttribute("defectTypeDelete","Defect Type has been deleted successfully");
				
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Defect Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else{
				request.setAttribute("defectTypeDeleteError","Defect Type has not been deleted successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("defectTypeHome", "DefectType",
				new DefectTypeBean());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "defecttypeid";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
