/**
 * 
 */
package com.mnt.erp.controller;

import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.ApplicantBean;
import com.mnt.erp.bean.ReceiptBean;
import com.mnt.erp.bean.ReceiptWithHold;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.shortListService;
import com.mnt.erp.service.vacancyService;

/**
 * @author devi
 * 
 */
@Controller
public class shortListController {
	@Autowired
	vacancyService vService;
	@Autowired
	shortListService shService;
	@Autowired
	PopulateService populateService;

	@RequestMapping(value = "/shortListHome", method = RequestMethod.GET)
	public ModelAndView assetHome(
			@ModelAttribute("shortList") ApplicantBean sBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("shortListHome", "shortList", sBean);
	}

	@ModelAttribute("vacancyDetailNo")
	public Map<Integer, String> assetSelectBox() {
		Map<Integer, String> map = null;
		try {
			map=populateService.populateSelectBox("select o.vacancyDetailLineId,o.vacancyDetailNo from VacancyDetailLine o");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/shortListSearch", method = RequestMethod.POST)
	public @ResponseBody
	String shortList(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("shortList") ApplicantBean appBean, Model model) {
		response.setCharacterEncoding("UTF-8");
		int vId = 0;
		StringWriter out = new StringWriter();
		JSONObject responseDetailsJson = new JSONObject();
	    JSONArray jsonArray = new JSONArray();
		
		if (request.getParameter("vacancyDetailLineId") != "") {
			vId = Integer.parseInt(request.getParameter("vacancyDetailLineId"));
		}
		List<ApplicantBean> list = null;
	
		try {
			list = shService.basicSearchShortList(vId);

			for(ApplicantBean b:list){
				String[] path=b.getDocPath().replace("\\", "/").split("/");
				b.setDocPath(path[(path.length-1)-1]+"/"+path[(path.length-1)]);
				
				jsonArray.add(b);
				
			}
		
			jsonArray.writeJSONString(out);
		
	
			
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return out.toString();
	}
	
	@RequestMapping(value = "/shortListSave", method = RequestMethod.POST)
	public String shortListUpdate(
			@ModelAttribute("shortList") ApplicantBean appBean,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		
		String recUpadted = null;
		try
		{
			String[] jhjh=appBean.getSortList();
		
			String msg=shService.shortListSave(jhjh);
		
		}
		
		catch(Exception e)
		{
		e.printStackTrace();
	}
		model.addAttribute("shortList", new ApplicantBean());
		request.setAttribute("success","Success");
		return "shortListHome";
		
		
	}
}
