/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 21-01-2014
 */
public class ReceiptBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int receiptId;
	private String orgId;
	private String paymentMethodId;
	private String bankId;
	private String accNo;
	private String postingDate;
	private String currencyId;
	private String receiptNo;
	private String amount;
	private String custId;
	private String custInvoiceId;
	private String paymentTypeId;
	private String chequeNo;
	private String chequeDate;
	private String receiptStatus;
	private String desc;
	private String chequeIssuedBy;
	private String chequeIssuedDate;
	private String chequeClearanceStatus;
	private String chequeClearanceDate;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private List<ReceiptWithHold> recWithHold;
	
	private Status status;
	private PaymentType paymentType;
	private PaymentMethod paymentMethod;
	private Organization organization;
	private CustomerBean cust;
	private CustomerInvoice custInvoice;
	private HouseBankBean bank;
	private Currency currency;
	
	//Child Variables
	private int[] recWithHoldId;
	private String[] withHoldReason;
	private String[] withHoldAmount;
	
	
	//Setter And Getter Methods
	
	public int getReceiptId() {
		return receiptId;
	}
	public String getOrgId() {
		return orgId;
	}
	public String getPaymentMethodId() {
		return paymentMethodId;
	}
	public String getBankId() {
		return bankId;
	}
	public String getAccNo() {
		return accNo;
	}
	public String getPostingDate() {
		return postingDate;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public String getReceiptNo() {
		return receiptNo;
	}
	public String getAmount() {
		return amount;
	}
	public String getCustId() {
		return custId;
	}
	public String getCustInvoiceId() {
		return custInvoiceId;
	}
	public String getPaymentTypeId() {
		return paymentTypeId;
	}
	public String getChequeNo() {
		return chequeNo;
	}
	public String getChequeDate() {
		return chequeDate;
	}
	public List<ReceiptWithHold> getRecWithHold() {
		return recWithHold;
	}
	public void setRecWithHold(List<ReceiptWithHold> recWithHold) {
		this.recWithHold = recWithHold;
	}
	public String getReceiptStatus() {
		return receiptStatus;
	}
	public String getDesc() {
		return desc;
	}
	public String getChequeIssuedBy() {
		return chequeIssuedBy;
	}
	public String getChequeIssuedDate() {
		return chequeIssuedDate;
	}
	public String getChequeClearanceStatus() {
		return chequeClearanceStatus;
	}
	public int[] getRecWithHoldId() {
		return recWithHoldId;
	}
	public String[] getWithHoldReason() {
		return withHoldReason;
	}
	public String[] getWithHoldAmount() {
		return withHoldAmount;
	}
	public void setRecWithHoldId(int[] recWithHoldId) {
		this.recWithHoldId = recWithHoldId;
	}
	public void setWithHoldReason(String[] withHoldReason) {
		this.withHoldReason = withHoldReason;
	}
	public void setWithHoldAmount(String[] withHoldAmount) {
		this.withHoldAmount = withHoldAmount;
	}
	public String getXmlLabel() {
		return xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	public String getChequeClearanceDate() {
		return chequeClearanceDate;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public Status getStatus() {
		return status;
	}
	public PaymentType getPaymentType() {
		return paymentType;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public Organization getOrganization() {
		return organization;
	}
	public CustomerBean getCust() {
		return cust;
	}
	public CustomerInvoice getCustInvoice() {
		return custInvoice;
	}
	public HouseBankBean getBank() {
		return bank;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public void setCust(CustomerBean cust) {
		this.cust = cust;
	}
	public void setCustInvoice(CustomerInvoice custInvoice) {
		this.custInvoice = custInvoice;
	}
	public void setBank(HouseBankBean bank) {
		this.bank = bank;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public void setCustInvoiceId(String custInvoiceId) {
		this.custInvoiceId = custInvoiceId;
	}
	public void setPaymentTypeId(String paymentTypeId) {
		this.paymentTypeId = paymentTypeId;
	}
	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}
	public void setChequeDate(String chequeDate) {
		this.chequeDate = chequeDate;
	}
	public void setReceiptStatus(String receiptStatus) {
		this.receiptStatus = receiptStatus;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setChequeIssuedBy(String chequeIssuedBy) {
		this.chequeIssuedBy = chequeIssuedBy;
	}
	public void setChequeIssuedDate(String chequeIssuedDate) {
		this.chequeIssuedDate = chequeIssuedDate;
	}
	public void setChequeClearanceStatus(String chequeClearanceStatus) {
		this.chequeClearanceStatus = chequeClearanceStatus;
	}
	public void setChequeClearanceDate(String chequeClearanceDate) {
		this.chequeClearanceDate = chequeClearanceDate;
	}

}
