/**
 * 
 */
package com.mnt.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.EquipmentCategory;
import com.mnt.erp.bean.EquipmentDocument;
import com.mnt.erp.bean.MaintenancePlan;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.EquipmentService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author madhav
 * 
 */

@Controller
@Scope("request")
public class EquipmentController {
	private static Logger logger=Logger.getLogger(EquipmentController.class);
			

	@Autowired
	EquipmentService equipmentService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	// Home page
	@RequestMapping(value = "/equipmentHome", method = RequestMethod.GET)
	public ModelAndView equipmentHome(
			@ModelAttribute("equipmentCmd") EquipmentBean equipmentBean,
			SessionStatus status,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("equipmentHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("equipmentHome", "equipmentCmd", equipmentBean);

	}

	// Method for Addion Equipment Details
	@RequestMapping(value = "/equipmentAdd", method = RequestMethod.POST)
	public String saveEquipment(
			@ModelAttribute("equipmentCmd") EquipmentBean saveEquipmentBean,
			MultipartHttpServletRequest request, HttpServletResponse response,
			SessionStatus status) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String res=null;
		HttpSession session=null;
		int id=saveEquipmentBean.getEquipmentId();
		// File saving details
		String filePathToGraphsDir = null;

		InputStream inputStream = null;
		OutputStream outputStream = null;

		MultipartFile[] file = saveEquipmentBean.getFile();
		String[] docName = saveEquipmentBean.getDocName();
		EquipmentDocument eqDoc = new EquipmentDocument();

		String equipName = saveEquipmentBean.getEquipmentName();
		EquipmentBean eBean = (EquipmentBean) saveEquipmentBean;
		eBean.seteId(1);
		try {

			equipmentService.saveEquipment(eBean);

			// Uploading Details
			filePathToGraphsDir = servletContext
					.getRealPath("/equipmentDocuments");
			int eqId = eBean.getEquipmentId();
			logger.info("equipment id==="+eqId);
			String dirName = String.valueOf(eBean.getEquipmentId());

			if (file.length != 0 && docName.length != 0) {

				for (int i = 0; i < file.length; i++) {

					String fileName = file[i].getOriginalFilename();
					inputStream = file[i].getInputStream();
					File newDir = new File(filePathToGraphsDir + "/" + dirName);
					logger.info("dir path iss==="+newDir);
					if (!newDir.exists()) {
						if (newDir.mkdir()) {
							System.out.println("Directory is created");
						} else
							System.out.println("Directory is Not Created");
					}
				
			
					String savePath = newDir + "/" + fileName;
				
					File file2=new File(newDir + "/" + fileName);
					logger.info("final file isiss=="+file2);
					outputStream = new FileOutputStream(file2);
					int read = 0;
					byte[] bytes = new byte[1024];

					while ((read = inputStream.read(bytes)) != -1) {
						outputStream.write(bytes, 0, read);
					}

					// Save into Equipment Documents
					eqDoc.setDocumentName(docName[i]);
					eqDoc.setEquipmentId(eqId);
					eqDoc.setDocumentPath(savePath);
					msg=equipmentService.saveEquipmentDocuments(eqDoc);
					if(msg.equals("S")){
						res = "redirect:equipmentHome.mnt?list=" + "success" + "";
						session=request.getSession(false);
						Date date = new Date();
						String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
						auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Maintenance Plan","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());		
					}
					else{
						res = "redirect:equipmentHome.mnt?listwar=" + "fail" + "";
					}
					// closing the Stream files
					outputStream.flush();
					inputStream.close();
					outputStream.close();

				}
			}
		
		} catch (Exception e) {
			res = "redirect:equipmentHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
		}
		return res;
	}

	@RequestMapping(value = "/checkEquipAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkAddDuplicate(HttpServletRequest request,
			HttpServletResponse response, EquipmentBean dupBean) {
		response.setCharacterEncoding("UTF-8");
		String message = null;
		String equipmentName = request.getParameter("equipmentName");
		Long checkEquipName = equipmentService.addCheckEquipment(equipmentName);
		if (checkEquipName != 0) {

			dupBean.seteId(1);
			message = "Warning ! Equipment Name already Exists Choose Another One";
		} else {
			dupBean.seteId(1);
			message = "";
		}

		return message;
	}

	// Method for Update Duplicate
	@RequestMapping(value = "/checkUpdateEquipDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkUpdateEquipmentDuplicate(HttpServletRequest request,
			HttpServletResponse response, EquipmentBean dupBean1) {
		response.setCharacterEncoding("UTF-8");
		String message = null;
		String equipmentName = request.getParameter("equipmentName");
		String eqId = request.getParameter("eqId");
		int id = Integer.valueOf(eqId);
		int checkEquipName = equipmentService.updateCheckEquipment(
				equipmentName, id);
		if (checkEquipName != 0) {
			dupBean1.seteIdEdit(1);
			message = "Warning ! EquipmentName already Exists Choose Another One";
		} else {
			dupBean1.seteIdEdit(1);
			message = "";
		}

		return message;
	}

	// Method for Equipment Category Selection
	@ModelAttribute("equipmentCatSelect")
	public Map<Integer, String> equipmentCategorySelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> listValues = equipmentService
					.selectEquipmentCategory();
			Iterator<Object[]> iter = listValues.iterator();

			while (iter.hasNext()) {
				Object[] objects = (Object[]) iter.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	// basic Search model attribute
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "equipmentId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	// Method for basic search
	@RequestMapping(value = "/equipmentSearch", method = RequestMethod.GET)
	public String searchcondition(
			@ModelAttribute("equipmentCmd") EquipmentBean equipmentSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<EquipmentBean> equipmentBean = new ArrayList<EquipmentBean>();

		try {
			int id = equipmentSearch.getEquipmentId();
			String dbField = equipmentSearch.getXmlLabel();
			String operation = equipmentSearch.getOperations();
			String basicSearchId = equipmentSearch.getBasicSearchId();

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

				list = equipmentService.searchEquipment();

			} else {

				list = equipmentService.basicSearchEquipment(dbField,
						operation, basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				EquipmentBean eb = new EquipmentBean();
				Object[] obj = (Object[]) iterator.next();
				eb.setEquipmentId((Integer) obj[0]);
				eb.setEquipmentName((String) obj[1]);
				EquipmentCategory eCat = ((EquipmentCategory) obj[2]);
				eb.setEquipmentCategory(eCat.getEquipmentCategory());
				eb.setMake((String) obj[3]);
				eb.setModel((String) obj[4]);
				eb.setPowerConsumptionInHours((String) obj[5]);
				eb.setProductionCapacity((String) obj[6]);
				eb.setValidFrom((String) obj[6]);
				eb.setValidTo((String) obj[7]);
				eb.setWorkInstruction((String) obj[8]);

				equipmentBean.add(eb);
			}
			request.setAttribute("equipmentBean", equipmentBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "equipmentHome";
	}

	@RequestMapping(value = "/equipmentEdit", method = RequestMethod.GET)
	public String equipmentEdit(
			@ModelAttribute("equipmentCmd") EquipmentBean equipmentEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("equipmentId"));
		List<Object[]> list = null;
		List<EquipmentBean> equipmentBean = new ArrayList<EquipmentBean>();
		try {
			list = equipmentService.searchEquipmentWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				equipmentEdit.setEquipmentIdEdit((Integer) obj[0]);
				equipmentEdit.setEquipmentNameEdit((String) obj[1]);
				equipmentEdit.setEquipmentCategoryIdEdit((String) obj[2]);
				equipmentEdit.setMakeEdit((String) obj[3]);
				equipmentEdit.setModelEdit((String) obj[4]);
				equipmentEdit.setPowerConsumptionInHoursEdit((String) obj[5]);
				equipmentEdit.setProductionCapacityEdit((String) obj[6]);
				equipmentEdit.setValidFromEdit((String) obj[7]);
				equipmentEdit.setValidToEdit((String) obj[8]);
				equipmentEdit.setWorkInstructionEdit((String) obj[9]);

				equipmentBean.add(equipmentEdit);
			}
			request.setAttribute("equipmentEdit", equipmentBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "equipmentHome";

	}

	@RequestMapping(value = "/equipmentUpdate", method = RequestMethod.POST)
	public String customerUpdate(
			@ModelAttribute("equipmentCmd") EquipmentBean equipmentBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		equipmentBeanUpdate.setEquipmentId(equipmentBeanUpdate
				.getEquipmentIdEdit());
		equipmentBeanUpdate.setEquipmentName(equipmentBeanUpdate
				.getEquipmentNameEdit());
		equipmentBeanUpdate.setEquipmentCategoryId(equipmentBeanUpdate
				.getEquipmentCategoryIdEdit());
		equipmentBeanUpdate.setMake(equipmentBeanUpdate.getMakeEdit());
		equipmentBeanUpdate.setModel(equipmentBeanUpdate.getModelEdit());
		equipmentBeanUpdate.setPowerConsumptionInHours(equipmentBeanUpdate
				.getPowerConsumptionInHoursEdit());
		equipmentBeanUpdate.setProductionCapacity(equipmentBeanUpdate
				.getProductionCapacityEdit());
		equipmentBeanUpdate
				.setValidFrom(equipmentBeanUpdate.getValidFromEdit());
		equipmentBeanUpdate.setValidTo(equipmentBeanUpdate.getValidToEdit());
		equipmentBeanUpdate.setWorkInstruction(equipmentBeanUpdate
				.getWorkInstructionEdit());
		try {
			msg = equipmentService.updateEquipment(equipmentBeanUpdate);

			if (msg == "S") {
				request.setAttribute("equipUpdate","Equipment has been updated");

			} else {
				request.setAttribute("equipUpdateError","Equipment has not been updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "equipmentHome";
	}

	@RequestMapping(value = "/equipmentDelete", method = RequestMethod.GET)
	public ModelAndView conditionDelete(
			@ModelAttribute("equipmentCmd") EquipmentBean conditionDel,
			HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("equipmentId"));
		try {

			String msg = equipmentService.deleteEquipment(id);

			if (msg == "S") {
				session=request.getSession(false);
				 Date date = new Date();
				 String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				 auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Equipment","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				 request.setAttribute("equipDeleted","Equipment has been deleted");
				
			} else {
				
				request.setAttribute("equipDeletedError","Equipment has not been deleted");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("equipmentHome", "equipmentCmd",new EquipmentBean());
	}

}
