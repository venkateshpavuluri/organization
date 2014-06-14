/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author madhav
 *
 */
public class ConditionBean {

	//variable for adding 
		private int conditionId;
		private String conditionTypeId;
		private String condition;
		private String conditionType;
		private int cId;
		
		//variables for searching
		private String xmlLabel;
		private String operations;
		private String basicSearchId;
		
		//variables for Editing
		private int conditionIdEdit;
		private String conditionTypeIdEdit;
		private String conditionEdit;
		private String conditionTypeEdit;
		private int ctIdEdit;
		
		//Instance variable for mapping
		private ConditionType conditionTypeChild;
		
		//Getters and Setter Methods
		/**
		 * @return the conditionId
		 */
		public int getConditionId() {
			return conditionId;
		}
		/**
		 * @param conditionId the conditionId to set
		 */
		public void setConditionId(int conditionId) {
			this.conditionId = conditionId;
		}
		/**
		 * @return the conditionTypeId
		 */
		public String getConditionTypeId() {
			return conditionTypeId;
		}
		/**
		 * @param conditionTypeId the conditionTypeId to set
		 */
		public void setConditionTypeId(String conditionTypeId) {
			this.conditionTypeId = conditionTypeId;
		}
		/**
		 * @return the condition
		 */
		public String getCondition() {
			return condition;
		}
		/**
		 * @param condition the condition to set
		 */
		public void setCondition(String condition) {
			this.condition = condition;
		}
		/**
		 * @return the cId
		 */
		public int getcId() {
			return cId;
		}
		/**
		 * @param cId the cId to set
		 */
		public void setcId(int cId) {
			this.cId = cId;
		}
		/**
		 * @return the xmlLabel
		 */
		public String getXmlLabel() {
			return xmlLabel;
		}
		/**
		 * @param xmlLabel the xmlLabel to set
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
		 * @param operations the operations to set
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
		 * @param basicSearchId the basicSearchId to set
		 */
		public void setBasicSearchId(String basicSearchId) {
			this.basicSearchId = basicSearchId;
		}
		/**
		 * @return the conditionIdEdit
		 */
		public int getConditionIdEdit() {
			return conditionIdEdit;
		}
		/**
		 * @param conditionIdEdit the conditionIdEdit to set
		 */
		public void setConditionIdEdit(int conditionIdEdit) {
			this.conditionIdEdit = conditionIdEdit;
		}
		/**
		 * @return the conditionTypeIdEdit
		 */
		public String getConditionTypeIdEdit() {
			return conditionTypeIdEdit;
		}
		/**
		 * @param conditionTypeIdEdit the conditionTypeIdEdit to set
		 */
		public void setConditionTypeIdEdit(String conditionTypeIdEdit) {
			this.conditionTypeIdEdit = conditionTypeIdEdit;
		}
		/**
		 * @return the conditionEdit
		 */
		public String getConditionEdit() {
			return conditionEdit;
		}
		/**
		 * @param conditionEdit the conditionEdit to set
		 */
		public void setConditionEdit(String conditionEdit) {
			this.conditionEdit = conditionEdit;
		}
		/**
		 * @return the conditionType
		 */
		public String getConditionType() {
			return conditionType;
		}
		/**
		 * @param conditionType the conditionType to set
		 */
		public void setConditionType(String conditionType) {
			this.conditionType = conditionType;
		}
		/**
		 * @return the ctIdEdit
		 */
		public int getCtIdEdit() {
			return ctIdEdit;
		}
		/**
		 * @param ctIdEdit the ctIdEdit to set
		 */
		public void setCtIdEdit(int ctIdEdit) {
			this.ctIdEdit = ctIdEdit;
		}
		/**
		 * @return the conditionTypeChild
		 */
		public ConditionType getConditionTypeChild() {
			return conditionTypeChild;
		}
		/**
		 * @param conditionTypeChild the conditionTypeChild to set
		 */
		public void setConditionTypeChild(ConditionType conditionTypeChild) {
			this.conditionTypeChild = conditionTypeChild;
		}
		/**
		 * @return the conditionTypeEdit
		 */
		public String getConditionTypeEdit() {
			return conditionTypeEdit;
		}
		/**
		 * @param conditionTypeEdit the conditionTypeEdit to set
		 */
		public void setConditionTypeEdit(String conditionTypeEdit) {
			this.conditionTypeEdit = conditionTypeEdit;
		}
		
		
}
