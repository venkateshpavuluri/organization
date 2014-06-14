/**
copyright MNT Soft
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.VehicleDao;

/**
 * @author anikesh
 *@version 1.0 29-10-2013
 *@build 0.0
 *
 */
public class VehicleServiceImpl implements VehicleService{
VehicleDao vehidao;
List<Object[]> objects;
String msg;

public VehicleDao getVehidao() {
	return vehidao;
}

public void setVehidao(VehicleDao vehidao) {
	this.vehidao = vehidao;
}

public String saveVehicleDetails(Object object,String userId,String userName)
{
	try
	{
		
		msg=vehidao.saveVehicleDetails(object,userId,userName);
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		
	}
	return msg;


}
@Override
public Long duplicateVehicleCheck(String registrationNum) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=vehidao.duplicateVehicleCheck(registrationNum);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public List<Object[]> selectVehicleTypeIds() {

	 try
	 {
		 objects=vehidao.selectVehicleTypeIds();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
@Override
public List<Object[]> searchVehicle() {
	// TODO Auto-generated method stub
	List<Object[]> list=null;
	try
	{
		objects=vehidao.searchVehicle();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return objects;
}

@Override
public List<Object[]> searchVehicleWithName(String regnum) {
	List<Object[]> list=null;
	try
	{
		System.out.println("vehicle reg num in vehicle service veh Dao impl is   "+regnum);
		list=vehidao.searchVehicleWithName(regnum);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Object[]> selectVehicleNames() {

	 try
	 {
		 objects=vehidao.selectVehicleNames();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
public List<Object[]> basicSearchVehicle(String label,String operator,String searchName){
	try {
		objects = vehidao.basicSearchVehicle(label, operator, searchName);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
@Override
public List<Object[]> searchVehicleWithId(String regnum) {
	List<Object[]> list=null;
	try
	{
		list=vehidao.searchVehicleWithId(regnum);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public String updateVehicle(Object object) {
	try
	{
 msg=vehidao.updateVehicle(object);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
@Override
public Long updateDuplicateCheck(String regnum,int vehicleid) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=vehidao.updateDuplicateCheck(regnum, vehicleid);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public String vehicleDelete(String id) {
	// TODO Auto-generated method stub
	String msg=null;
	try
	{
		msg=vehidao.vehicleDelete(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
public List<Object[]> getVehicleAdvance(String columns,String opeator,String advanceSearchText) {
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
	 list = vehidao.setVehicleAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
	}
	else
	{
		list = vehidao.searchVehicle();
	}
	return list;
}
}
