package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
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
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import com.mnt.erp.bean.AssetGroup;
import com.mnt.erp.service.AssetGroupService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author ybusireddy
 * @version 20-09-2013
 */

@Controller
public class AssetGroupController {

	@Autowired
	AssetGroupService assetGroupService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/assetGroupHome", method = RequestMethod.GET)
	@RequestScoped
	public String getAssetGroupHome(@ModelAttribute AssetGroup assetGroup,
			SessionStatus status, HttpServletResponse response, Model model,HttpServletRequest request) {
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("assetGroupHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		model.addAttribute("industry", assetGroup);
		return "assetGroupHome";
	}

	@RequestMapping(value = "/addAssetGroup", method = RequestMethod.POST)
	@RequestScoped
	public String saveAssetGroup(@ModelAttribute AssetGroup assetGroup,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {

		String isa = null;
		String assetGroupSave,res = null;
        HttpSession session=null;
		String assetGroupType = assetGroup.getAssetGroupType();
		int checkType = assetGroupService.checkAssetGroupType(assetGroupType);

		if (checkType == 0) {
			try {
				session=request.getSession(false);
				isa = assetGroupService.saveAssetGroupDetails(assetGroup,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				

				if (isa.equals("S")) {
					Date date = new Date();
					String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"A","assetGroup","ROW" ,String.valueOf(assetGroup.getAssetGroupId()),"1",modifiedDate,session.getAttribute("userName").toString());
					res = "redirect:assetGroupHome.mnt?list=" + "success" + "";
					
				} else {
					res = "redirect:assetGroupHome.mnt?listwar=" + "fail" + "";
				}
			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:assetGroupHome.mnt?listwar=" + "fail" + "";
			}
			
		} else {
			request.setAttribute("addAssetGroupDuplicate",
					"AssetGroupType Already Exists Choose Another One");
			assetGroup.setAid(1);
			return "assetGroupHome";
		}
		return "redirect:assetGroupHome.mnt?list=" + "success" + "";
	}

	@ModelAttribute("assetGroupType")
	public Map<Integer, String> getAssertGroupType() {
		Map<Integer, String> map = new Hashtable<Integer, String>();
		List<Object[]> list = null;
		try {
			list = assetGroupService.selectAssetGroup();
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objs = (Object[]) iterator.next();
				map.put((Integer) objs[0], (String) objs[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	@RequestMapping(value = "/searchAssetGroup", method = RequestMethod.GET)
	@RequestScoped
	public String searchAssetGroupType(@ModelAttribute AssetGroup assetGroup,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {

		List<Object[]> list = null;
		int searchAssetGroupId = assetGroup.getAssetGroupId();
		List<AssetGroup> assetGroupSearch = null;
		String dbField = assetGroup.getXmlLabel();
		String operation = assetGroup.getOperations();
		String basicSearchId = assetGroup.getBasicSearchId();

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

		if (basicSearchId != "") {

			try {
				assetGroupSearch = new ArrayList<AssetGroup>();
				// list =
				// assetGroupService.searchAssetGroupWithId(searchAssetGroupId);

				list = assetGroupService.basicSearchAssetGroup(dbField,
						operation, basicSearchId);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					AssetGroup assetGroup2 = new AssetGroup();
					Object[] objs = (Object[]) iterator.next();
					assetGroup2.setAssetGroupId((Integer) objs[0]);
					assetGroup2.setAssetGroupType((String) objs[1]);
					assetGroupSearch.add(assetGroup2);
				}

				request.setAttribute("assetGroupSearch", assetGroupSearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "assetGroupHome";
		} else {

			try {
				assetGroupSearch = new ArrayList<AssetGroup>();
				list = assetGroupService.searchAssetGroup();

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					AssetGroup assetGroup2 = new AssetGroup();
					Object[] objs = (Object[]) iterator.next();
					assetGroup2.setAssetGroupId((Integer) objs[0]);
					assetGroup2.setAssetGroupType((String) objs[1]);
					assetGroupSearch.add(assetGroup2);
				}

				request.setAttribute("assetGroupSearch", assetGroupSearch);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "assetGroupHome";

		}
	}

	@RequestMapping(value = "/assetGroupEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String assetGroupEdit(@ModelAttribute AssetGroup assetGroupDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		int id = Integer.parseInt(request.getParameter("assetGroupIdEdit"));

		List<Object[]> list = null;
		Object[] object = null;

		List<AssetGroup> assetGroupList = new ArrayList<AssetGroup>();

		try {

			list = assetGroupService.searchAssetGroupWithId(id);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				assetGroupDisplay.setAssetGroupIdEdit((Integer) object[0]);
				assetGroupDisplay.setAssetGroupTypeEdit((String) object[1]);
				assetGroupList.add(assetGroupDisplay);
			}
			request.setAttribute("assetGroupValues", assetGroupList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}

		return "assetGroupHome";

	}

	@RequestMapping(value = "/assetGroupUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateAssetGroup(@ModelAttribute AssetGroup assetGroup,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {

		String isa = null;
		String assetGroupUpdate = null;

		int assetGroupId = assetGroup.getAssetGroupIdEdit();
		String assetGroupType = assetGroup.getAssetGroupTypeEdit();

		assetGroup.setAssetGroupId(assetGroupId);
		assetGroup.setAssetGroupType(assetGroupType);
		int checkAssetGroup = assetGroupService.updateCheckAssetGroupType(
				assetGroupType, assetGroupId);
		if (checkAssetGroup == 0) {
			try {
				isa = assetGroupService.updateAssetGroup(assetGroup);
				if(isa.equals("S"))
					request.setAttribute("assetGroupUpdate", "AssetGroup Details Updated Successfully");
				else
					request.setAttribute("assetGroupUpdateErr", "AssetGroup Details Doesn't updated properly");
				
			}

			catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			request.setAttribute("updateAssetGroupDuplicate",
					"Asset Group Type Already Exists Choose Another One");
			request.setAttribute("assetGroupValues", "assetGroupValues");
			return "assetGroupHome";
		}
		model.addAttribute("assetGroup", new AssetGroup());
		return "assetGroupHome";
	}

	@RequestMapping(value = "/assetGroupDelete", method = RequestMethod.GET)
	public String deleteAssetGroup(@ModelAttribute AssetGroup assetGroup,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("assetGroupIdDelete"));
		String isa = null;
		HttpSession session=null;
		try {
			isa = assetGroupService.deleteAssetGroup(id);
			session=request.getSession(false);
			Date date = new Date();
		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","assertGroup","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
		if(isa.equals("S"))
			request.setAttribute("assetGroupDel", "Asset Group deleted successfully");
		else
			request.setAttribute("assetGroupDelErr", "Asset Group doesn't deleted properly");
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("assetGroup", new AssetGroup());
		return "assetGroupHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "assetGroupId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
