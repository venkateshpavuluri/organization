/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;


/**
 * This is Uom pojo.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

import java.io.Serializable;

@SuppressWarnings("unchecked")

public class Uom implements Serializable{
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	private int uom_Id;
	private String hid;
    private String uom;
    private String uomCode;
    private int aid;
    private int eid;
    
    /*EditProperties*/

	private int editUom_id;
	private String editUom;
	private String editUomCode;
	
	/*getter methods of Uom*/
	
	public int getEid() {
		return eid;
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
	public String getHid() {
		return hid;
	}
	public String getUom() {
		return uom;
	}
	public int getUom_Id() {
		return uom_Id;
	}
	public String getUomCode() {
		return uomCode;
	}
	public int getEditUom_id() {
		return editUom_id;
	}
	public String getEditUom() {
		return editUom;
	}
	public String getEditUomCode() {
		return editUomCode;
	}
	 public int getAid() {
			return aid;
		}
	/*setter methods of Uom*/
	
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setEditUom_id(int editUom_id) {
		this.editUom_id = editUom_id;
	}
	public void setEditUom(String editUom) {
		this.editUom = editUom;
	}
	public void setEditUomCode(String editUomCode) {
		this.editUomCode = editUomCode;
	}
	
    public void setHid(String hid) {
	this.hid = hid;
    }

    public void setUom_Id(int uom_Id) {
	this.uom_Id = uom_Id;
    }

    public void setUom(String uom) {
	this.uom = uom;
    }

    public void setUomCode(String uomCode) {
	this.uomCode = uomCode;
    }
    
    public void setAid(int aid) {
		this.aid = aid;
	}

}
