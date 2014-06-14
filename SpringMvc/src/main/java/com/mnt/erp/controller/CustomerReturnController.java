package com.mnt.erp.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.CustomerReturn;
import com.mnt.erp.bean.CustomerReturnLine;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.ReasonForRejection;
import com.mnt.erp.bean.RfqBean;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CustomerReturnService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.StorageLocationService;
import com.mnt.erp.service.UomService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class CustomerReturnController {
	@Autowired
	CustomerReturnService customerReturnService;

	@Autowired
	UomService uomService;

	@Autowired
	StorageLocationService storageLocationService;

	@Autowired
	MaterialService materialService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	DateConversionService dateService;

	@RequestMapping(value = "/CustomerReturnHome", method = RequestMethod.GET)
	public ModelAndView customerHome(
			@ModelAttribute("CustomerReturnCommand") CustomerReturn CustomerReturn,HttpServletRequest request,
			SessionStatus status, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("CustomerReturnHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		return new ModelAndView("customerReturnHome", "CustomerReturnCommand",
				CustomerReturn);

	}
	@RequestMapping(value = "/GetQuantity", method = RequestMethod.POST)
	public @ResponseBody
	String checkquantity(HttpServletRequest request,
			HttpServletResponse response, RfqBean rfqbean) {

		String quantity =null;
		try {

			int mid =Integer.parseInt( request.getParameter("mid"));
			int sid=Integer.parseInt(request.getParameter("salesorderid"));

			quantity = customerReturnService.getQuantityCount(mid, sid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantity;
	}

	@RequestMapping(value = "/GetQuantityEdit", method = RequestMethod.POST)
	public @ResponseBody
	String checkquantityEdit(HttpServletRequest request,
			HttpServletResponse response, RfqBean rfqbean) {

		String quantity =null;
		try {

			int mid =Integer.parseInt( request.getParameter("midedit"));
			int sid=Integer.parseInt(request.getParameter("salesorderidedit"));
            //int cid=Integer.parseInt(request.getParameter("crid"));
			
			quantity = customerReturnService.getQuantityCount(mid, sid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return quantity;
	}

	/* To Get Material Id Values */
	@ModelAttribute("material")
	public Map<Integer, String> materialIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = customerReturnService.selectMaterialIds();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* To Get Material Id Values */
	@ModelAttribute("salesOrder")
	public Map<Integer, String> salesOrderIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = customerReturnService.selectSalesOrders();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* To Get UOM Id Values */
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

	/* To Get Reason For Rejection Id Values */
	@ModelAttribute("reasonForRejectionId")
	public Map<Integer, String> reasonForRejectionIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = customerReturnService.selectReasonForRejection();
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

	/* To Get Storage Location Id Values */
	@ModelAttribute("storageId")
	public Map<Integer, String> storageLocIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = storageLocationService.getStorageIds();
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

	@RequestMapping(value = "/CustomerReturnAdd", method = RequestMethod.POST)
	public String saveCustomerReturn(
			@ModelAttribute("CustomerReturnCommand") CustomerReturn customerReturn,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
           String res=null;
	   
		List<CustomerReturnLine> customerReturnLines = null;
	    HttpSession session=null;
		String msg = null;
		CustomerReturnLine customerReturnLine = null;
		String customerReturnNo = customerReturn.getCustomerReturnNo();
		int list1 = 0;

		list1 = customerReturnService.customerReturnDuplicate(customerReturnNo);
		if (list1 == 0) {
			try {
				customerReturn.setCustomerReturnDate(dateService.dateFormat(dateService.dateParse(customerReturn.getCustomerReturnDate(),"au"),"au"));
				customerReturnLines = new ArrayList<CustomerReturnLine>();
				if(customerReturn.getMaterialids()!=null){
				String materialedit = customerReturn.getMaterialids();
				List<String> meditlist = Arrays.asList(materialedit.split(","));
				Object[] materialiids = meditlist.toArray();
				Integer[] quantity = customerReturn.getQty();

				String uomEdit = customerReturn.getUoms();
				List<String> uomlist = Arrays.asList(uomEdit.split(","));
				Object[] uomids = uomlist.toArray();
				String[] price = customerReturn.getPrice();
				String rfreactionEdit = customerReturn.getReasonForRejection();
				List<String> rfreactionlist = Arrays.asList(rfreactionEdit
						.split(","));
				Object[] rfreaction = rfreactionlist.toArray();
				String storageLocEdit = customerReturn.getStorageLocation();
				List<String> storageLoclist = Arrays.asList(storageLocEdit
						.split(","));
				Object[] storageLocids = storageLoclist.toArray();

				for (int i = 0; i < quantity.length; i++) {
					customerReturnLine = new CustomerReturnLine();

					customerReturnLine
							.setMaterialId(materialiids[i].toString());
					customerReturnLine.setQty(quantity[i]);
					float l = customerReturnLine.getQty();
					int m = Integer.parseInt(customerReturnLine.getMaterialId());

					float n;
					n = materialService.materialStockGet(m);

					float p = 0;
					p = l + n;
					String a = materialService.materialStockUpdate(m, p);

					customerReturnLine.setuOMId(uomids[i].toString());
					customerReturnLine.setPrice(price[i]);
					customerReturnLine.setReasonForRejectionId(rfreaction[i]
							.toString());
					customerReturnLine.setStorageLocationId(storageLocids[i]
							.toString());
					customerReturnLines.add(customerReturnLine);
				}
				}
				customerReturn.setCustomerReturnLine(customerReturnLines);
				session=request.getSession(false);
				msg = customerReturnService.saveCustomerReturn(customerReturn,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());

			
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (msg.equals("S")) {
				res = "redirect:CustomerReturnHome.mnt?list=" + "success" + "";
			}
			else{
				res = "redirect:CustomerReturnHome.mnt?listwar=" + "fail" + "";
			}

		}

		else {
			customerReturn.setAid(1);
			request.setAttribute("addCustomerReturnDuplicate",
					"Customer Return Already Exists Please try some other number");
			return "customerReturnHome";
		}
		return res;

	}

	@RequestMapping(value = "/CustomerReturnSearch", method = RequestMethod.GET)
	public ModelAndView searchCustomerReturn(
			@ModelAttribute("CustomerReturnCommand") CustomerReturn customerReturn,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list1 = null;
		List<CustomerReturn> list = null;
		try {
			String dbField = customerReturn.getXmlLabel();
			String operation = customerReturn.getOperations();
			String basicSearchId = customerReturn.getBasicSearchId();

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
				list1 = customerReturnService.searchCustomerReturn();

			} else {
				list1 = customerReturnService.basicSearchCustomerReturn(
						dbField, operation, basicSearchId);

			}
			list = new ArrayList<CustomerReturn>();
			Iterator<Object[]> iterator = list1.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				CustomerReturn pList = new CustomerReturn();
				pList.setCustomerReturnId((Integer) objects[0]);
				pList.setCustomerReturnNo((String) objects[1]);
				String s = (String) objects[2];
				String t = s.substring(0, 10);
				pList.setCustomerReturnDate(dateService.dateFormat(dateService.dateParse(t,"se"),"se"));

				pList.setReference((String) objects[3]);
				pList.setDescription((String) objects[4]);
			

				list.add(pList);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("crvalues", "crvalues");
		request.setAttribute("customerReturn1", list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customerReturnHome");
		modelAndView.addObject("customerReturn", list);
		return modelAndView;
	}

	@RequestMapping(value = "/CustomerReturnAdvanceSearch", method = RequestMethod.GET)
	public String customerReturnAdvanceSearch(
			@ModelAttribute("CustomerReturnCommand") CustomerReturn customerReturnAdavance,
			HttpServletRequest request, HttpServletResponse response) {
		String name1 = "customerReturn", s1 = null, s2 = null;
		List<Object[]> returnString = null;
		List<CustomerReturn> customerReturnList = null;
		customerReturnList = new ArrayList<CustomerReturn>();
		customerReturnAdavance.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			for (Object[] object : returnString) {
				CustomerReturn p = new CustomerReturn();

				s1 = (String) object[0];
				s2 = (String) object[1];
				p.setFirstLabel(s1);
				p.setSecondLabel(s2);
				customerReturnList.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("customerReturnSearchAdvance", customerReturnList);

		return "customerReturnHome";
	}

	@RequestMapping(value = "/CustomerReturnAdvanceSearchOperations", method = RequestMethod.POST)
	public ModelAndView CustomerReturnAdvanceSearchOperations(
			@ModelAttribute("CustomerReturnCommand") CustomerReturn CustomerReturnOpearations,
			HttpServletRequest request, HttpServletResponse response,
			Model model) throws IOException, ParseException {
		List<CustomerReturn> list = null;
		list = new ArrayList<CustomerReturn>();
		String columns = CustomerReturnOpearations.getFirstLabel();
		String operations = CustomerReturnOpearations.getOperations1();
		String advanceSearchText = CustomerReturnOpearations
				.getAdvanceSearchText();
		List<Object[]> objectsArray = null;
		if (advanceSearchText.length() != 0) {
			objectsArray = customerReturnService.getCustRetrunAdvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = customerReturnService.searchCustomerReturn();
		}
		Iterator<Object[]> iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[]) iterator.next();

			CustomerReturn pList = new CustomerReturn();

			pList.setCustomerReturnId((Integer) objects[0]);
			pList.setCustomerReturnNo((String) objects[1]);
			String s = (String) objects[2];
			String t = s.substring(0, 10);
			pList.setCustomerReturnDate(dateService.dateFormat(dateService.dateParse(t,"se"),"se"));
			pList.setReference((String) objects[3]);
			pList.setDescription((String) objects[4]);
			list.add(pList);

		}

		request.setAttribute("customerReturn1", list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("customerReturnHome");
		modelAndView.addObject("customerReturn", list);
		return modelAndView;
		
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "customerReturnId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/customerReturnEditHome", method = RequestMethod.GET)
	public String customerReturnEdit(
			@ModelAttribute("CustomerReturnCommand") CustomerReturn customerReturnEdit,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object> list = null;
		List<CustomerReturn> customerReturnEditList = new ArrayList<CustomerReturn>();
		List<CustomerReturnLine> customerReturnLineEditList = new ArrayList<CustomerReturnLine>();
		int prid = Integer.parseInt(request.getParameter("customerReturnId"));

		try {

			list = customerReturnService.editCustomerReturnWithId(prid);
			Iterator<Object> iterator = list.iterator();
			if (iterator.hasNext()) {
				Object quotObj = iterator.next();
				CustomerReturn cr = (CustomerReturn) quotObj;
				customerReturnEdit.setCustomerReturnIdEdit(prid);
				customerReturnEdit.setCustomerReturnNoEdit(cr
						.getCustomerReturnNo());
				String s = cr.getCustomerReturnDate();
				String t = s.substring(0, 10);
				customerReturnEdit.setCustomerReturnDateEdit(dateService.dateFormat(dateService.dateParse(t,"se"),"se"));
				customerReturnEdit.setReferenceEdit(cr.getReference());
				customerReturnEdit.setDescriptionEdit(cr.getDescription());
				customerReturnEdit.setSalesOrderIdEdit(cr.getSalesOrderId());

				List<CustomerReturnLine> listEdit = cr.getCustomerReturnLine();

				Iterator<CustomerReturnLine> iterator1 = listEdit.iterator();
				while (iterator1.hasNext()) {
					Object quotLineObj = iterator1.next();
					CustomerReturnLine crLine = (CustomerReturnLine) quotLineObj;
					CustomerReturnLine crMultiple = new CustomerReturnLine();
					crMultiple.setCustomerReturnLineId(crLine
							.getCustomerReturnLineId());
					
					int materialId = Integer.parseInt(crLine.getMaterialId());
					int stock;
					stock = materialService.materialStockGet(materialId);
				
					int beforeQtyEdit=(int)(crLine.getQty());
					
					int remainingStock=stock-beforeQtyEdit;
				
										/*if(remainingStock<0){
											remainingStock=-remainingStock;
					}*/
					crMultiple.setStockEdit(remainingStock);
					Material material = crLine.getMaterial();
					crMultiple.setMateriaName(material.getMaterialName());
					crMultiple.setQtyEdit(crLine.getQty());
					Uom uom = crLine.getUomDetails();
					crMultiple.setUomName(uom.getUom());
					crMultiple.setPriceEdit(crLine.getPrice());
					ReasonForRejection reasonForRejection = crLine
							.getReasonForRejectionDetails();
					crMultiple.setReasonForRejectionName(reasonForRejection
							.getReasonForRejection());
					StorageLocation storageloc = crLine
							.getStorageLocationDetails();
					crMultiple.setStorageLocName(storageloc
							.getStorageLocation());

					crMultiple.setMaterialIdEdit(material.getMaterial_Id());
					crMultiple.setuOMIdEdit(uom.getUom_Id());

					crMultiple.setReasonForRejectionIdEdit(reasonForRejection
							.getReasonForRejectionId());

					crMultiple.setStorageLocationIdEdit(storageloc
							.getStorageLocationId());
					customerReturnLineEditList.add(crMultiple);

				}

				customerReturnEditList.add(customerReturnEdit);

			}

			model.addAttribute("CustomerReturnCommand", customerReturnEdit);

			request.setAttribute("customerReturnEditList",
					customerReturnEditList);
			request.setAttribute("customerReturnLineEditList",
					customerReturnLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customerReturnHome";

	}

	@RequestMapping(value = "/customerReturnUpdate1", method = RequestMethod.POST)
	public String updateCustomerReturn1(
			@ModelAttribute("CustomerReturnCommand") CustomerReturn customerReturnUpdate,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {

		CustomerReturnLine customerReturnLine = null;
		List<CustomerReturnLine> CustomerReturnLineEditList = new ArrayList<CustomerReturnLine>();
	

		String crno = customerReturnUpdate.getCustomerReturnNoEdit();

		int eid = customerReturnUpdate.getCustomerReturnIdEdit();
		int list1 = 0;
		
		String msg = null;
		list1 = customerReturnService.customerReturnEditDuplicate(crno, eid);

		if (list1 == 0) {
			try {
				
				float stockEdit=customerReturnUpdate.getStockEdit();
				customerReturnUpdate.setCustomerReturnId(customerReturnUpdate
						.getCustomerReturnIdEdit());
				customerReturnUpdate.setCustomerReturnNo(customerReturnUpdate
						.getCustomerReturnNoEdit());
				customerReturnUpdate.setCustomerReturnDate(dateService.dateFormat(dateService.dateParse(customerReturnUpdate.getCustomerReturnDateEdit(),"au"),"au")
						);
				customerReturnUpdate.setReference(customerReturnUpdate
						.getReferenceEdit());
				customerReturnUpdate.setDescription(customerReturnUpdate
						.getDescriptionEdit());
				customerReturnUpdate.setSalesOrderId(customerReturnUpdate
						.getSalesOrderIdEdit());
				if(customerReturnUpdate.getMaterialidsEdit()!=null){

				int[] customerReturnIdUpdate = customerReturnUpdate
						.getCustomerReturnLineIdEdit();
				String materialedit = customerReturnUpdate.getMaterialidsEdit();

				List<String> meditlist = Arrays.asList(materialedit.split(","));
				Object[] materialiidedit = meditlist.toArray();
				Integer[] quantity = customerReturnUpdate.getQtyEdit();
				String uomedit = customerReturnUpdate.getUomsEdit();

				List<String> uomlist = Arrays.asList(uomedit.split(","));
				Object[] uomIdlist = uomlist.toArray();
				String[] price = customerReturnUpdate.getPriceEdit();

				String reasonForRejectionid = customerReturnUpdate
						.getReasonForRejectionEdit();

				List<String> reasonForRejectionidlist = Arrays
						.asList(reasonForRejectionid.split(","));
				Object[] reasonForRejection = reasonForRejectionidlist
						.toArray();
				String storageLocId = customerReturnUpdate
						.getStorageLocationEdit();
				List<String> storageloclist = Arrays.asList(storageLocId
						.split(","));
				Object[] storageloc = storageloclist.toArray();

				for (int i = 0; i < quantity.length; i++) {

					customerReturnLine = new CustomerReturnLine();
					customerReturnLine.setMaterialId(materialiidedit[i].toString());
					customerReturnLine.setQty(quantity[i]);
					
					float afterEditQty = customerReturnLine.getQty();
					
					int materialId= Integer.parseInt(customerReturnLine.getMaterialId());

							
					
						float totalStock = 0;
						totalStock = afterEditQty + stockEdit;
					
						String a = materialService.materialStockUpdate(materialId, totalStock);
					customerReturnLine.setuOMId(uomIdlist[i].toString());
					customerReturnLine.setPrice(price[i]);
					customerReturnLine.setReasonForRejectionId(reasonForRejection[i].toString());
					customerReturnLine.setStorageLocationId(storageloc[i].toString());
				

					int kk = customerReturnIdUpdate[i];

					String ch = "1", ch1 = "0";
					String idQL = request.getParameter(kk + "Check");
				

					if (ch.equals(idQL)) {

						String msge = customerReturnService.deleteCustomerReturnLine(kk);
						

					}

					if (ch1.equals(idQL) || idQL == null) {

						CustomerReturnLineEditList.add(customerReturnLine);
						customerReturnUpdate.setCustomerReturnLine(CustomerReturnLineEditList);
					}

				}
				}

				msg = customerReturnService
						.updateCustomerReturn(customerReturnUpdate);

			
				
				if (msg.equals("S")) {
					
					request.setAttribute("customerRetUpdate", "CustomerReturn has been updated");
					
					
				}
				else{
					request.setAttribute("customerRetUpdateError", "CustomerReturn has not been updated");
				}


			} catch (Exception e) {
				e.printStackTrace();
			}
			return "customerReturnHome";
		}

		else {
			customerReturnUpdate.setCustomerReturnIdEdit(1);
			request.setAttribute("addCustomerReturnEditDuplicate",
					"Customer Return Already Exists Please try some other Number");

			request.setAttribute("customerReturnEditList",
					"customerReturnEditList");
		
			return "customerReturnHome";
		}
	}

	@RequestMapping(value = "/customerReturnDelete", method = RequestMethod.GET)
	public ModelAndView customerReturnDelete(
			@ModelAttribute("CustomerReturnCommand") CustomerReturn customerReturn,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
       HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("customerReturnId"));


		try {
			String msg = customerReturnService.deleteCustomerReturn(id);

			

			
			if (msg.equals("S")) {
				request.setAttribute("customerReturnDelete",
						"Customer Return has been deleted successfully");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Customer Return","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			

			} else {

				request.setAttribute("customerReturnDeleteError",
						"Customer Return Data Deletion Failed due to constraint violation!");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("customerReturnHome", "CustomerReturnCommand",
				new CustomerReturn());
	}

}
