package com.mnt.erp.bean;

import java.util.List;

public class CustomerInvoice {
	private int customerinvoiceid;
	private String customerinvoiceno;
	private String customerinvoicedate;
	private String postingdate;
	private String deliverynoteid;
	private float amount;
	private String currencyid;
	private String reference;
	private String description;
	private String orgid;
	private String fy;

	private int editcustomerinvoiceid;
	private String editcustomerinvoiceno;
	private String editcustomerinvoicedate;
	private String editpostingdate;
	private String editdeliverynoteid;
	private float editamount;
	private String editcurrencyid;
	private String editreference;
	private String editdescription;
	private String editorgid;
	private String editfy;

	private List<CustomerInvoiceLine> customerinvoicelinebean;
	private List editcustomerinvoicelinebean;
	private int[] customerinvoicelineid;
	private String materialid;
	private int[] qty;
	private String uomid;
	private String[] price;
	private String[] tax;

	private int[] editcustomerinvoicelineid;
	private String editmaterialid;
	private int[] editqty;
	private String edituomid;
	private String[] editprice;
	private String[] edittax;

	private String materialName;
	private String uomidName;
	private String materialNameedit;
	private String uomNameedit;
   private String  materialidName;;
	private String xmlLabel;
	private String operations;
	private String basicSearchId;

	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;

	private DeliveryNote deliverynotebean;
	private Currency currencybean;
	private Organization orgbean;
	private Material materialbean;
    private Uom uombean;
	
	public String getMaterialidName() {
		return materialidName;
	}

	public void setMaterialidName(String materialidName) {
		this.materialidName = materialidName;
	}

	public int getCustomerinvoiceid() {
		return customerinvoiceid;
	}

	public void setCustomerinvoiceid(int customerinvoiceid) {
		this.customerinvoiceid = customerinvoiceid;
	}

	public String getCustomerinvoiceno() {
		return customerinvoiceno;
	}

	public void setCustomerinvoiceno(String customerinvoiceno) {
		this.customerinvoiceno = customerinvoiceno;
	}

	public String getCustomerinvoicedate() {
		return customerinvoicedate;
	}

	public void setCustomerinvoicedate(String customerinvoicedate) {
		this.customerinvoicedate = customerinvoicedate;
	}

	public String getPostingdate() {
		return postingdate;
	}

	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}

	public String getDeliverynoteid() {
		return deliverynoteid;
	}

	public void setDeliverynoteid(String deliverynoteid) {
		this.deliverynoteid = deliverynoteid;
	}


	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public void setEditamount(float editamount) {
		this.editamount = editamount;
	}

	public String getCurrencyid() {
		return currencyid;
	}

	public void setCurrencyid(String currencyid) {
		this.currencyid = currencyid;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getFy() {
		return fy;
	}

	public void setFy(String fy) {
		this.fy = fy;
	}

	public int getEditcustomerinvoiceid() {
		return editcustomerinvoiceid;
	}

	public void setEditcustomerinvoiceid(int editcustomerinvoiceid) {
		this.editcustomerinvoiceid = editcustomerinvoiceid;
	}

	public String getEditcustomerinvoiceno() {
		return editcustomerinvoiceno;
	}

	public void setEditcustomerinvoiceno(String editcustomerinvoiceno) {
		this.editcustomerinvoiceno = editcustomerinvoiceno;
	}

	public String getEditcustomerinvoicedate() {
		return editcustomerinvoicedate;
	}

	public void setEditcustomerinvoicedate(String editcustomerinvoicedate) {
		this.editcustomerinvoicedate = editcustomerinvoicedate;
	}

	public String getEditpostingdate() {
		return editpostingdate;
	}

	public void setEditpostingdate(String editpostingdate) {
		this.editpostingdate = editpostingdate;
	}

	public String getEditdeliverynoteid() {
		return editdeliverynoteid;
	}

	public void setEditdeliverynoteid(String editdeliverynoteid) {
		this.editdeliverynoteid = editdeliverynoteid;
	}


	public float getEditamount() {
		return editamount;
	}

	public String getEditcurrencyid() {
		return editcurrencyid;
	}

	public void setEditcurrencyid(String editcurrencyid) {
		this.editcurrencyid = editcurrencyid;
	}

	public String getEditreference() {
		return editreference;
	}

	public void setEditreference(String editreference) {
		this.editreference = editreference;
	}

	public String getEditdescription() {
		return editdescription;
	}

	public void setEditdescription(String editdescription) {
		this.editdescription = editdescription;
	}

	public String getEditorgid() {
		return editorgid;
	}

	public void setEditorgid(String editorgid) {
		this.editorgid = editorgid;
	}

	public String getEditfy() {
		return editfy;
	}

	public void setEditfy(String editfy) {
		this.editfy = editfy;
	}

	public List<CustomerInvoiceLine> getCustomerinvoicelinebean() {
		return customerinvoicelinebean;
	}

	public void setCustomerinvoicelinebean(
			List<CustomerInvoiceLine> customerinvoicelinebean) {
		this.customerinvoicelinebean = customerinvoicelinebean;
	}

	public List getEditcustomerinvoicelinebean() {
		return editcustomerinvoicelinebean;
	}

	public void setEditcustomerinvoicelinebean(List editcustomerinvoicelinebean) {
		this.editcustomerinvoicelinebean = editcustomerinvoicelinebean;
	}

	public int[] getCustomerinvoicelineid() {
		return customerinvoicelineid;
	}

	public void setCustomerinvoicelineid(int[] customerinvoicelineid) {
		this.customerinvoicelineid = customerinvoicelineid;
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

	public String[] getPrice() {
		return price;
	}

	public void setPrice(String[] price) {
		this.price = price;
	}

	public String[] getTax() {
		return tax;
	}

	public void setTax(String[] tax) {
		this.tax = tax;
	}

	
	public int[] getEditcustomerinvoicelineid() {
		return editcustomerinvoicelineid;
	}

	public void setEditcustomerinvoicelineid(int[] editcustomerinvoicelineid) {
		this.editcustomerinvoicelineid = editcustomerinvoicelineid;
	}

	public String getEditmaterialid() {
		return editmaterialid;
	}

	public void setEditmaterialid(String editmaterialid) {
		this.editmaterialid = editmaterialid;
	}

	public int[] getEditqty() {
		return editqty;
	}

	public void setEditqty(int[] editqty) {
		this.editqty = editqty;
	}

	public String getEdituomid() {
		return edituomid;
	}

	public void setEdituomid(String edituomid) {
		this.edituomid = edituomid;
	}

	public String[] getEditprice() {
		return editprice;
	}

	public void setEditprice(String[] editprice) {
		this.editprice = editprice;
	}

	public String[] getEdittax() {
		return edittax;
	}

	public void setEdittax(String[] edittax) {
		this.edittax = edittax;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getUomidName() {
		return uomidName;
	}

	public void setUomidName(String uomidName) {
		this.uomidName = uomidName;
	}

	public String getMaterialNameedit() {
		return materialNameedit;
	}

	public void setMaterialNameedit(String materialNameedit) {
		this.materialNameedit = materialNameedit;
	}

	public String getUomNameedit() {
		return uomNameedit;
	}

	public void setUomNameedit(String uomNameedit) {
		this.uomNameedit = uomNameedit;
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

	public DeliveryNote getDeliverynotebean() {
		return deliverynotebean;
	}

	public void setDeliverynotebean(DeliveryNote deliverynotebean) {
		this.deliverynotebean = deliverynotebean;
	}

	public Currency getCurrencybean() {
		return currencybean;
	}

	public void setCurrencybean(Currency currencybean) {
		this.currencybean = currencybean;
	}

	public Organization getOrgbean() {
		return orgbean;
	}

	public void setOrgbean(Organization orgbean) {
		this.orgbean = orgbean;
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

}
