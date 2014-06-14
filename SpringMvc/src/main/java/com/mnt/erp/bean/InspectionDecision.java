/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author devi
 *
 */
public class InspectionDecision {
	private int inspDecision_Id;
	private String decision;
	private String inspLotOrigin;
	private int aid;
	
	//Edit operations
	private int inspDecision_IdEdit;
	private String decisionEdit;
	private String inspLotOriginEdit;
	
	//Basic Search Properties
	
			private String xmlLabel;
			private String operations;
			private String basicSearchId;
	
   //RelationShip
    private InsplotOrigin inspectBean;
    
    
    //getters & setters

	public int getInspDecision_Id() {
		return inspDecision_Id;
	}

	public void setInspDecision_Id(int inspDecision_Id) {
		this.inspDecision_Id = inspDecision_Id;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getInspDecision_IdEdit() {
		return inspDecision_IdEdit;
	}

	public void setInspDecision_IdEdit(int inspDecision_IdEdit) {
		this.inspDecision_IdEdit = inspDecision_IdEdit;
	}

	public String getDecisionEdit() {
		return decisionEdit;
	}

	public void setDecisionEdit(String decisionEdit) {
		this.decisionEdit = decisionEdit;
	}

	

	public String getInspLotOrigin() {
		return inspLotOrigin;
	}

	public void setInspLotOrigin(String inspLotOrigin) {
		this.inspLotOrigin = inspLotOrigin;
	}

	public String getInspLotOriginEdit() {
		return inspLotOriginEdit;
	}

	public void setInspLotOriginEdit(String inspLotOriginEdit) {
		this.inspLotOriginEdit = inspLotOriginEdit;
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

	public InsplotOrigin getInspectBean() {
		return inspectBean;
	}

	public void setInspectBean(InsplotOrigin inspectBean) {
		this.inspectBean = inspectBean;
	}

	
  
    
    
    
}
