package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.EvaluationCriteria;
import com.mnt.erp.dao.EvaluationCriteriaDao;

public class EvaluationCriteriaServiceImpl implements EvaluationCriteriaService{
	public EvaluationCriteriaDao evaluationCriteriaDao;
	public String msg;
	List<Object[]> objects;


	
	public EvaluationCriteriaDao getEvaluationCriteriaDao() {
		return evaluationCriteriaDao;
	}
	public void setEvaluationCriteriaDao(EvaluationCriteriaDao evaluationCriteriaDao) {
		this.evaluationCriteriaDao = evaluationCriteriaDao;
	}
	public String saveEvaluationCriteria(Object object,String userId,String userName){
     try{
		   msg=evaluationCriteriaDao.saveEvaluationCriteria(object,userId,userName);
	    }
	 catch(Exception e){
			e.printStackTrace();
		}
	 return msg;

}
	public List<Object[]> searchEvaluationCriteria(int id){
		// TODO Auto-generated method stub
		List<Object[]> list=null;
		try
		{
		   list=evaluationCriteriaDao.searchEvaluationCriteria(id);
						
		 }
		catch(Exception e)
		{
		   e.printStackTrace();
		}
		return list;
	}
	
	public List<EvaluationCriteria> editEvaluationCriteriaWithId(int id){
		List<EvaluationCriteria> list=null;
		try
		{
			list=evaluationCriteriaDao.editEvaluationCriteriaWithId(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
	
	
	@Override
	public String updateEvaluationCriteria(Object object) {
		try
		{
	       msg=evaluationCriteriaDao.updateEvaluationCriteria(object);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public String EvaluationCriteriaDelete(int id) {
		// TODO Auto-generated method stub
		String msg=null;
		try
		{
			msg=evaluationCriteriaDao.EvaluationCriteriaDelete(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return msg;
	}
	public int EvaluationCriteriaDuplicate(String EvaluationCriteria){
		// TODO Auto-generated method stub
		int list1=0;
		try
		{
			list1=evaluationCriteriaDao.EvaluationCriteriaDuplicate(EvaluationCriteria);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	public int EvaluationCriteriaEditDuplicate(String EvaluationCriteria,int id){
		int list1=0;
		try
		{
			list1=evaluationCriteriaDao.EvaluationCriteriaEditDuplicate(EvaluationCriteria, id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list1;
	}
	@Override
	public List<Object[]> basicSearchEvaluationCriteria(String label,
			String operator, String searchName) {
		try {
			objects = evaluationCriteriaDao.basicSearchEvaluationCriteria(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return objects;
	}
	public String deleteEvaluationCriteriaDetail(int kk){
		String msg = null;
		try {
			msg = evaluationCriteriaDao.deleteEvaluationCriteriaDetail(kk);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	
}
