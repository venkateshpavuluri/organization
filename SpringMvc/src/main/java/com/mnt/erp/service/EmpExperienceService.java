/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.EmpExperience;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 *
 */
public interface EmpExperienceService  
{

	public String saveEmpExperience(EmpExperience empExperience);
	public int duplicateCheckEmpExperience(String empExperience,String designation_Id,String company,String id);
	public List<Object[]> getEmpExperienceId();
	public List<Object[]> basicSearchEmpExperience(String label, String operator,String searchName);
	public List<Object> editEmpExperience(int id);
	public String updateEmpExperience(EmpExperience empExperience);
	public String deleteEmpExperience(int id);

	
}
