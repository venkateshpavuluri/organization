
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;

/**
 * This is AgreementTypeService interface.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public interface AgreementTypeService {
	
	public String saveAgreementType(Object object,String userId,String userName);
	
	public List<Object[]> searchAgreementType(int id);
	
	public List<Object[]> editAgreementTypeWithId(int id);
	
	public String updateAgreementType(Object object);
	
	public String agreementTypeDelete(int id);
	
	public int agreementTypeDuplicate(String agreementType);
	
	public int agreementTypeEditDuplicate(String agreementType,int id);
	
	public List<Object[]> basicSearchAgreementType(String label,String operator,String searchName);
}
