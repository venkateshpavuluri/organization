package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.CharacteristicType;
import com.mnt.erp.bean.Code;
import com.mnt.erp.bean.InspCharacteristic;
import com.mnt.erp.bean.InspCharacteristicMethod;
import com.mnt.erp.bean.InspectionMethodBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.InspCharacteristicService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author kirangangone
 *
 */
@Controller
@Scope("request")
public class InspCharacteristicController {
	
	
	@Autowired
	InspCharacteristicService inspCharacteristicService;
	
	
	@Autowired
	UomService uomService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	DateConversionService dateService;
	
	@RequestMapping(value = "/inspCharacteristicAdvanceSearch", method = RequestMethod.GET)
	public String inspectionCharAdvanceSearch(
			@ModelAttribute("inspCharacteristicCommand") InspCharacteristic inspCharacteristic,
			HttpServletRequest request, HttpServletResponse response) {

		// String
		// advanceSearchHidden=request.getParameter("advanceSearchHidden");
		response.setCharacterEncoding("UTF-8");
		String name1 = "inspCharacteristic", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		// Vendor v=null;
		List<InspCharacteristic> inspCharacteristicList = null;
		inspCharacteristicList = new ArrayList();
		inspCharacteristic.setAdvanceSearchHidden(1);
		inspCharacteristic.setAdvanceBasicSearchHidden(2);
		try {
			returnString = xmlService.populateXml(name1);
			Iterator it = returnString.iterator();
			for (Object[] object : returnString) {
				InspCharacteristic inspCharacteristicObject = new InspCharacteristic();

				s1 = (String) object[0];
				s2 = (String) object[1];
				inspCharacteristicObject.setFirstLabel(s1);
				inspCharacteristicObject.setSecondLabel(s2);
				inspCharacteristicList.add(inspCharacteristicObject);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("inspCharacteristicSearchAdvance", inspCharacteristicList);

		return "inspCharacteristicHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "inspCharacteristic";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	@ModelAttribute("Uom")
	public Map<Integer, String> uomSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Object[] UomObjects = null;
		List<Object[]> UomList = null;
		Iterator<Object[]> UomIterator = null;
		try {
			UomList = uomService.uomIdGet();
			UomIterator = UomList.iterator();
			while (UomIterator.hasNext()) {
				UomObjects = (Object[]) UomIterator.next();
				map.put((Integer) UomObjects[0], (String) UomObjects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}
	
	
	
	@ModelAttribute("characteristicType")
	public Map<Integer, String> characteristicType() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Object[] UomObjects = null;
		List<Object[]> UomList = null;
		Iterator<Object[]> UomIterator = null;
		try {
			UomList = inspCharacteristicService.charactersticTypeSelect();
			UomIterator = UomList.iterator();
			while (UomIterator.hasNext()) {
				UomObjects = (Object[]) UomIterator.next();
				map.put((Integer) UomObjects[0], (String) UomObjects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}
	
	@ModelAttribute("inspectionMethod")
	public Map<Integer, String> inspectionMethod() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		Object[] inspectionMethodObjects = null;
		List<Object[]> inspectionMethodList = null;
		Iterator<Object[]> inspectionMethodIterator = null;
		try {
			inspectionMethodList = inspCharacteristicService.inspectionMethodSelect();
			inspectionMethodIterator = inspectionMethodList.iterator();
			while (inspectionMethodIterator.hasNext()) {
				inspectionMethodObjects = (Object[]) inspectionMethodIterator.next();
				map.put((Integer) inspectionMethodObjects[0], (String) inspectionMethodObjects[1]);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	
	@RequestMapping(value = "/duplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String uplicateCheck(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforeCreditNoteNoValue = 0;
		try {

			String beforeCreditNoteNo = request.getParameter("InspCharacteristic");
			String id=request.getParameter("InspCharacteristicid");
			if(id.equalsIgnoreCase("0"))
			{
			beforeCreditNoteNoValue = inspCharacteristicService.checkInspCharacteristic(beforeCreditNoteNo,"");
			}
			else
			{
				beforeCreditNoteNoValue = inspCharacteristicService.checkInspCharacteristic(beforeCreditNoteNo,id);
				
			}
			
			Code creditNote = new Code();
			if (beforeCreditNoteNoValue != 0) {
                  System.out.println("this is working");
				creditNote.setCodeDuplicate(1);
				creditNote.setCode("");
				msa = "Warning ! Insp Characteristic aleardy exists.";
				return msa;
			}
			if (beforeCreditNoteNoValue == 0) {
				creditNote.setCodeDuplicate(1);
				msa = "";
				return msa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msa;
	}
	
	@RequestMapping(value = "/InspCharacteristic", method = RequestMethod.GET)
	public ModelAndView getInspCharacteristic(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("InspCharacteristic.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		return new ModelAndView("inspCharacteristicHome", "inspCharacteristicCommand", new InspCharacteristic());

	}

	@RequestMapping(value = "/InspCharacteristicAdd", method = RequestMethod.POST)
	public String addInspCharacteristic(@ModelAttribute("inspCharacteristicCommand") InspCharacteristic inspCharacteristic,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session=null;
		String res=null;
		Set<InspCharacteristicMethod> inspCharacteristicMethod = new HashSet<InspCharacteristicMethod>();
		String[] inspectionMethodId = inspCharacteristic.getInspectionMethodIdForView();
		
		InspCharacteristic inspCharacteristicDetails = (InspCharacteristic) inspCharacteristic;
	    if(inspectionMethodId!=null)
		{
			for (int n = 0; n < inspectionMethodId.length; n++) {

				InspCharacteristicMethod inspectionMethodDetails = new InspCharacteristicMethod();
				
				inspectionMethodDetails.setInspectionMethodId(inspectionMethodId[n]);
		
				inspCharacteristicMethod.add(inspectionMethodDetails);
			}
	}
	    inspCharacteristicDetails.setInspCharacteristicMethodGroupDetails(inspCharacteristicMethod);
		

		int checkInsp = inspCharacteristicService.checkInspCharacteristic(inspCharacteristic.getInspCharacteristic(),"");
		if (checkInsp == 0) {
			try {
				session=request.getSession(false);
				inspCharacteristicDetails
				.setValidFrom(dateService.dateFormat(
						dateService.dateParse(
								inspCharacteristicDetails.getValidFrom(), "au"),
						"au"));
				String msg = inspCharacteristicService.saveInspCharacteristic(inspCharacteristicDetails, session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if(msg=="S")
				{
					res = "redirect:InspCharacteristic.mnt?list=" + "success" + "";
				}
				else
				{
					res = "redirect:InspCharacteristic.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				
			}
		} else {
			inspCharacteristic.setInCId(1);
			request.setAttribute("fail",
					"Warning ! InspCharacteristic aleardy exists.");
			request.setAttribute("inspCharacteristicMethod", inspCharacteristicMethod);

			return "inspCharacteristicHome";

		}
		
		return res;
	}
	
	
	@RequestMapping(value = "/inspCharacteristicSearch", method = RequestMethod.GET)
	public String searchInspectionchar(
			@ModelAttribute("inspCharacteristicCommand") InspCharacteristic inspCharacteristicSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<InspCharacteristic> inspCharacteristicList = new ArrayList<InspCharacteristic>();
		List<Object[]> list=null;
		Iterator<Object[]> iterator = null;
		Object[] objects = null;
		int advanceBasicSearchHidden=0;
		try {
			
			advanceBasicSearchHidden=inspCharacteristicSearch.getAdvanceBasicSearchHidden();
			if(advanceBasicSearchHidden==2)
			{
				
				String columns = inspCharacteristicSearch.getFirstLabel();
				String operations = inspCharacteristicSearch.getOperations1();
				String advanceSearchText = inspCharacteristicSearch.getAdvanceSearchText();
				if (advanceSearchText.length() != 0 && advanceSearchText != null) {

					list = inspCharacteristicService.basicSearchInspCharacteristic(columns, operations,
							advanceSearchText,"A");
				} else {
					list = inspCharacteristicService.basicSearchInspCharacteristic("","","","");
				}
				inspCharacteristicSearch.setAdvanceBasicSearchHidden(2);
			}
			else
			{
			String dbField = inspCharacteristicSearch.getXmlLabelBasic();
			String operation = inspCharacteristicSearch.getOperations();
			String basicSearchId = inspCharacteristicSearch.getBasicSearchId();

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
			 list = inspCharacteristicService.basicSearchInspCharacteristic("","","","");

			} else 
				if (basicSearchId != "")
			{
				
				list = inspCharacteristicService.basicSearchInspCharacteristic(dbField, operation,
						basicSearchId,"B");
				
			}
			}
			
			if(list!=null){
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				InspCharacteristic cb = new InspCharacteristic();
				
				cb.setInspCharacteristicId((Integer) objects[0]);
				 cb.setInspCharacteristicCode((String) objects[1]);
				 cb.setInspCharacteristic((String) objects[2]);
				 cb.setValidFrom((String) objects[4]);
				 cb
					.setValidFrom(dateService.dateFormat(
				dateService.dateParse(
									((String) objects[4]), "se"),
							"se"));
							cb.setCharacteristicTypeId((String) objects[5]);
				 cb.setRules((String) objects[6]);
				 Uom uom=(Uom)objects[7];
				 cb.setUomId(uom.getUom());
				 CharacteristicType ctype=(CharacteristicType)objects[8];
				 cb.setCharTypeName(ctype.getCharacteristicType());
				 inspCharacteristicList.add(cb);

			}
		}
			
			
			request.setAttribute("inspCharacteristicList", inspCharacteristicList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "inspCharacteristicHome";

	}
	
	
	
	@RequestMapping(value = "/inspCharacteristicEdit", method = RequestMethod.GET)
	public String inspCharacteristicEdit(
			@ModelAttribute("inspCharacteristicCommand") InspCharacteristic inspCharacteristic,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<InspCharacteristic> inspCharacteristicEditList = new ArrayList<InspCharacteristic>();
		Set<InspCharacteristicMethod> inspCharacteristicMethodEditList = new HashSet<InspCharacteristicMethod>();

		int purcId = Integer.parseInt(request.getParameter("inspCharacteristicId"));

		try {

			List<Object> l = inspCharacteristicService.editInspCharacteristicWithId(purcId);
			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				InspCharacteristic ccb = (InspCharacteristic) oo;
				inspCharacteristic.setInspCharacteristicId(ccb.getInspCharacteristicId());
				 inspCharacteristic.setInspCharacteristicCode(ccb.getInspCharacteristicCode());
				 inspCharacteristic.setInspCharacteristic(ccb.getInspCharacteristic());
				 inspCharacteristic.setUpperLimit(ccb.getUpperLimit());
				 inspCharacteristic.setLowerLimit(ccb.getLowerLimit());
				 inspCharacteristic.setUomId(ccb.getUomId());
				 inspCharacteristic.setValidFrom(
							dateService.dateFormat(
									dateService.dateParse(
											ccb.getValidFrom(), "se"),
												"se"));
				 inspCharacteristic.setCharacteristicTypeId(ccb.getCharacteristicTypeId());
				 inspCharacteristic.setPriority(ccb.getPriority());
				 inspCharacteristic.setRules(ccb.getRules());
				 inspCharacteristic.setMinTolerance(ccb.getMinTolerance());
				 inspCharacteristic.setMaxTolerance(ccb.getMaxTolerance());
				 inspCharacteristic.setSpecification(ccb.getSpecification());
			

				Set<InspCharacteristicMethod> listEdit = ccb.getInspCharacteristicMethodGroupDetails();
				
				Iterator<InspCharacteristicMethod> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					InspCharacteristicMethod cc = (InspCharacteristicMethod) o;
					InspCharacteristicMethod cMultiple = new InspCharacteristicMethod();
					cMultiple.setInspCharacteristicMethodId(cc.getInspCharacteristicMethodId());
					cMultiple.setInspectionMethodId(cc.getInspectionMethodId());
					InspectionMethodBean inspectionMethodName = (InspectionMethodBean) cc.getInspectionMethodBeanDetails();
					
					
					cMultiple.setInspectionMethodName(inspectionMethodName.getInspectionmethod());
					inspCharacteristicMethodEditList.add(cMultiple);

				}
				inspCharacteristic.setInspCharacteristicMethodGroupDetails(inspCharacteristicMethodEditList);
				inspCharacteristicEditList.add(inspCharacteristic);
			}

			request.setAttribute("inspCharacteristicEditList", inspCharacteristicEditList);
			request.setAttribute("inspCharacteristicMethodEditList",inspCharacteristicMethodEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "inspCharacteristicHome";
	}
	
	@RequestMapping(value = "/inspCharacteristicUpdate", method = RequestMethod.POST)
	public String inspCharacteristicUpdate(
			@ModelAttribute("inspCharacteristicCommand") InspCharacteristic inspCharacteristicUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Set<InspCharacteristicMethod> inspCharacteristicUpList = new HashSet<InspCharacteristicMethod>();
		int[] inspCharacteristicMethodId = inspCharacteristicUpdate.getInspCharacteristicMethodId();
		String[] inspectionMethodIdForView = inspCharacteristicUpdate.getInspectionMethodIdForView();
		
		try{
			inspCharacteristicUpdate
			.setValidFrom(dateService.dateFormat(
					dateService.dateParse(
							inspCharacteristicUpdate.getValidFrom(), "au"),
					"au"));
		if (inspectionMethodIdForView != null) {

			for (int n = 0; n < inspectionMethodIdForView.length; n++) {

				int puId = inspCharacteristicMethodId[n];

				if (puId == 0) {
					InspCharacteristicMethod cbd = new InspCharacteristicMethod();
					cbd.setInspectionMethodId(inspectionMethodIdForView[n]);
					cbd.setInspCharacteristicId(inspCharacteristicUpdate.getInspCharacteristicId());
					inspCharacteristicUpList.add(cbd);

				} else {
					int CheckInsp = Integer.parseInt(request.getParameter("CheckInsp"
									+ inspCharacteristicMethodId[n]));

					InspCharacteristicMethod cbd = new InspCharacteristicMethod();
					cbd.setInspectionMethodId(inspectionMethodIdForView[n]);
					cbd.setInspCharacteristicMethodId(inspCharacteristicMethodId[n]);
					cbd.setInspCharacteristicId(inspCharacteristicUpdate.getInspCharacteristicId());
					if (CheckInsp == 0) {
						inspCharacteristicUpList.add(cbd);
						
					} else {

						inspCharacteristicService.deleteInspCharacteristic(inspCharacteristicMethodId[n],"Sub");

					}

				}
			}
			inspCharacteristicUpdate.setInspCharacteristicMethodGroupDetails(inspCharacteristicUpList);

		}
		String msg = inspCharacteristicService.updateInspCharacteristic(inspCharacteristicUpdate);
	
		if (msg=="S") {
			
			request.setAttribute("inspCharUpdate", "Inspection Characteristic has been updated successfully");
			
		} else {
			
			request.setAttribute("inspCharUpdateError", "Inspection Characteristic has not been updated");
			
		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "inspCharacteristicHome";
	}
	
	
	
	
	@RequestMapping(value = "/inspCharacteristicDelete", method = RequestMethod.GET)
	public ModelAndView inspCharactersticDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
	  HttpSession session=null;

		try {
			
			int id = Integer.parseInt(request.getParameter("inspCharacteristicId"));
			String msg = inspCharacteristicService.deleteInspCharacteristic(id, "main");
			if (msg=="S")
			{
				request.setAttribute("inspCharDelete","Inspection Characteristic has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Characteristic Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
				
			}
			else
			{
				request.setAttribute("inspCharDeleteError","Inspection Characteristic has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("inspCharacteristicHome", "inspCharacteristicCommand",
				new InspCharacteristic());
	}
	
}
