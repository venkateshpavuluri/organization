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

import com.mnt.erp.bean.NewsBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class NewsController {
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

    @RequestMapping(value = "/newsHome", method = RequestMethod.GET)
    public String getNews(@ModelAttribute("newsCmd") NewsBean newsBean,
	    SessionStatus status, Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("newsHome.mnt", session
		.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	model.addAttribute("newsCmd", new NewsBean());
	return "newsView";
    }
    
    @RequestMapping(value = "/addNews", method = RequestMethod.POST)
    @RequestScoped
    public String saveNews(

    @ModelAttribute("newsCmd") NewsBean newsBean,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;

	String AGSuccessdup = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from NewsBean o where  o.news='"
		    + newsBean.getNews()+"'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {
		mess = dao.saveDetails(newsBean);

		map.addAttribute("newsBean", newsBean);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "NewsBean", "ROW", String.valueOf(newsBean
				    .getNewsId()), "1", modifiedDate,
			    session.getAttribute("userName").toString());
		    model.addAttribute("newsCmd", new NewsBean());
		    return "redirect:newsHome.mnt?list=" + "success" + "";
		} else {
		    return "redirect:newsHome.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! News is already exists";

		newsBean.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "newsView";
	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:newsHome.mnt?listwar=" + "fail" + "";
	}
    }
    @RequestMapping(value = "/searchNews", method = RequestMethod.GET)
    public String searchNews(@ModelAttribute("newsCmd") NewsBean newsBean,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<NewsBean> newsList = null;
	try {
	     newsBean.getNewsId();
	    newsList = new ArrayList<NewsBean>();
	    String dbField = newsBean.getXmlLabel();
	    String operation = newsBean.getOperations();
	    String basicSearchId = newsBean.getBasicSearchId();

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
		sql = "select n.newsId,n.news, n.newsDate from NewsBean n";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    NewsBean newsSearch = new NewsBean();
		    newsSearch.setNewsId((Integer) obj[0]);
		    newsSearch.setNews((String) obj[1]);
		    newsSearch.setNewsDate((String) obj[2]);

		    newsList.add(newsSearch);
		}

	    } else {

		sql = "select a.newsId,a.news,a.newsDate from NewsBean a where a."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    NewsBean newsSearch = new NewsBean();
		    newsSearch.setNewsId((Integer) obj[0]);
		    newsSearch.setNews((String) obj[1]);
		    newsSearch.setNewsDate((String) obj[2]);

		   newsList.add(newsSearch);
		}

	    }
	    request.setAttribute("newsBeans", newsList);
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "newsView";
    }
    @RequestMapping(value = "/editNews", method = RequestMethod.GET)
    public String editNews(@ModelAttribute("newsCmd") NewsBean newsBean,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("newsId"));
	try {

	    sql = "select a.newsId,a.news,a.newsDate from NewsBean a where a.newsId='"
		    + id + "'";

	    list = dao.searchDetails(sql);

	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();

		newsBean.setNewsId((Integer) obj[0]);
		newsBean.setNews((String) obj[1]);
		newsBean.setNewsDate((String)obj[2]);

	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "newsView";

    }

    @RequestMapping(value = "/updateNews", method = RequestMethod.POST)
    public String updateNews(@ModelAttribute("newsCmd") NewsBean newsBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String newsName = newsBean.getNews();
	int newsId = newsBean.getNewsId();
	String AGSuccessdupedit = null;

	Long id = 0L;
	try {
	    sql = "select count(*) from NewsBean ab where ab.news='"
		    + newsName + "'and ab.newsId!='" + newsId + "'";
	    id = dao.duplicateCheck(sql);

	    if (id == 0) {

		newsBean.setNews(newsBean.getNews());

		int message = dao.updateDetails(newsBean);

		if (message != 0) {
		    request.setAttribute("NewsUpdate",
			    "News Data Updated Successfully");

		} else {
		    request.setAttribute("NewsUpdateFail",
			    "News Data Updated Did not updated");

		}
	    } else {
		AGSuccessdupedit = "Warning ! News is already exists";

		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "newsView";
	    }
	    model.addAttribute("newsCmd", new NewsBean());
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "newsView";
    }

    @RequestMapping(value = "/deleteNews", method = RequestMethod.GET)
    public String deleteNews(@ModelAttribute("newsCmd")NewsBean newsBean,
	    HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request.getParameter("newsId"));
	    NewsBean deleteBean = new NewsBean();
	    deleteBean.setNewsId(groupId);

	    int msg = dao.deleteDetails(deleteBean);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "NewsBean", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("NewsDelete",
			"News Data is Deleted Successfully");
	    } else {
		request.setAttribute("NewsDeleteFail",
			"News Data is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("newsCmd", new NewsBean());
	return "newsView";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "news";

	Map<String, String> map =null;

	try {
	    map = xmlService.populateXmlLabels(name);

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
