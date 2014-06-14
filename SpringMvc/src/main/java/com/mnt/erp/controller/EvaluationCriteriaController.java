package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.EvaluationCriteria;
import com.mnt.erp.bean.EvaluationSubCriteria;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.EvaluationCriteriaService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class EvaluationCriteriaController {
	@Autowired
	EvaluationCriteriaService evaluationCriteriaService;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/EvaluationCriteria", method = RequestMethod.GET)
	public ModelAndView getEvaluationCriteria(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		
		return new ModelAndView("EvaluationCriteriaHome", "EvaluationCriteriaadd",
				new EvaluationCriteria());
	}

	@RequestMapping(value = "/EvaluationCriteriaadd", method = RequestMethod.POST)
	public String saveEvaluationCriteria(
			@ModelAttribute("EvaluationCriteriaadd") EvaluationCriteria EvaluationCriteria,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		List<String> list = new ArrayList<String>();
		String msg = null;
		String EvaluationCriteriaAdd = null;
		EvaluationSubCriteria EvaluationSubCriteriass=null;
		String res = null;
		HttpSession session=null;
		int EvaluationCriteriaList1 = 0;
		List<EvaluationSubCriteria> evaluationSubCriterialist=null;
		String evaluationCriteria = EvaluationCriteria.getEvaluationCriteria();
		
		EvaluationCriteriaList1 = evaluationCriteriaService.EvaluationCriteriaDuplicate(evaluationCriteria);
		
		if (EvaluationCriteriaList1 == 0) {

			try {
				session=request.getSession(false);
				String rating = EvaluationCriteria.getEvaluationSubCriteria();
				if(rating!=null){
				
				List<String> ratinglist = Arrays.asList(rating.split(","));
				Object[] evac = ratinglist.toArray();
				
				
				String score = EvaluationCriteria.getScore();
				List<String> scoreList = Arrays.asList(score.split(","));
				Object[] scores = scoreList.toArray();
				

			
				
				evaluationSubCriterialist= new ArrayList<EvaluationSubCriteria>();
				for (int i = 0; i < evac.length; i++) {
				
					EvaluationSubCriteriass = new EvaluationSubCriteria();
					EvaluationSubCriteriass.setEvaluationSubCriteria(evac[i].toString());
					
					EvaluationSubCriteriass.setScore(scores[i].toString());
					
					evaluationSubCriterialist.add(EvaluationSubCriteriass);
			
		
				}
				EvaluationCriteria.setEvaluationSubCriterias(evaluationSubCriterialist);
			
		
				} 
				msg = evaluationCriteriaService.saveEvaluationCriteria(EvaluationCriteria,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

				if (msg.equals("S")) {
					EvaluationCriteriaAdd = "Evaluation Criteria has been saved successfully";
					list.add("2");
					res = "redirect:EvaluationCriteria.mnt?success="
							+ EvaluationCriteriaAdd + "&list=" + list + "";
				} else {
					EvaluationCriteriaAdd = "Evaluation Criteria is not saved properly";
					list.add("2");
					res = "redirect:EvaluationCriteria.mnt?warning="
							+ EvaluationCriteriaAdd + "&listwar=" + list + "";
				}

			} catch (Exception e) {
				
				EvaluationCriteriaAdd = "Evaluation Criteria is not saved properly";
				list.add("2");
				res = "redirect:EvaluationCriteria.mnt?warning="
						+ EvaluationCriteriaAdd + "&listwar=" + list + "";
				e.printStackTrace();
			}

		

		}

		else {

			EvaluationCriteria.setAid(1);

			request.setAttribute("addEvaluationCriteriaDuplicate",
					"Evaluation Criteria Already Exists Please try some other name");

			return "EvaluationCriteriaHome";

		}
		return res;
	}

	@RequestMapping(value = "/EvaluationCriteriaSearch", method = RequestMethod.GET)
	public ModelAndView searchEvaluationCriteria(
			@ModelAttribute("EvaluationCriteriaadd") EvaluationCriteria EvaluationCriteria,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
	
		response.setCharacterEncoding("UTF-8");
		List<EvaluationCriteria> evaluationCriterias = null;
		try {
			int id = EvaluationCriteria.getEvaluationCriteriaId();
			String dbField = EvaluationCriteria.getXmlLabel();
			String operation = EvaluationCriteria.getOperations();
			String basicSearchId = EvaluationCriteria.getBasicSearchId();

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
				List<Object[]> list = evaluationCriteriaService.searchEvaluationCriteria(id);
				evaluationCriterias = new ArrayList<EvaluationCriteria>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					EvaluationCriteria at = new EvaluationCriteria();
					at.setEvaluationCriteriaId((Integer) objects[0]);
					at.setEvaluationCriteria((String) objects[1]);
					at.setWeightingFactor((String) objects[2]);
					evaluationCriterias.add(at);
				}

			} else {

				List<Object[]> list = evaluationCriteriaService.basicSearchEvaluationCriteria(
						dbField, operation, basicSearchId);
				evaluationCriterias = new ArrayList<EvaluationCriteria>();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					EvaluationCriteria agt = new EvaluationCriteria();
					agt.setEvaluationCriteriaId((Integer) objects[0]);
					agt.setEvaluationCriteria((String) objects[1]);
					agt.setWeightingFactor((String) objects[2]);
					evaluationCriterias.add(agt);

				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("agtvalues", "agtvalues");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("EvaluationCriteriaHome");
		modelAndView.addObject("EvaluationCriteria", evaluationCriterias);
		return modelAndView;
	}

	@RequestMapping(value = "/EvaluationCriteriaEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editEvaluationCriteria(
			@ModelAttribute("EvaluationCriteriaadd") EvaluationCriteria EvaluationCriteria,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<EvaluationCriteria> evaluationCriteriaList=new ArrayList<EvaluationCriteria>();
		List<EvaluationSubCriteria> evaluationSubCriteriaList=new ArrayList<EvaluationSubCriteria>();
		int id = Integer.parseInt(request.getParameter("EvaluationCriteriaEdit"));
		List<EvaluationCriteria> list = null;
		EvaluationCriteria objects = null;
		try {
			list = evaluationCriteriaService.editEvaluationCriteriaWithId(id);
			Iterator<EvaluationCriteria> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = iterator.next();
				EvaluationCriteria resReq = (EvaluationCriteria) objects;
				EvaluationCriteria.setEvaluationCriteriaIdEdit(resReq.getEvaluationCriteriaId());
				EvaluationCriteria.setEvaluationCriteriaEdit(resReq.getEvaluationCriteria());
				EvaluationCriteria.setWeightingFactorEdit(resReq.getWeightingFactor());
				List<EvaluationSubCriteria> listEdit = resReq.getEvaluationSubCriterias();
				
				Iterator<EvaluationSubCriteria> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					EvaluationSubCriteria resRdit = (EvaluationSubCriteria) object2;
					EvaluationSubCriteria resReEdit = new EvaluationSubCriteria();
					resReEdit.setEvaluationSubCriteriaIdEdit(resRdit.getEvaluationSubCriteriaId());
					resReEdit.setEvaluationSubCriteriaEdit(resRdit.getEvaluationSubCriteria());
					
					resReEdit.setScoreEdit(resRdit.getScore());
				
					evaluationSubCriteriaList.add(resReEdit);
				}
				EvaluationCriteria.setEvaluationSubCriterias(evaluationSubCriteriaList);
				evaluationCriteriaList.add(EvaluationCriteria);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("EvaluationCriteriavalues", evaluationCriteriaList);
		
		request.setAttribute("evaluationSubCriteriaList", evaluationSubCriteriaList);
		request.setAttribute("EvaluationCriteriavalues", "EvaluationCriteriavalues");
		return "EvaluationCriteriaHome";

	}

	@RequestMapping(value = "/EvaluationCriteriaUpdate", method = RequestMethod.POST)
	public String updateEvaluationCriteria(
			@ModelAttribute("EvaluationCriteriaadd") EvaluationCriteria evaluationCriteriaEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		int EvaluationCriteriaEditList = 0;
		List<EvaluationSubCriteria> evaluationCriteriaList=null;
		EvaluationSubCriteria evaluationSubCriteria=null;
		String evaluationCriteria = evaluationCriteriaEdit.getEvaluationCriteriaEdit();
		int id = evaluationCriteriaEdit.getEvaluationCriteriaIdEdit();
		evaluationCriteriaEdit.setEvaluationCriteriaId(evaluationCriteriaEdit.getEvaluationCriteriaIdEdit());
		evaluationCriteriaEdit.setEvaluationCriteria(evaluationCriteriaEdit.getEvaluationCriteriaEdit());
		evaluationCriteriaEdit.setWeightingFactor(evaluationCriteriaEdit.getWeightingFactorEdit());
		EvaluationCriteriaEditList = evaluationCriteriaService.EvaluationCriteriaEditDuplicate(
				evaluationCriteria, id);
		if (EvaluationCriteriaEditList == 0) {

			try {
				String rating = evaluationCriteriaEdit.getEvaluationSubCriteriaEdit();

				if(rating!=null){
				
				
				
				List<String> ratinglist = Arrays.asList(rating.split(","));
				Object[] ratings = ratinglist.toArray();
				
							
				
				
			   
				String kpis = evaluationCriteriaEdit.getScoreEdit();
				
				List<String> kpiList = Arrays.asList(kpis.split(","));
				Object[] kpiIds = kpiList.toArray();
				
			
				int[] empPerUpdate = evaluationCriteriaEdit.getEveCriteriaEditt();
				
			
				evaluationCriteriaList = new ArrayList<EvaluationSubCriteria>();
				for (int i = 0; i < ratings.length; i++) {
				
					evaluationSubCriteria = new EvaluationSubCriteria();
					evaluationSubCriteria.setEvaluationCriteriaId(evaluationSubCriteria.getEvaluationCriteriaIdEdit());
					evaluationSubCriteria.setEvaluationSubCriteria(ratings[i].toString());
					evaluationSubCriteria.setScore(kpiIds[i].toString());
				

					int resDelId = empPerUpdate[i];
					
						String check = "1", check1 = "0";
						String egCheck = request.getParameter(resDelId + "Check");
						
						if (check.equals(egCheck)) {
							
							evaluationCriteriaService.deleteEvaluationCriteriaDetail(resDelId);

						}

						if (check1.equals(egCheck) || egCheck == null) {
							
							evaluationCriteriaList.add(evaluationSubCriteria);

						}
					
				}
				evaluationCriteriaEdit.setEvaluationSubCriterias(evaluationCriteriaList);
				
				
				String msg = evaluationCriteriaService.updateEvaluationCriteria(evaluationCriteriaEdit);

				if (msg == "S") {

					request.setAttribute("EvaluationCriteriaUpdate",
							"Evaluation Criteria has been updated successfully");

				}

				else {

					request.setAttribute("EvaluationCriteriaUpdateError",
							"Evaluation Criteria has not been updated");
				}

			}
			}catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("EvaluationCriteriaadd", new EvaluationCriteria());

			return "EvaluationCriteriaHome";

		} else {

			request.setAttribute("EvaluationCriteriavalues", "EvaluationCriteriavalues");
			request.setAttribute("editEvaluationCriteriaDuplicate",
					"Evaluation Criteria Already Exists Please try some other name");

			return "EvaluationCriteriaHome";
		}

	}

	@RequestMapping(value = "/EvaluationCriteriaDelete", method = RequestMethod.GET)
	public ModelAndView deleteEvaluationCriteria(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;

		try {
			id = Integer.parseInt(request.getParameter("EvaluationCriteriaDelete"));
			
			String msg = evaluationCriteriaService.EvaluationCriteriaDelete(id);
			
			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Evaluation Criteria","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("EvaluationCriteriadelete",
						"Evaluation Criteria has been deleted successfully");
			} else {
				request.setAttribute("EvaluationCriteriadeleteError",
						"Evaluation Criteria has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("EvaluationCriteriaHome", "EvaluationCriteriaadd",
				new EvaluationCriteria());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "EvaluationCriteria";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
