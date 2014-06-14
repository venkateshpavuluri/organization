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
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.MaterialPrice;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MaterialPriceService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.OrganizationService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class MaterialPriceController {

	@Autowired
	MaterialPriceService mpservice;

	@Autowired
	MaterialService materialService;

	@Autowired
	OrganizationService organizationService;

	@Autowired
	UomService uomService;

	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	@Autowired
	DateConversionService dateService;

	@RequestMapping(value = "/materialPrice", method = RequestMethod.GET)
	public ModelAndView assetHome(
			@ModelAttribute("materialPriceCommand") MaterialPrice materialPriceBean,
			SessionStatus status,HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("materialPrice.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("materialPriceHome", "materialPriceCommand",
				materialPriceBean);
	}

// To Get Material Id Values 
	@ModelAttribute("material")
	public Map<Integer, String> materialIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = materialService.materialIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	 //To Get Org Id Values 
	@ModelAttribute("organization")
	public Map<Integer, String> PurOrgCompany() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;

		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = organizationService.selectOrganizationDetails();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	 //To Get UOM Id Values 
	@ModelAttribute("uom")
	public Map<Integer, String> UomIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = uomService.selectUomDetails();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	@ModelAttribute("SelectCurrency")
	public Map<Integer, String> currencySelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> list = null;
			Iterator<Object[]> itr = null;
			Object[] objects = null;
			list = mpservice.populateCurrencyIds();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return map;
	}

	@RequestMapping(value = "/materialPriceAdd", method = RequestMethod.POST)
	public String saveMaterialPrice(
			@ModelAttribute("materialPriceCommand") MaterialPrice materialPriceBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg=null;
		String res=null;
		HttpSession session=null;
		MaterialPrice mpbean = (MaterialPrice) materialPriceBean;

		try {
			
			materialPriceBean.setValidFrom(dateService.dateFormat(dateService.dateParse(materialPriceBean.getValidFrom(),"au"),"au"));
			materialPriceBean.setValidTo(dateService.dateFormat(dateService.dateParse(materialPriceBean.getValidTo(),"au"),"au"));
			session=request.getSession(false);
			msg=mpservice.saveMaterialPriceDetails(mpbean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
			if(msg=="S"){
				res = "redirect:materialPrice.mnt?list=" + "success" + "";
			}
			else{
				res = "redirect:materialPrice.mnt?listwar=" + "fail" + "";
			}
		

		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return res;

	}

	@RequestMapping(value = "/DuplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkMPAddDuplicate(MaterialPrice materialPriceCheck,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {

		String m=request.getParameter("materialId");
		
		int material=Integer.parseInt(m);
		
		
		String batchNo = request.getParameter("batchNo");
		String validFrom = request.getParameter("validFrom");
		String validTo = request.getParameter("validTo");
		String materialPriceDuplMessage = null;
		
		Long checkCustName = mpservice.checkMaterialPrice(material, batchNo,
				validFrom, validTo);
		
		if (checkCustName != 0) {
			materialPriceCheck.setAid(1);
			materialPriceDuplMessage = "Warning ! Material Price is Already exists.";
		} else {
			materialPriceCheck.setAid(1);
			materialPriceDuplMessage = null;
		}

		return materialPriceDuplMessage;
	}

	@RequestMapping(value = "/MaterialPriceSearch", method = RequestMethod.GET)
	public ModelAndView searchAssetType(
			@ModelAttribute("materialPriceCommand") MaterialPrice materialPriceSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<MaterialPrice> materialPriceList = new ArrayList<MaterialPrice>();

		try {
			int id = materialPriceSearch.getMaterialPrice_Id();
			String dbField = materialPriceSearch.getXmlLabel();
			String operation = materialPriceSearch.getOperations();
			String basicSearchId = materialPriceSearch.getBasicSearchId();

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
				list = mpservice.searchMaterialPrice();

			} else {
				list = mpservice.basicSearchMaterialPrice(dbField, operation,
						basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				MaterialPrice materialPrice = new MaterialPrice();
				Object[] obj = (Object[]) iterator.next();
				materialPrice.setMaterialPrice_Id((Integer) obj[0]);
				Material material = ((Material) obj[1]);
				materialPrice.setMaterialName(material.getMaterialName());
				materialPrice.setBatchNo((String) obj[2]);
				materialPrice.setAmount((String) obj[3]);
				materialPrice.setValidFrom(dateService.dateFormat(dateService.dateParse((String) obj[6],"se"),"se"));
				materialPrice.setValidTo(dateService.dateFormat(dateService.dateParse((String) obj[7],"se"),"se"));
				materialPriceList.add(materialPrice);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("mpvalues", "mpvalues");

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("materialPriceHome");
		modelAndView.addObject("MaterialPrice", materialPriceList);
		return modelAndView;

	}

	@RequestMapping(value = "/MaterialPriceEdit", method = RequestMethod.GET)
	public String materialPriceEdit(
			@ModelAttribute("materialPriceCommand") MaterialPrice materialPriceEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("MaterialPriceId"));
		List<Object[]> list = null;
		List<MaterialPrice> materialPriceList = new ArrayList<MaterialPrice>();
		try {
			list = mpservice.searchMaterialPriceWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				materialPriceEdit.setMaterialPrice_IdEdit((Integer) obj[0]);
				materialPriceEdit.setMaterial_IdEdit((String) obj[1]);
				materialPriceEdit.setBatchNoEdit((String) obj[2]);
				materialPriceEdit.setAmountEdit((String) obj[3]);
				materialPriceEdit.setCurrency_IdEdit((String) obj[4]);
				materialPriceEdit.setPerUnitEdit((String) obj[5]);
			
				materialPriceEdit.setValidFromEdit(dateService.dateFormat(dateService.dateParse((String) obj[6],"se"),"se"));
				materialPriceEdit.setValidToEdit(dateService.dateFormat(dateService.dateParse((String) obj[7],"se"),"se"));
				materialPriceEdit.setOrg_IdEdit((String) obj[8]);
				materialPriceList.add(materialPriceEdit);
			}
			request.setAttribute("materialPriceEdit", materialPriceList);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "materialPriceHome";

	}
    
	@RequestMapping(value = "/DuplicateCheckEdit", method = RequestMethod.POST)
	public @ResponseBody
	String checkMPEditDuplicate(MaterialPrice materialPriceCheck,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {

		
		String m=request.getParameter("materialIdEdit");
		
		int materialEdit=Integer.parseInt(m);
		
		String batchNoEdit = request.getParameter("batchNoEdit");
		String validFromEdit = request.getParameter("validFromEdit");
		String validToEdit = request.getParameter("validToEdit");
		String mp=request.getParameter("materialPrice_IdEdit");
		int materialPrice_IdEdit = Integer.parseInt(mp);
		String materialPriceEditDuplMessage = null;
		
		Long checkCustName = mpservice.updateCheckMaterialPrice(materialEdit, batchNoEdit, validFromEdit, validToEdit, materialPrice_IdEdit);
		
		if (checkCustName != 0) {
			materialPriceCheck.setMaterial_IdEdit("1");
			materialPriceEditDuplMessage = "Warning ! Material Price is Already exists.";
		} else {
			materialPriceCheck.setMaterial_IdEdit("1");
			materialPriceEditDuplMessage = null;
		}

		return materialPriceEditDuplMessage;
	}
	@RequestMapping(value = "/MaterialPriceUpdate", method = RequestMethod.POST)
	public String updateMaterialPrice(
			@ModelAttribute("materialPriceCommand") MaterialPrice materialPriceUpdate,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
	

		try {
			materialPriceUpdate.setMaterialPrice_Id(materialPriceUpdate
					.getMaterialPrice_IdEdit());
			materialPriceUpdate.setMaterial_Id(materialPriceUpdate
					.getMaterial_IdEdit());
			materialPriceUpdate
					.setBatchNo(materialPriceUpdate.getBatchNoEdit());
			materialPriceUpdate.setAmount(materialPriceUpdate.getAmountEdit());
			materialPriceUpdate.setCurrency_Id(materialPriceUpdate
					.getCurrency_IdEdit());
			materialPriceUpdate
					.setPerUnit(materialPriceUpdate.getPerUnitEdit());
			materialPriceUpdate.setuOM_Id(materialPriceUpdate.getuOM_IdEdit());
			materialPriceUpdate.setValidFrom(dateService.dateFormat(dateService.dateParse(materialPriceUpdate
					.getValidFromEdit(),"au"),"au"));
			materialPriceUpdate
					.setValidTo(dateService.dateFormat(dateService.dateParse(materialPriceUpdate.getValidToEdit(),"au"),"au"));
			materialPriceUpdate.setOrg_Id(materialPriceUpdate.getOrg_IdEdit());

			String msg = mpservice.updateMaterialPrice(materialPriceUpdate);
			if(msg=="S"){
				request.setAttribute("materialPriceUpdate", "Material Price has been updated");
			}
			else{
				request.setAttribute("materialPriceUpdateError", "Material Price has not been updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("materialPriceCommand", new MaterialPrice());

		return "materialPriceHome";

	}

	@RequestMapping(value = "/MaterialPriceDelete", method = RequestMethod.GET)
	public ModelAndView deleteAgreementType(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;
		
		try {
			id = Integer.parseInt(request.getParameter("MaterialPriceId"));
			String msg = mpservice.deleteMaterialPrice(id);
			if (msg.equals("S")){
				request.setAttribute("materialPriceDeleted", "Material Price has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Material Price","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
			}
			else{
				request.setAttribute("materialPriceDeletedError", "Matrial Price has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	

		return new ModelAndView("materialPriceHome","materialPriceCommand",new MaterialPrice());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "materialPriceId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
