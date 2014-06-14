/**
 * 
 */
package com.mnt.erp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Voucher;
import com.mnt.erp.bean.VoucherTypeBean;
import com.mnt.erp.bean.WorkFlowList;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.VendorService;
import com.mnt.erp.service.VoucherService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author kirangangone
 * @version 1.0 05-02-2014
 * @build 0.0
 * 
 */

@Controller
@Scope("request")
public class VoucherController {
	@Autowired
	VoucherService voucherService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	VendorService categoryService;
	@Autowired
	PopulateService populateService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	DateConversionService dateService;

	HttpSession session;

	@RequestMapping(value = "/Voucher", method = RequestMethod.GET)
	public ModelAndView getPurchaseOrder(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("Voucher.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("voucherHome", "voucherCommand", new Voucher());

	}

	@ModelAttribute("employeeId")
	public Map<Integer, String> getVoucherGroupId() {
		List<Object[]> voucherListvalues = null;
		Iterator<Object[]> voucherIterator = null;
		Object[] voucherObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			voucherListvalues = voucherService.getVoucherEmployeeId();
			voucherIterator = voucherListvalues.iterator();
			while (voucherIterator.hasNext()) {
				voucherObjects = (Object[]) voucherIterator.next();
				map.put((Integer) voucherObjects[0], (String) voucherObjects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return map;
	}

	@ModelAttribute("statusId")
	public Map<Integer, String> selectStatusId() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		List<Object[]> voucherListvalues = null;
		Object[] voucherObjects = null;
		Iterator<Object[]> voucherIterator = null;
		try {
			voucherListvalues = categoryService
					.selectPaymentMethodIds("statusId");
			voucherIterator = voucherListvalues.iterator();
			while (voucherIterator.hasNext()) {
				voucherObjects = (Object[]) voucherIterator.next();
				map.put((Integer) voucherObjects[0], (String) voucherObjects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("voucherType_Id")
	public Map<Integer, String> populatMaterialids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = populateService
					.poPulate("select m.vouchertypeid,m.vouchertype from VoucherTypeBean m");
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

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "voucher";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/voucherCheck", method = RequestMethod.POST)
	public @ResponseBody
	String creditNoteNoDuplicateAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;
		int beforeCreditNoteNoValue = 0;
		try {

			String beforeCreditNoteNo = request.getParameter("voucher");
			String id = request.getParameter("voucherId");
			if (id.equalsIgnoreCase("0")) {
				beforeCreditNoteNoValue = voucherService.duplicateCheckVoucher(
						beforeCreditNoteNo, "");
			} else {
				beforeCreditNoteNoValue = voucherService.duplicateCheckVoucher(
						beforeCreditNoteNo, id);
			}
			Voucher creditNote = new Voucher();
			if (beforeCreditNoteNoValue != 0) {
				creditNote.setVoucherDuplicate(1);
				msa = "Warning ! Voucher aleardy exists. Please try some other one";
				return msa;
			}
			if (beforeCreditNoteNoValue == 0) {
				creditNote.setVoucherDuplicate(1);
				msa = "";
				return msa;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msa;
	}

	@RequestMapping(value = "/voucherAdd", method = RequestMethod.POST)
	public String addVoucher(
			@ModelAttribute("voucherCommand") Voucher voucherAdd,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		boolean flag = false;
		Date date = new Date();
		HttpSession session = request.getSession();
		int checkCreditNote = voucherService.duplicateCheckVoucher(
				voucherAdd.getVoucherDT(), "");
		if (checkCreditNote == 0) {
			try {
				voucherAdd.setVoucherDT(dateService.dateFormat(
						dateService.dateParse(voucherAdd.getVoucherDT(), "au"),
						"au"));
				List<Object[]> list2 = null;
				String id = (String) session.getAttribute("userId"), stepid = null, userid = null;
				WorkFlowList wflist = new WorkFlowList();
				wflist.setReceivedFrom(id);
				wflist.setWorkListId(voucherAdd.getVoucherNo());
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				wflist.setReceivedDTTM(dateFormat.format(date));
				wflist.setWorkListContext("VO");
				wflist.setWorkListStatus("Queued");
				list2 = voucherService.getStepUser();
				Iterator<Object[]> iterator = list2.iterator();
				while (iterator.hasNext()) {
					Object[] objects = (Object[]) iterator.next();
					stepid = (String) objects[0];
					userid = (String) objects[1];
				}
				wflist.setUserId(userid);
				wflist.setStep(stepid);
				flag = voucherService.saveVoucher(voucherAdd);
				if (flag) {
					Date date1 = new Date();
					session = request.getSession(false);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date1);
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Voucher", "ROW", String.valueOf(voucherAdd
									.getVoucherId()), "1", modifiedDate,
							session.getAttribute("userName").toString());
					String wmsg = voucherService
							.saveWorkFlowListDaoDetails(wflist);
					String voucherSave = "$uccess : Voucher Data is saved successfully";
					return "redirect:Voucher.mnt?list=" + voucherSave + "";
				} else {
					String voucherSave = "$uccess : Voucher Data is not saved";
					return "redirect:Voucher.mnt?listwar=" + voucherSave + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				String voucherSave = "$uccess : Voucher Data is not saved";
				return "redirect:Voucher.mnt?listwar=" + voucherSave + "";
			}
		} else {
			request.setAttribute("fail",
					"Warning ! Voucher  aleardy exists. Please try some other Voucher ");
			return "voucherHome";

		}
	}

	@RequestMapping(value = "/voucherSearch", method = RequestMethod.GET)
	public String searchScheduling(
			@ModelAttribute("voucherCommand") Voucher voucher, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Voucher> voucherList = new ArrayList<Voucher>();
		List<Object[]> voucherObjecList = null;
		Iterator<Object[]> voucherIterator = null;
		Object[] voucherObjects = null;
		try {

			String dbField = voucher.getXmlLabelBasic();
			String operation = voucher.getOperations();
			String basicSearchId = voucher.getBasicSearchId();

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
				voucherObjecList = voucherService
						.basicSearchVoucher("", "", "");

			} else {
				voucherObjecList = voucherService.basicSearchVoucher(dbField,
						operation, basicSearchId);
			}
			voucherIterator = voucherObjecList.iterator();
			while (voucherIterator.hasNext()) {
				voucherObjects = (Object[]) voucherIterator.next();
				Voucher cb = new Voucher();
				cb.setVoucherId((Integer) voucherObjects[0]);
				cb.setVoucherNo((String) voucherObjects[1]);
				cb.setVoucherDT(dateService.dateFormat(
						dateService.dateParse((String) voucherObjects[2], "se"),
						"se"));
				cb.setEmployeeId((String) voucherObjects[3]);
				cb.setAmount((String) voucherObjects[4]);
				VoucherTypeBean vv = (VoucherTypeBean) voucherObjects[6];
				cb.setVoucherType_Id(vv.getVouchertype());
				Status s = ((Status) voucherObjects[7]);
				cb.setStatusId(s.getStatus());

				voucherList.add(cb);
			}
			request.setAttribute("voucherList", voucherList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "voucherHome";

	}

	@RequestMapping(value = "/voucherEdit", method = RequestMethod.GET)
	public String voucherEdit(
			@ModelAttribute("voucherCommand") Voucher voucher, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Voucher> voucherEditList = new ArrayList<Voucher>();
		int purcId = Integer.parseInt(request.getParameter("coaId"));
		try {
			List<Object> voucherList = voucherService.editVoucher(purcId);
			Iterator<Object> voucherIterator = voucherList.iterator();
			if (voucherIterator.hasNext()) {
				Object oo = voucherIterator.next();
				Voucher ccb = (Voucher) oo;
				voucher.setVoucherId(ccb.getVoucherId());
				voucher.setSignature(ccb.getSignature());
				voucher.setVoucherNo(ccb.getVoucherNo());
				voucher.setVoucherType_Id(ccb.getVoucherType_Id());
				voucher.setVoucherDT(dateService.dateFormat(
						dateService.dateParse(ccb.getVoucherDT(), "se"), "se"));
				voucher.setEmployeeId(ccb.getEmployeeId());
				voucher.setAmount(ccb.getAmount());
				voucher.setStatusId(ccb.getStatusId());
			}
			voucherEditList.add(voucher);
			request.setAttribute("voucherEditList", voucherEditList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "voucherHome";
	}

	@RequestMapping(value = "/voucherUpdate", method = RequestMethod.POST)
	public String voucherUpdate(
			@ModelAttribute("voucherCommand") Voucher voucherUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		boolean flag = false;
		try {
			voucherUpdate.setVoucherDT(dateService.dateFormat(
					dateService.dateParse(voucherUpdate.getVoucherDT(), "au"),
					"au"));
			flag = voucherService.updateVoucher(voucherUpdate);
			String voucherUpdateText = null;
			if (flag == true) {
				voucherUpdateText = "$uccess : Voucher Data is updated successfully";
				request.setAttribute("voucherUpdate", voucherUpdateText);

			} else {
				String fail = "Error ! : Voucher data is not updated properly";
				request.setAttribute("voucherUpdateFail", fail);
				model.addAttribute("voucherCommand", new Voucher());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "voucherHome";
	}

	@RequestMapping(value = "/voucherDelete", method = RequestMethod.GET)
	public String voucherDelete(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {

			int id = Integer.parseInt(request.getParameter("voucherId"));
			boolean msg = voucherService.deleteVoucher(id);
			model.addAttribute("voucherCommand", new Voucher());
			if (msg == true) {
				Date date1 = new Date();
				session = request.getSession(false);
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date1);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Voucher", "ROW", String.valueOf(id),
						"1", modifiedDate, session.getAttribute("userName")
								.toString());
				String voucherUpdate = "$uccess : Voucher Data is deleted successfully";
				request.setAttribute("voucherDelete", voucherUpdate);

				return "voucherHome";
			} else {

				request.setAttribute("voucherDeleteFail",
						"Error ! : Voucher data is not deleted properly");
				return "voucherHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("voucherDeleteFail",
					"Error ! : Voucher data is not deleted properly");
			return "voucherHome";
		}
	}

}
