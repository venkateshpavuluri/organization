package com.mnt.erp.controller;



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
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.DocumentCategory;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class DocumentCategoryController {
	List<Object[]>list=null;
	Iterator<Object[]> iterator = null;
	@Autowired ERPDao erpDao;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	AuditLogService auditLogService;


	@Autowired
	MenuService menuService;
	
	
	@RequestMapping(value = "/documentcategoryHome", method = RequestMethod.GET)
	public String getDC(
			@ModelAttribute DocumentCategory dbean,
			SessionStatus status, Model model,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("documentcategoryHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("DocumentCategory", new DocumentCategory());

		return "documentcategoryHome";
	}

	@RequestMapping(value = "/savedc", method = RequestMethod.POST)
	public String saveDC(
			@ModelAttribute("DocumentCategory")  DocumentCategory dbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		int msg = 0;
		String DCsuccessdup = null;
		String res=null;
		String name = dbean.getDocumentcategory();
		HttpSession session=null;
		int dcid=dbean.getDocumentcategoryid();
		Long id = 0L;
		try {
			id = erpDao.duplicateCheck("select count(*) from DocumentCategory ab where ab.documentcategory='"
					+ name + "'");
			
			if (id == 0) {

				msg=erpDao.saveDetails(dbean);
			
				if (msg!=0) {
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Document Category","ROW" ,String.valueOf(dcid),"1",modifiedDate,session.getAttribute("userName").toString());
					res = "redirect:documentcategoryHome.mnt?list=" + "success" + "";
				}
				else {
					res = "redirect:documentcategoryHome.mnt?listwar=" + "fail" + "";
				}
			}

			else {
				DCsuccessdup = "Warning ! Document Category is already exists. Please try some other name ";
				dbean.setDchide(1);
				request.setAttribute("DCsuccessdup",DCsuccessdup);
				return "documentcategoryHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	return res;

	}
	@RequestMapping(value = "/searchDC", method = RequestMethod.GET)
	public String searchDC(
			@ModelAttribute("DocumentCategory") DocumentCategory dbean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<DocumentCategory> dbeans = new ArrayList<DocumentCategory>();
			String dbField = dbean.getXmlLabel();
			String operation = dbean.getOperations();
			String basicSearchId = dbean.getBasicSearchId();

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
			 list=	erpDao.searchDetails("select ag.documentcategoryid,ag.documentcategory from DocumentCategory ag order by ag.documentcategory");
			
			 iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					DocumentCategory dcbean = new DocumentCategory();
					dcbean.setDocumentcategoryid((Integer)obj[0]);
					dcbean.setDocumentcategory((String)obj[1]);
					dbeans.add(dcbean);

				}

			} else {
				list =erpDao.searchDetails("select ag.documentcategoryid,ag.documentcategory from DocumentCategory ag where ag."
					+ dbField + "" + operation + "'"+basicSearchId+"' order by ag.documentcategory");
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					DocumentCategory dcbean = new DocumentCategory();
					dcbean.setDocumentcategoryid((Integer)obj[0]);
					dcbean.setDocumentcategory((String)obj[1]);
					dbeans.add(dcbean);
				}
			}
			request.setAttribute("dbeans", dbeans);
			 
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "documentcategoryHome";
	}

	@RequestMapping(value = "/dcEdit", method = RequestMethod.GET)
	public String editDC(
			@ModelAttribute("DocumentCategory") DocumentCategory dbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("dcedit"));

		try {
			List<DocumentCategory> dbeans = new ArrayList<DocumentCategory>();
			list = erpDao.searchDetails("select ag.documentcategoryid,ag.documentcategory from DocumentCategory ag where ag.documentcategoryid="
					+ id + "");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				dbean.setDocumentcategoryidedit((Integer)obj[0]);
				dbean.setDocumentcategoryedit((String)obj[1]);
				dbeans.add(dbean);
			}
			request.setAttribute("editvalues", dbeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "documentcategoryHome";

	}

		@RequestMapping(value = "/DCUpdate", method = RequestMethod.POST)
	public String updateDC(
			@ModelAttribute("DocumentCategory") DocumentCategory dbean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = dbean.getDocumentcategoryedit();
		int imid = dbean.getDocumentcategoryidedit();
		Long iid = 0l;
		String dcdupedit = null;
		try {
			iid =erpDao.duplicateCheck("select count(*) from DocumentCategory ab where ab.documentcategory='"
					+ name + "'and ab.documentcategoryid!='" + imid + "'");
			if (iid == 0) {
				dbean.setDocumentcategoryid(dbean.getDocumentcategoryidedit());
				dbean.setDocumentcategory(dbean.getDocumentcategoryedit());

				int message = erpDao.updateDetails(dbean);
				if (message==1) {
					request.setAttribute("DCUpdate","Document Category has been updated");
				}
				else{
					request.setAttribute("DCUpdateError","Document Category has not been updated");
				}
			} else {
				dcdupedit = "Warning ! Document Category is already exists. Please try some other name ";
				dbean.setDchideedit(1);
				request.setAttribute("dcdupedit",dcdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "documentcategoryHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "documentcategoryHome";
	}

	@RequestMapping(value = "/DCDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView DCDelete(
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		HttpSession session=null;
		try {
			Id = Integer.parseInt(request.getParameter("dcdelete"));
			DocumentCategory dc=new DocumentCategory();
	        dc.setDocumentcategoryid(Id);
	        
			int msg = erpDao.deleteDetails(dc);
			if (msg!=0){
				request.setAttribute("DCDelete","Document Category has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Document Category","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
			 
				
			}
			else{
				request.setAttribute("DCDeleteError","Document Category has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("documentcategoryHome", "DocumentCategory",
				new DocumentCategory());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "documentcategoryid";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
