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

import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Route;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.RouteService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author anikesh
 * 
 */
@Controller
public class RouteController {
	@Autowired
	RouteService routeService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	List<Route> routeList = null;
	List<Route> route1 = null;
	List<Object[]> objectsArray = null;
	Iterator<Object[]> iterator = null;
	Object[] objects2 = null;
	Route mm = null;

	@RequestMapping(value = "/routeHome", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView routeType(@ModelAttribute("routeAdd") Route route,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("routeHome.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("routeHome", "routeAdd", new Route());
	}

	@RequestMapping(value = "/routeAdd", method = RequestMethod.GET)
	@RequestScoped
	public String saveRouteDetails(
			@ModelAttribute("routeAdd") @Valid Route routeAdd,
			BindingResult result, DefaultSessionAttributeStore store,
			WebRequest request1, HttpServletRequest request,
			SessionStatus status, Model model, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		String msa, res = null;
		HttpSession session = null;
		Long duplicateId = 0l;

		try {
			response.setCharacterEncoding("UTF-8");
			if (result.hasErrors()) {
				routeAdd.setAid(1);
				return "routeHome";
			}
			duplicateId = routeService.duplicateRouteCheck(routeAdd
					.getRouteCode());
			if (duplicateId == 0) {
				session = request.getSession(false);
				msa = routeService.saveRouteDetails(routeAdd, session
						.getAttribute("userId").toString(), session
						.getAttribute("userName").toString());
				model.addAttribute("routeAdd", new Route());
				if (msa.equals("S")) {
					res = "redirect:routeHome.mnt?list=" + "success" + "";
				} else {
					res = "redirect:routeHome.mnt?listwar=" + "fail" + "";
				}
			} else {

				request.setAttribute("RouteDuplicate",
						"Route Registration Number  Already exist");
				routeAdd.setAid(1);
				return "routeHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:routeHome.mnt?listwar=" + "fail" + "";

		}
		return "redirect:routeHome.mnt?list=" + "success" + "";
	}

	@ModelAttribute("organizationIds")
	public Map<String, String> populateOrganizationIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = routeService.selectOrganizationIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				String rotid = Integer.toString(Integer.parseInt(objects[0]
						.toString()));

				map.put(rotid, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("uomIds")
	public Map<String, String> populateUomIds() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = routeService.selectUomIds();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				String rotid = Integer.toString(Integer.parseInt(objects[0]
						.toString()));

				map.put(rotid, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/routeSearch", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String searchRoute(@ModelAttribute Route routeSearch,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");

		List<Object[]> list = null;

		List<Route> routeBean = new ArrayList<Route>();

		try {

			String dbField = routeSearch.getXmlLabel();
			String operation = routeSearch.getOperations();
			String basicSearchId = routeSearch.getBasicSearchId();

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
				list = routeService.searchRoute();
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Route r = new Route();
					Object[] obj = (Object[]) iterator.next();
					r.setRouteId((Integer) obj[0]);
					r.setRouteCode((String) obj[1]);
					r.setOrganizationId((String) obj[2]);
					r.setFromPlace((String) obj[3]);
					r.setToPlace((String) obj[4]);
					r.setDistance((String) obj[5]);
					r.setUomId((String) obj[6]);
					r.setApproxTime((String) obj[7]);
					r.setTimeUomId((String) obj[8]);
					r.setOrganizationName((String) obj[9]);
					r.setUomName((String) obj[10]);
					r.setTimeUomName((String) obj[11]);
					routeBean.add(r);

				}
			} else {
				list = routeService.basicSearchRoute(dbField, operation,
						basicSearchId);
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {

					Route r = new Route();
					Object[] obj = (Object[]) iterator.next();
					r.setRouteId((Integer) obj[0]);
					r.setRouteCode((String) obj[1]);
					r.setOrganizationId((String) obj[2]);
					r.setFromPlace((String) obj[3]);
					r.setToPlace((String) obj[4]);
					r.setDistance((String) obj[5]);
					r.setUomId((String) obj[6]);
					r.setApproxTime((String) obj[7]);
					r.setTimeUomId((String) obj[8]);
					r.setOrganizationName((String) obj[9]);
					r.setUomName((String) obj[10]);
					r.setTimeUomName((String) obj[11]);
					routeBean.add(r);

				}
			}
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("routeSearch", routeBean);

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("routeAdd", routeSearch);

		return "routeHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "routeId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("RouteSearchNames")
	public Map<String, String> populaterouteSearchNames() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<String, String> map = null;
		try {
			listvalues = routeService.selectRouteNames();
			map = new HashMap<String, String>();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				String desigId = Integer.toString((Integer) objects[0]);
				map.put(desigId, (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/routeEditHome", method = RequestMethod.GET)
	@Scope("request")
	@RequestScoped
	public String routeEdit(@ModelAttribute Route routeDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		String routename = request.getParameter("routeDetEdit");
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		Object[] object = null;

		List<Route> routesList = new ArrayList<Route>();

		try {

			list = routeService.searchRouteWithId(routename);

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				object = (Object[]) iterator.next();

				routeDisplay.setRouteIdEdit((Integer) object[0]);
				routeDisplay.setRouteCodeEdit((String) object[1]);
				routeDisplay.setOrganizationIdEdit((String) object[2]);
				routeDisplay.setFromPlaceEdit((String) object[3]);
				routeDisplay.setToPlaceEdit((String) object[4]);
				routeDisplay.setDistanceEdit((String) object[5]);
				routeDisplay.setUomIdEdit((String) object[6]);
				routeDisplay.setApproxTimeEdit((String) object[7]);
				routeDisplay.setTimeUomIdEdit((String) object[8]);

				routesList.add(routeDisplay);

			}

			request.setAttribute("routeValues", routesList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			object = null;
		}
		model.addAttribute("routeAdd", routeDisplay);
		return "routeHome";

	}

	@RequestMapping(value = "/routeUpdate", method = RequestMethod.POST)
	@RequestScoped
	public String updateRoute(@ModelAttribute("routeAdd") Route route,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		Long duplicateId = 0l;
		try {
			duplicateId = routeService.updateDuplicateCheck(
					route.getRouteCodeEdit(), route.getRouteIdEdit());

			if (duplicateId == 0) {

				route.setRouteId(route.getRouteIdEdit());
				route.setRouteCode(route.getRouteCodeEdit());
				route.setOrganizationId(route.getOrganizationIdEdit());
				route.setFromPlace(route.getFromPlaceEdit());
				route.setToPlace(route.getToPlaceEdit());
				route.setDistance(route.getDistanceEdit());
				route.setUomId(route.getUomIdEdit());
				route.setApproxTime(route.getApproxTimeEdit());
				route.setTimeUomId(route.getTimeUomIdEdit());

				String msg = routeService.updateRoute(route);

				if (msg.equals("S")) {
					request.setAttribute("routeUpadteSuccess",
							"Route Details Updated Successfully");
				} else {

					request.setAttribute("routeUpadteFail",
							"Route Details has Not Updated");

				}
			} else {
				request.setAttribute("routeUpdateDuplicate",
						"Registration Number Already exist");

				request.setAttribute("routeValues", "routeValues");
				return "routeHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("routeAdd", new Route());

		return "routeHome";

	}

	@RequestMapping(value = "/routeDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView materialDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String routeid = null;
		HttpSession session = null;
		try {
			routeid = request.getParameter("routeIdDelete");

			String msg = routeService.routeDelete(routeid);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Route", "ROW", String
						.valueOf(routeid), "1", modifiedDate, session
						.getAttribute("userName").toString());

				request.setAttribute("routeDelSuccess",
						"Route details Deleted Successfully");
			} else {
				request.setAttribute("routeDelFail",
						"route details Did Not Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("roleUpadteFail",
					"Route details Did Not Deleted");
		}
		return new ModelAndView("routeHome", "routeAdd", new Route());
	}

	@RequestMapping(value = "/routeAdvanceSearch", method = RequestMethod.GET)
	public String routeAdvanceSearch(@ModelAttribute("routeAdd") Route route,
			HttpServletRequest request, HttpServletResponse response) {

		String name1 = "routeId", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		routeList = new ArrayList();
		route.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			for (Object[] object : returnString) {
				Route v = new Route();

				s1 = (String) object[0];
				s2 = (String) object[1];

				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				routeList.add(v);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("routeSearchAdvance", routeList);

		return "routeHome";
	}

	@RequestMapping(value = "/routeAdvanceSearchOperations", method = RequestMethod.POST)
	public String routeAdvanceSearchOperations(@ModelAttribute Route route,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		route1 = new ArrayList<Route>();
		String columns = route.getFirstLabel();
		String operations = route.getOperations1();
		String advanceSearchText = route.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {

			objectsArray = routeService.getRouteAdvance(columns, operations,
					advanceSearchText);
		} else {
			objectsArray = routeService.searchRoute();
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {

			mm = new com.mnt.erp.bean.Route();
			objects2 = (Object[]) iterator.next();
			mm.setRouteId((Integer) objects2[0]);
			mm.setRouteCode((String) objects2[1]);
			mm.setOrganizationId((String) objects2[2]);
			mm.setFromPlace((String) objects2[3]);
			mm.setToPlace((String) objects2[4]);
			mm.setDistance((String) objects2[5]);
			mm.setUomId((String) objects2[6]);
			mm.setApproxTime((String) objects2[7]);
			mm.setTimeUomId((String) objects2[8]);
			mm.setOrganizationName((String) objects2[9]);
			mm.setUomName((String) objects2[10]);
			mm.setTimeUomName((String) objects2[11]);
			route1.add(mm);

		}

		request.setAttribute("routeSearch", route1);
		model.addAttribute("routeAdd", new Route());

		return "routeHome";
	}

}
