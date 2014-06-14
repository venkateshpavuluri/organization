package com.mnt.erp.bean;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;



public class Vendor {
	private int vendorId;
	private String customerId;
	private String vendorName;
	private String address;
	private String city;
	private String state;
	private String country;
	private String zip;
	private String email;
	private String phone;
	private String fax;
	private String mobile;
	private String vendGroupId;
	private String blocked;
	private String tinNo;
	private String panNo;
	private String vatNo;
	private String serviceTaxNo;
	private String statusId;
	private int vendorAddDuplicate;
	private int vendorAddDuplicateEdit;
	
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	private String materialName;
	
	
	
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	
	
	private int[] vendAccountId;
	private String[] vendorIdAccount;
	private String[] acGroupId;
	private String[] reCondId;
	private String[] paymentTermId;
	private String[] paymentMethodId;
	private int[] checkedAccount;
	private String vendorNameAccount;
	private String acGroupName;
	private String reCondName;
	private String paymentTermName;
	private String paymentMethodName;
	
	
	
	private int[] evendAccountId;
	private String[] evendorIdAccount;
	private String[] eacGroupId;
	private String[] ereCondId;
	private String[] epaymentTermId;
	private String[] epaymentMethodId;
	
	private String evendorNameAccount;
	private String eacGroupName;
	private String ereCondName;
	private String epaymentTermName;
	private String epaymentMethodName;
	private Set<VendorAccountDetails> vendAccount;
	
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	/**
	 * @return the vendorAddDuplicate
	 */
	public int getVendorAddDuplicate() {
		return vendorAddDuplicate;
	}
	/**
	 * @param vendorAddDuplicate the vendorAddDuplicate to set
	 */
	public void setVendorAddDuplicate(int vendorAddDuplicate) {
		this.vendorAddDuplicate = vendorAddDuplicate;
	}
	private int vendorIdEdit;
	private String customerIdEdit;
	private String vendorNameEdit;
	private String addressEdit;
	private String cityEdit;
	private String stateEdit;
	private String countryEdit;
	private String zipEdit;
	private String emailEdit;
	private String phoneEdit;
	private String faxEdit;
	private String mobileEdit;
	private String vendGroupIdEdit;
	private String blockedEdit;
	private String tinNoEdit;
	private String panNoEdit;
	private String vatNoEdit;
	private String serviceTaxNoEdit;
		
	private int vendorBankDetId;
	private String[] bankName;
	private String[] bankAddress;
	private String[] micrCode;
	private String[] ifscCode;
	private String[] accountType;
	private String[] accountNumber;
	private List<VendorBankDet> vendorBankDet;
	private String[] documentName;
	private MultipartFile[] file;
	//private int[] materialId;
	private String materialId;
	private int[] vendorMatId;
	private int materialHiddenAdd;
	private String[] materialPresent;
	private String MaterialNameEdit;
	
	
	
	/**
	 * @return the materialPresent
	 */
	public String[] getMaterialPresent() {
		return materialPresent;
	}
	/**
	 * @param materialPresent the materialPresent to set
	 */
	public void setMaterialPresent(String[] materialPresent) {
		this.materialPresent = materialPresent;
	}
	/**
	 * @return the materialHiddenAdd
	 */
	public int getMaterialHiddenAdd() {
		return materialHiddenAdd;
	}
	/**
	 * @param materialHiddenAdd the materialHiddenAdd to set
	 */
	public void setMaterialHiddenAdd(int materialHiddenAdd) {
		this.materialHiddenAdd = materialHiddenAdd;
	}
	private List vendorMaterial;
	private int materialIdEditName;
	/**
	 * @return the materialIdEditName
	 */
	public int getMaterialIdEditName() {
		return materialIdEditName;
	}
	/**
	 * @param materialIdEditName the materialIdEditName to set
	 */
	public void setMaterialIdEditName(int materialIdEditName) {
		this.materialIdEditName = materialIdEditName;
	}
	
	/**
	 * @return the vendorMaterial
	 */
	public List getVendorMaterial() {
		return vendorMaterial;
	}
	/**
	 * @param vendorMaterial the vendorMaterial to set
	 */
	public void setVendorMaterial(List vendorMaterial) {
		vendorMaterial = vendorMaterial;
	}
	private int[] vendorBankDetIdEdit;
	private String[] bankNameEdit;
	private String[] bankAddressEdit;
	private String[] micrCodeEdit;
	private String[] ifscCodeEdit;
	private String[] accountTypeEdit;
	private String[] accountNumberEdit;
	private List<VendorBankDet> vendorBankDetEdit;
	private String[] documentNameEdit;
	private MultipartFile[] fileEdit;
	private String materialIdEdit;
	private int[] vendorMatIdEdit;
	private int[] vendorBankDetHidden;
	private String[] vendorMaterialHidden;
	private String[] vendorDocumentPathEdit;
	private String[] checkPrevious;
	private String[] checkPreviousEdit;
	private String[] checkMaterial;
	/**
	 * @return the checkMaterial
	 */
	public String[] getCheckMaterial() {
		return checkMaterial;
	}
	/**
	 * @param checkMaterial the checkMaterial to set
	 */
	public void setCheckMaterial(String[] checkMaterial) {
		this.checkMaterial = checkMaterial;
	}
	/**
	 * @return the checkPrevious
	 */
	public String[] getCheckPrevious() {
		return checkPrevious;
	}
	/**
	 * @param checkPrevious the checkPrevious to set
	 */
	public void setCheckPrevious(String[] checkPrevious) {
		this.checkPrevious = checkPrevious;
	}
	/**
	 * @return the vendorDocumentPathEdit
	 */
	public String[] getVendorDocumentPathEdit() {
		return vendorDocumentPathEdit;
	}
	/**
	 * @param vendorDocumentPathEdit the vendorDocumentPathEdit to set
	 */
	public void setVendorDocumentPathEdit(String[] vendorDocumentPathEdit) {
		this.vendorDocumentPathEdit = vendorDocumentPathEdit;
	}
	/**
	 * @return the vendorMaterialHidden
	 */
	public String[] getVendorMaterialHidden() {
		return vendorMaterialHidden;
	}
	/**
	 * @param vendorMaterialHidden the vendorMaterialHidden to set
	 */
	public void setVendorMaterialHidden(String[] vendorMaterialHidden) {
		this.vendorMaterialHidden = vendorMaterialHidden;
	}
	/**
	 * @return the vendorBankDetHidden
	 */
	public int[] getVendorBankDetHidden() {
		return vendorBankDetHidden;
	}
	/**
	 * @param vendorBankDetHidden the vendorBankDetHidden to set
	 */
	public void setVendorBankDetHidden(int vendorBankDetHidden[]) {
		this.vendorBankDetHidden = vendorBankDetHidden;
	}
	/**
	 * @return the vendorBankDetIdEdit
	 */
	public int[] getVendorBankDetIdEdit() {
		return vendorBankDetIdEdit;
	}
	/**
	 * @param vendorBankDetIdEdit the vendorBankDetIdEdit to set
	 */
	public void setVendorBankDetIdEdit(int vendorBankDetIdEdit[]) {
		this.vendorBankDetIdEdit = vendorBankDetIdEdit;
	}
	/**
	 * @return the bankNameEdit
	 */
	public String[] getBankNameEdit() {
		return bankNameEdit;
	}
	/**
	 * @param bankNameEdit the bankNameEdit to set
	 */
	public void setBankNameEdit(String[] bankNameEdit) {
		this.bankNameEdit = bankNameEdit;
	}
	/**
	 * @return the bankAddressEdit
	 */
	public String[] getBankAddressEdit() {
		return bankAddressEdit;
	}
	/**
	 * @param bankAddressEdit the bankAddressEdit to set
	 */
	public void setBankAddressEdit(String[] bankAddressEdit) {
		this.bankAddressEdit = bankAddressEdit;
	}
	/**
	 * @return the micrCodeEdit
	 */
	public String[] getMicrCodeEdit() {
		return micrCodeEdit;
	}
	/**
	 * @param micrCodeEdit the micrCodeEdit to set
	 */
	public void setMicrCodeEdit(String[] micrCodeEdit) {
		this.micrCodeEdit = micrCodeEdit;
	}
	/**
	 * @return the ifscCodeEdit
	 */
	public String[] getIfscCodeEdit() {
		return ifscCodeEdit;
	}
	/**
	 * @param ifscCodeEdit the ifscCodeEdit to set
	 */
	public void setIfscCodeEdit(String[] ifscCodeEdit) {
		this.ifscCodeEdit = ifscCodeEdit;
	}
	/**
	 * @return the accountTypeEdit
	 */
	public String[] getAccountTypeEdit() {
		return accountTypeEdit;
	}
	/**
	 * @param accountTypeEdit the accountTypeEdit to set
	 */
	public void setAccountTypeEdit(String[] accountTypeEdit) {
		this.accountTypeEdit = accountTypeEdit;
	}
	/**
	 * @return the accountNumberEdit
	 */
	public String[] getAccountNumberEdit() {
		return accountNumberEdit;
	}
	/**
	 * @param accountNumberEdit the accountNumberEdit to set
	 */
	public void setAccountNumberEdit(String[] accountNumberEdit) {
		this.accountNumberEdit = accountNumberEdit;
	}
	/**
	 * @return the vendorBankDetEdit
	 */
	public List<VendorBankDet> getVendorBankDetEdit() {
		return vendorBankDetEdit;
	}
	/**
	 * @param vendorBankDetEdit the vendorBankDetEdit to set
	 */
	public void setVendorBankDetEdit(List<VendorBankDet> vendorBankDetEdit) {
		this.vendorBankDetEdit = vendorBankDetEdit;
	}
	/**
	 * @return the documentNameEdit
	 */
	public String[] getDocumentNameEdit() {
		return documentNameEdit;
	}
	/**
	 * @param documentNameEdit the documentNameEdit to set
	 */
	public void setDocumentNameEdit(String documentNameEdit[]) {
		this.documentNameEdit = documentNameEdit;
	}
	/**
	 * @return the fileEdit
	 */
	public MultipartFile[] getFileEdit() {
		return fileEdit;
	}
	/**
	 * @param fileEdit the fileEdit to set
	 */
	public void setFileEdit(MultipartFile[] fileEdit) {
		this.fileEdit = fileEdit;
	}
	/**
	 * @return the materialIdEdit
	 */
	public String getMaterialIdEdit() {
		return materialIdEdit;
	}
	/**
	 * @param materialIdEdit the materialIdEdit to set
	 */
	public void setMaterialIdEdit(String materialIdEdit) {
		this.materialIdEdit = materialIdEdit;
	}
	/**
	 * @return the vendorMatIdEdit
	 */
	public int[] getVendorMatIdEdit() {
		return vendorMatIdEdit;
	}
	/**
	 * @param vendorMatIdEdit the vendorMatIdEdit to set
	 */
	public void setVendorMatIdEdit(int[] vendorMatIdEdit) {
		this.vendorMatIdEdit = vendorMatIdEdit;
	}
	/**
	 * @return the file
	 */
	
	private int[] vendorDocId;
	private int[] vendorDocIdEdit;
	/**
	 * @return the vendorDocIdEdit
	 */
	public int[] getVendorDocIdEdit() {
		return vendorDocIdEdit;
	}
	/**
	 * @param vendorDocIdEdit the vendorDocIdEdit to set
	 */
	public void setVendorDocIdEdit(int[] vendorDocIdEdit) {
		this.vendorDocIdEdit = vendorDocIdEdit;
	}
	/**
	 * @return the file
	 */
	public MultipartFile[] getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
	
		
	
	
	/**
	 * @return the documentName
	 */
	public String[] getDocumentName() {
		return documentName;
	}
	/**
	 * @param documentName the documentName to set
	 */
	public void setDocumentName(String documentName[]) {
		this.documentName = documentName;
	}
	
	/**
	 * @return the vendorDocId
	 */
	public int[] getVendorDocId() {
		return vendorDocId;
	}
	/**
	 * @param vendorDocId the vendorDocId to set
	 */
	public void setVendorDocId(int[] vendorDocId) {
		this.vendorDocId = vendorDocId;
	}
	
	/**
	 * @return the vendorMatId
	 */
	public int[] getVendorMatId() {
		return vendorMatId;
	}
	/**
	 * @param vendorMatId the vendorMatId to set
	 */
	public void setVendorMatId(int[] vendorMatId) {
		this.vendorMatId = vendorMatId;
	}
	/**
	 * @return the vendorBankDet
	 */
	public List<VendorBankDet> getVendorBankDet() {
		return vendorBankDet;
	}
	/**
	 * @param vendorBankDet the vendorBankDet to set
	 */
	public void setVendorBankDet(List<VendorBankDet> vendorBankDet) {
		this.vendorBankDet = vendorBankDet;
	}
	/**
	 * @return the vendorBankDetId
	 */
	public int getVendorBankDetId() {
		return vendorBankDetId;
	}
	/**
	 * @param vendorBankDetId the vendorBankDetId to set
	 */
	public void setVendorBankDetId(int vendorBankDetId) {
		this.vendorBankDetId = vendorBankDetId;
	}
	/**
	 * @return the vendorBankDet
	 */
	
	/**
	 * @return the vendorId
	 */
	public int getVendorId() {
		return vendorId;
	}
	/**
	 * @return the vendorBankDet
	 */

	/**
	 * @return the bankName
	 */
	public String[] getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String[] bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the bankAddress
	 */
	public String[] getBankAddress() {
		return bankAddress;
	}
	/**
	 * @param bankAddress the bankAddress to set
	 */
	public void setBankAddress(String[] bankAddress) {
		this.bankAddress = bankAddress;
	}
	/**
	 * @return the micrCode
	 */
	public String[] getMicrCode() {
		return micrCode;
	}
	/**
	 * @param micrCode the micrCode to set
	 */
	public void setMicrCode(String[] micrCode) {
		this.micrCode = micrCode;
	}
	/**
	 * @return the ifscCode
	 */
	public String[] getIfscCode() {
		return ifscCode;
	}
	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String[] ifscCode) {
		this.ifscCode = ifscCode;
	}
	/**
	 * @return the accountType
	 */
	public String[] getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String[] accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the accountNumber
	 */
	public String[] getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String[] accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the vendGroupId
	 */
	public String getVendGroupId() {
		return vendGroupId;
	}
	/**
	 * @param vendGroupId the vendGroupId to set
	 */
	public void setVendGroupId(String vendGroupId) {
		this.vendGroupId = vendGroupId;
	}
	/**
	 * @return the blocked
	 */
	public String getBlocked() {
		return blocked;
	}
	/**
	 * @param blocked the blocked to set
	 */
	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}
	/**
	 * @return the tinNo
	 */
	public String getTinNo() {
		return tinNo;
	}
	/**
	 * @param tinNo the tinNo to set
	 */
	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}
	/**
	 * @return the panNo
	 */
	public String getPanNo() {
		return panNo;
	}
	/**
	 * @param panNo the panNo to set
	 */
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}
	/**
	 * @return the vatNo
	 */
	public String getVatNo() {
		return vatNo;
	}
	/**
	 * @param vatNo the vatNo to set
	 */
	public void setVatNo(String vatNo) {
		this.vatNo = vatNo;
	}
	/**
	 * @return the serviceTaxNo
	 */
	public String getServiceTaxNo() {
		return serviceTaxNo;
	}
	/**
	 * @param serviceTaxNo the serviceTaxNo to set
	 */
	public void setServiceTaxNo(String serviceTaxNo) {
		this.serviceTaxNo = serviceTaxNo;
	}
	/**
	 * @return the vendorIdEdit
	 */
	public int getVendorIdEdit() {
		return vendorIdEdit;
	}
	/**
	 * @param vendorIdEdit the vendorIdEdit to set
	 */
	public void setVendorIdEdit(int vendorIdEdit) {
		this.vendorIdEdit = vendorIdEdit;
	}
	/**
	 * @return the customerIdEdit
	 */
	public String getCustomerIdEdit() {
		return customerIdEdit;
	}
	/**
	 * @param customerIdEdit the customerIdEdit to set
	 */
	public void setCustomerIdEdit(String customerIdEdit) {
		this.customerIdEdit = customerIdEdit;
	}
	/**
	 * @return the vendorNameEdit
	 */
	public String getVendorNameEdit() {
		return vendorNameEdit;
	}
	/**
	 * @param vendorNameEdit the vendorNameEdit to set
	 */
	public void setVendorNameEdit(String vendorNameEdit) {
		this.vendorNameEdit = vendorNameEdit;
	}
	/**
	 * @return the addressEdit
	 */
	public String getAddressEdit() {
		return addressEdit;
	}
	/**
	 * @param addressEdit the addressEdit to set
	 */
	public void setAddressEdit(String addressEdit) {
		this.addressEdit = addressEdit;
	}
	/**
	 * @return the cityEdit
	 */
	public String getCityEdit() {
		return cityEdit;
	}
	/**
	 * @param cityEdit the cityEdit to set
	 */
	public void setCityEdit(String cityEdit) {
		this.cityEdit = cityEdit;
	}
	/**
	 * @return the stateEdit
	 */
	public String getStateEdit() {
		return stateEdit;
	}
	/**
	 * @param stateEdit the stateEdit to set
	 */
	public void setStateEdit(String stateEdit) {
		this.stateEdit = stateEdit;
	}
	/**
	 * @return the countryEdit
	 */
	public String getCountryEdit() {
		return countryEdit;
	}
	/**
	 * @param countryEdit the countryEdit to set
	 */
	public void setCountryEdit(String countryEdit) {
		this.countryEdit = countryEdit;
	}
	/**
	 * @return the zipEdit
	 */
	public String getZipEdit() {
		return zipEdit;
	}
	/**
	 * @param zipEdit the zipEdit to set
	 */
	public void setZipEdit(String zipEdit) {
		this.zipEdit = zipEdit;
	}
	/**
	 * @return the emailEdit
	 */
	public String getEmailEdit() {
		return emailEdit;
	}
	/**
	 * @param emailEdit the emailEdit to set
	 */
	public void setEmailEdit(String emailEdit) {
		this.emailEdit = emailEdit;
	}
	/**
	 * @return the phoneEdit
	 */
	public String getPhoneEdit() {
		return phoneEdit;
	}
	/**
	 * @param phoneEdit the phoneEdit to set
	 */
	public void setPhoneEdit(String phoneEdit) {
		this.phoneEdit = phoneEdit;
	}
	/**
	 * @return the faxEdit
	 */
	public String getFaxEdit() {
		return faxEdit;
	}
	/**
	 * @param faxEdit the faxEdit to set
	 */
	public void setFaxEdit(String faxEdit) {
		this.faxEdit = faxEdit;
	}
	/**
	 * @return the mobileEdit
	 */
	public String getMobileEdit() {
		return mobileEdit;
	}
	/**
	 * @param mobileEdit the mobileEdit to set
	 */
	public void setMobileEdit(String mobileEdit) {
		this.mobileEdit = mobileEdit;
	}
	/**
	 * @return the vendGroupIdEdit
	 */
	public String getVendGroupIdEdit() {
		return vendGroupIdEdit;
	}
	/**
	 * @param vendGroupIdEdit the vendGroupIdEdit to set
	 */
	public void setVendGroupIdEdit(String vendGroupIdEdit) {
		this.vendGroupIdEdit = vendGroupIdEdit;
	}
	/**
	 * @return the blockedEdit
	 */
	public String getBlockedEdit() {
		return blockedEdit;
	}
	/**
	 * @param blockedEdit the blockedEdit to set
	 */
	public void setBlockedEdit(String blockedEdit) {
		this.blockedEdit = blockedEdit;
	}
	/**
	 * @return the tinNoEdit
	 */
	public String getTinNoEdit() {
		return tinNoEdit;
	}
	/**
	 * @param tinNoEdit the tinNoEdit to set
	 */
	public void setTinNoEdit(String tinNoEdit) {
		this.tinNoEdit = tinNoEdit;
	}
	/**
	 * @return the panNoEdit
	 */
	public String getPanNoEdit() {
		return panNoEdit;
	}
	/**
	 * @param panNoEdit the panNoEdit to set
	 */
	public void setPanNoEdit(String panNoEdit) {
		this.panNoEdit = panNoEdit;
	}
	/**
	 * @return the vatNoEdit
	 */
	public String getVatNoEdit() {
		return vatNoEdit;
	}
	/**
	 * @param vatNoEdit the vatNoEdit to set
	 */
	public void setVatNoEdit(String vatNoEdit) {
		this.vatNoEdit = vatNoEdit;
	}
	/**
	 * @return the serviceTaxNoEdit
	 */
	public String getServiceTaxNoEdit() {
		return serviceTaxNoEdit;
	}
	/**
	 * @param serviceTaxNoEdit the serviceTaxNoEdit to set
	 */
	public void setServiceTaxNoEdit(String serviceTaxNoEdit) {
		this.serviceTaxNoEdit = serviceTaxNoEdit;
	}
	public String getFirstLabel() {
		return firstLabel;
	}
	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}
	public String getSecondLabel() {
		return secondLabel;
	}
	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}
	public String getOperations1() {
		return operations1;
	}
	public void setOperations1(String operations1) {
		this.operations1 = operations1;
	}
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}
	/**
	 * @return the vendorAddDuplicateEdit
	 */
	public int getVendorAddDuplicateEdit() {
		return vendorAddDuplicateEdit;
	}
	/**
	 * @param vendorAddDuplicateEdit the vendorAddDuplicateEdit to set
	 */
	public void setVendorAddDuplicateEdit(int vendorAddDuplicateEdit) {
		this.vendorAddDuplicateEdit = vendorAddDuplicateEdit;
	}
	/**
	 * @return the materialId
	 */
	public String getMaterialId() {
		return materialId;
	}
	/**
	 * @param materialId the materialId to set
	 */
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	/**
	 * @return the materialName
	 */
	public String getMaterialName() {
		return materialName;
	}
	/**
	 * @param materialName the materialName to set
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	/**
	 * @return the checkPreviousEdit
	 */
	public String[] getCheckPreviousEdit() {
		return checkPreviousEdit;
	}
	/**
	 * @param checkPreviousEdit the checkPreviousEdit to set
	 */
	public void setCheckPreviousEdit(String[] checkPreviousEdit) {
		this.checkPreviousEdit = checkPreviousEdit;
	}
	//setter And Getters of Vendor Accounts
	public int[] getVendAccountId() {
		return vendAccountId;
	}
	public void setVendAccountId(int[] vendAccountId) {
		this.vendAccountId = vendAccountId;
	}
	public String[] getVendorIdAccount() {
		return vendorIdAccount;
	}
	public void setVendorIdAccount(String[] vendorIdAccount) {
		this.vendorIdAccount = vendorIdAccount;
	}
	public String[] getAcGroupId() {
		return acGroupId;
	}
	public void setAcGroupId(String[] acGroupId) {
		this.acGroupId = acGroupId;
	}
	public String[] getReCondId() {
		return reCondId;
	}
	public void setReCondId(String[] reCondId) {
		this.reCondId = reCondId;
	}
	public String[] getPaymentTermId() {
		return paymentTermId;
	}
	public void setPaymentTermId(String[] paymentTermId) {
		this.paymentTermId = paymentTermId;
	}
	public String[] getPaymentMethodId() {
		return paymentMethodId;
	}
	public void setPaymentMethodId(String[] paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public String getVendorNameAccount() {
		return vendorNameAccount;
	}
	public void setVendorNameAccount(String vendorNameAccount) {
		this.vendorNameAccount = vendorNameAccount;
	}
	public String getAcGroupName() {
		return acGroupName;
	}
	public void setAcGroupName(String acGroupName) {
		this.acGroupName = acGroupName;
	}
	public String getReCondName() {
		return reCondName;
	}
	public void setReCondName(String reCondName) {
		this.reCondName = reCondName;
	}
	public String getPaymentTermName() {
		return paymentTermName;
	}
	public void setPaymentTermName(String paymentTermName) {
		this.paymentTermName = paymentTermName;
	}
	public String getPaymentMethodName() {
		return paymentMethodName;
	}
	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}
	public String getMaterialNameEdit() {
		return MaterialNameEdit;
	}
	public void setMaterialNameEdit(String materialNameEdit) {
		MaterialNameEdit = materialNameEdit;
	}
	
	public String[] getEvendorIdAccount() {
		return evendorIdAccount;
	}
	public void setEvendorIdAccount(String[] evendorIdAccount) {
		this.evendorIdAccount = evendorIdAccount;
	}
	public String[] getEacGroupId() {
		return eacGroupId;
	}
	public void setEacGroupId(String[] eacGroupId) {
		this.eacGroupId = eacGroupId;
	}
	public String[] getEreCondId() {
		return ereCondId;
	}
	public void setEreCondId(String[] ereCondId) {
		this.ereCondId = ereCondId;
	}
	public String[] getEpaymentTermId() {
		return epaymentTermId;
	}
	public void setEpaymentTermId(String[] epaymentTermId) {
		this.epaymentTermId = epaymentTermId;
	}
	public String[] getEpaymentMethodId() {
		return epaymentMethodId;
	}
	public void setEpaymentMethodId(String[] epaymentMethodId) {
		this.epaymentMethodId = epaymentMethodId;
	}
	public String getEvendorNameAccount() {
		return evendorNameAccount;
	}
	public void setEvendorNameAccount(String evendorNameAccount) {
		this.evendorNameAccount = evendorNameAccount;
	}
	public String getEacGroupName() {
		return eacGroupName;
	}
	public void setEacGroupName(String eacGroupName) {
		this.eacGroupName = eacGroupName;
	}
	public String getEreCondName() {
		return ereCondName;
	}
	public void setEreCondName(String ereCondName) {
		this.ereCondName = ereCondName;
	}
	public String getEpaymentTermName() {
		return epaymentTermName;
	}
	public void setEpaymentTermName(String epaymentTermName) {
		this.epaymentTermName = epaymentTermName;
	}
	public String getEpaymentMethodName() {
		return epaymentMethodName;
	}
	public void setEpaymentMethodName(String epaymentMethodName) {
		this.epaymentMethodName = epaymentMethodName;
	}
	public int[] getEvendAccountId() {
		return evendAccountId;
	}
	public void setEvendAccountId(int[] evendAccountId) {
		this.evendAccountId = evendAccountId;
	}
	public Set<VendorAccountDetails> getVendAccount() {
		return vendAccount;
	}
	public void setVendAccount(Set<VendorAccountDetails> vendAccount) {
		this.vendAccount = vendAccount;
	}
	public int[] getCheckedAccount() {
		return checkedAccount;
	}
	public void setCheckedAccount(int[] checkedAccount) {
		this.checkedAccount = checkedAccount;
	}
	public String getStatusId() {
		return statusId;
	}
	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}
	
	
	
	
	
}
