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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.MaintenanceOrderType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MaintenanceOrderTypeServiceImpl;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class MaintenanceOrderTypeController {

	@Autowired
	MaintenanceOrderTypeServiceImpl mainTypeService;
	
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	
	@RequestMapping(value = "/maintenanceOrderTypeHome", method = RequestMethod.GET)
	public ModelAndView maintenanceOrderTypeHome(
			@ModelAttribute("maintenanceOrderTypeCommand") MaintenanceOrderType maintenanceOrderType,
			SessionStatus status,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("maintenanceOrderTypeHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("maintenanceOrderHome", "maintenanceOrderTypeCommand", maintenanceOrderType);
	}
	
	
	@RequestMapping(value = "/maintOrderTypeCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkname(HttpServletRequest request, HttpServletResponse response,
			MaintenanceOrderType maintenanceOrderType) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		Long motypecheck =null;
		try {
			
			String maintOrderTypecheck = request.getParameter("maintOrderTypecheck");
		
			motypecheck = mainTypeService.checkMaintenanceOrderType(maintOrderTypecheck);
			if (motypecheck != 0) {
				maintenanceOrderType.setAid(2);
				request.setAttribute("addGLFiscalYearDuplicate","Warning ! Maintenance Order Type already exists!");
				maintenanceOrderType.setMaintOrderType("");
				msg = "Warning ! Maintenance Order Type already exists!";

			}
			if (motypecheck == 0) {
				maintenanceOrderType.setAid(2);
				request.setAttribute("addGLFiscalYearDuplicate","Warning ! Maintenance Order Type already exists!");
				maintenanceOrderType.setMaintOrderType("");
				msg = "";
			}
		}
        catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	
	
	
	@RequestMapping(value = "/maintenanceOrderTypeAdd", method = RequestMethod.POST)
	public String saveMaintenanceOrderType(
			@ModelAttribute("maintenanceOrderTypeCommand") MaintenanceOrderType maintenanceOrderTypeAdd,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String res = null;
		HttpSession session=null;
		int id=maintenanceOrderTypeAdd.getMaintOrderType_Id();

		
			try {
				session=request.getSession(false);
				
				String msg=mainTypeService.saveMaintenanceOrderTypeDetails(maintenanceOrderTypeAdd);
				if(msg=="S"){
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Maintenance Order Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());		
					res = "redirect:maintenanceOrderTypeHome.mnt?list=" + "success" + "";
				
				}
				else{
					res = "redirect:maintenanceOrderTypeHome.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				res = "redirect:maintenanceOrderTypeHome.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
				
			}
		

		return res;

	}



	@RequestMapping(value = "/MaintenanceOrderTypeSearch", method = RequestMethod.GET)
	public ModelAndView searchMaintenanceOrderType(
			@ModelAttribute("maintenanceOrderTypeCommand") MaintenanceOrderType maintenanceOrderTypeSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<MaintenanceOrderType> maintenanceOrderTypeBean = new ArrayList<MaintenanceOrderType>();

		try {
			
			String dbField = maintenanceOrderTypeSearch.getXmlLabel();
			String operation = maintenanceOrderTypeSearch.getOperations();
			String basicSearchId = maintenanceOrderTypeSearch.getBasicSearchId();

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
				list = mainTypeService.searchMaintenanceOrderType();

			} else {
				list = mainTypeService.basicSearchMaintenanceOrderType(dbField, operation, basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				MaintenanceOrderType maintenanceTypeSearch = new MaintenanceOrderType();
				Object[] obj = (Object[]) iterator.next();
				maintenanceTypeSearch.setMaintOrderType_Id((Integer) obj[0]);
				maintenanceTypeSearch.setMaintOrderType((String) obj[1]);
					
				maintenanceOrderTypeBean.add(maintenanceTypeSearch);
			}

			request.setAttribute("maintenanceOrderTypeBean", maintenanceOrderTypeBean);
			request.setAttribute("mtSearchvalues", "mtSearchvalues");

		} catch (Exception e) {
			e.printStackTrace();
		}
        
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("maintenanceOrderHome");
	    modelAndView.addObject("maintenanceOrderType",maintenanceOrderTypeBean);
		return modelAndView;
		

	}

	@RequestMapping(value = "/maintenanceOrderTypeEdit", method = RequestMethod.GET)
	public String  editMaintenanceOrderType(
			@ModelAttribute("maintenanceOrderTypeCommand") MaintenanceOrderType maintenanceOrderTypeEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("maintenanceOrderTypeId"));
		
		List<Object[]> list = null;
		List<MaintenanceOrderType> maintenanceOrderTypeEditBean = new ArrayList<MaintenanceOrderType>();
		try {
			list = mainTypeService.searchMaintenanceOrderTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				maintenanceOrderTypeEdit.setMaintOrderType_IdEdit((Integer) obj[0]);
				maintenanceOrderTypeEdit.setMaintOrderTypeEdit((String) obj[1]);
				maintenanceOrderTypeEditBean.add(maintenanceOrderTypeEdit);
				
			}
			request.setAttribute("maintenanceOrderTypeEdit", maintenanceOrderTypeEditBean);
			request.setAttribute("mtvalues", "mtvalues");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "maintenanceOrderHome";

	}

	@RequestMapping(value = "/maintOrderTypeEditCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checknameEdit(HttpServletRequest request,
			HttpServletResponse response, MaintenanceOrderType maintenanceOrderTypecheck) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		Long fiscalEdit = null;

		try {

			String maintenanceOrderType = request.getParameter("maintOrderTypeEdit");
			int maintenanceOrderTypeId = Integer.parseInt(request.getParameter("maintOrderType_IdEdit"));
			fiscalEdit = mainTypeService.updateCheckMaintenanceOrderType(maintenanceOrderType, maintenanceOrderTypeId);
			
			if (fiscalEdit != 0) {
				maintenanceOrderTypecheck.setMaintOrderType_Id(1);
				request.setAttribute("addGLFiscalYearEditDuplicate","Warning ! Maintenance Order Type already exists!");
				maintenanceOrderTypecheck.setMaintOrderTypeEdit("");
				msg = "Warning ! Maintenance Order Type already exists!";
               }
			
			if (fiscalEdit == 0) {
				maintenanceOrderTypecheck.setMaintOrderType_Id(1);
				request.setAttribute("addGLFiscalYearEditDuplicate","Warning ! Maintenance Order Type already exists!");
				maintenanceOrderTypecheck.setMaintOrderTypeEdit("");
				msg = "";
			   }
		    } 
		    catch (Exception e) {
		    	e.printStackTrace();
		     }
		return msg;
	}
	
	@RequestMapping(value = "/MaintenanceOrderTypeUpdate", method = RequestMethod.POST)
	public String updateMaintenanceOrderType(
			@ModelAttribute("maintenanceOrderTypeCommand") MaintenanceOrderType maintenanceOrderTypeUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		maintenanceOrderTypeUpdate.setMaintOrderType_Id(maintenanceOrderTypeUpdate.getMaintOrderType_IdEdit());
		maintenanceOrderTypeUpdate.setMaintOrderType(maintenanceOrderTypeUpdate.getMaintOrderTypeEdit());
		
		
	
			try {

				String msg = mainTypeService.updateMaintenanceOrderType(maintenanceOrderTypeUpdate);

				if (msg.equals("S")) {
					request.setAttribute("mainOrderTypeUpdated", "Maintenance Order Type has been updated");
				} else {
					request.setAttribute("mainOrderTypeUpdateError", "Maintenance Order Type has not been updated");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

	 
		return "maintenanceOrderHome";
	}

	@RequestMapping(value = "/maintenanceOrderTypeDelete", method = RequestMethod.GET)
	public ModelAndView deleteMaintenanceOrderType(
			@ModelAttribute("maintenanceOrderTypeCommand") MaintenanceOrderType maintenanceOrderTypeDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
	   HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("maintenanceOrderTypeId"));
		try {

			String msg = mainTypeService.deleteMaintenanceOrderType(id);
			if (msg == "S") {

				request.setAttribute("mainOrderTypeDeleted", "Maintenance Order Type has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Code Group","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
			} else {
				request.setAttribute("mainOrderTypeDeletedError", "Maintenance Order Type has not been deleted");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("maintenanceOrderHome", "maintenanceOrderTypeCommand",
				new MaintenanceOrderType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "maintenanceOrderTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
