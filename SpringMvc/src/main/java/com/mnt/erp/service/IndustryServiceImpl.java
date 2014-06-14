package com.mnt.erp.service;

import java.util.List;


import com.mnt.erp.dao.IndustryDao;
/**
 * @author ybusireddy
 * @version 19-09-2013
 */
public class IndustryServiceImpl implements IndustryService {
	IndustryDao dao;
	List<Object[]> list=null;

	
	public IndustryDao getDao() {
		return dao;
	}

	public void setDao(IndustryDao dao) {
		this.dao = dao;
	}

	@Override
	public String saveIndustryDetails(Object object,String userId,String userName) {
		// TODO Auto-generated method stub
		String isa=null;
		try{
			isa=dao.saveIndustryDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return isa;
	}

	@Override
	public List<Object[]> searchIndustry() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dao.searchIndustry();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Object[]> searchIndustryWithId(int id) {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dao.searchIndustryWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return list;
	}

	@Override
	public String updateIndustry(Object object) {
		// TODO Auto-generated method stub
		String s=null;
		try
		{
			s=dao.updateIndustry(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public String deleteIndustry(int id) {
		// TODO Auto-generated method stub
		String is = null;
		try
		{
			is=dao.deleteIndustry(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return is;
	}

	@Override
	public List<Object[]> selectIndustryId() {
		// TODO Auto-generated method stub
		
		try
		{
			list=dao.selectIndustryId();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int checkIndustryType(String type) {
		// TODO Auto-generated method stub
		int i=0;
		try
		{
			i=dao.checkIndustryType(type);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public int updateCheckIndustryType(String indType, int indId){
		int i=0;
		try
		{
			i=dao.updateCheckIndustryType(indType, indId);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return i;
	}
	public List<Object[]> basicSearchIndustryType(String label,String operator,String searchName){
		try
		{
			list=dao.basicSearchIndustryType(label, operator, searchName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
