/**
@copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author Sailaja
 * @version 1.0 30-10-2013
 * @build 0.0
 * 
 */
public class ReasonForMovement {

	/* =============================Bean Properties======================= */

	private int reasonForMovementId;
	private String reasonForMovement;
	private int aid;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	/* =============================Editt Properties======================= */

	private int reasonForMovementIdEditt;
	private String reasonForMovementEditt;

	/* =============================Getters================================ */

	public int getReasonForMovementId() {
		return reasonForMovementId;
	}

	public String getReasonForMovement() {
		return reasonForMovement;
	}

	public int getAid() {
		return aid;
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

	public int getReasonForMovementIdEditt() {
		return reasonForMovementIdEditt;
	}

	public String getReasonForMovementEditt() {
		return reasonForMovementEditt;
	}
	/* =============================Setters================================ */

	public void setReasonForMovementId(int reasonForMovementId) {
		this.reasonForMovementId = reasonForMovementId;
	}

	public void setReasonForMovement(String reasonForMovement) {
		this.reasonForMovement = reasonForMovement;
	}

	public void setAid(int aid) {
		this.aid = aid;
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

	public void setReasonForMovementIdEditt(int reasonForMovementIdEditt) {
		this.reasonForMovementIdEditt = reasonForMovementIdEditt;
	}

	public void setReasonForMovementEditt(String reasonForMovementEditt) {
		this.reasonForMovementEditt = reasonForMovementEditt;
	}

    
}
