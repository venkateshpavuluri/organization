package com.mnt.erp.bean;

/**
 * @author Parvathi
 * @version 1.0 04-1-2014
 */
public class CharacteristicType {
	private int characteristicType_Id;
	private String characteristicType;
	private int aid;
	
	//Basic search properties
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	//Edit Properties
	private int characteristicType_IdEdit;
	private String characteristicTypeEdit;
	
	
	
	//get properties
	public int getCharacteristicType_Id() {
		return characteristicType_Id;
	}
	public String getCharacteristicType() {
		return characteristicType;
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
	public int getCharacteristicType_IdEdit() {
		return characteristicType_IdEdit;
	}
	public String getCharacteristicTypeEdit() {
		return characteristicTypeEdit;
	}
	
	//set properties
	
	public void setCharacteristicType_Id(int characteristicType_Id) {
		this.characteristicType_Id = characteristicType_Id;
	}
	public void setCharacteristicType(String characteristicType) {
		this.characteristicType = characteristicType;
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
	public void setCharacteristicType_IdEdit(int characteristicType_IdEdit) {
		this.characteristicType_IdEdit = characteristicType_IdEdit;
	}
	public void setCharacteristicTypeEdit(String characteristicTypeEdit) {
		this.characteristicTypeEdit = characteristicTypeEdit;
	}
	
	
	
	
}
