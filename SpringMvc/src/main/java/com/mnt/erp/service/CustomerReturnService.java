package com.mnt.erp.service;

import java.util.List;

public interface CustomerReturnService {
	
	public List<Object[]> selectSalesOrders();
	
	public List<Object[]> selectMaterialIds();
	
	public List<Object[]> selectReasonForRejection();
	
	public String saveCustomerReturn(Object object,String userId,String userName);
	
	public List<Object[]> basicSearchCustomerReturn(String label, String operator,
			String searchName);
	public List<Object[]> searchCustomerReturn();
	
	public String deleteCustomerReturn(int id);
	
    public List<Object> editCustomerReturnWithId(int id);

    public String updateCustomerReturn(Object object);
public int customerReturnDuplicate(String CRNo);
    
    public int customerReturnEditDuplicate(String CRNo,int id);
    
    public String deleteCustomerReturnLine(int kk);
    
    public List<Object[]> getCustomerReturnAdvance(String name);
    
    public List<Object[]> getCustRetrunAdvance(String columns,String opeator,String advanceSearchText);
    
    public String getQuantityCount(int mid,int sid);
    
    
}
