package com.mnt.erp.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.DefaultSessionAttributeStore;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.AccountGroupBean;
import com.mnt.erp.bean.PaymentMethod;
import com.mnt.erp.bean.PaymentTerms;
import com.mnt.erp.bean.Vendor;
import com.mnt.erp.bean.VendorAccountDetails;
import com.mnt.erp.bean.VendorBankDet;
import com.mnt.erp.bean.VendorDocuments;
import com.mnt.erp.bean.VendorMaterial;
import com.mnt.erp.service.AuditLogService;
import com.mnt.erp.service.CountryService;
import com.mnt.erp.service.CustomerService;
import com.mnt.erp.service.MaterialService;
import com.mnt.erp.service.MenuService;
import com.mnt.erp.service.VendGroupService;
import com.mnt.erp.service.VendorService;
import com.mnt.erp.service.XmlLabelsService;

@Controller
@Scope("request")
public class VendorController {

	@Autowired
	VendorService categoryService;

	@Autowired
	ServletContext servletContext;

	@Autowired
	CountryService countryService;

	@Autowired
	MaterialService materialService;

	@Autowired
	CustomerService customerService;

	@Autowired
	VendGroupService vendorGroupService;
	@Autowired
	XmlLabelsService xmlService;

	@Autowired
	MenuService menuService;
	@Autowired
	AuditLogService auditLogService;

	HttpSession session;

	private static final int BUFFER_SIZE = 4096;
	VendorDocuments vendorDocument = null;
	VendorBankDet vendorBankDet = null;
	VendorMaterial vendorMaterial = null;
	Vendor vendor = null;
	Map<Integer, String> map = null;
	List<Object[]> list = null;
	Iterator<Object[]> iterator = null;
	Iterator<Object[]> iteratorMaterialName = null;
	Object[] objects = null;
	String pathValue = null;
	String[] names = null;
	String filePathToGraphsDir = null, filePathToGraphsDir1 = null;
	File downloadFile = null;
	FileInputStream inputStream = null;
	String mimeType = null;
	String headerKey = null;
	String headerValue = null;
	OutputStream outStream = null;
	byte[] buffer = null;
	int bytesRead = 0;
	int msa = 0, msa2 = 0, msa3 = 0;
	int msa1 = 0;
	Vendor bom2 = null;
	String vendorUpadte = null;
	List<String> listString = null;
	String countryname = null;
	String[] bankName = null;
	String[] bankAddress = null;
	String[] ifscCode = null;
	String[] micrCode = null;
	String[] accountNumber = null;
	String[] accountType = null;

	List<VendorBankDet> venderBankDetailsList = null;
	List<VendorAccountDetails> venderAccountList = null;

	Long vendorNameDublicate = null;
	String matrialId = null;
	int materialHiddenAdd = 0;
	String documentName[] = null;
	MultipartFile[] file = null;
	VendorBankDet v1 = null;
	VendorAccountDetails vendorAccount = null;
	VendorDocuments vendorDocuments = null;
	File filePath;
	String fileName = "";
	MultipartFile[] multipartFile = null;
	InputStream inputStreamAdd = null;
	OutputStream outputStreamAdd = null;
	int read = 0;
	byte[] bytes = null;
	List<Vendor> vendor1 = null;
	String name = null;
	Vendor mm = null;
	Object[] objects2 = null;
	Object[] objectsMaterial = null;
	List<Object[]> objectsArray = null;
	int id = 0;

	List<Object[]> list2 = null, list3 = null, list4 = null, list5 = null;
	Object[] objects1 = null;
	Object[] objects3 = null;

	List<Vendor> vendorList = null;
	Iterator<Object[]> iteratorBank = null;
	List<VendorBankDet> vendorBankDetList = null;
	Iterator<Object[]> iteratorDocument = null;
	List<VendorDocuments> vendorDocumentsList = null;
	Iterator<Object[]> iteratorMatrial = null, iteratorAccount = null;

	List<VendorMaterial> vendorMaterialList = null;
	List<VendorAccountDetails> vendorAccountList = null;
	int[] vendorBankDetIdEdit = null;
	String vendorCheckValue = null;
	String vendorCheckValue_1 = null;
	Long count = null;
	String[] documentNameEdit = null;
	String[] documentPath = null;
	int[] vendorDocIdEdit = null;
	int[] vendorDocId = null;
	String checkDoc = null, msg = null;
	String checkPrevious[] = null;
	String vendorCheckDocValue = null;
	String[] checkMaterial = null;
	int matrialIdEdit[] = null;

	int vendorMatIdEdit[] = null;
	String vendorCheckMaterial = "";

	@RequestMapping(value = "/vendor", method = RequestMethod.GET)
	public ModelAndView getVendor(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		List<String> list = menuService.getPrivilige("vendor.mnt", session
				.getAttribute("userId").toString());
		session.setAttribute("privilegeList", list);
		return new ModelAndView("vendorHome", "vendorForm", new Vendor());
	}

	@ModelAttribute("country")
	public Map<Integer, String> populateCountry() {
		map = new HashMap<Integer, String>();
		try {
			list = countryService.getCountryIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("customerIdDetails")
	public Map<Integer, String> populateCustomerId() {
		map = new HashMap<Integer, String>();
		try {
			list = customerService.getCustomerIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("vendorGroupIdDetails")
	public Map<Integer, String> populateVendorGroupId() {
		map = new HashMap<Integer, String>();
		try {
			list = vendorGroupService.getVendorGroupIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("AccGroupSelect")
	public Map<Integer, String> selectAccountGroupBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = categoryService.selectAccountGroupIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("PaymentTermSelect")
	public Map<Integer, String> selectPTBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = categoryService.selectPaymentTermIds();
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("PaymentMethodSelect")
	public Map<Integer, String> selectPMBox() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = categoryService.selectPaymentMethodIds("PaymentMethod");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ModelAttribute("statusId")
	public Map<Integer, String> selectStatusId() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		try {
			list = categoryService.selectPaymentMethodIds("statusId");
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void doDownload(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		pathValue = request.getParameter("id");
		names = pathValue.split("/");
		filePathToGraphsDir = servletContext.getRealPath("/VendorId");

		filePathToGraphsDir = filePathToGraphsDir + "\\"
				+ names[names.length - 2] + "\\" + names[names.length - 1];
		filePathToGraphsDir1 = filePathToGraphsDir.replace('\\', '/');
		downloadFile = new File(filePathToGraphsDir1);
		inputStream = new FileInputStream(downloadFile);
		mimeType = servletContext.getMimeType(filePathToGraphsDir);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		headerKey = "Content-Disposition";
		headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		outStream = response.getOutputStream();
		buffer = new byte[BUFFER_SIZE];
		bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inputStream.close();
		outStream.close();

	}

	@ModelAttribute("materialId")
	public Map<Integer, String> populateMaterialName() {
		map = new HashMap<Integer, String>();
		vendor = new Vendor();
		try {
			list = materialService.getMaterialName();
			iterator = list.iterator();
			// vendor.setMaterialPresent("yes");

			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				map.put((Integer) objects[0], (String) objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// countValueForMaterial++;
		return map;
	}

	@RequestMapping(value = "/vendorNameCheck", method = RequestMethod.POST)
	public @ResponseBody
	String checkVendorDuplicateAdd(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;

		try {

			String beforeCompareVendorName = request.getParameter("vendorName");
			vendorNameDublicate = categoryService
					.getVendorNameDuplicate(beforeCompareVendorName);

			if (vendorNameDublicate != 0) {
				vendor.setVendorAddDuplicate(1);
				request.setAttribute("vendorDuplicateAdd",
						"Warning ! @Vendor@ Duplicate values are not allowed");
				vendor.setVendorName("");
				msa = "Warning ! @Vendor@ Duplicate values are not allowed";
			}
			if (vendorNameDublicate == 0) {
				vendor.setVendorAddDuplicate(1);
				msa = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Vendor vendor = null;
		}
		return msa;
	}

	@RequestMapping(value = "/vendorNameCheckEdit", method = RequestMethod.POST)
	public @ResponseBody
	String checkVendorDuplicateEdit(HttpServletRequest request,
			HttpServletResponse response) {
		String msa = null;

		try {

			String beforeCompareVendorName = request
					.getParameter("vendorNameEdit");
			int id = Integer.parseInt(request.getParameter("vendorIdEdit"));
			vendorNameDublicate = categoryService
					.getVendorNameDuplicateForEdit(beforeCompareVendorName, id);

			if (vendorNameDublicate != 0) {
				vendor.setVendorAddDuplicate(1);
				msa = "Warning ! @Vendor@ Duplicate values are not allowed";
			}
			if (vendorNameDublicate == 0) {
				vendor.setVendorAddDuplicateEdit(1);
				msa = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Vendor vendor = null;
		}
		return msa;
	}

	@RequestMapping(value = "materialIdAuto", method = RequestMethod.POST)
	public @ResponseBody
	String populateMaterialNameAuto(HttpServletRequest request) {

		map = new HashMap<Integer, String>();
		vendor = new Vendor();
		JSONObject json = new JSONObject();
		String kk = "";
		String jsonText = null;
		try {

			list = materialService.getMaterialName(request
					.getParameter("materialIdAuto"));
			iterator = list.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();
				kk = kk + "{'Id':'" + (Integer) objects[0]
						+ "','MaterialName':'" + (String) objects[1] + "'},";
			}
			if (kk.length() > 2) {
				kk = kk.substring(0, kk.length() - 1);

				kk = "[" + kk + "]";
				kk = kk.replace("'", "\"");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return kk;
	}

	@RequestMapping(value = "/vendorAdd", method = RequestMethod.POST)
	public String saveVendor(@ModelAttribute("vendorForm") Vendor vendor,
			DefaultSessionAttributeStore store, WebRequest request1,
			HttpServletRequest request, HttpServletResponse response,
			SessionStatus status, Model model) {
		response.setCharacterEncoding("UTF-8");
		filePathToGraphsDir = servletContext.getRealPath("/VendorId");
		filePathToGraphsDir1 = filePathToGraphsDir.replace('\\', '/');

		String[] acGroup = vendor.getAcGroupId();
		String[] recnd = vendor.getReCondId();
		String[] payTerm = vendor.getPaymentTermId();
		String[] payMtd = vendor.getPaymentMethodId();

		try {
			vendorNameDublicate = categoryService.getVendorNameDuplicate(vendor
					.getVendorName());

			venderBankDetailsList = new ArrayList<VendorBankDet>();
			venderAccountList = new ArrayList<VendorAccountDetails>();

			if (vendorNameDublicate == 0) {
				msa = categoryService.setVendorSave(vendor);
				if (msa != 0) {
					Date date = new Date();
					session = request.getSession(false);
					String modifiedDate = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss").format(date);
					auditLogService.setAuditLogSave(
							session.getAttribute("userId").toString(), "A",
							"Vendor", "ROW", String.valueOf(msa), "1",
							modifiedDate, session.getAttribute("userName")
									.toString());

				}

				String[] bankName = vendor.getBankName();
				String[] bankAddress = vendor.getBankAddress();
				String[] ifscCode = vendor.getIfscCode();
				String[] micrCode = vendor.getMicrCode();
				String[] accountNumber = vendor.getAccountNumber();
				String[] accountType = vendor.getAccountType();
				if (bankName != null) {
					if (bankName.length != 0) {

						for (int i = 0; i < bankName.length; i++) {
							v1 = new VendorBankDet();

							v1.setVendorId(msa);
							v1.setBankName(bankName[i]);
							v1.setBankAddress(bankAddress[i]);
							v1.setIfscCode(ifscCode[i]);
							v1.setMicrCode(micrCode[i]);
							v1.setAccountType(accountType[i]);
							v1.setAccountNumber(accountNumber[i]);
							venderBankDetailsList.add(v1);
							// if(bankName[i]!="" || bankName[i]!=null)
							if (bankName[i].length() != 0
									&& vendorNameDublicate == 0) {
								msa1 = categoryService.setVendorBankDetSave(v1);

							}

						}
					} else {
						msa1 = 1;
					}
				}

				file = vendor.getFile();
				String[] documentName = vendor.getDocumentName();
				if (file != null && documentName != null) {
					if (file.length != 0 && documentName.length != 0) {

						for (int i = 0; i < file.length; i++) {
							vendorDocuments = new VendorDocuments();
							filePath = new File(filePathToGraphsDir1 + "//"
									+ msa);
							if (!filePath.exists()) {
								if (filePath.mkdir()) {

								}
							}
							// multipartFile = vendor.getFile();
							// for(int k=0;k<multipartFile.length;k++)
							// {
							fileName = file[i].getOriginalFilename();
							vendorDocuments.setVendorId(msa);
							vendorDocuments.setDocumentName(documentName[i]);
							vendorDocuments
									.setDocumentPath(filePathToGraphsDir1 + "/"
											+ msa + "/" + fileName);
							if (documentName[i].length() != 0
									&& vendorNameDublicate == 0) {
								msa3 = categoryService
										.setVendorDocumentsSave(vendorDocuments);
								try {
									inputStreamAdd = file[i].getInputStream();
									outputStreamAdd = new FileOutputStream(
											filePathToGraphsDir1 + "//" + msa
													+ "//" + fileName);
									read = 0;
									bytes = new byte[1024];

									while ((read = inputStreamAdd.read(bytes)) != -1) {
										outputStreamAdd.write(bytes, 0, read);
									}

								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						}

					} else {
						msa3 = 1;
					}
				}

				matrialId = vendor.getMaterialId();

				// vendorMaterialList = new ArrayList<VendorMaterial>();
				if (matrialId != null) {
					String s = matrialId;

					String res[] = s.split(",");

					for (int i = 0; i < res.length; i++)

					{
						// /vendorMaterial=new VendorMaterial();
						if (!res[i].equals("0")) {
							vendorMaterial = new VendorMaterial();
							if (!res[i].equals("")) {
								vendorMaterial.setMaterialId(Integer
										.parseInt(res[i]));
								vendorMaterial.setVendorId(msa);
								categoryService
										.setVendorMaterialSave(vendorMaterial);

							}

						}

					}
				}

				if (acGroup != null) {
					if (acGroup.length != 0) {

						for (int i = 0; i < acGroup.length; i++) {
							vendorAccount = new VendorAccountDetails();
							vendorAccount.setVendorId(Integer.toString(msa));
							vendorAccount.setAcGroupId(acGroup[i]);
							vendorAccount.setReCondId(recnd[i]);
							vendorAccount.setPaymentTermId(payTerm[i]);
							vendorAccount.setPaymentMethodId(payMtd[i]);

							venderAccountList.add(vendorAccount);
							// if(bankName[i]!="" || bankName[i]!=null)
							if (acGroup[i].length() != 0
									&& vendorNameDublicate == 0) {
								msa1 = categoryService
										.setVendorAccountSave(vendorAccount);

							}

						}
					}
				}

				bom2 = new Vendor();

				model.addAttribute("vendorForm", bom2);
				if (msa != 0) {

					return "redirect:vendor.mnt?list=" + "success" + "";
				} else {
					String fail = "Error ! : Vendor data is not saved properly";
					request.setAttribute("fail", fail);
					return "redirect:vendor.mnt?listwar=" + "fail" + "";
				}

			} else {
				request.setAttribute("venderBankDetailsList",
						venderBankDetailsList);
				vendor.setVendorAddDuplicate(1);
				request.setAttribute("vendorDuplicateAdd",
						"Warning ! Vendor Name aleardy exists. Please try some other name");
				return "vendorHome";

			}

		}

		catch (Exception e) {
			String fail = "Error ! : Vendor data is not saved properly";
			request.setAttribute("fail", fail);
			return "redirect:vendor.mnt?listwar=" + "fail" + "";
		}

	}

	@RequestMapping(value = "/vendorSearch", method = RequestMethod.GET)
	public String searchVendorDetails(@ModelAttribute Vendor vendor,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		response.setCharacterEncoding("UTF-8");
		vendor1 = new ArrayList<Vendor>();
		name = vendor.getVendorName();
		String dbField = vendor.getXmlLabel();
		String operation = vendor.getOperations();
		String basicSearchId = vendor.getBasicSearchId();

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
		if (basicSearchId.length() != 0) {
			// objectsArray = categoryService.getVendor(vendor.getVendorName());
			objectsArray = categoryService.basicSearchVendor(dbField,
					operation, basicSearchId);
		} else {
			objectsArray = categoryService.getVendor("ALL");
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			mm = new com.mnt.erp.bean.Vendor();
			objects2 = (Object[]) iterator.next();
			mm.setVendorId((Integer) objects2[0]);
			mm.setCustomerId((String) objects2[1]);
			mm.setVendorName((String) objects2[2]);
			mm.setAddress((String) objects2[3]);
			mm.setCity((String) objects2[4]);
			mm.setState((String) objects2[5]);
			countryname = categoryService.getCountryName((String) objects2[6]);
			mm.setCountry(countryname);
			mm.setZip((String) objects2[7]);
			mm.setEmail((String) objects2[8]);
			mm.setPhone((String) objects2[9]);
			mm.setFax((String) objects2[10]);
			mm.setMobile((String) objects2[11]);
			name = categoryService.getGroupName((String) objects2[12]);
			mm.setVendGroupId((String) name);
			String blocked = (String) objects2[13];
			if (blocked.equals("0")) {
				blocked = "YES";
			} else {
				blocked = "NO";
			}
			mm.setBlocked(blocked);
			mm.setTinNo((String) objects2[14]);
			mm.setPanNo((String) objects2[15]);
			mm.setVatNo((String) objects2[16]);
			mm.setServiceTaxNo((String) objects2[17]);

			vendor1.add(mm);

		}
		request.setAttribute("vendorSearch", vendor1);

		model.addAttribute("vendorForm", new Vendor());

		return "vendorHome";
	}

	@RequestMapping(value = "/vendorEdit", method = RequestMethod.GET)
	public String vendorEdit(@ModelAttribute Vendor vendorDisplay,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {

		response.setCharacterEncoding("UTF-8");
		id = Integer.parseInt(request.getParameter("vendorEdit"));

		vendorList = new ArrayList<Vendor>();
		vendorBankDetList = new ArrayList<VendorBankDet>();
		vendorDocumentsList = new ArrayList<VendorDocuments>();
		vendorMaterialList = new ArrayList<VendorMaterial>();
		vendorAccountList = new ArrayList<VendorAccountDetails>();
		String materialName = null;

		try {

			list = categoryService.getVendorId(id);
			list2 = categoryService.getVendorBankDetId(id);
			list3 = categoryService.getVendorDocumentId(id);
			list4 = categoryService.getVendorMaterialId(id);
			list5 = categoryService.getVendorAccountId(id);
			iterator = list.iterator();
			iteratorBank = list2.iterator();
			iteratorDocument = list3.iterator();
			iteratorMatrial = list4.iterator();
			iteratorAccount = list5.iterator();
			while (iterator.hasNext()) {
				objects = (Object[]) iterator.next();

				vendorDisplay.setVendorIdEdit((Integer) objects[0]);
				vendorDisplay.setCustomerIdEdit((String) objects[1]);
				vendorDisplay.setVendorNameEdit((String) objects[2]);
				vendorDisplay.setAddressEdit((String) objects[3]);
				vendorDisplay.setCityEdit((String) objects[4]);
				vendorDisplay.setStateEdit((String) objects[5]);
				vendorDisplay.setCountryEdit((String) objects[6]);
				vendorDisplay.setZipEdit((String) objects[7]);
				vendorDisplay.setEmailEdit((String) objects[8]);
				vendorDisplay.setPhoneEdit((String) objects[9]);
				vendorDisplay.setFaxEdit((String) objects[10]);
				vendorDisplay.setMobileEdit((String) objects[11]);
				vendorDisplay.setVendGroupIdEdit((String) objects[12]);
				vendorDisplay.setBlockedEdit((String) objects[13]);
				vendorDisplay.setTinNoEdit((String) objects[14]);
				vendorDisplay.setPanNoEdit((String) objects[15]);
				vendorDisplay.setVatNoEdit((String) objects[16]);
				vendorDisplay.setServiceTaxNoEdit((String) objects[17]);
				vendorDisplay.setStatusId((String) objects[18]);
				vendorList.add(vendorDisplay);

			}

			while (iteratorBank.hasNext()) {
				objects1 = (Object[]) iteratorBank.next();
				vendorBankDet = new VendorBankDet();
				vendorBankDet.setBankName((String) objects1[0]);

				vendorBankDet.setBankAddress((String) objects1[1]);
				vendorBankDet.setMicrCode((String) objects1[2]);
				vendorBankDet.setIfscCode((String) objects1[3]);
				vendorBankDet.setAccountType((String) objects1[4]);
				vendorBankDet.setAccountNumber((String) objects1[5]);
				vendorBankDet.setVendorBankDetId((Integer) objects1[6]);
				vendorBankDetList.add(vendorBankDet);

			}

			while (iteratorDocument.hasNext()) {
				objects2 = (Object[]) iteratorDocument.next();
				vendorDocument = new VendorDocuments();
				vendorDocument.setDocumentName((String) objects2[0]);
				vendorDocument.setDocumentPath((String) objects2[1]);
				vendorDocument.setVendorDocId((Integer) objects2[2]);

				vendorDocumentsList.add(vendorDocument);
			}

			while (iteratorMatrial.hasNext()) {
				objects3 = (Object[]) iteratorMatrial.next();
				vendorMaterial = new VendorMaterial();
				vendorMaterial.setMaterialId((Integer) objects3[0]);
				vendorMaterial.setVendorMatId((Integer) objects3[1]);
				list = materialService
						.getMaterialNameEdit((Integer) objects3[0]);
				iteratorMaterialName = list.iterator();
				while (iteratorMaterialName.hasNext()) {
					objectsMaterial = (Object[]) iteratorMaterialName.next();
					materialName = (String) objectsMaterial[0];
				}
				vendorMaterial.setMaterialName(materialName);
				// v1.setVendorDocId((Integer)objects3[2]);

				vendorMaterialList.add(vendorMaterial);
			}

			while (iteratorAccount.hasNext()) {
				// objects1 = (Object[]) iteratorAccount.next();

				Object obj = iteratorAccount.next();
				VendorAccountDetails ca = (VendorAccountDetails) obj;
				VendorAccountDetails vendorAccount = new VendorAccountDetails();
				AccountGroupBean ag = ca.getAcGroup();
				PaymentTerms pt = ca.getPaymentTerm();
				PaymentMethod pm = ca.getPaymentMethod();
				vendorAccount.setEacGroupName(ag.getAccountgroup());
				vendorAccount.setEreCondName(ag.getAccountgroup());
				vendorAccount.setEpaymentTermName(pt.getPaymentTermName());
				vendorAccount.setEpaymentMethodName(pm.getPaymentMethodName());
				vendorAccount.setEvendAccountId(ca.getVendAccountId());
				vendorAccount.setEacGroupId(ca.getAcGroupId());
				vendorAccount.setEreCondId(ca.getReCondId());
				vendorAccount.setEpaymentTermId(ca.getPaymentTermId());
				vendorAccount.setEpaymentMethodId(ca.getPaymentMethodId());
				vendorAccountList.add(vendorAccount);

			}

			request.setAttribute("vendorValues", vendorList);
			request.setAttribute("vendorBankValues", vendorBankDetList);
			request.setAttribute("vendorDocumentsValues", vendorDocumentsList);
			request.setAttribute("vendorMaterialValues", vendorMaterialList);
			request.setAttribute("vendorAccountList", vendorAccountList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			list = null;
			objects = null;
		}

		model.addAttribute("vendorForm", vendorDisplay);

		return "vendorHome";
	}

	@RequestMapping(value = "/vendorUpdate", method = RequestMethod.POST)
	public String updateVendorDetails(@ModelAttribute Vendor vendor,
			HttpServletRequest request, Model model,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		try {

			vendor.setVendorId(vendor.getVendorIdEdit());
			vendor.setCustomerId(vendor.getCustomerIdEdit());
			vendor.setVendorName(vendor.getVendorNameEdit());
			vendor.setAddress(vendor.getAddressEdit());
			vendor.setCity(vendor.getCityEdit());
			vendor.setState(vendor.getStateEdit());
			vendor.setCountry(vendor.getCountryEdit());
			vendor.setZip(vendor.getZipEdit());
			vendor.setEmail(vendor.getEmailEdit());
			vendor.setPhone(vendor.getPhoneEdit());
			vendor.setFax(vendor.getFaxEdit());
			vendor.setMobile(vendor.getMobileEdit());
			vendor.setVendGroupId(vendor.getVendGroupIdEdit());
			vendor.setBlocked(vendor.getBlockedEdit());
			vendor.setTinNo(vendor.getTinNoEdit());
			vendor.setPanNo(vendor.getPanNoEdit());
			vendor.setVatNo(vendor.getVatNoEdit());
			vendor.setServiceTaxNo(vendor.getServiceTaxNoEdit());
			msg = categoryService.updateVendor(vendor);
			venderBankDetailsList = new ArrayList<VendorBankDet>();
			vendorBankDetIdEdit = vendor.getVendorBankDetIdEdit();

			// int[] vendorBankDetHidden=vendor.getVendorBankDetHidden();
			String[] bankName = vendor.getBankNameEdit();
			String[] bankAddress = vendor.getBankAddressEdit();
			String[] ifscCode = vendor.getIfscCodeEdit();
			String[] micrCode = vendor.getMicrCodeEdit();
			String[] accountNumber = vendor.getAccountNumberEdit();
			String[] accountType = vendor.getAccountTypeEdit();

			if (bankName != null) {
				if (bankName.length != 0) {
					for (int i = 0; i < bankName.length; i++) {
						v1 = new VendorBankDet();

						if (vendorBankDetIdEdit[i] != 0) {
							vendorCheckValue = request
									.getParameter(vendorBankDetIdEdit[i]
											+ "Check");
						}
						if (vendorBankDetIdEdit[i] == 0) {
							vendorCheckValue = request.getParameter("Check");
						}

						if ((bankName[i] != "" || bankName[i] != null)) {

							if (vendorBankDetIdEdit[i] != 0
									&& vendorCheckValue.equals("0")) {

								v1.setVendorId(vendor.getVendorIdEdit());
								v1.setVendorBankDetId(vendorBankDetIdEdit[i]);
								v1.setBankName(bankName[i]);
								v1.setBankAddress(bankAddress[i]);
								v1.setIfscCode(ifscCode[i]);
								v1.setMicrCode(micrCode[i]);
								v1.setAccountType(accountType[i]);
								v1.setAccountNumber(accountNumber[i]);
								count = categoryService
										.checkDuplicateVendorBankDet(
												bankName[i], accountNumber[i],
												vendor.getVendorIdEdit(),
												vendorBankDetIdEdit[i]);

								if (count == 0) {
									categoryService.updateVendorBankDet(v1);
								}
							}
							if (vendorBankDetIdEdit[i] == 0) {

								v1.setVendorId(vendor.getVendorIdEdit());
								v1.setBankName(bankName[i]);
								v1.setBankAddress(bankAddress[i]);
								v1.setIfscCode(ifscCode[i]);
								v1.setMicrCode(micrCode[i]);
								v1.setAccountType(accountType[i]);
								v1.setAccountNumber(accountNumber[i]);
								count = categoryService
										.checkDuplicateVendorBankDet(
												bankName[i], accountNumber[i],
												vendor.getVendorIdEdit(), 0);
								if (bankName[i].length() != 0 && count == 0) {
									categoryService.setVendorBankDetSave(v1);
								}
							}
							if (vendorCheckValue.equals("1")) {

								categoryService
										.vendorBankDetDelete(vendorBankDetIdEdit[i]);
							}
						}

					}
				}
			}
			String[] documentNameEdit = vendor.getDocumentNameEdit();
			String[] documentName = vendor.getDocumentName();
			String[] documentPath = vendor.getVendorDocumentPathEdit();
			vendorDocIdEdit = vendor.getVendorDocIdEdit();
			vendorDocId = vendor.getVendorDocId();
			MultipartFile[] file = vendor.getFile();

			filePathToGraphsDir = servletContext.getRealPath("/VendorId");
			filePathToGraphsDir1 = filePathToGraphsDir.replace('\\', '/');

			checkPrevious = vendor.getCheckPrevious();

			if (checkPrevious != null) {
				for (int l = 0; l < checkPrevious.length; l++) {
					if (checkPrevious[l].equals("1")) {
						// if(documentName.length!=0)
						// {
						vendorDocuments = new VendorDocuments();
						// for(int j=0;j<documentName.length;j++)
						// {
						checkDoc = request.getParameter(vendorDocIdEdit[l]
								+ "CheckDoc");

						if (checkDoc.equals("0")) {
							vendorDocuments.setVendorId(vendor
									.getVendorIdEdit());
							vendorDocuments.setDocumentName(documentName[l]);
							vendorDocuments.setVendorDocId(vendorDocIdEdit[l]);
							vendorDocuments.setDocumentPath(documentPath[l]);
							categoryService
									.UpdateVendorDocuments(vendorDocuments);
						}
						if (checkDoc.equals("1")) {

							categoryService
									.vendorDocumentDelete(vendorDocIdEdit[l]);
						}
					}
				}
			}
			if (file != null) {
				if (file.length != 0 && documentNameEdit.length != 0) {
					for (int i = 0; i < file.length; i++) {
						vendorDocuments = new VendorDocuments();
						filePath = new File(filePathToGraphsDir1 + "//"
								+ vendor.getVendorIdEdit());
						if (!filePath.exists()) {
							if (filePath.mkdir()) {
								System.out.println("Directory is created!");
							}
						}
						fileName = file[i].getOriginalFilename();
						if (documentNameEdit[i].length() != 0) {
							vendorDocuments.setVendorId(vendor
									.getVendorIdEdit());
							vendorDocuments
									.setDocumentName(documentNameEdit[i]);
							vendorDocuments
									.setDocumentPath(filePathToGraphsDir1 + "/"
											+ vendor.getVendorIdEdit() + "/"
											+ fileName);
							categoryService
									.setVendorDocumentsSave(vendorDocuments);

							try {
								inputStreamAdd = file[i].getInputStream();

								outputStreamAdd = new FileOutputStream(
										filePathToGraphsDir1 + "//"
												+ vendor.getVendorIdEdit()
												+ "//" + fileName);
								read = 0;
								bytes = new byte[1024];

								while ((read = inputStreamAdd.read(bytes)) != -1) {
									outputStreamAdd.write(bytes, 0, read);
								}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}

					}
				}
			}

			checkMaterial = vendor.getCheckMaterial();
			matrialId = vendor.getMaterialIdEdit();
			vendorMatIdEdit = vendor.getVendorMatIdEdit();
			vendorCheckMaterial = "";
			String s = matrialId;
			if (s != null) {
				String res[] = s.split(",");
				for (int i = 0; i < res.length; i++) {
					vendorMaterial = new VendorMaterial();
					if (vendorMatIdEdit[i] != 0) {
						vendorCheckMaterial = request
								.getParameter(vendorMatIdEdit[i]
										+ "CheckMaterial");
						if (vendorCheckMaterial.equals("0")) {
							vendorMaterial.setMaterialId(Integer
									.parseInt(res[i]));
							vendorMaterial
									.setVendorId(vendor.getVendorIdEdit());
							vendorMaterial.setVendorMatId(vendorMatIdEdit[i]);
							categoryService
									.updateVendorMaterial(vendorMaterial);
						}
						if (vendorCheckMaterial.equals("1")) { //

							categoryService
									.vendorMaterialDelete(vendorMatIdEdit[i]);
						}
					}
					if (vendorMatIdEdit[i] == 0 && !res[i].equals("0")) {

						vendorMaterial.setMaterialId(Integer.parseInt(res[i]));
						vendorMaterial.setVendorId(vendor.getVendorIdEdit());
						categoryService.setVendorMaterialSave(vendorMaterial);

					}

				}
			}
			Set<VendorAccountDetails> custAcUp = new HashSet<VendorAccountDetails>();
			int cAcId[] = vendor.getEvendAccountId();
			String[] acGp = vendor.getEacGroupId();
			String[] rec = vendor.getEreCondId();
			String[] payTr = vendor.getEpaymentTermId();
			String[] patMt = vendor.getEpaymentMethodId();
			int[] checked = vendor.getCheckedAccount();
			if (acGp != null) {
				for (int n = 0; n < acGp.length; n++) {
					int cbId = cAcId[n];
					if (cbId == 0) {
						VendorAccountDetails ca = new VendorAccountDetails();
						ca.setAcGroupId(acGp[n]);
						ca.setReCondId(rec[n]);
						ca.setPaymentTermId(payTr[n]);
						ca.setPaymentMethodId(patMt[n]);
						ca.setVendorId(Integer.toString(vendor
								.getVendorIdEdit()));
						categoryService.setVendorAccountSave(ca);

					} else {
						if (checked[n] == 1) {
							categoryService.vendorAccountDelete(cbId);

						} else if (checked[n] == 0 && cbId != 0) {
							VendorAccountDetails ca = new VendorAccountDetails();
							ca.setVendAccountId(cbId);
							ca.setVendorId(Integer.toString(vendor
									.getVendorIdEdit()));
							ca.setAcGroupId(acGp[n]);
							ca.setReCondId(rec[n]);
							ca.setPaymentTermId(payTr[n]);
							ca.setPaymentMethodId(patMt[n]);
							categoryService.updateVendorAccount(ca);
						}
					}
				}
			}

			if (msg.equals("S")) {
				request.setAttribute("vendorUpadte",
						"$uccess : Vendor Data is updated successfully");
			} else {
				String fail = "Error ! : Vendor data is not updated properly";
				request.setAttribute("vendorUpadteError", fail);
				model.addAttribute("vendorForm", new Vendor());
				return "vendorHome";
			}

		} catch (Exception e) {
			e.printStackTrace();
			String fail = "Error ! : Vendor data is not updated properly";
			request.setAttribute("fail", fail);
			model.addAttribute("vendorForm", new Vendor());
			return "vendorHome";
		}

		model.addAttribute("vendorForm", new Vendor());
		return "vendorHome";
	}

	@RequestMapping(value = "/vendorDelete", method = RequestMethod.GET)
	public ModelAndView VendorDelete(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		try {
			id = Integer.parseInt(request.getParameter("vendorDelete"));
			String msg = categoryService.vendorDelete(id);
			if (msg.equals("S")) {
				session = request.getSession(false);
				Date date = new Date();
				String modifiedDate = new SimpleDateFormat(
						"yyyy-MM-dd HH:mm:ss").format(date);
				auditLogService.setAuditLogSave(session.getAttribute("userId")
						.toString(), "D", "Vendor", "ROW", String.valueOf(id),
						"1", modifiedDate, session.getAttribute("userName")
								.toString());
				request.setAttribute("vendorDelete",
						"$uccess : Vendor Data is deleted successfully");
			} else {
				String fail = "Error ! : Vendor data is not deleted properly";
				request.setAttribute("vendorDeleteError", fail);
				return new ModelAndView("vendorHome", "vendorForm",
						new Vendor());

			}

		} catch (Exception e) {
			e.printStackTrace();
			String fail = "Error ! : Vendor data is not deleted properly";
			request.setAttribute("fail", fail);
			return new ModelAndView("vendorHome", "vendorForm", new Vendor());
			// request.setAttribute("vendorUpadte","Vendor details cant be deleted! Please Delete The Child Table Data");
		}
		return new ModelAndView("vendorHome", "vendorForm", new Vendor());
	}

	@ModelAttribute("xmlItems")
	public Map<String, String> populatLabelDetails() {
		String name = "vendorId";

		Map<String, String> map = new HashMap<String, String>();

		try {
			map = xmlService.populateXmlLabels(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@RequestMapping(value = "/vendorAdvanceSearch", method = RequestMethod.GET)
	public String vendorAdvanceSearch(
			@ModelAttribute("vendorForm") Vendor vendor,
			HttpServletRequest request, HttpServletResponse response) {

		String name1 = "vendor", s1 = null, s2 = null;

		List<Object[]> returnString = null;
		response.setCharacterEncoding("UTF-8");
		vendorList = new ArrayList();
		vendor.setAdvanceSearchHidden(1);
		try {
			returnString = xmlService.populateXml(name1);
			Iterator it = returnString.iterator();
			for (Object[] object : returnString) {
				Vendor v = new Vendor();

				s1 = (String) object[0];
				s2 = (String) object[1];
				v.setFirstLabel(s1);
				v.setSecondLabel(s2);
				vendorList.add(v);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("vendorSearchAdvance", vendorList);

		return "vendorHome";
	}

	@RequestMapping(value = "/vendorAdvanceSearchOperations", method = RequestMethod.POST)
	public String vendorAdvanceSearchOperations(@ModelAttribute Vendor vendor,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		response.setCharacterEncoding("UTF-8");
		vendor1 = new ArrayList<Vendor>();
		String columns = vendor.getFirstLabel();
		String operations = vendor.getOperations1();
		String advanceSearchText = vendor.getAdvanceSearchText();

		if (advanceSearchText.length() != 0) {

			objectsArray = categoryService.getVendorAdvance(columns,
					operations, advanceSearchText);
		} else {
			objectsArray = categoryService.getVendor("ALL");
		}
		iterator = objectsArray.iterator();
		while (iterator.hasNext()) {
			mm = new com.mnt.erp.bean.Vendor();
			objects2 = (Object[]) iterator.next();
			mm.setVendorId((Integer) objects2[0]);
			mm.setCustomerId((String) objects2[1]);
			mm.setVendorName((String) objects2[2]);
			mm.setAddress((String) objects2[3]);
			mm.setCity((String) objects2[4]);
			mm.setState((String) objects2[5]);
			countryname = categoryService.getCountryName((String) objects2[6]);
			mm.setCountry(countryname);
			mm.setZip((String) objects2[7]);
			mm.setEmail((String) objects2[8]);
			mm.setPhone((String) objects2[9]);
			mm.setFax((String) objects2[10]);
			mm.setMobile((String) objects2[11]);
			name = categoryService.getGroupName((String) objects2[12]);
			mm.setVendGroupId((String) name);
			String blocked = (String) objects2[13];
			if (blocked.equals("0")) {
				blocked = "YES";
			} else {
				blocked = "NO";
			}
			mm.setBlocked(blocked);
			mm.setTinNo((String) objects2[14]);
			mm.setPanNo((String) objects2[15]);
			mm.setVatNo((String) objects2[16]);
			mm.setServiceTaxNo((String) objects2[17]);

			vendor1.add(mm);

		}

		request.setAttribute("vendorSearch", vendor1);
		model.addAttribute("vendorForm", new Vendor());

		return "vendorHome";
	}

}
