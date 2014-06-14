package com.mnt.erp.service;
/*
@author Srinivas
@version 1.0   
*/
import java.util.List;

import com.mnt.erp.dao.InspectionMethodDao;

public class InspectionMethodServiceImpl implements InspectionMethodService {
	InspectionMethodDao idao;
	String imessage;
	List<Object[]> objects;
	
	
	public InspectionMethodDao getIdao() {
		return idao;
	}

	public void setIdao(InspectionMethodDao idao) {
		this.idao = idao;
	}

	@Override
	public String saveInspectionMethodService(Object object,String userId,String userName) {
		try{
			imessage=idao.saveInspectionMethod(object, userId, userName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return imessage;
	}

	@Override
	public List<Object[]> searchInspectionMethodServiceWithId(int id) {
          try{
			
			objects=idao.searchInspectionMethodWithId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> searchInspectionMethodService() {
		try{
			objects=idao.searchInspectionMethod();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public List<Object[]> selectInspectionMethodService() {
		try{
			objects=idao.selectInspectionMethod();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public String updateInspectionMethodService(Object object) {
		try{
			imessage=idao.updateInspectionMethod(object);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return imessage;
	}

	@Override
	public String deleteInspectionMethodService(int id) {
		try{
			imessage=idao.deleteInspectionMethod(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return imessage;
	}

	@Override
	public Long getInspectionMethodCount(String name) {
		// TODO Auto-generated method stub
		Long id=0L;
		try{
			id=idao.getInspectionMethodCount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getInspectionMethodCountedit(String name, int imid) {
		Long id=0L;
		try{
			id=idao.getInspectionMethodCountedit(name, imid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
	public List<Object[]> basicSearchInspectionMethod(String label,String operator,String searchName){
		try{
			objects=idao.basicSearchInspectionMethod(label, operator, searchName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

}
