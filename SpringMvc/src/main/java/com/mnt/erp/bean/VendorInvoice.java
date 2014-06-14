package com.mnt.erp.bean;

import java.util.List;

public class VendorInvoice {
	private int vendorinvoiceid;
	private String vendorinvoiceno;
	private String vendorinvoicedate;
	private String postingdate;
	private float amount;
	private String currencyid;
	private String reference;
	private String description;
	private String purchaseorderid;
	private String orgid;
	private String fy;
	private String vendorid;

	private int editvendorinvoiceid;
	private String editvendorinvoiceno;
	private String editvendorinvoicedate;
	private String editpostingdate;
	private float editamount;
	private String editcurrencyid;
	private String editreference;
	private String editdescription;
	private String editpurchaseorderid;
	private String editorgid;
	private String editfy;
	private String editvendorid;
	
	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	
	private String firstLabel;
	private String secondLabel;
	private String operations1;
	private String advanceSearchText;
	private int advanceSearchHidden;
	
	private List<VendorInvoiceLine> vendorinvoicelinebean;
	private List editvendorinvoicelinebean;
	private Currency currencybean;
	private PurchaseOrder purchaseorderbean;
	private Organization orgbean;
	private Vendor vendorbean;
	private Material materialbean;
    private Uom uombean;
	
    private int[] vendorinvoicelineid;
	private String materialid;
	private int[] qty;
	private String uomid;
	private String[] price;
	private String[] tax;
	
	    private int[] editvendorinvoicelineid;
		private String editmaterialid;
		private int[] editqty;
		private String edituomid;
		private String[] editprice;
		private String[] edittax;
   private String materialName;
   private String uomidName;
   private String materialNameedit;
   private String uomNameedit;
		private String materialidName;
		
	public String getMaterialidName() {
			return materialidName;
		}
		public void setMaterialidName(String materialidName) {
			this.materialidName = materialidName;
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
	public List getEditvendorinvoicelinebean() {
			return editvendorinvoicelinebean;
		}
		public void setEditvendorinvoicelinebean(List editvendorinvoicelinebean) {
			this.editvendorinvoicelinebean = editvendorinvoicelinebean;
		}
	public int[] getVendorinvoicelineid() {
			return vendorinvoicelineid;
		}
		public void setVendorinvoicelineid(int[] vendorinvoicelineid) {
			this.vendorinvoicelineid = vendorinvoicelineid;
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
		public int[] getEditvendorinvoicelineid() {
			return editvendorinvoicelineid;
		}
		public void setEditvendorinvoicelineid(int[] editvendorinvoicelineid) {
			this.editvendorinvoicelineid = editvendorinvoicelineid;
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
	public Currency getCurrencybean() {
		return currencybean;
	}
	public void setCurrencybean(Currency currencybean) {
		this.currencybean = currencybean;
	}
	public PurchaseOrder getPurchaseorderbean() {
		return purchaseorderbean;
	}
	public void setPurchaseorderbean(PurchaseOrder purchaseorderbean) {
		this.purchaseorderbean = purchaseorderbean;
	}
	public Organization getOrgbean() {
		return orgbean;
	}
	public void setOrgbean(Organization orgbean) {
		this.orgbean = orgbean;
	}
	public Vendor getVendorbean() {
		return vendorbean;
	}
	public void setVendorbean(Vendor vendorbean) {
		this.vendorbean = vendorbean;
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
	public List<VendorInvoiceLine> getVendorinvoicelinebean() {
		return vendorinvoicelinebean;
	}
	public void setVendorinvoicelinebean(
			List<VendorInvoiceLine> vendorinvoicelinebean) {
		this.vendorinvoicelinebean = vendorinvoicelinebean;
	}
	public int getVendorinvoiceid() {
		return vendorinvoiceid;
	}
	public void setVendorinvoiceid(int vendorinvoiceid) {
		this.vendorinvoiceid = vendorinvoiceid;
	}
	public String getVendorinvoiceno() {
		return vendorinvoiceno;
	}
	public void setVendorinvoiceno(String vendorinvoiceno) {
		this.vendorinvoiceno = vendorinvoiceno;
	}
	public String getVendorinvoicedate() {
		return vendorinvoicedate;
	}
	public void setVendorinvoicedate(String vendorinvoicedate) {
		this.vendorinvoicedate = vendorinvoicedate;
	}
	public String getPostingdate() {
		return postingdate;
	}
	public void setPostingdate(String postingdate) {
		this.postingdate = postingdate;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
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
	public String getPurchaseorderid() {
		return purchaseorderid;
	}
	public void setPurchaseorderid(String purchaseorderid) {
		this.purchaseorderid = purchaseorderid;
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
	public String getVendorid() {
		return vendorid;
	}
	public void setVendorid(String vendorid) {
		this.vendorid = vendorid;
	}
	public int getEditvendorinvoiceid() {
		return editvendorinvoiceid;
	}
	public void setEditvendorinvoiceid(int editvendorinvoiceid) {
		this.editvendorinvoiceid = editvendorinvoiceid;
	}
	public String getEditvendorinvoiceno() {
		return editvendorinvoiceno;
	}
	public void setEditvendorinvoiceno(String editvendorinvoiceno) {
		this.editvendorinvoiceno = editvendorinvoiceno;
	}
	public String getEditvendorinvoicedate() {
		return editvendorinvoicedate;
	}
	public void setEditvendorinvoicedate(String editvendorinvoicedate) {
		this.editvendorinvoicedate = editvendorinvoicedate;
	}
	public String getEditpostingdate() {
		return editpostingdate;
	}
	public void setEditpostingdate(String editpostingdate) {
		this.editpostingdate = editpostingdate;
	}
	
	
	public float getEditamount() {
		return editamount;
	}
	public void setEditamount(float editamount) {
		this.editamount = editamount;
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
	public String getEditpurchaseorderid() {
		return editpurchaseorderid;
	}
	public void setEditpurchaseorderid(String editpurchaseorderid) {
		this.editpurchaseorderid = editpurchaseorderid;
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
	public String getEditvendorid() {
		return editvendorid;
	}
	public void setEditvendorid(String editvendorid) {
		this.editvendorid = editvendorid;
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
	
	
	

}
