/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.breakTimeDao;

/**
 * @author devi
 *
 */
public class BreakTimeServiceImpl implements BreakTimeService{
	String brmessage;
	List<Object[]> objects;
    breakTimeDao dao;
	public breakTimeDao getDao() {
		return dao;
	}
	public void setDao(breakTimeDao dao) {
		this.dao = dao;
	}
@Override
	
	public String saveBreakTime(Object breakTimeobject,String userId,String userName) {
		try{
			brmessage=dao.saveBreakTime(breakTimeobject,userId,userName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return brmessage;
	}

	@Override
	public List<Object[]> selectBreakTimeService() {
		try{
			objects=dao.selectBreakTime();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}
	
	@Override
	public List<Object[]> searchBreakTimeServiceWithId(int id) {
		try{
			
			objects=dao.searchBreakTimeWithId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> searchBreakTimeService() {
		try{
			objects=dao.searchBreakTime();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public String updateBreakTimeService(Object updatebtservice) {
		try{
			brmessage=dao.updateBreakTime(updatebtservice);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return brmessage;
	}

	@Override
	public String deleteBreakTimeService(int id) {
		try{
			brmessage=dao.deleteBreakTime(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return brmessage;
	}

	@Override
	public Long getBreakTimecount(String name) {
		Long iid=0l;
		try{
		 iid=dao.getBreakTimeCount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	@Override
	public Long getBreakTimecountedit(String name, int breakTimeId) {
		Long iid=0l;
		try{
		 iid=dao.getBreakTimeCountedit(name, breakTimeId);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	@Override
	public List<Object[]> basicSearchBreakTime(String label, String operator,
			String searchName) {
		try {
			objects = dao.basicSearchBreakTime(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public List<Object[]> selectorgservice() {
try{
			
			objects=dao.getOrganizationIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectshiftservice() {
try{
			
			objects=dao.getShiftIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}
}
