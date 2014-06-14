/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 *
 */
public class EmpExperience {
	/*Variable for EmpExperience Bean */
	private int experience_Id;
	private String employee_Id;
	private String fromDT;
	private String todate;
	private String designation_Id;
	private String company;
	private String compPhone;
	private String referenceName;
	private String redDesigntion_Id;
	private String email;
	
	/* Variable For Basic Search And Advanced Search*/
	private String operations;
	private String basicSearchId;
	private String xmlLabelBasic;
	
	
	/* Duplicate Check */
	private int duplicate;
	private Employee empDetails;
	private Designation desDetails;
	private Designation redDesDetails;
	
	
	/* Setters and getters for Code Bean	 */
	
	public int getExperience_Id() {
		return experience_Id;
	}
	public void setExperience_Id(int experience_Id) {
		this.experience_Id = experience_Id;
	}
	public String getEmployee_Id() {
		return employee_Id;
	}
	public void setEmployee_Id(String employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getFromDT() {
		return fromDT;
	}
	public void setFromDT(String fromDT) {
		this.fromDT = fromDT;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public String getDesignation_Id() {
		return designation_Id;
	}
	public void setDesignation_Id(String designation_Id) {
		this.designation_Id = designation_Id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompPhone() {
		return compPhone;
	}
	public void setCompPhone(String compPhone) {
		this.compPhone = compPhone;
	}
	public String getReferenceName() {
		return referenceName;
	}
	public void setReferenceName(String referenceName) {
		this.referenceName = referenceName;
	}
	public String getRedDesigntion_Id() {
		return redDesigntion_Id;
	}
	public void setRedDesigntion_Id(String redDesigntion_Id) {
		this.redDesigntion_Id = redDesigntion_Id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getXmlLabelBasic() {
		return xmlLabelBasic;
	}
	public void setXmlLabelBasic(String xmlLabelBasic) {
		this.xmlLabelBasic = xmlLabelBasic;
	}
	public int getDuplicate() {
		return duplicate;
	}
	public void setDuplicate(int duplicate) {
		this.duplicate = duplicate;
	}
	public Employee getEmpDetails() {
		return empDetails;
	}
	public void setEmpDetails(Employee empDetails) {
		this.empDetails = empDetails;
	}
	public Designation getDesDetails() {
		return desDetails;
	}
	public void setDesDetails(Designation desDetails) {
		this.desDetails = desDetails;
	}
	public Designation getRedDesDetails() {
		return redDesDetails;
	}
	public void setRedDesDetails(Designation redDesDetails) {
		this.redDesDetails = redDesDetails;
	}
	
	
}
