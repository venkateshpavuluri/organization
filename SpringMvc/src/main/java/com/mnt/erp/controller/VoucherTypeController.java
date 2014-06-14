package com.mnt.erp.controller;

/*
 @author Srinivas
 @version 1.0   
 */
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
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.VoucherTypeBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.VoucherTypeService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class VoucherTypeController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	@Autowired
	VoucherTypeService vouchertservice;
	
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/voucherTypeHome", method = RequestMethod.GET)
	public String getVoucherType(
			@ModelAttribute VoucherTypeBean vbean,HttpServletRequest request,
			SessionStatus status, Model model,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("voucherTypeHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		model.addAttribute("VoucherType", new VoucherTypeBean());

		return "voucherTypeHome";
	}

	@RequestMapping(value = "/saveVoucherType", method = RequestMethod.POST)
	@RequestScoped
	public String saveVoucherTypes(
			@ModelAttribute("VoucherType") VoucherTypeBean vbean,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request,HttpServletResponse response, SessionStatus sessionStatus,
			ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		String mess = null;
		VoucherTypeBean vbean2 = null;
		String VtSuccessdup = null;
		HttpSession session=null;
		String res=null;
		String name = vbean.getVouchertype();
		Long id = 0L;
		try {
			id = vouchertservice.getVoucherTypeCount(name);
	
			if (id == 0) {
				session=request.getSession(false);
				mess = vouchertservice.saveVoucherTypeservice(vbean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				vbean2 = new VoucherTypeBean();
				map.addAttribute("VoucherType", vbean2);
				if (mess.equals("S")) {
					res = "redirect:voucherTypeHome.mnt?list=" + "success" + "";
				}
				else{
					res = "redirect:voucherTypeHome.mnt?listwar=" + "fail" + "";
				}
			} else {
				VtSuccessdup = "Warning ! Voucher Type is already exists. Please try some other name";
				vbean.setVthide(1);
				request.setAttribute("VtSuccessdup", VtSuccessdup);
				
				return "voucherTypeHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	@RequestMapping(value = "/searchVoucherDetails", method = RequestMethod.GET)
	public String searchVoucherTypes(
			@ModelAttribute("VoucherType") VoucherTypeBean vbean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<VoucherTypeBean> vtbeans = new ArrayList<VoucherTypeBean>();
			String dbField = vbean.getXmlLabel();
			String operation = vbean.getOperations();
			String basicSearchId = vbean.getBasicSearchId();

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

				list = vouchertservice.searchVoucherType();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					VoucherTypeBean vtbean2 = new VoucherTypeBean();
					vtbean2.setVouchertypeid((Integer) obj[0]);
					vtbean2.setVouchertype((String) obj[1]);
					vtbeans.add(vtbean2);
				}

			} else {

				list = vouchertservice.basicSearchVoucherType(dbField, operation, basicSearchId);				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					VoucherTypeBean vtbean2 = new VoucherTypeBean();
					vtbean2.setVouchertypeid((Integer) obj[0]);
					vtbean2.setVouchertype((String) obj[1]);
					vtbeans.add(vtbean2);
				}
			
			
			}
			request.setAttribute("vocherValues", "vocherValues");
			request.setAttribute("vtbeans", vtbeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "voucherTypeHome";
	}

	@ModelAttribute("VoucherSearch")
	public Map<Integer, String> populateVoucherTypeids() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = vouchertservice.selectVoucherTypeids();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				map.put((Integer) obj[0], ((String) obj[1]));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/VoucherTypesedit", method = RequestMethod.GET)
	public String editVoucherType(
			@ModelAttribute("VoucherType") VoucherTypeBean vtbean,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("voucheredit"));

		try {
			List<VoucherTypeBean> vtbeans = new ArrayList<VoucherTypeBean>();
			list = vouchertservice.searchVoucherTypeWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				vtbean.setEvouchertypeid((Integer) obj[0]);
				vtbean.setEvouchertype((String) obj[1]);
				vtbeans.add(vtbean);
			}
			request.setAttribute("editvalues", vtbeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "voucherTypeHome";

	}

	@RequestMapping(value = "/VoucherTypeUpdate", method = RequestMethod.POST)
	public String updateVoucherTypes(
			@ModelAttribute("VoucherType") VoucherTypeBean vtbean,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = vtbean.getEvouchertype();
		int vtid = vtbean.getEvouchertypeid();
		String VtSuccessdupedit = null;

		Long id = 0L;
		try {

			id = vouchertservice.getVoucherTypeCountedit(name, vtid);
			if (id == 0) {
				vtbean.setVouchertypeid(vtbean
						.getEvouchertypeid());

				vtbean.setVouchertype(vtbean.getEvouchertype());

				String message = vouchertservice.updateVoucherType(vtbean);
						

				if (message.equals("S")) {
					request.setAttribute("VoucherTypeUpdate","Voucher Type has been updated");
					
				}
				else{
					request.setAttribute("VoucherTypeUpdateError","Voucher Type has not been updated");
				}
			} else {
				VtSuccessdupedit = "Warning ! Voucher Type is already exists. Please try some other name";
				vtbean.setEvthide(1);
				request.setAttribute("VtSuccessdupedit", VtSuccessdupedit);
				request.setAttribute("editvalues", "editvalues");
				return "voucherTypeHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "voucherTypeHome";
	}

	@RequestMapping(value = "/VoucherTypeDelete", method = RequestMethod.GET)
	@RequestScoped
	public ModelAndView VoucherTypeDelete(HttpServletRequest request,HttpServletResponse response) {
		int id = 0;
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		try {
			id = Integer.parseInt(request
					.getParameter("voucherdelete"));

			String msg = vouchertservice.deleteVoucherType(id);
					if (msg.equals("S")){
				request.setAttribute("VoucherTypeDelete","Voucher Type has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Voucher Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			 
					}
					else{
						request.setAttribute("VoucherTypeDeleteError","Voucher Type has not been deleted");	
					}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("voucherTypeHome", "VoucherType",
				new VoucherTypeBean());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "vouchertypeid";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
