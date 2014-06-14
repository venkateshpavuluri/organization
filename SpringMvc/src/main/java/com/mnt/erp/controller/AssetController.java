package com.mnt.erp.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;

import com.mnt.erp.bean.Agreement;
import com.mnt.erp.bean.AssertTypeBean;
import com.mnt.erp.bean.AssetAssignmentBean;
import com.mnt.erp.bean.AssetBean;
import com.mnt.erp.bean.AssetGroup;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.service.AssetService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;
@Controller
public class AssetController {
	private static Logger logger = Logger.getLogger(AssetController.class);
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	String msg = null;
	String msgedit = null;
	@Autowired
	AssetService agservice;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	PopulateService populateService;
	@Autowired
	DateConversionService dateService;

	HttpSession session;

	@RequestMapping(value = "/assetHome", method = RequestMethod.GET)
	public String getRfq(@ModelAttribute AssetBean astbean,
			SessionStatus status, Model model, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("assetHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("ASSET", new AssetBean());
		return "assetHome";
	}

	/*@RequestMapping(value = "/AgDuplicateCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkagname(HttpServletRequest request,
			HttpServletResponse response, Agreement agbean) {
		Long pname = null;
		try {
			String before = request.getParameter("rfqno");

			pname = agservice.getAgreementCount(before);
			if (pname != 0) {
				msg = "Warning ! Agreement No is already exists. Please try some other name";
			}
			if (pname == 0) {
				msg = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}*/

	@RequestMapping(value = "/saveAsset", method = RequestMethod.POST)
	public String saveAsset(@ModelAttribute("ASSET") AssetBean agbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<AssetAssignmentBean> agbeanlist = new ArrayList<AssetAssignmentBean>();
		try {
agbean.setWeon(dateService.dateFormat(dateService.dateParse(agbean.getWeon(), "au"), "au"));
			String employee = agbean.getEmployeeId();
			String asgndon[] = agbean.getAssignedon();
			if (employee != null) {
				List<String> mlist = Arrays.asList(employee.split(","));
				Object[] employees = mlist.toArray();
				String returnedon[] = agbean.getReturnedon();

				for (int r = 0; r < employee.length(); r++) {

					AssetAssignmentBean aasgnbean = new AssetAssignmentBean();
					aasgnbean.setEmployeeId(employees[r].toString());
					aasgnbean.setAssignedon(dateService.dateFormat(
							dateService.dateParse(asgndon[r], "au"), "au"));
					aasgnbean.setReturnedon(dateService.dateFormat(
							dateService.dateParse(returnedon[r], "au"), "au"));
					agbeanlist.add(aasgnbean);
				}
				agbean.setAssetasgnmentbean(agbeanlist);
			}
			String msg = agservice.saveAsset(agbean);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "ASSET", "ROW", String
						.valueOf(agbean.getAssetid()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				return "redirect:assetHome.mnt?list=" + "success" + "";
			} else {
				return "redirect:assetHome.mnt?listwar=" + "fail" + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:assetHome.mnt?listwar=" + "fail" + "";
		}

	}

	@ModelAttribute("assetTypeIds")
	public Map<Integer, String> populateAseetType() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = agservice.selectAssetTypeid();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("assetGroupIds")
	public Map<Integer, String> populateAssetGroupIds() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = agservice.selectAssetGroupId();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	@ModelAttribute("employeeIds")
	public Map<Integer, String> populateEmployee() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = agservice.selectEmpId();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] object = (Object[]) iterator.next();
				map.put((Integer) object[0], (String) object[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	
	@RequestMapping(value = "/searchasset", method = RequestMethod.GET)
	public String searchAgreementIds(
			@ModelAttribute("ASSET") AssetBean searchBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<AssetBean> searchbeans = new ArrayList<AssetBean>();
			String dbField = searchBean.getXmlLabel();
			String operation = searchBean.getOperations();
			String basicSearchId = searchBean.getBasicSearchId();

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
				list = agservice.searchAsset();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					AssetBean agbean = new AssetBean();
					agbean.setAssetid((Integer) obj[0]);
					AssertTypeBean attype = (AssertTypeBean) obj[1];
					agbean.setAssettypeId(attype.getAssertTypeName());
					AssetGroup ag=(AssetGroup)obj[2];
					agbean.setAssetgroupId(ag.getAssetGroupType());
					agbean.setModel((String)obj[3]);
					agbean.setSerialNumber((String)obj[4]);
					agbean.setStatus((String)obj[5]);
					agbean.setWeon((String)obj[6]);
					searchbeans.add(agbean);

				}

			} else {

				list = agservice.basicSearchAsset(dbField, operation,
						basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					AssetBean agbean = new AssetBean();
					agbean.setAssetid((Integer) obj[0]);
					AssertTypeBean attype = (AssertTypeBean) obj[1];
					agbean.setAssettypeId(attype.getAssertTypeName());
					AssetGroup ag=(AssetGroup)obj[2];
					agbean.setAssetgroupId(ag.getAssetGroupType());
					agbean.setModel((String)obj[3]);
					agbean.setSerialNumber((String)obj[4]);
					agbean.setStatus((String)obj[5]);
					agbean.setWeon((String)obj[6]);
					searchbeans.add(agbean);
				}
			}
			request.setAttribute("searchbeans", searchbeans);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "assetHome";
	}

	@RequestMapping(value = "/assetEdit", method = RequestMethod.GET)
	public String editAgreement(@ModelAttribute("ASSET") AssetBean editbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<AssetBean> agedit = new ArrayList<AssetBean>();
		List<AssetAssignmentBean> aglinelist = new ArrayList<AssetAssignmentBean>();
		// int processId = processBean.getProcessid();
		int agId = Integer.parseInt(request.getParameter("assetedit"));

		try {
			List<AssetBean> list = agservice.EditAsset(agId);
			Iterator<AssetBean> iter = list.iterator();
			if (iter.hasNext()) {
				Object object = iter.next();
				AssetBean agb = (AssetBean) object;
				editbean.setAssetid(agb.getAssetid());
				editbean.setAssettypeId(agb.getAssettypeId());
				editbean.setAssetgroupId(agb.getAssetgroupId());
				editbean.setModel(agb.getModel());
				editbean.setSerialNumber(agb.getSerialNumber());
				editbean.setStatus(agb.getStatus());
				editbean.setWeon(agb.getWeon());
				List<AssetAssignmentBean> listEdit = agb.getAssetasgnmentbean();
				Iterator<AssetAssignmentBean> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					AssetAssignmentBean agmntedit = (AssetAssignmentBean) object2;
					AssetAssignmentBean aglineedit = new AssetAssignmentBean();
					aglineedit.setAssetasgmntIdedit(agmntedit.getAssetasgmntId());
					Employee emp = agmntedit.getEmployeebean();
					aglineedit.setEmployeenameedit(emp.getfName());
					aglineedit.setEmployeeIdedit(agmntedit.getEmployeeId());
					aglineedit.setAssignedonedit(agmntedit.getAssignedon());
					aglineedit.setReturnedonedit(agmntedit.getReturnedon());
					aglinelist.add(aglineedit);

				}
				editbean.setAssetasgnmentbean(aglinelist);

				agedit.add(editbean);

			}
			request.setAttribute("editvalues", agedit);
			request.setAttribute("assetlinelistdetails", aglinelist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "assetHome";

	}

	
	 /*@RequestMapping(value = "/ASSETDuplicateEditCheck", method = RequestMethod.POST)
	 public @ResponseBody String checkrfqnameEdit(HttpServletRequest request, HttpServletResponse
	  response, Model model, Agreement rfqbean) {
	  
	  Long pname = null;
	  
	 try {
	  
	  String beforeedit = request.getParameter("rfqnameedit"); int id =
	  Integer.parseInt(request.getParameter("rfqeditid"));
	  
	  pname = agservice.getAgreementCountedit(beforeedit, id); if (pname != 0) {
	 
	  rfqbean.setAgreementNo("");
	  
	 msgedit = "Warning ! ASSET No is already exists. Please try some other name";
	  
	  } if (pname == 0) {
	  
	  rfqbean.setAgreementNo("");
	  
	  msgedit = null;
	 
	 }
	  } catch (Exception e) 
	  { 
		  e.printStackTrace(); 
		  } 
	 return msgedit;
	 }*/
	 
	@RequestMapping(value = "/assetUpdate", method = RequestMethod.POST)
	public String rfqUpdate(@ModelAttribute("ASSET") AssetBean assetUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<AssetAssignmentBean> assetlinelist = new ArrayList<AssetAssignmentBean>();
		String msg = null;
		String checked = "", s1 = "0", s2 = "1";
		int ss = 0;
		try {
			assetUpdate.getAssetid();
			assetUpdate.getAssettypeId();
			assetUpdate.getAssetgroupId();
			assetUpdate.getModel();
			assetUpdate.getSerialNumber();
			assetUpdate.getStatus();
			assetUpdate.getWeon();

			int assetlineid[] = assetUpdate.getAssetasgmntIdedit();
			String adon[] = assetUpdate.getAssignedonedit();
			if (adon != null) {
				String empid = assetUpdate.getEmployeeIdedit();

				List<String> emplist = Arrays.asList(empid
						.split(","));
				Object[] emparray = emplist.toArray();
				String reton[] = assetUpdate.getReturnedonedit();
				if (empid != null) {
					for (int r = 0; r < adon.length; r++) {
						int aID = assetlineid[r];

						if (aID == 0) {
							AssetAssignmentBean assignmentbean = new AssetAssignmentBean();
							assignmentbean.setAssetasgmntId(assetlineid[r]);
							assignmentbean.setEmployeeId(emparray[r].toString());
							assignmentbean.setAssignedon(dateService.dateFormat(dateService.dateParse(adon[r],"au"), "au"));
							assignmentbean.setReturnedon(dateService.dateFormat(dateService.dateParse(reton[r],"au"), "au"));
							assetlinelist.add(assignmentbean);

						} else {

							AssetAssignmentBean assignmentbean = new AssetAssignmentBean();
							assignmentbean.setAssetasgmntId(assetlineid[r]);
							assignmentbean.setEmployeeId(emparray[r].toString());
							assignmentbean.setAssignedon(dateService.dateFormat(dateService.dateParse(adon[r],"au"), "au"));
							assignmentbean.setReturnedon(dateService.dateFormat(dateService.dateParse(reton[r],"au"), "au"));
							assetlinelist.add(assignmentbean);
							ss = assetlineid[r];

							checked = request.getParameter("Checkdelete" + ss);

							if (s2.equals(checked)) {

								agservice.deleteChildDetails(ss);

							}
							if (s1.equals(checked) || checked == null) {
								assetlinelist.add(assignmentbean);

							}

						}

					}
				}

			}

			assetUpdate.setAssetasgnmentbean(assetlinelist);
			msg = agservice.updateAsset(assetUpdate);

			if (msg.equals("S")) {
				request.setAttribute("RfqUpdateSuccess",
						"Asset Data Updated Successfully");
				model.addAttribute("ASSET", new AssetBean());
			} else {
				request.setAttribute("RfqUpdateFail",
						"Asset Data Updated Successfully");
				model.addAttribute("ASSET", new AssetBean());
			}

		} catch (Exception e) {
			request.setAttribute("RfqUpdateFail",
					"Asset Data Updated Successfully");
			model.addAttribute("ASSET", new AssetBean());
			e.printStackTrace();
		}

		return "assetHome";
	}


	 @RequestMapping(value = "/assetDelete", method = RequestMethod.GET)
		public String rfqDelete(@ModelAttribute("ASSET") AssetBean abDelete,
				Model model, HttpServletRequest request,
				HttpServletResponse response) {
			String agDel = null;
			response.setCharacterEncoding("UTF-8");

			int rId = Integer.parseInt(request.getParameter("assetdelete"));
			try {
				String msg = agservice.deleteAsset(rId);
				if (msg.equals("S")) {

					session = request.getSession(false);
					Date date = new Date();
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId")
							.toString(), "D", "ASSET", "ROW", String.valueOf(rId),
							"1", modifiedDate, session.getAttribute("userName")
									.toString());
					agDel = "Asset Details Deleted Successfully";
					request.setAttribute("RfqDeleteSuccess",
							"Asset Data Deleted Successfully");
					model.addAttribute("ASSET", new AssetBean());
				} else {
					agDel = "Asset Details Deletion Failed";
					request.setAttribute("RfqDeleteFail",
							"Asset Data Deleted Successfully");
					model.addAttribute("ASSET", new AssetBean());
				}

			} catch (Exception e) {
				agDel = "Asset Details Deletion Failed";
				request.setAttribute("RfqDeleteFail",
						"Asset Data Deleted Successfully");
				e.printStackTrace();
			}
			return "assetHome";

		}

		@ModelAttribute("xmlItems")
		public Map<String, String> populatLabelDetails() {
			String name = "assetid";

			Map<String, String> map = new HashMap<String, String>();

			try {
				map = xmlService.populateXmlLabels(name);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return map;
		}

		@RequestMapping(value = "/assetAdvanceSearch", method = RequestMethod.GET)
		public String AgAdvanceSearch(@ModelAttribute("ASSET") AssetBean agbean,
				HttpServletRequest request, HttpServletResponse response) {
			response.setCharacterEncoding("UTF-8");

			List<AssetBean> asblist = null;
			String name1 = "agreementId", s1 = null, s2 = null;
			List<Object[]> returnString = null;
			// Vendor v=null;
			asblist = new ArrayList<AssetBean>();
			agbean.setAdvanceSearchHidden(1);
			try {
				returnString = xmlService.populateXml(name1);
				Iterator<Object[]> list = returnString.iterator();
				for (Object[] object : returnString) {
					AssetBean v = new AssetBean();

					s1 = (String) object[0];
					s2 = (String) object[1];
					v.setFirstLabel(s1);
					v.setSecondLabel(s2);
					asblist.add(v);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("agSearchAdvance", asblist);

			return "assetHome";
		}

		@RequestMapping(value = "/assetAdvanceSearchOperations", method = RequestMethod.POST)
		public String ssAdvanceSearchOperations(@ModelAttribute AssetBean agBean,
				HttpServletRequest request, HttpServletResponse response) {
			List<AssetBean> searchbeans = null;
			List<Object[]> objectsArray = null;

			response.setCharacterEncoding("UTF-8");
			try{
				searchbeans = new ArrayList<AssetBean>();
			String columns = agBean.getFirstLabel();
			String operations = agBean.getOperations1();
			String advanceSearchText = agBean.getAdvanceSearchText();

			if (advanceSearchText.length() != 0) {

				objectsArray = agservice.setAgreementAdvanceSearch(columns, operations,
						advanceSearchText);
			} else {
				objectsArray = agservice.setAssetSearch("ALL");
			}
			iterator = objectsArray.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				AssetBean agbean = new AssetBean();
				agbean.setAssetid((Integer) obj[0]);
				AssertTypeBean attype = (AssertTypeBean) obj[1];
				agbean.setAssettypeId(attype.getAssertTypeName());
				AssetGroup ag=(AssetGroup)obj[2];
				agbean.setAssetgroupId(ag.getAssetGroupType());
				agbean.setModel((String)obj[3]);
				agbean.setSerialNumber((String)obj[4]);
				agbean.setStatus((String)obj[5]);
				agbean.setWeon((String)obj[6]);
				searchbeans.add(agbean);
			}

			request.setAttribute("searchbeans", searchbeans);
			}catch(Exception e){
				e.printStackTrace();
			}
			return "rfqHome";
		}
}
