/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.TrainingSchedule;
import com.mnt.erp.bean.Vacancy;

/**
 * @author devi
 *
 */
public interface trainingScheduleDao {
	public String saveTrainingSchedule(Object object,String userId,String userName);
	public List<Object[]> searchTrainingSchedule();
	public List<Object[]> basicSearchTrainingSchedule(String dbField,String operation,String basicSearchId);
	public List<TrainingSchedule> editTrainingScheduleDetails(int tScheduleId);
	public String updateTrainingScheduleDetails(Object object);
	public String deleteChildRecords(Object object);
	public String deleteTrainingSchedule(int tScheduleId);
	public List<Object[]> setTrainingScheduleSearch(String name);
	public List<Object[]> getTrainingCategoryIds();
	public List<Object[]> getOrganizationIds();
	public List<Object[]> getEmployeeIds();
}
