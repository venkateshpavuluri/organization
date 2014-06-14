/**
 * 
 */
package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import com.mnt.erp.bean.ClaimTypeBean;
import com.mnt.erp.bean.EventType;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author yogi
 * 
 */
@Controller
public class ClaimTypeController {
    @Autowired
    ERPDao erpDao;
    @Autowired
    XmlLabelsService xmlService;
    @Autowired
    MenuService menuService;
    @Autowired
    AuditLogService auditLogService;
    HttpSession session = null;
    String message = null;

    @RequestMapping(value = "/claimTypeHome", method = RequestMethod.GET)
    public String  claimTypeHome(
	    @ModelAttribute("claimTypeCmd") ClaimTypeBean claimTypeBean,Model model,
	    HttpServletResponse response, HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("claimTypeHome.mnt",
		session.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	model.addAttribute("eventTypeCmd", new EventType());
	return "claimTypeView";
    }

    @RequestMapping(value = "/claimTypeAdd", method = RequestMethod.POST)
    public String saveClaimType(
	    @ModelAttribute("claimTypeCmd") ClaimTypeBean claimTypeBean,
	    HttpServletRequest request, SessionStatus status,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	String claimTypeSave = null;

	ClaimTypeBean ctBean = (ClaimTypeBean) claimTypeBean;
	try {
	    int i = erpDao.saveDetails(ctBean);
	    status.setComplete();
	    if (i != 0) {
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(new Date());
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "A", "ClaimType", "ROW", String
			.valueOf(ctBean.getClaimTypeId()), "1", modifiedDate,
			session.getAttribute("userName").toString());
		claimTypeSave = "Claim type data saved successfully";
	    } else {
		claimTypeSave = "Claim Type Data Insertion Failures";
		return "redirect:claimTypeHome.mnt?addClaimTypeFail="
			+ claimTypeSave + "";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    claimTypeSave = "Claim Type Data Insertion Failures";
	    return "redirect:claimTypeHome.mnt?addClaimTypeFail="
		    + claimTypeSave + "";
	}
	return "redirect:claimTypeHome.mnt?addClaimTypesus=" + claimTypeSave
		+ "";
    }

    @RequestMapping(value = "/checkClaimTypeAddDuplicate", method = RequestMethod.POST)
    public @ResponseBody
    String checkClaimTypeAddDuplicate(HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam("claimName") String claimName) {
	response.setCharacterEncoding("UTF-8");
	
	Long checkEventName = erpDao
		.duplicateCheck("select count(*) from ClaimTypeBean e where e.claimType='"
			+ claimName + "'");
	if (checkEventName != 0) {
	    message = "Warning ! Claimt Type is Already exists. Please try some other name";
	} else {
	    message = "";
	}
	return message;
    }

    @RequestMapping(value = "/checkClaimTypeUpdateDuplicate", method = RequestMethod.POST)
    public @ResponseBody
    String checkClaimTypeUpdateDuplicate(HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam("claimName") String claimType,
	    @RequestParam("claimId") int claimTypeId) {
	response.setCharacterEncoding("UTF-8");
	long checkName = erpDao
		.duplicateCheck("select count(*) from ClaimTypeBean where claimType='"
			+ claimType
			+ "'"
			+ "and claimTypeId!='"
			+ claimTypeId
			+ "'");

	if (checkName != 0) {
	    message = "Warning ! Claim Type is Already exists. Please try some other name";
	} else {
	    message = "";
	}
	return message;
    }

    @RequestMapping(value = "/claimTypeSearch", method = RequestMethod.GET)
    public String searchClaimType(
    @ModelAttribute("claimTypeCmd") ClaimTypeBean claimTypeBeanSearch,
	    Model model, HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<Object[]> list = null;
	List<ClaimTypeBean> claimList = new ArrayList<ClaimTypeBean>();

	try {
	    String dbField = claimTypeBeanSearch.getXmlLabel();
	    String operation = claimTypeBeanSearch.getOperations();
	    String basicSearchId = claimTypeBeanSearch.getBasicSearchId();

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
		String sql = "select lt.claimTypeId,lt.claimType from ClaimTypeBean lt order by lt.claimType ";
		list = erpDao.searchDetails(sql);

	    } else {
		String sql = "select lt.claimTypeId,lt.claimType from ClaimTypeBean lt where lt."
			+ dbField
			+ " "
			+ operation
			+ " '"
			+ basicSearchId
			+ "'order by lt.claimType";
		list = erpDao.searchDetails(sql);
	    }

	    Iterator<Object[]> iterator = list.iterator();
	    while (iterator.hasNext()) {
		ClaimTypeBean ab = new ClaimTypeBean();
		Object[] oblt = (Object[]) iterator.next();
		ab.setClaimTypeId((Integer) oblt[0]);
		ab.setClaimType((String) oblt[1]);
		claimList.add(ab);
	    }
	    request.setAttribute("claimList", claimList);

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "claimTypeView";

    }

    @RequestMapping(value = "/claimTypeEdit", method = RequestMethod.GET)
    public String claimTypeEdit(
    @ModelAttribute("claimTypeCmd") ClaimTypeBean claimTypeEdit,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("claimTypeId"));
	List<Object[]> list = null;
	List<ClaimTypeBean> claimEdit = new ArrayList<ClaimTypeBean>();
	try {
	    list = erpDao.searchDetails("select lt.claimTypeId,lt.claimType from ClaimTypeBean lt where lt.claimTypeId="+ id + "");
	    Iterator<Object[]> iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();
		claimTypeEdit.setClaimTypeId((Integer) obj[0]);
		claimTypeEdit.setClaimType((String) obj[1]);
		claimEdit.add(claimTypeEdit);
	    }
	    request.setAttribute("claimEdit", claimEdit);
	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    list = null;
	}
	return "claimTypeView";
    }

    @RequestMapping(value = "/claimTypeUpdate", method = RequestMethod.POST)
    public String claimTypeUpdate(
	    @ModelAttribute("claimTypeCmd") ClaimTypeBean claimTypeUpdate,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	String claimTypeUpadted = null;
	ClaimTypeBean claimTypeBeanUpdate = (ClaimTypeBean) claimTypeUpdate;
	try {
	    int msg = erpDao.updateDetails(claimTypeBeanUpdate);
	    if (msg != 0) {
		claimTypeUpadted = "Claim  Type Data Updated Successfully";
	    } else {
		claimTypeUpadted = "Claim Type Data Updation Failed";
		return "redirect:claimTypeHome.mnt?updateClaimTypeFail="
			+ claimTypeUpadted + "";
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:claimTypeHome.mnt?updateClaimTypeFail="
		    + claimTypeUpadted + "";
	}
	return "redirect:claimTypeHome.mnt?updateClaimTypesus="
		+ claimTypeUpadted + "";
    }

    @RequestMapping(value = "/claimTypeDelete", method = RequestMethod.GET)
    public String claimTypeDelete(

    @ModelAttribute("claimTypeCmd") ClaimTypeBean claimTypeDelete,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	String claimTypeDeleted = null;
	int id = Integer.parseInt(request.getParameter("claimTypeId"));
	claimTypeDelete.setClaimTypeId(id);
	try {
	    int msg = erpDao.deleteDetails(claimTypeDelete);
	    if (msg != 0) {
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(new Date());
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "ClaimType", "ROW", String
			.valueOf(id), "1", modifiedDate,
			session.getAttribute("userName").toString());
		claimTypeDeleted = "Claim Type Deleted Successfully";
	    } else {
		claimTypeDeleted = "claim Type Deletion Failed";
		return "redirect:claimTypeHome.mnt?deleteclaimTypeFail="
			+ claimTypeDeleted + "";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    claimTypeDeleted = "Claim Type  Deletion Failed";
	    return "redirect:claimTypeHome.mnt?deleteClaimTypeFail="
		    + claimTypeDeleted + "";
	}

	return "redirect:claimTypeHome.mnt?deleteClaimTypesus="
		+ claimTypeDeleted + "";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "claimType";
	Map<String, String> map = null;
	try {
	    map = xmlService.populateXmlLabels(name);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
