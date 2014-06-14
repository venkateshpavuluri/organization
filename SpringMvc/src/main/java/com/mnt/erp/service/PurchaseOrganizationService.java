
/*
 * @Copyright MNTSOFT
 * 
 */

package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.OrgPlants;
import com.mnt.erp.bean.PurchaseOrganization;

/**
 * This is PurchaseOrganization Service Interface.
 * @Author parvathi
 * @Version 1.0
 * @Batch 0.0
 */

public interface PurchaseOrganizationService {
	
public String savePurchaseOrganization(Object object,String userId,String userName);

public List<OrgPlants> selectPlants(String orgId);

public List<Object[]> searchPurchaseOrganization();

public List<PurchaseOrganization> editPurchaseOrganization(int id);

public String updatePurchaseOrganization(Object object);

public String deletePurchaseOrganization(int id);

public int purchaseOrganizationDuplicate(String purOrg);

public int purchaseOrganizationEditDuplicate(String purOrg,int id);

public List<Object[]> basicSearchPurchaseOrganization(String label,String operator,String searchName);

public List<Object[]> selectPurchaseOrg();


}
