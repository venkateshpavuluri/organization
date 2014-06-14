/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.physicalVerificationDao;

/**
 * @author kirangangone
 *
 */
public class physicalVerificationServiceImpl implements physicalVerificationService{

	
	
	public physicalVerificationDao pvdao;
	String message=null;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;
	
	
	
	
	/**
	 * @return the pvdao
	 */
	public physicalVerificationDao getPvdao() {
		return pvdao;
	}



	/**
	 * @param pvdao the pvdao to set
	 */
	public void setPvdao(physicalVerificationDao pvdao) {
		this.pvdao = pvdao;
	}



	@Override
	public List<Object>  addPhysicalVerification(Object object) {
		// TODO Auto-generated method stub
		List<Object>  message=pvdao.addPhysicalVerification(object);
		 return message;
	}
	
	
	
	public List<Object[]> basicSearchPV(){
		try {
			objects = pvdao.basicSearchPV();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}
	
	public List<Object> editPVWithId(int cId) {
		try {
			obj = pvdao.editPVWithId(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	public List<Object[]> basicSearchPhysicalVerification(String label, String operator,
			String searchName) {
		List<Object[]> objs = null;
		try {
			objs = pvdao.basicSearchPhysicalVerification(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}
	
	public List<Object[]> getPhysicalVerificationAdvance(String columns,String opeator,String advanceSearchText) {
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
			finalStringForSearch=finalStringForSearch+"  po."+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
			
			
			
		}
		//System.out.println("String Value Kiran" +finalStringForSearch);
		List<Object[]> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = pvdao.setPhysicalVerificationAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = pvdao.basicSearchPV();
		}
		return list;
	}
	
	@Override
	public String updatePhysicalVerification(Object object) {
		try {
			//System.out.println("Came to Service Of Purchase Update");
			message = pvdao.updatePhysicalVerificationDao(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public int updateCheckPhysicalVerification(String pno, int custId) {
		int i = 0;
		try {
			i = pvdao.updateCheckPhysicalVerification(pno, custId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public Long checkPhysicalVerification(String pno) {
		try {
			l = pvdao.checkPhysicalVerification(pno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}
	
	public String deletePhysicalVerificationLine(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = pvdao.deletePhysicalVerificationLine(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
	public List<Object[]> uomIdGet() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = pvdao.uomIdGet();
		return idsList;

	}
	public List<Object[]> materialIdGet() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = pvdao.materialIdGet();
		return idsList;

	}
	
	
	public List<Object[]> verificationTypeIdSelect() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = pvdao.verificationTypeIdSelect();
		return idsList;

	}
	
	public List<Object[]> orgIdSelect() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = pvdao.orgIdSelect();
		return idsList;

	}
	
	public List<Object[]> plantIdSelect() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = pvdao.plantIdSelect();
		return idsList;

	}

	public List<Object[]> storageLocationIdSelect() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = pvdao.storageLocationIdSelect();
		return idsList;

	}
	
	
	public List<Object[]> getplantIdForOrg(String org){
		// TODO Auto-generated method stub
		List<Object[]> idsList = pvdao.getplantIdForOrg(org);
		return idsList;

	}
	
	
	public List<Object[]> getLocationIdForOrg(String plant){
		// TODO Auto-generated method stub
		List<Object[]> idsList = pvdao.getLocationIdForOrg(plant);
		return idsList;

	}
	public List<Object[]> getGoodsIdForOrg(String goods){
		// TODO Auto-generated method stub
		List<Object[]> idsList = pvdao.getGoodsIdForOrg(goods);
		return idsList;

	}

	public Double getTotalReceviedGood(String goods,String materialId){
		// TODO Auto-generated method stub
		Double idsList = pvdao.getTotalReceviedGood(goods,materialId);
		return idsList;

	}

	
	
}
