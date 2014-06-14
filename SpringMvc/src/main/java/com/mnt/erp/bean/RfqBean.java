package com.mnt.erp.bean;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class RfqBean {
	private int rfqid;
	private String rfqType;
	private String rfqNo;
	private String rfqDate;
	private String quotationdeadline;
	private String itemCategory;
	private String  deliveryDate;
	private String  validFrom;
	private String  validTo;
	private String storageLocation;
	private String palntRfq;
	private String refNumber;
	private String purchaseGrouprfq;
	private String statusid;
	
	private int rfqidedit;
	private String rfqTypeedit;
	private String rfqNoedit;
	private String rfqDateedit;
	private String quotationdeadlineedit;
	private String itemCategoryedit;
	private String  deliveryDateedit;
	private String  validFromedit;
	private String  validToedit;
	private String storageLocationedit;
	private String palntRfqedit;
	private String refNumberedit;
	private String purchaseGrouprfqeit;
	private String statusidedit;
	private int rfqhide;
	private int[] rfqlineid;
	private String[] rfqlinetypeid;
	private String materialid;
	
	private int[] qty;
	private String uomid;
	
	private String[] deliverydate;
	private int[] rfqlineidedit;
	private String[] rfqlinetypeidedit;
	private String materialidedit;
	private int[] qtyedit;
	private String uomidedit;
	private String[] deliverydateedit;
    private String xmlLabel;
    private String operations;
    private String basicSearchId;
    private List<RFQLineBean> rfqlinebean;
    private List rfqlineeditlist;
  
   private RFQType rfqbean;
   private ItemCategory itemcategorybean;
   private StorageLocation storagelocationbean;
   private Plant plantbean;
   private PurchaseGroup purchasegroupbean;
   private Status statusbean;
   private Material materialbean;
   private Uom uombean;
   private String materialidName;
   private String uomidName;
    
    private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	private String valueForSubData;
	
   
	public String getValueForSubData() {
		return valueForSubData;
	}
	public void setValueForSubData(String valueForSubData) {
		this.valueForSubData = valueForSubData;
	}
	public Status getStatusbean() {
		return statusbean;
	}
	public void setStatusbean(Status statusbean) {
		this.statusbean = statusbean;
	}
	public String getStatusidedit() {
		return statusidedit;
	}
	public void setStatusidedit(String statusidedit) {
		this.statusidedit = statusidedit;
	}
	public String getStatusid() {
		return statusid;
	}
	public void setStatusid(String statusid) {
		this.statusid = statusid;
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
	public Material getMaterialbean() {
	return materialbean;
}
public void setMaterialbean(Material materialbean) {
	this.materialbean = materialbean;
}
public Uom getUombean() {
	return uombean;
}
public void setUombean(Uom uombean) {
	this.uombean = uombean;
}
	public String getMaterialidName() {
	return materialidName;
}
public void setMaterialidName(String materialidName) {
	this.materialidName = materialidName;
}
public String getUomidName() {
	return uomidName;
}
public void setUomidName(String uomidName) {
	this.uomidName = uomidName;
}
	public ItemCategory getItemcategorybean() {
	return itemcategorybean;
}
public void setItemcategorybean(ItemCategory itemcategorybean) {
	this.itemcategorybean = itemcategorybean;
}
public StorageLocation getStoragelocationbean() {
	return storagelocationbean;
}
public void setStoragelocationbean(StorageLocation storagelocationbean) {
	this.storagelocationbean = storagelocationbean;
}
public Plant getPlantbean() {
	return plantbean;
}
public void setPlantbean(Plant plantbean) {
	this.plantbean = plantbean;
}
public PurchaseGroup getPurchasegroupbean() {
	return purchasegroupbean;
}
public void setPurchasegroupbean(PurchaseGroup purchasegroupbean) {
	this.purchasegroupbean = purchasegroupbean;
}
	public RFQType getRfqbean() {
	return rfqbean;
}
public void setRfqbean(RFQType rfqbean) {
	this.rfqbean = rfqbean;
}
	public List getRfqlineeditlist() {
		return rfqlineeditlist;
	}
	public void setRfqlineeditlist(List rfqlineeditlist) {
		this.rfqlineeditlist = rfqlineeditlist;
	}
	public List<RFQLineBean> getRfqlinebean() {
		return rfqlinebean;
	}
	public void setRfqlinebean(List<RFQLineBean> rfqlinebean) {
		this.rfqlinebean = rfqlinebean;
	}
	public int getRfqid() {
		return rfqid;
	}
	public void setRfqid(int rfqid) {
		this.rfqid = rfqid;
	}
	public String getRfqType() {
		return rfqType;
	}
	public void setRfqType(String rfqType) {
		this.rfqType = rfqType;
	}
	public String getRfqNo() {
		return rfqNo;
	}
	public void setRfqNo(String rfqNo) {
		this.rfqNo = rfqNo;
	}
	public String getRfqDate() {
		return rfqDate;
	}
	public void setRfqDate(String rfqDate) {
		this.rfqDate = rfqDate;
	}
	public String getQuotationdeadline() {
		return quotationdeadline;
	}
	public void setQuotationdeadline(String quotationdeadline) {
		this.quotationdeadline = quotationdeadline;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getValidFrom() {
		return validFrom;
	}
	public void setValidFrom(String validFrom) {
		this.validFrom = validFrom;
	}
	public String getValidTo() {
		return validTo;
	}
	public void setValidTo(String validTo) {
		this.validTo = validTo;
	}
	public String getStorageLocation() {
		return storageLocation;
	}
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	public String getPalntRfq() {
		return palntRfq;
	}
	public void setPalntRfq(String palntRfq) {
		this.palntRfq = palntRfq;
	}
	public String getRefNumber() {
		return refNumber;
	}
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}
	public String getPurchaseGrouprfq() {
		return purchaseGrouprfq;
	}
	public void setPurchaseGrouprfq(String purchaseGrouprfq) {
		this.purchaseGrouprfq = purchaseGrouprfq;
	}
	public int getRfqhide() {
		return rfqhide;
	}
	public void setRfqhide(int rfqhide) {
		this.rfqhide = rfqhide;
	}
	public int[] getRfqlineid() {
		return rfqlineid;
	}
	public void setRfqlineid(int[] rfqlineid) {
		this.rfqlineid = rfqlineid;
	}
	public String[] getRfqlinetypeid() {
		return rfqlinetypeid;
	}
	public void setRfqlinetypeid(String[] rfqlinetypeid) {
		this.rfqlinetypeid = rfqlinetypeid;
	}
	
	public String getMaterialid() {
		return materialid;
	}
	public void setMaterialid(String materialid) {
		this.materialid = materialid;
	}
	public int[] getQty() {
		return qty;
	}
	public void setQty(int[] qty) {
		this.qty = qty;
	}
	
	public String getUomid() {
		return uomid;
	}
	public void setUomid(String uomid) {
		this.uomid = uomid;
	}
	public String[] getDeliverydate() {
		return deliverydate;
		
	}
	public void setDeliverydate(String[] deliverydate) {
		this.deliverydate = deliverydate;
	}
	public int[] getRfqlineidedit() {
		return rfqlineidedit;
	}
	public void setRfqlineidedit(int[] rfqlineidedit) {
		this.rfqlineidedit = rfqlineidedit;
	}
	public String[] getRfqlinetypeidedit() {
		return rfqlinetypeidedit;
	}
	public void setRfqlinetypeidedit(String[] rfqlinetypeidedit) {
		this.rfqlinetypeidedit = rfqlinetypeidedit;
	}
	public String getMaterialidedit() {
		return materialidedit;
	}
	public void setMaterialidedit(String materialidedit) {
		this.materialidedit = materialidedit;
	}
	public int[] getQtyedit() {
		return qtyedit;
	}
	public void setQtyedit(int[] qtyedit) {
		this.qtyedit = qtyedit;
	}
	public String getUomidedit() {
		return uomidedit;
	}
	public void setUomidedit(String uomidedit) {
		this.uomidedit = uomidedit;
	}
	public String[] getDeliverydateedit() {
		return deliverydateedit;
	}
	public void setDeliverydateedit(String[] deliverydateedit) {
		this.deliverydateedit = deliverydateedit;
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
	public int getRfqidedit() {
		return rfqidedit;
	}
	public void setRfqidedit(int rfqidedit) {
		this.rfqidedit = rfqidedit;
	}
	public String getRfqTypeedit() {
		return rfqTypeedit;
	}
	public void setRfqTypeedit(String rfqTypeedit) {
		this.rfqTypeedit = rfqTypeedit;
	}
	public String getRfqNoedit() {
		return rfqNoedit;
	}
	public void setRfqNoedit(String rfqNoedit) {
		this.rfqNoedit = rfqNoedit;
	}
	public String getRfqDateedit() {
		return rfqDateedit;
	}
	public void setRfqDateedit(String rfqDateedit) {
		this.rfqDateedit = rfqDateedit;
	}
	public String getQuotationdeadlineedit() {
		return quotationdeadlineedit;
	}
	public void setQuotationdeadlineedit(String quotationdeadlineedit) {
		this.quotationdeadlineedit = quotationdeadlineedit;
	}
	public String getItemCategoryedit() {
		return itemCategoryedit;
	}
	public void setItemCategoryedit(String itemCategoryedit) {
		this.itemCategoryedit = itemCategoryedit;
	}
	public String getDeliveryDateedit() {
		return deliveryDateedit;
	}
	public void setDeliveryDateedit(String deliveryDateedit) {
		this.deliveryDateedit = deliveryDateedit;
	}
	public String getValidFromedit() {
		return validFromedit;
	}
	public void setValidFromedit(String validFromedit) {
		this.validFromedit = validFromedit;
	}
	public String getValidToedit() {
		return validToedit;
	}
	public void setValidToedit(String validToedit) {
		this.validToedit = validToedit;
	}
	public String getStorageLocationedit() {
		return storageLocationedit;
	}
	public void setStorageLocationedit(String storageLocationedit) {
		this.storageLocationedit = storageLocationedit;
	}
	public String getPalntRfqedit() {
		return palntRfqedit;
	}
	public void setPalntRfqedit(String palntRfqedit) {
		this.palntRfqedit = palntRfqedit;
	}
	public String getRefNumberedit() {
		return refNumberedit;
	}
	public void setRefNumberedit(String refNumberedit) {
		this.refNumberedit = refNumberedit;
	}
	public String getPurchaseGrouprfqeit() {
		return purchaseGrouprfqeit;
	}
	public void setPurchaseGrouprfqeit(String purchaseGrouprfqeit) {
		this.purchaseGrouprfqeit = purchaseGrouprfqeit;
	}
	

}
