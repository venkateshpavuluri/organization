/**
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.ConditionBean;
import com.mnt.erp.bean.ConditionType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.ConditionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author madhav
 *
 */
@Controller
@Scope("request")
public class ConditionController {
	
	@Autowired
	ConditionService conditionService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	
	@RequestMapping(value = "/conditionHome", method = RequestMethod.GET)
	public ModelAndView conditionHome(
			@ModelAttribute("conditionCmd") ConditionBean conditionBean,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("conditionHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		return new ModelAndView("conditionHome", "conditionCmd", conditionBean);
		
		
	}
	
	@RequestMapping(value = "/conditionAdd", method = RequestMethod.POST)
	public String saveCondition(
			@ModelAttribute("conditionCmd") ConditionBean conditionBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String condSave = null;
		HttpSession session=null;
		String msg,res=null;
		String condition = conditionBean.getCondition();
		ConditionBean cBean = (ConditionBean) conditionBean;
		Long checkAsset = conditionService.addCheckConditionType(condition);

		if (checkAsset == 0) {
			try {
				session=request.getSession(false);
				msg=conditionService.saveCondition(cBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if(msg.equals("S"))
					res = "redirect:conditionHome.mnt?list=" + "success" + "";

			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:conditionHome.mnt?listwar=" + "fail" + "";
			}
		} else {
			conditionBean.setcId(1);
			request.setAttribute("addConditionDuplicate",
					"Condition Already Exists Choose Another One");

			return "conditionHome";

		}

		return  "redirect:conditionHome.mnt?list=" + "success" + "";

	}
	
	@ModelAttribute("conditionTypeSelect")
	public Map<Integer, String> conditionTypeSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			List<Object[]> listValues = conditionService.selectConditionType();
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
	
	@RequestMapping(value = "/conditionSearch", method = RequestMethod.GET)
	public String searchcondition(
			@ModelAttribute("conditionCmd") ConditionBean conditionSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<ConditionBean> conditionBean = new ArrayList<ConditionBean>();

		try {
			int id = conditionSearch.getConditionIdEdit();
			String dbField = conditionSearch.getXmlLabel();
			String operation = conditionSearch.getOperations();
			String basicSearchId = conditionSearch.getBasicSearchId();

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

				list = conditionService.searchCondition();

			} else {
				
				list = conditionService.basicSearchCondition(dbField,
						operation, basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				ConditionBean cb = new ConditionBean();
				Object[] obj = (Object[]) iterator.next();
				cb.setConditionId((Integer) obj[0]);
				cb.setCondition((String) obj[1]);
				ConditionType cType = ((ConditionType) obj[2]);
				cb.setConditionType(cType.getConditionType());
				conditionBean.add(cb);
			}
			request.setAttribute("conditionBean", conditionBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "conditionHome";

	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "conditionId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/conditionEdit", method = RequestMethod.GET)
	public String conditionEdit(
			@ModelAttribute("conditionCmd") ConditionBean conditionEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("conditionId"));
		List<Object[]> list = null;
		List<ConditionBean> conditionBean = new ArrayList<ConditionBean>();
		try {
			list =conditionService.searchConditoinWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				conditionEdit.setConditionIdEdit((Integer) obj[0]);
				conditionEdit.setConditionEdit((String) obj[1]);
				conditionEdit.setConditionTypeIdEdit((String) obj[2]);
				conditionBean.add(conditionEdit);
			}
			request.setAttribute("conditionEdit", conditionBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "conditionHome";

	}
	
	@RequestMapping(value = "/conditionUpdate", method = RequestMethod.POST)
	public String conditionUpdate(
			@ModelAttribute("conditionCmd") ConditionBean conditionUpdate,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		String conUpdated = null;

		String condition = conditionUpdate.getConditionEdit();
		int conditionId = conditionUpdate.getConditionIdEdit();
		String conditionTypeId = conditionUpdate.getConditionTypeIdEdit();

		conditionUpdate.setCondition(conditionUpdate.getConditionEdit());
		conditionUpdate.setConditionId(conditionUpdate.getConditionIdEdit());
		conditionUpdate.setConditionTypeId(conditionUpdate.getConditionTypeIdEdit());
		Long checkUpdate = conditionService.updateCheckCondition(condition, conditionId);

		if (checkUpdate == 0) {

			try {

				String msg = conditionService.updateCondition(conditionUpdate);

				if (msg.equals("S")) {
					request.setAttribute("conditionUpdate", "Condition update successfully");

				} else {
					request.setAttribute("conditionUpErr", "Condition data doesn't updated properly");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			request.setAttribute("updateConditionDuplicate",
					"Condition Already Exists Choose Another One");
			request.setAttribute("conditionEdit", "conditionEdit");
			return "conditionHome";

		}
		model.addAttribute("conditionCmd",new ConditionBean());
		return "conditionHome";
	}

	@RequestMapping(value = "/conditionDelete", method = RequestMethod.GET)
	public String conditionDelete(
			@ModelAttribute("conditionCmd") ConditionBean conditionDel,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		
		response.setCharacterEncoding("UTF-8");
		String conDeleted = null;
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("conditionId"));
		try {

			String msg = conditionService.deleteCodition(id);
			
			if (msg == "S") {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","condition","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				
                request.setAttribute("ConditionDel", "Condition Details Deleted Successfully");
				
			} else {
				request.setAttribute("ConditionDelErr", "Condition Details Not Deleted!");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("conditionCmd", new ConditionBean());
		return "conditionHome";
	}
}
