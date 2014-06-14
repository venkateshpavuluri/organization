/**

 *
 */
package com.mnt.erp.bean;
/**
 * @author Sailaja
   @version 1.0
   @build 0.0
 *
 */
public class MaterialType
{
	
	/*==========================Bean Properties===========================*/
		private int materialType;
		private String materialTypeName;
		private String MaterialTypeCode;
		private int aid;
	/*==========================Edit Properties===========================*/
		private int materialTypeEdit;
		private String materialTypeNameEdit;
		private String MaterialTypeCodeEdit;

	/*==========================Bean Properties===========================*/
		private String xmlLabel;
		private String operations;
		private String basicSearchId;
		
		

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

		public int getAid()
		{
			return aid;
		}
		
		public int getMaterialType() 
		{
			return materialType;
		}
		
		public String getMaterialTypeName()
		{
			return materialTypeName;
		}
		
		public String getMaterialTypeCode() 
		{
			return MaterialTypeCode;
		}
		
		public int getMaterialTypeEdit()
		{
			return materialTypeEdit;
		}
		
		public String getMaterialTypeNameEdit() 
		{
			return materialTypeNameEdit;
		}
		
		public String getMaterialTypeCodeEdit() 
		{
			return MaterialTypeCodeEdit;
		}

	/*==========================Setter Methods===========================*/
		
		public void setAid(int aid)
		{
			this.aid = aid;
		}
		public void setMaterialType(int materialType)
		{
			this.materialType = materialType;
		}
		public void setMaterialTypeName(String materialTypeName)
		{
			this.materialTypeName = materialTypeName;
		}
		public void setMaterialTypeCode(String materialTypeCode)
		{
			MaterialTypeCode = materialTypeCode;
		}
		public void setMaterialTypeEdit(int materialTypeEdit)
		{
			this.materialTypeEdit = materialTypeEdit;
		}
		public void setMaterialTypeNameEdit(String materialTypeNameEdit)
		{
			this.materialTypeNameEdit = materialTypeNameEdit;
		}
		public void setMaterialTypeCodeEdit(String materialTypeCodeEdit)
		{
			MaterialTypeCodeEdit = materialTypeCodeEdit;
		}
		
		


}
