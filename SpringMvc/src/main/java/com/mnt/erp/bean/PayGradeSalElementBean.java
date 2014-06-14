/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author devi
 *
 */
public class PayGradeSalElementBean {
	private int payGradeSalElement_Id;
	private String payGrade_Id;
	private String payElement_Id;
	private String amount_Formulae;
	private Boolean include;
		
	
	private int payGradeSalElement_IdEdit;
	private String payGrade_IdEdit;
	private String payElement_IdEdit;
	private String amount_FormulaeEdit;
	private Boolean includeEdit;
		
   	private int aid;
	private int payGradehide;
	private int payGradedupedit;
	
	private String xmlLabel;
    private String operations;
    private String basicSearchId;
    
    private PayGradeBean payGradeBean;
    private PayElementBean payElementBean;
    
    
    
	public int getPayGradeSalElement_IdEdit() {
		return payGradeSalElement_IdEdit;
	}
	public void setPayGradeSalElement_IdEdit(int payGradeSalElement_IdEdit) {
		this.payGradeSalElement_IdEdit = payGradeSalElement_IdEdit;
	}
	public String getPayGrade_IdEdit() {
		return payGrade_IdEdit;
	}
	public void setPayGrade_IdEdit(String payGrade_IdEdit) {
		this.payGrade_IdEdit = payGrade_IdEdit;
	}
	public String getPayElement_IdEdit() {
		return payElement_IdEdit;
	}
	public void setPayElement_IdEdit(String payElement_IdEdit) {
		this.payElement_IdEdit = payElement_IdEdit;
	}
	public String getAmount_FormulaeEdit() {
		return amount_FormulaeEdit;
	}
	public void setAmount_FormulaeEdit(String amount_FormulaeEdit) {
		this.amount_FormulaeEdit = amount_FormulaeEdit;
	}
	public Boolean getIncludeEdit() {
		return includeEdit;
	}
	public void setIncludeEdit(Boolean includeEdit) {
		this.includeEdit = includeEdit;
	}
	public int getPayGradeSalElement_Id() {
		return payGradeSalElement_Id;
	}
	public void setPayGradeSalElement_Id(int payGradeSalElement_Id) {
		this.payGradeSalElement_Id = payGradeSalElement_Id;
	}
	public String getPayGrade_Id() {
		return payGrade_Id;
	}
	public void setPayGrade_Id(String payGrade_Id) {
		this.payGrade_Id = payGrade_Id;
	}
	public String getPayElement_Id() {
		return payElement_Id;
	}
	public void setPayElement_Id(String payElement_Id) {
		this.payElement_Id = payElement_Id;
	}
	public String getAmount_Formulae() {
		return amount_Formulae;
	}
	public void setAmount_Formulae(String amount_Formulae) {
		this.amount_Formulae = amount_Formulae;
	}
	
	public Boolean getInclude() {
		return include;
	}
	public void setInclude(Boolean include) {
		this.include = include;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getPayGradehide() {
		return payGradehide;
	}
	public void setPayGradehide(int payGradehide) {
		this.payGradehide = payGradehide;
	}
	public int getPayGradedupedit() {
		return payGradedupedit;
	}
	public void setPayGradedupedit(int payGradedupedit) {
		this.payGradedupedit = payGradedupedit;
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
	public PayGradeBean getPayGradeBean() {
		return payGradeBean;
	}
	public void setPayGradeBean(PayGradeBean payGradeBean) {
		this.payGradeBean = payGradeBean;
	}
	public PayElementBean getPayElementBean() {
		return payElementBean;
	}
	public void setPayElementBean(PayElementBean payElementBean) {
		this.payElementBean = payElementBean;
	}
    
    
    

}
