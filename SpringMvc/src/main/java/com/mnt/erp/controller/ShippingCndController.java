/*
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

import javax.enterprise.context.RequestScoped;
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

import com.mnt.erp.bean.ShippingConditionBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ShippingConditionService;
import com.mnt.erp.service.XmlLabelsService;

/*
 * @author Naresh
 * @version 1.0  20-09-2013
 */

@Controller
public class ShippingCndController {
	@Autowired
	ShippingConditionService shippingCndService;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;


	List<Object[]> list = null;
	Iterator<Object[]> itr = null;
	Object[] objects = null;

	@RequestMapping(value = "/shippingCndHome", method = RequestMethod.GET)
	public ModelAndView shippingHome(
			@ModelAttribute("shippingCnd") ShippingConditionBean shippingBean,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("shippingCndHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		return new ModelAndView("shippingCndHome", "shippingCnd", shippingBean);

	}

	@RequestMapping(value = "/shippingCndAdd", method = RequestMethod.POST)
	public String saveShippingCnd(
			@ModelAttribute("shippingCnd") ShippingConditionBean shippingBean,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		String shippingCndSave = null;
		String res=null;
		HttpSession session=null;
		String scBean = shippingBean.getShippingCondition();
		ShippingConditionBean sBean = (ShippingConditionBean) shippingBean;
		Long checkscBean = shippingCndService.checkShippingCndCount(scBean);
		if (checkscBean == 0) {

			try {
				session=request.getSession(false);
				shippingCndSave=shippingCndService.saveShippingCondition(sBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if(shippingCndSave.equals("S"))
				{
				res = "redirect:shippingCndHome.mnt?list=" + "success" + "";
				}
			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:shippingCndHome.mnt?listwar=" + "fail" + "";
			}
		
		
		
		}else {
			request.setAttribute("ShipCndDuplicate",
					"Warning ! Shipping Condition is Already exists. Please try some other name");
			shippingBean.setScId(1);
			return "shippingCndHome";
		}
		return "redirect:shippingCndHome.mnt?list=" + "success" + "";
	}

	@ModelAttribute("shipCndSelect")
	public Map<Integer, String> shippingSelectBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = shippingCndService.selectShippingCondition();
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

	@RequestMapping(value = "/shippingCndSearch", method = RequestMethod.GET)
	@RequestScoped
	public String searchShipCnd(
			@ModelAttribute("shippingCnd") ShippingConditionBean shipCndSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<ShippingConditionBean> shipCndBean = new ArrayList<ShippingConditionBean>();

		try {
			int id = shipCndSearch.getShippingConditionId();
			String dbField = shipCndSearch.getXmlLabel();
			String operation = shipCndSearch.getOperations();
			String basicSearchId = shipCndSearch.getBasicSearchId();

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
				list = shippingCndService.searchShippingCondition();

			} else {

				list = shippingCndService.basicShipCnd(dbField, operation,
						basicSearchId);
			}
			
			itr = list.iterator();
			while (itr.hasNext()) {
				ShippingConditionBean scb = new ShippingConditionBean();
				Object[] obj = (Object[]) itr.next();
				scb.setShippingConditionId((Integer) obj[0]);
				scb.setShippingCondition((String) obj[1]);
				shipCndBean.add(scb);
			}

			request.setAttribute("shipCndBean", shipCndBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "shippingCndHome";

	}

	@RequestMapping(value = "/shipCndEdit", method = RequestMethod.GET)
	@RequestScoped
	public String shippingCndEdit(
			@ModelAttribute("shippingCnd") ShippingConditionBean shipCndEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("shipCndId"));
		List<ShippingConditionBean> shipCndBean = new ArrayList<ShippingConditionBean>();
		try {
			list = shippingCndService.searchShippingConditionWithId(id);
			itr = list.iterator();
			while (itr.hasNext()) {

				Object[] obj = (Object[]) itr.next();
				shipCndEdit.setShippingConditionEditId((Integer) obj[0]);
				shipCndEdit.setShippingConditionEdit((String) obj[1]);
				shipCndBean.add(shipCndEdit);
			}
			request.setAttribute("shipCndBeanEdit", shipCndBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "shippingCndHome";

	}

	@RequestMapping(value = "/shipCndUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String shipCndUpdate(
			@ModelAttribute("shippingCnd") ShippingConditionBean shipUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String shipUpadted = null;
		String scName = shipUpdate.getShippingConditionEdit();
		int scId = shipUpdate.getShippingConditionEditId();

		shipUpdate.setShippingConditionId(scId);
		shipUpdate.setShippingCondition(scName);
		int i = shippingCndService.updateCheckScCount(scName, scId);
		if (i == 0) {
			try {
				String msg = shippingCndService
						.updateShippingCondition(shipUpdate);
				if (msg.equals("S")) {
					
					request.setAttribute("shipUpdate", "Shipping Condition Data Updated Successfully");

				} else {
					request.setAttribute("shipUpdateErr", "Shipping Condition Data Doesn't Updated");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			model.addAttribute("shippingCnd", new ShippingConditionBean());
			return "shippingCndHome";
		} else {
			request.setAttribute("updateShipCndDuplicate",
					"Warning ! Shipping Condition is Already exists. Please try some other name");
			request.setAttribute("shipCndBeanEdit", "shipCndBeanEdit");
			return "shippingCndHome";
		}

	}

	@RequestMapping(value = "/shipCndDelete", method = RequestMethod.GET)
	public String shipCndDelete(
			@ModelAttribute("shippingCnd") ShippingConditionBean shipUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String shipdeleted = null;
		HttpSession session=null;

		int id = Integer.parseInt(request.getParameter("shipCndId"));
		try {
			String msg = shippingCndService.deleteShippingCondition(id);
			if (msg.equals("S")) {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","shipping","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("shippingDel", "Shipping Condition  Deleted Successfully");
				

			} else {
				request.setAttribute("shippingDelErr", "Shipping Condition  Deleted Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("shippingCnd", new ShippingConditionBean());
		return "shippingCndHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "shippingId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
