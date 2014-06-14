
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.OrgPlants;
import com.mnt.erp.bean.PurchaseOrganization;
import com.mnt.erp.dao.PurchaseOrganizationDao;

/**
 * This is PurchaseOrganization Service Implementation .
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class PurchaseOrganizationServiceImpl implements PurchaseOrganizationService{
	
	public PurchaseOrganizationDao podao;
	String msg;
	List<Object[]> objects;

	public PurchaseOrganizationDao getPodao() {
		return podao;
	}
	public void setPodao(PurchaseOrganizationDao podao) {
		this.podao = podao;
	}
	
	public String savePurchaseOrganization(Object object,String userId,String userName){
		try
		{
			msg=podao.savePurchaseOrganization(object,userId,userName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public List<OrgPlants> selectPlants(String orgId){
		List<OrgPlants> objects=null;
		try{
			objects=podao.selectPlants(orgId);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}
	public List<Object[]> searchPurchaseOrganization(){
		
		try{
			objects=podao.searchPurchaseOrganization();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}
	public List<PurchaseOrganization> editPurchaseOrganization(int id){
		List<PurchaseOrganization> list=null;
		try{
			
			list=podao.editPurchaseOrganizationWithId(id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}

	public String updatePurchaseOrganization(Object object){
		try
		{
			msg=podao.updatePurchaseOrganization(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;	
	}
	
	public String deletePurchaseOrganization(int id){
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=podao.deletePurchaseOrganization(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	
	public int purchaseOrganizationDuplicate(String purOrg){
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=podao.purchaseOrganizationDuplicate(purOrg);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;	
	}
	public int purchaseOrganizationEditDuplicate(String purOrg,int id){
		// TODO Auto-generated method stub
				int list1=0;
				try
				{
					list1=podao.purchaseOrganizationEditDuplicate(purOrg, id);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list1;	
	}
	@Override
	public List<Object[]> basicSearchPurchaseOrganization(String label,
			String operator, String searchName) {
		try {
			objects = podao.basicSearchPurchaseOrganization(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	public List<Object[]> selectPurchaseOrg() {
		// TODO Auto-generated method stub
		List<Object[]> idsList=podao.selectPurchaseOrg();
		return idsList;
	}
}
