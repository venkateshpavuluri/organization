/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;
import com.mnt.erp.dao.PurchaseRequisitionDao;

/**
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public class PurchaseRequisitionServiceImpl implements
		PurchaseRequisitionService {
	List<Object[]> list = null;
	public PurchaseRequisitionDao purchaseRequisitionDao;

	public PurchaseRequisitionDao getPurchaseRequisitionDao() {
		return purchaseRequisitionDao;
	}

	public void setPurchaseRequisitionDao(
			PurchaseRequisitionDao purchaseRequisitionDao) {
		this.purchaseRequisitionDao = purchaseRequisitionDao;
	}

	String msg;

	public String savePurchaseRequisitionDetails(Object object) {
		try {
			msg = purchaseRequisitionDao.savePurchaseRequisitionDetails(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public List<Object[]> searchPurchaseReq() {

		try {
			list = purchaseRequisitionDao.searchPurchaseReq();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<Object> editPurchaseReqWithId(int prid) {
		List<Object> list = null;
		try {
			list = purchaseRequisitionDao.editPurchaseReqWithId(prid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public String updatePurchaseRequisition(Object object) {

		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = purchaseRequisitionDao.updatePurchaseRequisition(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}

	public String deletePurchaseRequisition(int id) {

		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = purchaseRequisitionDao.deletePurchaseRequisition(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}

	public int purchaseRequisitionDuplicate(String purReqNo) {

		int list1 = 0;
		try {
			list1 = purchaseRequisitionDao
					.purchaseRequisitionDuplicate(purReqNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	public int purchaseRquisitionEditDuplicate(String purReqNo, int id) {
		int list1 = 0;
		try {
			list1 = purchaseRequisitionDao.purchaseRquisitionEditDuplicate(
					purReqNo, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	public List<Object[]> basicSearchPurchaseReq(String label, String operator,
			String searchName) {
		try {
			list = purchaseRequisitionDao.basicSearchPurchaseReq(label,
					operator, searchName);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public String deletePuchseRequisitionLine(int kk){
		String msg = null;
		try {
			msg = purchaseRequisitionDao.deletePuchseRequisitionLine(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;

	}
	public List<Object[]> setPurchaseRequisitionAdvanceSearch(String name){
		try {
			list = purchaseRequisitionDao.getPurchaseRequisitionAdvance(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
		public List<Object[]> getPurchaseRequisitionAdvance(String columns,String opeator,String advanceSearchText) 
		{
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
			//System.out.println("String Value Kiran" +finalStringForSearch);
			List<Object[]> list=null;
			if(finalStringForSearch.length()>3)
			{
				
			 list = purchaseRequisitionDao.getPurchaseRequisitionAdvance(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
			
			}
			else
				if(finalStringForSearch.length()<3)
			{
			
				list = purchaseRequisitionDao.searchPurchaseReq();
				
			}
			return list;
		}
		
		@Override
		public List<Object[]> selectPlantIds(int orgId) {
			List<Object[]> list=null;
			try {
				list = purchaseRequisitionDao.selectPlantIds(orgId);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		@Override
		public List<Object[]> populateStorLocIds(int plantId) {
			List<Object[]> list=null;
			try {
				list = purchaseRequisitionDao.populateStorLocIds(plantId);

			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		
		@Override
		 public List<Object[]> getStepUser(){
			 List<Object[]> list=null;
				try {
					
					list = purchaseRequisitionDao.getStepUser();

				} catch (Exception e) {
					e.printStackTrace();
				}
				return list;
		 }

	}


