/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author kirangangone
 *
 */
public class Voucher {
	/*Variable for Voucher Bean */
	private int voucherId;
	private String signature;
	private String voucherDT;
	private String employeeId;
	private String amount;
	private String statusId;
	private byte[] sign;
	private String voucherNo;
	private String voucherType_Id;
	//For WorkFlow purpose
	private String voucherTypeName;
	private String workFlowListId;
	private String statusName;
	private Status statusDetails;
	/* Variable For Basic Search And Advanced Search*/
	private String operations;
	private String basicSearchId;
	private String xmlLabelBasic;
	
	private String comments;
	private String actionNames;
	

	public String getActionNames() {
		return actionNames;
	}


	public void setActionNames(String actionNames) {
		this.actionNames = actionNames;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public Status getStatusDetails() {
		return statusDetails;
	}


	public void setStatusDetails(Status statusDetails) {
		this.statusDetails = statusDetails;
	}


	public String getStatusName() {
		return statusName;
	}


	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}


	/* Duplicate Check */
	private int voucherDuplicate;

	
	private Employee employeeIdDetails;
	private VoucherTypeBean voucherTypeIdDetails;

	/* Setters and getters for Voucher Bean	 */

	
	public int getVoucherId() {
		return voucherId;
	}


	public String getVoucherTypeName() {
		return voucherTypeName;
	}


	public void setVoucherTypeName(String voucherTypeName) {
		this.voucherTypeName = voucherTypeName;
	}


	public String getWorkFlowListId() {
		return workFlowListId;
	}


	public void setWorkFlowListId(String workFlowListId) {
		this.workFlowListId = workFlowListId;
	}


	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}


	public String getSignature() {
		return signature;
	}


	public void setSignature(String signature) {
		this.signature = signature;
	}


	public String getVoucherDT() {
		return voucherDT;
	}


	public void setVoucherDT(String voucherDT) {
		this.voucherDT = voucherDT;
	}


	public String getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}


	public String getStatusId() {
		return statusId;
	}


	public void setStatusId(String statusId) {
		this.statusId = statusId;
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


	public int getVoucherDuplicate() {
		return voucherDuplicate;
	}


	public void setVoucherDuplicate(int voucherDuplicate) {
		this.voucherDuplicate = voucherDuplicate;
	}


	public Employee getEmployeeIdDetails() {
		return employeeIdDetails;
	}


	public void setEmployeeIdDetails(Employee employeeIdDetails) {
		this.employeeIdDetails = employeeIdDetails;
	}


	public byte[] getSign() {
		return sign;
	}


	public void setSign(byte[] sign) {
		this.sign = sign;
	}


	public String getVoucherNo() {
		return voucherNo;
	}


	public void setVoucherNo(String voucherNo) {
		this.voucherNo = voucherNo;
	}


	public String getVoucherType_Id() {
		return voucherType_Id;
	}


	public void setVoucherType_Id(String voucherType_Id) {
		this.voucherType_Id = voucherType_Id;
	}


	public VoucherTypeBean getVoucherTypeIdDetails() {
		return voucherTypeIdDetails;
	}


	public void setVoucherTypeIdDetails(VoucherTypeBean voucherTypeIdDetails) {
		this.voucherTypeIdDetails = voucherTypeIdDetails;
	}


}
