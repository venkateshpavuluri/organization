package com.mnt.erp.service;

import java.util.List;

public interface VerificationTypeService {
		public String saveVerificationTypeservice(Object object,String userId,String userName);
		public Long getVerificationTypeCount(String name);
		public List<Object[]> searchVerificationType();
		public List<Object[]> selectVerificationType();
		public String updateVerificationType(Object object);
		public String deleteVerificationType(int id);
		public List<Object[]> searchVerificationTypeWithId(int id);
		public Long getVerificationTypeCountedit(String name,int verificationtypeid);
		
		public List<Object[]> basicSearchVerificationType(String label,String operator,String searchName);
}
