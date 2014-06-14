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

import com.mnt.erp.bean.TrainingCategory;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author yogi
 * 
 */
@Controller
public class TrainingCategoryController {
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
    

    @RequestMapping(value = "/trainingCategory", method = RequestMethod.GET)
    public String gettrainingCategory(
	    @ModelAttribute("trainingCategoryCmd") TrainingCategory trainingCategory,
	    SessionStatus status, Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);

	model.addAttribute("trainingCategoryCmd", new TrainingCategory());

	return "trainingCategoryView";
    }

    @RequestMapping(value = "/trainingCategoryAdd", method = RequestMethod.POST)
    @RequestScoped
    public String saveTrainingCategory(

    @ModelAttribute("trainingCategoryCmd") TrainingCategory trainingCategory,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from TrainingCategory o where  o.trainingCategory='"
		    + trainingCategory.getTrainingCategory() + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(trainingCategory);

		map.addAttribute("trainingCategory", trainingCategory);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "TrainingCategory", "ROW", String
				    .valueOf(trainingCategory
					    .getTrainingCategoryId()), "1",
			    modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("TrainingCategory",
			    new TrainingCategory());
		    return "redirect:trainingCategory.mnt?list=" + "success"
			    + "";
		} else {
		    return "redirect:trainingCategory.mnt?listwar=" + "fail"
			    + "";
		}
	    } else {
		AGSuccessdup = "Warning ! TrainingCategory is already exists";

		trainingCategory.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "trainingCategoryView";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:TrainingCategory.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/trainingCategorySearch", method = RequestMethod.GET)
    public String searchTrainingCategory(
	    @ModelAttribute("trainingCategoryCmd") TrainingCategory trainingCategory,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<TrainingCategory> trainingList = null;
	try {
	    // int iid = trainingCategory.getTrainingCategoryId();
	    trainingList = new ArrayList<TrainingCategory>();
	    String dbField = trainingCategory.getXmlLabel();
	    String operation = trainingCategory.getOperations();
	    String basicSearchId = trainingCategory.getBasicSearchId();

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
		sql = "select ag.trainingCategoryId,ag.trainingCategory from TrainingCategory ag";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    TrainingCategory trainingSearch = new TrainingCategory();
		    trainingSearch.setTrainingCategoryId((Integer) obj[0]);
		    trainingSearch.setTrainingCategory((String) obj[1]);

		    trainingList.add(trainingSearch);
		}

	    } else {

		// list = accountgroupservice.searchAccountGroupsWithId(iid);
		sql = "select ag.trainingCategoryId,ag.trainingCategory from TrainingCategory ag where ag."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    TrainingCategory trainingSearch = new TrainingCategory();
		    trainingSearch.setTrainingCategoryId((Integer) obj[0]);
		    trainingSearch.setTrainingCategory((String) obj[1]);

		    trainingList.add(trainingSearch);
		}

	    }
	    request.setAttribute("licenceBeans", trainingList);
	    // model.addAttribute("accountGroup", new AccountGroupBean());
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "trainingCategoryView";
    }

    @RequestMapping(value = "/trainingCategoryEdit", method = RequestMethod.GET)
    public String editTrainingCategory(
	    @ModelAttribute("trainingCategoryCmd") TrainingCategory trainingCategory,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("trainingCategoryEdit"));
	// List<Licence> licenceEdit=null;
	try {

	    sql = "select ag.trainingCategoryId,ag.trainingCategory from TrainingCategory ag where ag.trainingCategoryId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		trainingCategory.setTrainingCategoryId((Integer) obj[0]);
		trainingCategory.setTrainingCategoryEdit((String) obj[1]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "trainingCategoryView";

    }

    @RequestMapping(value = "/trainingCategoryUpdate", method = RequestMethod.POST)
    public String updateTrainingCategory(
	    @ModelAttribute("trainingCategoryCmd") TrainingCategory trainingCategory,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String licenceName = trainingCategory.getTrainingCategoryEdit();
	int licenceId = trainingCategory.getTrainingCategoryId();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from TrainingCategory ab where ab.trainingCategory='"
		    + licenceName
		    + "'and ab.trainingCategoryId!='"
		    + licenceId
		    + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		trainingCategory.setTrainingCategory((trainingCategory
			.getTrainingCategoryEdit()));

		int message = dao.updateDetails(trainingCategory);

		if (message != 0) {
		    request.setAttribute("TrainingCategoryUpdate",
			    "TrainingCategory Data Updated Successfully");

		} else {
		    request.setAttribute("TrainingCategoryUpdateFail",
			    "TrainingCategory Data Updated Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! TrainingCategory is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "trainingCategoryView";
	    }
	    model.addAttribute("trainingCategory", new TrainingCategory());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "trainingCategoryView";
    }

    @RequestMapping(value = "/trainingCategoryDelete", method = RequestMethod.GET)
    public String trainingCategoryDelete(HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request
		    .getParameter("trainingCategoryDelete"));
	    TrainingCategory licence = new TrainingCategory();
	    licence.setTrainingCategoryId(groupId);

	    int msg = dao.deleteDetails(licence);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "TrainingCategory", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("TrainingCategoryDelete",
			"TrainingCategory Data is Deleted Successfully");
	    } else {
		request.setAttribute("TrainingCategoryDeleteFail",
			"TrainingCategory Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("trainingCategoryCmd", new TrainingCategory());
	return "trainingCategoryView";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "trainingCategory";

	Map<String, String> map = new HashMap<String, String>();

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
