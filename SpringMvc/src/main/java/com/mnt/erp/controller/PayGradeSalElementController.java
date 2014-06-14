/**
 * 
 */
package com.mnt.erp.controller;

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



import com.mnt.erp.bean.PayElementBean;
import com.mnt.erp.bean.PayGradeBean;
import com.mnt.erp.bean.PayGradeSalElementBean;

import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PayGradeSalElementService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author devi
 *
 */
@Controller
public class PayGradeSalElementController {
	Logger logger=Logger.getLogger(PayGradeSalElementController.class);
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	PayGradeSalElementService pgseService;
	@Autowired
	MenuService menuService;
	@Autowired
	ERPDao dao;
	@Autowired
	AuditLogService auditLogService;
	
	HttpSession session;
	
	@RequestMapping(value = "/PayGradeSalElementHome", method = RequestMethod.GET)
	public String getPaygrade(@ModelAttribute PayGradeSalElementBean pgBean,
			SessionStatus status, Model model, HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession(false);
		List<String> list=menuService.getPrivilige("PayGradeSalElementHome.mnt", session.getAttribute("userId").toString());
				session.setAttribute("privilegeList",list);
		model.addAttribute("PayGradeSalElement", pgBean);
		return "PayGradeSalElementHome";

	}
	@RequestMapping(value = "/addPayGradeSalElement", method = RequestMethod.POST)
	public String savePaygrade(@ModelAttribute("PayGradeSalElement") PayGradeSalElementBean payBean,
			Model model, HttpServletRequest request,
			HttpServletResponse response,
			DefaultSessionAttributeStore defaultSessionAttributeStore,
			ModelMap map, SessionStatus sessionStatus) {
		response.setCharacterEncoding("UTF-8");
		String msg,res = null;
		
		String payGradesuccessdup = null;
		List<String> list = null;
		String name = payBean.getAmount_Formulae();
		Long id = 0L;

		try {
			id = pgseService.getPayGradeSalElementcount(name);
			
			if (id == 0) {
				session=request.getSession(false);
				msg = pgseService.savePayGradeSalElement(payBean, session.getAttribute("userId").toString(),session.getAttribute("userName").toString());
				 
				
				if (msg.equals("S")) 
					res = "redirect:PayGradeSalElementHome.mnt?list=" + "success" + "";
					
				else
					res = "redirect:PayGradeSalElementHome.mnt?listwar=" + "fail" + "";
				
			} else {
				payGradesuccessdup = "Warning ! PayGradeSalElement is already exists. Please try some other name";
				payBean.setPayGradehide(1);
				request.setAttribute("payGradesuccessdup", payGradesuccessdup);
				return "PayGradeSalElementHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			res = "redirect:PayGradeSalElementHome.mnt?listwar=" + "fail" + "";
		}

		return res;

	}
	@ModelAttribute("payGrade")
	public Map<Integer, String> shift() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = pgseService.selectPayGradeService();
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
	@ModelAttribute("payElement")
	public Map<Integer, String> org() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = pgseService.selectPayElementService();
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
	@RequestMapping(value = "/searchPayGradeSalElement", method = RequestMethod.GET)
	public String searchPaygradeIds(@ModelAttribute("PayGradeSalElement") PayGradeSalElementBean payBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int iid = payBean.getPayGradeSalElement_Id();
			List<PayGradeSalElementBean> btBeans = new ArrayList<PayGradeSalElementBean>();
			String dbField = payBean.getXmlLabel();
			String operation = payBean.getOperations();
			String basicSearchId = payBean.getBasicSearchId();
            
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
				list = pgseService.searchPayGradeSalElementService();
				
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					PayGradeSalElementBean pgBean=new PayGradeSalElementBean();
					pgBean.setPayGradeSalElement_Id((Integer) obj[0]);
					PayGradeBean prBean=(PayGradeBean) obj[1];
				    pgBean.setPayGrade_Id(prBean.getPayGrade());
				    PayElementBean peBean =(PayElementBean) obj[2];
				    pgBean.setPayElement_Id(peBean.getPayelement());
				    pgBean.setAmount_Formulae((String) obj[3]);
				    pgBean.setInclude((Boolean) obj[4]);
					
					btBeans.add(pgBean);
				}

			} else {

				list = pgseService.basicSearchPayGradeSalElement(dbField, operation,basicSearchId);
				
				Iterator<Object[]> iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					PayGradeSalElementBean pgBean=new PayGradeSalElementBean();
					pgBean.setPayGradeSalElement_Id((Integer) obj[0]);
					PayGradeBean prBean=(PayGradeBean) obj[1];
				    pgBean.setPayGrade_Id(prBean.getPayGrade());
				    PayElementBean peBean =(PayElementBean) obj[2];
				    pgBean.setPayElement_Id(peBean.getPayelement());
				    pgBean.setAmount_Formulae((String) obj[3]);
				    pgBean.setInclude((Boolean) obj[4]);
					
					btBeans.add(pgBean);
				}
			}
			request.setAttribute("payGradeBeans", btBeans);
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "PayGradeSalElementHome";
	}
	
	@RequestMapping(value = "/PayGradeSalElementEdit", method = RequestMethod.GET)
	public String editPaygrade(@ModelAttribute("PayGradeSalElement") PayGradeSalElementBean brBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("payGradeEdit"));

		try {
			List<PayGradeSalElementBean> pgsBeans = new ArrayList<PayGradeSalElementBean>();
			list = pgseService.searchPayGradeSalElementServiceWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				brBean.setPayGradeSalElement_IdEdit((Integer) obj[0]);
				brBean.setPayGrade_IdEdit((String) obj[1]);
				brBean.setPayElement_IdEdit((String) obj[2]);
				brBean.setAmount_FormulaeEdit((String) obj[3]);
				brBean.setIncludeEdit((Boolean) obj[4]);
				
				pgsBeans.add(brBean);
			}
			request.setAttribute("editvalues", pgsBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "PayGradeSalElementHome";

	}
	@RequestMapping(value = "/PayGradeSalElementUpdate", method = RequestMethod.POST)
	public String updatePaygrade(@ModelAttribute("PayGradeSalElement") PayGradeSalElementBean brBean,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		String name = brBean.getAmount_Formulae();
		int pgsId = brBean.getPayGradeSalElement_Id();
		
		Long id = 0l;
		
		String payGradeUpdatedup=null;
		String msg=null;
		try {
			id = pgseService.getPayGradeSalElementcountedit(name, pgsId);
          
			if (id == 0) {
				
				brBean.setPayGradeSalElement_Id(brBean.getPayGradeSalElement_IdEdit());
				
				brBean.setPayGrade_Id(brBean.getPayGrade_IdEdit());
				brBean.setPayElement_Id(brBean.getPayElement_IdEdit());
				brBean.setAmount_Formulae(brBean.getAmount_FormulaeEdit());
				brBean.setInclude(brBean.getIncludeEdit());
				msg=pgseService.updatePayGradeSalElementService(brBean);
			}
			if(msg.equals("S"))
			{
			   request.setAttribute("payGradeUpdate", "PayGrade SalElement Updated Successfully");
					
					
				}
			
				
			 else {
				
				 payGradeUpdatedup = "payGrade already exists choose another one";
				 request.setAttribute("payGradeUpdate", payGradeUpdatedup);
					return "PayGradeSalElementHome";
			}
		} catch (Exception e) {
			e.printStackTrace();
			  request.setAttribute("payGradeUpdateErr", "payGrade Details Doesn't Updated");

		}
		 model.addAttribute("PayGradeSalElement", new PayGradeSalElementBean());
		return "PayGradeSalElementHome";
	}
	@RequestMapping(value = "/PayGradeSalElementDelete", method = RequestMethod.GET)
	@RequestScoped
	public String paygradeDelete(@ModelAttribute("PayGradeSalElement") PayGradeSalElementBean brBean,HttpServletRequest request,
			HttpServletResponse response,Model model) {
		
		response.setCharacterEncoding("UTF-8");
		int Id = 0;
		
		try {
			Id = Integer.parseInt(request.getParameter("paygradeDelete"));

			String msg = pgseService.deletePayGradeSalElementService(Id);
			if (msg.equals("S")){
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","PayGrade","ROW" ,String.valueOf(Id),"1",modifiedDate,session.getAttribute("userName").toString());
				
				request.setAttribute("payGradeDel", "PayGrade Details Deleted Successfully");
			}	else
				request.setAttribute("payGradeDelErr", "PayGrade Details Doesn't Deleted ");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("payGradeDelErr", "payGrade Details Doesn't Deleted ");
		}
		model.addAttribute("PayGradeSalElement", new PayGradeSalElementBean());
		return "PayGradeSalElementHome";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "amount";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
