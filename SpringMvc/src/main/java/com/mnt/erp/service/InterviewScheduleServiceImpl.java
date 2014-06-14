/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.InterViewSchedule;
import com.mnt.erp.dao.InterviewScheduleDao;

/**
 * @author venkateshp
 *
 */
public class InterviewScheduleServiceImpl implements InterviewScheduleService {
private static Logger logger=Logger.getLogger(InterviewScheduleServiceImpl.class);
	InterviewScheduleDao dao;
	List<Object[]> listObjects;
	String msg=null;
/**
 * @return the dao
 */
public InterviewScheduleDao getDao() {
	return dao;
}

/**
 * @param dao the dao to set
 */
public void setDao(InterviewScheduleDao dao) {
	this.dao = dao;
}

@Override
public List<Object[]> searchIVSchedule() {
	// TODO Auto-generated method stub
	try
	{
		listObjects=dao.searchIVSchedule();		
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
	}
	return listObjects;
}

@Override
public List<Object[]> basicSearchIVSchedule(String dbField, String operation,
		String basicSearchId) {
	// TODO Auto-generated method stub
	try
	{
		listObjects=dao.basicSearchIVSchedule(dbField, operation, basicSearchId);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
	}
	return listObjects;
}

@Override
public List<InterViewSchedule> editIVScheduleDetails(int sheduleId) {
	// TODO Auto-generated method stub
	 List<InterViewSchedule> interViewSchedules=null;
	try
	{
		interViewSchedules=dao.editIVScheduleDetails(sheduleId);	
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
	}
	return interViewSchedules;
}

@Override
public String updateIVScheduleDetails(Object object) {
	String msg=null;
	try
	{
		msg=dao.updateIVScheduleDetails(object);
	}
	catch(Exception e)
	{
		
	}
	// TODO Auto-generated method stub
	return msg;
}

@Override
public String deleteChildRecords(Object object) {
	// TODO Auto-generated method stub

	try
	{
		msg=dao.deleteChildRecords(object);
		
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
	}
	return msg;
}

@Override
public String deleteIVSchedule(int deliveryId) {
	// TODO Auto-generated method stub
	try
	{
	msg=dao.deleteIVSchedule(deliveryId);
	}
	catch(Exception e)
	{
		logger.error(e.getMessage());
	}
	return msg;
}

@Override
public List<Object[]> iVScheduleAdvance(String columns, String operations,
		String advanceSearchText) {
	// TODO Auto-generated method stub
	List<Object[]> list=null;
	try
	{
	String column[]=columns.split(",");
	String op[]=operations.split(",");
	String advanceSearch[]=advanceSearchText.split(",");
	String finalStringForSearch="";
	
	
	for(int i=0;i<advanceSearch.length;i++){
		if(!op[i].equals("0") && advanceSearch[i]!="")
		{
		if (op[i].equals("_%")) {
			column[i]=column[i];
			op[i]=" like ";
			advanceSearch[i] =advanceSearch[i] +"%";
			

		} else if (op[i].equals("%_")) {
			column[i]=column[i];
			op[i]=" like ";
			advanceSearch[i] ="%" + advanceSearch[i];

		} else if (op[i].equals("%_%")) {
			column[i]=column[i];
			op[i]=" like ";
			advanceSearch[i] ="%"  + advanceSearch[i] + "%" ;

		} else if (op[i].equals("=")) {
			column[i]=column[i];
			op[i]=" = ";
			advanceSearch[i] =advanceSearch[i]  ;

		} else if (op[i].equals("!=")) {
			column[i]=column[i];
			op[i]=" != ";
			advanceSearch[i] =advanceSearch[i]  ;

		}
		if(!op[i].equals("0") && advanceSearch[i]!="")
		{
		//finalStringForSearch=finalStringForSearch+" "+column[i]+""+op[i]+""+advanceSearch[i]+""+"AND";
		finalStringForSearch=finalStringForSearch+"  i."+column[i]+""+op[i]+""+advanceSearch[i]+"" +" AND";
		}
		}
	
		
		
		
	}
	//System.out.println("String Value Kiran" +finalStringForSearch);

	
	
	logger.info("with in service operations are=="+columns+operations+advanceSearchText);
	if(finalStringForSearch.length()>3)
	{
	 list =dao.iVScheduleAdvance(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
	}
	else
	{
		list = dao.iVSheduleSearch("ALL");
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;

}


public List<Object[]> getIVShedule(String delivery) {
	// TODO Auto-generated method stub
	List<Object[]> list=null;
	try
	{
	 list = dao.iVSheduleSearch(delivery);
	}
	catch(Exception e)
	{
		
	}
	return list;
}


}
