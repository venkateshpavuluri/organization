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
import com.mnt.erp.bean.InterviewRound;
import com.mnt.erp.bean.RecruitmentPlan;
import com.mnt.erp.bean.RecruitmentPlanLine;
import com.mnt.erp.bean.Vacancy;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.RecruitmentPlanService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class RecruitmentPlanController {
	@Autowired XmlLabelsService xmlService;
	@Autowired RecruitmentPlanService recruitmentPlanService;
	@Autowired
	DateConversionService dateService;
	@RequestMapping(value = "/RecruitmentPlan", method = RequestMethod.GET)
	public ModelAndView getRecruitmentPlan(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		return new ModelAndView("recruitmentPlanHome", "RecruitmentPlanCommand",
				new RecruitmentPlan());
	}
	/* To Get Status Id Values */
	@ModelAttribute("vacancy")
	public Map<Integer, String> vacancyIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = recruitmentPlanService.selectVacancy();
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
	@ModelAttribute("interviewRound")
	public Map<Integer, String> interviewRoundIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = recruitmentPlanService.selectInterviewRound();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	
	@RequestMapping(value = "/RecruitmentPlanAdd", method = RequestMethod.POST)
	public String saveRecruitmentPlan(
			@ModelAttribute("RecruitmentPlanCommand") RecruitmentPlan recruitmentPlanAdd,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res=null;
		List<RecruitmentPlanLine> recruitmentPlanLineList = null;
		RecruitmentPlanLine recruitmentPlanLine=null;
	
		
			try { 
			               
				recruitmentPlanAdd.setRecruitmentPlanDT(dateService.dateFormat(dateService.dateParse(recruitmentPlanAdd.getRecruitmentPlanDT(),"au"),"au"));
				String description = recruitmentPlanAdd.getDescription();
	
				if(description!=null){
					
			
				List<String> descriptionlist = Arrays.asList(description.split(","));
				Object[] descriptions = descriptionlist.toArray();
				
		
				
				String interviewRounds = recruitmentPlanAdd.getInterviewRoundId();
		
				List<String> interviewRoundsList = Arrays.asList(interviewRounds.split(","));
				Object[] interviewRoundIds = interviewRoundsList.toArray();
				
				recruitmentPlanLineList = new ArrayList<RecruitmentPlanLine>();
				for (int i = 0; i < descriptions.length; i++) {
				
					recruitmentPlanLine = new RecruitmentPlanLine();
			
					recruitmentPlanLine.setInterviewRoundId(interviewRoundIds[i].toString());
					
					recruitmentPlanLine.setDescription(descriptions[i].toString());
					
					
					recruitmentPlanLineList.add(recruitmentPlanLine);
			
		
				}
				recruitmentPlanAdd.setRecruitmentPlanLine(recruitmentPlanLineList);
			
		
				} 
				msg=recruitmentPlanService.saveRecruitmentPlanDetails(recruitmentPlanAdd);
				
				if(msg=="S"){
					res = "redirect:RecruitmentPlan.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:RecruitmentPlan.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				res = "redirect:RecruitmentPlan.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
				
			}

		
			return res;

	}
	@RequestMapping(value = "/recruitmentPlanSearch", method = RequestMethod.GET)
	public ModelAndView recruitmentPlanSearch(
			@ModelAttribute("RecruitmentPlanCommand") RecruitmentPlan recruitmentPlanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<RecruitmentPlan> recruitmentPlanBean = new ArrayList<RecruitmentPlan>();

		try {
		
			String dbField = recruitmentPlanSearch.getXmlLabel();
			String operation = recruitmentPlanSearch.getOperations();
			String basicSearchId = recruitmentPlanSearch.getBasicSearchId();

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
				list = recruitmentPlanService.searchRecruitmentPlan();

			} else {
				list = recruitmentPlanService.basicSearchRecruitmentPlan(dbField, operation, basicSearchId);
						
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				RecruitmentPlan recPlan = new RecruitmentPlan();
				Object[] obj = (Object[]) iterator.next();
				recPlan.setRecruitmentPlanId((Integer) obj[0]);
				Vacancy vacancy=((Vacancy) obj[1]);
				recPlan.setVacancyNo(vacancy.getVacancyNo());
				recPlan.setRecruitmentPlanDT(dateService.dateFormat(dateService.dateParse((String) obj[2],"se"),"se"));
				
				recruitmentPlanBean.add(recPlan);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("recruitmentPlanValues", "recruitmentPlanValues");


		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("recruitmentPlanHome");
	    modelAndView.addObject("recruitmentPlan",recruitmentPlanBean);
		return modelAndView;

	}

	@RequestMapping(value = "/recruitmentPlanEdit", method = RequestMethod.GET)
	public String editProdutionPlan(
			@ModelAttribute("RecruitmentPlanCommand") RecruitmentPlan recruitmentPlanEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<RecruitmentPlan> recPlanEdit = new ArrayList<RecruitmentPlan>();
		
		List<RecruitmentPlanLine> recPlanLineList = new ArrayList<RecruitmentPlanLine>();
		int id = Integer.parseInt(request.getParameter("recruitmentPlanId"));

		try {
			
			List<RecruitmentPlan> list = recruitmentPlanService.searchRecruitmentPlanWithId(id);
					Iterator<RecruitmentPlan> iter = list.iterator();
			while (iter.hasNext()) {
				 Object pobject = iter.next();
				 RecruitmentPlan resReq = (RecruitmentPlan) pobject;
			
				recruitmentPlanEdit.setRecruitmentPlanIdEdit(id);
				recruitmentPlanEdit.setVacancyIdEdit(resReq.getVacancyId());
				
				recruitmentPlanEdit.setRecruitmentPlanDTEdit(dateService.dateFormat(dateService.dateParse(resReq.getRecruitmentPlanDT(),"se"),"se"));
							
				List<RecruitmentPlanLine> listEdit = resReq.getRecruitmentPlanLine();
		
				Iterator<RecruitmentPlanLine> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					
					Object object2 = iterate.next();
			
					RecruitmentPlanLine resRdit = (RecruitmentPlanLine) object2;
				
					RecruitmentPlanLine resReEdit = new RecruitmentPlanLine();
					resReEdit.setRecruitmentPlanLineIdEdit(resRdit.getRecruitmentPlanLineId());
				
					InterviewRound interviewRound=resRdit.getInterviewRound();
					resReEdit.setInterviewName(interviewRound.getInterviewRound());
					resReEdit.setInterviewRoundIdEdit(resRdit.getInterviewRoundId());
					resReEdit.setDescriptionEdit(resRdit.getDescription());
					
					
					
				
					recPlanLineList.add(resReEdit);
				

				}
				recruitmentPlanEdit.setRecruitmentPlanLine(recPlanLineList);
				
				recPlanEdit.add(recruitmentPlanEdit);
				
			}
		
			
			request.setAttribute("recPlanEdit", recPlanEdit);
			
			request.setAttribute("recPlanLineList", recPlanLineList);
			
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
		
		return "recruitmentPlanHome";

	}
	@RequestMapping(value = "/recruitmentPlanUpdate", method = RequestMethod.POST)
	public String productionPlanUpdate(
			@ModelAttribute("RecruitmentPlanCommand") RecruitmentPlan recruitmentPlanUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<RecruitmentPlanLine> recruitmentPlanLine = null;
		RecruitmentPlanLine recPlanLine=null;
		String msg=null;
		int[] recPlanUpdate = recruitmentPlanUpdate.getRecPlanEditt();
		
		recruitmentPlanUpdate.setRecruitmentPlanId(recruitmentPlanUpdate.getRecruitmentPlanIdEdit());
		recruitmentPlanUpdate.setVacancyId(recruitmentPlanUpdate.getVacancyIdEdit());
	
		try{
		recruitmentPlanUpdate.setRecruitmentPlanDT(dateService.dateFormat(dateService.dateParse(recruitmentPlanUpdate.getRecruitmentPlanDTEdit(),"au"),"au"));
		
				
						
						String description = recruitmentPlanUpdate.getDescriptionEdit();
						
						if(description!=null){
							
					
						List<String> descriptionlist = Arrays.asList(description.split(","));
						Object[] descriptions = descriptionlist.toArray();
						
				
						
						String interviewRounds = recruitmentPlanUpdate.getInterviewRoundIdEdit();
				
						List<String> interviewRoundsList = Arrays.asList(interviewRounds.split(","));
						Object[] interviewRoundIds = interviewRoundsList.toArray();
						
		recruitmentPlanLine = new ArrayList<RecruitmentPlanLine>();
		for (int i = 0; i < descriptions.length; i++) {
		
			recPlanLine = new RecruitmentPlanLine();
			
			recPlanLine.setInterviewRoundId(interviewRoundIds[i].toString());
			
			recPlanLine.setDescription(descriptions[i].toString());
			
	
			int replanId = recPlanUpdate[i];
			String check = "1", check1 = "0";
			String egCheck = request.getParameter(replanId + "Check");
			
			if (check.equals(egCheck)) {
		
				recruitmentPlanService.deleteRecruitmentPlanDetail(replanId);

			}

			if (check1.equals(egCheck) || egCheck == null) {
				
				recruitmentPlanLine.add(recPlanLine);

			}
			//recruitmentPlanLine.add(recPlanLine);
		}
			
		

		

				recruitmentPlanUpdate.setRecruitmentPlanLine(recruitmentPlanLine);
					

				System.out.println("date update:"+recruitmentPlanUpdate.getRecruitmentPlanDT());
		msg=recruitmentPlanService.updateRecruitmentPlan(recruitmentPlanUpdate);
		
		if(msg=="S"){
			request.setAttribute("recPlanUpdate", "Recruitment Plan has been updated");
		}
		else{
			request.setAttribute("recPlanUpdateError", "Recruitment Plan has not been updated");
		}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "recruitmentPlanHome";
	}

	@RequestMapping(value = "/recruitmentPlanDelete", method = RequestMethod.GET)
	public ModelAndView employeeDelete(
			@ModelAttribute("RecruitmentPlanCommand") RecruitmentPlan recruitmentPlanDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("recruitmentPlanId"));
		try {

			String msg = recruitmentPlanService.deleteRecruitmentPlan(id);
			if (msg == "S") {

				request.setAttribute("recPlanDelete","Recruitment Plan has been deleted");
				
				
			} else {

				request.setAttribute("recPlanDeleteError", "Recruitment Plan has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("recruitmentPlanHome", "RecruitmentPlanCommand",
				new RecruitmentPlan());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "recruitmentPlanId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
