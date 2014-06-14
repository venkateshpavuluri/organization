/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.AgreementTypeDao;

/**
 * This is AgreementTypeService interface implementation .
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class AgreementTypeServiceImpl implements AgreementTypeService {
	
	public AgreementTypeDao atdao;
	public String msg;
	List<Object[]> objects;

	
	/* getter methhods of AgreementTypeDao */
	
	public AgreementTypeDao getAtdao() {
		return atdao;
	}
	public String getMsg() {
		return msg;
	}
	
	/* setter methhods of AgreementTypeDao */
	
	public void setAtdao(AgreementTypeDao atdao) {
		this.atdao = atdao;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String saveAgreementType(Object object,String userId,String userName){
     try{
		   msg=atdao.saveAgreementType(object,userId,userName);
	    }
	 catch(Exception e){
			e.printStackTrace();
		}
	 return msg;

}
	public List<Object[]> searchAgreementType(int id){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
		   list=atdao.searchAgreementType(id);
						
		 }
		catch(Exception e)
		{
		   e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> editAgreementTypeWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=atdao.editAgreementTypeWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public String updateAgreementType(Object object) {
		try
		{
	       msg=atdao.updateAgreementType(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String agreementTypeDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=atdao.agreementTypeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int agreementTypeDuplicate(String agreementType){
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=atdao.agreementTypeDuplicate(agreementType);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	public int agreementTypeEditDuplicate(String agreementType,int id){
		int list1=0;
		try
		{
			list1=atdao.agreementTypeEditDuplicate(agreementType, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchAgreementType(String label,
			String operator, String searchName) {
		try {
			objects = atdao.basicSearchAgreementType(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	
}