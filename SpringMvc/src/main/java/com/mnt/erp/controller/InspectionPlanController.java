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
import com.mnt.erp.bean.InspCharacteristic;
import com.mnt.erp.bean.InspectionPlan;
import com.mnt.erp.bean.InspectionPlanLine;
import com.mnt.erp.bean.InsplotOrigin;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.ProcessDetailBean;
import com.mnt.erp.service.InspectionPlanService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class InspectionPlanController {
	 @Autowired
	    XmlLabelsService xmlService;
	 @Autowired
	 InspectionPlanService inspectionPlanService;
	 @Autowired
	    PopulateService populateService;
	@RequestMapping(value = "/InspectionPlan", method = RequestMethod.GET)
	public ModelAndView getInspectionPlan(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		
		return new ModelAndView("InspectionPlanHome", "inspectionPlanCommand",
				new InspectionPlan());
	}
	
	
	@RequestMapping(value = "/InspectionPlanAdd", method = RequestMethod.POST)
    public String saveInspectionPlanAdd(
	    @ModelAttribute("inspectionPlanCommand") InspectionPlan InspectionPlanAdd,
	    HttpServletRequest request, SessionStatus status,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	String msg = null;
	String res = null;
	List<InspectionPlanLine> inspectionPlanLine = null;
	InspectionPlanLine inspectionPlanLines = null;
	String id = InspectionPlanAdd.getMaterialId();
	Long s = inspectionPlanService.checkInspectionPlan(id);

	if (s == 0) {
	    try {

		String equipment = InspectionPlanAdd.getEquipmentId();
		if (equipment != null) {

		    List<String> equipmentsList = Arrays
			    .asList(equipment.split(","));
		    Object[] equipments = equipmentsList.toArray();

		    String processDetail = InspectionPlanAdd
			    .getProcessDetailId();
		    List<String> processDetailList = Arrays.asList(processDetail
			    .split(","));
		    Object[] processDetails = processDetailList.toArray();

		    String inspChars = InspectionPlanAdd
				    .getInspCharacteristicId();
			    List<String> inspCharsList = Arrays.asList(inspChars
				    .split(","));
			    Object[] inspCharsLists = inspCharsList.toArray();
			    inspectionPlanLine= new ArrayList<InspectionPlanLine>();
				
				for (int i = 0; i < equipmentsList.size(); i++) {
				
					inspectionPlanLines = new InspectionPlanLine();
			
					inspectionPlanLines.setInspCharacteristicId(inspCharsLists[i].toString());
					inspectionPlanLines.setEquipmentId(equipments[i].toString());
					inspectionPlanLines.setProcessDetailId(processDetails[i].toString());
					inspectionPlanLine.add(inspectionPlanLines);
			
		
				}
				InspectionPlanAdd.setInspectionPlanLine(inspectionPlanLine);
		    msg = inspectionPlanService
			    .saveInspectionPlanDetails(InspectionPlanAdd);
		    if (msg == "S") {
			res = "redirect:InspectionPlan.mnt?list=" + "success"
				+ "";
		    } else {
			res = "redirect:InspectionPlan.mnt?listwar=" + "fail"
				+ "";
		    }
		}
	    } catch (Exception e) {
		 res = "redirect:InspectionPlan.mnt?listwar=" + "fail" + "";
		e.printStackTrace();

	    }
	    return res;

	} else {
	    InspectionPlanAdd.setAid(1);

	    request.setAttribute("addPrivMainDuplicate",
		    "Material Already Exists Please try some other Material");
	    return "InspectionPlanHome";
	}

    }

    @RequestMapping(value = "/InspectionPlanSearch", method = RequestMethod.GET)
    public ModelAndView InspectionPlanSearch(
	    @ModelAttribute("inspectionPlanCommand") InspectionPlan InspectionPlanSearch,
	    Model model, HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<Object[]> list = null;
	List<InspectionPlan> InspectionPlan = new ArrayList<InspectionPlan>();

	try {

	    String dbField = InspectionPlanSearch.getXmlLabel();
	    String operation = InspectionPlanSearch.getOperations();
	    String basicSearchId = InspectionPlanSearch.getBasicSearchId();

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
		list = inspectionPlanService.searchInspectionPlan();

	    } else {
		list = inspectionPlanService.basicSearchInspectionPlan(
			dbField, operation, basicSearchId);

	    }

	    Iterator<Object[]> iterator = list.iterator();
	    while (iterator.hasNext()) {
		InspectionPlan inspPlan = new InspectionPlan();
		Object[] obj = (Object[]) iterator.next();
		inspPlan.setInspectionPlanId((Integer) obj[0]);
		Material material=(Material)obj[1];
		inspPlan.setMaterialName(material.getMaterialName());
		InsplotOrigin insplot=(InsplotOrigin)obj[2];
		inspPlan.setInsplotOrginName(insplot.getInsplotorigin());
		
		InspectionPlan.add(inspPlan);
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	request.setAttribute("preMainValues", "preMainValues");

	ModelAndView modelAndView = new ModelAndView();
	modelAndView.setViewName("InspectionPlanHome");
	modelAndView.addObject("InspectionPlan", InspectionPlan);
	return modelAndView;

    }

    @RequestMapping(value = "/InspectionPlanEdit", method = RequestMethod.GET)
    public String editInspectionPlan(
	    @ModelAttribute("inspectionPlanCommand") InspectionPlan InspectionPlanEdit,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<InspectionPlan> inspPlanEdit = new ArrayList<InspectionPlan>();
List<InspectionPlanLine> inspectionPlanLineList=new ArrayList<InspectionPlanLine>();
	List<InspectionPlanLine> resourceReqDetailList = new ArrayList<InspectionPlanLine>();
	int id = Integer.parseInt(request.getParameter("InspectionPlanId"));

	try {
	    List<InspectionPlan> list = inspectionPlanService
		    .searchInspectionPlanWithId(id);
	    Iterator<InspectionPlan> iter = list.iterator();
	    while (iter.hasNext()) {
		Object pobject = iter.next();
		InspectionPlan inspect = (InspectionPlan) pobject;
		InspectionPlanEdit.setInspectionPlanId(inspect.getInspectionPlanId());
		InspectionPlanEdit.setMaterialId(inspect.getMaterialId());
		InspectionPlanEdit.setInspLotOriginId(inspect.getInspLotOriginId());

		

		List<InspectionPlanLine> listEdit = inspect
			.getInspectionPlanLine();

		Iterator<InspectionPlanLine> iterate = listEdit.iterator();
		while (iterate.hasNext()) {
		    Object object2 = iterate.next();
		    InspectionPlanLine inspecRdit = (InspectionPlanLine) object2;

		    InspectionPlanLine inspectEdit = new InspectionPlanLine();
		    inspectEdit.setInspectionPlanLineIdEdit(inspecRdit.getInspectionPlanLineId());
		    inspectEdit.setProcessDetailIdEdit(inspecRdit.getProcessDetailId());
		    inspectEdit.setInspCharacteristicIdEdit(inspecRdit.getInspCharacteristicId());
		    inspectEdit.setEquipmentIdEdit(inspecRdit.getEquipmentId());
		   ProcessDetailBean process=inspecRdit.getProcessDetailBean();
		   inspectEdit.setProcessDetailName(String.valueOf(process.getProcessseq()));
		   InspCharacteristic inspChar=inspecRdit.getInspectionCharacteristic();
		   inspectEdit.setInspectionCharName(inspChar.getInspCharacteristic());
		   EquipmentBean equipment=inspecRdit.getEquipment();
		   inspectEdit.setEquipmentName(equipment.getEquipmentName());
		

		   inspectionPlanLineList.add(inspectEdit);

		}
		InspectionPlanEdit
			.setInspectionPlanLine(inspectionPlanLineList);

		inspPlanEdit.add(InspectionPlanEdit);

	    }
	   
	    request.setAttribute("preMainEdit", inspPlanEdit);

	    request.setAttribute("preMainCatList", inspectionPlanLineList);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "InspectionPlanHome";
    }

    @RequestMapping(value = "/InspectionPlanUpdate", method = RequestMethod.POST)
	public String InspectionPlanUpdate(
			@ModelAttribute("inspectionPlanCommand") InspectionPlan InspectionPlanUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		List<InspectionPlanLine> inspectionPlanLine = null;
		
		String msg=null;
		
		int id=InspectionPlanUpdate.getInspectionPlanId();
		
	String equipmentId=InspectionPlanUpdate.getMaterialId();
	//List<InspectionPlanLine> inspectionPlanLine = null;
	InspectionPlanLine inspectionPlanLinest = null;
	Long s=inspectionPlanService.updateCheckInspectionPlan(equipmentId, id);
System.out.println("the s:"+s);
		if(s==0){
				try{
		
		

					String equipment = InspectionPlanUpdate.getEquipmentIdEdit();
					if (equipment != null) {

					    List<String> equipmentsList = Arrays
						    .asList(equipment.split(","));
					    Object[] equipments = equipmentsList.toArray();

					    String processDetail = InspectionPlanUpdate
						    .getProcessDetailIdEdit();
					    List<String> processDetailList = Arrays.asList(processDetail
						    .split(","));
					    Object[] processDetails = processDetailList.toArray();

					    String inspChars = InspectionPlanUpdate
							    .getInspCharacteristicIdEdit();
						    List<String> inspCharsList = Arrays.asList(inspChars
							    .split(","));
						    Object[] inspCharsLists = inspCharsList.toArray();
						    int[] resReqIdUpdate = InspectionPlanUpdate.getInspectionEditt();
						    inspectionPlanLine= new ArrayList<InspectionPlanLine>();
							System.out.println("size of the list"+equipmentsList.size());
							for (int i = 0; i < equipmentsList.size(); i++) {
							
								inspectionPlanLinest = new InspectionPlanLine();
								System.out.println("the inspection Line:"+resReqIdUpdate[i]);
								inspectionPlanLinest.setInspectionPlanLineId(resReqIdUpdate[i]);
								inspectionPlanLinest.setInspCharacteristicId(inspCharsLists[i].toString());
								inspectionPlanLinest.setEquipmentId(equipments[i].toString());
								inspectionPlanLinest.setProcessDetailId(processDetails[i].toString());
								
	
		int resDelId = resReqIdUpdate[i];
		
			String check = "1", check1 = "0";
			String egCheck = request.getParameter(resDelId + "Check");
			
			if (check.equals(egCheck)) {
				
				inspectionPlanService.deleteInspectionPlanDetail(resDelId);

			}

			if (check1.equals(egCheck) || egCheck == null) {
				
				inspectionPlanLine.add(inspectionPlanLinest);

			}

		}
			
	

		InspectionPlanUpdate.setInspectionPlanLine(inspectionPlanLine);


		msg=inspectionPlanService.updateInspectionPlan(InspectionPlanUpdate);
		
		if(msg=="S"){
			request.setAttribute("InspectionPlanUpdate", "InspectionPlan has been updated");
		}
		else{
			request.setAttribute("InspectionPlanUpdateError", "InspectionPlan has not been updated");
		}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
				}
		else{
		
		//InspectionPlanUpdate.setInspectionPlanSchIdEdit(1);
		request.setAttribute("addPreMainEditDuplicate","Equipment Already Exists Please try some other Equipment");
		request.setAttribute("preMainEdit", "preMainEdit");
		return "InspectionPlanHome";
		}
		return "InspectionPlanHome";
	}

    @RequestMapping(value = "/InspectionPlanDelete", method = RequestMethod.GET)
    public ModelAndView InspectionPlanDelete(
	    @ModelAttribute("inspectionPlanCommand") InspectionPlan InspectionPlanDelete,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");

	int id = Integer.parseInt(request.getParameter("InspectionPlanId"));
	try {

	    String msg = inspectionPlanService.deleteInspectionPlan(id);
	    if (msg == "S") {

		request.setAttribute("InspectionPlanDelete",
			"InspectionPlan has been deleted");

	    } else {

		request.setAttribute("InspectionPlanDeleteError",
			"InspectionPlan has not been deleted");
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return new ModelAndView("InspectionPlanHome",
		"inspectionPlanCommand", new InspectionPlan());
    }
    @ModelAttribute("material")
    public Map<Integer, String> populateMaterial() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select m.material_Id,m.materialName from Material m");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @ModelAttribute("inspLotOrigin")
    public Map<Integer, String> populateInspLotOrigin() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select e.insplotoriginId,e.insplotorigin from InsplotOrigin e");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @ModelAttribute("processDetail")
    public Map<Integer, Integer> populateProcessDetail() {
    List<Object[]> listvalues = null;
    Map<Integer, Integer> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, Integer>();
        listvalues = populateService
    	    .poPulate("select p.processdetailid,p.processseq from ProcessDetailBean p");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (Integer) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @ModelAttribute("inspCharacteristic")
    public Map<Integer, String> populateInspCharacteristic() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select e.inspCharacteristicId,e.inspCharacteristic from InspCharacteristic e");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }
    @ModelAttribute("equipment")
    public Map<Integer, String> populateEquipment() {
    List<Object[]> listvalues = null;
    Map<Integer, String> map = null;
    Iterator<Object[]> iterator = null;
    try {
        map = new HashMap<Integer, String>();
        listvalues = populateService
    	    .poPulate("select e.equipmentId,e.equipmentName from EquipmentBean e");

        iterator = listvalues.iterator();
        while (iterator.hasNext()) {
    	Object[] objects = (Object[]) iterator.next();
    	// list.add((String)objects[1]);
    	map.put((Integer) objects[0], (String) objects[1]);

        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return map;
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "InspectionPlan";

	Map<String, String> map = new HashMap<String, String>();

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
