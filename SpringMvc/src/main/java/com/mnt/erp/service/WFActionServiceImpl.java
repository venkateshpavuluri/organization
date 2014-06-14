/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.WFAction;
import com.mnt.erp.dao.WFActionDao;

/**
 * @author A Nikesh
 *
 */
public class WFActionServiceImpl implements WFActionService{

	WFActionDao dao;
	List<Object[]> objects;
	String msg;
	public WFActionDao getDao() {
		return dao;
	}

	public void setDao(WFActionDao dao) {
		this.dao = dao;
	}
	public String saveWFActionDetails(Object object,String userId,String userName)
	{
		try
		{
			
			msg=dao.saveWFActionDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateWFActionCheck(String wfaction,String wstep) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.duplicateWFActionCheck(wfaction,wstep);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> selectStepIds() {

		 try
		 {
			 objects=dao.selectStepIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	public List<Object[]> selectActionIds(){
		 try
		 {
			 objects=dao.selectActionIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchWFAction() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dao.searchWFAction();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchWFAction(String label,String operator,String searchName){
		try {
			objects = dao.basicSearchWFAction(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchWFActionWithName(String wfactionname) {
		List<Object[]> list=null;
		try
		{
			System.out.println("wfaction name in wfaction service dao impl is   "+wfactionname);
			list=dao.searchWFActionWithName(wfactionname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectWFActionNames() {

		 try
		 {
			 objects=dao.selectWFActionNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchWFActionWithId(String wfactionname) {
		List<Object[]> list=null;
		try
		{
			list=dao.searchWFActionWithId(wfactionname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateWFAction(Object object) {
		try
		{
	 msg=dao.updateWFAction(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String wfaction,String wstep,String wfactionid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.updateDuplicateCheck(wfaction,wstep, wfactionid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String wfactionDelete(String id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.wfactionDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	
	public List<Object[]> getWFActionAdvance(String columns,String opeator,String advanceSearchText) {
		String column[]=columns.split(",");
		String op[]=opeator.split(",");
		String advanceSearch[]=advanceSearchText.split(",");
		String finalStringForSearch="";
		
		for(int i=0;i<advanceSearch.length;i++){
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			if (op[i].equals("_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = advanceSearch[i] +"%";
				

			} else if (op[i].equals("%_")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = "%" + advanceSearch[i];

			} else if (op[i].equals("%_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] =  "%"  + advanceSearch[i] + "%" ;

			} else if (op[i].equals("=")) {
				column[i]=column[i];
				op[i]=" = ";
				advanceSearch[i] =   advanceSearch[i]  ;

			} else if (op[i].equals("!=")) {
				column[i]=column[i];
				op[i]=" != ";
				advanceSearch[i] =   advanceSearch[i]  ;

			}
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			finalStringForSearch=finalStringForSearch+"  "+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
			
			
			
		}
		//System.out.println("String Value Kiran" +finalStringForSearch);
		List<Object[]> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = dao.setWFActionAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = dao.searchWFAction();
		}
		return list;
	}
}
