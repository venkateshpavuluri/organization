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
import com.mnt.erp.bean.LoanTypeBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class LoanTypeController {
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
    @RequestMapping("/loanTypeHome")
    public String getLoanType(@ModelAttribute("loanTypeCmd") LoanTypeBean loanTypeBean,SessionStatus status,
	    Model model, HttpServletResponse response,
	    HttpServletRequest request) {
	response.setCharacterEncoding("UTF-8");
	session = request.getSession(false);
	List<String> list = menuService.getPrivilige("loanTypeHome.mnt", session
		.getAttribute("userId").toString());
	session.setAttribute("privilegeList", list);
	model.addAttribute("loanTypeCmd", new LoanTypeBean());
	return "loanTypeView"; 
    }
    @RequestMapping(value = "/addLoanType", method = RequestMethod.POST)
    @RequestScoped
    public String saveLoanType(
    @ModelAttribute("loanTypeCmd") LoanTypeBean loanTypeBean,
	    DefaultSessionAttributeStore attributeStore,
	    HttpServletRequest request, HttpServletResponse response,
	    SessionStatus sessionStatus, ModelMap map, Model model) {
	response.setCharacterEncoding("UTF-8");
	int mess = 0;
	String AGSuccessdup = null;
	Long id = 0L;
	try {
	    sql = "select count(*) from LoanTypeBean o where  o.loanType='"
		    + loanTypeBean.getLoanType() + "'";
	    id = dao.duplicateCheck(sql);
	    if (id == 0) {
		mess = dao.saveDetails(loanTypeBean);
		map.addAttribute("loanTypeBean", loanTypeBean);
		if (mess != 0) {
		    Date date = new Date();
		    session = request.getSession(false);
		    String modifiedDate = new SimpleDateFormat(
			    "yyyy-MM-dd HH:mm:ss").format(date);
		    auditLogService.setAuditLogSave(
			    session.getAttribute("userId").toString(), "A",
			    "LoanTypeBean", "ROW", String
				    .valueOf(loanTypeBean.getLoanTypeId()),
			    "1", modifiedDate, session.getAttribute("userName")
				    .toString());
		    model.addAttribute("loanTypeCmd", new LoanTypeBean());
		    return "redirect:loanTypeHome.mnt?list=" + "success" + "";
		} else {
		    return "redirect:loanTypeHome.mnt?listwar=" + "fail" + "";
		}
	    } else {
		AGSuccessdup = "Warning ! Loan Type is already exists";

		loanTypeBean.setAid(1);
		request.setAttribute("AGSuccessdup", AGSuccessdup);
		return "loanTypeView";
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    return "redirect:loanTypeHome.mnt?listwar=" + "fail" + "";
	}
    }

    @RequestMapping(value = "/searchLoanType", method = RequestMethod.GET)
    public String searchLoanType(
	    @ModelAttribute("loanTypeCmd") LoanTypeBean loanTypeBean,
	    BindingResult bindingResult, HttpServletRequest request,
	    HttpServletResponse response, Model model) {
	response.setCharacterEncoding("UTF-8");
	List<LoanTypeBean> loanTypeList = null;
	try {
	    loanTypeBean.getLoanTypeId();
	    loanTypeList = new ArrayList<LoanTypeBean>();
	    String dbField = loanTypeBean.getXmlLabel();
	    String operation = loanTypeBean.getOperations();
	    String basicSearchId = loanTypeBean.getBasicSearchId();

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
		sql = "select a.loanTypeId,a.loanType from LoanTypeBean a";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    LoanTypeBean loanSearch = new LoanTypeBean();
		    loanSearch.setLoanTypeId((Integer) obj[0]);
		    loanSearch.setLoanType((String) obj[1]);

		    loanTypeList.add(loanSearch);
		}

	    } else {

		sql = "select a.loanTypeId,a.loanType from LoanTypeBean a where a."
			+ dbField + "" + operation + "'" + basicSearchId + "'";
		list = dao.searchDetails(sql);
		iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] obj = (Object[]) iterator.next();
		    LoanTypeBean loanSearch = new LoanTypeBean();
		    loanSearch.setLoanTypeId((Integer) obj[0]);
		    loanSearch.setLoanType((String) obj[1]);
		    loanTypeList.add(loanSearch);
		}

	    }
	    request.setAttribute("loanBeans", loanTypeList);
	} catch (Exception e) {
	    e.printStackTrace();

	}
	return "loanTypeView";
    }

    @RequestMapping(value = "/editLoanType", method = RequestMethod.GET)
    public String editLoanType(
	    @ModelAttribute("loanTypeCmd") LoanTypeBean loanTypeBean,
	    HttpServletRequest request, Model model) {
	int id = Integer.parseInt(request.getParameter("loanTypeId"));
	try {

	    sql = "select a.loanTypeId,a.loanType from LoanTypeBean a where a.loanTypeId='"
		    + id + "'";
	    list = dao.searchDetails(sql);
	    iterator = list.iterator();
	    while (iterator.hasNext()) {
		Object[] obj = (Object[]) iterator.next();
		loanTypeBean.setLoanTypeId((Integer) obj[0]);
		loanTypeBean.setLoanType((String) obj[1]);
	    }
	    request.setAttribute("editvalues", "df");

	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "loanTypeView";

    }

    @RequestMapping(value = "/updateLoanType", method = RequestMethod.POST)
    public String updateLoanType(
	    @ModelAttribute("loanTypeCmd") LoanTypeBean loanTypeBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	String loanName = loanTypeBean.getLoanType();
	int loanId = loanTypeBean.getLoanTypeId();
	String AGSuccessdupedit = null;
	Long id = 0L;
	try {
	    sql = "select count(*) from LoanTypeBean ab where ab.loanType='"
		    + loanName + "'and ab.loanTypeId!='" + loanId + "'";
	    id = dao.duplicateCheck(sql);
	    if (id == 0) {
		loanTypeBean.setLoanType(loanTypeBean.getLoanType());
		int message = dao.updateDetails(loanTypeBean);

		if (message != 0) {
		    request.setAttribute("LoanTypeUpdate",
			    "Loan Type Updated Successfully");
		} else {
		    request.setAttribute("LoanTypeUpdateFail",
			    "Loan Type Did not updated");
		}
	    } else {
		AGSuccessdupedit = "Warning ! Loan Type is already exists";
		request.setAttribute("AGSuccessdupedit", AGSuccessdupedit);
		request.setAttribute("editvalues", "editvalues");
		return "loanTypeView";
	    }
	    model.addAttribute("loanTypeCmd", new LoanTypeBean());
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "loanTypeView";
    }

    @RequestMapping(value = "/deleteLoanType", method = RequestMethod.GET)
    public String deleteLoanType(
	    @ModelAttribute("loanTypeCmd") LoanTypeBean loanTypeBean,
	    HttpServletRequest request, HttpServletResponse response,
	    Model model) {
	response.setCharacterEncoding("UTF-8");
	int groupId = 0;
	try {
	    groupId = Integer.parseInt(request.getParameter("loanTypeId"));
	    LoanTypeBean deleteBean = new LoanTypeBean();
	    deleteBean.setLoanTypeId(groupId);
	    int msg = dao.deleteDetails(deleteBean);
	    if (msg != 0) {
		Date date = new Date();
		session = request.getSession(false);
		String modifiedDate = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss").format(date);
		auditLogService.setAuditLogSave(session.getAttribute("userId")
			.toString(), "D", "LoanTypeBean", "ROW", String
			.valueOf(groupId), "1", modifiedDate, session
			.getAttribute("userName").toString());
		request.setAttribute("LoanTypeDelete",
			"Loan Type is Deleted Successfully");
	    } else {
		request.setAttribute("LoanTypeDeleteFail",
			"Loan Type is Did Not Deleted ");
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	model.addAttribute("loanTypeCmd", new LoanTypeBean());
	return "loanTypeView";
    }

    @ModelAttribute("xmlItems")
    public Map<String, String> populatLabelDetails() {
	String name = "loanType";
	Map<String, String> map = null;
	try {
	    map = xmlService.populateXmlLabels(name);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return map;
    }
}
