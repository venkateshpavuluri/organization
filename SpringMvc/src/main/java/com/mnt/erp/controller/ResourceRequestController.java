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
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.ResourceReqDetail;
import com.mnt.erp.bean.ResourceRequest;
import com.mnt.erp.bean.Status;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.ResourceRequestService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.mail.MailService;

@Controller
public class ResourceRequestController {
	
	@Autowired
	public org.springframework.mail.javamail.JavaMailSenderImpl mailSender;
	@Autowired
	ResourceRequestService resourceRequestService;

	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
    public MailService	userRegistraService;
	
	@Autowired
	DateConversionService dateService;
	
	@RequestMapping(value="/ResourceRequest",method=RequestMethod.GET)
	public ModelAndView getResourceRequest(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		
		
		return new ModelAndView("ResourceRequestHome","resourceRequestCommand",new ResourceRequest());
	}
	
	/* To Get Status Id Values */
	@ModelAttribute("status")
	public Map<Integer, String> statusIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = resourceRequestService.selectStatus();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	/* To Get employee Id Values */
	@ModelAttribute("employee")
	public Map<Integer, String> employeeIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = resourceRequestService.selectEmployee();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}
	@RequestMapping(value = "/resourceRequestAdd", method = RequestMethod.POST)
	public String saveResourceRequestAdd(
			@ModelAttribute("resourceRequestCommand") ResourceRequest resourceRequestAdd,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res=null;
		List<ResourceReqDetail> resourceReqDetail = null;
		ResourceReqDetail resourceReqDetails=null;
		 mailSender.setHost("smtp.gmail.com");
		 mailSender.setPort(587);
		 mailSender.setUsername("thotaparvathidevi@gmail.com");
		 mailSender.setPassword("kruparani");
	/*	final String username="";
		final String password="";
		Properties pop=new Properties();
		pop.put("mail.smtp.auth","true");
		pop.put("mail.smtp.starttls.enable","true");
		pop.put("mail.smtp.host", "smtp.gmail.com");
		pop.put("mail.smtp.port", "587");
		
		Session session=Session.getInstance(pop, new javax.mail.);*/
			try { 
			
				resourceRequestAdd.setResourceReqDate(dateService.dateFormat(dateService.dateParse(resourceRequestAdd.getResourceReqDate(),"au"),"au"));         
				/*JavaMailSenderImpl sender = new JavaMailSenderImpl();
		        sender.setHost("smtp.gmail.com");
		        sender.setPort(587);
		        sender.setPassword("devimca");
		        sender.setUsername("parvathidevi@mntsoft.co.in");

		        MimeMessage message = sender.createMimeMessage();
		       
		            MimeMessageHelper helper = new MimeMessageHelper(message);
		            helper.setTo("parvathidevi@mntsoft.co.in");
		            helper.setText("Thank you for ordering!");
		        

		        sender.send(message);*/
		   
				int[] noOfPositions = resourceRequestAdd.getNoOfPositions();
				
				String requiredDate = resourceRequestAdd.getRequiredDate();
				if(requiredDate!=null){
				
				
				String jobDescription = resourceRequestAdd.getJobDescription();
				List<String> jobDescriptionlist = Arrays.asList(jobDescription.split(","));
				Object[] jobDescriptions = jobDescriptionlist.toArray();
				
			
				List<String> requiredDatelist = Arrays.asList(requiredDate.split(","));
				Object[] requiredDates = requiredDatelist.toArray();
				
							
				
				String priorities = resourceRequestAdd.getPriority();
				List<String> prioritiesList = Arrays.asList(priorities.split(","));
				Object[] priority = prioritiesList.toArray();
				
				String statuss = resourceRequestAdd.getRdstatusId();
				List<String> statusList = Arrays.asList(statuss.split(","));
				Object[] statusids = statusList.toArray();
				
				resourceReqDetail = new ArrayList<ResourceReqDetail>();
				for (int i = 0; i < requiredDates.length; i++) {
				
					resourceReqDetails = new ResourceReqDetail();
					resourceReqDetails.setNoOfPositions(noOfPositions[i]);
					resourceReqDetails.setJobDescription(jobDescriptions[i].toString());
					resourceReqDetails.setRequiredDate(requiredDates[i].toString());
					resourceReqDetails.setPriority(priority[i].toString());
				
					resourceReqDetails.setRdstatusId(statusids[i].toString());
					
					
					resourceReqDetail.add(resourceReqDetails);
			
		
				}
				resourceRequestAdd.setResourceReqDetail(resourceReqDetail);
		
				} 
				userRegistraService.hrmail(resourceRequestAdd);
				msg=resourceRequestService.saveResourceRequestDetails(resourceRequestAdd);
				
				if(msg=="S"){
					res = "redirect:ResourceRequest.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:ResourceRequest.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				res = "redirect:ResourceRequest.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
				
			}

		
			return res;

	}
	@RequestMapping(value = "/resourceReqSearch", method = RequestMethod.GET)
	public ModelAndView resourceRequestSearch(
			@ModelAttribute("resourceRequestCommand") ResourceRequest resourceReqSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<ResourceRequest> resourceRequestBean = new ArrayList<ResourceRequest>();

		try {
		
			String dbField = resourceReqSearch.getXmlLabel();
			String operation = resourceReqSearch.getOperations();
			String basicSearchId = resourceReqSearch.getBasicSearchId();

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
				list = resourceRequestService.searchResourceRequest();

			} else {
				list = resourceRequestService.basicSearchResourceRequest(dbField, operation, basicSearchId);
						
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				ResourceRequest resReq = new ResourceRequest();
				Object[] obj = (Object[]) iterator.next();
				resReq.setResourceReqId((Integer) obj[0]);
				resReq.setResourceReqDate(dateService.dateFormat(dateService.dateParse((String) obj[1],"se"),"se"));
				Employee emp=((Employee) obj[2]);
				resReq.setEmpName(emp.getfName());
				resReq.setDescription((String) obj[3]);
				Status status=((Status) obj[4]);
				resReq.setStatusName(status.getStatus());
				resourceRequestBean.add(resReq);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("resourceReqValues", "resourceReqValues");


		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("ResourceRequestHome");
	    modelAndView.addObject("resourceRequest",resourceRequestBean);
		return modelAndView;

	}

	@RequestMapping(value = "/resourceReqEdit", method = RequestMethod.GET)
	public String editProdutionPlan(
			@ModelAttribute("resourceRequestCommand") ResourceRequest resourceRequestEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ResourceRequest> resReqEdit = new ArrayList<ResourceRequest>();
		
		List<ResourceReqDetail> resourceReqDetailList = new ArrayList<ResourceReqDetail>();
		int id = Integer.parseInt(request.getParameter("resourceReqId"));

		try {
			List<ResourceRequest> list = resourceRequestService.searchResourceRequestWithId(id);
			Iterator<ResourceRequest> iter = list.iterator();
			while (iter.hasNext()) {
				 Object pobject = iter.next();
				ResourceRequest resReq = (ResourceRequest) pobject;
				
				resourceRequestEdit.setResourceReqIdEdit(resReq.getResourceReqId());
				resourceRequestEdit.setResourceReqDateEdit(dateService.dateFormat(dateService.dateParse(resReq.getResourceReqDate(),"se"),"se"));
				resourceRequestEdit.setEmployeeIdEdit(resReq.getEmployeeId());
				resourceRequestEdit.setDescriptionEdit(resReq.getDescription());
				resourceRequestEdit.setStatusIdEdit(resReq.getStatusId());
				//resReqEdit.add(resourceRequestEdit);
				
				List<ResourceReqDetail> listEdit = resReq.getResourceReqDetail();
				
				Iterator<ResourceReqDetail> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					ResourceReqDetail resRdit = (ResourceReqDetail) object2;
				
					ResourceReqDetail resReEdit = new ResourceReqDetail();
					resReEdit.setResourceReqDetIdEdit(resRdit.getResourceReqDetId());
					
					resReEdit.setNoOfPositionsEdit(resRdit.getNoOfPositions());
					resReEdit.setJobDescriptionEdit(resRdit.getJobDescription());
					resReEdit.setRequiredDateEdit(dateService.dateFormat(dateService.dateParse(resRdit.getRequiredDate(),"se"),"se"));
					
					resReEdit.setPriorityEdit(resRdit.getPriority());
					Status status=resRdit.getStatus();
					resReEdit.setRdstatusname(status.getStatus());
					resReEdit.setRdstatusIdEdit(resRdit.getRdstatusId());
				
					
				
					resourceReqDetailList.add(resReEdit);
				

				}
				resourceRequestEdit.setResourceReqDetail(resourceReqDetailList);
				
				resReqEdit.add(resourceRequestEdit);

			}
		
			
			request.setAttribute("resReqEdit", resReqEdit);
			
			request.setAttribute("resourceReqDetailList", resourceReqDetailList);
			
			}
		 catch (Exception e) {
			e.printStackTrace();
		}
		
		return "ResourceRequestHome";

	}
	
	@RequestMapping(value = "/resouceReqUpdate", method = RequestMethod.POST)
	public String productionPlanUpdate(
			@ModelAttribute("resourceRequestCommand") ResourceRequest resourceReqUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ResourceReqDetail> resourceReqDetail = null;
		ResourceReqDetail resoReqDetail=null;
		String msg=null;
		try{
		resourceReqUpdate.setResourceReqId(resourceReqUpdate.getResourceReqIdEdit());
		resourceReqUpdate.setResourceReqDate(dateService.dateFormat(dateService.dateParse(resourceReqUpdate.getResourceReqDateEdit(),"au"),"au"));
		resourceReqUpdate.setEmployeeId(resourceReqUpdate.getEmployeeIdEdit());
		resourceReqUpdate.setDescription(resourceReqUpdate.getDescriptionEdit());
		resourceReqUpdate.setStatusId(resourceReqUpdate.getStatusIdEdit());
			
		int[] noOfPositions = resourceReqUpdate.getNoOfPositionsEdit();
		String requiredDate = resourceReqUpdate.getRequiredDateEdit();

		if(requiredDate!=null){
		
		
		String jobDescription = resourceReqUpdate.getJobDescriptionEdit();
		List<String> jobDescriptionlist = Arrays.asList(jobDescription.split(","));
		Object[] jobDescriptions = jobDescriptionlist.toArray();
		
	
		List<String> requiredDatelist = Arrays.asList(requiredDate.split(","));
		Object[] requiredDates = requiredDatelist.toArray();
		
					
		
		String priorities = resourceReqUpdate.getPriorityEdit();
		List<String> prioritiesList = Arrays.asList(priorities.split(","));
		Object[] priority = prioritiesList.toArray();
	   
		String statuss = resourceReqUpdate.getRdstatusIdEdit();
		
		List<String> statusList = Arrays.asList(statuss.split(","));
		Object[] statusids = statusList.toArray();
		int[] resReqIdUpdate = resourceReqUpdate.getResReqEditt();

		resourceReqDetail = new ArrayList<ResourceReqDetail>();
		for (int i = 0; i < requiredDates.length; i++) {
		
			resoReqDetail = new ResourceReqDetail();
			resoReqDetail.setNoOfPositions(noOfPositions[i]);
			resoReqDetail.setJobDescription(jobDescriptions[i].toString());
			resoReqDetail.setRequiredDate(dateService.dateFormat(dateService.dateParse(requiredDates[i].toString(),"au"),"au"));
			resoReqDetail.setPriority(priority[i].toString());
			resoReqDetail.setRdstatusId(statusids[i].toString());
	
			int resDelId = resReqIdUpdate[i];
			String check = "1", check1 = "0";
			String egCheck = request.getParameter(resDelId + "Check");
			
			if (check.equals(egCheck)) {
				
				resourceRequestService.deleteResourceReqDetail(resDelId);

			}

			if (check1.equals(egCheck) || egCheck == null) {
				
				resourceReqDetail.add(resoReqDetail);

			}

		}
			
	
		resourceReqUpdate.setResourceReqDetail(resourceReqDetail);


		msg=resourceRequestService.updateResourceRequest(resourceReqUpdate);
		
		if(msg=="S"){
			request.setAttribute("resourceReqUpdate", "Resource Request has been updated");
		}
		else{
			request.setAttribute("resourceReqUpdateError", "Resource Request has not been updated");
		}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "ResourceRequestHome";
	}

	@RequestMapping(value = "/resourceReqDelete", method = RequestMethod.GET)
	public ModelAndView employeeDelete(
			@ModelAttribute("resourceRequestCommand") ResourceRequest resourceRequestDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("resourceReqId"));
		try {

			String msg = resourceRequestService.deleteResourceRequest(id);
			if (msg == "S") {

				request.setAttribute("resReqDelete","Resource Request has been deleted");
				
				
			} else {

				request.setAttribute("resReqDeleteError", "Resource Request has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("ResourceRequestHome", "resourceRequestCommand",
				new ResourceRequest());
	}
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "resourceRequestId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
