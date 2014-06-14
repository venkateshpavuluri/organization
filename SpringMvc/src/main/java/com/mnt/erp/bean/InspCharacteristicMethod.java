/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 *
 */
public class InspCharacteristicMethod {

	
	/*InspCharacteristicMethod Table Varialble*/
	 private int inspCharacteristicMethodId;
	 private int inspCharacteristicId;
	 private String inspectionMethodId;
	 private String inspectionMethodName;
	 private InspectionMethodBean  inspectionMethodBeanDetails;
	 
	 
	 
	 
	public int getInspCharacteristicMethodId() {
		return inspCharacteristicMethodId;
	}
	public void setInspCharacteristicMethodId(int inspCharacteristicMethodId) {
		this.inspCharacteristicMethodId = inspCharacteristicMethodId;
	}
	public int getInspCharacteristicId() {
		return inspCharacteristicId;
	}
	public void setInspCharacteristicId(int inspCharacteristicId) {
		this.inspCharacteristicId = inspCharacteristicId;
	}
	public String getInspectionMethodId() {
		return inspectionMethodId;
	}
	public void setInspectionMethodId(String inspectionMethodId) {
		this.inspectionMethodId = inspectionMethodId;
	}
	 
	
	

	 public String getInspectionMethodName() {
		return inspectionMethodName;
	}
	public void setInspectionMethodName(String inspectionMethodName) {
		this.inspectionMethodName = inspectionMethodName;
	}
	public InspectionMethodBean getInspectionMethodBeanDetails() {
		return inspectionMethodBeanDetails;
	}
	public void setInspectionMethodBeanDetails(
			InspectionMethodBean inspectionMethodBeanDetails) {
		this.inspectionMethodBeanDetails = inspectionMethodBeanDetails;
	}
	 
	 
	 
}
