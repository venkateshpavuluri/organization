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

import com.mnt.erp.bean.ProductionBatchBean;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.ProductionBatchService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
public class ProductionBatchController {
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;

	@Autowired
	ProductionBatchService pbservice;

	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;

	@Autowired
	AuditLogService auditLogService;
	
	@Autowired
	DateConversionService dateService;

	@RequestMapping(value = "/ProductionBatchHome", method = RequestMethod.GET)
	public String getProductionBatch(
			@ModelAttribute ProductionBatchBean pbbean, SessionStatus status,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("ProductionBatchHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);

		model.addAttribute("productionBatch", new ProductionBatchBean());

		return "ProductionBatchHome";
	}

	@RequestMapping(value = "/saveProBatch", method = RequestMethod.POST)
	@RequestScoped
	public String saveProductionBatch(
	@ModelAttribute("productionBatch") ProductionBatchBean pbbean,
			DefaultSessionAttributeStore attributeStore,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus sessionStatus, ModelMap map, Model model) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = null;
		String mess = null;
		String res = null;
		try {
			pbbean.setBatchdate(dateService.dateFormat(dateService.dateParse(pbbean.getBatchdate(),"au"),"au"));
			pbbean.setBatchastdt(dateService.dateFormat(dateService.dateParse(pbbean.getBatchastdt(),"au"),"au"));
			pbbean.setBatchedt(dateService.dateFormat(dateService.dateParse(pbbean.getBatchaedt(),"au"),"au"));
			pbbean.setBatchastdt(dateService.dateFormat(dateService.dateParse(pbbean.getBatchastdt(),"au"),"au"));
			pbbean.setBatchaedt(dateService.dateFormat(dateService.dateParse(pbbean.getBatchaedt(),"au"),"au"));
			pbbean.setDeliverydt(dateService.dateFormat(dateService.dateParse(pbbean.getDeliverydt(),"au"),"au"));
			session = request.getSession(false);
			mess = pbservice.saveProductionBatchservice(pbbean, session.getAttribute("userId").toString(),
					session.getAttribute("userName").toString());
			if (mess.equals("S")) {

				res = "redirect:ProductionBatchHome.mnt?list=" + "success" + "";
			} else {

				res = "redirect:ProductionBatchHome.mnt?listwar=" + "fail" + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;

	}

	@ModelAttribute("productionorder")
	public Map<Integer, String> populatePO() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = pbservice.selectProductionOrderIds();
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

	@ModelAttribute("Status")
	public Map<Integer, String> populateStatusIds() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = pbservice.selectStatusIds();
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
	@RequestMapping(value = "/searchProductionBatch", method = RequestMethod.GET)
	public String searchProductionBatch(
			@ModelAttribute("productionBatch") ProductionBatchBean pbBean,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			List<ProductionBatchBean> pblist = new ArrayList<ProductionBatchBean>();
			String dbField = pbBean.getXmlLabel();
			String operation = pbBean.getOperations();
			String basicSearchId = pbBean.getBasicSearchId();

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

				list = pbservice.searchProductionBatch();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					ProductionBatchBean pbBeans = new ProductionBatchBean();
					pbBeans.setProbatchId((Integer) obj[0]);
					ProductionOrderBean pobean=(ProductionOrderBean)obj[1];
					pbBeans.setProId(pobean.getProdOrderNo());
					pbBeans.setBatchtype((String)obj[2]);
					pbBeans.setBatchdate(dateService.dateFormat(dateService.dateParse((String) obj[3], "se"), "se"));
					pbBeans.setBatchqty((String)obj[4]);
					pbBeans.setBatchstdt(dateService.dateFormat(dateService.dateParse((String) obj[5], "se"), "se"));
					pbBeans.setDeliverydt(dateService.dateFormat(dateService.dateParse((String) obj[6], "se"), "se"));
					pbBeans.setBatchedt(dateService.dateFormat(dateService.dateParse((String) obj[7], "se"), "se"));
					pbBeans.setBatchastdt(dateService.dateFormat(dateService.dateParse((String) obj[8], "se"), "se"));
					pbBeans.setBatchaedt(dateService.dateFormat(dateService.dateParse((String) obj[9], "se"), "se"));
					Status st=(Status)obj[10];
					pbBeans.setStatusId(st.getStatus());
					pblist.add(pbBeans);
				}

			} else {

				// list = accountgroupservice.searchAccountGroupsWithId(iid);
				list = pbservice.basicSearchProductionBatch(dbField, operation, basicSearchId);
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					ProductionBatchBean pbBeans = new ProductionBatchBean();
					pbBeans.setProbatchId((Integer) obj[0]);
					ProductionOrderBean pobean=(ProductionOrderBean)obj[1];
					pbBeans.setProId(pobean.getProdOrderNo());
					pbBeans.setBatchtype((String)obj[2]);
					pbBeans.setBatchdate(dateService.dateFormat(dateService.dateParse((String) obj[3], "se"), "se"));
					pbBeans.setBatchqty((String)obj[4]);
					pbBeans.setBatchstdt(dateService.dateFormat(dateService.dateParse((String) obj[5], "se"), "se"));
					pbBeans.setDeliverydt(dateService.dateFormat(dateService.dateParse((String) obj[6], "se"), "se"));
					pbBeans.setBatchedt(dateService.dateFormat(dateService.dateParse((String) obj[7], "se"), "se"));
					pbBeans.setBatchastdt(dateService.dateFormat(dateService.dateParse((String) obj[8], "se"), "se"));
					pbBeans.setBatchaedt(dateService.dateFormat(dateService.dateParse((String) obj[9], "se"), "se"));
					Status st=(Status)obj[10];
					pbBeans.setStatusId(st.getStatus());
					pblist.add(pbBeans);
				}

			}
			request.setAttribute("pbBeans", pblist);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return "ProductionBatchHome";
	}
	@RequestMapping(value = "/ProBatchEdit", method = RequestMethod.GET)
	public String editproductionBatch(
			@ModelAttribute("productionBatch") ProductionBatchBean pbbean,
			HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("pbedit"));

		try {
			List<ProductionBatchBean> poBeans = new ArrayList<ProductionBatchBean>();
			list = pbservice.searchProductionBatchWithId(id);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] obj = (Object[]) iterator.next();
				pbbean.setProbatchIdedit((Integer) obj[0]);
				pbbean.setProIdedit((String) obj[1]);
				pbbean.setBatchtypeedit((String) obj[2]);
				pbbean.setBatchdateedit(dateService.dateFormat(dateService.dateParse((String) obj[3], "se"), "se"));
				pbbean.setBatchqtyedit((String)obj[4]);
				pbbean.setBatchstdtedit(dateService.dateFormat(dateService.dateParse((String) obj[5], "se"), "se"));
				pbbean.setDeliverydtedit(dateService.dateFormat(dateService.dateParse((String) obj[6], "se"), "se"));
				pbbean.setBatchedtedit(dateService.dateFormat(dateService.dateParse((String) obj[7], "se"), "se"));
				pbbean.setBatchastdtedit(dateService.dateFormat(dateService.dateParse((String) obj[8], "se"), "se"));
				pbbean.setBatchaedtedit(dateService.dateFormat(dateService.dateParse((String) obj[9], "se"), "se"));
				pbbean.setStatusIdedit((String)obj[10]);
				poBeans.add(pbbean);
			}
			request.setAttribute("editvalues", poBeans);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ProductionBatchHome";

	}
	@RequestMapping(value = "/productionBatchUpdate", method = RequestMethod.POST)
	public String updateaccountGroups(
			@ModelAttribute("productionBatch") ProductionBatchBean pbean,
			HttpServletRequest request,HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		String AGSuccessdupedit = null;
		try {

			
			pbean.setProbatchId(pbean.getProbatchIdedit());
             pbean.setProId(pbean.getProIdedit());
             pbean.setBatchtype(pbean.getBatchtypeedit());
             pbean.setBatchdate(dateService.dateFormat(dateService.dateParse(pbean.getBatchdateedit(),"au"),"au"));
             pbean.setBatchqty(pbean.getBatchqtyedit());
             pbean.setBatchstdt(dateService.dateFormat(dateService.dateParse(pbean.getBatchstdtedit(),"au"),"au"));
             pbean.setDeliverydt(dateService.dateFormat(dateService.dateParse(pbean.getDeliverydtedit(),"au"),"au"));
             pbean.setBatchedt(dateService.dateFormat(dateService.dateParse(pbean.getBatchedtedit(),"au"),"au"));
             pbean.setBatchastdt(dateService.dateFormat(dateService.dateParse(pbean.getBatchastdtedit(),"au"),"au"));
             pbean.setBatchaedt(dateService.dateFormat(dateService.dateParse(pbean.getBatchaedtedit(),"au"),"au"));
             pbean.setStatusId(pbean.getStatusIdedit());
			
				String message = pbservice.updateProductionBatch(pbean);

				if (message.equals("S")) {
					
					request.setAttribute("pbatchUpdate","Production Batch has been updated");
					
				}
				else{
					
					request.setAttribute("pbatchUpdateError","Production Batch has not been updated");
					
				}
			
				return "ProductionBatchHome";
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "ProductionBatchHome";
	}
	
	@RequestMapping(value = "/ProBatchDelete", method = RequestMethod.GET)
	public ModelAndView productionbatchDelete(HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		HttpSession session=null;
		try {
			id = Integer.parseInt(request.getParameter("pbdelete"));

			String msg = pbservice.deleteProductionBatch(id);
			if (msg.equals("S")){
				request.setAttribute("probDelete","Production Batch has been deleted");
				session=request.getSession(false);
				Date date = new Date();
				String modifiedDate= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId").toString(),"D","Production Batch","ROW" ,String.valueOf(id),"1",modifiedDate,session.getAttribute("userName").toString());
			}
			else{
				request.setAttribute("probDeleteError","Production Batch has not been deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("ProductionBatchHome", "productionBatch",
				new ProductionBatchBean());
	}
	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "probatchId";

		Map<String, String> map =null;

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
