/**
 * 
 */
package com.mnt.erp.controller;


import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.GoodsReceipt;
import com.mnt.erp.bean.ReportBean;
import com.mnt.erp.service.DateConversionService;
import com.mnt.erp.service.GoodsReceiptTypeService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.PurchaseOrderService;
import com.mnt.erp.service.VendorService;

/**
 * @author madhav
 *
 */
@Controller
@Scope("request")
public class ReportController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	VendorService categoryService;
	
	@Autowired
	GoodsReceiptTypeService grtservice;
	
	@Autowired
	PurchaseOrderService poservice;
	
	@Autowired
	MaterialService materialService;
	@Autowired
	PopulateService populateService;
	@Autowired
	DateConversionService dateService;
	

	
	
	//.....
	String reportId=null;
	String reportDate=null;
	
	//Global variables
	String filePath=null;
	File jrFile=null;
	JasperDesign jd=null;
	JasperReport jr=null;
	Connection connection=null;
	JasperPrint jp=null;
	String rootPath=null;
	String printPath=null;
	String destFile=null;
	String jrprintPath=null;
	HttpSession session=null;
	String userId=null;
	long time;
	String datePattern = null;
	
	static Logger log = Logger.getLogger(ReportController.class);
	
	/* **************************Common method for Generating Reports ************* */
	
	public void generateReport(HttpServletRequest request,
			HashMap<String, Object> parametrs)
			throws JRException, SQLException {
		
		
		time=System.currentTimeMillis();
		 jrFile=new File(filePath);

		// 3. Convert template to JasperDesign
		 jd = JRXmlLoader.load(jrFile);

		// 4. Compile design to JasperReport
		 jr = JasperCompileManager.compileReport(jd);
		 String destFile = printPath+"\\"+jr.getName()+time+".jrprint";
		
				// 5. Create the JasperPrint object
				// Make sure to pass the JasperReport, report parameters, and data source
				 connection=dataSource.getConnection();
				 System.out.println(connection);
				 JasperFillManager.fillReportToFile(jr, destFile, parametrs, connection);
				//JasperPrint jp = JasperFillManager.fillReport(jr, parametrs);
				
				 String jrprintPath="jrprint/"+jr.getName()+time+".jrprint";
				 request.setAttribute("jrPrintPath", jrprintPath);
	}
	
	

	/* ********************************** RFQ Report ******************************** */
	
		@RequestMapping(value = "/rfqListReport", method = RequestMethod.GET)
		public ModelAndView reportHome(@ModelAttribute("reportCmd") ReportBean rBean,HttpServletResponse response,HttpServletRequest request) {
			response.setCharacterEncoding("UTF-8");
			 // Setting response's headers
	       return new ModelAndView("reportHome","reportCmd",rBean);

		}
		
		
		
		
		//Method for Generating the Report
	@RequestMapping(value ="/generateRfqReport", method = RequestMethod.GET)
	public  ModelAndView generaterRfqReport(@ModelAttribute("reportCmd") ReportBean rBean, HttpServletRequest request,HttpServletResponse response) {
			
		String rfqno=null;
		
		 rfqno=rBean.getrNo();
		String rdate=rBean.getrDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				
				if(rfqno!="" && rdate!=""){
					parametrs.put("rfqNo", rfqno);
					parametrs.put("rdate", dateService.dateFormat(dateService.dateParse(rdate,"au"),"au"));
				}
				 else if(rfqno=="" && rdate!=""){
					parametrs.put("rfqNo",null);
					parametrs.put("rdate", dateService.dateFormat(dateService.dateParse(rdate,"au"),"au"));
					
				}else if(rfqno!="" && rdate==""){
					
					parametrs.put("rfqNo",rfqno);
					parametrs.put("rdate",null);
				}
				else{
					parametrs.put("rfqNo", null);
					parametrs.put("rdate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern", datePattern);
				
			
				// 2. Retrieve template
				 filePath = servletContext.getRealPath("/Resources/jrxml/RFQList.jrxml");
				 printPath = servletContext.getRealPath("/reportApplet/jrprint");
				
				 generateReport(request,parametrs);	                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}

	/* ********************************** Purchase Order Report ******************************** */
	
	@RequestMapping(value = "/poListReport", method = RequestMethod.GET)
	public ModelAndView poReportHome(@ModelAttribute("poListCmd") ReportBean poBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");
		 // Setting response's headers
      
		return new ModelAndView("poReportHome");

	}
	
	@RequestMapping(value ="/generatePOReport", method = RequestMethod.GET)
	public  ModelAndView generatePOReport(@ModelAttribute("poListCmd") ReportBean poBean,HttpServletRequest request,HttpServletResponse response) {
		

			String poNumber=poBean.getPoNo();
			String poDate=poBean.getPoDate();
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(poNumber!="" && poDate!=""){
					parametrs.put("poNumber", poNumber);
					parametrs.put("poDate", dateService.dateFormat(dateService.dateParse(poDate,"au"),"au"));
					
				} else if(poNumber=="" && poDate!=""){
					
					parametrs.put("poNumber",null);
					parametrs.put("poDate", dateService.dateFormat(dateService.dateParse(poDate,"au"),"au"));
					
				}else if(poNumber!="" && poDate==""){
					
					parametrs.put("poNumber",poNumber);
					parametrs.put("poDate",null);
				}
				else{
					parametrs.put("poNumber", null);
					parametrs.put("poDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern", datePattern);
				
				// 2. Retrieve template
				 filePath = servletContext.getRealPath("/Resources/jrxml/PO.jrxml");
				  printPath = servletContext.getRealPath("/reportApplet/jrprint");
				  //Method for Generating Report
				  generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* **********************************Purchase Requisition Report ******************************** */
	
	@RequestMapping(value = "/prListReport", method = RequestMethod.GET)
	public ModelAndView prReportHome(@ModelAttribute("prListCmd") ReportBean prBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("prReportHome");

	}
	
	@RequestMapping(value ="/generatePRReport", method = RequestMethod.GET)
	public  ModelAndView generatePRReport(@ModelAttribute("prListCmd") ReportBean prBean,HttpServletRequest request,HttpServletResponse response) {
			
			String prno=prBean.getPrNo();
			String prdate=prBean.getPrDate();

			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(prno!="" && prdate!=""){
					parametrs.put("prno", prno);
					parametrs.put("prdate", dateService.dateFormat(dateService.dateParse(prdate,"au"),"au"));
				}else if(prno=="" && prdate!=""){
					
					parametrs.put("prno",null);
					parametrs.put("prdate", dateService.dateFormat(dateService.dateParse(prdate,"au"),"au"));
					
				}else if(prno!="" && prdate==""){
					
					parametrs.put("prno",prno);
					parametrs.put("prdate",null);
				}
				else{
					parametrs.put("prno", null);
					parametrs.put("prdate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern", datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/PurchaseRequisitionListReport.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 
			 //Method for Generating Report
			 generateReport(request,parametrs);
			 	                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	
/* **********************************Material Stock Report******************************** */
	
	@RequestMapping(value = "/totStockReport", method = RequestMethod.GET)
	public ModelAndView msReportHome(@ModelAttribute("msCmd") ReportBean prBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("msReportHome");

	}
	
	@RequestMapping(value ="/generateMSReport", method = RequestMethod.GET)
	public  ModelAndView generateMSReport(@ModelAttribute("msCmd") ReportBean msBean,HttpServletRequest request,HttpServletResponse response) {
			
		
			String mId=msBean.getMaterialId();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(mId!=null ){
					parametrs.put("materialId",mId);
				}
				else{
					parametrs.put("materialId",Integer.parseInt("0"));	
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/MaterialStock.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 
			 //Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return new ModelAndView("reportViewer");
		}

/* **********************************Quotation Report ******************************** */
	
	@RequestMapping(value = "/quotationListReport", method = RequestMethod.GET)
	public ModelAndView quotationReportHome(@ModelAttribute("quoListCmd") ReportBean quoBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("quotationReportHome");

	}
	
	@RequestMapping(value ="/generateQuotationReport", method = RequestMethod.GET)
	public  ModelAndView generateQuotationReport(@ModelAttribute("quoListCmd") ReportBean quoBean,HttpServletRequest request,HttpServletResponse response) {
			
			String qNo=quoBean.getqNo();
			String qDate=quoBean.getqDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(qNo!="" && qDate!=""){
					parametrs.put("quotationNo", qNo);
					parametrs.put("quotationDate", dateService.dateFormat(dateService.dateParse(qDate,"au"),"au"));
				}else if(qNo=="" && qDate!=""){
					
					parametrs.put("quotationNo",null);
					parametrs.put("quotationDate", dateService.dateFormat(dateService.dateParse(qDate,"au"),"au"));
					
				}else if(qNo!="" && qDate==""){
					
					parametrs.put("quotationNo",qNo);
					parametrs.put("quotationDate",null);
				}
				else{
					parametrs.put("quotationNo", null);
					parametrs.put("quotationDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern", datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/Quotation.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* **********************************Goods Receipt Report ******************************** */
	/* To get Vendor Id Values */

	@ModelAttribute("vendor")
	public Map<Integer, String> vendorIdGet() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {

			listvalues = categoryService.vendorIdGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();

				map.put((Integer) objects[0], (String) objects[1]);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;

	}

	/* Method Ended */
	
	/* To Get GoodsReceiptType Id Values */
	@ModelAttribute("goodsReceiptType")
	public Map<Integer, String> GoodsReceiptType() {
		List<Object[]> listvalues = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			listvalues = grtservice.goodsReceiptIdsGet();
			iterator = listvalues.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {

		}
		return map;
	}

	/* Method Ended */
	
	@RequestMapping(value = "/purchasedetailsreport", method = RequestMethod.GET)
	public @ResponseBody
	Map<Integer, String> getPurchaseDetails(
			@RequestParam(value = "goodsReceipt", required = true) String goodsReceiptType,
			HttpServletRequest req, HttpServletResponse response)
			throws Exception {

		String str = StringUtils.deleteWhitespace(goodsReceiptType);

		List<Object[]> list = null;
		StringBuffer stringBuffer = new StringBuffer();
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();

		{
			list = poservice.purchaseOrderNumGet(str);
			iterator = list.iterator();
			while (iterator.hasNext()) {
				Object[] objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
				stringBuffer.append("<option value='"
						+ (String) objects[1] + "'>");
				stringBuffer.append((String) objects[1] + "</option>");
			}

		}
		response.setContentType("text/html"); // this is imp.
		PrintWriter out;
		out = response.getWriter();
		out.println(stringBuffer.toString());
		out.flush();
		return null;
	}

	
	@RequestMapping(value = "/grListReport", method = RequestMethod.GET)
	public ModelAndView goodsReceiptReportHome(@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goodsReceipt,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("goodsReceiptReportHome","GoodsReceiptCommand",goodsReceipt);

	}
	@RequestMapping(value ="/generateGRReport", method = RequestMethod.GET)
	public  ModelAndView generateGoodsReceiptReport(@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goodsReceipt,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response){
			
			String grTypeId=goodsReceipt.getGoodsReceiptType_Id();
			
			String grNum=goodsReceipt.getGoodsReceiptTypeNum();
			
			String vendor=goodsReceipt.getVendor_Id();
			String receivingDate=null;
			receivingDate=goodsReceipt.getReceivingDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(grTypeId!="" && grNum!="" && vendor!="" && receivingDate!=""){
					parametrs.put("grTypeId", grTypeId);
					parametrs.put("grNum", grNum);
					parametrs.put("vendor", vendor);
					parametrs.put("receivingDate", receivingDate);
				}
				else{
					parametrs.put("grTypeId", Integer.parseInt("0"));
					parametrs.put("grNum", Integer.parseInt("0"));
					parametrs.put("vendor", Integer.parseInt("0"));
					parametrs.put("receivingDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern", datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/GrList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 
			//Method for Generating Report
			 generateReport(request,parametrs);
				                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
		
/* **********************************Purchase Requisition With Child Report ******************************** */
	
	@RequestMapping(value = "/prReport", method = RequestMethod.GET)
	public ModelAndView generatePRWithChild(@ModelAttribute("prReportCmd") ReportBean prBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("generatePRWithChild");

	}
	
	@RequestMapping(value ="/generatePRReportWithChild", method = RequestMethod.GET)
	public  ModelAndView generatePRWithChildReport(@ModelAttribute("prReportCmd") ReportBean prBean, HttpServletRequest request,HttpServletResponse response) {
			
		
			String prNo=prBean.getPrNo();
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("prno", prNo);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern", datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/PRreport/PRREPORT.jrxml");
			String rootPath1=servletContext.getRealPath("/Resources/jrxml/PRreport/");
			 rootPath=rootPath1+"\\";
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
			 
			//Method for Generating Report
			 generateReport(request,parametrs);
			 	                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* **********************************Goods Receipt With Child Report ******************************** */
	
	@RequestMapping(value = "/grReport", method = RequestMethod.GET)
	public ModelAndView generateGRWithChild(@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goodsReceipt,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("generateGRWithChild","GoodsReceiptCommand",goodsReceipt);

	}
	
	@RequestMapping(value ="/generateGRReportWithChild", method = RequestMethod.GET)
	public  ModelAndView generateGRWithChildReport(@ModelAttribute("GoodsReceiptCommand") GoodsReceipt goodsReceipt, HttpServletRequest request,HttpServletResponse response) {
			
		
			int grType=Integer.parseInt(goodsReceipt.getGoodsReceiptType_Id());
			String grNo=goodsReceipt.getGoodsReceiptTypeNum();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("GoodsReceiptTypeId", grType);
					parametrs.put("goodsReceiptNum", grNo);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern", datePattern);
					
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/GRreport/GrLineReport.jrxml");
			 rootPath = servletContext.getRealPath("/Resources/jrxml/GRreport/");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
				
			//Method for Generating Report
			 generateReport(request,parametrs);
				                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* **********************************Quotation With Child Report ******************************** */
	
	@RequestMapping(value = "/quotationReport", method = RequestMethod.GET)
	public ModelAndView generateQuotationWithChild(@ModelAttribute("quoReportCmd") ReportBean quBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("generateQuotationWithChild");

	}
	
	@RequestMapping(value ="/generateQuotReportWithChild", method = RequestMethod.GET)
	public  ModelAndView generateQuotationWithChildReport(@ModelAttribute("quoReportCmd") ReportBean quBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String qNo=quBean.getqNo();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("quotationNo",qNo);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
					
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/QuotationReport/QuotationList.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/QuotationReport/");
		 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* **********************************Purchase Order With Child Report ******************************** */
	
	@RequestMapping(value = "/poReport", method = RequestMethod.GET)
	public ModelAndView generatePOWithChild(@ModelAttribute("poReportCmd") ReportBean poRBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("poReportWithChild");

	}
	
	@RequestMapping(value ="/generatePOReportWithChild", method = RequestMethod.GET)
	public  ModelAndView generatePOWithChildReport(@ModelAttribute("poReportCmd") ReportBean poRBean,HttpServletRequest request,HttpServletResponse response) {
			
		
			String poNO=poRBean.getPoNo();
		
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("poNo",poNO);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/PO/PurchaseOrder.jrxml");
			  String rootPath1=servletContext.getRealPath("/Resources/jrxml/PO/");
			  rootPath=rootPath1+"\\";
			  printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
			 
			//Method for Generating Report
			 generateReport(request,parametrs);
			                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* **********************************RFQ  With Child Report ******************************** */
	
	@RequestMapping(value = "/rfqReport", method = RequestMethod.GET)
	public ModelAndView generateRfqWithChild(@ModelAttribute("rfqReportCmd") ReportBean rfqReportBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("rfqReportWithChild");

	}
	
	@RequestMapping(value ="/generateRFQReportWithChild", method = RequestMethod.GET)
	public  ModelAndView generateRfqWithChildReport(@ModelAttribute("rfqReportCmd") ReportBean rfqReportBean,HttpServletRequest request,HttpServletResponse response) {
			
		
			
		time=System.currentTimeMillis();
		String rfqNo=rfqReportBean.getrNo();
		
		
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("rfqNo", Integer.parseInt(rfqNo));
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/RFQ/RFQList.jrxml");
			 String rootPath1=servletContext.getRealPath("/Resources/jrxml/RFQ/");
		 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			  
				 rootPath=rootPath1+"\\";
			 parametrs.put("rootPath", rootPath);
			 
			//Method for Generating Report
			 generateReport(request,parametrs);
			 
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* ********************************** Vendor Quotation Comparison  With Child Report ******************************** */
	
	@RequestMapping(value = "/quotationCompReport", method = RequestMethod.GET)
	public ModelAndView vendorQuotComp(@ModelAttribute("qcReportCmd") ReportBean qcBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("vendorQuotComp");

	}
	
	@RequestMapping(value ="/generatevendorQuotComp", method = RequestMethod.GET)
	public  ModelAndView generatevendorQuotComp(@ModelAttribute("qcReportCmd") ReportBean qcBean,HttpServletRequest request,HttpServletResponse response) {
			
		
			String rfqId=qcBean.getReportId();
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("rfq_Id", Integer.parseInt(rfqId));
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/VendorQuotationComparision.jrxml");
			  printPath = servletContext.getRealPath("/reportApplet/jrprint");
			
			//Method for Generating Report
			generateReport(request,parametrs);	                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** Pending GR Report ******************************** */
	@RequestMapping(value = "/pendingGoodsRcptReport", method = RequestMethod.GET)
	public ModelAndView pendingGoodsForPO(@ModelAttribute("poReportCmd") ReportBean poBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("pendingGoodsForPOHome");
	}
		
	@RequestMapping(value ="/generatependingGoodsForPO", method = RequestMethod.GET)
	public  ModelAndView generatePendingGoodsForPO(HttpServletRequest request,HttpServletResponse response) {
				
			
				String purchaseOrderId=request.getParameter("purchaseOrderId");
				try {
					// 1. Add report parameters
					HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
						parametrs.put("purchaseOrderId", Integer.parseInt(purchaseOrderId));
						
						//Get the user Id for displaying logo 
						session =request.getSession(false);
						userId=session.getAttribute("userId").toString();
						parametrs.put("logoID", userId);
						
					// 2. Retrieve template
				 filePath = servletContext.getRealPath("/Resources/jrxml/PendingGoodsReceipt.jrxml");
				  printPath = servletContext.getRealPath("/reportApplet/jrprint");
				
				//Method for Generating Report
				generateReport(request,parametrs);	                                  
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				return new ModelAndView("reportViewer");
			}
	
	/* ********************************** Get tobe Reorder Material ******************************** */
	@RequestMapping(value = "/reorderMatReport", method = RequestMethod.GET)
	public ModelAndView getTobeReorderMaterialHome(@ModelAttribute("reorderMatCmd") ReportBean rmBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("getTobeReorderMaterialHome");
	}
	
	@RequestMapping(value ="/generateRMReport", method = RequestMethod.GET)
	public  ModelAndView generategetTobeReorderMaterial(@ModelAttribute("reorderMatCmd") ReportBean rmBean,HttpServletRequest request,HttpServletResponse response) {
				
			
				String materialId=request.getParameter("materialId");
				try {
					// 1. Add report parameters
					HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
						parametrs.put("materialId", materialId);
						
						//Get the user Id for displaying logo 
						session =request.getSession(false);
						userId=session.getAttribute("userId").toString();
						parametrs.put("logoID", userId);
						
					// 2. Retrieve template
				 filePath = servletContext.getRealPath("/Resources/jrxml/GetTobeReorderdMaterial.jrxml");
				  printPath = servletContext.getRealPath("/reportApplet/jrprint");
				
				//Method for Generating Report
				generateReport(request,parametrs);	                                  
				} catch (Exception e) {
					
					e.printStackTrace();
				}
				return new ModelAndView("reportViewer");
			}
	
/* **********************************Sales Inquiry List  ******************************** */
	
	@RequestMapping(value = "/salesInqListReport", method = RequestMethod.GET)
	public ModelAndView salesInquiryListHome(@ModelAttribute("siListCmd") ReportBean siBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("salesInquiryListHome");

	}
	
	@RequestMapping(value ="/generateSalesInquiryList", method = RequestMethod.GET)
	public  ModelAndView generateSalesInquiryList(@ModelAttribute("siListCmd") ReportBean siBean, HttpServletRequest request,HttpServletResponse response) {
			
			String siNo=siBean.getSiNo();
			String siDate=siBean.getSiDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(siNo!="" && siDate!=""){
					parametrs.put("salesInquiryNo", siNo);
					parametrs.put("requestedDate", dateService.dateFormat(dateService.dateParse(siDate,"au"),"au"));
				}else if(siNo=="" && siDate!=""){
					
					parametrs.put("salesInquiryNo",null);
					parametrs.put("requestedDate", dateService.dateFormat(dateService.dateParse(siDate,"au"),"au"));
					
				}else if(siNo!="" && siDate==""){
					
					parametrs.put("salesInquiryNo",siNo);
					parametrs.put("requestedDate",null);
				}
				else{
					parametrs.put("salesInquiryNo", null);
					parametrs.put("requestedDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/salesInquiryList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* **********************************Sales Order List  ******************************** */
	
	@RequestMapping(value = "/salesOrderListReport", method = RequestMethod.GET)
	public ModelAndView salesOrderListHome(@ModelAttribute("soListCmd") ReportBean soBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("salesOrderListHome");

	}
	
	@RequestMapping(value ="/generateSalesOrderList", method = RequestMethod.GET)
	public  ModelAndView generateSalesOrderList(@ModelAttribute("soListCmd") ReportBean soBean, HttpServletRequest request,HttpServletResponse response) {
			
			String soNo=soBean.getSoNo();
			String soDate=soBean.getSoDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(soNo!="" && soDate!=""){
					parametrs.put("salesOrderNo", soNo);
					parametrs.put("salesOrderDate", dateService.dateFormat(dateService.dateParse(soDate,"au"),"au"));
				}else if(soNo=="" && soDate!=""){
					
					parametrs.put("salesOrderNo",null);
					parametrs.put("salesOrderDate", dateService.dateFormat(dateService.dateParse(soDate,"au"),"au"));
					
				}else if(soNo!="" && soDate==""){
					
					parametrs.put("salesOrderNo",soNo);
					parametrs.put("salesOrderDate",null);
				}
				else{
					parametrs.put("salesOrderNo", null);
					parametrs.put("salesOrderDate", null);
					
				}
				
				
				
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/salesOrderList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* **********************************Sales Purchase Order List  ******************************** */
	
	@RequestMapping(value = "/salesPOListReport", method = RequestMethod.GET)
	public ModelAndView salesPurchaseOrderListHome(@ModelAttribute("spoListCmd") ReportBean spoBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("salesPurchaseOrderListHome");

	}
	
	@RequestMapping(value ="/generateSalesPurchaseOrderList", method = RequestMethod.GET)
	public  ModelAndView generateSalesPurchaseOrderList(@ModelAttribute("spoListCmd") ReportBean spoBean, HttpServletRequest request,HttpServletResponse response) {
			
			String spoNo=spoBean.getSpoNo();
			String spoDate=spoBean.getSpoDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(spoNo!="" && spoDate!=""){
					parametrs.put("salesPoNo", spoNo);
					parametrs.put("salesPoDate", dateService.dateFormat(dateService.dateParse(spoDate,"au"),"au"));
				}else if(spoNo=="" && spoDate!=""){
					
					parametrs.put("salesPoNo",null);
					parametrs.put("salesPoDate", dateService.dateFormat(dateService.dateParse(spoDate,"au"),"au"));
					
				}else if(spoNo!="" && spoDate==""){
					
					parametrs.put("salesPoNo",spoNo);
					parametrs.put("salesPoDate",null);
				}
				else{
					parametrs.put("salesPoNo", null);
					parametrs.put("salesPoDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/salesPOList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			 
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* **********************************Sales Quotation List  ******************************** */
	
	@RequestMapping(value = "/salesQuotListReport", method = RequestMethod.GET)
	public ModelAndView salesQuotationListHome(@ModelAttribute("sqoListCmd") ReportBean sqoBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("salesQuotationListHome");

	}
	
	@RequestMapping(value ="/generateSalesQuotationList", method = RequestMethod.GET)
	public  ModelAndView generateSalesQuotationList( @ModelAttribute("sqoListCmd") ReportBean sqoBean,HttpServletRequest request,HttpServletResponse response) {
			
			String sqNo=sqoBean.getSqNo();
			String sqDate=sqoBean.getSqDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(sqNo!="" && sqDate!=""){
					parametrs.put("salesQuoNO", sqNo);
					parametrs.put("salesQuoDate",dateService.dateFormat(dateService.dateParse(sqDate,"au"),"au") );
				}else if(sqNo=="" && sqDate!=""){
					
					parametrs.put("salesQuoNO",null);
					parametrs.put("salesQuoDate", dateService.dateFormat(dateService.dateParse(sqDate,"au"),"au"));
					
				}else if(sqNo!="" && sqDate==""){
					
					parametrs.put("salesQuoNO",sqNo);
					parametrs.put("salesQuoDate",null);
				}
				else{
					parametrs.put("salesQuoNO", null);
					parametrs.put("salesQuoDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/salesQuotationList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* **********************************Sales Inquiry Parent with Child ******************************** */
	
	@RequestMapping(value = "/salesInqReport", method = RequestMethod.GET)
	public ModelAndView salesInquirypwcHome(@ModelAttribute("siReportCmd") ReportBean siRBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("salesInquirypwcHome");

	}
	
	@RequestMapping(value ="/generateSalesInquiryPwcReport", method = RequestMethod.GET)
	public  ModelAndView generateSalesInquiryPwcReport(@ModelAttribute("siReportCmd") ReportBean siRBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String siNo=siRBean.getSiNo();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("salesInquiryNo",siNo);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/salesInquiry/salesInquiryReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/salesInquiry/salesInquiryLine.jasper");
		 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* **********************************Sales Order Parent with Child ******************************** */
	
	@RequestMapping(value = "/salesOrderReport", method = RequestMethod.GET)
	public ModelAndView salesOrderpwcHome(@ModelAttribute("soReportCmd") ReportBean soRBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("salesOrderpwcHome");

	}
	
	@RequestMapping(value ="/generateSalesOrderPwcReport", method = RequestMethod.GET)
	public  ModelAndView generateSalesOrderPwcReport(@ModelAttribute("soReportCmd") ReportBean soRBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String soNo=soRBean.getSoNo();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("salesOrderNo",soNo);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/salesOrder/salesOrderReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/salesOrder/salesOrderLine.jasper");
		 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* **********************************Sales Purchase Order Parent with Child ******************************** */
	
	@RequestMapping(value = "/salesPOReport", method = RequestMethod.GET)
	public ModelAndView salesPopwcHome(@ModelAttribute("spoReportCmd") ReportBean spoRBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("salesPopwcHome");

	}
	
	@RequestMapping(value ="/generateSalesPOPwcReport", method = RequestMethod.GET)
	public  ModelAndView generateSalesPOPwcReport(@ModelAttribute("spoReportCmd") ReportBean spoRBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String spNo=spoRBean.getSpoNo();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("salesPoNo",spNo);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/salesPO/salesPoReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/salesPO/salesPoLine.jasper");
		 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* **********************************Sales Quotation Parent with Child ******************************** */
	
	@RequestMapping(value = "/salesQuotReport", method = RequestMethod.GET)
	public ModelAndView salesQuopwcHome(@ModelAttribute("sqoReportCmd") ReportBean sqoRBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("salesQuopwcHome");

	}
	
	@RequestMapping(value ="/generateSalesQuoPwcReport", method = RequestMethod.GET)
	public  ModelAndView generateSalesQuoPwcReport(@ModelAttribute("sqoReportCmd") ReportBean sqoRBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String sqNo=sqoRBean.getSqNo();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("salesQuoNo",sqNo);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/salesQuo/salesQuotation.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/salesQuo/salesQuoLine.jasper");
		 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** voucher ******************************** */
	@RequestMapping(value = "/voucherReport", method = RequestMethod.GET)
	public ModelAndView voucherReportHome(@ModelAttribute("voucherReportCmd") ReportBean voBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("voucherReport");

	}
	
	@RequestMapping(value ="/generatepaymentVoucherReport", method = RequestMethod.GET)
	public  ModelAndView generateVoucherReport(@ModelAttribute("voucherReportCmd") ReportBean voBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String vId=voBean.getVoucherNo();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("voucherId",vId);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/paymentVoucher/voucher.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/paymentVoucher/voucherSigns.jasper");
		 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	
/* ********************************** Total Stock******************************** */
	
	
	@RequestMapping(value = "/totalStockReport", method = RequestMethod.GET)
	public ModelAndView totalStockReportHome(@ModelAttribute("tsReportCmd") ReportBean tsBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("tsReport");

	}

	@RequestMapping(value ="/generateTSReport", method = RequestMethod.GET)
	public  ModelAndView generateTSReport( @ModelAttribute("tsReportCmd") ReportBean tsBean,HttpServletRequest request,HttpServletResponse response) {
			
			String mId=tsBean.getMaterialId();
			String sLocation=tsBean.getsLocation();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(mId!="" && sLocation!=""){
					parametrs.put("materialId", mId);
					parametrs.put("sLocationId", sLocation);
				}else if(mId=="" && sLocation!=""){
					parametrs.put("materialId","0");
					parametrs.put("sLocationId", sLocation);
				}else if(mId!="" && sLocation==""){
					parametrs.put("materialId",mId);
					parametrs.put("sLocationId", "0");
				}
				else{
					parametrs.put("materialId", "0");
					parametrs.put("sLocationId", "0");
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/totalStock.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
		/* ********************************** Customer Return List******************************** */
	
	@RequestMapping(value = "/crListReport", method = RequestMethod.GET)
	public ModelAndView crListReportHome(@ModelAttribute("crReportCmd") ReportBean crBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("crListReport");

	}
	
	@RequestMapping(value ="/generateCustomerReturnList", method = RequestMethod.GET)
	public  ModelAndView generateCustomerReturnList(@ModelAttribute("crReportCmd") ReportBean crBean, HttpServletRequest request,HttpServletResponse response) {
			
			 reportId=crBean.getReportId();
			 reportDate=crBean.getReportDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(reportId!="" && reportDate!=""){
					parametrs.put("customerId", reportId);
					parametrs.put("customerDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId=="" && reportDate!=""){
					
					parametrs.put("customerId",null);
					parametrs.put("customerDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId!="" && reportId==""){
					
					parametrs.put("customerId",reportId);
					parametrs.put("customerDate",null);
				}
				else{
					parametrs.put("customerId", null);
					parametrs.put("customerDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/customerReturnList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* ********************************** Vendor Return List******************************** */
	
	@RequestMapping(value = "/vrListReport", method = RequestMethod.GET)
	public ModelAndView vrListReportHome(@ModelAttribute("vrReportCmd") ReportBean vrBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("vrListReport");

	}
	
	@RequestMapping(value ="/generateVendorReturnList", method = RequestMethod.GET)
	public  ModelAndView generateVendorReturnList(@ModelAttribute("vrReportCmd") ReportBean vrBean, HttpServletRequest request,HttpServletResponse response) {
			
		 reportId=vrBean.getReportId();
		 reportDate=vrBean.getReportDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(reportId!="" && reportDate!=""){
					parametrs.put("vrId", reportId);
					parametrs.put("vrDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId=="" && reportDate!=""){
					
					parametrs.put("vrId",null);
					parametrs.put("vrDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId!="" && reportId==""){
					
					parametrs.put("vrId",reportId);
					parametrs.put("vrDate",null);
				}
				else{
					parametrs.put("vrId", null);
					parametrs.put("vrDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/vendorReturnList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* ********************************** Physical Verification List******************************** */
	
	@RequestMapping(value = "/pvListReport", method = RequestMethod.GET)
	public ModelAndView pvListReportHome(@ModelAttribute("pvReportCmd") ReportBean pvBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("pvListReport");

	}
	
	@RequestMapping(value ="/generatePhysicalVerificationList", method = RequestMethod.GET)
	public  ModelAndView generatePhysicalVerificationist(@ModelAttribute("pvReportCmd") ReportBean pvBean, HttpServletRequest request,HttpServletResponse response) {
			
		 reportId=pvBean.getReportId();
		 reportDate=pvBean.getReportDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(reportId!="" && reportDate!=""){
					parametrs.put("vId", reportId);
					parametrs.put("vDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId=="" && reportDate!=""){
					
					parametrs.put("vId",null);
					parametrs.put("vDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId!="" && reportId==""){
					
					parametrs.put("vId",reportId);
					parametrs.put("vDate",null);
				}
				else{
					parametrs.put("vId", null);
					parametrs.put("vDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/physicalVerificationList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* ********************************** Stock Transfer List******************************** */
	
	@RequestMapping(value = "/stockTransferListReport", method = RequestMethod.GET)
	public ModelAndView stListReportHome(@ModelAttribute("stReportCmd") ReportBean stBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("stockTransferListReport");

	}
	@RequestMapping(value ="/generateStockTransferList", method = RequestMethod.GET)
	public  ModelAndView generateStockTransferList(@ModelAttribute("stReportCmd") ReportBean stBean, HttpServletRequest request,HttpServletResponse response) {
			
		 reportId=stBean.getReportId();
		 reportDate=stBean.getReportDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(reportId!="" && reportDate!=""){
					parametrs.put("stockTransferId", reportId);
					parametrs.put("stockTransferDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
				}else if(reportId=="" && reportDate!=""){
					
					parametrs.put("stockTransferId",null);
					parametrs.put("stockTransferDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId!="" && reportId==""){
					
					parametrs.put("stockTransferId",reportId);
					parametrs.put("stockTransferDate",null);
				}
				else{
					parametrs.put("stockTransferId", null);
					parametrs.put("stockTransferDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/stockTransferList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	/* ********************************** Goods Issue To Customer List******************************** */
	
	@RequestMapping(value = "/goodsIssueToCustomer", method = RequestMethod.GET)
	public ModelAndView goodsIssueToCustomerReportHome(@ModelAttribute("gisReportCmd") ReportBean gisBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("goodsIssueToCustomer");

	}
	@RequestMapping(value ="/generateGISReport", method = RequestMethod.GET)
	public  ModelAndView generateGISReport(@ModelAttribute("gisReportCmd") ReportBean gisBean, HttpServletRequest request,HttpServletResponse response) {
			
		 reportId=gisBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				parametrs.put("soId", reportId);
			
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/goodsIssueToCustomer.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* ********************************** Goods Issue To Production List******************************** */
	
	@RequestMapping(value = "/goodsIssueToProduction", method = RequestMethod.GET)
	public ModelAndView goodsIssueToProductionReportHome(@ModelAttribute("gipReportCmd") ReportBean gipBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("goodsIssueToProduction");

	}
	@RequestMapping(value ="/generateGIPReport", method = RequestMethod.GET)
	public  ModelAndView generateGIPReport(@ModelAttribute("gisReportCmd") ReportBean gisBean, HttpServletRequest request,HttpServletResponse response) {
			
		 reportId=gisBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				parametrs.put("poId", reportId);
			
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/goodsIssueToProduction.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* ********************************** Vendor Invoice List******************************** */
	
	@RequestMapping(value = "/vendorInvoiceListReport", method = RequestMethod.GET)
	public ModelAndView viListReportHome(@ModelAttribute("viReportCmd") ReportBean viBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("vendorInvoiceListReport");

	}
	
	@RequestMapping(value ="/generateVendorInvoiceList", method = RequestMethod.GET)
	public  ModelAndView generateVendorInvoiceList(@ModelAttribute("viReportCmd") ReportBean viBean, HttpServletRequest request,HttpServletResponse response) {
			
		 reportId=viBean.getReportId();
		 reportDate=viBean.getReportDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(reportId!="" && reportDate!=""){
					parametrs.put("vendorInvoiceId", reportId);
					parametrs.put("vendorDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId=="" && reportDate!=""){
					
					parametrs.put("vendorInvoiceId",null);
					parametrs.put("vendorDate", dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId!="" && reportId==""){
					
					parametrs.put("vendorInvoiceId",reportId);
					parametrs.put("vendorDate",null);
				}
				else{
					parametrs.put("vendorInvoiceId", null);
					parametrs.put("vendorDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/vendorInvoiceList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* ********************************** Customer Invoice List******************************** */
	
	@RequestMapping(value = "/customerInvoiceListReport", method = RequestMethod.GET)
	public ModelAndView ciListReportHome(@ModelAttribute("ciReportCmd") ReportBean ciBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("customerInvoiceListReport");

	}
	@RequestMapping(value ="/generateCustomerInvoiceList", method = RequestMethod.GET)
	public  ModelAndView generateCustomerInvoiceList(@ModelAttribute("ciReportCmd") ReportBean ciBean, HttpServletRequest request,HttpServletResponse response) {
			
		 reportId=ciBean.getReportId();
		// reportDate=ciBean.getReportDate();
		 reportDate=ciBean.getReportDate();
		 
			
			try {
				
				
			
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(reportId!="" && reportDate!=""){
					parametrs.put("customerInvoiceId", reportId);
					parametrs.put("customerDate",  dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
					
				}else if(reportId=="" && reportDate!=""){
					
					parametrs.put("customerInvoiceId",null);
					parametrs.put("customerDate",  dateService.dateFormat(dateService.dateParse(reportDate,"au"),"au"));
					
				}else if(reportId!="" && reportId==""){
					
					parametrs.put("customerInvoiceId",reportId);
					parametrs.put("customerDate",null);
				}
				else{
					parametrs.put("customerInvoiceId", null);
					parametrs.put("customerDate", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/customerInvoice.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* **********************************Payment List******************************** */
	
	@RequestMapping(value = "/paymentListReport", method = RequestMethod.GET)
	public ModelAndView paymentListReportHome(@ModelAttribute("pReportCmd") ReportBean pBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("paymentListReport");

	}
	@RequestMapping(value ="/generatePaymentReport", method = RequestMethod.GET)
	public  ModelAndView generatePaymentReport(@ModelAttribute("pReportCmd") ReportBean pBean, HttpServletRequest request,HttpServletResponse response) {
			
		 reportId=pBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				parametrs.put("vendorInvoiceId", reportId);
			
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/paymentList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* **********************************Receipt List******************************** */
	
	@RequestMapping(value = "/ReceiptListReport", method = RequestMethod.GET)
	public ModelAndView ReceiptListReportHome(@ModelAttribute("rReportCmd") ReportBean rBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("ReceiptListReport");

	}
	
	@RequestMapping(value ="/generateReceiptReport", method = RequestMethod.GET)
	public  ModelAndView generateReceiptReport(@ModelAttribute("rReportCmd") ReportBean rBean, HttpServletRequest request,HttpServletResponse response) {
			
		 reportId=rBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				parametrs.put("customerInvoiceId", reportId);
			
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/receiptReport.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* ********************************** Customer Return Parent with Child  ******************************** */
	
	@RequestMapping(value = "/customerReturnReport", method = RequestMethod.GET)
	public ModelAndView customerReturnReport(@ModelAttribute("crpReportCmd") ReportBean crpBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("customerReturnReport");

	}
	@RequestMapping(value ="/generateCRReport", method = RequestMethod.GET)
	public  ModelAndView generateCRReport(@ModelAttribute("crpReportCmd") ReportBean crpBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String reportId=crpBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("crId",reportId);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/CustomerReturn/customerReturnReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/CustomerReturn/customerReturnLine.jasper");
		 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* ********************************** Vendor Return Parent with Child  ******************************** */
	
	@RequestMapping(value = "/vendorReturnReport", method = RequestMethod.GET)
	public ModelAndView vendorReturnReport(@ModelAttribute("vrpReportCmd") ReportBean vrpBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("vendorReturnReport");

	}
	
	@RequestMapping(value ="/generateVRReport", method = RequestMethod.GET)
	public  ModelAndView generateVRReport(@ModelAttribute("vrpReportCmd") ReportBean vrpBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String reportId=vrpBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("vrId",reportId);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/VendorReturn/vendorReturnReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/VendorReturn/vendorReturnLine.jasper");
		 printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	
/* ********************************** Physical Verification Parent with Child  ******************************** */
	
	@RequestMapping(value = "/pysicalVerificationReport", method = RequestMethod.GET)
	public ModelAndView pysicalVerificationReport(@ModelAttribute("pvpReportCmd") ReportBean pvpBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("pysicalVerificationReport");

	}
	@RequestMapping(value ="/generatePVReport", method = RequestMethod.GET)
	public  ModelAndView generatePVReport(@ModelAttribute("pvpReportCmd") ReportBean pvpBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String reportId=pvpBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("verificationId",reportId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					
				// 2. Retrieve template
			  filePath = servletContext.getRealPath("/Resources/jrxml/physicalVerification/physicalVerificationReportParent.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/physicalVerification/physicalVerificationReportLine.jasper");
			  printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	
/* **********************************Stock Transfer Parent with Child  ******************************** */
	
	@RequestMapping(value = "/stockTransferReport", method = RequestMethod.GET)
	public ModelAndView stockTransferReport(@ModelAttribute("stpReportCmd") ReportBean stpBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("stockTransferReport");

	}
	@RequestMapping(value ="/generateSTReport", method = RequestMethod.GET)
	public  ModelAndView generateSTReport(@ModelAttribute("stpReportCmd") ReportBean stpBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String reportId=stpBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("stockTransferId",reportId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					
				// 2. Retrieve template
			  filePath = servletContext.getRealPath("/Resources/jrxml/stockTransfer/stockTransferReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/stockTransfer/stockTransferReportLine.jasper");
			  printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* **********************************Customer Invoice Parent with Child  ******************************** */
	
	@RequestMapping(value = "/customerInvoiceReport", method = RequestMethod.GET)
	public ModelAndView customerInvoiceReport(@ModelAttribute("cipReportCmd") ReportBean cipBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("customerInvoiceReport");

	}
	@RequestMapping(value ="/generateCIReport", method = RequestMethod.GET)
	public  ModelAndView generateCIReport(@ModelAttribute("cipReportCmd") ReportBean cipBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String reportId=cipBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("ciID",reportId);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			  filePath = servletContext.getRealPath("/Resources/jrxml/customerInvoice/cusotmerInvoiceParent.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/customerInvoice/customerInvoiceLine.jasper");
			  printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
/* **********************************Vendor Invoice Parent with Child  ******************************** */
	
	@RequestMapping(value = "/vendorInvoiceReport", method = RequestMethod.GET)
	public ModelAndView vendorInvoiceReport(@ModelAttribute("vipReportCmd") ReportBean vipBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("vendorInvoiceReport");

	}
	@RequestMapping(value ="/generateVIReport", method = RequestMethod.GET)
	public  ModelAndView generateVIReport(@ModelAttribute("vipReportCmd") ReportBean vipBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String reportId=vipBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("viId",reportId);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			  filePath = servletContext.getRealPath("/Resources/jrxml/VendorInvoice/vendorInvoiceReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/VendorInvoice/vendorInvoiceLine.jasper");
			  printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* **********************************Customer List******************************** */
	
	@RequestMapping(value = "/cutomerListReport", method = RequestMethod.GET)
	public ModelAndView customerListHome(@ModelAttribute("custListCmd") ReportBean cusBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("customerListHome");

	}
	
	@RequestMapping(value ="/generateCustomerListReport", method = RequestMethod.GET)
	public  ModelAndView generateCustomerListReport(@ModelAttribute("custListCmd") ReportBean cusBean, HttpServletRequest request,HttpServletResponse response) {
			
			String cusId=cusBean.getReportId() ;
			String city=cusBean.getReportDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(cusId!="" && city!=""){
					parametrs.put("customerId", cusId);
					parametrs.put("city", city);
				}else if(cusId=="" && city!=""){
					
					parametrs.put("customerId",null);
					parametrs.put("city",city);
					
				}else if(cusId!="" && city==""){
					
					parametrs.put("customerId",cusId);
					parametrs.put("city",null);
				}
				else{
					parametrs.put("customerId", null);
					parametrs.put("city", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/customerList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* **********************************Vendor List******************************** */
	@RequestMapping(value = "/vendorListReport", method = RequestMethod.GET)
	public ModelAndView vendorListHome(@ModelAttribute("custListCmd") ReportBean cusBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("vendorListHome");

	}
	@RequestMapping(value ="/generateVendorListReport", method = RequestMethod.GET)
	public  ModelAndView generateVendorListReport(@ModelAttribute("venListCmd") ReportBean cusBean, HttpServletRequest request,HttpServletResponse response) {
			
			String venId=cusBean.getReportId() ;
			String city=cusBean.getReportDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(venId!="" && city!=""){
					parametrs.put("vendorId", venId);
					parametrs.put("city", city);
				}else if(venId=="" && city!=""){
					
					parametrs.put("vendorId",null);
					parametrs.put("city",city);
					
				}else if(venId!="" && city==""){
					
					parametrs.put("vendorId",venId);
					parametrs.put("city",null);
				}
				else{
					parametrs.put("vendorId", null);
					parametrs.put("city", null);
					
				}
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/vendorList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	
	/* **********************************Inspetion Lot Result******************************** */
	@RequestMapping(value = "/inspLotResultListReport", method = RequestMethod.GET)
	public ModelAndView inspLotResultListReport(@ModelAttribute("inspLotCmd") ReportBean inspLotBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("inspLotResultListReport");

	}
	
	@RequestMapping(value ="/generateInspectionLotResult", method = RequestMethod.GET)
	public  ModelAndView generateInspectionLotResult(@ModelAttribute("inspLotCmd") ReportBean inspLotBean, HttpServletRequest request,HttpServletResponse response) {
			
			String inspectionId=inspLotBean.getReportId() ;
			String refNo=inspLotBean.getReportDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(inspectionId!="" && refNo!=""){
					parametrs.put("inspLotId", inspectionId);
					parametrs.put("refNO", refNo);
				}
				
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/insptionLotResult.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* **********************************Dialy Work in Progress******************************** */
	@RequestMapping(value = "/dwpListReport", method = RequestMethod.GET)
	public ModelAndView dwpListReport(@ModelAttribute("dwpCmd") ReportBean dwpBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("dwpListReport");

	}
	
	@RequestMapping(value ="/generatdwpReport", method = RequestMethod.GET)
	public  ModelAndView generatdwpReport(@ModelAttribute("dwpCmd") ReportBean dwpBean, HttpServletRequest request,HttpServletResponse response) {
			
			String shiftId=dwpBean.getReportId() ;
			String workDay=dwpBean.getReportDate();
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				if(workDay!="" && shiftId!=""){
					parametrs.put("shiftId", shiftId);
					parametrs.put("workDay", workDay);
				}
				
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/dailyWorkInProgress.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	/* **********************************Material to send Customer******************************** */
	@RequestMapping(value = "/matTocustListReport", method = RequestMethod.GET)
	public ModelAndView matTocustListReport(@ModelAttribute("matToCust") ReportBean matToCustBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("matTocustListReport");

	}
	
	@RequestMapping(value ="/generateMatToCustomer", method = RequestMethod.GET)
	public  ModelAndView generateMatToCustomer(@ModelAttribute("matToCust") ReportBean matToCustBean, HttpServletRequest request,HttpServletResponse response) {
			
			String soId=matToCustBean.getReportId() ;
			
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				
					parametrs.put("soId", soId);
					
				
				
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/pendingMaterialForConsumer.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* **********************************Get All Employees******************************** */
	@RequestMapping(value = "/allEmployeeReport", method = RequestMethod.GET)
	public ModelAndView allEmployeeReport(@ModelAttribute("empCmd") ReportBean matToCustBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("allEmployeeReport");

	}
	
	@RequestMapping(value ="/generateEmpsReport", method = RequestMethod.GET)
	public  ModelAndView generateEmpsReport(@ModelAttribute("empCmd") ReportBean matToCustBean, HttpServletRequest request,HttpServletResponse response) {
			
			String orgId=matToCustBean.getReportId() ;
			
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				
					parametrs.put("orgId", orgId);
					
				
				
				
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/allEmployees.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* **********************************Attendance******************************** */
	@RequestMapping(value = "/attendanceReport", method = RequestMethod.GET)
	public ModelAndView attendanceReport(@ModelAttribute("attCmd") ReportBean attBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("attendanceReport");

	}
	
	@RequestMapping(value ="/generateAttendanceReport", method = RequestMethod.GET)
	public  ModelAndView generateAttendanceReport(@ModelAttribute("attCmd") ReportBean attBean, HttpServletRequest request,HttpServletResponse response) {
			
			String month=attBean.getReportId() ;
			String year=attBean.getReportDate();
			
			
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				
					parametrs.put("month", month);
					parametrs.put("year",year);
					
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/attendance.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* **********************************Applicants******************************** */
	@RequestMapping(value = "/applicantsReport", method = RequestMethod.GET)
	public ModelAndView applicantsReport(@ModelAttribute("appCmd") ReportBean appCmd,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("applicantsReport");

	}
	
	
	@RequestMapping(value ="/generateApplicantReport", method = RequestMethod.GET)
	public  ModelAndView generateApplicantReport(@ModelAttribute("appCmd") ReportBean attBean, HttpServletRequest request,HttpServletResponse response) {
			
			String vacancyId=attBean.getReportId() ;
			
			
			
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				
					parametrs.put("vacancyId", vacancyId);
					
					
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/allApplicants.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* **********************************Time Sheet ******************************** */
	@RequestMapping(value = "/timeSheetReport", method = RequestMethod.GET)
	public ModelAndView timeSheetReport(@ModelAttribute("tsCmd") ReportBean tsCmd,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("timeSheetReport");

	}
	@RequestMapping(value ="/generateTimeSheetReport", method = RequestMethod.GET)
	public  ModelAndView generateTimeSheetReport(@ModelAttribute("tsCmd") ReportBean tsCmd, HttpServletRequest request,HttpServletResponse response) {
			
			String month=tsCmd.getReportId() ;
			String orgId=tsCmd.getReportDate();
			
			
			
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
				
					parametrs.put("month", month);
					parametrs.put("orgId", orgId);
					
					
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/getTimeSheet.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	/* **********************************Delivery Notes List******************************** */
	@RequestMapping(value = "/deliveryNotesListReport", method = RequestMethod.GET)
	public ModelAndView deliveryNotesListReport(@ModelAttribute("dnsCmd") ReportBean dnsBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("deliveryNotesListReport");

	}
	
	@RequestMapping(value ="/generateDNListReport", method = RequestMethod.GET)
	public  ModelAndView generateDNListReport(@ModelAttribute("dnsCmd") ReportBean dnsBean, HttpServletRequest request,HttpServletResponse response) {
			
			String soId=dnsBean.getReportId() ;
		
			
			
			
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
					if(soId!="")
					parametrs.put("soId", soId);
					else
					parametrs.put("soId", null);
					
					
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/deliveryNoteList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** delivery Notes Parent with Child Report ******************************** */
	@RequestMapping(value = "/deliveryNotesReport", method = RequestMethod.GET)
	public ModelAndView deliveryNotesReport(@ModelAttribute("dnCmd") ReportBean dnBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("deliveryNotesReport");

	}
	@RequestMapping(value ="/generateDeliveryNoteReport", method = RequestMethod.GET)
	public  ModelAndView generateDeliveryNoteReport(@ModelAttribute("dnCmd") ReportBean dnBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String reportId=dnBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("soId",reportId);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			  filePath = servletContext.getRealPath("/Resources/jrxml/deliveryNote/deliveryNoteReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/deliveryNote/deliveryNoteLine.jasper");
			  printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* **********************************Break Down Maintainence List******************************** */
	@RequestMapping(value = "/bdmListReport", method = RequestMethod.GET)
	public ModelAndView bdmListReport(@ModelAttribute("bdmCmd") ReportBean bdmBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("bdmListReport");

	}
	@RequestMapping(value ="/generateBdmListReport", method = RequestMethod.GET)
	public  ModelAndView generateBdmListReport(@ModelAttribute("bdmCmd") ReportBean bdmBean, HttpServletRequest request,HttpServletResponse response) {
			
			String bmId=bdmBean.getReportId() ;
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
			
					
					parametrs.put("bmId", bmId);
					
				
					
					
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/bmList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** Break Down Maintainence Parent with Child Report ******************************** */
	@RequestMapping(value = "/bdmLogoReport", method = RequestMethod.GET)
	public ModelAndView bdmLogoReport(@ModelAttribute("bdmlCmd") ReportBean bdmlBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("bdmLogoReport");

	}
	
	@RequestMapping(value ="/generateBdmLogoReport", method = RequestMethod.GET)
	public  ModelAndView generateBdmLogoReport(@ModelAttribute("dnCmd") ReportBean dnBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String reportId=dnBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("bmId",reportId);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			  filePath = servletContext.getRealPath("/Resources/jrxml/breadownMaintainence/bmReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/breadownMaintainence/bmChild.jasper");
			  printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** Break Down Maintainence Parent with Child Report ******************************** */
	@RequestMapping(value = "/productionOrderReport", method = RequestMethod.GET)
	public ModelAndView productionOrderReport(@ModelAttribute("porCmd") ReportBean porBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("productionOrderReport");

	}
	
	@RequestMapping(value ="/generateProductionOrderReport", method = RequestMethod.GET)
	public  ModelAndView generateProductionOrderReport(@ModelAttribute("porCmd") ReportBean porBean,HttpServletRequest request,HttpServletResponse response) {
			
	
		String reportId=porBean.getReportId();
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("poId",reportId);
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoID", userId);
					//Set Date Pattern
					datePattern=dateService.getDatePattern().getConPattern();
					parametrs.put("datePattern",datePattern);
				// 2. Retrieve template
			  filePath = servletContext.getRealPath("/Resources/jrxml/ProductionOrderReport/getPOReport.jrxml");
			  rootPath=servletContext.getRealPath("/Resources/jrxml/ProductionOrderReport/poProcessLine.jasper");
			  printPath = servletContext.getRealPath("/reportApplet/jrprint");
			 parametrs.put("rootPath", rootPath);
		
			//Method for Generating Report
			 generateReport(request,parametrs);
					                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** Holidays List Report ******************************** */
	@RequestMapping(value = "/holidaysListReport", method = RequestMethod.GET)
	public ModelAndView holidaysListReport(@ModelAttribute("hCmd") ReportBean hBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("holidaysListReport");
	}
	
	@RequestMapping(value ="/generateHolidayListReport", method = RequestMethod.GET)
	public  ModelAndView generateHolidayListReport(@ModelAttribute("hCmd") ReportBean hBean, HttpServletRequest request,HttpServletResponse response) {
			
			String year=hBean.getReportId() ;
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				parametrs.put("year", year);
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/holidayList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** BirthDay List Report ******************************** */
	@RequestMapping(value = "/birthDayListReport", method = RequestMethod.GET)
	public ModelAndView birthDayListReport(@ModelAttribute("bCmd") ReportBean bBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("birthDayListReport");
	}
	@RequestMapping(value ="/generateBirthDayListReport", method = RequestMethod.GET)
	public  ModelAndView generateBirthDayListReport(@ModelAttribute("bCmd") ReportBean bBean, HttpServletRequest request,HttpServletResponse response) {
			
			String orgId=bBean.getReportId() ;
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				parametrs.put("orgId", orgId);
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/birthDayList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** Asset List Report ******************************** */
	@RequestMapping(value = "/assetListReport", method = RequestMethod.GET)
	public ModelAndView assetListReport(@ModelAttribute("aCmd") ReportBean aBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("assetListReport");
	}
	@RequestMapping(value ="/generateAssetListReport", method = RequestMethod.GET)
	public  ModelAndView generateAssetListReport(@ModelAttribute("aCmd") ReportBean aBean, HttpServletRequest request,HttpServletResponse response) {
			
			String assetId=aBean.getReportId() ;
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				parametrs.put("assetId", assetId);
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/assetList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** Agreement List Report ******************************** */
	@RequestMapping(value = "/agreementListReport", method = RequestMethod.GET)
	public ModelAndView agreementListReport(@ModelAttribute("agCmd") ReportBean agBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("agreementListReport");
	}
	
	@RequestMapping(value ="/generateAgreementListReport", method = RequestMethod.GET)
	public  ModelAndView generateAgreementListReport(@ModelAttribute("agCmd") ReportBean agCmd, HttpServletRequest request,HttpServletResponse response) {
			
			String agreementId=agCmd.getReportId() ;
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				if(agreementId !=""){
					parametrs.put("agreementId", agreementId);
				}
				else {
				parametrs.put("agreementId", null);
				}
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/agreementListReport.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** Agreement Line Report ******************************** */
	@RequestMapping(value = "/agreementLineReport", method = RequestMethod.GET)
	public ModelAndView agreementLineReport(@ModelAttribute("alCmd") ReportBean alBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("agreementLineReport");
	}
	
	@RequestMapping(value ="/generateAgreementLineReport", method = RequestMethod.GET)
	public  ModelAndView generateAgreementLineReport(@ModelAttribute("alCmd") ReportBean alCmd, HttpServletRequest request,HttpServletResponse response) {
			
			String agreementId=alCmd.getReportId() ;
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				if(agreementId !=""){
					parametrs.put("agreementId", agreementId);
				}
				else {
				parametrs.put("agreementId", null);
				}
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/agreementLineReport.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** Inspection Lot Result Report ******************************** */
	@RequestMapping(value = "/inspectionLotResultReport", method = RequestMethod.GET)
	public ModelAndView inspectionLotResultReport(@ModelAttribute("iLRCmd") ReportBean iLRCmd,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("inspectionLotResultReport");
	}
	
	@RequestMapping(value ="/generateInspectionLotResultReport", method = RequestMethod.GET)
	public  ModelAndView generateInspectionLotResultReport(@ModelAttribute("iLRCmd") ReportBean iLRCmd, HttpServletRequest request,HttpServletResponse response) {
			
			String inspLId=iLRCmd.getReportId() ;
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				if(inspLId !=""){
					parametrs.put("inspLRId", inspLId);
				}
				else {
				parametrs.put("inspLRId", null);
				}
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/inspectionLotResultList.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	/* ********************************** Employee Advance Reciept ******************************** */
	@RequestMapping(value = "/empAdvanceRecieptReport", method = RequestMethod.GET)
	public ModelAndView empAdvanceRecieptReport(@ModelAttribute("emparCmd") ReportBean emparBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("empAdvanceRecieptReport");
	}
	
	@RequestMapping(value ="/generateEmparReport", method = RequestMethod.GET)
	public  ModelAndView generateEmparReport(@ModelAttribute("emparCmd") ReportBean emparBean, HttpServletRequest request,HttpServletResponse response) {
			
			String empId=emparBean.getReportId() ;
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				if(empId !=""){
					parametrs.put("empId", empId);
				}
				else {
				parametrs.put("empId", null);
				}
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/empAdvanceReciept.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
	
	/* ********************************** Employee Advance Payment ******************************** */
	@RequestMapping(value = "/empAdvancePaymentReport", method = RequestMethod.GET)
	public ModelAndView empAdvancePaymentReport(@ModelAttribute("empapCmd") ReportBean empapBean,HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("empAdvancePaymentReport");
	}
	
	@RequestMapping(value ="/generateEmpapReport", method = RequestMethod.GET)
	public  ModelAndView generateEmpapReport(@ModelAttribute("empapCmd") ReportBean empapBean, HttpServletRequest request,HttpServletResponse response) {
			
			String empId=empapBean.getReportId() ;
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
				if(empId !=""){
					parametrs.put("empId", empId);
				}
				else {
				parametrs.put("empId", null);
				}
				//Get the user Id for displaying logo 
				session =request.getSession(false);
				userId=session.getAttribute("userId").toString();
				parametrs.put("logoID", userId);
				
				//Set Date Pattern
				datePattern=dateService.getDatePattern().getConPattern();
				parametrs.put("datePattern",datePattern);
				
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/empAdvancePayment.jrxml");
			 printPath = servletContext.getRealPath("/reportApplet/jrprint");	
			
			 //Method for Generating Report
			 generateReport(request,parametrs);
		                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return new ModelAndView("reportViewer");
		}
/* ********************************** Batch Report ******************************** */
	
	/*@RequestMapping(value = "/batchReport", method = RequestMethod.GET)
	public ModelAndView batchReport(HttpServletResponse response,HttpServletRequest request) {
		response.setCharacterEncoding("UTF-8");

		return new ModelAndView("batchReport");

	}	
	@RequestMapping(value ="/generateBatchReport", method = RequestMethod.GET)
	public  ModelAndView generateBatchReport(HttpServletRequest request,HttpServletResponse response) {
			
		
			String materialids=request.getParameter("materialids");
			String vendoId=request.getParameter("vendor_Id");
		
			
			try {
				// 1. Add report parameters
				HashMap<String, Object> parametrs= new HashMap<String, Object>(); 
					parametrs.put("materialId", Integer.parseInt(materialids));
					parametrs.put("vendorId", Integer.parseInt(vendoId));
					
					//Get the user Id for displaying logo 
					session =request.getSession(false);
					userId=session.getAttribute("userId").toString();
					parametrs.put("logoId", userId);
					
				// 2. Retrieve template
			 filePath = servletContext.getRealPath("/Resources/jrxml/GoodsGetQtyReport.jrxml");
			 //String rootPath1=servletContext.getRealPath("/Resources/jrxml/RFQ/");
			  
				 //rootPath=rootPath1+"\\";
			 //parametrs.put("rootPath", rootPath);
		
				 jrFile=new File(filePath);
			
				// 3. Convert template to JasperDesign
			 jd = JRXmlLoader.load(jrFile);

				// 4. Compile design to JasperReport
				 jr = JasperCompileManager.compileReport(jd);
				
						// 5. Create the JasperPrint object
						// Make sure to pass the JasperReport, report parameters, and data source
						 connection=dataSource.getConnection();
						 jp = JasperFillManager.fillReport(jr, parametrs, connection);
						//JasperPrint jp = JasperFillManager.fillReport(jr, parametrs);
						
						
						// 6. View the report in Jasper Viewer
						JasperViewer.viewReport(jp, false);
					
						
						
				                                  
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			
			
			return new ModelAndView("batchReport");
		}*/
	
	

	
/* ************************************************************************************* */
	/* ***************************************Select box ************************************ */
	
//getting Purchase Order Number Model Attribute
	@ModelAttribute("pendingGoods")
	public Map<Integer, String> pendingGoodsPO() {
		
			String sql="select p.purchaseOrderId,p.purchaseOrderNo from PurchaseOrder p";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			
			/*Iterator iter = map.entrySet().iterator();
			 
			while (iter.hasNext()) {
				Map.Entry mEntry = (Map.Entry) iter.next();
				System.out.println(mEntry.getKey() + " : " + mEntry.getValue());
			}*/
		return map;
	}
	
//getting Material Id model Attribute
		@ModelAttribute("getMaterialOrder")
		public Map<Integer, String> gettobeMaterialOrder() {
			
				String sql="select m.material_Id,m.materialName from Material m";
				Map<Integer, String> map = populateService.populateSelectBox(sql);
				
			return map;
		}
		
		//Purchase Requisition 
		@ModelAttribute("purchaseReq")
		public Map<Integer, String> getPurchaseReq() {
			
				String sql="select p.purchaseReq_Id,p.purchaseReqNo from PurchaseReq p";
				Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//RFQ
		@ModelAttribute("rfq")
		public Map<Integer, String> getRfq() {
			
				String sql="select r.rfqid,r.rfqNo from RfqBean r";
				Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//Quotation
		@ModelAttribute("quo")
		public Map<Integer, String> getQuotation() {
			
				String sql="select q.quotationId,q.quotationNo from Quotation q";
				Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//Purchase Order
		@ModelAttribute("po")
		public Map<Integer, String> getPurchaseOrder() {
			
			String sql="select p.purchaseOrderId,p.purchaseOrderNo from PurchaseOrder p";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
		return map;
		}
		//Sales Inquiry
		@ModelAttribute("si")
		public Map<Integer, String> getSI() {
			
			String sql="select si.salesInquiryId,si.salesInquiryNo from SalesInquiryBean si";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
		return map;
		}
		//Sales Order
		@ModelAttribute("so")
		public Map<Integer, String> getSO() {
			
			String sql="select so.salesOrderId,so.salesOrderNo from SalesOrderBean so";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
		return map;
		}
		//Sales Purchase Order
		@ModelAttribute("spo")
		public Map<Integer, String> getSPO() {
			
			String sql="select spo.salesPOId,spo.salesPONbr from SalesPurchaseOrderBean spo";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
		return map;
		}
		//Sales Quotation
		@ModelAttribute("sqo")
		public Map<Integer, String> getSQO() {
			
			String sql="select sqo.salesQuotationId,sqo.salesQuotationNo from SalesQuotationBean sqo";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
		return map;
		}
		
		//payement Voucher
		@ModelAttribute("voucher")
		public Map<Integer, String> getVoucher() {
					
			String sql="select vo.voucherId,vo.voucherNo from Voucher vo";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		
		//storageLocation
		@ModelAttribute("sl")
		public Map<Integer, String> getStorageLocation() {
							
					String sql="select sl.storageLocationId,sl.storageLocation from StorageLocation sl";
					Map<Integer, String> map = populateService.populateSelectBox(sql);
					return map;
				}
		//CustomerReturn
		@ModelAttribute("customerReturn")
		public Map<Integer, String> getCustomerReturn() {
							
					String sql="select cr.customerReturnId,cr.customerReturnNo from CustomerReturn cr";
					Map<Integer, String> map = populateService.populateSelectBox(sql);
					return map;
				}
		//CustomerReturn
		@ModelAttribute("vendorReturn")
		public Map<Integer, String> getVendorReturn() {
									
			String sql="select vr.vendorReturnId,vr.vendorReturnNo from VendorReturn vr";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//Physical Verification
		@ModelAttribute("physicalVerification")
		public Map<Integer, String> getPhysicalVerification() {
									
			String sql="select pv.verificationId,pv.verificationNo from physicalVerification pv";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//Stock Transfer
		@ModelAttribute("stockTransfer")
		public Map<Integer, String> getStockTransfer() {					
			String sql="select st.stockTransferId,st.stockTransferNo from StockTransferBean st";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		
		//Production Order
		@ModelAttribute("productionOrder")
		public Map<Integer, String> getProductionOrder() {					
			String sql="select po.prodOrderId,po.prodOrderNo from ProductionOrderBean po";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//Vendor Invoice
		@ModelAttribute("vendorInvoice")
		public Map<Integer, String> getVendorInvoice() {					
			String sql="select vi.vendorinvoiceid,vi.vendorinvoiceno from VendorInvoice vi";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//Customer Invoice
		@ModelAttribute("customerInvoice")
		public Map<Integer, String> getCustomerInvoice() {					
			String sql="select ci.customerinvoiceid,ci.customerinvoiceno from CustomerInvoice ci";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//Customer 
		@ModelAttribute("customer")
		public Map<Integer, String> getCustomerName() {					
			String sql="select c.customerId,c.customerName from CustomerBean c";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//Vendor 
		@ModelAttribute("vendor")
		public Map<Integer, String> getVendorName() {					
			String sql="select v.vendorId,v.vendorName from Vendor v";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		
		//InspectionLotOrigin
		@ModelAttribute("inseptionLotOrigin")
		public Map<Integer, String> getInspetionLotOrginNo() {					
			String sql="select i.insplotoriginId,i.insplotorigin from InsplotOrigin i";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//shift
		@ModelAttribute("shift")
		public Map<Integer, String> getShift() {					
			String sql="select i.shiftId,i.shift from ShiftBean i";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//Organization 
		@ModelAttribute("org")
		public Map<Integer, String> getOrganization() {					
			String sql="select i.orgId,i.orgName from Organization i";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//monthList 
		@ModelAttribute("months")
		public Map<Integer, String> getMonths() {					
			
			Map<Integer, String> map = new HashMap<Integer, String>();
			map.put(1, "January");map.put(2, "February");
			map.put(3, "March");map.put(4, "April");map.put(5, "May");map.put(6, "June");map.put(7, "July");map.put(8, "Auguest");map.put(9, "September");map.put(10, "October");map.put(11, "November");map.put(12, "December");
			
			return map;
		}
		//Organization 
		@ModelAttribute("vacancy")
		public Map<Integer, String> getVacancy() {					
			String sql="select i.vacancyId,i.vacancyNo from Vacancy i";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
		//BreakDown 
		@ModelAttribute("bm")
		public Map<Integer, String> getBreakDown() {					
			String sql="select i.breakdownMaintenace_Id,i.breakDownNo from BreakDownMaintenance i";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
	//BreakDown 
	@ModelAttribute("bml")
	public Map<Integer, String> getBreakDownLogo() {					
		String sql="select i.brkdownMaintenaceLogId,i.logNo from BreakDownMaintenanceLog i";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
	}
	
	/*//AssetList 
	@ModelAttribute("asset")
	public Map<Integer, String> getAssetList() {					
		String sql="select i.assetid,i.serialNumber from AssetBean i";
			Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
	}*/
	
	//Aggrement 
	@ModelAttribute("aggrement")
	public Map<Integer, String> getaggrement() {					
		String sql="select i.agreementId,i.agreementNo from Agreement i";
		Map<Integer, String> map = populateService.populateSelectBox(sql);
			return map;
		}
	
	//Aggrement 
	@ModelAttribute("inspLotNot")
	
	public Map<Integer, String> getinspLotNot() {					
	 String sql="select i.inspLotNoId,i.inspLotNo from InspectionLotBean i";
		Map<Integer, String> map = populateService.populateSelectBox(sql);
		return map;
	}
	
	//Employee 
	@ModelAttribute("employee")
	public Map<Integer, String> getEmpName() {					
	    String sql="select i.employee_Id,i.fName from Employee i";
		Map<Integer, String> map = populateService.populateSelectBox(sql);
		return map;
		}
}
	