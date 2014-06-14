/**
 * @copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 *  @version 1.0  14-05-2014
 */
public class ProdOrderProcessEqp implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int popEqpId;
	private int popId;
	private String equipmentId;
	private String uomId;
	private Double estimatedCost;
	private String eqpName;
	private String uomName;
	
	private EquipmentBean equipment;
	private Uom uom;
	
	//Setter and Getter Methods
	
	public int getPopEqpId() {
		return popEqpId;
	}
	public int getPopId() {
		return popId;
	}
	public String getEquipmentId() {
		return equipmentId;
	}
	public String getUomId() {
		return uomId;
	}
	public Double getEstimatedCost() {
		return estimatedCost;
	}
	public void setPopEqpId(int popEqpId) {
		this.popEqpId = popEqpId;
	}
	public void setPopId(int popId) {
		this.popId = popId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public void setUomId(String uomId) {
		this.uomId = uomId;
	}
	public String getEqpName() {
		return eqpName;
	}
	public String getUomName() {
		return uomName;
	}
	public void setEqpName(String eqpName) {
		this.eqpName = eqpName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public void setEstimatedCost(Double estimatedCost) {
		this.estimatedCost = estimatedCost;
	}
	public EquipmentBean getEquipment() {
		return equipment;
	}
	public Uom getUom() {
		return uom;
	}
	public void setEquipment(EquipmentBean equipment) {
		this.equipment = equipment;
	}
	public void setUom(Uom uom) {
		this.uom = uom;
	}
			
	

}
