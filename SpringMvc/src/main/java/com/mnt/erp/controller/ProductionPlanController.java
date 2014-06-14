package com.mnt.erp.controller;

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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.ProductionPlan;
import com.mnt.erp.bean.ProductionPlanLine;
import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.productionPlanTypeBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ProductionPlanService;

@Controller
public class ProductionPlanController {
	
	@Autowired ProductionPlanService proPlanService;
	
	@Autowired AuditLogService auditLogService;
	@Autowired
	DateConversionService dateService;
	@Autowired
	MenuService menuService;
	HttpSession session;

	@RequestMapping(value = "/productionPlan", method = RequestMethod.GET)
	public ModelAndView productionPlanHome(
			@ModelAttribute("productionPlanCommand") ProductionPlan productionPlan,
			SessionStatus status,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("productionPlan.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("productionPlanHome", "productionPlanCommand", productionPlan);
	}
	
	/* To Get production Plan Type Id Values */

	@ModelAttribute("productionPlanType")
	public Map<Integer, String> productionPlanTypeIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = proPlanService.selectProductionPlanType();
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
	
	

	/* To Get Plant Id Values */

	@ModelAttribute("plant")
	public Map<Integer, String> plantIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = proPlanService.selectPlant();
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
	

	/* To Get Material Id Values */

	@ModelAttribute("material")
	public Map<Integer, String> materrialIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = proPlanService.selectMaterial();
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
	
	/* To Get Uom Id Values */

	@ModelAttribute("uom")
	public Map<Integer, String> uomIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = proPlanService.selectUom();
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
	
	/* To Get production num Id Values */

	@ModelAttribute("productionOrderNum")
	public Map<Integer, String> productionIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = proPlanService.selectProductionOrderNums();
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
	
	/* To Get Project Id Values */

	@ModelAttribute("project")
	public Map<Integer, String> projectIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = proPlanService.selectProject();
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
	
	
	/* To Get Status Id Values */

	@ModelAttribute("status")
	public Map<Integer, String> statusIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = proPlanService.selectStatus();
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
	@RequestMapping(value = "/productionPlanAdd", method = RequestMethod.POST)
	public String saveProductionPlan(
			@ModelAttribute("productionPlanCommand") ProductionPlan productionPlanAdd,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String res=null;
		List<ProductionPlanLine> productionPlanLine = null;
		ProductionPlanLine producPlanLine=null;
			try { 
				productionPlanAdd.setPlanDate(dateService.dateFormat(dateService.dateParse(productionPlanAdd.getPlanDate(),"au"),"au"));
				String sdatesEdit = productionPlanAdd.getStartDT();
				if(sdatesEdit!=null){
				List<String> sdateslist = Arrays.asList(sdatesEdit.split(","));
				Object[] sdates = sdateslist.toArray();
				
				String materialsedit = productionPlanAdd.getMaterial_Id();
				List<String> materialslist = Arrays.asList(materialsedit.split(","));
				Object[] materialsids = materialslist.toArray();
				
				String edatesEdit = productionPlanAdd.getFinishDT();
				List<String> edateslist = Arrays.asList(edatesEdit.split(","));
				Object[] edates = edateslist.toArray();
				
				String qtyEdit = productionPlanAdd.getQty();
				List<String> qtylist = Arrays.asList(qtyEdit.split(","));
				Object[] qtys = qtylist.toArray();
				
				
				String uomedit = productionPlanAdd.getuOM_Id();
				List<String> uomList = Arrays.asList(uomedit.split(","));
				Object[] uomids = uomList.toArray();
				
			
			
		
				String productionOrderEdit = productionPlanAdd.getProductionOrder_Id();
		
				String[] productionOrderids = productionOrderEdit.split(",");
				
				productionPlanLine = new ArrayList<ProductionPlanLine>();
				for (int i = 0; i < sdates.length; i++) {
				
					producPlanLine = new ProductionPlanLine();
					producPlanLine.setMaterial_Id(materialsids[i].toString());
					
					producPlanLine.setQty(qtys[i].toString());
					
					producPlanLine.setuOM_Id(uomids[i].toString());
					
					producPlanLine.setStartDT(dateService.dateFormat(dateService.dateParse(sdates[i].toString(),"au"),"au"));
					
					producPlanLine.setFinishDT(dateService.dateFormat(dateService.dateParse(edates[i].toString(),"au"),"au"));
					
					if(productionOrderids[i].toString().equals("0"))
					{
						productionPlanAdd.setProductionOrder_Id(null);
						
					}
					else
					{
						producPlanLine.setProductionOrder_Id(productionOrderids[i].toString());
					}
				
					
					productionPlanLine.add(producPlanLine);
			
		
				}
				productionPlanAdd.setProductionPlanLine(productionPlanLine);
		
				} 
				session=request.getSession(false);
				String msg=proPlanService.saveProductionPlanDetails(productionPlanAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if(msg.equals("S")){
					res = "redirect:productionPlan.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:productionPlan.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				res = "redirect:productionPlan.mnt?listwar=" + "fail" + "";
				e.printStackTrace();
							}

		
		return res;

	}
	
	
	@RequestMapping(value = "/productionPlanSearch", method = RequestMethod.GET)
	public ModelAndView searchProductionPlan(
			@ModelAttribute("productionPlanCommand")  ProductionPlan productionPlanSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		List<Object[]> list = null;
		List<ProductionPlan> productionPlanBean = new ArrayList<ProductionPlan>();
		try {
			String dbField = productionPlanSearch.getXmlLabel();
			String operation = productionPlanSearch.getOperations();
			String basicSearchId = productionPlanSearch.getBasicSearchId();

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
				list = proPlanService.searchProductionPlan();
				
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					ProductionPlan productionPlan = new ProductionPlan();
					Object[] obj = (Object[]) iterator.next();
					productionPlan.setProductionPlan_Id((Integer) obj[0]);
					
				
					productionPlanTypeBean productionPlanType=((productionPlanTypeBean) obj[1]);
					productionPlan.setProductionPlanTypeName(productionPlanType.getProductionPlanType());
					productionPlan.setPlanDate(dateService.dateFormat(dateService.dateParse((String) obj[2],"se"),"se"));
					Plant plant=((Plant) obj[3]);
					productionPlan.setPlantName(plant.getPlantName());
					Project project=((Project) obj[4]);
					productionPlan.setProjectName(project.getProjectName());
					Status status=((Status) obj[5]);
					productionPlan.setStatusName(status.getStatus());
				
					
					productionPlanBean.add(productionPlan);
				}

			} else {
				 list = proPlanService.basicSearchProductionPlan(dbField,
						operation, basicSearchId);
				 Iterator<Object[]> iterator = list.iterator();
					while (iterator.hasNext()) {
						ProductionPlan productionPlan = new ProductionPlan();
						Object[] obj = (Object[]) iterator.next();
						productionPlan.setProductionPlan_Id((Integer) obj[0]);
						productionPlanTypeBean productionPlanType=((productionPlanTypeBean) obj[1]);
						productionPlan.setProductionPlanTypeName(productionPlanType.getProductionPlanType());
						productionPlan.setPlanDate(dateService.dateFormat(dateService.dateParse((String) obj[2],"se"),"se"));
						Plant plant=((Plant) obj[3]);
						productionPlan.setPlantName(plant.getPlantName());
						Project project=((Project) obj[4]);
						productionPlan.setProjectName(project.getProjectName());
						Status status=((Status) obj[5]);
						productionPlan.setStatusName(status.getStatus());
					
						
						productionPlanBean.add(productionPlan);

			}
			
			
		
		request.setAttribute("productionPlanBean", productionPlanBean);
			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        
		request.setAttribute("productionPlan", "productionPlan");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("productionPlanHome");
		modelAndView.addObject("productionPlan", productionPlanBean);
		return modelAndView;
	}

	@RequestMapping(value = "/productionPlanEdit", method = RequestMethod.GET)
	public String editProdutionPlan(
			@ModelAttribute("productionPlanCommand") ProductionPlan productionPlanEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ProductionPlan> proPlanEdit = new ArrayList<ProductionPlan>();
		
		List<ProductionPlanLine> productionPlanLinelist = new ArrayList<ProductionPlanLine>();
		int id = Integer.parseInt(request.getParameter("productionPlanId"));

		try {
			List<Object> list = proPlanService.searchProductionPlanWithId(id);
			Iterator<Object> iter = list.iterator();
			while (iter.hasNext()) {
				 Object pobject = iter.next();
				ProductionPlan proplan = (ProductionPlan) pobject;
				productionPlanEdit.setProductionPlan_IdEdit(proplan.getProductionPlan_Id());
				productionPlanEdit.setProductionPlanType_IdEdit(proplan.getProductionPlanType_Id());
				productionPlanEdit.setPlanDateEdit(dateService.dateFormat(dateService.dateParse(proplan.getPlanDate(),"se"),"se"));
				productionPlanEdit.setPlant_IdEdit(proplan.getPlant_Id());
				productionPlanEdit.setProject_IdEdit(proplan.getProject_Id());
				productionPlanEdit.setStatus_IdEdit(proplan.getStatus_Id());
				List<ProductionPlanLine> listEdit = proplan.getProductionPlanLine();
				
				Iterator<ProductionPlanLine> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					ProductionPlanLine rfedit = (ProductionPlanLine) object2;

					ProductionPlanLine rfqlineedit = new ProductionPlanLine();
					
					rfqlineedit.setProductionPlanLine_IdEdit(rfedit.getProductionPlanLine_Id());
					rfqlineedit.setMaterial_IdEdit(rfedit.getMaterial_Id());
					Material material=rfedit.getMaterial();
					rfqlineedit.setMaterialName(material.getMaterialName());
					rfqlineedit.setQtyEdit(rfedit.getQty());
					Uom uom=rfedit.getUom();
					rfqlineedit.setUomName(uom.getUom());
					rfqlineedit.setuOM_IdEdit(rfedit.getuOM_Id());
					rfqlineedit.setStartDTEdit(dateService.dateFormat(dateService.dateParse(rfedit.getStartDT(),"se"),"se"));
					rfqlineedit.setFinishDTEdit(dateService.dateFormat(dateService.dateParse(rfedit.getFinishDT(),"se"),"se"));
					ProductionOrderBean productionOrder = rfedit.getProductionOrder();
					if(productionOrder!=null)
					{
					rfqlineedit.setProductionOrderNumber(productionOrder.getProdOrderNo());
					rfqlineedit.setProductionOrder_IdEdit(rfedit.getProductionOrder_Id());
					}
					else
					{
						rfqlineedit.setProductionOrderNumber("0");
						rfqlineedit.setProductionOrder_IdEdit("0");
					}
									
					
				
					productionPlanLinelist.add(rfqlineedit);
				

				}
				productionPlanEdit.setProductionPlanLine(productionPlanLinelist);
				
				proPlanEdit.add(productionPlanEdit);

			}

			
			request.setAttribute("productionPlanEdit", proPlanEdit);
			request.setAttribute("productionPlanLinelist", productionPlanLinelist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "productionPlanHome";

	}
	
	
	@RequestMapping(value = "/productionPlanUpdate", method = RequestMethod.POST)
	public String productionPlanUpdate(
			@ModelAttribute("productionPlanCommand") ProductionPlan productionPlanUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ProductionPlanLine> productionPlanLine = null;
		ProductionPlanLine producPlanLine=null;
		try{
		productionPlanUpdate.setProductionPlan_Id(productionPlanUpdate.getProductionPlan_IdEdit());
		productionPlanUpdate.setProductionPlanType_Id(productionPlanUpdate.getProductionPlanType_IdEdit());
		productionPlanUpdate.setPlanDate(dateService.dateFormat(dateService.dateParse(productionPlanUpdate.getPlanDateEdit(),"au"),"au"));
		productionPlanUpdate.setPlant_Id(productionPlanUpdate.getPlant_IdEdit());
		productionPlanUpdate.setProject_Id(productionPlanUpdate.getProject_IdEdit());
		productionPlanUpdate.setStatus_Id(productionPlanUpdate.getStatus_IdEdit());
		
		int[] proIdUpdate = productionPlanUpdate.getProductionPlanLine_IdEditt();
		
		String sdatesEdit = productionPlanUpdate.getStartDTEdit();
		if(sdatesEdit!=null){
		List<String> sdateslist = Arrays.asList(sdatesEdit.split(","));
		Object[] sdates = sdateslist.toArray();
		
		String materialsedit = productionPlanUpdate.getMaterial_IdEdit();
		List<String> materialslist = Arrays.asList(materialsedit.split(","));
		Object[] materialsids = materialslist.toArray();
		
		String edatesEdit = productionPlanUpdate.getFinishDTEdit();
		List<String> edateslist = Arrays.asList(edatesEdit.split(","));
		Object[] edates = edateslist.toArray();
		
		String qtyEdit = productionPlanUpdate.getQtyEdit();
		List<String> qtylist = Arrays.asList(qtyEdit.split(","));
		Object[] qtys = qtylist.toArray();
		
		
		String uomedit = productionPlanUpdate.getuOM_IdEdit();
		List<String> uomList = Arrays.asList(uomedit.split(","));
		Object[] uomids = uomList.toArray();
	
		String productionOrderEdit = productionPlanUpdate.getProductionOrder_IdEdit();
		List<String> productionOrderList = Arrays.asList(productionOrderEdit.split(","));
		Object[] productionOrderids = productionOrderList.toArray();
		
		productionPlanLine = new ArrayList<ProductionPlanLine>();
		for (int i = 0; i < materialsids.length; i++) {
		
			producPlanLine = new ProductionPlanLine();
			
			producPlanLine.setMaterial_Id(materialsids[i].toString());
			
			producPlanLine.setQty(qtys[i].toString());
			
			producPlanLine.setuOM_Id(uomids[i].toString());
			
			producPlanLine.setStartDT(dateService.dateFormat(dateService.dateParse(sdates[i].toString(),"au"),"au"));
			
			producPlanLine.setFinishDT(dateService.dateFormat(dateService.dateParse(edates[i].toString(),"au"),"au"));
			
			producPlanLine.setProductionOrder_Id(productionOrderids[i].toString());
			

			int proLineId = proIdUpdate[i];
			String check = "1", check1 = "0";
			String egCheck = request.getParameter(proLineId + "Check");
			
			if (check.equals(egCheck)) {
				
				proPlanService.deleteProductionPlanLine(proLineId);

			}

			if (check1.equals(egCheck) || egCheck == null) {
				
				productionPlanLine.add(producPlanLine);

			}
			
	}
		productionPlanUpdate.setProductionPlanLine(productionPlanLine);
		
       String msg = proPlanService.updateProductionPlan(productionPlanUpdate);
		


				if (msg.equals("S")) {
				
					request.setAttribute("proPlanUpdate","Production Plan has been updated");

				} else {
					
					request.setAttribute("proPlanUpdateError","Production Plan has not been updated");
				}

		}
		}
		catch(Exception e){
			e.printStackTrace();
		}
				return "productionPlanHome";
	}

	@RequestMapping(value = "/productionPlanDelete", method = RequestMethod.GET)
	public ModelAndView deleteProductionPlan(
			@ModelAttribute("productionPlanCommand") ProductionPlan productionPlanDelet,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		int id = Integer.parseInt(request.getParameter("productionPlanId"));

		try {
			String msg = proPlanService.deleteProductionPlan(id);
			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Production Plan","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("prodPlanDelete","Production Plan has been deleted");
				

			} else {
				request.setAttribute("prodPlanDeleteError","Production Plan has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("productionPlanHome", "productionPlanCommand",new ProductionPlan());
	

	}

	}

