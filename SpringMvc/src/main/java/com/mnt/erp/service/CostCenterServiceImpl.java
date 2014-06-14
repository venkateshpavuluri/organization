package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.CostCenterDao;

public class CostCenterServiceImpl implements CostCenterService{
	public CostCenterDao costCenterDao;
	public String msg;
	List<Object[]> objects;

	
	/* getter methhods of CostCenterDao */
	
	public CostCenterDao getcostCenterDao() {
		return costCenterDao;
	}
	public String getMsg() {
		return msg;
	}
	
	/* setter methhods of CostCenterDao */
	
	public void setcostCenterDao(CostCenterDao costCenterDao) {
		this.costCenterDao = costCenterDao;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String saveCostCenter(Object object,String userId,String userName){
     try{
		   msg=costCenterDao.saveCostCenter(object,userId,userName);
	    }
	 catch(Exception e){
			e.printStackTrace();
		}
	 return msg;

}
	public List<Object[]> searchCostCenter(int id){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
		   list=costCenterDao.searchCostCenter(id);
						
		 }
		catch(Exception e)
		{
		   e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> editCostCenterWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=costCenterDao.editCostCenterWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public String updateCostCenter(Object object) {
		try
		{
	       msg=costCenterDao.updateCostCenter(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String costCenterDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=costCenterDao.costCenterDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int costCenterDuplicate(String CostCenter){
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=costCenterDao.costCenterDuplicate(CostCenter);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	public int costCenterEditDuplicate(String CostCenter,int id){
		int list1=0;
		try
		{
			list1=costCenterDao.costCenterEditDuplicate(CostCenter, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchCostCenter(String label,
			String operator, String searchName) {
		try {
			objects = costCenterDao.basicSearchCostCenter(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	
}
