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

import com.mnt.erp.bean.ShedulingTypeBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ShedulingTypeService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 23-09-2013
 */
@Controller
public class ShedulingTypeController {
	@Autowired
	ShedulingTypeService shedulingService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	List<Object[]> list = null;
	Iterator<Object[]> itr = null;
	Object[] objects = null;
	HttpSession session = null;

	@RequestMapping(value = "/schedulingHome", method = RequestMethod.GET)
	public ModelAndView shedulingHome(
			@ModelAttribute("schedulingType") ShedulingTypeBean schedulingBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("schedulingHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("schedulingHome", "schedulingType",
				schedulingBean);
	}

	@RequestMapping(value = "/schedulingAdd", method = RequestMethod.POST)
	public String savescheduling(
			@ModelAttribute("schedulingType") ShedulingTypeBean schedulingBean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status) {
		response.setCharacterEncoding("UTF-8");
		String stBean = schedulingBean.getShedulingType();
		ShedulingTypeBean Bean = (ShedulingTypeBean) schedulingBean;
		String sehdulingSave = null;
		Long checkScheduling = shedulingService.checkSchedulingType(stBean);
		if (checkScheduling == 0) {
			try {
				shedulingService.saveShedulingType(Bean);
				status.setComplete();
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Scheduling Type", "ROW", String
						.valueOf(Bean.getShedulingTypeId()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				sehdulingSave = "Scheduling Type Data Saved Successfully";
				return "redirect:schedulingHome.mnt?addSchedulingsus="
						+ sehdulingSave + "";
			} catch (Exception e) {
				e.printStackTrace();
				String shippingCndFail = "Scheduling Type Data Insertion Failures";
				return "redirect:schedulingHome.mnt?addShipCndFail="
						+ shippingCndFail + "";
			}
		} else {

			request.setAttribute("SchedulingTypeDuplicate",
					"Scheduling Type already exists!");
			schedulingBean.setShdId(1);
			return "schedulingHome";

		}

	}

	@ModelAttribute("schedulingSelect")
	public Map<Integer, String> selectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();

		try {
			list = shedulingService.selectShedulingType();
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;

	}

	@RequestMapping(value = "/schedulingSearch", method = RequestMethod.GET)
	public String searchScheduling(
			@ModelAttribute("schedulingType") ShedulingTypeBean schedulingBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ShedulingTypeBean> schedulingList = new ArrayList<ShedulingTypeBean>();

		try {
			int sId = schedulingBeanSearch.getShedulingTypeId();
			String dbField = schedulingBeanSearch.getXmlLabel();
			String operation = schedulingBeanSearch.getOperations();
			String basicSearchId = schedulingBeanSearch.getBasicSearchId();

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
				list = shedulingService.searchShedulingType();

			} else {

				// list = shedulingService.searchShedulingTypeWithId(sId);
				list = shedulingService.basicShedtype(dbField, operation,
						basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				ShedulingTypeBean stb = new ShedulingTypeBean();
				stb.setShedulingTypeId((Integer) objects[0]);
				stb.setShedulingType((String) objects[1]);
				schedulingList.add(stb);

			}

			request.setAttribute("schedulingList", schedulingList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "schedulingHome";

	}

	@RequestMapping(value = "/schdulingEdit", method = RequestMethod.GET)
	public String schdulingEdit(
			@ModelAttribute("schedulingType") ShedulingTypeBean schedulingBeanEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ShedulingTypeBean> schedulingList = new ArrayList<ShedulingTypeBean>();
		int sId = Integer.parseInt(request.getParameter("schdulingId"));
		try {
			list = shedulingService.searchShedulingTypeWithId(sId);
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();

				schedulingBeanEdit.setShedulingTypeEditId((Integer) objects[0]);
				schedulingBeanEdit.setShedulingEditType((String) objects[1]);
				schedulingList.add(schedulingBeanEdit);

			}
			request.setAttribute("schedulingEditList", schedulingList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "schedulingHome";
	}

	@RequestMapping(value = "/schdulingUpdate", method = RequestMethod.POST)
	public String schdulingTypeUpdate(
			@ModelAttribute("schedulingType") ShedulingTypeBean schedulingBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String schdulingUpdate = null;
		String schName = schedulingBeanUpdate.getShedulingEditType();
		int schId = schedulingBeanUpdate.getShedulingTypeEditId();

		schedulingBeanUpdate.setShedulingTypeId(schId);
		schedulingBeanUpdate.setShedulingType(schName);
		int ckeck = shedulingService.updateCheckScCount(schName, schId);
		if (ckeck == 0) {

			try {
				String msg = shedulingService
						.updateShedulingType(schedulingBeanUpdate);
				if (msg.equals("Updated")) {
					schdulingUpdate = "Scheduling Type Data Updated Successfully";

				} else {
					schdulingUpdate = "Schduling Type Data Updation Failed";
					return "redirect:schedulingHome.mnt?UpdateSchedulingFail="
							+ schdulingUpdate + "";
				}

			} catch (Exception e)

			{
				e.printStackTrace();
			}
		} else {
			request.setAttribute("updateSchdulingTypeDuplicate",
					"Schduling Type already exists!");
			request.setAttribute("schedulingEditList", "schedulingEditList");
			return "schedulingHome";
		}
		return "redirect:schedulingHome.mnt?UpdateSchedulingsus="
				+ schdulingUpdate + "";

	}

	@RequestMapping(value = "/schdulingDelete", method = RequestMethod.GET)
	public String schdulingTypeDelete(
			@ModelAttribute("schedulingType") ShedulingTypeBean schedulingBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String schdulingDelete = null;
		int sId = Integer.parseInt(request.getParameter("schdulingId"));
		try {
			String msg = shedulingService.deleteShedulingType(sId);
			if (msg.equals("Deleted")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Scheduling Type", "ROW", String
						.valueOf(sId), "1", modifiedDate,
						session.getAttribute("userName").toString());
				schdulingDelete = "Scheduling Type Deleted Successfully";

			} else {
				schdulingDelete = "Scheduling Type Deletion Failed";
				return "redirect:schedulingHome.mnt?DeleteSchedulingFail="
						+ schdulingDelete + "";

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:schedulingHome.mnt?DeleteSchedulingsus="
				+ schdulingDelete + "";

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "shedulingId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
