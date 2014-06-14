/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.dao.PayGradeSalElementDao;

/**
 * @author devi
 *
 */
public class PayGradeSalElementServiceImpl implements PayGradeSalElementService {
	PayGradeSalElementDao pgsDao;
	String brmessage;
	List<Object[]> objects;
	public PayGradeSalElementDao getPgsDao() {
		return pgsDao;
	}

	public void setPgsDao(PayGradeSalElementDao pgsDao) {
		this.pgsDao = pgsDao;
	}
@Override
	
	public String savePayGradeSalElement(Object object,String userId,String userName) {
		try{
			brmessage=pgsDao.savePayGradeSalElement(object, userId, userName);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return brmessage;
	}

	@Override
	public List<Object[]> selectPayGradeSalElementService() {
		try{
			objects=pgsDao.selectPayGradeSalElement();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}
	
	@Override
	public List<Object[]> searchPayGradeSalElementServiceWithId(int id) {
		try{
			
			objects=pgsDao.searchPayGradeSalElementWithId(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return objects;
	}

	@Override
	public List<Object[]> searchPayGradeSalElementService() {
		try{
			objects=pgsDao.searchPayGradeSalElement();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return objects;
	}

	@Override
	public String updatePayGradeSalElementService(Object updatebtservice) {
		try{
			brmessage=pgsDao.updatePayGradeSalElement(updatebtservice);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return brmessage;
	}

	@Override
	public String deletePayGradeSalElementService(int id) {
		try{
			brmessage=pgsDao.deletePayGradeSalElement(id);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return brmessage;
	}

	@Override
	public Long getPayGradeSalElementcount(String name) {
		Long iid=0l;
		try{
		 iid=pgsDao.getPayGradeSalElementCount(name);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	@Override
	public Long getPayGradeSalElementcountedit(String name, int pgsId) {
		Long iid=0l;
		try{
		 iid=pgsDao.getPayGradeSalElementCountedit(name, pgsId);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return iid;
	}

	@Override
	public List<Object[]> basicSearchPayGradeSalElement(String label, String operator,
			String searchName) {
		try {
			objects = pgsDao.basicSearchPayGradeSalElement(label, operator, searchName);
			} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}

	@Override
	public List<Object[]> selectPayGradeService() {
try{
			
			objects=pgsDao.getPayGradeIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

	@Override
	public List<Object[]> selectPayElementService() {
try{
			
			objects=pgsDao.getPayElementIds();
		}catch(Exception e){
			e.printStackTrace();
		}
		return objects;
	}

}
