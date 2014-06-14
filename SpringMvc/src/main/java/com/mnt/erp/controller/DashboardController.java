/**
 * 
 */
package com.mnt.erp.controller;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mnt.erp.bean.DashBoard;
import com.mnt.erp.bean.GetPendingLeaveRequestBean;
import com.mnt.erp.bean.GetSalesOrderByYear;
import com.mnt.erp.bean.GetScheduleInterviewsBean;
import com.mnt.erp.bean.GoodsDeliveryInTheYear;
import com.mnt.erp.bean.InvoiceToCollect;
import com.mnt.erp.bean.InvoiceToPay;
import com.mnt.erp.bean.MatStockBean;
import com.mnt.erp.bean.Material;
import com.mnt.erp.bean.PendingPo;
import com.mnt.erp.bean.StorageLocation;
import com.mnt.erp.bean.ToBeReoredeMaterial;
import com.mnt.erp.bean.Top5OrderItems;
import com.mnt.erp.service.DashBoardService;
import com.mnt.erp.service.PopulateService;

/**
 * @author kirangangone
 * @version 1.0 06-01-2014
 * @build 0.0
 * 
 */

@Controller
@Scope("request")
public class DashboardController {
    private static Logger logger = Logger.getLogger(DashboardController.class);
    @Autowired
    PopulateService populateService;
    @Autowired
    DashBoardService dashBoardService;
    @RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
    public String getPurchaseOrder(
	    @ModelAttribute("dashboardCommand") DashBoard dashBoard,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	List<PendingPo> listOfPendings = null;
	List<GoodsDeliveryInTheYear> deliveryInTheYears = null;
	List<ToBeReoredeMaterial> reorederLevels = null;
	List<InvoiceToCollect> invoiceToCollects = null;
	List<InvoiceToPay> invoiceToPays = null;
	List<MatStockBean> matStockBeans = null;
	List<GetPendingLeaveRequestBean> getPendingLeaveRequest= null;
	List<GetScheduleInterviewsBean> scheduleInterviewsBeans= null;
	try {
	    matStockBeans = dashBoardService.getMatStockDetails();
	    listOfPendings = dashBoardService.getPendingPoDetails("top5");
	    deliveryInTheYears = dashBoardService.getGoodsinyear("top5");
	    reorederLevels = dashBoardService.getTobeReorederLevels("top5");
	    invoiceToCollects = dashBoardService.invoiceToCollect("top5");
	    invoiceToPays = dashBoardService.getInvoiceToPays("top5");
	    getPendingLeaveRequest= dashBoardService.getPendingLeaveRequest();
	    scheduleInterviewsBeans= dashBoardService.getScheduleInterviews();
	    request.setAttribute("pendingPo", listOfPendings);
	    request.setAttribute("deliveryInTheYears", deliveryInTheYears);
	    request.setAttribute("reorederMaterial", reorederLevels);
	    request.setAttribute("invoiceToCollects", invoiceToCollects);
	    request.setAttribute("invoiceToPays", invoiceToPays);
	    request.setAttribute("matStockBeans", matStockBeans);
	    request.setAttribute("getPendingLeaveRequest", getPendingLeaveRequest);
	    request.setAttribute("scheduleInterviewsBeans", scheduleInterviewsBeans);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return "dashboardHome";
    }
    @RequestMapping(value = "/getStockDetails", method = RequestMethod.POST)
    public @ResponseBody
    String getTotalStockDetails(
	    @ModelAttribute("dashboardCommand") DashBoard dashBoard,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	StringWriter out = new StringWriter();
	// JSONObject responseDetailsJson = new JSONObject();
	JSONArray jsonArray = new JSONArray();
	try {

	    String id = request.getParameter("storageId");
	    if (id != null) {
		int storageId = Integer.parseInt(id);
		// List<Object[]>
		// list=erpDao.searchDetails("select m.matStockId,m.batchNo,m.qtyAval,m.storageLocDetails,m.materialsDetails from com.mnt.erp.bean.MatStockBean m where m.storLocId="+storageId);
		List<Object[]> list = dashBoardService
			.getTotalStocks(storageId);
		logger.info("list size iss==" + list.size());
		Iterator<Object[]> iterator = list.iterator();
		while (iterator.hasNext()) {
		    Object[] objects = (Object[]) iterator.next();
		    MatStockBean stockBean = new MatStockBean();
		    stockBean.setMatStockId((Integer) objects[0]);
		    stockBean.setBatchNo((String) objects[1]);
		    stockBean.setQtyAval((Float) objects[2]);
		    StorageLocation location = (StorageLocation) objects[3];
		    Material material = (Material) objects[4];
		    stockBean.setMaterialName(material.getMaterialName());
		    stockBean.setStorageLocName(location.getStorageLocation());
		    jsonArray.add(stockBean);
		}
		jsonArray.writeJSONString(out);

	    }

	} catch (Exception e) {
	    logger.error(e.getMessage());
	}

	return out.toString();

    }

    @ModelAttribute("storageDetails")
    public Map<Integer, String> populateStorages() {
	Map<Integer, String> map = null;
	try {
	    map = populateService
		    .populateSelectBox("select s.storageLocationId,s.storageLocation from com.mnt.erp.bean.StorageLocation s");

	} catch (Exception e) {
	    logger.error(e.getMessage());
	}
	return map;
    }

    @RequestMapping(value = "/getStockDetailsHome", method = RequestMethod.POST)
    public @ResponseBody
    String getTotalStockDetailsHome(
	    @ModelAttribute("dashboardCommand") DashBoard dashBoard,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	StringWriter out = new StringWriter();
	// JSONObject responseDetailsJson = new JSONObject();
	JSONArray jsonArray = new JSONArray();
	try {

	    // List<Object[]>
	    // list=erpDao.searchDetails("select m.matStockId,m.batchNo,m.qtyAval,m.storageLocDetails,m.materialsDetails from com.mnt.erp.bean.MatStockBean m where m.storLocId="+storageId);
	    List<MatStockBean> list = dashBoardService.getMatStockDetails();
	    logger.info("list size iss==" + list.size());
	    Iterator<MatStockBean> iterator = list.iterator();
	    while (iterator.hasNext()) {
		MatStockBean stockBean = (MatStockBean) iterator.next();

		jsonArray.add(stockBean);
	    }
	    jsonArray.writeJSONString(out);

	} catch (Exception e) {
	    logger.error(e.getMessage());
	}

	return out.toString();

    }

    @RequestMapping(value = "/getTop5OrderItems", method = RequestMethod.POST)
    public @ResponseBody
    String getTop5OrderItems(
	    @ModelAttribute("dashboardCommand") DashBoard dashBoard,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	StringWriter out = new StringWriter();
	// JSONObject responseDetailsJson = new JSONObject();
	JSONArray jsonArray = new JSONArray();
	try {
	    // List<Object[]>
	    // list=erpDao.searchDetails("select m.matStockId,m.batchNo,m.qtyAval,m.storageLocDetails,m.materialsDetails from com.mnt.erp.bean.MatStockBean m where m.storLocId="+storageId);
	    List<Top5OrderItems> list = dashBoardService.getTop5orderItems();
	    logger.info("list size iss==" + list.size());
	    Iterator<Top5OrderItems> iterator = list.iterator();
	    while (iterator.hasNext()) {
		Top5OrderItems stockBean = (Top5OrderItems) iterator.next();
		jsonArray.add(stockBean);
	    }
	    jsonArray.writeJSONString(out);
	} catch (Exception e) {
	    logger.error(e.getMessage());
	}
	return out.toString();

    }

    @RequestMapping(value = "/getsalesOrderByYear", method = RequestMethod.POST)
    public @ResponseBody
    String getSalesOrderItemsByYear(
	    @ModelAttribute("dashboardCommand") DashBoard dashBoard,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	StringWriter out = new StringWriter();
	// JSONObject responseDetailsJson = new JSONObject();
	JSONArray jsonArray = new JSONArray();
	try {
	    int year = Integer.parseInt(request.getParameter("years"));
	    logger.debug("year iss==" + year);
	    // List<Object[]>
	    // list=erpDao.searchDetails("select m.matStockId,m.batchNo,m.qtyAval,m.storageLocDetails,m.materialsDetails from com.mnt.erp.bean.MatStockBean m where m.storLocId="+storageId);
	    List<GetSalesOrderByYear> list = dashBoardService
		    .getSalesOrdersByYear(year);
	    logger.debug("years list size iss==" + list.size());
	    Iterator<GetSalesOrderByYear> iterator = list.iterator();
	    while (iterator.hasNext()) {
		GetSalesOrderByYear stockBean = (GetSalesOrderByYear) iterator
			.next();
		jsonArray.add(stockBean);
	    }
	    jsonArray.writeJSONString(out);
	} catch (Exception e) {
	    logger.error(e.getMessage());
	}

	return out.toString();

    }

    @ModelAttribute("allYears")
    public Map<Integer, String> populateYears() {
	Map<Integer, String> map = null;
	try {
	    map = new LinkedHashMap<Integer, String>();
	    Date hj = new Date();
	    String modifiedDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
		    .format(hj);
	    int year = Calendar.getInstance().get(Calendar.YEAR);
	    for (int i = 1970; i <= year; i++) {
		map.put(i, String.valueOf(i));
	    }

	} catch (Exception e) {
	    logger.error(e.getMessage());
	}
	return map;
    }

    @RequestMapping(value = "/allmaterialsDisplayHome", method = RequestMethod.GET)
    public String getAllMaterialsDisplay(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	try {

	    List<Top5OrderItems> list = dashBoardService.allorderItems();
	    request.setAttribute("allMaterials", list);
	} catch (Exception e) {
	    e.printStackTrace();
	}

	return "allMaterials";

    }

    @RequestMapping(value = "/allOrderItems", method = RequestMethod.POST)
    public @ResponseBody
    String allOrderItems(
	    @ModelAttribute("dashboardCommand") DashBoard dashBoard,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	StringWriter out = new StringWriter();
	// JSONObject responseDetailsJson = new JSONObject();
	JSONArray jsonArray = new JSONArray();
	try {
	    List<Top5OrderItems> list = dashBoardService.allorderItems();
	    logger.info("list size iss==" + list.size());
	    Iterator<Top5OrderItems> iterator = list.iterator();
	    while (iterator.hasNext()) {
		Top5OrderItems stockBean = (Top5OrderItems) iterator.next();
		jsonArray.add(stockBean);
	    }
	    jsonArray.writeJSONString(out);
	} catch (Exception e) {
	    logger.error(e.getMessage());
	}

	return out.toString();

    }

    @RequestMapping(value = "/allinvoiceToCollects", method = RequestMethod.GET)
    public String getAllInvoices(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	try {

	    List<InvoiceToCollect> list = dashBoardService
		    .invoiceToCollect("all");
	    request.setAttribute("allInvoices", list);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	// it returns WEB-INF/Login/allInvoiceToCollect.jsp page
	return "allInvoiceToCollect";

    }

    /* Here display all InvoiceToPay Details */

    @RequestMapping(value = "/allinvoiceToPay", method = RequestMethod.GET)
    public String getAllinvoiceToPay(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	try {

	    List<InvoiceToPay> list = dashBoardService.getInvoiceToPays("all");
	    request.setAttribute("allInvoicesToPay", list);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	// it returns WEB-INF/Login/allInvoiceToPay.jsp page
	return "allInvoiceToPay";
    }

    @RequestMapping(value = "/allPendingPoOrder", method = RequestMethod.GET)
    public String getAllPendingPuOrder(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	try {
	    List<PendingPo> list = dashBoardService.getPendingPoDetails("all");
	    request.setAttribute("allPendingPo", list);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	// it returns WEB-INF/Login/pendingPoOrder.jsp page
	return "pendingPoOrder";
    }

    @RequestMapping(value = "/allGoodsDelivery", method = RequestMethod.GET)
    public String getAllGoodsDelivery(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	try {
	    List<GoodsDeliveryInTheYear> list = dashBoardService
		    .getGoodsinyear("all");
	    request.setAttribute("allGoodsDelivery", list);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	// it returns WEB-INF/Login/allGoodsDelInYear.jsp page
	return "allGoodsDelInYear";
    }
   /* @RequestMapping(value = "/getPendingLeave", method = RequestMethod.GET)
    public String getPendingLeave(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	try {
	    List<GetPendingLeaveRequestBean> list = dashBoardService.getPendingLeaveRequest();
	    request.setAttribute("getPendingLeave", list);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	// it returns WEB-INF/Login/allGoodsDelInYear.jsp page
	return "allGoodsDelInYear";
    }*/
    @RequestMapping(value = "/allSalesOrderItemsHome", method = RequestMethod.GET)
    public String getAllSalesOrderItemsHome(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");

	// it returns WEB-INF/Login/allGoodsDelInYear.jsp page
	return "allSalesOrderItems";
    }

    @RequestMapping(value = "/getAllSalesOrderByYear", method = RequestMethod.POST)
    public @ResponseBody
    String getAllSalesOrderItemsByYear(
	    @ModelAttribute("dashboardCommand") DashBoard dashBoard,
	    HttpServletRequest request, HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");
	StringWriter out = new StringWriter();
	// JSONObject responseDetailsJson = new JSONObject();
	JSONArray jsonArray = new JSONArray();
	try {
	    System.out.println("piechart iss");
	    // List<Object[]>
	    // list=erpDao.searchDetails("select m.matStockId,m.batchNo,m.qtyAval,m.storageLocDetails,m.materialsDetails from com.mnt.erp.bean.MatStockBean m where m.storLocId="+storageId);
	    List<GetSalesOrderByYear> list = dashBoardService
		    .getSalesOrdersByYear(0);
	    logger.debug("years list size iss==" + list.size());
	    System.out.println("piechart iss" + list.size());
	    Iterator<GetSalesOrderByYear> iterator = list.iterator();
	    while (iterator.hasNext()) {
		GetSalesOrderByYear stockBean = (GetSalesOrderByYear) iterator
			.next();
		jsonArray.add(stockBean);
	    }
	    jsonArray.writeJSONString(out);
	} catch (Exception e) {
	    logger.error(e.getMessage());
	}

	return out.toString();

    }

    @RequestMapping(value = "/allToBeReorderMatHome", method = RequestMethod.GET)
    public String getAllToBeReorderMatHome(HttpServletRequest request,
	    HttpServletResponse response) {
	response.setCharacterEncoding("UTF-8");

	// it returns WEB-INF/Login/allGoodsDelInYear.jsp page
	try {
	    List<ToBeReoredeMaterial> reoredeMaterials = dashBoardService
		    .getTobeReorederLevels("all");
	    System.out.println("size iss==" + reoredeMaterials.size());
	    request.setAttribute("allReoredeMaterials", reoredeMaterials);

	} catch (Exception e) {
	    logger.error(e.getMessage());
	    e.printStackTrace();
	}
	return "allToBeReorderedMat";
    }

}
