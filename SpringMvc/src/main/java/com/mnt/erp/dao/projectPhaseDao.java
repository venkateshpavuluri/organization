package com.mnt.erp.dao;

import java.util.List;

public interface projectPhaseDao {
	public String saveProjectPhase(Object object,String userId,String userName);
	public long checkProjectPhase(String type);
	public List<Object[]> searchProjectPhase();
	public String deleteProjectPhase(int id);
	public List<Object[]> searchProjectPhaseWithId(int id);
	public List<Object[]> basicSearchProjectPhase(String label,String operator,String searchName);
	public String updateProjectPhase(Object object);
	public List<Object[]> selectProjectPhase();
	public long updateCheckProjectPhase(String type, int Id);
	public List<Object[]> getProjectIds();

}
