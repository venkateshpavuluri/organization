package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.EvaluationCriteria;

public interface EvaluationCriteriaService {
	public String saveEvaluationCriteria(Object object,String userId,String userName);

	public List<Object[]> searchEvaluationCriteria(int id);

	public List<EvaluationCriteria> editEvaluationCriteriaWithId(int id);

	public String updateEvaluationCriteria(Object object);

	public String EvaluationCriteriaDelete(int id);

	public int EvaluationCriteriaDuplicate(String EvaluationCriteria);

	public int EvaluationCriteriaEditDuplicate(String EvaluationCriteria,int id);
	
	public String deleteEvaluationCriteriaDetail(int kk);

	public List<Object[]> basicSearchEvaluationCriteria(String label,String operator,String searchName);
}
