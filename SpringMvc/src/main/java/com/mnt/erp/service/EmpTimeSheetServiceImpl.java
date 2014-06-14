package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.EmpTimeSheetDao;

/**
 * @author devi
 *
 */
public class EmpTimeSheetServiceImpl implements EmpTimeSheetService{
	String brmessage;
	List<Object[]> objects;
	
	EmpTimeSheetDao etsDao;

	public EmpTimeSheetDao getEtsDao() {
		return etsDao;
	}

	public void setEtsDao(EmpTimeSheetDao etsDao) {
		this.etsDao = etsDao;
	}
	

	
	public String saveEmpTimeSheet(Object breakTimeobject,String userId,String userName) {
		try{
			brmessage=etsDao.saveEmpTimeSheet(breakTimeobject, userId, userName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return brmessage;
	}


	public List<Object[]> selectEmpTimeSheet() {
		try{
			objects=etsDao.selectEmpTimeSheet();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}
	
	
	public List<Object[]> searchEmpTimeSheetWithId(int id) {
		try{
			
			objects=etsDao.searchEmpTimeSheetWithId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	
	public List<Object[]> searchEmpTimeSheet() {
		try{
			objects=etsDao.searchEmpTimeSheet();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	
	public String updateEmpTimeSheet(Object updatebtservice) {
		try{
			brmessage=etsDao.updateEmpTimeSheet(updatebtservice);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return brmessage;
	}

	
	public String deleteEmpTimeSheet(int id) {
		try{
			brmessage=etsDao.deleteEmpTimeSheet(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return brmessage;
	}


	public Long getEmpTimeSheetCount(String name) {
		Long iid=0l;
		try{
		 iid=etsDao.getEmpTimeSheetCount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	
	public Long getEmpTimeSheetCountEdit(String name, int breakTimeId) {
		Long iid=0l;
		try{
		 iid=etsDao.getEmpTimeSheetCountEdit(name, breakTimeId);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	
	public List<Object[]> basicSearchEmpTimeSheet(String label, String operator,
			String searchName) {
		try {
			objects = etsDao.basicSearchEmpTimeSheet(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	
	public List<Object[]> selectEmpService() {
try{
			
			objects=etsDao.getEmployeeIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	
	public List<Object[]> selectActivityService() {
try{
			
			objects=etsDao.getActivityIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

}
