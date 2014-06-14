package com.mnt.erp.service;

import java.util.List;

public interface projectPhaseService {
	public String saveProjectPhase(Object object,String userId,String userName);
	public long checkProjectPhase(String type);
	public List<Object[]> searchProjectPhase();
	public List<Object[]> searchProjectPhaseWithId(int id);
	public List<Object[]> basicSearchProjectPhase(String label,String operator,String searchName);
	public String deleteProjectPhase(int id);
	public String updateProjectPhase(Object object);
	public List<Object[]> selectProjectPhase();
	public long updateCheckProjectPhase(String type, int Id);
	public List<Object[]>selectProjectService();

}
