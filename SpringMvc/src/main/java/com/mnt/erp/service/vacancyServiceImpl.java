/**
 * 
 */
package com.mnt.erp.service;

import java.util.Iterator;
import java.util.List;

import com.mnt.erp.bean.DeliveryNote;
import com.mnt.erp.bean.Vacancy;
import com.mnt.erp.dao.DeliveryNoteDao;
import com.mnt.erp.dao.vacancyDao;

/**
 * @author devi
 *
 */
public class vacancyServiceImpl implements vacancyService{
	String msg=null;
	List<Object[]> list=null;
		
		vacancyDao vacancyDao;
		
		
		public vacancyDao getVacancyDao() {
			return vacancyDao;
		}

		public void setVacancyDao(vacancyDao vacancyDao) {
			this.vacancyDao = vacancyDao;
		}

		@Override
		public String saveVacancy(Object object,String userId,String userName) {
			// TODO Auto-generated method stub
			try
			{
				msg=vacancyDao.saveVacancy(object,userId,userName);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return msg;
		}

		@Override
		public List<Object[]> searchVacancy() {
			// TODO Auto-generated method stub
			try
			{
				
				list=vacancyDao.searchVacancy();
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}

		@Override
		public List<Object[]> basicSearchVacancy(String dbField,
				String operation, String basicSearchId) {
			// TODO Auto-generated method stub
			try
			{
				
				
				list=vacancyDao.basicSearchVacancy(dbField, operation, basicSearchId);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return list;
		}

		@Override
		public List<Vacancy> editVacancyDetails(int deliveryNoteId) {
			// TODO Auto-generated method stub
			Iterator<Object[]> iterator=null;
			List<Vacancy> vacancy=null;
			try
			{
				vacancy=vacancyDao.editVacancyDetails(deliveryNoteId);
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return vacancy;
		}

		@Override
		public String updateVacancyDetails(Object object) {
			// TODO Auto-generated method stub
			try
			{
				msg=vacancyDao.updateVacancyDetails(object);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return msg;
		}

		@Override
		public String deleteChildRecords(Object object) {
			// TODO Auto-generated method stub
			try
			{
				msg=vacancyDao.deleteChildRecords(object);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public String deleteVacancy(int deliveryId) {
			// TODO Auto-generated method stub
			try
			{
				msg=vacancyDao.deleteVacancy(deliveryId);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return msg;
		}

		
		@Override
		public List<Object[]> getVacancy(String delivery) {
			// TODO Auto-generated method stub
			List<Object[]> list=null;
			try
			{
			 list = vacancyDao.setVacancySearch(delivery);
			}
			catch(Exception e)
			{
				
			}
			return list;
		}
		 public List<Object[]> getEmployeeMailIds(){
			// TODO Auto-generated method stub
				List<Object[]> list=null;
				try
				{
				 list = vacancyDao.getEmployeeMailIds();
				}
				catch(Exception e)
				{
					
				}
				return list; 
		 }
		 public String saveVacancyVendor(Object object){
			 try
				{
					msg=vacancyDao.saveVacancyVendor(object);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return msg; 
		 }
}
