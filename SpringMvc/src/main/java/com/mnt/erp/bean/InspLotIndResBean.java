/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 17-05-2014
 */
public class InspLotIndResBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int inspLotIndResId;
	private String inspLotId;
	private String processDetailId;
	private Double inspect;
	private Double inspected;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;
	private List<InspLotIndResLine> inspLotIndResList;
	
	private InspectionLotBean inspLotBean;
	private ProcessDetailBean processDetail;
	
	//child variables
	private int[] inspLotIndResLineId;
	private String[] sampleNo;
	private String[] inspCharId;
	private String[] upperLimit;
	private String[] lowerLimit;
	private String[] minTolerance;
	private String[] maxTolerance;
	private String[] uomId;
	private Double[] measuredVal;
	private String[] defectClsId;
	private String[] defectTypeId;
	private String[] codeGrpId;
	private String[] codeId;
	private String[] defectLoc;
	private String[] valuation;
	private String[] inspDecisionId;
	
	private String inspCharName;
	private String uomName;
	private String defClsName;
	private String defTypeName;
	private String codeGrpName;
	private String codeName;
	
	//Setter And Getter Methods
	
	public int getInspLotIndResId() {
		return inspLotIndResId;
	}
	public String getInspLotId() {
		return inspLotId;
	}
	public String getProcessDetailId() {
		return processDetailId;
	}
	public String getLabels() {
		return labels;
	}
	public String getDbField() {
		return dbField;
	}
	public String getAsOpts() {
		return asOpts;
	}
	public String getAdvanceSearchText() {
		return advanceSearchText;
	}
	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}
	public void setDbField(String dbField) {
		this.dbField = dbField;
	}
	public void setAsOpts(String asOpts) {
		this.asOpts = asOpts;
	}
	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}
	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}
	public Double getInspect() {
		return inspect;
	}
	public Double getInspected() {
		return inspected;
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
	public InspectionLotBean getInspLotBean() {
		return inspLotBean;
	}
	public ProcessDetailBean getProcessDetail() {
		return processDetail;
	}
	public void setInspLotIndResId(int inspLotIndResId) {
		this.inspLotIndResId = inspLotIndResId;
	}
	public void setInspLotId(String inspLotId) {
		this.inspLotId = inspLotId;
	}
	public void setProcessDetailId(String processDetailId) {
		this.processDetailId = processDetailId;
	}
	public void setInspect(Double inspect) {
		this.inspect = inspect;
	}
	public void setInspected(Double inspected) {
		this.inspected = inspected;
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
	public void setInspLotBean(InspectionLotBean inspLotBean) {
		this.inspLotBean = inspLotBean;
	}
	public void setProcessDetail(ProcessDetailBean processDetail) {
		this.processDetail = processDetail;
	}
	public List<InspLotIndResLine> getInspLotIndResList() {
		return inspLotIndResList;
	}
	public void setInspLotIndResList(List<InspLotIndResLine> inspLotIndResList) {
		this.inspLotIndResList = inspLotIndResList;
	}
	public int[] getInspLotIndResLineId() {
		return inspLotIndResLineId;
	}
	public String[] getSampleNo() {
		return sampleNo;
	}
	public String[] getInspCharId() {
		return inspCharId;
	}
	public String[] getUpperLimit() {
		return upperLimit;
	}
	public String[] getLowerLimit() {
		return lowerLimit;
	}
	public String[] getMinTolerance() {
		return minTolerance;
	}
	public String[] getMaxTolerance() {
		return maxTolerance;
	}
	public String[] getUomId() {
		return uomId;
	}
	public Double[] getMeasuredVal() {
		return measuredVal;
	}
	public String[] getDefectClsId() {
		return defectClsId;
	}
	public String[] getDefectTypeId() {
		return defectTypeId;
	}
	public String[] getCodeGrpId() {
		return codeGrpId;
	}
	public String[] getCodeId() {
		return codeId;
	}
	public String[] getDefectLoc() {
		return defectLoc;
	}
	public String[] getValuation() {
		return valuation;
	}
	public String[] getInspDecisionId() {
		return inspDecisionId;
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
	public void setInspLotIndResLineId(int[] inspLotIndResLineId) {
		this.inspLotIndResLineId = inspLotIndResLineId;
	}
	public void setSampleNo(String[] sampleNo) {
		this.sampleNo = sampleNo;
	}
	public void setInspCharId(String[] inspCharId) {
		this.inspCharId = inspCharId;
	}
	public void setUpperLimit(String[] upperLimit) {
		this.upperLimit = upperLimit;
	}
	public void setLowerLimit(String[] lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	public void setMinTolerance(String[] minTolerance) {
		this.minTolerance = minTolerance;
	}
	public void setMaxTolerance(String[] maxTolerance) {
		this.maxTolerance = maxTolerance;
	}
	public void setUomId(String[] uomId) {
		this.uomId = uomId;
	}
	public void setMeasuredVal(Double[] measuredVal) {
		this.measuredVal = measuredVal;
	}
	public void setDefectClsId(String[] defectClsId) {
		this.defectClsId = defectClsId;
	}
	public void setDefectTypeId(String[] defectTypeId) {
		this.defectTypeId = defectTypeId;
	}
	public void setCodeGrpId(String[] codeGrpId) {
		this.codeGrpId = codeGrpId;
	}
	public void setCodeId(String[] codeId) {
		this.codeId = codeId;
	}
	public void setDefectLoc(String[] defectLoc) {
		this.defectLoc = defectLoc;
	}
	public void setValuation(String[] valuation) {
		this.valuation = valuation;
	}
	public void setInspDecisionId(String[] inspDecisionId) {
		this.inspDecisionId = inspDecisionId;
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
