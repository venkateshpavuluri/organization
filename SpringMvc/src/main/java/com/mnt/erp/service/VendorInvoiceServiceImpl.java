package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.bean.VendorInvoice;
import com.mnt.erp.dao.VendorInvoiceDao;

public class VendorInvoiceServiceImpl implements VendorInvoiceService{
	VendorInvoiceDao vidao;
	String vimessage;
	List<Object[]> objects;
	List<Object> object;
	List<VendorInvoice> vilist;
	
	public VendorInvoiceDao getVidao() {
		return vidao;
	}

	public void setVidao(VendorInvoiceDao vidao) {
		this.vidao = vidao;
	}

	@Override
	public String saveVendorInvoiceservice(Object object) {
		try{
			vimessage=vidao.saveVendorInvoice(object);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return vimessage;
	}

	@Override
	public List<Object[]> selectorgservice() {
             try{
			
			objects=vidao.selectorg();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectcurrencyservice() {
try{
			
			objects=vidao.selectcurrency();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectVendorservice() {
try{
			
			objects=vidao.selectVendor();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectpurchaseOrderservice() {
try{
			
			objects=vidao.selectpurchaseOrder();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchVendorInvoiceservice() {
		try{
			objects=vidao.searchVendorInvoice();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public List<Object[]> selectVendorInvoiceservice() {
		try{
			objects=vidao.selectVendorInvoice();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> selectMaterialservice() {
		try{
			objects=vidao.selectMaterial();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> selectUOMservice() {
		try{
			objects=vidao.selectUOM();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<VendorInvoice> EditVendorInvoiceservice(int iid) {
		try{
			vilist=vidao.EditVendorInvoice(iid);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return vilist;
	}

	@Override
	public List<Object[]> VendorInvoiceadvance(String columns, String opeator,
			String advanceSearchText) {
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
			 list = vidao.setVendorInvoiceAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
			}
			else
			{
				list = vidao.setVendorInvoiceSearch("ALL");
			}
			return list;
	}

	@Override
	public List<Object[]> getVendorInvoice(String vi) {
		List<Object[]> list = vidao.setVendorInvoiceSearch(vi);
		return list;
	}

	@Override
	public String deleteChildDetailsService(int cid) {
		try{
			vimessage=vidao.deleteChildDetails(cid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return vimessage;
	}

	@Override
	public String updateVendorInvoiceservice(Object object) {
		try{
			vimessage=vidao.updateVendorInvoice(object);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vimessage;
	}

	@Override
	public String deleteVendorInvoiceservice(int id) {
		try{
			vimessage=vidao.deleteVendorInvoice(id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return vimessage;
	}

	@Override
	public List<Object[]> basicSearchVendorInvoiceservice(String label,
			String operator, String searchName) {
		try {
			objects =vidao.basicSearchVendorInvoice(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public Long getVICount(String name) {
		Long id = 0L;
		try {
			id = vidao.getVICount(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getVICountedit(String name, int viid) {
		Long id = 0L;
		try {
			id = vidao.getVICountedit(name, viid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
