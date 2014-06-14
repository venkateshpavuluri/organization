/**
 * @Copyright MNTSOFT 
 */
package com.mnt.erp.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Naresh
 * @version 1.0 20-11-2013
 */
public class SalesOrderBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int soId;
	private int editSOId;
	private int salesOrderId;
	private String salesOrderNo;
	private String orderTypeId;
	private String customerId;
	private String salesGroupId;
	private String paymentTermId;
	private String uom;
	private String custPONumber;
	private String salesOrderDate;
	private String custPODate;
	private String reqDeliveryDate;
	private String netWeight;
	private String totalWeight;
	private String totalVolume;
	private String orderReason;
	private String priority;
	private String unloadingPoint;
	private String route;
	private String receivingPoint;
	private String statusId;

	private String xmlLabel;
	private String operations;
	private String basicSearchId;
	private String material_Id;
	private String uom_Id;
	private String currency_Id;
	private String ematerialName;
	private String euomName;
	private String ecurrencyName;
	private String labels;
	private String dbField;
	private String asOpts;
	private String advanceSearchText;
	private int advanceSearchHidden;

	List<SalesOrderLineBean> salesOrderLineBean;
	private CustomerBean custBean;
	private SalesGroup salesGroup;
	private OrderType orderType;
	private PaymentTerms paymentTerm;
	private Uom uomBean;
	private Status status;

	// Child variables
	private int[] salesOrderLineId;
	private String[] materialId;
	private String[] uomId;
	private String[] currencyId;
	private String[] quantity;
	private String[] custMaterailNo;
	private String[] netPrice;
	private String[] uPrice;
	private String[] tax;
	private String[] discount;
	private String[] totalAmt;

	// Child Edit variables
	private int[] esalesOrderLineId;
	private String[] ematerialId;
	private String[] euomId;
	private String[] ecurrencyId;
	private String[] equantity;
	private String[] ecustMaterailNo;
	private String[] enetPrice;	
	private String[] euPrice;
	private String[] etax;
	private String[] ediscount;
	
	/*WorkFlow Properties*/
	private String workFlowListId;
	private String step;
	private String comments;
	private String actionNames;
	/**
	 * @return the actionNames
	 */
	public String getActionNames() {
		return actionNames;
	}

	/**
	 * @param actionNames the actionNames to set
	 */
	public void setActionNames(String actionNames) {
		this.actionNames = actionNames;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * @return the workFlowListId
	 */
	public String getWorkFlowListId() {
		return workFlowListId;
	}

	/**
	 * @param workFlowListId the workFlowListId to set
	 */
	public void setWorkFlowListId(String workFlowListId) {
		this.workFlowListId = workFlowListId;
	}

	/**
	 * @return the step
	 */
	public String getStep() {
		return step;
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(String step) {
		this.step = step;
	}

	public String getLabels() {
		return labels;
	}

	public String getDbField() {
		return dbField;
	}

	public String getAsOpts() {
		return asOpts;
	}

	public String getAdvanceSearchText() {
		return advanceSearchText;
	}

	public int getAdvanceSearchHidden() {
		return advanceSearchHidden;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public void setDbField(String dbField) {
		this.dbField = dbField;
	}

	public void setAsOpts(String asOpts) {
		this.asOpts = asOpts;
	}

	public void setAdvanceSearchText(String advanceSearchText) {
		this.advanceSearchText = advanceSearchText;
	}

	public void setAdvanceSearchHidden(int advanceSearchHidden) {
		this.advanceSearchHidden = advanceSearchHidden;
	}

	private String[] etotalAmt;

	// Edit variables
	private int esalesOrderId;
	private String esalesOrderNo;
	private String eorderTypeId;
	private String ecustomerId;
	private String childUomName;

	private String esalesGroupId;
	private String epaymentTermId;
	private String euom;

	private String ecustPONumber;
	private String esalesOrderDate;
	private String ecustPODate;
	private String ereqDeliveryDate;
	private String enetWeight;
	private String etotalWeight;
	private String etotalVolume;
	private String eorderReason;
	private String epriority;
	private String eunloadingPoint;
	private String eroute;
	private String ereceivingPoint;
	private String ematerial_Id;
	private String euom_Id;
	private String ecurrency_Id;
	private String estatusId;

	// Sub child variables
	private String[] sosUomId;
	private String[] sosQuantity;
	public String[] getTax() {
		return tax;
	}

	public String[] getDiscount() {
		return discount;
	}

	public String[] getTotalAmt() {
		return totalAmt;
	}

	public String[] getEtax() {
		return etax;
	}

	public String[] getEdiscount() {
		return ediscount;
	}

	public String[] getEtotalAmt() {
		return etotalAmt;
	}

	public void setTax(String[] tax) {
		this.tax = tax;
	}

	public void setDiscount(String[] discount) {
		this.discount = discount;
	}

	public void setTotalAmt(String[] totalAmt) {
		this.totalAmt = totalAmt;
	}

	public void setEtax(String[] etax) {
		this.etax = etax;
	}

	public void setEdiscount(String[] ediscount) {
		this.ediscount = ediscount;
	}

	public void setEtotalAmt(String[] etotalAmt) {
		this.etotalAmt = etotalAmt;
	}

	private String[] sosDelDate;
	private String sos_UomId;

	// Sub Edit child variables
	private int[] esalesOrderSchLineId;
	private String[] esosUomId;
	private String[] esosQuantity;
	private String[] esosDelDate;
	private String esos_UomId;

	// Setter And Getter Methods
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public String getStatusId() {
		return statusId;
	}

	public String[] getuPrice() {
		return uPrice;
	}

	public String[] getEuPrice() {
		return euPrice;
	}

	public String getEstatusId() {
		return estatusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public void setuPrice(String[] uPrice) {
		this.uPrice = uPrice;
	}

	public void setEuPrice(String[] euPrice) {
		this.euPrice = euPrice;
	}

	public void setEstatusId(String estatusId) {
		this.estatusId = estatusId;
	}
	public String getChildUomName() {
		return childUomName;
	}

	public void setChildUomName(String childUomName) {
		this.childUomName = childUomName;
	}

	public String getEmaterialName() {
		return ematerialName;
	}

	public void setEmaterialName(String ematerialName) {
		this.ematerialName = ematerialName;
	}

	public String getEuomName() {
		return euomName;
	}

	public void setEuomName(String euomName) {
		this.euomName = euomName;
	}

	public String getEcurrencyName() {
		return ecurrencyName;
	}

	public void setEcurrencyName(String ecurrencyName) {
		this.ecurrencyName = ecurrencyName;
	}

	public int getEditSOId() {
		return editSOId;
	}

	public void setEditSOId(int editSOId) {
		this.editSOId = editSOId;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public int getSoId() {
		return soId;
	}

	public void setSoId(int soId) {
		this.soId = soId;
	}

	public int[] getEsalesOrderLineId() {
		return esalesOrderLineId;
	}

	public void setEsalesOrderLineId(int[] esalesOrderLineId) {
		this.esalesOrderLineId = esalesOrderLineId;
	}

	public String[] getEmaterialId() {
		return ematerialId;
	}

	public void setEmaterialId(String[] ematerialId) {
		this.ematerialId = ematerialId;
	}

	public String[] getEuomId() {
		return euomId;
	}

	public void setEuomId(String[] euomId) {
		this.euomId = euomId;
	}

	public String[] getEcurrencyId() {
		return ecurrencyId;
	}

	public void setEcurrencyId(String[] ecurrencyId) {
		this.ecurrencyId = ecurrencyId;
	}

	public int[] getEsalesOrderSchLineId() {
		return esalesOrderSchLineId;
	}

	public void setEsalesOrderSchLineId(int[] esalesOrderSchLineId) {
		this.esalesOrderSchLineId = esalesOrderSchLineId;
	}

	public String[] getEquantity() {
		return equantity;
	}

	public void setEquantity(String[] equantity) {
		this.equantity = equantity;
	}

	public String[] getSosUomId() {
		return sosUomId;
	}

	public void setSosUomId(String[] sosUomId) {
		this.sosUomId = sosUomId;
	}

	public String[] getEsosUomId() {
		return esosUomId;
	}

	public void setEsosUomId(String[] esosUomId) {
		this.esosUomId = esosUomId;
	}

	public String[] getEsosQuantity() {
		return esosQuantity;
	}

	public void setEsosQuantity(String[] esosQuantity) {
		this.esosQuantity = esosQuantity;
	}

	public String[] getEsosDelDate() {
		return esosDelDate;
	}

	public void setEsosDelDate(String[] esosDelDate) {
		this.esosDelDate = esosDelDate;
	}

	public String getEsos_UomId() {
		return esos_UomId;
	}

	public void setEsos_UomId(String esos_UomId) {
		this.esos_UomId = esos_UomId;
	}

	public String[] getSosQuantity() {
		return sosQuantity;
	}

	public String getSos_UomId() {
		return sos_UomId;
	}

	public void setSos_UomId(String sos_UomId) {
		this.sos_UomId = sos_UomId;
	}

	public void setSosQuantity(String[] sosQuantity) {
		this.sosQuantity = sosQuantity;
	}

	public String[] getSosDelDate() {
		return sosDelDate;
	}

	public void setSosDelDate(String[] sosDelDate) {
		this.sosDelDate = sosDelDate;
	}

	public String[] getEcustMaterailNo() {
		return ecustMaterailNo;
	}

	public void setEcustMaterailNo(String[] ecustMaterailNo) {
		this.ecustMaterailNo = ecustMaterailNo;
	}

	public String[] getEnetPrice() {
		return enetPrice;
	}

	public void setEnetPrice(String[] enetPrice) {
		this.enetPrice = enetPrice;
	}

	public int getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getOrderTypeId() {
		return orderTypeId;
	}

	public void setOrderTypeId(String orderTypeId) {
		this.orderTypeId = orderTypeId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustPONumber() {
		return custPONumber;
	}

	public String getMaterial_Id() {
		return material_Id;
	}

	public void setMaterial_Id(String material_Id) {
		this.material_Id = material_Id;
	}

	public String getUom_Id() {
		return uom_Id;
	}

	public void setUom_Id(String uom_Id) {
		this.uom_Id = uom_Id;
	}

	public String getCurrency_Id() {
		return currency_Id;
	}

	public void setCurrency_Id(String currency_Id) {
		this.currency_Id = currency_Id;
	}

	public void setCustPONumber(String custPONumber) {
		this.custPONumber = custPONumber;
	}

	public String getSalesOrderDate() {
		return salesOrderDate;
	}

	public void setSalesOrderDate(String salesOrderDate) {
		this.salesOrderDate = salesOrderDate;
	}

	public String getCustPODate() {
		return custPODate;
	}

	public void setCustPODate(String custPODate) {
		this.custPODate = custPODate;
	}

	public String getReqDeliveryDate() {
		return reqDeliveryDate;
	}

	public Uom getUomBean() {
		return uomBean;
	}

	public int getEsalesOrderId() {
		return esalesOrderId;
	}

	public void setEsalesOrderId(int esalesOrderId) {
		this.esalesOrderId = esalesOrderId;
	}

	public String getEsalesOrderNo() {
		return esalesOrderNo;
	}

	public void setEsalesOrderNo(String esalesOrderNo) {
		this.esalesOrderNo = esalesOrderNo;
	}

	public String getEorderTypeId() {
		return eorderTypeId;
	}

	public void setEorderTypeId(String eorderTypeId) {
		this.eorderTypeId = eorderTypeId;
	}

	public String getEcustomerId() {
		return ecustomerId;
	}

	public void setEcustomerId(String ecustomerId) {
		this.ecustomerId = ecustomerId;
	}

	public String getEsalesGroupId() {
		return esalesGroupId;
	}

	public void setEsalesGroupId(String esalesGroupId) {
		this.esalesGroupId = esalesGroupId;
	}

	public String getEpaymentTermId() {
		return epaymentTermId;
	}

	public void setEpaymentTermId(String epaymentTermId) {
		this.epaymentTermId = epaymentTermId;
	}

	public String getEuom() {
		return euom;
	}

	public void setEuom(String euom) {
		this.euom = euom;
	}

	public String getEcustPONumber() {
		return ecustPONumber;
	}

	public void setEcustPONumber(String ecustPONumber) {
		this.ecustPONumber = ecustPONumber;
	}

	public String getEsalesOrderDate() {
		return esalesOrderDate;
	}

	public void setEsalesOrderDate(String esalesOrderDate) {
		this.esalesOrderDate = esalesOrderDate;
	}

	public String getEcustPODate() {
		return ecustPODate;
	}

	public void setEcustPODate(String ecustPODate) {
		this.ecustPODate = ecustPODate;
	}

	public String getEreqDeliveryDate() {
		return ereqDeliveryDate;
	}

	public void setEreqDeliveryDate(String ereqDeliveryDate) {
		this.ereqDeliveryDate = ereqDeliveryDate;
	}

	public String getEnetWeight() {
		return enetWeight;
	}

	public void setEnetWeight(String enetWeight) {
		this.enetWeight = enetWeight;
	}

	public String getEtotalWeight() {
		return etotalWeight;
	}

	public void setEtotalWeight(String etotalWeight) {
		this.etotalWeight = etotalWeight;
	}

	public String getEtotalVolume() {
		return etotalVolume;
	}

	public void setEtotalVolume(String etotalVolume) {
		this.etotalVolume = etotalVolume;
	}

	public String getEorderReason() {
		return eorderReason;
	}

	public void setEorderReason(String eorderReason) {
		this.eorderReason = eorderReason;
	}

	public String getEpriority() {
		return epriority;
	}

	public void setEpriority(String epriority) {
		this.epriority = epriority;
	}

	public String getEunloadingPoint() {
		return eunloadingPoint;
	}

	public void setEunloadingPoint(String eunloadingPoint) {
		this.eunloadingPoint = eunloadingPoint;
	}

	public String getEroute() {
		return eroute;
	}

	public void setEroute(String eroute) {
		this.eroute = eroute;
	}

	public String getEreceivingPoint() {
		return ereceivingPoint;
	}

	public void setEreceivingPoint(String ereceivingPoint) {
		this.ereceivingPoint = ereceivingPoint;
	}

	public String getEmaterial_Id() {
		return ematerial_Id;
	}

	public void setEmaterial_Id(String ematerial_Id) {
		this.ematerial_Id = ematerial_Id;
	}

	public String getEuom_Id() {
		return euom_Id;
	}

	public void setEuom_Id(String euom_Id) {
		this.euom_Id = euom_Id;
	}

	public String getEcurrency_Id() {
		return ecurrency_Id;
	}

	public void setEcurrency_Id(String ecurrency_Id) {
		this.ecurrency_Id = ecurrency_Id;
	}

	public void setUomBean(Uom uomBean) {
		this.uomBean = uomBean;
	}

	public void setReqDeliveryDate(String reqDeliveryDate) {
		this.reqDeliveryDate = reqDeliveryDate;
	}

	public String getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}

	public String getTotalWeight() {
		return totalWeight;
	}

	public void setTotalWeight(String totalWeight) {
		this.totalWeight = totalWeight;
	}

	public String getTotalVolume() {
		return totalVolume;
	}

	public List<SalesOrderLineBean> getSalesOrderLineBean() {
		return salesOrderLineBean;
	}

	public void setSalesOrderLineBean(
			List<SalesOrderLineBean> salesOrderLineBean) {
		this.salesOrderLineBean = salesOrderLineBean;
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

	public int[] getSalesOrderLineId() {
		return salesOrderLineId;
	}

	public void setSalesOrderLineId(int[] salesOrderLineId) {
		this.salesOrderLineId = salesOrderLineId;
	}

	public String[] getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String[] materialId) {
		this.materialId = materialId;
	}

	public String[] getUomId() {
		return uomId;
	}

	public void setUomId(String[] uomId) {
		this.uomId = uomId;
	}

	public String[] getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(String[] currencyId) {
		this.currencyId = currencyId;
	}

	public String[] getQuantity() {
		return quantity;
	}

	public void setQuantity(String[] quantity) {
		this.quantity = quantity;
	}

	public String[] getCustMaterailNo() {
		return custMaterailNo;
	}

	public void setCustMaterailNo(String[] custMaterailNo) {
		this.custMaterailNo = custMaterailNo;
	}

	public String[] getNetPrice() {
		return netPrice;
	}

	public void setNetPrice(String[] netPrice) {
		this.netPrice = netPrice;
	}

	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
	}

	public String getPaymentTermId() {
		return paymentTermId;
	}

	public void setPaymentTermId(String paymentTermId) {
		this.paymentTermId = paymentTermId;
	}

	public String getSalesGroupId() {
		return salesGroupId;
	}

	public void setSalesGroupId(String salesGroupId) {
		this.salesGroupId = salesGroupId;
	}

	public CustomerBean getCustBean() {
		return custBean;
	}

	public void setCustBean(CustomerBean custBean) {
		this.custBean = custBean;
	}

	public SalesGroup getSalesGroup() {
		return salesGroup;
	}

	public void setSalesGroup(SalesGroup salesGroup) {
		this.salesGroup = salesGroup;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public PaymentTerms getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(PaymentTerms paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getOrderReason() {
		return orderReason;
	}

	public void setOrderReason(String orderReason) {
		this.orderReason = orderReason;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getUnloadingPoint() {
		return unloadingPoint;
	}

	public void setUnloadingPoint(String unloadingPoint) {
		this.unloadingPoint = unloadingPoint;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getReceivingPoint() {
		return receivingPoint;
	}

	public void setReceivingPoint(String receivingPoint) {
		this.receivingPoint = receivingPoint;
	}

	public String getSalesOrderNo() {
		return salesOrderNo;
	}

	public void setSalesOrderNo(String salesOrderNo) {
		this.salesOrderNo = salesOrderNo;
	}

}
