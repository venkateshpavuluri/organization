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

import com.mnt.erp.bean.EventType;
import com.mnt.erp.bean.Licence;

import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author yogi
 *
 */
@Controller
public class EventTypeController {
    
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

    @RequestMapping(value = "/eventType", method = RequestMethod.GET)
    public String getEventType(@ModelAttribute("eventTypeCmd") EventType eventType, SessionStatus status,
	    Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("eventType.mnt", session
		.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	model.addAttribute("eventTypeCmd", new EventType());

	return "eventTypeView";
    }

    @RequestMapping(value = "/eventTypeAdd", method = RequestMethod.POST)
    @RequestScoped
    public String saveEventType(

    @ModelAttribute("eventTypeCmd") EventType eventType,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from EventType o where  o.eventType='"
		    + eventType.getEventType() + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(eventType);

		map.addAttribute("eventType", eventType);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "EventType", "ROW", String.valueOf(eventType.getEventTypeId()),
			    "1", modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("eventTypeCmd", new EventType());
		    return "redirect:eventType.mnt?list=" + "success" + "";
		} else {
		    return "redirect:eventType.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! Event type is already exists";

		eventType.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "eventTypeView";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:eventType.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/searchEventType", method = RequestMethod.GET)
    public String searchEventType(@ModelAttribute("eventTypeCmd") EventType eventType,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<EventType> eventTypeList = null;
	try {
	    int iid = eventType.getEventTypeId();
	    eventTypeList = new ArrayList<EventType>();
	    String dbField = eventType.getXmlLabel();
	    String operation = eventType.getOperations();
	    String basicSearchId = eventType.getBasicSearchId();

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
		sql = "select ag.eventTypeId,ag.eventType from EventType ag";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    EventType eventTypesearch = new EventType();
		    eventTypesearch.setEventTypeId((Integer) obj[0]);
		    eventTypesearch.setEventType((String) obj[1]);

		    eventTypeList.add(eventTypesearch);
		}

	    } else {

		// list = accountgroupservice.searchAccountGroupsWithId(iid);
		sql = "select ag.eventTypeId,ag.eventType from EventType ag where ag."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    EventType eventTypesearch = new EventType();
		    eventTypesearch.setEventTypeId((Integer) obj[0]);
		    eventTypesearch.setEventType((String) obj[1]);

		    eventTypeList.add(eventTypesearch);
		}

	    }
	    request.setAttribute("licenceBeans", eventTypeList);
	    // model.addAttribute("accountGroup", new AccountGroupBean());
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "eventTypeView";
    }

    @RequestMapping(value = "/eventTypeEdit", method = RequestMethod.GET)
    public String eventTypeEdit(@ModelAttribute("eventTypeCmd") EventType eventType,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("eventTypeEdit"));
	List<Licence> licenceEdit = null;
	try {

	    sql = "select ag.eventTypeId,ag.eventType from EventType ag where ag.eventTypeId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		eventType.setEventTypeId((Integer) obj[0]);
		eventType.setEventTypeEdit((String) obj[1]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "eventTypeView";

    }

    @RequestMapping(value = "/eventTypeUpdate", method = RequestMethod.POST)
    public String eventTypeUpdate(@ModelAttribute("eventTypeCmd") EventType eventType,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String licenceName = eventType.getEventTypeEdit();
	int licenceId = eventType.getEventTypeId();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from EventType ab where ab.eventType='"
		    + licenceName + "'and ab.eventTypeId!='" + licenceId + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		eventType.setEventType(eventType.getEventTypeEdit());

		int message = dao.updateDetails(eventType);

		if (message != 0) {
		    request.setAttribute("EventTypeUpdate",
			    "Event Type Data Updated Successfully");

		} else {
		    request.setAttribute("EventTypeUpdateFail",
			    "Event Type Data Updated Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! Event Type is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "eventTypeView";
	    }
	    model.addAttribute("eventTypeCmd", new EventType());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "eventTypeView";
    }

    @RequestMapping(value = "/eventTypeDelete", method = RequestMethod.GET)
    public String eventTypeDelete(@ModelAttribute("eventTypeCmd")EventType eventType,
	    HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request.getParameter("eventTypeDelete"));
	    EventType licence = new EventType();
	    licence.setEventTypeId(groupId);

	    int msg = dao.deleteDetails(licence);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "EventType", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("EventTypeDelete",
			"Event Type Data is Deleted Successfully");
	    } else {
		request.setAttribute("EventTypeDeleteFail",
			"Event Type Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("eventTypeCmd", new EventType());
	return "eventTypeView";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "eventType";

	Map<String, String> map = new HashMap<String, String>();

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }

}

