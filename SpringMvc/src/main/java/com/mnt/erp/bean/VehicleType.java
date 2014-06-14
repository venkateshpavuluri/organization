/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.bean;

/**
 * @author anikesh
 *@version 1.0 28-10-2013
 *@build 0.0
 *
 */
public class VehicleType {
	private int vehicletypeId;
	private String vehicletype;
	private String vehicletypeSearch;
	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	private int aid;
	
	private int vehicletypeIdEdit;
	private String vehicletypeEdit;
	public int getVehicletypeId() {
		return vehicletypeId;
	}
	public void setVehicletypeId(int vehicletypeId) {
		this.vehicletypeId = vehicletypeId;
	}
	public String getVehicletype() {
		return vehicletype;
	}
	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}
	public String getVehicletypeSearch() {
		return vehicletypeSearch;
	}
	public void setVehicletypeSearch(String vehicletypeSearch) {
		this.vehicletypeSearch = vehicletypeSearch;
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
	
	
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getVehicletypeIdEdit() {
		return vehicletypeIdEdit;
	}
	public void setVehicletypeIdEdit(int vehicletypeIdEdit) {
		this.vehicletypeIdEdit = vehicletypeIdEdit;
	}
	public String getVehicletypeEdit() {
		return vehicletypeEdit;
	}
	public void setVehicletypeEdit(String vehicletypeEdit) {
		this.vehicletypeEdit = vehicletypeEdit;
	}
	

}
