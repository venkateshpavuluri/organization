/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.RouteDao;

/**
 * @author anikesh
 *
 */
public class RouteServiceImpl implements RouteService{
	RouteDao rotDao;
	List<Object[]> objects;
	String msg;

	

	public RouteDao getRotDao() {
		return rotDao;
	}
	public void setRotDao(RouteDao rotDao) {
		this.rotDao = rotDao;
	}
	public String saveRouteDetails(Object object,String userId,String userName)
	{
		try
		{
			
			msg=rotDao.saveRouteDetails(object,userId,userName);
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			
		}
		return msg;


	}
	@Override
	public Long duplicateRouteCheck(String registrationNum) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=rotDao.duplicateRouteCheck(registrationNum);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public List<Object[]> selectOrganizationIds() {

		 try
		 {
			 objects=rotDao.selectOrganizationIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> selectUomIds() {

		 try
		 {
			 objects=rotDao.selectUomIds();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	@Override
	public List<Object[]> searchRoute() {
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
			objects=rotDao.searchRoute();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchRouteWithName(String regnum) {
		List<Object[]> list=null;
		try
		{
			System.out.println("route reg num in route service veh Dao impl is   "+regnum);
			list=rotDao.searchRouteWithName(regnum);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Object[]> selectRouteNames() {

		 try
		 {
			 objects=rotDao.selectRouteNames();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		
		return objects;
	}
	public List<Object[]> basicSearchRoute(String label,String operator,String searchName){
		try {
			objects = rotDao.basicSearchRoute(label, operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	@Override
	public List<Object[]> searchRouteWithId(String regnum) {
		List<Object[]> list=null;
		try
		{
			list=rotDao.searchRouteWithId(regnum);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String updateRoute(Object object) {
		try
		{
	 msg=rotDao.updateRoute(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Long updateDuplicateCheck(String regnum,int routeid) {
		// TODO Auto-generated method stub
		Long duplicate=0l;
		try
		{
			duplicate=rotDao.updateDuplicateCheck(regnum, routeid);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return duplicate;
	}
	@Override
	public String routeDelete(String id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=rotDao.routeDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public List<Object[]> getRouteAdvance(String columns,String opeator,String advanceSearchText) {
		String column[]=columns.split(",");
		String op[]=opeator.split(",");
		String advanceSearch[]=advanceSearchText.split(",");
		String finalStringForSearch="";
		
		for(int i=0;i<advanceSearch.length;i++){
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			if (op[i].equals("_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = advanceSearch[i] +"%";
				

			} else if (op[i].equals("%_")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] = "%" + advanceSearch[i];

			} else if (op[i].equals("%_%")) {
				column[i]=column[i];
				op[i]=" like ";
				advanceSearch[i] =  "%"  + advanceSearch[i] + "%" ;

			} else if (op[i].equals("=")) {
				column[i]=column[i];
				op[i]=" = ";
				advanceSearch[i] =   advanceSearch[i]  ;

			} else if (op[i].equals("!=")) {
				column[i]=column[i];
				op[i]=" != ";
				advanceSearch[i] =   advanceSearch[i]  ;

			}
			if(!op[i].equals("0") && advanceSearch[i]!="")
			{
			finalStringForSearch=finalStringForSearch+"  "+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
			
			
			
		}
		//System.out.println("String Value Kiran" +finalStringForSearch);
		List<Object[]> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = rotDao.setRouteAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = rotDao.searchRoute();
		}
		return list;
	}

}
