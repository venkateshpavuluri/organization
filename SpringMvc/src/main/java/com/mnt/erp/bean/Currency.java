/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

/**
 * @author Gkiran
 * @version 1.0v
 * @Date -09-2013
 */

public class Currency {

	private int currencyId;
	private String currency;
	private String isoCode;
	private String symbol;

	private int currencyIdEdit;
	private String currencyEdit;
	private String isoCodeEdit;
	private String symbolEdit;
	private int currencyAddDuplicate;
	private int currencyAddDuplicateUpdate;
	private String currencyEditUpdate;
	private String isoCodeEditUpdate;
	private String symbolEditUpdate;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;

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
	 * @return the currencyId
	 */
	public int getCurrencyId() {
		return currencyId;
	}

	/**
	 * @param currencyId
	 *            the currencyId to set
	 */
	public void setCurrencyId(int currencyId) {
		this.currencyId = currencyId;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency
	 *            the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the isoCode
	 */
	public String getIsoCode() {
		return isoCode;
	}

	/**
	 * @param isoCode
	 *            the isoCode to set
	 */
	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	/**
	 * @return the symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * @param symbol
	 *            the symbol to set
	 */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * @return the currencyIdEdit
	 */
	public int getCurrencyIdEdit() {
		return currencyIdEdit;
	}

	/**
	 * @param currencyIdEdit
	 *            the currencyIdEdit to set
	 */
	public void setCurrencyIdEdit(int currencyIdEdit) {
		this.currencyIdEdit = currencyIdEdit;
	}

	/**
	 * @return the currencyEdit
	 */
	public String getCurrencyEdit() {
		return currencyEdit;
	}

	/**
	 * @param currencyEdit
	 *            the currencyEdit to set
	 */
	public void setCurrencyEdit(String currencyEdit) {
		this.currencyEdit = currencyEdit;
	}

	/**
	 * @return the isoCodeEdit
	 */
	public String getIsoCodeEdit() {
		return isoCodeEdit;
	}

	/**
	 * @param isoCodeEdit
	 *            the isoCodeEdit to set
	 */
	public void setIsoCodeEdit(String isoCodeEdit) {
		this.isoCodeEdit = isoCodeEdit;
	}

	/**
	 * @return the symbolEdit
	 */
	public String getSymbolEdit() {
		return symbolEdit;
	}

	/**
	 * @param symbolEdit
	 *            the symbolEdit to set
	 */
	public void setSymbolEdit(String symbolEdit) {
		this.symbolEdit = symbolEdit;
	}

	/**
	 * @return the currencyAddDuplicate
	 */
	public int getCurrencyAddDuplicate() {
		return currencyAddDuplicate;
	}

	/**
	 * @param currencyAddDuplicate
	 *            the currencyAddDuplicate to set
	 */
	public void setCurrencyAddDuplicate(int currencyAddDuplicate) {
		this.currencyAddDuplicate = currencyAddDuplicate;
	}

	/**
	 * @return the currencyAddDuplicateUpdate
	 */
	public int getCurrencyAddDuplicateUpdate() {
		return currencyAddDuplicateUpdate;
	}

	/**
	 * @param currencyAddDuplicateUpdate
	 *            the currencyAddDuplicateUpdate to set
	 */
	public void setCurrencyAddDuplicateUpdate(int currencyAddDuplicateUpdate) {
		this.currencyAddDuplicateUpdate = currencyAddDuplicateUpdate;
	}

	/**
	 * @return the currencyEditUpdate
	 */
	public String getCurrencyEditUpdate() {
		return currencyEditUpdate;
	}

	/**
	 * @param currencyEditUpdate
	 *            the currencyEditUpdate to set
	 */
	public void setCurrencyEditUpdate(String currencyEditUpdate) {
		this.currencyEditUpdate = currencyEditUpdate;
	}

	/**
	 * @return the isoCodeEditUpdate
	 */
	public String getIsoCodeEditUpdate() {
		return isoCodeEditUpdate;
	}

	/**
	 * @param isoCodeEditUpdate
	 *            the isoCodeEditUpdate to set
	 */
	public void setIsoCodeEditUpdate(String isoCodeEditUpdate) {
		this.isoCodeEditUpdate = isoCodeEditUpdate;
	}

	/**
	 * @return the symbolEditUpdate
	 */
	public String getSymbolEditUpdate() {
		return symbolEditUpdate;
	}

	/**
	 * @param symbolEditUpdate
	 *            the symbolEditUpdate to set
	 */
	public void setSymbolEditUpdate(String symbolEditUpdate) {
		this.symbolEditUpdate = symbolEditUpdate;
	}

}
