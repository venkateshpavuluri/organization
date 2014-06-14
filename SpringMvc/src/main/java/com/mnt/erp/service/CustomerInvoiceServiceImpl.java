package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.CustomerInvoice;
import com.mnt.erp.dao.CustomerInvoiceDao;

public class CustomerInvoiceServiceImpl implements CustomerInvoiceService {
	CustomerInvoiceDao cidao;
	String cimessage;
	List<Object[]> objects;
	List<Object> object;
	List<CustomerInvoice> vilist;
	public CustomerInvoiceDao getCidao() {
		return cidao;
	}

	public void setCidao(CustomerInvoiceDao cidao) {
		this.cidao = cidao;
	}

	@Override
	public String saveCustomerInvoiceservice(Object object) {
		try{
			cimessage=cidao.saveCustomerInvoice(object);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return cimessage;
	}

	@Override
	public List<Object[]> selectorgservice() {
		 try{
				
				objects=cidao.selectorg();
			}catch(Exception e){
				e.printStackTrace();
			}
			return objects;
	}

	@Override
	public List<Object[]> selectcurrencyservice() {
try{
			
			objects=cidao.selectcurrency();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectDeliveryNoteservice() {
try{
			
			objects=cidao.selectdeliverynote();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectCustomerInvoiceservice() {
		try{
			objects=cidao.searchCustomerInvoice();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> selectMaterialservice() {
		try{
			objects=cidao.selectMaterial();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> selectUOMservice() {
		try{
			objects=cidao.selectUOM();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<CustomerInvoice> EditCustomerInvoiceservice(int iid) {
		try{
			vilist=cidao.EditCustomerInvoice(iid);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return vilist;
	}

	@Override
	public List<Object[]> CustomerInvoiceadvance(String columns,
			String opeator, String advanceSearchText) {
		
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
				 list = cidao.setCustomerInvoiceAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
				}
				else
				{
					list = cidao.setCustomerInvoiceSearch("ALL");
				}
				return list;
		}
	

	@Override
	public List<Object[]> getCustomerInvoice(String vi) {
		List<Object[]> list = cidao.setCustomerInvoiceSearch(vi);
		return list;
	}

	@Override
	public String deleteChildDetailsService(int cid) {
		try{
			cimessage=cidao.deleteChildDetails(cid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return cimessage;
	}

	@Override
	public String updateCustomerInvoiceservice(Object object) {
		try{
			cimessage=cidao.updateCustomerInvoice(object);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return cimessage;
	}

	@Override
	public String deleteCustomerInvoiceservice(int id) {
		try{
			cimessage=cidao.deleteCustomerInvoice(id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return cimessage;
	}

	@Override
	public List<Object[]> basicSearchCustomerInvoiceservice(String label,
			String operator, String searchName) {
		try {
			objects =cidao.basicSearchCustomerInvoice(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public Long getCICount(String name) {
		Long id = 0L;
		try {
			id = cidao.getCICount(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getCICountedit(String name, int cid) {
		Long id = 0L;
		try {
			id = cidao.getCICountedit(name, cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
