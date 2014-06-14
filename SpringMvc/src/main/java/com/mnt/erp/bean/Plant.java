/**
 * @Copyright MNTSOFT
 * 
 */
package com.mnt.erp.bean;

/**
 * @author pvenkateswarlu
 * @version 1.0 20-09-2013
 */
public class Plant {
	/**
	 * @return the searchkey
	 */
	public String getSearchkey() {
		return searchkey;
	}

	/**
	 * @param searchkey
	 *            the searchkey to set
	 */
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}

	private int plantId;
	private String plantName;
	private String add1;
	private String add2;
	private String add3;
	private String city;
	private String state;
	private String country;
	private String phone;
	private String mobile;
	private String fax;
	private String orgId;
	private Organization organization;
	private CountrysList countrysList;
	private String searchkey;
	private String purorgid;
	private String countryName;
	private String orgName;
	private int aid;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	
	
	/* EditProperties */
	private int plantIdEdit;
	private String plantNameEdit;
	private String add1Edit;
	private String add2Edit;
	private String add3Edit;
	private String cityEdit;
	private String stateEdit;
	private String countryEdit;
	private String phoneEdit;
	private String mobileEdit;
	private String faxEdit;
	private String orgIdEdit;
	
	
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

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}



	/**
	 * @return the plantIdEdit
	 */
	public int getPlantIdEdit() {
		return plantIdEdit;
	}

	/**
	 * @param plantIdEdit
	 *            the plantIdEdit to set
	 */
	public void setPlantIdEdit(int plantIdEdit) {
		this.plantIdEdit = plantIdEdit;
	}

	/**
	 * @return the plantNameEdit
	 */
	public String getPlantNameEdit() {
		return plantNameEdit;
	}

	/**
	 * @param plantNameEdit
	 *            the plantNameEdit to set
	 */
	public void setPlantNameEdit(String plantNameEdit) {
		this.plantNameEdit = plantNameEdit;
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
	 * @return the mobileEdit
	 */
	public String getMobileEdit() {
		return mobileEdit;
	}

	/**
	 * @param mobileEdit
	 *            the mobileEdit to set
	 */
	public void setMobileEdit(String mobileEdit) {
		this.mobileEdit = mobileEdit;
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
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName
	 *            the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the purorgid
	 */
	public String getPurorgid() {
		return purorgid;
	}

	/**
	 * @param purorgid
	 *            the purorgid to set
	 */
	public void setPurorgid(String purorgid) {
		this.purorgid = purorgid;
	}

	/**
	 * @return the organization
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * @param organization
	 *            the organization to set
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

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
	 * @return the plantId
	 */
	public int getPlantId() {
		return plantId;
	}

	/**
	 * @param plantId
	 *            the plantId to set
	 */
	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	/**
	 * @return the plantName
	 */
	public String getPlantName() {
		return plantName;
	}

	/**
	 * @param plantName
	 *            the plantName to set
	 */
	public void setPlantName(String plantName) {
		this.plantName = plantName;
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
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the orgId
	 */
	public String getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the countryEdit
	 */
	public String getCountryEdit() {
		return countryEdit;
	}

	/**
	 * @param countryEdit the countryEdit to set
	 */
	public void setCountryEdit(String countryEdit) {
		this.countryEdit = countryEdit;
	}

	/**
	 * @return the orgIdEdit
	 */
	public String getOrgIdEdit() {
		return orgIdEdit;
	}

	/**
	 * @param orgIdEdit the orgIdEdit to set
	 */
	public void setOrgIdEdit(String orgIdEdit) {
		this.orgIdEdit = orgIdEdit;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @param fax
	 *            the fax to set
	 */




}
