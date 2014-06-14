/**
 *  @Copyright MNTSOFT
 */
package com.mnt.erp.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;

import com.mnt.erp.bean.DatePatternsBean;
import com.mnt.erp.dao.DateConversionDao;

/**
 * @author Naresh
 * @version 1.0 15-04-2014
 */
public class DateConversionServiceImpl implements DateConversionService {
	@Autowired
	DateConversionDao dateDao;

	public Date dateParse(String s, String se) throws ParseException,
			IOException {
		Date date = null;
		try {
			date = dateDao.dateParse(s, se);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return date;
	}

	public String dateFormat(Date d, String se) throws IOException {
		String string = null;
		try {
			string = dateDao.dateFormat(d, se);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
	}

	@Override
	public DatePatternsBean getDatePattern() throws JAXBException {

		DatePatternsBean bean = dateDao.getDatePattern();
		return bean;
	}

	@Override
	public boolean isThisDateValid(String validateDate) throws ParseException {
		boolean flag = false;
		try {
			flag = dateDao.isThisDateValid(validateDate);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return flag;
	}

}
