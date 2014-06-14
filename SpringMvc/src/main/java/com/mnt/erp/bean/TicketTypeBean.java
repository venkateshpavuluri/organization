/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author devi
 *
 */
public class TicketTypeBean {
	private int ticketType_Id;
	private String ticketType;
	private int atId;
	private int ateditId;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	public int getTicketType_Id() {
		return ticketType_Id;
	}
	public void setTicketType_Id(int ticketType_Id) {
		this.ticketType_Id = ticketType_Id;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public int getAtId() {
		return atId;
	}
	public void setAtId(int atId) {
		this.atId = atId;
	}
	public int getAteditId() {
		return ateditId;
	}
	public void setAteditId(int ateditId) {
		this.ateditId = ateditId;
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
