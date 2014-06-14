/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.CreditNoteDao;


/**
 * @author kirangangone
 * 
 */
public class CreditNoteServiceImpl implements CreditNoteService {
	public CreditNoteDao CreditNotedao;
	String message = null;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;

	public CreditNoteDao getCreditNotedao() {
		return CreditNotedao;
	}

	public void setCreditNotedao(CreditNoteDao creditNotedao) {
		CreditNotedao = creditNotedao;
	}
	
     @Override
	public String addCreditNote(Object object) {
		// TODO Auto-generated method stub
		message = CreditNotedao.addCreditNote(object);
		return message;
	}

     
     public List<Object[]> basicSearchCreditNote() {
 		try {
 			objects = CreditNotedao.basicSearchCreditNote();

 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return objects;
 	}

 	public List<Object[]> getCreditNoteAdvance(String columns, String opeator,
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
 					finalStringForSearch = finalStringForSearch + "  c."
 							+ column[i] + " " + op[i] + " '" + advanceSearch[i]
 							+ "' " + "AND";
 				}
 			}

 		}
 		// System.out.println("String Value Kiran" +finalStringForSearch);
 		List<Object[]> list = null;
 		if (finalStringForSearch.length() > 3) {
 			list = CreditNotedao.setCreditNoteAdvanceSearch(finalStringForSearch
 					.substring(0, finalStringForSearch.length() - 3));
 		} else {
 			list = CreditNotedao.basicSearchCreditNote();
 		}
 		return list;
 	}
 	public List<Object[]> basicSearchCredit(String label, String operator,
			String searchName) {
		List<Object[]> objs = null;
		try {
			objs = CreditNotedao.basicSearchCredit(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}
	
 	public List<Object> editCreditNoteWithId(int cId) {
		try {
			obj = CreditNotedao.editCreditNoteWithId(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
 	
 	public String deleteCreditNoteDetailList(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = CreditNotedao.deleteCreditNoteDetailList(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
 	
 	@Override
	public String updateCreditNote(Object object) {
		try {
			// System.out.println("Came to Service Of Purchase Update");
			message = CreditNotedao.updateCreditNote(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	public int updateCheckCredit(String pno, int custId) {
		int i = 0;
		try {
			i = CreditNotedao.updateCheckCredit(pno, custId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public String deleteCreditNote(int id) {
		// TODO Auto-generated method stub
		String msg = null;
		try {
			msg = CreditNotedao.deleteCreditNote(id);
		} catch (Exception e) {
			//e.printStackTrace();
			return msg;
		}
		return msg;
	}
	
	/*
	public PurchaseOrderCreditNotedao getCreditNotedao() {
		return CreditNotedao;
	}

	public void setCreditNotedao(PurchaseOrderCreditNotedao CreditNotedao) {
		this.CreditNotedao = CreditNotedao;
	}

	

	

	
	


	public Long checkPurchase(String pno) {
		try {
			l = CreditNotedao.checkPurchase(pno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	
	
	public List<Object[]> purchaseOrderNumGet(String s) {
		// TODO Auto-generated method stub
		List<Object[]> mId = CreditNotedao.purchaseOrderNumGet(s);
		return mId;
	}
	
	public List<Object[]> getStepUser(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=CreditNotedao.getStepUser();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}*/
	
	
	/*For Customer Invoice No*/

	public List<Object[]> getCustomerInvoiceId(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=CreditNotedao.getCustomerInvoiceId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	
	/*For Vendor Invoice No*/
	
	public List<Object[]> getVendorInvoiceId(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=CreditNotedao.getVendorInvoiceId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	
	/*For Checking CreditNote Duplicates*/
	
	public Long checkCreditNote(String pno) {
		try {
			l = CreditNotedao.checkCreditNote(pno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}
	
	
	
	/*@Override
	public String saveWorkFlowListCreditNotedaoDetails(Object object){
		
		String list=null;
		try
		{
			list=CreditNotedao.saveWorkFlowListCreditNotedaoDetails(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return list;
		}
		*/

}
