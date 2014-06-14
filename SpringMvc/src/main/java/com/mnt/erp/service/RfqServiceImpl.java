package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.RfqBean;
import com.mnt.erp.dao.RfqDao;

public class RfqServiceImpl implements RfqService {
	RfqDao rfqdao;
	String rfqmessage;
	List<Object[]> objects;
	List<Object> object;
	List<RfqBean> rflist;
	public RfqDao getRfqdao() {
		return rfqdao;
	}

	public void setRfqdao(RfqDao rfqdao) {
		this.rfqdao = rfqdao;
	}

	@Override
	public String saverfqservice(Object object) {
		try{
			rfqmessage=rfqdao.saverfq(object);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqmessage;
	}

	@Override
	public List<Object[]> selectrfqTypeservice() {
		try{
			
			objects=rfqdao.selectrfqType();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectItemCategoryservice() {
try{
			
			objects=rfqdao.selectItemCategory();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectstorageLocationservice() {
try{
			
			objects=rfqdao.selectstorageLocation();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectplantservice() {
try{
			
			objects=rfqdao.selectplant();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectpurchaseGroupservice() {
try{
			
			objects=rfqdao.selectpurchaseGroup();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> searchRfqservice() {
		try{
			objects=rfqdao.searchRfq();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public List<Object[]> selectRfqservice() {
		try{
			objects=rfqdao.selectRfq();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<RfqBean> EditRfqservice(int iid) {
		try{
			rflist=rfqdao.EditRfq(iid);
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return rflist;
	}

	@Override
	public String updateRfqservice(Object object) {
		try{
			rfqmessage=rfqdao.updateRfq(object);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rfqmessage;
	}

	@Override
	public String deleteRfqservice(int id) {
		try{
			rfqmessage=rfqdao.deleteRfq(id);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return rfqmessage;
	}

	@Override
	public List<Object[]> basicSearchRfqservice(String label, String operator,
			String searchName) {
		try {
			objects =rfqdao.basicSearchRfq(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public List<Object[]> selectMaterialservice() {
		try{
			objects=rfqdao.selectMaterial();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> selectUOMservice() {
		try{
			objects=rfqdao.selectUOM();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public String deleteChildDetailsService(int cid) {
		try{
			rfqmessage=rfqdao.deleteChildDetails(cid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rfqmessage;
	}

	
	@Override
	public List<Object[]> Rfqadvance(String columns, String opeator,
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
		 list = rfqdao.setRfqAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = rfqdao.setRfqSearch("ALL");
		}
		return list;
	}

	@Override
	public List<Object[]> getrfq(String rfq) {
		List<Object[]> list = rfqdao.setRfqSearch(rfq);
		return list;
	}

	@Override
	public Long getRfqCount(String name) {
		Long id = 0L;
		try {
			id = rfqdao.getRfqCount(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public Long getRfqCountedit(String name, int Rfqid) {
		Long id = 0L;
		try {
			id = rfqdao.getRfqCountedit(name, Rfqid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

	@Override
	public List<Object[]> selectStatus() {
try{
			
			objects=rfqdao.selectStatus();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

}
