/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import java.io.Serializable;

/**
 * @author Naresh
 * @version 1.0 05-02-2014
 */
public class InspOperationStep implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int inspOperStepId;
	private String inspoperationId;
	private String inspOperStepNo;
	private String noOfSamples;

	// Setter And Getter Methods

	public int getInspOperStepId() {
		return inspOperStepId;
	}

	public String getInspoperationId() {
		return inspoperationId;
	}

	

	public String getNoOfSamples() {
		return noOfSamples;
	}

	public void setInspOperStepId(int inspOperStepId) {
		this.inspOperStepId = inspOperStepId;
	}

	public void setInspoperationId(String inspoperationId) {
		this.inspoperationId = inspoperationId;
	}

	

	public String getInspOperStepNo() {
		return inspOperStepNo;
	}

	public void setInspOperStepNo(String inspOperStepNo) {
		this.inspOperStepNo = inspOperStepNo;
	}

	public void setNoOfSamples(String noOfSamples) {
		this.noOfSamples = noOfSamples;
	}

}
