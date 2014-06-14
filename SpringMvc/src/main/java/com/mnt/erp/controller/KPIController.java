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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.bean.KPIBean;
import com.mnt.erp.bean.KPIGroupBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class KPIController {

    List<Object[]> list = null;
    Iterator<Object[]> iterator = null;
    @Autowired
    PopulateService populateService;
    @Autowired
    ERPDao dao;
    String sql;
    @Autowired
    XmlLabelsService xmlService;
    @Autowired
    MenuService menuService;
    @Autowired
    AuditLogService auditLogService;
    HttpSession session = null;

    @RequestMapping(value = "/kpi", method = RequestMethod.GET)
    public ModelAndView KPIHome(@ModelAttribute("KPICmd") KPIBean kpiBean,
	    HttpServletResponse response, HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("kpi.mnt", session
		.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	return new ModelAndView("kpiHome", "KPICmd", kpiBean);
    }

    @RequestMapping(value = "/saveKPI", method = RequestMethod.POST)
    @RequestScoped
    public String saveKPI(@ModelAttribute("KPICmd") KPIBean kpiBean,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from KPIBean o where  o.KPI='"
		    + kpiBean.getKPI() + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(kpiBean);

		map.addAttribute("kpiBean", kpiBean);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "KPIBeab", "ROW",
			    String.valueOf(kpiBean.getKPIId()), "1",
			    modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("KPICmd", new KPIBean());
		    return "redirect:kpi.mnt?list=" + "success" + "";
		} else {
		    return "redirect:kpi.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! KPI is already exists";

		kpiBean.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "kpiHome";
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:kpi.mnt?listwar=" + "fail" + "";
	}
    }

    @ModelAttribute("KPIGroupValues")
    public Map<Integer, String> populateKPIGroup() {
	List<Object[]> listvalues = null;
	Map<Integer, String> map = null;
	Iterator<Object[]> iterator = null;
	try {
	    map = new HashMap<Integer, String>();
	    listvalues = populateService
		    .poPulate("select k.KPIGroupId,k.KPIGroup from KPIGroupBean k");

	    iterator = listvalues.iterator();
	    while (iterator.hasNext()) {
		Object[] objects = (Object[]) iterator.next();
		// list.add((String)objects[1]);
		map.put((Integer) objects[0], (String) objects[1]);

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return map;
    }

    @RequestMapping(value = "/searchKPI", method = RequestMethod.GET)
    public String searchKPI(@ModelAttribute("KPICmd") KPIBean kpiBean,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<KPIBean> kpiList = null;
	try {
	    int iid = kpiBean.getKPIId();
	    kpiList = new ArrayList<KPIBean>();
	    String dbField = kpiBean.getXmlLabel();
	    String operation = kpiBean.getOperations();
	    String basicSearchId = kpiBean.getBasicSearchId();

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
		sql = "select ag.KPIId,ag.KPI, ag.minRate, ag.maxRate, ag.KPIGroup from KPIBean ag";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    KPIBean kpiSearch = new KPIBean();
		    kpiSearch.setKPIId((Integer) obj[0]);
		    kpiSearch.setKPI((String) obj[1]);
		    kpiSearch.setMinRate((String) obj[2]);
		    kpiSearch.setMaxRate((String) obj[3]);
		    kpiSearch.setKPIGroup((String) obj[4]);
		    kpiList.add(kpiSearch);
		}

	    } else {

		// list = accountgroupservice.searchAccountGroupsWithId(iid);
		sql = "select ag.KPIId,ag.KPI, ag.minRate, ag.maxRate, ag.KPIGroup from KPIBean ag where ag."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    KPIBean kpiSearch = new KPIBean();
		    kpiSearch.setKPIId((Integer) obj[0]);
		    kpiSearch.setKPI((String) obj[1]);
		    kpiSearch.setMinRate((String) obj[2]);
		    kpiSearch.setMaxRate((String) obj[3]);
		    kpiSearch.setKPIGroup((String) obj[4]);

		    kpiList.add(kpiSearch);
		}

	    }
	    request.setAttribute("kpiValues", kpiList);
	    // model.addAttribute("accountGroup", new AccountGroupBean());
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "kpiHome";
    }

    @RequestMapping(value = "/kpiEdit", method = RequestMethod.GET)
    public String kpiEdit(@ModelAttribute("KPICmd") KPIBean kpiBean,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("KPIId"));
	try {

	    sql = "select ag.KPIId,ag.KPI, ag.minRate, ag.maxRate, ag.KPIGroup from KPIBean ag where ag.KPIId='"
		    + id + "'";

	    list = dao.searchDetails(sql);
	    KPIGroupBean kpiGroupBean = new KPIGroupBean();
	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();
		kpiBean.setKPIIdEdit((Integer) obj[0]);
		kpiBean.setKPIEdit((String) obj[1]);
		kpiBean.setMinRateEdit((String) obj[2]);
		kpiBean.setMaxRateEdit((String) obj[3]);
		kpiBean.setKPIGroupEdit((String) obj[4]);
	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "kpiHome";

    }

    @RequestMapping(value = "/kpiUpdate", method = RequestMethod.POST)
    public String kpiUpdate(@ModelAttribute("KPICmd") KPIBean kpiBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String kpiName = kpiBean.getKPIEdit();
	int kpiId = kpiBean.getKPIId();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from KPIBean ab where ab.KPI='" + kpiName
		    + "'and ab.KPIId!='" + kpiId + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		kpiBean.setKPIId(kpiBean.getKPIIdEdit());
		kpiBean.setKPI(kpiBean.getKPIEdit());
		kpiBean.setMinRate(kpiBean.getMinRateEdit());
		kpiBean.setMaxRate(kpiBean.getMaxRateEdit());
		kpiBean.setKPIGroup(kpiBean.getKPIGroupEdit());
		int message = dao.updateDetails(kpiBean);

		if (message != 0) {
		    request.setAttribute("KPIUpdate",
			    "KPI Data Updated Successfully");

		} else {
		    request.setAttribute("KPIUpdateFail",
			    "KPI Data Updated Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! KPI is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "kpiHome";
	    }
	    model.addAttribute("KPICmd", new KPIBean());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "kpiHome";
    }

    @RequestMapping(value = "/kpiDelete", method = RequestMethod.GET)
    public String kpiDelete(@ModelAttribute("KPICmd") KPIBean kpiBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request.getParameter("KPIId"));
	    KPIBean bean = new KPIBean();
	    bean.setKPIId(groupId);

	    int msg = dao.deleteDetails(bean);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "KPIBean", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("KPIDelete",
			"KPI Data is Deleted Successfully");
	    } else {
		request.setAttribute("KPIDeleteFail",
			"KPI Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("KPICmd", new KPIBean());
	return "kpiHome";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "KPIId";

	Map<String, String> map = null;

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
