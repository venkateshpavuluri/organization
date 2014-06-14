/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 04-01-2014
 */
public class GLJournalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int glAccountId;
	private String glAccountDT;
	private String postingDT;
	private String reference;
	private String orgId;
	private String currencyId;
	private String glFiscalYearId;
	private String description;
	private String createdBy;
	private String createdDTTM;
	private String modifiedBy;
	private String modifiedDTTM;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;

	private GLFiscalYear glFiscalYear;
	private Currency currency;
	private Organization organization;
	private List<GLJournalLine> glJournalLine;
	
	//Child Variabes
	private int[] glAccountLineId;
	private String[] accGroupId;
	private String[] debitCredit;
	private String[] amount;
	private String[] currenId;
	private String[] tax;
	private String[] total;
	private String accGroup;
	private String curId;
	private String dc;
	
	//Edit Variables
	
	private int eglAccountId;
	private String eglAccountDT;
	private String epostingDT;
	private String ereference;
	private String eorgId;
	private String ecurrencyId;
	private String eglFiscalYearId;
	private String edescription;
	private String ecreatedBy;
	private String ecreatedDTTM;
	
	//Edit Child Variables
	private int[] eglAccountLineId;
	private String[] eaccGroupId;
	public String getLabels() {
		return labels;
	}

	public String getDbField() {
		return dbField;
	}

	public String getAsOpts() {
		return asOpts;
	}

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public void setDbField(String dbField) {
		this.dbField = dbField;
	}

	public void setAsOpts(String asOpts) {
		this.asOpts = asOpts;
	}

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	private String[] edebitCredit;
	private String[] eamount;
	private String[] ecurrenId;
	private String[] etax;
	private String[] etotal;
	private String currencyName;
	private String accName;
	
	

	// Setter And Getter Methods

	public int getGlAccountId() {
		return glAccountId;
	}

	public String getGlAccountDT() {
		return glAccountDT;
	}

	public String getPostingDT() {
		return postingDT;
	}

	public String getReference() {
		return reference;
	}

	public String getOrgId() {
		return orgId;
	}

	public String getCurrencyId() {
		return currencyId;
	}

	public String getGlFiscalYearId() {
		return glFiscalYearId;
	}

	public String getDescription() {
		return description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getCreatedDTTM() {
		return createdDTTM;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public String getModifiedDTTM() {
		return modifiedDTTM;
	}

	public void setGlAccountId(int glAccountId) {
		this.glAccountId = glAccountId;
	}

	public void setGlAccountDT(String glAccountDT) {
		this.glAccountDT = glAccountDT;
	}

	public void setPostingDT(String postingDT) {
		this.postingDT = postingDT;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}

	public void setGlFiscalYearId(String glFiscalYearId) {
		this.glFiscalYearId = glFiscalYearId;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreatedDTTM(String createdDTTM) {
		this.createdDTTM = createdDTTM;
	}

	public int getEglAccountId() {
		return eglAccountId;
	}

	public String getEglAccountDT() {
		return eglAccountDT;
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

	public String getEpostingDT() {
		return epostingDT;
	}

	public String getEreference() {
		return ereference;
	}

	public String getEorgId() {
		return eorgId;
	}

	public String getEcurrencyId() {
		return ecurrencyId;
	}

	public String getEglFiscalYearId() {
		return eglFiscalYearId;
	}

	public String getEdescription() {
		return edescription;
	}

	public String getEcreatedBy() {
		return ecreatedBy;
	}

	public String getEcreatedDTTM() {
		return ecreatedDTTM;
	}

	public int[] getEglAccountLineId() {
		return eglAccountLineId;
	}

	public String[] getEaccGroupId() {
		return eaccGroupId;
	}

	public String[] getEdebitCredit() {
		return edebitCredit;
	}

	public String[] getEamount() {
		return eamount;
	}

	public String[] getEcurrenId() {
		return ecurrenId;
	}

	public String[] getEtax() {
		return etax;
	}

	public String[] getEtotal() {
		return etotal;
	}

	public void setEglAccountId(int eglAccountId) {
		this.eglAccountId = eglAccountId;
	}

	public void setEglAccountDT(String eglAccountDT) {
		this.eglAccountDT = eglAccountDT;
	}

	public void setEpostingDT(String epostingDT) {
		this.epostingDT = epostingDT;
	}

	public void setEreference(String ereference) {
		this.ereference = ereference;
	}

	public void setEorgId(String eorgId) {
		this.eorgId = eorgId;
	}

	public void setEcurrencyId(String ecurrencyId) {
		this.ecurrencyId = ecurrencyId;
	}

	public void setEglFiscalYearId(String eglFiscalYearId) {
		this.eglFiscalYearId = eglFiscalYearId;
	}

	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}

	public void setEcreatedBy(String ecreatedBy) {
		this.ecreatedBy = ecreatedBy;
	}

	public void setEcreatedDTTM(String ecreatedDTTM) {
		this.ecreatedDTTM = ecreatedDTTM;
	}

	public void setEglAccountLineId(int[] eglAccountLineId) {
		this.eglAccountLineId = eglAccountLineId;
	}

	public void setEaccGroupId(String[] eaccGroupId) {
		this.eaccGroupId = eaccGroupId;
	}

	public void setEdebitCredit(String[] edebitCredit) {
		this.edebitCredit = edebitCredit;
	}

	public void setEamount(String[] eamount) {
		this.eamount = eamount;
	}

	public void setEcurrenId(String[] ecurrenId) {
		this.ecurrenId = ecurrenId;
	}

	public void setEtax(String[] etax) {
		this.etax = etax;
	}

	public void setEtotal(String[] etotal) {
		this.etotal = etotal;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public void setModifiedDTTM(String modifiedDTTM) {
		this.modifiedDTTM = modifiedDTTM;
	}

	public String getXmlLabel() {
		return xmlLabel;
	}

	public String getOperations() {
		return operations;
	}

	public String getAccGroup() {
		return accGroup;
	}

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}

	public String getCurId() {
		return curId;
	}

	public void setAccGroup(String accGroup) {
		this.accGroup = accGroup;
	}

	public void setCurId(String curId) {
		this.curId = curId;
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

	public int[] getGlAccountLineId() {
		return glAccountLineId;
	}

	public String[] getAccGroupId() {
		return accGroupId;
	}

	public String[] getDebitCredit() {
		return debitCredit;
	}

	public String[] getAmount() {
		return amount;
	}

	public String[] getCurrenId() {
		return currenId;
	}

	public String[] getTax() {
		return tax;
	}

	public String[] getTotal() {
		return total;
	}

	public void setGlAccountLineId(int[] glAccountLineId) {
		this.glAccountLineId = glAccountLineId;
	}

	public void setAccGroupId(String[] accGroupId) {
		this.accGroupId = accGroupId;
	}

	public void setDebitCredit(String[] debitCredit) {
		this.debitCredit = debitCredit;
	}

	public void setAmount(String[] amount) {
		this.amount = amount;
	}

	public void setCurrenId(String[] currenId) {
		this.currenId = currenId;
	}

	public void setTax(String[] tax) {
		this.tax = tax;
	}

	public void setTotal(String[] total) {
		this.total = total;
	}

	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

	public GLFiscalYear getGlFiscalYear() {
		return glFiscalYear;
	}

	public Currency getCurrency() {
		return currency;
	}

	public Organization getOrganization() {
		return organization;
	}

	public List<GLJournalLine> getGlJournalLine() {
		return glJournalLine;
	}

	public void setGlFiscalYear(GLFiscalYear glFiscalYear) {
		this.glFiscalYear = glFiscalYear;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public void setGlJournalLine(List<GLJournalLine> glJournalLine) {
		this.glJournalLine = glJournalLine;
	}

}
