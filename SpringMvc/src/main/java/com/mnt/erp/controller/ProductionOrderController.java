/**
 * @Copyright MNTSOFT 
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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.Plant;
import com.mnt.erp.bean.ProductionOrderBean;
import com.mnt.erp.bean.ProductionOrderType;
import com.mnt.erp.bean.SalesOrderBean;
import com.mnt.erp.bean.Status;
import com.mnt.erp.bean.Uom;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.ProductionOrderService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author Naresh
 * @version 1.0 24-01-2014
 */
@Controller
public class ProductionOrderController {
	private static final Logger log = Logger
			.getLogger(ProductionOrderController.class);
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	ProductionOrderService prodOrderService;
	@Autowired
	PopulateService populateService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	DateConversionService dateService;

	List<Object[]> list = null;
	Iterator<Object[]> itr = null;
	Object[] objects = null;
	List<Object> obj = null;
	HttpSession session = null;
	String message = null;
	boolean flag = true;

	@RequestMapping(value = "/prodOrderHome", method = RequestMethod.GET)
	public ModelAndView prodOrderHome(
			@ModelAttribute("prodOrderCmd") ProductionOrderBean prodOrderBean,
			SessionStatus status, HttpServletResponse response,
			HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		List<String> list = menuService.getPrivilige("prodOrderHome.mnt",
				session.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("prodOrderHome", "prodOrderCmd", prodOrderBean);
	}

	@ModelAttribute("materialSelect")
	public Map<Integer, String> populatMaterialIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.material_Id,m.materialName from Material m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("uomSelect")
	public Map<Integer, String> populatUomIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select m.uom_Id,m.uom from Uom m");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("plantSelect")
	public Map<Integer, String> populatePlantIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.plantId,p.plantName from Plant p");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("salesOrderSelect")
	public Map<Integer, String> populateSOIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select p.salesOrderId,p.salesOrderNo from SalesOrderBean p");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("statusSelect")
	public Map<Integer, String> populatStatusIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.statusId,s.status from Status s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("POTypeSelect")
	public Map<Integer, String> populatPOTypeIds() {

		Map<Integer, String> map = null;
		try {
			map = populateService
					.populateSelectBox("select s.prodOrderTypeId,s.prodOrderType from ProductionOrderType s");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/checkProdOrderAddDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkRecAddDuplicate(HttpServletRequest request,
			HttpServletResponse response, ProductionOrderBean sqdupBean) {
		response.setCharacterEncoding("UTF-8");
		String poNo = request.getParameter("prodOrderNo");
		Long checkCustName = prodOrderService.checkProdOrderCout(poNo);
		if (checkCustName != 0) {

			message = "Warning ! Production Order No is Already exists. Please try some other name";
		} else {
			message = "";
		}
		return message;
	}

	@RequestMapping(value = "/checkProdOrderUpdateDuplicate", method = RequestMethod.POST)
	public @ResponseBody
	String checkRecUpdateDuplicate(HttpServletRequest request,
			HttpServletResponse response, ProductionOrderBean dupBean) {
		response.setCharacterEncoding("UTF-8");
		String message = null;
		String poNo = request.getParameter("prodOrderNo");
		int poId = Integer.parseInt(request.getParameter("prodOrderId"));
		long checkCustName = prodOrderService.updateCheckProdOrder(poNo, poId);

		if (checkCustName != 0) {

			message = "Warning ! Production Order No is Already exists. Please try some other name";
		} else {
			message = "";
		}

		return message;
	}

	@RequestMapping(value = "/prodOrderAdd", method = RequestMethod.POST)
	public String saveproductionOrder(
			@ModelAttribute("prodOrderCmd") ProductionOrderBean poBean,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String poSave = null;
		try {
			ProductionOrderBean addBean = (ProductionOrderBean) poBean;
			addBean.setProdOrderDate(dateService.dateFormat(
					dateService.dateParse(addBean.getProdOrderDate(), "au"),
					"au"));

			addBean.setActEndDate(dateService.dateFormat(
					dateService.dateParse(addBean.getActEndDate(), "au"), "au"));
			addBean.setActStartDate(dateService.dateFormat(
					dateService.dateParse(addBean.getActStartDate(), "au"),
					"au"));
			addBean.setEstStartDate(dateService.dateFormat(
					dateService.dateParse(addBean.getEstStartDate(), "au"),
					"au"));
			addBean.setEstEndDate(dateService.dateFormat(
					dateService.dateParse(addBean.getEstEndDate(), "au"), "au"));
			flag = prodOrderService.saveProdOrderDetails(addBean);

			if (flag == true) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "A", "Production Order", "ROW", String
						.valueOf(addBean.getProdOrderId()), "1", modifiedDate,
						session.getAttribute("userName").toString());
				poSave = "Production Order Data Saved Successfully";

			} else {
				poSave = "Production Order Data Insertion Failures";
				return "redirect:prodOrderHome.mnt?addPOFail=" + poSave + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:prodOrderHome.mnt?addPOsus=" + poSave + "";

	}

	@RequestMapping(value = "/prodOrderSearch", method = RequestMethod.GET)
	public String searchProdOrder(
			@ModelAttribute("prodOrderCmd") ProductionOrderBean prodOrderBeanSearch,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		List<ProductionOrderBean> prodOrderList = new ArrayList<ProductionOrderBean>();
		try {

			String dbField = prodOrderBeanSearch.getXmlLabel();
			String operation = prodOrderBeanSearch.getOperations();
			String basicSearchId = prodOrderBeanSearch.getBasicSearchId();

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
				list = prodOrderService.searchProdOrder();

			} else {

				list = prodOrderService.basicSearchProdOrder(dbField,
						operation, basicSearchId);
			}
			itr = list.iterator();
			while (itr.hasNext()) {
				objects = (Object[]) itr.next();
				ProductionOrderBean pob = new ProductionOrderBean();
				pob.setProdOrderId((Integer) objects[0]);
				pob.setProdOrderNo((String) objects[1]);
				pob.setProdOrderDate(dateService.dateFormat(
						dateService.dateParse((String) objects[2], "se"), "se"));
				pob.setTotQty((String) objects[3]);
				pob.setEstStartDate(dateService.dateFormat(
						dateService.dateParse((String) objects[4], "se"), "se"));
				pob.setEstEndDate(dateService.dateFormat(
						dateService.dateParse((String) objects[5], "se"), "se"));
				pob.setActStartDate(dateService.dateFormat(
						dateService.dateParse((String) objects[6], "se"), "se"));
				pob.setActEndDate(dateService.dateFormat(
						dateService.dateParse((String) objects[7], "se"), "se"));
				pob.setPriority((String) objects[8]);
				pob.setDesc((String) objects[9]);

				ProductionOrderType pot = ((ProductionOrderType) objects[10]);
				pob.setProdOrderTypeId(pot.getProdOrderType());
				SalesOrderBean sob = ((SalesOrderBean) objects[11]);
				pob.setSalesOrderId(sob.getSalesOrderNo());
				Material mt = ((Material) objects[12]);
				pob.setMaterialId(mt.getMaterialName());
				Uom uom = ((Uom) objects[14]);
				pob.setUomId(uom.getUom());
				Plant p = ((Plant) objects[13]);
				pob.setPlantId(p.getPlantName());
				Status st = ((Status) objects[15]);
				pob.setStatusId(st.getStatus());
				prodOrderList.add(pob);
			}
			request.setAttribute("prodOrderList", prodOrderList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "prodOrderHome";

	}

	@RequestMapping(value = "/prodOrderDelete", method = RequestMethod.GET)
	public String prodOrderDelete(
			@ModelAttribute("prodOrderCmd") ProductionOrderBean prodOrderBeanDelete,
			Model model, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String prodOrderDelete = null;
		int poId = Integer.parseInt(request.getParameter("prodOrderId"));
		try {
			flag = prodOrderService.deleteProdOrder(poId);
			if (flag == true) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Production Order", "ROW", String
						.valueOf(poId), "1", modifiedDate, session
						.getAttribute("userName").toString());
				prodOrderDelete = "Production Order Deleted Successfully";

			} else {
				prodOrderDelete = "Production Order Deletion Failed due to Conatraint Violation";
				return "redirect:prodOrderHome.mnt?DeletePOFail="
						+ prodOrderDelete + "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:prodOrderHome.mnt?DeletePOsus=" + prodOrderDelete + "";

	}

	@RequestMapping(value = "/prodOrderEdit", method = RequestMethod.GET)
	public String prodOrderEdit(
			@ModelAttribute("prodOrderCmd") ProductionOrderBean salesEdit,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("prodOrderId"));
		List<ProductionOrderBean> prodOrderBean = new ArrayList<ProductionOrderBean>();
		ProductionOrderBean po = null;
		try {
			obj = prodOrderService.searchProdOrderWithId(id);
			Iterator<Object> iterator = obj.iterator();
			while (iterator.hasNext()) {
				Object obj = iterator.next();
				po = (ProductionOrderBean) obj;
				po.setProdOrderDate(dateService.dateFormat(
						dateService.dateParse(po.getProdOrderDate(), "se"),
						"se"));

				po.setActEndDate(dateService.dateFormat(
						dateService.dateParse(po.getActEndDate(), "se"), "se"));
				po.setActStartDate(dateService.dateFormat(
						dateService.dateParse(po.getActStartDate(), "se"), "se"));
				po.setEstStartDate(dateService.dateFormat(
						dateService.dateParse(po.getEstStartDate(), "se"), "se"));
				po.setEstEndDate(dateService.dateFormat(
						dateService.dateParse(po.getEstEndDate(), "se"), "se"));
				prodOrderBean.add(po);
			}
			model.addAttribute("prodOrderCmd", po);
			request.setAttribute("prodOrderEdit", prodOrderBean);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			obj = null;
		}
		return "prodOrderHome";

	}

	@RequestMapping(value = "/prodOrderUpdate", method = RequestMethod.POST)
	public String prodOrderUpdate(
			@ModelAttribute("prodOrderCmd") ProductionOrderBean recUpdate,
			HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String poUpadted = null;
		try {
			ProductionOrderBean upBean = (ProductionOrderBean) recUpdate;
			upBean.setProdOrderDate(dateService.dateFormat(
					dateService.dateParse(upBean.getProdOrderDate(), "au"),
					"au"));
			upBean.setActEndDate(dateService.dateFormat(
					dateService.dateParse(upBean.getActEndDate(), "au"), "au"));
			upBean.setActStartDate(dateService.dateFormat(
					dateService.dateParse(upBean.getActStartDate(), "au"), "au"));
			upBean.setEstStartDate(dateService.dateFormat(
					dateService.dateParse(upBean.getEstStartDate(), "au"), "au"));
			upBean.setEstEndDate(dateService.dateFormat(
					dateService.dateParse(upBean.getEstEndDate(), "au"), "au"));
			flag = prodOrderService.updateProdOrder(upBean);

			if (flag == true) {
				poUpadted = "Production Order Data Updated Successfully";

			} else {
				poUpadted = "Production Order Data Updation Failed";
				return "redirect:prodOrderHome.mnt?updatePOFail=" + poUpadted
						+ "";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:prodOrderHome.mnt?updatePOsus=" + poUpadted + "";
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "ProductionOrder";
		Map<String, String> map = null;
		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
