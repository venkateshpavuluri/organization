package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.AssetBean;

public interface AssetService {
	public String saveAsset(Object object);
	public List<Object[]>selectAssetTypeid();
	public List<Object[]>selectAssetGroupId();
	public List<Object[]>selectEmpId();
	public List<Object[]>searchAsset();
	public List<AssetBean>EditAsset(int iid);
	public String updateAsset(Object object);
	public String deleteAsset(int id);
	public String deleteChildDetails(int cid);
	public List<Object[]> basicSearchAsset(String label,String operator,String searchName);
	public List<Object[]> setAssetAdvanceSearch(String name);
	public List<Object[]> setAssetSearch(String name);
	public List<Object[]> setAgreementAdvanceSearch(String columns, String opeator,
			String advanceSearchText);
}
