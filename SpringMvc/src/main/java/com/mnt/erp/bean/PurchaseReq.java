
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.bean;

import java.util.List;

/**
 * This is purchaseReq pojo.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class PurchaseReq {

	private int purchaseReq_Id;
	private String purchaseReqNo;
	private String requestedBy;
	private String requestedDate;
	private String requiredate;
	private String reqDate;
	private String orgId;
	private String orgname;
	private String[] requiredDate;
	private String org_Id;
	private String description;
	private String refNo;
	private int status_Id;
	private String status_id;
	private int aid;
	private String[] statusId;
	private String[] plantId;
	private String[] material_Id;
	private String	plantName;
	private String status;
	private Integer[] quantity;
	private List<PurchaseReqLine> purchaseReqLine;
	
	/*Advandced search properties*/
	
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	/*properties for dropdown*/
	
	private String redates; 
	private String statusids;
	private String materialids;
	private String quantities;
	private String plants;
	private String uoms;
	private String storagelocs;
	
	/*Edit properties for drop down */
	private String redatesEdit; 
	private String statusidsEdit;
	private String materialidsEdit;
	private String quantitiesEdit;
	private String plantsEdit;
	private String uomsEdit;
	private String storagelocsEdit;
	private int purchaseReqLine_IdEdit;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	
	/*Edit Properties*/
	private int[] purchaseReqLineIdEditt;
	private int purchaseReq_IdEdit;
	private String purchaseReqNoEdit;
	private String requestedByEdit;
	private String requestedDateEdit;
	private String requiredDateEdit;
	private String[] EditreqiuiredDate;
	private String org_IdEdit; 
	private String[] uom_Id;
	private String[] uom_IdEdit;
	private String descriptionEdit;
	private String refNoEdit;
	private String[] statusIdEdit;
	private int status_IdEdit;
	private String status_idEdit;
	private String[] plantIdEdit;
	private String[] material_IdEdit;
	private Integer[] quantityEdit;
	private String[] storageLocationIdEdit;
	
	
	/*Extra For WorkFlow*/
	
	private String orgName;
	private Organization organization;
	
	//private Integer[] quantity;
	private com.mnt.erp.bean.Status statusDetails;
	private String stepId;
	private String comments;
	private String actionNames;
	private String workFlowListId;
	
	
	
	/*PurchaseReqLine Display Properties*/
	
	private int purchaseReqLine_Id;
	private String purReqLineReqDate;
	private int purReqLineqty;
	private String materialName;
	private String statusName;
	private String purReqLinplantName;
	private String storageLocName;
	private String uomName;
	private String userName;
	
	
	

	/*Edit names*/
	private String materiaName;
	private String uomname;
	private String statuName;
	private String plantname;
	private String storageLoName;

	/*getter methods of PurchaseReq*/
	
	public String getXmlLabel() {
		return xmlLabel;
	}
	
	public int[] getPurchaseReqLineIdEditt() {
		return purchaseReqLineIdEditt;
	}

	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public Organization getOrganization() {
		return organization;
	}
	
	public String getMateriaName() {
		return materiaName;
	}

	public String getUomname() {
		return uomname;
	}

	public String getStatuName() {
		return statuName;
	}

	public String getPlantname() {
		return plantname;
	}

	public String getStorageLoName() {
		return storageLoName;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	public com.mnt.erp.bean.Status getStatusDetails() {
		return statusDetails;
	}
	public void setStatusDetails(com.mnt.erp.bean.Status statusDetails) {
		this.statusDetails = statusDetails;
	}
	public String getStepId() {
		return stepId;
	}
	public void setStepId(String stepId) {
		this.stepId = stepId;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public int getPurchaseReqLine_IdEdit() {
		return purchaseReqLine_IdEdit;
	}

	public void setPurchaseReqLine_IdEdit(int purchaseReqLine_IdEdit) {
		this.purchaseReqLine_IdEdit = purchaseReqLine_IdEdit;
	}

	public String getActionNames() {
		return actionNames;
	}
	public void setActionNames(String actionNames) {
		this.actionNames = actionNames;
	}
	public String getWorkFlowListId() {
		return workFlowListId;
	}
	public void setWorkFlowListId(String workFlowListId) {
		this.workFlowListId = workFlowListId;
	}
	public int getPurchaseReqLine_Id() {
		return purchaseReqLine_Id;
	}
	public void setPurchaseReqLine_Id(int purchaseReqLine_Id) {
		this.purchaseReqLine_Id = purchaseReqLine_Id;
	}
	public String getPurReqLineReqDate() {
		return purReqLineReqDate;
	}
	public void setPurReqLineReqDate(String purReqLineReqDate) {
		this.purReqLineReqDate = purReqLineReqDate;
	}
	public int getPurReqLineqty() {
		return purReqLineqty;
	}
	public void setPurReqLineqty(int purReqLineqty) {
		this.purReqLineqty = purReqLineqty;
	}
	public String getMaterialName() {
		return materialName;
	}
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getPurReqLinplantName() {
		return purReqLinplantName;
	}
	public void setPurReqLinplantName(String purReqLinplantName) {
		this.purReqLinplantName = purReqLinplantName;
	}
	public String getStorageLocName() {
		return storageLocName;
	}
	public void setStorageLocName(String storageLocName) {
		this.storageLocName = storageLocName;
	}
	public String getUomName() {
		return uomName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public String getUserName() {
		return userName;
	}
	
	public void setPurchaseReqLineIdEditt(int[] purchaseReqLineIdEditt) {
		this.purchaseReqLineIdEditt = purchaseReqLineIdEditt;
	}

	public String getFirstLabel() {
		return firstLabel;
	}

	public String getSecondLabel() {
		return secondLabel;
	}

	public String getOperations1() {
		return operations1;
	}

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
	
	public String getStoragelocs() {
		return storagelocs;
	}
	public String[] getStorageLocationIdEdit() {
		return storageLocationIdEdit;
	}
	public String[] getEditreqiuiredDate() {
		return EditreqiuiredDate;
	}
	public int getStatus_IdEdit() {
		return status_IdEdit;
	}
	public String[] getUom_IdEdit() {
		return uom_IdEdit;
	}
	public String getPurchaseReqNoEdit() {
		return purchaseReqNoEdit;
	}
	public String getRequestedByEdit() {
		return requestedByEdit;
	}
	public String getRequestedDateEdit() {
		return requestedDateEdit;
	}
	public String getRequiredDateEdit() {
		return requiredDateEdit;
	}
	public String getOrg_IdEdit() {
		return org_IdEdit;
	}
	public String getDescriptionEdit() {
		return descriptionEdit;
	}
	public String getRefNoEdit() {
		return refNoEdit;
	}
	public String[] getStatusIdEdit() {
		return statusIdEdit;
	}
	public String getStatus_idEdit() {
		return status_idEdit;
	}
	public String[] getPlantIdEdit() {
		return plantIdEdit;
	}
	public String[] getMaterial_IdEdit() {
		return material_IdEdit;
	}
	public Integer[] getQuantityEdit() {
		return quantityEdit;
	}
	public String getRequiredate() {
		return requiredate;
	}
	public List<PurchaseReqLine> getPurchaseReqLine() {
		return purchaseReqLine;
	}
	public String getPlantName() {
		return plantName;
	}
		public String getStatus() {
		return status;
	}
	public String[] getMaterial_Id() {
		return material_Id;
	}
	private String[] storageLocationId;
	
	public String[] getRequiredDate() {
		return requiredDate;
	}
	public String[] getStatusId() {
		return statusId;
	}
	public String[] getPlantId() {
		return plantId;
	}
	public Integer[] getQuantity() {
		return quantity;
	}
	public String[] getStorageLocationId() {
		return storageLocationId;
	}
	public String[] getUom_Id() {
		return uom_Id;
	}
	
	public String getOrgname() {
		return orgname;
	}
	public String getOrgId() {
		return orgId;
	}
	public int getPurchaseReq_IdEdit() {
		return purchaseReq_IdEdit;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public String getReqDate() {
		return reqDate;
	}
	public int getPurchaseReq_Id() {
		return purchaseReq_Id;
	}
	public String getPurchaseReqNo() {
		return purchaseReqNo;
	}
	public String getRequestedBy() {
		return requestedBy;
	}
	public String getOrg_Id() {
		return org_Id;
	}
	public String getRefNo() {
		return refNo;
	}
	public String getDescription() {
		return description;
	}
	public int getStatus_Id() {
		return status_Id;
	}
	public int getAid() {
		return aid;
	}
	
	
	
	public String getRedates() {
		return redates;
	}
	public String getStatusids() {
		return statusids;
	}
	public String getMaterialids() {
		return materialids;
	}
	public String getQuantities() {
		return quantities;
	}
	public String getPlants() {
		return plants;
	}
	public String getUoms() {
		return uoms;
	}
	
	public String getRedatesEdit() {
		return redatesEdit;
	}
	public String getStatusidsEdit() {
		return statusidsEdit;
	}
	public String getMaterialidsEdit() {
		return materialidsEdit;
	}
	public String getQuantitiesEdit() {
		return quantitiesEdit;
	}
	public String getPlantsEdit() {
		return plantsEdit;
	}
	public String getUomsEdit() {
		return uomsEdit;
	}
	public String getStoragelocsEdit() {
		return storagelocsEdit;
	}
	public String getStatus_id() {
		return status_id;
	}
	
	
	
	/*setter methods of PurchaseReq */
	
	public void setMaterial_Id(String[] material_Id) {
		this.material_Id = material_Id;
	}
	public void setPlantId(String[] plantId) {
		this.plantId = plantId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public void setRequiredDate(String[] requiredDate) {
		this.requiredDate = requiredDate;
	}
	public void setUom_Id(String[] uom_Id) {
		this.uom_Id = uom_Id;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setPurchaseReqLine(List<PurchaseReqLine> purchaseReqLine) {
		this.purchaseReqLine = purchaseReqLine;
	}
	public void setMaterial_IdEdit(String[] material_IdEdit) {
		this.material_IdEdit = material_IdEdit;
	}
	public void setStatus_idEdit(String status_idEdit) {
		this.status_idEdit = status_idEdit;
	}
	
	public void setMateriaName(String materiaName) {
		this.materiaName = materiaName;
	}

	public void setUomname(String uomname) {
		this.uomname = uomname;
	}

	public void setStatuName(String statuName) {
		this.statuName = statuName;
	}

	public void setPlantname(String plantname) {
		this.plantname = plantname;
	}

	public void setStorageLoName(String storageLoName) {
		this.storageLoName = storageLoName;
	}

	public void setOrg_IdEdit(String org_IdEdit) {
		this.org_IdEdit = org_IdEdit;
	}
	public void setPlantName(String plantName) {
		this.plantName = plantName;
	}
	public void setStatusId(String[] statusId) {
		this.statusId = statusId;
	}
	public void setRequestedDateEdit(String requestedDateEdit) {
		this.requestedDateEdit = requestedDateEdit;
	}
	public void setPurchaseReq_Id(int purchaseReq_Id) {
		this.purchaseReq_Id = purchaseReq_Id;
	}
	public void setPurchaseReqNoEdit(String purchaseReqNoEdit) {
		this.purchaseReqNoEdit = purchaseReqNoEdit;
	}
	public void setPurchaseReqNo(String purchaseReqNo) {
		this.purchaseReqNo = purchaseReqNo;
	}
	public void setStorageLocationIdEdit(String[] storageLocationIdEdit) {
		this.storageLocationIdEdit = storageLocationIdEdit;
	}
	public void setEditreqiuiredDate(String[] editreqiuiredDate) {
		EditreqiuiredDate = editreqiuiredDate;
	}
	public void setPlantIdEdit(String[] plantIdEdit) {
		this.plantIdEdit = plantIdEdit;
	}
	public void setRequiredate(String requiredate) {
		this.requiredate = requiredate;
	}
	public void setQuantityEdit(Integer[] quantityEdit) {
		this.quantityEdit = quantityEdit;
	}
	public void setUom_IdEdit(String[] uom_IdEdit) {
		this.uom_IdEdit = uom_IdEdit;
	}
	public void setStatus_IdEdit(int status_IdEdit) {
		this.status_IdEdit = status_IdEdit;
	}
	public void setOrg_Id(String org_Id) {
		this.org_Id = org_Id;
	}
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	public void setPurchaseReq_IdEdit(int purchaseReq_IdEdit) {
		this.purchaseReq_IdEdit = purchaseReq_IdEdit;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	public void setStorageLocationId(String[] storageLocationId) {
		this.storageLocationId = storageLocationId;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	public void setStatus_Id(int status_Id) {
		this.status_Id = status_Id;
	}
	public void setRequestedByEdit(String requestedByEdit) {
		this.requestedByEdit = requestedByEdit;
	}
	public void setRequiredDateEdit(String requiredDateEdit) {
		this.requiredDateEdit = requiredDateEdit;
	}
	public void setDescriptionEdit(String descriptionEdit) {
		this.descriptionEdit = descriptionEdit;
	}
	public void setRefNoEdit(String refNoEdit) {
		this.refNoEdit = refNoEdit;
	}
	public void setStatusIdEdit(String[] statusIdEdit) {
		this.statusIdEdit = statusIdEdit;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setStatus_id(String status_id) {
		this.status_id = status_id;
	}
	public void setQuantity(Integer[] quantity) {
		this.quantity = quantity;
	}
	public void setRedates(String redates) {
		this.redates = redates;
	}
	public void setStatusids(String statusids) {
		this.statusids = statusids;
	}
	public void setMaterialids(String materialids) {
		this.materialids = materialids;
	}
	public void setQuantities(String quantities) {
		this.quantities = quantities;
	}
	public void setPlants(String plants) {
		this.plants = plants;
	}
	public void setUoms(String uoms) {
		this.uoms = uoms;
	}
	public void setStoragelocs(String storagelocs) {
		this.storagelocs = storagelocs;
	}
	public void setRedatesEdit(String redatesEdit) {
		this.redatesEdit = redatesEdit;
	}
	public void setStatusidsEdit(String statusidsEdit) {
		this.statusidsEdit = statusidsEdit;
	}
	public void setMaterialidsEdit(String materialidsEdit) {
		this.materialidsEdit = materialidsEdit;
	}
	public void setQuantitiesEdit(String quantitiesEdit) {
		this.quantitiesEdit = quantitiesEdit;
	}
	public void setPlantsEdit(String plantsEdit) {
		this.plantsEdit = plantsEdit;
	}
	public void setUomsEdit(String uomsEdit) {
		this.uomsEdit = uomsEdit;
	}
	public void setStoragelocsEdit(String storagelocsEdit) {
		this.storagelocsEdit = storagelocsEdit;
	}

	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}

	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}

	public void setOperations1(String operations1) {
		this.operations1 = operations1;
	}

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}
	
	
}
