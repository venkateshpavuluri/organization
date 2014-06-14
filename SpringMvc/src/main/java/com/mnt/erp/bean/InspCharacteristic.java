/**
 * 
 */
package com.mnt.erp.bean;

import java.util.List;
import java.util.Set;


/**
 * @author kirangangone
 *
 */
public class InspCharacteristic {
	/*InspCharacteristic Table Varialble*/
	 private int inspCharacteristicId;
	 private String inspCharacteristicCode;
	 private String inspCharacteristic;
	 private String upperLimit;
	 private String lowerLimit;
	 private String uomId;
	 private String validFrom;
	 private String characteristicTypeId;
	 private String priority;
	 private String rules;
	 private String minTolerance;
	 private String maxTolerance;
	 private String specification;
	 
	 /*InspCharacteristicMethod Table Varialble*/ 
	 private int[] inspCharacteristicMethodId;
	 private String inspectionMethodId;
	 private String[] inspectionMethodName;
	 private String[] inspectionMethodIdForView;
	 private CharacteristicType characteristicType;
	 private String charTypeName;
	 
	 
	
		
	/* Duplicate Check */
	 private int inspCharacteristicDuplicate;
	 private int inCId;
		
		
		
	/*Basic Search And Advanced Search*/
	 private String xmlLabelBasic;
	 private String operations;
	 private String basicSearchId;
	 private String firstLabel;
	 private String secondLabel;
	 private String operations1;
	 private String advanceSearchText;
	 private int advanceSearchHidden;
	 private int advanceBasicSearchHidden;
		
		
		

		/*Name Of the Uom*/
		private Uom uomDetails;
		
			
		/*For InspCharacteristicMethod For Foreign Key */
		private Set<InspCharacteristicMethod> inspCharacteristicMethodGroupDetails;

		/*Setters And Getters Methods of InspCharacteristic and InspCharacteristicMethod*/
		public int getInspCharacteristicId() {
			return inspCharacteristicId;
		}


		public void setInspCharacteristicId(int inspCharacteristicId) {
			this.inspCharacteristicId = inspCharacteristicId;
		}


		public String getInspCharacteristicCode() {
			return inspCharacteristicCode;
		}


		public void setInspCharacteristicCode(String inspCharacteristicCode) {
			this.inspCharacteristicCode = inspCharacteristicCode;
		}


		public String getInspCharacteristic() {
			return inspCharacteristic;
		}


		public void setInspCharacteristic(String inspCharacteristic) {
			this.inspCharacteristic = inspCharacteristic;
		}


		public String getUpperLimit() {
			return upperLimit;
		}


		public void setUpperLimit(String upperLimit) {
			this.upperLimit = upperLimit;
		}


		public String getLowerLimit() {
			return lowerLimit;
		}


		public void setLowerLimit(String lowerLimit) {
			this.lowerLimit = lowerLimit;
		}


		public String getUomId() {
			return uomId;
		}


		public void setUomId(String uomId) {
			this.uomId = uomId;
		}


		public String getValidFrom() {
			return validFrom;
		}


		public void setValidFrom(String validFrom) {
			this.validFrom = validFrom;
		}


		public String getCharacteristicTypeId() {
			return characteristicTypeId;
		}


		public void setCharacteristicTypeId(String characteristicTypeId) {
			this.characteristicTypeId = characteristicTypeId;
		}


		public String getPriority() {
			return priority;
		}


		public void setPriority(String priority) {
			this.priority = priority;
		}


		public String getRules() {
			return rules;
		}


		public void setRules(String rules) {
			this.rules = rules;
		}


		public String getMinTolerance() {
			return minTolerance;
		}


		public void setMinTolerance(String minTolerance) {
			this.minTolerance = minTolerance;
		}


		public String getMaxTolerance() {
			return maxTolerance;
		}


		public void setMaxTolerance(String maxTolerance) {
			this.maxTolerance = maxTolerance;
		}


		public String getSpecification() {
			return specification;
		}


		public void setSpecification(String specification) {
			this.specification = specification;
		}


		public int[] getInspCharacteristicMethodId() {
			return inspCharacteristicMethodId;
		}


		public void setInspCharacteristicMethodId(int[] inspCharacteristicMethodId) {
			this.inspCharacteristicMethodId = inspCharacteristicMethodId;
		}


		public String getInspectionMethodId() {
			return inspectionMethodId;
		}


		public void setInspectionMethodId(String inspectionMethodId) {
			this.inspectionMethodId = inspectionMethodId;
		}

		 public String[] getInspectionMethodName() {
				return inspectionMethodName;
			}


			public void setInspectionMethodName(String[] inspectionMethodName) {
				this.inspectionMethodName = inspectionMethodName;
			}
			
		public int getInspCharacteristicDuplicate() {
			return inspCharacteristicDuplicate;
		}


		public void setInspCharacteristicDuplicate(int inspCharacteristicDuplicate) {
			this.inspCharacteristicDuplicate = inspCharacteristicDuplicate;
		}


		public int getInCId() {
			return inCId;
		}


		public void setInCId(int inCId) {
			this.inCId = inCId;
		}


		
		
		
		public Set<InspCharacteristicMethod> getInspCharacteristicMethodGroupDetails() {
			return inspCharacteristicMethodGroupDetails;
		}


		public void setInspCharacteristicMethodGroupDetails(
				Set<InspCharacteristicMethod> inspCharacteristicMethodGroupDetails) {
			this.inspCharacteristicMethodGroupDetails = inspCharacteristicMethodGroupDetails;
		}


		public String[] getInspectionMethodIdForView() {
			return inspectionMethodIdForView;
		}


		public void setInspectionMethodIdForView(String[] inspectionMethodIdForView) {
			this.inspectionMethodIdForView = inspectionMethodIdForView;
		}
		
		


		/* Advanced Search Setters and Getters Methods*/
		
	
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
		
		
		 public String getXmlLabelBasic() {
				return xmlLabelBasic;
			}
			public void setXmlLabelBasic(String xmlLabelBasic) {
				this.xmlLabelBasic = xmlLabelBasic;
			}
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
			public int getAdvanceBasicSearchHidden() {
				return advanceBasicSearchHidden;
			}


			public void setAdvanceBasicSearchHidden(int advanceBasicSearchHidden) {
				this.advanceBasicSearchHidden = advanceBasicSearchHidden;
			}

		
		
		/*For Uom Name getters and setters*/
		
			public Uom getUomDetails() {
				return uomDetails;
			}


			public void setUomDetails(Uom uomDetails) {
				this.uomDetails = uomDetails;
			}


			public CharacteristicType getCharacteristicType() {
				return characteristicType;
			}


			public void setCharacteristicType(CharacteristicType characteristicType) {
				this.characteristicType = characteristicType;
			}


			public String getCharTypeName() {
				return charTypeName;
			}


			public void setCharTypeName(String charTypeName) {
				this.charTypeName = charTypeName;
			}
		


}
