package com.mnt.erp.service;

import java.util.List;

import com.mnt.erp.bean.GoodsReceipt;

public interface GoodsReceiptService {
	public List<Object> getGoodsAdvance(String columns,String opeator,String advanceSearchText);
	public List<Object> getGoods(String goods);

	public String saveGoodsReceipt(Object object,String userId,String userName);
	
	public List<GoodsReceipt> searchGoodsReceipt();
	
	public String deleteGoodsReceipt(int id);
	
	public List<Object> editGoodsReceipWithId(int prid);
	
	public String updateGoodsReceipt(Object object);
	
	public int goodsReceiptDuplicate(String receivingID);
	
	public int goodsReceiptEditDuplicate(String receivingId,int id);
	
	public List<GoodsReceipt> basicSearchGoodsReceipt(String label, String operator,
			String searchName);
	
	public List<Object> purchaseOrderMaterialGet(String poNum,int materilId);
	public List<Object> goodsReceiptLineMaterialQtyGet(String poNum,int materilId);
	public String deleteGoodsReceiptLine(int kk);
	
	
	
}
