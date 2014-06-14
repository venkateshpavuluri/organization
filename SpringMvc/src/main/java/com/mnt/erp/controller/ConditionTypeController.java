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

import com.mnt.erp.bean.AssertTypeBean;
import com.mnt.erp.bean.ConditionType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.ConditionTypeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author madhav
 * 
 */
@Controller
@Scope("request")
public class ConditionTypeController {

	@Autowired
	ConditionTypeService conditionTypeService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/conditionType", method = RequestMethod.GET)
	public ModelAndView conditionHome(
			@ModelAttribute("conditionTypeCmd") ConditionType ctBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("conditionType.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		return new ModelAndView("conditionType", "conditionTypeCmd", ctBean);
	}

	// Method for saving the form
	@RequestMapping(value = "/conditionTypeAdd", method = RequestMethod.POST)
	public String saveConditionType(
			@ModelAttribute("conditionTypeCmd") ConditionType ctBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		String cType = ctBean.getConditionType();
		ConditionType cBean = (ConditionType) ctBean;
		Long checkAsset = conditionTypeService.addCheckConditionType(cType);
		HttpSession session = null;
		String msg, res = null;
		if (checkAsset == 0) {
			try {
				session = request.getSession(false);
				msg = conditionTypeService.saveConditionType(cBean, session
						.getAttribute("userId").toString(), session
						.getAttribute("userName").toString());
				if (msg.equals("S")) {
					res = "redirect:conditionType.mnt?list=" + "success" + "";
				}
			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:conditionType.mnt?listwar=" + "fail" + "";
			}
		} else {
			ctBean.setCtId(1);
			request.setAttribute("addConditionTypeDuplicate",
					"Condition Type Already Exists Choose Another One");

			return "conditionType";

		}

		return "redirect:conditionType.mnt?list=" + "success" + "";

	}

	@RequestMapping(value = "/conditionTypeSearch", method = RequestMethod.GET)
	public String searchConditionType(
			@ModelAttribute("conditionTypeCmd") ConditionType conditionTypeSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<ConditionType> conditionTypeBean = new ArrayList<ConditionType>();

		try {
			int id = conditionTypeSearch.getConditionTypeId();
			String dbField = conditionTypeSearch.getXmlLabel();
			String operation = conditionTypeSearch.getOperations();
			String basicSearchId = conditionTypeSearch.getBasicSearchId();

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
				list = conditionTypeService.searchConditionType();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					ConditionType ct = new ConditionType();
					Object[] obj = (Object[]) iterator.next();
					ct.setConditionTypeId((Integer) obj[0]);
					ct.setConditionType((String) obj[1]);
					conditionTypeBean.add(ct);
				}
			} else {
				list = conditionTypeService.basicSearchConditionType(dbField,
						operation, basicSearchId);

				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					ConditionType ct = new ConditionType();
					Object[] obj = (Object[]) iterator.next();
					ct.setConditionTypeId((Integer) obj[0]);
					ct.setConditionType((String) obj[1]);
					conditionTypeBean.add(ct);
				}
			}
			request.setAttribute("conditionTypeBean", conditionTypeBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "conditionType";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "ConditionTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/conditionTypeEdit", method = RequestMethod.GET)
	public String conditionTypeEdit(
			@ModelAttribute("conditionTypeCmd") ConditionType ctEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("conditionTypeId"));
		List<Object[]> list = null;
		List<ConditionType> conditionTypeBean = new ArrayList<ConditionType>();
		try {
			list = conditionTypeService.searchConditionTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				ctEdit.setConditionTypeIdEdit((Integer) obj[0]);
				ctEdit.setConditionTypeEdit((String) obj[1]);
				conditionTypeBean.add(ctEdit);
			}
			request.setAttribute("conditionTypeEdit", conditionTypeBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "conditionType";
	}

	@RequestMapping(value = "/conditionTypeUpdate", method = RequestMethod.GET)
	public String conditionTypeUpdate(
			@ModelAttribute("conditionTypeCmd") ConditionType conditionTypeUpdate,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String ctUpdated = null;

		String conditionType = conditionTypeUpdate.getConditionTypeEdit();
		int conditionTypId = conditionTypeUpdate.getConditionTypeIdEdit();

		conditionTypeUpdate.setConditionTypeId(conditionTypId);
		conditionTypeUpdate.setConditionType(conditionType);
		Long checkUpdate = conditionTypeService.updateCheckConditionType(
				conditionType, conditionTypId);
		if (checkUpdate == 0) {

			try {

				String msg = conditionTypeService
						.updateConditionType(conditionTypeUpdate);

				if (msg.equals("S")) {
					request.setAttribute("conditionTypeUpdte",
							"Condition type update successfully");

				} else {
					request.setAttribute("conditionTypeUpdteErr",
							"Condition type doesn't updated properly");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {

			request.setAttribute("updateCTDuplicate",
					"Condition Type Already Exists Choose Another One");
			request.setAttribute("conditionTypeEdit", "conditionTypeEdit");
			return "conditionType";

		}
		model.addAttribute("conditionTypeCmd", new ConditionType());
		return "conditionType";
	}

	@RequestMapping(value = "/conditionTypeDelete", method = RequestMethod.GET)
	public String ConditionTypeDelete(
			@ModelAttribute("conditionTypeCmd") AssertTypeBean assetDelete,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String ctDeleted = null;
		HttpSession session = null;
		int id = Integer.parseInt(request.getParameter("conditionTypeId"));
		try {

			String msg = conditionTypeService.deleteConditionType(id);
			if (msg == "S") {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "conditionType", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());

				request.setAttribute("conDel",
						"Condition type deleted successfully");
			} else {

				request.setAttribute("conDelErr",
						"Condition type doesn't deleted properly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("conditionTypeCmd", new ConditionType());
		return "conditionType";
	}

}
