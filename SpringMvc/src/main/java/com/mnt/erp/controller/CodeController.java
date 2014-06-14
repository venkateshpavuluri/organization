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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.mnt.erp.bean.Code;
import com.mnt.erp.bean.CodeGroup;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CodeService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.XmlLabelsService;



/**
 * @author kirangangone
 * @version 1.0 04-01-2014
 * @build 0.0
 * 
 */

@Controller
@Scope("request")
public class CodeController {
	@Autowired
	CodeService codeService;
	@Autowired
	XmlLabelsService xmlService;
	
	@Autowired
	MenuService menuService;
	
	@Autowired
	AuditLogService auditLogService;
	@RequestMapping(value = "/Code", method = RequestMethod.GET)
	public ModelAndView getCode(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("Code.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
				return new ModelAndView("codeHome","codeCommand",new Code());

	}
	
	
	@ModelAttribute("codeGroups")
	public Map<Integer, String> getCodeGroupId() {
		List<Object[]> codeListvalues = null;
		Iterator<Object[]> codeIterator = null;
		Object[] codeObjects = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			codeListvalues = codeService.getCodeGroupId();
			codeIterator = codeListvalues.iterator();
			while (codeIterator.hasNext()) {
				codeObjects = (Object[]) codeIterator.next();
				map.put((Integer) codeObjects[0], (String) codeObjects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "code";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	
	
	
	
	@RequestMapping(value = "/codeAdd", method = RequestMethod.POST)
	public String addCode(@ModelAttribute("codeCommand") Code codeAdd,
			HttpServletRequest request, HttpServletResponse response,Model model) {
		response.setCharacterEncoding("UTF-8");
	String msg=null;
	HttpSession session=null;	
	String res=null;
	String code=codeAdd.getCode();
	String codeGroupId=codeAdd.getCodeGroupId();
	
	long codeCheck=codeService.duplicateCheckCode(code, codeGroupId);


		if (codeCheck == 0) {
			try {
				session=request.getSession(false);
				msg = codeService.saveCode(codeAdd,session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
			
				if(msg=="S")
				{
					res = "redirect:Code.mnt?list=" + "success" + "";
					
				}
				else
				{
					res = "redirect:Code.mnt?listwar=" + "fail" + "";
				}

			} catch (Exception e) {
				e.printStackTrace();
				
			}
		} else {
			codeAdd.setAid(1);
			System.out.println("the else block is working");
			request.setAttribute("codeAddDuplicateCheck","Warning ! Code  aleardy exists.");
			return "codeHome";

		}
		return res;
	}
	
	
	
	
	@RequestMapping(value = "/codeSearch", method = RequestMethod.GET)
	public String searchScheduling(
			@ModelAttribute("codeCommand") Code code,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Code> codeList = new ArrayList<Code>();
		List<Object[]> codeObjecList = null;
		Iterator<Object[]> codeIterator = null;
		Object[] codeObjects = null;
		try {
			
			String dbField = code.getXmlLabelBasic();
			String operation = code.getOperations();
			String basicSearchId = code.getBasicSearchId();

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
				codeObjecList = codeService.basicSearchCode("","","");

			} else {

				// list = custService.searchCustomerWithId(cid, status);
				codeObjecList = codeService.basicSearchCode(dbField, operation,
						basicSearchId);
			}
			codeIterator = codeObjecList.iterator();
			while (codeIterator.hasNext()) {
				codeObjects = (Object[]) codeIterator.next();
				Code cb = new Code();
				cb.setCode(((String) codeObjects[0]));
				cb.setCodeId((Integer)codeObjects[2]);
			    CodeGroup codeGroup=(CodeGroup)codeObjects[3];
			    cb.setCodeGroupId(codeGroup.getCodeGroup());
				codeList.add(cb);

			}
			// purchaseOrderSearch.setPuEditId(0);
			request.setAttribute("codeList", codeList);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "codeHome";

	}
	
	
	
	@RequestMapping(value = "/codeEdit", method = RequestMethod.GET)
	public String creditNoteEdit(
			@ModelAttribute("codeCommand") Code code,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Code> codeEditList = new ArrayList<Code>();
	//	List<CreditNoteDetail> creditNoteDetailEditList = new ArrayList<CreditNoteDetail>();

		int purcId = Integer.parseInt(request.getParameter("codeId"));

		// String status = "Y";
		try {

			List<Object> codeList = codeService.editCode(purcId);
			Iterator<Object> codeIterator = codeList.iterator();
			if (codeIterator.hasNext()) {
				Object oo = codeIterator.next();
				Code ccb = (Code)oo;
				code.setCodeIdEdit(ccb.getCodeId());
				code.setCodeEdit(ccb.getCode());
				code.setCodeGroupIdEdit(ccb.getCodeGroupId());
				code.setCnId(2);
				
				}
				
			codeEditList.add(code);
		
			request.setAttribute("codeEditList", codeEditList);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "codeHome";
	}
	
	
	
	
	@RequestMapping(value = "/codeUpdate", method = RequestMethod.POST)
	public String customerUpdate(
			@ModelAttribute("codeCommand") Code codeUpdate,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String msg=null;
		int id=codeUpdate.getCodeIdEdit();
		String code=codeUpdate.getCodeEdit();
		String codeGroupId=codeUpdate.getCodeGroupIdEdit();
		long updateCheck=codeService.duplicateCheckCodeUpdate(code, codeGroupId, id);
		if(updateCheck==0){
		codeUpdate.setCode(codeUpdate.getCodeEdit());
		codeUpdate.setCodeGroupId(codeUpdate.getCodeGroupIdEdit());
		codeUpdate.setCodeId(codeUpdate.getCodeIdEdit());
		msg = codeService.updateCode(codeUpdate);
	
		if (msg=="S") {
		
			request.setAttribute("codeUpdate", "Code has been updated");

		}
		else{
			request.setAttribute("codeUpdateError", "Code has not been updated");
		}
		}
		else{
		
			request.setAttribute("codeEditList", "codeEditList");
			request.setAttribute("codeUpdateCheck", "Code already exists");
			return "codeHome";
		}
		model.addAttribute("codeCommand", new Code());
		return "codeHome";
	}
	
	
	
	
	@RequestMapping(value = "/codeDelete", method = RequestMethod.GET)
	public ModelAndView codeDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		try {
			
			int id = Integer.parseInt(request.getParameter("codeId"));
		 String msg = codeService.deleteCode(id);
		 HttpSession session=null;
			if (msg=="S")
			{
				request.setAttribute("codeDeleted", "Code has been deleted successfully");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Code","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else
			{
				request.setAttribute("codeDeleteError", "Code has not been deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return new ModelAndView("codeHome", "codeCommand",
				new Code());
	}
	
}
