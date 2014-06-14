/*
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 09-05-2014
 */

public class EventBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int eventId;
    private String event;
    private String fromDate;
    private String toDate;
    private String fromTM;
    private String toTM;
    private String venue;
    private String contactPerson;
    private String contactPhone;
    private String reference;
    private int eId;
    private String xmlLabel;
    private String operations;
    private String basicSearchId;

    // Setter And Getter Methods
    public String getEvent() {
	return event;
    }

    public void setEvent(String event) {
	this.event = event;
    }

    public String getFromDate() {
	return fromDate;
    }

    public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
    }

    public String getToDate() {
	return toDate;
    }

    public void setToDate(String toDate) {
	this.toDate = toDate;
    }

    public String getFromTM() {
	return fromTM;
    }

    public void setFromTM(String fromTM) {
	this.fromTM = fromTM;
    }

    public String getToTM() {
	return toTM;
    }

    public void setToTM(String toTM) {
	this.toTM = toTM;
    }

    public String getVenue() {
	return venue;
    }

    public void setVenue(String venue) {
	this.venue = venue;
    }

    public String getContactPerson() {
	return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
	this.contactPerson = contactPerson;
    }

    public String getContactPhone() {
	return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
	this.contactPhone = contactPhone;
    }

    public String getReference() {
	return reference;
    }

    public void setReference(String reference) {
	this.reference = reference;
    }

    public static long getSerialversionuid() {
	return serialVersionUID;
    }

    public int getEventId() {
	return eventId;
    }

    public void setEventId(int eventId) {
	this.eventId = eventId;
    }

    public int geteId() {
	return eId;
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

    public void seteId(int eId) {
	this.eId = eId;
    }

}
