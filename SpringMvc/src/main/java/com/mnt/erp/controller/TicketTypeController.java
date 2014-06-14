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
import com.mnt.erp.bean.TicketTypeBean;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;
import com.mnt.erp.service.ticketTypeService;

/**
 * @author devi
 *
 */
@Controller
public class TicketTypeController {
	@Autowired
	ticketTypeService tService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	
	@RequestMapping(value = "/ticketTypeHome", method = RequestMethod.GET)
	public ModelAndView ticketTypeHome(
			@ModelAttribute("TicketType") TicketTypeBean tBean,
			SessionStatus status, HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("ticketTypeHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);

		return new ModelAndView("ticketTypeHome", "TicketType", tBean);
	}

	@RequestMapping(value = "/ticketTypeAdd", method = RequestMethod.POST)
	public String saveTicketType(
			@ModelAttribute("TicketType") TicketTypeBean ticBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg,res = null;
		HttpSession session=null;
		String ticketType = ticBean.getTicketType();
		TicketTypeBean tBean = (TicketTypeBean) ticBean;
		Long checkAsset = tService.checkTicketTypeCount(ticketType);
		if (checkAsset == 0) {
			try {
				session=request.getSession(false);
				msg=tService.saveTicketTypeDetails(tBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				if(msg.equals("S"))
					res = "redirect:ticketTypeHome.mnt?list=" + "success" + "";
				else
					res = "redirect:ticketTypeHome.mnt?listwar=" + "fail" + "";
			} catch (Exception e) {
				e.printStackTrace();
				res = "redirect:ticketTypeHome.mnt?listwar=" + "fail" + "";
				
			}
		} else {
			ticBean.setAtId(1);
			request.setAttribute("addTicketDuplicate",
					"Ticket is already exists. Please try some other name");

			return "ticketTypeHome";

		}

		return res;

	}

	

	@RequestMapping(value = "/ticketTypeSearch", method = RequestMethod.GET)
	public String searchTicketType(
			@ModelAttribute("TicketType") TicketTypeBean ticSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<TicketTypeBean> tBean = new ArrayList<TicketTypeBean>();

		try {
			int id = ticSearch.getTicketType_Id();
			String dbField = ticSearch.getXmlLabel();
			String operation = ticSearch.getOperations();
			String basicSearchId = ticSearch.getBasicSearchId();

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
				list = tService.searchTicketType();

			} else {
				list = tService.basicSearchTicketType(dbField, operation, basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				TicketTypeBean ab = new TicketTypeBean();
				Object[] obj = (Object[]) iterator.next();
				ab.setTicketType_Id((Integer) obj[0]);
				ab.setTicketType((String) obj[1]);
				
				tBean.add(ab);
			}

			request.setAttribute("ticketBean", tBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "ticketTypeHome";

	}

	@RequestMapping(value = "/ticketTypeEdit", method = RequestMethod.GET)
	public String ticketTypeEdit(
			@ModelAttribute("TicketType") TicketTypeBean ticketEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("ticketId"));
		List<Object[]> list = null;
		List<TicketTypeBean> ticketBean = new ArrayList<TicketTypeBean>();
		try {
			list = tService.searchTicketTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				ticketEdit.setTicketType_Id((Integer) obj[0]);
				ticketEdit.setTicketType((String) obj[1]);
				ticketBean.add(ticketEdit);
			}
			request.setAttribute("ticketTypeEdit", ticketBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "ticketTypeHome";

	}

	@RequestMapping(value = "/ticketTypeUpdate", method = RequestMethod.POST)
	public String ticketTypeUpdate(
			@ModelAttribute("TicketType") TicketTypeBean ticBean,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		        
		String ticketType=ticBean.getTicketType();
		int ticketTypeId=ticBean.getTicketType_Id();
		
        ticBean.setTicketType(ticketType);
        ticBean.setTicketType_Id(ticketTypeId);
				
		Long checkUpdate = tService.updateCheckTicketType(ticketType, ticketTypeId);
				
		if (checkUpdate == 0) {

			try {
				
				String msg = tService.updateTicketType(ticBean);
                
				if (msg.equals("S")) {
					request.setAttribute("ticketUpdate", "Ticket Data Updated Successfully");
					

				} else {
					request.setAttribute("ticketUpdateErr", "Ticket Data Doesn't updated properly");
				}

			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("ticketUpdateErr", "Ticket Data Doesn't updated properly");
				
			}

		} else {

			request.setAttribute("updateTicketTypeDuplicate",
					"ticketType is already exists. Please try some other name");
			request.setAttribute("ticketTypeEdit", "ticketTypeEdit");
			return "ticketTypeHome";

		}
		model.addAttribute("TicketType", new TicketTypeBean());
		return "ticketTypeHome";
	}

	@RequestMapping(value = "/ticketTypeDelete", method = RequestMethod.GET)
	public String ticketTypeDelete(
			@ModelAttribute("TicketType") TicketTypeBean ticketDelete,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("ticketId"));
		try {

			String msg = tService.deleteTicketType(id);
			if (msg == "S") {
				session=request.getSession(false);
				Date date = new Date();
			String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
			auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","ticketType","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
				request.setAttribute("ticketDel",  "TicketType Data Deleted Successfully");
				
			} else {

				request.setAttribute("ticketDelErr",  "TicketType Data Doesn't deleted properly");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("TicketType", new TicketTypeBean());
		return "ticketTypeHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "ticketTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}




}
