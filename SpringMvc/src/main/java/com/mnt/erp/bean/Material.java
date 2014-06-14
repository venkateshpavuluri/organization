/**
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

import java.util.Set;

/**
 * @author pvenkateswarlu
 * @version 1.0 15-09-2013
 */
public class Material {

	private String materialCode;

	private int material_Id;
	private MaterialCategory category;
	private MaterialType materialTypeValues;
	private String materialCategoryName;
	private String materialTypeName;
	private String taxCategoryName;
	private String uomName;
	private int materialIdEdit;
	private String materialCodeEdit;
	private String materialNameEdit;
	private String materialCategoryEdit;
	private String materialTypeEdit;
	private String taxCatogeryEdit;
	private String uomEdit;
	private String reorderLevel;
	private String maxDeliveryTime;
	private String maxDeliveryTimeUOM;
	private String alternateUOM;
	private int aid;

	private String materialName;
	private String materialDescription;
	private String uom;
	// private String uom;
	private String materialCategory;
	private String materialType;
	private String taxCatogery;

	private String active;
	private String salesUOM;
	private String purchaseUOM;
	private String avgWeight;
	private String avgHeight;
	private String avgLength;
	private String avgVolume;
	private String weightUOM;
	private String heightUOM;
	private String lengthUOM;
	private String dimension;
	private String shelfLife;
	private String shelfLifeUOM;

	private int stock;

	private int[] materialinspId;
	private String inspectionTypeId;
	private String[] inspectionPct;
	private String serialControl;
	private String skip;
	private String[] sampleProc;
	private String activemi;
	private String inspectionName;
	private String serialcontrolName;
	private String skipName;
	private String activeName;
	private Set<MaterialInspection> mibean;
	
	private int[] materialinspIdedit;
	private String inspectionTypeIdedit;
	private String insepectionTypeNameedit;
	private String[] inspectionPctedit;
	private String serialControledit;
	private String skipedit;
	private String[] sampleProcedit;
	private String activemiedit;
	private String inspectionNameedit;
	private String serialcontrolNameedit;
	private String skipNameedit;
	private String activeNameedit;
	

	public String getInsepectionTypeNameedit() {
		return insepectionTypeNameedit;
	}

	public void setInsepectionTypeNameedit(String insepectionTypeNameedit) {
		this.insepectionTypeNameedit = insepectionTypeNameedit;
	}

	public int[] getMaterialinspIdedit() {
		return materialinspIdedit;
	}

	public void setMaterialinspIdedit(int[] materialinspIdedit) {
		this.materialinspIdedit = materialinspIdedit;
	}

	public String getInspectionTypeIdedit() {
		return inspectionTypeIdedit;
	}

	public void setInspectionTypeIdedit(String inspectionTypeIdedit) {
		this.inspectionTypeIdedit = inspectionTypeIdedit;
	}

	public String[] getInspectionPctedit() {
		return inspectionPctedit;
	}

	public void setInspectionPctedit(String[] inspectionPctedit) {
		this.inspectionPctedit = inspectionPctedit;
	}

	public String getSerialControledit() {
		return serialControledit;
	}

	public void setSerialControledit(String serialControledit) {
		this.serialControledit = serialControledit;
	}

	public String getSkipedit() {
		return skipedit;
	}

	public void setSkipedit(String skipedit) {
		this.skipedit = skipedit;
	}

	public String[] getSampleProcedit() {
		return sampleProcedit;
	}

	public void setSampleProcedit(String[] sampleProcedit) {
		this.sampleProcedit = sampleProcedit;
	}

	public String getActivemiedit() {
		return activemiedit;
	}

	public void setActivemiedit(String activemiedit) {
		this.activemiedit = activemiedit;
	}

	public String getInspectionNameedit() {
		return inspectionNameedit;
	}

	public void setInspectionNameedit(String inspectionNameedit) {
		this.inspectionNameedit = inspectionNameedit;
	}

	public String getSerialcontrolNameedit() {
		return serialcontrolNameedit;
	}

	public void setSerialcontrolNameedit(String serialcontrolNameedit) {
		this.serialcontrolNameedit = serialcontrolNameedit;
	}

	public String getSkipNameedit() {
		return skipNameedit;
	}

	public void setSkipNameedit(String skipNameedit) {
		this.skipNameedit = skipNameedit;
	}

	public String getActiveNameedit() {
		return activeNameedit;
	}

	public void setActiveNameedit(String activeNameedit) {
		this.activeNameedit = activeNameedit;
	}

	public Set<MaterialInspection> getMibean() {
		return mibean;
	}

	public void setMibean(Set<MaterialInspection> mibean) {
		this.mibean = mibean;
	}

	public String getSerialControl() {
		return serialControl;
	}

	public void setSerialControl(String serialControl) {
		this.serialControl = serialControl;
	}

	public String getSkip() {
		return skip;
	}

	public void setSkip(String skip) {
		this.skip = skip;
	}

	public String getActivemi() {
		return activemi;
	}

	public void setActivemi(String activemi) {
		this.activemi = activemi;
	}

	public int[] getMaterialinspId() {
		return materialinspId;
	}

	public void setMaterialinspId(int[] materialinspId) {
		this.materialinspId = materialinspId;
	}

	public String getInspectionTypeId() {
		return inspectionTypeId;
	}

	public void setInspectionTypeId(String inspectionTypeId) {
		this.inspectionTypeId = inspectionTypeId;
	}
	public String[] getInspectionPct() {
		return inspectionPct;
	}

	public void setInspectionPct(String[] inspectionPct) {
		this.inspectionPct = inspectionPct;
	}

	public String[] getSampleProc() {
		return sampleProc;
	}

	public void setSampleProc(String[] sampleProc) {
		this.sampleProc = sampleProc;
	}

	public String getInspectionName() {
		return inspectionName;
	}

	public void setInspectionName(String inspectionName) {
		this.inspectionName = inspectionName;
	}

	public String getSerialcontrolName() {
		return serialcontrolName;
	}

	public void setSerialcontrolName(String serialcontrolName) {
		this.serialcontrolName = serialcontrolName;
	}

	public String getSkipName() {
		return skipName;
	}

	public void setSkipName(String skipName) {
		this.skipName = skipName;
	}

	public String getActiveName() {
		return activeName;
	}

	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	private String materialCategoryCode;
	private TaxCategory taxCategory;
	private Uom uomDetails;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	/* Edit Properties */
	private String activeEdit;
	private String salesUOMEdit;
	private String purchaseUOMEdit;
	private String avgWeightEdit;
	private String avgHeightEdit;
	private String avgLengthEdit;
	private String avgVolumeEdit;
	private String weightUOMEdit;
	private String heightUOMEdit;
	private String lengthUOMEdit;
	private String dimensionEdit;
	private String shelfLifeEdit;
	private String shelfLifeUOMEdit;
	private String reorderLevelEdit;
	private String maxDeliveryTimeEdit;
	private String maxDeliveryTimeUOMEdit;
	private String alternateUOMEdit;
	private String materialDescriptionEdit;

	/**
	 * @return the materialDescriptionEdit
	 */
	public String getMaterialDescriptionEdit() {
		return materialDescriptionEdit;
	}

	/**
	 * @param materialDescriptionEdit
	 *            the materialDescriptionEdit to set
	 */
	public void setMaterialDescriptionEdit(String materialDescriptionEdit) {
		this.materialDescriptionEdit = materialDescriptionEdit;
	}

	/**
	 * @return the alternateUOMEdit
	 */
	public String getAlternateUOMEdit() {
		return alternateUOMEdit;
	}

	/**
	 * @param alternateUOMEdit
	 *            the alternateUOMEdit to set
	 */
	public void setAlternateUOMEdit(String alternateUOMEdit) {
		this.alternateUOMEdit = alternateUOMEdit;
	}

	/**
	 * @return the maxDeliveryTimeUOMEdit
	 */
	public String getMaxDeliveryTimeUOMEdit() {
		return maxDeliveryTimeUOMEdit;
	}

	/**
	 * @param maxDeliveryTimeUOMEdit
	 *            the maxDeliveryTimeUOMEdit to set
	 */
	public void setMaxDeliveryTimeUOMEdit(String maxDeliveryTimeUOMEdit) {
		this.maxDeliveryTimeUOMEdit = maxDeliveryTimeUOMEdit;
	}

	/**
	 * @return the maxDeliveryTimeEdit
	 */
	public String getMaxDeliveryTimeEdit() {
		return maxDeliveryTimeEdit;
	}

	/**
	 * @param maxDeliveryTimeEdit
	 *            the maxDeliveryTimeEdit to set
	 */
	public void setMaxDeliveryTimeEdit(String maxDeliveryTimeEdit) {
		this.maxDeliveryTimeEdit = maxDeliveryTimeEdit;
	}

	/**
	 * @return the reorderLevelEdit
	 */
	public String getReorderLevelEdit() {
		return reorderLevelEdit;
	}

	/**
	 * @param reorderLevelEdit
	 *            the reorderLevelEdit to set
	 */
	public void setReorderLevelEdit(String reorderLevelEdit) {
		this.reorderLevelEdit = reorderLevelEdit;
	}

	/**
	 * @param salesUOMEdit
	 *            the salesUOMEdit to set
	 */
	public void setSalesUOMEdit(String salesUOMEdit) {
		this.salesUOMEdit = salesUOMEdit;
	}

	/**
	 * @return the purchaseUOMEdit
	 */
	public String getPurchaseUOMEdit() {
		return purchaseUOMEdit;
	}

	/**
	 * @param purchaseUOMEdit
	 *            the purchaseUOMEdit to set
	 */
	public void setPurchaseUOMEdit(String purchaseUOMEdit) {
		this.purchaseUOMEdit = purchaseUOMEdit;
	}

	/**
	 * @return the avgWeightEdit
	 */
	public String getAvgWeightEdit() {
		return avgWeightEdit;
	}

	/**
	 * @param avgWeightEdit
	 *            the avgWeightEdit to set
	 */
	public void setAvgWeightEdit(String avgWeightEdit) {
		this.avgWeightEdit = avgWeightEdit;
	}

	/**
	 * @return the avgHeightEdit
	 */
	public String getAvgHeightEdit() {
		return avgHeightEdit;
	}

	/**
	 * @param avgHeightEdit
	 *            the avgHeightEdit to set
	 */
	public void setAvgHeightEdit(String avgHeightEdit) {
		this.avgHeightEdit = avgHeightEdit;
	}

	/**
	 * @return the avgLengthEdit
	 */
	public String getAvgLengthEdit() {
		return avgLengthEdit;
	}

	/**
	 * @param avgLengthEdit
	 *            the avgLengthEdit to set
	 */
	public void setAvgLengthEdit(String avgLengthEdit) {
		this.avgLengthEdit = avgLengthEdit;
	}

	/**
	 * @return the avgVolumeEdit
	 */
	public String getAvgVolumeEdit() {
		return avgVolumeEdit;
	}

	/**
	 * @param avgVolumeEdit
	 *            the avgVolumeEdit to set
	 */
	public void setAvgVolumeEdit(String avgVolumeEdit) {
		this.avgVolumeEdit = avgVolumeEdit;
	}

	/**
	 * @return the weightUOMEdit
	 */
	public String getWeightUOMEdit() {
		return weightUOMEdit;
	}

	/**
	 * @param weightUOMEdit
	 *            the weightUOMEdit to set
	 */
	public void setWeightUOMEdit(String weightUOMEdit) {
		this.weightUOMEdit = weightUOMEdit;
	}

	/**
	 * @return the heightUOMEdit
	 */
	public String getHeightUOMEdit() {
		return heightUOMEdit;
	}

	/**
	 * @param heightUOMEdit
	 *            the heightUOMEdit to set
	 */
	public void setHeightUOMEdit(String heightUOMEdit) {
		this.heightUOMEdit = heightUOMEdit;
	}

	/**
	 * @return the lengthUOMEdit
	 */
	public String getLengthUOMEdit() {
		return lengthUOMEdit;
	}

	/**
	 * @param lengthUOMEdit
	 *            the lengthUOMEdit to set
	 */
	public void setLengthUOMEdit(String lengthUOMEdit) {
		this.lengthUOMEdit = lengthUOMEdit;
	}

	/**
	 * @return the dimensionEdit
	 */
	public String getDimensionEdit() {
		return dimensionEdit;
	}

	/**
	 * @param dimensionEdit
	 *            the dimensionEdit to set
	 */
	public void setDimensionEdit(String dimensionEdit) {
		this.dimensionEdit = dimensionEdit;
	}

	/**
	 * @return the shelfLifeEdit
	 */
	public String getShelfLifeEdit() {
		return shelfLifeEdit;
	}

	/**
	 * @param shelfLifeEdit
	 *            the shelfLifeEdit to set
	 */
	public void setShelfLifeEdit(String shelfLifeEdit) {
		this.shelfLifeEdit = shelfLifeEdit;
	}

	/**
	 * @return the shelfLifeUOMEdit
	 */
	public String getShelfLifeUOMEdit() {
		return shelfLifeUOMEdit;
	}

	/**
	 * @param shelfLifeUOMEdit
	 *            the shelfLifeUOMEdit to set
	 */
	public void setShelfLifeUOMEdit(String shelfLifeUOMEdit) {
		this.shelfLifeUOMEdit = shelfLifeUOMEdit;
	}

	/**
	 * @return the materialCode
	 */
	public String getMaterialCode() {
		return materialCode;
	}

	/**
	 * @param materialCode
	 *            the materialCode to set
	 */
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	/**
	 * @return the material_Id
	 */
	public int getMaterial_Id() {
		return material_Id;
	}

	/**
	 * @param material_Id
	 *            the material_Id to set
	 */
	public void setMaterial_Id(int material_Id) {
		this.material_Id = material_Id;
	}

	/**
	 * @return the category
	 */
	public MaterialCategory getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(MaterialCategory category) {
		this.category = category;
	}

	/**
	 * @return the materialTypeValues
	 */
	public MaterialType getMaterialTypeValues() {
		return materialTypeValues;
	}

	/**
	 * @param materialTypeValues
	 *            the materialTypeValues to set
	 */
	public void setMaterialTypeValues(MaterialType materialTypeValues) {
		this.materialTypeValues = materialTypeValues;
	}

	/**
	 * @return the materialCategoryName
	 */
	public String getMaterialCategoryName() {
		return materialCategoryName;
	}

	/**
	 * @param materialCategoryName
	 *            the materialCategoryName to set
	 */
	public void setMaterialCategoryName(String materialCategoryName) {
		this.materialCategoryName = materialCategoryName;
	}

	/**
	 * @return the materialTypeName
	 */
	public String getMaterialTypeName() {
		return materialTypeName;
	}

	/**
	 * @param materialTypeName
	 *            the materialTypeName to set
	 */
	public void setMaterialTypeName(String materialTypeName) {
		this.materialTypeName = materialTypeName;
	}

	/**
	 * @return the taxCategoryName
	 */
	public String getTaxCategoryName() {
		return taxCategoryName;
	}

	/**
	 * @param taxCategoryName
	 *            the taxCategoryName to set
	 */
	public void setTaxCategoryName(String taxCategoryName) {
		this.taxCategoryName = taxCategoryName;
	}

	/**
	 * @return the uomName
	 */
	public String getUomName() {
		return uomName;
	}

	/**
	 * @param uomName
	 *            the uomName to set
	 */
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	/**
	 * @return the materialIdEdit
	 */
	public int getMaterialIdEdit() {
		return materialIdEdit;
	}

	/**
	 * @param materialIdEdit
	 *            the materialIdEdit to set
	 */
	public void setMaterialIdEdit(int materialIdEdit) {
		this.materialIdEdit = materialIdEdit;
	}

	/**
	 * @return the materialCodeEdit
	 */
	public String getMaterialCodeEdit() {
		return materialCodeEdit;
	}

	/**
	 * @param materialCodeEdit
	 *            the materialCodeEdit to set
	 */
	public void setMaterialCodeEdit(String materialCodeEdit) {
		this.materialCodeEdit = materialCodeEdit;
	}

	/**
	 * @return the materialNameEdit
	 */
	public String getMaterialNameEdit() {
		return materialNameEdit;
	}

	/**
	 * @param materialNameEdit
	 *            the materialNameEdit to set
	 */
	public void setMaterialNameEdit(String materialNameEdit) {
		this.materialNameEdit = materialNameEdit;
	}

	/**
	 * @return the materialCategoryEdit
	 */
	public String getMaterialCategoryEdit() {
		return materialCategoryEdit;
	}

	/**
	 * @param materialCategoryEdit
	 *            the materialCategoryEdit to set
	 */
	public void setMaterialCategoryEdit(String materialCategoryEdit) {
		this.materialCategoryEdit = materialCategoryEdit;
	}

	/**
	 * @return the materialTypeEdit
	 */
	public String getMaterialTypeEdit() {
		return materialTypeEdit;
	}

	/**
	 * @param materialTypeEdit
	 *            the materialTypeEdit to set
	 */
	public void setMaterialTypeEdit(String materialTypeEdit) {
		this.materialTypeEdit = materialTypeEdit;
	}

	/**
	 * @return the taxCatogeryEdit
	 */
	public String getTaxCatogeryEdit() {
		return taxCatogeryEdit;
	}

	/**
	 * @param taxCatogeryEdit
	 *            the taxCatogeryEdit to set
	 */
	public void setTaxCatogeryEdit(String taxCatogeryEdit) {
		this.taxCatogeryEdit = taxCatogeryEdit;
	}

	/**
	 * @return the uomEdit
	 */
	public String getUomEdit() {
		return uomEdit;
	}

	/**
	 * @param uomEdit
	 *            the uomEdit to set
	 */
	public void setUomEdit(String uomEdit) {
		this.uomEdit = uomEdit;
	}

	/**
	 * @return the reorderLevel
	 */
	public String getReorderLevel() {
		return reorderLevel;
	}

	/**
	 * @param reorderLevel
	 *            the reorderLevel to set
	 */
	public void setReorderLevel(String reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	/**
	 * @return the maxDeliveryTime
	 */
	public String getMaxDeliveryTime() {
		return maxDeliveryTime;
	}

	/**
	 * @param maxDeliveryTime
	 *            the maxDeliveryTime to set
	 */
	public void setMaxDeliveryTime(String maxDeliveryTime) {
		this.maxDeliveryTime = maxDeliveryTime;
	}

	/**
	 * @return the maxDeliveryTimeUOM
	 */
	public String getMaxDeliveryTimeUOM() {
		return maxDeliveryTimeUOM;
	}

	/**
	 * @param maxDeliveryTimeUOM
	 *            the maxDeliveryTimeUOM to set
	 */
	public void setMaxDeliveryTimeUOM(String maxDeliveryTimeUOM) {
		this.maxDeliveryTimeUOM = maxDeliveryTimeUOM;
	}

	/**
	 * @return the alternateUOM
	 */
	public String getAlternateUOM() {
		return alternateUOM;
	}

	/**
	 * @param alternateUOM
	 *            the alternateUOM to set
	 */
	public void setAlternateUOM(String alternateUOM) {
		this.alternateUOM = alternateUOM;
	}

	/**
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}

	/**
	 * @param aid
	 *            the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}

	/**
	 * @return the materialName
	 */
	public String getMaterialName() {
		return materialName;
	}

	/**
	 * @param materialName
	 *            the materialName to set
	 */
	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	/**
	 * @return the materialDescription
	 */
	public String getMaterialDescription() {
		return materialDescription;
	}

	/**
	 * @param materialDescription
	 *            the materialDescription to set
	 */
	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	/**
	 * @return the uom
	 */
	public String getUom() {
		return uom;
	}

	/**
	 * @param uom
	 *            the uom to set
	 */
	public void setUom(String uom) {
		this.uom = uom;
	}

	/**
	 * @return the materialCategory
	 */
	public String getMaterialCategory() {
		return materialCategory;
	}

	/**
	 * @param materialCategory
	 *            the materialCategory to set
	 */
	public void setMaterialCategory(String materialCategory) {
		this.materialCategory = materialCategory;
	}

	/**
	 * @return the materialType
	 */
	public String getMaterialType() {
		return materialType;
	}

	/**
	 * @param materialType
	 *            the materialType to set
	 */
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	/**
	 * @return the taxCatogery
	 */
	public String getTaxCatogery() {
		return taxCatogery;
	}

	/**
	 * @param taxCatogery
	 *            the taxCatogery to set
	 */
	public void setTaxCatogery(String taxCatogery) {
		this.taxCatogery = taxCatogery;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	/**
	 * @return the activeEdit
	 */
	public String getActiveEdit() {
		return activeEdit;
	}

	/**
	 * @param activeEdit
	 *            the activeEdit to set
	 */
	public void setActiveEdit(String activeEdit) {
		this.activeEdit = activeEdit;
	}

	/**
	 * @return the salesUOMEdit
	 */
	public String getSalesUOMEdit() {
		return salesUOMEdit;
	}

	/**
	 * @return the salesUOM
	 */
	public String getSalesUOM() {
		return salesUOM;
	}

	/**
	 * @param salesUOM
	 *            the salesUOM to set
	 */
	public void setSalesUOM(String salesUOM) {
		this.salesUOM = salesUOM;
	}

	/**
	 * @return the purchaseUOM
	 */
	public String getPurchaseUOM() {
		return purchaseUOM;
	}

	/**
	 * @param purchaseUOM
	 *            the purchaseUOM to set
	 */
	public void setPurchaseUOM(String purchaseUOM) {
		this.purchaseUOM = purchaseUOM;
	}

	/**
	 * @return the avgWeight
	 */
	public String getAvgWeight() {
		return avgWeight;
	}

	/**
	 * @param avgWeight
	 *            the avgWeight to set
	 */
	public void setAvgWeight(String avgWeight) {
		this.avgWeight = avgWeight;
	}

	/**
	 * @return the avgHeight
	 */
	public String getAvgHeight() {
		return avgHeight;
	}

	/**
	 * @param avgHeight
	 *            the avgHeight to set
	 */
	public void setAvgHeight(String avgHeight) {
		this.avgHeight = avgHeight;
	}

	/**
	 * @return the avgLength
	 */
	public String getAvgLength() {
		return avgLength;
	}

	/**
	 * @param avgLength
	 *            the avgLength to set
	 */
	public void setAvgLength(String avgLength) {
		this.avgLength = avgLength;
	}

	/**
	 * @return the avgVolume
	 */
	public String getAvgVolume() {
		return avgVolume;
	}

	/**
	 * @param avgVolume
	 *            the avgVolume to set
	 */
	public void setAvgVolume(String avgVolume) {
		this.avgVolume = avgVolume;
	}

	/**
	 * @return the weightUOM
	 */
	public String getWeightUOM() {
		return weightUOM;
	}

	/**
	 * @param weightUOM
	 *            the weightUOM to set
	 */
	public void setWeightUOM(String weightUOM) {
		this.weightUOM = weightUOM;
	}

	/**
	 * @return the heightUOM
	 */
	public String getHeightUOM() {
		return heightUOM;
	}

	/**
	 * @param heightUOM
	 *            the heightUOM to set
	 */
	public void setHeightUOM(String heightUOM) {
		this.heightUOM = heightUOM;
	}

	/**
	 * @return the lengthUOM
	 */
	public String getLengthUOM() {
		return lengthUOM;
	}

	/**
	 * @param lengthUOM
	 *            the lengthUOM to set
	 */
	public void setLengthUOM(String lengthUOM) {
		this.lengthUOM = lengthUOM;
	}

	/**
	 * @return the dimension
	 */
	public String getDimension() {
		return dimension;
	}

	/**
	 * @param dimension
	 *            the dimension to set
	 */
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	/**
	 * @return the shelfLife
	 */
	public String getShelfLife() {
		return shelfLife;
	}

	/**
	 * @param shelfLife
	 *            the shelfLife to set
	 */
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	/**
	 * @return the shelfLifeUOM
	 */
	public String getShelfLifeUOM() {
		return shelfLifeUOM;
	}

	/**
	 * @param shelfLifeUOM
	 *            the shelfLifeUOM to set
	 */
	public void setShelfLifeUOM(String shelfLifeUOM) {
		this.shelfLifeUOM = shelfLifeUOM;
	}

	/**
	 * @return the materialCategoryCode
	 */
	public String getMaterialCategoryCode() {
		return materialCategoryCode;
	}

	/**
	 * @param materialCategoryCode
	 *            the materialCategoryCode to set
	 */
	public void setMaterialCategoryCode(String materialCategoryCode) {
		this.materialCategoryCode = materialCategoryCode;
	}

	/**
	 * @return the taxCategory
	 */
	public TaxCategory getTaxCategory() {
		return taxCategory;
	}

	/**
	 * @param taxCategory
	 *            the taxCategory to set
	 */
	public void setTaxCategory(TaxCategory taxCategory) {
		this.taxCategory = taxCategory;
	}

	/**
	 * @return the uomDetails
	 */
	public Uom getUomDetails() {
		return uomDetails;
	}

	/**
	 * @param uomDetails
	 *            the uomDetails to set
	 */
	public void setUomDetails(Uom uomDetails) {
		this.uomDetails = uomDetails;
	}

	/**
	 * @return the xmlLabel
	 */
	public String getXmlLabel() {
		return xmlLabel;
	}

	/**
	 * @param xmlLabel
	 *            the xmlLabel to set
	 */
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}

	/**
	 * @return the operations
	 */
	public String getOperations() {
		return operations;
	}

	/**
	 * @param operations
	 *            the operations to set
	 */
	public void setOperations(String operations) {
		this.operations = operations;
	}

	/**
	 * @return the basicSearchId
	 */
	public String getBasicSearchId() {
		return basicSearchId;
	}

	/**
	 * @param basicSearchId
	 *            the basicSearchId to set
	 */
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}

}
