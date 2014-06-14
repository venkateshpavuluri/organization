/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 10-12-2013
 */
public class CustomerAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int custAccountId;
	private String customerId;
	private String acGroupId;
	private String reCondId;
	private String paymentTermId;
	private String paymentMethodId;
	
	private String customName;
	private String acGroupName;
	private String reCondName;
	private String paymentTermName;
	private String paymentMethodName;
	
	private PaymentTerms paymentTerm;
	private PaymentMethod paymentMethod;
	private AccountGroupBean acGroup;
	private AccountGroupBean recnd;
	
	
	private String ecustomName;
	private String eacGroupName;
	private String ereCondName;
	private String epaymentTermName;
	private String epaymentMethodName;
	
	//Edit Variables
	private int ecustAccountId;
	private String ecustomerId;
	private String eacGroupId;
	private String ereCondId;
	private String epaymentTermId;
	private String epaymentMethodId;
	
	// Setter And Getter Methods

	public int getCustAccountId() {
		return custAccountId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getAcGroupId() {
		return acGroupId;
	}

	public String getReCondId() {
		return reCondId;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public String getPaymentMethodId() {
		return paymentMethodId;
	}

	public String getCustomName() {
		return customName;
	}

	public String getAcGroupName() {
		return acGroupName;
	}

	public AccountGroupBean getRecnd() {
		return recnd;
	}

	public void setRecnd(AccountGroupBean recnd) {
		this.recnd = recnd;
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

	public void setCustAccountId(int custAccountId) {
		this.custAccountId = custAccountId;
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

	public PaymentTerms getPaymentTerm() {
		return paymentTerm;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public AccountGroupBean getAcGroup() {
		return acGroup;
	}

	public int getEcustAccountId() {
		return ecustAccountId;
	}

	public String getEcustomerId() {
		return ecustomerId;
	}

	public String getEacGroupId() {
		return eacGroupId;
	}

	public String getEreCondId() {
		return ereCondId;
	}

	public String getEpaymentTermId() {
		return epaymentTermId;
	}

	public String getEpaymentMethodId() {
		return epaymentMethodId;
	}

	public void setEcustAccountId(int ecustAccountId) {
		this.ecustAccountId = ecustAccountId;
	}

	public void setEcustomerId(String ecustomerId) {
		this.ecustomerId = ecustomerId;
	}

	public void setEacGroupId(String eacGroupId) {
		this.eacGroupId = eacGroupId;
	}

	public void setEreCondId(String ereCondId) {
		this.ereCondId = ereCondId;
	}

	public void setEpaymentTermId(String epaymentTermId) {
		this.epaymentTermId = epaymentTermId;
	}

	public void setEpaymentMethodId(String epaymentMethodId) {
		this.epaymentMethodId = epaymentMethodId;
	}


	public void setPaymentTerm(PaymentTerms paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public void setAcGroup(AccountGroupBean acGroup) {
		this.acGroup = acGroup;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setAcGroupId(String acGroupId) {
		this.acGroupId = acGroupId;
	}

	public void setReCondId(String reCondId) {
		this.reCondId = reCondId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public void setPaymentMethodId(String paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

}
