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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.DocumentType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DocumentTypeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

@Controller
public class DocumentTypeController {

	@Autowired
	DocumentTypeService dtservice;

	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/DocumentType", method = RequestMethod.GET)
	public ModelAndView getDocumentType(HttpServletRequest request,HttpServletResponse response) {
		
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("DocumentType.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("DocumentTypeHome", "DocumentTypeCommand",
				new DocumentType());
	}

	@RequestMapping(value = "/DocumentTypeadd", method = RequestMethod.POST)
	public String saveDocumentType(
			@ModelAttribute("DocumentTypeCommand") DocumentType documentType,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		HttpSession session=null;
		String dtype = documentType.getDocumentType();
		int list1 = 0;
		list1 = dtservice.documentTypeDuplicate(dtype);
		String msg = null;
		String res=null;
		if (list1 == 0) {
			try {
				session=request.getSession(false);
				msg = dtservice.saveDocumentType(documentType,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (msg.equals("S")) {
					res = "redirect:DocumentType.mnt?list=" + "success" + "";
					
				}
				else
				{
					res = "redirect:DocumentType.mnt?listwar=" + "fail" + "";
				}
				

			}

			catch (Exception e) {
				
				res = "redirect:DocumentType.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
			}

			
		} 
		else {
			
			documentType.setAid(1);
			
			request.setAttribute("addDocumentTypeDuplicate",
					"Document Type Already Exists  Please try some other name");

			return "DocumentTypeHome";
		}
		
		return res;

	}

	@RequestMapping(value = "/DocumentTypeSearch", method = RequestMethod.GET)
	public ModelAndView searchDocumentType(
			@ModelAttribute("DocumentTypeCommand") DocumentType documentTypesearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object[]> list = null;
		List<DocumentType> DocumentTypes = null;
		try {
			
			String dbField = documentTypesearch.getXmlLabel();
			String operation = documentTypesearch.getOperations();
			String basicSearchId = documentTypesearch.getBasicSearchId();

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
				list = dtservice.searchDocumentType();

			} else {
				 list = dtservice.basicSearchAssertType(dbField,
						operation, basicSearchId);

			}
			DocumentTypes = new ArrayList<DocumentType>();
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				DocumentType dt = new DocumentType();
				dt.setDocumentType_Id((Integer) objects[0]);
				dt.setDocumentType((String) objects[1]);
				DocumentTypes.add(dt);
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
       request.setAttribute("documentTypeSearch", "documentTypeSearch");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("DocumentTypeHome");
		modelAndView.addObject("documentType", DocumentTypes);
		return modelAndView;
	}

	@RequestMapping(value = "/DocumentTypeEditHome", method = RequestMethod.GET)
	@org.springframework.context.annotation.Scope("request")
	public String editDocumentType(
			@ModelAttribute("DocumentTypeCommand") DocumentType documentTypeEdit,
			BindingResult result, HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("documentTypeId"));
		List<Object[]> list = null;
		Object[] objects = null;
		try {
			list = dtservice.editDocumentTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				documentTypeEdit.setDocumentType_IdEdit((Integer) objects[0]);
			
				documentTypeEdit.setDocumentTypeEdit((String) objects[1]);
			

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {

			list = null;
			objects = null;
		}

		model.addAttribute("DocumentTypeCommand", documentTypeEdit);
		request.setAttribute("dtvalues", "dtvalues");

		return "DocumentTypeHome";
	}

	@RequestMapping(value = "/DocumentTypeEdit", method = RequestMethod.POST)
	public String updateDocumentType(
			@ModelAttribute("DocumentTypeCommand") DocumentType documentType,
			HttpServletRequest request, Model model) {
		
		int id = documentType.getDocumentType_IdEdit();
		String dtype = documentType.getDocumentTypeEdit();
		int list2 = 0;
		list2 = dtservice.documentTypeEditDuplicate(dtype, id);

		if (list2 == 0) {
			try {
				documentType.setDocumentType_Id(documentType
						.getDocumentType_IdEdit());
				documentType
						.setDocumentType(documentType.getDocumentTypeEdit());
				String msg = dtservice.updateDocumentType(documentType);
				
				if(msg.equals("S")){
					
				request.setAttribute("documentTypeUpdate","Document Type has been updated successfully");
				
				}
				else
				{
					request.setAttribute("documentTypeUpdateError","Document Type has not been updated");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("DocumentTypeCommand", new DocumentType());
			return "DocumentTypeHome";

		}

		else {

			request.setAttribute("dtvalues", "dtvalues");
			request.setAttribute("editDocmentTypeDuplicate",
					"Document Type Already Exists  Please try some other name");

			return "DocumentTypeHome";
		}
	}

	@RequestMapping(value = "/DocumentTypeDelete", method = RequestMethod.GET)
	public ModelAndView deleteDocumentType(HttpServletRequest request,
			HttpServletResponse response) {
		
		int id = 0;
		String msg = null;
		HttpSession session=null;
		
		try {
			id = Integer.parseInt(request.getParameter("documentTypeId"));
			msg = dtservice.deleteDocumentType(id);
			
			if (msg.equals("S")){
				request.setAttribute("documentTypeDelete","Document Type has been deleted successfully");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Document Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
			}
			else
			{
				request.setAttribute("documentTypeDeleteError","Document Type has not been deleted");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("DocumentTypeHome", "DocumentTypeCommand",
				new DocumentType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "documentType_Id";
		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
