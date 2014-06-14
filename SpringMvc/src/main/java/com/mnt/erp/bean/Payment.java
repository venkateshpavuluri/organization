/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author venkateshp
 * @version 1.0 10-12-2013
 */
public class Payment {

	private int paymentId;
	private String orgId;
	private String paymentMethodId;
	private String bankId;
	private String accountNo;
	private String postingDate;
	private String currecyId;
	private String paymentNo;
	private String amount;
	private String vendorId;
	private String customerId;
	private String vendorInvoiceId;
	private String customerInvoiceId;
	private String paymentTypeId;
	private String chequeNo;
	private String chequeDate;
	private String paymentStatus;
	private String description;
	private String chequeIssuedBy;
	private String chequeIssuedDate;
	private String chequeClearanceStatus;
	private String chequeClearanceDate;
	private int aid;
	private String withHoldReason;
	private String withHoldAmount;
	private List<PaymentWithHold> paymentWithhold;
	private int paymentwithholdid;
	
	
	/*Edit Properties*/
	private String orgIdEdit;
	private String paymentMethodIdEdit;
	private String bankIdEdit;
	private String accountNoEdit;
	private String postingDateEdit;
	private String currecyIdEdit;
	private String paymentNoEdit;
	private String amountEdit;
	private String vendorIdEdit;
	private String customerIdEdit;
	private String vendorInvoiceIdEdit;
	private String customerInvoiceIdEdit;
	private String paymentTypeIdEdit;
	private String chequeNoEdit;
	private String chequeDateEdit;
	private String paymentStatusEdit;
	private String descriptionEdit;
	private String chequeIssuedByEdit;
	private String chequeIssuedDateEdit;
	private String chequeClearanceStatusEdit;
	private String chequeClearanceDateEdit;
	private String BankName;
	private String vendorName;
	private String customerName;
	private String vendorInvName;
	private String customerInvName;
	
	/*RelationShip Properties*/
	
	private Organization  organizationDetails;
	private HouseBankBean bankDetails;
	private Currency currencyDetails;
	private  Vendor vendorDetails;
	private VendorInvoice vendorInvoiceDetails;
	private PaymentType paymentTypeDetails;
	private PaymentMethod paymentMethodDetails;

	
	

	
	



	/**
	 * @return the paymentwithholdid
	 */
	public int getPaymentwithholdid() {
		return paymentwithholdid;
	}

	/**
	 * @param paymentwithholdid the paymentwithholdid to set
	 */
	public void setPaymentwithholdid(int paymentwithholdid) {
		this.paymentwithholdid = paymentwithholdid;
	}

	/**
	 * @return the paymentWithhold
	 */
	public List<PaymentWithHold> getPaymentWithhold() {
		return paymentWithhold;
	}

	/**
	 * @param paymentWithhold the paymentWithhold to set
	 */
	public void setPaymentWithhold(List<PaymentWithHold> paymentWithhold) {
		this.paymentWithhold = paymentWithhold;
	}

	/**
	 * @return the withHoldReason
	 */
	public String getWithHoldReason() {
		return withHoldReason;
	}

	/**
	 * @param withHoldReason the withHoldReason to set
	 */
	public void setWithHoldReason(String withHoldReason) {
		this.withHoldReason = withHoldReason;
	}

	/**
	 * @return the withHoldAmount
	 */
	public String getWithHoldAmount() {
		return withHoldAmount;
	}

	/**
	 * @param withHoldAmount the withHoldAmount to set
	 */
	public void setWithHoldAmount(String withHoldAmount) {
		this.withHoldAmount = withHoldAmount;
	}

/**
	 * @return the orgIdEdit
	 */
	public String getOrgIdEdit() {
		return orgIdEdit;
	}

	/**
	 * @param orgIdEdit the orgIdEdit to set
	 */
	public void setOrgIdEdit(String orgIdEdit) {
		this.orgIdEdit = orgIdEdit;
	}

	/**
	 * @return the paymentMethodIdEdit
	 */
	public String getPaymentMethodIdEdit() {
		return paymentMethodIdEdit;
	}

	/**
	 * @param paymentMethodIdEdit the paymentMethodIdEdit to set
	 */
	public void setPaymentMethodIdEdit(String paymentMethodIdEdit) {
		this.paymentMethodIdEdit = paymentMethodIdEdit;
	}

	/**
	 * @return the bankIdEdit
	 */
	public String getBankIdEdit() {
		return bankIdEdit;
	}

	/**
	 * @param bankIdEdit the bankIdEdit to set
	 */
	public void setBankIdEdit(String bankIdEdit) {
		this.bankIdEdit = bankIdEdit;
	}

	/**
	 * @return the accountNoEdit
	 */
	public String getAccountNoEdit() {
		return accountNoEdit;
	}

	/**
	 * @param accountNoEdit the accountNoEdit to set
	 */
	public void setAccountNoEdit(String accountNoEdit) {
		this.accountNoEdit = accountNoEdit;
	}

	/**
	 * @return the postingDateEdit
	 */
	public String getPostingDateEdit() {
		return postingDateEdit;
	}

	/**
	 * @param postingDateEdit the postingDateEdit to set
	 */
	public void setPostingDateEdit(String postingDateEdit) {
		this.postingDateEdit = postingDateEdit;
	}

	/**
	 * @return the currecyIdEdit
	 */
	public String getCurrecyIdEdit() {
		return currecyIdEdit;
	}

	/**
	 * @param currecyIdEdit the currecyIdEdit to set
	 */
	public void setCurrecyIdEdit(String currecyIdEdit) {
		this.currecyIdEdit = currecyIdEdit;
	}

	/**
	 * @return the paymentNoEdit
	 */
	public String getPaymentNoEdit() {
		return paymentNoEdit;
	}

	/**
	 * @param paymentNoEdit the paymentNoEdit to set
	 */
	public void setPaymentNoEdit(String paymentNoEdit) {
		this.paymentNoEdit = paymentNoEdit;
	}

	/**
	 * @return the amountEdit
	 */
	public String getAmountEdit() {
		return amountEdit;
	}

	/**
	 * @param amountEdit the amountEdit to set
	 */
	public void setAmountEdit(String amountEdit) {
		this.amountEdit = amountEdit;
	}

	/**
	 * @return the vendorIdEdit
	 */
	public String getVendorIdEdit() {
		return vendorIdEdit;
	}

	/**
	 * @param vendorIdEdit the vendorIdEdit to set
	 */
	public void setVendorIdEdit(String vendorIdEdit) {
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
	 * @return the vendorInvoiceIdEdit
	 */
	public String getVendorInvoiceIdEdit() {
		return vendorInvoiceIdEdit;
	}

	/**
	 * @param vendorInvoiceIdEdit the vendorInvoiceIdEdit to set
	 */
	public void setVendorInvoiceIdEdit(String vendorInvoiceIdEdit) {
		this.vendorInvoiceIdEdit = vendorInvoiceIdEdit;
	}

	/**
	 * @return the customerInvoiceIdEdit
	 */
	public String getCustomerInvoiceIdEdit() {
		return customerInvoiceIdEdit;
	}

	/**
	 * @param customerInvoiceIdEdit the customerInvoiceIdEdit to set
	 */
	public void setCustomerInvoiceIdEdit(String customerInvoiceIdEdit) {
		this.customerInvoiceIdEdit = customerInvoiceIdEdit;
	}

	/**
	 * @return the paymentTypeIdEdit
	 */
	public String getPaymentTypeIdEdit() {
		return paymentTypeIdEdit;
	}

	/**
	 * @param paymentTypeIdEdit the paymentTypeIdEdit to set
	 */
	public void setPaymentTypeIdEdit(String paymentTypeIdEdit) {
		this.paymentTypeIdEdit = paymentTypeIdEdit;
	}

	/**
	 * @return the chequeNoEdit
	 */
	public String getChequeNoEdit() {
		return chequeNoEdit;
	}

	/**
	 * @param chequeNoEdit the chequeNoEdit to set
	 */
	public void setChequeNoEdit(String chequeNoEdit) {
		this.chequeNoEdit = chequeNoEdit;
	}

	/**
	 * @return the chequeDateEdit
	 */
	public String getChequeDateEdit() {
		return chequeDateEdit;
	}

	/**
	 * @param chequeDateEdit the chequeDateEdit to set
	 */
	public void setChequeDateEdit(String chequeDateEdit) {
		this.chequeDateEdit = chequeDateEdit;
	}

	/**
	 * @return the paymentStatusEdit
	 */
	public String getPaymentStatusEdit() {
		return paymentStatusEdit;
	}

	/**
	 * @param paymentStatusEdit the paymentStatusEdit to set
	 */
	public void setPaymentStatusEdit(String paymentStatusEdit) {
		this.paymentStatusEdit = paymentStatusEdit;
	}

	/**
	 * @return the descriptionEdit
	 */
	public String getDescriptionEdit() {
		return descriptionEdit;
	}

	/**
	 * @param descriptionEdit the descriptionEdit to set
	 */
	public void setDescriptionEdit(String descriptionEdit) {
		this.descriptionEdit = descriptionEdit;
	}

	/**
	 * @return the chequeIssuedByEdit
	 */
	public String getChequeIssuedByEdit() {
		return chequeIssuedByEdit;
	}

	/**
	 * @param chequeIssuedByEdit the chequeIssuedByEdit to set
	 */
	public void setChequeIssuedByEdit(String chequeIssuedByEdit) {
		this.chequeIssuedByEdit = chequeIssuedByEdit;
	}

	/**
	 * @return the chequeIssuedDateEdit
	 */
	public String getChequeIssuedDateEdit() {
		return chequeIssuedDateEdit;
	}

	/**
	 * @param chequeIssuedDateEdit the chequeIssuedDateEdit to set
	 */
	public void setChequeIssuedDateEdit(String chequeIssuedDateEdit) {
		this.chequeIssuedDateEdit = chequeIssuedDateEdit;
	}

	/**
	 * @return the chequeClearanceStatusEdit
	 */
	public String getChequeClearanceStatusEdit() {
		return chequeClearanceStatusEdit;
	}

	/**
	 * @param chequeClearanceStatusEdit the chequeClearanceStatusEdit to set
	 */
	public void setChequeClearanceStatusEdit(String chequeClearanceStatusEdit) {
		this.chequeClearanceStatusEdit = chequeClearanceStatusEdit;
	}

	/**
	 * @return the chequeClearanceDateEdit
	 */
	public String getChequeClearanceDateEdit() {
		return chequeClearanceDateEdit;
	}

	/**
	 * @param chequeClearanceDateEdit the chequeClearanceDateEdit to set
	 */
	public void setChequeClearanceDateEdit(String chequeClearanceDateEdit) {
		this.chequeClearanceDateEdit = chequeClearanceDateEdit;
	}

/**
	 * @return the bankName
	 */
	public String getBankName() {
		return BankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		BankName = bankName;
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
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the vendorInvName
	 */
	public String getVendorInvName() {
		return vendorInvName;
	}

	/**
	 * @param vendorInvName the vendorInvName to set
	 */
	public void setVendorInvName(String vendorInvName) {
		this.vendorInvName = vendorInvName;
	}

	/**
	 * @return the customerInvName
	 */
	public String getCustomerInvName() {
		return customerInvName;
	}

	/**
	 * @param customerInvName the customerInvName to set
	 */
	public void setCustomerInvName(String customerInvName) {
		this.customerInvName = customerInvName;
	}

	/**
	 * @return the organizationDetails
	 */
	public Organization getOrganizationDetails() {
		return organizationDetails;
	}

	/**
	 * @param organizationDetails the organizationDetails to set
	 */
	public void setOrganizationDetails(Organization organizationDetails) {
		this.organizationDetails = organizationDetails;
	}

	/**
	 * @return the bankDetails
	 */
	public HouseBankBean getBankDetails() {
		return bankDetails;
	}

	/**
	 * @param bankDetails the bankDetails to set
	 */
	public void setBankDetails(HouseBankBean bankDetails) {
		this.bankDetails = bankDetails;
	}

	/**
	 * @return the currencyDetails
	 */
	public Currency getCurrencyDetails() {
		return currencyDetails;
	}

	/**
	 * @param currencyDetails the currencyDetails to set
	 */
	public void setCurrencyDetails(Currency currencyDetails) {
		this.currencyDetails = currencyDetails;
	}

	/**
	 * @return the vendorDetails
	 */
	public Vendor getVendorDetails() {
		return vendorDetails;
	}

	/**
	 * @param vendorDetails the vendorDetails to set
	 */
	public void setVendorDetails(Vendor vendorDetails) {
		this.vendorDetails = vendorDetails;
	}

	/**
	 * @return the customerDetails
	 */
	

	/**
	 * @return the vendorInvoiceDetails
	 */
	public VendorInvoice getVendorInvoiceDetails() {
		return vendorInvoiceDetails;
	}

	/**
	 * @param vendorInvoiceDetails the vendorInvoiceDetails to set
	 */
	public void setVendorInvoiceDetails(VendorInvoice vendorInvoiceDetails) {
		this.vendorInvoiceDetails = vendorInvoiceDetails;
	}

	

	/**
	 * @return the paymentTypeDetails
	 */
	public PaymentType getPaymentTypeDetails() {
		return paymentTypeDetails;
	}

	/**
	 * @param paymentTypeDetails the paymentTypeDetails to set
	 */
	public void setPaymentTypeDetails(PaymentType paymentTypeDetails) {
		this.paymentTypeDetails = paymentTypeDetails;
	}

	/**
	 * @return the paymentMethodDetails
	 */
	public PaymentMethod getPaymentMethodDetails() {
		return paymentMethodDetails;
	}

	/**
	 * @param paymentMethodDetails the paymentMethodDetails to set
	 */
	public void setPaymentMethodDetails(PaymentMethod paymentMethodDetails) {
		this.paymentMethodDetails = paymentMethodDetails;
	}

/**
	 * @return the paymentMethodId
	 */
	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	/**
	 * @param paymentMethodId the paymentMethodId to set
	 */
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

/**
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}

	/**
	 * @param aid the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}

/*Basic Search*/
private String xmlLabel;
private String operations;
private String basicSearchId;

/*Advance Search*/
private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	
	
	
	
	
	/**
	 * @return the xmlLabel
	 */
	public String getXmlLabel() {
		return xmlLabel;
	}

	/**
	 * @param xmlLabel the xmlLabel to set
	 */
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}

	/**
	 * @return the operations
	 */
	public String getOperations() {
		return operations;
	}

	/**
	 * @param operations the operations to set
	 */
	public void setOperations(String operations) {
		this.operations = operations;
	}

	/**
	 * @return the basicSearchId
	 */
	public String getBasicSearchId() {
		return basicSearchId;
	}

	/**
	 * @param basicSearchId the basicSearchId to set
	 */
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

	/**
	 * @return the firstLabel
	 */
	public String getFirstLabel() {
		return firstLabel;
	}

	/**
	 * @param firstLabel the firstLabel to set
	 */
	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}

	/**
	 * @return the secondLabel
	 */
	public String getSecondLabel() {
		return secondLabel;
	}

	/**
	 * @param secondLabel the secondLabel to set
	 */
	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}

	/**
	 * @return the operations1
	 */
	public String getOperations1() {
		return operations1;
	}

	/**
	 * @param operations1 the operations1 to set
	 */
	public void setOperations1(String operations1) {
		this.operations1 = operations1;
	}

	/**
	 * @return the advanceSearchText
	 */
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	/**
	 * @param advanceSearchText the advanceSearchText to set
	 */
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	/**
	 * @return the advanceSearchHidden
	 */
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	/**
	 * @param advanceSearchHidden the advanceSearchHidden to set
	 */
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	/**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}

	/**
	 * @param paymentId
	 *            the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * @return the bankId
	 */
	public String getBankId() {
		return bankId;
	}

	/**
	 * @param bankId
	 *            the bankId to set
	 */
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the accountNo
	 */
	public String getAccountNo() {
		return accountNo;
	}

	/**
	 * @param accountNo
	 *            the accountNo to set
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	/**
	 * @return the postingDate
	 */
	public String getPostingDate() {
		return postingDate;
	}

	/**
	 * @param postingDate
	 *            the postingDate to set
	 */
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	/**
	 * @return the currecyId
	 */
	public String getCurrecyId() {
		return currecyId;
	}

	/**
	 * @param currecyId
	 *            the currecyId to set
	 */
	public void setCurrecyId(String currecyId) {
		this.currecyId = currecyId;
	}

	/**
	 * @return the paymentNo
	 */
	public String getPaymentNo() {
		return paymentNo;
	}

	/**
	 * @param paymentNo
	 *            the paymentNo to set
	 */
	public void setPaymentNo(String paymentNo) {
		this.paymentNo = paymentNo;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the vendorId
	 */
	public String getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId
	 *            the vendorId to set
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the vendorInvoiceId
	 */
	public String getVendorInvoiceId() {
		return vendorInvoiceId;
	}

	/**
	 * @param vendorInvoiceId
	 *            the vendorInvoiceId to set
	 */
	public void setVendorInvoiceId(String vendorInvoiceId) {
		this.vendorInvoiceId = vendorInvoiceId;
	}

	/**
	 * @return the customerInvoiceId
	 */
	public String getCustomerInvoiceId() {
		return customerInvoiceId;
	}

	/**
	 * @param customerInvoiceId
	 *            the customerInvoiceId to set
	 */
	public void setCustomerInvoiceId(String customerInvoiceId) {
		this.customerInvoiceId = customerInvoiceId;
	}

	/**
	 * @return the paymentTypeId
	 */
	public String getPaymentTypeId() {
		return paymentTypeId;
	}

	/**
	 * @param paymentTypeId
	 *            the paymentTypeId to set
	 */
	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}

	/**
	 * @return the chequeNo
	 */
	public String getChequeNo() {
		return chequeNo;
	}

	/**
	 * @param chequeNo
	 *            the chequeNo to set
	 */
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	/**
	 * @return the chequeDate
	 */
	public String getChequeDate() {
		return chequeDate;
	}

	/**
	 * @param chequeDate
	 *            the chequeDate to set
	 */
	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}

	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus
	 *            the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the chequeIssuedBy
	 */
	public String getChequeIssuedBy() {
		return chequeIssuedBy;
	}

	/**
	 * @param chequeIssuedBy
	 *            the chequeIssuedBy to set
	 */
	public void setChequeIssuedBy(String chequeIssuedBy) {
		this.chequeIssuedBy = chequeIssuedBy;
	}

	/**
	 * @return the chequeIssuedDate
	 */
	public String getChequeIssuedDate() {
		return chequeIssuedDate;
	}

	/**
	 * @param chequeIssuedDate
	 *            the chequeIssuedDate to set
	 */
	public void setChequeIssuedDate(String chequeIssuedDate) {
		this.chequeIssuedDate = chequeIssuedDate;
	}

	/**
	 * @return the chequeClearanceStatus
	 */
	public String getChequeClearanceStatus() {
		return chequeClearanceStatus;
	}

	/**
	 * @param chequeClearanceStatus
	 *            the chequeClearanceStatus to set
	 */
	public void setChequeClearanceStatus(String chequeClearanceStatus) {
		this.chequeClearanceStatus = chequeClearanceStatus;
	}

	/**
	 * @return the chequeClearanceDate
	 */
	public String getChequeClearanceDate() {
		return chequeClearanceDate;
	}

	/**
	 * @param chequeClearanceDate
	 *            the chequeClearanceDate to set
	 */
	public void setChequeClearanceDate(String chequeClearanceDate) {
		this.chequeClearanceDate = chequeClearanceDate;
	}

}
