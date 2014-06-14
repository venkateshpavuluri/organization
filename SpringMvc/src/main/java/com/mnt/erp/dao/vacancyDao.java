package com.mnt.erp.dao;

import java.util.List;

import com.mnt.erp.bean.Vacancy;
/**
 * @author devi
 *
 */
public interface vacancyDao {
	public String saveVacancy(Object object,String userId,String userName);
	public List<Object[]> searchVacancy();
	public List<Object[]> basicSearchVacancy(String dbField,String operation,String basicSearchId);
	public List<Vacancy> editVacancyDetails(int deliveryNoteId);
	public String updateVacancyDetails(Object object);
	public String deleteChildRecords(Object object);
	public String deleteVacancy(int deliveryId);
	public List<Object[]> setVacancySearch(String name);
		public List<Object[]> getEmployeeMailIds();
		public String saveVacancyVendor(Object object);

		public List<Object[]> getVacancyIds();


}
