/**
 * 
 */
package com.mnt.erp.dao;

import java.util.List;

/**
 * @author Sailaja
 * @version 1.0
 * @build 0.0
 *
 */
public interface QuotationDao
{
    public List<Object[]> quotationAdvanceSearch(String name);
	
	public List<Object[]> setQuotationSearch(String name);
	
	public String addQuotation(Object object);
	public List<Object[]> searchQuotation();
	public List<Object[]> searchQuotationWithId(int id);
	public List<Object> editQuotationWithId(int qid);
	public String updateQuotation(Object object);
    public String deleteQuotation(int id);
    public String deleteQuotationLine(int qLineId);
    public int checkDuplicate(String checkQuotNo);	
    public int checkEditDuplicate(String checkQuotNo,int id);
    public List<Object[]> quotationIdGet();
    public List<Object[]> rfqIdGet();
    public List<Object[]> basicSearchQuotation(String label,String operator,String searchName);
 
 
}
