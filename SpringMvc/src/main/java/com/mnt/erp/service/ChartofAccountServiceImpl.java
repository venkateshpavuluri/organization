/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;



import com.mnt.erp.bean.ChartofAccount;
import com.mnt.erp.dao.ChartofAccountDao;


/**
 * @author kirangangone
 * 
 */
public class ChartofAccountServiceImpl implements ChartofAccountService {
	public ChartofAccountDao chartofAccountdao;
	boolean message = false;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;

	
     /**
	 * @return the chartofAccountdao
	 */
	public ChartofAccountDao getChartofAccountdao() {
		return chartofAccountdao;
	}


	/**
	 * @param chartofAccountdao the chartofAccountdao to set
	 */
	public void setChartofAccountdao(ChartofAccountDao chartofAccountdao) {
		this.chartofAccountdao = chartofAccountdao;
	}


	@Override
	public boolean saveChartofAccount(ChartofAccount chartofAccount,String userId,String userName) {
		// TODO Auto-generated method stub
		 message=chartofAccountdao.saveChartofAccount(chartofAccount,userId,userName);
		return message;
	}
	
	public int duplicateCheckChartofAccount(String chartofAccount, String Id) {
		int i = 0;
		try {
			i = chartofAccountdao.duplicateCheckChartofAccount(chartofAccount, Id);

		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
		return i;
	}
	
/*For ChartofAccount Group Id*/
	
	public List<Object[]> getChartofAccountOrgId(){
		// TODO Auto-generated method stub
				List<Object[]>  list=null;
				try
				{
					list=chartofAccountdao.getChartofAccountOrgId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	

	
	
	public List<Object[]> basicSearchChartofAccount(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		try {
			objs = chartofAccountdao.basicSearchChartofAccount(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}
	
	public List<Object> editChartofAccount(int cId) {
		try {
			obj = chartofAccountdao.editChartofAccount(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	@Override
	public boolean updateChartofAccount(ChartofAccount chartofAccount) {
		boolean flag=false;
		try {
			// System.out.println("Came to Service Of Purchase Update");
		flag = chartofAccountdao.updateChartofAccount(chartofAccount);
		} catch (Exception e) {
			e.printStackTrace();
			return flag;
		}
		return flag;
	}

	public boolean deleteChartofAccount(int id) {
		// TODO Auto-generated method stub
		boolean msg = false;
		try {
			msg = chartofAccountdao.deleteChartofAccount(id);
		} catch (Exception e) {
			//e.printStackTrace();
			return msg;
		}
		return msg;
	}
	
    

}
