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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.CodeGroup;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CodeGroupService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;


/**
 * @author Parvathi
 * @version 1.0 
 * @Date 04-1-2014
 */

@Controller
@Scope("request")
public class CodeGroupController {
	
	@Autowired
	CodeGroupService codeGroupService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	@RequestMapping(value = "/CodeGroup", method = RequestMethod.GET)
	public String getCodeGroup(
			
			@ModelAttribute("codeGroupCommand") CodeGroup codeGroupBean,
			
			SessionStatus status, Model model,HttpServletRequest request,HttpServletResponse response) {
		
			response.setCharacterEncoding("UTF-8");
			
			HttpSession session = request.getSession(false);
			List<String> list = menuService.getPrivilige("CodeGroup.mnt",
					session.getAttribute("userId").toString());
			session.setAttribute("privilegeList", list);

			model.addAttribute("codeGroupHome", new CodeGroup());
		

			return "codeGroupHome";
	}
	
	@RequestMapping(value = "/codeGroupCheck", method = RequestMethod.POST)
	
	public @ResponseBody String checkSalesAddDuplicate(HttpServletRequest request,
			HttpServletResponse response, CodeGroup dupBean) {
	
		response.setCharacterEncoding("UTF-8");
		String codeGroupCheck = request.getParameter("codeGroup");
	
		Long codeGroup =codeGroupService.checkCodeGroupCout(codeGroupCheck);
		
		String message=null;
		
		if (codeGroup != 0) {
			dupBean.setAid(1);
			message = "Warning ! Code Group is Already exists.";
		} else {
			dupBean.setAid(1);
			message = "";
		}

		return message;
	}

	
	@RequestMapping(value = "/codeGroupAdd", method = RequestMethod.POST)
	
	public String codeGroupSave(@ModelAttribute("codeGroupCommand") CodeGroup codeGroupBean,HttpServletRequest request, SessionStatus status,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		String codeGroup = codeGroupBean.getCodeGroup();
		String res=null;
		HttpSession session=null;
	
		Long checkCodeGroup = codeGroupService.checkCodeGroupCout(codeGroup);

		if (checkCodeGroup == 0) {
			try {
				session=request.getSession(false);
				String msg=codeGroupService.saveCodeGroupDetails(codeGroupBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if(msg=="S"){
					
					res = "redirect:CodeGroup.mnt?list=" + "success" + "";
				
				}
				
				else
				{
					
					res = "redirect:CodeGroup.mnt?listwar=" + "fail" + "";
				
				}

			} catch (Exception e) {
				e.printStackTrace();
				
			}
		} else {
			
			codeGroupBean.setAid(1);
			
			request.setAttribute("addCode GroupDuplicate","Warning ! Code Group already exists!");

			return "codeGroupHome";

		}

		return res;

	}
	@RequestMapping(value = "/codeGroupSearch", method = RequestMethod.GET)
	public ModelAndView codeGroupSearch(
			@ModelAttribute("codeGroupCommand") CodeGroup codeGroupSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<CodeGroup> codeGroupBean = new ArrayList<CodeGroup>();

		try {
		
			String dbField = codeGroupSearch.getXmlLabel();
			String operation = codeGroupSearch.getOperations();
			String basicSearchId = codeGroupSearch.getBasicSearchId();

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
				list = codeGroupService.searchCodeGroup();

			} else {
				list = codeGroupService.basicSearchCodeGroup(dbField, operation,
						basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				CodeGroup ab = new CodeGroup();
				Object[] obj = (Object[]) iterator.next();
				ab.setCodeGroup_Id((Integer) obj[0]);
				ab.setCodeGroup((String) obj[1]);
				codeGroupBean.add(ab);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("codeGroupValues", "codeGroupValues");


		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("codeGroupHome");
	    modelAndView.addObject("codeGroupBean",codeGroupBean);
		return modelAndView;

	}
	
	@RequestMapping(value = "/codeGroupEdit", method = RequestMethod.GET)
	public String codeGroupEdit(@ModelAttribute("codeGroupCommand") CodeGroup codeGroupEdit,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("codeGroupId"));
		List<Object[]> list = null;
		List<CodeGroup> codeGroupBean = new ArrayList<CodeGroup>();
		try {
			list = codeGroupService.searchCodeGroupWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				codeGroupEdit.setCodeGroup_IdEdit((Integer) obj[0]);
				codeGroupEdit.setCodeGroupEdit((String) obj[1]);
				codeGroupBean.add(codeGroupEdit);
			}
			request.setAttribute("codeGroupEdit", codeGroupBean);
			request.setAttribute("codeGroupEditValues", "codeGroupEditValues");

		} 
		catch (Exception e) {

			e.printStackTrace();
			
		} 
		finally {
			list = null;
		}
		
		return "codeGroupHome";

	}
	@RequestMapping(value = "/editcodeGroupCheck", method = RequestMethod.POST)
	public @ResponseBody String checkcodeGroupUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response, CodeGroup dupBean) {
		
		response.setCharacterEncoding("UTF-8");
		
		String codeGroupEdit = request.getParameter("codeGroupEdit");
		int codeGroup_IdEdit = Integer.parseInt(request.getParameter("codeGroup_IdEdit"));
		Long codeGroupCheck = codeGroupService.updateCheckCodeGroup(codeGroupEdit, codeGroup_IdEdit);
		String message=null;
				if (codeGroupCheck != 0) {
			dupBean.setCodeGroup_IdEdit(1);
			message = "Warning ! Code Group already exists!";
		} else {
			dupBean.setCodeGroup_IdEdit(1);
			message = null;
		}

		return message;
	}
	
	@RequestMapping(value = "/codeGroupUpdate", method = RequestMethod.POST)
	public String codeGroupUpdate(
			@ModelAttribute("codeGroupCommand") CodeGroup codeGroupUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		try {
			
			    codeGroupUpdate.setCodeGroup_Id(codeGroupUpdate.getCodeGroup_IdEdit());
			    codeGroupUpdate.setCodeGroup(codeGroupUpdate.getCodeGroupEdit());
				String msg = codeGroupService.updateCodeGroup(codeGroupUpdate);

				if (msg.equals("S")) {
					
					request.setAttribute("codeGroupUpdated", "Code Group has been updated");

				} else {
					request.setAttribute("codeGroupUpdatedError","Code Group has not been updated");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		
		return "codeGroupHome";
	}

	@RequestMapping(value = "/codeGroupDelete", method = RequestMethod.GET)
	public ModelAndView codeGroupDelete(
			@ModelAttribute("codeGroupCommand") CodeGroup codeGroupDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
	
		
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("codeGroupId"));
		try {

			String msg = codeGroupService.deleteCodeGroup(id);
			if (msg == "S") {

				request.setAttribute("codeGroupDeleted", "CodeGroup has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Code Group","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
				
			} else {

				request.setAttribute("codeGroupDeletedError", "CodeGroup has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("codeGroupHome", "codeGroupCommand",
				new CodeGroup());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "codeGroupId";

		Map<String, String> map =null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	

}
