/**
 * 
 */
package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.Code;

/**
 * @author kirangangone
 * @version 1.0
 * @build 0.0
 *
 */
public interface CodeService  
{

	public String saveCode(Code code,String userId,String userName);
	public Long duplicateCheckCode(String code,String codeGroupId);
	public Long duplicateCheckCodeUpdate(String code,String codeGroupId,int id);
	public List<Object[]> getCodeGroupId();
	public List<Object[]> basicSearchCode(String label, String operator,String searchName);
	public List<Object> editCode(int id);
	public String updateCode(Code code);
	public String deleteCode(int id);


}
