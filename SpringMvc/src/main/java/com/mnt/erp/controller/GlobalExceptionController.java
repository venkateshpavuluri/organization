/**
 *  @Copyright MNTSOFT
 */
package com.mnt.erp.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.mnt.erp.bean.CustomGenericException;

/**
 * @author Naresh
 * @version 1.0 02-04-2014
 */

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(CustomGenericException.class)
	// @ResponseStatus(value=HttpStatus.NOT_FOUND,reason="No such Order")
	public ModelAndView handleException(CustomGenericException ex) {
		ModelAndView model = new ModelAndView("ExceptionsHome");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception e) {

		ModelAndView model = new ModelAndView("ExceptionsHome");
		model.addObject("name", e.getClass().getSimpleName());
		//model.addObject("errMsg", e.getMessage());

		return model;

	}

}
