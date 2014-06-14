/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.InterViewSchedule;

/**
 * @author venkateshp
 *
 */
public interface InterviewScheduleDao {
	
	public List<Object[]> searchIVSchedule();
	public List<Object[]> basicSearchIVSchedule(String dbField,String operation,String basicSearchId);
	public List<InterViewSchedule> editIVScheduleDetails(int deliveryNoteId);
	public String updateIVScheduleDetails(Object object);
	public String deleteChildRecords(Object object);
	public String deleteIVSchedule(int deliveryId);
	public List<Object[]> iVScheduleAdvance(String query);
	public List<Object[]> iVSheduleSearch(String name);


}
