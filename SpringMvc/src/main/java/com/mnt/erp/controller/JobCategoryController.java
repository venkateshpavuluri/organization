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

import com.mnt.erp.bean.JobCategoryBean;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 13-12-2013
 */
@Controller
public class JobCategoryController {
	@Autowired
	ERPDao erpDao;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	HttpSession session = null;

	@RequestMapping(value = "/jobCategoryHome", method = RequestMethod.GET)
	public ModelAndView jobCategoryHome(
			@ModelAttribute("jobCategoryCmd") JobCategoryBean jobBean,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("jobCategoryHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("jobCategoryHome", "jobCategoryCmd", jobBean);
	}

	@RequestMapping(value = "/jobCategoryAdd", method = RequestMethod.POST)
	public String saveJobCategory(
			@ModelAttribute("jobCategoryCmd") JobCategoryBean jobCatBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String jobCatSave = null;
		String jobName = jobCatBean.getJobCategory();
		JobCategoryBean jobBean = (JobCategoryBean) jobCatBean;
		String sql = "select count(*) from JobCategoryBean j where j.jobCategory='"
				+ jobName + "'";
		Long checkJob = erpDao.duplicateCheck(sql);

		if (checkJob == 0) {
			try {
				int msg = erpDao.saveDetails(jobBean);
				status.setComplete();
				if (msg != 0) {
					session = request.getSession(false);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(new Date());
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Job Category", "ROW", String.valueOf(jobBean
									.getJobCategoryId()), "1", modifiedDate,
							session.getAttribute("userName").toString());
					jobCatSave = "Job Category Data Saved Successfully";
				} else {
					jobCatSave = "Job Category Data Insertion Failures";
					return "redirect:jobCategoryHome.mnt?addJobcatFail="
							+ jobCatSave + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				jobCatSave = "Job Category Data Insertion Failures";
				return "redirect:jobCategoryHome.mnt?addJobcatFail="
						+ jobCatSave + "";
			}
		} else {
			jobCatBean.setJcId(1);
			request.setAttribute("addJobCatDuplicate",
					"Job Category already exists!");

			return "jobCategoryHome";

		}

		return "redirect:jobCategoryHome.mnt?addJobcatsus=" + jobCatSave + "";

	}

	@RequestMapping(value = "/jobCategorySearch", method = RequestMethod.GET)
	public String searchjobCategory(

	@ModelAttribute("jobCategoryCmd") JobCategoryBean jobCatSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<JobCategoryBean> jobCategoryList = new ArrayList<JobCategoryBean>();

		try {
			int id = jobCatSearch.getJobCategoryId();
			String dbField = jobCatSearch.getXmlLabel();
			String operation = jobCatSearch.getOperations();
			String basicSearchId = jobCatSearch.getBasicSearchId();

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
				String sql = "select j.jobCategoryId,j.jobCategory from JobCategoryBean j order by j.jobCategory ";
				list = erpDao.searchDetails(sql);

			} else {
				String sql = "select j.jobCategoryId,j.jobCategory from JobCategoryBean j where j."
						+ dbField
						+ " "
						+ operation
						+ " '"
						+ basicSearchId
						+ "'order by j.jobCategory ";
				list = erpDao.searchDetails(sql);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				JobCategoryBean ab = new JobCategoryBean();
				Object[] obj = (Object[]) iterator.next();
				ab.setJobCategoryId((Integer) obj[0]);
				ab.setJobCategory((String) obj[1]);
				jobCategoryList.add(ab);
			}

			request.setAttribute("jobCategoryList", jobCategoryList);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "jobCategoryHome";

	}

	@RequestMapping(value = "/jobCategoryEdit", method = RequestMethod.GET)
	public String jobCategoryEdit(

	@ModelAttribute("jobCategoryCmd") JobCategoryBean jobCatEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("jobCategoryId"));
		List<Object[]> list = null;
		List<JobCategoryBean> jobCategoryEdit = new ArrayList<JobCategoryBean>();
		try {
			list = erpDao
					.searchDetails("select j.jobCategoryId,j.jobCategory from JobCategoryBean j where j.jobCategoryId="
							+ id + "");
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				jobCatEdit.setEjobCategoryId((Integer) obj[0]);
				jobCatEdit.setEjobCategory((String) obj[1]);
				jobCategoryEdit.add(jobCatEdit);
			}
			request.setAttribute("jobCategoryEdit", jobCategoryEdit);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "jobCategoryHome";

	}

	@RequestMapping(value = "/jobCategoryUpdate", method = RequestMethod.POST)
	public String jobCategoryUpdate(

	@ModelAttribute("jobCategoryCmd") JobCategoryBean jobCatUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String jobCatUpadted = null;

		String jobCategory = jobCatUpdate.getEjobCategory();
		int jobCatId = jobCatUpdate.getEjobCategoryId();

		jobCatUpdate.setJobCategoryId(jobCatId);
		jobCatUpdate.setJobCategory(jobCategory);
		Long checkUpdate = erpDao
				.duplicateCheck("select count(*) from JobCategoryBean j where j.jobCategory='"
						+ jobCategory
						+ "' and j.jobCategoryId!='"
						+ jobCatId
						+ "'");
		if (checkUpdate == 0) {

			try {

				int msg = erpDao.updateDetails(jobCatUpdate);

				if (msg != 0) {
					jobCatUpadted = "Job Category Data Updated Successfully";

				} else {
					jobCatUpadted = "Job Category Data Updation Failed";
					return "redirect:jobCategoryHome.mnt?updatejobCatFail="
							+ jobCatUpadted + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				return "redirect:jobCategoryHome.mnt?updatejobCatFail="
						+ jobCatUpadted + "";
			}

		} else {

			request.setAttribute("updatejobCategoryDuplicate",
					"Job Category already exists!");
			request.setAttribute("jobCategoryEdit", "jobCategoryEdit");
			return "jobCategoryHome";

		}
		return "redirect:jobCategoryHome.mnt?updatejobCatsus=" + jobCatUpadted
				+ "";
	}

	@RequestMapping(value = "/jobCategoryDelete", method = RequestMethod.GET)
	public String jobCategoryDelete(

	@ModelAttribute("jobCategoryCmd") JobCategoryBean jobCatDelete,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String jobCatDeleted = null;
		int id = Integer.parseInt(request.getParameter("jobCategoryId"));
		jobCatDelete.setJobCategoryId(id);
		try {

			int msg = erpDao.deleteDetails(jobCatDelete);
			if (msg != 0) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Job Category", "ROW", String
						.valueOf(id), "1", modifiedDate,
						session.getAttribute("userName").toString());
				jobCatDeleted = "Job Category  Deleted Successfully";
			} else {

				jobCatDeleted = "Job Category  Deletion Failed";
				return "redirect:jobCategoryHome.mnt?deletejobCatFail="
						+ jobCatDeleted + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:jobCategoryHome.mnt?deletejobCatFail="
					+ jobCatDeleted + "";
		}

		return "redirect:jobCategoryHome.mnt?deletejobCatsus=" + jobCatDeleted
				+ "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "jobCategoryId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
