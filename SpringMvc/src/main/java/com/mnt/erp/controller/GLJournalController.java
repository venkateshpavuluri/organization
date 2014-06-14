/**
 *@Copyright MNTSOFT 
 */
package com.mnt.erp.controller;

import java.io.IOException;
import java.text.DateFormat;
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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.bean.Currency;
import com.mnt.erp.bean.GLFiscalYear;
import com.mnt.erp.bean.GLJournalBean;
import com.mnt.erp.bean.GLJournalLine;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.GLJournalService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 04-01-2014
 */
@Controller
public class GLJournalController {
	private static final Logger log = Logger
			.getLogger(GLJournalController.class);
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	PopulateService populateService;
	@Autowired
	GLJournalService glJournalService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@Autowired
	DateConversionService dateService;
	List<Object[]> list = null;
	Iterator<Object[]> itr = null;
	Object[] objects = null;
	Object obj = null;
	String message = null;
	HttpSession session = null;
	boolean flag = true;

	@RequestMapping(value = "/glJournalHome", method = RequestMethod.GET)
	public ModelAndView glJournalHome(
			@ModelAttribute("glJournalCmd") GLJournalBean glJournalBean,
			HttpServletResponse response, HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("glJournalHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("glJournalHome", "GLJournalCmd", glJournalBean);

	}

	@ModelAttribute("currencySelect")
	public Map<Integer, String> populatCurrencyIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select c.currencyId,c.currency from Currency c");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("orgSelect")
	public Map<Integer, String> populatOrgIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select c.orgId,c.orgName from Organization c");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("GLFiscalSelect")
	public Map<Integer, String> populatGLFiscalIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select c.gLFiscalYear_Id,c.fiscalYear from GLFiscalYear c");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("AccGroupSelect")
	public Map<Integer, String> populatAccGroupIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select c.accountgroupid,c.accountgroup from AccountGroupBean c");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/glJournalAdd", method = RequestMethod.POST)
	public String saveglJournal(
			@ModelAttribute("glJournalCmd") GLJournalBean glJournalBean,
			HttpServletRequest request, HttpServletResponse response) {
		String glJournalSave = null;
		response.setCharacterEncoding("UTF-8");
		List<GLJournalLine> glJournalDetail = new ArrayList<GLJournalLine>();

		String accGrp[] = glJournalBean.getAccGroupId();
		String cur[] = glJournalBean.getCurrenId();
		String dc[] = glJournalBean.getDebitCredit();
		String amt[] = glJournalBean.getAmount();
		String tax[] = glJournalBean.getTax();
		String total[] = glJournalBean.getTotal();
		GLJournalBean journalBean = (GLJournalBean) glJournalBean;

		HttpSession session = request.getSession();
		journalBean.setCreatedBy((String) session.getAttribute("userId"));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		journalBean.setCreatedDTTM(df.format(new Date()));

		if (accGrp != null) {
			for (int m = 0; m < accGrp.length; m++) {
				GLJournalLine dnd = new GLJournalLine();
				dnd.setAccGroupId(accGrp[m]);
				dnd.setCurrenId(cur[m]);
				dnd.setDebitCredit(dc[m]);
				dnd.setAmount(amt[m]);
				dnd.setTax(tax[m]);
				dnd.setTotal(total[m]);
				glJournalDetail.add(dnd);
			}
		}
		try {
			glJournalBean
					.setGlAccountDT(dateService.dateFormat(
							dateService.dateParse(
									glJournalBean.getGlAccountDT(), "au"), "au"));
			glJournalBean.setPostingDT(dateService.dateFormat(
					dateService.dateParse(glJournalBean.getPostingDT(), "au"),
					"au"));
			journalBean.setGlJournalLine(glJournalDetail);
			flag = glJournalService.saveGLJournal(journalBean);

			if (flag == true) {
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "GL Journal", "ROW", String
						.valueOf(journalBean.getGlAccountId()), "1",
						modifiedDate, session.getAttribute("userName")
								.toString());
				glJournalSave = "GL Journal Data Saved Successfully";

			} else {
				glJournalSave = "GL Journal Data Insertion Failures";
				return "redirect:glJournalHome.mnt?addGLJFail=" + glJournalSave
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:glJournalHome.mnt?addGLJsus=" + glJournalSave + "";

	}

	@RequestMapping(value = "/glJournalSearch", method = RequestMethod.GET)
	public String searchglJournal(
			@ModelAttribute("glJournalCmd") GLJournalBean glJournalBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<GLJournalBean> GLJList = new ArrayList<GLJournalBean>();
		try {

			String dbField = glJournalBeanSearch.getXmlLabel();
			String operation = glJournalBeanSearch.getOperations();
			String basicSearchId = glJournalBeanSearch.getBasicSearchId();

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
				list = glJournalService.searchGLJournal();

			} else {

				list = glJournalService.basicSearchGLJournal(dbField,
						operation, basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				GLJournalBean dnb = new GLJournalBean();
				dnb.setGlAccountId((Integer) objects[0]);
				dnb.setGlAccountDT(dateService.dateFormat(
						dateService.dateParse((String) objects[1], "se"), "se"));
				dnb.setPostingDT(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));
				dnb.setReference((String) objects[3]);
				Organization org = ((Organization) objects[10]);
				dnb.setOrgId(org.getOrgName());
				Currency curr = ((Currency) objects[9]);
				dnb.setCurrencyId(curr.getCurrency());
				GLFiscalYear glf = ((GLFiscalYear) objects[8]);
				dnb.setGlFiscalYearId(glf.getFiscalYear());
				dnb.setDescription((String) objects[7]);

				GLJList.add(dnb);
			}
			request.setAttribute("GLJList", GLJList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "glJournalHome";

	}

	@RequestMapping(value = "/glJournalDelete", method = RequestMethod.GET)
	public String glJournalDelete(
			@ModelAttribute("glJournalCmd") GLJournalBean glJournalBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		String GLJDelete = null;
		int glId = Integer.parseInt(request.getParameter("glAccountId"));

		try {
			flag = glJournalService.deleteGLJournal(glId);

			if (flag == true) {
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(new Date());
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "GL Journal", "ROW", String
						.valueOf(glId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				GLJDelete = "GL Journal Deleted Successfully";

			} else {
				GLJDelete = "GL Journal Deletion Failed due to Conatraint Violation";
				return "redirect:glJournalHome.mnt?DeleteGLJFail=" + GLJDelete
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:glJournalHome.mnt?DeleteGLJsus=" + GLJDelete + "";

	}

	@RequestMapping(value = "/glJournalEdit", method = RequestMethod.GET)
	public String glJournalEdit(
			@ModelAttribute("glJournalCmd") GLJournalBean glJournalBeanEdit,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<GLJournalBean> gljEditList = new ArrayList<GLJournalBean>();
		List<GLJournalLine> gljLineEditList = new ArrayList<GLJournalLine>();
		int glId = glJournalBeanEdit.getGlAccountId();
		try {

			List<Object> l = glJournalService.searchGLJournalWithId(glId);

			Iterator<Object> itrr = l.iterator();
			if (itrr.hasNext()) {
				Object oo = itrr.next();
				GLJournalBean sob = (GLJournalBean) oo;
				glJournalBeanEdit.setEglAccountId(sob.getGlAccountId());
				glJournalBeanEdit
						.setEglAccountDT(dateService.dateFormat(dateService
								.dateParse(sob.getGlAccountDT(), "se"), "se"));
				glJournalBeanEdit.setEpostingDT(dateService.dateFormat(
						dateService.dateParse(sob.getPostingDT(), "se"), "se"));
				glJournalBeanEdit.setEreference(sob.getReference());
				glJournalBeanEdit.setEorgId(sob.getOrgId());
				glJournalBeanEdit.setEglFiscalYearId(sob.getGlFiscalYearId());
				glJournalBeanEdit.setEdescription(sob.getDescription());
				glJournalBeanEdit.setEcurrencyId(sob.getCurrencyId());
				glJournalBeanEdit.setEcreatedBy(sob.getCreatedBy());
				glJournalBeanEdit.setEcreatedDTTM(sob.getCreatedDTTM());

				List<GLJournalLine> listEdit = sob.getGlJournalLine();
				Iterator<GLJournalLine> iter = listEdit.iterator();
				while (iter.hasNext()) {
					Object o = iter.next();
					GLJournalLine so = (GLJournalLine) o;
					GLJournalLine soMultiple = new GLJournalLine();
					soMultiple.setEglAccountLineId(so.getGlAccountLineId());
					Currency cur = so.getCurncy();
					soMultiple.setCurrencyName(cur.getCurrency());
					soMultiple.setEcurrenId(so.getCurrenId());
					AccountGroupBean ag = ((AccountGroupBean) so.getAccGroup());
					soMultiple.setAccName(ag.getAccountgroup());
					soMultiple.setEaccGroupId(so.getAccGroupId());
					soMultiple.setEdebitCredit(so.getDebitCredit());
					soMultiple.setEamount(so.getAmount());
					soMultiple.setEtax(so.getTax());
					soMultiple.setEtotal(so.getTotal());

					gljLineEditList.add(soMultiple);
				}
				glJournalBeanEdit.setGlJournalLine(gljLineEditList);
				gljEditList.add(glJournalBeanEdit);
			}

			request.setAttribute("gljEditList", gljEditList);
			request.setAttribute("gljLineEditList", gljLineEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "glJournalHome";
	}

	@RequestMapping(value = "/glJournalUpdate", method = RequestMethod.POST)
	public String glJournalUpdate(
			@ModelAttribute("glJournalCmd") GLJournalBean glJournalBeanUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<GLJournalLine> GLJUpList = new ArrayList<GLJournalLine>();
		String journalUpdate = null;

		glJournalBeanUpdate.setGlAccountId(glJournalBeanUpdate
				.getEglAccountId());

		glJournalBeanUpdate.setOrgId(glJournalBeanUpdate.getEorgId());
		glJournalBeanUpdate.setCurrencyId(glJournalBeanUpdate.getEcurrencyId());
		glJournalBeanUpdate.setGlFiscalYearId(glJournalBeanUpdate
				.getEglFiscalYearId());
		glJournalBeanUpdate.setReference(glJournalBeanUpdate.getEreference());
		glJournalBeanUpdate.setDescription(glJournalBeanUpdate
				.getEdescription());
		glJournalBeanUpdate.setCreatedBy(glJournalBeanUpdate.getEcreatedBy());
		glJournalBeanUpdate.setCreatedDTTM(glJournalBeanUpdate
				.getEcreatedDTTM());
		HttpSession session = request.getSession();
		glJournalBeanUpdate.setModifiedBy((String) session
				.getAttribute("userId"));
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		glJournalBeanUpdate.setModifiedDTTM(df.format(new Date()));

		int glAcId[] = glJournalBeanUpdate.getEglAccountLineId();
		String acGrp[] = glJournalBeanUpdate.getEaccGroupId();
		String dc[] = glJournalBeanUpdate.getEdebitCredit();
		String curr[] = glJournalBeanUpdate.getEcurrenId();
		String amt[] = glJournalBeanUpdate.getEamount();
		String tax[] = glJournalBeanUpdate.getEtax();
		String total[] = glJournalBeanUpdate.getEtotal();

		String childDelete = "", ss = "1";
		int id = 0;
		if (acGrp != null) {

			for (int n = 0; n < acGrp.length; n++) {
				int cbId = glAcId[n];
				if (cbId == 0) {
					GLJournalLine glj = new GLJournalLine();
					glj.setAccGroupId(acGrp[n]);
					glj.setCurrenId(curr[n]);
					glj.setDebitCredit(dc[n]);
					glj.setAmount(amt[n]);
					glj.setTax(tax[n]);
					glj.setTotal(total[n]);
					GLJUpList.add(glj);

				} else {

					GLJournalLine glj = new GLJournalLine();
					glj.setAccGroupId(acGrp[n]);
					glj.setCurrenId(curr[n]);
					glj.setDebitCredit(dc[n]);
					glj.setAmount(amt[n]);
					glj.setTax(tax[n]);
					glj.setTotal(total[n]);
					id = glAcId[n];
					childDelete = request.getParameter("Check" + id);
					if (ss.equals(childDelete)) {
						flag = glJournalService.deleteGLJournalLine(id);
					} else {
						GLJUpList.add(glj);
					}
				}

			}
		}

		try {
			glJournalBeanUpdate
					.setGlAccountDT(dateService.dateFormat(dateService
							.dateParse(glJournalBeanUpdate.getEglAccountDT(),
									"au"), "au"));
			glJournalBeanUpdate
					.setPostingDT(dateService.dateFormat(
							dateService.dateParse(
									glJournalBeanUpdate.getEpostingDT(), "au"),
							"au"));
			glJournalBeanUpdate.setGlJournalLine(GLJUpList);
			flag = glJournalService.updateGLJournal(glJournalBeanUpdate);

			if (flag == true) {
				journalUpdate = "GL Journal Data Updated Successfully";

			}

			else {
				journalUpdate = "GL Journal Data Updation Failed";
				return "redirect:glJournalHome.mnt?UpdateGLJFail="
						+ journalUpdate + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:glJournalHome.mnt?UpdateGLJsus=" + journalUpdate + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "GLJournalId";

		Map<String, String> map = null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/glJournalAdvanceSearch", method = RequestMethod.GET)
	public String glJournalAdvanceSearch(
			@ModelAttribute("glJournalCmd") GLJournalBean st,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		List<Object[]> objArray = null;
		List<GLJournalBean> stList = new ArrayList<GLJournalBean>();
		List<GLJournalBean> refList = new ArrayList<GLJournalBean>();
		st.setAdvanceSearchHidden(1);
		try {
			objArray = xmlService.populateXml("GLJournalId");

			for (Object[] object : objArray) {
				GLJournalBean s = new GLJournalBean();
				if ((boolean) object[2].equals("false")) {
					s.setDbField((String) object[0]);
					s.setLabels((String) object[1]);
					stList.add(s);
				} else {
					s.setDbField((String) object[0]);
					s.setLabels((String) object[1]);
					refList.add(s);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("stAdv", stList);
		model.addAttribute("refList", refList);
		return "glJournalHome";
	}

	@RequestMapping(value = "/glJournalAdvanceSearchOperations", method = RequestMethod.GET)
	public String glJournalAdvanceSearchOperations(
			@ModelAttribute("glJournalCmd") GLJournalBean stAdvSearch,
			HttpServletRequest request, HttpServletResponse response,
			Model model, ModelMap map) throws IOException, ParseException {
		List<Object[]> objectsArray = null;
		List<GLJournalBean> GLJList = new ArrayList<GLJournalBean>();
		String columns = stAdvSearch.getDbField();
		String operations = stAdvSearch.getAsOpts();
		String advanceSearchText = stAdvSearch.getAdvanceSearchText();
		if (advanceSearchText.length() > 1) {
			objectsArray = glJournalService.advSearchGLJournal(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = glJournalService.searchGLJournal();
		}
		itr = objectsArray.iterator();
		while (itr.hasNext()) {
			objects = (Object[]) itr.next();
			GLJournalBean dnb = new GLJournalBean();
			dnb.setGlAccountId((Integer) objects[0]);
			dnb.setGlAccountDT(dateService.dateFormat(
					dateService.dateParse((String) objects[1], "se"), "se"));
			dnb.setPostingDT(dateService.dateFormat(
					dateService.dateParse((String) objects[2], "se"), "se"));
			dnb.setReference((String) objects[3]);
			Organization org = ((Organization) objects[10]);
			dnb.setOrgId(org.getOrgName());
			Currency curr = ((Currency) objects[9]);
			dnb.setCurrencyId(curr.getCurrency());
			GLFiscalYear glf = ((GLFiscalYear) objects[8]);
			dnb.setGlFiscalYearId(glf.getFiscalYear());
			dnb.setDescription((String) objects[7]);

			GLJList.add(dnb);
		}
		request.setAttribute("GLJList", GLJList);
		request.setAttribute("Adv", "Adv");
		model.addAttribute("glJournalCmd", new GLJournalBean());
		return "glJournalHome";
	}
}
