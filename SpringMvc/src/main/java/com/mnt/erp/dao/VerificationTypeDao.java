package com.mnt.erp.dao;

import java.util.List;

public interface VerificationTypeDao {
	public String saveVerificationType(Object object,String userId,String userName);
	public Long getVerificationTypeCount(String name);
	public List<Object[]> searchVerificationtypeWithId(int id);
	public List<Object[]> searchVerificationType();
	public List<Object[]> selectVerificationTypeIds();
	public String updateVerificationType(Object object);
	public String deleteVerificationType(int id);
	public Long getVerificationTypeCountedit(String name,int verificationtypeid);
	public List<Object[]> basicSearchVerificationType(String label,String operator,String searchName);
}
