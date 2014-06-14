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

import com.mnt.erp.bean.MaintenanceCategory;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author yogi
 *
 */
@Controller
public class MaintananceCategoryController {

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
    

    @RequestMapping(value = "/maintananceCategory", method = RequestMethod.GET)
    public String getMaintananceCategory(
	    @ModelAttribute("mntCatCmd") MaintenanceCategory maintenanceCategory,
	    SessionStatus status, Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);

	model.addAttribute("mntCatCmd", new MaintenanceCategory());

	return "maintananceView";
    }
    
    @RequestMapping(value = "/maintananceCategoryAdd", method = RequestMethod.POST)
    @RequestScoped
    public String saveMaintananceCategory(

    @ModelAttribute("mntCatCmd") MaintenanceCategory maintenanceCategory,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from MaintenanceCategory o where  o.maintenanceCategory='"
		    + maintenanceCategory.getMaintenanceCategory()+ "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(maintenanceCategory);

		map.addAttribute("maintenanceCategory", maintenanceCategory);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "MaintenanceCategory", "ROW", String
				    .valueOf(maintenanceCategory
					    .getMaintenanceCategoryId()), "1",
			    modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("MaintenanceCategory",
			    new MaintenanceCategory());
		    return "redirect:maintananceCategory.mnt?list=" + "success"
			    + "";
		} else {
		    return "redirect:maintananceCategory.mnt?listwar=" + "fail"
			    + "";
		}
	    } else {
		AGSuccessdup = "Warning ! Maintanance Category is already exists";

		maintenanceCategory.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "maintananceView";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:maintananceCategory.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/maintananceCategorySearch", method = RequestMethod.GET)
    public String searchMaintananceCategory(
	    @ModelAttribute("mntCatCmd") MaintenanceCategory maintananceCategory,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<MaintenanceCategory> mntList = null;
	try {
	    // int iid = trainingCategory.getTrainingCategoryId();
	    mntList= new ArrayList<MaintenanceCategory>();
	    String dbField = maintananceCategory.getXmlLabel();
	    String operation = maintananceCategory.getOperations();
	    String basicSearchId = maintananceCategory.getBasicSearchId();

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
		sql = "select ag.maintenanceCategoryId,ag.maintenanceCategory from MaintenanceCategory ag";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    MaintenanceCategory mntSearch = new MaintenanceCategory();
		    mntSearch.setMaintenanceCategoryId(((Integer) obj[0]));
		    mntSearch.setMaintenanceCategory((String) obj[1]);

		    mntList.add(mntSearch);
		}

	    } else {

		sql = "select ag.maintenanceCategoryId,ag.maintenanceCategory from MaintenanceCategory ag where ag."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    MaintenanceCategory mntSearch = new MaintenanceCategory();
		    mntSearch.setMaintenanceCategoryId(((Integer) obj[0]));
		    mntSearch.setMaintenanceCategory(((String) obj[1]));
		    mntList.add(mntSearch);
		}

	    }
	    request.setAttribute("mntBeans", mntList);
	    // model.addAttribute("accountGroup", new AccountGroupBean());
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "maintananceView";
    }

    @RequestMapping(value = "/maintananceCategoryEdit", method = RequestMethod.GET)
    public String editMaintananceCategory(
	    @ModelAttribute("mntCatCmd") MaintenanceCategory maintenanceCategory,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("maintananceCategoryEdit"));
	// List<Licence> licenceEdit=null;
	try {

	    sql = "select ag.maintenanceCategoryId,ag.maintenanceCategory from MaintenanceCategory ag where ag.maintenanceCategoryId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		maintenanceCategory.setMaintenanceCategoryId(((Integer) obj[0]));
		maintenanceCategory.setMaintananceCategoryEdit(((String) obj[1]));

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "maintananceView";

    }

    @RequestMapping(value = "/maintenanceCategoryUpdate", method = RequestMethod.POST)
    public String updateMaintenanceCategory(
	    @ModelAttribute("mntCatCmd") MaintenanceCategory maintenanceCategory, 
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String editName = maintenanceCategory.getMaintananceCategoryEdit();
	int genId = maintenanceCategory.getMaintenanceCategoryId();

	String AGSuccessdupedit = null;
	Long id = 0L;
	try {
	    sql = "select count(*) from MaintenanceCategory ab where ab.maintenanceCategory='"
		    + editName
		    + "'and ab.maintenanceCategoryId!='"
		    + genId
		    + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		maintenanceCategory.setMaintenanceCategory(((maintenanceCategory.getMaintananceCategoryEdit())));

		int message = dao.updateDetails(maintenanceCategory);

		if (message != 0) {
		    request.setAttribute("maintenanceCategoryUpdate",
			    "MaintenanceCategory Data Updated Successfully");
		} else {
		    request.setAttribute("maintenanceCategoryUpdateFail",
			    "MaintenanceCategory Data Updated Did not updated");
		}
	    } else {
		AGSuccessdupedit = "Warning ! Maintenance category is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "maintananceView";
	    }
	    model.addAttribute("maintenanceCategory", new MaintenanceCategory());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "maintananceView";
    }

    @RequestMapping(value = "/maintenanceCategoryDelete", method = RequestMethod.GET)
    public String maintenanceCategoryDelete(HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request
		    .getParameter("maintenanceCategoryDelete"));
	    MaintenanceCategory category = new MaintenanceCategory();
	    category.setMaintenanceCategoryId(groupId);

	    int msg = dao.deleteDetails(category);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "MaintenanceCategory", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("maintenanceCategoryDelete",
			"Maintenance Category Data is Deleted Successfully");
	    } else {
		request.setAttribute("MaintenanceCategoryDeleteFail",
			"MaintenanceCategory Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("mntCatCmd", new MaintenanceCategory());
	return "maintananceView";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "maintenanceCategory";

	Map<String, String> map = new HashMap<String, String>();

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
