/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;



import com.mnt.erp.bean.EmployeeLeave;
import com.mnt.erp.dao.EmployeeLeaveDao;


/**
 * @author kirangangone
 * 
 */
public class EmployeeLeaveServiceImpl implements EmployeeLeaveService {
	public EmployeeLeaveDao employeeLeavedao;
	boolean message = false;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;

	
     /**
	 * @return the employeeLeavedao
	 */
	public EmployeeLeaveDao getEmployeeLeavedao() {
		return employeeLeavedao;
	}


	/**
	 * @param employeeLeavedao the employeeLeavedao to set
	 */
	public void setEmployeeLeavedao(EmployeeLeaveDao employeeLeavedao) {
		this.employeeLeavedao = employeeLeavedao;
	}


	@Override
	public boolean saveEmployeeLeave(EmployeeLeave employeeLeave) {
		// TODO Auto-generated method stub
		 message=employeeLeavedao.saveEmployeeLeave(employeeLeave);
		return message;
	}
	
	public int duplicateCheckEmployeeLeave(String employeeLeave, String Id) {
		int i = 0;
		try {
			i = employeeLeavedao.duplicateCheckEmployeeLeave(employeeLeave, Id);

		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
		return i;
	}
	
/*For EmployeeLeave Group Id*/
	
	public List<Object[]> getAllSelectId(String type){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=employeeLeavedao.getAllSelectId(type);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	

	
	
	public List<Object[]> basicSearchEmployeeLeave(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		try {
			objs = employeeLeavedao.basicSearchEmployeeLeave(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}
	
	public List<Object> editEmployeeLeave(int cId) {
		try {
			obj = employeeLeavedao.editEmployeeLeave(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	@Override
	public boolean updateEmployeeLeave(EmployeeLeave employeeLeave) {
		boolean flag=false;
		try {
			
		flag = employeeLeavedao.updateEmployeeLeave(employeeLeave);
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	public boolean deleteEmployeeLeave(int id) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			msg = employeeLeavedao.deleteEmployeeLeave(id);
		} catch (Exception e) {
			//e.printStackTrace();
			return msg;
		}
		return msg;
	}
	
  

}
