/**
 * @Copyright MNTSOFT
 */
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

import com.mnt.erp.bean.SalesAreaBean;
import com.mnt.erp.bean.SalesOrganizationBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.SalesAreaService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 31-10-2013
 */

@Controller
public class SalesAreaController {

	@Autowired
	SalesAreaService salesAreaService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/salesAreaHome", method = RequestMethod.GET)
	public ModelAndView assetHome(
			@ModelAttribute("salesAreaCmd") SalesAreaBean salesAreaBean,
			SessionStatus status, HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("salesAreaHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);


		return new ModelAndView("salesAreaHome", "salesAreaCmd", salesAreaBean);
	}

	@RequestMapping(value = "/salesAreaAdd", method = RequestMethod.POST)
	public String saveSalesArea(
			@ModelAttribute("salesAreaCmd") SalesAreaBean salesBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String salesSave = null;
		HttpSession session=null;
	
		String res=null;
		String salesAreaName = salesBean.getSalesArea();
		SalesAreaBean sBean = (SalesAreaBean) salesBean;
		Long checkAsset = salesAreaService.checkSalesAreaCout(salesAreaName);

		if (checkAsset == 0) {
			try {
				session=request.getSession(false);
			String	msg=salesAreaService.saveSalesAreaDetails(sBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
			
				if(msg.equals("S")){
					
					res="redirect:salesAreaHome.mnt?list="
					+ "success" + "";
					
				}else{
					
					res="redirect:salesAreaHome.mnt?listwar="
					+ "fail" + "";
				}
			

			} catch (Exception e) {
				e.printStackTrace();
				
				res="redirect:salesAreaHome.mnt?listwar="
				+ "fail" + "";
			}
		} else {
			salesBean.setSaId(1);
			request.setAttribute("addsalesDuplicate",
					"Sales Area is Already exists. Please try some other name");

			return "salesAreaHome";

		}

		return res="redirect:salesAreaHome.mnt?list="
				+ "success" + "";

	}

	@ModelAttribute("salesOrgSelect")
	public Map<Integer, String> salesAreaSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> listValues = salesAreaService.selectSalesOrg();
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

	@RequestMapping(value = "/salesAreaSearch", method = RequestMethod.GET)
	public String searchSalesArea(
			@ModelAttribute("salesAreaCmd") SalesAreaBean salesSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<SalesAreaBean> salesAreaBean = new ArrayList<SalesAreaBean>();

		try {
			int id = salesSearch.getEditSalesAreaId();
			String dbField = salesSearch.getXmlLabel();
			String operation = salesSearch.getOperations();
			String basicSearchId = salesSearch.getBasicSearchId();

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

				list = salesAreaService.searchSalesArea();

			} else {

				list = salesAreaService.basicSearchSalesArea(dbField,
						operation, basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				SalesAreaBean sab = new SalesAreaBean();
				Object[] obj = (Object[]) iterator.next();
				sab.setSalesAreaId((Integer) obj[0]);
				sab.setSalesArea((String) obj[1]);
				SalesOrganizationBean sOrg = ((SalesOrganizationBean) obj[2]);
				sab.setSalesOrgName(sOrg.getSalesorganization());
				salesAreaBean.add(sab);
			}
			request.setAttribute("salesAreaBean", salesAreaBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "salesAreaHome";

	}

	@RequestMapping(value = "/salesAreaEdit", method = RequestMethod.GET)
	public String salesAreaEdit(
			@ModelAttribute("salesAreaCmd") SalesAreaBean salesEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("salesAreaId"));
		List<Object[]> list = null;
		List<SalesAreaBean> salesAreaBean = new ArrayList<SalesAreaBean>();
		try {
			list = salesAreaService.searchSalesAreaWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				salesEdit.setEditSalesAreaId((Integer) obj[0]);
				salesEdit.setEditSalesArea((String) obj[1]);
				salesEdit.setEditSalesOrgId((String) obj[2]);
				salesAreaBean.add(salesEdit);
			}
			request.setAttribute("salesAreaEdit", salesAreaBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "salesAreaHome";

	}

	@RequestMapping(value = "/salesAreaUpdate", method = RequestMethod.POST)
	public String salesAreaUpdate(
			@ModelAttribute("salesAreaCmd") SalesAreaBean salesUpdate,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		String salesUpadted = null;

		String salesName = salesUpdate.getEditSalesArea();
		int salesId = salesUpdate.getEditSalesAreaId();
		String salesOrg = salesUpdate.getEditSalesOrgId();

		salesUpdate.setSalesArea(salesUpdate.getEditSalesArea());
		salesUpdate.setSalesAreaId(salesUpdate.getEditSalesAreaId());
		salesUpdate.setSalesOrgId(salesUpdate.getEditSalesOrgId());
		Long checkUpdate = salesAreaService.updateCheckSalesArea(salesName,
				salesId);

		if (checkUpdate == 0) {

			try {

				String msg = salesAreaService.updateSalesArea(salesUpdate);

				if (msg.equals("S")) {
					salesUpadted = "Sales Area Data Updated Successfully";
					request.setAttribute("salesUpdated", "Sales Area Data Updated Successfully");

				} else {
					salesUpadted = "Sales Area Data Updation Failed";
					request.setAttribute("salesUpdateErr", "Sales Area Data doesn't updated properly");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			request.setAttribute("updateSalesAreaDuplicate",
					"Sales Area is Already exists. Please try some other name");
			request.setAttribute("salesAreaEdit", "salesAreaEdit");
			

		}
		model.addAttribute("salesAreaCmd",new SalesAreaBean());
		return "salesAreaHome";
	}

	@RequestMapping(value = "/salesAreaDelete", method = RequestMethod.GET)
	public String salesAreaDelete(
			@ModelAttribute("salesAreaCmd") SalesAreaBean salesDelete,
			HttpServletRequest request, HttpServletResponse response,Model model) {

		response.setCharacterEncoding("UTF-8");
		String salesDeleted = null;
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("salesAreaId"));
		try {

			String msg = salesAreaService.deleteSalesArea(id);

			if (msg == "S") {

				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Salesarea","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				salesDeleted = "Sales Area Data Deleted Successfully";
				request.setAttribute("salesdel", "Sales Area Data Deleted Successfully");
			} else {

				salesDeleted = "Sales Area Data Not Deleted";
				request.setAttribute("salesdelerr", "Sales Area Data doesn't deleted properly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("salesAreaCmd",new SalesAreaBean());
		return "salesAreaHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "salesAreaId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
