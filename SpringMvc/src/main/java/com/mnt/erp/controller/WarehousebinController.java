package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.StorageSectionBean;
import com.mnt.erp.bean.StorageType;
import com.mnt.erp.bean.WarehouseBinType;
import com.mnt.erp.bean.Warehousebin;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.Warehousebinservice;
import com.mnt.erp.service.XmlLabelsService;
@Controller
public class WarehousebinController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	@Autowired
	Warehousebinservice wbservice;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/warhousebinHome", method = RequestMethod.GET)
	public String getWareHousebin(
			@ModelAttribute Warehousebin whbean,
			SessionStatus status, Model model,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
       
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("warhousebinHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		
		model.addAttribute("WHB", new Warehousebin());

		return "warhousebinHome";
	}

	
	@ModelAttribute("StorageType")
	public Map<Integer, String> populateStorageType() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = wbservice.selectstoragetype();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@ModelAttribute("whbtype")
	public Map<Integer, String> populatewhbType() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = wbservice.selectWareHouseBinTypeIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@ModelAttribute("StorageSection")
	public Map<Integer, String> populateStorageSection() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = wbservice.selectStorageSectionIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value = "/savewhb", method = RequestMethod.POST)
	@RequestScoped
	public String saveWareHouseBin(
			@ModelAttribute("WHB") Warehousebin whBean,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request,HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		String mess = null;
		String res=null;
		try {
				session=request.getSession(false);
				mess = wbservice.saveWareHouseBin(whBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (mess.equals("S")) {
					
					res = "redirect:warhousebinHome.mnt?list=" + "success" + "";
				}
				else{
					
					res = "redirect:warhousebinHome.mnt?listwar=" + "fail" + "";
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	@RequestMapping(value = "/searchwhb", method = RequestMethod.GET)
	public String searchwhb(
			@ModelAttribute("WHB") Warehousebin whBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<Warehousebin> wbBeans = new ArrayList<Warehousebin>();
			String dbField = whBean.getXmlLabel();
			String operation = whBean.getOperations();
			String basicSearchId = whBean.getBasicSearchId();

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

				list = wbservice.searchWareHouseBin();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Warehousebin whb = new Warehousebin();
					whb.setWarehousebinId((Integer) obj[0]);
					StorageType st=(StorageType)obj[1];
					whb.setStoragetypeId(st.getStoragetype());
					WarehouseBinType ca=(WarehouseBinType)obj[2];
					whb.setWhbtypeid(ca.getWarehousebintype());
					whb.setWhbno((String)obj[3]);
					whb.setWhbname((String)obj[4]);
					StorageSectionBean ssb=(StorageSectionBean)obj[5];
					whb.setStoragesectionId(ssb.getStorageSection());
					wbBeans.add(whb);
				}

			} else {

				// list = accountgroupservice.searchAccountGroupsWithId(iid);
				list = wbservice.basicSearchWareHouseBin(dbField,
						operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Warehousebin whb = new Warehousebin();
					whb.setWarehousebinId((Integer) obj[0]);
					StorageType st=(StorageType)obj[1];
					whb.setStoragetypeId(st.getStoragetype());
					WarehouseBinType ca=(WarehouseBinType)obj[2];
					whb.setWhbtypeid(ca.getWarehousebintype());
					whb.setWhbno((String)obj[3]);
					whb.setWhbname((String)obj[4]);
					StorageSectionBean ssb=(StorageSectionBean)obj[5];
					whb.setStoragesectionId(ssb.getStorageSection());
					wbBeans.add(whb);
				}

			}
			request.setAttribute("wbBeans", wbBeans);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "warhousebinHome";
	}

	
	@RequestMapping(value = "/whbEdit", method = RequestMethod.GET)
	public String editwhb(
			@ModelAttribute("WHB") Warehousebin whbean,
			HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("whbedit"));

		try {
			List<Warehousebin> whbeans = new ArrayList<Warehousebin>();
			list = wbservice.searchWareHouseBinWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				whbean.setWarehousebinId((Integer) obj[0]);
				whbean.setStoragetypeId((String) obj[1]);
				whbean.setWhbtypeid((String) obj[2]);
				whbean.setWhbno((String) obj[3]);
				whbean.setWhbname((String) obj[4]);
				whbean.setStoragesectionId((String) obj[5]);
				whbeans.add(whbean);
			}
			request.setAttribute("editvalues", whbeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "warhousebinHome";

	}

	@RequestMapping(value = "/whbUpdate", method = RequestMethod.POST)
	public String updatewhb(
			@ModelAttribute("WHB") Warehousebin whBean,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			whBean.setWarehousebinId(whBean.getWarehousebinId());
			whBean.setWhbtypeid(whBean.getWhbtypeid());
			whBean.setStoragetypeId(whBean.getStoragetypeId());
			whBean.setWhbno(whBean.getWhbno());
			whBean.setWhbname(whBean.getWhbname());
			whBean.setStoragesectionId(whBean.getStoragesectionId());
				String message = wbservice.updateWareHouseBin(whBean);
				if (message.equals("S")) {
					request.setAttribute("whUpdate","Warehouse Bin has been updated");
				}
				else{
					request.setAttribute("whUpdateError","Warehouse Bin has not been updated");
				}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "warhousebinHome";
	}

	@RequestMapping(value = "/whbDelete", method = RequestMethod.GET)
	public ModelAndView whbDelete(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session=null;
		try {
			id = Integer.parseInt(request.getParameter("whbdelete"));

			String msg = wbservice.deleteWareHouseBin(id);
			if (msg.equals("S")){
				request.setAttribute("wbdelete","Ware House Bin has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Ware House Bin","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else{
				request.setAttribute("whbDeleteError","Ware House Bin has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("warhousebinHome", "WHB",
				new Warehousebin());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "warehousebinId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
