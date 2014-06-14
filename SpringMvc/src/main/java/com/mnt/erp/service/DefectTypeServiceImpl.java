package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.DefectTypeDao;

public class DefectTypeServiceImpl implements DefectTypeService {
	DefectTypeDao dtdao;
	String dmessage;
	List<Object[]> objects;
	
	public DefectTypeDao getDtdao() {
		return dtdao;
	}

	public void setDtdao(DefectTypeDao dtdao) {
		this.dtdao = dtdao;
	}

	@Override
	public String saveDefectTypeService(Object object,String userId,String userName) {
		try{
			dmessage=dtdao.saveDefectType(object, userId, userName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return dmessage;
	}

	@Override
	public List<Object[]> searchDefectTypeServiceWithId(int id) {
		try{
		objects=dtdao.searchDefectTypeWithId(id);
	}catch(Exception e){
		e.printStackTrace();
	}
	
	return objects;
	}

	@Override
	public List<Object[]> searchDefectTypeService() {
		try{
			objects=dtdao.searchDefectType();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public List<Object[]> selectDefectTypeService() {
		try{
			objects=dtdao.selectDefectType();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public String updateDefectTypeService(Object object) {
		try{
			dmessage=dtdao.updateDefectType(object);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return dmessage;
	}

	@Override
	public String deleteDefectTypeService(int id) {
		try{
			dmessage=dtdao.deleteDefectType(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dmessage;
	}

	@Override
	public Long getDefectTypeCount(String name) {
		Long id=0L;
		try{
			id=dtdao.getDefectTypeCount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getDefectTypeCountedit(String name, int dtid) {
		Long id=0L;
		try{
			id=dtdao.getDefectTypeCountedit(name, dtid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Object[]> basicSearchDefectType(String label, String operator,
			String searchName) {
		try{
			objects=dtdao.basicSearchDefectType(label, operator, searchName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

}
