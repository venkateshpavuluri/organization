/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author anikesh
 *
 */
public class Route {
	private int routeId;
	private String routeCode;
	private String organizationId;
	private int orgIdInt;
	private String organizationName;
	private String fromPlace;
	private String toPlace;
	private String distance;
	private int distInt;
	private String uomId;
	private int uomInt;
	private String uomName;
	private String approxTime;
	private int approxInt;
	private String timeUomId;
	private int timeUomInt;
	private String timeUomName;
	private int aid;
	private Organization organizationBean;
	private Uom uomBean;
	private Uom timeuomBean;

	private int routeIdEdit;
	private String routeCodeEdit;
	private String organizationIdEdit;

	private String fromPlaceEdit;
	private String toPlaceEdit;
	private String distanceEdit;
	private String uomIdEdit;
	
	private String approxTimeEdit;
	private String timeUomIdEdit;
	
	
	private String operations;
	private String basicSearchId;
	private String xmlLabel;
	
	
	//-------------------- advance search ----------
		private String firstLabel;
		private String secondLabel;
		private String operations1;
		private String advanceSearchText;
		private int advanceSearchHidden;
	
	
	
		
		
	
		
	public int getRouteId() {
			return routeId;
		}
		public void setRouteId(int routeId) {
			this.routeId = routeId;
		}
		public String getRouteCode() {
			return routeCode;
		}
		public void setRouteCode(String routeCode) {
			this.routeCode = routeCode;
		}
		public String getOrganizationId() {
			return organizationId;
		}
		public void setOrganizationId(String organizationId) {
			this.organizationId = organizationId;
		}
		public String getOrganizationName() {
			return organizationName;
		}
		public void setOrganizationName(String organizationName) {
			this.organizationName = organizationName;
		}
		public String getFromPlace() {
			return fromPlace;
		}
		public void setFromPlace(String fromPlace) {
			this.fromPlace = fromPlace;
		}
		public String getToPlace() {
			return toPlace;
		}
		public void setToPlace(String toPlace) {
			this.toPlace = toPlace;
		}
		public String getDistance() {
			return distance;
		}
		public void setDistance(String distance) {
			this.distance = distance;
		}
		public String getUomId() {
			return uomId;
		}
		public void setUomId(String uomId) {
			this.uomId = uomId;
		}
		public String getUomName() {
			return uomName;
		}
		public void setUomName(String uomName) {
			this.uomName = uomName;
		}
		public String getApproxTime() {
			return approxTime;
		}
		public void setApproxTime(String approxTime) {
			this.approxTime = approxTime;
		}
		public String getTimeUomId() {
			return timeUomId;
		}
		public void setTimeUomId(String timeUomId) {
			this.timeUomId = timeUomId;
		}
		public String getTimeUomName() {
			return timeUomName;
		}
		public void setTimeUomName(String timeUomName) {
			this.timeUomName = timeUomName;
		}
		public int getAid() {
			return aid;
		}
		public void setAid(int aid) {
			this.aid = aid;
		}
		public Organization getOrganizationBean() {
			return organizationBean;
		}
		public void setOrganizationBean(Organization organizationBean) {
			this.organizationBean = organizationBean;
		}
		public Uom getUomBean() {
			return uomBean;
		}
		public void setUomBean(Uom uomBean) {
			this.uomBean = uomBean;
		}
		public int getRouteIdEdit() {
			return routeIdEdit;
		}
		public void setRouteIdEdit(int routeIdEdit) {
			this.routeIdEdit = routeIdEdit;
		}
		public String getRouteCodeEdit() {
			return routeCodeEdit;
		}
		public void setRouteCodeEdit(String routeCodeEdit) {
			this.routeCodeEdit = routeCodeEdit;
		}
		public String getOrganizationIdEdit() {
			return organizationIdEdit;
		}
		public void setOrganizationIdEdit(String organizationIdEdit) {
			this.organizationIdEdit = organizationIdEdit;
		}
		public String getFromPlaceEdit() {
			return fromPlaceEdit;
		}
		public void setFromPlaceEdit(String fromPlaceEdit) {
			this.fromPlaceEdit = fromPlaceEdit;
		}
		public String getToPlaceEdit() {
			return toPlaceEdit;
		}
		public void setToPlaceEdit(String toPlaceEdit) {
			this.toPlaceEdit = toPlaceEdit;
		}
		public String getDistanceEdit() {
			return distanceEdit;
		}
		public void setDistanceEdit(String distanceEdit) {
			this.distanceEdit = distanceEdit;
		}
		public String getUomIdEdit() {
			return uomIdEdit;
		}
		public void setUomIdEdit(String uomIdEdit) {
			this.uomIdEdit = uomIdEdit;
		}
		public String getApproxTimeEdit() {
			return approxTimeEdit;
		}
		public void setApproxTimeEdit(String approxTimeEdit) {
			this.approxTimeEdit = approxTimeEdit;
		}
		public String getTimeUomIdEdit() {
			return timeUomIdEdit;
		}
		public void setTimeUomIdEdit(String timeUomIdEdit) {
			this.timeUomIdEdit = timeUomIdEdit;
		}
		
		
		
		
		public Uom getTimeuomBean() {
			return timeuomBean;
		}
		public void setTimeuomBean(Uom timeuomBean) {
			this.timeuomBean = timeuomBean;
		}
		public int getOrgIdInt() {
			return orgIdInt;
		}
		public void setOrgIdInt(int orgIdInt) {
			this.orgIdInt = orgIdInt;
		}
		public int getDistInt() {
			return distInt;
		}
		public void setDistInt(int distInt) {
			this.distInt = distInt;
		}
		public int getUomInt() {
			return uomInt;
		}
		public void setUomInt(int uomInt) {
			this.uomInt = uomInt;
		}
		public int getApproxInt() {
			return approxInt;
		}
		public void setApproxInt(int approxInt) {
			this.approxInt = approxInt;
		}
		public int getTimeUomInt() {
			return timeUomInt;
		}
		public void setTimeUomInt(int timeUomInt) {
			this.timeUomInt = timeUomInt;
		}
	//=================search methods====================
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
	public String getXmlLabel() {
		return xmlLabel;
	}
	public void setXmlLabel(String xmlLabel) {
		this.xmlLabel = xmlLabel;
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
