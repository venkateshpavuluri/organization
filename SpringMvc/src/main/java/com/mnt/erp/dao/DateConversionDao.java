/**
 * @Copyright MNTSOFT
 */
package com.mnt.erp.dao;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.xml.bind.JAXBException;

import com.mnt.erp.bean.DatePatternsBean;

/**
 * @author Naresh
 * @version 1.0 15-04-2014
 */
public interface DateConversionDao {

	public Date dateParse(String s, String se) throws ParseException,
			IOException;

	public String dateFormat(Date d, String se) throws IOException;

	public DatePatternsBean getDatePattern() throws JAXBException;

	public boolean isThisDateValid(String validateDate) throws ParseException;
			

}
