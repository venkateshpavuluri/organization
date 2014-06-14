/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 17-05-2014
 */
public class InspLotIndResLine implements Serializable{

	private static final long serialVersionUID = 1L;
	private int inspLotIndResLineId;
	private String sampleNo;
	private String inspCharId;
	private String upperLimit;
	private String lowerLimit;
	private String minTolerance;
	private String maxTolerance;
	private String uomId;
	private Double measuredVal;
	private String defectClsId;
	private String defectTypeId;
	private String codeGrpId;
	private String codeId;
	private String defectLoc;
	private String valuation;
	private String inspDecisionId;
	
	private InspCharacteristic inspCharBean;
	private Uom uomBean;
	private DefectClassBean defClsBean;
	private DefectTypeBean defTypeBean;
	private CodeGroup codeGrpBean;
	private Code codeBean;
	
	private String inspCharName;
	private String uomName;
	private String defClsName;
	private String defTypeName;
	private String codeGrpName;
	private String codeName;
	
	//Setter And Getter Methods
	
	
	public int getInspLotIndResLineId() {
		return inspLotIndResLineId;
	}
	public String getSampleNo() {
		return sampleNo;
	}
	public String getInspCharId() {
		return inspCharId;
	}
	public String getUpperLimit() {
		return upperLimit;
	}
	public String getLowerLimit() {
		return lowerLimit;
	}
	public String getMinTolerance() {
		return minTolerance;
	}
	public String getMaxTolerance() {
		return maxTolerance;
	}
	public String getUomId() {
		return uomId;
	}
	public Double getMeasuredVal() {
		return measuredVal;
	}
	public String getDefectClsId() {
		return defectClsId;
	}
	public String getDefectTypeId() {
		return defectTypeId;
	}
	public String getCodeGrpId() {
		return codeGrpId;
	}
	public String getCodeId() {
		return codeId;
	}
	public String getDefectLoc() {
		return defectLoc;
	}
	public String getValuation() {
		return valuation;
	}
	public String getInspDecisionId() {
		return inspDecisionId;
	}
	public void setInspLotIndResLineId(int inspLotIndResLineId) {
		this.inspLotIndResLineId = inspLotIndResLineId;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}
	public void setInspCharId(String inspCharId) {
		this.inspCharId = inspCharId;
	}
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit;
	}
	public void setLowerLimit(String lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public void setMinTolerance(String minTolerance) {
		this.minTolerance = minTolerance;
	}
	public void setMaxTolerance(String maxTolerance) {
		this.maxTolerance = maxTolerance;
	}
	public void setUomId(String uomId) {
		this.uomId = uomId;
	}
	public void setMeasuredVal(Double measuredVal) {
		this.measuredVal = measuredVal;
	}
	public void setDefectClsId(String defectClsId) {
		this.defectClsId = defectClsId;
	}
	public void setDefectTypeId(String defectTypeId) {
		this.defectTypeId = defectTypeId;
	}
	public void setCodeGrpId(String codeGrpId) {
		this.codeGrpId = codeGrpId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	public void setDefectLoc(String defectLoc) {
		this.defectLoc = defectLoc;
	}
	public void setValuation(String valuation) {
		this.valuation = valuation;
	}
	public void setInspDecisionId(String inspDecisionId) {
		this.inspDecisionId = inspDecisionId;
	}
	public InspCharacteristic getInspCharBean() {
		return inspCharBean;
	}
	public Uom getUomBean() {
		return uomBean;
	}
	public DefectClassBean getDefClsBean() {
		return defClsBean;
	}
	public DefectTypeBean getDefTypeBean() {
		return defTypeBean;
	}
	public CodeGroup getCodeGrpBean() {
		return codeGrpBean;
	}
	public Code getCodeBean() {
		return codeBean;
	}
	public String getInspCharName() {
		return inspCharName;
	}
	public String getUomName() {
		return uomName;
	}
	public String getDefClsName() {
		return defClsName;
	}
	public String getDefTypeName() {
		return defTypeName;
	}
	public String getCodeGrpName() {
		return codeGrpName;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setInspCharBean(InspCharacteristic inspCharBean) {
		this.inspCharBean = inspCharBean;
	}
	public void setUomBean(Uom uomBean) {
		this.uomBean = uomBean;
	}
	public void setDefClsBean(DefectClassBean defClsBean) {
		this.defClsBean = defClsBean;
	}
	public void setDefTypeBean(DefectTypeBean defTypeBean) {
		this.defTypeBean = defTypeBean;
	}
	public void setCodeGrpBean(CodeGroup codeGrpBean) {
		this.codeGrpBean = codeGrpBean;
	}
	public void setCodeBean(Code codeBean) {
		this.codeBean = codeBean;
	}
	public void setInspCharName(String inspCharName) {
		this.inspCharName = inspCharName;
	}
	public void setUomName(String uomName) {
		this.uomName = uomName;
	}
	public void setDefClsName(String defClsName) {
		this.defClsName = defClsName;
	}
	public void setDefTypeName(String defTypeName) {
		this.defTypeName = defTypeName;
	}
	public void setCodeGrpName(String codeGrpName) {
		this.codeGrpName = codeGrpName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	
	
	

}
