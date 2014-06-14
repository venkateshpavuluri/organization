package com.mnt.erp.bean;

public class EmpQualification {

	private int empQual_Id;
	private String employee_Id;
	private String qualification_Id;
	private String yearPassed;
	private String grade;
	private String board;
	private String totMarks;
	private String percentage;
	private int aid;
	
	private Employee employee;
	
	private String empName;
	private String qualificationName;
	private Qualification qualification;
	
	//Basic search Properties
	
	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	
	
	//Edit Properties
	
	private int empQual_IdEdit;
	private String employee_IdEdit;
	private String qualification_IdEdit;
	private String yearPassedEdit;
	private String gradeEdit;
	private String boardEdit;
	private String totMarksEdit;
	private String percentageEdit;
	
	public int getEmpQual_Id() {
		return empQual_Id;
	}
	public void setEmpQual_Id(int empQual_Id) {
		this.empQual_Id = empQual_Id;
	}
	public String getEmployee_Id() {
		return employee_Id;
	}
	
	
	public String getEmpName() {
		return empName;
	}
	public String getQualificationName() {
		return qualificationName;
	}
	public String getOperations() {
		return operations;
	}
	public String getBasicSearchId() {
		return basicSearchId;
	}
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setEmployee_Id(String employee_Id) {
		this.employee_Id = employee_Id;
	}
	public String getQualification_Id() {
		return qualification_Id;
	}
	public void setQualification_Id(String qualification_Id) {
		this.qualification_Id = qualification_Id;
	}
	public String getYearPassed() {
		return yearPassed;
	}
	public void setYearPassed(String yearPassed) {
		this.yearPassed = yearPassed;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getTotMarks() {
		return totMarks;
	}
	public void setTotMarks(String totMarks) {
		this.totMarks = totMarks;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Qualification getQualification() {
		return qualification;
	}
	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}
	public int getEmpQual_IdEdit() {
		return empQual_IdEdit;
	}
	public void setEmpQual_IdEdit(int empQual_IdEdit) {
		this.empQual_IdEdit = empQual_IdEdit;
	}
	public String getEmployee_IdEdit() {
		return employee_IdEdit;
	}
	public void setEmployee_IdEdit(String employee_IdEdit) {
		this.employee_IdEdit = employee_IdEdit;
	}
	public String getQualification_IdEdit() {
		return qualification_IdEdit;
	}
	public void setQualification_IdEdit(String qualification_IdEdit) {
		this.qualification_IdEdit = qualification_IdEdit;
	}
	public String getYearPassedEdit() {
		return yearPassedEdit;
	}
	public void setYearPassedEdit(String yearPassedEdit) {
		this.yearPassedEdit = yearPassedEdit;
	}
	public String getGradeEdit() {
		return gradeEdit;
	}
	public void setGradeEdit(String gradeEdit) {
		this.gradeEdit = gradeEdit;
	}
	public String getBoardEdit() {
		return boardEdit;
	}
	public void setBoardEdit(String boardEdit) {
		this.boardEdit = boardEdit;
	}
	public String getTotMarksEdit() {
		return totMarksEdit;
	}
	public void setTotMarksEdit(String totMarksEdit) {
		this.totMarksEdit = totMarksEdit;
	}
	public String getPercentageEdit() {
		return percentageEdit;
	}
	public void setPercentageEdit(String percentageEdit) {
		this.percentageEdit = percentageEdit;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}
	public void setOperations(String operations) {
		this.operations = operations;
	}
	public void setBasicSearchId(String basicSearchId) {
		this.basicSearchId = basicSearchId;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
	}
	
	
	
}