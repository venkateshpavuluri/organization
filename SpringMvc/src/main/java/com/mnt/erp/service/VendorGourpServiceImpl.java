
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;


import java.util.List;
import com.mnt.erp.dao.VendorGroupDao;

/**
 * This is VendGroup Service Interface implementation.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */
public class VendorGourpServiceImpl  implements VendGroupService{
	public VendorGroupDao vdao;
List<Object[]> objects=null;
	public VendorGroupDao getVdao() {
		return vdao;
	}
	public void setVdao(VendorGroupDao vdao) {
		this.vdao = vdao;
	}
	String msg;
	@Override
	public String saveVendorGroup(Object object,String userId,String userName){
		try
		{
			msg=vdao.saveVendorGroup(object, userId, userName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;

}
	public List<Object[]> searchVendorGroup(int id){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
		list=vdao.searchVendorGroup(id);
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> editVendorGroupWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=vdao.editVendorGroupWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public String updateVendorGroup(Object object) {
		try
		{
	        msg=vdao.updateVendorGroup(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String deleteVendorGroup(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=vdao.vendorGroupDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}

	public int vendorDuplicate(String vendorGroupCheck,String vendorGroupCodeCheck){
	
		int list=0;
		try
		{
			list=vdao.vendorDuplicate(vendorGroupCheck, vendorGroupCodeCheck);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	public int vendorEditDuplicate(String vendorGroupCheck,String vendorGroupCodeCheck,int id){
		
		int list=0;
		try
		{
			list=vdao.vendorEditDuplicate(vendorGroupCheck, vendorGroupCodeCheck, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Object[]> getVendorGroupIds() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			list=vdao.getVendorGroupIds();
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> basicSearchVendorGroup(String label, String operator,
			String searchName) {
		try {
			objects =vdao.basicSearchVendorGroup(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
}
