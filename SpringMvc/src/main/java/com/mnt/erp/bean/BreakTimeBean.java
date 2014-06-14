/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author devi
 *
 */
public class BreakTimeBean {

	private int breakTimeId;
	private String breakTimecode;
	private String starttime;
	private String endtime;
	private String length;
    private String shift;
	private String organization;
	private int aid;
	private int breakhide;
	private int breakdupedit;
	
	private int breakTimeIdEdit;
	private String breakTimecodeEdit;
	private String starttimeEdit;
	private String endtimeEdit;
	private String lengthEdit;
    private String shiftEdit;
	private String organizationEdit;
	private String xmlLabel;
    private String operations;
    private String basicSearchId;
    
    private ShiftBean shiftBean;
    private Organization orgBean;
    
    
    
    
  
public int getBreakhide() {
		return breakhide;
	}
	public void setBreakhide(int breakhide) {
		this.breakhide = breakhide;
	}
	public int getBreakdupedit() {
		return breakdupedit;
	}
	public void setBreakdupedit(int breakdupedit) {
		this.breakdupedit = breakdupedit;
	}
public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public String getShiftEdit() {
		return shiftEdit;
	}
	public void setShiftEdit(String shiftEdit) {
		this.shiftEdit = shiftEdit;
	}
	public String getOrganizationEdit() {
		return organizationEdit;
	}
	public void setOrganizationEdit(String organizationEdit) {
		this.organizationEdit = organizationEdit;
	}
public ShiftBean getShiftBean() {
		return shiftBean;
	}
	public void setShiftBean(ShiftBean shiftBean) {
		this.shiftBean = shiftBean;
	}
	public Organization getOrgBean() {
		return orgBean;
	}
	public void setOrgBean(Organization orgBean) {
		this.orgBean = orgBean;
	}
	//generate getters & setters
	public int getBreakTimeId() {
		return breakTimeId;
	}
	public void setBreakTimeId(int breakTimeId) {
		this.breakTimeId = breakTimeId;
	}
	public String getBreakTimecode() {
		return breakTimecode;
	}
	public void setBreakTimecode(String breakTimecode) {
		this.breakTimecode = breakTimecode;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
	public int getBreakTimeIdEdit() {
		return breakTimeIdEdit;
	}
	public void setBreakTimeIdEdit(int breakTimeIdEdit) {
		this.breakTimeIdEdit = breakTimeIdEdit;
	}
	public String getBreakTimecodeEdit() {
		return breakTimecodeEdit;
	}
	public void setBreakTimecodeEdit(String breakTimecodeEdit) {
		this.breakTimecodeEdit = breakTimecodeEdit;
	}
	public String getStarttimeEdit() {
		return starttimeEdit;
	}
	public void setStarttimeEdit(String starttimeEdit) {
		this.starttimeEdit = starttimeEdit;
	}
	public String getEndtimeEdit() {
		return endtimeEdit;
	}
	public void setEndtimeEdit(String endtimeEdit) {
		this.endtimeEdit = endtimeEdit;
	}
	public String getLengthEdit() {
		return lengthEdit;
	}
	public void setLengthEdit(String lengthEdit) {
		this.lengthEdit = lengthEdit;
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
    
    
}
