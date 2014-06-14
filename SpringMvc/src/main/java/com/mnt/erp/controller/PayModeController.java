/**
 * 
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
import com.mnt.erp.bean.PayModeBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.payModeService;

/**
 * @author devi
 *
 */
@Controller
public class PayModeController {
	@Autowired
	payModeService payService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	@RequestMapping(value = "/payModeHome", method = RequestMethod.GET)
	public ModelAndView payModeHome(
			@ModelAttribute("PayMode") PayModeBean payBean,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("payModeHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		return new ModelAndView("payModeHome", "PayMode", payBean);
	}

	@RequestMapping(value = "/payModeAdd", method = RequestMethod.POST)
	public String savePayMode(
			@ModelAttribute("PayMode") PayModeBean payBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg,res = null;
		HttpSession session=null;
		String paymode = payBean.getPayMode();
		PayModeBean aBean = (PayModeBean) payBean;
		Long checkAsset = payService.checkPayModeCount(paymode);

		if (checkAsset == 0) {
			try {
				session=request.getSession(false);
				msg=payService.savePayModeDetails(aBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if(msg.equals("S"))
					res = "redirect:payModeHome.mnt?list=" + "success" + "";
				else
					res = "redirect:payModeHome.mnt?listwar=" + "fail" + "";
			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:payModeHome.mnt?listwar=" + "fail" + "";
				
			}
		} else {
			payBean.setAtId(1);
			request.setAttribute("addPayModeDuplicate",
					"PayMode is already exists. Please try some other name");

			return "payModeHome";

		}

		return res;

	}

	

	@RequestMapping(value = "/payModeSearch", method = RequestMethod.GET)
	public String searchPayMode(
			@ModelAttribute("PayMode") PayModeBean paySearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<PayModeBean> payBean = new ArrayList<PayModeBean>();

		try {
			int id = paySearch.getPayMode_Id();
			String dbField = paySearch.getXmlLabel();
			String operation = paySearch.getOperations();
			String basicSearchId = paySearch.getBasicSearchId();

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
				list = payService.searchPayMode();

			} else {
				list = payService.basicSearchPayMode(dbField, operation, basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				PayModeBean ab = new PayModeBean();
				Object[] obj = (Object[]) iterator.next();
				ab.setPayMode_Id((Integer) obj[0]);
				ab.setPayMode((String) obj[1]);
				payBean.add(ab);
			}

			request.setAttribute("payBean", payBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "payModeHome";

	}

	@RequestMapping(value = "/payModeEdit", method = RequestMethod.GET)
	public String payModeEdit(
			@ModelAttribute("PayMode") PayModeBean payEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("payModeId"));
		List<Object[]> list = null;
		List<PayModeBean> payModeBean = new ArrayList<PayModeBean>();
		try {
			list = payService.searchPayModeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				payEdit.setPayMode_Id((Integer) obj[0]);
				payEdit.setPayMode((String) obj[1]);
				payModeBean.add(payEdit);
			}
			request.setAttribute("payModeEdit", payModeBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "payModeHome";

	}

	@RequestMapping(value = "/payModeUpdate", method = RequestMethod.POST)
	public String payModeUpdate(
			@ModelAttribute("PayMode") PayModeBean payBean,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		        
		String payMode=payBean.getPayMode();
		int payModeId=payBean.getPayMode_Id();
		

		payBean.setPayMode_Id(payModeId);
        payBean.setPayMode(payMode);
		
		Long checkUpdate = payService.updateCheckPayMode(payMode, payModeId);
				
		if (checkUpdate == 0) {

			try {

				String msg = payService.updatePayMode(payBean);

				if (msg.equals("S")) {
					request.setAttribute("payModeUpdate", "PayMode Data Updated Successfully");
					

				} else {
					request.setAttribute("payModeUpdateErr", "PayMode Data Doesn't updated properly");
				}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("payModeUpdateErr", "PayMode Data Doesn't updated properly");
				
			}

		} else {

			request.setAttribute("updatePayModeDuplicate",
					"PayMode is already exists. Please try some other name");
			request.setAttribute("payModeEdit", "payModeEdit");
			return "payModeHome";

		}
		model.addAttribute("PayMode", new PayModeBean());
		return "payModeHome";
	}

	@RequestMapping(value = "/payModeDelete", method = RequestMethod.GET)
	public String payModeDelete(
			@ModelAttribute("PayMode") PayModeBean payDelete,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("payModeId"));
		try {

			String msg = payService.deletePayMode(id);
			if (msg == "S") {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","assertType","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("payModeDel",  "PayMode Data Deleted Successfully");
				
			} else {

				request.setAttribute("payModeDelErr",  "PayMode Data Doesn't deleted properly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("PayMode", new PayModeBean());
		return "payModeHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "payModeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}


}
