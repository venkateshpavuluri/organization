/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.controller;

import java.io.IOException;
import java.text.ParseException;
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
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.EventBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 09-05-2014
 */
@Controller
public class EventController {
    @Autowired
    ERPDao erpDao;
    @Autowired
    XmlLabelsService xmlService;
    @Autowired
    MenuService menuService;
    @Autowired
    DateConversionService dateService;
    @Autowired
    AuditLogService auditLogService;
    HttpSession session = null;
    String message = null;

    @RequestMapping(value = "/eventHome", method = RequestMethod.GET)
    public ModelAndView eventHome(
	    @ModelAttribute("eventCmd") EventBean eventBean,
	    HttpServletResponse response, HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("eventHome.mnt", session
		.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	return new ModelAndView("eventHome", "eventCmd", eventBean);
    }

    @RequestMapping(value = "/EventAdd", method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("eventCmd") EventBean eventBean,
	    HttpServletRequest request, SessionStatus status,
	    HttpServletResponse response) throws IOException, ParseException {
	response.setCharacterEncoding("UTF-8");
	String eventSave = null;
	eventBean.setFromDate(dateService.dateFormat(
		dateService.dateParse(eventBean.getFromDate(), "au"), "au"));
	eventBean.setToDate(dateService.dateFormat(
		dateService.dateParse(eventBean.getToDate(), "au"), "au"));
	EventBean ltBean = (EventBean) eventBean;
	try {
	    int i = erpDao.saveDetails(ltBean);
	    status.setComplete();
	    if (i != 0) {
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(new Date());
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "A", "Event", "ROW", String.valueOf(ltBean
			.getEventId()), "1", modifiedDate, session
			.getAttribute("userName").toString());
		eventSave = "Event Data Saved Successfully";
	    } else {
		eventSave = "Event Data Insertion Failures";
		return "redirect:eventHome.mnt?addEventFail=" + eventSave + "";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    eventSave = "Event Data Insertion Failures";
	    return "redirect:eventHome.mnt?addEventFail=" + eventSave + "";
	}
	return "redirect:eventHome.mnt?addEventsus=" + eventSave + "";
    }

    @RequestMapping(value = "/checkEventAddDuplicate", method = RequestMethod.POST)
    public @ResponseBody
    String checkEventAddDuplicate(HttpServletRequest request,
	    HttpServletResponse response, @RequestParam("eventID") String event) {
	response.setCharacterEncoding("UTF-8");
	Long checkEventName = erpDao
		.duplicateCheck("select count(*) from EventBean e where e.event='"
			+ event + "'");
	if (checkEventName != 0) {
	    message = "Warning ! Event is Already exists. Please try some other name";
	} else {
	    message = "";
	}
	return message;
    }

    @RequestMapping(value = "/checkEventUpdateDuplicate", method = RequestMethod.POST)
    public @ResponseBody
    String checkEventUpdateDuplicate(HttpServletRequest request,
	    HttpServletResponse response,
	    @RequestParam("eventEdit") String event,
	    @RequestParam("eventIdEdit") int eventId) {
	response.setCharacterEncoding("UTF-8");
	long checkEventName = erpDao
		.duplicateCheck("select count(*) from EventBean where event='"
			+ event + "'" + "and eventId!='" + eventId + "'");

	if (checkEventName != 0) {
	    message = "Warning ! Event is Already exists. Please try some other name";
	} else {
	    message = "";
	}
	return message;
    }

    @RequestMapping(value = "/EventSearch", method = RequestMethod.GET)
    public String searchEvent(

    @ModelAttribute("eventCmd") EventBean EventSearch, Model model,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<Object[]> list = null;
	List<EventBean> EventList = new ArrayList<EventBean>();

	try {
	    String dbField = EventSearch.getXmlLabel();
	    String operation = EventSearch.getOperations();
	    String basicSearchId = EventSearch.getBasicSearchId();

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
		String sql = "select lt.eventId,lt.event, lt.fromDate, lt.toDate, lt.fromTM, lt.toTM, lt.venue, lt.contactPerson, lt.contactPhone, lt.reference from EventBean lt order by lt.event ";
		list = erpDao.searchDetails(sql);

	    } else {
		String sql = "select lt.eventId,lt.event, lt.fromDate, lt.toDate, lt.fromTM, lt.toTM, lt.venue, lt.contactPerson, lt.contactPhone, lt.reference from EventBean lt where lt."
			+ dbField
			+ " "
			+ operation
			+ " '"
			+ basicSearchId
			+ "'order by lt.event";
		list = erpDao.searchDetails(sql);
	    }

	    Iterator<Object[]> iterator = list.iterator();
	    while (iterator.hasNext()) {
		EventBean ab = new EventBean();
		Object[] oblt = (Object[]) iterator.next();
		ab.setEventId((Integer) oblt[0]);
		ab.setEvent((String) oblt[1]);
		ab.setFromDate(dateService.dateFormat(
			dateService.dateParse((String) oblt[2], "se"), "se"));
		ab.setToDate(dateService.dateFormat(
			dateService.dateParse((String) oblt[3], "se"), "se"));
		ab.setFromTM((String) oblt[4]);
		ab.setToTM((String) oblt[5]);
		ab.setVenue((String) oblt[6]);
		ab.setContactPerson((String) oblt[7]);
		ab.setContactPhone((String) oblt[8]);
		ab.setReference((String) oblt[9]);
		EventList.add(ab);
	    }

	    request.setAttribute("EventList", EventList);

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "eventHome";

    }

    @RequestMapping(value = "/EventEdit", method = RequestMethod.GET)
    public String eventEdit(

    @ModelAttribute("eventCmd") EventBean eventEdit,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	int id = Integer.parseInt(request.getParameter("EventId"));
	List<Object[]> list = null;
	List<EventBean> EventEdit = new ArrayList<EventBean>();
	try {
	    list = erpDao
		    .searchDetails("select lt.eventId,lt.event, lt.fromDate, lt.toDate, lt.fromTM, lt.toTM, lt.venue, lt.contactPerson, lt.contactPhone, lt.reference from EventBean lt where lt.eventId="
			    + id + "");
	    Iterator<Object[]> iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();
		eventEdit.setEventId((Integer) obj[0]);
		eventEdit.setEvent((String) obj[1]);
		eventEdit.setFromDate(dateService.dateFormat(
			dateService.dateParse((String) obj[2], "se"), "se"));
		eventEdit.setToDate(dateService.dateFormat(
			dateService.dateParse((String) obj[3], "se"), "se"));
		eventEdit.setFromTM((String) obj[4]);
		eventEdit.setToTM((String) obj[5]);
		eventEdit.setVenue((String) obj[6]);
		eventEdit.setContactPerson((String) obj[7]);
		eventEdit.setContactPhone((String) obj[8]);
		eventEdit.setReference((String) obj[9]);
		EventEdit.add(eventEdit);
	    }
	    request.setAttribute("EventEdit", EventEdit);

	} catch (Exception e) {
	    e.printStackTrace();
	} finally {
	    list = null;
	}
	return "eventHome";

    }

    @RequestMapping(value = "/EventUpdate", method = RequestMethod.POST)
    public String eventUpdate(

    @ModelAttribute("eventCmd") EventBean EventUpdate,
	    HttpServletRequest request, HttpServletResponse response)
	    throws IOException, ParseException {
	response.setCharacterEncoding("UTF-8");
	String EventUpadted = null;
	EventBean eventUpdate = (EventBean) EventUpdate;
	eventUpdate.setFromDate(dateService.dateFormat(
		dateService.dateParse(eventUpdate.getFromDate(), "au"), "au"));
	eventUpdate.setToDate(dateService.dateFormat(
		dateService.dateParse(eventUpdate.getToDate(), "au"), "au"));
	try {
	    int msg = erpDao.updateDetails(eventUpdate);

	    if (msg != 0) {
		EventUpadted = "Event Data Updated Successfully";
	    } else {
		EventUpadted = "Event Data Updation Failed";
		return "redirect:eventHome.mnt?updateEventFail=" + EventUpadted
			+ "";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:eventHome.mnt?updateEventFail=" + EventUpadted
		    + "";
	}
	return "redirect:eventHome.mnt?updateEventsus=" + EventUpadted + "";
    }

    @RequestMapping(value = "/EventDelete", method = RequestMethod.GET)
    public String eventDelete(

    @ModelAttribute("eventCmd") EventBean EventDelete,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	String EventDeleted = null;
	int id = Integer.parseInt(request.getParameter("EventId"));
	EventDelete.setEventId(id);
	try {

	    int msg = erpDao.deleteDetails(EventDelete);
	    if (msg != 0) {
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(new Date());
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "Event", "ROW", String.valueOf(id),
			"1", modifiedDate, session.getAttribute("userName")
				.toString());
		EventDeleted = "Event  Deleted Successfully";
	    } else {

		EventDeleted = "Event  Deletion Failed";
		return "redirect:eventHome.mnt?deleteEventFail=" + EventDeleted
			+ "";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    EventDeleted = "Event  Deletion Failed";
	    return "redirect:eventHome.mnt?deleteEventFail=" + EventDeleted
		    + "";
	}

	return "redirect:eventHome.mnt?deleteEventsus=" + EventDeleted + "";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "Event";

	Map<String, String> map = null;

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }

}
