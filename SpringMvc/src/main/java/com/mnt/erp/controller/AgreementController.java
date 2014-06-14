/*
 * @author Srinivas
 */
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import com.mnt.erp.bean.AgreementLine;
import com.mnt.erp.bean.Agreement;
import com.mnt.erp.bean.AgreementType;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Organization;
import com.mnt.erp.bean.PurchaseOrganization;
import com.mnt.erp.bean.RfqBean;
import com.mnt.erp.bean.StockTransferBean;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.bean.Vendor;
import com.mnt.erp.service.AgreementService;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class AgreementController {
	private static Logger logger = Logger.getLogger(AgreementController.class);
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	String msg = null;
	String msgedit = null;
	@Autowired
	AgreementService agservice;
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

	@RequestMapping(value = "/agreementHome", method = RequestMethod.GET)
	public String getRfq(@ModelAttribute Agreement agbean,
			SessionStatus status, Model model, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("agreementHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("AGREEMENT", new Agreement());

		return "agreementHome";
	}

	@RequestMapping(value = "/AgDuplicateCheck", method = RequestMethod.POST)
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
	}

	@RequestMapping(value = "/saveagreement", method = RequestMethod.POST)
	public String saveRfq(@ModelAttribute("AGREEMENT") Agreement agbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<AgreementLine> agbeanlist = new ArrayList<AgreementLine>();

		try {
			agbean.setAgreementDate(dateService.dateFormat(
					dateService.dateParse(agbean.getAgreementDate(), "au"),
					"au"));
			agbean.setStdt(dateService.dateFormat(
					dateService.dateParse(agbean.getStdt(), "au"), "au"));
			agbean.setEtdt(dateService.dateFormat(
					dateService.dateParse(agbean.getEtdt(), "au"), "au"));

			String material = agbean.getMaterialId();
			String qtty[] = agbean.getTargetqty();
			if (qtty != null) {
				List<String> mlist = Arrays.asList(material.split(","));
				Object[] materials = mlist.toArray();

				String uomid = agbean.getUomId();
				List<String> ulist = Arrays.asList(uomid.split(","));
				Object[] uomids = ulist.toArray();
				String netprice[] = agbean.getNetprice();

				for (int r = 0; r < qtty.length; r++) {

					AgreementLine aglinebean = new AgreementLine();
					aglinebean.setMaterialId(materials[r].toString());
					aglinebean.setTargetqty(qtty[r]);
					aglinebean.setUomId(uomids[r].toString());
					aglinebean.setNetprice(netprice[r]);
					agbeanlist.add(aglinebean);
				}
				agbean.setAgreementline(agbeanlist);
			}
			String msg = agservice.saveAgreement(agbean);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "AGREEMENT", "ROW", String
						.valueOf(agbean.getAgreementId()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				return "redirect:agreementHome.mnt?list=" + "success" + "";
			} else {
				return "redirect:agreementHome.mnt?listwar=" + "fail" + "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:agreementHome.mnt?listwar=" + "fail" + "";
		}

	}

	@ModelAttribute("agreementType")
	public Map<Integer, String> populateAgreementType() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = agservice.selectAgreementTypeid();
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

	@ModelAttribute("Vendor")
	public Map<Integer, String> populateVendorIds() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = agservice.selectVendorId();
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

	@ModelAttribute("Organization")
	public Map<Integer, String> populateOrganization() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = agservice.selectOrgId();
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

	@ModelAttribute("PurOrg")
	public Map<Integer, String> populatepurorgids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = agservice.selectpurOrgId();
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

	@ModelAttribute("materialid")
	public Map<Integer, String> populatMaterialids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = agservice.selectMaterial();
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

	@ModelAttribute("uom")
	public Map<Integer, String> populatUomids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = agservice.selectUom();
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

	@RequestMapping(value = "/searchagreement", method = RequestMethod.GET)
	public String searchAgreementIds(
			@ModelAttribute("AGREEMENT") Agreement agBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<Agreement> agbeans = new ArrayList<Agreement>();
			String dbField = agBean.getXmlLabel();
			String operation = agBean.getOperations();
			String basicSearchId = agBean.getBasicSearchId();

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
				list = agservice.searchAgreementservice();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Agreement agbean = new Agreement();
					agbean.setAgreementId((Integer) obj[0]);
					AgreementType agtype = (AgreementType) obj[1];
					agbean.setAgreementtypeid(agtype.getAgreementType());
					agbean.setAgreementNo((String) obj[2]);
					Vendor vendor = (Vendor) obj[3];
					agbean.setVendorId(vendor.getVendorName());
					Organization org = (Organization) obj[4];
					agbean.setOrgId(org.getOrgName());
					PurchaseOrganization po = (PurchaseOrganization) obj[5];
					agbean.setPurOrgId(po.getPurOrg());
					agbean.setAgreementDate(dateService.dateFormat(
							dateService.dateParse((String) obj[6], "se"), "se"));
					agbean.setStdt(dateService.dateFormat(
							dateService.dateParse((String) obj[7], "se"), "se"));
					agbean.setEtdt(dateService.dateFormat(
							dateService.dateParse((String) obj[8], "se"), "se"));
					agbeans.add(agbean);

				}

			} else {

				list = agservice.basicSearchAgreement(dbField, operation,
						basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					Agreement agbean = new Agreement();
					agbean.setAgreementId((Integer) obj[0]);
					AgreementType agtype = (AgreementType) obj[1];
					agbean.setAgreementtypeid(agtype.getAgreementType());
					agbean.setAgreementNo((String) obj[2]);
					Vendor vendor = (Vendor) obj[3];
					agbean.setVendorId(vendor.getVendorName());
					Organization org = (Organization) obj[4];
					agbean.setOrgId(org.getOrgName());
					PurchaseOrganization po = (PurchaseOrganization) obj[5];
					agbean.setPurOrgId(po.getPurOrg());
					agbean.setAgreementDate(dateService.dateFormat(
							dateService.dateParse((String) obj[6], "se"), "se"));
					agbean.setStdt(dateService.dateFormat(
							dateService.dateParse((String) obj[7], "se"), "se"));
					agbean.setEtdt(dateService.dateFormat(
							dateService.dateParse((String) obj[8], "se"), "se"));
					agbeans.add(agbean);
				}
			}
			request.setAttribute("agbeans", agbeans);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "agreementHome";
	}

	@RequestMapping(value = "/agreementEdit", method = RequestMethod.GET)
	public String editAgreement(@ModelAttribute("AGREEMENT") Agreement agbean,
			BindingResult result, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		List<Agreement> agedit = new ArrayList<Agreement>();
		List<AgreementLine> aglinelist = new ArrayList<AgreementLine>();
		// int processId = processBean.getProcessid();
		int agId = Integer.parseInt(request.getParameter("agedit"));

		try {
			List<Agreement> list = agservice.EditAgreement(agId);

			Iterator<Agreement> iter = list.iterator();
			if (iter.hasNext()) {
				Object object = iter.next();
				Agreement agb = (Agreement) object;
				agbean.setAgreementId(agb.getAgreementId());
				agbean.setAgreementNo(agb.getAgreementNo());
				agbean.setAgreementtypeid(agb.getAgreementtypeid());
				agbean.setVendorId(agb.getVendorId());
				agbean.setOrgId(agb.getOrgId());
				agbean.setPurOrgId(agb.getPurOrgId());

				agbean.setAgreementDate(dateService.dateFormat(
						dateService.dateParse(agb.getAgreementDate(), "se"),
						"se"));
				agbean.setStdt(dateService.dateFormat(
						dateService.dateParse(agb.getStdt(), "se"), "se"));

				agbean.setEtdt(dateService.dateFormat(
						dateService.dateParse(agb.getEtdt(), "se"), "se"));
				List<AgreementLine> listEdit = agb.getAgreementline();
				Iterator<AgreementLine> iterate = listEdit.iterator();
				while (iterate.hasNext()) {
					Object object2 = iterate.next();
					AgreementLine agmntedit = (AgreementLine) object2;
					AgreementLine aglineedit = new AgreementLine();
					aglineedit.setAgreementlineidedit(agmntedit
							.getAgreementlineid());
					Material matrfq = agmntedit.getMaterialdetail();
					aglineedit.setMaterialidName(matrfq.getMaterialName());
					aglineedit.setMaterialIdedit(agmntedit.getMaterialId());
					aglineedit.setTargetqtyedit(agmntedit.getTargetqty());
					Uom uomrfq = agmntedit.getUomdetail();
					aglineedit.setUomidName(uomrfq.getUom());
					aglineedit.setUomIdedit(agmntedit.getUomId());
					aglineedit.setNetpriceedit(agmntedit.getNetprice());
					aglinelist.add(aglineedit);

				}
				agbean.setAgreementline(aglinelist);

				agedit.add(agbean);

			}
			request.setAttribute("editvalues", agedit);
			request.setAttribute("aglinelistdetails", aglinelist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "agreementHome";

	}

	
	@RequestMapping(value = "/agreementUpdate", method = RequestMethod.POST)
		public String agUpdate(@ModelAttribute("AGREEMENT") Agreement agUpdate,
				Model model, HttpServletRequest request,
				HttpServletResponse response) {
			response.setCharacterEncoding("UTF-8");
			List<AgreementLine> aglinelist = new ArrayList<AgreementLine>();
			String msg = null;
			String checked = "", s1 = "0", s2 = "1";
			int ss = 0;
			try {
				agUpdate.setAgreementId(agUpdate.getAgreementId());
				agUpdate.setAgreementNo(agUpdate.getAgreementNo());
				agUpdate.setAgreementtypeid(agUpdate.getAgreementtypeid());
				
				agUpdate.setVendorId(agUpdate.getVendorId());
				agUpdate.setAgreementDate(dateService.dateFormat(dateService
						.dateParse(agUpdate.getAgreementDate(), "au"), "au"));
				agUpdate.setStdt(dateService.dateFormat(
						dateService.dateParse(agUpdate.getStdt(), "au"),
						"au"));
				agUpdate.setEtdt(dateService.dateFormat(
						dateService.dateParse(agUpdate.getEtdt(), "au"),
						"au"));
				agUpdate.setOrgId(agUpdate.getOrgId());
				agUpdate.setPurOrgId(agUpdate.getPurOrgId());
				int aglineid[] = agUpdate.getAgreementlineidedit();
				String ddate[]= agUpdate.getNetpriceedit();
				if (ddate != null) {
					String materialid = agUpdate.getMaterialIdedit();
					List<String> materiallist = Arrays.asList(materialid.split(","));
					Object[] materialarray = materiallist.toArray();
					String agqty[] = agUpdate.getTargetqtyedit();
					String uomid = agUpdate.getUomIdedit();
					List<String> uomlist = Arrays.asList(uomid.split(","));
					Object[] uomrfq = uomlist.toArray();

					if (materialid != null) {
						for (int a = 0; a <ddate.length; a++) {
							int agId = aglineid[0];
							if (agId == 0) {
								AgreementLine linebean = new AgreementLine();
								linebean.setAgreementlineid(aglineid[a]);
								linebean.setMaterialId(materialarray[a].toString());
								linebean.setTargetqty(agqty[a]);
								linebean.setUomId(uomrfq[a].toString());
								linebean.setNetprice(ddate[a]);
								aglinelist.add(linebean);

							} else {
								AgreementLine linebean = new AgreementLine();
								linebean.setAgreementlineid(aglineid[a]);
								linebean.setMaterialId(materialarray[a].toString());
								linebean.setTargetqty(agqty[a]);
								linebean.setUomId(uomrfq[a].toString());
								linebean.setNetprice(ddate[a]);
								aglinelist.add(linebean);
								ss = aglineid[a];

								checked = request.getParameter("Checkdelete" + ss);

								if (s2.equals(checked)) {

									agservice.deleteChildDetails(ss);

								}
								if (s1.equals(checked) || checked == null) {
									aglinelist.add(linebean);

								}

							}

						}
					}

				}

				agUpdate.setAgreementline(aglinelist);
				msg = agservice.updateAgreement(agUpdate);

				if (msg.equals("S")) {
					request.setAttribute("RfqUpdateSuccess",
							"RFQ Data Updated Successfully");
					model.addAttribute("RFQ", new RfqBean());
				} else {
					request.setAttribute("RfqUpdateFail",
							"RFQ Data Updated Successfully");
					model.addAttribute("RFQ", new RfqBean());
				}

			} catch (Exception e) {
				request.setAttribute("RfqUpdateFail",
						"RFQ Data Updated Successfully");
				model.addAttribute("RFQ", new RfqBean());
				e.printStackTrace();
			}

			return "agreementHome";
		}

	 @RequestMapping(value = "/agDelete", method = RequestMethod.GET)
		public String rfqDelete(@ModelAttribute("AGREEMENT") Agreement agDelete,
				Model model, HttpServletRequest request,
				HttpServletResponse response) {
			String agDel = null;
			response.setCharacterEncoding("UTF-8");

			int rId = Integer.parseInt(request.getParameter("agdelete"));
			try {
				String msg = agservice.deleteAgreement(rId);
				if (msg.equals("S")) {

					session = request.getSession(false);
					Date date = new Date();
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(session.getAttribute("userId")
							.toString(), "D", "AGREEMENT", "ROW", String.valueOf(rId),
							"1", modifiedDate, session.getAttribute("userName")
									.toString());
					agDel = "Agreement Details Deleted Successfully";
					request.setAttribute("RfqDeleteSuccess",
							"Agreement Data Deleted Successfully");
					model.addAttribute("AGREEMENT", new Agreement());
				} else {
					agDel = "Agreement Details Deletion Failed";
					request.setAttribute("RfqDeleteFail",
							"Agreement Data Deleted Successfully");
					model.addAttribute("AGREEMENT", new Agreement());
				}

			} catch (Exception e) {
				agDel = "Agreement Details Deletion Failed";
				request.setAttribute("RfqDeleteFail",
						"Agreement Data Deleted Successfully");
				e.printStackTrace();
			}
			return "agreementHome";

		}

		@ModelAttribute("xmlItems")
		public Map<String, String> populatLabelDetails() {
			String name = "agreementId";

			Map<String, String> map = new HashMap<String, String>();

			try {
				map = xmlService.populateXmlLabels(name);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return map;
		}

		@RequestMapping(value = "/agreementAdvanceSearch", method = RequestMethod.GET)
		public String AgAdvanceSearch(@ModelAttribute("AGREEMENT") Agreement agbean,
				HttpServletRequest request, HttpServletResponse response) {
			response.setCharacterEncoding("UTF-8");

			List<Agreement> rfqlist = null;
			String name1 = "agreementId", s1 = null, s2 = null;
			List<Object[]> returnString = null;
			// Vendor v=null;
			rfqlist = new ArrayList<Agreement>();
			agbean.setAdvanceSearchHidden(1);
			try {
				returnString = xmlService.populateXml(name1);
				Iterator<Object[]> list = returnString.iterator();
				for (Object[] object : returnString) {
					Agreement v = new Agreement();

					s1 = (String) object[0];
					s2 = (String) object[1];
					v.setFirstLabel(s1);
					v.setSecondLabel(s2);
					rfqlist.add(v);

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("agSearchAdvance", rfqlist);

			return "agreementHome";
		}

		@RequestMapping(value = "/agAdvanceSearchOperations", method = RequestMethod.POST)
		public String ssAdvanceSearchOperations(@ModelAttribute Agreement agBean,
				HttpServletRequest request, HttpServletResponse response) {
			List<Agreement> agbeans = null;
			List<Object[]> objectsArray = null;

			response.setCharacterEncoding("UTF-8");
			try{
			agbeans = new ArrayList<Agreement>();
			String columns = agBean.getFirstLabel();
			String operations = agBean.getOperations1();
			String advanceSearchText = agBean.getAdvanceSearchText();

			if (advanceSearchText.length() != 0) {

				objectsArray = agservice.setAgreementAdvanceSearch(columns, operations,
						advanceSearchText);
			} else {
				objectsArray = agservice.setAgreementSearch("ALL");
			}
			iterator = objectsArray.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				Agreement agbean = new Agreement();
					agbean.setAgreementId((Integer) obj[0]);
					AgreementType agtype = (AgreementType) obj[1];
					agbean.setAgreementtypeid(agtype.getAgreementType());
					agbean.setAgreementNo((String) obj[2]);
					Vendor vendor = (Vendor) obj[3];
					agbean.setVendorId(vendor.getVendorName());
					Organization org = (Organization) obj[4];
					agbean.setOrgId(org.getOrgName());
					PurchaseOrganization po = (PurchaseOrganization) obj[5];
					agbean.setPurOrgId(po.getPurOrg());
					agbean.setAgreementDate(dateService.dateFormat(
							dateService.dateParse((String) obj[6], "se"), "se"));
					agbean.setStdt(dateService.dateFormat(
							dateService.dateParse((String) obj[7], "se"), "se"));
					agbean.setEtdt(dateService.dateFormat(
							dateService.dateParse((String) obj[8], "se"), "se"));
					agbeans.add(agbean);
			}

			request.setAttribute("agbeans", agbeans);
			//model.addAttribute("RFQ", new RfqBean());
			}catch(Exception e){
				e.printStackTrace();
			}
			return "rfqHome";
		}
		@RequestMapping(value = "/populatePO", method = RequestMethod.POST)
		public @ResponseBody
		Map<Integer, String> POIds(HttpServletRequest request,
				HttpServletResponse response, StockTransferBean stBean) {
			response.setCharacterEncoding("UTF-8");
			int orgId = Integer.parseInt(request.getParameter("OrgId"));
		
			Map<Integer, String> map = null;
			List<PurchaseOrganization> plist=new ArrayList<PurchaseOrganization>();
			try {
				plist = agservice.selectPo(orgId);
				if (plist!=null) {
					map = new HashMap<Integer, String>();
				}
			Iterator<PurchaseOrganization>	itr = plist.iterator();
				while (itr.hasNext()) {
					Object objects = itr.next();
					PurchaseOrganization po= (PurchaseOrganization) objects;
					map.put((Integer) po.getPurOrg_Id(), (String) po.getPurOrg());

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return map;
		}
		@RequestMapping(value = "/populatePOEdit", method = RequestMethod.POST)
		public @ResponseBody
		Map<Integer, String> POEditIds(HttpServletRequest request,
				HttpServletResponse response, StockTransferBean stBean) {
			response.setCharacterEncoding("UTF-8");
			int orgId = Integer.parseInt(request.getParameter("OrgIdEdit"));
		
			Map<Integer, String> map = null;
			List<PurchaseOrganization> plist=new ArrayList<PurchaseOrganization>();
			try {
				plist = agservice.selectPo(orgId);
				if (plist!=null) {
					map = new HashMap<Integer, String>();
				}
			Iterator<PurchaseOrganization>	itr = plist.iterator();
				while (itr.hasNext()) {
					Object objects = itr.next();
					PurchaseOrganization po= (PurchaseOrganization) objects;
					map.put((Integer) po.getPurOrg_Id(), (String) po.getPurOrg());

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return map;
		}
}
