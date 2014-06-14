package com.mnt.erp.controller;

/*
 @author Srinivas
 @version 1.0   
 */
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
import javax.validation.Valid;
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
import com.mnt.erp.bean.CountrysList;
import com.mnt.erp.bean.HouseBankBean;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.HouseBankService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class HouseBankController {

	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	@Autowired
	HouseBankService hbservice;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/housebankhome", method = RequestMethod.GET)
	public String getHouseBank(
			@ModelAttribute HouseBankBean hbean,
			SessionStatus status, Model model,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
	
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("housebankhome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		
		
		model.addAttribute("HOUSEBANK", new HouseBankBean());

		return "housebankhome";
	}

	@RequestMapping(value = "/saveHouseBank", method = RequestMethod.POST)
	public String saveHouseBank(
			@ModelAttribute("HOUSEBANK") @Valid HouseBankBean hbbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		String msg = null;
		String hbsuccessdup = null;
		String res=null;
		String name = hbbean.getBankcode();
		HttpSession session=null;
		Long id = 0L;
		try {
			id = hbservice.getHouseBankCountService(name);
			if (id == 0) {
				session=request.getSession(false);
				msg = hbservice.saveHouseBankService(hbbean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if (msg.equals("S")) {
					res = "redirect:housebankhome.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:housebankhome.mnt?listwar=" + "fail" + "";
				}
			}

			else {
				hbsuccessdup = "Warning ! Bank Code is already exists. Please try some other name ";
				hbbean.setHousebankhide(1);
				request.setAttribute("hbsuccessdup",hbsuccessdup);
				return "housebankhome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}
	@ModelAttribute("orgid")
	public Map<Integer, String> populateRfqType() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = hbservice.selectOrgidService();
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

	@ModelAttribute("countrylist")
	public Map<Integer, String> populateItemCategoryids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = hbservice.selectCountryidService();
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

	@ModelAttribute("hbSearch")
	public Map<Integer, String> populateHousebank() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = hbservice.selectHouseBankIdsService();
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

	@RequestMapping(value = "/searchHousebank", method = RequestMethod.GET)
	public String searchInspectionMethodIds(
			@ModelAttribute("HOUSEBANK") HouseBankBean hbbean,BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<HouseBankBean> hbbeans = new ArrayList<HouseBankBean>();
			String dbField = hbbean.getXmlLabel();
			String operation = hbbean.getOperations();
			String basicSearchId = hbbean.getBasicSearchId();

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
				list = hbservice.searchHouseBankService();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					HouseBankBean hbBean2 = new HouseBankBean();
					hbBean2.setBankid((Integer) obj[0]);
					Organization org=(Organization)obj[1];
					hbBean2.setOrgid(org.getOrgName());
					hbBean2.setBankcode((String)obj[2]);
					hbBean2.setBankname((String)obj[3]);
					hbBean2.setBranchname((String)obj[4]);
					hbBean2.setAddress((String)obj[5]);
					hbBean2.setCity((String)obj[6]);
					hbBean2.setState((String)obj[7]);
					CountrysList cl=(CountrysList)obj[8];
					hbBean2.setCountry(cl.getCountryName());
					hbBean2.setSwiftcode((String)obj[9]);
					hbBean2.setIfsccode((String)obj[10]);
					hbbeans.add(hbBean2);

				}

			} else {

				// list =
				// inspectionservice.searchInspectionMethodServiceWithId(iid);
				list = hbservice.basicSearchHouseBankService(dbField, operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					HouseBankBean hbBean2 = new HouseBankBean();
					hbBean2.setBankid((Integer) obj[0]);
					Organization org=(Organization)obj[1];
					hbBean2.setOrgid(org.getOrgName());
					hbBean2.setBankcode((String)obj[2]);
					hbBean2.setBankname((String)obj[3]);
					hbBean2.setBranchname((String)obj[4]);
					hbBean2.setAddress((String)obj[5]);
					hbBean2.setCity((String)obj[6]);
					hbBean2.setState((String)obj[7]);
					CountrysList cl=(CountrysList)obj[8];
					hbBean2.setCountry(cl.getCountryName());
					hbBean2.setSwiftcode((String)obj[9]);
					hbBean2.setIfsccode((String)obj[10]);
					hbbeans.add(hbBean2);
				}
			}
			request.setAttribute("HBBeans", hbbeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "housebankhome";
	}

	@RequestMapping(value = "/housebankEdit", method = RequestMethod.GET)
	public String edithousebank(
			@ModelAttribute("HOUSEBANK") HouseBankBean  Bean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		List<HouseBankBean> hblist=new ArrayList<HouseBankBean>();
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("hbedit"));

		try {
			List<HouseBankBean> hbbeans = new ArrayList<HouseBankBean>();
			hblist = hbservice.EditHousebankservice(id);
			Iterator<HouseBankBean> iterator = hblist.iterator();
			while (iterator.hasNext()) {
				Object object = iterator.next();
				HouseBankBean hb = (HouseBankBean) object;
				Bean.setBankidedit( hb.getBankid());
			    Bean.setOrgidedit( hb.getOrgid());
				Bean.setBankcodeedit( hb.getBankcode());
				Bean.setBanknameedit( hb.getBankname());
				Bean.setBranchnameedit( hb.getBranchname());
				Bean.setAddressedit( hb.getAddress());
				Bean.setCityedit( hb.getCity());
				Bean.setStateedit( hb.getState());
				Bean.setCountryedit( hb.getCountry());
				Bean.setSwiftcodeedit( hb.getSwiftcode());
				Bean.setIfsccodeedit( hb.getIfsccode());
				hbbeans.add(Bean);
			}
			request.setAttribute("editvalues", hbbeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "housebankhome";

	}

	@RequestMapping(value = "/houseBankUpdate", method = RequestMethod.POST)
	public String updateHouseBank(
			@ModelAttribute("HOUSEBANK") HouseBankBean hbb,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = hbb.getBankcodeedit();
		int imid = hbb.getBankidedit();
		Long iid = 0l;
		String hbuccessdupedit = null;
		try {
			iid = hbservice.getHouseBankCounteditService(name, imid);
			if (iid == 0) {
				hbb.setBankid(hbb.getBankidedit());
				hbb.setOrgid(hbb.getOrgidedit());
				hbb.setBankcode(hbb.getBankcodeedit());
				hbb.setBankname(hbb.getBanknameedit());
				hbb.setBranchname(hbb.getBranchnameedit());
				hbb.setAddress(hbb.getAddressedit());
				hbb.setCity(hbb.getCityedit());
				hbb.setState(hbb.getStateedit());
				hbb.setCountry(hbb.getCountryedit());
				hbb.setSwiftcode(hbb.getSwiftcodeedit());
				hbb.setIfsccode(hbb.getIfsccodeedit());

				String message = hbservice.updateHouseBankService(hbb);
				if (message.equals("S")) {
					request.setAttribute("hbupdate",
							"House Bank has been updated");
				}
				else{
					request.setAttribute("hbupdateError",
							"House Bank has not been updated");
					
				}
			} else {
				hbuccessdupedit = "Warning ! Bank Code is already exists. Please try some other name ";
				hbb.setHousebankhideedit(1);
				request.setAttribute("hbdupedit",hbuccessdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "housebankhome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "housebankhome";
	}

	@RequestMapping(value = "/housebankDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView HouseBankDelete(
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("housedelete"));
			String msg= hbservice.deleteHouseBankService(id);
			if (msg.equals("S")){
				request.setAttribute("bankDeleted","House Bank has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","House Bank","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
			}
			else{
				request.setAttribute("bankDeletedError","House Bank has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("housebankhome", "HOUSEBANK",
				new HouseBankBean());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "bankid";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
