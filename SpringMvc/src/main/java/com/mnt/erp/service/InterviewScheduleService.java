/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.InterViewSchedule;

/**
 * @author venkateshp
 *
 */
public interface InterviewScheduleService {
	public List<Object[]> searchIVSchedule();
	public List<Object[]> basicSearchIVSchedule(String dbField,String operation,String basicSearchId);
	public List<InterViewSchedule> editIVScheduleDetails(int sheduleId);
	public String updateIVScheduleDetails(Object object);
	public String deleteChildRecords(Object object);
	public String deleteIVSchedule(int deliveryId);
	public List<Object[]> iVScheduleAdvance(String columns,String operations,String advanceSearchText);
	public List<Object[]> getIVShedule(String delivery);

}
