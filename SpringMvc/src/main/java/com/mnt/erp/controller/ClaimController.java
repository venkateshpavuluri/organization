/**
 * 
 */
package com.mnt.erp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mnt.erp.bean.ClaimBean;
import com.mnt.erp.bean.ClaimDocumentsBean;
import com.mnt.erp.bean.ClaimTypeBean;
import com.mnt.erp.bean.Employee;
import com.mnt.erp.bean.Project;
import com.mnt.erp.bean.ProjectTask;
import com.mnt.erp.bean.ProjectTaskDocument;
import com.mnt.erp.bean.ProjectTaskResource;
import com.mnt.erp.bean.Status;
import com.mnt.erp.daojar.ERPDao;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.ClaimService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.PopulateService;
import com.mnt.erp.service.XmlLabelsService;

/**
 * @author devi
 *
 */
@Controller
public class ClaimController {
	@Autowired
	PopulateService populateService;
	@Autowired
	XmlLabelsService xmlService;
	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;
	@Autowired
	ERPDao erpDao;
	@Autowired
	ServletContext servletContext;
	@Autowired
	ClaimService clService;
	
	String msg;
	List<Object[]> list=null;
	MultipartFile[] file = null;
	ClaimDocumentsBean claimDocument = null;
	File filePath;
	String filePathToGraphsDir = null, filePathToGraphsDir1 = null;
	
	@RequestMapping(value = "/claimHome", method = RequestMethod.GET)
	public String claimHome(
			@ModelAttribute("Claim") ClaimBean ptask,
			HttpServletResponse response, Model model,
			HttpServletRequest request) {
			response.setCharacterEncoding("UTF-8");
		return "claimHome";
	}

	
	@RequestMapping(value = "/saveClaim", method = RequestMethod.POST)
	public String SaveClaim(@ModelAttribute("Claim") ClaimBean claim,
			HttpServletResponse response, Model model,
			HttpServletRequest request,
			@RequestParam("file") MultipartFile[] file1) {
		response.setCharacterEncoding("UTF-8");
		String[] documentPath = null;
		ClaimDocumentsBean cdoc=null;
		Set<ClaimDocumentsBean> cdocSet=null;
				
		String result = null;
		HttpSession session = null;
        String msg=null;
		String resumesFile, originalPath = null;

		try {
        
			cdocSet = new HashSet<ClaimDocumentsBean>();
			session = request.getSession(false);
			for (int i = 0; i < file1.length; i++) {

				resumesFile = servletContext.getRealPath("/claimDocuments");
				Date date = new Date();
				String dt = date.getYear() + date.getMonth() + date.getDay()
						+ date.getHours() + date.getMinutes()
						+ date.getSeconds() + "" + System.currentTimeMillis()
						+ file1[0].getOriginalFilename();
				originalPath = resumesFile + "\\" + dt;
				
				InputStream inputStream = file1[0].getInputStream();

				java.io.OutputStream outputStream = new FileOutputStream(
						new File(originalPath));
				int read1 = 0;
				byte[] bytes1 = new byte[1024];

				while ((read1 = inputStream.read(bytes1)) != -1) {
					outputStream.write(bytes1, 0, read1);
				}
				outputStream.flush();
				inputStream.close();
				outputStream.close();
				cdoc = new ClaimDocumentsBean();
		
				cdoc.setDocumentPath(originalPath);
				cdocSet.add(cdoc);
				

			}
			claim.setClaimDocDetails(cdocSet);
			session = request.getSession(false);
			msg = clService.saveClaim(claim, session.getAttribute("userId").toString(), session
							.getAttribute("userName").toString());

			if (msg.equals("S")) {
				result = "redirect:claimHome.mnt?list=" + "success" + "";

			} else {
				result = "redirect:claimHome.mnt?listwar=" + "fail" + "";
			}

		} catch (Exception e) {
			result = "redirect:claimHome.mnt?listwar=" + "fail" + "";
			e.printStackTrace();
		}

		return result;
	}
	@RequestMapping(value = "/claimSearch", method = RequestMethod.GET)
	public String searchClaim(
			@ModelAttribute("Claim") ClaimBean claim,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		Iterator<Object[]> iterator = null;
		ClaimBean claimDetails = null;
		List<ClaimBean> listofclaims = null;
		try {
			int iid = claim.getClaimId();

			String dbField = claim.getXmlLabel();
			String operation = claim.getOperations();
			String basicSearchId = claim.getBasicSearchId();
			listofclaims = new ArrayList<ClaimBean>();

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
				list = clService.searchClaim();
				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					claimDetails= new ClaimBean();
					claimDetails.setClaimId((Integer) obj[0]);
					ClaimTypeBean cBean=((ClaimTypeBean) obj[1]);
					claimDetails.setClaimTypeName(cBean.getClaimType());
					claimDetails.setClaimNo((String) obj[2]);
					Employee eBean=((Employee) obj[3]);
					claimDetails.setEmpName(eBean.getfName());
					claimDetails.setAmount((String) obj[4]);
					Status sBean=((Status) obj[5]);
					claimDetails.setStatusName(sBean.getStatus());
					claimDetails.setDescription((String) obj[6]);
                    listofclaims.add(claimDetails);
					
					
				}

			} else {

				list = clService.basicSearchClaim(dbField, operation, basicSearchId);

				iterator = list.iterator();
				while (iterator.hasNext()) {
					Object[] obj = (Object[]) iterator.next();
					claimDetails= new ClaimBean();
					claimDetails.setClaimId((Integer) obj[0]);
					ClaimTypeBean cBean=((ClaimTypeBean) obj[1]);
					claimDetails.setClaimTypeName(cBean.getClaimType());
					claimDetails.setClaimNo((String) obj[2]);
					Employee eBean=((Employee) obj[3]);
					claimDetails.setEmpName(eBean.getfName());
					claimDetails.setAmount((String) obj[4]);
					Status sBean=((Status) obj[5]);
					claimDetails.setStatusName(sBean.getStatus());
					claimDetails.setDescription((String) obj[6]);
                    listofclaims.add(claimDetails);
           
				}
			}
			
			request.setAttribute("listofclaims", listofclaims);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return "claimHome";
	}
	@RequestMapping(value = "/claimEditHome", method = RequestMethod.GET)
	public String editClaim(@ModelAttribute("Claim") ClaimBean claim,
			BindingResult result, HttpServletRequest request, Model model,
			HttpServletResponse response) {

		int claimId = 0;
		response.setCharacterEncoding("UTF-8");
		Iterator<ClaimBean> iterator = null;
		Set<ClaimDocumentsBean> listOfclaims = null;
		Iterator<ClaimDocumentsBean> claimIterator = null;
		
		List<ClaimBean> claimforchildEdit = null;
		List<ClaimBean> claimDetails = null;
		
		String cdoc = null;

		try {
			claimId=Integer.parseInt(request.getParameter(("claimEditId")));
			claimforchildEdit=new ArrayList<ClaimBean>();
			claimDetails=clService.editClaimDetails(claimId);
			listOfclaims=new HashSet<ClaimDocumentsBean>();
			iterator=claimDetails.iterator();
			

			while (iterator.hasNext()) {

				ClaimBean obj = (ClaimBean) iterator.next();
				
				claim.setClaimId(obj.getClaimId());
				claim.setClaimTypeId(obj.getClaimTypeId());
				claim.setClaimNo(obj.getClaimNo());
				claim.setEmployeeId(obj.getEmployeeId());
				claim.setAmount(obj.getAmount());
				claim.setStatusId(obj.getStatusId());
				claim.setDescription(obj.getDescription());
				
				listOfclaims=obj.getClaimDocDetails();
				claimIterator=listOfclaims.iterator();
				

				while (claimIterator.hasNext()) {
					ClaimDocumentsBean claimdocLine=(ClaimDocumentsBean) claimIterator.next();
					ClaimBean claimBean=new ClaimBean();
					claimBean.setClaimDocId(claimdocLine.getClaimDocId());
					String [] docPath=claimdocLine.getDocumentPath().split(",");
					claimBean.setDocumentPath(docPath[docPath.length-1]);
					claimforchildEdit.add(claimBean);

				}
			}
			

			request.setAttribute("editvalues", "");
			request.setAttribute("claimDocumentsValues", claimforchildEdit);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "claimHome";

	}
	@RequestMapping(value = "/updateClaim", method = RequestMethod.POST)
	public String claimUpdate(
			@ModelAttribute("Claim") ClaimBean claim, Model model,
			HttpServletRequest request, HttpServletResponse response,
			@RequestParam("file") MultipartFile file1) {
		response.setCharacterEncoding("UTF-8");

		String msg = null;

		String checked = "", s2 = "1";
		int ss = 0;
		ClaimDocumentsBean claimDetailLine = null;
		Set<ClaimDocumentsBean> claimDetailLines = null;
		List<ClaimDocumentsBean> childDelete = null;
		String dbResumePath = null;

		try {
			childDelete = new ArrayList<ClaimDocumentsBean>();
			claimDetailLines = new HashSet<ClaimDocumentsBean>();
			claim.setClaimId(claim.getClaimId());
			claim.setClaimTypeId(claim.getClaimTypeId());
			claim.setClaimNo(claim.getClaimNo());
			claim.setEmployeeId(claim.getEmployeeId());
			claim.setAmount(claim.getAmount());
			claim.setStatusId(claim.getStatusId());
			claim.setDescription(claim.getDescription());
			
			
			childDelete = new ArrayList<ClaimDocumentsBean>();
			

			String[] claimDocId = String.valueOf(claim.getClaimDocId()).split(",");
				
			String[] claimDocPath = claim.getDocumentPath().split(",");
			System.out.println("doc length ==== "+claimDocPath.length);	
			for (int i = 0; i <= claimDocPath.length; i++) {
				int cDocId = Integer.parseInt(claimDocId[i]);

				if (cDocId == 0) {
					ClaimDocumentsBean document = new ClaimDocumentsBean();
					document.setClaimDocId(Integer.valueOf(claimDocId[i]));
					System.out.println("file "+file1);
					if (file1.getBytes().length > 0) {
						InputStream inputStream = file1.getInputStream();
						String resumesFile = servletContext
								.getRealPath("/claimDocuments");
						Date date = new Date();
						String dt = date.getYear() + date.getMonth()
								+ date.getDay() + date.getHours()
								+ date.getMinutes() + date.getSeconds() + ""
								+ System.currentTimeMillis();
						String originalPath = resumesFile + "\\" + dt + ".txt";

						java.io.OutputStream outputStream = new FileOutputStream(
								new File(originalPath));
						int read = 0;
						byte[] bytes = new byte[1024];

						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
						outputStream.flush();
						inputStream.close();
						outputStream.close();
						dbResumePath = originalPath;

					} else {
						dbResumePath = claimDocPath[i];
					}
					document.setDocumentPath(dbResumePath);
					claimDetailLines.add(document);
				}

				else {

					ClaimDocumentsBean document = new ClaimDocumentsBean();
					document.setClaimDocId(Integer.valueOf(claimDocId[i]));
					
					
					if (file1.getBytes().length > 0) {
						InputStream inputStream = file1.getInputStream();
						String resumesFile = servletContext
								.getRealPath("/claimDocuments");
						Date date = new Date();
						String dt = date.getYear() + date.getMonth()
								+ date.getDay() + date.getHours()
								+ date.getMinutes() + date.getSeconds() + ""
								+ System.currentTimeMillis();
						String originalPath = resumesFile + "\\" + dt + ".txt";

						java.io.OutputStream outputStream = new FileOutputStream(
								new File(originalPath));
						int read = 0;
						byte[] bytes = new byte[1024];

						while ((read = inputStream.read(bytes)) != -1) {
							outputStream.write(bytes, 0, read);
						}
						outputStream.flush();
						inputStream.close();
						outputStream.close();
						dbResumePath = originalPath;

					} else {
						dbResumePath = claimDocPath[i];
					}
					document.setDocumentPath(dbResumePath);
					
					String checkDoc = null;

					ss = Integer.parseInt(claimDocId[i]);
				
					checked = request.getParameter("Checkdelete" + ss);

					
					String[] checkPrevious = claim.getCheckPrevious()
							.split(",");
					
					if (checkPrevious != null) {
						for (int l = 0; l < checkPrevious.length; l++) {
							if (checkPrevious[l].equals("1")) {

								checkDoc = request.getParameter(claimDocId[i]
												+ "Checkdelete");
								
								if (checkDoc.equals("0")) {
									claimDetailLines.add(document);

								}
								if (checkDoc.equals("1")) {

									ClaimDocumentsBean document2 = new ClaimDocumentsBean();
									document2.setClaimDocId(Integer.parseInt(claimDocId[i]));
									
									childDelete.add(document2);
								}
							}

						}
					}
					

					claim.setClaimDocDetails(claimDetailLines);
										

				}
			}
			clService.deleteChildRecords(childDelete);
			msg=clService.updateClaimDetails(claim);

			if (msg.equals("S")) {
				request.setAttribute("claimUpdate",
						"Claim Details Updated Successfully");
			} else {
				request.setAttribute("claimUpdateErr",
						"Claim Details is not updated properly");
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("Claim", new ClaimBean());
		return "claimHome";
	}
	@RequestMapping(value = "/claimDelete", method = RequestMethod.GET)
	public String deleteClaim(
			@ModelAttribute("Claim") ClaimBean claim,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		try {
			int deleId = Integer.parseInt(request.getParameter("claimDeleteId"));
			HttpSession session = null;
			msg = clService.deleteClaim(deleId);

			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "claim", "ROW", String
						.valueOf(deleId), "1", modifiedDate, session
						.getAttribute("userName").toString());

				request.setAttribute("claimDel",
						"Claim Details Deleted Successfully");
			} else {
				request.setAttribute("claimDelErr",
						"Claim Data is not deleted properly");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "claimHome";
	}
	@ModelAttribute("ClaimTypeIds")
	public Map<Integer, String> populatClaimTypeIds() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = clService.getClaimTypeIds();
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

	@ModelAttribute("EmployeeIds")
	public Map<Integer, String> populatEmployeeIds() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = clService.getEmployeeIds();
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
	@ModelAttribute("StatusIds")
	public Map<Integer, String> populatStatusIds() {
		List<Object[]> list = null;
		Iterator<Object[]> iterator = null;
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = clService.getStatusIds();
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

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "claim";

		Map<String, String> map = new LinkedHashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

}
