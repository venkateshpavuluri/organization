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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Shop;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PlantService;
import com.mnt.erp.service.ShopService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class ShopController {

	@Autowired
	ShopService shopservice;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	PlantService plantService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	
	@RequestMapping(value = "/ShopHome", method = RequestMethod.GET)
	public ModelAndView shopHome(
			@ModelAttribute("shopCommand") Shop shop,
			SessionStatus status,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("ShopHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("shopHome", "shopCommand", shop);
	}
	
	/* To Get Plant Id Values */
	@ModelAttribute("plant")
	public Map<Integer, String> plantIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = plantService.getPlantIds();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	
	
@RequestMapping(value = "/shopAdd", method = RequestMethod.POST)
	public String saveShop(
			@ModelAttribute("shopCommand") Shop shopAdd,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		String res=null;
		String shopName=shopAdd.getShopName();
		Long shopCheck=shopservice.checkShopCout(shopName);
		int shopId=shopAdd.getShop_Id();
		if(shopCheck==0){
			try {
                String plant=shopAdd.getPlant_Id();
               
                if(plant.equals("0")){
                	shopAdd.setPlant_Id(null);
                }
				String msg=shopservice.saveShopDetails(shopAdd);
				
				if(msg=="S"){
					session=request.getSession(false);
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","Shop","ROW" ,String.valueOf(shopId),"1",modifiedDate,session.getAttribute("userName").toString());		
					res = "redirect:ShopHome.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:ShopHome.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
		else{
			shopAdd.setAid(1);
			request.setAttribute("shopAddDuplicateCheck","Shop Name already exists");
			return "shopHome";
		}

		return res;

	}



	@RequestMapping(value = "/shopSearch", method = RequestMethod.GET)
	public ModelAndView searchShop(
			@ModelAttribute("shopCommand") Shop shopSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<Shop> shopBean = new ArrayList<Shop>();

		try {

			String dbField = shopSearch.getXmlLabel();
			String operation = shopSearch.getOperations();
			String basicSearchId = shopSearch.getBasicSearchId();

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
				list = shopservice.searchShop();

			} else {
				list = shopservice.basicSearchShop(dbField, operation, basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Shop shoSearch = new Shop();
				Object[] obj = (Object[]) iterator.next();
				shoSearch.setShop_Id((Integer) obj[0]);
				shoSearch.setShopCode((String) obj[1]);
				shoSearch.setShopName((String) obj[2]);
				shoSearch.setDescription((String) obj[3]);
				shoSearch.setPlant_Id((String) obj[4]);
				
				shopBean.add(shoSearch);
			}

			request.setAttribute("ShopBean", shopBean);
			request.setAttribute("shopSearchvalues", "shopSearchvalues");

		} catch (Exception e) {
			e.printStackTrace();
		}
        
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("shopHome");
	    modelAndView.addObject("Shop",shopBean);
		return modelAndView;
		

	}
	
	@RequestMapping(value = "/ShopEdit", method = RequestMethod.GET)
	public String assetTypeEdit(
			@ModelAttribute("shopCommand") Shop shopEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		int id = Integer.parseInt(request.getParameter("shopId"));
		
		List<Object[]> list = null;
		List<Shop> shopEditBean = new ArrayList<Shop>();
		try {
			list = shopservice.searchShopWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				shopEdit.setShop_IdEdit((Integer) obj[0]);
				shopEdit.setShopCodeEdit((String) obj[1]);
				shopEdit.setShopNameEdit((String) obj[2]);
				shopEdit.setDescriptionEdit((String) obj[3]);
				shopEdit.setPlant_IdEdit((String) obj[4]);
				
				shopEditBean.add(shopEdit);
			}
			request.setAttribute("shopEdit", shopEditBean);
			request.setAttribute("shopEditValues", "shopEditValues");

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "shopHome";

	}

	@RequestMapping(value = "/shopUpdate", method = RequestMethod.POST)
	public String shopUpdate(
			@ModelAttribute("shopCommand") Shop shopUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String shop=shopUpdate.getShopNameEdit();
		int shopId=shopUpdate.getShop_IdEdit();
		
		Long shopCheck=shopservice.updateCheckShop(shop, shopId);
		if(shopCheck==0){
		shopUpdate.setShop_Id(shopUpdate.getShop_IdEdit());
		shopUpdate.setShopCode(shopUpdate.getShopCodeEdit());
		shopUpdate.setShopName(shopUpdate.getShopNameEdit());
		shopUpdate.setDescription(shopUpdate.getDescriptionEdit());
		String plant=shopUpdate.getPlant_IdEdit();
		
		if(plant.equals("0")){
			shopUpdate.setPlant_Id(null);
		}else{
		shopUpdate.setPlant_Id(shopUpdate.getPlant_IdEdit());
		}


			try {

				String msg =shopservice.updateShop(shopUpdate);

				if (msg.equals("S")) {
					
					request.setAttribute("shopUpdate","Shop has been updated");
				} else {
					request.setAttribute("shopUpdateError", "Shop has not been updated");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else{
			request.setAttribute("shopEditValues", "shopEditValues");
			request.setAttribute("shopUpdateCheck", "Shop is already exists");
			
			return "shopHome";
		}
	 
		return "shopHome";
	}

	@RequestMapping(value = "/ShopDelete", method = RequestMethod.GET)
	public ModelAndView shopDelete(
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("shopId"));
		try {

			String msg = shopservice.deleteShop(id);
			if (msg == "S") {

				request.setAttribute("shopDelete","Shop has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Shop","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			} else {

				request.setAttribute("shopDeleteError","Shop has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("shopHome", "shopCommand",
				new Shop());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "shopId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
