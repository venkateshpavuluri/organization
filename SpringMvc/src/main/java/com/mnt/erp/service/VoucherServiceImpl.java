/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;




import com.mnt.erp.bean.Voucher;
import com.mnt.erp.dao.VoucherDao;


/**
 * @author kirangangone
 * 
 */
public class VoucherServiceImpl implements VoucherService {
	public VoucherDao voucherdao;
	boolean message = false;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;

	
     /**
	 * @return the voucherdao
	 */
	public VoucherDao getVoucherdao() {
		return voucherdao;
	}


	/**
	 * @param voucherdao the voucherdao to set
	 */
	public void setVoucherdao(VoucherDao voucherdao) {
		this.voucherdao = voucherdao;
	}


	@Override
	public boolean saveVoucher(Voucher voucher) {
		// TODO Auto-generated method stub
		 message=voucherdao.saveVoucher(voucher);
		return message;
	}
	
	public int duplicateCheckVoucher(String voucher, String Id) {
		int i = 0;
		try {
			i = voucherdao.duplicateCheckVoucher(voucher, Id);

		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
		return i;
	}
	
/*For Voucher Group Id*/
	
	public List<Object[]> getVoucherEmployeeId(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=voucherdao.getVoucherEmployeeId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	

	
	
	public List<Object[]> basicSearchVoucher(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		try {
			objs = voucherdao.basicSearchVoucher(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}
	
	public List<Object> editVoucher(int cId) {
		try {
			obj = voucherdao.editVoucher(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	@Override
	public boolean updateVoucher(Voucher voucher) {
		boolean flag=false;
		try {
			// System.out.println("Came to Service Of Purchase Update");
		flag = voucherdao.updateVoucher(voucher);
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	public boolean deleteVoucher(int id) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			msg = voucherdao.deleteVoucher(id);
		} catch (Exception e) {
			//e.printStackTrace();
			return msg;
		}
		return msg;
	}
	
	public List<Object[]> getStepUser(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=voucherdao.getStepUser();
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
			list=voucherdao.saveWorkFlowListDaoDetails(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return list;
		}
		
	
    

}
