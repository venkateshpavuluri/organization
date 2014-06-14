package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.ProfitCenterDao;

public class ProfitCenterServiceImpl implements ProfitCenterService {
	public ProfitCenterDao profitCenterdao;
	public String msg;
	List<Object[]> objects;

	
	/* getter methhods of ProfitCenterDao */
	
	public ProfitCenterDao getprofitCenterdao() {
		return profitCenterdao;
	}
	public String getMsg() {
		return msg;
	}
	
	/* setter methhods of ProfitCenterDao */
	
	public void setprofitCenterdao(ProfitCenterDao profitCenterdao) {
		this.profitCenterdao = profitCenterdao;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String saveProfitCenter(Object object,String userId,String userName){
     try{
		   msg=profitCenterdao.saveProfitCenter(object,userId,userName);
	    }
	 catch(Exception e){
			e.printStackTrace();
		}
	 return msg;

}
	public List<Object[]> searchProfitCenter(int id){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
		   list=profitCenterdao.searchProfitCenter(id);
						
		 }
		catch(Exception e)
		{
		   e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> editProfitCenterWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=profitCenterdao.editProfitCenterWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public String updateProfitCenter(Object object) {
		try
		{
	       msg=profitCenterdao.updateProfitCenter(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String profitCenterDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=profitCenterdao.profitCenterDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int profitCenterDuplicate(String ProfitCenter){
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=profitCenterdao.profitCenterDuplicate(ProfitCenter);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	public int profitCenterEditDuplicate(String ProfitCenter,int id){
		int list1=0;
		try
		{
			list1=profitCenterdao.profitCenterEditDuplicate(ProfitCenter, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchProfitCenter(String label,
			String operator, String searchName) {
		try {
			objects = profitCenterdao.basicSearchProfitCenter(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	
}
