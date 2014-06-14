/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Voucher;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 *
 */
public interface VoucherService  
{

	public boolean saveVoucher(Voucher voucher);
	public int duplicateCheckVoucher(String voucher,String id);
	public List<Object[]> getVoucherEmployeeId();
	public List<Object[]> basicSearchVoucher(String label, String operator,String searchName);
	public List<Object> editVoucher(int id);
	public boolean updateVoucher(Voucher voucher);
	public boolean deleteVoucher(int id);
	public String saveWorkFlowListDaoDetails(Object object);
	public List<Object[]> getStepUser();

	
}
