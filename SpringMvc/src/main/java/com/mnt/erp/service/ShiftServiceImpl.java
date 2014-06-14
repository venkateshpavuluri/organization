package com.mnt.erp.service;
/*
@author Srinivas
@version 1.0   
*/
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mnt.erp.dao.ShiftDao;

public class ShiftServiceImpl  implements ShiftService {
ShiftDao sdao;
String shiftmessage;
List<Object[]> objects;


public ShiftDao getSdao() {
	return sdao;
}

public void setSdao(ShiftDao sdao) {
	this.sdao = sdao;
}

	@Override
	
	public String saveShiftService(Object shiftserviceobject,String userId,String userName) {
		try{
			shiftmessage=sdao.saveShift(shiftserviceobject,userId,userName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return shiftmessage;
	}

	@Override
	public List<Object[]> selectShiftService() {
		try{
			objects=sdao.selectShift();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}
	
	@Override
	public List<Object[]> searchShiftServiceWithId(int id) {
		try{
			
			objects=sdao.searchShiftWithId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> searchShiftService() {
		try{
			objects=sdao.searchShift();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public String updateShiftService(Object updateshiftservice) {
		try{
			shiftmessage=sdao.updateShift(updateshiftservice);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return shiftmessage;
	}

	@Override
	public String deleteShiftService(int id) {
		try{
			shiftmessage=sdao.deleteShift(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return shiftmessage;
	}

	@Override
	public Long getShiftcount(String name) {
		Long iid=0l;
		try{
		 iid=sdao.getShiftCount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	@Override
	public Long getShiftcountedit(String name, int shiftid) {
		Long iid=0l;
		try{
		 iid=sdao.getShiftCountedit(name,shiftid);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	@Override
	public List<Object[]> basicSearchAccoutGroup(String label, String operator,
			String searchName) {
		try {
			objects = sdao.basicSearchShift(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	

	
	

	

}
