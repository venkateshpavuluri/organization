/**
 * 
 */
package com.mnt.erp.bean;

/**
 * @author yogi
 * 
 */
public class MediaTypeBean {
    private int mediaTypeId;
    private String mediaType;
    private int aid;
    private String xmlLabel;
    private String operations;
    private String basicSearchId;
    private String mediaTypeEdit;

    public String getMediaTypeEdit() {
	return mediaTypeEdit;
    }

    public void setMediaTypeEdit(String mediaTypeEdit) {
	this.mediaTypeEdit = mediaTypeEdit;
    }

    public int getAid() {
	return aid;
    }

    public void setAid(int aid) {
	this.aid = aid;
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

    public int getMediaTypeId() {
	return mediaTypeId;
    }

    public void setMediaTypeId(int mediaTypeId) {
	this.mediaTypeId = mediaTypeId;
    }

    public String getMediaType() {
	return mediaType;
    }

    public void setMediaType(String mediaType) {
	this.mediaType = mediaType;
    }

}
