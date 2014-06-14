/**
 * 
 */
package com.mnt.erp.bean;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author devi
 *
 */
public class ClaimDocumentsBean {
	private int claimDocId;
	private int claimId;
	private String documentPath;
	private MultipartFile imageFile;
	
	
	
	public int getClaimDocId() {
		return claimDocId;
	}
	public void setClaimDocId(int claimDocId) {
		this.claimDocId = claimDocId;
	}
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public String getDocumentPath() {
		return documentPath;
	}
	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
	public MultipartFile getImageFile() {
		return imageFile;
	}
	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}
	
	
	

}
