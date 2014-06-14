/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 17-05-2014
 */
public class InspLotEqpBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int inspLotEqpId;
	private String equipmentId;
	private String eqpName;
	private EquipmentBean eqpBean;
	
	// Setter And Getter Methods
	
	public int getInspLotEqpId() {
		return inspLotEqpId;
	}
	public String getEquipmentId() {
		return equipmentId;
	}

	public void setInspLotEqpId(int inspLotEqpId) {
		this.inspLotEqpId = inspLotEqpId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	
	public String getEqpName() {
		return eqpName;
	}
	
	public void setEqpName(String eqpName) {
		this.eqpName = eqpName;
	}
	public EquipmentBean getEqpBean() {
		return eqpBean;
	}
	public void setEqpBean(EquipmentBean eqpBean) {
		this.eqpBean = eqpBean;
	}
	

}
