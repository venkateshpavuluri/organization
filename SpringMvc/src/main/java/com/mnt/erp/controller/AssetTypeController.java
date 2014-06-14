/*
 * @Copyright MNTSOFT
 * 
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

import com.mnt.erp.bean.AssertTypeBean;
import com.mnt.erp.service.AssertTypeService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 18-09-2013
 */

@Controller
public class AssetTypeController {
	@Autowired
	AssertTypeService assertService;
	
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/assertTypeHome", method = RequestMethod.GET)
	public ModelAndView assetHome(
			@ModelAttribute("assertTypeAdd") AssertTypeBean asstBean,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("assertTypeHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		return new ModelAndView("assertTypeHome", "assertTypeAdd", asstBean);
	}

	@RequestMapping(value = "/assertTypeAdd", method = RequestMethod.POST)
	public String saveAssetType(
			@ModelAttribute("assertTypeAdd") AssertTypeBean asstBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String assetSave,msg,res = null;
		HttpSession session=null;
		String assrt = asstBean.getAssertTypeName();
		AssertTypeBean aBean = (AssertTypeBean) asstBean;
		Long checkAsset = assertService.checkAssetTypeCout(assrt);

		if (checkAsset == 0) {
			try {
				session=request.getSession(false);
				msg=assertService.saveAssertTypeDetails(aBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if(msg.equals("S"))
					res = "redirect:assertTypeHome.mnt?list=" + "success" + "";
				else
					res = "redirect:assertTypeHome.mnt?listwar=" + "fail" + "";
			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:assertTypeHome.mnt?listwar=" + "fail" + "";
				
			}
		} else {
			asstBean.setAtId(1);
			request.setAttribute("addAssetTypeDuplicate",
					"Asset Type is already exists. Please try some other name");

			return "assertTypeHome";

		}

		return "redirect:assertTypeHome.mnt?list=" + "success" + "";

	}

	@ModelAttribute("assetTypeSelect")
	public Map<Integer, String> assetSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> listValues = assertService.selectAssetType();
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

	@RequestMapping(value = "/assetTypeSearch", method = RequestMethod.GET)
	public String searchAssetType(
			@ModelAttribute("assertTypeAdd") AssertTypeBean assetSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<AssertTypeBean> assetTypeBean = new ArrayList<AssertTypeBean>();

		try {
			int id = assetSearch.getAssertTypeId();
			String dbField = assetSearch.getXmlLabel();
			String operation = assetSearch.getOperations();
			String basicSearchId = assetSearch.getBasicSearchId();

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
				list = assertService.searchAssertType();

			} else {
				list = assertService.basicSearchAssertType(dbField, operation,
						basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				AssertTypeBean ab = new AssertTypeBean();
				Object[] obj = (Object[]) iterator.next();
				ab.setAssertTypeId((Integer) obj[0]);
				ab.setAssertTypeName((String) obj[1]);
				assetTypeBean.add(ab);
			}

			request.setAttribute("assetTypeBean", assetTypeBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "assertTypeHome";

	}

	@RequestMapping(value = "/assetTypeEdit", method = RequestMethod.GET)
	public String assetTypeEdit(
			@ModelAttribute("assertTypeAdd") AssertTypeBean assetEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("assetTypeId"));
		List<Object[]> list = null;
		List<AssertTypeBean> assetTypeBean = new ArrayList<AssertTypeBean>();
		try {
			list = assertService.searchAssertTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				assetEdit.setAssertTypeEditId((Integer) obj[0]);
				assetEdit.setAssertTypeEditName((String) obj[1]);
				assetTypeBean.add(assetEdit);
			}
			request.setAttribute("assetTypeEdit", assetTypeBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "assertTypeHome";

	}

	@RequestMapping(value = "/assetTypeUpdate", method = RequestMethod.POST)
	public String assetTypeUpdate(
			@ModelAttribute("assertTypeAdd") AssertTypeBean assetUpdate,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		String assetUpadted = null;

		String assetType = assetUpdate.getAssertTypeEditName();
		int assetId = assetUpdate.getAssertTypeEditId();

		assetUpdate.setAssertTypeId(assetId);
		assetUpdate.setAssertTypeName(assetType);
		Long checkUpdate = assertService.updateCheckAssetType(assetType,
				assetId);
		if (checkUpdate == 0) {

			try {

				String msg = assertService.updateAssertType(assetUpdate);

				if (msg.equals("S")) {
					request.setAttribute("assertTypeUpdate", "Asset Type Data Updated Successfully");
					

				} else {
					request.setAttribute("assertTypeUpdateErr", "Asset Type Data Doesn't updated properly");
				}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("assertTypeUpdateErr", "Asset Type Data Doesn't updated properly");
				
			}

		} else {

			request.setAttribute("updateAssetTypeDuplicate",
					"Asset Type is already exists. Please try some other name");
			request.setAttribute("assetTypeEdit", "assetTypeEdit");
			return "assertTypeHome";

		}
		model.addAttribute("assertTypeAdd", new AssertTypeBean());
		return "assertTypeHome";
	}

	@RequestMapping(value = "/assetTypeDelete", method = RequestMethod.GET)
	public String assetTypeDelete(
			@ModelAttribute("assertTypeAdd") AssertTypeBean assetDelete,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		String assetDeleted = null;
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("assetTypeId"));
		try {

			String msg = assertService.deleteAssertType(id);
			if (msg == "S") {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","assertType","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("assertDel",  "Asset Type Data Deleted Successfully");
				
			} else {

				request.setAttribute("assertDelErr",  "Asset Type Data Doesn't deleted properly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("assertTypeAdd", new AssertTypeBean());
		return "assertTypeHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "assetId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
