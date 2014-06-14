/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.WFStage;
import com.mnt.erp.dao.WFStageDao;

/**
 * @author Administrator
 *
 */
public class WFStageServiceImpl implements WFStageService{
	List<Object[]> objects;
	String msg;	
WFStageDao dao;

public WFStageDao getDao() {
	return dao;
}

public void setDao(WFStageDao dao) {
	this.dao = dao;
}

public String saveWFStageDetails(Object object,String userId,String userName)
{
	try
	{
		
		msg=dao.saveWFStageDetails(object,userId,userName);
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		
	}
	return msg;


}
@Override
public Long duplicateWFStageCheck(String wfstage) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=dao.duplicateWFStageCheck(wfstage);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public List<Object[]> selectProcessIds() {

	 try
	 {
		 objects=dao.selectProcessIds();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
@Override
public List<Object[]> searchWFStage() {
	// TODO Auto-generated method stub
	List<Object[]> list=null;
	try
	{
		list=dao.searchWFStage();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
public List<Object[]> basicSearchWFStage(String label,String operator,String searchName){
	try {
		objects = dao.basicSearchWFStage(label, operator, searchName);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}

@Override
public List<Object[]> searchWFStageWithName(String wfstagename) {
	List<Object[]> list=null;
	try
	{
		list=dao.searchWFStageWithName(wfstagename);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Object[]> selectWFStageNames() {

	 try
	 {
		 objects=dao.selectWFStageNames();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
@Override
public List<Object[]> searchWFStageWithId(String wfstagename) {
	List<Object[]> list=null;
	try
	{
		list=dao.searchWFStageWithId(wfstagename);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public String updateWFStage(Object object) {
	try
	{
 msg=dao.updateWFStage(object);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
@Override
public Long updateDuplicateCheck(String wfstageName,String wfstageid) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=dao.updateDuplicateCheck(wfstageName, wfstageid);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public String wfstageDelete(String id) {
	// TODO Auto-generated method stub
	String msg=null;
	try
	{
		msg=dao.wfstageDelete(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
public List<Object[]> getWFStageAdvance(String columns,String opeator,String advanceSearchText) {
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
	 list = dao.setWFStageAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
	}
	else
	{
		list = dao.searchWFStage();
	}
	return list;
}
}
