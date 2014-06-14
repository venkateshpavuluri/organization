/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.FunctionDao;

/**
 * @author anikesh
 *
 */
public class FunctionServiceImpl implements FunctionService{
FunctionDao funcdao;
List<Object[]> objects;
String msg;


public FunctionDao getFuncdao() {
	return funcdao;
}

public void setFuncdao(FunctionDao funcdao) {
	this.funcdao = funcdao;
}
public String saveFunctionDetails(Object object,String userId,String userName)
{
	try
	{
		
		msg=funcdao.saveFunctionDetails(object,userId,userName);
		
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		
	}
	return msg;


}
@Override
public Long duplicateFunctionCheck(String function) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=funcdao.duplicateFunctionCheck(function);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public List<Object[]> searchFunction() {
	// TODO Auto-generated method stub
	List<Object[]> list=null;
	try
	{
		objects=funcdao.searchFunction();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return objects;
}


@Override
public List<Object[]> selectFunctionNames() {

	 try
	 {
		 objects=funcdao.selectFunctionNames();
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	
	return objects;
}
public List<Object[]> basicSearchFunction(String label,String operator,String searchName){
	try {
		objects = funcdao.basicSearchFunction(label, operator, searchName);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
@Override
public List<Object[]> searchFunctionWithId(String functionname) {
	List<Object[]> list=null;
	try
	{
		list=funcdao.searchFunctionWithId(functionname);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return list;
}
@Override
public String updateFunction(Object object) {
	try
	{
 msg=funcdao.updateFunction(object);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
@Override
public Long updateDuplicateCheck(String functionName,int functionid) {
	// TODO Auto-generated method stub
	Long duplicate=0l;
	try
	{
		duplicate=funcdao.updateDuplicateCheck(functionName, functionid);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return duplicate;
}
@Override
public String functionDelete(int id) {
	// TODO Auto-generated method stub
	String msg=null;
	try
	{
		msg=funcdao.functionDelete(id);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return msg;
}
}
