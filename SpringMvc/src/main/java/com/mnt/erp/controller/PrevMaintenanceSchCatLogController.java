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
import com.mnt.erp.bean.PrevMaintenance;
import com.mnt.erp.bean.PrevMaintenanceSchCat;
import com.mnt.erp.bean.PrevMaintenanceSchCatLog;
import com.mnt.erp.bean.PrevMaintenanceSchCatLogSpare;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.VacancyDetailLine;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.BreakdownMaintenaceLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.PrevMaintenaceSchCatLogService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author venkateshp
 *
 */
@Controller
public class PrevMaintenanceSchCatLogController {
	private static Logger logger=Logger.getLogger(PrevMaintenanceSchCatLogController.class);
	@Autowired PopulateService populateService;
	@Autowired PrevMaintenaceSchCatLogService prevMtSchCatService;
	@Autowired AuditLogService auditLogService;
	@Autowired XmlLabelsService xmlService;
	@Autowired ERPDao erpDao;
	@Autowired MenuService menuService;
	@Autowired DateConversionService dateService;
	
	@RequestMapping(value = "/prevMtSchCatLogHome", method = RequestMethod.GET)
	public String prevMtSchCatLogHome(
			@ModelAttribute("prevMtSchCatLog") PrevMaintenanceSchCatLog  schCatLog,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("prevMtSchCatLogHome.mnt", session.getAttribute("userId").toString());
		session.setAttribute("privilegeList",list);
		return "preMtSchCatLogView";
}
	
	@RequestMapping(value = "/saveprevMtSchCatLog", method = RequestMethod.POST)
	public String addBrkDownMtLog(@ModelAttribute("prevMtSchCatLog") PrevMaintenanceSchCatLog maintenanceLog ,
HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicatId=null;
		HttpSession session=null;
		List<PrevMaintenanceSchCatLogSpare> listOfLogSpare=null;
try
{
	listOfLogSpare=new ArrayList<PrevMaintenanceSchCatLogSpare>();
	String mt=maintenanceLog.getMaterialId();
	String uom=maintenanceLog.getUomId();
	String qt=maintenanceLog.getQuantity();
	String[] materialIds=null;
	String[] uomIds=null;
	String[] quantity=null;
	maintenanceLog.setMaintenanceDT(dateService.dateFormat(dateService.dateParse(maintenanceLog.getMaintenanceDT(), "au"), "au"));
	if(mt!=null)
		materialIds=mt.split(",");
	if(uom!=null)
		uomIds=uom.split(",");
	if(qt!=null)
		quantity=qt.split(",");
	for(int i=0;i<materialIds.length;i++)
	{
		PrevMaintenanceSchCatLogSpare maintenanceSpare=new PrevMaintenanceSchCatLogSpare();
		maintenanceSpare.setMaterialId(materialIds[i]);
		maintenanceSpare.setUomId(uomIds[i]);
		maintenanceSpare.setQuantity(quantity[i]);
		listOfLogSpare.add(maintenanceSpare);
	}
	maintenanceLog.setPrevMtSchCatLogSpares(listOfLogSpare);
	String idg=prevMtSchCatService.savePreMtSchCatLog(maintenanceLog);
	
	if(idg.equals("S"))
	{
		session=request.getSession(false);
		 Date date1 = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Prevent Maintenance Schedule Category Log","ROW" ,String.valueOf(maintenanceLog.getPrevMaintenanceSchCatLogId()),"1",modifiedDate,session.getAttribute("userName").toString());
		return "redirect:/prevMtSchCatLogHome.mnt?list=success";
	}
	else
	{
		return "redirect:/prevMtSchCatLogHome.mnt?listwar=fail";
	}
}
catch(Exception e)
{
	e.printStackTrace();
	return "redirect:/prevMtSchCatLogHome.mnt?listwar=fail";
}
}
	
	
	@RequestMapping(value = "/prevMtSchCatSearch", method = RequestMethod.GET)
	public String searchIVShedule(
			@ModelAttribute("prevMtSchCatLog")PrevMaintenanceSchCatLog  maintenanceLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		List<Object[]> listOfObjects=null;
		List<PrevMaintenanceSchCatLog> maintenanceLogs=null;
		Iterator<Object[]> iterator=null;
		try
		{
			maintenanceLogs=new ArrayList<PrevMaintenanceSchCatLog>();
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
				//sql="select p.prevMaintenanceSchCatLogId,p.maintenanceDT,p.maintainedBy,p.prevMtSchCats,p.statusDetails from com.mnt.erp.bean.PrevMaintenanceSchCatLog p";
				listOfObjects=prevMtSchCatService.searchPreMtSchCatLog();
			
				}
			else
			{
				listOfObjects=prevMtSchCatService.preMtSchCatLogBasicSearch(dbField, operation, basicSearchId);
				}
			iterator=listOfObjects.iterator();
			while(iterator.hasNext())
			{
				Object[] objects=(Object[])iterator.next();
		
				PrevMaintenanceSchCatLog maintenanceSchCatLog=new PrevMaintenanceSchCatLog();
				maintenanceSchCatLog.setPrevMaintenanceSchCatLogId((Integer)objects[0]);
				maintenanceSchCatLog.setMaintenanceDT(dateService.dateFormat(dateService.dateParse((String)objects[1], "se"), "se"));
				maintenanceSchCatLog.setMaintainedBy((String)objects[2]);
				PrevMaintenanceSchCat prevMaintenance=(PrevMaintenanceSchCat)objects[3];
				maintenanceSchCatLog.setPrevMtName(String.valueOf(prevMaintenance.getMaintenanceTypeId()));
				Status status=(Status)objects[4];
				maintenanceSchCatLog.setStatusName(status.getStatus());
				maintenanceLogs.add(maintenanceSchCatLog);
			}
				request.setAttribute("prevMt",maintenanceLogs);
			}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "preMtSchCatLogView";
	}


	@RequestMapping(value = "/prevMtLogEdit", method = RequestMethod.GET)
	public String editBrkDownMtLog(@ModelAttribute("prevMtSchCatLog")PrevMaintenanceSchCatLog schCatLog,HttpServletRequest request,HttpServletResponse response, Model model) {
		List<PrevMaintenanceSchCatLogSpare> downMaintenanceSpares=null;
		List<PrevMaintenanceSchCatLogSpare> listMaintenanceSpares=null;
		try
		{
			int maintenanceLogId=Integer.parseInt(request.getParameter("prevMtLogId"));
			List<PrevMaintenanceSchCatLog> maintenanceLogs=prevMtSchCatService.editPreMtSchCatLog(maintenanceLogId);
			listMaintenanceSpares=new ArrayList<PrevMaintenanceSchCatLogSpare>();
			Iterator<PrevMaintenanceSchCatLog> iterator=maintenanceLogs.iterator();
			while(iterator.hasNext())
			{
				
				PrevMaintenanceSchCatLog catLog=(PrevMaintenanceSchCatLog)iterator.next();
				schCatLog.setPrevMaintenanceSchCatLogId(catLog.getPrevMaintenanceSchCatLogId());

				schCatLog.setMaintainedBy(catLog.getMaintainedBy());
				schCatLog.setMaintenanceDT(dateService.dateFormat(dateService.dateParse(catLog.getMaintenanceDT(), "se"), "se"));
				schCatLog.setStatusId(catLog.getStatusId());
				schCatLog.setPrevMaintenanceSchCatId(catLog.getPrevMaintenanceSchCatId());
			
		 downMaintenanceSpares=(List<PrevMaintenanceSchCatLogSpare>)catLog.getPrevMtSchCatLogSpares();
				Iterator<PrevMaintenanceSchCatLogSpare> listOfSpares=downMaintenanceSpares.iterator();
				while(listOfSpares.hasNext())
				{
					PrevMaintenanceSchCatLogSpare maintenanceSpare=(PrevMaintenanceSchCatLogSpare)listOfSpares.next();
					PrevMaintenanceSchCatLog brkDownMaLog=new PrevMaintenanceSchCatLog();
					brkDownMaLog.setPrevMtSchCatLogSpareIdEdit(String.valueOf(maintenanceSpare.getPrevMtSchCatLogSpareId()));
					brkDownMaLog.setMaterialIdEdit(maintenanceSpare.getMaterialId());
					brkDownMaLog.setUomIdEdit(maintenanceSpare.getUomId());
					brkDownMaLog.setQuantityEdit(maintenanceSpare.getQuantity());
					Material material=(Material)maintenanceSpare.getMaterials();
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
		
		return "preMtSchCatLogView";
	}
	
	
	
	
	
	@RequestMapping(value = "/updatePrevMtLog", method = RequestMethod.POST)
	public String prevMtLogUpdate(
			@ModelAttribute("prevMtSchCatLog")PrevMaintenanceSchCatLog schCatLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
	
		List<InterViewSchedule> interViewSchedules=null;
		List<PrevMaintenanceSchCatLogSpare> brkDwnMtSparelist=null;
		List<PrevMaintenanceSchCatLogSpare> childDelete=null;
		try
		{
			//sql="select count(*) from ChartofAccount cb where  cb.coa='"
					//+ chartofAccount + "' and cb.coaId!="+Id;
					
		String brkDwnMtSpare=schCatLog.getPrevMtSchCatLogSpareIdEdit();
			String materials=schCatLog.getMaterialIdEdit();
			String uom= schCatLog.getUomIdEdit();
			String qua=schCatLog.getQuantityEdit();
			schCatLog.setMaintenanceDT(dateService.dateFormat(dateService.dateParse(schCatLog.getMaintenanceDT(), "ae"), "ae"));
			//schCatLog.setEndDt(dateService.dateFormat(dateService.dateParse(downMaintenanceLog.getEndDt(), "ae"), "ae"));
			if(materials!=null);
				String[] materialIds=materials.split(",");
				if(qua!=null);
				String[] quantity=qua.split(",");
				if(uom!=null);
				String[] uomIds=uom.split(",");
				if(brkDwnMtSpare!=null);
					String[] brkDwnMtSpareId=brkDwnMtSpare.split(",");
					brkDwnMtSparelist=new ArrayList<PrevMaintenanceSchCatLogSpare>();
			childDelete=new ArrayList<PrevMaintenanceSchCatLogSpare>();
			for(int i=0;i<uomIds.length;i++)
			{
				int id=Integer.parseInt(brkDwnMtSpareId[i]);
				if(id==0)
				{
					PrevMaintenanceSchCatLogSpare maintenanceSpare=new PrevMaintenanceSchCatLogSpare();
			maintenanceSpare.setPrevMtSchCatLogSpareId(Integer.valueOf(brkDwnMtSpareId[i]));
			maintenanceSpare.setMaterialId(materialIds[i]);
			maintenanceSpare.setUomId(uomIds[i]);
			maintenanceSpare.setQuantity(quantity[i]);
			brkDwnMtSparelist.add(maintenanceSpare);
				}
				else
				{
					PrevMaintenanceSchCatLogSpare maintenanceSpare=new PrevMaintenanceSchCatLogSpare();
					maintenanceSpare.setPrevMtSchCatLogSpareId(Integer.valueOf(brkDwnMtSpareId[i]));
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
					PrevMaintenanceSchCatLogSpare mtSpareDelete=new PrevMaintenanceSchCatLogSpare();
					mtSpareDelete.setPrevMtSchCatLogSpareId(Integer.valueOf(brkDwnMtSpareId[i]));
					childDelete.add(mtSpareDelete);
				}
				}
				}
			schCatLog.setPrevMtSchCatLogSpares(brkDwnMtSparelist);
		String msg=	prevMtSchCatService.deleteChilds(childDelete);
		String msgs=prevMtSchCatService.updatePreMtSchCatLog(schCatLog);
		if(msgs.equals("S"))
		{
			request.setAttribute("prevMtSchLogUpdate","Success");
			model.addAttribute("prevMtSchCatLog",new PrevMaintenanceSchCatLog());
		}
		else
		{
			request.setAttribute("prevMtSchLogUpdateFail","Fail");
		}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.setAttribute("prevMtSchLogUpdateFail","Fail");
		}
	return "preMtSchCatLogView";	
		}
	
	
	
	@RequestMapping(value = "/prevLogDelete", method = RequestMethod.GET)
	public String brkDownMtLogDelete(
			@ModelAttribute("prevMtSchCatLog")PrevMaintenanceSchCatLog schCatLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=null; 
		try
		{
			int id=Integer.parseInt(request.getParameter("prevMtLogId"));
			String msg=prevMtSchCatService.deletePreMtSchCatLog(id);
			if(msg.equals("S"))
			{
				session=request.getSession(false);
				 Date date1 = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Prevent Maintenance Schedule Category Log","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("prevMtLogDelete","Success");
			}
			else
			{
				request.setAttribute("prevMtLogDeleteFail","Fail");
			}
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			e.printStackTrace();
			request.setAttribute("prevMtLogDeleteFail","Fail");
		}
		return "preMtSchCatLogView";
	}


	

	@RequestMapping(value = "/prevMtAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody String addDuplicateCheck(@ModelAttribute("prevMtSchCatLog")PrevMaintenanceSchCatLog schCatLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=null;
		String msg=null;
	try
	{
		int prevMtCat=Integer.parseInt(request.getParameter("prevMtCat"));
		System.out.println("id iss=="+prevMtCat);
	Long	duplicatId=erpDao.duplicateCheck("select count(*) from com.mnt.erp.bean.PrevMaintenanceSchCatLog b where b.prevMaintenanceSchCatId="+prevMtCat+"");
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
	@RequestMapping(value = "/prevMtUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody String addDuplicateCheckForEdit(@ModelAttribute("prevMtSchCatLog")PrevMaintenanceSchCatLog schCatLog,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");	
		HttpSession session=null;
		String msg=null;
	try
	{
		int prevCatId=Integer.parseInt(request.getParameter("prevCatId"));
		int prevMtId=Integer.parseInt(request.getParameter("prevMtId"));
		Long duplicate=erpDao.duplicateCheck("select count(*) from com.mnt.erp.bean.PrevMaintenanceSchCatLog b where b.prevMaintenanceSchCatId='"+prevCatId+"' and  b.prevMaintenanceSchCatLogId!="+prevMtId);
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
		e.printStackTrace();
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
	
	@ModelAttribute("statusDetails")
	public Map<Integer, String> populateStatusDetails() {
		Map<Integer, String> map = null;
		try {
			map = populateService.populateSelectBox("select m.statusId,m.status from com.mnt.erp.bean.Status m");

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
	
	@ModelAttribute("prevMtSchCatDetails")
	public Map<Integer, String> populatePrevMtSchCatDetails() {
		Map<Integer, String> map = null;
		try {
			map = populateService.populateSelectBox("select b.prevMaintenanceSchCatId,b.maintenanceCategoryId from com.mnt.erp.bean.PrevMaintenanceSchCat b");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
	
	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name ="prevMaintenanceSchCatLogId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	
	
}
