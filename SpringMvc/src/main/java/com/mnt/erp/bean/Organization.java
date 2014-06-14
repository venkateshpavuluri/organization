/**
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

import org.springframework.web.multipart.MultipartFile;



/**
 * @author pvenkateswarlu
 * @version 1.0 18-09-2013
 */
public class Organization {
	private int orgId;
	
	private String orgName;
	private String add1;
	private String add2;
	private String add3;
	private String city;
	private String state;
	private String countryId;
	private String countryIdEdit;
	private byte[] image;
	private MultipartFile imageFile;
	private int aid;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	private String ref;
	private String refName;
	
	private String country;
	private String phone;
	private String fax;
	private String email;
	private String orgTypeId;
	private String orgType;
	private OrganizationType organizationType;

	/* EditProperties */

	private int orgIdEdit;
	private String orgNameEdit;
	private String add1Edit;
	private String add2Edit;
	private String add3Edit;
	private String cityEdit;
	private String stateEdit;
	private String countryEdit;
	private String phoneEdit;
	private String faxEdit;
	private String emailEdit;
	private String orgTypeIdEdit;
	private String orgTypeEdit;
	private byte[] imageEdit;
	private CountrysList countrysList;
	
	
	
	
	


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the imageFile
	 */
	public MultipartFile getImageFile() {
		return imageFile;
	}

	/**
	 * @param imageFile the imageFile to set
	 */
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getRefName() {
		return refName;
	}

	public void setRefName(String refName) {
		this.refName = refName;
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

	/**
	 * @return the aid
	 */
	public int getAid() {
		return aid;
	}

	/**
	 * @param aid the aid to set
	 */
	public void setAid(int aid) {
		this.aid = aid;
	}

	/**
	 * @return the countryIdEdit
	 */
	

	/**
	 * @param countryId
	 *            the countryId to set
	 */


	

	/**
	 * @return the countrysList
	 */
	public CountrysList getCountrysList() {
		return countrysList;
	}

	/**
	 * @param countrysList
	 *            the countrysList to set
	 */
	public void setCountrysList(CountrysList countrysList) {
		this.countrysList = countrysList;
	}



	/**
	 * @return the orgNameEdit
	 */
	public String getOrgNameEdit() {
		return orgNameEdit;
	}

	/**
	 * @param orgNameEdit
	 *            the orgNameEdit to set
	 */
	public void setOrgNameEdit(String orgNameEdit) {
		this.orgNameEdit = orgNameEdit;
	}

	/**
	 * @return the add1Edit
	 */
	public String getAdd1Edit() {
		return add1Edit;
	}

	/**
	 * @param add1Edit
	 *            the add1Edit to set
	 */
	public void setAdd1Edit(String add1Edit) {
		this.add1Edit = add1Edit;
	}

	/**
	 * @return the add2Edit
	 */
	public String getAdd2Edit() {
		return add2Edit;
	}

	/**
	 * @param add2Edit
	 *            the add2Edit to set
	 */
	public void setAdd2Edit(String add2Edit) {
		this.add2Edit = add2Edit;
	}

	/**
	 * @return the add3Edit
	 */
	public String getAdd3Edit() {
		return add3Edit;
	}

	/**
	 * @param add3Edit
	 *            the add3Edit to set
	 */
	public void setAdd3Edit(String add3Edit) {
		this.add3Edit = add3Edit;
	}

	/**
	 * @return the cityEdit
	 */
	public String getCityEdit() {
		return cityEdit;
	}

	/**
	 * @param cityEdit
	 *            the cityEdit to set
	 */
	public void setCityEdit(String cityEdit) {
		this.cityEdit = cityEdit;
	}

	/**
	 * @return the stateEdit
	 */
	public String getStateEdit() {
		return stateEdit;
	}

	/**
	 * @param stateEdit
	 *            the stateEdit to set
	 */
	public void setStateEdit(String stateEdit) {
		this.stateEdit = stateEdit;
	}

	/**
	 * @return the countryEdit
	 */
	public String getCountryEdit() {
		return countryEdit;
	}

	/**
	 * @param countryEdit
	 *            the countryEdit to set
	 */
	public void setCountryEdit(String countryEdit) {
		this.countryEdit = countryEdit;
	}

	/**
	 * @return the phoneEdit
	 */
	public String getPhoneEdit() {
		return phoneEdit;
	}

	/**
	 * @param phoneEdit
	 *            the phoneEdit to set
	 */
	public void setPhoneEdit(String phoneEdit) {
		this.phoneEdit = phoneEdit;
	}

	/**
	 * @return the faxEdit
	 */
	public String getFaxEdit() {
		return faxEdit;
	}

	/**
	 * @param faxEdit
	 *            the faxEdit to set
	 */
	public void setFaxEdit(String faxEdit) {
		this.faxEdit = faxEdit;
	}

	/**
	 * @return the emailEdit
	 */
	public String getEmailEdit() {
		return emailEdit;
	}

	/**
	 * @param emailEdit
	 *            the emailEdit to set
	 */
	public void setEmailEdit(String emailEdit) {
		this.emailEdit = emailEdit;
	}

	/**
	 * @return the orgTypeIdEdit
	 */


	/**
	 * @return the orgTypeEdit
	 */
	public String getOrgTypeEdit() {
		return orgTypeEdit;
	}

	public String getOrgTypeIdEdit() {
		return orgTypeIdEdit;
	}

	public void setOrgTypeIdEdit(String orgTypeIdEdit) {
		this.orgTypeIdEdit = orgTypeIdEdit;
	}

	/**
	 * @param orgTypeEdit
	 *            the orgTypeEdit to set
	 */
	public void setOrgTypeEdit(String orgTypeEdit) {
		this.orgTypeEdit = orgTypeEdit;
	}

	/**
	 * @return the orgType
	 */
	public String getOrgType() {
		return orgType;
	}

	/**
	 * @param orgType
	 *            the orgType to set
	 */
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	/**
	 * @return the organizationType
	 */
	public OrganizationType getOrganizationType() {
		return organizationType;
	}

	/**
	 * @param organizationType
	 *            the organizationType to set
	 */
	public void setOrganizationType(OrganizationType organizationType) {
		this.organizationType = organizationType;
	}

	/**
	 * @return the orgId
	 */
	public int getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId
	 *            the orgId to set
	 */
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}

	/**
	 * @param orgName
	 *            the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	/**
	 * @return the add1
	 */
	public String getAdd1() {
		return add1;
	}

	/**
	 * @param add1
	 *            the add1 to set
	 */
	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	/**
	 * @return the add2
	 */
	public String getAdd2() {
		return add2;
	}

	/**
	 * @param add2
	 *            the add2 to set
	 */
	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	/**
	 * @return the add3
	 */
	public String getAdd3() {
		return add3;
	}

	/**
	 * @param add3
	 *            the add3 to set
	 */
	public void setAdd3(String add3) {
		this.add3 = add3;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the state
	 */


	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getCountryIdEdit() {
		return countryIdEdit;
	}

	public void setCountryIdEdit(String countryIdEdit) {
		this.countryIdEdit = countryIdEdit;
	}

	public String getOrgTypeId() {
		return orgTypeId;
	}

	public void setOrgTypeId(String orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	public int getOrgIdEdit() {
		return orgIdEdit;
	}

	public void setOrgIdEdit(int orgIdEdit) {
		this.orgIdEdit = orgIdEdit;
	}

	  
	  public byte[] getImageEdit() {
		return imageEdit;
	}

	public void setImageEdit(byte[] imageEdit) {
		this.imageEdit = imageEdit;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	}



	/**
	 * @return the parentOrg
	 */


