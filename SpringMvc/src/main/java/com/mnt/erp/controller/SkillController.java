package com.mnt.erp.controller;

/*
 @author  Venkatesh

 @version 1.0   
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


import com.mnt.erp.bean.Licence;
import com.mnt.erp.bean.Skill;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class SkillController {

	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	String sql;

	@Autowired 
	ERPDao dao;

	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session;

	@RequestMapping(value = "/skill", method = RequestMethod.GET)
	public String getSkill(
			@ModelAttribute Skill skill,
			SessionStatus status, Model model,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		 session=request.getSession(false);
			List<String> list=menuService.getPrivilige("skill.mnt", session.getAttribute("userId").toString());
					session.setAttribute("privilegeList",list);
		model.addAttribute("skill", new Skill());

		return "skillView";
	}

	@RequestMapping(value = "/skillAdd", method = RequestMethod.POST)
	@RequestScoped
	public String saveSkills(
			
			@ModelAttribute("skill") Skill skill,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request,HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		int mess = 0;
	
		String liSuccess = null;
		String AGSuccessdup = null;

		
		Long id = 0L;
		try {
			sql="select count(*) from Skill o where  o.skill='" + skill.getSkill()
					+ "'";
			id =dao.duplicateCheck(sql);
		
			if (id == 0) {
				 mess=dao.saveDetails(skill);
			
				map.addAttribute("skill", skill);
				if (mess!=0) {
					Date date = new Date();
					session=request.getSession(false);
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Skill","ROW" ,String.valueOf(skill.getSkillId()),"1",modifiedDate,session.getAttribute("userName").toString());
					model.addAttribute("skill", new Skill());
					return "redirect:skill.mnt?list="
					+ "success"+ "";
				}
				else
				{
					return "redirect:skill.mnt?listwar="
							+ "fail"+ "";
				}
			} else {
				AGSuccessdup = "Warning ! Skill is already exists. Please try some other name";
			
				skill.setAid(1);
				request.setAttribute("AGSuccessdup", AGSuccessdup);
				return "skillView";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:skill.mnt?listwar="
			+ "fail"+ "";
		}
	}

	@RequestMapping(value = "/searchskill", method = RequestMethod.GET)
	public String searchSkills(
			@ModelAttribute("skill") Skill skill,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<Skill> skills =null;
		try {
			int iid = skill.getSkillId();
			skills=new ArrayList<Skill>();
			String dbField = skill.getXmlLabel();
			String operation = skill.getOperations();
			String basicSearchId = skill.getBasicSearchId();

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
sql="select ag.skillId,ag.skill from Skill ag order by ag.skill";
				list =dao.searchDetails(sql);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Skill skillsearch = new Skill();
					skillsearch.setSkillId((Integer)obj[0]);
					skillsearch.setSkill((String)obj[1]);
					
					skills.add(skillsearch);
				}

			} else {

				// list = accountgroupservice.searchAccountGroupsWithId(iid);
sql = "select ag.skillId,ag.skill from Skill ag where ag."
						+ dbField + "" + operation +"'"+ basicSearchId+"'";
				list = dao.searchDetails(sql);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Skill skillsearch = new Skill();
					skillsearch.setSkillId((Integer)obj[0]);
					skillsearch.setSkill((String)obj[1]);
					
					skills.add(skillsearch);
				}

			}
			request.setAttribute("skillValues","skillValues");
			request.setAttribute("licenceBeans", skills);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "skillView";
	}



	@RequestMapping(value = "/skilledit", method = RequestMethod.GET)
	public String editSkill(
			@ModelAttribute("skill") Skill skill,
			HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("skilledit"));
		List<Licence> licenceEdit=null;
		try {
			
			sql="select ag.skillId,ag.skill from Skill ag where ag.skillId='"+id+"'";
			
			list=dao.searchDetails(sql);
			
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				
			
				skill.setSkillId((Integer)obj[0]);
				skill.setSkillEdit((String)obj[1]);
			
			}
			request.setAttribute("editvalues","df");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "skillView";

	}

	@RequestMapping(value = "/skillUpdate", method = RequestMethod.POST)
	public String updateSkills(
			@ModelAttribute("skill") Skill skill,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		String licenceName =skill.getSkillEdit();
		int licenceId = skill.getSkillId();
	
		String AGSuccessdupedit = null;

		Long id = 0L;
		try {
		sql = "select count(*) from Skill ab where ab.skill='"
					+ licenceName + "'and ab.skillId!='" + licenceId + "'";
			id =dao.duplicateCheck(sql);

			if (id == 0) {
				
				skill.setSkill(skill.getSkillEdit());

				

				int message =dao.updateDetails(skill);

				if (message!=0) {
					request.setAttribute("SkillUpdate",
							"Skill Data Updated Successfully");
					
				}
				else
				{
					request.setAttribute("SkillUpdateFail","Skill Data Updated Did not updated");
					
				}
			} else {
				AGSuccessdupedit = "Warning ! Skill is already exists. Please try some other name";
		
				request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "skillView";
			}
			model.addAttribute("skill",new Skill());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "skillView";
	}

	@RequestMapping(value = "/skillDelete", method = RequestMethod.GET)
	public String skillDelete(HttpServletRequest request,HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		int groupId = 0;
		try {
			groupId = Integer.parseInt(request
					.getParameter("skillDelete"));
			Skill licence=new Skill();
			licence.setSkillId(groupId);

			int  msg =dao.deleteDetails(licence);
			if (msg!=0)
			{
				Date date = new Date();
				session=request.getSession(false);
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	          auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Skill","ROW" ,String.valueOf(groupId),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("SkillDelete",
						"Skill Data is Deleted Successfully");
			}
			else
			{
				request.setAttribute("SkillDeleteFail",
						"Skill Data is Did Not Deleted ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("skill",new Skill());
		return "skillView";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "skillId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
