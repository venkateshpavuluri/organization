/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.PurchaseOrderDao;

/**
 * @author kiran
 * 
 */
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	public PurchaseOrderDao podao;
	String message = null;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;

	@Override
	public String addPurchaseOrder(Object object) {
		// TODO Auto-generated method stub
		message = podao.addPurchaseOrder(object);
		return message;
	}

	public PurchaseOrderDao getPodao() {
		return podao;
	}

	public void setPodao(PurchaseOrderDao podao) {
		this.podao = podao;
	}

	public List<Object[]> basicSearchPO() {
		try {
			objects = podao.basicSearchPO();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objects;
	}

	public List<Object> editPOWithId(int cId) {
		try {
			obj = podao.editPOWithId(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public List<Object[]> basicSearchPurchase(String label, String operator,
			String searchName) {
		List<Object[]> objs = null;
		try {
			objs = podao.basicSearchPurchase(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}

	public List<Object[]> getPurchaseAdvance(String columns, String opeator,
			String advanceSearchText) {
		String column[] = columns.split(",");
		String op[] = opeator.split(",");
		String advanceSearch[] = advanceSearchText.split(",");
		String finalStringForSearch = "";

		for (int i = 0; i < advanceSearch.length; i++) {
			if (!op[i].equals("0") && advanceSearch[i] != "") {
				if (op[i].equals("_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = advanceSearch[i] + "%";

				} else if (op[i].equals("%_")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = "%" + advanceSearch[i];

				} else if (op[i].equals("%_%")) {
					column[i] = column[i];
					op[i] = " like ";
					advanceSearch[i] = "%" + advanceSearch[i] + "%";

				} else if (op[i].equals("=")) {
					column[i] = column[i];
					op[i] = " = ";
					advanceSearch[i] = advanceSearch[i];

				} else if (op[i].equals("!=")) {
					column[i] = column[i];
					op[i] = " != ";
					advanceSearch[i] = advanceSearch[i];

				}
				if (!op[i].equals("0") && advanceSearch[i] != "") {
					finalStringForSearch = finalStringForSearch + "  po."
							+ column[i] + " " + op[i] + " '" + advanceSearch[i]
							+ "' " + "AND";
				}
			}

		}
		// System.out.println("String Value Kiran" +finalStringForSearch);
		List<Object[]> list = null;
		if (finalStringForSearch.length() > 3) {
			list = podao.setPurchaseAdvanceSearch(finalStringForSearch
					.substring(0, finalStringForSearch.length() - 3));
		} else {
			list = podao.basicSearchPO();
		}
		return list;
	}

	@Override
	public String updatePurchaseOrder(Object object) {
		try {
			// System.out.println("Came to Service Of Purchase Update");
			message = podao.updatePurchaseOrderDao(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	public int updateCheckPurchase(String pno, int custId) {
		int i = 0;
		try {
			i = podao.updateCheckPurchase(pno, custId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public Long checkPurchase(String pno) {
		try {
			l = podao.checkPurchase(pno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	public String deletePurchaseOrderLine(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = podao.deletePurchaseOrderLine(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	public String deletePurchaseOrder(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = podao.deletePurchaseOrder(id);
		} catch (Exception e) {
			e.printStackTrace();
			return msg;
		}
		return msg;
	}
	public List<Object[]> purchaseOrderNumGet(String s) {
		// TODO Auto-generated method stub
		List<Object[]> mId = podao.purchaseOrderNumGet(s);
		return mId;
	}
	
	public List<Object[]> getStepUser(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=podao.getStepUser();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	
	
	
	@Override
	public String saveWorkFlowListDaoDetails(Object object){
		
		String list=null;
		try
		{
			list=podao.saveWorkFlowListDaoDetails(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return list;
		}
		

}
