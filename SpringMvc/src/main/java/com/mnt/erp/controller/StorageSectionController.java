package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.mnt.erp.bean.StorageSectionBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class StorageSectionController {

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

    @RequestMapping(value = "/storageSection", method = RequestMethod.GET)
    public String getStSection(
	    @ModelAttribute("StSectionCmd") StorageSectionBean storageSectionBean,
	    SessionStatus status, Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("storageSection.mnt",
		session.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	model.addAttribute("StSectionCmd", new StorageSectionBean());

	return "stSectionHome";
    }

    @RequestMapping(value = "/saveStSection", method = RequestMethod.POST)
    @RequestScoped
    public String saveStorageSection(

    @ModelAttribute("StSectionCmd") StorageSectionBean storageSectionBean,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String SSSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from StorageSectionBean o where  o.storageSection='"
		    + storageSectionBean.getStorageSection() + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(storageSectionBean);

		map.addAttribute("storageSection", storageSectionBean);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "StorageSectionBean", "ROW", String
				    .valueOf(storageSectionBean
					    .getStorageSectionId()), "1",
			    modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("StSectionCmd", new StorageSectionBean());
		    return "redirect:storageSection.mnt?list=" + "success" + "";
		} else {
		    return "redirect:storageSection.mnt?listwar=" + "fail" + "";
		}
	    } else {
		SSSuccessdup = "Warning ! Storage Section is already exists";

		storageSectionBean.setAid(1);
		request.setAttribute("SSSuccessdup", SSSuccessdup);
		return "stSectionHome";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:storageSection.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/searchStorageSection", method = RequestMethod.GET)
    public String searchStorageSection(
	    @ModelAttribute("StSectionCmd") StorageSectionBean storageSectionBean,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<StorageSectionBean> sectionList = null;
	try {
	    storageSectionBean.getStorageSectionId();
	    sectionList = new ArrayList<StorageSectionBean>();
	    String dbField = storageSectionBean.getXmlLabel();
	    String operation = storageSectionBean.getOperations();
	    String basicSearchId = storageSectionBean.getBasicSearchId();

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
		sql = "select ag.storageSectionId,ag.storageSection from StorageSectionBean ag";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    StorageSectionBean sectionsearch = new StorageSectionBean();
		    sectionsearch.setStorageSectionId((Integer) obj[0]);
		    sectionsearch.setStorageSection((String) obj[1]);

		    sectionList.add(sectionsearch);
		}

	    } else {

		// list = accountgroupservice.searchAccountGroupsWithId(iid);
		sql = "select ag.storageSectionId,ag.storageSection from StorageSectionBean ag where ag."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    StorageSectionBean storageSearch = new StorageSectionBean();
		    storageSearch.setStorageSectionId((Integer) obj[0]);
		    storageSearch.setStorageSection((String) obj[1]);

		    sectionList.add(storageSearch);
		}

	    }
	    request.setAttribute("storageValues", sectionList);
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "stSectionHome";
    }

    @RequestMapping(value = "/storageSectionEdit", method = RequestMethod.GET)
    public String editStorageSection(
	    @ModelAttribute("StSectionCmd") StorageSectionBean storageSectionBean,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("storageSectionId"));
	try {

	    sql = "select ss.storageSectionId,ss.storageSection from StorageSectionBean ss where ss.storageSectionId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		storageSectionBean.setStorageSectionId((Integer) obj[0]);
		storageSectionBean.setStorageSectionEdit((String) obj[1]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "stSectionHome";

    }

    @RequestMapping(value = "/storageSectionUpdate", method = RequestMethod.POST)
    public String updateStorageSection(
	    @ModelAttribute("StSectionCmd") StorageSectionBean storageSectionBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String storageName = storageSectionBean.getStorageSectionEdit();
	int storageId = storageSectionBean.getStorageSectionId();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from StorageSectionBean ab where ab.storageSection='"
		    + storageName
		    + "'and ab.storageSectionId!='"
		    + storageId
		    + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		storageSectionBean.setStorageSection(storageSectionBean
			.getStorageSectionEdit());

		int message = dao.updateDetails(storageSectionBean);

		if (message != 0) {
		    request.setAttribute("StorageSectionUpdate",
			    "Storage Section Data Updated Successfully");

		} else {
		    request.setAttribute("StorageSectionUpdateFail",
			    "Storage Section Data Updated Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! Storage Section is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "stSectionHome";
	    }
	    model.addAttribute("StSectionCmd", new StorageSectionBean());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "stSectionHome";
    }

    @RequestMapping(value = "/storageSectionDelete", method = RequestMethod.GET)
    public String deleteStorageSection(
	    @ModelAttribute("StSectionCmd") StorageSectionBean storageSectionBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer
		    .parseInt(request.getParameter("storageSectionId"));
	    StorageSectionBean storage = new StorageSectionBean();
	    storage.setStorageSectionId(groupId);

	    int msg = dao.deleteDetails(storage);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "StorageSectionBean", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("StorageSectionDelete",
			"Storage Section Data is Deleted Successfully");
	    } else {
		request.setAttribute("StorageSectionDeleteFail",
			"Storage Section Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("StSectionCmd", new StorageSectionBean());
	return "stSectionHome";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "storageSection";

	Map<String, String> map = null;

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
