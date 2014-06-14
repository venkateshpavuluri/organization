package com.mnt.erp.bean;

/**
 * @author Srinivas

 */
import java.util.List;

public class ProcessBean {
	private int processid;
	private String process;
private String materialprocess;
private String version;
	private String processedit;
	private String materialprocessEdit;
	private String versionEdit;
	private List<ProcessDetailBean> processdetailbean;
	private int[] processdetailid;
	private int[] processseq;
	private String[] processtypeid;
	private String processtypeid1;
	private String[] processdescription;
	private String[] predessor;
	private String[] successor;
	private String[] stageinspection;
	private String stageinspection1;
	private String[] serialcontrol;
	private String serialcontrol1;
	private int[] inspectionpct;
	private int[] processdetailidedit;
	private int processidedit;
	private int[] processseqedit;
	private String processtypeidedit1;
	private String[] processtypeidedit;
	private String[] processdescriptionedit;
	private String[] predessoredit;
	private String[] successoredit;
	private String[] stageinspectionedit;
	private String[] serialcontroledit;
	private String[] stageinspectionedit1;
	private String[] serialcontroledit1;
	private String[] stageinspectionedit2;
	private String[] serialcontroledit2;
	private int[] inspectionpctedit;
	private int processhide;
	private int processhideedit;
	private List processdetaileditlist;
	private String stageinspectionedits;
	private String serialcontroledits;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String[] processtypeidedit2;
  
	private int id;
	private String tagName;
	private String processTypeName;
	private String serialcontrolNameEdit;
	private String stageinspectionNameEdit;
	private ProcessTypeBean ptbean;
	
	private Material materialbean;
	
	public Material getMaterialbean() {
		return materialbean;
	}

	public void setMaterialbean(Material materialbean) {
		this.materialbean = materialbean;
	}

	public String getMaterialprocessEdit() {
		return materialprocessEdit;
	}

	public void setMaterialprocessEdit(String materialprocessEdit) {
		this.materialprocessEdit = materialprocessEdit;
	}

	public String getVersionEdit() {
		return versionEdit;
	}

	public void setVersionEdit(String versionEdit) {
		this.versionEdit = versionEdit;
	}

	public String getMaterialprocess() {
		return materialprocess;
	}

	public void setMaterialprocess(String materialprocess) {
		this.materialprocess = materialprocess;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String[] getStageinspectionedit2() {
		return stageinspectionedit2;
	}

	public void setStageinspectionedit2(String[] stageinspectionedit2) {
		this.stageinspectionedit2 = stageinspectionedit2;
	}

	public String[] getSerialcontroledit2() {
		return serialcontroledit2;
	}

	public void setSerialcontroledit2(String[] serialcontroledit2) {
		this.serialcontroledit2 = serialcontroledit2;
	}

	public ProcessTypeBean getPtbean() {
		return ptbean;
	}

	public void setPtbean(ProcessTypeBean ptbean) {
		this.ptbean = ptbean;
	}

	public String getStageinspectionedits() {
		return stageinspectionedits;
	}

	public void setStageinspectionedits(String stageinspectionedits) {
		this.stageinspectionedits = stageinspectionedits;
	}

	public String getSerialcontroledits() {
		return serialcontroledits;
	}

	public void setSerialcontroledits(String serialcontroledits) {
		this.serialcontroledits = serialcontroledits;
	}

	public String getSerialcontrolNameEdit() {
		return serialcontrolNameEdit;
	}

	public void setSerialcontrolNameEdit(String serialcontrolNameEdit) {
		this.serialcontrolNameEdit = serialcontrolNameEdit;
	}

	public String getStageinspectionNameEdit() {
		return stageinspectionNameEdit;
	}

	public void setStageinspectionNameEdit(String stageinspectionNameEdit) {
		this.stageinspectionNameEdit = stageinspectionNameEdit;
	}

	public String getProcessTypeName() {
		return processTypeName;
	}

	public void setProcessTypeName(String processTypeName) {
		this.processTypeName = processTypeName;
	}

	public String[] getProcesstypeidedit2() {
		return processtypeidedit2;
	}

	public void setProcesstypeidedit2(String[] processtypeidedit2) {
		this.processtypeidedit2 = processtypeidedit2;
	}

	
	

	public String[] getStageinspectionedit1() {
		return stageinspectionedit1;
	}

	public void setStageinspectionedit1(String[] stageinspectionedit1) {
		this.stageinspectionedit1 = stageinspectionedit1;
	}

	public String[] getSerialcontroledit1() {
		return serialcontroledit1;
	}

	public void setSerialcontroledit1(String[] serialcontroledit1) {
		this.serialcontroledit1 = serialcontroledit1;
	}

	public String getProcesstypeidedit1() {
		return processtypeidedit1;
	}

	public void setProcesstypeidedit1(String processtypeidedit1) {
		this.processtypeidedit1 = processtypeidedit1;
	}

	public String getProcesstypeid1() {
		return processtypeid1;
	}

	public void setProcesstypeid1(String processtypeid1) {
		this.processtypeid1 = processtypeid1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
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

	public List getProcessdetaileditlist() {
		return processdetaileditlist;
	}

	public void setProcessdetaileditlist(List processdetaileditlist) {
		this.processdetaileditlist = processdetaileditlist;
	}

	private String[] pId;

	public String[] getpId() {
		return pId;
	}

	public void setpId(String[] pId) {
		this.pId = pId;
	}

	public String[] getpSeq() {
		return pSeq;
	}

	public void setpSeq(String[] pSeq) {
		this.pSeq = pSeq;
	}

	public String[] getpTypeId() {
		return pTypeId;
	}

	public void setpTypeId(String[] pTypeId) {
		this.pTypeId = pTypeId;
	}

	public String[] getpDesc() {
		return pDesc;
	}

	public void setpDesc(String[] pDesc) {
		this.pDesc = pDesc;
	}

	public String[] getpPred() {
		return pPred;
	}

	public void setpPred(String[] pPred) {
		this.pPred = pPred;
	}

	public String[] getpSus() {
		return pSus;
	}

	public void setpSus(String[] pSus) {
		this.pSus = pSus;
	}

	public String[] getpInsp() {
		return pInsp;
	}

	public void setpInsp(String[] pInsp) {
		this.pInsp = pInsp;
	}

	public String[] getpSer() {
		return pSer;
	}

	public void setpSer(String[] pSer) {
		this.pSer = pSer;
	}

	public String[] getpInpct() {
		return pInpct;
	}

	public void setpInpct(String[] pInpct) {
		this.pInpct = pInpct;
	}

	private String[] pSeq;
	private String[] pTypeId;
	private String[] pDesc;
	private String[] pPred;
	private String[] pSus;
	private String[] pInsp;
	private String[] pSer;
	private String[] pInpct;

	public int getProcesshide() {
		return processhide;
	}

	public void setProcesshide(int processhide) {
		this.processhide = processhide;
	}

	public int getProcesshideedit() {
		return processhideedit;
	}

	public void setProcesshideedit(int processhideedit) {
		this.processhideedit = processhideedit;
	}

	public int[] getProcessdetailid() {
		return processdetailid;
	}

	public void setProcessdetailid(int[] processdetailid) {
		this.processdetailid = processdetailid;
	}

	public int[] getProcessdetailidedit() {
		return processdetailidedit;
	}

	public void setProcessdetailidedit(int[] processdetailidedit) {
		this.processdetailidedit = processdetailidedit;
	}

	public int[] getProcessseq() {
		return processseq;
	}

	public void setProcessseq(int[] processseq) {
		this.processseq = processseq;
	}

	public String[] getProcesstypeid() {
		return processtypeid;
	}

	public void setProcesstypeid(String[] processtypeid) {
		this.processtypeid = processtypeid;
	}

	public int[] getInspectionpct() {
		return inspectionpct;
	}

	public void setInspectionpct(int[] inspectionpct) {
		this.inspectionpct = inspectionpct;
	}

	public int getProcessid() {
		return processid;
	}

	public void setProcessid(int processid) {
		this.processid = processid;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public int getProcessidedit() {
		return processidedit;
	}

	public void setProcessidedit(int processidedit) {
		this.processidedit = processidedit;
	}

	public String getProcessedit() {
		return processedit;
	}

	public void setProcessedit(String processedit) {
		this.processedit = processedit;
	}

	public List<ProcessDetailBean> getProcessdetailbean() {
		return processdetailbean;
	}

	public void setProcessdetailbean(List<ProcessDetailBean> processdetailbean) {
		this.processdetailbean = processdetailbean;
	}

	public String[] getProcessdescription() {
		return processdescription;
	}

	public void setProcessdescription(String[] processdescription) {
		this.processdescription = processdescription;
	}

	public String[] getPredessor() {
		return predessor;
	}

	public void setPredessor(String[] predessor) {
		this.predessor = predessor;
	}

	public String[] getSuccessor() {
		return successor;
	}

	public void setSuccessor(String[] successor) {
		this.successor = successor;
	}

	public int[] getProcessseqedit() {
		return processseqedit;
	}

	public void setProcessseqedit(int[] processseqedit) {
		this.processseqedit = processseqedit;
	}

	public String[] getProcesstypeidedit() {
		return processtypeidedit;
	}

	public void setProcesstypeidedit(String[] processtypeidedit) {
		this.processtypeidedit = processtypeidedit;
	}

	public String[] getProcessdescriptionedit() {
		return processdescriptionedit;
	}

	public void setProcessdescriptionedit(String[] processdescriptionedit) {
		this.processdescriptionedit = processdescriptionedit;
	}

	public String[] getPredessoredit() {
		return predessoredit;
	}

	public void setPredessoredit(String[] predessoredit) {
		this.predessoredit = predessoredit;
	}

	public String[] getSuccessoredit() {
		return successoredit;
	}

	public void setSuccessoredit(String[] successoredit) {
		this.successoredit = successoredit;
	}

	public String[] getStageinspection() {
		return stageinspection;
	}

	public void setStageinspection(String[] stageinspection) {
		this.stageinspection = stageinspection;
	}

	public String getStageinspection1() {
		return stageinspection1;
	}

	public void setStageinspection1(String stageinspection1) {
		this.stageinspection1 = stageinspection1;
	}

	public String[] getSerialcontrol() {
		return serialcontrol;
	}

	public void setSerialcontrol(String[] serialcontrol) {
		this.serialcontrol = serialcontrol;
	}

	public String getSerialcontrol1() {
		return serialcontrol1;
	}

	public void setSerialcontrol1(String serialcontrol1) {
		this.serialcontrol1 = serialcontrol1;
	}

	public String[] getStageinspectionedit() {
		return stageinspectionedit;
	}

	public void setStageinspectionedit(String[] stageinspectionedit) {
		this.stageinspectionedit = stageinspectionedit;
	}

	public String[] getSerialcontroledit() {
		return serialcontroledit;
	}

	public void setSerialcontroledit(String[] serialcontroledit) {
		this.serialcontroledit = serialcontroledit;
	}

	public int[] getInspectionpctedit() {
		return inspectionpctedit;
	}

	public void setInspectionpctedit(int[] inspectionpctedit) {
		this.inspectionpctedit = inspectionpctedit;
	}

}
