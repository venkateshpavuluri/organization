/**
 * @author yogi
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

import com.mnt.erp.bean.MediaTypeBean;

import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class MediaTypeController {
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

    @RequestMapping(value = "/mediaType", method = RequestMethod.GET)
    public String getMediaType(
	    @ModelAttribute("mediaTypeCmd") MediaTypeBean mediaTypeBean,
	    SessionStatus status, Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);

	List<String> list = menuService.getPrivilige("mediaType.mnt", session
		.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	model.addAttribute("mediaType", new MediaTypeBean());

	return "mediaTypeHome";
    }

    @RequestMapping(value = "/mediaTypeAdd", method = RequestMethod.POST)
    @RequestScoped
    public String saveMediaType(

    @ModelAttribute("mediaTypeCmd") MediaTypeBean mediaTypeBean,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	// String liSuccess = null;
	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from MediaTypeBean o where  o.mediaType='"
		    + mediaTypeBean.getMediaType() + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(mediaTypeBean);

		map.addAttribute("mediaType", mediaTypeBean);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "MediaTypeBean", "ROW", String
				    .valueOf(mediaTypeBean.getMediaTypeId()),
			    "1", modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("mediaType", new MediaTypeBean());
		    return "redirect:mediaType.mnt?list=" + "success" + "";
		} else {
		    return "redirect:mediaType.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! Media Type is already exists. Please try some other name";

		mediaTypeBean.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "mediaTypeHome";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:mediaType.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/searchMedia", method = RequestMethod.GET)
    public String searchMedia(
	    @ModelAttribute("mediaTypeCmd") MediaTypeBean mediaTypeBean,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<MediaTypeBean> mediaList = null;
	try {
	    int iid = mediaTypeBean.getMediaTypeId();
	    mediaList = new ArrayList<MediaTypeBean>();
	    String dbField = mediaTypeBean.getXmlLabel();
	    String operation = mediaTypeBean.getOperations();
	    String basicSearchId = mediaTypeBean.getBasicSearchId();

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
		sql = "select ag.mediaTypeId, ag.mediaType from MediaTypeBean ag";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    MediaTypeBean mediasearch = new MediaTypeBean();
		    mediasearch.setMediaTypeId((Integer) obj[0]);
		    mediasearch.setMediaType((String) obj[1]);

		    mediaList.add(mediasearch);
		}

	    } else {

		// list = accountgroupservice.searchAccountGroupsWithId(iid);
		sql = "select ag.mediaTypeId,ag.mediaType from MediaTypeBean ag where ag."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    MediaTypeBean mediasearch = new MediaTypeBean();
		    mediasearch.setMediaTypeId((Integer) obj[0]);
		    mediasearch.setMediaType((String) obj[1]);

		    mediaList.add(mediasearch);
		}

	    }
	    request.setAttribute("mediaValues", "mediaValues");
	    request.setAttribute("licenceBeans", mediaList);

	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "mediaTypeHome";
    }

    @RequestMapping(value = "/mediaEdit", method = RequestMethod.GET)
    public String mediaTypeEdit(
	    @ModelAttribute("mediaTypeCmd") MediaTypeBean mediaTypeBean,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("mediaEdit"));
	// List<Licence> licenceEdit = null;
	try {

	    sql = "select ag.mediaTypeId,ag.mediaType from MediaTypeBean ag where ag.mediaTypeId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		mediaTypeBean.setMediaTypeId((Integer) obj[0]);
		mediaTypeBean.setMediaTypeEdit((String) obj[1]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "mediaTypeHome";

    }

    @RequestMapping(value = "/mediaUpdate", method = RequestMethod.POST)
    public String updateMedia(
	    @ModelAttribute("mediaTypeCmd") MediaTypeBean mediaTypeBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String editName = mediaTypeBean.getMediaTypeEdit();
	int mediaId = mediaTypeBean.getMediaTypeId();

	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from MediaTypeBean ab where ab.mediaType='"
		    + editName + "'and ab.mediaTypeId!='" + mediaId + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		mediaTypeBean.setMediaType(mediaTypeBean.getMediaTypeEdit());

		int message = dao.updateDetails(mediaTypeBean);

		if (message != 0) {
		    request.setAttribute("MediaUpdate",
			    "Media Type Data Updated Successfully");

		} else {
		    request.setAttribute("MediaUpdateFail",
			    "Media Type Data Updated Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! Media Type is already exists. Please try some other name";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		mediaTypeBean.setAid(1);
		return "mediaTypeHome";
	    }
	     model.addAttribute("mediaType", new MediaTypeBean());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "mediaTypeHome";
    }

    @RequestMapping(value = "/mediaDelete", method = RequestMethod.GET)
    public String mediaTypeDelete(HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request.getParameter("mediaDelete"));
	    MediaTypeBean media = new MediaTypeBean();
	    media.setMediaTypeId(groupId);

	    int msg = dao.deleteDetails(media);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "MediaTypeBean", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("MediaTypeDelete",
			"Media Type Data is Deleted Successfully");
	    } else {
		request.setAttribute("MediaTypeDeleteFail",
			"Media Type Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("mediaType", new MediaTypeBean());
	return "mediaTypeHome";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "mediaType";

	Map<String, String> map = new HashMap<String, String>();

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
