package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.projectResourceDao;

public class projectResourceServiceImpl implements projectResourceService {
	String brmessage;
	List<Object[]> objects;
	projectResourceDao PRDao;
	public projectResourceDao getPRDao() {
		return PRDao;
	}
	public void setPRDao(projectResourceDao pRDao) {
		PRDao = pRDao;
	}
@Override
	
	public String saveProjectResource(Object breakTimeobject,String userId,String userName) {
		try{
			brmessage=PRDao.saveProjectResource(breakTimeobject,userId,userName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return brmessage;
	}

	@Override
	public List<Object[]> selectProjectResourceService() {
		try{
			objects=PRDao.selectProjectResource();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}
	
	@Override
	public List<Object[]> searchProjectResourceServiceWithId(int id) {
		try{
			
			objects=PRDao.searchProjectResourceWithId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> searchProjectResourceService() {
		try{
			objects=PRDao.searchProjectResource();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public String updateProjectResourceService(Object updatebtservice) {
		try{
			brmessage=PRDao.updateProjectResource(updatebtservice);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return brmessage;
	}

	@Override
	public String deleteProjectResourceService(int id) {
		try{
			brmessage=PRDao.deleteProjectResource(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return brmessage;
	}

	@Override
	public Long getProjectResourcecount(int id) {
		Long iid=0l;
		try{
		 iid=PRDao.getProjectResourceCount(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	@Override
	public Long getProjectResourcecountedit(String name,int breakTimeId) {
		Long iid=0l;
		try{
		 iid=PRDao.getProjectResourceCountedit(name,breakTimeId);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	@Override
	public List<Object[]> basicSearchProjectResource(String label, String operator,
			String searchName) {
		try {
			objects = PRDao.basicSearchProjectResource(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public List<Object[]> selectEmployeeService() {
try{
			
			objects=PRDao.getEmployeeIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectProjectService() {
try{
			
			objects=PRDao.getProjectIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}
	
	@Override
	public List<Object[]> selectDesgService() {
try{
			
			objects=PRDao.getDesgIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPrtypeService() {
try{
			
			objects=PRDao.getPrtypeIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectUomService() {
try{
			
			objects=PRDao.getUomIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}


}
