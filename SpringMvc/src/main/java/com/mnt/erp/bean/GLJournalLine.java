/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0  04-01-2014
 */
public class GLJournalLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int glAccountLineId;
	private int glAccountId;
	private String accGroupId;
	private String debitCredit;
	private String amount;
	private String currenId;
	private String tax;
	private String total;
	
	private AccountGroupBean accGroup;
	private Currency curncy;
	
	//Edit Variables
	private int eglAccountLineId;
	private int eglAccountId;
	private String eaccGroupId;
	private String edebitCredit;
	private String eamount;
	private String ecurrenId;
	private String etax;
	private String etotal;
	private String currencyName;
	private String accName;
	
	//Setter And Getter Methods
	
	public int getGlAccountLineId() {
		return glAccountLineId;
	}
	public int getGlAccountId() {
		return glAccountId;
	}
	public String getAccGroupId() {
		return accGroupId;
	}
	public String getDebitCredit() {
		return debitCredit;
	}
	public String getAmount() {
		return amount;
	}
	public String getCurrenId() {
		return currenId;
	}
	public String getTax() {
		return tax;
	}
	public String getTotal() {
		return total;
	}
	public void setGlAccountLineId(int glAccountLineId) {
		this.glAccountLineId = glAccountLineId;
	}
	public void setGlAccountId(int glAccountId) {
		this.glAccountId = glAccountId;
	}
	public void setAccGroupId(String accGroupId) {
		this.accGroupId = accGroupId;
	}
	public void setDebitCredit(String debitCredit) {
		this.debitCredit = debitCredit;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public void setCurrenId(String currenId) {
		this.currenId = currenId;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public AccountGroupBean getAccGroup() {
		return accGroup;
	}
	public Currency getCurncy() {
		return curncy;
	}
	public int getEglAccountLineId() {
		return eglAccountLineId;
	}
	public int getEglAccountId() {
		return eglAccountId;
	}
	public String getEaccGroupId() {
		return eaccGroupId;
	}
	public String getEdebitCredit() {
		return edebitCredit;
	}
	public String getEamount() {
		return eamount;
	}
	public String getEcurrenId() {
		return ecurrenId;
	}
	public String getEtax() {
		return etax;
	}
	public String getEtotal() {
		return etotal;
	}
	public String getCurrencyName() {
		return currencyName;
	}
	public String getAccName() {
		return accName;
	}
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public void setEglAccountLineId(int eglAccountLineId) {
		this.eglAccountLineId = eglAccountLineId;
	}
	public void setEglAccountId(int eglAccountId) {
		this.eglAccountId = eglAccountId;
	}
	public void setEaccGroupId(String eaccGroupId) {
		this.eaccGroupId = eaccGroupId;
	}
	public void setEdebitCredit(String edebitCredit) {
		this.edebitCredit = edebitCredit;
	}
	public void setEamount(String eamount) {
		this.eamount = eamount;
	}
	public void setEcurrenId(String ecurrenId) {
		this.ecurrenId = ecurrenId;
	}
	public void setEtax(String etax) {
		this.etax = etax;
	}
	public void setEtotal(String etotal) {
		this.etotal = etotal;
	}
	public void setAccGroup(AccountGroupBean accGroup) {
		this.accGroup = accGroup;
	}
	public void setCurncy(Currency curncy) {
		this.curncy = curncy;
	}
	
	
	

}
