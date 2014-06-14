package com.mnt.erp.bean;

public class Qualification {

		private int qualification_Id;
		private String qualification;
		private int aid;
	
	//Basic Search Properties
	
		private String xmlLabel;
		private String operations;
		private String basicSearchId;

	//Edit Properties
		private int qualification_IdEdit;
		private String qualificationEdit;
		
		
		//getter methods
		
		public int getQualification_Id() {
			return qualification_Id;
		}
		public String getQualification() {
			return qualification;
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
		public int getQualification_IdEdit() {
			return qualification_IdEdit;
		}
		public String getQualificationEdit() {
			return qualificationEdit;
		}
		

		//setter methods
		public void setQualification_Id(int qualification_Id) {
			this.qualification_Id = qualification_Id;
		}
		public void setQualification(String qualification) {
			this.qualification = qualification;
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
		public void setQualification_IdEdit(int qualification_IdEdit) {
			this.qualification_IdEdit = qualification_IdEdit;
		}
		public void setQualificationEdit(String qualificationEdit) {
			this.qualificationEdit = qualificationEdit;
		}
	
	
	
	
}
