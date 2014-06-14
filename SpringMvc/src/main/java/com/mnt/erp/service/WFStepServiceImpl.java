/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.WFProcess;
import com.mnt.erp.bean.WFStep;
import com.mnt.erp.dao.WFStepDao;
import com.mnt.erp.dao.WFStepDao;

/**
 * @author Administrator
 *
 */
public class WFStepServiceImpl implements WFStepService{
WFStepDao dao;
List<Object[]> objects;
String msg;



public WFStepDao getDao() {
	return dao;
}
public void setDao(WFStepDao dao) {
	this.dao = dao;
}
public String saveWFStepDetails(Object object,String userId,String userName)
{
	try
	{
		
		msg=dao.saveWFStepDetails(object,userId,userName);
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		
	}
	return msg;


}
@Override
public Long duplicateWFStepCheck(String sid,String role) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=dao.duplicateWFStepCheck(sid,role);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public List<Object[]> selectStageIds() {

	 try
	 {
		 objects=dao.selectStageIds();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
@Override
public List<Object[]> selectRoleIds() {

	 try
	 {
		 objects=dao.selectRoleIds();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
@Override
public List<Object[]> searchWFStep() {
	// TODO Auto-generated method stub
	List<Object[]> list=null;
	try
	{
		list=dao.searchWFStep();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
public List<Object[]> basicSearchWFStep(String label,String operator,String searchName){
	try {
		objects = dao.basicSearchWFStep(label, operator, searchName);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}

@Override
public List<Object[]> searchWFStepWithName(String wfstepname) {
	List<Object[]> list=null;
	try
	{
		list=dao.searchWFStepWithName(wfstepname);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public List<Object[]> selectWFStepNames() {

	 try
	 {
		 objects=dao.selectWFStepNames();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
@Override
public List<Object[]> searchWFStepWithId(String wfstepname) {
	List<Object[]> list=null;
	try
	{
		list=dao.searchWFStepWithId(wfstepname);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public String updateWFStep(Object object) {
	try
	{
 msg=dao.updateWFStep(object);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
@Override
public Long updateDuplicateCheck(String wfstepName,String wfstepid,String wfstageid) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=dao.updateDuplicateCheck(wfstepName, wfstepid, wfstageid);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public String wfstepDelete(String id) {
	// TODO Auto-generated method stub
	String msg=null;
	try
	{
		msg=dao.wfstepDelete(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
public List<Object[]> getWFStepAdvance(String columns,String opeator,String advanceSearchText) {
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
	 list = dao.setWFStepAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
	}
	else
	{
		list = dao.searchWFStep();
	}
	return list;
}

}
