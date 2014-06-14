package com.mnt.erp.dao;

import java.util.List;

public interface GoodsReceiptTypeDao {
	public String saveGoodsReceiptTypeDetails(Object object,String userId,String userName);

	public List<Object[]> searchGoodsReceiptType();

	public List<Object[]> searchGoodsReceiptTypeWithId(int id);

	public String updateGoodsReceiptType(Object object);

	public String deleteGoodsReceiptType(int id);

	public List<Object[]> selectGoodsReceiptType();

	public int checkGoodsReceiptType(String type);

	public int updateCheckGoodsReceiptType(String type, int gdtId);
	public List<Object[]> basicSearchGoodsReceipt(String label, String operator,
			String searchName);
	public List<Object[]> goodsReceiptIdsGet();
	
	

}
