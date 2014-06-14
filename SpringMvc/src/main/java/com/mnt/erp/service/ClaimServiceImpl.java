/**
 * 
 */
package com.mnt.erp.service;


import java.util.List;
import com.mnt.erp.bean.ClaimBean;
import com.mnt.erp.dao.ClaimDao;


/**
 * @author devi
 *
 */
public class ClaimServiceImpl implements ClaimService{
	
	String msg=null;
	List<Object[]> list=null;

	ClaimDao clDao;
		
	public ClaimDao getClDao() {
		return clDao;
	}
	public void setClDao(ClaimDao clDao) {
		this.clDao = clDao;
	}
	@Override
	public String saveClaim(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		try
		{
			msg=clDao.saveClaim(object, userId, userName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	 public List<Object[]> getClaimTypeIds(){
			// TODO Auto-generated method stub
				List<Object[]> list=null;
				try
				{
				 list = clDao.getClaimTypeIds();
				}
				catch(Exception e)
				{
					
				}
				return list; 
		 }
	 public List<Object[]> getEmployeeIds(){
			// TODO Auto-generated method stub
				List<Object[]> list=null;
				try
				{
				 list = clDao.getEmployeeIds();
				}
				catch(Exception e)
				{
					
				}
				return list; 
		 }
	 public List<Object[]> getStatusIds(){
			// TODO Auto-generated method stub
				List<Object[]> list=null;
				try
				{
				 list = clDao.getStatusIds();
				}
				catch(Exception e)
				{
					
				}
				return list; 
		 }
	 @Override
		public List<Object[]> searchClaim() {
			// TODO Auto-generated method stub
			try
			{
				list=clDao.searchClaim();
				
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return list;
		}
		@Override
		public List<Object[]> basicSearchClaim(String dbField,
				String operation, String basicSearchId) {
			// TODO Auto-generated method stub
			try
			{
				
				list=clDao.basicSearchClaim(dbField, operation, basicSearchId);
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return list;
		}

		@Override
		public String deleteChildRecords(Object object) {
			// TODO Auto-generated method stub
			try
			{
				msg=clDao.deleteChildRecords(object);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public String deleteClaim(int claimId) {
			// TODO Auto-generated method stub
			try
			{
				msg=clDao.deleteClaim(claimId);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return msg;
		}
		@Override
		public List<ClaimBean> editClaimDetails(int claimId) {
			// TODO Auto-generated method stub
			
			List<ClaimBean> task=null;
			try
			{
				task=clDao.editClaimDetails(claimId);
				
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return task;
		}

		@Override
		public String updateClaimDetails(Object object) {
			// TODO Auto-generated method stub
			try
			{
				msg=clDao.updateClaimDetails(object);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return msg;
		}



}
