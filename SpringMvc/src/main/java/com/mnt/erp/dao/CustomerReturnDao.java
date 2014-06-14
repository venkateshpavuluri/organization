package com.mnt.erp.dao;

import java.util.List;

public interface CustomerReturnDao {

	public List<Object[]> selectSalesOrders();
	
	public List<Object[]> selectMaterialIds();
	
	public List<Object[]> selectReasonForRejection();
	
	public String saveCustomerReturn(Object object,String userId,String userName);
	
	public List<Object[]> basicSearchCustomerReturn(String label, String operator,
				String searchName);
    public List<Object[]> searchCustomerReturn();
    
    public List<Object> editCustomerReturnWithId(int id);

    public String updateCustomerReturn(Object object);
		
	public String deleteCustomerReturn(int id);
	
   public int customerReturnDuplicate(String CRNo);
    
    public int customerReturnEditDuplicate(String CRNo,int id);
    
    public String deleteCustomerReturnLine(int kk);
    
    public List<Object[]> getCustomerReturnAdvance(String name);
    public String getQuantity(int mid,int sid);
}
