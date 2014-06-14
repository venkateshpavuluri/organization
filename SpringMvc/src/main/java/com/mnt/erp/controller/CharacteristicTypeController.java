package com.mnt.erp.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.CharacteristicType;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CharacteristicTypeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Parvathi
 * @version 1.0 
 * @date 04-1-2014
 */

@Controller
public class CharacteristicTypeController {
	
	@Autowired
	CharacteristicTypeService charTypeService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	
	@Autowired
	XmlLabelsService xmlService;
	
	
	
	
	@RequestMapping(value="/CharacteristicTypeHome",method=RequestMethod.GET)
	public ModelAndView getCharacteristicType(HttpServletRequest request,HttpServletResponse response)
	{
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("CharacteristicTypeHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("characteristicTypeHome","characteristicTypeCommand",new CharacteristicType());
	}
	
	@RequestMapping(value = "/checkCharacteristicTypeDuplicate", method = RequestMethod.POST)
	
	public @ResponseBody String checkCharacterSticAddDuplicate(HttpServletRequest request,HttpServletResponse response, CharacteristicType characteristicTypeBean) {
		response.setCharacterEncoding("UTF-8");
		
		String message=null;
		String CharacteristicType = request.getParameter("CharacteristicType");
		Long checkCharacteristicType = charTypeService.checkCharacteristicType(CharacteristicType);
		
		if (checkCharacteristicType != 0) {
			
			characteristicTypeBean.setAid(1);
			message = "Warning ! Characteristic Type is already exists.";
			
		}
		else {
			
			characteristicTypeBean.setAid(1);
			message = "";
			
		}

		return message;
	}
	
	@RequestMapping(value = "/characteristicTypeAdd", method = RequestMethod.POST)
	public String saveCharacteristicType(
			@ModelAttribute("characteristicTypeCommand") CharacteristicType characteristicTypeBean,
			HttpServletRequest request, SessionStatus status,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=null;
		String msg=null;
		String res=null;
	
			try {
				session=request.getSession(false);
				msg=charTypeService.saveCharacteristicTypeDetails(characteristicTypeBean,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				
				if(msg=="S"){
					res = "redirect:CharacteristicTypeHome.mnt?list=" + "success" + "";
				}
				else
				{
					res = "redirect:CharacteristicTypeHome.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				
			}


		return res;

	}



	@RequestMapping(value = "/characteristicTypeSearch", method = RequestMethod.GET)
	public String searchCharacteristicType(
			@ModelAttribute("characteristicTypeCommand") CharacteristicType characteristicTypeSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Object[]> list = null;
		List<CharacteristicType> characteristicTypeBean = new ArrayList<CharacteristicType>();

		try {
			
			String dbField = characteristicTypeSearch.getXmlLabel();
			String operation = characteristicTypeSearch.getOperations();
			String basicSearchId = characteristicTypeSearch.getBasicSearchId();

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
				list = charTypeService.searchCharacteristicType();

			} else {
				
				list = charTypeService.basicSearchCharacteristicType(dbField, operation, basicSearchId);
			}

			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				CharacteristicType ab = new CharacteristicType();
				Object[] obj = (Object[]) iterator.next();
				ab.setCharacteristicType_Id((Integer) obj[0]);
				ab.setCharacteristicType((String) obj[1]);
				characteristicTypeBean.add(ab);
			}

			request.setAttribute("characteristicTypeBean", characteristicTypeBean);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "characteristicTypeHome";

	}

	@RequestMapping(value = "/characteristicTypeEdit", method = RequestMethod.GET)
	public String editCharacteristicType(
			@ModelAttribute("characteristicTypeCommand") CharacteristicType characteristicTypeEdit,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("characteristicTypeId"));
		List<Object[]> list = null;
		List<CharacteristicType> characteristicTypeBean = new ArrayList<CharacteristicType>();
		try {
			list = charTypeService.searchCharacteristicTypeWithId(id);
			Iterator<Object[]> iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				characteristicTypeEdit.setCharacteristicType_IdEdit((Integer) obj[0]);
				characteristicTypeEdit.setCharacteristicTypeEdit((String) obj[1]);
				characteristicTypeBean.add(characteristicTypeEdit);
			}
			request.setAttribute("characteristicTypeEdit", characteristicTypeBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			list = null;
		}
		return "characteristicTypeHome";

	}

	
	@RequestMapping(value = "/checkCharacteristicTypeUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkSalesUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response, CharacteristicType dupBean) {
		response.setCharacterEncoding("UTF-8");
		
		String characteristicTypeEdit = request.getParameter("characteristicTypeEdit");
		
		int charTypeId = Integer.parseInt(request.getParameter("charTypeId"));
	
		String message=null;
		Long checkcharType = charTypeService.updateCheckCharacteristicType(characteristicTypeEdit, charTypeId);
		if (checkcharType != 0) {
			dupBean.setCharacteristicType_IdEdit(1);
			message = "Warning ! Characteristic Type is already exists.";
		} else {
			dupBean.setCharacteristicType_IdEdit(1);
			message = null;
		}

		return message;
	}

	@RequestMapping(value = "/characteristicTypeUpdate", method = RequestMethod.POST)
	public String updateCharacteristicType(
			@ModelAttribute("characteristicTypeCommand") CharacteristicType characteristicTypeUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		
		characteristicTypeUpdate.setCharacteristicType_Id(characteristicTypeUpdate.getCharacteristicType_IdEdit());
		characteristicTypeUpdate.setCharacteristicType(characteristicTypeUpdate.getCharacteristicTypeEdit());
		
			try {

				String msg = charTypeService.updateCharacteristicType(characteristicTypeUpdate);

				if (msg.equals("S")) {
					request.setAttribute("charTypeUpdate", "Characteristic Type has been updated");
					
				} else {
					request.setAttribute("charTypeUpdateError", "Characteristic Type has not been updated");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
       return "characteristicTypeHome";
	}

	
	
	
	@RequestMapping(value = "/characteristicTypeDelete", method = RequestMethod.GET)
	public ModelAndView deleteCharacteristicType(
			@ModelAttribute("characteristicTypeCommand") CharacteristicType characteristicTypeDelete,
			HttpServletRequest request, HttpServletResponse response) {
	
		HttpSession session=null;
		int id = Integer.parseInt(request.getParameter("characteristicTypeId"));
		try {

			String msg = charTypeService.deleteCharacteristicType(id);
			if (msg == "S") {

				request.setAttribute("charTypeDelete", "Characteristic Type has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Characteristic Type","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			} else {

				request.setAttribute("charTypeDeleteError", "Characteristic Type has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("characteristicTypeHome", "characteristicTypeCommand",
				new CharacteristicType());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "characteristicTypeId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	
}
