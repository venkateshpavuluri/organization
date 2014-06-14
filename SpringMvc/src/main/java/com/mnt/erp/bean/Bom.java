/**
@copyright MNTSOFT

 * 
 */
package com.mnt.erp.bean;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0 08-11-2013
 * @build 0.0
 *
 */
public class Bom 
{
	/* ============================Bean Properties======================= */
	private int bomId;
	private String bmaterial_Id;
	private String plant_Id;
	private String usage;
	private String bomCategoryId;
	private String revisionLevel;
	private String bomNumber;
	private int aid;
	private String qty;
	private String qtyEdit;
	private String uOMId;
	private String uOMIdEdit;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	

	private int bomLineId; 
	private String[] material_Id;
	private String mId;
	private Integer[] quantity;
	private String[] uom_Id;
	private String uomm;
	private Integer[] explosionLevel;
	private Integer[] predessor;
	private String[] parentMaterial;
	private String parentMat;
	/*==========================Advance Search============================================*/
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	/* ============================= Bean class Objests======================================*/

	public String getFirstLabel() {
		return firstLabel;
	}

	public void setFirstLabel(String firstLabel) {
		this.firstLabel = firstLabel;
	}

	public String getSecondLabel() {
		return secondLabel;
	}

	public void setSecondLabel(String secondLabel) {
		this.secondLabel = secondLabel;
	}

	public String getOperations1() {
		return operations1;
	}

	public void setOperations1(String operations1) {
		this.operations1 = operations1;
	}

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	

	public void setUom_IdEditt(String[] uom_IdEditt) {
		this.uom_IdEditt = uom_IdEditt;
	}

	private Material materialBean;
	private Plant plantBean;
	private BomCategory bomCategoryBean;
	
	public Material getMaterialBean() {
		return materialBean;
	}

	public void setMaterialBean(Material materialBean) {
		this.materialBean = materialBean;
	}

	public Plant getPlantBean() {
		return plantBean;
	}

	public void setPlantBean(Plant plantBean) {
		this.plantBean = plantBean;
	}
	public BomCategory getBomCategoryBean() {
		return bomCategoryBean;
	}

	public void setBomCategoryBean(BomCategory bomCategoryBean) {
		this.bomCategoryBean = bomCategoryBean;
	}
	
	/*========================others================================================*/
	private String materialName;
	private String parentMaterialName;
	private String uomName;
	
	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getUomName() {
		return uomName;
	}

	public void setUomName(String uomName) {
		this.uomName = uomName;
	}

	
	/* ============================= Edit Properties======================================*/


	private int bomIdEditt;
	private String bmaterial_IdEditt;
	private String plant_IdEditt;
	private String usageEditt;
	private String bomCategoryIdEditt;
	private String revisionLevelEditt;
	private String bomNumberEditt;
	
	private int[] bomLineIdEditt; 
	private String[] material_IdEditt;
	private String mIdEditt;
	private Integer[] quantityEditt;
	private String[] uom_IdEditt;
	private String uommEditt;
	private Integer[] explosionLevelEditt;
	private Integer[] predessorEditt;
	private String[] parentMaterialEditt;
	private String parentMatEditt;
	/* ====================Child PoJO List============================ */
	private List<BomLine> bomLine;

	public List<BomLine> getBomLine() {
		return bomLine;
	}

	public void setBomLine(List<BomLine> bomLine) {
		this.bomLine = bomLine;
	}
	
	
	public String getParentMaterialName() {
		return parentMaterialName;
	}

	public void setParentMaterialName(String parentMaterialName) {
		this.parentMaterialName = parentMaterialName;
	}

	/* ============================= Getters================================================*/
	public int getBomId() {
		return bomId;
	}
	public String getBmaterial_Id() {
		return bmaterial_Id;
	}
	public String getPlant_Id() {
		return plant_Id;
	}
	public String getUsage() {
		return usage;
	}
	public String getBomCategoryId() {
		return bomCategoryId;
	}
	public String getRevisionLevel() {
		return revisionLevel;
	}
	public String getBomNumber() {
		return bomNumber;
	}
	public int getAid() {
		return aid;
	}
	public String getXmlLabel() {
		return xmlLabel;
	}
	public String getOperations() {
		return operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public int getBomLineId() {
		return bomLineId;
	}
	public String[] getMaterial_Id() {
		return material_Id;
	}
	public Integer[] getQuantity() {
		return quantity;
	}
	public String[] getUom_Id() {
		return uom_Id;
	}
	
	public String getmId() {
		return mId;
	}

	public String getUomm() {
		return uomm;
	}

	public String getmIdEditt() {
		return mIdEditt;
	}

	public String getUommEditt() {
		return uommEditt;
	}

	public Integer[] getExplosionLevel() {
		return explosionLevel;
	}
	public Integer[] getPredessor() {
		return predessor;
	}
	public int getBomIdEditt() {
		return bomIdEditt;
	}
	public String getBmaterial_IdEditt() {
		return bmaterial_IdEditt;
	}
	public String getPlant_IdEditt() {
		return plant_IdEditt;
	}
	public String getUsageEditt() {
		return usageEditt;
	}
	public String getBomCategoryIdEditt() {
		return bomCategoryIdEditt;
	}
	public String getRevisionLevelEditt() {
		return revisionLevelEditt;
	}
	public String getBomNumberEditt() {
		return bomNumberEditt;
	}
	public int[] getBomLineIdEditt() {
		return bomLineIdEditt;
	}
	public String[] getMaterial_IdEditt() {
		return material_IdEditt;
	}
	public Integer[] getQuantityEditt() {
		return quantityEditt;
	}
	public String[] getUom_IdEditt() {
		return uom_IdEditt;
	}
	public Integer[] getExplosionLevelEditt() {
		return explosionLevelEditt;
	}
	public Integer[] getPredessorEditt() {
		return predessorEditt;
	}
	public String[] getParentMaterial() {
		return parentMaterial;
	}
	public String getParentMat() {
		return parentMat;
	}
	public String getParentMatEditt() {
		return parentMatEditt;
	}

	/* ============================= Setters======================================*/
	
	public void setParentMat(String parentMat) {
		this.parentMat = parentMat;
	}
	public void setParentMatEditt(String parentMatEditt) {
		this.parentMatEditt = parentMatEditt;
	}

	public void setParentMaterial(String[] parentMaterial) {
		this.parentMaterial = parentMaterial;
	}

	public String[] getParentMaterialEditt() {
		return parentMaterialEditt;
	}

	public void setParentMaterialEditt(String[] parentMaterialEditt) {
		this.parentMaterialEditt = parentMaterialEditt;
	}

	public void setBomId(int bomId) {
		this.bomId = bomId;
	}
	public void setBmaterial_Id(String bmaterial_Id) {
		this.bmaterial_Id = bmaterial_Id;
	}
	public void setPlant_Id(String plant_Id) {
		this.plant_Id = plant_Id;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public void setBomCategoryId(String bomCategoryId) {
		this.bomCategoryId = bomCategoryId;
	}
	public void setRevisionLevel(String revisionLevel) {
		this.revisionLevel = revisionLevel;
	}
	public void setBomNumber(String bomNumber) {
		this.bomNumber = bomNumber;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	public void setBomLineId(int bomLineId) {
		this.bomLineId = bomLineId;
	}
	public void setMaterial_Id(String[] material_Id) {
		this.material_Id = material_Id;
	}
	public void setQuantity(Integer[] quantity) {
		this.quantity = quantity;
	}
	public void setUom(String[] uom_Id) {
		this.uom_Id = uom_Id;
	}
	
	public void setmId(String mId) {
		this.mId = mId;
	}

	public void setUomm(String uomm) {
		this.uomm = uomm;
	}

	public void setmIdEditt(String mIdEditt) {
		this.mIdEditt = mIdEditt;
	}

	public void setUommEditt(String uommEditt) {
		this.uommEditt = uommEditt;
	}

	public void setExplosionLevel(Integer[] explosionLevel) {
		this.explosionLevel = explosionLevel;
	}
	public void setPredessor(Integer[] predessor) {
		this.predessor = predessor;
	}
	public void setBomIdEditt(int bomIdEditt) {
		this.bomIdEditt = bomIdEditt;
	}
	public void setBmaterial_IdEditt(String bmaterial_IdEditt) {
		this.bmaterial_IdEditt = bmaterial_IdEditt;
	}
	public void setPlant_IdEditt(String plant_IdEditt) {
		this.plant_IdEditt = plant_IdEditt;
	}
	public void setUsageEditt(String usageEditt) {
		this.usageEditt = usageEditt;
	}
	public void setBomCategoryIdEditt(String bomCategoryIdEditt) {
		this.bomCategoryIdEditt = bomCategoryIdEditt;
	}
	public void setRevisionLevelEditt(String revisionLevelEditt) {
		this.revisionLevelEditt = revisionLevelEditt;
	}
	public void setBomNumberEditt(String bomNumberEditt) {
		this.bomNumberEditt = bomNumberEditt;
	}
	public void setBomLineIdEditt(int[] bomLineIdEditt) {
		this.bomLineIdEditt = bomLineIdEditt;
	}
	public void setMaterial_IdEditt(String[] material_IdEditt) {
		this.material_IdEditt = material_IdEditt;
	}
	public void setQuantityEditt(Integer[] quantityEditt) {
		this.quantityEditt = quantityEditt;
	}
	public void setUomEditt(String[] uom_IdEditt) {
		this.uom_IdEditt = uom_IdEditt;
	}
	public void setExplosionLevelEditt(Integer[] explosionLevelEditt) {
		this.explosionLevelEditt = explosionLevelEditt;
	}
	public void setPredessorEditt(Integer[] predessorEditt) {
		this.predessorEditt = predessorEditt;
	}

	public String getQty() {
		return qty;
	}

	public void setQty(String qty) {
		this.qty = qty;
	}

	public String getQtyEdit() {
		return qtyEdit;
	}

	public void setQtyEdit(String qtyEdit) {
		this.qtyEdit = qtyEdit;
	}

	public String getuOMId() {
		return uOMId;
	}

	public void setuOMId(String uOMId) {
		this.uOMId = uOMId;
	}

	public String getuOMIdEdit() {
		return uOMIdEdit;
	}

	public void setuOMIdEdit(String uOMIdEdit) {
		this.uOMIdEdit = uOMIdEdit;
	}

	public void setUom_Id(String[] uom_Id) {
		this.uom_Id = uom_Id;
	}
	
	
}
