/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author yogi
 * 
 */
public class EventType {
    private int eventTypeId;

    private String eventType;
    private String eventTypeEdit;
    private int aid;

    private String xmlLabel;
    private String operations;
    private String basicSearchId;

    public int getEventTypeId() {
	return eventTypeId;
    }

    public void setEventTypeId(int eventTypeId) {
	this.eventTypeId = eventTypeId;
    }

    public String getEventType() {
	return eventType;
    }

    public void setEventType(String eventType) {
	this.eventType = eventType;
    }

    public String getEventTypeEdit() {
	return eventTypeEdit;
    }

    public void setEventTypeEdit(String eventTypeEdit) {
	this.eventTypeEdit = eventTypeEdit;
    }

    public int getAid() {
	return aid;
    }

    public void setAid(int aid) {
	this.aid = aid;
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

}
