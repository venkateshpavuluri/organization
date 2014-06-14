/**
 * @Copyright MNTSOFT
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.PayGradeBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 */
@Controller
public class PayGradeController {
	@Autowired
	ERPDao erpDao;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session = null;

	@RequestMapping(value = "/payGradeHome", method = RequestMethod.GET)
	public ModelAndView payGradeHome(
			@ModelAttribute("payGradeCmd") PayGradeBean payGradeBean,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("payGradeHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("payGradeHome", "payGradeCmd", payGradeBean);
	}

	@RequestMapping(value = "/payGradeAdd", method = RequestMethod.POST)
	public String savepayGrade(
			@ModelAttribute("payGradeCmd") PayGradeBean payGradeBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String payGradeSave = null;
		String payGradeName = payGradeBean.getPayGrade();
		PayGradeBean pgBean = (PayGradeBean) payGradeBean;
		String sql = "select count(*) from PayGradeBean pg where pg.payGrade='"
				+ payGradeName + "'";
		Long checkJob = erpDao.duplicateCheck(sql);

		if (checkJob == 0) {
			try {
				int msg = erpDao.saveDetails(pgBean);
				status.setComplete();
				if (msg != 0) {
					session = request.getSession(false);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(new Date());
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Pay Grade", "ROW", String.valueOf(pgBean
									.getPayGradeId()), "1", modifiedDate,
							session.getAttribute("userName").toString());
					payGradeSave = "Pay Grade Data Saved Successfully";
				} else {
					return "redirect:payGradeHome.mnt?addpayGradeFail="
							+ payGradeSave + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				payGradeSave = "Pay Grade Data Insertion Failures";
				return "redirect:payGradeHome.mnt?addpayGradeFail="
						+ payGradeSave + "";
			}
		} else {
			payGradeBean.setPgId(1);
			request.setAttribute("addpayGradeDuplicate",
					"pay Grade already exists!");

			return "payGradeHome";

		}

		return "redirect:payGradeHome.mnt?addpayGradesus=" + payGradeSave + "";

	}

	@RequestMapping(value = "/payGradeSearch", method = RequestMethod.GET)
	public String searchpayGrade(

	@ModelAttribute("payGradeCmd") PayGradeBean payGradeSearch, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<PayGradeBean> payGradeList = new ArrayList<PayGradeBean>();

		try {
			String dbField = payGradeSearch.getXmlLabel();
			String operation = payGradeSearch.getOperations();
			String basicSearchId = payGradeSearch.getBasicSearchId();

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
				String sql = "select pg.payGradeId,pg.payGrade from PayGradeBean pg order by pg.payGrade";
				list = erpDao.searchDetails(sql);

			} else {
				String sql = "select pg.payGradeId,pg.payGrade from PayGradeBean pg where pg."
						+ dbField
						+ " "
						+ operation
						+ " '"
						+ basicSearchId
						+ "'order by pg.payGrade";
				list = erpDao.searchDetails(sql);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				PayGradeBean ab = new PayGradeBean();
				Object[] obpg = (Object[]) iterator.next();
				ab.setPayGradeId((Integer) obpg[0]);
				ab.setPayGrade((String) obpg[1]);
				payGradeList.add(ab);
			}

			request.setAttribute("payGradeList", payGradeList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "payGradeHome";

	}

	@RequestMapping(value = "/payGradeEdit", method = RequestMethod.GET)
	public String payGradeEdit(

	@ModelAttribute("payGradeCmd") PayGradeBean membersEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("payGradeId"));
		List<Object[]> list = null;
		List<PayGradeBean> payGradeEdit = new ArrayList<PayGradeBean>();
		try {
			list = erpDao
					.searchDetails("select pg.payGradeId,pg.payGrade from PayGradeBean pg where pg.payGradeId="
							+ id + "");
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				membersEdit.setEpayGradeId((Integer) obj[0]);
				membersEdit.setEpayGrade((String) obj[1]);
				payGradeEdit.add(membersEdit);
			}
			request.setAttribute("payGradeEdit", payGradeEdit);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "payGradeHome";

	}

	@RequestMapping(value = "/payGradeUpdate", method = RequestMethod.POST)
	public String payGradeUpdate(

	@ModelAttribute("payGradeCmd") PayGradeBean payGradeUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String payGradeUpadted = null;
		String payGrade = payGradeUpdate.getEpayGrade();
		int payGradeId = payGradeUpdate.getEpayGradeId();
		payGradeUpdate.setPayGradeId(payGradeId);
		payGradeUpdate.setPayGrade(payGrade);
		Long checkUpdate = erpDao
				.duplicateCheck("select count(*) from PayGradeBean pg where pg.payGrade='"
						+ payGrade
						+ "' and pg.payGradeId!='"
						+ payGradeId
						+ "'");
		if (checkUpdate == 0) {
			try {

				int msg = erpDao.updateDetails(payGradeUpdate);

				if (msg != 0) {
					payGradeUpadted = "Pay Grade Data Updated Successfully";

				} else {
					payGradeUpadted = "Pay Grade Data Updation Failed";
					return "redirect:payGradeHome.mnt?updatepayGradeFail="
							+ payGradeUpadted + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			request.setAttribute("updatepayGradeDuplicate",
					"Pay Grade already exists");
			request.setAttribute("payGradeEdit", "payGradeEdit");
			return "payGradeHome";
		}
		return "redirect:payGradeHome.mnt?updatepayGradesus=" + payGradeUpadted
				+ "";
	}

	@RequestMapping(value = "/payGradeDelete", method = RequestMethod.GET)
	public String payGradeDelete(

	@ModelAttribute("payGradeCmd") PayGradeBean payGradeDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String payGradeDeleted = null;
		int id = Integer.parseInt(request.getParameter("payGradeId"));
		payGradeDelete.setPayGradeId(id);
		try {

			int msg = erpDao.deleteDetails(payGradeDelete);
			if (msg != 0) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Pay Grade", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				payGradeDeleted = "Pay Grade  Deleted Successfully";
			} else {
				payGradeDeleted = "pay Grade Deletion Failed";
				return "redirect:payGradeHome.mnt?deletepayGradeFail="
						+ payGradeDeleted + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:payGradeHome.mnt?deletepayGradeFail="
					+ payGradeDeleted + "";
		}

		return "redirect:payGradeHome.mnt?deletepayGradesus=" + payGradeDeleted
				+ "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "payGradeId";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
