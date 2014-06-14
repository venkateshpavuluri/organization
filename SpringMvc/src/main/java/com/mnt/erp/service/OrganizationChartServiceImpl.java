/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.OrganizationChartDao;

/**
 * @author tparvathi
 *
 */
public class OrganizationChartServiceImpl implements OrganizationChartService{
	public OrganizationChartDao orgChatdao;
	public String msg;
	List<Object[]> objects;

	

	public OrganizationChartDao getOrgChatdao() {
		return orgChatdao;
	}
	public void setOrgChatdao(OrganizationChartDao orgChatdao) {
		this.orgChatdao = orgChatdao;
	}
	
	public String saveOrganizationChart(Object object,String userId,String userName){
     try{
		   msg=orgChatdao.saveOrganizationChart(object,userId,userName);
	    }
	 catch(Exception e){
			e.printStackTrace();
		}
	 return msg;

}
	public List<Object[]> searchOrganizationChart(int id){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
		   list=orgChatdao.searchOrganizationChart(id);
						
		 }
		catch(Exception e)
		{
		   e.printStackTrace();
		}
		return list;
	}
	
	public List<Object[]> editOrganizationChartWithId(int id){
		List<Object[]> list=null;
		try
		{
			list=orgChatdao.editOrganizationChartWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public String updateOrganizationChart(Object object) {
		try
		{
	       msg=orgChatdao.updateOrganizationChart(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String OrganizationChartDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=orgChatdao.OrganizationChartDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int OrganizationChartDuplicate(String org,String designation,String parentDesignation){
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=orgChatdao.OrganizationChartDuplicate(org,designation, parentDesignation);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	public int OrganizationChartEditDuplicate(String org,String designation,String parentDesignation,int id){
		int list1=0;
		try
		{
			list1=orgChatdao.OrganizationChartEditDuplicate(org,designation,parentDesignation, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchOrganizationChart(String label,
			String operator, String searchName) {
		try {
			objects = orgChatdao.basicSearchOrganizationChart(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	
}
