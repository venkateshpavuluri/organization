/**
 *  @Copyright MNTSOFT
 */
package com.mnt.erp.bean;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Naresh
 * @version 1.0 02-04-2014
 */

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Order")  // 404
public class CustomGenericException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String errCode;
	private String errMsg;

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public CustomGenericException(String errCode, String errMsg) {
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

}
