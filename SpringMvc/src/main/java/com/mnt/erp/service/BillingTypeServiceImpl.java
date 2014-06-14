/**
copyright MNTSoft
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.BillingTypeDao;

/**
 * @author A Nikesh
 *@version 1.0 05-11-2013
 *@build 0.0
 *
 */
public class BillingTypeServiceImpl implements BillingTypeService{
	

	BillingTypeDao billTypeDao;
	List<Object[]> objects;
	String msg;

	

	public BillingTypeDao getBillTypeDao() {
		return billTypeDao;
	}
	public void setBillTypeDao(BillingTypeDao billTypeDao) {
		this.billTypeDao = billTypeDao;
	}
	public String saveBillingTypeDetails(Object object)
	{
		try
		{
			
			msg=billTypeDao.saveBillingTypeDetails(object);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateBillingTypeCheck(String billingtype) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=billTypeDao.duplicateBillingTypeCheck(billingtype);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchBillingType() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			objects=billTypeDao.searchBillingType();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchBillingTypeWithName(String billingtypename) {
		List<Object[]> list=null;
		try
		{
			System.out.println("billingtype name in billingtype service billTypeDao impl is   "+billingtypename);
			list=billTypeDao.searchBillingTypeWithName(billingtypename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectBillingTypeNames() {

		 try
		 {
			 objects=billTypeDao.selectBillingTypeNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchBillingTypeWithId(String billingtypename) {
		List<Object[]> list=null;
		try
		{
			list=billTypeDao.searchBillingTypeWithId(billingtypename);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateBillingType(Object object) {
		try
		{
	 msg=billTypeDao.updateBillingType(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String billingtype,int billingtypeid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=billTypeDao.updateDuplicateCheck(billingtype, billingtypeid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String billingtypeDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=billTypeDao.billingtypeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public List<Object[]> basicSearchBillingType(String label,String operator,String searchName){
		try {
			objects = billTypeDao.basicSearchBillingType(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	

}
