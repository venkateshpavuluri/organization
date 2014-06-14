/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.WFProcess;
import com.mnt.erp.dao.WFProcessDao;

/**
 * @author Administrator
 *
 */
public class WFProcessServiceImpl implements WFProcessService{
	WFProcessDao dao;
	List<Object[]> objects;
	String msg;
	
	
	
	public WFProcessDao getDao() {
		return dao;
	}
	public void setDao(WFProcessDao dao) {
		this.dao = dao;
	}
	public String saveWFProcessDetails(Object object,String userId,String userName)
	{
		try
		{
			System.out.println("in save of wfprocess service impl");
			msg=dao.saveWFProcessDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateWFProcessCheck(String wfprocess) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.duplicateWFProcessCheck(wfprocess);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> searchWFProcess() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=dao.searchWFProcess();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	public List<Object[]> basicSearchWFProcess(String label,String operator,String searchName){
		try {
			objects = dao.basicSearchWFProcess(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public List<Object[]> searchWFProcessWithId(String wfprocessname) {
		List<Object[]> list=null;
		try
		{
			list=dao.searchWFProcessWithId(wfprocessname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> searchWFProcessWithName(String wfprocessname) {
		List<Object[]> list=null;
		try
		{
			list=dao.searchWFProcessWithName(wfprocessname);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectWFProcessNames() {

		 try
		 {
			 objects=dao.selectWFProcessNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public String updateWFProcess(Object object) {
		try
		{
	 msg=dao.updateWFProcess(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String wfprocess,String wfprocessid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=dao.updateDuplicateCheck(wfprocess, wfprocessid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String wfprocessDelete(String id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=dao.wfprocessDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
}
