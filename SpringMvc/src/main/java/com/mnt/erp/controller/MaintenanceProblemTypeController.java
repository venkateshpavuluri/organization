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

import com.mnt.erp.bean.MaintenanceProblemType;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author yogi
 * 
 */
@Controller
public class MaintenanceProblemTypeController {

    List<Object[]> list = null;
    Iterator<Object[]> iterator = null;
    String sql;

    @Autowired
    ERPDao dao;

    @Autowired
    XmlLabelsService xmlService;
    @Autowired
    MenuService menuService;
    @Autowired
    AuditLogService auditLogService;
    HttpSession session;

    @RequestMapping(value = "/mntProblem", method = RequestMethod.GET)
    public String getMaintenanceProblemType(
	    @ModelAttribute("mntProblemCmd") MaintenanceProblemType problemType,
	    SessionStatus status, Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);

	model.addAttribute("mntProblemCmd", new MaintenanceProblemType());

	return "mntProblemHome";
    }

    @RequestMapping(value = "/mntProblemAdd", method = RequestMethod.POST)
    @RequestScoped
    public String saveMaintenenceProblem(

    @ModelAttribute("mntProblemCmd") MaintenanceProblemType problemType,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from MaintenanceProblemType o where  o.maintenanceProblemType='"
		    + problemType.getMaintenanceProblemType()+ "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(problemType);

		map.addAttribute("problemType", problemType);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "MaintenanceProblemType", "ROW", String
				    .valueOf(problemType.getMaintenanceProblemType_Id()),
			    "1", modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("MaintenanceProblemType",
			    new MaintenanceProblemType());
		    return "redirect:mntProblem.mnt?list=" + "success" + "";
		} else {
		    return "redirect:mntProblem.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! Maintanance Problem is already exists";

		problemType.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "mntProblemHome";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:mntProblem.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/mntProblemSearch", method = RequestMethod.GET)
    public String searchMaintenenceProblem(
	    @ModelAttribute("mntProblemCmd") MaintenanceProblemType problemType,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<MaintenanceProblemType> mntProblemList = null;
	try {
	    // int iid = trainingCategory.getTrainingCategoryId();
	    mntProblemList = new ArrayList<MaintenanceProblemType>();
	    String dbField = problemType.getXmlLabel();
	    String operation = problemType.getOperations();
	    String basicSearchId = problemType.getBasicSearchId();

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
		sql = "select ag.maintenanceProblemType_Id,ag.maintenanceProblemType from MaintenanceProblemType ag";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    MaintenanceProblemType mntSearch = new MaintenanceProblemType();
		    mntSearch.setMaintenanceProblemType_Id(((Integer) obj[0]));
		    mntSearch.setMaintenanceProblemType((String) obj[1]);

		    mntProblemList.add(mntSearch);
		}

	    } else {

		sql = "select ag.maintenanceProblemType_Id,ag.maintenanceProblemType from MaintenanceProblemType ag where ag."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    MaintenanceProblemType mntSearch = new MaintenanceProblemType();
		    mntSearch.setMaintenanceProblemType_Id(((Integer) obj[0]));
		    mntSearch.setMaintenanceProblemType(((String) obj[1]));
		    mntProblemList.add(mntSearch);
		}

	    }
	    request.setAttribute("mntProblemBeans", mntProblemList);
	    // model.addAttribute("accountGroup", new AccountGroupBean());
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "mntProblemHome";
    }

    @RequestMapping(value = "/mntProblemEdit", method = RequestMethod.GET)
    public String editMntProblem(
	    @ModelAttribute("mntProblemCmd") MaintenanceProblemType problemType,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("mntProblemEdit"));
	// List<Licence> licenceEdit=null;
	try {

	    sql = "select ag.maintenanceProblemType_Id,ag.maintenanceProblemType from MaintenanceProblemType ag where ag.maintenanceProblemType_Id='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		problemType.setMaintenanceProblemType_Id(((Integer) obj[0]));
		problemType.setMaintenanceProblemTypeEdit(((String) obj[1]));

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "mntProblemHome";

    }

    @RequestMapping(value = "/mntProblemUpdate", method = RequestMethod.POST)
    public String updateMntProblem(
	    @ModelAttribute("mntProblemCmd") MaintenanceProblemType problemType,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String editName = problemType.getMaintenanceProblemTypeEdit();
	int genId = problemType.getMaintenanceProblemType_Id();

	String AGSuccessdupedit = null;
	Long id = 0L;
	try {
	    sql = "select count(*) from MaintenanceProblemType ab where ab.maintenanceProblemType='"
		    + editName + "'and ab.maintenanceProblemType_Id!='" + genId + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		problemType.setMaintenanceProblemType(((problemType.getMaintenanceProblemTypeEdit())));

		int message = dao.updateDetails(problemType);

		if (message != 0) {
		    request.setAttribute("mntProblemUpdate",
			    "Maintenence Problem Data Updated Successfully");
		} else {
		    request.setAttribute("mntProblemUpdateFail",
			    "Maintenece Problem Data Updated Did not updated");
		}
	    } else {
		AGSuccessdupedit = "Warning ! Maintenance problem is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "mntProblemHome";
	    }
	    model.addAttribute("problemType", new MaintenanceProblemType());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "mntProblemHome";
    }

    @RequestMapping(value = "/mntProblemDelete", method = RequestMethod.GET)
    public String maintenenceProblemDelete(HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer
		    .parseInt(request.getParameter("mntProblemDelete"));
	    MaintenanceProblemType category = new MaintenanceProblemType();
	    category.setMaintenanceProblemType_Id(groupId);

	    int msg = dao.deleteDetails(category);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "MaintenanceProblemType", "ROW",
			String.valueOf(groupId), "1", modifiedDate, session
				.getAttribute("userName").toString());
		request.setAttribute("mntProblemDelete",
			"Maintenance Problem Data is Deleted Successfully");
	    } else {
		request.setAttribute("mntProblemDeleteFail",
			"Maintenance Problem Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("mntProblemCmd", new MaintenanceProblemType());
	return "mntProblemHome";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "mntProblem";

	Map<String, String> map = new HashMap<String, String>();

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }

}
