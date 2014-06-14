/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;



import com.mnt.erp.bean.Code;
import com.mnt.erp.dao.CodeDao;


/**
 * @author kirangangone
 * 
 */
public class CodeServiceImpl implements CodeService {
	public CodeDao codedao;
	String msg = null;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;

	
     /**
	 * @return the codedao
	 */
	public CodeDao getCodedao() {
		return codedao;
	}


	/**
	 * @param codedao the codedao to set
	 */
	public void setCodedao(CodeDao codedao) {
		this.codedao = codedao;
	}


	@Override
	public String saveCode(Code code,String userId,String userName) {
		// TODO Auto-generated method stub
		 msg=codedao.saveCode(code, userId, userName);
		 return msg;
	}
	
	public Long duplicateCheckCode(String code, String codeGroupId) {
		Long i = null;
		try {
			i = codedao.duplicateCheckCode(code, codeGroupId);

		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
		return i;
	}
	
	public Long duplicateCheckCodeUpdate(String code,String codeGroupId,int id){
		Long i = null;
		try {
			i = codedao.duplicateCheckCodeUpdate(code, codeGroupId,id);

		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
		return i;
	}
	
/*For Code Group Id*/
	
	public List<Object[]> getCodeGroupId(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=codedao.getCodeGroupId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	

	
	
	public List<Object[]> basicSearchCode(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		try {
			objs = codedao.basicSearchCode(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}
	
	public List<Object> editCode(int cId) {
		try {
			obj = codedao.editCode(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	@Override
	public String updateCode(Code code) {
		boolean flag=false;
		try {
			// System.out.println("Came to Service Of Purchase Update");
		msg = codedao.updateCode(code);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		return msg;
	}

	public String deleteCode(int id) {
		// TODO Auto-generated method stub
		
		try {
			msg = codedao.deleteCode(id);
		} catch (Exception e) {
		e.printStackTrace();
			
		}
		return msg;
	}
	
    /* 
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
 	public List<Object[]> basicSearchCode(String label, String operator,
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

	
	
	
	
	
	For Customer Invoice No

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
	
	For Vendor Invoice No
	
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
	
	For Checking CreditNote Duplicates
	
	public Long checkCreditNote(String pno) {
		try {
			l = CreditNotedao.checkCreditNote(pno);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}
	
	*/
	
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
