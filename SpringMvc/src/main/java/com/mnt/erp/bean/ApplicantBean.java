/**
 * 
 */
package com.mnt.erp.bean;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author devi
 *
 */
public class ApplicantBean implements JSONStreamAware{
	private int applicant_Id;
	private String fname;
	private String mname;
	private String lname;
	private String phoneNo;
	private String email;
	private String vacancyDetail_Id;
	private String vacancyDetailNo;
	private VacancyDetailLine vacancyDetail;
	private String refNo;
	private String docPath;
	private MultipartFile imageFile;
	private MultipartFile imageFileEdit;
	private Boolean shortListed;
	private Boolean selected;
	private Boolean joined;
	private int aid;
	private String[] sortList;
			 
	
	private String dbDocPath;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	//Edit Properties
	
	private int applicant_IdEdit;
	private String fnameEdit;
	private String mnameEdit;
	private String lnameEdit;
	private String phoneNoEdit;
	private String emailEdit;
	private String vacancyDetail_IdEdit;
	private String vacancyDetailNoEdit;
	private String refNoEdit;
	private String docPathEdit;
	private Boolean shortListedEdit;
	private Boolean selectedEdit;
	private Boolean joinedEdit;
	

	
	
	
	/**
	 * @return the sortList
	 */
	public String[] getSortList() {
		return sortList;
	}
	/**
	 * @param sortList the sortList to set
	 */
	public void setSortList(String[] sortList) {
		this.sortList = sortList;
	}

	
	

	public MultipartFile getImageFileEdit() {
		return imageFileEdit;
	}
	public void setImageFileEdit(MultipartFile imageFileEdit) {
		this.imageFileEdit = imageFileEdit;
	}
	public String getDbDocPath() {
		return dbDocPath;
	}
	public void setDbDocPath(String dbDocPath) {
		this.dbDocPath = dbDocPath;
	}

	//Generate getter & setter methods
	public int getApplicant_Id() {
		return applicant_Id;
	}
	public void setApplicant_Id(int applicant_Id) {
		this.applicant_Id = applicant_Id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public VacancyDetailLine getVacancyDetail() {
		return vacancyDetail;
	}
	public void setVacancyDetail(VacancyDetailLine vacancyDetail) {
		this.vacancyDetail = vacancyDetail;
	}
	public String getRefNo() {
		return refNo;
	}
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	
	
	
	public Boolean getShortListed() {
		return shortListed;
	}
	public void setShortListed(Boolean shortListed) {
		this.shortListed = shortListed;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
	public Boolean getJoined() {
		return joined;
	}
	public void setJoined(Boolean joined) {
		this.joined = joined;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
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
	public int getApplicant_IdEdit() {
		return applicant_IdEdit;
	}
	public void setApplicant_IdEdit(int applicant_IdEdit) {
		this.applicant_IdEdit = applicant_IdEdit;
	}
	public String getFnameEdit() {
		return fnameEdit;
	}
	public void setFnameEdit(String fnameEdit) {
		this.fnameEdit = fnameEdit;
	}
	public String getMnameEdit() {
		return mnameEdit;
	}
	public void setMnameEdit(String mnameEdit) {
		this.mnameEdit = mnameEdit;
	}
	public String getLnameEdit() {
		return lnameEdit;
	}
	public void setLnameEdit(String lnameEdit) {
		this.lnameEdit = lnameEdit;
	}
	public String getPhoneNoEdit() {
		return phoneNoEdit;
	}
	public void setPhoneNoEdit(String phoneNoEdit) {
		this.phoneNoEdit = phoneNoEdit;
	}
	public String getEmailEdit() {
		return emailEdit;
	}
	public void setEmailEdit(String emailEdit) {
		this.emailEdit = emailEdit;
	}
	
	public String getRefNoEdit() {
		return refNoEdit;
	}
	public void setRefNoEdit(String refNoEdit) {
		this.refNoEdit = refNoEdit;
	}
	
	

	public String getDocPath() {
		return docPath;
	}
	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}
	
	
	
	
	public String getDocPathEdit() {
		return docPathEdit;
	}
	public void setDocPathEdit(String docPathEdit) {
		this.docPathEdit = docPathEdit;
	}
	public Boolean getShortListedEdit() {
		return shortListedEdit;
	}
	public void setShortListedEdit(Boolean shortListedEdit) {
		this.shortListedEdit = shortListedEdit;
	}
	public Boolean getSelectedEdit() {
		return selectedEdit;
	}
	public void setSelectedEdit(Boolean selectedEdit) {
		this.selectedEdit = selectedEdit;
	}
	public Boolean getJoinedEdit() {
		return joinedEdit;
	}
	public void setJoinedEdit(Boolean joinedEdit) {
		this.joinedEdit = joinedEdit;
	}
	public String getVacancyDetail_Id() {
		return vacancyDetail_Id;
	}
	public void setVacancyDetail_Id(String vacancyDetail_Id) {
		this.vacancyDetail_Id = vacancyDetail_Id;
	}
	public String getVacancyDetailNo() {
		return vacancyDetailNo;
	}
	public void setVacancyDetailNo(String vacancyDetailNo) {
		this.vacancyDetailNo = vacancyDetailNo;
	}
	public String getVacancyDetail_IdEdit() {
		return vacancyDetail_IdEdit;
	}
	public void setVacancyDetail_IdEdit(String vacancyDetail_IdEdit) {
		this.vacancyDetail_IdEdit = vacancyDetail_IdEdit;
	}
	public String getVacancyDetailNoEdit() {
		return vacancyDetailNoEdit;
	}
	public void setVacancyDetailNoEdit(String vacancyDetailNoEdit) {
		this.vacancyDetailNoEdit = vacancyDetailNoEdit;
	}
	@SuppressWarnings("unchecked")
	@Override
	public void writeJSONString(Writer out) throws IOException {
		
		@SuppressWarnings("rawtypes")
		LinkedHashMap obj = new LinkedHashMap();
		obj.put("applicant_Id", applicant_Id);
        obj.put("fname", fname);
        obj.put("mname", mname);
        obj.put("lname", lname);
        obj.put("phoneNo", phoneNo);
        obj.put("email", email);
        obj.put("docPath", docPath);
        
        JSONValue.writeJSONString(obj, out);
		
	}
	
	
	//Convert to JsonString
	
	

	
}
