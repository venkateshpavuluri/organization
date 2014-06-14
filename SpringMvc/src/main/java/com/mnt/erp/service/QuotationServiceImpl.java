/**
 * 
 */
package com.mnt.erp.service;

import java.io.Serializable;
import java.util.List;

import com.mnt.erp.dao.QuotationDao;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 * 
 */

public class QuotationServiceImpl implements QuotationService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public QuotationDao qtdao;
	List<Object[]> list = null;
	String message;

	/* =======================Add Method============================ */
	@Override
	public String addQuotation(Object object) {
		// TODO Auto-generated method stub
		message = qtdao.addQuotation(object);
		return message;
	}

	/*
	 * =======================Setter and Getters for
	 * Dao============================
	 */
	public QuotationDao getQtdao() {
		return qtdao;
	}

	public void setQtdao(QuotationDao qtdao) {
		this.qtdao = qtdao;
	}

	/* =======================Search(all) Method============================ */
	@Override
	public List<Object[]> searchQuotation() {
		// TODO Auto-generated method stub
		// List<Object[]> list=null;
		try {

			list = qtdao.searchQuotation();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	/* =======================Search(With id) Method============================ */
	@Override
	public List<Object[]> searchQuotationWithId(int id) {
		// TODO Auto-generated method stub

		try {
			list = qtdao.searchQuotationWithId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/* =======================Update Method============================ */
	@Override
	public String updateQuotation(Object object) {
		// TODO Auto-generated method stub

		try {
			message = qtdao.updateQuotation(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}

	/* =======================Edit Method============================ */
	@Override
	public List<Object> editQuotationWithId(int qid) {
		// TODO Auto-generated method stub
		List<Object> list = null;
		try {
			list = qtdao.editQuotationWithId(qid);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	/* =======================Delete Method============================ */
	@Override
	public String deleteQuotation(int id) {
		// TODO Auto-generated method stub
		try {
			message = qtdao.deleteQuotation(id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;

	}

	/*
	 * =======================Add Duplicate Checking
	 * Method============================
	 */
	@Override
	public int checkDuplicate(String checkQuotNo) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = qtdao.checkDuplicate(checkQuotNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}

	/*
	 * =======================Edit Duplicate Checking
	 * Method============================
	 */
	@Override
	public int checkEditDuplicate(String checkQuotNo, int id) {
		// TODO Auto-generated method stub
		int list1 = 0;
		try {
			list1 = qtdao.checkEditDuplicate(checkQuotNo, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list1;
	}
/*=====================To Get RFQ NO Values=========================*/
	@Override
	public List<Object[]> rfqIdGet() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = qtdao.rfqIdGet();
		return idsList;
	}
	/*
	 * =======================TO get quotaion id
	 * Values============================
	 */
	@Override
	public List<Object[]> quotationIdGet() {
		// TODO Auto-generated method stub
		List<Object[]> idsList = qtdao.quotationIdGet();
		return idsList;
	}
/*============================Basic Search========================================*/
	public List<Object[]> basicSearchQuotation(String label, String operator,
			String searchName) {
		try {
			list = qtdao.basicSearchQuotation(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public String deleteQuotationLine(int qLineId) {
		// TODO Auto-generated method stub
		try {
			message = qtdao.deleteQuotationLine(qLineId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
	@Override
	public List<Object[]> getQuotationAdvance(String columns, String opeator,
			String advanceSearchText) {
		// TODO Auto-generated method stub
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
			finalStringForSearch=finalStringForSearch+"  q."+column[i]+" "+op[i]+" '"+advanceSearch[i] +"' " +"AND";
			}
			}
		
		}
		
		List<Object[]> list=null;
		if(finalStringForSearch.length()>3)
		{
		 list = qtdao.quotationAdvanceSearch(finalStringForSearch.substring(0, finalStringForSearch.length()-3));
		}
		else
		{
			list = qtdao.quotationAdvanceSearch("ALL");
		}
		return list;
	}
	public List<Object[]> getQuotation(String quotation) {
		List<Object[]> list = qtdao.setQuotationSearch(quotation);
		return list;
	}


}
