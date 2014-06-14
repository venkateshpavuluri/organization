package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.SalesOrganizationDao;

public class SalesOrganizationServiceImpl implements SalesOrganizationService{
	String somessage;
	List<Object[]> objects;
	SalesOrganizationDao sodao;
	
	public SalesOrganizationDao getSodao() {
		return sodao;
	}

	public void setSodao(SalesOrganizationDao sodao) {
		this.sodao = sodao;
	}

	@Override
	public String saveSalesOrgService(Object object,String userId,String UserName) {
		try{
			somessage=sodao.saveSalesOrg(object,userId,UserName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return somessage;
	}

	@Override
	public List<Object[]> searchSalesOrgServiceWithId(int id) {
		 try{
				
				objects=sodao.searchSalesOrgWithId(id);
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return objects;
	}

	@Override
	public List<Object[]> searchSalesOrgService() {
		try{
			objects=sodao.searchSalesOrg();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public List<Object[]> selectSalesOrgService() {
		try{
			objects=sodao.selectSalesOrg();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> selectOrg() {
		try{
			objects=sodao.selectOrg();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public String updateSalesOrgService(Object object) {
		try{
			somessage=sodao.updateSalesOrg(object);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return somessage;
	}

	@Override
	public String deleteSalesOrgService(int id) {
		try{
			somessage=sodao.deleteSalesOrg(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		return somessage;
	}

	@Override
	public Long getSalesOrgCount(String name) {
		Long id=0L;
		try{
			id=sodao.getSalesOrgCount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getSalesOrgCountedit(String name, int imid) {
		Long id=0L;
		try{
			id=sodao.getSalesOrgCountedit(name, imid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Object[]> basicSearchSalesOrg(String label, String operator,
			String searchName) {
		try{
			objects=sodao.basicSearchSalesOrg(label, operator, searchName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;	}

}
