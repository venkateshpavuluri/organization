/**
 * 
 */
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

import org.apache.log4j.Logger;
import org.codehaus.groovy.runtime.callsite.PogoMetaMethodSite.PogoCachedMethodSiteNoUnwrap;
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
import com.mnt.erp.bean.AuditLog;
import com.mnt.erp.bean.BreakDownMaintenance;
import com.mnt.erp.bean.BreakDownMaintenanceLog;
import com.mnt.erp.bean.BreakDownMaintenanceSpare;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.InterViewResult;
import com.mnt.erp.bean.InterViewSchedule;
import com.mnt.erp.bean.InterviewRound;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.VacancyDetailLine;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.BreakdownMaintenaceLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author venkateshp
 *
 */
@Controller
public class BkDownMaitenanceLogController {
	private static Logger logger=Logger.getLogger(BkDownMaitenanceLogController.class);
	@Autowired PopulateService populateService;
	@Autowired BreakdownMaintenaceLogService maintenaceLogService;
	@Autowired AuditLogService auditLogService;
	@Autowired XmlLabelsService xmlService;
	@Autowired ERPDao erpDao;
	@Autowired MenuService menuService;
	@Autowired DateConversionService dateService;
	
	@RequestMapping(value = "/brkDwnMaitenanceLogHome", method = RequestMethod.GET)
	public String brkDownMaintnceLogHome(
			@ModelAttribute("brkDownMaintnceLog") BreakDownMaintenanceLog maintenanceLog,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("brkDwnMaitenanceLogHome.mnt", session.getAttribute("userId").toString());
		session.setAttribute("privilegeList",list);
		return "brkDownMaitenanceLog";
}
	
	@RequestMapping(value = "/saveBrkDownMaintenance", method = RequestMethod.POST)
	public String addBrkDownMtLog(@ModelAttribute("brkDownMaintnceLog")BreakDownMaintenanceLog maintenanceLog,
HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicatId=null;
		HttpSession session=null;
		List<BreakDownMaintenanceSpare> listOfLogSpare=null;
try
{
	listOfLogSpare=new ArrayList<BreakDownMaintenanceSpare>();
	String mt=maintenanceLog.getMaterialId();
	String uom=maintenanceLog.getUomId();
	String qt=maintenanceLog.getQuantity();
	String[] materialIds=null;
	String[] uomIds=null;
	String[] quantity=null;
	maintenanceLog.setStartDt(dateService.dateFormat(dateService.dateParse(maintenanceLog.getStartDt(), "au"), "au"));
	maintenanceLog.setEndDt(dateService.dateFormat(dateService.dateParse(maintenanceLog.getEndDt(), "au"), "au"));
	if(mt!=null)
		materialIds=mt.split(",");
	if(uom!=null)
		uomIds=uom.split(",");
	if(qt!=null)
		quantity=qt.split(",");
	for(int i=0;i<materialIds.length;i++)
	{
		BreakDownMaintenanceSpare maintenanceSpare=new BreakDownMaintenanceSpare();
		maintenanceSpare.setMaterialId(materialIds[i]);
		maintenanceSpare.setUomId(uomIds[i]);
		maintenanceSpare.setQuantity(quantity[i]);
		listOfLogSpare.add(maintenanceSpare);
	}
	maintenanceLog.setBrkDownMtSpare(listOfLogSpare);
	String idg=maintenaceLogService.savebrkDownMaintenanceLog(maintenanceLog);
	
	if(idg.equals("S"))
	{
		session=request.getSession(false);
		 Date date1 = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","BreakDown Maintenance Log","ROW" ,String.valueOf(maintenanceLog.getBrkdownMaintenaceLogId()),"1",modifiedDate,session.getAttribute("userName").toString());
		return "redirect:/brkDwnMaitenanceLogHome.mnt?list=success";
	}
	else
	{
		return "redirect:/brkDwnMaitenanceLogHome.mnt?listwar=fail";
	}
}
catch(Exception e)
{
	e.printStackTrace();
	return "redirect:/brkDwnMaitenanceLogHome.mnt?listwar=fail";
}
}
	
	
	@RequestMapping(value = "/brkDownMtLogSearch", method = RequestMethod.GET)
	public String searchIVShedule(
			@ModelAttribute("brkDownMaintnceLog")BreakDownMaintenanceLog maintenanceLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		List<Object[]> listOfObjects=null;
		List<BreakDownMaintenanceLog> maintenanceLogs=null;
		Iterator<Object[]> iterator=null;
		try
		{
			maintenanceLogs=new ArrayList<BreakDownMaintenanceLog>();
			String dbField = maintenanceLog.getXmlLabel();
			String operation = maintenanceLog.getOperations();
			String basicSearchId = maintenanceLog.getBasicSearchId();
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
				//sql="select b.brkdownMaintenaceLogId,b.logNo,b.startDt,b.endDt,b.repairedBy,b.brkdwnMiant from com.mnt.erp.bean.BreakDownMaintenanceLog b";
				listOfObjects=maintenaceLogService.searchBrkDownMtLogDt();
			
				}
			else
			{
				listOfObjects=maintenaceLogService.brkDwnMtLogBasicSearch(dbField, operation, basicSearchId);
				}
			iterator=listOfObjects.iterator();
			while(iterator.hasNext())
			{
				Object[] objects=(Object[])iterator.next();
				BreakDownMaintenanceLog brkdwnMaintenanceLog=new BreakDownMaintenanceLog();
				brkdwnMaintenanceLog.setBrkdownMaintenaceLogId((Integer)objects[0]);
				brkdwnMaintenanceLog.setLogNo((String)objects[1]);
				brkdwnMaintenanceLog.setStartDt(dateService.dateFormat(dateService.dateParse((String)objects[2], "se"), "se"));
				brkdwnMaintenanceLog.setEndDt(dateService.dateFormat(dateService.dateParse((String)objects[3], "se"), "se"));
				brkdwnMaintenanceLog.setRepairedBy((String)objects[4]);
				BreakDownMaintenance downMaintenance=(BreakDownMaintenance)objects[5];
				brkdwnMaintenanceLog.setMaintenanceName(downMaintenance.getBreakDownNo());
				maintenanceLogs.add(brkdwnMaintenanceLog);
			}
				request.setAttribute("brkDown",maintenanceLogs);
			}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "brkDownMaitenanceLog";
	}


	@RequestMapping(value = "/brkDownMtLogEdit", method = RequestMethod.GET)
	public String editBrkDownMtLog(@ModelAttribute("brkDownMaintnceLog")BreakDownMaintenanceLog maintenanceLog,HttpServletRequest request,HttpServletResponse response, Model model) {
		List<BreakDownMaintenanceSpare> downMaintenanceSpares=null;
		List<BreakDownMaintenanceSpare> listMaintenanceSpares=null;
		try
		{
			int maintenanceLogId=Integer.parseInt(request.getParameter("brkDnMtLogId"));
			List<BreakDownMaintenanceLog> maintenanceLogs=maintenaceLogService.editBrkDownMtLogDetails(maintenanceLogId);
			listMaintenanceSpares=new ArrayList<BreakDownMaintenanceSpare>();
			Iterator<BreakDownMaintenanceLog> iterator=maintenanceLogs.iterator();
			while(iterator.hasNext())
			{
				BreakDownMaintenanceLog downMaintenanceLog=(BreakDownMaintenanceLog)iterator.next();
				maintenanceLog.setBrkdownMaintenaceLogId(downMaintenanceLog.getBrkdownMaintenaceLogId());
				maintenanceLog.setBrkdownMaintenaceId(downMaintenanceLog.getBrkdownMaintenaceId());
				maintenanceLog.setLogNo(downMaintenanceLog.getLogNo());
				maintenanceLog.setStartDt(dateService.dateFormat(dateService.dateParse(downMaintenanceLog.getStartDt(), "se"), "se"));
				maintenanceLog.setEndDt(dateService.dateFormat(dateService.dateParse(downMaintenanceLog.getEndDt(), "se"), "se"));
				maintenanceLog.setRepairedBy(downMaintenanceLog.getRepairedBy());
		 downMaintenanceSpares=(List<BreakDownMaintenanceSpare>)downMaintenanceLog.getBrkDownMtSpare();
				Iterator<BreakDownMaintenanceSpare> listOfSpares=downMaintenanceSpares.iterator();
				while(listOfSpares.hasNext())
				{
					BreakDownMaintenanceSpare maintenanceSpare=(BreakDownMaintenanceSpare)listOfSpares.next();
					BreakDownMaintenanceLog brkDownMaLog=new BreakDownMaintenanceLog();
					brkDownMaLog.setBrDnMaintenaceSpareIdEdit(String.valueOf(maintenanceSpare.getBrDnMaintenaceSpareId()));
					brkDownMaLog.setMaterialIdEdit(maintenanceSpare.getMaterialId());
					brkDownMaLog.setUomIdEdit(maintenanceSpare.getUomId());
					brkDownMaLog.setQuantityEdit(maintenanceSpare.getQuantity());
					Material material=(Material)maintenanceSpare.getMaterialDetails();
					Uom uom=(Uom)maintenanceSpare.getUomDetails();
					brkDownMaLog.setMaterialName(material.getMaterialName());
					brkDownMaLog.setUomName(uom.getUom());
					listMaintenanceSpares.add(brkDownMaLog);
				}
				
			}
			request.setAttribute("editValues","edit");
			request.setAttribute("brkdownSpareDetails",listMaintenanceSpares);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return "brkDownMaitenanceLog";
	}
	
	
	
	
	
	@RequestMapping(value = "/updateBrkDownMtLog", method = RequestMethod.POST)
	public String brkDownMtLogUpdate(
			@ModelAttribute("brkDownMaintnceLog")BreakDownMaintenanceLog downMaintenanceLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
	
		List<InterViewSchedule> interViewSchedules=null;
		List<BreakDownMaintenanceSpare> brkDwnMtSparelist=null;
		List<BreakDownMaintenanceSpare> childDelete=null;
		try
		{
			//sql="select count(*) from ChartofAccount cb where  cb.coa='"
					//+ chartofAccount + "' and cb.coaId!="+Id;
					
		String brkDwnMtSpare=downMaintenanceLog.getBrDnMaintenaceSpareIdEdit();
			String materials=downMaintenanceLog.getMaterialIdEdit();
			String uom= downMaintenanceLog.getUomIdEdit();
			String qua=downMaintenanceLog.getQuantityEdit();
			downMaintenanceLog.setStartDt(dateService.dateFormat(dateService.dateParse(downMaintenanceLog.getStartDt(), "ae"), "ae"));
			downMaintenanceLog.setEndDt(dateService.dateFormat(dateService.dateParse(downMaintenanceLog.getEndDt(), "ae"), "ae"));
			if(materials!=null);
				String[] materialIds=materials.split(",");
				if(qua!=null);
				String[] quantity=qua.split(",");
				if(uom!=null);
				String[] uomIds=uom.split(",");
				if(brkDwnMtSpare!=null);
					String[] brkDwnMtSpareId=brkDwnMtSpare.split(",");
					brkDwnMtSparelist=new ArrayList<BreakDownMaintenanceSpare>();
			childDelete=new ArrayList<BreakDownMaintenanceSpare>();
			for(int i=0;i<uomIds.length;i++)
			{
				int id=Integer.parseInt(brkDwnMtSpareId[i]);
				if(id==0)
				{
			BreakDownMaintenanceSpare maintenanceSpare=new BreakDownMaintenanceSpare();
			maintenanceSpare.setBrDnMaintenaceSpareId(Integer.valueOf(brkDwnMtSpareId[i]));
			maintenanceSpare.setMaterialId(materialIds[i]);
			maintenanceSpare.setUomId(uomIds[i]);
			maintenanceSpare.setQuantity(quantity[i]);
			brkDwnMtSparelist.add(maintenanceSpare);
				}
				else
				{
					BreakDownMaintenanceSpare maintenanceSpare=new BreakDownMaintenanceSpare();
					maintenanceSpare.setBrDnMaintenaceSpareId(Integer.valueOf(brkDwnMtSpareId[i]));
					maintenanceSpare.setMaterialId(materialIds[i]);
					maintenanceSpare.setUomId(uomIds[i]);
					maintenanceSpare.setQuantity(quantity[i]);
				int	ss = Integer.parseInt(brkDwnMtSpareId[i]);
				String	checked = request.getParameter("Checkdelete" + ss);
				if(checked.equals("0"))
				{
					brkDwnMtSparelist.add(maintenanceSpare);
				}
				else
				{
					BreakDownMaintenanceSpare mtSpareDelete=new BreakDownMaintenanceSpare();
					mtSpareDelete.setBrDnMaintenaceSpareId(Integer.valueOf(brkDwnMtSpareId[i]));
					childDelete.add(mtSpareDelete);
				}
				}
				}
			downMaintenanceLog.setBrkDownMtSpare(brkDwnMtSparelist);
		String msg=	maintenaceLogService.deleteChilds(childDelete);
		String msgs=maintenaceLogService.updateBrkDwnMtLog(downMaintenanceLog);
		if(msgs.equals("S"))
		{
			request.setAttribute("brkDownMtLogUpdate","Success");
			model.addAttribute("brkDownMaintnceLog",new BreakDownMaintenanceLog());
		}
		else
		{
			request.setAttribute("IbrkDownMtLogUpdateFail","Fail");
		}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.setAttribute("IbrkDownMtLogUpdateFail","Fail");
		}
	return "brkDownMaitenanceLog";	
		}
	
	
	
	@RequestMapping(value = "/brkDwnLogDelete", method = RequestMethod.GET)
	public String brkDownMtLogDelete(
			@ModelAttribute("brkDownMaintnceLog")BreakDownMaintenanceLog downMaintenanceLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=null; 
		try
		{
			int id=Integer.parseInt(request.getParameter("brkDnMtLogId"));
			String msg=maintenaceLogService.deleteBrkDwnMtLog(id);
			if(msg.equals("S"))
			{
				session=request.getSession(false);
				 Date date1 = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","BreakDown Maintenance Log","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("brkDownMtLogDelete","Success");
			}
			else
			{
				request.setAttribute("brkDownMtLogDeleteFail","Fail");
			}
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			request.setAttribute("brkDownMtLogDeleteFail","Fail");
		}
		return "brkDownMaitenanceLog";
	}


	

	@RequestMapping(value = "/brkDownAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody String addDuplicateCheck(@ModelAttribute("brkDownMaintnceLog")BreakDownMaintenanceLog downMaintenanceLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=null;
		String msg=null;
	try
	{
		int logNo=Integer.parseInt(request.getParameter("logNo"));
	Long	duplicatId=erpDao.duplicateCheck("select count(*) from com.mnt.erp.bean.BreakDownMaintenanceLog b where b.logNo='"+logNo+"'");
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
		e.printStackTrace();
	}
	return msg;
	}
	
	@RequestMapping(value = "/brkDownUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody String addDuplicateCheckForEdit(@ModelAttribute("brkDownMaintnceLog")BreakDownMaintenanceLog downMaintenanceLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=null;
		String msg=null;
	try
	{
		int logNo=Integer.parseInt(request.getParameter("logNo"));
		int brkDownMtLog=Integer.parseInt(request.getParameter("brkDownMtLog"));
		Long duplicate=erpDao.duplicateCheck("select count(*) from com.mnt.erp.bean.BreakDownMaintenanceLog b where b.logNo='"+logNo+"' and  b.brkdownMaintenaceLogId!="+brkDownMtLog);
	System.out.println("duplicate =="+duplicate);
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
	
	
	
	
	
	
	@ModelAttribute("materialDetails")
	public Map<Integer, String> populateMaterialDetails() {
		Map<Integer, String> map = null;
		try {
			map = populateService.populateSelectBox("select m.material_Id,m.materialName from com.mnt.erp.bean.Material m");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@ModelAttribute("uomDetails")
	public Map<Integer, String> populateUomDetails() {
		Map<Integer, String> map = null;
		try {
			map = populateService.populateSelectBox("select u.uom_Id,u.uom from com.mnt.erp.bean.Uom u");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	@ModelAttribute("brkDownMaintenanceDetails")
	public Map<Integer, String> populateBrkDownMaintnceDetails() {
		Map<Integer, String> map = null;
		try {
			map = populateService.populateSelectBox("select b.breakdownMaintenace_Id,b.problem from com.mnt.erp.bean.BreakDownMaintenance b");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name ="brkdownMaintenaceLogId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	
	
}
