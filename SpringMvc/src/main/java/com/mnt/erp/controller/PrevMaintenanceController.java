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
import com.mnt.erp.bean.EquipmentBean;
import com.mnt.erp.bean.MaintenanceCategory;
import com.mnt.erp.bean.PrevMaintenance;
import com.mnt.erp.bean.PrevMaintenanceSchCat;
import com.mnt.erp.bean.maintenanceTypeBean;
import com.mnt.erp.service.PrevMaintenanceService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class PrevMaintenanceController {
    @Autowired
    PrevMaintenanceService prevMaintenanceService;
    @Autowired
    XmlLabelsService xmlService;

    @RequestMapping(value = "/PrevMaintenance", method = RequestMethod.GET)
    public ModelAndView getResourceRequest(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");

	return new ModelAndView("PrevMaintenanceHome",
		"prevMaintenanceCommand", new PrevMaintenance());
    }

    /* To Get Equipment Id Values */
    @ModelAttribute("equipment")
    public Map<Integer, String> equipmentIdGet() {
	List<Object[]> listvalues = null;
	Iterator<Object[]> iterator = null;
	Map<Integer, String> map = new HashMap<Integer, String>();
	try {
	    listvalues = prevMaintenanceService.selectEquipment();
	    iterator = listvalues.iterator();
	    while (iterator.hasNext()) {
		Object[] objects = (Object[]) iterator.next();
		map.put((Integer) objects[0], (String) objects[1]);
	    }

	} catch (Exception e) {

	}
	return map;
    }

    /* To Get Equipment Id Values */
    @ModelAttribute("maintenanceCategory")
    public Map<Integer, String> maintenanceCategoryIdGet() {
	List<Object[]> listvalues = null;
	Iterator<Object[]> iterator = null;
	Map<Integer, String> map = new HashMap<Integer, String>();
	try {
	    listvalues = prevMaintenanceService.selectMaintenanceCategory();
	    iterator = listvalues.iterator();
	    while (iterator.hasNext()) {
		Object[] objects = (Object[]) iterator.next();
		map.put((Integer) objects[0], (String) objects[1]);
	    }

	} catch (Exception e) {

	}
	return map;
    }

    /* To Get Equipment Id Values */
    @ModelAttribute("maintenanceType")
    public Map<Integer, String> maintenanceTypeIdGet() {
	List<Object[]> listvalues = null;
	Iterator<Object[]> iterator = null;
	Map<Integer, String> map = new HashMap<Integer, String>();
	try {
	    listvalues = prevMaintenanceService.selectMaintenanceType();
	    iterator = listvalues.iterator();
	    while (iterator.hasNext()) {
		Object[] objects = (Object[]) iterator.next();
		map.put((Integer) objects[0], (String) objects[1]);
	    }

	} catch (Exception e) {

	}
	return map;
    }

    @RequestMapping(value = "/prevMaintenanceAdd", method = RequestMethod.POST)
    public String savePrevMaintenanceAdd(
	    @ModelAttribute("prevMaintenanceCommand") PrevMaintenance prevMaintenanceAdd,
	    HttpServletRequest request, SessionStatus status,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	String msg = null;
	String res = null;
	List<PrevMaintenanceSchCat> prevMaintenanceSchCat = null;
	PrevMaintenanceSchCat prevMaintenanceSchCa = null;
	String id = prevMaintenanceAdd.getEquipmentId();
	Long s = prevMaintenanceService.checkPrevMaintenance(id);

	if (s == 0) {
	    try {

		String schDate = prevMaintenanceAdd.getSchDT();
		if (schDate != null) {

		    List<String> schDatelist = Arrays
			    .asList(schDate.split(","));
		    Object[] schDates = schDatelist.toArray();

		    String maintencCate = prevMaintenanceAdd
			    .getMaintenanceCategoryId();
		    List<String> maintencCateList = Arrays.asList(maintencCate
			    .split(","));
		    Object[] maintencCateids = maintencCateList.toArray();

		    msg = prevMaintenanceService
			    .savePrevMaintenanceDetails(prevMaintenanceAdd);
		    if (msg == "S") {
			res = "redirect:PrevMaintenance.mnt?list=" + "success"
				+ "";
		    } else {
			res = "redirect:PrevMaintenance.mnt?listwar=" + "fail"
				+ "";
		    }
		}
	    } catch (Exception e) {
		// res = "redirect:PrevMaintenance.mnt?listwar=" + "fail" + "";
		e.printStackTrace();

	    }
	    return res;

	} else {
	    prevMaintenanceAdd.setAid(1);

	    request.setAttribute("addPrivMainDuplicate",
		    "Equipment Already Exists Please try some other Equipment");
	    return "PrevMaintenanceHome";
	}

    }

    @RequestMapping(value = "/prevMaintenanceSearch", method = RequestMethod.GET)
    public ModelAndView prevMaintenanceSearch(
	    @ModelAttribute("prevMaintenanceCommand") PrevMaintenance prevMaintenanceSearch,
	    Model model, HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<Object[]> list = null;
	List<PrevMaintenance> prevMaintenance = new ArrayList<PrevMaintenance>();

	try {

	    String dbField = prevMaintenanceSearch.getXmlLabel();
	    String operation = prevMaintenanceSearch.getOperations();
	    String basicSearchId = prevMaintenanceSearch.getBasicSearchId();

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
		list = prevMaintenanceService.searchPrevMaintenance();

	    } else {
		list = prevMaintenanceService.basicSearchPrevMaintenance(
			dbField, operation, basicSearchId);

	    }

	    Iterator<Object[]> iterator = list.iterator();
	    while (iterator.hasNext()) {
		PrevMaintenance prevMain = new PrevMaintenance();
		Object[] obj = (Object[]) iterator.next();
		prevMain.setPrevMaintenanceSchId((Integer) obj[0]);
		prevMain.setPrevMaintenanceSchNo((String) obj[1]);
		EquipmentBean emp = ((EquipmentBean) obj[2]);
		prevMain.setEquipmentName(emp.getEquipmentName());
		prevMaintenance.add(prevMain);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	request.setAttribute("preMainValues", "preMainValues");

	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("PrevMaintenanceHome");
	modelAndView.addObject("PrevMaintenance", prevMaintenance);
	return modelAndView;

    }

    @RequestMapping(value = "/prevMaintenanceEdit", method = RequestMethod.GET)
    public String editPrevMain(
	    @ModelAttribute("prevMaintenanceCommand") PrevMaintenance prevMaintenanceEdit,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<PrevMaintenance> preMainEdit = new ArrayList<PrevMaintenance>();

	List<PrevMaintenanceSchCat> resourceReqDetailList = new ArrayList<PrevMaintenanceSchCat>();
	int id = Integer.parseInt(request.getParameter("prevMaintenanceId"));

	try {
	    List<PrevMaintenance> list = prevMaintenanceService
		    .searchPrevMaintenanceWithId(id);
	    Iterator<PrevMaintenance> iter = list.iterator();
	    while (iter.hasNext()) {
		Object pobject = iter.next();
		PrevMaintenance resReq = (PrevMaintenance) pobject;

		prevMaintenanceEdit.setPrevMaintenanceSchIdEdit(resReq
			.getPrevMaintenanceSchId());
		prevMaintenanceEdit.setPrevMaintenanceSchNoEdit(resReq
			.getPrevMaintenanceSchNo());
		prevMaintenanceEdit.setEquipmentIdEdit(resReq.getEquipmentId());

		// preMainEdit.add(resourceRequestEdit);

		List<PrevMaintenanceSchCat> listEdit = resReq
			.getPrevMaintenanceSchCat();

		Iterator<PrevMaintenanceSchCat> iterate = listEdit.iterator();
		while (iterate.hasNext()) {
		    Object object2 = iterate.next();
		    PrevMaintenanceSchCat resRdit = (PrevMaintenanceSchCat) object2;

		    PrevMaintenanceSchCat resReEdit = new PrevMaintenanceSchCat();
		    resReEdit.setPrevMaintenanceSchCatIdEdit(resRdit
			    .getPrevMaintenanceSchCatId());

		    resReEdit.setMaintenanceCategoryIdEdit(resRdit
			    .getMaintenanceCategoryId());
		    resReEdit.setMaintenanceTypeIdEdit(resRdit
			    .getMaintenanceTypeId());
		    MaintenanceCategory maincat = resRdit
			    .getMaintenanceCategory();
		    resReEdit.setMaintenanceCategoryName(maincat
			    .getMaintenanceCategory());
		    maintenanceTypeBean mainType = resRdit
			    .getMaintenanceTypeDetails();
		    resReEdit.setMaintenanceTypeBeanName(mainType
			    .getMaintenanceType());
		    resReEdit.setSchDTEdit(resRdit.getSchDT());

		    resourceReqDetailList.add(resReEdit);

		}
		prevMaintenanceEdit
			.setPrevMaintenanceSchCat(resourceReqDetailList);

		preMainEdit.add(prevMaintenanceEdit);

	    }

	    request.setAttribute("preMainEdit", preMainEdit);

	    request.setAttribute("preMainCatList", resourceReqDetailList);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "PrevMaintenanceHome";
    }

    @RequestMapping(value = "/prevMaintenanceUpdate", method = RequestMethod.POST)
	public String prevMaintenanceUpdate(
			@ModelAttribute("prevMaintenanceCommand") PrevMaintenance prevMaintenanceUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<PrevMaintenanceSchCat> resourceReqDetail = null;
		PrevMaintenanceSchCat resoReqDetail=null;
		String msg=null;
		prevMaintenanceUpdate.setPrevMaintenanceSchId(prevMaintenanceUpdate.getPrevMaintenanceSchIdEdit());
		prevMaintenanceUpdate.setPrevMaintenanceSchNo(prevMaintenanceUpdate.getPrevMaintenanceSchNoEdit());
		prevMaintenanceUpdate.setEquipmentId(prevMaintenanceUpdate.getEquipmentIdEdit());
		int id=prevMaintenanceUpdate.getPrevMaintenanceSchId();
	String equipmentId=prevMaintenanceUpdate.getEquipmentIdEdit();
	Long s=prevMaintenanceService.updateCheckPrevMaintenance(equipmentId, id);

		if(s==0){
				try{
		
		String requiredDate = prevMaintenanceUpdate.getSchDTEdit();

		if(requiredDate!=null){
		
		
	
		List<String> requiredDatelist = Arrays.asList(requiredDate.split(","));
		Object[] requiredDates = requiredDatelist.toArray();
		
					
		
		
	   
		String statuss = prevMaintenanceUpdate.getMaintenanceCategoryIdEdit();
		
		List<String> statusList = Arrays.asList(statuss.split(","));
		Object[] statusids = statusList.toArray();
		
	String maintype = prevMaintenanceUpdate.getMaintenanceTypeIdEdit();
		
		List<String> maintypeList = Arrays.asList(maintype.split(","));
		Object[] maintypeids = maintypeList.toArray();
		int[] resReqIdUpdate = prevMaintenanceUpdate.getPrevMainEditt();
	
		resourceReqDetail = new ArrayList<PrevMaintenanceSchCat>();
		for (int i = 0; i < requiredDates.length; i++) {
		
			resoReqDetail = new PrevMaintenanceSchCat();
			
			resoReqDetail.setPrevMaintenanceSchCatId(resReqIdUpdate[i]);
			resoReqDetail.setSchDT(requiredDates[i].toString());
			
			resoReqDetail.setMaintenanceCategoryId(statusids[i].toString());
			resoReqDetail.setMaintenanceTypeId(maintypeids[i].toString());
	
		int resDelId = resReqIdUpdate[i];
		
			String check = "1", check1 = "0";
			String egCheck = request.getParameter(resDelId + "Check");
			
			if (check.equals(egCheck)) {
				
				prevMaintenanceService.deletePrevMaintenanceDetail(resDelId);

			}

			if (check1.equals(egCheck) || egCheck == null) {
				
				resourceReqDetail.add(resoReqDetail);

			}

		}
			
		//resourceReqDetail.add(resoReqDetail);

		prevMaintenanceUpdate.setPrevMaintenanceSchCat(resourceReqDetail);


		msg=prevMaintenanceService.updatePrevMaintenance(prevMaintenanceUpdate);
		
		if(msg=="S"){
			request.setAttribute("prevMainUpdate", "PrevMaintenance has been updated");
		}
		else{
			request.setAttribute("prevMainUpdateError", "PrevMaintenance has not been updated");
		}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
				}
		else{
		
		prevMaintenanceUpdate.setPrevMaintenanceSchIdEdit(1);
		request.setAttribute("addPreMainEditDuplicate","Equipment Already Exists Please try some other Equipment");
		request.setAttribute("preMainEdit", "preMainEdit");
		return "PrevMaintenanceHome";
		}
		return "PrevMaintenanceHome";
	}

    @RequestMapping(value = "/prevMaintenanceDelete", method = RequestMethod.GET)
    public ModelAndView prevMaintenanceDelete(
	    @ModelAttribute("prevMaintenanceCommand") PrevMaintenance prevMaintenanceDelete,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");

	int id = Integer.parseInt(request.getParameter("prevMaintenanceId"));
	try {

	    String msg = prevMaintenanceService.deletePrevMaintenance(id);
	    if (msg == "S") {

		request.setAttribute("prevMainDelete",
			"PrevMaintenance has been deleted");

	    } else {

		request.setAttribute("prevMainDeleteError",
			"PrevMaintenance has not been deleted");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return new ModelAndView("PrevMaintenanceHome",
		"prevMaintenanceCommand", new PrevMaintenance());
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "prevMaintenanceId";

	Map<String, String> map = new HashMap<String, String>();

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }

}
