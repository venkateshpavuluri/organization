/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.EmpExperience;
import com.mnt.erp.dao.EmpExperienceDao;


/**
 * @author kirangangone
 * 
 */
public class EmpExperienceServiceImpl implements EmpExperienceService {
	public EmpExperienceDao empExperiencedao;
	String message = null;
	List<Object[]> objects = null;
	List<Object> obj = null;
	Long l = 0l;

	
     /**
	 * @return the empExperiencedao
	 */
	public EmpExperienceDao getEmpExperiencedao() {
		return empExperiencedao;
	}


	/**
	 * @param empExperiencedao the empExperiencedao to set
	 */
	public void setEmpExperiencedao(EmpExperienceDao empExperiencedao) {
		this.empExperiencedao = empExperiencedao;
	}


	@Override
	public String saveEmpExperience(EmpExperience empExperience) {
		 message=empExperiencedao.saveEmpExperience(empExperience);
		return message;
	}
	
	public int duplicateCheckEmpExperience(String empExperience,String designation_Id,String company, String Id) {
		int i = 0;
		try {
			i = empExperiencedao.duplicateCheckEmpExperience(empExperience,designation_Id,company, Id);

		} catch (Exception e) {
			e.printStackTrace();
			return i;
		}
		return i;
	}
	
/*For EmpExperience Group Id*/
	
	public List<Object[]> getEmpExperienceId(){
	
				List<Object[]>  list=null;
				try
				{
					list=empExperiencedao.getEmpExperienceId();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				return list;
	}
	

	
	
	public List<Object[]> basicSearchEmpExperience(String label, String operator,String searchName) {
		List<Object[]> objs = null;
		try {
			objs = empExperiencedao.basicSearchEmpExperience(label, operator, searchName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objs;

	}
	
	public List<Object> editEmpExperience(int cId) {
		try {
			obj = empExperiencedao.editEmpExperience(cId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	@Override
	public String updateEmpExperience(EmpExperience empExperience) {

		try {
			
			message = empExperiencedao.updateEmpExperience(empExperience);
		}
		catch (Exception e) {
			e.printStackTrace();
		
		}
		return message;
	}

	public String deleteEmpExperience(int id) {
		
		try {
			message = empExperiencedao.deleteEmpExperience(id);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return message;
	}
	
    

}
