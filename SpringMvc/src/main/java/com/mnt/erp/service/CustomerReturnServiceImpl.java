package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.CustomerReturnDao;

public class CustomerReturnServiceImpl implements CustomerReturnService {
	
private CustomerReturnDao crdao;

public CustomerReturnDao getCrdao() {
	return crdao;
}

public void setCrdao(CustomerReturnDao crdao) {
	this.crdao = crdao;
}
List<Object[]> objects=null;

String msg=null;

public List<Object[]> selectMaterialIds(){
	try {
		objects = crdao.selectMaterialIds();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}

public List<Object[]> selectReasonForRejection(){
	try {
		objects = crdao.selectReasonForRejection();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
public String saveCustomerReturn(Object object,String userId,String userName){
	try {
		msg = crdao.saveCustomerReturn(object, userId, userName);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return msg;
}
public List<Object[]> selectSalesOrders(){
	try {
		objects = crdao.selectSalesOrders();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}

public List<Object[]> basicSearchCustomerReturn(String label, String operator,
		String searchName){
	try {
		objects = crdao.basicSearchCustomerReturn(label,
				operator, searchName);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
public List<Object[]> searchCustomerReturn(){
	try {
		objects = crdao.searchCustomerReturn();

	} catch (Exception e) {
		e.printStackTrace();
	}
	return objects;
}
public String deleteCustomerReturn(int id){
	try {
		msg = crdao.deleteCustomerReturn(id);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return msg;
}
public List<Object> editCustomerReturnWithId(int id){
	 List<Object> obj=null;
	try {
		obj = crdao.editCustomerReturnWithId(id);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return obj;
}

public String updateCustomerReturn(Object object){
	try {
		msg = crdao.updateCustomerReturn(object);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return msg;
}
public int customerReturnDuplicate(String CRNo){
	int cr=0;
	try {
		cr = crdao.customerReturnDuplicate(CRNo);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return cr;
}

public int customerReturnEditDuplicate(String CRNo,int id){
	int cr=0;
	try {
		cr = crdao.customerReturnEditDuplicate(CRNo, id);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return cr;
}

public String deleteCustomerReturnLine(int kk){
	try {
		msg = crdao.deleteCustomerReturnLine(kk);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return msg;
}
public List<Object[]> getCustomerReturnAdvance(String name){
	List<Object[]> obj=null;
	try {
		obj = crdao.getCustomerReturnAdvance(name);

	} catch (Exception e) {
		e.printStackTrace();
	}
	return obj;
}
public List<Object[]> getCustRetrunAdvance(String columns,String opeator,String advanceSearchText){
	System.out.println("this is service of adavance search");
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
	
	List<Object[]> list=null;
	if(finalStringForSearch.length()>3)
	{
	 list = crdao.getCustomerReturnAdvance(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
	}
	else
		if(finalStringForSearch.length()<3)
	{
		list = crdao.searchCustomerReturn();
	}
	return list;
}

@Override
public String getQuantityCount(int mid, int sid) {
	String quantity=null;
	try{
		quantity=crdao.getQuantity(mid, sid);
	}catch(Exception e){
		e.printStackTrace();
	}
	return quantity;
}
}
