package com.mnt.erp.controller;

/**
 * @author Srinivas

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

import com.mnt.erp.bean.StockTypeBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class StockTypeController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	ERPDao erpDao;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session;

	@RequestMapping(value = "/stocktypeHome", method = RequestMethod.GET)
	public String getStocktype(@ModelAttribute StockTypeBean ebean,
			SessionStatus status, Model model, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("stocktypeHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("STOCKTYPE", new StockTypeBean());
		return "stocktypeHome";
	}

	@RequestMapping(value = "/saveStockType", method = RequestMethod.POST)
	public String saveStockType(
			@ModelAttribute("STOCKTYPE") StockTypeBean ebean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		int msg = 0;
		StockTypeBean ebean1 = null;
		String StockTypeBeansuccess = null;
		String StockTypeBeansuccessdup = null;
		// List<String> list = null;
		String name = ebean.getStocktype();
		Long id = 0L;
		try {
			id = erpDao
					.duplicateCheck("select count(*) from StockTypeBean ab where ab.stocktype='"
							+ name + "'");

			if (id == 0) {

				msg = erpDao.saveDetails(ebean);
				ebean1 = new StockTypeBean();
				map.addAttribute("STOCKTYPE", ebean1);
				if (msg >= 1) {
					Date date = new Date();
					session = request.getSession(false);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Stock Type", "ROW", String.valueOf(id), "1",
							modifiedDate, session.getAttribute("userName")
									.toString());
					StockTypeBeansuccess = "Stock Type Data Saved Successfully";
					request.setAttribute("StockTypeBeansuccess",
							StockTypeBeansuccess);
					return "redirect:stocktypeHome.mnt?list=" + "success" + "";
				} else {
					String StockTypeBeansuccessFail = "Stock Type Data is Not Saved Properly";
					request.setAttribute("StockTypeBeansuccessFail",
							StockTypeBeansuccessFail);
					model.addAttribute("STOCKTYPE", new StockTypeBean());
					return "redirect:stocktypeHome.mnt?listwar=" + "fail" + "";
				}
			}

			else {
				StockTypeBeansuccessdup = "Warning ! Stock Type is already exists. Please try some other name ";
				ebean.setSthide(1);
				request.setAttribute("StockTypeBeansuccessdup",
						StockTypeBeansuccessdup);
				return "stocktypeHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:stocktypeHome.mnt?listwar=" + "fail" + "";
		}

	}

	@RequestMapping(value = "/searchStockType", method = RequestMethod.GET)
	public String searchStockTypeBean(
			@ModelAttribute("STOCKTYPE") StockTypeBean ebean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = ebean.getStocktypeid();
			List<StockTypeBean> ebeans = new ArrayList<StockTypeBean>();
			String dbField = ebean.getXmlLabel();
			String operation = ebean.getOperations();
			String basicSearchId = ebean.getBasicSearchId();

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
				list = erpDao
						.searchDetails("select ag.stocktypeid,ag.stocktype from StockTypeBean ag ORDER BY ag.stocktype");

			} else {
				list = erpDao
						.searchDetails("select ag.stocktypeid,ag.stocktype from StockTypeBean ag where ag."
								+ dbField
								+ ""
								+ operation
								+ "'"
								+ basicSearchId + "' ORDER BY ag.stocktype");
			}

			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				StockTypeBean StockTypeBeanbean = new StockTypeBean();
				StockTypeBeanbean.setStocktypeid((Integer) obj[0]);
				StockTypeBeanbean.setStocktype((String) obj[1]);
				ebeans.add(StockTypeBeanbean);

			}
			
			request.setAttribute("ebeans", ebeans);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "stocktypeHome";
	}

	@RequestMapping(value = "/StockTypeBeanEdit", method = RequestMethod.GET)
	public String editStockTypeBean(
			@ModelAttribute("STOCKTYPE") StockTypeBean ebean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("stocktypeedit"));

		try {
			List<StockTypeBean> ebeans = new ArrayList<StockTypeBean>();
			list = erpDao
					.searchDetails("select ag.stocktypeid,ag.stocktype from StockTypeBean ag where ag.stocktypeid="
							+ id + "");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				ebean.setEditstocktypeid((Integer) obj[0]);
				ebean.setEditstocktype((String) obj[1]);
				ebeans.add(ebean);
			}
			request.setAttribute("editvalues", ebeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "stocktypeHome";

	}

	@RequestMapping(value = "/StockTypeBeanUpdate", method = RequestMethod.POST)
	public String updateStockTypeBean(
			@ModelAttribute("STOCKTYPE") StockTypeBean ebean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = ebean.getEditstocktype();
		int imid = ebean.getEditstocktypeid();
		Long iid = 0l;
		String StockTypeBeandupedit = null;
		try {
			iid = erpDao
					.duplicateCheck("select count(*) from StockTypeBean ab where ab.stocktype='"
							+ name + "'and ab.stocktypeid!='" + imid + "'");
			if (iid == 0) {
				ebean.setStocktype(ebean.getEditstocktype());
				ebean.setStocktypeid(ebean.getEditstocktypeid());

				int message = erpDao.updateDetails(ebean);
				if (message == 1) {
					request.setAttribute("StockTypeBeanUpdate",
							"Stock Type Data Updated Successfully");
				} else {
					request.setAttribute("StockTypeBeanUpdateError",
							"Stock Type Data did not Updated");
				}
			} else {
				StockTypeBeandupedit = "Warning ! Stock Type is already exists. Please try some other name ";
				ebean.setSthideedit(1);
				request.setAttribute("StockTypeBeandupedit",
						StockTypeBeandupedit);
				request.setAttribute("editvalues", "editvalues");
				return "stocktypeHome";
			}

		} catch (Exception e) {
			request.setAttribute("StockTypeBeanUpdateError",
					"Stock Type Data did not Updated");
			e.printStackTrace();
		}
		model.addAttribute("STOCKTYPE", new StockTypeBean());
		return "stocktypeHome";
	}

	@RequestMapping(value = "/StockTypeBeanDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView StockTypeBeanDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		try {
			Id = Integer.parseInt(request.getParameter("stocktypedelete"));
			StockTypeBean StockTypeBeanbean = new StockTypeBean();
			StockTypeBeanbean.setStocktypeid(Id);
			int msg = erpDao.deleteDetails(StockTypeBeanbean);
			if (msg == 1) {
				request.setAttribute("StockTypeBeanDelete",
						"Stock Type Data is Deleted Successfully");
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Stock Type", "ROW", String
						.valueOf(Id), "1", modifiedDate,
						session.getAttribute("userName").toString());
			} else {
				request.setAttribute("StockTypeBeanDeleteError",
						"Stock Type Data is did not Deleted");
			}
		} catch (Exception e) {
			request.setAttribute("StockTypeBeanDeleteError",
					"Stock Type Data is did not Deleted");
			e.printStackTrace();
		}
		return new ModelAndView("stocktypeHome", "STOCKTYPE",
				new StockTypeBean());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "stocktypeid";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
