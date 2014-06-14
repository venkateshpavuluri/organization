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
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.GoodsReceiptType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.GoodsReceiptTypeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class GoodsReceiptTypeController {
	@Autowired
	GoodsReceiptTypeService goodsReceiptTypeService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	MenuService menuService;
	HttpSession session;

	@RequestMapping(value = "/goodsReceiptTypeHome", method = RequestMethod.GET)
	@RequestScoped
	public String getGoodsReceiptTypeHome(
			@ModelAttribute GoodsReceiptType goodsReceiptType,
			HttpServletResponse response, SessionStatus status, Model model,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige(
				"goodsReceiptTypeHome.mnt", session.getAttribute("userId")
						.toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("goodsReceiptType", goodsReceiptType);
		return "goodsReceiptTypeHome";
	}

	@RequestMapping(value = "/addGoodsReceiptType", method = RequestMethod.POST)
	@RequestScoped
	public String saveGoodsReceiptType(
			@ModelAttribute GoodsReceiptType goodsReceiptType,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		String isa = null;
		String goodsReceiptTypeSave = null;

		String goodsReceiptTypeCheck = goodsReceiptType.getGoodsReceiptType();
		int checkGoodsReceiptType = goodsReceiptTypeService
				.checkGoodsReceiptType(goodsReceiptTypeCheck);

		if (checkGoodsReceiptType == 0) {
			try {
				session = request.getSession(false);
				isa = goodsReceiptTypeService.saveGoodsReceiptTypeDetails(
						goodsReceiptType, session.getAttribute("userId")
								.toString(), session.getAttribute("userName")
								.toString());
				status.setComplete();

				if (isa.equals("S")) {
					return "redirect:goodsReceiptTypeHome.mnt?list="
							+ goodsReceiptTypeSave + "";
				} else {
					goodsReceiptTypeSave = "GoodsReceiptType Details Insertion Failed";
					return "redirect:goodsReceiptTypeHome.mnt?listwar="
							+ goodsReceiptTypeSave + "";
				}
			} catch (Exception e) {
				e.printStackTrace();
				goodsReceiptTypeSave = "GoodsReceiptType Details Insertion Failed";
				return "redirect:goodsReceiptTypeHome.mnt?listwar="
						+ goodsReceiptTypeSave + "";

			}

		} else {
			request.setAttribute("addGoodsReceiptTypeDuplicate",
					"GoodsReceiptType Already Exists Choose Another One");
			goodsReceiptType.setAid(1);
			return "goodsReceiptTypeHome";
		}
	}

	@ModelAttribute("selectGoodsReceiptType")
	public Map<Integer, String> getGoodsReceiptType() {
		Map<Integer, String> map = new Hashtable<Integer, String>();
		List<Object[]> list = null;
		try {
			list = goodsReceiptTypeService.selectGoodsReceiptType();
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

	@RequestMapping(value = "/searchGoodsReceiptType", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView searchGoodsReceiptType(
			@ModelAttribute GoodsReceiptType goodsReceiptType,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;
		int searchGoodsReceiptTypeId = goodsReceiptType.getGoodsReceiptTypeId();
		List<GoodsReceiptType> goodsReceiptTypeSearch = null;
		try {
			String dbField = goodsReceiptType.getXmlLabel();
			String operation = goodsReceiptType.getOperations();
			String basicSearchId = goodsReceiptType.getBasicSearchId();

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

				goodsReceiptTypeSearch = new ArrayList<GoodsReceiptType>();

				list = goodsReceiptTypeService.basicSearchGoodsReceipt(dbField,
						operation, basicSearchId);

			} else {

				goodsReceiptTypeSearch = new ArrayList<GoodsReceiptType>();
				list = goodsReceiptTypeService.searchGoodsReceiptType();

			}
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				GoodsReceiptType goodsReceiptType2 = new GoodsReceiptType();
				Object[] objs = (Object[]) iterator.next();
				goodsReceiptType2.setGoodsReceiptTypeId((Integer) objs[0]);
				goodsReceiptType2.setGoodsReceiptType((String) objs[1]);
				goodsReceiptTypeSearch.add(goodsReceiptType2);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("goodsReceiptTypeSearch", "goodsReceiptTypeSearch");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("goodsReceiptTypeHome");
		modelAndView.addObject("goodsReceiptTypeRow", goodsReceiptTypeSearch);
		return modelAndView;
	}

	@RequestMapping(value = "/goodsReceiptTypeEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String goodsReceiptTypeEdit(
			@ModelAttribute GoodsReceiptType goodsReceiptTypeDisplay,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request
				.getParameter("goodsReceiptTypeIdEdit"));

		List<Object[]> list = null;
		Object[] object = null;

		List<GoodsReceiptType> goodsReceiptTypeList = new ArrayList<GoodsReceiptType>();

		try {

			list = goodsReceiptTypeService.searchGoodsReceiptTypeWithId(id);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();
				goodsReceiptTypeDisplay
						.setGoodsReceiptTypeIdEdit((Integer) object[0]);
				goodsReceiptTypeDisplay
						.setGoodsReceiptTypeEdit((String) object[1]);
				goodsReceiptTypeList.add(goodsReceiptTypeDisplay);
			}
			request.setAttribute("goodsReceiptTypeValues", goodsReceiptTypeList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}

		return "goodsReceiptTypeHome";

	}

	@RequestMapping(value = "/goodsReceiptTypeUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updategoodsReceiptType(
			@ModelAttribute GoodsReceiptType goodsReceiptType,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");

		String gr = null;
		String goodsReceiptTypeUpdate = null;

		int goodsReceiptTypeId = goodsReceiptType.getGoodsReceiptTypeIdEdit();
		String goodsReceiptTypeEdit = goodsReceiptType
				.getGoodsReceiptTypeEdit();

		goodsReceiptType.setGoodsReceiptTypeId(goodsReceiptTypeId);
		goodsReceiptType.setGoodsReceiptType(goodsReceiptTypeEdit);
		int checkDuplicate = goodsReceiptTypeService
				.updateCheckGoodsReceiptType(goodsReceiptTypeEdit,
						goodsReceiptTypeId);
		if (checkDuplicate == 0) {
			try {
				gr = goodsReceiptTypeService
						.updateGoodsReceiptType(goodsReceiptType);
				if (gr.equals("S")) {

					request.setAttribute("gdsRecieptTypeUpdate",
							"GoodsReceiptType Details Updated Successfully");
				} else {
					request.setAttribute("gdsRecieptTypeUpdateError",
							"GoodsReceiptType Details Did not Updated");
				}
			}

			catch (Exception e) {
				request.setAttribute("gdsRecieptTypeUpdateError",
						"GoodsReceiptType Details Did not Updated");
				e.printStackTrace();
			}
		} else {
			request.setAttribute("updateGoodsReceiptTypeDuplicate",
					"GoodsReceiptType Already Exists Choose Another One");
			request.setAttribute("goodsReceiptTypeValues",
					"goodsReceiptTypeList");
			return "goodsReceiptTypeHome";
		}
		return "goodsReceiptTypeHome";
	}

	@RequestMapping(value = "/goodsReceiptTypeDelete", method = RequestMethod.GET)
	@RequestScoped
	public String deleteGoodsReceiptType(
			@ModelAttribute GoodsReceiptType goodsReceiptType,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request
				.getParameter("goodsReceiptTypeIdDelete"));
		String isa = null;
		try {
			isa = goodsReceiptTypeService.deleteGoodsReceiptType(id);
			if (isa.equals("S")) {
				request.setAttribute("gdsRecieptTypeDelete", "delete success");
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Goods Reciept Type", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
			} else {
				request.setAttribute("gdsRecieptTypeDeleteError",
						"delete faisl");

			}

		}

		catch (Exception e) {
			request.setAttribute("gdsRecieptTypeDeleteError", "delete faisl");
			e.printStackTrace();
		}
		return "goodsReceiptTypeHome";

	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "goodsReceiptId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
