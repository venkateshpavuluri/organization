/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

/**
 * @author Naresh
 * @version 1.0 23-09-2013
 */
public class CustomerBankDept {
	
	private int customerBankDetId;
	private int customerId;
	private String bankName;
	private String bankAddress;
	private String accountType;
	private String accountNumber;
	private String MICRCode;
	private String IFSCCode;
	
	private int ebcustomerId;
	private int ecustomerBankDetId;
	private String ebankName;
	private String ebankAddress;
	private String eaccountType;
	private String eaccountNumber;
	private String emicrCode;
	private String eifscCode;
	
	
	public int getEbcustomerId() {
		return ebcustomerId;
	}
	public void setEbcustomerId(int ebcustomerId) {
		this.ebcustomerId = ebcustomerId;
	}
	public int getEcustomerBankDetId() {
		return ecustomerBankDetId;
	}
	public void setEcustomerBankDetId(int ecustomerBankDetId) {
		this.ecustomerBankDetId = ecustomerBankDetId;
	}
	public String getEbankName() {
		return ebankName;
	}
	public void setEbankName(String ebankName) {
		this.ebankName = ebankName;
	}
	public String getEbankAddress() {
		return ebankAddress;
	}
	public void setEbankAddress(String ebankAddress) {
		this.ebankAddress = ebankAddress;
	}
	public String getEaccountType() {
		return eaccountType;
	}
	public void setEaccountType(String eaccountType) {
		this.eaccountType = eaccountType;
	}
	public String getEaccountNumber() {
		return eaccountNumber;
	}
	public void setEaccountNumber(String eaccountNumber) {
		this.eaccountNumber = eaccountNumber;
	}
	public String getEmicrCode() {
		return emicrCode;
	}
	public void setEmicrCode(String emicrCode) {
		this.emicrCode = emicrCode;
	}
	public String getEifscCode() {
		return eifscCode;
	}
	public void setEifscCode(String eifscCode) {
		this.eifscCode = eifscCode;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCustomerBankDetId() {
		return customerBankDetId;
	}
	public void setCustomerBankDetId(int customerBankDetId) {
		this.customerBankDetId = customerBankDetId;
	}
	
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getMICRCode() {
		return MICRCode;
	}
	public void setMICRCode(String mICRCode) {
		MICRCode = mICRCode;
	}
	public String getIFSCCode() {
		return IFSCCode;
	}
	public void setIFSCCode(String iFSCCode) {
		IFSCCode = iFSCCode;
	}
	
	
}
