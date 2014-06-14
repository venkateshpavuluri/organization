
package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import com.mnt.erp.bean.ApplicantBean;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.InterViewResult;
import com.mnt.erp.bean.InterViewSchedule;
import com.mnt.erp.bean.InterviewRound;
import com.mnt.erp.bean.VacancyDetailLine;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.InterviewScheduleService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author venkateshp
 *
 */
@Controller
public class InterviewSheduleContoller {
	private static Logger logger=Logger.getLogger(InterviewSheduleContoller.class);
	@Autowired
	InterviewScheduleService ivScheduleService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;
	@Autowired 
	XmlLabelsService xmlService;
	@Autowired
	PopulateService populateService;
	@Autowired
	ERPDao erpDao;
	@Autowired
	DateConversionService dateService;

	@RequestMapping(value = "/inetrviewScheduleHome", method = RequestMethod.GET)
	public String interViewSheduleHome(
			@ModelAttribute("interviewSchedule") InterViewSchedule interViewSchedule,
			SessionStatus status,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		return "interviewScheduleView";

}
	
	
	@RequestMapping(value = "/saveInterviewSchedule", method = RequestMethod.POST)
	
	public String addInterViewShedule(
			@ModelAttribute("interviewSchedule") InterViewSchedule interViewSchedule,
			SessionStatus status,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicatId=null;
		HttpSession session=null;
		List<InterViewResult> viewResultslist=null;
try
{
	
	interViewSchedule.setScheduledDate(dateService.dateFormat(dateService.dateParse(interViewSchedule.getScheduledDate(),"au"),"au"));
	viewResultslist=new ArrayList<InterViewResult>();
	String[] comments=interViewSchedule.getComments().split(",");
	String[] nextRound=interViewSchedule.getNextRound().split(",");
	String[] rating=interViewSchedule.getRating().split(",");
	String[] applicants=interViewSchedule.getIrApplicantId().split(",");

	for(int i=0;i<comments.length;i++)
	{
		InterViewResult viewResult=new InterViewResult();
		viewResult.setComments(comments[i]);
		viewResult.setIrApplicantId(applicants[i]);
		viewResult.setNextRound(nextRound[i]);
		viewResult.setRating(rating[i]);
		viewResultslist.add(viewResult);
	}
	interViewSchedule.setIvResultDetails(viewResultslist);
	int idg=erpDao.saveDetails(interViewSchedule);
	
	if(idg!=0)
	{
		session=request.getSession(false);
		 Date date1 = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Interviw Shedule","ROW" ,String.valueOf(interViewSchedule.getInterviewScheduleId()),"1",modifiedDate,session.getAttribute("userName").toString());
		return "redirect:/inetrviewScheduleHome.mnt?list=success";
	}
	else
	{
		return "redirect:/inetrviewScheduleHome.mnt?listwar=fail";
	}
	

	
	
}
catch(Exception e)
{
	e.printStackTrace();
	return "redirect:/inetrviewScheduleHome.mnt?listwar=fail";
}
}
	
	
	@RequestMapping(value = "/searchIVSchedule", method = RequestMethod.GET)
	public String searchIVShedule(
			@ModelAttribute("interviewSchedule")InterViewSchedule interViewSchedule,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		List<Object[]> listOfObjects=null;
		List<InterViewSchedule> interViewSchedules=null;
		Iterator<Object[]> iterator=null;
		try
		{
			
			//int iid = interViewSchedule.getDeliveryNoteId();
			
			String dbField = interViewSchedule.getXmlLabel();
			String operation = interViewSchedule.getOperations();
			String basicSearchId = interViewSchedule.getBasicSearchId();
			interViewSchedules=new ArrayList<InterViewSchedule>();
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
			// sql="selecct d.deliveryNoteId,d.deliveryNoteDate,d.totalWeight,d.uomDetails,d.plannedGI,d.actualGI,d.noofPacks,d.statusDetails,d.deliveryNotes from com.mnt.erp.bean.DeliveryNote d ";

			if (basicSearchId == "") {
				listOfObjects=ivScheduleService.searchIVSchedule();
				iterator=listOfObjects.iterator();
				while(iterator.hasNext())
				{
					Object[] objects=(Object[])iterator.next();
					InterViewSchedule viewSchedule=new InterViewSchedule();
					
					//sql="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue from com.mnt.erp.bean.InterViewSchedule i";
				VacancyDetailLine detailLine=(VacancyDetailLine)objects[0];
				Employee employee=(Employee)objects[1];
				ApplicantBean applicantBean=(ApplicantBean)objects[2];
				InterviewRound interviewRound=(InterviewRound)objects[3];
				viewSchedule.setScheduledDate(dateService.dateFormat(dateService.dateParse((String)objects[4],"se"),"se"));
				viewSchedule.setScheduledTime((String)objects[5]);
				viewSchedule.setVenue((String)objects[6]);
				viewSchedule.setInterviewScheduleId((Integer)objects[7]);
				viewSchedule.setVacancyNo(detailLine.getVacancyDetailNo());
				viewSchedule.setEmpName(employee.getfName()+employee.getmName()+employee.getlName());
				viewSchedule.setiVRoundName(interviewRound.getInterviewRound());
				viewSchedule.setApplicanName(applicantBean.getFname()+applicantBean.getMname()+applicantBean.getLname());
			    interViewSchedules.add(viewSchedule);
				}
				
				
			}
			else
			{
				listOfObjects=ivScheduleService.basicSearchIVSchedule(dbField, operation, basicSearchId);
				iterator=listOfObjects.iterator();
				while(iterator.hasNext())
				{
					Object[] objects=(Object[])iterator.next();
					InterViewSchedule viewSchedule=new InterViewSchedule();
					
					//sql="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue from com.mnt.erp.bean.InterViewSchedule i";
				VacancyDetailLine detailLine=(VacancyDetailLine)objects[0];
				Employee employee=(Employee)objects[1];
				ApplicantBean applicantBean=(ApplicantBean)objects[2];
				InterviewRound interviewRound=(InterviewRound)objects[3];
				viewSchedule.setScheduledDate(dateService.dateFormat(dateService.dateParse((String)objects[4],"se"),"se"));
				viewSchedule.setScheduledTime((String)objects[5]);
				viewSchedule.setVenue((String)objects[6]);
				viewSchedule.setInterviewScheduleId((Integer)objects[7]);
				viewSchedule.setVacancyNo(detailLine.getVacancyDetailNo());
				viewSchedule.setEmpName(employee.getfName()+employee.getmName()+employee.getlName());
				viewSchedule.setiVRoundName(interviewRound.getInterviewRound());
				viewSchedule.setApplicanName(applicantBean.getFname()+applicantBean.getMname()+applicantBean.getLname());
			    interViewSchedules.add(viewSchedule);
				}
				
				
			}
			request.setAttribute("IVScheduleDetails",interViewSchedules);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "interviewScheduleView";
	}
	

	@RequestMapping(value = "/iVScheduleEdit", method = RequestMethod.GET)
	public String editIVShedule(
			@ModelAttribute("interviewSchedule")InterViewSchedule interViewSchedule,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		List<InterViewSchedule> iVSchedulesList=null;
		List<InterViewSchedule> iVSchedulesListIterator=null;
		Iterator<InterViewSchedule> iterator=null;
		List<InterViewResult> interViewResults=null;
		try
		{
			
			
			iVSchedulesListIterator=new ArrayList<InterViewSchedule>();
		int sheduleId=Integer.parseInt(request.getParameter("iVScheduleId"));	
		iVSchedulesList=ivScheduleService.editIVScheduleDetails(sheduleId);
		if(iVSchedulesList!=null)
		{
			iterator=iVSchedulesList.iterator();
			while(iterator.hasNext())
			{
				InterViewSchedule viewSchedule=(InterViewSchedule)iterator.next();
				viewSchedule.setScheduledDate(dateService.dateFormat(dateService.dateParse(viewSchedule.getScheduledDate(),"se"),"se"));
				
				BeanUtils.copyProperties(interViewSchedule, viewSchedule);
				 interViewResults=viewSchedule.getIvResultDetails();
			}
			Iterator<InterViewResult> iteratorresult=interViewResults.iterator();
			while(iteratorresult.hasNext())
			{
				InterViewResult interViewResult=(InterViewResult)iteratorresult.next();
				InterViewSchedule viewScheduleparent=new InterViewSchedule();
				ApplicantBean applicantBean=(ApplicantBean)interViewResult.getApplicantsDetails();
				viewScheduleparent.setApplicanName(applicantBean.getFname());
				viewScheduleparent.setInterviewResultIdEdit(String.valueOf(interViewResult.getInterviewResultId()));
				viewScheduleparent.setIrApplicantIdEdit(interViewResult.getIrApplicantId());
				viewScheduleparent.setRatingEdit(interViewResult.getRating());
				viewScheduleparent.setNextRoundEdit(interViewResult.getNextRound());
				if(interViewResult.getNextRound().equals("0"))
				{
			
				viewScheduleparent.setNextRoundNameEdit("No");
				
				}
				else
				{
					viewScheduleparent.setNextRoundNameEdit("Yes");
				}
				logger.info("nextround edit iss=="+viewScheduleparent.getNextRoundEdit());
				viewScheduleparent.setCommentsEdit(interViewResult.getComments());
				iVSchedulesListIterator.add(viewScheduleparent);
			}
			
			/*request.setAttribute("interViewResults", interViewResults);*/
			logger.info("size iss=="+iVSchedulesList.size());
			request.setAttribute("interviewResult", iVSchedulesListIterator);
			
		}
		request.setAttribute("editValues","edit");
		}
		catch(Exception e)
		{
		
			e.printStackTrace();
			return "interviewScheduleView";
		}
		return "interviewScheduleView";
		
	}
	
	
	
	
	@RequestMapping(value = "/searchIVUpdate", method = RequestMethod.POST)
	public String IVScheduleDelete(
			@ModelAttribute("interviewSchedule")InterViewSchedule interViewSchedule,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
	
		List<InterViewSchedule> interViewSchedules=null;
		List<InterViewResult> interViewResultslist=null;
		List<InterViewResult> childDelete=null;
		try
		{
			//sql="select count(*) from ChartofAccount cb where  cb.coa='"
					//+ chartofAccount + "' and cb.coaId!="+Id;
		interViewSchedule.setScheduledDate(dateService.dateFormat(dateService.dateParse(interViewSchedule.getScheduledDate(),"au"),"au"));
			
			String[] interviewResultIds=interViewSchedule.getInterviewResultIdEdit().split(",");
		
			String[] comments=interViewSchedule.getCommentsEdit().split(",");
			String[] nextRound=interViewSchedule.getNextRoundEdit().split(",");
			String[] rating=interViewSchedule.getRatingEdit().split(",");
			String[] applicants=interViewSchedule.getIrApplicantIdEdit().split(",");
			interViewResultslist=new ArrayList<InterViewResult>();
			childDelete=new ArrayList<InterViewResult>();
			for(int i=0;i<applicants.length;i++)
			{
				int id=Integer.parseInt(interviewResultIds[i]);
				if(id==0)
				{
				InterViewResult interViewResult=new InterViewResult();
				interViewResult.setComments(comments[i]);
				interViewResult.setInterviewResultId(Integer.parseInt(interviewResultIds[i]));
				interViewResult.setNextRound(nextRound[i]);
				interViewResult.setRating(rating[i]);
				interViewResult.setIrApplicantId(applicants[i]);
				interViewResultslist.add(interViewResult);
				}
				else
				{
					InterViewResult interViewResult=new InterViewResult();
					interViewResult.setComments(comments[i]);
					interViewResult.setInterviewResultId(Integer.parseInt(interviewResultIds[i]));
					interViewResult.setNextRound(nextRound[i]);
					interViewResult.setRating(rating[i]);
					interViewResult.setIrApplicantId(applicants[i]);
					
					
				int	ss = Integer.parseInt(interviewResultIds[i]);
				String	checked = request.getParameter("Checkdelete" + ss);
				if(checked.equals("0"))
				{
					interViewResultslist.add(interViewResult);	
				}
				else
				{
					InterViewResult childDeleteiv=new InterViewResult();
					childDeleteiv.setInterviewResultId(Integer.parseInt(interviewResultIds[i]));
					childDelete.add(childDeleteiv);
					
				}
				}
				
				}
			
			interViewSchedule.setIvResultDetails(interViewResultslist);
			ivScheduleService.deleteChildRecords(childDelete);
		String msg=ivScheduleService.updateIVScheduleDetails(interViewSchedule);
		if(msg.equals("S"))
		{
			request.setAttribute("IVScheduleUpdate","Success");
			model.addAttribute("interviewSchedule",new InterViewSchedule());
		}
		else
		{
			request.setAttribute("IVScheduleUpdateFail","Success");
		}
		
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.setAttribute("IVScheduleUpdateFail","Fail");
		}
	return "interviewScheduleView";
			
		}
	
	
	@RequestMapping(value = "/iVScheduleDelete", method = RequestMethod.GET)
	public String searchIVDelete(
			@ModelAttribute("interviewSchedule")InterViewSchedule interViewSchedule,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=null;
	try
	{
		int deleteid=Integer.parseInt(request.getParameter("iVScheduleId"));
		
	
		String msg=ivScheduleService.deleteIVSchedule(deleteid);
		if(msg.equals("S"))
		{
			session=request.getSession(false);
		 Date date1 = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Interviw Shedule","ROW" ,String.valueOf(deleteid),"1",modifiedDate,session.getAttribute("userName").toString());
			request.setAttribute("IVScheduleDelete","IVSchedule deleted successfully");
		}
		else
		{
			request.setAttribute("IVScheduleDeleteFail","IVSchedule deleted successfully");
			request.setAttribute("editValues","IVSchedule deleted successfully");
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return "interviewScheduleView";
	}
	
	
	@RequestMapping(value = "/IVScheduleDuplicate", method = RequestMethod.POST)
	public @ResponseBody String addDuplicateCheck(
			@ModelAttribute("interviewSchedule")InterViewSchedule interViewSchedule,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=null;
		String msg=null;
	try
	{
		int applicantid=Integer.parseInt(request.getParameter("applicantName"));
	Long	duplicatId=erpDao.duplicateCheck("select count(*) from InterViewSchedule b where b.applicantId="+applicantid+"");
		logger.info("duplicate id iss=="+duplicatId);
		if(duplicatId==0)
		{
			msg="not exists";
		}
		else
		{
			msg="";
		}
		
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
	}
	return msg;
	}
	
	@RequestMapping(value = "/IVScheduleCheckEdit", method = RequestMethod.POST)
	public @ResponseBody String addDuplicateCheckForEdit(
			@ModelAttribute("interviewSchedule")InterViewSchedule interViewSchedule,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=null;
		String msg=null;
	try
	{
		int applicantid=Integer.parseInt(request.getParameter("applicantName"));
		int aiVScheduleId=Integer.parseInt(request.getParameter("IVScheduleId"));
		Long duplicate=erpDao.duplicateCheck("select count(*) from InterViewSchedule b where b.applicantId="+applicantid +" and  b.interviewScheduleId!="+aiVScheduleId);
		logger.info("duplicate id iss=="+duplicate);
		if(duplicate==0)
		{
			msg="not exists";
		}
		else
		{
		msg="";
		}
		
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
	}
	return msg;
	}
	
	@RequestMapping(value = "/IVScheduleAdvanceSearch", method = RequestMethod.GET)
	public String IVSheduleAdvanceSearch(
			@ModelAttribute("interviewSchedule")InterViewSchedule interViewSchedule ,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		// String
		// advanceSearchHidden=request.getParameter("advanceSearchHidden");

		List<InterViewSchedule> scheduleList = null;

		String name1 = "interviewScheduleId", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		// Vendor v=null;

		try {
			scheduleList = new ArrayList();
			interViewSchedule.setAdvanceSearchHidden(1);
			returnString = xmlService.populateXml(name1);
			Iterator it = returnString.iterator();
			for (Object[] object : returnString) {
				InterViewSchedule v = new InterViewSchedule();

				s1 = (String) object[0];
				s2 = (String) object[1];
				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				scheduleList.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("listofIVSchedule", scheduleList);

		return "interviewScheduleView";
	}
	
	
	

	@RequestMapping(value = "/IVSheduleAdvanceSearchOperations", method = RequestMethod.POST)
	public String iVSheduleAdvanceSearchOperations(@ModelAttribute("interviewSchedule") InterViewSchedule interViewSchedule,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
	
		List<Object[]> objectsArray = null;
		Iterator<Object[]> iterator = null;
		response.setCharacterEncoding("UTF-8");
	
		String columns = interViewSchedule.getFirstLabel();
		String operations = interViewSchedule.getOperations1();
		String advanceSearchText = interViewSchedule.getAdvanceSearchText();
		logger.info("advance search iss===" + advanceSearchText);
		List<InterViewSchedule> interViewSchedules=null;
		try
		{
			interViewSchedules=new ArrayList<InterViewSchedule>();
		if (advanceSearchText != null) {
			if (advanceSearchText.length() != 0) {
				objectsArray = ivScheduleService.iVScheduleAdvance(columns,
						operations, advanceSearchText);
			} else {
				objectsArray = ivScheduleService.getIVShedule("ALL");
			}
		}
		if (objectsArray != null) {
			iterator = objectsArray.iterator();
			while (iterator.hasNext()) {
				Object[] objects=(Object[])iterator.next();
				InterViewSchedule viewSchedule=new InterViewSchedule();
				
				//sql="select i.vacancyDetails,i.employees,i.applicant,i.interviewRound,i.scheduledDate,i.scheduledTime,i.venue from com.mnt.erp.bean.InterViewSchedule i";
			VacancyDetailLine detailLine=(VacancyDetailLine)objects[0];
			Employee employee=(Employee)objects[1];
			ApplicantBean applicantBean=(ApplicantBean)objects[2];
			InterviewRound interviewRound=(InterviewRound)objects[3];
			viewSchedule.setScheduledDate((String)objects[4]);
			viewSchedule.setScheduledTime((String)objects[5]);
			viewSchedule.setVenue((String)objects[6]);
			viewSchedule.setInterviewScheduleId((Integer)objects[7]);
			viewSchedule.setVacancyNo(detailLine.getVacancyDetailNo());
			viewSchedule.setEmpName(employee.getfName()+employee.getmName()+employee.getlName());
			viewSchedule.setiVRoundName(interviewRound.getInterviewRound());
			viewSchedule.setApplicanName(applicantBean.getFname()+applicantBean.getMname()+applicantBean.getLname());
		    interViewSchedules.add(viewSchedule);
				logger.info("with in the advance search");
			}
		}
		request.setAttribute("IVScheduleDetails", interViewSchedules);
		// model.addAttribute("RFQ",new RfqBean());
		interViewSchedule.setAdvanceSearchHidden(0);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "interviewScheduleView";
	}
	
	
	
	
	
	
	@ModelAttribute("vacancyDetails")
	public Map<Integer, String> populateVacancyDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			/*
			 * listvalues = categoryService .selectMaterialCategoryDetails();
			 */
			map = populateService.populateSelectBox("select m.vacancyDetailLineId,m.vacancyDetailNo from com.mnt.erp.bean.VacancyDetailLine m");
logger.info("vacancydetails length iss=="+map.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@ModelAttribute("applicantDetails")
	public Map<Integer, String> populateApplicantDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			/*
			 * listvalues = categoryService .selectMaterialCategoryDetails();
			 */
			map = populateService.populateSelectBox("select v.applicant_Id,v.fname from com.mnt.erp.bean.ApplicantBean v");
			logger.info("applicant detail length iss=="+map.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("employeeDetails")
	public Map<Integer, String> populateEmployeeDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			/*
			 * listvalues = categoryService .selectMaterialCategoryDetails();
			 */
			map = populateService.populateSelectBox("select v.employee_Id,v.fName from com.mnt.erp.bean.Employee v");
			logger.info("employee detail length iss=="+map.size());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@ModelAttribute("interviewRoundDetails")
	public Map<Integer, String> populateInterviewRoundDetails() {
		List<Object[]> listvalues = null;
		Map<Integer, String> map = null;
		Iterator<Object[]> iterator = null;
		try {
			/*
			 * listvalues = categoryService .selectMaterialCategoryDetails();
			 */
			map = populateService.populateSelectBox("select v.interviewRoundId,v.interviewRound from com.mnt.erp.bean.InterviewRound v");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "interviewScheduleId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
}
