/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @author Naresh
 * @version 1.0 23-09-2013
 */
public class CustomerBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private int cuId;
	private int customerId;
	private String customerName;
	private String customerGroupId;
	private String salesAreaId;
	private String companyName;
	private String address;
	private String city;
	private String state;
	private String countryId;
	private String countryName;
	private String zip;
	private String email;
	private String phone;
	private String mobile;
	private String fax;
	private String contactPerson;
	private String contactPersonPhone;
	private String statusId;
	private String active;
	private List<CustomerBankDept> custBank;
	private Set<CustomerAccount> custAccount;
	private List customerBankEditList;
	private CountrysList countrys;
	private CustomerGroup custGroup;
	private SalesAreaBean salesArea;
	private Status status;
	

	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	private int customerBankDetId;
	private String[] bankName;
	private String[] bankAddress;
	private String[] accountType;
	private String[] accountNumber;
	private String[] MICRCode;
	private String[] IFSCCode;
	private int[] efcustomerId;

	// CustomerBank Edit variables
	private int[] ebcustomerId;
	private int[] ecustomerBankDetId;
	private String[] ebankName;
	private String[] ebankAddress;
	private String[] eaccountType;
	private String[] eaccountNumber;
	private String[] emicrCode;
	private String[] eifscCode;

	// Customer Edit variables
	private int cuEditId;
	private int ecustomerId;

	private String ecustomerName;
	private String ecustomerGroupId;
	private String esalesAreaId;
	private String ecompanyName;
	private String eaddress;
	private String ecity;
	private String estate;
	private String ecountryId;
	private String ezip;
	private String eemail;
	private String ephone;
	private String emobile;
	private String efax;
	private String econtactPerson;
	private String econtactPersonPhone;
	private String estatusId;
	private String eactive;

	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;

	// Customer Account Variables
	private int[] custAccountId;
	private String[] customId;
	private String[] acGroupId;
	private String[] reCondId;
	private String[] paymentTermId;
	private String[] paymentMethodId;

	private String customName;
	private String acGroupName;
	private String reCondName;
	private String paymentTermName;
	private String paymentMethodName;

	// Edit Customer Account Variables
	private int[] ecustAccountId;
	private String[] ecustomId;
	private String[] eacGroupId;
	private String[] ereCondId;
	private String[] epaymentTermId;
	private String[] epaymentMethodId;

	private String ecustomName;
	private String eacGroupName;
	private String ereCondName;
	private String epaymentTermName;
	private String epaymentMethodName;

	// Setter And Getter Methods
	
	public String getEactive() {
		return eactive;
	}

	public void setEactive(String eactive) {
		this.eactive = eactive;
	}
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	
	public Status getStatus() {
		return status;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setEstatusId(String estatusId) {
		this.estatusId = estatusId;
	}

	public SalesAreaBean getSalesArea() {
		return salesArea;
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

	public Set<CustomerAccount> getCustAccount() {
		return custAccount;
	}

	public void setCustAccount(Set<CustomerAccount> custAccount) {
		this.custAccount = custAccount;
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

	public void setSalesArea(SalesAreaBean salesArea) {
		this.salesArea = salesArea;
	}

	public CustomerGroup getCustGroup() {
		return custGroup;
	}

	public void setCustGroup(CustomerGroup custGroup) {
		this.custGroup = custGroup;
	}

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

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public CountrysList getCountrys() {
		return countrys;
	}

	public void setCountrys(CountrysList countrys) {
		this.countrys = countrys;
	}

	public int[] getEcustAccountId() {
		return ecustAccountId;
	}

	public String[] getEcustomId() {
		return ecustomId;
	}

	public String[] getEacGroupId() {
		return eacGroupId;
	}

	public String getEcustomName() {
		return ecustomName;
	}

	public String getEacGroupName() {
		return eacGroupName;
	}

	public String getEreCondName() {
		return ereCondName;
	}

	public String getEpaymentTermName() {
		return epaymentTermName;
	}

	public String getEpaymentMethodName() {
		return epaymentMethodName;
	}

	public void setEcustomName(String ecustomName) {
		this.ecustomName = ecustomName;
	}

	public void setEacGroupName(String eacGroupName) {
		this.eacGroupName = eacGroupName;
	}

	public void setEreCondName(String ereCondName) {
		this.ereCondName = ereCondName;
	}

	public void setEpaymentTermName(String epaymentTermName) {
		this.epaymentTermName = epaymentTermName;
	}

	public void setEpaymentMethodName(String epaymentMethodName) {
		this.epaymentMethodName = epaymentMethodName;
	}

	public String[] getEreCondId() {
		return ereCondId;
	}

	public String[] getEpaymentTermId() {
		return epaymentTermId;
	}

	public String[] getEpaymentMethodId() {
		return epaymentMethodId;
	}

	public void setEcustAccountId(int[] ecustAccountId) {
		this.ecustAccountId = ecustAccountId;
	}

	public void setEcustomId(String[] ecustomId) {
		this.ecustomId = ecustomId;
	}

	public void setEacGroupId(String[] eacGroupId) {
		this.eacGroupId = eacGroupId;
	}

	public void setEreCondId(String[] ereCondId) {
		this.ereCondId = ereCondId;
	}

	public void setEpaymentTermId(String[] epaymentTermId) {
		this.epaymentTermId = epaymentTermId;
	}

	public void setEpaymentMethodId(String[] epaymentMethodId) {
		this.epaymentMethodId = epaymentMethodId;
	}

	public String getCustomName() {
		return customName;
	}

	public String getAcGroupName() {
		return acGroupName;
	}

	public String getReCondName() {
		return reCondName;
	}

	public String getPaymentTermName() {
		return paymentTermName;
	}

	public String getPaymentMethodName() {
		return paymentMethodName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public void setAcGroupName(String acGroupName) {
		this.acGroupName = acGroupName;
	}

	public void setReCondName(String reCondName) {
		this.reCondName = reCondName;
	}

	public void setPaymentTermName(String paymentTermName) {
		this.paymentTermName = paymentTermName;
	}

	public void setPaymentMethodName(String paymentMethodName) {
		this.paymentMethodName = paymentMethodName;
	}

	public List getCustomerBankEditList() {
		return customerBankEditList;
	}

	public void setCustomerBankEditList(List customerBankEditList) {
		this.customerBankEditList = customerBankEditList;
	}

	public int[] getCustAccountId() {
		return custAccountId;
	}

	public String[] getCustomId() {
		return customId;
	}

	public String[] getAcGroupId() {
		return acGroupId;
	}

	public String[] getReCondId() {
		return reCondId;
	}

	public String[] getPaymentTermId() {
		return paymentTermId;
	}

	public String[] getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setCustAccountId(int[] custAccountId) {
		this.custAccountId = custAccountId;
	}

	public void setCustomId(String[] customId) {
		this.customId = customId;
	}

	public void setAcGroupId(String[] acGroupId) {
		this.acGroupId = acGroupId;
	}

	public void setReCondId(String[] reCondId) {
		this.reCondId = reCondId;
	}

	public void setPaymentTermId(String[] paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public void setPaymentMethodId(String[] paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public int getCuEditId() {
		return cuEditId;
	}

	public void setCuEditId(int cuEditId) {
		this.cuEditId = cuEditId;
	}

	public int getCuId() {
		return cuId;
	}

	public void setCuId(int cuId) {
		this.cuId = cuId;
	}

	public List<CustomerBankDept> getCustBank() {
		return custBank;
	}

	public void setCustBank(List<CustomerBankDept> custBank) {
		this.custBank = custBank;
	}

	public int[] getEbcustomerId() {
		return ebcustomerId;
	}

	public void setEbcustomerId(int[] ebcustomerId) {
		this.ebcustomerId = ebcustomerId;
	}

	public int[] getEcustomerBankDetId() {
		return ecustomerBankDetId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public void setEcustomerBankDetId(int[] ecustomerBankDetId) {
		this.ecustomerBankDetId = ecustomerBankDetId;
	}

	public String[] getEbankName() {
		return ebankName;
	}

	public void setEbankName(String[] ebankName) {
		this.ebankName = ebankName;
	}

	public String[] getEbankAddress() {
		return ebankAddress;
	}

	public void setEbankAddress(String[] ebankAddress) {
		this.ebankAddress = ebankAddress;
	}

	public String[] getEaccountType() {
		return eaccountType;
	}

	public void setEaccountType(String[] eaccountType) {
		this.eaccountType = eaccountType;
	}

	public String[] getEaccountNumber() {
		return eaccountNumber;
	}

	public void setEaccountNumber(String[] eaccountNumber) {
		this.eaccountNumber = eaccountNumber;
	}

	public String[] getEmicrCode() {
		return emicrCode;
	}

	public void setEmicrCode(String[] emicrCode) {
		this.emicrCode = emicrCode;
	}

	public String[] getEifscCode() {
		return eifscCode;
	}

	public void setEifscCode(String[] eifscCode) {
		this.eifscCode = eifscCode;
	}

	public int[] getEfcustomerId() {
		return efcustomerId;
	}

	public void setEfcustomerId(int[] efcustomerId) {
		this.efcustomerId = efcustomerId;
	}

	public String getEstatusId() {
		return estatusId;
	}

	

	public String getStatusId() {
		return statusId;
	}

	

	public int getEcustomerId() {
		return ecustomerId;
	}

	public void setEcustomerId(int ecustomerId) {
		this.ecustomerId = ecustomerId;
	}

	public String getEcustomerName() {
		return ecustomerName;
	}

	public void setEcustomerName(String ecustomerName) {
		this.ecustomerName = ecustomerName;
	}

	public String getEcustomerGroupId() {
		return ecustomerGroupId;
	}

	public void setEcustomerGroupId(String ecustomerGroupId) {
		this.ecustomerGroupId = ecustomerGroupId;
	}

	public String getEsalesAreaId() {
		return esalesAreaId;
	}

	public void setEsalesAreaId(String esalesAreaId) {
		this.esalesAreaId = esalesAreaId;
	}

	public String getEcompanyName() {
		return ecompanyName;
	}

	public void setEcompanyName(String ecompanyName) {
		this.ecompanyName = ecompanyName;
	}

	public String getEaddress() {
		return eaddress;
	}

	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}

	public String getEcity() {
		return ecity;
	}

	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

	public String getEstate() {
		return estate;
	}

	public void setEstate(String estate) {
		this.estate = estate;
	}

	public String getEcountryId() {
		return ecountryId;
	}

	public void setEcountryId(String ecountryId) {
		this.ecountryId = ecountryId;
	}

	public String getEzip() {
		return ezip;
	}

	public void setEzip(String ezip) {
		this.ezip = ezip;
	}

	public String getEemail() {
		return eemail;
	}

	public void setEemail(String eemail) {
		this.eemail = eemail;
	}

	public String getEphone() {
		return ephone;
	}

	public void setEphone(String ephone) {
		this.ephone = ephone;
	}

	public String getEmobile() {
		return emobile;
	}

	public void setEmobile(String emobile) {
		this.emobile = emobile;
	}

	public String getEfax() {
		return efax;
	}

	public void setEfax(String efax) {
		this.efax = efax;
	}

	public String getEcontactPerson() {
		return econtactPerson;
	}

	public void setEcontactPerson(String econtactPerson) {
		this.econtactPerson = econtactPerson;
	}

	public String getEcontactPersonPhone() {
		return econtactPersonPhone;
	}

	public void setEcontactPersonPhone(String econtactPersonPhone) {
		this.econtactPersonPhone = econtactPersonPhone;
	}

	public int getCustomerBankDetId() {
		return customerBankDetId;
	}

	public void setCustomerBankDetId(int customerBankDetId) {
		this.customerBankDetId = customerBankDetId;
	}

	public String[] getBankName() {
		return bankName;
	}

	public void setBankName(String[] bankName) {
		this.bankName = bankName;
	}

	public String[] getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String[] bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String[] getAccountType() {
		return accountType;
	}

	public void setAccountType(String[] accountType) {
		this.accountType = accountType;
	}

	public String[] getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String[] accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String[] getMICRCode() {
		return MICRCode;
	}

	public void setMICRCode(String[] mICRCode) {
		MICRCode = mICRCode;
	}

	public String[] getIFSCCode() {
		return IFSCCode;
	}

	public void setIFSCCode(String[] iFSCCode) {
		IFSCCode = iFSCCode;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGroupId() {
		return customerGroupId;
	}

	public void setCustomerGroupId(String customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	public String getSalesAreaId() {
		return salesAreaId;
	}

	public void setSalesAreaId(String salesAreaId) {
		this.salesAreaId = salesAreaId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPersonPhone() {
		return contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}

}
