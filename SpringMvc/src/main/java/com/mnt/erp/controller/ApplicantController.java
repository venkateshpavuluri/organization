/**
 * 
 */
package com.mnt.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lowagie.text.pdf.codec.Base64.OutputStream;
import com.mnt.erp.bean.ApplicantBean;
import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.OrganizationType;
import com.mnt.erp.bean.VacancyDetailLine;
import com.mnt.erp.service.ApplicantService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.vacancyService;

/**
 * @author devi
 *
 */
@Controller
public class ApplicantController {
	@Autowired
	vacancyService vService;
	@Autowired
	ApplicantService appService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	ServletContext servletContext;
	@Autowired
	PopulateService populateService;
	
	
	List<ApplicantBean> organization1 = null;
	String name = null;
	Organization org = null;
	Object[] objects2 = null;
	
	List<Object[]> objectsArray = null;
	int id = 0;
	Iterator<Object[]> iterator = null;
	List<ApplicantBean> organizationList = null;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/applicantHome", method = RequestMethod.GET)
	public String applicantHome(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			response.setCharacterEncoding("UTF-8");
			HttpSession session=request.getSession(false);
			List<String> list=menuService.getPrivilige("applicantHome.mnt", session.getAttribute("userId").toString());
					session.setAttribute("privilegeList",list);
			model.addAttribute("applicant", new ApplicantBean());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "applicantHome";
	}

	@ModelAttribute("vacancyIds")
	public Map<Integer, String> populateVacancyIds() {
		Map<Integer, String> map = null;
		List<Object[]> list = null;
		
		try {
		map=populateService.populateSelectBox("select o.vacancyDetailLineId,o.vacancyDetailNo from VacancyDetailLine o");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	

	@RequestMapping(value = "/applicantAdd", method = RequestMethod.POST)
	@Scope("request")
	public String saveApplicant(@ModelAttribute("applicant") ApplicantBean applicant,
			Model model, BindingResult result, HttpServletRequest request,
			HttpServletResponse response,@RequestParam("imageFile") MultipartFile file1) {
		String msg = null;
		
		Long id = 0l;
		List<String> list = null;
	
		String res=null;
		HttpSession session=null;
		String fname=applicant.getFname();
		String resumesFile=null;
		String originalPath=null;
		try {
			response.setCharacterEncoding("UTF-8");
			id=appService.duplicateCheck(fname);
			
           session=request.getSession(false);
			if (id == 0) {
				resumesFile=servletContext.getRealPath("/Resumes");
				Date date=new Date();
				   String dt = date.getYear()+date.getMonth()+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds()+""+System.currentTimeMillis();
				originalPath=resumesFile+"\\"+dt+".txt";
				//File file=new File(originalPath);
				InputStream inputStream=file1.getInputStream();
				
				java.io.OutputStream outputStream=new FileOutputStream(new File(originalPath));
				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				outputStream.flush();
				inputStream.close();
				outputStream.close();
				
		
		
			applicant.setDocPath(originalPath);
			
		msg=appService.saveApplicantDetails(applicant,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
	
			
			
				
				if (msg.equals("S")) {
			
					 
					res="redirect:applicantHome.mnt?list=" + "success" + "";
				} else {
					res="redirect:applicantHome.mnt?listwar=" + "fail" + "";
				}
			} else {

				request.setAttribute("duplicate", "Applicant Name  is already exists. Please try some other name");
				applicant.setAid(1);
				return "applicantHome";
			}

		} catch (Exception e) {
			res="redirect:applicantHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
			
			
		}
		return res;
		
	}

	

	@RequestMapping(value = "/applicantSearch", method = RequestMethod.GET)
	public String searchApplicant(@ModelAttribute("applicant") ApplicantBean applicant,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		List<ApplicantBean> applicants = null;

		String dbField = applicant.getXmlLabel();
		String operation = applicant.getOperations();
		String basicSearchId = applicant.getBasicSearchId();
          
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
		try {
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			
			if (basicSearchId == "") {

				applicants = appService.searchApplicants();

			} else {
			
				applicants=appService.basicSearchApplicant(dbField, operation, basicSearchId);
						
			}
			request.setAttribute("applicantSearch", applicants);
		
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "applicantHome";
	}

	@RequestMapping(value = "/applicantEditHome", method = RequestMethod.GET)
	public String editApplicant(@ModelAttribute("applicant") ApplicantBean applicant,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
	
		
		List<ApplicantBean> applicants = null;
		Iterator<ApplicantBean> iterator = null;
		ApplicantBean applicantEdit = null;
		VacancyDetailLine vDetail=null;
		int id = Integer.parseInt(request.getParameter("applicantEdit"));
	
		try {
			response.setCharacterEncoding("UTF-8");
			applicants = appService.searchApplicantWithId(id);
			request.setAttribute("imageId",id);
		
			applicantEdit = new ApplicantBean();
			iterator = applicants.iterator();
			while (iterator.hasNext()) {
				applicant = (ApplicantBean) iterator.next();
				applicantEdit.setApplicant_IdEdit(applicant.getApplicant_Id());
				applicantEdit.setFnameEdit(applicant.getFname());
				applicantEdit.setLnameEdit(applicant.getLname());
				applicantEdit.setMnameEdit(applicant.getMname());
				applicantEdit.setPhoneNoEdit(applicant.getPhoneNo());
				applicantEdit.setEmailEdit(applicant.getEmail());
				applicantEdit.setVacancyDetail_IdEdit(applicant.getVacancyDetail_Id());
				applicantEdit.setRefNoEdit(applicant.getRefNo());
			
				String path=applicant.getDocPath().replace("\\", "/");
				String[] resumepath=path.split("/");
				applicantEdit.setDocPathEdit("Resumes/"+resumepath[resumepath.length-1]);
				applicantEdit.setDbDocPath(applicant.getDocPath());
				applicantEdit.setShortListedEdit(applicant.getShortListed());
				applicantEdit.setSelectedEdit(applicant.getSelected());
				applicantEdit.setJoinedEdit(applicant.getJoined());
				
			

			}
			model.addAttribute("applicant", applicantEdit);
			request.setAttribute("applicantValues", applicants);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "applicantHome";
	}
	@RequestMapping(value="/applicantUpdate", method = RequestMethod.POST)
	public String updateApplicant(
			@ModelAttribute("applicant") ApplicantBean applicant,
			Model model, HttpServletRequest request,
			HttpServletResponse response,@RequestParam("imageFileEdit")MultipartFile file1) {
		String msg = null;
		Long duplicateId = 0l;
		try {
			response.setCharacterEncoding("UTF-8");
			
			
			
			
			duplicateId = appService.updateDuplicateCheck(applicant.getFnameEdit(),applicant.getApplicant_IdEdit());
          	if (duplicateId == 0) {
						   
          		String dbResumePath=null;
          
    			if(file1.getBytes().length>0)
    			{
    			
    				InputStream inputStream=file1.getInputStream();
    		String	resumesFile=servletContext.getRealPath("/Resumes");
			Date date=new Date();
			   String dt = date.getYear()+date.getMonth()+date.getDay()+date.getHours()+date.getMinutes()+date.getSeconds()+""+System.currentTimeMillis();
    		String	originalPath=resumesFile+"\\"+dt+".txt";
    
    			java.io.OutputStream outputStream=new FileOutputStream(new File(originalPath));
    			int read = 0;
    			byte[] bytes = new byte[1024];

    			while ((read = inputStream.read(bytes)) != -1) {
    				outputStream.write(bytes, 0, read);
    			}
    			outputStream.flush();
    			inputStream.close();
    			outputStream.close();
    			dbResumePath=originalPath;
    			System.out.println("with in if file iss==="+dbResumePath);
    			}
    			
    			else
    			{
    			
    				dbResumePath=applicant.getDbDocPath();
    				System.out.println("with in else file iss==="+dbResumePath);
    			}
    	
    		applicant.setDocPath(dbResumePath);
          		
				msg = appService.updateApplicant(applicant);
				if (msg.equals("S")) {
					request.setAttribute("applicantUpdate",
							"Applicant Data is updated Successfully");
				} else {
					request.setAttribute("applicantUpdateError",
							"Applicant Data is not updated properly");
				}
			} else {

				request.setAttribute("applicantValues", "hello");
				request.setAttribute("applicantUpdateDuplicate",
						"Applicant Name is already exists. Please try some other name");
				return "applicantHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("applicant", new ApplicantBean());
		return "applicantHome";
	}

	@RequestMapping(value = "/applicantDelete", method = RequestMethod.GET)
	public String deleteApplicant(
			@ModelAttribute("applicant") ApplicantBean applicant,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		String msg = null;
		int id = 0;
		HttpSession session=null;
		try {
		
			response.setCharacterEncoding("UTF-8");
			id = Integer.parseInt(request
					.getParameter("applicantCodeDelete"));
			msg = appService.deleteApplicant(id);
			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Applicant","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
					request.setAttribute("applicantDelete",
						"Applicant Data is deleted Successfully");
			} else {
				request.setAttribute("applicantDeleteError",
						"Applicant Data  is not deleted properly ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("applicant", new ApplicantBean());
		return "applicantHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "fname";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
}
